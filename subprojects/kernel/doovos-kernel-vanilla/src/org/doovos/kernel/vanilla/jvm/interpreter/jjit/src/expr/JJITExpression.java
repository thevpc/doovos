/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITInstr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public interface JJITExpression {

    public JJITExpression copy();

    public JJITExpression getParent();
    
    public TypeStruct getExpressionType();

    public void setParent(JJITExpression parent);

    public JJITExpression replace(JJITExpression a, JJITExpression b);

    public abstract void write(PrintStream out);

    public abstract void write(PrintWriter out);

    public Collection<JJITExpression> getChildren();

    public Collection<JJITExpression> getDeepChildren();

    public Collection<JJITExpression> getAllExpressions();

    public boolean contains(JJITExpression expr);

//    public boolean isReadVar(String name);

//    public boolean isWriteVar(String name);

    public Set<String> getVars();

    public JJITVarUsageList getVarUsage(String... names);

    /**
     * 
     * @param o
     * @return null if no match found or matching expressions
     */
    public Map<JJITPattern, JJITExpression> matches(JJITExpression o);
    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap);
}
