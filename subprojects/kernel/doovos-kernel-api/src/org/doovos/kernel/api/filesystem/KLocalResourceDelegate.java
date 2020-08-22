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
package org.doovos.kernel.api.filesystem;

import java.rmi.RemoteException;
import java.util.Collection;

public class KLocalResourceDelegate extends KResourceDelegate implements KLocalResource {
    public KLocalResourceDelegate(KLocalResource delegate) {
        super(delegate);
    }

    public void initResource(String path) throws RemoteException {
        getDelegateLocal().initResource(path);
    }


    protected KLocalResource getDelegateLocal() throws RemoteException {
        return (KLocalResource) super.getDelegate();
    }

    public int getLocalChildrenCount() throws RemoteException {
        return getDelegateLocal().getLocalChildrenCount();
    }

    public Collection<KLocalResource> getLocalChildren() throws RemoteException {
        return getDelegateLocal().getLocalChildren();
    }

    public KLocalResource getLocalChild(String name) throws RemoteException {
        return getDelegateLocal().getLocalChild(name);
    }

    public void detach() throws RemoteException {
        getDelegateLocal().detach();
    }

    public void attach() throws RemoteException {
        getDelegateLocal().attach();
    }

    public void attach(KResource resource) throws RemoteException {
        getDelegateLocal().attach(resource);
    }

    public KResource toRemote() throws RemoteException {
        //TODO delegate the remote??
        return getDelegateLocal().toRemote();
    }

    public void setPath(String path) throws RemoteException {
        getDelegateLocal().setPath(path);
    }

    public void setInternalPath(KInternalPath internalPath) throws RemoteException {
        getDelegateLocal().setInternalPath(internalPath);
    }
}
