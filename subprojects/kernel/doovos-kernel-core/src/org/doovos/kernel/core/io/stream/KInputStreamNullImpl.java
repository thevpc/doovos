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

import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.io.stream.KLocalInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.RemoteException;

import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 20:50:02
 */
public class KInputStreamNullImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalInputStream {

    private static JavaNullStream JNS = new JavaNullStream();
//    private static final byte[] EMPTY_ARRAY_BYTE = new byte[0];

    public KInputStreamNullImpl() throws RemoteException {
        super(KResourceType.INPUT, true,DoovosConstants.STREAM_PATH, DoovosConstants.STREAM_IN_PREFIX + "null", null);
    }

    public InputStream getInputStream() {
        return JNS;
    }

    public int available() throws IOException {
        return 0;
    }

    public int read(KMemorySegment segment, long byteArrayPointer, int byteArrayOffset, int len) throws IOException {
        return 0;
    }

    private static class JavaNullStream extends InputStream implements Serializable {

        public JavaNullStream() {
        }

        public int read() throws IOException {
            return -1;
        }

        @Override
        public int read(byte b[], int off, int len) throws IOException {
            return 0;
        }
    }

    public int read() throws IOException {
        return -1;
    }

    public byte[] read(int len) throws IOException {
        return EmptyArray.BYTES;
    }

    public int skip(long n) throws IOException {
        return 0;
    }
}
