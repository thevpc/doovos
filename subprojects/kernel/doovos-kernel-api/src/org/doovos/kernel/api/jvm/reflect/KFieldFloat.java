/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.api.jvm.reflect;

import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KFloat;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.Doovos;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
  * User: vpc
  * Date: 11 mai 2009
  * Time: 03:36:18
  * To change this template use File | Settings | File Templates.
  */
 public class KFieldFloat extends KField {
    private final int byteOffset = definition.getByteOffset();
    public KFieldFloat(KFieldDef definition, KClass field) throws RemoteException {
        super(definition, field);
    }

    @Override
    public void setStaticValue(KRegister value) throws RemoteException {
        staticSegment.setFieldFloat(staticPointer, byteOffset, value.floatValue());
    }

    @Override
    public KRegister getStaticValue() throws RemoteException {
        return new KFloat(staticSegment.getFieldFloat(staticPointer, byteOffset));
    }

    @Override
    public void setInstanceValue(KReference ref, KRegister value) throws RemoteException {
        memoryManager.setFieldFloat(ref, byteOffset, value.floatValue());
    }

    @Override
    public KRegister getInstanceValue(KReference ref) throws RemoteException {
        return new KFloat(memoryManager.getFieldFloat(ref, byteOffset));
    }

//    public void setClassValue(KRegister value) throws RemoteException {
//        KReference staticReference = clazz.staticReference;
//        KMemorySegment staticReferenceSegment = clazz.staticReferenceSegment;
//
//        KObject o = staticReferenceSegment.getObject(staticReference.pointer);
//        setFieldValue(value, o, staticReference);
//        staticReferenceSegment.setObject(staticReference.pointer, o);
//    }

//    public void setObjectValue(KReference ref, KRegister value) throws RemoteException {
//        KMemorySegment seg = Doovos.getMemorySegment(ref.segment);
//        KObject o = seg.getObject(ref.pointer);
//        setFieldValue(value, o, ref);
//        seg.setObject(ref.pointer, o);
//    }

//    public KRegister getClassValue() throws RemoteException {
//        KObject o = Doovos.getSystem().getMemoryManager().getObject(clazz.staticReference);
//        return getFieldValue(o);
//    }

//    public KRegister getObjectValue(KReference ref) throws RemoteException {
//        KObject o = Doovos.getSystem().getMemoryManager().getObject(ref);
//        return getFieldValue(o);
//    }
//    public void getValue(KRegister register);


//    public void setFieldValue(KRegister value, KObject object, KReference ref) throws RemoteException {
//        byte[] content = object.getContent();
//        DMemoryUtils.float2byteArray(((KFloat) value).value, content, byteOffset);
//    }

    /**
     * if(fieldName==null) return classId as DRegisterLong
     *
     * @param fieldName
     * @param o
     * @return
     */
//    public KRegister getFieldValue(KObject o) throws RemoteException {
//        byte[] content = o.getContent();
//        return new KFloat(DMemoryUtils.byteArray2float(content, byteOffset));
//    }
}