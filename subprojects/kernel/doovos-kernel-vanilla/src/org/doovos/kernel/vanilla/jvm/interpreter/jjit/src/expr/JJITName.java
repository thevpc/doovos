/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsage;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITName extends JJITExpressionImpl {

    private String name;
    private TypeStruct type;

    public JJITName(String expression,Class type) {
        this(expression, type.getName());
    }
    
    public JJITName(String expression,String type) {
        this.name = expression;
        this.type = new TypeStruct(type);
    }

    public JJITName(String expression,TypeStruct type) {
        this.name = expression;
        this.type = type;
    }

    public TypeStruct getExpressionType() {
        return type;
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        return this;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list=new JJITVarUsageList();
        for (String _name : names) {
            if(this.name.equals(_name)){
                list.add(new JJITVarUsage(this, JJITVarUsageType.READ));
                break;
            }
        }
        return list;
    }

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITName other = (JJITName) o;
        if (!JJITPatternUtils.matches(name, other.name)
                ) {
            return null;
        }
        return ee;
    }

//    @Override
//    public boolean isReadVar(String name) {
//        return this.name.equals(name);
//    }
//
//    @Override
//    public boolean isWriteVar(String name) {
//        return false;
//    }

    public String getValue() {
        return name;
    }

    public Collection<JJITExpression> getChildren() {
        return Collections.EMPTY_LIST;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (this.equals(a)) {
            return b.copy();
        }
        return copy();
    }

    public JJITExpression copy() {
        return new JJITName(name,type);
    }

    public void write(PrintStream out) {
        out.print(name);
    }

    public void write(PrintWriter out) {
        out.print(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJITName other = (JJITName) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public Set<String> getVars() {
        HashSet<String> all = new HashSet<String>();
        all.add(getValue());
        return all;
    }
}
