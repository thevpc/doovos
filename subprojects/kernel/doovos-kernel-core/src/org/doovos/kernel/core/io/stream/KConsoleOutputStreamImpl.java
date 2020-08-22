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
package org.doovos.kernel.core.io.stream;

import enigma.console.Console;
import enigma.console.TextAttributes;
import org.doovos.kernel.core.io.term.console.TextConsole;

import java.awt.*;
import java.rmi.RemoteException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 19 nov. 2004
 * Time: 22:27:42
 */
public class KConsoleOutputStreamImpl extends KOutputStreamImpl {
    private TextConsole console;

    public KConsoleOutputStreamImpl(TextConsole console) throws RemoteException {
        super(console.getOutputStream());
        this.console = console;
//        if (validAttributes == null) {
//            validAttributes = new TreeSet<String>();
//        }
//        validAttributes.add(FORECOLOR_ATTRIBUTE);
//        validAttributes.add(BACKCOLOR_ATTRIBUTE);
//        validAttributes.add(WINDOWTITLE_ATTRIBUTE);
    }

    public Console getConsole() {
        return console;
    }

    public Object setAttribute(String name, Object newValue) {
        if (FORECOLOR_ATTRIBUTE.equals(name)) {
            TextAttributes old = console.getTextAttributes();
            console.setTextAttributes(new TextAttributes((Color) newValue, old.getBackground()));
            return old.getForeground();
        } else if (BACKCOLOR_ATTRIBUTE.equals(name)) {
            TextAttributes old = console.getTextAttributes();
            console.setTextAttributes(new TextAttributes(old.getForeground(), (Color) newValue));
            return old.getBackground();
        } else if (WINDOWTITLE_ATTRIBUTE.equals(name)) {
            String old = console.getTitle();
            console.setTitle((String) newValue);
            return old;
        } else if (CLS_ATTRIBUTE.equals(name)) {
            if ((Boolean) newValue) {
                console.clear();
            }
            return false;
        } else {
            return super.setAttribute(name, newValue);
        }
    }

    public String toString() {
        return super.toString() + " [console " + console.getTitle() + "]";
    }
}
