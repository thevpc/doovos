/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;

/**
 *
 * @author vpc
 */
public interface JJITInstr {

    public void writeSource(PrintWriter out, JavaSourceLayout layout);

    public void writeSource(PrintStream out, JavaSourceLayout layout);

    public JJITInstr replaceReads(JJITExpression a, JJITExpression b);
    //public void writeByteCode(ClassStream out);

    public Collection<JJITExpression> getExpressions();

    public boolean contains(JJITExpression expr);
    
    public JJITVarUsageList getVarUsage(String ... names);
    
//    public boolean isReadBeforeUpdate(String readName,String updateName);
    
//    public boolean isVarRead(String name);
//    
//    public boolean isVarUpdated(String name);

//    public boolean isVarContentUpdated(String n);

//    public int getVarReadCount(String name);

    public JJITExpression[] getReadExpressions(JJITExpression n);
    
    public  boolean containsReadExpressions(JJITExpression n) ;

    public JJITExpression[] getReadExpressions() ;
    
    public List<JJITExpression> getRootReadExpressions() ;

    public Set<String> getReadVars() ;

    public JJITInstr simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap);
}
