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
package org.doovos.kernel.core.io.screen;

import org.doovos.kernel.api.io.screen.KConstructor;
import org.doovos.kernel.api.filesystem.KPropertyEvent;
import org.doovos.kernel.api.io.term.KTerminal;
import org.doovos.kernel.api.io.term.KLocalTerminal;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KLocalResource;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.core.io.term.KConsoleTextModeTerminalImpl;

import java.rmi.RemoteException;
import org.doovos.kernel.api.io.screen.KLocalScreenDevice;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 01-dec.-2005
 * Time: 9:04:42
 */
public abstract class KScreenDeviceAbstractImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalScreenDevice, KLocalResource {

    private String defaultTermName;

    public KScreenDeviceAbstractImpl(String prefix) throws RemoteException {
        super(KResourceType.DEVICE, false,DoovosConstants.DEVICE_PATH, prefix, null);
    }

    public KTerminal addTerminal(KConstructor<KTerminal> terminal) throws RemoteException {
        if (terminal == null) {
            terminal = new KConstructor<KTerminal>(KTerminal.class);
            terminal.set(KTerminal.TITLE_PROPERTY, null);
        }
        if (terminal.getType().equals(KTerminal.class)) {
            terminal.setType(KConsoleTextModeTerminalImpl.class);
//            terminal.setType(KConsoleWinTerminalImpl.class);
        }
        if (!terminal.contains(KTerminal.TITLE_PROPERTY)) {
            terminal.set(KTerminal.TITLE_PROPERTY, null);
        }
        terminal.set(KTerminal.SCREEN_PROPERTY, this);
        KLocalTerminal term;
        try {
            term = (KLocalTerminal) terminal.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Create Exception", e);
        }
        term.attach();
        defaultTermName = term.getName();
        addTerminal(term);
        return term;
    }


    public KTerminal getDefaultTerminal() throws RemoteException {
        return getLocalChild(defaultTermName);
    }

    protected abstract void addTerminal(KLocalTerminal consoleTerminal) throws RemoteException;

    protected abstract void hideTerminal(String terminalName) throws RemoteException;

    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
        super.onPropertyEvent(event);
//        if (ChildFreeEvent.NAME.equals(event.getPropertyName())) {
//            ChildFreeEvent e = (ChildFreeEvent) event.getNewValue();
//            try {
//                DTerminalLocal dTerminal = getLocalChild(e.getPath().getName());
//                if (dTerminal != null) {
//                    hideTerminal(dTerminal);
//                }
//            } catch (Exception e1) {
//                e1.printStackTrace();
//                //
//            }
//        }
    }

    public KLocalTerminal getLocalChild(String name) throws RemoteException {
        return (KLocalTerminal) super.getLocalChild(name);
    }

}
