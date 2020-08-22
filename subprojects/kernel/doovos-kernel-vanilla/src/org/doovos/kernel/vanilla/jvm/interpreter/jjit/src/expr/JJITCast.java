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
public class JJITCast extends JJITExpressionImpl {

    private JJITExpression expression;
    private TypeStruct expressionType;
    
    public JJITCast(JJITExpression var, TypeStruct type) {
        this.expression = var.copy();
        this.expression.setParent(this);
        expressionType=(type);
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        expression=simplifyChild(expression,fields, varsMap);
        if (expression.getExpressionType().equals(expressionType)) {
            // replace : ((KFloat)FZERO)
            // with    : FZERO
            return expression;
        }
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return expression.getVarUsage(names);
    }
    
    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITCast other = (JJITCast) o;
        if (!JJITPatternUtils.matches(getExpressionType(), other.getExpressionType())
                || !JJITPatternUtils.matches(expression, other.expression, ee)) {
            return null;
        }
        return ee;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (a.equals(this)) {
            return b.copy();
        }
        return new JJITCast(expression.replace(a, b), expressionType);
    }

    public JJITExpression copy() {
        return new JJITCast(expression, expressionType);
    }

//    public boolean isReadVar(String name) {
//        return expression.isReadVar(name);
//    }
//
//    public boolean isWriteVar(String name) {
//        return expression.isWriteVar(name);
//    }

    public JJITExpression getVar() {
        return expression;
    }

    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>(1);
        c.add(expression);
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JJITCast jjitCast = (JJITCast) o;

        if (getExpressionType() != null ? !getExpressionType().equals(jjitCast.getExpressionType()) : jjitCast.getExpressionType() != null) {
            return false;
        }
        if (expression != null ? !expression.equals(jjitCast.expression) : jjitCast.expression != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = expression != null ? expression.hashCode() : 0;
        result = 31 * result + (getExpressionType() != null ? getExpressionType().hashCode() : 0);
        return result;
    }

    public void write(PrintStream out) {
        out.print("((");
        out.print(expressionType.getSimpleName());
        out.print(")");
        expression.write(out);
        out.print(")");
    }

    public void write(PrintWriter out) {
        out.print("((");
        out.print(expressionType.getSimpleName());
        out.print(")");
        expression.write(out);
        out.print(")");
    }

    public TypeStruct getExpressionType() {
        return expressionType;
    }
    
    
}
