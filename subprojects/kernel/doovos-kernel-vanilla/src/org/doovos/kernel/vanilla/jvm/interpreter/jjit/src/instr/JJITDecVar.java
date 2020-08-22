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
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITDecVar extends JJITInstrImpl {

    private TypeStruct type;
    private String name;
    private JJITExpression expression;

    public JJITDecVar(TypeStruct type, String name, JJITExpression expression) {
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

    public JJITVarUsageList getVarUsage(String... names) {
        JJITVarUsageList found = new JJITVarUsageList();
        found.addAll(expression.getVarUsage(names));
        for (String _name : names) {
            if (this.name.equals(_name)) {
                found.add(new JJITVarUsage(new JJITName(_name,Object.class.getName()), JJITVarUsageType.WRITE));
            }
        }
        return found;
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
    @Override
    public Collection<JJITExpression> getExpressions() {
        ArrayList<JJITExpression> all = new ArrayList<JJITExpression>();
        if (expression != null) {
            all.add(expression);
            all.addAll(expression.getDeepChildren());
        }
        return all;
    }

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b) {
        return new JJITDecVar(type, name, expression.replace(a, b));
    }

    public void writeSource(PrintStream out, JavaSourceLayout layout) {
        out.print(layout.getIndent());
        if (expression != null) {
            out.print(type.getSimpleName() + " " + name);
//              name.writeSource(out, "");
            out.print(" = ");
            expression.write(out);
            out.print(";");
        } else {
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
            out.print(type.getSimpleName() + " " + name);
//              name.writeSource(out, "");
            out.print(" = ");
            expression.write(out);
            out.print(";");
        } else {
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

    public TypeStruct getExpressionType() {
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
        final JJITDecVar other = (JJITDecVar) obj;
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
