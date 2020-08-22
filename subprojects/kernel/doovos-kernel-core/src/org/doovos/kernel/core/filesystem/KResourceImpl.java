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

import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.filesystem.Attributes;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KLocalFileSystem;
import org.doovos.kernel.api.site.KLocalSite;

import java.io.Serializable;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import org.doovos.kernel.api.site.KSiteEntry;


/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 11 oct. 2004
 * Time: 15:20:21
 */
public class KResourceImpl extends UnicastRemoteObject implements KLocalResource {
    //    private ArrayList<XResourceImpl> links;

    private String path;
    private KInternalPath internalPath;
    private boolean leaf;
    private KResourceType type;
    private Date creationTime;
    private String creationSiteId;
    //    protected TreeSet<String> validAttributes;
    protected Map<String, LinkedHashSet<String>> listeners;
    protected Map<String, Object> properties;
    protected KLifeStatus lifeStatus = KLifeStatus.INIT;
    private int childIndex = 1;

    protected KResourceImpl() throws RemoteException {

    }
    protected KResourceImpl(KResourceType type, boolean leaf) throws RemoteException {
        this.type = type;
        this.leaf = leaf;
    }



    /**
     * called by filesystem
     * @param path
     * @throws RemoteException
     */
    public void initResource(String path) throws RemoteException {
        this.path = path;
        this.internalPath = path == null ? null : new KInternalPath(path);
        creationTime = new Date();
        creationSiteId = Doovos.getSystem().getName();
        lifeStatus = KLifeStatus.RUNNING;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public int getLocalChildrenCount() throws RemoteException {
        int count = 0;
        String p = getPath();
        for (KLocalFileSystem lfs : Doovos.getSystem().getLocalSite().getLocalFileSystems()) {
            if (lfs.acceptPath(p)) {
                count += lfs.getResourcesList(p, null).size();
            }
        }
        return count;
    }

    public KLocalResource getLocalChild(String name) throws RemoteException {
        KLocalSite localSite = Doovos.getSystem().getLocalSite();
        if (localSite == null) {
            return null;
        }
        KResource[] found = localSite.listResources(getPath() + "/" + name);
        return found.length == 0 ? null : (KLocalResource) found[0];
    }

    public Collection<KLocalResource> getLocalChildren() throws RemoteException {
        String p = getPath();
        Collection<KLocalResource> all = new ArrayList<KLocalResource>();
        KLocalSite localSite = Doovos.getSystem().getLocalSite();
        if (localSite != null) {
            for (KResource dResourceLocal : localSite.listResourcesByParent(p, null)) {
                all.add((KLocalResource) dResourceLocal);
            }
        }
        return all;
    }

    public KResource getChild(String[] path, int offset) throws RemoteException {
        if (offset < path.length) {
            KLocalResource r = getLocalChild(path[offset]);
            if (r != null) {
                if (offset == path.length - 1) {
                    return r;
                } else {
                    return r.getChild(path, offset + 1);
                }
            }
        }
        return null;
    }

//    public void addResource(DResource child){
//        links.get(0).addResource(child);
//    }
//
//    public void removeResource(DResource child){
//        for (XResourceImpl xResource : links) {
//            xResource.removeResource(child);
//        }
//    }
//
//    public Collection<DResource> getResources(String filter){
//        Hashtable<String,DResource> m=new Hashtable<String, DResource>();
//        HashSet<String> u=new HashSet<String>();
//        ArrayList<DResource> distincts=new ArrayList<DResource>();
//        for (XResourceImpl xResource : links) {
//            Collection<XResourceImpl> r=xResource.getResources(filter);
//            for (XResourceImpl resourceChild : r) {
//                if(u.contains(resourceChild.getName())){
//                    System.out.println("[ERROR] Duplicate Resource "+new DPath(path,resourceChild.getName()).toString());
//                }else{
//                    switch(resourceChild.getDyplicateType()){
//                        case DISTINCT:{
//                            DResource dResourceChild=new DResource(new DPath(path,resourceChild.getName()));
//                            dResourceChild.addImpl(resourceChild);
//                            distincts.add(dResourceChild);
//                            break;
//                        }
//                        case UNIQUE:{
//                            u.add(resourceChild.getName());
//                            break;
//                        }
//                        case MERGE:{
//                            String n=resourceChild.getName();
//                            DResource dResourceChild= m.get(n);
//                            if(dResourceChild==null){
//                                dResourceChild=new DResource(new DPath(path,n));
//                                m.put(n,dResourceChild);
//                            }
//                            dResourceChild.addImpl(resourceChild);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        distincts.addAll(h.values());
//        return distincts;
//    }
//
//    public int getResourcesCount(String filter){
//        HashSet u=new HashSet();
//        HashSet m=new HashSet();
//        int distincts=0;
//        for (XResourceImpl xResource : links) {
//            Collection<XResourceImpl> r=xResource.getResources(filter);
//            for (XResourceImpl resourceChild : r) {
//                if(u.contains(resourceChild.getName())){
//                    System.out.println("[ERROR] Duplicate Resource "+new DPath(path,resourceChild.getName()).toString());
//                }else{
//                    switch(resourceChild.getDyplicateType()){
//                        case DISTINCT:{
//                            distincts++;
//                            break;
//                        }
//                        case UNIQUE:{
//                            u.add(resourceChild.getName());
//                            break;
//                        }
//                        case MERGE:{
//                            m.add(resourceChild.getName());
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return distincts+m.memorySize();
//    }
//
//    private void addImpl(XResourceImpl impl){
//        if(links==null){
//            links=new ArrayList<XResourceImpl>(1);
//        }
//        links.ensureCapacity(links.memorySize()+1);
//        links.add(impl);
//    }
//
//    public String getName(){
//        return links.get(0).getName();
//    }
//
//    public long getSoftWeight(){
//        long l=0;
//        for (XResourceImpl xResource : links) {
//            l+=xResource.getSoftWeight();
//        }
//        return l;
//    }
//
//    public long getHardWeight(){
//        long l=0;
//        for (XResourceImpl xResource : links) {
//            l+=xResource.getHardWeight();
//        }
//        return l;
//    }
//
    /**
     * path of the resource (Global Path)
     *
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * resource name, should be the latest part of the path
     *
     * @return name
     */
    public String getName() {
        return new KFilePath(path).getName();
    }

    @Override
    public String toString() {
        return getClass().getName() + ":/" + path;
    }

    /**
     * try to free up resources, all errors will be ignored
     */
    public final void free() throws RemoteException {
        if (lifeStatus == KLifeStatus.RUNNING) {
            lifeStatus = KLifeStatus.FREEING;
            firePropertyEventListener(DoovosConstants.PROPERTY_ID_PRE_FREE, DoovosConstants.PROPERTY_NAME_PRE_FREE, null, true);
            freeImpl();
            //detach();
            firePropertyEventListener(DoovosConstants.PROPERTY_ID_FREE, DoovosConstants.PROPERTY_NAME_FREE, null, true);
            lifeStatus = KLifeStatus.FREE;
        }
    }

    protected void freeImpl() throws RemoteException {
        //        DPath path = getPath();
        Collection<KResource> chs = Doovos.getSystem().getFileSystemManager().list(getPath(), null);
        for (KResource ch : chs) {
            try {
                ch.free();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
//        me.getParent().onPropertyEvent(
//                new PropertyEvent(path,getType(), new ChildFreeEvent())
//        );
//        SiteResourceManagerImpl r = (SiteResourceManagerImpl) Doovos.getLocalSite().getResourceManager();
//        r.getImportNamingTable().unregisterLocalResource(getPath());
    }

    public KResource getParent() throws RemoteException {
        String parentPath = new KFilePath(path).getParentPath();
        return parentPath == null ? null : Doovos.getSystem().getFileSystemManager().getResource(parentPath);
    }

    public void migrateTo(String SiteId) throws RemoteException {
        if (isSticky()) {
            throw new IllegalArgumentException("This resource is sticky");
        }
        KLocalSite oldSite = Doovos.getSystem().getLocalSite();
        KSiteEntry newSite = Doovos.getSystem().getSiteManager().getSite(SiteId);
        if (oldSite != null && oldSite.getName().equals(newSite.getName())) {
            throw new IllegalArgumentException("could not migrate to local site");
        }
        KLocalResource copy;
        try {
            copy = (KLocalResource) this.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        try {
            UnicastRemoteObject.unexportObject(copy.toRemote(), true);
        } catch (NoSuchObjectException ex) {
            throw new IllegalArgumentException(ex);
        }
        KResource newRef = newSite.getSite().attachResource(copy, this, oldSite.getName());
        oldSite.detachResource(this, newRef, newSite.getName());
    }

    public void detach() throws RemoteException {
    }

    public void attach() throws RemoteException {
        //attach(null);
    }

    public void attach(KResource resource) throws RemoteException {
        //setInternalPath(new KInternalPath(getInternalPath().getPublicPath()));
//        Doovos.getSystem().getFileSystemManager().registerLocalResource(this);
    }

    public KResourceType getType() {
        return type;
    }

    public KInternalPath getInternalPath() {
        return internalPath;
    }

    public void setInternalPath(KInternalPath internalPath) {
        this.internalPath = internalPath;
    }

//    protected void checkAttribute(String name){
//        if(validAttributes==null || !validAttributes.contains(name)){
//            throw new UnknownAttributeException("Unknown attribute "+name);
//        }
//    }
    public Object setAttribute(String name, Object newValue) {
//        checkAttribute(name);
        return null;
    }

    public void setAttributes(Attributes newValues) throws RemoteException {
        if (newValues != null) {
            for (Map.Entry<String, Object> stringObjectEntry : newValues.entrySet()) {
                setAttribute(stringObjectEntry.getKey(), stringObjectEntry.getValue());
            }
        }
    }

    public Serializable getAttribute(String name) {
//        checkAttribute(name);
        return null;
    }

    public void addPropertyEventListener(String dPath, String propertyEvent) {
        if (listeners == null) {
            listeners = new HashMap<String, LinkedHashSet<String>>();
        }
        LinkedHashSet<String> plisteners = listeners.get(propertyEvent);
        if (plisteners == null) {
            plisteners = new LinkedHashSet<String>(3);
            listeners.put(propertyEvent, plisteners);
        }
        plisteners.add(dPath);
    }

    public void removePropertyEventListener(String dPath, String propertyEvent) {
        if (listeners != null) {
            LinkedHashSet<String> plisteners = listeners.get(propertyEvent);
            plisteners.remove(dPath);
            if (plisteners.size() == 0) {
                listeners.remove(propertyEvent);
                if (listeners.size() == 0) {
                    listeners = null;
                }
            }
        }
    }

    protected void firePropertyEventListener(KPropertyEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if (listeners != null && !((oldValue == newValue) || (oldValue != null && oldValue.equals(newValue)))) {
            for (Map.Entry<String, LinkedHashSet<String>> listArray : listeners.entrySet()) {
                for (String ppath : listArray.getValue()) {
                    try {
                        Doovos.getSystem().getFileSystemManager().getResource(ppath).onPropertyEvent(event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    protected void firePropertyEventListener(int eventId, String propertyEvent, Object oldValue, Object newValue) {
        if (listeners != null && !((oldValue == newValue) || (oldValue != null && oldValue.equals(newValue)))) {
            KPropertyEvent event = new KPropertyEvent(getPath(), getType(), eventId, propertyEvent, oldValue, newValue);
            for (Map.Entry<String, LinkedHashSet<String>> listArray : listeners.entrySet()) {
                for (String ppath : listArray.getValue()) {
                    try {
                        Doovos.getSystem().getFileSystemManager().getResource(ppath).onPropertyEvent(event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
    }

    public Date getCreationTime() throws RemoteException {
        return creationTime;
    }

    public String getCreationSiteId() throws RemoteException {
        return creationSiteId;
    }

    public String getCurrentSiteId() throws RemoteException {
        KLocalSite localSite = Doovos.getSystem().getLocalSite();
        return localSite == null ? null : localSite.getName();
    }

    public boolean isSticky() throws RemoteException {
        return true;
    }

    public KResource toRemote() throws RemoteException {
        return this;
    }

    public void setPath(String path) throws RemoteException {
        this.path = path;
    }

    public KLifeStatus getLifeStatus() {
        return lifeStatus;
    }

    protected void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    protected void setType(KResourceType type) {
        this.type = type;
    }

    public String nextChildName(String prefix, String suffix) throws RemoteException {
        if (prefix == null) {
            prefix = "";
        }
        if (suffix == null) {
            suffix = "";
        }
        KLocalSite localSite = Doovos.getSystem().getLocalSite();
        String myPath = getPath();
        String a;
        if (childIndex == 0) {
            childIndex++;
            a = prefix + suffix;
            if (a.length() > 0) {
                if (!localSite.exists(myPath + "/" + a)) {
                    return a;
                }
            }
        }
        while (true) {
            a = prefix + childIndex + suffix;
            childIndex++;
            if (!localSite.exists(myPath + "/" + a)) {
                return a;
            }
        }
    }
}
