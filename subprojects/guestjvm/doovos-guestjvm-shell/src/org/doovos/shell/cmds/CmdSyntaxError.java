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

import org.doovos.shell.interpreter.ShellException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 13 nov. 2004
 * Time: 21:17:13
 */
public class CmdSyntaxError extends ShellException {
//    public CmdSyntaxError() {
//        super("Syntaxe Error. Please check command parameters.");
//    }

    public CmdSyntaxError(String[] args, String cmd, String desc, String message) {
        super(buildMessage(args, cmd, desc, message));
    }

    private static String buildMessage(String[] args, String cmd, String desc, String message) {
        StringBuilder s = new StringBuilder();
        if (cmd != null) {
            s.append(cmd);
            s.append(" : ");
            s.append("Syntaxe Error.");
        }
        s.append(message);
        if (args != null) {
            s.append("\nPlease check command parameters.");
            s.append("\nArguments where : ");
            for (int i = 0; i < args.length; i++) {
                String a = args[i];
                if (i > 0) {
                    s.append(", ");
                }
                s.append("\"");
                s.append(a);
                s.append("\"");
            }
        }
        if (desc != null) {
            s.append("\n");
            s.append(desc);
        }
        return s.toString();
    }
}
