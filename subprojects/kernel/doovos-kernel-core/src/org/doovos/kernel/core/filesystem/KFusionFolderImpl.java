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

import org.doovos.kernel.api.filesystem.KInternalPath;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.filesystem.KFolder;
import org.doovos.kernel.api.filesystem.KLocalFolder;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import org.doovos.kernel.api.filesystem.KLocalResource;
import org.doovos.kernel.api.filesystem.KResource;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 6 nov. 2004
 * Time: 01:02:06
 */
public class KFusionFolderImpl extends KResourceImpl implements KFolder, KLocalFolder, Cloneable {
//    public KFusionFolderImpl(String path) throws RemoteException {
//        initResource(KResourceType.FOLDER, path, false);
//    }

    private KFolder[] siteFolder;
    private Queue<String> nextNames = new LinkedList<String>();

    public KFusionFolderImpl(String path, KResource[] folders) throws RemoteException {
        super(KResourceType.FOLDER, false);
        this.siteFolder = new KFolder[folders.length];
        for (int i = 0; i < folders.length; i++) {
            siteFolder[i] = (KFolder)folders[i];
        }
        setPath(path);
    }

    @Override
    public int getLocalChildrenCount() throws RemoteException {
        return getLocalChildren().size();
    }

    @Override
    public String nextChildName(String prefix, String suffix) throws RemoteException {
        if (nextNames.size() == 0) {
            for (KFolder r : siteFolder) {
                nextNames.add(r.nextChildName(prefix, suffix));
            }
        }
        String item = nextNames.poll();
        if(item==null){
            if(prefix==null){
                prefix="";
            }
            if(suffix==null){
                suffix="";
            }
            return prefix+suffix;
        }
        return item;
    }

//    public Collection<DResourceLocal> getLocalChildren() throws RemoteException {
//        ArrayList<DResourceLocal> all=new ArrayList<DResourceLocal>();
//        DPath p=getPath();
//        for (DFileSystemDeviceLocal fs : Doovos.getLocalSite().getLocalFileSystemDevices()) {
//            all.addAll(fs.getResourcesList(p,null));
//        }
//        return all;
//    }
//    public DResourceLocal getLocalChild(String name)  {
//        throw new AbstractMethodError("getLocalChild");
//        TreeMap<String, ArrayList<SFolder>> folderPaths = new TreeMap<String, ArrayList<SFolder>>();
//        for (SFolder aSiteFolder : siteFolder) {
//            Collection<DResource> k = aSiteFolder.getInternalPath().getSite().getResourcesList(aSiteFolder.getInternalPath(), null);
//            for (DResource r : k) {
//                if (r instanceof SFolder) {
//                    if (r.getName().equals(name)) {
//                        String n = r.getPath();
//                        ArrayList<SFolder> alf = folderPaths.get(n);
//                        if (alf == null) {
//                            alf = new ArrayList<SFolder>();
//                            folderPaths.put(n, alf);
//                        }
//                        alf.add((SFolder) r);
//                    }
//                } else {
//                    return r;
//                }
//            }
//        }
//        for (Map.Entry<String, ArrayList<SFolder>> entry : folderPaths.entrySet()) {
//            return
//                    new DFusionFolderImpl(entry.getValue().get(0).getPath(),
//                            entry.getValue().toArray(new SFolder[0]));
//        }
//        return null;
//    }
    public Collection<KInternalPath> getAllInternalPaths() throws RemoteException {
        ArrayList<KInternalPath> all = new ArrayList<KInternalPath>();
        for (KFolder dSiteFolder : siteFolder) {
            all.add(dSiteFolder.getInternalPath());
        }
        return all;
    }

    public boolean isHidden() throws RemoteException {
        for (KFolder sFolder : siteFolder) {
            return sFolder.isHidden();
        }
        return false;
    }

    public boolean canRead() throws RemoteException {
        for (KFolder sFolder : siteFolder) {
            return sFolder.canRead();
        }
        return false;
    }

    public boolean canExecute() throws RemoteException {
        for (KFolder sFolder : siteFolder) {
            return sFolder.canExecute();
        }
        return false;
    }

    public boolean canWrite() throws RemoteException {
        for (KFolder sFolder : siteFolder) {
            return sFolder.canWrite();
        }
        return false;
    }

    public long lastModified() throws RemoteException {
        for (KFolder sFolder : siteFolder) {
            return sFolder.lastModified();
        }
        return 0;
    }
}
