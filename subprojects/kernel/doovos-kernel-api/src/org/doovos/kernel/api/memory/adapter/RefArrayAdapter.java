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
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import java.util.List;

public class RefArrayAdapter extends ArrayAdapter {

    public RefArrayAdapter() {
    }

    public RefArrayAdapter(KProcess process, KClass itemClass, int size) throws RemoteException {
        setProcess(process);
        setReference(process.getMemorySegment().allocRefArray(itemClass, size));
        setKClass(Doovos.getSystem().getMemoryManager().getPointer(getReference()).getKClass());
    }

    public static RefArrayAdapter newInstance(KProcess process, String itemClass, int size) throws RemoteException {
        return newInstance(process, process.getClassRepository().getClassByName(itemClass), size);
    }

    public static RefArrayAdapter newInstance(KProcess process, KClass itemClass, List<KReference> list) throws RemoteException {
        RefArrayAdapter r = newInstance(process, itemClass, list.size());
        int i = 0;
        for (KReference kReference : list) {
            r.setArrayReference(i, kReference);
            i++;
        }
        return r;
    }

    public static RefArrayAdapter newInstance(KProcess process, String itemClass, List<KReference> list) throws RemoteException {
        RefArrayAdapter r = newInstance(process, itemClass, list.size());
        int i = 0;
        for (KReference kReference : list) {
            r.setArrayReference(i, kReference);
            i++;
        }
        return r;
    }

    public static RefArrayAdapter newInstance(KProcess process, KClass itemClass, int size) throws RemoteException {
        RefArrayAdapter r = new RefArrayAdapter();
        r.setProcess(process);
        r.setReference(process.getMemorySegment().allocRefArray(itemClass, size));
        r.setKClass(Doovos.getSystem().getMemoryManager().getPointer(r.getReference()).getKClass());
        return r;
    }

    public RefArrayAdapter(KProcess process, KClass classRef, KReference reference) {
        super(process, classRef, reference);
    }

    public RefArrayAdapter(KProcess process, KReference reference) throws RemoteException {
        super(process, Doovos.getSystem().getMemoryManager().getPointer(reference).getKClass(), reference);
    }

    public int length() throws RemoteException {
        return Doovos.getSystem().getMemoryManager().getArraySize(getReference());
    }

    public KReference getArrayReference(int index) throws RemoteException {
        return Doovos.getSystem().getMemoryManager().getReferenceArray(getReference(), index);
    }

    public String getArrayString(int index) throws RemoteException {
        return Doovos.getSystem().getMemoryManager().getString(getArrayReference(index));
    }

    public void setArrayReference(int index, KReference value) throws RemoteException {
        Doovos.getSystem().getMemoryManager().setReferenceArray(getReference(), index, value);
    }

    public String[] toStringArray() throws RemoteException {
        int len = length();
        String[] ret = new String[len];
        for (int i = 0; i < len; i++) {
            ret[i] = getArrayString(i);
        }
        return ret;
    }

    public KReference[] toArray() throws RemoteException {
        int len = length();
        KReference[] ret = new KReference[len];
        for (int i = 0; i < len; i++) {
            ret[i] = getArrayReference(i);
        }
        return ret;
    }

}
