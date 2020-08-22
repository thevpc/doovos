/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITArr extends JJITExpressionImpl {

    private JJITExpression expression;
    private JJITExpression[] args;

    public JJITArr(JJITExpression expr, JJITExpression... args) {
        this.expression = expr.copy();
        expression.setParent(this);
        this.args = new JJITExpression[args.length];
        for (int i = 0; i < args.length; i++) {
            this.args[i] = (args[i] == null) ? JJITConstant.NULL.copy() : args[i].copy();
            this.args[i].setParent(this);
        }
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        expression=simplifyChild(expression,fields, varsMap);
        for (int i = 0; i < args.length; i++) {
            args[i]=args[i].simplify(fields, varsMap);
        }
        return this;
    }

    public TypeStruct getExpressionType() {
        if(expression instanceof JJITType){
            return ((JJITType)expression).getValue();
        }else{
            throw new IllegalArgumentException("What i gonna do?");
        }
    }
    

    @Override
    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITArr jjitArr = (JJITArr) o;
        if (!JJITPatternUtils.matches(args, jjitArr.args, ee)
                || !JJITPatternUtils.matches(expression, jjitArr.expression, ee)) {
            return null;
        }
        return ee;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list = new JJITVarUsageList();
        list.addAll(expression.getVarUsage(names));
        for (int i = 0; i < args.length; i++) {
            list.addAll(args[i].getVarUsage(names));
        }
        return list;
    }

//    public boolean isReadVar(String name) {
//        if (expression.isReadVar(name)) {
//            return true;
//        }
//        for (int i = 0; i < args.length; i++) {
//            if (args[i].isReadVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean isWriteVar(String name) {
//        for (int i = 0; i < args.length; i++) {
//            if (args[i].isReadVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }

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
        JJITExpression expr2 = expression.replace(a, b);
        JJITExpression[] args2 = new JJITExpression[args.length];
        for (int i = 0; i < args2.length; i++) {
            args2[i] = args[i].replace(a, b);
        }
        return new JJITArr(expr2, args2);
    }

    public JJITExpression copy() {
        return new JJITArr(expression, args);
    }

    public void write(PrintStream out) {
        expression.write(out);
        for (JJITExpression arg : args) {
            out.print("[");
            arg.write(out);
            out.print("]");
        }
    }

    public void write(PrintWriter out) {
        expression.write(out);
        for (JJITExpression arg : args) {
            out.print("[");
            arg.write(out);
            out.print("]");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JJITArr jjitArr = (JJITArr) o;

        if (!Arrays.equals(args, jjitArr.args)) {
            return false;
        }
        if (expression != null ? !expression.equals(jjitArr.expression) : jjitArr.expression != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = expression != null ? expression.hashCode() : 0;
        result = 31 * result + (args != null ? Arrays.hashCode(args) : 0);
        return result;
    }

    public JJITExpression[] getArgs() {
        return args;
    }

    public JJITExpression getExpression() {
        return expression;
    }
}
