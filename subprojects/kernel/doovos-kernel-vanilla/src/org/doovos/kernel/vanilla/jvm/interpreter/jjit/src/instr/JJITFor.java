/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;

/**
 *
 * @author vpc
 */
public class JJITFor extends JJITBloc {

    private JJITInstr declaration;
    private JJITExpression cond;
    private JJITExpression inc;

    protected JJITFor(JJITInstr dec, JJITExpression cond, JJITExpression inc, List<JJITInstr> list) {
        super(list);
        this.declaration = dec;
        this.cond = cond;
        this.inc = inc;
    }

    @Override
    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList found = new JJITVarUsageList();
        found.addAll(declaration.getVarUsage(names));
        found.addAll(cond.getVarUsage(names));
        found.addAll(inc.getVarUsage(names));
        for (JJITInstr ii : list) {
            found.addAll(ii.getVarUsage(names));
        }
        return found;
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        declaration=declaration.simplify(fields, varsMap);
        cond=cond.simplify(fields, varsMap);
        inc=inc.simplify(fields, varsMap);
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).simplify(fields, varsMap));
        }
        return this;
    }

    @Override
    public List<JJITExpression> getRootReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        all.addAll(declaration.getRootReadExpressions());
        all.add(cond);
        all.add(inc);
        all.addAll(super.getRootReadExpressions());
        return all;
    }

    public JJITFor(JJITInstr dec, JJITExpression cond, JJITExpression inc) {
        this.declaration = dec;
        this.cond = cond;
        this.inc = inc;
    }

//    @Override
//    public boolean isVarRead(String name) {
//        if (declaration.isVarRead(name) || cond.isReadVar(name) || inc.isReadVar(name)) {
//            return true;
//        }
//        return super.isVarRead(name);
//    }
//
//    @Override
//    public boolean isVarUpdated(String name) {
//        if (declaration.isVarUpdated(name) || cond.isWriteVar(name) || inc.isWriteVar(name)) {
//            return true;
//        }
//        return super.isVarUpdated(name);
//    }

    @Override
    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {

        JJITInstr dec2 = declaration.replaceReads(a, b);
        JJITExpression cond2 = cond.replace(a, b);
        JJITExpression inc2 = inc.replace(a, b);
        List<JJITInstr> list2 = new ArrayList<JJITInstr>();
        for (JJITInstr i : list) {
            list2.add(i.replaceReads(a, b));
        }
        return new JJITFor(dec2, cond2, inc2, list2);
    }

    @Override
    public Collection<JJITExpression> getExpressions() {
        final Collection<JJITExpression> expressions = super.getExpressions();
        if (declaration != null) {
            expressions.addAll(declaration.getExpressions());
        }
        if (cond != null) {
            expressions.add(cond);
            expressions.addAll(cond.getDeepChildren());
        }
        if (inc != null) {
            expressions.add(inc);
            expressions.addAll(inc.getDeepChildren());
        }
        return expressions;
    }

    @Override
    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        out.print(layout.getIndent() + "for(");
        if (declaration != null) {
            JavaSourceLayout inlinedLayout = layout.copy();
            inlinedLayout.setIndent("");
            declaration.writeSource(out, inlinedLayout);
        } else {
            out.print(";");
        }
        if (cond != null) {
            cond.write(out);
        }
        out.print(";");
        if (inc != null) {
            inc.write(out);
        }
        out.println("){");
        super.writeSource(out, layout);
        out.println(layout.getIndent() + "}");
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        out.print(layout.getIndent() + "for(");
        if (declaration != null) {
            JavaSourceLayout inlinedLayout = layout.copy();
            inlinedLayout.setIndent("");
            inlinedLayout.setNewLine(false);
            declaration.writeSource(out, inlinedLayout);
        } else {
            out.print(";");
        }
        if (cond != null) {
            cond.write(out);
        }
        out.print(";");
        if (inc != null) {
            inc.write(out);
        }
        out.println("){");
        super.writeSource(out, layout);
        out.println(layout.getIndent() + "}");
    }
}
