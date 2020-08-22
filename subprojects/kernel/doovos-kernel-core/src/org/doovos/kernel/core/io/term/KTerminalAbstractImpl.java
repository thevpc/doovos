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
package org.doovos.kernel.core.io.term;

import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.io.screen.KConstructor;
import org.doovos.kernel.api.io.screen.KScreenDevice;
import org.doovos.kernel.api.io.term.KTerminal;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.io.term.KLocalTerminal;

import javax.swing.*;
import java.rmi.RemoteException;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 01-dec.-2005
 * Time: 9:05:14
 */
public abstract class KTerminalAbstractImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalTerminal {

    private KScreenDevice screen;
    private JComponent component;
    private String title;

    public KTerminalAbstractImpl() throws RemoteException {
        super(KResourceType.DEVICE, true,null,DoovosConstants.DEVICE_TERM_PREFIX, null);
    }

    public KTerminalAbstractImpl(KConstructor<? extends KTerminal> params) throws RemoteException {
        super(KResourceType.DEVICE, true,((KScreenDevice) params.get(KTerminal.SCREEN_PROPERTY)).getPath(), DoovosConstants.DEVICE_TERM_PREFIX, null);
        this.screen = ((KScreenDevice) params.get(KTerminal.SCREEN_PROPERTY));
        this.component = (JComponent) params.get(KTerminal.COMPONENT_PROPERTY, false);
        this.title = (String) params.get(KTerminal.TITLE_PROPERTY);
    }

    public KScreenDevice getScreen() {
        return screen;
    }

    public JComponent getComponent() {
        return component;
    }

    public String getTitle() {
        return title == null ? getName() : title;
    }
}
