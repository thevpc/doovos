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
package org.doovos.kernel.api.process;

import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.jni.KJNIMethod;
import org.doovos.kernel.api.jvm.jni.KJNIMethodInfo;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;
import org.doovos.kernel.api.jvm.KGarbageCollector;
import org.doovos.kernel.api.jvm.jni.KJNINoSuchMethodException;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Interface for Processes handling
 *
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 21 déc. 2005
 * Time: 01:58:04
 */
public interface KProcess extends KResource {
//    public static final int POINTER_PROCESS_COMMANDLINE=0;
//    public static final int POINTER_PROCESS_COMMANDS=16;
//    public static final int POINTER_PROCESS_ARGS=32;
//    public static final int POINTER_PROCESS_ENVS=48;
    //    public static final int POINTER_PROCESS_METADATA=64;
    //    public static final int END_OF_PROCESS = -1;
    public static final int NEXT_STATEMENT = -2;
    //    public static final int FIRST_STATEMENT = 0;
    public static final int THIS_STATEMENT = -3;

//    public String getTitle() throws RemoteException;


    public int getParentPID() throws RemoteException;

    public /*KProcessLiveStatus*/int getStatus() throws RemoteException;


    /**
     * return memory offset
     *
     * @return
     * @throws RemoteException
     */
    //public DMemValue<Integer> allocMemInt() throws RemoteException;
    //public DMemoryPage allocMemPage(long size) throws RemoteException;
    //public DMemValue<int[]> allocMemIntArray(int size) throws RemoteException;
    public KMemorySegment getMemorySegment() throws RemoteException;
    public KMemoryManager getMemoryManager() throws RemoteException;

    public KMemorySegment[] getMemorySegments() throws RemoteException;

    public KMemorySegment getMemorySegment(int index) throws RemoteException;

    public String getCwd() throws RemoteException;
    
    public String getUser() throws RemoteException;

    public void setCwd(String newDir) throws RemoteException;

    public KInputStream getStdin() throws RemoteException;

    public void setStdin(KInputStream stdin) throws RemoteException;

    public KOutputStream getStdout() throws RemoteException;

    public KOutputStream getStderr() throws RemoteException;

    public void setStdout(KOutputStream stdout) throws RemoteException;

    public void setStderr(KOutputStream stdout) throws RemoteException;

    public int getProcessesChildrenCount() throws RemoteException;

    public Collection<KProcess> getProcessesChildren() throws RemoteException;

    int addIndexedMemorySegment(String path) throws RemoteException;

    public void setStatus(/*KProcessRequestedStatus*/int status) throws RemoteException;

    public KClassRepository getClassRepository() throws RemoteException;

    public int getClassRepositoryId() throws RemoteException;

    /**
     * reference to ProcessInfo structure
     *
     * @return
     * @throws RemoteException
     */
    public KReference getGuestReference() throws RemoteException;

    public KReference getInfoReference() throws RemoteException;

    public KClass getKClass() throws RemoteException;

    public void loadNativeLibraryClass(String library) throws RemoteException;

    public KJNIMethodInfo getJNIMethodInfo(String methodFullId) throws RemoteException ;

    public KJNIMethod getJNIMethod(String methodFullId) throws RemoteException;

    public Set<String> getForcedToNativeMethods(String className) throws RemoteException;

    public boolean existsNativeMethod(String methodFullId) throws RemoteException, KJNINoSuchMethodException;
    
    public KRegister invokeNativeMethod(String methodFullId, KFrame frame, KRegister[] parameters) throws RemoteException, KJNINoSuchMethodException;

    public void gc() throws RemoteException;

    public KGarbageCollector getGarbageCollector() throws RemoteException;

    public long maxMemorySize() throws RemoteException;

    public long freeMemorySize() throws RemoteException;

    public KStreamDescriptor getStreamDescriptor(int desc) throws RemoteException;

    public KStreamDescriptor openInputStream(String path) throws RemoteException, IOException;

    public KStreamDescriptor openOutputStream(String path, boolean append) throws RemoteException, IOException;

    public List<KThread> getThreads() throws RemoteException;

    public int getId() throws RemoteException;

}
