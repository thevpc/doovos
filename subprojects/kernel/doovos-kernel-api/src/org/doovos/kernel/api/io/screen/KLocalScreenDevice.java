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
package org.doovos.kernel.api.io.screen;

import org.doovos.kernel.api.io.term.KTerminal;

import java.rmi.RemoteException;
import org.doovos.kernel.api.filesystem.KLocalResource;

/**
 * Main interface for Screen Devices handled by Doovos
 *
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 01-dec.-2005
 * Time: 8:51:15
 */
public interface KLocalScreenDevice extends KScreenDevice,KLocalResource {

    /**
     * show the given terminal on the screen. other terminal may become invisible.
     * the selected terminal is the only active terminal
     *
     * @param name
     * @
     */
    public void selectTerminal(String name) throws RemoteException;

    /**
     * create new terminal
     *
     * @param terminal new terminal configuration
     * @return
     * @
     */
    public KTerminal addTerminal(KConstructor<KTerminal> terminal) throws RemoteException;

    /**
     * retrieve the default terminal for this screen. A screen must at lease have a terminal.
     *
     * @return
     * @
     */
    public KTerminal getDefaultTerminal() throws RemoteException;
}
