/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

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
public class JJITExprInstr extends JJITInstrImpl {

    private JJITExpression expression;

    public JJITExprInstr(JJITExpression e) {
        this.expression = e;
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        this.expression=expression.simplify(fields, varsMap);
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return expression.getVarUsage(names);
    }



    public List<JJITExpression> getRootReadExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        if (expression != null) {
            all.add(expression);
        }
        return all;
    }

//    @Override
//    public boolean isVarRead(String name) {
//        return expression.isReadVar(name);
//    }
//
//    @Override
//    public boolean isVarUpdated(String name) {
//        return expression.isWriteVar(name);
//    }

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        return new JJITExprInstr(expression.replace(a, b));
    }

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        expression.write(out);
        out.print(";");
        if (layout.isNewLine()) {
            out.println();
        }
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        expression.write(out);
        out.print(";");
        if (layout.isNewLine()) {
            out.println();
        }
    }

    @Override
    public Collection<JJITExpression> getExpressions() {
        Collection<JJITExpression> all = new ArrayList<JJITExpression>();
        all.add(expression);
        all.addAll(expression.getDeepChildren());
        return all;
    }
}
