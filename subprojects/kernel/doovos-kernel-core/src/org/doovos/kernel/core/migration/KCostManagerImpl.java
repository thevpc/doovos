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
package org.doovos.kernel.core.migration;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.migration.KCostManager;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.site.KSite;
import org.doovos.kernel.api.site.KLocalSite;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;
import org.doovos.kernel.api.site.KSiteEntry;

/**
 * User: taha
 *
 * @lastmodified 20 dec. 2005
 * Time: 15:33:17
 */
public class KCostManagerImpl implements KCostManager {
    public KCostManagerImpl() {
    }

    public void start() {

    }

    public void shutdown() {

    }

    public KSite getSiteForCreation(KResourceType type, long size, KProcess process, String path, Properties envs) throws RemoteException {
        String allocEnv = envs.getProperty("ALLOC_" + type);
        if (allocEnv != null) {
            KSiteEntry site = Doovos.getSystem().getSiteManager().getSite(allocEnv);
            if (site != null) {
                return site.getSite();
            }
        }
        double netCost = 50;
        double detachfromProcessCost = 100;
        KLocalSite localSite = Doovos.getSystem().getLocalSite();
        KSite bestSite = null;
        double bestCost = Double.POSITIVE_INFINITY;
        switch (type) {
            case FILE:
            case MEM:
            case PROCESS: {
                for (KSiteEntry dSiteEntry : Doovos.getSystem().getSiteManager().getSites()) {
                    KSite site = dSiteEntry.getSite();
                    double creationCost = Double.NaN;
                    try {
                        creationCost = site.getCreationCost(type, path, size);
                    } catch (RemoteException ex) {
                        netCost = Double.NaN;
                        //unreachable site
                    }
                    if (site != localSite) {
                        creationCost += netCost;
                    }
                    if (process != null) {
                        if (site != process.getInternalPath().getSite()) {
                            creationCost += detachfromProcessCost;
                        }
                    }
                    if (bestSite == null || creationCost < bestCost) {
                        bestSite = site;
                        bestCost = creationCost;
                    }
                }
                break;
            }
            case FOLDER: {
                bestCost = 0;
                bestSite = localSite;
                break;
            }
            default: {
                bestCost = 0;
                bestSite = localSite;
            }
        }

        return bestSite;
    }

    public KSite getSiteForMigration(KResourceType type, long size, KProcess process, String path) {
        return null;
    }

    public List<MigrationInfo> getMigrationProposal() {
        return null;
    }

    public static class MigrationInfoImpl implements KCostManager.MigrationInfo {
        private KProcess process;
        private String toSite;

        public MigrationInfoImpl(KProcess process, String toSite) {
            this.process = process;
            this.toSite = toSite;
        }

        public KProcess getProcess() {
            return process;
        }

        public String getToSite() {
            return toSite;
        }
    }
}
