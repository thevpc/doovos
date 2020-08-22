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
package org.doovos.kernel.core.site;

import java.io.File;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.boot.BootConfig;
import org.doovos.kernel.api.io.screen.KConstructor;
import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.io.screen.KScreenDevice;
import org.doovos.kernel.api.io.term.KTerminal;
import org.doovos.kernel.api.jvm.bytecode.KInvalidByteCodeImageException;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.adapter.DProcessAdapter;
import org.doovos.kernel.api.process.*;
import org.doovos.kernel.api.security.KCredentials;
import org.doovos.kernel.api.site.KLocalSite;
import org.doovos.kernel.api.site.KSiteEntry;
import org.doovos.kernel.core.security.KCredentialsImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.Principal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.doovos.kernel.api.io.screen.KLocalScreenDevice;
import org.doovos.kernel.api.jvm.reflect.KLocalClassRepository;
import org.doovos.kernel.api.memory.KLocalMemorySegment;
import org.doovos.kernel.api.site.KParentProcessContext;
import org.doovos.kernel.api.site.KSite;
import org.doovos.kernel.core.filesystem.KLocalNativeFileSystem;
import org.doovos.kernel.core.filesystem.KLocalRuntimeFileSystem;
import org.doovos.kernel.core.filesystem.KResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 20:30:42
 */
public class KSiteImpl extends KResourceImpl implements KLocalSite {

    private KLocalScreenDevice screenDevice;
    private LinkedHashMap<String, KLocalFileSystem> localFileSystems = new LinkedHashMap<String, KLocalFileSystem>();
    private KLocalRuntimeFileSystem runtimeFileSystem;
    private int counter = 0;
    private final Doovos system = Doovos.getSystem();
    private String uuid;

    public KSiteImpl() throws RemoteException {
        super(KResourceType.SITE, false);
        uuid = system.getUUID();
    }

    public String getUUID() throws RemoteException {
        return uuid;
    }

    @Override
    public void attach() throws RemoteException {
        runtimeFileSystem = new KLocalRuntimeFileSystem();
        system.getSiteManager().registerLocalSite();
        mount(runtimeFileSystem);
        resolveName();
        super.attach();
        mount(".", "/");
        system.getLog().info("Assigning id : [" + getName() + "] to local site ...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //TODO load mount file (fstab)
        //TODO expect
        // a system folder /system
        // a system folder /program
        // a startup shell for instance /sys/boot.sh and
        // login shell for instance /login.sh
        screenDevice = system.getFactory().createScreen();
        screenDevice.attach();
        KTerminal term = screenDevice.addTerminal(new KConstructor<KTerminal>(KTerminal.class).set(KTerminal.TITLE_PROPERTY, DoovosConstants.DEVICE_TERM_PREFIX));
        //System.setOut(new PrintStream(term.getOut().getOutputStream()));
        //System.setIn(term.getIn().getInputStream());

        KTerminal defaultTerminal = getScreen().getDefaultTerminal();
        try {
            BootConfig booConfig = system.getBootConfig();
            String init = booConfig.getBootClassName();
            String[] args = booConfig.getBootClassArgs();
//            String init="test.B";
//            String[] args=null;
//            String init="org.doovos.shell.interpreter.ShellInterpreter";
//            String[] args=null;
//            String init="org.doovos.usr.ls";
//            String[] args={};
            Properties envs = new Properties();
            envs.setProperty(DoovosConstants.ENV_OS_COPYRIGHTS, Doovos.VERSION.getOsCopyrights());
            envs.setProperty(DoovosConstants.ENV_OS_ID, Doovos.VERSION.getOsId());
            envs.setProperty(DoovosConstants.ENV_OS_NAME, Doovos.VERSION.getOsName());
            envs.setProperty(DoovosConstants.ENV_OS_VERSION, Doovos.VERSION.getOsVersion());
            envs.setProperty(DoovosConstants.ENV_OS_LOCAL_SITE, this.getName());
            envs.setProperty(DoovosConstants.ENV_SYSTEM_TERM, defaultTerminal.getPath());
            envs.setProperty(DoovosConstants.ENV_SYSTEM_STDIN, defaultTerminal.getIn().getPath());
            envs.setProperty(DoovosConstants.ENV_SYSTEM_STDOUT, defaultTerminal.getOut().getPath());
            envs.setProperty(DoovosConstants.ENV_SYSTEM_STDERR, defaultTerminal.getErr().getPath());
            for (Map.Entry<String, String> entry : booConfig.getBootClassEnv().entrySet()) {
                envs.setProperty(entry.getKey(), System.getProperty(entry.getKey(), entry.getValue()));
            }
            system.exec(null,init, args, envs, new KCredentialsImpl(system.getSecurityManager().getSystemLogin(), null), "/");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage(), e);
        } catch (KInvalidByteCodeImageException e) {
            e.printStackTrace();
            throw new RemoteException(e.getMessage(), e);
        }
        system.getSiteManager().invalidatePath("/");
    }

