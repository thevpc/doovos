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

import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;

import java.rmi.RemoteException;

/**
 * JNI implementation
 * User: vpc
 * Date: 24 janv. 2009
 * Time: 22:59:34
 */

/**
 * JNI implementation
 */
@JNICLASS("org.doovos.api.DThread")
public class DThreadJNI {
    //public ProcessInfo getInfo()
    @JNICALL
    public void sleep(JNIEnv env, @THIS KReference ref, long value) throws RemoteException {
        findReference(env, ref).sleep(value);
    }

    @JNICALL
    public void waitChild(JNIEnv env, @THIS KReference ref) throws RemoteException {
        findReference(env, ref).waitChild();
    }

    private KLocalThread findReference(JNIEnv env, KReference ref) throws RemoteException {
        return env.getThread();
    }
}