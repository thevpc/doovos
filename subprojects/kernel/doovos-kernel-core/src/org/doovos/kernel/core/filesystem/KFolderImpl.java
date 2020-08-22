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

import java.io.IOException;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KFolder;

import java.io.File;
import java.rmi.RemoteException;
import java.util.Date;

import org.doovos.kernel.api.filesystem.KLocalFolder;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.core.util.ObjectDelegate;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 5 nov. 2004
 * Time: 21:12:00
 */
public class KFolderImpl extends KResourceImpl implements KLocalFolder, KFolder {
    private File hostFolder;

    public KFolderImpl(String path, File _hostFolder) throws RemoteException {
        super(KResourceType.FOLDER, false);
        setPath(path);
        this.hostFolder = _hostFolder;
    }

    public boolean isHidden() throws RemoteException {
        return hostFolder.isHidden();
    }

    public boolean canRead() throws RemoteException {
        return hostFolder.canRead();
    }

    public boolean canWrite() throws RemoteException {
        return hostFolder.canWrite();
    }

    public boolean canExecute() throws RemoteException {
        return hostFolder.canExecute();
    }

    public long lastModified() throws RemoteException {
        return hostFolder.lastModified();
    }

    public String nextChildName(String prefix, String suffix) throws RemoteException {
        if(prefix==null){
            prefix="noname-";
        }else if(prefix.length()<3){
            while(prefix.length()<3){
                prefix=prefix+"-";
            }
        }
        File ff;
        try {
            ff = File.createTempFile(prefix, suffix, hostFolder);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        ff.delete();
        return ff.getName();
    }

}
