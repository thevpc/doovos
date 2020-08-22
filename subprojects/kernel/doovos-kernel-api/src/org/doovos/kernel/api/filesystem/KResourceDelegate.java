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

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

public class KResourceDelegate implements KResource {

    protected KResource delegate;

    public KResourceDelegate(KResource delegate) {
        this.delegate = delegate;
    }

    protected KResource getDelegate() throws RemoteException {
        return delegate;
    }

    public boolean isLeaf() throws RemoteException {
        return getDelegate().isLeaf();
    }

    public KResource getChild(String[] path, int offset) throws RemoteException {
        return getDelegate().getChild(path, offset);
    }

    public String getPath() throws RemoteException {
        return getDelegate().getPath();
    }

    public KInternalPath getInternalPath() throws RemoteException {
        return getDelegate().getInternalPath();
    }

    public String getName() throws RemoteException {
        return getDelegate().getName();
    }

    public void free() throws RemoteException {
        getDelegate().free();
    }

    public KResource getParent() throws RemoteException {
        return getDelegate().getParent();
    }

    public Date getCreationTime() throws RemoteException {
        return getDelegate().getCreationTime();
    }

    public KResourceType getType() throws RemoteException {
        return getDelegate().getType();
    }

    public Object setAttribute(String name, Object newValue) throws RemoteException {
        return getDelegate().setAttribute(name, newValue);
    }

    public Serializable getAttribute(String name) throws RemoteException {
        return getDelegate().getAttribute(name);
    }

    public void addPropertyEventListener(String dPath, String propertyEvent) throws RemoteException {
        getDelegate().addPropertyEventListener(dPath, propertyEvent);
    }

    public void removePropertyEventListener(String dPath, String propertyEvent) throws RemoteException {
        getDelegate().removePropertyEventListener(dPath, propertyEvent);
    }

    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
        getDelegate().onPropertyEvent(event);
    }

    public String getCreationSiteId() throws RemoteException {
        return getDelegate().getCreationSiteId();
    }

    public String getCurrentSiteId() throws RemoteException {
        return getDelegate().getCurrentSiteId();
    }

    public void migrateTo(String siteId) throws RemoteException {
        getDelegate().migrateTo(siteId);
    }

    public boolean isSticky() throws RemoteException {
        return getDelegate().isSticky();
    }

    public void setAttributes(Attributes newValues) throws RemoteException {
        getDelegate().setAttributes(newValues);
    }

    public KLifeStatus getLifeStatus() throws RemoteException {
        return getDelegate().getLifeStatus();
    }

    public String nextChildName(String prefix, String suffix) throws RemoteException {
        return getDelegate().nextChildName(prefix, suffix);
    }
}
