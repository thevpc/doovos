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
import org.doovos.kernel.api.memory.KBoolean;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;

public class DSiteAdapter extends AbstractFieldsMemoryAdapter {
    private StringAdapter name;
    private StringAdapter url;
    private boolean alive;
    private boolean local;

    public DSiteAdapter(KProcess process, String uuid,String name, String url, boolean local, boolean alive) throws RemoteException {
        this(process, new StringAdapter(process, uuid), new StringAdapter(process, name), new StringAdapter(process, url), local, alive);
    }

    public DSiteAdapter(KProcess process, StringAdapter uuid, StringAdapter name, StringAdapter url, boolean local, boolean alive) throws RemoteException {
        setKClass(process.getClassRepository().getClassByName("org.doovos.api.DSite"));
        setProcess(process);
        setReference(process.getMemorySegment().allocObject(getKClass()));
        setUUID(uuid);
        setName(name);
        setURL(url);
        setAlive(alive);
        setLocal(local);
    }

    public DSiteAdapter(KProcess process, KReference reference) throws RemoteException {
        super(process, Doovos.getSystem().getMemoryManager().getPointer(reference).getKClass(), reference);
    }

    void reload() throws RemoteException {
        name = loadStringAdapter("name", false);
        url = loadStringAdapter("url", false);
        alive = loadBoolean("alive", false);
        local = loadBoolean("local", false);
    }

    public StringAdapter getName() throws RemoteException {
        checkLoaded();
        return name;
    }

    public StringAdapter getURL() throws RemoteException {
        checkLoaded();
        return url;
    }

    public void setName(StringAdapter value) throws RemoteException {
        storeReferenceAdapter("name", false, value, getReference());
        invalidate();
    }

    public void setUUID(StringAdapter value) throws RemoteException {
        storeReferenceAdapter("uuid", false, value, getReference());
        invalidate();
    }

    public void setURL(StringAdapter value) throws RemoteException {
        storeReferenceAdapter("url", false, value, getReference());
        invalidate();
    }

    public void setAlive(boolean value) throws RemoteException {
        getKClass().getField("alive", false).setInstanceValue(getReference(), KBoolean.valueOf(value));
        invalidate();
    }

    public void setLocal(boolean value) throws RemoteException {
        getKClass().getField("local", false).setInstanceValue(getReference(), KBoolean.valueOf(value));
        invalidate();
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isLocal() {
        return local;
    }
}