/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 * @author vpc
 */
public class JJITDecField extends JJITInstrImpl {

    private int modifiers;
    private TypeStruct type;
    private String name;
    private JJITExpression expression;

    public JJITDecField(int modifiers,TypeStruct type, String name, JJITExpression expression) {
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
        this.expression = expression;
    }

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        if(expression!=null){
            expression=expression.simplify(fields, varsMap);
        }
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return new JJITVarUsageList();
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
//        return name.equals(name) | expression.isWriteVar(name);
//    }

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        return new JJITDecField(modifiers,type, name, expression.replace(a, b));
    }

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
        if (expression != null) {
            out.print(Modifier.toString(modifiers)+ " ");
            out.print(type.getSimpleName() + " " + name);
//              name.writeSource(out, "");
            out.print(" = ");
            expression.write(out);
            out.print(";");
        } else {
            out.print(Modifier.toString(modifiers)+ " ");
            out.print(type.getSimpleName() + " " + name);
//              name.writeSource(out, "");
            out.print(";");
        }
        if (layout.isNewLine()) {
            out.println();
        }
    }

    public void writeSource(PrintWriter out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        if (expression != null) {
            out.print(Modifier.toString(modifiers)+ " ");
            out.print(type.getSimpleName() + " " + name);
//              name.writeSource(out, "");
            out.print(" = ");
            expression.write(out);
            out.print(";");
        } else {
            out.print(Modifier.toString(modifiers)+ " ");
            out.print(type.getSimpleName() + " " + name);
//              name.writeSource(out, "");
            out.print(";");
        }
        if (layout.isNewLine()) {
            out.println();
        }
    }

    public JJITExpression getExpression() {
        return expression;
    }

    public String getName() {
        return name;
    }

    public TypeStruct getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJITDecField other = (JJITDecField) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
}
