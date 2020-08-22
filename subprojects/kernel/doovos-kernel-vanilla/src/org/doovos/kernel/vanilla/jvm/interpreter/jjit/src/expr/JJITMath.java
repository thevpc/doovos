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
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMathOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITMath extends JJITExpressionImpl {

    private JJITMathOp op;
    private JJITExpression opr1;
    private JJITExpression opr2;

    public JJITMath(JJITMathOp op, JJITExpression a, JJITExpression b) {
        this.op = op;
        this.opr1 = a == null ? JJITConstant.NULL.copy() : a.copy();
        this.opr2 = b == null ? JJITConstant.NULL.copy() : b.copy();
        this.opr1.setParent(this);
        this.opr2.setParent(this);
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        opr1=simplifyChild(opr1,fields, varsMap);
        opr2=simplifyChild(opr2,fields, varsMap);
        if(opr1 instanceof JJITConstant && opr2 instanceof JJITConstant){
            //TODO fix me
        }
        return this;
    }

    public TypeStruct getExpressionType() {
        TypeStruct t1 = opr1.getExpressionType();
        TypeStruct t2 = opr2.getExpressionType();
        if(t1.equals(t2)){
            return t1;
        }else if(is(t1,t2, Types.DOUBLE)){
            return Types.DOUBLE;
        }else if(is(t1,t2, Types.FLOAT, Types.LONG)){
            return Types.FLOAT;
        }else if(is(t1,t2, Types.FLOAT, Types.INT)){
            return Types.FLOAT;
        }else if(is(t1,t2, Types.FLOAT, Types.SHORT)){
            return Types.FLOAT;
        }else if(is(t1,t2, Types.FLOAT, Types.BYTE)){
            return Types.FLOAT;
        }else if(is(t1,t2, Types.FLOAT, Types.CHAR)){
            return Types.FLOAT;
        }else if(is(t1,t2, Types.LONG, Types.INT)){
            return Types.LONG;
        }else if(is(t1,t2, Types.LONG, Types.SHORT)){
            return Types.LONG;
        }else if(is(t1,t2, Types.LONG, Types.BYTE)){
            return Types.LONG;
        }else if(is(t1,t2, Types.LONG, Types.CHAR)){
            return Types.LONG;
        }else if(is(t1,t2, Types.INT, Types.SHORT)){
            return Types.INT;
        }else if(is(t1,t2, Types.INT, Types.BYTE)){
            return Types.INT;
        }else if(is(t1,t2, Types.INT, Types.CHAR)){
            return Types.INT;
        }else{
            throw new IllegalArgumentException("Unsupported");
        }
    }
    
    private boolean is(TypeStruct t1,TypeStruct t2,TypeStruct a){
        if(t1.equals(a) || t2.equals(a)){
            return true;
        }
        return false;
    }
    private boolean is(TypeStruct t1,TypeStruct t2,TypeStruct a,TypeStruct b){
        if(t1.equals(a) && t2.equals(b)){
            return true;
        }
        if(t1.equals(b) && t2.equals(a)){
            return true;
        }
        return false;
    }
    
    

    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list=new JJITVarUsageList();
        list.addAll(opr1.getVarUsage(names));
        list.addAll(opr2.getVarUsage(names));
        return list;
    }

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITMath other = (JJITMath) o;
        if (       !JJITPatternUtils.matchesObj(op, other.op)
                || !JJITPatternUtils.matches(opr1, other.opr1, ee)
                || !JJITPatternUtils.matches(opr2, other.opr2, ee)) {
            return null;
        }
        return ee;
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
        ArrayList<JJITExpression> c=new ArrayList<JJITExpression>();
        c.add(opr1);
        c.add(opr2);
        return c;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (this.equals(a)) {
            return b.copy();
        }
        return new JJITMath(op, opr1.replace(a, b), opr2.replace(a, b));
    }

    public JJITExpression copy() {
        return new JJITMath(op, opr1, opr2);
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJITMath jjitMath = (JJITMath) o;

        if (opr1 != null ? !opr1.equals(jjitMath.opr1) : jjitMath.opr1 != null) return false;
        if (opr2 != null ? !opr2.equals(jjitMath.opr2) : jjitMath.opr2 != null) return false;
        if (op != jjitMath.op) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = op != null ? op.hashCode() : 0;
        result = 31 * result + (opr1 != null ? opr1.hashCode() : 0);
        result = 31 * result + (opr2 != null ? opr2.hashCode() : 0);
        return result;
    }

    public void write(PrintStream out) {
        out.print("(");
        opr1.write(out);
        switch (op) {
            case REM: {
                out.print(" % ");
                break;
            }
            case USHR: {
                out.print(" >>> ");
                break;
            }
            case SHL: {
                out.print(" << ");
                break;
            }
            case SHR: {
                out.print(" >> ");
                break;
            }
            case OR: {
                out.print(" | ");
                break;
            }
            case AND: {
                out.print(" & ");
                break;
            }
            case XOR: {
                out.print(" ^ ");
                break;
            }
            case ADD: {
                out.print(" + ");
                break;
            }
            case DIV: {
                out.print(" / ");
                break;
            }
            case MUL: {
                out.print(" * ");
                break;
            }
            case SUB: {
                out.print(" - ");
                break;
            }
            default:{
                throw new IllegalArgumentException("Unsupported OP "+op);
            }
        }
        opr2.write(out);
        out.print(")");
    }
    public void write(PrintWriter out) {
        out.print("(");
        opr1.write(out);
        switch (op) {
            case REM: {
                out.print(" % ");
                break;
            }
            case USHR: {
                out.print(" >>> ");
                break;
            }
            case SHL: {
                out.print(" << ");
                break;
            }
            case SHR: {
                out.print(" >> ");
                break;
            }
            case OR: {
                out.print(" | ");
                break;
            }
            case AND: {
                out.print(" & ");
                break;
            }
            case XOR: {
                out.print(" ^ ");
                break;
            }
            case ADD: {
                out.print(" + ");
                break;
            }
            case DIV: {
                out.print(" / ");
                break;
            }
            case MUL: {
                out.print(" * ");
                break;
            }
            case SUB: {
                out.print(" - ");
                break;
            }
            default:{
                throw new IllegalArgumentException("Unsupported OP "+op);
            }
        }
        opr2.write(out);
        out.print(")");
    }
}
