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

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 26 oct. 2004
 * Time: 23:08:51
 */
public class EnvCmd implements DShellInternalCmd {

    public void exec(String[] args, DShell shell) throws Exception {
        if (!DSystem.isDoovosEnabled()) {
            System.out.println(getClass().getName() + " : " + Arrays.asList(args));
            return;
        }
        System.out.println("v1.1");
        int commandArgsCount = args.length;
        if (commandArgsCount == 0) {
            showEnvs(shell);
        } else {
            for (int i = 0; i < commandArgsCount; i++) {
                String name = args[i];
                showEnv(name,shell);
            }
        }
    }

    public static void showEnvs(DShell shell) {
        Properties shellProperties = shell.getShellProperties();
        String[] processEnvs = shellProperties.keySet().toArray(new String[shellProperties.size()]);
        Arrays.sort(processEnvs);
        for (String var : processEnvs) {
            if (!var.endsWith(".VALUES")) {
//                    System.out.print(System.identityHashCode(processEnv)+" ");
                if (shell.isExported(var)) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[ ] ");
                }
                System.out.println(var + "=\"" + shellProperties.getProperty(var) + "\"");
            }
        }
    }

    private static void showEnv(String name,DShell shell) {
        String s = shell.getEnv(name);
        System.out.println(s);
        String vals = shell.getEnv(name + ".VALUES");
        if (vals != null) {
            System.out.println("valid values are :");
            List<String> stringList = Arrays.asList(vals.split(":"));
            for (String s1 : stringList) {
                System.out.println(s1);
            }
        }

    }

    public String getName() {
        return "env";
    }

    public String getSyntax() {
        return "env env=val\n"
                + "or\n"
                + "set env=\n"
                + getDesc();
    }

    public String getDesc() {
        return "sets/unsets env vars";
    }
}
