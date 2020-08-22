/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

import org.doovos.kernel.api.jvm.bytecode.MethodSignatureParser;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITConverter;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.FieldStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITCall extends JJITExpressionImpl {
    private static final Map<MethodStruct, TypeStruct> INV_INLINE_CONSTRUCTORS = new HashMap<MethodStruct, TypeStruct>();
    private static final Map<FieldStruct, JJITConstant> CONSTANTS = new HashMap<FieldStruct, JJITConstant>();

    static {
        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_intValue, Types.KINTEGER);
        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_doubleValue, Types.KDOUBLE);
        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_longValue, Types.KLONG);
        INV_INLINE_CONSTRUCTORS.put(Calls.KRegister_floatValue, Types.KFLOAT);
        CONSTANTS.put(Fields.KInteger_M1, JJITConstant.IM1);
        CONSTANTS.put(Fields.KInteger_ZERO, JJITConstant.I0);
        CONSTANTS.put(Fields.KInteger_ONE, JJITConstant.I1);
    }

    private JJITExpression expression;
    private MethodStruct method;
    private JJITExpression[] args;

    public JJITCall(JJITExpression var, MethodStruct method, JJITExpression... args) {

        this.method = method;
        this.expression = var.copy();
        expression.setParent(this);
        this.args = new JJITExpression[args.length];
        for (int i = 0; i < args.length; i++) {
            this.args[i] = (args[i] == null) ? JJITConstant.NULL.copy() : args[i].copy();
            this.args[i].setParent(this);
        }
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        TypeStruct ttype = INV_INLINE_CONSTRUCTORS.get(method);
        expression=simplifyChild(expression, fields, varsMap);
        for (int i = 0; i < args.length; i++) {
            args[i]=simplifyChild(args[i],fields, varsMap);
        }
        if (ttype != null) {
            JJITExpression oo = expression;
            if (oo instanceof JJITNew) {
                JJITNew oonew = (JJITNew) oo;
                if (oonew.getType().equals(ttype)) {
//                                    for (JJITExpression ee : ii.getRootReadExpressions()) {
//                                        Map<JJITPattern, JJITExpression> rr = ee.matches(new JJITNew("KInteger",new JJITPatternAny(1)).call("intValue"));
//                                    }

                    return JJITConverter.convert(oonew.getArgs()[0], method.getReturnType());
                }
            } else if (oo instanceof JJITField) {
                JJITField f = (JJITField) oo;
                JJITConstant jjitConstant = CONSTANTS.get(f.getField());
                if (jjitConstant != null) {
                    return jjitConstant;
                }
            } else if (oo instanceof JJITName) {
                JJITName oon = (JJITName) oo;
                String vv = oon.getValue();
                JJITDecField df = fields.get(vv);
                if (df == null) {
                    //ignore
                } else {
                    JJITExpression init = df.getExpression();
                    if (init instanceof JJITKRegisterConstant) {
                        JJITKRegisterConstant cst = (JJITKRegisterConstant) init;
                        //replace     : <Constant>.intValue() : exp IZERO.longValue() ...etc
                        //      with : ConstantValue : exp 0
                        return cst.getJavaConst();
                    }
                }
            } else if (oo instanceof JJITOp3) {
                JJITOp3 o3 = (JJITOp3) oo;
                JJITExpression o4 = new JJITOp3(o3.getCondition(), new JJITCall(o3.getTrueExpression(), method), new JJITCall(o3.getFalseExpression(), method));
                o4=o4.simplify(fields, varsMap);
                return o4;
            }
        } else if (method.equals(Calls.Float_isNaN)) {
            if (args[0] instanceof JJITConstant) {
                JJITConstant arg = (JJITConstant) args[0];
                return JJITConstant.asBool(Float.isNaN(((Number) arg.getObject()).floatValue()));
            }
        } else if (method.equals(Calls.Double_isNaN)) {
            if (args[0] instanceof JJITConstant) {
                JJITConstant arg = (JJITConstant) args[0];
                return JJITConstant.asBool(Double.isNaN(((Number) arg.getObject()).doubleValue()));
            }
        }
        return this;
    }


    public JJITVarUsageList getVarUsage(String... names) {
        JJITVarUsageList list = new JJITVarUsageList();
        list.addAll(expression.getVarUsage(names));
        for (JJITExpression a : args) {
            list.addAll(a.getVarUsage(names));
        }
        boolean getterMethod = !method.isUpdateContent();
        if (getterMethod) {
            JJITUtils.fillNamesIntoUsageList(expression, list, JJITVarUsageType.GETTER, names);
        } else {
            JJITUtils.fillNamesIntoUsageList(expression, list, JJITVarUsageType.SETTER, names);
        }
        return list;
    }

