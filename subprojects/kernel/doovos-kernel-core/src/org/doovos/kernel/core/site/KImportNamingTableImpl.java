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
package org.doovos.kernel.core.site;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KResource;

import java.rmi.RemoteException;
import java.util.*;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 07-dec.-2005
 * Time: 13:49:46
 */
public class KImportNamingTableImpl {
    private ImportNamingTableUpdater namingTableUpdater;
    private long time = 0;

    private final Map<String, DNamingEntryImpl> table = new HashMap<String, DNamingEntryImpl>();

    public KImportNamingTableImpl() {
    }

    public Collection<Entry> getEntries() {
        return new ArrayList<Entry>(table.values());
    }

    public void cacheResource(KResource resource) throws RemoteException {
        table.put(resource.getPath(), new DNamingEntryImpl(resource, (++time)));
    }

    public void invalidate() {
        table.clear();
    }

    public void invalidate(String path, boolean recurse) {
        if (recurse) {
            if ("/".equals(path)) {
                table.clear();
            } else {
                for (Iterator<Map.Entry<String, DNamingEntryImpl>> i = table.entrySet().iterator(); i.hasNext();) {
                    Map.Entry<String, DNamingEntryImpl> entry = i.next();
                    if (entry.getKey().startsWith(path)) {
                        i.remove();
                    }
                }
            }
        } else {
            table.remove(path);
        }
    }

    public void refreshCache() {
        try {
            int max = 100;
            int max0 = (int) (max * 0.7);
            if (table.size() > max) {
                synchronized (table) {
                    while (table.size() > max0) {
                        DNamingEntryImpl e = null;
                        for (DNamingEntryImpl dNamingEntry : table.values()) {
                            if (e == null || dNamingEntry.latestCall < e.latestCall) {
                                e = dNamingEntry;
                            }
                        }
                        table.remove(e.path);
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public KResource getCache(String path) {
        DNamingEntryImpl dNamingEntry = table.get(path);
        if (dNamingEntry != null) {
            dNamingEntry.latestCall = (++time);
            return dNamingEntry.resource;
        }
        return null;
    }

    public static class DNamingEntryImpl implements Entry {
        private long latestCall;
        private String path;
        private KResource resource;

        public DNamingEntryImpl(KResource resource, long latestCall) throws RemoteException {
            this.path = resource.getPath();
            this.resource = resource;
            this.latestCall = latestCall;
        }

        public long getLatestCall() {
            return latestCall;
        }

        public String getPath() {
            return path;
        }

        public KResource getResource() {
            return resource;
        }
    }

    public void start() throws RemoteException {
        Doovos.getSystem().getLog().debug("Loading Remote Resources Naming Table ...");
        namingTableUpdater = new ImportNamingTableUpdater();
        namingTableUpdater.start();
    }

    public void shutdown() {
        namingTableUpdater.doStop();
        table.clear();
    }

    public class ImportNamingTableUpdater extends Thread {
        boolean softStop = false;

        public ImportNamingTableUpdater() throws RemoteException {
            super("ImportNamingTableUpdater-" + Doovos.getSystem().getName());
        }

        public void doStop() {
            softStop = true;
        }

        public void run() {
            if (softStop) {
                return;
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                //
            }
            refreshCache();
        }
    }

    public static interface Entry {

        public long getLatestCall();

        public String getPath();

        public KResource getResource();
    }
}
