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

import org.doovos.kernel.api.boot.BootConfig;
import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;
import org.doovos.kernel.api.io.stream.KLocalOutputStreamDelegate;
import org.doovos.kernel.api.io.stream.KOutputStreamNull;
import org.doovos.kernel.api.io.term.KTerminal;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.migration.KCostManager;
import org.doovos.kernel.api.process.*;
import org.doovos.kernel.api.security.KCredentials;
import org.doovos.kernel.api.security.KSecurityManager;
import org.doovos.kernel.api.site.KSite;
import org.doovos.kernel.api.site.KLocalSite;
import org.doovos.kernel.api.site.KSiteManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;
import org.doovos.kernel.api.factory.KMemoryFactory;
import org.doovos.kernel.api.site.KParentProcessContext;
import org.doovos.kernel.api.util.EmptyArray;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 11 oct. 2004
 * Time: 12:43:41
 */
public final class Doovos {

    public static final DoovosVersion VERSION = DoovosVersion.INSTANCE;
    private static final Doovos system = new Doovos();
    private HashMap<String,Object> systemLocals=new HashMap<String, Object>();
    private KMemoryFactory memoryFactory;
    private KMemoryManager memoryManager;
    private KSecurityManager securityManager;
    private KCostManager costManager;
    private KSiteManager siteManager;
    private KLocalSite localSite;
    private BootConfig bootProperties;
    private KFileSystemManager fileSystemManager;
    private KSysLog log;
    private static KFactory factory;
    private PropertyChangeSupport support;
    public static final KOutputStream nullOut = new KOutputStreamNull();
    public static KWhichLocator whichLocator;
    public static ThreadLocal<KLocalThread> currentThread = new ThreadLocal<KLocalThread>();
    public static final KOutputStream out = new KLocalOutputStreamDelegate(null) {

        @Override
        protected KResource getDelegate() throws RemoteException {
            KProcess p = Doovos.currentProcess();
            return p == null ? nullOut : p.getStdout();
        }
    };

    private static enum Status {

        STARTING,
        STARTED,
        RUNNING,
        SHUTTINGDOWN
    }

    public static enum Event {

        SHUTTING_DOWN,
    }
    private static Status status;
    private String name;
    private String uuid;

    public static Doovos getSystem() {
        return system;
    }

    public String getName() {
        return name;
    }
    public static final Object RESOURCE_ADDED_LOCK = new Object();

