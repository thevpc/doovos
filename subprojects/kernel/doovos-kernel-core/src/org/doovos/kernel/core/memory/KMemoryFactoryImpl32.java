/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory;

import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import java.util.Properties;
import org.doovos.kernel.api.factory.KMemoryFactory;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.memory.KLocalMemorySegment;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.memory.slaballocator.KSlabMemorySegment32;

/**
 *
 * @author vpc
 */
public class KMemoryFactoryImpl32 implements KMemoryFactory {

    public KMemoryManager createMemoryManager() {
        return new KMemoryManagerImpl();
    }

    public KLocalMemorySegment createMemorySegment(KProcess process, Properties envs, KSegmentDef options) throws RemoteException {
        //return KUtils.resolveInstance("MemorySegment", envs, KSlabMemorySegment.class);
        return new KSlabMemorySegment32();
    }

    public void prepareClassDef(KClassDef classDef) {
//        System.out.println("prepareClassDef :: " + classDef);
//        if (classDef.getName().toLowerCase().contains("dprocess".toLowerCase())) {
//            System.out.print("");
//        }
        int classFieldIndex = 2;//classId
        int instanceFieldIndex = 2;//classId
        KClassDef superClass = classDef.getSuperClass();
        if (superClass != null) {
            instanceFieldIndex = superClass.getInstanceSize();
        }
        int indexI = 0;
        int indexC = 0;
        for (KFieldDef attribute : classDef.getFields()) {
            if (Modifier.isStatic(attribute.getModifiers())) {
                attribute.setByteOffset(classFieldIndex);
                attribute.setIndex(indexC);
                attribute.setAbsoluteIndex(indexC + indexI);
                indexC++;
                classFieldIndex += attribute.getObjectType().getIntSize();
//                System.out.println("<CLASS   > " + attribute);
            } else {
                attribute.setByteOffset(instanceFieldIndex);
                attribute.setAbsoluteIndex(indexC + indexI);
                attribute.setIndex(indexI);
                indexI++;
                instanceFieldIndex += attribute.getObjectType().getIntSize();
//                System.out.println("<INSTANCE> " + attribute);
            }
        }

//        byte[] _instancePatternBytes = new byte[instanceFieldIndex];
//        byte[] _classPatternBytes = new byte[classFieldIndex];
//        long classId = classDef.getClassId();

//        KMemoryUtilities.long2byteArray(classId, _instancePatternBytes, 0);
//        KMemoryUtilities.long2byteArray(classId, _classPatternBytes, 0);

//        for (KFieldDef f : classDef.getFields()) {
//            if (!KClassDef.isPrimitiveTypeName(f.getTypeName())) {
//                if (!Modifier.isStatic(f.getModifiers())) {
////                    System.out.println(">> INIT INSTANCE NULL FOR " + f);
//                    try {
//                        System.arraycopy(
//                                KClassDef.NULL_BYTES, 0, _instancePatternBytes, f.getByteOffset(), KClassDef.NULL_BYTES.length);
//                    } catch (RuntimeException e) {
//                        throw e;
//                    }
//                } else {
//                    try {
////                        System.out.println(">> INIT CLASS NULL FOR " + f);
//                        System.arraycopy(
//                                KClassDef.NULL_BYTES, 0, _classPatternBytes, f.getByteOffset(), KClassDef.NULL_BYTES.length);
//                    } catch (RuntimeException e) {
//                        throw e;
//                    }
//                }
//            }
//        }

//        KClassDef c = superClass;
//
//        while (c != null) {
//            for (KFieldDef f : c.getFields()) {
//                if (!KClassDef.isPrimitiveTypeName(f.getTypeName())) {
//                    if (!Modifier.isStatic(f.getModifiers())) {
////                        System.out.println(">> INIT INSTANCE NULL FOR " + f);
//                        try {
//                            System.arraycopy(
//                                    KClassDef.NULL_BYTES, 0, _instancePatternBytes, f.getByteOffset(), KClassDef.NULL_BYTES.length);
//                        } catch (RuntimeException e) {
//                            throw e;
//                        }
//                    }
//                }
//            }
//            c = c.getSuperClass();
//        }

//        classDef.init(classFieldIndex, instanceFieldIndex, _classPatternBytes, _instancePatternBytes);
        classDef.setInstanceSize(instanceFieldIndex);
        classDef.setClassSize(classFieldIndex);
//        classDef.setSuperClass(superClass);
//        classDef.setSuperInterfaces(superInterfaces);
    }
}
