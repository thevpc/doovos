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

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.lib.text.ConsoleTable;
import org.doovos.lib.text.PropertyFilter;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 26 oct. 2004
 * Time: 23:08:51
 */
public class tree {

    static{
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "tree");
                pp.setMetadata("version", "0.2");
                pp.setMetadata("author", "Taha BEN SALAH");
                pp.setMetadata("date", "2010-12-08");
            }
        }
    }

    public static void main(String[] args) {
        PropertyFilter filter = null;
        File w = null;
        if (args.length == 0) {
            w = new File(".");
        } else if (args.length == 1) {
            w = new File(args[0]);
        } else if (args.length == 2 && "select".equals(args[0])) {
            w = new File(args[0]);
            filter = new PropertyFilter(args[1]);
        } else if (args.length == 3 && "select".equals(args[1])) {
            w = new File(args[0]);
            filter = new PropertyFilter(args[2]);
        }
        if (w != null) {
            printResourceItem(w, filter, true, null);
        } else {
            System.err.println(getSyntax());
        }
    }

    public static String getName() {
        return "tree";
    }

    public static String getSyntax() {
        return "tree [<RESOURCE>] [select <COLUMNS>]";
    }

    public static String getDesc() {
        return "List Resource content as a Tree";
    }

    private static void printResourceItem(File r, PropertyFilter filter, boolean isLast, String prefix) {
        ArrayList<String> propsList = null;
        if (filter != null) {
            LinkedHashSet<String> props = new LinkedHashSet<String>();
            props.addAll(ls.getFilePropNames(r, filter));
            propsList = new ArrayList<String>(props);
            filter.reorderProperies(propsList);
            if (!propsList.contains("name")) {
                propsList.add(0, "name");
            }
        }

        StringBuilder sb = new StringBuilder();
        if (prefix == null) {

        } else {
            sb.append(prefix);
            sb.append("+- ");
        }
        boolean leaf = false;//r.isLeaf();
        if (!leaf) {
            sb.append("[");
        }
        System.out.print(sb.toString());

        String title;
        if (filter == null || propsList.size() == 0) {
            title = r.getName();
        } else {
            StringBuilder tb = new StringBuilder();
            Map<String, Object> prps = ls.getFileProps(r, filter);
            for (String s : propsList) {
                if (tb.length() > 0) {
                    tb.append(" ; ");
                    tb.append(s).append("=").append(ConsoleTable.stringify(prps.get(s)));
                } else {
                    tb.append(ConsoleTable.stringify(prps.get(s)));
                }
            }
            title = tb.toString();
        }
        System.out.print(title);
        if (!leaf) {
            System.out.print("]");
        }
        System.out.println();
        String cprefix = prefix == null ? "" : (isLast ? (prefix + "   ") : (prefix + "|  "));
        File[] children = r.listFiles();
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                printResourceItem(children[i], filter, i == children.length - 1, cprefix);
            }
        }
    }
}
