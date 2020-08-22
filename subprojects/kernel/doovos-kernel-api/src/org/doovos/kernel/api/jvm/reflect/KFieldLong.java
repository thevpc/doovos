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
import org.doovos.kernel.api.memory.KLong;
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
 public class KFieldLong extends KField {
    private final int byteOffset = definition.getByteOffset();
    public KFieldLong(KFieldDef definition, KClass field) throws RemoteException {
        super(definition, field);
    }

    @Override
    public void setStaticValue(KRegister value) throws RemoteException {
        staticSegment.setFieldLong(staticPointer, byteOffset, value.longValue());
    }

    @Override
    public KRegister getStaticValue() throws RemoteException {
        return new KLong(staticSegment.getFieldLong(staticPointer, byteOffset));
    }

//    public void setClassValue(KRegister value) throws RemoteException {
//        KReference staticReference = clazz.staticReference;
//        KMemorySegment staticReferenceSegment = clazz.staticReferenceSegment;
//
//        KObject o = staticReferenceSegment.getObject(staticReference.pointer);
//        setFieldValue(value, o, staticReference);
//        staticReferenceSegment.setObject(staticReference.pointer, o);
//    }

    @Override
    public void setInstanceValue(KReference ref, KRegister value) throws RemoteException {
        memoryManager.setFieldLong(ref, byteOffset, value.longValue());
    }

    @Override
    public KRegister getInstanceValue(KReference ref) throws RemoteException {
        return new KLong(memoryManager.getFieldLong(ref, byteOffset));
    }

//    public KRegister getClassValue() throws RemoteException {
//        KObject o = Doovos.getSystem().getMemoryManager().getObject(clazz.staticReference);
//        return getFieldValue(o);
//    }

//    public void getValue(KRegister register);


//    public void setFieldValue(KRegister value, KObject object, KReference ref) throws RemoteException {
//        byte[] content = object.getContent();
//        DMemoryUtils.long2byteArray(value.longValue(), content, byteOffset);
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
//        return new KLong(DMemoryUtils.byteArray2long(content, byteOffset));
//    }
}