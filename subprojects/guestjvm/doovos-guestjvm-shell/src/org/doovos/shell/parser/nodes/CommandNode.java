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
 * Doovos BIN is a standard implementation for Doovos boot sequence, shell and
 * common application tools. These applications are running onDoovos guest JVM
 * (distributed jvm).
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
package org.doovos.shell.parser.nodes;

import java.util.ArrayList;

public class CommandNode implements Node {
    public ArrayList items = new ArrayList();
    public ArrayList usingItems = new ArrayList();
    public ArrayList redirectItems = new ArrayList();
    public boolean nowait = false;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            CommandItemNode item = (CommandItemNode) items.get(i);
            sb.append("[").append(item).append("]");
        }
        if (usingItems.size() > 0) {
            sb.append(" using ");
            for (int i = 0; i < usingItems.size(); i++) {
                CommandUsingItemNode item = (CommandUsingItemNode) usingItems.get(i);
                sb.append(" [").append(item).append("]");
            }
        }
        for (int i = 0; i < redirectItems.size(); i++) {
            CommandRedirectItemNode item = (CommandRedirectItemNode) redirectItems.get(i);
            sb.append(" [").append(item).append("]");
        }
        if (sb.length() > 0) {
            if (nowait) {
                sb.append(" nowait");
            } else {
                sb.append(" wait");
            }
        } else {
            sb.append("<EMPTY COMMAND>");
        }
        return sb.toString();
    }
}
