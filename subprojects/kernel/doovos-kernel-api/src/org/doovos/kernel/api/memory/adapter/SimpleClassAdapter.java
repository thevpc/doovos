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

import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KBoolean;
import org.doovos.kernel.api.memory.KLong;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.jvm.jni.JNIEnv;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 15 avr. 2009
 * Time: 00:10:34
 * To change this template use File | Settings | File Templates.
 */
public class SimpleClassAdapter extends AbstractFieldsMemoryAdapter {


    public SimpleClassAdapter(JNIEnv env, KReference reference) throws RemoteException {
        this(env.getProcess(), reference);
    }

    public SimpleClassAdapter(KProcess process, KReference reference) throws RemoteException {
        super(process, reference);
    }

    public static SimpleClassAdapter newInstance(JNIEnv env, String className) throws RemoteException {
        return newInstance(env.getProcess(), className);
    }

    public static SimpleClassAdapter newInstance(KProcess process, String className) throws RemoteException {
        KClass ref = process.getClassRepository().getClassByName(className);
        KReference kReference = process.getMemorySegment().allocObject(ref);
        return new SimpleClassAdapter(process, kReference);
    }

    void reload() throws RemoteException {
        //do nothing
    }

    public KRegister getRegister(String fieldName) throws RemoteException {
        return getKClass().getField(fieldName, true).getInstanceValue(getReference());
    }

    public void setRegister(String fieldName, KRegister value) throws RemoteException {
        getKClass().getField(fieldName, true).setInstanceValue(getReference(), value == null ? KReference.NULL : value);
    }

    public KReference getReference(String fieldName) throws RemoteException {
        return (KReference) getRegister(fieldName);
    }

    public SimpleClassAdapter getObject(String fieldName) throws RemoteException {
        return new SimpleClassAdapter(getProcess(), (KReference) getRegister(fieldName));
    }

    public RefArrayAdapter getRefArray(String fieldName) throws RemoteException {
        return new RefArrayAdapter(getProcess(), (KReference) getRegister(fieldName));
    }

    public void setReference(String fieldName, KReference value) throws RemoteException {
        setRegister(fieldName, value);
    }

    public String getString(String fieldName) throws RemoteException {
        KReference r = getReference(fieldName);
        return r.isNull() ? null : Doovos.getSystem().getMemoryManager().getString(r);
    }

    public void setString(String fieldName, String value) throws RemoteException {
        if (value == null) {
            setReference(fieldName, null);
        } else {
            setReference(fieldName, getProcess().getMemorySegment().allocString(value));
        }
    }

    public int getInt(String fieldName) throws RemoteException {
        return ((KInteger) getRegister(fieldName)).value;
    }

    public void setInt(String fieldName, int value) throws RemoteException {
        setRegister(fieldName, new KInteger(value));
    }

    public long getLong(String fieldName) throws RemoteException {
        return ((KLong) getRegister(fieldName)).value;
    }

    public void setLong(String fieldName, long value) throws RemoteException {
        setRegister(fieldName, new KLong(value));
    }

    public boolean getBoolean(String fieldName) throws RemoteException {
        return ((KBoolean) getRegister(fieldName)).value;
    }

    public void setBoolean(String fieldName, boolean value) throws RemoteException {
        setRegister(fieldName, KBoolean.valueOf(value));
    }

}
