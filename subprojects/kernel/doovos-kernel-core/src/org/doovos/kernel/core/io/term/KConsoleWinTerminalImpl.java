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

import org.doovos.kernel.api.io.screen.KConstructor;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;
import org.doovos.kernel.api.io.term.KTerminal;
import org.doovos.kernel.core.io.stream.KConsoleInputStreamImpl;
import org.doovos.kernel.core.io.stream.KConsoleOutputStreamImpl;
import org.doovos.kernel.core.io.term.console.TextConsole;

import java.rmi.RemoteException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 01-dec.-2005
 * Time: 9:18:50
 */
public class KConsoleWinTerminalImpl extends KTerminalAbstractImpl {
    private KConsoleInputStreamImpl inputStream;
    private KConsoleOutputStreamImpl outputStream;
    private KConsoleOutputStreamImpl errorStream;

    public KConsoleWinTerminalImpl() throws RemoteException {

    }

    public KConsoleWinTerminalImpl(KConstructor<? extends KTerminal> params) throws RemoteException {
        super(params.set(KTerminal.COMPONENT_PROPERTY, new TextConsole((String) params.get(KTerminal.TITLE_PROPERTY)).getTextWindow()));
        TextConsole textConsole = (TextConsole) getComponent().getClientProperty("TextConsole");
        if (getTitle() == null) {
            textConsole.setTitle(getName());
        }
        outputStream = new KConsoleOutputStreamImpl(textConsole);
        outputStream.attach();
        errorStream = new KConsoleOutputStreamImpl(textConsole);
        errorStream.attach();
//        errorStream.setAttribute(DConsoleOutputStreamImpl.FORECOLOR_ATTRIBUTE, new Color(255, 128, 128));
        inputStream = new KConsoleInputStreamImpl(textConsole);
        inputStream.attach();
    }

    public KInputStream getIn() {
        return inputStream;
    }

    public KOutputStream getOut() {
        return outputStream;
    }

    public KOutputStream getErr() {
        return errorStream;
    }
}
