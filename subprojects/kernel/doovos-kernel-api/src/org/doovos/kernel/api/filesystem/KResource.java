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
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 21 déc. 2005
 * Time: 00:19:25
 */
public interface KResource extends Remote{
    public static enum KLifeStatus {
        INIT,
        RUNNING,
        FREEING,
        FREE
    }

    public boolean isLeaf() throws RemoteException;

    public String nextChildName(String prefix, String suffix) throws RemoteException;

    public KResource getChild(String[] path, int offset) throws RemoteException;

    public String getPath() throws RemoteException;

    public KInternalPath getInternalPath() throws RemoteException;

    public String getName() throws RemoteException;


    public void free() throws RemoteException;

    public KResource getParent() throws RemoteException;

    public Date getCreationTime() throws RemoteException;

    public KResourceType getType() throws RemoteException;

    public Object setAttribute(String name, Object newValue) throws RemoteException;

    public void setAttributes(Attributes newValues) throws RemoteException;

    public Serializable getAttribute(String name) throws RemoteException;

    public void addPropertyEventListener(String dPath, String propertyEvent) throws RemoteException;

    public void removePropertyEventListener(String dPath, String propertyEvent) throws RemoteException;

    public void onPropertyEvent(KPropertyEvent event) throws RemoteException;

    public String getCreationSiteId() throws RemoteException;

    public String getCurrentSiteId() throws RemoteException;

    /**
     * migrate resource the current resource to new localtion (Site named siteId)
     *
     * @param siteId
     * @
     */
    public void migrateTo(String siteId) throws RemoteException;

    /**
     * true when migration is not allowed or has no meaning
     *
     * @return
     * @
     */
    public boolean isSticky() throws RemoteException;

    public KLifeStatus getLifeStatus() throws RemoteException;

}
