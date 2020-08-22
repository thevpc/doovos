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
package org.doovos.kernel.api.memory.adapter;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KBoolean;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;

public abstract class AbstractFieldsMemoryAdapter extends AbstractMemoryAdapter {
    protected boolean _loaded;

    protected AbstractFieldsMemoryAdapter() {
    }

    public AbstractFieldsMemoryAdapter(KProcess process, KReference reference) throws RemoteException {
        super(process, Doovos.getSystem().getMemoryManager().getPointer(reference).getKClass(), reference);
    }

    public AbstractFieldsMemoryAdapter(KProcess process, KClass classRef, KReference reference) {
        super(process, classRef, reference);
    }

    public void checkLoaded() throws RemoteException {
        if (!_loaded) {
            reload();
            _loaded = true;
        }
    }

    public boolean isLoaded() {
        return _loaded;
    }

    abstract void reload() throws RemoteException;

//    protected String[] loadStringArray(String fieldName,DObject o) throws RemoteException {
//        return MemoryAdapterUtils.loadStringArray(getProcess(),(DRegisterReference) getClassRef().getProcessClass().getFieldValueAsRegister(fieldName,o));
//    }

    protected StringArrayAdapter loadStringArrayAdapter(String fieldName, boolean checkSuper) throws RemoteException {
        KReference reference = (KReference) getKClass().getField(fieldName, checkSuper).getInstanceValue(getReference());
        return reference.isNull() ? null : new StringArrayAdapter(getProcess(), reference);
    }

//    protected String loadString(String fieldName,DObject o) throws RemoteException {
//        DRegisterReference reference = (DRegisterReference) getClassRef().getProcessClass().getFieldValueAsRegister(fieldName, o);
//        return Doovos.getSystem().getMemoryManager().getStringChars(reference);
//    }

    protected int loadInt(String fieldName, boolean checkSuper) throws RemoteException {
        KInteger i=(KInteger) loadRegister(fieldName, checkSuper);
        return i.value;
    }

    protected boolean loadBoolean(String fieldName, boolean checkSuper) throws RemoteException {
        KBoolean i=(KBoolean) loadRegister(fieldName, checkSuper);
        return i.value;
    }

    protected KReference loadReference(String fieldName, boolean checkSuper) throws RemoteException {
        return (KReference) getKClass().getField(fieldName, checkSuper).getInstanceValue(getReference());
    }
    
    protected KRegister loadRegister(String fieldName, boolean checkSuper) throws RemoteException {
        return getKClass().getField(fieldName, checkSuper).getInstanceValue(getReference());
    }

    protected StringAdapter loadStringAdapter(String fieldName, boolean checkSuper) throws RemoteException {
        KReference reference = (KReference) getKClass().getField(fieldName, checkSuper).getInstanceValue(getReference());
        return reference.isNull() ? null : new StringAdapter(getProcess(), reference);
    }

//    protected void storeString(String fieldName,String value,DObject o) throws RemoteException {
//        DRegisterReference ref = getProcess().getMemorySegment().allocString(getProcess().getStringClassRef(), value);
//        getClassRef().getProcessClass().setFieldValue(fieldName,ref,o);
//    }

    protected void storeReferenceAdapter(String fieldName, boolean checkSuper, AbstractMemoryAdapter value) throws RemoteException {
        getKClass().getField(fieldName, checkSuper).setInstanceValue(getReference(),value == null ? null : value.getReference());
    }

    protected void storeReferenceAdapter(String fieldName, boolean checkSuper, AbstractMemoryAdapter value, KReference ref) throws RemoteException {
        getKClass().getField(fieldName, checkSuper).setInstanceValue(ref, value == null ? null : value.getReference());
    }

//    protected void storeStringArray(String fieldName,String[] values,DObject o) throws RemoteException {
//        DRegisterReference value = MemoryAdapterUtils.allocStringArray(getProcess(), values);
//        getClassRef().getProcessClass().setFieldValue(fieldName,value,o);
//    }

    public void invalidate() {
        _loaded = false;
    }
}
