/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;

/**
 *
 * @author vpc
 */
public class JJITIf extends JJITInstrImpl {

    private JJITExpression condition;
    private JJITBloc trueBloc;
    private JJITBloc falseBloc;

    public JJITIf(JJITExpression expression, JJITBloc trueBloc, JJITBloc falseBloc) {
        this.condition = expression;
        this.trueBloc = trueBloc;
        this.falseBloc = falseBloc;
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        condition=condition.simplify(fields, varsMap);
        trueBloc=(JJITBloc) trueBloc.simplify(fields, varsMap);
        falseBloc=falseBloc==null?null:(JJITBloc) falseBloc.simplify(fields, varsMap);
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list0 = new JJITVarUsageList();
        list0.addAll(condition.getVarUsage(names));


        JJITVarUsageList list1 = new JJITVarUsageList();
        for (JJITVarUsage o : trueBloc.getVarUsage(names)) {
            if(o.isConditional()){
                list1.add(o);
            }else{
                list1.add(new JJITVarUsage(o.getVar(), o.getType(), true));
            }
        }
        if (falseBloc != null) {
            JJITVarUsageList list2 = new JJITVarUsageList();
            for (JJITVarUsage o : falseBloc.getVarUsage(names)) {
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

    public List<JJITExpression> getRootReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        all.add(condition);
        all.addAll(trueBloc.getRootReadExpressions());
        if (falseBloc != null) {
            all.addAll(falseBloc.getRootReadExpressions());
        }
        return all;
    }

    @Override
    public JJITExpression[] getReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        all.addAll(condition.getAllExpressions());
        if (trueBloc != null) {
            all.addAll(Arrays.asList(trueBloc.getReadExpressions()));
        }
        if (falseBloc != null) {
            all.addAll(Arrays.asList(falseBloc.getReadExpressions()));
        }
        return all.toArray(new JJITExpression[all.size()]);
    }

//    @Override
//    public boolean isVarRead(String name) {
//        return condition.isReadVar(name) || (validBloc != null && validBloc.isVarRead(name)) || (invalidBloc != null && invalidBloc.isVarRead(name));
//    }
//
//    @Override
//    public boolean isVarUpdated(String name) {
//        return condition.isWriteVar(name) || (validBloc != null && validBloc.isVarUpdated(name)) || (invalidBloc != null && invalidBloc.isVarUpdated(name));
//    }

    @Override
    public Collection<JJITExpression> getExpressions() {
        final Collection<JJITExpression> expressions = new ArrayList<JJITExpression>();
        expressions.add(condition);
        expressions.addAll(condition.getDeepChildren());
        if (trueBloc != null) {
            expressions.addAll(trueBloc.getExpressions());
        }
        if (falseBloc != null) {
            expressions.addAll(falseBloc.getExpressions());
        }
        return expressions;
    }

    public JJITBloc Else() {
        return falseBloc;
    }

    public JJITBloc Then() {
        return trueBloc;
    }

    public JJITIf ElseIf(JJITExpression cond) {
        return falseBloc.If(cond);
    }

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        JJITExpression expression2 = condition.replace(a, b);
        JJITBloc validBloc2 = (JJITBloc) ((trueBloc == null) ? null : trueBloc.replaceReads(a, b));
        JJITBloc invalidBloc2 = (JJITBloc) ((falseBloc == null) ? null : falseBloc.replaceReads(a, b));
        return new JJITIf(expression2, validBloc2, invalidBloc2);
    }

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        out.print(layout.getIndent() + "if(");
        condition.write(out);
        out.println("){");
        JavaSourceLayout sub = layout.indent(2);
        trueBloc.writeSource(out, sub);
        if (falseBloc != null && falseBloc.list.size() > 0) {
            out.println(layout.getIndent() + "}else{");
            falseBloc.writeSource(out, sub);
            out.println(layout.getIndent() + "}");
        } else {
            out.println(layout.getIndent() + "}");
        }
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        out.print(layout.getIndent() + "if(");
        condition.write(out);
        out.println("){");
        JavaSourceLayout sub = layout.indent(2);
        trueBloc.writeSource(out, sub);
        if (falseBloc != null && falseBloc.list.size() > 0) {
            out.println(layout.getIndent() + "}else{");
            falseBloc.writeSource(out, sub);
            out.println(layout.getIndent() + "}");
        } else {
            out.println(layout.getIndent() + "}");
        }
    }

    public JJITExpression getCondition() {
        return condition;
    }
}
