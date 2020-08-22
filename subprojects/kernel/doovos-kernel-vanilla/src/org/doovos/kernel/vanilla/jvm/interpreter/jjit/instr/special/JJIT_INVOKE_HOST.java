/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.jni.KJNIMethodInfo;
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.api.util.JavaByteCodeUtils;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 * @author vpc
 */
public class JJIT_INVOKE_HOST extends JJITInstructionDef {

    private KJNIMethodInfo method;

    public JJIT_INVOKE_HOST(KOperator op, KJNIMethodInfo method) {
        super(op);
        this.method = method;
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        throw new IllegalArgumentException("Unsupported");
    }

    @Override
    public boolean isJump() {
        return false;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        String methodName = method.getSpecMethodDesc();
        String[] paramsTypes = JavaByteCodeUtils.getMethodTypeCodes(methodName);
        String rt = JavaByteCodeUtils.getReturnType(methodName);
        KRegisterType rtt = JavaByteCodeUtils.getRegisterTypeByClassCode(rt);
        //[] r = rtt == null ? null : new KRegisterType[]{rtt};
        JJITChangeOp[] p;
        if (operator == KOperator.INVOKESTATIC) {
            p = new JJITChangeOp[paramsTypes.length + (rtt == null ? 0 : 1)];
            for (int i = 0; i < paramsTypes.length; i++) {
                p[i] = JJITChangeOp.Pop(JavaByteCodeUtils.getRegisterTypeByClassCode(paramsTypes[paramsTypes.length - i - 1]));
            }
            if (rtt != null) {
                p[paramsTypes.length] = JJITChangeOp.Push(JavaByteCodeUtils.getRegisterTypeByClassCode(rt));
            }
        } else {
            p = new JJITChangeOp[paramsTypes.length + 1 + (rtt == null ? 0 : 1)];
            for (int i = 0; i < paramsTypes.length; i++) {
                p[i] = JJITChangeOp.Pop(JavaByteCodeUtils.getRegisterTypeByClassCode(paramsTypes[paramsTypes.length - i - 1]));
            }
            p[paramsTypes.length] = JJITChangeOp.POP_REF;//this
            if (rtt != null) {
                p[paramsTypes.length + 1] = JJITChangeOp.Push(JavaByteCodeUtils.getRegisterTypeByClassCode(rt));
            }
        }
        return new JJITChanges(p);
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        r.declareRegs();
        //final String classNameString = (String) cls.getConstants()[classNameIndex];
        int paramsCount = JavaByteCodeUtils.getParametersCount(method.getSpecMethodDesc());
        String rt = JavaByteCodeUtils.getReturnType(method.getSpecMethodDesc());
        //final JJITExpressionImpl params = r.addRunInstanceMethodParams( classNameString, methodNameString);
//        final JJITExpression params = JJITConst.asNbr(paramsCount + (operator == KOperator.INVOKESTATIC ? 0 : 1));

//        r.declareKClazz();
//        r.declareRef();
//        r.declareThread();
//        r.declareRepo();
//        r.declareCaller();
//        JJITExpressionImpl meth = null;

        if (operator == KOperator.INVOKESTATIC) {
            JJITName[] regs = new JJITName[paramsCount];
            String[] argTypes = method.getImplParameterTypes();
            for (int ii = 0; ii < argTypes.length; ii++) {
                String t = argTypes[ii];
                regs[ii] = r.declareLocalVar(new TypeStruct(t), "v", null);
            }
            for (int j = paramsCount - 1; (j >= 0); j--) {
                String t = argTypes[j];
                if (t.equals("int")) {
                    r.popInt(regs[j]);
                } else if (t.equals("double")) {
                    r.popDouble(regs[j]);
                } else if (t.equals("float")) {
                    r.popFloat(regs[j]);
                } else if (t.equals("long")) {
                    r.popLong(regs[j]);
                } else if (t.equals("boolean")) {
                    r.set(regs[j], regs[j].ne(JJITConstant.I0));
                } else if (t.equals("short")) {
                    r.set(regs[j], regs[j].cast(Types.SHORT));
                } else {
                    throw new IllegalArgumentException("Unsupported type " + t);
                }
            }
            TypeStruct typeStruct = Types.VOID;
            TypeStruct ktypeStruct;
            String clsName = method.getImplClassName();
            String methName = method.getImplMethodName();
            JJITType jjitType = new JJITType(new TypeStruct(clsName));
            r.getParentClass().defineImport(jjitType.getValue());
            if (rt.equals("V")) {
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.addCode(jjitType.call(ms, (Object[]) regs));
            } else if (rt.equals("I")) {
                typeStruct=Types.INT;
                ktypeStruct=Types.KINTEGER;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.push(new JJITNew(ktypeStruct, jjitType.call(ms, (Object[]) regs)));
            } else if (rt.equals("D")) {
                typeStruct=Types.DOUBLE;
                ktypeStruct=Types.KDOUBLE;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.push(new JJITNew(ktypeStruct, jjitType.call(ms, (Object[]) regs)));
            } else if (rt.equals("J")) {
                typeStruct=Types.LONG;
                ktypeStruct=Types.KLONG;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.push(new JJITNew(ktypeStruct, jjitType.call(ms, (Object[]) regs)));
            } else if (rt.equals("S")) {
                typeStruct=Types.SHORT;
                ktypeStruct=Types.KSHORT;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.push(new JJITNew(ktypeStruct, jjitType.call(ms, (Object[]) regs)));
            } else if (rt.equals("C")) {
                typeStruct=Types.CHAR;
                ktypeStruct=Types.KINTEGER;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.push(new JJITNew(ktypeStruct, jjitType.call(ms, (Object[]) regs)));
            } else if (rt.equals("B")) {
                typeStruct=Types.BYTE;
                ktypeStruct=Types.KINTEGER;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.push(new JJITNew(ktypeStruct, jjitType.call(ms, (Object[]) regs)));
            } else if (rt.equals("Z")) {
                typeStruct=Types.BOOLEAN;
                ktypeStruct=Types.KINTEGER;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                r.push(new JJITNew(ktypeStruct, jjitType.call(ms, (Object[]) regs)));
            } else if (rt.equals("Ljava/lang/String;")) {
                typeStruct=Types.STRING;
//                ktypeStruct=Types.STRING;
                MethodStruct ms = new MethodStruct(clsName, methName, true, typeStruct.getName(), argTypes);
                JJITExpressionImpl ee = jjitType.call(ms, (Object[]) regs);
                JJITName s = r.declareLocalVar(Types.STRING, "s", null);
                r.set(s, jjitType.call(ms, (Object[]) regs));
                JJITName memman = r.declareMemMan();
                r.push(new JJITOp3(s.eq(JJITConstant.NULL), new JJITType(Types.KREFERENCE).field(Fields.KReference_NULL), memman.call(Calls.MemoryManager_allocString, ee)));
            } else {
                throw new IllegalArgumentException("Unsupported type " + rt);
            }
        } else {
            throw new IllegalArgumentException("Unsupported");
//            for (int j = paramsCount; (j > 0); j--) {
//                b.set(regs.arr(j), r.popReg());
//            }
//            final JJITName ref = new JJITName("ref");
//            b.set(ref, r.popRef());
//
//            b.set(regs.arr(0), ref);
//            String vv = isvirtual ? "getVirtualMethodBySignature" : "getMethodBySignature";
//            meth = new JJITName("memman").call("getPointer", ref).call("getKClass").call(vv, methodName);
        }

//        final JJITName j = new JJITName("j");
//        final JJITDecVar dec = new JJITDecVar("int", "j", regs.field("length").sub(1));
//        final JJITExpressionImpl cmp = j.gt(JJITConst.asNbr(0));
//        b.For(dec, cmp, j.decPost()).set(regs.arr(j), new JJITName("frame").call("pop"));

        //b.addCode(new JJITName("frame").call("getThread").call("getFrame").call("getCurrentInstruction").cast("JJITInstruction"));
        //b.addCode(new JJITName("thread").call("pushFrame", meth));
        //return cls;

        //r.setReturnExpression(new JJITName("next"));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT_INVOKE_HOST other = (JJIT_INVOKE_HOST) obj;
        if (this.method != other.method && (this.method == null || !this.method.equals(other.method))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.method != null ? this.method.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "INVOKE_HOST(" + method.getSpecMethodDesc() + ")";
    }
}
