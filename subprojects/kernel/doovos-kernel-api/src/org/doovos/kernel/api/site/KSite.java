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

import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.process.KThread;
import org.doovos.kernel.api.security.KCredentials;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Properties;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 21 déc. 2005
 * Time: 00:36:35
 */
public interface KSite extends KResource {

    public String getUUID() throws RemoteException;
    public KResource[] listResources(String path) throws RemoteException;

    public boolean exists(String pathinternalPath) throws RemoteException;

    public Collection<KResource> listResourcesByParent(String parentPath, KPathFilter filter) throws RemoteException;

    public KMemorySegment allocMemorySegment(KProcess process, KSegmentDef info, Properties envs) throws RemoteException;

    public KClassRepository allocClassRepository(KProcess process, Properties envs) throws RemoteException;

    public abstract KProcess exec(KParentProcessContext parentProcessContext, String classCode, String[] command, Properties env, KCredentials credentials, String workingDir) throws RemoteException;

    public KThread allocThread(KProcess parentProcess, Properties envs,String className, String method, KRegister[] parameters) throws RemoteException;

    public void invalidatePath(String path) throws RemoteException;

    public KResource attachResource(KLocalResource oldResourceCopy, KResource oldResourceRef, String oldSite) throws RemoteException;

    public double getCreationCost(KResourceType type, String path, double localWeigth) throws RemoteException;

    public double getMigrationCost(KResourceType type, double localWeigth, String path, String fromSite) throws RemoteException;

    public KFile openFile(String path, long size) throws IOException;

    public KFile openFolder(String path, boolean mkdirs) throws IOException;



    public void reservatePath(String path) throws RemoteException;

    public void unreservatePath(String path) throws RemoteException;
}
