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
package jniperf.java.lang;

import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 11 mai 2009
 * Time: 01:29:15
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS(value="java.lang.Integer",forceJNI=true)
public class IntegerJNIPerf {

    @JNICALL
    public static String toString(JNIEnv env,int i) {
        return Integer.toString(i);
    }

    @JNICALL
    public static int parseInt(JNIEnv env,String v) {
        return Integer.parseInt(v);
    }

    @JNICALL
    public static int parseInt(JNIEnv env,String v,int radix) {
        return Integer.parseInt(v,radix);
    }

    @JNICALL
    public static String toString(JNIEnv env,int i, int radix) {
        return Integer.toString(i,radix);
    }

    @JNICALL
    public static String toHexString(JNIEnv env,int i) {
        return Integer.toHexString(i);
    }

    @JNICALL
    public static String toOctalString(JNIEnv env,int i) {
        return Integer.toOctalString(i);
    }

    @JNICALL
    public static String toBinaryString(JNIEnv env,int i) {
        return Integer.toOctalString(i);
    }
}