    public synchronized void start(BootConfig bootProperties) throws RemoteException {
        uuid = UUID.randomUUID().toString();
        //Console console = Enigma.getConsole(OS_NAME + " v" + OS_VERSION);
        if (status != null) {
            throw new IllegalStateException("Start in progress");
        }
        status = Status.STARTING;
//        System.out.println(">>> " + Doovos.VERSION.getOsHeader() + " starting...");
        this.bootProperties = bootProperties;
        this.name = bootProperties.getStringProperty("name", null, false);
        if (name == null) {
            name = "taha";
            File f = null;
            try {
                f = getBootConfig().getBootFolder().getCanonicalFile();
                if (f.getName().length() >= 0) {
                    name = f.getName();
                }
            } catch (IOException e) {
                //
            }
        }
        KFactory doovosFactory = getFactory();
        whichLocator = doovosFactory.createWhichLocator();
        fileSystemManager = doovosFactory.createFileSystemManager();
        costManager = doovosFactory.createMigrationManager();
        siteManager = doovosFactory.createSiteNamingTable();
        securityManager = doovosFactory.createSecurityManager();
        memoryFactory = doovosFactory.createMemoryFactory();
        memoryManager = memoryFactory.createMemoryManager();
        log = doovosFactory.createSysLog(name);
        log.info("Starting Doovos instance named " + name + " (uuid = " + uuid + ")");
        fileSystemManager.start();
        costManager.start();
        siteManager.start();
        securityManager.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                try {
                    shutdown(false);
                } catch (Exception e) {
                    //no matter if problem
                }
            }
        });
        status = Status.STARTED;

        try {
            localSite = doovosFactory.createSite();
            localSite.attach();
        } catch (RemoteException e) {
            localSite = null;
            throw e;
        } catch (RuntimeException e) {
            localSite = null;
            throw e;
        }
    }

    public void shutdown(boolean forceExit) throws RemoteException {
        if (status == Status.SHUTTINGDOWN) {
            return;
        }
        status = Status.SHUTTINGDOWN;
        try {
            if (costManager != null) {
                costManager.shutdown();
            }
            if (securityManager != null) {
                securityManager.shutdown();
            }
            if (localSite != null) {
                localSite.shutdown();
            }
            if (fileSystemManager != null) {
                fileSystemManager.shutdown();
            }
            if (support != null) {
                support.firePropertyChange(Event.SHUTTING_DOWN.name(), null, Boolean.TRUE);
            }
        } finally {
            if (forceExit) {
                System.exit(0);
            }
        }
    }

    public KSiteManager getSiteManager() {
        return siteManager;
    }

    public KCostManager getCostManager() {
        return costManager;
    }

    public boolean isLocalSite() {
        return localSite != null;
    }

    public KLocalSite getLocalSite() {
        if (localSite == null) {
            throw new NoSuchElementException("No Local Site actived");
        }
        return localSite;
    }

    public KSysLog getLog() {
        return log;
    }

    public BootConfig getBootConfig() {
        return bootProperties;
    }

    public KMemoryFactory getMemoryFactory() {
        return memoryFactory;
    }
    
    public KFactory getFactory() {
        if (factory == null) {
            try {
                String factName = getBootConfig().getFactoryClassName();
                if (factName != null) {
                    Class fclass = Class.forName(factName);
                    factory = (KFactory) fclass.newInstance();
                    //syslog("using factory " + fclass.getName());
                }
            } catch (Throwable e) {
                //
            }
            if (factory == null) {
                try {
                    Class fclass = Class.forName(DoovosConstants.DEFAULT_FACTORY_NAME);
                    factory = (KFactory) fclass.newInstance();
                    System.out.println("using default factory " + DoovosConstants.DEFAULT_FACTORY_NAME);
                } catch (Throwable e) {
                    System.err.println("unable to use default factory " + DoovosConstants.DEFAULT_FACTORY_NAME);
                    System.err.println("shutting down");
                    System.exit(1);
                }
            }
        }
        return factory;
    }

    /**
     * retrives the current DProcessLocal associated with the active Java Thread
     * when null, this means, we still creating the init process (not yet created)
     * if called from a non Doovos valid context throws NoProcessForContextException
     *
     * @return
     * @throws KUnavailableProcessForContextException
     *
     */
    public static KProcess currentProcess() throws KUnavailableProcessForContextException, RemoteException {
        KLocalThread tl = currentThread.get();
        if (tl != null) {
            return tl.getProcess();
        } else if (!Thread.currentThread().getName().equals("main")) {
            throw new KUnavailableProcessForContextException();
        }
        return null;
//        Thread current = Thread.currentThread();
//        if (current instanceof KProcessSchedulerThread) {
//            return ((KProcessSchedulerThread) current).getCurrentThread().getProcess();
//        } else if (!current.getName().equals("main")) {
//            throw new KUnavailableProcessForContextException();
//        }
//        return null;
    }

    public static KLocalThread currentThread() throws KUnavailableProcessForContextException {
        KLocalThread tl = currentThread.get();
        if (tl != null) {
            return tl;
        } else if (!Thread.currentThread().getName().equals("main")) {
            throw new KUnavailableProcessForContextException();
        }
        return null;
//        Thread current = Thread.currentThread();
//        if (current instanceof KProcessSchedulerThread) {
//            return ((KProcessSchedulerThread) current).getCurrentThread();
//        } else if (!current.getName().equals("main")) {
//            throw new KUnavailableProcessForContextException();
//        }
//        return null;
    }

    public KSecurityManager getSecurityManager() {
        return securityManager;
    }

    public KMemoryManager getMemoryManager() {
        return memoryManager;
    }

    public void addSystemListener(PropertyChangeListener listener) {
        if (support == null) {
            support = new PropertyChangeSupport(getSystem());
        }
        support.addPropertyChangeListener(listener);
    }

    public void removeSystemListener(PropertyChangeListener listener) {
        if (support != null) {
            support.removePropertyChangeListener(listener);
        }
    }

    public void addSystemListener(Event event, PropertyChangeListener listener) {
        if (support == null) {
            support = new PropertyChangeSupport(getSystem());
        }
        support.addPropertyChangeListener(event.name(), listener);
    }

    public void removeSystemListener(Event event, PropertyChangeListener listener) {
        if (support != null) {
            support.removePropertyChangeListener(event.name(), listener);
        }
    }

    public KProcess shell(KParentProcessContext parentProcessContext, String[] args, Properties envs, KCredentials credentials, String workingDir) throws RemoteException {
        String shellClass = envs.getProperty("SHELL");
        if (shellClass == null) {
            throw new IllegalArgumentException("SHELL env not set");
        }
        return exec(parentProcessContext, shellClass, args, envs, credentials, workingDir);
    }

    public KProcess exec(KParentProcessContext parentProcessContext, String className, String[] args, Properties envs, KCredentials credentials, String workingDir) throws RemoteException {
        if (args == null) {
            args = EmptyArray.STRINGS;
        }
        KProcess parentProcess = Doovos.currentProcess();
        KSite site;
        site = getCostManager().getSiteForCreation(KResourceType.PROCESS, 1, parentProcess, DoovosConstants.PROCESS_PATH + "/?", envs);
        return site.exec(parentProcessContext, className, args, envs, credentials, workingDir);
    }

    public KThread allocThread(KProcess parentProcess, Properties env, String clazz, String method, KRegister[] parameters) throws RemoteException {
        KSite site;
        site = getCostManager().getSiteForCreation(KResourceType.THREAD, 1, parentProcess, DoovosConstants.PROCESS_PATH + "/?", env);
        return site.allocThread(parentProcess, env, clazz, method, parameters);
    }

    public KProcess getProcess(int pid) throws RemoteException {
        return (KProcess) fileSystemManager.getResource(DoovosConstants.PROCESS_PATH + "/" + String.valueOf(pid));
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
//    public ClassSpec resolveClass(DPath path) throws RemoteException {
//        if(path.toString().startsWith("/runtime/clsrepository/")){
//            return (ClassSpec) Doovos.getResource(path);
//        }
//        for (Site site : Doovos.getSiteNamingTable().getSites()) {
//            site.resolveClass().
//        }
//        return System.currentTimeMillis();
//    }

//    public static KPipeStream openPipe(String from, String to) throws RemoteException {
//        //getFactory().create
//        KPipeStreamImpl dPipeStream;
//        try {
//            dPipeStream = new KPipeStreamImpl(from, to);
//        } catch (RemoteException ex) {
//            Doovos.syslog(ex);
//            throw new IllegalArgumentException(ex);
//        }
//        Doovos.getLocalSite().registerLocalResource(dPipeStream);
//        return dPipeStream;
//    }
    public KInputStream openInputStream(String path) throws RemoteException, IOException {
        KResource r = fileSystemManager.getResource(path);
        if (r instanceof KFile) {
            return ((KFile) r).openInputStream();
        } else if (r instanceof KInputStream) {
            return ((KInputStream) r);
        } else if (r instanceof KTerminal) {
            return ((KTerminal) r).getIn();
        }
        throw new IOException("Invalid type for opening stream : " + r);
    }

    public KOutputStream openOutputStream(KProcess process, String path, KFile.OutFlags flags) throws IOException {
        KResource r = null;
        try {
            r = fileSystemManager.getResource(path);
        } catch (UnknownResourceException e) {
            if (flags.isCreate()) {
                r = openFile(process, path, 0);
            } else {
                throw e;
            }
        }
        if (r instanceof KFile) {
            return ((KFile) r).openOutputStream(flags);
        } else if (r instanceof KOutputStream) {
            return (KOutputStream) r;
        } else if (r instanceof KTerminal) {
            return ((KTerminal) r).getOut();
        }
        throw new IOException("Invalid type for opening stream : " + r);
    }

    public KFile openFile(KProcess process, String path, long size) throws IOException {
        KSite site = getCostManager().getSiteForCreation(KResourceType.FILE, size, process, path, null);
        if (site != null) {
            return site.openFile(path, size);
        } else {
            throw new IOException("No site found");
        }
    }

    public KFile openFolder(KProcess process, String path, boolean mkdirs) throws IOException {
        KSite site = getCostManager().getSiteForCreation(KResourceType.FOLDER, 0, null, path, null);
        if (site != null) {
            return site.openFolder(path, mkdirs);
        } else {
            throw new IOException("No site found");
        }
    }

    public KMemorySegment allocMemorySegment(KProcess process, KSegmentDef info, Properties envs) throws RemoteException {
        KSite site = getCostManager().getSiteForCreation(KResourceType.MEMORY_SEGMENT, info.size, process, null, envs);
        return site.allocMemorySegment(process, info, envs);
    }

    public KClassRepository allocClassRepository(KProcess process, Properties envs) throws RemoteException {
        return getCostManager().getSiteForCreation(KResourceType.CLASS_REPOSITORY, 1, process, null, envs).allocClassRepository(process, envs);
    }

    public synchronized KResource getResourceLenient(String path) throws RemoteException {
        try {
            return fileSystemManager.getResource(path);
        } catch (UnknownResourceException e) {
            return null;
        }
    }

    public KFileSystemManager getFileSystemManager() {
        return fileSystemManager;
    }
    private static final String _MEMORY_SEGMENTS_PATH1 = DoovosConstants.MEMORY_SEGMENTS_PATH + "/";

    public KMemorySegment getMemorySegment(long id) throws RemoteException {
        return (KMemorySegment) fileSystemManager.getResource(_MEMORY_SEGMENTS_PATH1 + (id));
    }
    private static final String _CLASS_REPOSITORY_PATH1 = DoovosConstants.CLASS_REPOSITORY_PATH + "/";

    public KClassRepository getClassRepository(long id) throws RemoteException {
        return (KClassRepository) fileSystemManager.getResource(_CLASS_REPOSITORY_PATH1 + (id));
    }

    public String[] which(String path, String workingDir, String pathEnv, String execExtensionEnv, String packageEnv, boolean rerieveOnlyFirst) throws RemoteException {
        return whichLocator.which(path, workingDir, pathEnv, execExtensionEnv, packageEnv, rerieveOnlyFirst);
    }

    public String getUserHome(String login) {
        return DoovosConstants.HOME_PATH + "/" + login;
    }

    public String getUUID() {
        return uuid;
    }

    public Object getSystemLocal(String name){
        return systemLocals.get(name);
    }

    public void putSystemLocal(String name,Object value){
        if(value==null){
            systemLocals.remove(name);
        }else{
            systemLocals.put(name,value);
        }
    }
}
