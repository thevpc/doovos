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
package org.doovos.kernel.core.util;

import org.doovos.kernel.core.filesystem.KFileImpl;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.io.stream.KInputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCache {
    private File localFile;
    private String path;
    private boolean local = false;

    public FileCache(KFile file) throws IOException {
        this.path = file.getPath();
        load();
    }

    public FileCache(String path) {
        this.path = path;
    }

//    public void forceLoad() throws IOException {
//        load();
//    }

//    private void log(String msg) throws IOException {
//        Doovos.syslog("FILE_CACHE '" +path+"' : "+msg);
//    }
    public boolean load() throws IOException {
//        log("loading...");
        KFile f = ((KFile) Doovos.getSystem().getFileSystemManager().getResource(path));
        if (Doovos.getSystem().getLocalSite().exists(f.getPath())) {
            KFileImpl fi = (KFileImpl) f;
            localFile = fi.getLocalFile();
            local = true;
//            log("local resource : "+localFile.getPath());
        } else {
//            log("checking hash..");
            String remoteHash = f.getKFileHash();
//            log("hash retrieved..");
            String localHash = null;
            File localTmpFolder = Doovos.getSystem().getBootConfig().getLocalTempFolder();
            localFile = new File(localTmpFolder, path);
            if (localFile.exists()) {
                localHash = KIOUtils.getChecksum(localFile);
            }
            if (localHash == null || !localHash.equals(remoteHash)) {
                Doovos.getSystem().getLog().debug("cache downloading remote file '" + path + "' to " + localFile.getPath());
//            System.out.println("FileCache reload "+f.getPath());
                localFile.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(localFile);
                KInputStream inputStream = f.openInputStream();
                int count = (int) f.length();
                if (count > 30000) {
                    count = 30000;
                }
                fos.write(inputStream.read(count));
                byte[] bytes;
                while ((bytes = inputStream.read(1024)).length > 0) {
                    fos.write(bytes);
                }
                fos.close();
//                log("loaded successfully to : "+localFile.getPath());
                return true;
            }else{
//                log("no need to reload, found in cache : "+localFile.getPath());
            }
        }
        return false;
    }

    public File getLocalFile() {
        return localFile;
    }

//    public boolean uptodate() throws RemoteException {
//        return local || ( hash != null && hash.equals(((KFile) Doovos.getResource(path)).getKFileHash()));
//    }

    @Override
    protected void finalize() throws Throwable {
//        if (!local  && localFile != null) {
//            if (!localFile.delete()) {
//                localFile.deleteOnExit();
//            }
//        }
    }

    public void close() {
//        if (!local  && localFile != null) {
//            if (!localFile.delete()) {
//                localFile.deleteOnExit();
//            }
//        }
    }
}
