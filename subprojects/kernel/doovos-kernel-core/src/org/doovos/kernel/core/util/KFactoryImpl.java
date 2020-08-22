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
package org.doovos.kernel.core.util;

import java.io.File;
import org.doovos.kernel.api.KFactory;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.KSysLog;
import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.jvm.reflect.KLocalClassRepository;
import org.doovos.kernel.api.process.*;
import org.doovos.kernel.api.security.KCredentials;
import org.doovos.kernel.api.site.KSiteManager;
import org.doovos.kernel.api.migration.KCostManager;
import org.doovos.kernel.api.jvm.bytecode.KClassDefRepository;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.core.filesystem.KFileSystemManagerImpl;
import org.doovos.kernel.core.io.screen.KScreenDeviceTextModeImpl;
import org.doovos.kernel.core.io.stream.KInputStreamImpl;
import org.doovos.kernel.core.io.stream.KOutputStreamImpl;
import org.doovos.kernel.core.jvm.bytecode.KClassDefRepositoryImpl;
import org.doovos.kernel.core.jvm.reflect.KBootstrapClassLoader;
import org.doovos.kernel.core.migration.KCostManagerImpl;
import org.doovos.kernel.core.process.*;
import org.doovos.kernel.core.security.KCredentialsImpl;
import org.doovos.kernel.core.site.KSiteManagerImpl;
import org.doovos.kernel.core.site.KWhichLocatorImpl;
import org.doovos.kernel.core.jvm.gc.KNaiveGarbageCollector;
import org.doovos.kernel.core.jvm.interpreter.KInterpreterIdx;
import org.doovos.kernel.core.security.KSecurityManagerImpl;
import org.doovos.kernel.core.site.KSiteImpl;
import org.doovos.kernel.api.jvm.KGarbageCollector;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.core.jvm.interpreter.KFrameImpl;
import org.doovos.kernel.api.security.KSecurityManager;
import org.doovos.kernel.api.site.KLocalSite;

import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.Properties;
import org.doovos.kernel.api.factory.KMemoryFactory;
import org.doovos.kernel.api.io.screen.KLocalScreenDevice;
import org.doovos.kernel.api.io.stream.KLocalInputStream;
import org.doovos.kernel.api.io.stream.KLocalOutputStream;
import org.doovos.kernel.api.site.KSite;
import org.doovos.kernel.core.filesystem.KFileImpl;
import org.doovos.kernel.core.filesystem.KFolderImpl;
import org.doovos.kernel.core.filesystem.KFusionFolderImpl;
import org.doovos.kernel.core.jvm.reflect.KClassRepositoryImpl;
import org.doovos.kernel.core.memory.KMemoryFactoryImpl;
import org.doovos.kernel.core.memory.KMemoryFactoryImpl32;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 20 déc. 2005
 * Time: 23:53:36
 */
public class KFactoryImpl implements KFactory {
    private static KClassDefRepository classDefRepository;
    
    public KMemoryFactory createMemoryFactory() {
//        return new KMemoryFactoryImpl32();
        return new KMemoryFactoryImpl();
    }
    
    public KCostManager createMigrationManager() {
        return new KCostManagerImpl();
    }

