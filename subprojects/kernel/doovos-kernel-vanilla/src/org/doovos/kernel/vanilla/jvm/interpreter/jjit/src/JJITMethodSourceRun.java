/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src;

import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITConverter;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITOptimizer;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITDebug;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowIterator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author vpc
 */
public final class JJITMethodSourceRun extends JJITMethodSource {

    private Map<Integer, IOLocalInfo> localInfos = new HashMap<Integer, IOLocalInfo>();
    private Map<String, IOFieldInfo> fieldInfos = new HashMap<String, IOFieldInfo>();
    private Stack<JJITName> codeStack = new Stack<JJITName>();
    private HashMap<JJITName, JJITExpression> codeMap = new HashMap<JJITName, JJITExpression>();
    private int minIndex;
    private int maxIndex;
    private JJITFlowControlNode currentNode;
    private HashMap<String, JJITDecVar> defaultVars = new HashMap<String, JJITDecVar>();

    public JJITMethodSourceRun(JJITClassSource parentClass) {
        super(parentClass);
        parentClass.defineImport(Types.KFRAME);
        parentClass.defineImport(Types.JJITINSTRUCTION);
        addDefaultVar(new JJITDecVar(Types.JJITINSTRUCTION, "nextInstr", null));
        addDefaultVar(new JJITDecVar(Types.BOOLEAN, "ignorable", JJITConstant.FALSE));
        addDefaultVar(new JJITDecVar(Types.KREFERENCE, "refval", null));
        addDefaultVar(new JJITDecVar(Types.KREFERENCE, "ref", null));
        addDefaultVar(new JJITDecVar(Types.KREFERENCE, "ref2", null));
        addDefaultVar(new JJITDecVar(Types.KREGISTER, "reg", null));
        addDefaultVar(new JJITDecVar(Types.KREGISTER, "reg2", null));
        addDefaultVar(new JJITDecVar(Types.KFRAME, "callerFrame", JJITConstant.NULL));
        addDefaultVar(new JJITDecVar(Types.KFRAME, "nextFrame", JJITConstant.NULL));
        addDefaultVar(new JJITDecVar(Types.KREGISTER_ARR, "regs", JJITConstant.NULL));
        addDefaultVar(new JJITDecVar(Types.INT, "index", JJITConstant.I0));
        addDefaultVar(new JJITDecVar(Types.INT, "index2", JJITConstant.I0));
        addDefaultVar(new JJITDecVar(Types.BOOLEAN, "jump", null));
        addDefaultVar(new JJITDecVar(Types.KCLASS, "kclass", JJITConstant.NULL));

        addDefaultVar(new JJITDecVar(Types.KPROCESS, "process", frame().call(Calls.KFrame_getProcess)));
        addDefaultVar(new JJITDecVar(Types.KTHREADLOCAL, "thread", frame().call(Calls.KFrame_getThread)));
        addDefaultVar(new JJITDecVar(Types.KMEMORYSEGMENT, "memseg", frame().call(Calls.KFrame_getMemorySegment)));
        addDefaultVar(new JJITDecVar(Types.KMEMORYMANAGER, "memman", frame().call(Calls.KFrame_getMemoryManager)));
        addDefaultVar(new JJITDecVar(Types.KCLASSREPOSITORY, "repo", frame().call(Calls.KFrame_getClassRepository)));

    }

    public void init() {
        JJITFlowControlNode[] nodes2 = getParentClass().getInstructions();
        minIndex = nodes2[0].getIndex();
        maxIndex = nodes2[nodes2.length - 1].getIndex();
        boolean sharedMode = getParentClass().isSharedMode();


        if (getDebug().isOptLocal()) {
            JJITFlowControlNode[] instructions = getParentClass().getInstructions();
            for (JJITFlowControlNode n : instructions) {
                JJITInstructionDef ii = n.getInstruction();
                if (!sharedMode) {
                    int r = ii.getReadLocal();
                    if (r >= 0) {
                        getIOLocalInfo(r).doRead();
                    }
                    int w = ii.getWriteLocal();
                    if (w >= 0) {
                        getIOLocalInfo(w).doWrite();
                    }
                }
            }
            for (IOLocalInfo li : localInfos.values()) {
//                boolean r = li.reads > 1;
//                boolean w = li.writes > 1;
//                li.cacheReads = r || w;
//                li.cacheWrites = r || w;
                li.cache = !sharedMode && (li.reads + li.writes > 1);
//                li.cacheWrites = w;
            }
            if (getDebug().isOptLocal()) {
                for (IOLocalInfo ii : localInfos.values()) {
                    lineComment(ii.name + " " + ii.index + " ; r=" + ii.reads + "/w=" + ii.writes + " : " + (ii.cache ? "Cached" : "NotCached"));
                    if (ii.cache) {
                        if (ii.readFirst) {
                            JJITExpressionImpl v = frame().call(Calls.KFrame_getLocal, ii.index);
                            addCode(new JJITDecVar(ii.type, ii.name, ii.validateType(v)));
                        } else {
                            addCode(new JJITDecVar(ii.type, ii.name, null));
                        }
                    }
                }
            }
        }
        //setReturnExpression(new JJITName("next"));

    }

