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
package jni.sun.misc;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 28 avr. 2009
 * Time: 03:57:42
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("sun.misc.Signal")
public class SignalJNI {
    static int x = 8;
    private static final KMemoryManager memoryManager = Doovos.getSystem().getMemoryManager();

    @JNICALL
    public static int findSignal(JNIEnv env, @JNIPARAM("java.lang.String") KReference s) throws RemoteException {
        String ss = memoryManager.getString(s);
        if ("HUP".equals(ss)) {
            return 1;
        }
        if ("INT".equals(ss)) {
            return 2;
        }
        if ("TERM".equals(ss)) {
            return 3;
        }
        return -1;
    }

    @JNICALL
    public static long handle0(JNIEnv env, int i, long l) {
        x++;
        return x;
        //TODO FIXE ME
    }

    @JNICALL
    public static void raise0(JNIEnv env, int i) {
        //TODO FIXE ME
    }
}
