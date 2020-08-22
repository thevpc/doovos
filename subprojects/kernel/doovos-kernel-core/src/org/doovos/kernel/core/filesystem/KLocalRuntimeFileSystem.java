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
package org.doovos.kernel.core.filesystem;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

public class KLocalRuntimeFileSystem extends KPrefixedPathRuntimeResourceImpl implements KLocalFileSystem {

    private final Object registerResourceLock = new Object();
    private Map<String, KLocalResource> staticFolders = new HashMap<String, KLocalResource>();
    private Map<String, KLocalResource> runtimeResource = new HashMap<String, KLocalResource>();
    private Map<String, List<KLocalResource>> runtimeResourceByParent = new HashMap<String, List<KLocalResource>>();

    public KLocalRuntimeFileSystem() throws RemoteException {
        super(KResourceType.FILE_SYSTEM, false, DoovosConstants.DEVICE_PATH, "fsrt", null);
    }

    public boolean acceptPath(String path) {
        return true;//path.getCanonicalPath().toString().startsWith(DoovosConstants.RUNTIME_PATH.toString()+"/");
    }

    public String getMountPoint() {
        return "/";
    }

    @Override
    public String toString() {
        return "RuntimeFS[" + Doovos.getSystem().getName() + "]";
    }

    public KLocalResource getResource(String path) {
        synchronized (registerResourceLock) {
            KLocalResource r = staticFolders.get(path);
            if (r != null) {
                return r;
            }
            r = runtimeResource.get(path);
            if (r != null) {
                return r;
            }
            return null;
        }
    }

    public boolean exists(String path) throws RemoteException {
        synchronized (registerResourceLock) {
            return staticFolders.containsKey(path) || runtimeResource.containsKey(path);
        }
    }

    public Collection<KLocalResource> getResourcesList(String path, KPathFilter filter) throws RemoteException {
        synchronized (registerResourceLock) {
            List<KLocalResource> list = runtimeResourceByParent.get(path);
            if (list == null) {
                list = Collections.EMPTY_LIST;
            }
            ArrayList<KLocalResource> ok = new ArrayList<KLocalResource>();
            for (KLocalResource dResourceLocal : list) {
                if (filter == null || (filter.accept(dResourceLocal.getPath()))) {
                    ok.add(dResourceLocal);
                }
            }
            return ok;
        }
    }

    private void registerFolder(KLocalFolder f) throws RemoteException {
        synchronized (registerResourceLock) {
            f.attach();
//            String path = f.getPath();
//            f.initResource(path);
//            staticFolders.put(path, f);
//            if (!path.equals("/")) {
//                String ppath = new KFilePath(f.getPath()).getParentPath();
//                List<KLocalResource> list = runtimeResourceByParent.get(ppath);
//                if (list == null) {
//                    list = new Vector<KLocalResource>();
//                    runtimeResourceByParent.put(ppath, list);
//                }
//                list.add(f);
//            }
        }
    }

    public void registerResource(KLocalResource f) throws RemoteException {
        synchronized (registerResourceLock) {
            if (f.getLifeStatus() != KLifeStatus.RUNNING) {
                throw new IllegalArgumentException("registerResource : invalid state : " + f.getLifeStatus()+" for "+f.getPath());
            }
            String path = f.getPath();
//            System.err.println(">> " + path);
            String ppath = new KFilePath(path).getParentPath();
            if (runtimeResource.containsKey(path)) {
                Doovos.getSystem().getLog().error("registerResource : DUPLICATE : " + path);
                Doovos.getSystem().getLog().error("\t" );
                throw new IllegalArgumentException("registerResource : DUPLICATE : " + path);
            }
            KLocalResource parent = getResource(ppath);
            if (parent != null) {
                List<KLocalResource> list = runtimeResourceByParent.get(ppath);
                if (list == null) {
                    list = new Vector<KLocalResource>();
                    runtimeResourceByParent.put(ppath, list);
                }
                list.add(f);
            }
            runtimeResource.put(path, f);
//            System.out.println("[" + getClass().getName()+" ] ADD : "+f.getPath());
        }
//        System.out.println("registerResource : "+f.getPath());
    }

    private void _unregisterResource(KResource f) throws RemoteException {
        _unregisterResource(f.getPath(), "  ");
    }

