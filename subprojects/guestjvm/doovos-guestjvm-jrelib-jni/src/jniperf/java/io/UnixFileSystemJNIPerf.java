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
package jniperf.java.io;

import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.memory.KReference;

import java.io.IOException;

@JNICLASS(value = "java.io.UnixFileSystem", forceJNI = true)
public class UnixFileSystemJNIPerf {

    @JNICALL
    public /*String*/String normalize(JNIEnv env, @THIS KReference ref, String path, int len, int off) throws IOException {
//        return Doovos.canonicalize(env.getProcess().getWorkingDir(), Doovos.getSystem().getMemoryManager().getString(path));
        String pathname = path;
        if (len == 0) return pathname;
        int n = len;
        while ((n > 0) && (pathname.charAt(n - 1) == '/')) n--;
        if (n == 0) return "/";
        StringBuffer sb = new StringBuffer(pathname.length());
        if (off > 0) sb.append(pathname.substring(0, off));
        char prevChar = 0;
        for (int i = off; i < n; i++) {
            char c = pathname.charAt(i);
            if ((prevChar == '/') && (c == '/')) continue;
            sb.append(c);
            prevChar = c;
        }
        return sb.toString();
    }
}