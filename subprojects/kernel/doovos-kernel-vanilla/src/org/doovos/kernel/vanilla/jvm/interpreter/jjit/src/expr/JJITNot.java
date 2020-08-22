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
public class JJITNot extends JJITExpressionImpl {

    private JJITExpression expression;

    public JJITNot(JJITExpression exp) {
        this.expression = exp.copy();
        this.expression.setParent(this);
    }

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITNot other = (JJITNot) o;
        if (!JJITPatternUtils.matches(expression, other.expression, ee)) {
            return null;
        }
        return ee;
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        expression=simplifyChild(expression, fields, varsMap);
        if(expression instanceof JJITConstant){
            JJITConstant c=(JJITConstant) expression;
            Object object = c.getObject();
            if(Boolean.TRUE.equals(object)){
                return JJITConstant.FALSE;
            }else if(Boolean.FALSE.equals(object)){
                return JJITConstant.TRUE;
            }
        }
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return expression.getVarUsage(names);
    }
//    public boolean isReadVar(String name) {
//        return expression.isReadVar(name);
//    }
//
//    public boolean isWriteVar(String name) {
//        return expression.isWriteVar(name);
//    }

    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>();
        c.add(expression);
        return c;
    }

    public JJITExpression getExpression() {
        return expression;
    }

    public TypeStruct getExpressionType() {
        return expression.getExpressionType();
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (this.equals(a)) {
            return b.copy();
        }
        return new JJITNot(expression.replace(a, b));
    }

    public JJITExpression copy() {
        return new JJITNot(expression);
    }

    public void write(PrintStream out) {
        out.print("!(");
        expression.write(out);
        out.print(")");
    }

    public void write(PrintWriter out) {
        out.print("!(");
        expression.write(out);
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

        JJITNot jjitNot = (JJITNot) o;

        if (expression != null ? !expression.equals(jjitNot.expression) : jjitNot.expression != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return expression != null ? expression.hashCode() : 0;
    }
}
