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
package org.doovos.kernel.api;

import java.io.File;
import org.doovos.kernel.api.filesystem.KFileSystemManager;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.filesystem.KWhichLocator;
import org.doovos.kernel.api.jvm.KGarbageCollector;
import org.doovos.kernel.api.jvm.bytecode.KClassDefRepository;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.api.migration.KCostManager;
import org.doovos.kernel.api.process.*;
import org.doovos.kernel.api.security.KCredentials;
import org.doovos.kernel.api.security.KSecurityManager;
import org.doovos.kernel.api.site.KLocalSite;
import org.doovos.kernel.api.site.KSiteManager;

import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.Properties;
import org.doovos.kernel.api.factory.KMemoryFactory;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.filesystem.KFolder;
import org.doovos.kernel.api.io.screen.KLocalScreenDevice;
import org.doovos.kernel.api.io.stream.KLocalInputStream;
import org.doovos.kernel.api.io.stream.KLocalOutputStream;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.jvm.reflect.KLocalClassRepository;
import org.doovos.kernel.api.memory.KLocalMemorySegment;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 20 déc. 2005
 * Time: 23:52:43
 */
public interface KFactory {

    public KCredentials createCredentials(String login,char[] password);
    
    public KSysLog createSysLog(String name);

    public KSecurityManager createSecurityManager();

    public KCostManager createMigrationManager();

    public KLocalSite createSite();

    public KSiteManager createSiteNamingTable();

    public KLocalScreenDevice createScreen() throws RemoteException;

    public KLocalOutputStream createOutputStream(OutputStream out) throws RemoteException;

    public KLocalInputStream createInputStream(InputStream in) throws RemoteException;

    public KInterpreter createInterpreter(Properties envs) throws RemoteException;

    public KGarbageCollector createGarbageCollector(Properties envs) throws RemoteException;

    public KMemoryFactory createMemoryFactory();
//    public KMemoryManager createMemoryManager();

//    public KLocalMemorySegment createMemorySegment(KProcess process, Properties envs, KSegmentDef options) throws RemoteException;
    
    public KLocalClassRepository createClassRepository(KProcess process, Properties envs) throws RemoteException;

    public abstract KFrame createFrame() throws RemoteException;

    public KClassDefRepository createClassDefRepository(final KProcess process) throws RemoteException;

    public KClassLoader createBootstrapClassLoader(final KProcess process, String[] bootstrapPaths) throws RemoteException;

    public KLocalThread createThread(KProcess process, KInterpreter kjvmInterpreter) throws RemoteException;

    public abstract KLocalProcess createProcess(KProcess parentProcess, Properties envs) throws RemoteException;

    public KResource createResource(String path, KResource[] resources) throws RemoteException;

    public KWhichLocator createWhichLocator() throws RemoteException;

    public KFileSystemManager createFileSystemManager() throws RemoteException;

    public KResourceBlocking createParkLock(KLocalThread local) throws RemoteException;
    public KResourceBlocking createAbsoluteTimeLock(KLocalThread local,long time) throws RemoteException;
    public KResourceBlocking createRelativeTimeLock(KLocalThread local,long time) throws RemoteException;
    public KFile createFile(String path, File hostFile) throws RemoteException;
    public KFolder createFolder(String path, File hostFolder) throws RemoteException;
}