    @Override
    public void build() {

        JJITDebug debug = getParentClass().getDebug();
        int insertIndex = 0;
        for (Map.Entry<JJITName, JJITExpression> stringStringEntry : this.getCodeMap().entrySet()) {
            JJITName n = stringStringEntry.getKey();
            getBaseBloc().insertCode(new JJITDecVar(n.getExpressionType(), n.getValue(), null), insertIndex);
            insertIndex++;
        }
        for (JJITDecVar var : getVars()) {
            getBaseBloc().insertCode(var, insertIndex);
            insertIndex++;
        }

        List<JJITInstr> t = getBaseBloc().getInstructions();
//        JJITExpression r = getReturnExpression();
//        if (r == null) {
//            declareAndReturnNext();
//            r = getReturnExpression();
//        }
//        Return(r);
        if (!(t.get(t.size() - 1) instanceof JJITReturn)) {
            ReturnNext();
        }

        Map<String, JJITDecField> fieldMap = new HashMap<String, JJITDecField>();
        JJITDecField[] fields = getParentClass().getFields();
        for (JJITDecField field : fields) {
            fieldMap.put(field.getName(), field);
        }
        Map<String, JJITDecVar> varsMap = new HashMap<String, JJITDecVar>();
        JJITDecVar[] vars = getVars();
        for (JJITDecVar field : vars) {
            varsMap.put(field.getName(), field);
        }

        boolean optSimplify = debug.isOptSimplify();
        if (debug.isOptSubstitute()) {
            for (int i = 0; i < 5; i++) {
                List<JJITInstr> bi = getBaseBloc().getInstructions();
                final JJITInstr[] instructions = bi.toArray(new JJITInstr[bi.size()]);
                JJITOptimizer.performSubstitution(new JJITFlowIterator(null, instructions, 0, instructions.length), optSimplify, fieldMap, varsMap);
                getBaseBloc().clear();
                getBaseBloc().addAll(Arrays.asList(instructions));
            }
        } else if (optSimplify) {
//            for (int i = 0; i < 5; i++) {
            List<JJITInstr> bi = getBaseBloc().getInstructions();
            final JJITInstr[] instructions = bi.toArray(new JJITInstr[bi.size()]);
            JJITOptimizer.performSimplify(instructions, fieldMap, varsMap);
            getBaseBloc().clear();
            getBaseBloc().addAll(Arrays.asList(instructions));
//            }
        }
    }

    boolean flushed;

    public void Flush() {
        if (!flushed) {
            flushed = true;
            JJITDebug debug = getParentClass().getDebug();
            if (debug.isOptLocal()) {
                for (IOLocalInfo ii : localInfos.values()) {
                    if (ii.cache && ii.writes > 0) {
                        addCode(frame().call(Calls.KFrame_setLocal, ii.index, ii.toKObject(new JJITName(ii.name, ii.type))));
                    }
                }
            }
        }
    }

    @Override
    public JJITBloc Return(JJITExpression e) {
        Flush();
        return super.Return(e);
    }

    @Override
    public JJITBloc Return() {
        return super.Return();
    }

    private IOLocalInfo getIOLocalInfo(int index) {
        IOLocalInfo ii = localInfos.get(index);
        if (ii == null) {
            ii = new IOLocalInfo(index);
            localInfos.put(index, ii);
        }
        return ii;
    }

