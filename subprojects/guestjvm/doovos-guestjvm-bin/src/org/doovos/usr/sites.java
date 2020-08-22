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
package org.doovos.usr;

import org.doovos.api.DSite;
import org.doovos.api.DSystem;

import java.io.PrintStream;
import org.doovos.api.DProcess;
import org.doovos.lib.text.ConsoleTable;
import org.doovos.lib.text.StyledShunck;

public class sites {
    static{
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "sites");
                pp.setMetadata("version", "0.2");
                pp.setMetadata("author", "Taha BEN SALAH");
                pp.setMetadata("date", "2010-12-08");
            }
        }
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        if (args.length == 0) {

            DSite[] table = DSystem.getSites();

            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.setShowHeader(true);
            consoleTable.addColumn(new StyledShunck("uuid", null/*DShellUtils.getHeaderAttrib()*/));
            consoleTable.addColumn(new StyledShunck("name", null/*DShellUtils.getHeaderAttrib()*/));
            consoleTable.addColumn(new StyledShunck("location", null/*DShellUtils.getHeaderAttrib()*/));
            consoleTable.addColumn(new StyledShunck("status", null/*DShellUtils.getHeaderAttrib()*/));
            consoleTable.addColumn(new StyledShunck("url", null/*DShellUtils.getHeaderAttrib()*/));

            for (DSite site : table) {
                consoleTable.addCell(new StyledShunck(site.getUUID(), null));
                consoleTable.addCell(new StyledShunck(site.getName(), null));
                consoleTable.addCell(new StyledShunck(site.isLocal() ? "<LOCAL>" : "<REMOTE>", null));
                consoleTable.addCell(new StyledShunck(site.isAlive() ? "<ALIVE>" : "<DEAD> ", null));
                consoleTable.addCell(new StyledShunck(site.getUrl(), null));
            }
            consoleTable.write(out);
            out.print("There are ");
            out.print(table.length);
            out.print(" Registered Sites.");
            out.println();

        } else if (args.length == 1 && "-local".equals(args[0])) {
            out.println(DSystem.getLocalSite().getName());
        } else {
            out.println("Syntax error");
        }
    }
}
