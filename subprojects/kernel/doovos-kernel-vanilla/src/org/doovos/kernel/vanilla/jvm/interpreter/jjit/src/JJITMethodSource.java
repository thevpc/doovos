/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITCall;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITBloc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Stack;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Names;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITDebug;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpressionImpl;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITFor;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITIf;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITInstr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JavaSourceLayout;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 * @author vpc
 */
public abstract class JJITMethodSource {

    protected LinkedHashMap<String, JJITDecVar> vars = new LinkedHashMap<String, JJITDecVar>();
//    private JJITExpression returnExpression;
    private JJITClassSource parentClass;
    private JJITVarHelper varHelper = new JJITVarHelper("m_");
    private JJITBloc baseBloc = new JJITBloc();
    private Stack<JJITBloc> blocs = new Stack<JJITBloc>();

    static {
        //"/*00*/  refvalue"
    }

    public JJITMethodSource(JJITClassSource parentClass) {
        this.parentClass = parentClass;
        blocs.push(baseBloc);

    }

    public JJITName createVar(TypeStruct type, String prefix, Object... obj) {
        return new JJITName(varHelper.createVar(prefix, obj), type);
    }


    public JJITName declareMemMan() {
        return getParentClass().declareMemMan();
//        getParentClass().defineImport(KMemoryManager.class.getName());
//        return declareLocalVar(defaultVars.get("memman"));
    }

    public JJITName declareRepo() {
        return getParentClass().declareRepo();
//        getParentClass().defineImport(KClassRepository.class.getName());
//        return declareLocalVar(defaultVars.get("repo"));
    }


    public JJITName declareLocalVar(TypeStruct type, String prefix, JJITExpression initVal) {
        final JJITName n = createVar(type,prefix);
        JJITDecVar v = new JJITDecVar(type, n.getValue(), initVal);
        declareLocalVar(v);
        return n;
    }

    public JJITName declareLocalVar(JJITDecVar v) {
        if (!vars.containsKey(v.getName())) {
            vars.put(v.getName(), v);
        }
        return new JJITName(v.getName(), v.getExpressionType());
    }

    public JJITDecVar[] getVars() {
        //Arrays.sort(base0);
        return vars.values().toArray(new JJITDecVar[vars.size()]);
    }


//    public JJITExpression getReturnExpression() {
//        return returnExpression;
//    }
//    public JJITMethodSource setReturnExpression(JJITExpression returnExpression) {
//        this.returnExpression = returnExpression;
//        return this;
//    }
    public void ReturnNext() {
        JJITName next = getParentClass().declareFieldNext();
        JJITMethodSourceInit init = getParentClass().init();
        init.bloc().set(next, init.instructions().arr(init.index().add(JJITConstant.I1)));
        Return(next);
//        setReturnExpression(next);
    }


    public JJITName declareAndInitKClass(String className) {
        getParentClass().defineImport(KClass.class.getName());
        String clsId = "Class:" + className;
        JJITName name = parentClass.getFieldVarById(clsId, Types.KCLASS);
        if (name == null) {
            JJITName repo = declareRepo();
            final JJITName v = parentClass.declareField(Types.KCLASS, "C" + getSimpleName(className), clsId, JJITConstant.NULL);
            if (isClassAlreadyLoaded(className)) {
                getParentClass().init().getBaseBloc().set(v, new JJITCall(repo, Calls.KClassRepository_getClassByName, JJITConstant.asString(className)));
            } else {
                baseBloc.If(JJITCmpOp.EQ, v, null).Then().set(v, new JJITCall(repo, Calls.KClassRepository_getClassByName, JJITConstant.asString(className)));
            }
            return v;
        } else {
            return name;
        }
    }

    private String getSimpleName(String c) {
        final int x = c.lastIndexOf('.');
        if (x > 0) {
            return c.substring(x + 1);
        }
        return c;
    }

