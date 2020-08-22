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
import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KReference;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;


@JNICLASS(value="java.lang.String",forceJNI=true)
public class StringJNIPerf {

    @JNICALL
    public static String valueOf(JNIEnv env, char[] data) throws Exception {
        return new String(data);
    }

    @JNICALL
    public static String valueOf(JNIEnv env, char[] data, int offset, int count) throws RemoteException {
        return new String(data, offset, count);
    }

    @JNICALL
    public static String copyValueOf(JNIEnv env, char[] data, int offset, int count) throws RemoteException {
        return new String(data, offset, count);
    }
    private final KMemoryManager memoryManager;

    public StringJNIPerf() {
        memoryManager = Doovos.getSystem().getMemoryManager();
    }

    @JNICALL
    public int hashCode(JNIEnv env, @THIS KReference ref) throws RemoteException {
        return memoryManager.getString(ref).hashCode();
    }

    @JNICALL
    public static String valueOf(JNIEnv env, int i) {
        return String.valueOf(i);
    }

    @JNICALL
    public static String valueOf(JNIEnv env, long i) {
        return String.valueOf(i);
    }

    @JNICALL
    public static String valueOf(JNIEnv env, float i) {
        return String.valueOf(i);
    }

    @JNICALL
    public static String valueOf(JNIEnv env, double i) {
        return String.valueOf(i);
    }

//    @JNICALL
//    public static String valueOf(JNIEnv env, short i) {
//        return String.valueOf(i);
//    }

    @JNICALL
    public static String valueOf(JNIEnv env, boolean i) {
        return String.valueOf(i);
    }

    @JNICALL
    public int indexOf(JNIEnv env, @THIS KReference ref, int ch) throws RemoteException {
        return memoryManager.getString(ref).indexOf(ch);
    }

    @JNICALL
    public int indexOf(JNIEnv env, @THIS KReference ref, int ch, int fromIndex) throws RemoteException {
        return memoryManager.getString(ref).indexOf(ch, fromIndex);
    }

    @JNICALL
    public int lastIndexOf(JNIEnv env, @THIS KReference ref, int ch) throws RemoteException {
        return memoryManager.getString(ref).lastIndexOf(ch);
    }

    @JNICALL
    public int lastIndexOf(JNIEnv env, @THIS KReference ref, int ch, int fromIndex) throws RemoteException {
        return memoryManager.getString(ref).lastIndexOf(ch, fromIndex);
    }


    @JNICALL
    public boolean startsWith(JNIEnv env, @THIS KReference ref, String prefix, int toffset) throws RemoteException {
        String this_string = memoryManager.getString(ref);
        String prefix_string = prefix;
        return this_string.startsWith(prefix_string, toffset);
    }

    @JNICALL
    public boolean startsWith(JNIEnv env, @THIS KReference ref, String prefix) throws RemoteException {
        String this_string = memoryManager.getString(ref);
        String prefix_string = prefix;
        return this_string.startsWith(prefix_string);
    }

    @JNICALL
    public boolean endsWith(JNIEnv env, @THIS KReference ref, String prefix) throws RemoteException {
        String this_string = memoryManager.getString(ref);
        String prefix_string = prefix;
        return this_string.endsWith(prefix_string);
    }

    @JNICALL
    public int compareTo(JNIEnv env, @THIS KReference ref, String anotherString) throws RemoteException {
        String this_string = memoryManager.getString(ref);
        String anotherString_string = anotherString;
        return this_string.compareTo(anotherString_string);
    }

    @JNICALL
    public boolean matches(JNIEnv env, @THIS KReference ref, String regex) throws RemoteException {
        String this_string = memoryManager.getString(ref);
        String regex_string = regex;
        return this_string.matches(regex_string);
    }

    @JNICALL
    public boolean equalsIgnoreCase(JNIEnv env, @THIS KReference ref, String anotherString) throws RemoteException {
        String this_string = memoryManager.getString(ref);
        String anotherString_string = anotherString;
        return this_string.equalsIgnoreCase(anotherString_string);
    }

    @JNICALL
    public boolean regionMatches(JNIEnv env, @THIS KReference ref, boolean ignoreCase, int toffset,
                                 String other, int ooffset, int len) throws RemoteException {
        String this_string = memoryManager.getString(ref);
        String other_string = other;
        return this_string.regionMatches(ignoreCase, toffset,
                other_string, ooffset, len);
    }

    @JNICALL
    public static int indexOf(JNIEnv env, char[] source, int sourceOffset, int sourceCount,
                              char[] target, int targetOffset, int targetCount,
                              int fromIndex) throws RemoteException {
        char[] source_chars = source;
        char[] target_chars = target;
        //copied from String because package protected

        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target_chars[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source_chars[i] != first) {
                while (++i <= max && source_chars[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source_chars[j] ==
                        target_chars[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;

    }
}