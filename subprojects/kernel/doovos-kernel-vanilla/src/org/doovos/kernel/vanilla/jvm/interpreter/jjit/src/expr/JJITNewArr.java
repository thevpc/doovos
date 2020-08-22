/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
public class JJITNewArr extends JJITExpressionImpl {

    private JJITType elementType;
    private JJITExpression[] args;

    public JJITNewArr(JJITType expr, JJITExpression... args) {
        this.elementType = (JJITType)expr.copy();
        elementType.setParent(this);
        this.args = new JJITExpression[args.length];
        for (int i = 0; i < args.length; i++) {
            this.args[i] = (args[i] == null) ? JJITConstant.NULL.copy() : args[i].copy();
            this.args[i].setParent(this);
        }
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        //elementType =simplifyChild(elementType, fields, varsMap);
        for (int i = 0; i < args.length; i++) {
            args[i]=args[i].simplify(fields, varsMap);
        }
        return this;
    }

    public TypeStruct getExpressionType() {
        return elementType.getValue();
    }
    

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list = new JJITVarUsageList();
        list.addAll(elementType.getVarUsage(names));
        for (JJITExpression a : args) {
            list.addAll(a.getVarUsage(names));
        }
        return list;
    }
    
    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITNewArr other = (JJITNewArr) o;
        if (
                   !JJITPatternUtils.matches(args, other.args, ee)
                || !JJITPatternUtils.matches(elementType, other.elementType, ee)) {
            return null;
        }
        return ee;
    }

//    public boolean isReadVar(String name) {
//        for (int i = 0; i < args.length; i++) {
//            if (args[i].isReadVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean isWriteVar(String name) {
//        for (int i = 0; i < args.length; i++) {
//            if (args[i].isReadVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }
    
    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>();
        c.add(elementType);
        c.addAll(Arrays.asList(args));
        return c;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (elementType.equals(a)) {
            elementType = (JJITType)b.copy();
        }
        JJITExpression[] args2=new JJITExpression[args.length];
        for (int i = 0; i < args2.length; i++) {
            args2[i]=args[i].replace(a,b);
        }
        return new JJITNewArr((JJITType) elementType.replace(a,b),args2);
    }

    public JJITExpression copy() {
        return new JJITNewArr(elementType,args);
    }

    
    public void write(PrintStream out) {
        out.print("new ");
        elementType.write(out);
        for (int i = 0; i < args.length; i++) {
            out.print("[");
            if (args[i] != null) {
                args[i].write(out);
            }
            out.print("]");
        }
    }

    public void write(PrintWriter out) {
        out.print("new ");
        elementType.write(out);
        for (int i = 0; i < args.length; i++) {
            out.print("[");
            if (args[i] != null) {
                args[i].write(out);
            }
            out.print("]");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJITNewArr that = (JJITNewArr) o;

        if (!Arrays.equals(args, that.args)) return false;
        if (elementType != null ? !elementType.equals(that.elementType) : that.elementType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = elementType != null ? elementType.hashCode() : 0;
        result = 31 * result + (args != null ? Arrays.hashCode(args) : 0);
        return result;
    }
}
