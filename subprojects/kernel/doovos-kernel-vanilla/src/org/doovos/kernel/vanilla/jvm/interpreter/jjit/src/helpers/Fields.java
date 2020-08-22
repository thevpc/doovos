package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers;

import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.FieldStruct;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 19/07/11
 * Time: 01:24
 * To change this template use File | Settings | File Templates.
 */
public class Fields {
    public static final FieldStruct KInteger_ZERO=new FieldStruct(KInteger.class, "ZERO", Types.KINTEGER);
    public static final FieldStruct KInteger_ONE=new FieldStruct(KInteger.class, "ONE", Types.KINTEGER);
    public static final FieldStruct KInteger_M1=new FieldStruct(KInteger.class, "M1", Types.KINTEGER);
    public static final FieldStruct KInteger_TWO =new FieldStruct(KInteger.class, "TWO", Types.KINTEGER);
    public static final FieldStruct KInteger_THREE =new FieldStruct(KInteger.class, "THREE", Types.KINTEGER);
    public static final FieldStruct KInteger_FOUR =new FieldStruct(KInteger.class, "FOUR", Types.KINTEGER);
    public static final FieldStruct KInteger_FIVE =new FieldStruct(KInteger.class, "FIVE", Types.KINTEGER);
    public static final FieldStruct KInteger_MAX_VALUE =new FieldStruct(KInteger.class, "MAX_VALUE", Types.KINTEGER);
    public static final FieldStruct KInteger_MIN_VALUE =new FieldStruct(KInteger.class, "MIN_VALUE", Types.KINTEGER);

    public static final FieldStruct KLong_ZERO =new FieldStruct(KLong.class, "ZERO", Types.KLONG);
    public static final FieldStruct KLong_ONE =new FieldStruct(KLong.class, "ONE", Types.KLONG);
    public static final FieldStruct KLong_M1 =new FieldStruct(KLong.class, "M1", Types.KLONG);
    public static final FieldStruct KLong_MAX_VALUE =new FieldStruct(KLong.class, "MAX_VALUE", Types.KLONG);
    public static final FieldStruct KLong_MIN_VALUE =new FieldStruct(KLong.class, "MIN_VALUE", Types.KLONG);

    public static final FieldStruct KDouble_ZERO=new FieldStruct(KDouble.class, "ZERO", Types.KDOUBLE);
    public static final FieldStruct KDouble_ONE=new FieldStruct(KDouble.class, "ONE", Types.KDOUBLE);
    public static final FieldStruct KDouble_M1=new FieldStruct(KDouble.class, "M1", Types.KDOUBLE);
    public static final FieldStruct KDouble_MAX_VALUE=new FieldStruct(KDouble.class, "MAX_VALUE", Types.KDOUBLE);
    public static final FieldStruct KDouble_MIN_VALUE=new FieldStruct(KDouble.class, "MIN_VALUE", Types.KDOUBLE);
    public static final FieldStruct KDouble_POSITIVE_INFINITY=new FieldStruct(KDouble.class, "POSITIVE_INFINITY", Types.KDOUBLE);
    public static final FieldStruct KDouble_NEGATIVE_INFINITY=new FieldStruct(KDouble.class, "NEGATIVE_INFINITY", Types.KDOUBLE);
    public static final FieldStruct KDouble_NAN=new FieldStruct(KDouble.class, "NAN", Types.KDOUBLE);

    public static final FieldStruct KFloat_ZERO=new FieldStruct(KFloat.class, "ZERO", Types.KFLOAT);
    public static final FieldStruct KFloat_ONE=new FieldStruct(KFloat.class, "ONE", Types.KFLOAT);
    public static final FieldStruct KFloat_M1=new FieldStruct(KFloat.class, "M1", Types.KFLOAT);
    public static final FieldStruct KFloat_MAX_VALUE=new FieldStruct(KFloat.class, "MAX_VALUE", Types.KFLOAT);
    public static final FieldStruct KFloat_MIN_VALUE=new FieldStruct(KFloat.class, "MIN_VALUE", Types.KFLOAT);
    public static final FieldStruct KFloat_POSITIVE_INFINITY=new FieldStruct(KFloat.class, "POSITIVE_INFINITY", Types.KFLOAT);
    public static final FieldStruct KFloat_NEGATIVE_INFINITY=new FieldStruct(KFloat.class, "NEGATIVE_INFINITY", Types.KFLOAT);
    public static final FieldStruct KFloat_NAN=new FieldStruct(KFloat.class, "NAN", Types.KFLOAT);

    public static final FieldStruct KReference_POINTER=new FieldStruct(KReference.class, "pointer", Types.LONG);
    public static final FieldStruct KReference_SEGMENT=new FieldStruct(KReference.class, "segment", Types.LONG);
    public static final FieldStruct KReference_NULL=new FieldStruct(KReference.class, "NULL", Types.KREFERENCE);

    public static final FieldStruct KRegister_EMPTY_ARRAY=new FieldStruct(KRegister[].class, "EMPTY_ARRAY", Types.KREGISTER_ARR);

}
