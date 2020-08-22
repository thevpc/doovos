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
package org.doovos.kernel.api.process;

import org.doovos.kernel.api.filesystem.KPropertyEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 19 nov. 2004
 * Time: 21:53:38
 */
public class KProcessTrapSupport implements Serializable {
    private int latestTrapId;
    protected Map<String, LinkedHashSet<KProcessTrap>> trapListByPropetyName;
    protected Map<Integer, String> propertyNameByTrapId;
    protected KProcess process;

    public KProcessTrapSupport(KProcess process) {
        this.process = process;
    }

    public int addTrap(KProcessTrap dProcessTrap, String propertyEvent) {
        dProcessTrap.setTrapIt(latestTrapId);
        if (trapListByPropetyName == null) {
            trapListByPropetyName = new HashMap<String, LinkedHashSet<KProcessTrap>>();
            propertyNameByTrapId = new HashMap<Integer, String>();
        }
        LinkedHashSet<KProcessTrap> plisteners = trapListByPropetyName.get(propertyEvent);
        if (plisteners == null) {
            plisteners = new LinkedHashSet<KProcessTrap>(3);
            trapListByPropetyName.put(propertyEvent, plisteners);
            propertyNameByTrapId.put(dProcessTrap.getTrapIt(), propertyEvent);
        }
        plisteners.add(dProcessTrap);
        latestTrapId++;
        return dProcessTrap.getTrapIt();
    }

    public void removeTrap(int id) {
        if (trapListByPropetyName != null) {
            String propertyEvent = propertyNameByTrapId.get(id);
            if (propertyEvent != null) {
                LinkedHashSet<KProcessTrap> plisteners = trapListByPropetyName.get(propertyEvent);
                for (Iterator<KProcessTrap> iterator = plisteners.iterator(); iterator.hasNext();) {
                    KProcessTrap trap = iterator.next();
                    if (trap.getTrapIt() == id) {
                        iterator.remove();
                        break;
                    }
                }
                if (plisteners.size() == 0) {
                    trapListByPropetyName.remove(propertyEvent);
                    if (trapListByPropetyName.size() == 0) {
                        trapListByPropetyName = null;
                    }
                }
                propertyNameByTrapId.remove(id);
            }
        }
    }

    public void fireTrapEvent(KPropertyEvent event) {
        if (trapListByPropetyName != null) {
            for (Map.Entry<String, LinkedHashSet<KProcessTrap>> listArray : trapListByPropetyName.entrySet()) {
                for (KProcessTrap trap : listArray.getValue()) {
                    try {
                        trap.onPropertyEvent(process, event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