//    private boolean isGetterMethod() {
//        if (GETTERS.contains(method)) {
//            return true;
//        }
//        if (isGetterMethod("get") || isGetterMethod("has") || isGetterMethod("is") || isGetterMethod("contains")) {
//            return true;
//        }
//        if (method.equals("size")) {
//            return true;
//        }
//        System.out.println("WRITE METHOD : " + method);
//        return false;
//    }
//
//    private boolean isGetterMethod(String prefix) {
//        return method.equals(prefix)
//                || (method.startsWith(prefix) && method.length() > prefix.length() && Character.isUpperCase(method.charAt(prefix.length())));
//    }

    @Override
    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITCall jjitArr = (JJITCall) o;
        if (!JJITPatternUtils.matches(method.getMethodName(), jjitArr.method.getMethodName())
                || !JJITPatternUtils.matches(args, jjitArr.args, ee)
                || !JJITPatternUtils.matches(expression, jjitArr.expression, ee)) {
            return null;
        }
        return ee;
    }

//    public boolean isReadVar(String name) {
//        if (expression.isReadVar(name)) {
//            return true;
//        }
//        for (JJITExpression e : args) {
//            if (expression.isReadVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean isWriteVar(String name) {
//        if (expression.isWriteVar(name)) {
//            return true;
//        }
//        for (JJITExpression e : args) {
//            if (expression.isWriteVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public JJITExpression getArg(int i) {
        return args[i];
    }

    public JJITExpression[] getArgs() {
        return args;
    }

    public MethodStruct getMethod() {
        return method;
    }

    public String getMethodName() {
        return method.getMethodName();
    }

    public JJITExpression getVar() {
        return expression;
    }

    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>();
        c.add(expression);
        c.addAll(Arrays.asList(args));
        return c;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (a.equals(this)) {
            return b.copy();
        }
        JJITExpression var2 = expression.replace(a, b);
        JJITExpression[] args2 = new JJITExpression[args.length];
        for (int i = 0; i < args2.length; i++) {
            args2[i] = args[i].replace(a, b);
        }
        return new JJITCall(var2, method, args2);
    }

    public JJITExpression copy() {
        return new JJITCall(expression, method, args);
    }

    public void write(PrintStream out) {
        expression.write(out);
        out.print(".");
        out.print(method.getMethodName());
        out.print("(");
        if (args.length > 0) {
            args[0].write(out);
        }
        for (int i = 1; i < args.length; i++) {
            out.print(",");
            args[i].write(out);
        }
        out.print(")");
    }

    public void write(PrintWriter out) {
        expression.write(out);
        out.print(".");
        out.print(method.getMethodName());
        out.print("(");
        if (args.length > 0) {
            args[0].write(out);
        }
        for (int i = 1; i < args.length; i++) {
            out.print(",");
            args[i].write(out);
        }
        out.print(")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JJITCall jjitCall = (JJITCall) o;

        if (!Arrays.equals(args, jjitCall.args)) {
            return false;
        }
        if (method != null ? !method.equals(jjitCall.method) : jjitCall.method != null) {
            return false;
        }
        if (expression != null ? !expression.equals(jjitCall.expression) : jjitCall.expression != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = expression != null ? expression.hashCode() : 0;
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (args != null ? Arrays.hashCode(args) : 0);
        return result;
    }

    public TypeStruct getExpressionType() {
        return method.getReturnType();
    }

    public static class Method {

        
        
    }
}