    private void resolveName() throws RemoteException {
        int index = 0;
        String parentPath = DoovosConstants.SITE_PATH;
        while (true) {
            String pp = parentPath + "/" + system.getName();
            if (index > 0) {
                pp += index;
            }
            String nextPath = parentPath + "/" + pp;
            index++;
            ArrayList<KSite> reservated = new ArrayList<KSite>();
            boolean ok = true;
            KSiteEntry[] sites = system.getSiteManager().getSites();
            try {
                for (KSiteEntry site : sites) {
                    try {
                        site.getSite().reservatePath(nextPath);
                        reservated.add(site.getSite());
                    } catch (Exception e) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    initResource(nextPath);
                }
            } finally {
                for (KSiteEntry site : sites) {
                    try {
                        site.getSite().unreservatePath(nextPath);
                    } catch (Exception e) {
                        //ignore
                    }
                }
            }
            if (ok) {
                return;
            }
        }

    }

    @Override
    public String getName() {
        return system.getName();
    }

    @Override
    public boolean isSticky() throws RemoteException {
        return true;
    }

    public void shutdown() {
        system.getLog().info("Local System [" + getName() + "] is shutting down");
        for (KLocalFileSystem dFileSystemDeviceLocal : localFileSystems.values()) {
            try {
                dFileSystemDeviceLocal.shutdown();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        // may be later migrate some of these processes/resources if process is created on another site
        system.getLog().debug("freeing local processes");
        // TODO
        // TODO first free processes
        //TODO then free stream?
        //TODO now free the rest of resources
        system.getLog().debug("Local System [" + getName() + "] dead");
    }

    public KResource attachResource(KLocalResource oldResourceCopy, KResource oldResourceRef, String oldSite) throws RemoteException {
        oldResourceCopy.attach(oldResourceRef);
        //no need for export of UnicastRemoteObject, it will reexport him self on deserialize
        //UnicastRemoteObject.exportObject(oldResourceCopy);
        return oldResourceCopy;
    }

    public void detachResource(KLocalResource oldLocalResource, KResource newRresourceRef, String newSite) throws RemoteException {
        system.getFileSystemManager().invalidate(oldLocalResource.getPath(), false);
        oldLocalResource.detach();
        try {
            UnicastRemoteObject.unexportObject(oldLocalResource.toRemote(), true);
        } catch (NoSuchObjectException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    public ExecutorService threadPool;

    public void threadAttachNative(KLocalThread local) {
        //try {
        //syslog(local.getId() + "." + System.identityHashCode(local.getId()) + " attach thread ");
        //new Throwable().printStackTrace(System.out);
        //} catch (RemoteException ex) {
        //    ex.printStackTrace();
        //}
        if (threadPool == null) {

            threadPool = new ThreadPoolExecutor(10,
                    100,
                    1,
                    TimeUnit.HOURS,
                    new LinkedBlockingQueue<Runnable>()) {

                @Override
                protected void beforeExecute(Thread t, Runnable r) {
                    super.beforeExecute(t, r);
                    KLocalThread thread = ((KRunnableAdapter) r).getThread();
//                    t.setPriority(thread.getPriority());
                    Doovos.currentThread.set(thread);
                }
            };
        }
        threadPool.execute(new KRunnableAdapter(local));
    }

    private class KRunnableAdapter implements Runnable {

        private KLocalThread thread;

        public KRunnableAdapter(KLocalThread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.run();
            } catch (RemoteException ex) {
                system.getLog().error(ex);
            }
        }

        public KLocalThread getThread() {
            return thread;
        }
    }

    public KProcess exec(KParentProcessContext parentProcessContext, String classCode, String[] command, Properties envs, KCredentials credentials, String workingDir) throws RemoteException {
        String parentLogin = null;
        String parentWorkingDir = null;
        Properties allEnv = new Properties();
        KProcess parentProcess = null;
        if (parentProcessContext != null && parentProcessContext.getPid() != -1) {
            parentLogin = parentProcessContext.getLogin();
            parentWorkingDir = parentProcessContext.getCwd();
            allEnv.putAll(parentProcessContext.getEnvs());
        }
        String user = null;
        if (parentLogin == null) {
            if (credentials == null) {
                throw new IllegalArgumentException("Unknown credentials");
            }
            //don't checkValidUser because 'system' login is not valid
            //Doovos.getSecurityManager().checkValidUser(credentials.getLogin());
            user = credentials.getLogin();
        } else if (system.getSecurityManager().isRoot(parentLogin)) {
            if (credentials != null) {
                system.getSecurityManager().checkValidUser(credentials.getLogin());
                user = credentials.getLogin();
            } else {
                user = parentLogin;
            }
        } else {
            if (credentials != null) {
                Principal principal = system.getSecurityManager().login(credentials);
                user = principal.getName();
            } else {
                user = parentLogin;
            }
        }
        if (workingDir == null) {
            workingDir = parentWorkingDir;
        }
        if (workingDir == null) {
            throw new IllegalArgumentException("Unknown working dir");
        }
        if (envs != null) {
            allEnv.putAll(envs);
        }
        allEnv.setProperty("USER", user);
        
        KLocalProcess process = system.getFactory().createProcess(parentProcess, allEnv);
        process.loadNativeLibraryClass("jni.java.lang.ObjectJNI");
        process.loadNativeLibraryClass("org.doovos.api.DSystemJNI");
        process.attach();
        process.initialize(classCode, parentProcessContext==null?-1:parentProcessContext.getPid(), command, allEnv, user, workingDir);
        //main thread will always be created where the process is
        KLocalThread thread = (KLocalThread) allocThread(process, allEnv, classCode, "main([Ljava/lang/String;)V",
                new KRegister[]{
                    new DProcessAdapter(process, process.getInfoReference()).getArguments().getReference()
                });
//        KClass systemClass = process.getClassRepository().getClassByName("java.lang.System");
//        KMethodDef initializeSystemClass_method = systemClass.getDefinition().getMethodBySignature("initializeSystemClass()V");
//        thread.pushFrame(systemClass,initializeSystemClass_method,KRegister.EMPTY_ARRAY);
//        thread.getFrame().initializeClass(systemClass);
        process.setStatus(KProcessRequestedStatus.READY);
        thread.start();
        return process;
    }

    public KThread allocThread(KProcess parentProcess, Properties envs, String className, String method, KRegister[] parameters) throws RemoteException {
        KLocalThread thread;
        KInterpreter kjvmInterpreter = system.getFactory().createInterpreter(envs);
        try {
            thread = system.getFactory().createThread(parentProcess, kjvmInterpreter);
        } catch (RemoteException ex) {
            system.getLog().error(ex);
            throw new IllegalArgumentException(ex);
        }
        thread.initialize(parentProcess,kjvmInterpreter, className, method, parameters);
        thread.requestStatus(KProcessRequestedStatus.READY);
        return thread;
    }

    public KScreenDevice getScreen() {
        return screenDevice;
    }

//    public Collection<DScreenDevice> getDevices() {
//        ArrayList<DScreenDevice> dScreenDevices = new ArrayList<DScreenDevice>();
//        if (screenDevice != null) {
//            dScreenDevices.add(screenDevice);
//        }
//        return dScreenDevices;
//    }
    public KMemorySegment allocMemorySegment(KProcess process, KSegmentDef info, Properties envs) throws RemoteException {
        KLocalMemorySegment seg = system.getMemoryFactory().createMemorySegment(process, envs, info);
        seg.init(process, info);
        seg.attach();
        //Doovos.getLocalSite().registerLocalResource((KResourceLocal) seg);
        return seg;
    }

    public KLocalClassRepository allocClassRepository(KProcess process, Properties envs) throws RemoteException {
        KLocalClassRepository r = system.getFactory().createClassRepository(process, envs);
        r.attach();
        return r;
    }

    public double getCreationCost(KResourceType type, String path, double localWeigth) throws RemoteException {
        return getBestCostForCreation(path, type, localWeigth);
    }

    public double getMigrationCost(KResourceType type, double localWeigth, String path, String fromSite) throws RemoteException {
        return getCreationCost(type, path, localWeigth);
    }

    public KFile openFile(String path, long size) throws IOException {
        KLocalFileSystem fs = getBestFSForCreation(path, KResourceType.FILE, size);
        if (fs == null) {
            throw new IllegalArgumentException("Unable to create Resource");
        }
        return (KFile) fs.openFile(path, size).toRemote();
    }

    public KFile openFolder(String path, boolean mkdirs) throws IOException {
        KLocalFileSystem fs = getBestFSForCreation(path, KResourceType.FOLDER, 0);
        if (fs == null) {
            throw new IllegalArgumentException("Unable to create Resource");
        }
        return (KFile) fs.openFolder(path, mkdirs).toRemote();
    }

    private KLocalFileSystem getBestFSForCreation(String path, KResourceType type, double localWeigth) throws RemoteException, FileNotFoundException {
        KLocalFileSystem ok = null;
        Double d = Double.NaN;
        for (KLocalFileSystem dFileSystemDeviceLocal : getLocalFileSystems()) {
            if (dFileSystemDeviceLocal.acceptPath(path)) {
                double d2 = dFileSystemDeviceLocal.getCreationCost(type, localWeigth);
                if (!Double.isInfinite(d2) && !Double.isNaN(d2) && (Double.isNaN(d) || d2 < d)) {
                    d = d2;
                    ok = dFileSystemDeviceLocal;
                }
            }
        }
        return ok;
    }

    private double getBestCostForCreation(String path, KResourceType type, double localWeigth) throws RemoteException {
        Double d = Double.NaN;
        for (KLocalFileSystem fs : getLocalFileSystems()) {
            if (fs.acceptPath(path)) {
                double d2 = fs.getCreationCost(type, localWeigth);
                if (!Double.isInfinite(d2) && !Double.isNaN(d2) && (Double.isNaN(d) || d2 < d)) {
                    d = d2;
                }
            }
        }
        return d;
    }

    public boolean exists(String path) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            for (KLocalFileSystem fs : localFileSystems.values()) {
                if (fs.acceptPath(path)) {
                    if (fs.exists(path)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public KResource[] listResources(String path) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            ArrayList<KResource> all = new ArrayList<KResource>();
            if (localFileSystems.size() == 0) {
                if (runtimeFileSystem.acceptPath(path)) {
                    KLocalResource r = runtimeFileSystem.getResource(path);
                    if (r != null) {
                        all.add(r);
                    }
                }
            } else {
                for (KLocalFileSystem dFileSystemDevice : localFileSystems.values()) {
                    if (dFileSystemDevice.acceptPath(path)) {
                        KLocalResource r = dFileSystemDevice.getResource(path);
                        if (r != null) {
                            all.add(r);
                        }
                    }
                }
            }
            return all.toArray(new KResource[all.size()]);
        }
    }

    public Collection<KResource> listResourcesByParent(String parentPath, KPathFilter filter) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            ArrayList<KResource> all = new ArrayList<KResource>();
            for (KLocalFileSystem fs : localFileSystems.values()) {
                if (fs.acceptPath(parentPath)) {
                    Collection<KLocalResource> r = fs.getResourcesList(parentPath, filter);
                    if (r != null) {
                        for (KLocalResource dResourceLocal : r) {
                            all.add(dResourceLocal);
                        }
                    }
                }
            }
            return all;//.toArray(new DResource[0]);
        }
    }

    public void invalidatePath(String path) throws RemoteException {
        //TODO
        //Doovos.getSystem().getFileSystemManager().invalidate(path, true);
    }

    public void mount(KLocalFileSystem provider) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            provider.attach();
            localFileSystems.put(provider.getPath(), provider);
        }
    }

