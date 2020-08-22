package org.doovos.kernel.core.filesystem;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.*;
import org.doovos.kernel.api.site.KSite;
import org.doovos.kernel.api.site.KSiteManager;
import org.doovos.kernel.core.site.KImportNamingTableImpl;

import java.rmi.RemoteException;
import java.util.*;
import org.doovos.kernel.api.site.KSiteEntry;

public class KFileSystemManagerImpl implements KFileSystemManager {
    private static final KSiteEntry[] EMPTY_ARRAY_KSITEENTRY = new KSiteEntry[0];

    private Set<String> lookingForResourcesSet = new HashSet<String>();
    private Set<String> lookingForResourcesListSet = new HashSet<String>();
    private KImportNamingTableImpl importNamingTable;
    private KSiteManager siteManager;
    private Doovos system = Doovos.getSystem();

    public void start() throws RemoteException {
        importNamingTable = new KImportNamingTableImpl();
        importNamingTable.start();
        siteManager = system.getSiteManager();
    }

    public void shutdown() throws RemoteException {
        importNamingTable.shutdown();
    }

    public Collection<KResource> list(String path, KPathFilter filter) throws RemoteException {
        ResourceHolderList resourceHolderList = new ResourceHolderList(system);
        // if is locking for this path return null so that caller could lookup in other sites
        if (lookingForResourcesListSet.contains(path)) {
            return null;
        }
        lookingForResourcesListSet.add(path);
        try {
            //            getResource(path);
            KSiteManager namingTable = siteManager;
            KSiteEntry[] sys = (namingTable == null) ? EMPTY_ARRAY_KSITEENTRY : namingTable.getSites();
            if (filter == null) {
                for (KSiteEntry s : sys) {
                    Collection<KResource> r = s.getSite().listResourcesByParent(path, null);
                    for (KResource dResource : r) {
                        resourceHolderList.addResource(dResource);
                    }
                }
            } else {
                for (KSiteEntry s : sys) {
                    Collection<KResource> r = s.getSite().listResourcesByParent(path, null);
                    for (KResource dResource : r) {
                        if (filter.accept(dResource.getPath())) {
                            resourceHolderList.addResource(dResource);
                        }
                    }
                }
            }
            //donot use cache
            //resourceNamingCache.put(path, internalPaths);
            resourceHolderList.checkExists();
            resourceHolderList.checkAmbigous();
            Collection<KResource> dResources = resourceHolderList.createDResources();
//                for (KResource dResource : dResources) {
//                    Doovos.getImportNamingTable().cacheResource(dResource);
//                }
            return dResources;
        } finally {
            lookingForResourcesListSet.remove(path);
        }

//        return getResource(path).getLocalChildren();
    }

    public void invalidate(String path, boolean recurse) throws RemoteException {
        importNamingTable.invalidate(path, recurse);
    }

    public boolean exists(String path) throws RemoteException {
        KSiteEntry[] sys = siteManager.getSites();
        for (KSiteEntry s : sys) {
            if (s.getSite().exists(path)) {
                return true;
            }
        }
        return false;
    }

//    public synchronized void bookPathStart(String path) throws RemoteException {
//        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
//        }
//    }
//
//    public synchronized KResource bookPathEnd(String path) throws RemoteException {
//
//    }
    public synchronized KResource find(String path) throws RemoteException {
        try {
            return getResource(path);
        } catch (UnknownResourceException e) {
            return null;
        }
    }

    public synchronized KResource getResource(String path) throws RemoteException {
        synchronized (Doovos.RESOURCE_ADDED_LOCK) {
            KResource cache = importNamingTable.getCache(path);
//            if (cache != null) {
//                return cache;
//            }
            //Doovos.syslog("getResource("+path+")");
            ResourceHolder resourceHolder = new ResourceHolder(path, system);
            // if is loking for this path return null so that caller could lookup in other sites
            if (lookingForResourcesSet.contains(path)) {
                throw new IllegalArgumentException("Looking for that resource now : " + path);
            }
            lookingForResourcesSet.add(path);
            try {
                KSiteEntry[] sys = siteManager.getSites();
                for (KSiteEntry s : sys) {
                    KResource[] r = s.getSite().listResources(path);
                    for (KResource dResource : r) {
                        resourceHolder.addResource(dResource);
                    }
                }
                //DEBUG END
                //donot use cache
                //resourceNamingCache.put(path, internalPaths);
                cache = resourceHolder.createDResource();
                importNamingTable.cacheResource(cache);
                return cache;
            } finally {
                lookingForResourcesSet.remove(path);
            }
        }

    }

