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
package org.doovos.kernel.api.io.stream;

import org.doovos.kernel.api.filesystem.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class KOutputStreamNull implements KOutputStream, KLocalOutputStream {

    public boolean isLeaf() throws RemoteException {
        return true;
    }

    public KResource getChild(String[] path, int offset) throws RemoteException {
        return null;
    }

    public void initResource(String path) throws RemoteException {
        //
    }

    public String getPath() throws RemoteException {
        return null;
    }

    public KInternalPath getInternalPath() throws RemoteException {
        return null;
    }

    public String getName() throws RemoteException {
        return "nullOut";
    }

    public void free() throws RemoteException {
        //
    }

    public KResource getParent() throws RemoteException {
        return null;
    }

    public Date getCreationTime() throws RemoteException {
        return null;
    }

    public KResourceType getType() throws RemoteException {
        return KResourceType.OUTPUT;
    }

    public Object setAttribute(String name, Object newValue) throws RemoteException {
        return null;
    }

    public Serializable getAttribute(String name) throws RemoteException {
        return null;
    }

    public void addPropertyEventListener(String dPath, String propertyEvent) throws RemoteException {
        //
    }

    public void removePropertyEventListener(String dPath, String propertyEvent) throws RemoteException {
        //
    }

    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
        //
    }

    public String getCreationSiteId() throws RemoteException {
        return null;
    }

    public String getCurrentSiteId() throws RemoteException {
        return null;
    }

    public void migrateTo(String siteId) throws RemoteException {
        //
    }

    public boolean isSticky() throws RemoteException {
        return false;
    }

    public int getLocalChildrenCount() throws RemoteException {
        return 0;
    }

    public Collection<KLocalResource> getLocalChildren() throws RemoteException {
        return null;
    }

    public KLocalResource getLocalChild(String name) throws RemoteException {
        return null;
    }

    public void detach() throws RemoteException {
    }

    public void attach() throws RemoteException {
        //Doovos.getLocalSite().registerLocalResource(this);
    }

    public void attach(KResource resource) throws RemoteException {
    }

    public KResource toRemote() throws RemoteException {
        return null;
    }

    public void setPath(String path) throws RemoteException {
    }

    public void setInternalPath(KInternalPath internalPath) throws RemoteException {
    }

    public OutputStream getOutputStream() throws RemoteException {
        return null;
    }

    public void writeln(Object message) throws RemoteException {
    }

    public void writeln(String message) throws RemoteException {
    }

    public void write(String message) throws RemoteException {
    }

    public void writeln(String message, Attributes attributes) throws RemoteException {
    }

    public void write(Object message) throws RemoteException {
    }

    public void write(Object message, Attributes attributes) throws RemoteException {
    }

    public void writeln(Object message, Attributes attributes) throws RemoteException {
    }

    public void write(String message, Attributes attributes) throws RemoteException {
    }

    public void write(int b) throws IOException {
    }

    public void write(byte b[], int off, int len) throws IOException {
    }

    public void setAttributes(Attributes newValues) throws RemoteException {
    }

    public KLifeStatus getLifeStatus() throws RemoteException {
        return KLifeStatus.RUNNING;
    }

    public String nextChildName(String prefix, String suffix) throws RemoteException {
        throw new UnsupportedOperationException("Not supported");
    }
}
