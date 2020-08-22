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
package jni.java.lang;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.memory.KMemorySegment;

import java.rmi.RemoteException;

@JNICLASS("java.lang.Throwable")
public class ThrowableJNI {

    @JNICALL(returnType = "java.lang.Throwable")
    public KReference fillInStackTrace(JNIEnv context, @THIS KReference ref) {
        //TODO FIX ME
        return ref;
    }

    @JNICALL
    public int getStackTraceDepth(JNIEnv context, @THIS KReference ref) throws RemoteException {
        return context.getThread().getFramesCount();
    }

    @JNICALL(returnType = "java.lang.StackTraceElement")
    public /*StackTraceElement*/ KReference getStackTraceElement(JNIEnv context, @THIS KReference ref,int index) throws RemoteException {
        KFrame ii = context.getThread().getFrame(index);
        KMemorySegment m = context.getProcess().getMemorySegment();
        KReference elem = context.newInstance("java.lang.StackTraceElement",new String[]{
                "java.lang.String",
                "java.lang.String",
                "java.lang.String",
                "int"
        },
                m.allocString(ii.getKClass().getName()),
                m.allocString(ii.getMethod().getSignature()),
                m.allocString("(unknown sources)"),
                new KInteger(0)

        );
        return elem;
    }
}
