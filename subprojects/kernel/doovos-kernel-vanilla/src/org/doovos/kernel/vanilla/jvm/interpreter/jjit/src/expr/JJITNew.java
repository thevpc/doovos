/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPattern;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.pattern.JJITPatternUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.usage.JJITVarUsageList;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecVar;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

/**
 *
 * @author vpc
 */
public class JJITNew extends JJITExpressionImpl {
    private static final Map<TypeStruct, TypeSimplifier> INLINE_CONSTRUCTORS = new HashMap<TypeStruct, TypeSimplifier>();
    private static interface TypeSimplifier{
        JJITExpression simplify(JJITNew instance, Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap);
    }

    public static class NewKIntegerSimplifier implements TypeSimplifier{
        public JJITExpression simplify(JJITNew instance, Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
            JJITExpression a0 = instance.args[0];
            if (a0 instanceof JJITCall) {
                JJITCall intValue = (JJITCall) a0;
                if (intValue.getMethod().equals(Calls.KRegister_intValue)) {
                    //replace     : new KInteger(x.intValue()) or new KLong(x.longValue()) ...etc
                    //      with : x
                    return intValue.getVar();
                }
            }else if(a0 instanceof JJITConstant){
                JJITConstant c=(JJITConstant) a0;
                int v = ((Number)c.getObject()).intValue();
                if (v == -1) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_M1);
                } else if (v == 0) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_ZERO);
                } else if (v == 1) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_ONE);
                } else if (v == 2) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_TWO);
                } else if (v == 3) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_THREE);
                } else if (v == 4) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_FOUR);
                } else if (v == 5) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_FIVE);
                } else if (v == Integer.MAX_VALUE) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_MAX_VALUE);
                } else if (v == Integer.MIN_VALUE) {
                    return new JJITType(Types.KINTEGER).field(Fields.KInteger_MIN_VALUE);
                }
            }
            return instance;
        }
    }
    public static class NewKLongSimplifier implements TypeSimplifier{
        public JJITExpression simplify(JJITNew instance, Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
            JJITExpression a0 = instance.args[0];
            if (a0 instanceof JJITCall) {
                JJITCall intValue = (JJITCall) a0;
                if (intValue.getMethod().equals(Calls.KRegister_longValue)) {
                    //replace     : new KInteger(x.intValue()) or new KLong(x.longValue()) ...etc
                    //      with : x
                    return intValue.getVar();
                }
            }else if(a0 instanceof JJITConstant){
                JJITConstant c=(JJITConstant) a0;
                long v = ((Number)c.getObject()).longValue();
                if (v == -1L) {
                    return new JJITType(Types.KLONG).field(Fields.KLong_M1);
                } else if (v == 0L) {
                    return new JJITType(Types.KLONG).field(Fields.KLong_ZERO);
                } else if (v == 1L) {
                    return new JJITType(Types.KLONG).field(Fields.KLong_ONE);
                } else if (v == Long.MAX_VALUE) {
                    return new JJITType(Types.KLONG).field(Fields.KLong_MAX_VALUE);
                } else if (v == Long.MIN_VALUE) {
                    return new JJITType(Types.KLONG).field(Fields.KLong_MIN_VALUE);
                }
            }
            return instance;
        }
    }

    public static class NewKDoubleSimplifier implements TypeSimplifier{
        public JJITExpression simplify(JJITNew instance, Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
            JJITExpression a0 = instance.args[0];
            if (a0 instanceof JJITCall) {
                JJITCall intValue = (JJITCall) a0;
                if (intValue.getMethod().equals(Calls.KRegister_doubleValue)) {
                    //replace     : new KInteger(x.intValue()) or new KLong(x.longValue()) ...etc
                    //      with : x
                    return intValue.getVar();
                }
            }else if(a0 instanceof JJITConstant){
                JJITConstant c=(JJITConstant) a0;
                double v = ((Number)c.getObject()).doubleValue();
                if(v==0.0){
                    return new JJITType(Types.KDOUBLE).field(Fields.KDouble_ZERO);
                }else if(v==1.0){
                    return new JJITType(Types.KDOUBLE).field(Fields.KDouble_ONE);
                }else if(v==-1.0){
                    return new JJITType(Types.KDOUBLE).field(Fields.KDouble_M1);
                }else if(v==Double.MAX_VALUE){
                    return new JJITType(Types.KDOUBLE).field(Fields.KDouble_MAX_VALUE);
                }else if(v==Double.MIN_VALUE){
                    return new JJITType(Types.KDOUBLE).field(Fields.KDouble_MIN_VALUE);
                }else if(Double.isInfinite(v)){
                    return new JJITType(Types.KDOUBLE).field(v>0? Fields.KDouble_POSITIVE_INFINITY:Fields.KDouble_NEGATIVE_INFINITY);
                }else if(Double.isNaN(v)){
                    return new JJITType(Types.KDOUBLE).field(Fields.KDouble_NAN);
                }
            }
            return instance;
        }
    }
    public static class NewKFloatSimplifier implements TypeSimplifier{
        public JJITExpression simplify(JJITNew instance, Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
            JJITExpression a0 = instance.args[0];
            if (a0 instanceof JJITCall) {
                JJITCall intValue = (JJITCall) a0;
                if (intValue.getMethod().equals(Calls.KRegister_floatValue)) {
                    //replace     : new KInteger(x.intValue()) or new KLong(x.longValue()) ...etc
                    //      with : x
                    return intValue.getVar();
                }
            }else if(a0 instanceof JJITConstant){
                JJITConstant c=(JJITConstant) a0;
                float v = ((Number)c.getObject()).floatValue();
                if(v==0.0f){
                    return new JJITType(Types.KFLOAT).field(Fields.KFloat_ZERO);
                }else if(v==1.0f){
                    return new JJITType(Types.KFLOAT).field(Fields.KFloat_ONE);
                }else if(v==-1.0f){
                    return new JJITType(Types.KFLOAT).field(Fields.KFloat_M1);
                }else if(v==Float.MAX_VALUE){
                    return new JJITType(Types.KFLOAT).field(Fields.KFloat_MAX_VALUE);
                }else if(v==Float.MIN_VALUE){
                    return new JJITType(Types.KFLOAT).field(Fields.KFloat_MIN_VALUE);
                }else if(Float.isInfinite(v)){
                    return new JJITType(Types.KFLOAT).field(v>0? Fields.KFloat_POSITIVE_INFINITY:Fields.KFloat_NEGATIVE_INFINITY);
                }else if(Float.isNaN(v)){
                    return new JJITType(Types.KFLOAT).field(Fields.KFloat_NAN);
                }
            }
            return instance;
        }
    }
    static {
        INLINE_CONSTRUCTORS.put(Types.KINTEGER, new NewKIntegerSimplifier());
        INLINE_CONSTRUCTORS.put(Types.KDOUBLE, new NewKDoubleSimplifier());
        INLINE_CONSTRUCTORS.put(Types.KLONG, new NewKLongSimplifier());
        INLINE_CONSTRUCTORS.put(Types.KFLOAT, new NewKFloatSimplifier());
    }

    private TypeStruct type;
    private JJITExpression[] args;