    public KLocalSite createSite() {
        try {
            return new KSiteImpl();
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
    }

    public KSiteManager createSiteNamingTable() {
        return new KSiteManagerImpl();
    }

    public KSecurityManager createSecurityManager() {
        return new KSecurityManagerImpl();
    }

    public KFile createFile(String path, File hostFile) throws RemoteException {
        KFile file = new KFileImpl(path, hostFile);
        return file;
    }

    public KFolder createFolder(String path, File hostFolder) throws RemoteException {
        KFolder folder = new KFolderImpl(path, hostFolder);
        return folder;
    }

    public KLocalScreenDevice createScreen() throws RemoteException {
        KLocalScreenDevice d;
        try {
            d = new KScreenDeviceTextModeImpl();
            //d = new KScreenDeviceTabbedFrameImpl();
        } catch (RemoteException ex) {
            Doovos.getSystem().getLog().error(ex);
            throw new IllegalArgumentException(ex);
        }
        return d;
    }

//    private void register(KResource d) throws RemoteException {
//        KLocalResource local = (KLocalResource) d;
//        Doovos.getSystem().getFileSystemManager().registerLocalResource(local);
//    }
    public KLocalOutputStream createOutputStream(OutputStream out) throws RemoteException {
        KLocalOutputStream d;
        try {
            d = new KOutputStreamImpl(out);
        } catch (RemoteException ex) {
            Doovos.getSystem().getLog().error(ex);
            throw new IllegalArgumentException(ex);
        }
        return d;
    }

    public KLocalInputStream createInputStream(InputStream in) throws RemoteException {
        KLocalInputStream d;
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            try {
                d = new KInputStreamImpl(in);
            } catch (RemoteException ex) {
                Doovos.getSystem().getLog().error(ex);
                throw new IllegalArgumentException(ex);
            }
        }
        return d;
    }

    public KInterpreter createInterpreter(Properties envs) throws RemoteException {
        return KUtils.resolveInstance("Interpreter", envs, KInterpreterIdx.class);
    }

    public KGarbageCollector createGarbageCollector(Properties envs) throws RemoteException {
        return KUtils.resolveInstance("GarbageCollector", envs, KNaiveGarbageCollector.class);
    }

    public KLocalClassRepository createClassRepository(KProcess process, Properties envs) throws RemoteException {
        return KUtils.resolveInstance("ClassRepository", envs, KClassRepositoryImpl.class);
    }

    public KLocalProcess createProcess(KProcess parentProcess, Properties envs) throws RemoteException {
        return KUtils.resolveInstance("Process", envs, KProcessImpl.class);
    }

    public KLocalThread createThread(final KProcess process, KInterpreter kjvmInterpreter) throws RemoteException {
        return new KThreadImpl(process, kjvmInterpreter);
    }

    public KFrame createFrame() throws RemoteException {
        return new KFrameImpl();
    }

    public KClassDefRepository createClassDefRepository(final KProcess process) throws RemoteException {
        if (classDefRepository == null) {
            classDefRepository = new KClassDefRepositoryImpl(Doovos.getSystem().getMemoryFactory());
        }
        return classDefRepository;
    }

    public KClassLoader createBootstrapClassLoader(KProcess process, String[] bootstrapPaths) throws RemoteException {
        KClassDefRepository p = createClassDefRepository(process);
        p.register(bootstrapPaths);
        return new KBootstrapClassLoader(bootstrapPaths, p);
    }

    public KResource createResource(String path, KResource[] resources) throws RemoteException {
        int len = resources.length;
        if (len == 1) {
            return resources[0];
        } else if (resources[0] instanceof KSite) {
            return resources[0];
        }
        return new KFusionFolderImpl(path, resources);
    }

    public KWhichLocator createWhichLocator() throws RemoteException {
        return new KWhichLocatorImpl();
    }

    public KSysLog createSysLog(String name) {
        return new KSysLogImpl(name);
    }

    public KFileSystemManager createFileSystemManager() throws RemoteException {
        return new KFileSystemManagerImpl();
    }

    public KResourceBlocking createParkLock(KLocalThread local) throws RemoteException {
        return KParkResourceBlocking.INSTANCE;
    }

    public KCredentials createCredentials(String login, char[] password) {
        return new KCredentialsImpl(login, password);
    }

    public KResourceBlocking createAbsoluteTimeLock(KLocalThread local, long time) throws RemoteException {
        return new KAbsoluteTimeResourceBlocking(time);
    }

    public KResourceBlocking createRelativeTimeLock(KLocalThread local, long time) throws RemoteException {
        return new KRelativeTimeResourceBlocking(time);
    }

   
}