    public JJITName declareAndInitKField(String className, String fieldName) {
        getParentClass().defineImport(KClass.class.getName());
        getParentClass().defineImport(KField.class.getName());
        //final JJITName c = parentClass.define("cls","run","KClass",className);
//        final JJITName f = parentClass.define("field", "run", "KField", fieldName);
        String fieldVarId = "Field:" + className + "." + fieldName;
        JJITName name = parentClass.getFieldVarById(fieldVarId, Types.KCLASS);
        if (name == null) {
            final JJITName f = parentClass.declareField(Types.KFIELD, fieldName, fieldVarId, JJITConstant.NULL);
            if (isClassAlreadyLoaded(className)) {
                JJITName cc = declareAndInitKClass(className);
                getParentClass().init().getBaseBloc().set(f, cc.call(Calls.KClass_getField, fieldName, JJITConstant.TRUE));
            } else {
                JJITName repo = declareRepo();
                baseBloc.If(JJITCmpOp.EQ, f, null).Then().set(f, repo.call(Calls.KClassRepository_getClassByName, className).call(Calls.KClass_getField, fieldName, JJITConstant.TRUE));
            }
            return f;
        } else {
            return name;
        }
    }

    public JJITName declareKFieldValue(String className, String fieldName, String fieldType) {
        JJITName f = declareAndInitKField(className, fieldName);

        String fieldVarId = "FieldValue:" + className + "." + fieldName;
        TypeStruct tt = KClassDef.isPrimitiveTypeCode(fieldType) ? Types.KREGISTER : Types.KREFERENCE;
        JJITName name = parentClass.getFieldVarById(fieldVarId, tt);
        if (name == null) {
            return parentClass.declareField(tt, f.getValue() + "_value", fieldVarId, JJITConstant.NULL);
        } else {
            return name;
        }
    }

//    public MethodDefVars declareAndInitKMethodAndParams(String className, String methodSig) {
//        JJITName cls = declareAndInitKClass(className);
//        final JJITName mth = createVar("mth", "KMethod", className, methodSig);
//        final JJITName mthParams = createVar("mtp", "KMethodParams", className, methodSig);
//        parentClass.declareField(new JJITDecField("KMethod", mth.getValue(), JJITConst.NULL));
//        bloc.If(JJITCmpOp.EQ, mth, null).Then().set(mth, cls.call("getMethodBySignature", JJITConst.asString(methodSig))).set(mth, mth.call("getParametersCount").add(1));
//
//        MethodDefVars v = new MethodDefVars();
//        v.methodParamsVarCount = mthParams;
//        v.methodVarName = mth;
//        return v;
//    }
    public JJITName declareAndInitKMethod(String className, String methodSig) {
        getParentClass().defineImport(KMethod.class.getName());
        JJITName cls = declareAndInitKClass(className);
        String mId = className + "." + methodSig;
        JJITName name = parentClass.getFieldVarById(mId, Types.KMETHOD);
        if (name == null) {
            final JJITName mth = createVar(Types.KMETHOD,"mth", mId);
            parentClass.declareField(new JJITDecField(Modifier.PRIVATE, Types.KMETHOD, mth.getValue(), JJITConstant.NULL));
            baseBloc.If(JJITCmpOp.EQ, mth, null).Then().set(mth, cls.call(Calls.KClass_getMethodBySignature, JJITConstant.asString(methodSig)));
            return mth;
        } else {
            return name;
        }
    }

    public JJITName declareAndInitKMethodIgnore(String className, String methodSig) {
        getParentClass().defineImport(KMethod.class.getName());
        JJITName cls = declareAndInitKClass(className);
        String mId = className + "." + methodSig;
        JJITName name = parentClass.getFieldVarById(mId, Types.KMETHOD);
        if (name == null) {
            final JJITName mth = createVar(Types.KMETHOD, "mth", mId);
            final JJITName mth_ignore = new JJITName(mth.getValue() + "_ignorable", "boolean");
            parentClass.declareField(new JJITDecField(Modifier.PRIVATE, Types.KMETHOD, mth.getValue(), JJITConstant.NULL));
            parentClass.declareField(new JJITDecField(Modifier.PRIVATE, Types.BOOLEAN, mth_ignore.getValue(), JJITConstant.FALSE));
//            if(!mth_ignore.getValue().equals(mth.getValue()+"_ignore")){
//                throw new IllegalArgumentException("Unexpected");
//            }
            if (isClassAlreadyLoaded(className)) {
                getParentClass().init().getBaseBloc().set(mth, cls.call(Calls.KClass_getMethodBySignature, JJITConstant.asString(methodSig)));
                getParentClass().init().getBaseBloc().set(mth_ignore, mth.call(Calls.KMethod_isIgnorable));
            } else {
                JJITBloc Then = baseBloc.If(JJITCmpOp.EQ, mth, null).Then();
                Then.set(mth, cls.call(Calls.KClass_getMethodBySignature, JJITConstant.asString(methodSig)));
                Then.set(mth_ignore, mth.call(Calls.KMethod_isIgnorable));
            }
            return mth;
        } else {
            return name;
        }
    }

