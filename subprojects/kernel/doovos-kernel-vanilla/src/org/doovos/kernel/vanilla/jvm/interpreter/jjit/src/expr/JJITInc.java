/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 * @author vpc
 */
public class JJITInc extends JJITExpressionImpl {

    private JJITExpression expression;
    private boolean inc;
    private boolean pre;

    public JJITInc(JJITExpression exp, boolean inc, boolean pre) {
        this.expression = exp.copy();
        expression.setParent(this);
        this.inc = inc;
        this.pre = pre;
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        return this;
    }

    public TypeStruct getExpressionType() {
        return expression.getExpressionType();
    }

    
    public JJITVarUsageList getVarUsage(String ... names) {
        if(expression instanceof JJITName){
            JJITName arName = (JJITName) expression;
            JJITVarUsageList list = new JJITVarUsageList();
            for (String n : names) {
                if (arName.getValue().equals(n)) {
                    list.add(new JJITVarUsage(arName, JJITVarUsageType.READ));
                    list.add(new JJITVarUsage(arName, JJITVarUsageType.WRITE));
                    return list;
                }
            }
            return list;
        }
        //TOD FIX ME
        return expression.getVarUsage(names);
    }

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITInc other = (JJITInc) o;
        if (!JJITPatternUtils.matches(expression, other.expression, ee)
                || inc != other.inc
                || pre != other.pre) {
            return null;
        }
        return ee;
    }

//    @Override
//    public boolean isReadVar(String name) {
//        return expression.isReadVar(name);
//    }
//
//    @Override
//    public boolean isWriteVar(String name) {
//        return expression.isReadVar(name);
//    }

    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>();
        c.add(expression);
        return c;
    }

    public JJITExpression getExpression() {
        return expression;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (this.equals(a)) {
            return b.copy();
        }
        return new JJITInc(expression.replace(a, b), inc, pre);
    }

    public JJITExpression copy() {
        return new JJITInc(expression, inc, pre);
    }

    public void write(PrintStream out) {
        String op = inc ? "++" : "--";
        if (pre) {
            out.print(op);
            expression.write(out);
        } else {
            expression.write(out);
            out.print(op);
        }
        //out.print(";");
    }

    public void write(PrintWriter out) {
        String op = inc ? "++" : "--";
        if (pre) {
            out.print(op);
            expression.write(out);
        } else {
            expression.write(out);
            out.print(op);
        }
        //out.print(";");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JJITInc jjitInc = (JJITInc) o;

        if (inc != jjitInc.inc) {
            return false;
        }
        if (pre != jjitInc.pre) {
            return false;
        }
        if (expression != null ? !expression.equals(jjitInc.expression) : jjitInc.expression != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = expression != null ? expression.hashCode() : 0;
        result = 31 * result + (inc ? 1 : 0);
        result = 31 * result + (pre ? 1 : 0);
        return result;
    }
}