//    public JJITNew(Class type, JJITExpression... args) {
//        this(type.getName(),args);
//    }
    
    public JJITNew(TypeStruct type, JJITExpression... args) {
        this.type = type;
        this.args = new JJITExpression[args.length];
        for (int i = 0; i < args.length; i++) {
            this.args[i] = (args[i] == null) ? JJITConstant.NULL.copy() : args[i].copy();
            this.args[i].setParent(this);
        }
    }


    public JJITExpression simplify(Map<String, JJITDecField> fields, Map<String, JJITDecVar> varsMap) {
        for (int i = 0; i < args.length; i++) {
            args[i]=simplifyChild(args[i],fields, varsMap);
        }
        TypeSimplifier mm = INLINE_CONSTRUCTORS.get(type);
        if (mm != null) {
            return mm.simplify(this,fields,varsMap);
        }
        return this;
    }



    public TypeStruct getExpressionType() {
        return type;
    }
    
    
    public JJITVarUsageList getVarUsage(String ... names) {
        JJITVarUsageList list = new JJITVarUsageList();
        for (int i = 0; i < args.length; i++) {
            list.addAll(args[i].getVarUsage(names));
        }
        return list;
    }

    protected Map<JJITPattern, JJITExpression> matchesImpl(JJITExpression o, Map<JJITPattern, JJITExpression> ee) {
        JJITNew other = (JJITNew) o;
        if (!JJITPatternUtils.matches(type, other.type)
                || !JJITPatternUtils.matches(args, other.args, ee)) {
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
//            if (args[i].isWriteVar(name)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public TypeStruct getType() {
        return type;
    }

    public JJITExpression getArg(int i) {
        return args[i];
    }

    public JJITExpression[] getArgs() {
        return args;
    }

    public JJITExpression replace(JJITExpression a, JJITExpression b) {
        if (this.equals(a)) {
            return b.copy();
        }
        JJITExpression[] args2 = new JJITExpression[args.length];
        for (int i = 0; i < args2.length; i++) {
            args2[i] = args[i].replace(a, b);
        }
        return new JJITNew(type, args2);
    }

    public JJITExpression copy() {
        return new JJITNew(type, args);
    }

    public Collection<JJITExpression> getChildren() {
        ArrayList<JJITExpression> c = new ArrayList<JJITExpression>();
        c.addAll(Arrays.asList(args));
        return c;
    }

    public void write(PrintStream out) {
        out.print("new ");
        out.print(type.getSimpleName());
        out.print("(");
        if (args.length > 0) {
            args[0].write(out);
        }
        for (int i = 1; i < args.length; i++) {
            out.print(",");
            args[i].write(out);
        }
        out.print(")");
    }

    public void write(PrintWriter out) {
        out.print("new ");
        out.print(type.getSimpleName());
        out.print("(");
        if (args.length > 0) {
            args[0].write(out);
        }
        for (int i = 1; i < args.length; i++) {
            out.print(",");
            args[i].write(out);
        }
        out.print(")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JJITNew jjitNew = (JJITNew) o;

        if (!Arrays.equals(args, jjitNew.args)) {
            return false;
        }
        if (type != null ? !type.equals(jjitNew.type) : jjitNew.type != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (args != null ? Arrays.hashCode(args) : 0);
        return result;
    }
}
