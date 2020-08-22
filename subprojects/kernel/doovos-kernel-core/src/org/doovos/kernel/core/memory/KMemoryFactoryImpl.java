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
import org.doovos.kernel.api.memory.KMemoryUtilities;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.memory.slaballocator.KSlabMemorySegment;
import org.doovos.kernel.core.util.KUtils;

/**
 *
 * @author vpc
 */
public class KMemoryFactoryImpl implements KMemoryFactory {

    public KMemoryManager createMemoryManager() {
        return new KMemoryManagerImpl();
    }

    public KLocalMemorySegment createMemorySegment(KProcess process, Properties envs, KSegmentDef options) throws RemoteException {
        return KUtils.resolveInstance("MemorySegment", envs, KSlabMemorySegment.class);
    }

    public void prepareClassDef(KClassDef classDef) {
//        System.out.println("prepareClassDef :: " + classDef);
//        if (classDef.getName().toLowerCase().contains("java.lang.byte".toLowerCase())) {
//            System.out.print("");
//        }
        int classFieldIndex = 8;//classId
        int instanceFieldIndex = 8;//classId
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
                classFieldIndex += attribute.getObjectType().getByteSize();
//                System.out.println("<CLASS   > " + attribute);
            } else {
                attribute.setByteOffset(instanceFieldIndex);
                attribute.setAbsoluteIndex(indexC + indexI);
                attribute.setIndex(indexI);
                indexI++;
                instanceFieldIndex += attribute.getObjectType().getByteSize();
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

        classDef.setClassSize(classFieldIndex);
        classDef.setInstanceSize(instanceFieldIndex);
//        classDef.init(classFieldIndex, instanceFieldIndex, _classPatternBytes, _instancePatternBytes);
//        classDef.setInstanceSize(instanceSize);
//        classDef.setClassSize(classSize);
//        classDef.setSuperClass(superClass);
//        classDef.setSuperInterfaces(superInterfaces);
    }
}
