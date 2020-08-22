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
package org.doovos.kernel.api.io.stream;

import org.doovos.kernel.api.filesystem.Attributes;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 20:50:02
 */
public interface KOutputStream extends KStream {
    public static final String FORECOLOR_ATTRIBUTE = "foreground";
    public static final String BACKCOLOR_ATTRIBUTE = "background";
    public static final String WINDOWTITLE_ATTRIBUTE = "windowtitle";
    public static final String CLS_ATTRIBUTE = "cls";

    public OutputStream getOutputStream() throws RemoteException;

    public void writeln(Object message) throws RemoteException;

    public void writeln(String message) throws RemoteException;

    public void write(String message) throws RemoteException;

    public void writeln(String message, Attributes attributes) throws RemoteException;

    public void write(Object message) throws RemoteException;

    public void write(Object message, Attributes attributes) throws RemoteException;

    public void writeln(Object message, Attributes attributes) throws RemoteException;

    public void write(String message, Attributes attributes) throws RemoteException;

    public void write(int b) throws IOException;

    public void write(byte b[], int off, int len) throws IOException;
}