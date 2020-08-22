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

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITConverter;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.FieldStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITField extends JJITExpressionImpl {

    private JJITExpression ref;
    private FieldStruct field;

    public JJITField(JJITExpression var, FieldStruct field) {
        this.ref = var.copy();
        this.ref.setParent(this);
        this.field = field;
    }

    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        ref=simplifyChild(ref,fields, varsMap);
        if (field.getFieldName().equals("value")) {
            JJITExpression var = ref;
            if (var instanceof JJITCast) {
                // ((KDouble)new KDouble(?)).value
                //      ==> ?
                JJITCast cc = (JJITCast) var;
                if (cc.getExpressionType().equals(Types.KDOUBLE) && cc.getVar() instanceof JJITNew) {
                    JJITNew oonew = (JJITNew) cc.getVar();
                    if (oonew.getType().equals(Types.KDOUBLE)) {
                        return oonew.getArgs()[0];
                    }
                }
            } else if (var instanceof JJITNew) {
                JJITNew oonew = (JJITNew) var;
                if (oonew.getType().equals(Types.KDOUBLE)) {
                    //replace new  : KFloat(expr).value
                    //replace with : expr
                    return JJITConverter.convert(oonew.getArg(0),Types.DOUBLE);
                } else if (oonew.getType().equals(Types.KFLOAT)) {
                    //replace new  : KFloat(expr).value
                    //replace with : expr
                    return JJITConverter.convert(oonew.getArg(0),Types.FLOAT);
                }

//            } else if (var instanceof JJITNew) {
//                // new KFloat(?.intValue()).value
//                //      ==> ?.floatValue()
//                JJITNew knew = (JJITNew) var;
//                if (knew.getType().equals(Types.KFLOAT)) {
//                    JJITExpression a0 = knew.getArg(0);
//                    if (a0 instanceof JJITCall && ((JJITCall) a0).getMethod().equals(Calls.KRegister_intValue)) {
//                        ii = simplifyReplacement(ii, e, new JJITCall(((JJITCall) a0).getVar(), Calls.KRegister_floatValue));
//                        replacement = true;
//                        break;
//                    }
//                }
            }
        }
       return this;
    }

    public TypeStruct getExpressionType() {
        return field.getType();
    }

    
    public JJITVarUsageList getVarUsage(String ... names) {
        return ref.getVarUsage(names);
    }
    
    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITField other = (JJITField) o;
        if (
                !JJITPatternUtils.matches(ref, other.ref,ee)
                || !JJITPatternUtils.matches(field, other.field)
                ) {
            return null;
        }
        return ee;
    }

//    public boolean isReadVar(String name) {
//        return ref.isReadVar(name);
//    }
//
//    public boolean isWriteVar(String name) {
//        return field.equals(name) || ref.isWriteVar(name);
//    }
    
    

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if(a.equals(this)){
            return b.copy();
        }
        return new JJITField(ref.replace(a,b),field);
    }

    public JJITExpression copy() {
        return new JJITField(ref,field);
    }

    
    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c=new ArrayList<JJITExpression>();
        c.add(ref);
        return c;
    }

    public FieldStruct getField() {
        return field;
    }

    public JJITExpression getVar() {
        return ref;
    }

    public void write(PrintStream out) {
        ref.write(out);
        out.print(".");
        out.print(field.getFieldName());
    }

    public void write(PrintWriter out) {
        ref.write(out);
        out.print(".");
        out.print(field.getFieldName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJITField that = (JJITField) o;

        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (ref != null ? !ref.equals(that.ref) : that.ref != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ref != null ? ref.hashCode() : 0;
        result = 31 * result + (field != null ? field.hashCode() : 0);
        return result;
    }
}
