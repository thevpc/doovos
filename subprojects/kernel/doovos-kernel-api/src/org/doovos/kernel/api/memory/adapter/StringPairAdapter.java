///**
// * ====================================================================
// *             Doovos (Distributed Object Oriented Operating System)
// *
// * Doovos is a new Open Source Distributed Object Oriented Operating System
// * Design and implementation based on the Java Platform.
// * Actually, it is a try for designing a distributed operation system in
// * top of existing centralized/network OS.
// * Designed OS will follow the object oriented architecture for redefining
// * all OS resources (memory,process,file system,device,...etc.) in a highly
// * distributed context.
// * Doovos is also a distributed Java virtual machine that implements JVM
// * specification on top the distributed resources context.
// *
// * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
// * Doovos Kernel code is executed on host JVM
// *
// * Copyright (C) 2008-2010 Taha BEN SALAH
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc.,
// * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// * ====================================================================
// */
//package org.doovos.kernel.api.memory.adapter;
//
//import org.doovos.kernel.api.Doovos;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.process.KProcess;
//
//import java.rmi.RemoteException;
//
//public class StringPairAdapter extends AbstractFieldsMemoryAdapter {
//    private StringAdapter key;
//    private StringAdapter value;
//
//    public StringPairAdapter(KProcess process, String key, String value) throws RemoteException {
//        this(process, new StringAdapter(process, key), new StringAdapter(process, value));
//    }
//
//    public StringPairAdapter(KProcess process, StringAdapter key, StringAdapter value) throws RemoteException {
//        setKClass(process.getClassRepository().getClassByName("org.doovos.api.StringPair"));
//        setProcess(process);
//        setReference(process.getMemorySegment().allocObject(getKClass()));
//        setKey(key);
//        setValue(value);
//    }
//
//    public StringPairAdapter(KProcess process, KReference reference) throws RemoteException {
//        super(process, Doovos.getSystem().getMemoryManager().getPointer(reference).getKClass(), reference);
//    }
//
//    void reload() throws RemoteException {
//        key = loadStringAdapter("key", false);
//        value = loadStringAdapter("value", false);
//    }
//
//    public StringAdapter getKey() throws RemoteException {
//        checkLoaded();
//        return key;
//    }
//
//    public StringAdapter getValue() throws RemoteException {
//        checkLoaded();
//        return value;
//    }
//
//    public void setKey(StringAdapter value) throws RemoteException {
//        storeReferenceAdapter("key", false, value, getReference());
//        invalidate();
//    }
//
//    public void setValue(StringAdapter value) throws RemoteException {
//        storeReferenceAdapter("value", false, value, getReference());
//        invalidate();
//    }
//
//
//}
