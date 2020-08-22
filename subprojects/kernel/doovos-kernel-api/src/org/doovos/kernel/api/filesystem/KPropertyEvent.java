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

import org.doovos.kernel.api.Doovos;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 19 nov. 2004
 * Time: 21:23:15
 */
public class KPropertyEvent implements Serializable {
    private String source;
    private KResourceType type = KResourceType.UNKNOWN;
    private int eventId;
    private String propertyName;
    private Object oldValue;
    private Object newValue;

    public KPropertyEvent(String source, KResourceType type, int eventId, String propertyName, Object oldValue, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.eventId = eventId;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public KResource getResource() throws RemoteException {
        return Doovos.getSystem().getFileSystemManager().getResource(source);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public int getEventId() {
        return eventId;
    }

    public KResourceType getType() {
        return type;
    }
}
