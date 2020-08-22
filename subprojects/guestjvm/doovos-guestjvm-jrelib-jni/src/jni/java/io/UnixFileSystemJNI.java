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
 * Doovos JAVA JNI is the native implementation (in Doovos sens so in java)
 * of the hotspot java libraries (provided by sun).
 * JNI code is executed on host JVM (in doovos kernel mode)
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
package jni.java.io;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.filesystem.KFileSystemManager;
import org.doovos.kernel.api.filesystem.KFolder;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.jvm.jni.*;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.adapter.RefArrayAdapter;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;
import org.doovos.kernel.api.process.KProcess;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Collection;
import org.doovos.kernel.api.filesystem.KFilePath;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 27 avr. 2009
 * Time: 00:39:29
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("java.io.UnixFileSystem")
public class UnixFileSystemJNI {
    //copied from FileSystem because package protected
    public static final int BA_EXISTS = 0x01;
    public static final int BA_REGULAR = 0x02;
    public static final int BA_DIRECTORY = 0x04;
    public static final int BA_HIDDEN = 0x08;

    public static final int BA_PROCESS = 0x10;
    public static final int BA_MEM_SEGMENT = 0x20;
    public static final int BA_CLASS_REPO = 0x30;
    public static final int BA_SREAM = 0x40;
    public static final int BA_DEVICE = 0x50;
    public static final int BA_SITE = 0x60;

    private final Doovos system = Doovos.getSystem();
    private final KFileSystemManager fileSystemManager = system.getFileSystemManager();

    @JNICALL
    public static void initIDs(JNIEnv env) {
        //TODO DO FIXE ME
    }

    @JNICALL
    public /*String*/String canonicalize0(JNIEnv env, @THIS KReference ref, String path) throws IOException {
        return KFilePath.canonicalize(env.getProcess().getCwd(), path);
    }

    @JNICALL
    public int getBooleanAttributes0(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.io.File") KReference file) throws RemoteException {
        String p = getFilePath(env, file);
        int r = 0;
        KResource resource = fileSystemManager.find(p);
        if (resource != null) {
            r |= BA_EXISTS;
            if (!resource.isLeaf()) {
                r |= BA_DIRECTORY;
            }
            if (resource instanceof KFolder) {
                KFolder f = (KFolder) resource;
                r |= BA_DIRECTORY;
                if (f.isHidden()) {
                    r |= BA_HIDDEN;
                }
            }
            if (resource instanceof KFile) {
                r |= BA_REGULAR;
                KFile f = (KFile) resource;
                if (f.isHidden()) {
                    r |= BA_HIDDEN;
                }
            }
            if (resource instanceof KProcess) {
                r |= BA_PROCESS;
            }
            if (resource instanceof KClassRepository) {
                r |= BA_CLASS_REPO;
            }
            if (resource instanceof KMemorySegment) {
                r |= BA_MEM_SEGMENT;
            }
            if (resource instanceof KMemorySegment) {
                r |= BA_MEM_SEGMENT;
            }
        }
        return r;
    }

    @JNICALL
    public boolean checkAccess(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.io.File") KReference f, boolean write) throws RemoteException {
        String path = getFilePath(env, f);
        KResource kFile = fileSystemManager.find(path);
        if (kFile != null) {
            if (kFile instanceof KFile) {
                KFile r = (KFile) kFile;
                return write ? r.canWrite() : r.canRead();
            } else if (kFile instanceof KFolder) {
                KFolder r = (KFolder) kFile;
                return write ? r.canWrite() : r.canRead();
            }
        }
        return false;
    }

    @JNICALL
    public long getLastModifiedTime(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.io.File") KReference f) throws RemoteException {
        String path = getFilePath(env, f);
        KResource kFile = fileSystemManager.find(path);
        if (kFile != null) {
            if (kFile instanceof KFile) {
                KFile r = (KFile) kFile;
                return r.lastModified();
            } else if (kFile instanceof KFolder) {
                KFolder r = (KFolder) kFile;
                return r.lastModified();
            }
        }
        return 0;
    }

    @JNICALL
    public long getLength(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.io.File") KReference f) throws RemoteException {
        String path = getFilePath(env, f);
        KResource kFile = fileSystemManager.find(path);
        if (kFile != null && kFile instanceof KFile) {
            KFile r = (KFile) kFile;
            return r.length();
        }
        return 0;
    }

    @JNICALL(returnType = "java.lang.String[]")
    public KReference list(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.io.File") KReference f) throws RemoteException {
        String path = getFilePath(env, f);
        KResource kFile = fileSystemManager.find(path);
        if (kFile == null) {
            return null;
        }
        Collection<KResource> resources = fileSystemManager.list(path, null);
        int max = resources.size();
        RefArrayAdapter arr = RefArrayAdapter.newInstance(env.getProcess(), "java.lang.String", max);
        int i = 0;
        for (KResource resource : resources) {
            arr.setArrayReference(i, env.getProcess().getMemorySegment().allocString(resource.getName()));
            i++;
        }
        return arr.getReference();
    }

    private String getFilePath(JNIEnv env, KReference file) throws RemoteException {
        SimpleClassAdapter a = new SimpleClassAdapter(env, file);
        String s = a.getString("path");
        return KFilePath.canonicalize(env.getProcess().getCwd(), s);
    }


    //--------------------------------------------------------
    // JRE 6
    //--------------------------------------------------------

    public static final int ACCESS_READ = 0x04;
    public static final int ACCESS_WRITE = 0x02;
    public static final int ACCESS_EXECUTE = 0x01;

    @JNICALL
    public boolean checkAccess(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.io.File") KReference f, int access) throws RemoteException {
        String path = getFilePath(env, f);
        KResource kFile = fileSystemManager.find(path);
        if (kFile != null) {
            if (kFile instanceof KFile) {
                KFile r = (KFile) kFile;
                switch (access) {
                    case ACCESS_READ: {
                        return r.canRead();
                    }
                    case ACCESS_EXECUTE: {
                        return r.canExecute();
                    }
                    case ACCESS_WRITE: {
                        return r.canWrite();
                    }
                }
            } else if (kFile instanceof KFolder) {
                KFolder r = (KFolder) kFile;
                switch (access) {
                    case ACCESS_READ: {
                        return r.canRead();
                    }
                    case ACCESS_EXECUTE: {
                        return r.canExecute();
                    }
                    case ACCESS_WRITE: {
                        return r.canWrite();
                    }
                }
            }
        }
        return false;
    }

}
