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
package org.doovos.shell.cmds;

import org.doovos.shell.DShell;

import java.util.Map;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 26 oct. 2004
 * Time: 23:08:51
 */
public class PropsCmd implements DShellInternalCmd {

    public void exec(String[] args, DShell shell) throws Exception {
        if (args.length == 0) {
            for (Map.Entry e : System.getProperties().entrySet()) {
                System.out.println(e.getKey() + " = " + e.getValue());
            }
        } else{
            throw new CmdSyntaxError(args, getName(), getSyntax(), "Wrong number of arguments " + args.length + " != 0");
        }
    }

    public String getName() {
        return "props";
    }

    public String getSyntax() {
        return "props\n"
                + getDesc();
    }

    public String getDesc() {
        return "show properties vars";
    }
}
