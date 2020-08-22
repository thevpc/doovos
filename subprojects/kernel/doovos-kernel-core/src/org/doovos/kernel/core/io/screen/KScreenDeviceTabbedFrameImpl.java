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

import enigma.core.Enigma;
import enigma.util.Util;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.io.KProperties;
import org.doovos.kernel.api.io.term.KLocalTerminal;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.rmi.RemoteException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 01-dec.-2005
 * Time: 14:57:09
 */
public class KScreenDeviceTabbedFrameImpl extends KScreenDeviceAbstractImpl {
    private JFrame frame = null;
    private JTabbedPane pane = null;
    private boolean exclusive = false;

    public KScreenDeviceTabbedFrameImpl() throws RemoteException {
        super("scrtab");
        KProperties props = null;
        try {
            props = new KProperties(DoovosConstants.SYSTEM_BOOT_PATH + "/boot.config");
            String value = props.getProperty("DScreenDeviceTabbedFrameImpl.exclusiveMode", "false");
            exclusive = Boolean.parseBoolean(value);
        } catch (IOException e) {
            //ignore error
        }
    }

    protected void addTerminal(final KLocalTerminal consoleTerminal) throws RemoteException {
        String title = consoleTerminal.getTitle();
        if (frame == null) {
            frame = new JFrame(Doovos.VERSION.getOsId() + " - " + Doovos.VERSION.getOsVersion() + " - site : " + Doovos.getSystem().getName());
            pane = new JTabbedPane();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(pane);
        }
        final JScrollPane scrollPane = new JScrollPane(consoleTerminal.getComponent());
        pane.addTab(
                title != null ? title : Util.msg(Enigma.class, "default.console.title"),
                scrollPane
        );
        pane.setSelectedIndex(pane.getTabCount() - 1);
        if (pane.getTabCount() == 1) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    if (exclusive) {
                        frame.setUndecorated(true);
                        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
                    } else {
                        frame.pack(); // force peer to be created so that insets are known
                        frame.setSize(frame.getPreferredSize());
                        frame.setVisible(true);
                    }
                }
            });
        }
        // workaround for 1.3.1: requestFocus not working unless run in another invokeLater
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    consoleTerminal.getComponent().requestFocus();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public int getTerminalIndex(String name) throws RemoteException {
        KLocalTerminal term = getLocalChild(name);
        return pane.indexOfComponent(term.getComponent());
    }

    public void selectTerminal(String name) throws RemoteException {
        int i = getTerminalIndex(name);
        if (i >= 0) {
            pane.setSelectedIndex(i);
        }
    }

    protected void hideTerminal(String name) throws RemoteException {
        int i = getTerminalIndex(name);
        if (i >= 0) {
            pane.removeTabAt(i);
        }
    }

    protected void freeImpl() throws RemoteException {
        super.freeImpl();
        frame.setVisible(false);
        frame.dispose();
    }
}
