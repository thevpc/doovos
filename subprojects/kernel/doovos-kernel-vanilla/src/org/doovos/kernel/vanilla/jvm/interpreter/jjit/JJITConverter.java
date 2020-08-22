package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITCall;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITCast;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITNew;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 19/07/11
 * Time: 02:56
 * To change this template use File | Settings | File Templates.
 */
public class JJITConverter {
    private static class Key {
        TypeStruct from;
        TypeStruct to;

        private Key(TypeStruct from, TypeStruct to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (from != null ? !from.equals(key.from) : key.from != null) return false;
            if (to != null ? !to.equals(key.to) : key.to != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = from != null ? from.hashCode() : 0;
            result = 31 * result + (to != null ? to.hashCode() : 0);
            return result;
        }
    }

    private static interface Converter {
        JJITExpression convert(JJITExpression e);
    }

    private static class NoConverter implements Converter {
        public JJITExpression convert(JJITExpression e) {
            return e;
        }
    }

    private static class NewKRegisterConverter implements Converter {
        TypeStruct type;

        private NewKRegisterConverter(TypeStruct type) {
            this.type = type;
        }

        public JJITExpression convert(JJITExpression e) {
            return new JJITNew(type, e);
        }
    }

    private static class CastConverter implements Converter {
        TypeStruct type;

        private CastConverter(TypeStruct type) {
            this.type = type;
        }

        public JJITExpression convert(JJITExpression e) {
            return new JJITCast(e, type);
        }
    }

    private static class SmallIntToIntConverter implements Converter {
        private SmallIntToIntConverter() {
        }

        public JJITExpression convert(JJITExpression e) {
            if(e instanceof JJITCast){
                JJITCast c=(JJITCast) e;
                if(c.getVar().getExpressionType().equals(Types.INT)){
                    return c.getVar();
                }
            }
            return new JJITCast(e, Types.INT);
        }
    }

    private static class MethodCallConverter implements Converter {
        MethodStruct method;

        private MethodCallConverter(MethodStruct method) {
            this.method = method;
        }

        public JJITExpression convert(JJITExpression e) {
            return new JJITCall(e, method);
        }
    }

    private static class PrimitiveConverter implements Converter {
        MethodStruct method;

        private PrimitiveConverter(MethodStruct method) {
            this.method = method;
        }

        public JJITExpression convert(JJITExpression e) {
            if (e instanceof JJITCall) {
                JJITCall call = (JJITCall) e;
                if (Types.isKRegister(call.getVar().getExpressionType())) {
                    return new JJITCall(call.getVar(), method);
                }
            }
            return new JJITCast(e, method.getReturnType());
        }
    }

    private static NoConverter C0 = new NoConverter();
    private static Map<Key, Converter> all = new HashMap<Key, Converter>();

    static {
        all.put(new Key(Types.INT, Types.KINTEGER), new NewKRegisterConverter(Types.KINTEGER));
        all.put(new Key(Types.DOUBLE, Types.KDOUBLE), new NewKRegisterConverter(Types.KDOUBLE));
        all.put(new Key(Types.FLOAT, Types.KFLOAT), new NewKRegisterConverter(Types.KFLOAT));
        all.put(new Key(Types.LONG, Types.KLONG), new NewKRegisterConverter(Types.KLONG));

        all.put(new Key(Types.KINTEGER, Types.INT), new MethodCallConverter(Calls.KRegister_intValue));
        all.put(new Key(Types.KREGISTER, Types.INT), new MethodCallConverter(Calls.KRegister_intValue));
        all.put(new Key(Types.KDOUBLE, Types.DOUBLE), new MethodCallConverter(Calls.KRegister_doubleValue));
        all.put(new Key(Types.KREGISTER, Types.DOUBLE), new MethodCallConverter(Calls.KRegister_doubleValue));
        all.put(new Key(Types.KFLOAT, Types.FLOAT), new MethodCallConverter(Calls.KRegister_floatValue));
        all.put(new Key(Types.KREGISTER, Types.FLOAT), new MethodCallConverter(Calls.KRegister_floatValue));
        all.put(new Key(Types.KLONG, Types.LONG), new MethodCallConverter(Calls.KRegister_longValue));
        all.put(new Key(Types.KREGISTER, Types.LONG), new MethodCallConverter(Calls.KRegister_longValue));
        all.put(new Key(Types.KREGISTER, Types.KREFERENCE), new CastConverter(Types.KREFERENCE));

        for (TypeStruct t1 : new TypeStruct[]{Types.INT, Types.LONG, Types.SHORT, Types.BYTE, Types.CHAR, Types.DOUBLE, Types.FLOAT}) {
            if (!t1.equals(Types.FLOAT)) {
                all.put(new Key(t1, Types.FLOAT), new PrimitiveConverter(Calls.KRegister_floatValue));
            }
        }
        for (TypeStruct t1 : new TypeStruct[]{Types.INT, Types.LONG, Types.SHORT, Types.BYTE, Types.CHAR, Types.DOUBLE, Types.FLOAT}) {
            if (!t1.equals(Types.DOUBLE)) {
                all.put(new Key(t1, Types.DOUBLE), new PrimitiveConverter(Calls.KRegister_doubleValue));
            }
        }
        for (TypeStruct t1 : new TypeStruct[]{Types.INT, Types.LONG, Types.SHORT, Types.BYTE, Types.CHAR, Types.DOUBLE, Types.FLOAT}) {
            if (!t1.equals(Types.LONG)) {
                all.put(new Key(t1, Types.LONG), new PrimitiveConverter(Calls.KRegister_longValue));
            }
            if (!t1.equals(Types.INT)) {
                all.put(new Key(t1, Types.LONG), new PrimitiveConverter(Calls.KRegister_intValue));
            }
        }
        all.put(new Key(Types.CHAR,Types.INT),new SmallIntToIntConverter());
        all.put(new Key(Types.BYTE,Types.INT),new SmallIntToIntConverter());
        all.put(new Key(Types.SHORT,Types.INT),new SmallIntToIntConverter());
        for (TypeStruct t1 : new TypeStruct[]{Types.KREFERENCE,Types.KSHORT,Types.KINTEGER,Types.KLONG,Types.KCHAR,Types.KBYTE,Types.KBOOLEAN,Types.KDOUBLE,Types.KFLOAT}) {
            all.put(new Key(t1,Types.KREGISTER),new NoConverter());
        }
    }

    public static JJITExpression convert(JJITExpression e, TypeStruct to) {
        TypeStruct from = e.getExpressionType();
        if (from.equals(to)) {
            return e;
        }
        Converter converter = all.get(new Key(from, to));
        if (converter == null) {
            throw new IllegalArgumentException("Conversion not supported yet from " + from + " to " + to);
        }
        return converter.convert(e);
    }


}