    private IOFieldInfo getIOFieldInfo(String className, String fieldName, String fieldType) {
        String nn = className + "." + fieldName;
        IOFieldInfo ii = fieldInfos.get(nn);
        if (ii == null) {
            ii = new IOFieldInfo(nn);
            fieldInfos.put(nn, ii);
        }
        return ii;
    }

    public void setLocal(int index, JJITExpressionImpl value) {
        JJITDebug debug = getParentClass().getDebug();
        boolean optLocals = debug.isOptLocal();
        final IOLocalInfo li = getIOLocalInfo(index);
        if (optLocals) {
            if (li.cache) {
                String item = li.name;
                set(new JJITName(item, li.type), li.validateType(value));
                return;
            }
        }
        addCode(frame().call(Calls.KFrame_setLocal, index, li.toKObject(value)));
    }

    public JJITExpression getLocalPrimitive(int index, KObjectType type) {
        JJITDebug debug = getParentClass().getDebug();
        boolean optLocals = debug.isOptLocal();
        final IOLocalInfo li = getIOLocalInfo(index);
        if (optLocals) {
            if (li.cache) {
                String item = li.name;
                return li.toPrimitive(new JJITName(item, li.type), type);
            }
        }
        return li.toPrimitive(frame().call(Calls.KFrame_getLocal, index), type);
    }

    public JJITExpression getLocalObject(int index) {
        boolean optLocals = getParentClass().getDebug().isOptLocal();
        if (optLocals) {
            final IOLocalInfo li = getIOLocalInfo(index);
            if (li.cache) {
                String item = li.name;
                return li.toKObject(new JJITName(item, li.type));
            }
        }
        return frame().call(Calls.KFrame_getLocal, index);
    }

    public JJITExpressionImpl getInstanceValue(String className, String fieldName, String fieldType) {
        boolean optFields = getParentClass().getDebug().isOptFields();
        if (optFields) {
            final JJITMethodSourceInit i = getParentClass().init();
            final IOFieldInfo li = getIOFieldInfo(className, fieldName, fieldType);
            if (li.cacheReads()) {
                return i.declareKFieldValue(className, fieldName, fieldType);
            }
        }
        if (getParentClass().getBaseMethod().getClassName().equals(className)) {
            final JJITMethodSourceInit i = getParentClass().init();
            final JJITName v = i.declareAndInitKField(className, fieldName);
            if ("I".equals(fieldType)) {
                return (new JJITNew(Types.KINTEGER, v.call(Calls.KField_getInstanceInt, popRef())));
            } else if ("D".equals(fieldType)) {
                return (new JJITNew(Types.KDOUBLE, v.call(Calls.KField_getInstanceDouble, popRef())));
            } else {
                boolean primitiveTypeCode = KClassDef.isPrimitiveTypeCode(fieldType);
                return (v.call(primitiveTypeCode ? Calls.KField_getInstanceValue : Calls.KField_getInstanceRef, popRef()));
            }
        } else {
            final JJITName v = declareAndInitKField(className, fieldName);
            return v.call(Calls.KField_getInstanceValue, popRef());
        }
    }

    public void setInstanceValue(String className, String fieldName, String fieldType) {
        final JJITName v = declareAndInitKField(className, fieldName);
        JJITName ref = declareRef();
        JJITName reg = declareReg();
        popReg(reg);
        popRef(ref);
        boolean optFields = getParentClass().getDebug().isOptFields();
        if (optFields) {
            final JJITMethodSourceInit i = getParentClass().init();
            final IOFieldInfo li = getIOFieldInfo(className, fieldName, fieldType);
            if (li.cacheWrites()) {
                JJITName fv = i.declareKFieldValue(className, fieldName, fieldType);
                set(fv, reg);
                return;
            }
        }

        if ("I".equals(fieldType)) {
            addCode(v.call(Calls.KField_setInstanceInt, ref, reg.call(Calls.KRegister_intValue)));
        } else {
            addCode(v.call(Calls.KField_setInstanceValue, ref, reg));
        }
    }

    private JJITName resolveStackItemName(int index, TypeStruct expressionType) {
        if (expressionType.equals(Types.KREFERENCE)) {
            return new JJITName("s" + index + "_ref", KReference.class.getName());
        }
        return new JJITName("s" + index, KRegister.class.getName());
    }

