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

import org.doovos.kernel.api.KFactory;
import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KLocalFileSystem;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Vector;
import org.doovos.kernel.api.DoovosConstants;

/**
 * @author vpc
 */
public class KLocalNativeFileSystem extends KPrefixedPathRuntimeResourceImpl implements KLocalFileSystem {

    private File nativePath;
    private String mountPath;
    //private Hashtable<DPath,DResourceLocal> cache=new Hashtable<DPath, DResourceLocal>();
    private final Doovos system = Doovos.getSystem();
    private KFactory factory ;

    public KLocalNativeFileSystem(File nativePath, String mountPath) throws RemoteException {
        super(KResourceType.FILE_SYSTEM, false,DoovosConstants.DEVICE_PATH,"fsnt",null);
        this.nativePath = nativePath;
        this.mountPath = new KFilePath(mountPath).canonicalize();
        factory = system.getFactory();
    }

    public boolean acceptPath(String path) {
        return path.equals(mountPath) || path.startsWith(mountPath + "/");
    }

    public KLocalResource getResource(String path) {
        return wrap(toFile(path), path);
    }

    public boolean exists(String path) throws RemoteException {
        File f = toFile(path);
        return f != null && f.exists();
    }

    public KLocalResource openFile(String path, long size) throws IOException {
        File hostFile = toFile(path);
        if (hostFile.exists()) {
            throw new IllegalArgumentException("File Already Exists");
        }
        if (hostFile.createNewFile()) {
            KFile kf = factory.createFile(path, hostFile);
            ((KLocalResource) kf).attach();
            return (KLocalResource) kf;
        }
        throw new IllegalArgumentException("Unable to create file");
    }

    public KLocalResource openFolder(String path, boolean mkdirs) throws IOException {
        File hostFile = toFile(path);
        if (hostFile.exists()) {
            throw new IllegalArgumentException("Folder Already Exists");
        }
        if ((mkdirs && !hostFile.mkdirs()) || !hostFile.mkdir()) {
            throw new IllegalArgumentException("Unable to create folder");
        }
        KFile kf = factory.createFile(path, hostFile);
        ((KLocalResource) kf).attach();
        return (KLocalResource) kf;
    }

    public double getCreationCost(KResourceType type, double localWeigth) throws RemoteException {
        switch (type) {
            case FILE: {
                return localWeigth < 1024 ? 10 : (localWeigth < 1024 * 1024) ? 50 : (localWeigth < 1024 * 1024 * 1024) ? 80 : 100;
            }
            case FOLDER: {
                return localWeigth;
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    private File toFile(String path) {
        String s = path;
        s = s.substring(mountPath.length());
        while (s.length() > 0 && s.charAt(s.length() - 1) == '/') {
            s = s.substring(0, s.length() - 1);
        }
        while (s.length() > 0 && s.charAt(0) == '/') {
            s = s.substring(1);
        }
        if (s.length() == 0) {
            return nativePath;
        }
        return new File(nativePath, s);
    }

    public Collection<KLocalResource> getResourcesList(String path, KPathFilter filter) {
        Collection<KLocalResource> all = new Vector<KLocalResource>();
        if (acceptPath(path)) {
            File f = toFile(path);
            if (f.exists()) {
                File[] files = f.listFiles();
                if (files != null) {
                    for (File file : files) {
                        String pp = path + "/" + file.getName();
                        if (filter == null || (filter.accept(pp))) {
                            KLocalResource r = wrap(file, pp);
                            if (r != null) {
                                all.add(r);
                            }
                        }
                    }
                }
            }
        }
        return all;
    }

    private KLocalResource wrap(File hostFile, String path) {
        if (hostFile.exists()) {
            if (hostFile.isDirectory()) {
                try {
                    KFolder kf = factory.createFolder(path, hostFile);
                    ((KLocalResource) kf).attach();
                    return (KLocalResource) kf;
                } catch (RemoteException ex) {
                    system.getLog().error(ex);
                }
            } else {
                try {
                    KFile kf = factory.createFile(path, hostFile);
                    ((KLocalResource) kf).attach();
                    return (KLocalResource) kf;
                } catch (RemoteException ex) {
                    system.getLog().error(ex);
                }
            }
        }
        return null;
    }

    public void shutdown() {
        system.getLog().info("Shutdown " + toString());
    }

    @Override
    public void attach() throws RemoteException {
        system.getLog().info("Start " + toString());
        super.attach();
    }

    public String getMountPoint() {
        return mountPath;
    }

    @Override
    public String toString() {
        return "NativeFS:" + nativePath.getPath();
    }
}