    private String generateLocalName(String parent, String prefix, String suffix) throws RemoteException {
        if (prefix == null) {
            prefix = "";
        }
        if (suffix == null) {
            suffix = "";
        }
        boolean first = false;
        String id = "";
//        String id = "rombatakaya_";
        if (first) {
            Collection<KResource> strms = listResourcesByParent(parent, null);
            Set<String> ts = new HashSet<String>();
            for (KResource dResource : strms) {
                ts.add(dResource.getName());
            }
            while (true) {
                String rnd = Long.toHexString(Double.doubleToLongBits(Math.random())) + Long.toHexString(System.currentTimeMillis());
                String name = prefix + rnd + suffix;
                if (!ts.contains(name)) {
                    String s = name + counter;
                    counter++;
                    return s;
                }
            }
        } else {
            prefix = id + prefix;
            Collection<KResource> strms = listResourcesByParent(parent, null);
            Set<String> ts = new HashSet<String>();
            for (KResource dResource : strms) {
                ts.add(dResource.getName());
            }
            for (int i = 0; i < 1000; i++) {
                String name = prefix + i + suffix;
                if (!ts.contains(name)) {
                    String s = name + counter;
                    counter++;
                    return name;
                }
            }
        }
        return null;
    }
    private HashSet<String> reservatedPaths = new HashSet<String>();

