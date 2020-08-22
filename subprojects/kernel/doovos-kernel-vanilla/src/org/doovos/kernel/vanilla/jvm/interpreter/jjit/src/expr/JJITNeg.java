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
public class JJITNeg extends JJITExpressionImpl {

    private JJITExpression expression;

    public JJITNeg(JJITExpression exp) {
        this.expression = exp.copy();
        this.expression.setParent(this);
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        expression=simplifyChild(expression,fields, varsMap);
        if(expression instanceof JJITNeg){
            return ((JJITNeg)expression).getExpression();
        }
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return expression.getVarUsage(names);
    }

    public TypeStruct getExpressionType() {
        return expression.getExpressionType();
    }
    

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITNeg other = (JJITNeg) o;
        if (!JJITPatternUtils.matches(expression, other.expression,ee)
                ) {
            return null;
        }
        return ee;
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

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (this.equals(a)) {
            return b.copy();
        }
        return new JJITNeg(expression.replace(a,b));
    }

    public JJITExpression copy() {
        return new JJITNeg(expression);
    }
    
    

    public void write(PrintStream out) {
            out.print("-(");
            expression.write(out);
            out.print(")");
    }

    public void write(PrintWriter out) {
            out.print("-(");
            expression.write(out);
            out.print(")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJITNeg jjitNeg = (JJITNeg) o;

        if (expression != null ? !expression.equals(jjitNeg.expression) : jjitNeg.expression != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return expression != null ? expression.hashCode() : 0;
    }
}
