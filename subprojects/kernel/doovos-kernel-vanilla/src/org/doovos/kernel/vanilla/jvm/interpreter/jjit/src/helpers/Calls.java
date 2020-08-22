/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers;

import java.util.Map;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.process.KThread;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;

/**
 *
 * @author vpc
 */
public class Calls {
    public static final MethodStruct Double_isNaN=new MethodStruct(Double.class, "isNaN", false, Types.BOOLEAN,Types.DOUBLE);
    public static final MethodStruct Float_isNaN=new MethodStruct(Float.class, "isNaN", false, Types.BOOLEAN,Types.FLOAT);
    public static final MethodStruct Map_Integer_JJITInstruction_put=new MethodStruct(Map.class, "put", true, Types.VOID, Types.INTEGER, Types.JJITINSTRUCTION);
    public static final MethodStruct Map_Integer_JJITInstruction_get=new MethodStruct(Map.class, "get", false, Types.INTEGER, Types.JJITINSTRUCTION);
    
    
    //KFrame pushFrame( KMethod method, KRegister... parameters)
    public static final MethodStruct KThread_pushFrame=new MethodStruct(KThread.class, "pushFrame", true, Types.KFRAME, Types.KMETHOD,Types.KREGISTER_ARR);
    public static final MethodStruct KThread_popFrame=new MethodStruct(KThread.class, "popFrame", true, Types.KFRAME);
    public static final MethodStruct KThread_getFrame=new MethodStruct(KThread.class, "getFrame", false, Types.KFRAME);
//    public static final MethodStruct KThread_getProcess=new MethodStruct(KThread.class, "getProcess", false, KProcess.class);
    
    public static final MethodStruct KProcess_getMemoryManager=new MethodStruct(KProcess.class, "getMemoryManager", false, Types.KMEMORYMANAGER);
    public static final MethodStruct KProcess_getClassRepository=new MethodStruct(KProcess.class, "getClassRepository", false, Types.KCLASSREPOSITORY);

    
    public static final MethodStruct KFrame_getMemoryManager=new MethodStruct(KFrame.class, "getMemoryManager", false, Types.KMEMORYMANAGER);

    public static final MethodStruct KFrame_getLocal=new MethodStruct(KFrame.class, "getLocal", false, Types.KREGISTER, Types.INT);
    public static final MethodStruct KFrame_setLocal=new MethodStruct(KFrame.class, "setLocal", true, Types.VOID, Types.INT, Types.KREGISTER);
    public static final MethodStruct KFrame_setProgramCounter=new MethodStruct(KFrame.class, "setProgramCounter", true, Types.VOID, Types.INT);
    public static final MethodStruct KFrame_getInstruction=new MethodStruct(KFrame.class, "getInstruction", false, Types.KINSTRUCTION,Types.INT);
    public static final MethodStruct KFrame_throwThrowable=new MethodStruct(KFrame.class, "throwThrowable", true, Types.INT, Types.KREFERENCE);
    public static final MethodStruct KFrame_getCurrentInstruction=new MethodStruct(KFrame.class, "getCurrentInstruction", false, Types.KINSTRUCTION);
    public static final MethodStruct KFrame_getMemorySegment=new MethodStruct(KFrame.class, "getMemorySegment", false, Types.KMEMORYSEGMENT);
    public static final MethodStruct KFrame_getThread=new MethodStruct(KFrame.class, "getThread", false, Types.KTHREADLOCAL);
    public static final MethodStruct KFrame_getProcess=new MethodStruct(KFrame.class, "getProcess", false, Types.KPROCESS);
    public static final MethodStruct KFrame_getClassRepository=new MethodStruct(KFrame.class, "getClassRepository", false, Types.KCLASSREPOSITORY);
    public static final MethodStruct KFrame_peek=new MethodStruct(KFrame.class, "peek", false, Types.KREGISTER);
    public static final MethodStruct KFrame_push=new MethodStruct(KFrame.class, "push", true, Types.VOID, Types.KREGISTER);
    