    @Deprecated
    public JJITInstr getPush(JJITExpression code) {
        if (isPushConsumed(0)) {
            JJITName item = resolveStackItemName(codeStack.size(), code.getExpressionType());
            codeMap.put(item, code);
            codeStack.push(item);
            return (new JJITSet(item, code));
        } else {
            return (new JJITExprInstr(frame().call(Calls.KFrame_push, code)));
        }
    }

    public void push(JJITExpression... codes) {
        for (int i = 0; i < codes.length; i++) {
            JJITExpression code = codes[i];
            if (isPushConsumed(codes.length - 1 - i)) {
                JJITName item = resolveStackItemName(codeStack.size(), code.getExpressionType());
                codeMap.put(item, code);
                codeStack.push(item);
                set(item, code);
            } else {
                addCode(frame().call(Calls.KFrame_push, code));
            }
        }
    }

    public void pushDoubles(JJITExpression... codes) {
        JJITExpression[] all = new JJITExpression[codes.length];
        for (int i = 0; i < all.length; i++) {
            all[i] = new JJITNew(Types.KDOUBLE, codes[i]);
        }
        push(all);
    }

    public void pushInts(JJITExpression... codes) {
        JJITExpression[] all = new JJITExpression[codes.length];
        for (int i = 0; i < all.length; i++) {
            all[i] = new JJITNew(Types.KINTEGER, codes[i]);
        }
        push(all);
    }


    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        String indent = layout.getIndent();
        JavaSourceLayout layout2 = layout.indent(2);
        out.println(indent + "public JJITInstruction run(KFrame frame) throws Exception {");
//        List<JJITDecVar> runVars = new ArrayList<JJITDecVar>();
//        for (Map.Entry<String, JJITExpression> stringStringEntry : this.getCodeMap().entrySet()) {
//            runVars.add(new JJITDecVar(TypeStruct.KREGISTER, stringStringEntry.getKey(), null));
//        }
//        runVars.addAll(Arrays.asList(getVars()));
//        for (JJITDecVar ai : runVars) {
//            ai.writeSource(out, layout2);
////            out.println();
//        }
        super.writeSource(out, layout2);
        out.println(indent + "}");
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        String indent = layout.getIndent();
        JavaSourceLayout layout2 = layout.indent(2);
        out.println(indent + "public JJITInstruction run(KFrame frame) throws Exception {");
//        for (JJITDecVar ai : runVars) {
//            ai.writeSource(out, layout2);
////            out.println();
//        }
        super.writeSource(out, layout2);
        out.println(indent + "}");
    }

    public HashMap<JJITName, JJITExpression> getCodeMap() {
        return codeMap;
    }

    //    private JJITConst resolveConstantExpression(JJITExpr code){
//        if(code instanceof JJITConst){
//           return (JJITConst)code;
//        }
//        if(code instanceof JJITName){
//            JJITName n=(JJITName)code;
//            if(fields.containsKey(code.getClass())
//        }
//
//    }
    public void popReg(JJITName var) {
        set(var, pop());
    }

    public void pushLocal(int local) {
//        if (getDebug().isPrimitiveLocals()) {
//            IOLocalInfo iOLocalInfo = getIOLocalInfo(local);
//            if (iOLocalInfo.cache) {
//                TypeStruct ttype = iOLocalInfo.type;
//                if (ttype.equals(TypeStruct.INT)) {
////                pushInts(getLocal(local).call("intValue"));
//                    push(getLocalObject(local));
//                    return;
//                }
//            }
//        }
        push(getLocalObject(local));
    }

    public void popToLocal(int local) {
        if (getDebug().isPrimitiveLocals()) {
            IOLocalInfo iOLocalInfo = getIOLocalInfo(local);
            TypeStruct ttype = iOLocalInfo.type;
            if (ttype.equals(Types.INT)) {
                setLocal(local, popInt());
//                setLocal(local, new JJITNew("KInteger", popInt()));
                return;
            }
        }
        setLocal(local, pop());
    }

    public void popIgnored() {
        if (codeStack.isEmpty()) {
            addCode(frame().call(Calls.KFrame_pop));
        } else {
            //ignore the pop
            codeStack.pop();
        }
    }

    public JJITExpressionImpl pop() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_pop);
        }
        return codeStack.pop();
    }

    public void popInt(JJITName varName) {
        set(varName, popInt());
    }

    //    public void popByte(String varName) {
