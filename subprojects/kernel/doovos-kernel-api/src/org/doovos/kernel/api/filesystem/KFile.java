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
package org.doovos.kernel.api.filesystem;

import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;


/**
 * Main interface for handled Files
 *
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 20:50:02
 */
public interface KFile extends KResource {
    String getKFileHash() throws IOException;
    boolean isDirectory() throws RemoteException;

    boolean isFile() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean canRead() throws RemoteException;

    boolean canExecute() throws RemoteException;

    boolean canWrite() throws RemoteException;

    long lastModified() throws RemoteException;

    long length() throws RemoteException;

    public static final class OutFlags implements Serializable {
        private boolean append = false;
        private boolean create = true;

        public OutFlags() {
        }

        public boolean isAppend() {
            return append;
        }

        public OutFlags setAppend(boolean append) {
            this.append = append;
            return this;
        }

        public boolean isCreate() {
            return create;
        }

        public OutFlags setCreate(boolean create) {
            this.create = create;
            return this;
        }
    }

    /**
     * open a distributed input stream
     *
     * @return
     * @
     */
    public KInputStream openInputStream() throws RemoteException;

    /**
     * open a distributed output stream
     *
     * @return
     * @ @param flags
     */
    public KOutputStream openOutputStream(OutFlags flags) throws RemoteException;
}
