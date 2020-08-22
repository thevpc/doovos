/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITPatternAny extends JJITPattern {
    private int id;
    public JJITPatternAny(int index) {
        this.id=index;
    }

    public TypeStruct getExpressionType() {
        return Types.VOID;
    }
    
    

    public JJITVarUsageList getVarUsage(String ... names) {
        return new JJITVarUsageList();
    }

    public boolean isReadVar(String name) {
        return false;
    }

    public boolean isWriteVar(String name) {
        return false;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        return copy();
    }

    public JJITExpression copy() {
        return new JJITPatternAny(id);
    }

    public Collection<JJITExpression> getChildren() {
        return new ArrayList<JJITExpression>();
    }

    public void write(PrintStream out) {
        out.print("<"+id+"?>");
    }

    public void write(PrintWriter out) {
        out.print("<"+id+"?>");
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return index;
//    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJITPatternAny other = (JJITPatternAny) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    public Map<JJITPattern,JJITExpression> matches(JJITExpression o) {
        if(o instanceof JJITPatternAny){
            HashMap<JJITPattern,JJITExpression> a=new HashMap<JJITPattern, JJITExpression>();
            a.put((JJITPatternAny)o, this);
            return a;
        }
        return null;
    }

    @Override
    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