//        return getBloc().addCode(new JJITSet(new JJITName(varName), popByte()));
//    }
    public void popRef(JJITName varName) {
        set(varName, popRef());
    }

    public void popFloat(JJITName varName) {
        set(varName, popFloat());
    }

    public void popLong(JJITName varName) {
        set(varName, popLong());
    }

    public void popDouble(JJITName varName) {
        set(varName, popDouble());
    }

    public void pop(KRegisterType t, String varName) {
        set(new JJITName(varName, KRegister.class), pop(t));
    }

    public void pop(JJITName varName) {
        set(varName, pop());
    }

    public JJITExpressionImpl pop(KRegisterType t) {
        switch (t) {
            case LONG: {
                return popLong();
            }
            case DOUBLE: {
                return popDouble();
            }
            case FLOAT: {
                return popFloat();
            }
            case INTEGER: {
                return popInt();
            }
            case REF: {
                return popRef();
            }
        }
        throw new IllegalArgumentException("Unsupported Type " + t);
    }

    public JJITExpressionImpl popInt() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_popInt);
        }
        return codeStack.pop().call(Calls.KRegister_intValue);
        //return codeStack.pop().cast("KInteger").field("value");
    }

    public JJITExpressionImpl popByte() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_popByte);
        }
        return codeStack.pop().call(Calls.KRegister_byteValue);
    }

    public JJITExpressionImpl popFloat() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_popFloat);
        }
        return codeStack.pop().call(Calls.KRegister_floatValue);
//        return codeStack.pop().cast(TypeStruct.KFLOAT).field("value",TypeStruct.FLOAT);
    }

    public JJITExpressionImpl popShort() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_popShort);
        }
        return codeStack.pop().call(Calls.KRegister_shortValue);
//        return codeStack.pop().cast(TypeStruct.KSHORT).field("value",TypeStruct.SHORT);
    }

    public JJITExpressionImpl popLong() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_popLong);
        }
        return codeStack.pop().call(Calls.KRegister_longValue);
//        return codeStack.pop().cast(TypeStruct.KLONG).field("value",TypeStruct.LONG);
    }

    public JJITExpressionImpl popDouble() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_popDouble);
        }
        return codeStack.pop().call(Calls.KRegister_doubleValue);
//        return codeStack.pop().cast(TypeStruct.KDOUBLE).field("value",TypeStruct.DOUBLE);
    }

    public JJITExpressionImpl popRef() {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_popRef);
        }
        JJITName r = codeStack.pop();
        return r.cast(Types.KREFERENCE);
    }

    public void peek(JJITName var, int x) {
        set(var, peek(x));
    }

    public JJITExpressionImpl peek(int ignorePush) {
        if (codeStack.isEmpty()) {
            return frame().call(Calls.KFrame_peek);
        }
        JJITExpressionImpl e = codeStack.peek();
        if (isPushConsumed(ignorePush)) {
            return e;
        }
        addCode(frame().call(Calls.KFrame_push, e));
        return e;
    }