    public void reservatePath(String path) throws RemoteException {
        if (!reservatedPaths.add(path) || exists(path)) {
            throw new IllegalArgumentException("Already reservated path " + path);
        }
        reservatedPaths.add(path);
    }

    public void unreservatePath(String path) {
        if (!reservatedPaths.remove(path)) {
            throw new IllegalArgumentException("Not reservated yet path " + path);
        }
    }

    public void registerResource(KLocalResource resource) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            runtimeFileSystem.registerResource(resource);
        }
    }

    public void registerResource(final KLocalResource resource, String parentPath, String prefix, String suffix) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            String path = resource.getPath();
            if (path == null) {
                system.getFileSystemManager().nextName(parentPath, prefix, suffix, new KNameAction() {

                    public void nameReserved(String parentPath, String name) {
                        try {
                            resource.initResource(parentPath + "/" + name);
                            runtimeFileSystem.registerResource(resource);
                        } catch (RemoteException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                });
            }
        }
    }

    public void unregisterResource(KLocalResource resource) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            runtimeFileSystem.unregisterResource(resource);
        }
    }

    public Collection<KLocalFileSystem> getLocalFileSystems() {
        return localFileSystems.values();
    }

    public void mount(String hostPath, String guestPath) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            File localFolder = new File(hostPath);
            if(!localFolder.isAbsolute()){
                localFolder=new File(system.getBootConfig().getBootFolder(),hostPath);
            }
            if (!localFolder.exists() || !localFolder.isDirectory()) {
                throw new RuntimeException("native path does not exist or is not a valid folder");
            }
            mount(new KLocalNativeFileSystem(localFolder, DoovosConstants.FILE_PATH + "/" + guestPath));
        }
    }

    public void umount(String name) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            KLocalFileSystem dev = localFileSystems.get(name);
            if (dev != null) {
                dev.shutdown();
                localFileSystems.remove(name);
            }
        }
    }
}
