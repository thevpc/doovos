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
package org.doovos.system.boot;

import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.api.DThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class DoovosLogin {

    static {
        DProcess info = DProcess.getProcess();
        String title = info.getMetadata("title");
        if (title == null) {
            info.setMetadata("title", "DoovosLogin");
            info.setMetadata("version", "0.1");
            info.setMetadata("author", "Taha GEN SALAH");
            info.setMetadata("date", "2009-04-12");
        }
    }

    public static void main(String[] args) {
        while (true) {
            try {
                String login = "";
                String password = "";
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                PrintStream out = System.out;
                //in.setAttributes(promptAttribute);
                //out.write("login: ", promptAttribute);
                out.print("login: ");
                login = in.readLine();
                if (login != null && login.length() > 0) {
                    //out.write("password: ", promptAttribute);
                    out.print("password: ");
                    //in.setAttributes(promptAttribute);
                    password = in.readLine();
                    DSystem.exec(DoovosSession.class.getName(), null, null, login, password.toCharArray(), null);
                    DThread.getThread().waitChild();
                }
            } catch (Exception e) {
                System.err.println("LOGIN ERROR : " + e);
            }
        }
    }

    /**
     * run
     *
     * @param path
     */
    public static void inlineInProcess(String path) {
        File file = new File(path);
        if (file.exists()) {
            try {
                DSystem.inline(path);
            } catch (Exception e) {
                System.err.println(e.toString());
                e.printStackTrace();
            }
        }
    }
}