//    public boolean isPushConsumed(int x, JJITFlowControlNode... nodes) {
//        return isPushConsumed(x, Arrays.asList(nodes));
//    }

    public boolean isPushConsumed(int x, List<JJITFlowControlNode> nodes) {
        for (JJITFlowControlNode node : nodes) {
            if (!isPushConsumed1(x, node)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPushConsumed1(int x, JJITFlowControlNode node) {
        if (node.getIndex() > maxIndex) {
            return false;
        }
        if (node.getIndex() < minIndex) {
            if (node.getIndex() < 0) {
                throw new RuntimeException("Should never happen");
            }
            return false;
        }
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        JJITChanges sc = node.getChanges();
        for (JJITChangeOp o : sc) {
            if (o.isPop()) {
                x--;
                if (x <= 0) {
                    return true;
                }
            } else if (o.isPush()) {
                x++;
            }
        }
        return isPushConsumed(x, node.getNext());
    }

    public boolean isPushConsumed(int x) {
        if (!getParentClass().getDebug().isOptStack()) {
            return false;
        }
//        int stackSize = x + 1;
        return isPushConsumed(x + 1, currentNode.getNext());
//
//        JJITInstructionDef[] instructions = getParentClass().getInstructions();
//        int instructions_length = instructions.length;
//        JJITFlowControl fc = getParentClass().getFlowControl();
//        int i0 = getParentClass().getFlowControlIndex();
//        for (int i = index + 1; i < instructions_length; i++) {
//            FlowControlNode node = fc.getNode(i + i0);
//            JJITStackChange sc = instructions[i].getStackChanges(node, 0);
//            for (JJITStackOp o : sc) {
//                if (o.isPop()) {
//                    stackSize--;
//                    if (stackSize <= 0) {
//                        return true;
//                    }
//                } else if (o.isPush()) {
//                    stackSize++;
//                }
//            }
//        }
//        return false;
    }
//    public boolean isPushConsumed(int x) {
//        if (!getParentClass().getDebug().isOptStack()) {
//            return false;
//        }
//        int stackSize = x + 1;
//        JJITInstructionDef[] instructions = getParentClass().getInstructions();
//        int instructions_length = instructions.length;
//        JJITFlowControl fc = getParentClass().getFlowControl();
//        int i0 = getParentClass().getFlowControlIndex();
//        for (int i = index + 1; i < instructions_length; i++) {
//            FlowControlNode node = fc.getNode(i + i0);
//            JJITStackChange sc = instructions[i].getStackChanges(node, 0);
//            for (JJITStackOp o : sc) {
//                if (o.isPop()) {
//                    stackSize--;
//                    if (stackSize <= 0) {
//                        return true;
//                    }
//                } else if (o.isPush()) {
//                    stackSize++;
//                }
//            }
//        }
//        return false;
//    }


    @Override
    public String toString() {
        return "JJITMethodSourceRun" + getParentClass();
    }

    private class IOLocalInfo {

        public IOLocalInfo(int localIndex) {
            this.index = localIndex;

            String guessedType = JJITUtils.guessLocalType(getParentClass().getInstructions(), localIndex);

            JJITClassSource pclass = getParentClass();
            KMethodDef bm = pclass.getBaseMethod();
            boolean staticBaseMethod = Modifier.isStatic(bm.getModifiers());
            boolean primitiveLocals = pclass.getDebug().isPrimitiveLocals();
            if (staticBaseMethod || localIndex > 0) {
                name = "local_" + localIndex;
//                KVariableDef v = bm.getVariableByIndex(index);
                typePrim = Types.KREGISTER;
                objType = Types.KREGISTER;
                if (guessedType != null) {
                    if (guessedType.equals("I")) {
                        typePrim = Types.INT;
                        objType = Types.KINTEGER;
                        prim = primitiveLocals;
//                    }else if(guessedType.equals("Ljava.lang.Object;")){
//                        typePrim=TypeStruct.KREFERENCE;
//                        objType=TypeStruct.KREFERENCE;
                    }
                }
                if (primitiveLocals) {
                    type = typePrim;
                } else {
                    type = Types.KREGISTER;
                }
            } else {
                name = "this_ref";
                type = Types.KREFERENCE;
                typePrim = Types.KREFERENCE;
                objType = Types.KREFERENCE;
            }

        }

        int index;
        int reads;
        int writes;
        boolean cache;
        boolean prim;
        //        boolean cacheWrites;
        boolean readFirst;
        boolean writeFirst;
        String name;
        TypeStruct type;
        TypeStruct typePrim;
        TypeStruct objType;

        void doRead() {
            if (reads == 0 && writes == 0) {
                readFirst = true;
            }
            reads++;
        }

        void doWrite() {
            if (reads == 0 && writes == 0) {
                writeFirst = true;
            }
            writes++;
        }

        public JJITExpression toPrimitive(JJITExpression e, KObjectType type) {
            TypeStruct to = Types.KREGISTER;
            switch (type) {
                case t_int: {
                    to = Types.INT;
                    break;
                }
                case t_long: {
                    to = Types.LONG;
                    break;
                }
                case t_double: {
                    to = Types.DOUBLE;
                    break;
                }
                case t_float: {
                    to = Types.FLOAT;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Not supported yet");
                }
            }
            return JJITConverter.convert(e, to);
        }

        public JJITExpression validateType(JJITExpression e) {
            return JJITConverter.convert(e, type);
        }

        public JJITExpression toKObject(JJITExpression e) {
            return JJITConverter.convert(e, objType);
//            if (type.equals(TypeStruct.INT)) {
//                return new JJITNew(TypeStruct.KINTEGER, e);
//            } else if (type.equals(TypeStruct.DOUBLE)) {
//                return new JJITNew(TypeStruct.KDOUBLE, e);
//            } else {
//                return e;
//            }
        }

        //        boolean cacheReads() {
//            return cacheReads;
//        }
//
//        boolean cacheWrites() {
//            return cacheWrites;
//        }
        @Override
        public String toString() {
            return "IOLocalInfo{" + "name=" + name + ",index=" + index + ", reads=" + reads + ", writes=" + writes + ", cache=" + cache + ", readFirst=" + readFirst + ", writeFirst=" + writeFirst + ", type=" + type + '}';
        }
    }

    private class IOFieldInfo {

        public IOFieldInfo(String name) {
            this.varName = name;
        }

        String className;
        String fieldName;
        int reads;
        int writes;
        boolean cacheReads;
        boolean cacheWrites;
        boolean readFirst;
        boolean writeFirst;
        String varName;
        String fieldType;

        void doRead() {
            if (reads == 0 && writes == 0) {
                readFirst = true;
            }
            reads++;
        }

        void doWrite() {
            if (reads == 0 && writes == 0) {
                writeFirst = true;
            }
            writes++;
        }

        boolean cacheReads() {
            return cacheReads;
        }

        boolean cacheWrites() {
            return cacheWrites;
        }
    }

    public JJITFlowControlNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(JJITFlowControlNode currentNode) {
        this.currentNode = currentNode;
    }

    public JJITName frame() {
        return new JJITName("frame", KFrame.class);
    }

    public JJITName declareIndex() {
        return declareLocalVar(defaultVars.get("index"));
    }

    public JJITName declareIndex2() {
        return declareLocalVar(defaultVars.get("index2"));
    }

    public JJITName declareKClazz() {
        getParentClass().defineImport(KClass.class.getName());
        return declareLocalVar(defaultVars.get("kclass"));
    }

    public JJITName declareJump() {
        return declareLocalVar(defaultVars.get("jump"));
    }

    public JJITName declareIgnorable() {
        return declareLocalVar(defaultVars.get("ignorable"));
    }

    public JJITName declareRefVal() {
        return declareLocalVar(defaultVars.get("refval"));
    }

    public JJITName declareReg() {
        return declareLocalVar(defaultVars.get("reg"));
    }

    public JJITName declareReg2() {
        return declareLocalVar(defaultVars.get("reg2"));
    }

    public JJITName declareRef() {
        return declareLocalVar(defaultVars.get("ref"));
    }

    public JJITName declareRef2() {
        return declareLocalVar(defaultVars.get("ref2"));
    }

    public JJITName declareProcess() {
        getParentClass().defineImport(KProcess.class.getName());
        return declareLocalVar(defaultVars.get("process"));
    }

    public JJITName declareCaller() {
        return declareLocalVar(defaultVars.get("callerFrame"));
    }

    public JJITName declareNextFrame() {
        return declareLocalVar(defaultVars.get("nextFrame"));
    }

    public JJITName declareNextInstr() {
        return declareLocalVar(defaultVars.get("nextInstr"));
    }

    public JJITName declareThread() {
        getParentClass().defineImport(KLocalThread.class.getName());
        return declareLocalVar(defaultVars.get("thread"));
    }

    public JJITName declareRegs() {
        return declareLocalVar(defaultVars.get("regs"));
    }

    public JJITName declareMemSeg() {
        getParentClass().defineImport(KMemorySegment.class.getName());
        return declareLocalVar(defaultVars.get("memseg"));
    }

    protected void addDefaultVar(JJITDecVar v) {
        defaultVars.put(v.getName(), v);
    }

    public JJITName declareLocalVar(JJITDecVar v) {
        for (JJITExpression e : v.getExpressions()) {
            if (e instanceof JJITName) {
                String n = ((JJITName) e).getValue();
                if (!"frame".equals(n) && !vars.containsKey(n)) {
                    if (defaultVars.containsKey(n)) {
                        declareLocalVar(defaultVars.get(n));
                    } else {
                        throw new NoSuchElementException("unknown dependency var " + n + " in " + v);
                    }
                }
            }
        }
        return super.declareLocalVar(v);
    }
}
