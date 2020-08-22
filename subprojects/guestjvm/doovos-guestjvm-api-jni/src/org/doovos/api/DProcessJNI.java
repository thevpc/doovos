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
 * Doovos API is a standard library running on Doovos guest JVM (distributed
 * jvm) to access Doovos mechanisms that are not handled by the Java Platform
 * standard libraries.
 * Il gives access to system processes, system threads, etc...

 * Doovos API JNI is the native implementation (in Doovos sens so in java)
 * of Doovos API.
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
package org.doovos.api;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * JNI implementation
 * User: vpc
 * Date: 24 janv. 2009
 * Time: 22:59:34
 */
/**
 * JNI implementation
 */
@JNICLASS("org.doovos.api.DProcess")
public class DProcessJNI {
    //public ProcessInfo getInfo()

    @JNICALL(returnType = "org.doovos.api.DProcess")
    public static KReference getProcess0(JNIEnv env) throws RemoteException {
        return env.getProcess().getGuestReference();
    }

//    @JNICALL
//    public void gc(JNIEnv env, @THIS KReference ref) throws RemoteException {
//        KProcess process = env.getProcess();
//        process.gc();
//    }
//
//    @JNICALL
//    public long maxMemorySize(JNIEnv env, @THIS KReference ref) throws RemoteException {
//        return findReference(env, ref).maxMemorySize();
//    }
//
//    @JNICALL
//    public long freeMemorySize(JNIEnv env, @THIS KReference ref) throws RemoteException {
//        return findReference(env, ref).freeMemorySize();
//    }
    private KProcess findReference(JNIEnv env, KReference ref) throws RemoteException {
        Collection<KResource> resources = Doovos.getSystem().getFileSystemManager().list(DoovosConstants.PROCESS_PATH, null);
        for (KResource resource : resources) {
            if (resource instanceof KProcess) {
                KProcess p = (KProcess) resource;
                if (p.getGuestReference().equals(ref)) {
                    return p;
                }
            }
        }
        throw new NoSuchElementException();
    }

    @JNICALL(returnType = "int[]")
    public static /*int[]*/ KReference getRootProcesses(JNIEnv env) throws RemoteException {
        Collection<KResource> resources = Doovos.getSystem().getFileSystemManager().list(DoovosConstants.PROCESS_PATH, null);
        ArrayList<Integer> all = new ArrayList<Integer>();
        for (KResource resource : resources) {
            if (resource instanceof KProcess) {
                KProcess p = (KProcess) resource;
                int pid = p.getParentPID();
                if (pid == -1) {
                    all.add(p.getId());
                }
            }
        }
        int[] ret = new int[all.size()];
        for (int i = 0; i < all.size(); i++) {
            ret[i] = all.get(i);
        }
        KMemorySegment m = env.getProcess().getMemorySegment();
        KReference kReference = m.allocIntArray(all.size());
        m.setIntArray(kReference.pointer, ret);
        return kReference;
    }

    @JNICALL
    public static int[] getAllProcesses(JNIEnv env) throws RemoteException {
        Collection<KResource> resources = Doovos.getSystem().getFileSystemManager().list(DoovosConstants.PROCESS_PATH, null);
        ArrayList<Integer> all = new ArrayList<Integer>();
        for (KResource resource : resources) {
            if (resource instanceof KProcess) {
                KProcess p = (KProcess) resource;
                all.add(p.getId());
            }
        }
        int[] ret = new int[all.size()];
        for (int i = 0; i < all.size(); i++) {
            ret[i] = all.get(i);
        }
        return ret;
    }

    @JNICALL
    public static int[] getOwnProcesses(JNIEnv env) throws RemoteException {
        final String currentUser = env.getProcess().getUser();
        Collection<KResource> resources = Doovos.getSystem().getFileSystemManager().list(DoovosConstants.PROCESS_PATH, null);
        ArrayList<Integer> all = new ArrayList<Integer>();
        for (KResource resource : resources) {
            if (resource instanceof KProcess) {
                KProcess p = (KProcess) resource;
                final String user = p.getUser();
                if (currentUser.equals(user)) {
                    all.add(p.getId());
                }
            }
        }
        int[] ret = new int[all.size()];
        for (int i = 0; i < all.size(); i++) {
            ret[i] = all.get(i);
        }
        return ret;
    }

    @JNICALL(returnType = "org.doovos.api.DProcess")
    public static /*DProcess*/ KReference getProcess(JNIEnv env, int pid) throws RemoteException {
        return Doovos.getSystem().getProcess(pid).getGuestReference();
    }

    @JNICALL(returnType = "int[]")
    public /*int[]*/ KReference getChildren(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KProcess process = findReference(env, ref);
        int processesChildrenCount = process.getProcessesChildrenCount();
        Collection<KProcess> processRemoteCollection = process.getProcessesChildren();

        ArrayList<Integer> all = new ArrayList<Integer>();
        for (KProcess resource : processRemoteCollection) {
            all.add(resource.getId());
        }
        int[] ret = new int[all.size()];
        for (int i = 0; i < all.size(); i++) {
            ret[i] = all.get(i);
        }
        KMemorySegment m = env.getProcess().getMemorySegment();
        KReference kReference = m.allocIntArray(all.size());
        m.setIntArray(kReference.pointer, ret);
        return kReference;
    }

    @JNICALL
    public String getClassRepository0(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KProcess process = findReference(env, ref);
        return process.getClassRepository().getPath();
    }

    @JNICALL
    public String[] getMemorySegments0(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KProcess process = findReference(env, ref);
        KMemorySegment[] indices = process.getMemorySegments();
        String[] ids = new String[indices.length];
        for (int i = 0; i < indices.length; i++) {
            ids[i] = indices[i].getPath();
        }
        return ids;
    }
}
