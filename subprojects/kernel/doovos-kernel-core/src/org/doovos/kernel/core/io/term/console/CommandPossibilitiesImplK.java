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
package org.doovos.kernel.core.io.term.console;

import org.doovos.kernel.api.io.term.KTerminalCommandPossibilities;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 7 mars 2009
 * Time: 21:54:20
 * To change this template use File | Settings | File Templates.
 */
public class CommandPossibilitiesImplK implements KTerminalCommandPossibilities {
    private ArrayList<String> possibilities = new ArrayList<String>();
    boolean hasMore;

    public CommandPossibilitiesImplK() {
    }

    public Collection<String> getPossibilities() {
        return possibilities;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getMinimum() {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        char old = 0;
        whileloop:
        while (true) {
            forloop:
            for (int i = 0; i < possibilities.size(); i++) {
                String s = possibilities.get(i);
                if (!(index < s.length())) {
                    break whileloop;
                }
                char c = s.charAt(index);
                if (i == 0) {
                    old = c;
                }
                if (i > 0 && i < (possibilities.size() - 1)) {
                    if (c != old) {
                        break whileloop;
                    }
                }
                if (i == possibilities.size() - 1) {
                    if (c == old) {
                        sb.append(c);
                    } else {
                        break whileloop;
                    }
                }
            }
            index++;
        }
        return sb.toString();
    }
}