    public boolean isClassAlreadyLoaded(String className) {
        return className.equals(getParentClass().getBaseMethod().getClassName());
    }

//    public JJITName declareAndInitKMethodParams(String className, String methodSig) {
//        JJITName cls = declareAndInitKClass(className);
//        final JJITName mthParams = createVar("mth", "KMethod", className, methodSig + "params");
//        parentClass.declareField(new JJITDecField("int", mthParams.getValue(), JJITConst.IM1));
//        bloc.If(JJITCmpOp.EQ, mthParams, JJITConst.IM1).Then().set(mthParams, cls.call("getMethodBySignature", methodSig).call("getParametersCount").add(1));
//        return mthParams;
//    }
    public JJITClassSource getParentClass() {
        return parentClass;
    }

    public void build() {
    }

    public JJITBloc bloc() {
        return blocs.peek();
    }

    public void enterBloc(JJITBloc b) {
        blocs.push(b);
    }

    public void exitBloc() {
        blocs.pop();
    }

    //Bloc adapter
//    @Override
//    public Collection<JJITExpression> getExpressions() {
//        ArrayList<JJITExpression> all=new ArrayList<JJITExpression>();
//        for (JJITInstr li : list) {
//            all.addAll(li.getExpressions());
//        }
//        return all;
//    }
//
//
//    public void removeInstr(int index) {
//        list.remove(index);
//    }
//
//    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
//        List<JJITInstr> list2=new ArrayList<JJITInstr>();
//        for (JJITInstr i : list) {
//            list2.add(i.replaceReads(a, b));
//        }
//        return new JJITBloc(list2);
//    }
//    public List<JJITInstr> getInstructions() {
//        return list;
//    }
    public JJITBloc addCode(JJITExpressionImpl e) {
        return bloc().addCode(e);
    }

    public JJITBloc lineComment(String cmt) {
        return bloc().lineComment(cmt);
    }

    public JJITBloc multiLineComment(String cmt) {
        return bloc().multiLineComment(cmt);
    }

    public JJITBloc addCode(JJITInstr e) {
        return bloc().addCode(e);
    }

//    public JJITBloc set(String a, JJITExpression b) {
//        return bloc().set(a, b);
//    }
    public JJITBloc set(JJITExpressionImpl a, JJITExpression b) {
        return bloc().set(a, b);
    }

    public JJITBloc Return(JJITExpression e) {
        return bloc().Return(e);
    }

    public JJITBloc Return() {
        return bloc().Return();
    }

    public JJITIf If(JJITExpression e) {
        return bloc().If(e);
    }

    public JJITIf If(JJITCmpOp op, JJITExpression a, JJITExpression b) {
        return bloc().If(op, a, b);
    }

    public JJITFor For(JJITInstr dec, JJITExpression cond, JJITExpression inc) {
        return bloc().For(dec, cond, inc);
    }

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        baseBloc.writeSource(out, layout);
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        baseBloc.writeSource(out, layout);
    }

//    public abstract void writeSource(PrintStream out, JavaSourceLayout layout);
//
//    public abstract void writeSource(PrintWriter out, JavaSourceLayout layout);
    public JJITBloc getBaseBloc() {
        return baseBloc;
    }

    public JJITDebug getDebug() {
        return getParentClass().getDebug();
    }
}
