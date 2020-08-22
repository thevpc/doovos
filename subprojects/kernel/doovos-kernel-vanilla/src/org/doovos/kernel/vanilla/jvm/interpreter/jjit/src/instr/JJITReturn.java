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
public class JJITReturn extends JJITInstrImpl {

    private JJITExpression expression;

    public JJITReturn(JJITExpression exp) {
        this.expression = exp;
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        if(expression!=null){
            expression=expression.simplify(fields, varsMap);
        }
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
    
    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        return new JJITReturn(expression.replace(a,b));
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
    
    

    @Override
    public Collection<JJITExpression> getExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        if (expression != null) {
            all.add(expression);
            all.addAll(expression.getDeepChildren());
        }
        return all;
    }

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        if (expression == null) {
            out.print("return;");
        } else {
            out.print("return ");
            expression.write(out);
            out.print(";");
        }
        if (layout.isNewLine()) {
            out.println();
        }
    }
    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        if (expression == null) {
            out.print("return;");
        } else {
            out.print("return ");
            expression.write(out);
            out.print(";");
        }
        if (layout.isNewLine()) {
            out.println();
        }
    }
}
