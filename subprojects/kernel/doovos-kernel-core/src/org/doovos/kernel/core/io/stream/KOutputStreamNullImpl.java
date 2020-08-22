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
package org.doovos.kernel.core.io.stream;

import org.doovos.kernel.api.filesystem.Attributes;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.io.stream.KLocalOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 20:50:02
 */
public class KOutputStreamNullImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalOutputStream {
    private static JavaNullStream JNS = new JavaNullStream();

    public KOutputStreamNullImpl() throws RemoteException {
        super(KResourceType.OUTPUT, true,DoovosConstants.STREAM_PATH, DoovosConstants.STREAM_OUT_PREFIX + "null", null);
    }

    public OutputStream getOutputStream() {
        return JNS;
    }


    public void writeln(String message) {
    }

    public void write(String message) {
    }

    public void write(int b) throws IOException {
    }

    public void write(byte b[], int off, int len) throws IOException {
    }

    private static class JavaNullStream extends OutputStream implements Serializable {
        public JavaNullStream() {
        }

        public void write(int b) throws IOException {
        }

        public void write(byte b[], int off, int len) throws IOException {
        }
    }

    public void write(Object message) {
    }

    public void writeln(Object message, Attributes attributes) {
    }

    public void writeln(Object message) {
    }

    public void write(Object message, Attributes attributes) {
    }

    public void writeln(String message, Attributes attributes) {
    }

    public void write(String message, Attributes attributes) {
    }
}