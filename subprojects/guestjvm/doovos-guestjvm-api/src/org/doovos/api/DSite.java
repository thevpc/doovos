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
 * Doovos API is a standard library running on Doovos guest JVM (distributed
 * jvm) to access Doovos mechanisms that are not handled by the Java Platform
 * standard libraries.
 * Il gives access to system processes, system threads, etc...

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
package org.doovos.api;

/**
 * Doovos Site structure
 */
public class DSite {
    private String uuid;
    private String name;
    private String url;
    private boolean alive;
    private boolean local;

    public DSite(String uuid, String name, String url, boolean local, boolean alive) {
        this.uuid = uuid;
        this.name = name;
        this.url = url;
        this.local = local;
        this.alive = alive;
    }

    /**
     *
     * @return true if the site is alive (running) and accessible
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     *
     * @return true if this instance denotes the current site
     */
    public boolean isLocal() {
        return local;
    }

    /**
     *
     * @return site id/name
     */
    public String getName() {
        return name;
    }

    /**
     * site access url
     * @return site access url
     */
    public String getUrl() {
        return url;
    }

    public String getUUID() {
        return uuid;
    }

}
