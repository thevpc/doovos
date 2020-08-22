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

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 26 oct. 2004
 * Time: 23:08:51
 */
public class AliasCmd implements DShellInternalCmd {

    public void exec(String[] args, DShell shell) throws Exception {
        int commandArgsCount = args.length;
        if (commandArgsCount == 0) {
            for (String k : shell.getAliases()) {
                System.out.print(k);
                System.out.print(" = ");
                System.out.print(shell.getAlias(k));
                System.out.println();
            }
        } else if (commandArgsCount == 2 && args[1].equals("=")) {
            shell.setAlias(args[0], null);
        } else if (commandArgsCount == 2) {
            shell.setAlias(args[0], args[1]);
        } else if (commandArgsCount == 3 && args[1].equals("=")) {
            shell.setAlias(args[0], args[2]);
        } else if (commandArgsCount % 3 == 0) {
            int c = commandArgsCount / 3;
            for (int i = 0; i < c; i++) {
                if (!args[i * 3 + 1].equals("=")) {
                    throw new CmdSyntaxError(
                            args,
                            getName(),
                            getSyntax(),
                            "expected = in argument "+(i * 3 + 1)+" but got "+args[i * 3 + 1]);
                }
            }
            for (int i = 0; i < c; i++) {
                shell.setAlias(args[3*i], args[3*i+2]);
            }
        } else {
            throw new CmdSyntaxError(
                            args,
                            getName(),
                            getSyntax(),
                            "wrong number of arguments "+commandArgsCount);
        }
    }

    public String getName() {
        return "alias";
    }

    public String getSyntax() {
        return "alias [[-add <name> <value>] | -remove <name>]";
    }

    public String getDesc() {
        return "list, create or remove aliases";
    }
}