    private void _unregisterResource(String path, String logPrefix) throws RemoteException {
        synchronized (registerResourceLock) {
            System.err.println(logPrefix + "<< start unregister " + path);
            if (!runtimeResource.containsKey(path)) {
                throw new NoSuchElementException("Resource " + path + " not found in " + this);
            }
            runtimeResource.remove(path);
//            System.out.println("[" + getClass().getName()+" ] REMOVE : "+path);
//        System.out.println("unregisterResource : "+f.getPath());
            //String parentPath = KFileUtilities.getGuestParentPath(path);


            //remove path hierarchy
            List<KLocalResource> list = runtimeResourceByParent.get(path);
            if (list != null && list.size() > 0) {
                throw new NoSuchElementException("Resource Children still alive under " + path + " (" + list + ")");
//                for (KLocalResource c : list.toArray(new KLocalResource[list.size()])) {
//                    unregisterResource(c.getPath(),logPrefix+"   ");
//                }
//                list.clear();
            }
            runtimeResourceByParent.remove(path);

            //remove path from parent

            String parentPath = new KFilePath(path).getParentPath();
            //remove path hierarchy
            list = runtimeResourceByParent.get(parentPath);
            if (list != null) {
                for (Iterator<KLocalResource> i = list.iterator(); i.hasNext();) {
                    KLocalResource c = i.next();
                    if (c.getPath().equals(path)) {
                        i.remove();
                        break;
                    }
                }
            }
            System.err.println(logPrefix + "<< end unregister " + path);
//            Doovos.getLog().debug("Unregister "+path);
        }
    }

    public void unregisterResource(KResource f) throws RemoteException {
        synchronized (registerResourceLock) {
            String path=f.getPath();
            if (!runtimeResource.containsKey(path)) {
                throw new NoSuchElementException("Resource " + path + " not found in " + this);
            }
            runtimeResource.remove(path);
            List<KLocalResource> list = runtimeResourceByParent.get(path);
            if (list != null && list.size() > 0) {
                throw new NoSuchElementException("Resource Children still alive under " + path + " (" + list + ")");
            }
            runtimeResourceByParent.remove(path);
            String parentPath = new KFilePath(path).getParentPath();
            //remove path hierarchy
            list = runtimeResourceByParent.get(parentPath);
            if (list != null) {
                for (Iterator<KLocalResource> i = list.iterator(); i.hasNext();) {
                    KLocalResource c = i.next();
                    if (c.getPath().equals(path)) {
                        i.remove();
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void attach() throws RemoteException {
        try {
            Doovos.getSystem().getLog().info("Starting runtime provider");
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.ROOT_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.RUNTIME_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.FILE_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.HOME_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.USER_ALL_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.USERS_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.PROCESS_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.MEMORY_SEGMENTS_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.CLASS_REPOSITORY_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.STREAM_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.DEVICE_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.SYSTEM_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.SYSTEM_BOOT_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.USER_ROOT_PATH)));
            registerFolder(new KRuntimeFolderImpl((DoovosConstants.USER_DEFAULT_PATH)));
//            registerFolder(new KRuntimeFolderImpl((DoovosConstants.SITE_PATH)));
//            for (KSiteEntry kSiteEntry : Doovos.getSystem().getSiteManager().getSites()) {
//
//            }
            //registerFolder(new SFolderImpl(DoovosConstants.PROGRAM_PATH));
        } catch (RemoteException ex) {
            Doovos.getSystem().getLog().error(ex);
            throw new RuntimeException(ex);
        }
        super.attach();
    }

    public void shutdown() {
        Doovos.getSystem().getLog().info("Shutdown runtime provider");
    }

    public double getCreationCost(KResourceType type, double localWeigth) throws RemoteException {
        switch (type) {
            case MEM: {
                //Runtime.getRuntime().freeMemory()
                return localWeigth < 5 ? 10 : (localWeigth < 100) ? 50 : 100;
            }
            case PROCESS: {
                int size = getResourcesList(DoovosConstants.PROCESS_PATH, null).size();
                int s2 = size + ((int) localWeigth);
                return s2 < 5 ? 10 : (localWeigth < 100) ? 50 : 100;
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    public KLocalResource openFile(String path, long size) throws IOException {
        throw new IllegalArgumentException("Unsupported");
    }

    public KLocalResource openFolder(String path, boolean mkdirs) throws IOException {
        throw new IllegalArgumentException("Unsupported");
    }
}
