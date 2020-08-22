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
import org.doovos.kernel.api.filesystem.Attributes;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;
import org.doovos.kernel.api.io.stream.KLocalPipeStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 11-dec.-2005
 * Time: 14:54:46
 */
public class KPipeStreamImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalPipeStream {
    private String in;
    private String out;

    public KPipeStreamImpl(String in, String out) throws RemoteException {
        super(KResourceType.PIPE, true,DoovosConstants.STREAM_PATH, DoovosConstants.STREAM_PIPE_PREFIX, null);
        this.out = out;
        this.in = in;
    }

    public KInputStream getDInputStream() throws RemoteException {
        return (KInputStream) Doovos.getSystem().getFileSystemManager().getResource(in);
    }

    public KOutputStream getDOutputStream() throws RemoteException {
        return (KOutputStream) Doovos.getSystem().getFileSystemManager().getResource(out);
    }

    public InputStream getInputStream() throws RemoteException {
        return getDInputStream().getInputStream();
    }

    public int read() throws IOException {
        return getDInputStream().read();
    }

    public byte[] read(int len) throws IOException {
        return getDInputStream().read(len);
    }

    public int available() throws IOException {
        return getDInputStream().available();
    }

    public OutputStream getOutputStream() throws RemoteException {
        return getDOutputStream().getOutputStream();
    }

    public void writeln(String message) throws RemoteException {
        getDOutputStream().writeln(message);
    }

    public void write(String message) throws RemoteException {
        getDOutputStream().write(message);
    }

    public void writeln(String message, Attributes attributes) throws RemoteException {
        getDOutputStream().writeln(message, attributes);
    }

    public void write(String message, Attributes attributes) throws RemoteException {
        getDOutputStream().write(message, attributes);
    }

    public void write(int b) throws IOException {
        getDOutputStream().write(b);
    }

    public void write(byte b[], int off, int len) throws IOException {
        getDOutputStream().write(b, off, len);
    }

    public void write(Object message) throws RemoteException {
        getDOutputStream().write(message);
    }

    public void write(Object message, Attributes attributes) throws RemoteException {
        getDOutputStream().write(message, attributes);
    }

    public void writeln(Object message, Attributes attributes) throws RemoteException {
        getDOutputStream().writeln(message, attributes);
    }

    public void writeln(Object message) throws RemoteException {
        getDOutputStream().writeln(message);
    }

    public int skip(long n) throws IOException {
        return 0;
    }

    public int read(KMemorySegment segment, long byteArrayPointer, int byteArrayOffset, int len) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
