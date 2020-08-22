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
package org.doovos.kernel.api.site;

import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.filesystem.KLocalResource;
import org.doovos.kernel.api.io.screen.KScreenDevice;
import org.doovos.kernel.api.process.KLocalThread;

import java.rmi.RemoteException;
import java.util.Collection;
import org.doovos.kernel.api.filesystem.KLocalFileSystem;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 21 déc. 2005
 * Time: 00:36:53
 */
public interface KLocalSite extends KSite, KLocalResource {
    public void shutdown() throws RemoteException;

    public KScreenDevice getScreen() throws RemoteException;

    public void detachResource(KLocalResource oldLocalResource, KResource newRresourceRef, String newSite) throws RemoteException;

    public void threadAttachNative(KLocalThread local) throws RemoteException;

    public void registerResource(KLocalResource resource,String parentPath,String prefix,String suffix) throws RemoteException;

    public void registerResource(KLocalResource resource) throws RemoteException;

    public void unregisterResource(KLocalResource resource) throws RemoteException;

    public Collection<KLocalFileSystem> getLocalFileSystems() throws RemoteException;

    public void mount(String hostPath,String guestPath) throws RemoteException;

    public void umount(String name) throws RemoteException;
}
