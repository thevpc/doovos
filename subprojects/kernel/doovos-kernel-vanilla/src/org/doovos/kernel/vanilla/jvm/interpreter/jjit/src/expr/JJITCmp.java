/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITCmpOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 * @author vpc
 */
public class JJITCmp extends JJITExpressionImpl {

    private JJITCmpOp op;
    private JJITExpression opr1;
    private JJITExpression opr2;

    public JJITCmp(JJITCmpOp op, JJITExpression a, JJITExpression b) {
        this.op = op;
        this.opr1 = a == null ? JJITConstant.NULL.copy() : a.copy();
        this.opr1.setParent(this);
        this.opr2 = b == null ? JJITConstant.NULL.copy() : b.copy();
        this.opr2.setParent(this);
    }

    public TypeStruct getExpressionType() {
        return Types.BOOLEAN;
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        this.opr1 = simplifyChild(opr1,fields,varsMap);
        this.opr2 = simplifyChild(opr2,fields,varsMap);

        switch (op){
            case OR:{
                if(opr1.equals(JJITConstant.FALSE)){
                    return opr2;
                }
                if(opr2.equals(JJITConstant.FALSE)){
                    return opr1;
                }
                if(opr1.equals(JJITConstant.TRUE) || opr2.equals(JJITConstant.TRUE)){
                    return JJITConstant.TRUE;
                }
                break;
            }
            case AND:{
                if(opr1.equals(JJITConstant.TRUE)){
                    return opr2;
                }
                if(opr2.equals(JJITConstant.TRUE)){
                    return opr1;
                }
                if(opr1.equals(JJITConstant.FALSE) || opr2.equals(JJITConstant.FALSE)){
                    return JJITConstant.FALSE;
                }
                break;
            }
        }
        return this;
    }

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITCmp other = (JJITCmp) o;
        if (       !JJITPatternUtils.matchesObj(op, other.op)
                || !JJITPatternUtils.matches(opr1, other.opr1, ee)
                || !JJITPatternUtils.matches(opr2, other.opr2, ee)) {
            return null;
        }
        return ee;
    }

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list=new JJITVarUsageList();
        list.addAll(opr1.getVarUsage(names));
        list.addAll(opr2.getVarUsage(names));
        return list;
    }
    
    

//    @Override
//    public boolean isReadVar(String name) {
//        return opr1.isReadVar(name) || opr2.isReadVar(name);
//    }
//
//    @Override
//    public boolean isWriteVar(String name) {
//        return opr1.isWriteVar(name) || opr2.isWriteVar(name);
//    }

    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>();
        c.add(opr1);
        c.add(opr2);
        return c;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (this.equals(a)) {
            return b.copy();
        }
        return new JJITCmp(op, opr1.replace(a, b), opr2.replace(a, b));
    }

    public JJITExpression copy() {
        return new JJITCmp(op, opr1, opr2);
    }

    public void write(PrintStream out) {
        opr1.write(out);
        switch (op) {
            case LT: {
                out.print(" < ");
                break;
            }
            case GT: {
                out.print(" > ");
                break;
            }
            case GE: {
                out.print(" >= ");
                break;
            }
            case LE: {
                out.print(" <= ");
                break;
            }
            case EQ: {
                out.print(" == ");
                break;
            }
            case NE: {
                out.print(" != ");
                break;
            }
            case OR: {
                out.print(" || ");
                break;
            }
            case AND: {
                out.print(" && ");
                break;
            }
            default: {
                throw new IllegalArgumentException("Unsupported op int " + getClass());
            }
        }
        opr2.write(out);
    }

    public void write(PrintWriter out) {
        opr1.write(out);
        switch (op) {
            case LT: {
                out.print(" < ");
                break;
            }
            case GT: {
                out.print(" > ");
                break;
            }
            case GE: {
                out.print(" >= ");
                break;
            }
            case LE: {
                out.print(" <= ");
                break;
            }
            case EQ: {
                out.print(" == ");
                break;
            }
            case NE: {
                out.print(" != ");
                break;
            }
            case OR: {
                out.print(" || ");
                break;
            }
            case AND: {
                out.print(" && ");
                break;
            }
            default: {
                throw new IllegalArgumentException("Unsupported op int " + getClass());
            }
        }
        opr2.write(out);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JJITCmp jjitCmp = (JJITCmp) o;

        if (op != jjitCmp.op) {
            return false;
        }
        if (opr1 != null ? !opr1.equals(jjitCmp.opr1) : jjitCmp.opr1 != null) {
            return false;
        }
        if (opr2 != null ? !opr2.equals(jjitCmp.opr2) : jjitCmp.opr2 != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = op != null ? op.hashCode() : 0;
        result = 31 * result + (opr1 != null ? opr1.hashCode() : 0);
        result = 31 * result + (opr2 != null ? opr2.hashCode() : 0);
        return result;
    }
}