    public static final MethodStruct KFrame_popByte=new MethodStruct(KFrame.class, "popByte", true, Types.BYTE);
    public static final MethodStruct KFrame_popInt=new MethodStruct(KFrame.class, "popInt", true, Types.INT);
    public static final MethodStruct KFrame_popFloat=new MethodStruct(KFrame.class, "popFloat", true, Types.FLOAT);
    public static final MethodStruct KFrame_popDouble=new MethodStruct(KFrame.class, "popDouble", true, Types.DOUBLE);
    public static final MethodStruct KFrame_popLong=new MethodStruct(KFrame.class, "popLong", true, Types.LONG);
    public static final MethodStruct KFrame_popShort=new MethodStruct(KFrame.class, "popShort", true, Types.SHORT);
    public static final MethodStruct KFrame_pop=new MethodStruct(KFrame.class, "pop", true, Types.KREGISTER);
    public static final MethodStruct KFrame_popRef=new MethodStruct(KFrame.class, "popRef", true, Types.KREFERENCE);
    
    
    public static final MethodStruct KClassRepository_getClassByName=new MethodStruct(KClassRepository.class, "getClassByName", false, Types.KCLASS,Types.STRING);
    
    public static final MethodStruct KClass_getField=new MethodStruct(KFrame.class, "getField", false, Types.KFIELD);
    public static final MethodStruct KClass_getMethodBySignature=new MethodStruct(KFrame.class, "getMethodBySignature", false, Types.KMETHOD);
    public static final MethodStruct KClass_isAssignableFrom=new MethodStruct(KClass.class, "isAssignableFrom", false, Types.BOOLEAN, Types.KREFERENCE);
    public static final MethodStruct KClass_getVirtualMethodBySignature=new MethodStruct(KClass.class, "getVirtualMethodBySignature", false, Types.KMETHOD,Types.STRING);
    public static final MethodStruct KClass_getGuestReference=new MethodStruct(KClass.class, "getGuestReference", false, Types.KREFERENCE);

    public static final MethodStruct KMethod_isIgnorable=new MethodStruct(KFrame.class, "isIgnorable", false, Types.BOOLEAN);

    public static final MethodStruct KRegister_intValue=new MethodStruct(KRegister.class, "intValue", false, Types.INT);
    public static final MethodStruct KRegister_isType1=new MethodStruct(KRegister.class, "isType1", false, Types.BOOLEAN);
    public static final MethodStruct KRegister_isType2=new MethodStruct(KRegister.class, "isType2", false, Types.BOOLEAN);
    public static final MethodStruct KRegister_floatValue=new MethodStruct(KRegister.class, "floatValue", false, Types.FLOAT);
    public static final MethodStruct KRegister_doubleValue=new MethodStruct(KRegister.class, "doubleValue", false, Types.DOUBLE);
    public static final MethodStruct KRegister_longValue=new MethodStruct(KRegister.class, "longValue", false, Types.LONG);
    public static final MethodStruct KRegister_byteValue=new MethodStruct(KRegister.class, "byteValue", false, Types.BYTE);
    public static final MethodStruct KRegister_shortValue=new MethodStruct(KRegister.class, "shortValue", false, Types.BYTE);
    public static final MethodStruct KReference_isNull=new MethodStruct(KRegister.class, "isNull", false, Types.BOOLEAN);
    public static final MethodStruct KReference_isNotNull=new MethodStruct(KRegister.class, "isNotNull", false, Types.BOOLEAN);
    

    
    public static final MethodStruct MemorySegment_allocMultiArray=new MethodStruct(KMemorySegment.class, "allocMultiArray", true, Types.KREFERENCE, Types.KCLASS, Types.INT_ARR);
    
