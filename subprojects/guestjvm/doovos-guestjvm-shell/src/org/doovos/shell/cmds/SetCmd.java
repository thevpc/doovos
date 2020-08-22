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

import org.doovos.api.DSystem;
import org.doovos.shell.DShell;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 26 oct. 2004
 * Time: 23:08:51
 */
public class SetCmd implements DShellInternalCmd {
    public void exec(String[] args, DShell shell) throws Exception {
        System.out.println("setting");
        if (!DSystem.isDoovosEnabled()) {
            System.out.println(getClass().getName() + " : " + Arrays.asList(args));
            return;
        }
        int commandArgsCount = args.length;
        for (int i = 0; i < commandArgsCount; i++) {
            String name = args[i];
            boolean isSetted = false;
            if (i < (commandArgsCount - 1)) {
                String eq = args[i + 1];
                if ("=".equals(eq)) {
                    if (i < (commandArgsCount - 2)) {
                        doSet(name, args[i + 2],shell);
                        i += 2;
                        isSetted = true;
                    } else {
                        doSet(name, null,shell);
                        i += 1;
                        isSetted = true;
                    }
                }
            }
            if (!isSetted) {
                System.err.println(getSyntax());
                return;
            }
        }
    }

    private void doSet(String name, String value,DShell shell) throws RemoteException {
        if (value == null) {
            shell.setEnv(name, value);
        } else {
            String valsEnv = shell.getEnv(name + ".VALUES");
            if (valsEnv != null) {
                List<String> stringList = Arrays.asList(valsEnv.split(":"));
                if (!stringList.contains(value)) {
                    System.err.println("Invalid value "+name+"="+value);
                    System.err.println("Valid values are ");
                    for (String s : stringList) {
                        System.err.println("\t" + s);
                    }
                    return;
                }
            }
            shell.setEnv(name, value);
        }
    }

    public String getName() {
        return "set";
    }

    public String getSyntax() {
        return
                "set env=val\n" +
                        "or\n" +
                        "set env=\n" +
                        getDesc();
    }

    public String getDesc() {
        return "sets/unsets env vars";
    }
}