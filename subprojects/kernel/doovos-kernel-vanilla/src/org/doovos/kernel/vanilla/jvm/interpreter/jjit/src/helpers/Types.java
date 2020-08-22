package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.*;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 19/07/11
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
public class Types {
    public static final TypeStruct KREGISTER=new TypeStruct(KRegister.class);
    public static final TypeStruct BOOLEAN=new TypeStruct(Boolean.TYPE);
    public static final TypeStruct VOID=new TypeStruct("void");
    public static final TypeStruct INT=new TypeStruct(Integer.TYPE);
    public static final TypeStruct INTEGER=new TypeStruct(Integer.class);
    public static final TypeStruct FLOAT=new TypeStruct(Float.TYPE);
    public static final TypeStruct CHAR=new TypeStruct(Character.TYPE);
    public static final TypeStruct DOUBLE=new TypeStruct(Double.TYPE);
    public static final TypeStruct INT_ARR=new TypeStruct("int[]");
    public static final TypeStruct LONG=new TypeStruct(Long.TYPE);
    public static final TypeStruct SHORT=new TypeStruct(Short.TYPE);
    public static final TypeStruct BYTE=new TypeStruct(Byte.TYPE);
    public static final TypeStruct STRING=new TypeStruct(String.class);
    public static final TypeStruct KPROCESS=new TypeStruct(KProcess.class);
    public static final TypeStruct KFRAME=new TypeStruct(KFrame.class);
    public static final TypeStruct KTHREADLOCAL=new TypeStruct(KLocalThread.class);
    public static final TypeStruct KREGISTER_ARR=new TypeStruct(KRegister.class.getName()+"[]");
    public static final TypeStruct KCLASS=new TypeStruct(KClass.class);
    public static final TypeStruct KFIELD=new TypeStruct(KField.class);
    public static final TypeStruct KINSTRUCTION=new TypeStruct(KInstruction.class);
    public static final TypeStruct JJITINSTRUCTION=new TypeStruct(JJITInstruction.class);
    public static final TypeStruct JJITINSTRUCTION_ARR=new TypeStruct(JJITInstruction.class.getName()+"[]");
    public static final TypeStruct KMEMORYMANAGER=new TypeStruct(KMemoryManager.class);
    public static final TypeStruct KMEMORYSEGMENT=new TypeStruct(KMemorySegment.class);
    public static final TypeStruct KMETHOD=new TypeStruct(KMethod.class);
    public static final TypeStruct KCLASSREPOSITORY=new TypeStruct(KClassRepository.class);

    public static final TypeStruct KREFERENCE=new TypeStruct(KReference.class);
    public static final TypeStruct KINTEGER=new TypeStruct(KInteger.class);
    public static final TypeStruct KLONG=new TypeStruct(KLong.class);
    public static final TypeStruct KCHAR=new TypeStruct(KChar.class);
    public static final TypeStruct KBYTE=new TypeStruct(KByte.class);
    public static final TypeStruct KBOOLEAN=new TypeStruct(KBoolean.class);
    public static final TypeStruct KDOUBLE=new TypeStruct(KDouble.class);
    public static final TypeStruct KFLOAT=new TypeStruct(KFloat.class);
    public static final TypeStruct KSHORT=new TypeStruct(KShort.class);
    public static final TypeStruct KRETURN=new TypeStruct(KReturn.class);

    private static Map<TypeStruct,TypeStruct> primTypeToKtype= new HashMap<TypeStruct, TypeStruct>();
    private static Map<TypeStruct,TypeStruct> KtypeToPrimType= new HashMap<TypeStruct, TypeStruct>();
    private static TypeStruct[] KRegisterTypes = {
            KREFERENCE,
            KDOUBLE,
            KFLOAT,
            KINTEGER,
            KSHORT,
            KLONG,
            KBYTE,
            KCHAR,
            KBOOLEAN,
            KREFERENCE,
            KREGISTER,
            KRETURN,
    };
    static{
        primTypeToKtype.put(DOUBLE, KDOUBLE);
        primTypeToKtype.put(INT, KDOUBLE);
        primTypeToKtype.put(FLOAT, KFLOAT);
        primTypeToKtype.put(LONG, KLONG);
        primTypeToKtype.put(CHAR, KCHAR);
        primTypeToKtype.put(SHORT, KSHORT);

        KtypeToPrimType.put(KDOUBLE, DOUBLE);
        KtypeToPrimType.put(KINTEGER, DOUBLE);
        KtypeToPrimType.put(KFLOAT, FLOAT);
        KtypeToPrimType.put(KLONG, LONG);
        KtypeToPrimType.put(KCHAR, CHAR);
        KtypeToPrimType.put(KSHORT, SHORT);
    }

    public static TypeStruct getPrimitiveType(TypeStruct ktype) {
        TypeStruct typeStruct = KtypeToPrimType.get(ktype);
        if(typeStruct==null){
            throw new IllegalArgumentException("Unsuppported");
        }
        return typeStruct;
    }

    public static TypeStruct getKType(TypeStruct primType) {
        TypeStruct typeStruct = primTypeToKtype.get(primType);
        if(typeStruct==null){
            throw new IllegalArgumentException("Unsuppported");
        }
        return typeStruct;
    }

    public static boolean isKRegister(TypeStruct s) {
        for (TypeStruct e : KRegisterTypes) {
            if(e.equals(s)){
                return true;
            }
        }
        return false;
    }
}
