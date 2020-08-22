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
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITOp3 extends JJITExpressionImpl {

    private JJITExpression condition;
    private JJITExpression trueExpression;
    private JJITExpression falseExpression;

    public JJITOp3(JJITExpression exp, JJITExpression trueExpression, JJITExpression falseExpression) {
        this.condition = exp.copy();
        this.trueExpression = trueExpression.copy();
        this.falseExpression = falseExpression.copy();
        this.condition.setParent(this);
        this.trueExpression.setParent(this);
        this.falseExpression.setParent(this);
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        condition=simplifyChild(condition,fields, varsMap);
        trueExpression=simplifyChild(trueExpression,fields, varsMap);
        falseExpression=simplifyChild(falseExpression,fields, varsMap);
        if(condition.equals(JJITConstant.TRUE)){
            return trueExpression;
        }else if(condition.equals(JJITConstant.FALSE)){
            return falseExpression;
        }
        return this;
    }

    public TypeStruct getExpressionType() {
        return trueExpression.getExpressionType();
    }
    

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITOp3 other = (JJITOp3) o;
        if (       !JJITPatternUtils.matches(condition, other.condition,ee)
                || !JJITPatternUtils.matches(trueExpression, other.trueExpression, ee)
                || !JJITPatternUtils.matches(falseExpression, other.falseExpression, ee)) {
            return null;
        }
        return ee;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list0 = new JJITVarUsageList();
        list0.addAll(condition.getVarUsage(names));


        JJITVarUsageList list1 = new JJITVarUsageList();
        for (JJITVarUsage o : trueExpression.getVarUsage(names)) {
            if(o.isConditional()){
                list1.add(o);
            }else{
                list1.add(new JJITVarUsage(o.getVar(), o.getType(), true));
            }
        }
        if (falseExpression != null) {
            JJITVarUsageList list2 = new JJITVarUsageList();
            for (JJITVarUsage o : falseExpression.getVarUsage(names)) {
                if(o.isConditional()){
                    list2.add(o);
                }else{
                    list2.add(new JJITVarUsage(o.getVar(), o.getType(), true));
                }
            }
            list1.combine(list2);
        }

        list0.addAll(list1);
        return list0;
    }

//    public boolean isReadVar(String name) {
//        return expression.isReadVar(name) || ok.isReadVar(name) || ko.isReadVar(name);
//    }
//
//    public boolean isWriteVar(String name) {
//        return expression.isWriteVar(name) || ok.isWriteVar(name) || ko.isWriteVar(name);
//    }

    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>();
        c.add(condition);
        c.add(trueExpression);
        c.add(falseExpression);
        return c;
    }

    public JJITExpression getCondition() {
        return condition;
    }

    public JJITExpression getTrueExpression() {
        return trueExpression;
    }

    public JJITExpression getFalseExpression() {
        return falseExpression;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        return new JJITOp3(condition.replace(a,b), trueExpression.replace(a,b), falseExpression.replace(a,b));
    }

    public JJITExpression copy() {
        return new JJITOp3(condition, trueExpression, falseExpression);
    }
    

    public void write(PrintStream out) {
        out.print("(");
        out.print("(");
        condition.write(out);
        out.print(")?(");
        trueExpression.write(out);
        out.print("):(");
        falseExpression.write(out);
        out.print("))");
        //out.print(";");
    }

    public void write(PrintWriter out) {
        out.print("(");
        out.print("(");
        condition.write(out);
        out.print(")?(");
        trueExpression.write(out);
        out.print("):(");
        falseExpression.write(out);
        out.print("))");
        //out.print(";");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJITOp3 jjitOp3 = (JJITOp3) o;

        if (condition != null ? !condition.equals(jjitOp3.condition) : jjitOp3.condition != null) return false;
        if (falseExpression != null ? !falseExpression.equals(jjitOp3.falseExpression) : jjitOp3.falseExpression != null) return false;
        if (trueExpression != null ? !trueExpression.equals(jjitOp3.trueExpression) : jjitOp3.trueExpression != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = condition != null ? condition.hashCode() : 0;
        result = 31 * result + (trueExpression != null ? trueExpression.hashCode() : 0);
        result = 31 * result + (falseExpression != null ? falseExpression.hashCode() : 0);
        return result;
    }
}
