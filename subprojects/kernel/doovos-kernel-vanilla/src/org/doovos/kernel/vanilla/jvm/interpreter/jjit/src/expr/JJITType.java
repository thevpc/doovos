/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
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
public class JJITType extends JJITExpressionImpl{
    private TypeStruct name;

    public JJITType(TypeStruct expression) {
        this.name=expression;
    }
    
//    public JJITType(String expression) {
//        this.name = expression;
//    }

    public JJITVarUsageList getVarUsage(String ... names) {
        return new JJITVarUsageList();
    }

    public TypeStruct getExpressionType() {
        return name;//"java.lang.Class";
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        return this;
    }

    public boolean isReadVar(String name) {
        return false;
    }

    public boolean isWriteVar(String name) {
        return false;
    }
    
     protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITType other = (JJITType) o;
        if (
                   !JJITPatternUtils.matches(name, other.name)){
            return null;
        }
        return ee;
    }
   

    public TypeStruct getValue() {
        return name;
    }

    public Collection<JJITExpression> getChildren() {
        return Collections.EMPTY_LIST;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
//        if (this.equals(a)) {
//            return b.copy();
//        }
        return copy();
    }

    public JJITExpression copy() {
        return new JJITType(name);
    }

    


    public void write(PrintStream out) {
        out.print(name.getSimpleName());
    }

    public void write(PrintWriter out) {
        out.print(name.getSimpleName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJITType other = (JJITType) obj;
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

    
}
