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
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.io.stream.KOutputStream;
import org.doovos.kernel.api.io.stream.KLocalOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Map;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 20:50:02
 */
public class KOutputStreamImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalOutputStream {
    private OutputStream javaOutputStream;

    public KOutputStreamImpl(OutputStream out) throws RemoteException {
        super(KResourceType.OUTPUT, true,DoovosConstants.STREAM_PATH, DoovosConstants.STREAM_OUT_PREFIX, null);
        this.javaOutputStream = out;
    }

    public OutputStream getOutputStream() {
        return new JavaStream(this);
    }


    @Override
    public void freeImpl() throws RemoteException {
        super.freeImpl();
        try {
            javaOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeln(String message) {
        try {
            javaOutputStream.write((message + "\n").getBytes());
        } catch (IOException e) {
            Doovos.getSystem().getLog().error(e);
        }
    }

    public void write(String message) {
        try {
            javaOutputStream.write((message).getBytes());
        } catch (IOException e) {
            Doovos.getSystem().getLog().error(e);
        }
    }

    public void write(int b) throws IOException {
        javaOutputStream.write(b);
    }

    public void write(byte b[], int off, int len) throws IOException {
        javaOutputStream.write(b, off, len);
    }

    private static class JavaStream extends OutputStream implements Serializable {
        private KOutputStream remote;

        public JavaStream(KOutputStream remote) {
            this.remote = remote;
        }

        public void write(int b) throws IOException {
            remote.write(b);
        }

        public void write(byte b[], int off, int len) throws IOException {
            remote.write(b, off, len);
        }
    }

    public void write(Object message) {
        write(String.valueOf(message));
    }

    public void writeln(Object message, Attributes attributes) {
        writeln(String.valueOf(message), attributes);
    }

    public void writeln(Object message) {
        writeln(String.valueOf(message));
    }

    public void write(Object message, Attributes attributes) {
        write(String.valueOf(message), attributes);
    }

    public void writeln(String message, Attributes attributes) {
        if (attributes == null) {
            writeln(message);
        } else {
            Attributes old = new Attributes();
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                old.put(entry.getKey(), setAttribute(entry.getKey(), entry.getValue()));
            }
            writeln(message);
            for (Map.Entry<String, Object> entry : old.entrySet()) {
                setAttribute(entry.getKey(), entry.getValue());
            }
        }
    }

    public void write(String message, Attributes attributes) {
        if (attributes == null) {
            write(message);
        } else {
            Attributes old = new Attributes();
            for (Map.Entry<String, Object> entry : attributes.entrySet()) {
                old.put(entry.getKey(), setAttribute(entry.getKey(), entry.getValue()));
            }
            write(message);
            for (Map.Entry<String, Object> entry : old.entrySet()) {
                setAttribute(entry.getKey(), entry.getValue());
            }
        }
    }
}
