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
package org.doovos.kernel.api.jvm;

import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KMemorySegment;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 mars 2009
 * Time: 09:03:06
 * To change this template use File | Settings | File Templates.
 */
public interface KGarbageCollector {
    /**
     * Run Garabage collection on the memomry segment
     *
     * @param segment target segment
     * @throws RemoteException if RMI exception
     */
    public void gc(KMemorySegment segment) throws RemoteException;

    /**
     * Called if the reference must not be garbage collected (examples are static references class constants ....)
     *
     * @param reference referenced pointer
     * @throws RemoteException if RMI exception
     */
    public void incReferencesCount(KReference reference) throws RemoteException;

    /**
     * Called to enable garbage collection on reference. Garbage Collection is actually activated if references cout is zero
     *
     * @param reference referenced pointer
     * @throws RemoteException if RMI exception
     */
    public void decReferencesCount(KReference reference) throws RemoteException;

    /**
     * Register a source referencatorfor the reference
     *
     * @param reference    referenced pointer
     * @param srcReference referenceator pointer
     * @throws RemoteException if RMI exception
     */
    public void addBackwardReference(KReference reference, KReference srcReference) throws RemoteException;

    /**
     * Unregister a source referencatorfor the reference
     *
     * @param reference    referenced pointer
     * @param srcReference referenceator pointer
     * @throws RemoteException if RMI exception
     */
    public void removeBackwardReference(KReference reference, KReference srcReference) throws RemoteException;

    public void forceFree(KReference reg) throws RemoteException;
}
