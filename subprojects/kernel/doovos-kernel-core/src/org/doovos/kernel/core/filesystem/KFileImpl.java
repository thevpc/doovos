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
package org.doovos.kernel.core.filesystem;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KLocalResource;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;

import java.io.*;
import java.rmi.RemoteException;
import java.util.Date;
import org.doovos.kernel.api.io.stream.KLocalOutputStream;
import org.doovos.kernel.core.util.KIOUtils;
import org.doovos.kernel.core.util.ObjectDelegate;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 25 oct. 2004
 * Time: 20:50:02
 */
public class KFileImpl extends KResourceImpl implements KFile, KLocalResource, Cloneable {

    private File localFile;
    private String initPath;

    public KFileImpl(String path, File hostFile) throws RemoteException {
        super(KResourceType.FILE, true);
        this.localFile = hostFile;
        this.initPath = path;
    }

    public boolean isDirectory() throws RemoteException {
        return localFile.isDirectory();
    }

    public boolean isFile() throws RemoteException {
        return localFile.isFile();
    }

    public boolean isHidden() throws RemoteException {
        return localFile.isHidden();
    }

    public boolean canRead() throws RemoteException {
        return localFile.canRead();
    }

    public boolean canExecute() throws RemoteException {
        return localFile.canExecute();
    }

    public boolean canWrite() throws RemoteException {
        return localFile.canWrite();
    }

    public long lastModified() throws RemoteException {
        return localFile.lastModified();
    }

    public long length() throws RemoteException {
        return localFile.length();
    }

    public KInputStream openInputStream() throws RemoteException {
        KInputStream i = null;
        try {
            i = Doovos.getSystem().getFactory().createInputStream(new FileInputStream(localFile));
        } catch (FileNotFoundException e) {
            throw new RemoteException(e.getMessage());
        }
        ((KLocalResource) i).attach();
        return i;
    }

    public KOutputStream openOutputStream(OutFlags flags) throws RemoteException {
        KLocalOutputStream i = null;
        try {
            if (localFile.exists()) {
                i = Doovos.getSystem().getFactory().createOutputStream(new FileOutputStream(localFile, flags.isAppend()));
                i.attach();
            } else {
                if (!flags.isCreate()) {
                    throw new FileNotFoundException("File not found : " + getPath());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RemoteException(e.getMessage());
        }
        return i;
    }

    @Override
    public void attach() throws RemoteException {
        super.attach();
        setPath(initPath);
    }

    @Override
    public void freeImpl() throws RemoteException {
        super.freeImpl();
        localFile.delete();
    }

    @Override
    public boolean isSticky() {
        return false;
    }

    public String getKFileHash() throws IOException {
        return localFile.exists() ? KIOUtils.getChecksum(localFile) : null;
    }

    public File getLocalFile() {
        return localFile;
    }
}
