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

import org.doovos.api.DProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import org.doovos.api.DSystem;
import org.doovos.lib.text.ConsoleTable;
import org.doovos.lib.text.PropertyFilter;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 26 oct. 2004
 * Time: 23:08:51
 */
public class pstree {
    static{
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "pstree");
                pp.setMetadata("version", "0.2");
                pp.setMetadata("author", "Taha BEN SALAH");
                pp.setMetadata("date", "2010-12-08");
            }
        }
    }
    
    public static void main(String[] args) {
        PropertyFilter filter = null;
        ConsoleTable table = new ConsoleTable();
        ArrayList<DProcess> processes = new ArrayList<DProcess>();

        table.addColumn("-");
        for (int i = 0; i < args.length; i++) {
            if ("-select".equals(args[i])) {
                if (i + 1 >= args.length) {
                    System.err.println("Expected select props as regexp");
                    return;
                }
                i++;
                filter = new PropertyFilter(args[i]);
            } else if (args[i].startsWith("-")) {
                System.err.println(getSyntax());
                return;
            } else {
                processes.add(DProcess.getProcess(Integer.parseInt(args[i])));
            }
        }
        if (processes.isEmpty()) {
            int[] ints = DProcess.getRootProcesses();
            for (int p : ints) {
                processes.add(DProcess.getProcess(p));
            }
        }
        List<String> props = null;
        if (filter == null) {
            props = new ArrayList<String>();
            props.add("TITLE");
        } else {
            props = getProperties(processes.toArray(new DProcess[processes.size()]));
            props = filter.filter(props);
        }
        for (String prop : props) {
            table.addColumn(prop);
        }
        for (DProcess pp : processes) {
            printResourceItem(pp, props, true, null, table);
        }
        table.write(System.out);
    }

    public static String getName() {
        return "pstree";
    }

    public static String getSyntax() {
        return "pstree -[select <PROPS_FILTER>] [<PROCESS>]... ";
    }

    public static String getDesc() {
        return "List Process hierarchy as a Tree";
    }

    private static void printResourceItem(DProcess topProcess, List<String> propsList, boolean isLast, String prefix, ConsoleTable table) {
        //File ff = new File("/runtime/processes/" + topProcess.getPID());

        StringBuilder sb = new StringBuilder();
        if (prefix == null) {
        } else {
            sb.append(prefix);
            sb.append("+- ");
        }
        boolean leaf = false;//topProcess != null && topProcess.isLeaf();
        if (!leaf) {
            sb.append("[");
        }

        sb.append(topProcess.getPID());
        sb.append("]");
        table.addCell(sb.toString());
        for (String prop : propsList) {
            table.addCell(getProperty(prop, topProcess));
        }
        table.newRow();
//        if (!leaf) {
//            System.out.print("] " + topProcess.getMetadata("title"));
//        }
        String cprefix = prefix == null ? "" : (isLast ? (prefix + "   ") : (prefix + "|  "));

        int[] c = topProcess.getChildren();

        for (int i = 0; i < c.length; i++) {
            printResourceItem(DProcess.getProcess(c[i]), propsList, i == c.length - 1, cprefix, table);
        }
    }

    private static List<String> getProperties(DProcess... processes) {
        TreeSet<String> a = new TreeSet<String>();
        a.add("PID");
        a.add("TITLE");
        for (DProcess p : processes) {
            for (Object k : p.getEnvs().keySet()) {
                a.add((String) k);
            }
        }
        return new ArrayList<String>(a);
    }

    private static String getProperty(String property, DProcess topProcess) {
//        table.addColumn("PID");
//        table.addColumn("TITLE");
//        table.addColumn("USER");
//        table.addColumn("HOME");
//        table.addColumn("CMD");
        if ("TITLE".equals(property)) {
            return topProcess.getMetadata("title");
        }
        return topProcess.getEnv(property);
    }
}
