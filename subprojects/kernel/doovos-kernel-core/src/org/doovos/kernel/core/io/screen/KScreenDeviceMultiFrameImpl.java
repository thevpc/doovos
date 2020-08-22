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
import org.doovos.kernel.api.io.term.KLocalTerminal;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 01-dec.-2005
 * Time: 14:57:09
 */
public class KScreenDeviceMultiFrameImpl extends KScreenDeviceAbstractImpl {

    private static class TermPeer {

        KLocalTerminal term;
        JFrame frame;
    }
//    private String currentTerm = null;
    private Map<String, TermPeer> frames = new HashMap<String, TermPeer>();

    public KScreenDeviceMultiFrameImpl() throws RemoteException {
        super("scrfrm");
    }

    protected void addTerminal(final KLocalTerminal consoleTerminal) throws RemoteException {
        TermPeer termPeer = new TermPeer();
        termPeer.term = consoleTerminal;
        frames.put(consoleTerminal.getName(), termPeer);
    }

    public JFrame getTerminalFrame(String name) throws RemoteException {
        final TermPeer ff = frames.get(name);
        if (ff == null) {
            throw new NoSuchElementException("Unknown terminal " + name);
        }
        if (ff.frame == null) {
            String title = ff.term.getTitle();
            final JFrame frame = new JFrame(title != null ? title : Util.msg(Enigma.class, "default.console.title"));
//        f.setLocation(random.nextInt(100), random.nextInt(100));
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            final JScrollPane scrollPane = new JScrollPane(ff.term.getComponent());
            frame.getContentPane().add(scrollPane);
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    frame.pack(); // force peer to be created so that insets are known
                    frame.setSize(frame.getPreferredSize());
                    frame.setVisible(true);
                    // workaround for 1.3.1: requestFocus not working unless run in another invokeLater
                    SwingUtilities.invokeLater(new Runnable() {

                        public void run() {
                            try {
                                ff.term.getComponent().requestFocus();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
            ff.frame=frame;
        }
        return ff.frame;
    }

    public void selectTerminal(String name) throws RemoteException {
        JFrame f = getTerminalFrame(name);
        f.toFront();
    }

    protected void hideTerminal(String name) throws RemoteException {
        JFrame f = getTerminalFrame(name);
        f.setVisible(false);
        f.dispose();
    }
}