    public static final MethodStruct MemoryManager_getKClass=new MethodStruct(KMemoryManager.class, "getKClass", false, Types.KCLASS, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getFloatArray=new MethodStruct(KMemoryManager.class, "getFloatArray", false, Types.FLOAT, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getShortArray=new MethodStruct(KMemoryManager.class, "getShortArray", false, Types.SHORT, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getIntArray=new MethodStruct(KMemoryManager.class, "getIntArray", false, Types.INT, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getCharArray=new MethodStruct(KMemoryManager.class, "getCharArray", false, Types.CHAR, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getDoubleArray=new MethodStruct(KMemoryManager.class, "getDoubleArray", false, Types.DOUBLE, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getByteArray=new MethodStruct(KMemoryManager.class, "getByteArray", false, Types.BYTE, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getLongArray=new MethodStruct(KMemoryManager.class, "getLongArray", false, Types.LONG, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getReferenceArray=new MethodStruct(KMemoryManager.class, "getReferenceArray", false, Types.KREFERENCE, Types.KREFERENCE);
    public static final MethodStruct MemoryManager_getArraySize=new MethodStruct(KMemoryManager.class, "getArraySize", false, Types.INT, Types.KREFERENCE);

    public static final MethodStruct MemoryManager_setByteArray=new MethodStruct(KMemoryManager.class, "setByteArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.BYTE);
    public static final MethodStruct MemoryManager_setIntArray=new MethodStruct(KMemoryManager.class, "setIntArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.INT);
    public static final MethodStruct MemoryManager_setShortArray=new MethodStruct(KMemoryManager.class, "setShortArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.SHORT);
    public static final MethodStruct MemoryManager_setCharArray=new MethodStruct(KMemoryManager.class, "setCharArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.CHAR);
    public static final MethodStruct MemoryManager_setLongArray=new MethodStruct(KMemoryManager.class, "setLongArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.LONG);
    public static final MethodStruct MemoryManager_setDoubleArray=new MethodStruct(KMemoryManager.class, "setDoubleArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.DOUBLE);
    public static final MethodStruct MemoryManager_setFloatArray=new MethodStruct(KMemoryManager.class, "setFloatArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.FLOAT);
    public static final MethodStruct MemoryManager_setReferenceArray=new MethodStruct(KMemoryManager.class, "setReferenceArray", true, Types.VOID, Types.KREFERENCE, Types.INT, Types.KREFERENCE);

    public static final MethodStruct MemoryManager_allocString=new MethodStruct(KMemoryManager.class, "allocString", true, Types.KREFERENCE, Types.STRING);
    public static final MethodStruct MemoryManager_allocRefArray=new MethodStruct(KMemoryManager.class, "allocRefArray", true, Types.KREFERENCE, Types.KCLASS, Types.INT);
    public static final MethodStruct MemoryManager_allocObject=new MethodStruct(KMemoryManager.class, "allocObject", true, Types.KREFERENCE, Types.KCLASS);
    public static final MethodStruct MemoryManager_allocShortArray=new MethodStruct(KMemoryManager.class, "allocShortArray", true, Types.KREFERENCE, Types.INT);
    public static final MethodStruct MemoryManager_allocLongArray=new MethodStruct(KMemoryManager.class, "allocLongArray", true, Types.KREFERENCE, Types.INT);
    public static final MethodStruct MemoryManager_allocIntArray=new MethodStruct(KMemoryManager.class, "allocIntArray", true, Types.KREFERENCE, Types.INT);
    public static final MethodStruct MemoryManager_allocDoubleArray=new MethodStruct(KMemoryManager.class, "allocDoubleArray", true, Types.KREFERENCE, Types.INT);
    public static final MethodStruct MemoryManager_allocBooleanArray=new MethodStruct(KMemoryManager.class, "allocBooleanArray", true, Types.KREFERENCE, Types.INT);
    public static final MethodStruct MemoryManager_allocCharArray=new MethodStruct(KMemoryManager.class, "allocCharArray", true, Types.KREFERENCE, Types.INT);
    public static final MethodStruct MemoryManager_allocFloatArray=new MethodStruct(KMemoryManager.class, "allocFloatArray", true, Types.KREFERENCE, Types.INT);
    public static final MethodStruct MemoryManager_allocByteArray=new MethodStruct(KMemoryManager.class, "allocByteArray", true, Types.KREFERENCE, Types.INT);
    
    
    public static final MethodStruct KField_getInstanceInt=new MethodStruct(KField.class, "getInstanceInt", false, Types.INT, Types.KREFERENCE);
    public static final MethodStruct KField_setInstanceInt=new MethodStruct(KField.class, "setInstanceInt", true, Types.VOID, Types.KREFERENCE, Types.INT);
    public static final MethodStruct KField_getInstanceValue=new MethodStruct(KField.class, "getInstanceValue", false, Types.KREGISTER, Types.KREFERENCE);
    public static final MethodStruct KField_setInstanceValue=new MethodStruct(KField.class, "setInstanceValue", true, Types.VOID, Types.KREFERENCE, Types.KREFERENCE);
    public static final MethodStruct KField_getInstanceDouble=new MethodStruct(KField.class, "getInstanceDouble", false, Types.DOUBLE, Types.KREFERENCE);
    public static final MethodStruct KField_getInstanceRef=new MethodStruct(KField.class, "getInstanceRef", false, Types.KREFERENCE, Types.KREFERENCE);
    public static final MethodStruct KField_getStaticValue=new MethodStruct(KField.class, "getStaticValue", false, Types.KREGISTER);
    public static final MethodStruct KField_setStaticValue=new MethodStruct(KField.class, "setStaticValue", true, Types.VOID, Types.KREGISTER);
    
}