    private static class ResourceHolder {

        Doovos system;
        String path;
        ArrayList<KResource> resources = new ArrayList<KResource>();
        ArrayList<KInternalPath> internalPaths = new ArrayList<KInternalPath>();

        public ResourceHolder(String path, Doovos system) {
            this.path = path;
            this.system = system;
        }

        public void addResource(KResource r) {
            resources.add(r);
        }

        public void checkAmbigous() throws RemoteException {
            Set<String> ts = new HashSet<String>();
            for (KResource resource : resources) {
                String name = resource.getName();
                if (resource instanceof KFolder) {
                    return;
                }
                if (ts.contains(name)) {
                    System.out.println("ambiguous name [" + name + "] from " + path);
//                    throw new RuntimeException("ambiguous name [" + name + "] from " + path.toString());
                }
                ts.add(name);
            }
        }

        public void checkExists() {
            if (resources.size() == 0) {
                throw new UnknownResourceException("Cound not locate Resource " + path);
            }
        }

        public boolean isEmpty() {
            return resources.size() == 0;
        }

        public KResource createDResource() throws RemoteException {
            int size = resources.size();
            if (size == 0) {
                throw new UnknownResourceException("Could not locate Resource " + path);
            }
//            TreeSet<String> ts = new TreeSet<String>();
            //no need for anbigous check
//            for (Iterator<KResource> i = resources.iterator(); i.hasNext();) {
//                KResource resource = i.next();
//                String name = resource.getName();
//                if (!(resource instanceof SFolder)) {
//                    if (ts.contains(name)) {
//                        System.out.println("ambiguous name [" + name + "] from " + path.toString());
//                    }
//                    ts.add(name);
//                }else{
//                    break;
//                }
//            }
            try {
                return system.getFactory().createResource(path, resources.toArray(new KResource[resources.size()]));
            } catch (Exception ex) {
                system.getLog().error("ambiguous name [" + resources.get(0).getName() + "] from " + path);
                for (KResource r : resources) {
                    Doovos.getSystem().getLog().error("\t" + r.getCurrentSiteId() + " : " + r.getType());
                }
                throw new RuntimeException(ex);
            }
        }
    }

    private static class ResourceHolderList {

        LinkedHashMap<String, ResourceHolder> list = new LinkedHashMap<String, ResourceHolder>();
        Doovos system;

        public ResourceHolderList(Doovos system) {
            this.system = system;
        }

        public void addResource(KResource r) throws RemoteException {
            String path = r.getPath();
            ResourceHolder resourceHolder = list.get(path);
            if (resourceHolder == null) {
                resourceHolder = new ResourceHolder(path, system);
                list.put(path, resourceHolder);
            }
            resourceHolder.addResource(r);
        }

        public Collection<KResource> createDResources() throws RemoteException {
            ArrayList<KResource> all = new ArrayList<KResource>();
            for (ResourceHolder resourceHolder : list.values()) {
                KResource dResource = resourceHolder.createDResource();
                all.add(dResource);
            }
            return all;
        }

        public void checkAmbigous() throws RemoteException {
            for (ResourceHolder resourceHolder : list.values()) {
                resourceHolder.checkAmbigous();
            }
        }

        public void checkExists() {
            for (ResourceHolder resourceHolder : list.values()) {
                resourceHolder.checkExists();
            }
        }
    }

    public String nextName(String parentPath, String prefix, String suffix, KNameAction action) throws RemoteException {
        KResource resource = getResource(parentPath);
        while (true) {
            String n = resource.nextChildName(prefix, suffix);
            String pp = parentPath + "/" + n;
            ArrayList<KSite> reservated = new ArrayList<KSite>();
            boolean ok = true;
            KSiteEntry[] sites = siteManager.getSites();
            try {
                for (KSiteEntry site : sites) {
                    try {
                        site.getSite().reservatePath(pp);
                        reservated.add(site.getSite());
                    } catch (Exception e) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    if (action != null) {
                        action.nameReserved(parentPath, n);
                    }
                }
            } finally {
                for (KSite site : reservated) {
                    try {
                        site.unreservatePath(pp);
                    } catch (Exception e) {
                        //ignore
                    }
                }
            }
            if (ok) {
                return pp;
            }
        }
    }
}
