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

import org.doovos.api.io.DFile;
import org.doovos.api.io.DResourceType;

import java.io.File;
import java.util.*;
import java.util.ArrayList;
import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.lib.text.ConsoleTable;
import org.doovos.lib.text.PropertyFilter;
import org.doovos.lib.text.StyledShunck;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 26 oct. 2004
 * Time: 23:08:51
 */
public class ls {
    static{
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "ls");
                pp.setMetadata("version", "0.2");
                pp.setMetadata("author", "Taha BEN SALAH");
                pp.setMetadata("date", "2010-12-08");
            }
        }
    }

    public static void main(String[] args) {
//        System.out.print("");
        PropertyFilter propertyFilter = null;
        String orderby = null;
        ArrayList<File> paths = new ArrayList<File>();
        boolean noheader = false;
        boolean nototal = false;
        boolean nosubtotal = false;
        boolean recursive = false;
        for (int i = 0; i < args.length; i++) {
            if ("-select".equals(args[i])) {
                if (i + 1 >= args.length) {
                    throw new RuntimeException("Expected select props as regexp");
                }
                i++;
                propertyFilter = new PropertyFilter(args[i]);
            } else if ("-orderby".equals(args[i])) {
                if (i + 1 >= args.length) {
                    throw new RuntimeException("Expected orderby props as regexp");
                }
                i++;
                orderby = args[i];
            } else if ("-noheader".equals(args[i])) {
                noheader = true;
            } else if ("-recursive".equals(args[i])) {
                recursive = true;
            } else if ("-nototal".equals(args[i])) {
                nototal = true;
            } else if ("-nosubtotal".equals(args[i])) {
                nosubtotal = true;
            } else if (args[i].startsWith("-")) {
                throw new RuntimeException("Unknown option " + args[i]);
            } else {
                paths.add(new File(args[i]));
            }
        }
        if (paths.isEmpty()) {
            paths.add(new File("."));
        }
        int totalCount = 0;
        for (File w : paths) {
            ArrayList<File> r = new ArrayList<File>(listResources(w));
            if (recursive) {
                Stack<File> s = new Stack<File>();
                s.addAll(r);
                r.clear();
                while (!s.empty()) {
                    File r0 = s.pop();
                    r.add(r0);
                    ArrayList<File> r2 = new ArrayList<File>(listResources(r0));
                    for (File r22 : r2) {
                        s.push(r22);
                    }
                }
            }
            totalCount += r.size();
            if (orderby != null) {
                //KPropertyComparator rac = new KPropertyComparator(orderby);
                //Collections.sort(r, rac);
            }

            LinkedHashSet<String> props = new LinkedHashSet<String>();
            for (File dResource : r) {
                props.addAll(getFilePropNames(dResource, propertyFilter));
            }
            ArrayList<String> propsList = new ArrayList<String>(props);
            if (propertyFilter != null) {
                propertyFilter.reorderProperies(propsList);
            }
            ConsoleTable consoleTable = new ConsoleTable();
            consoleTable.setShowHeader(!noheader);
            for (String aPropsList : propsList) {
                consoleTable.addColumn(new StyledShunck(aPropsList, null/*DShellUtils.getHeaderAttrib()*/));
            }
            for (File file : r) {
                Map<String, Object> prps = getFileProps(file, propertyFilter);
                Object[] vals = new Object[propsList.size()];
                for (int j = 0; j < vals.length; j++) {
                    /*Attributes*/
                    Object style = null;//DShellUtils.getAttrib(dResource, propsList.get(j), vals);
                    Object value = prps.get(propsList.get(j));
                    consoleTable.addCell(new StyledShunck(ConsoleTable.stringify(value), style));
                }
            }
            consoleTable.write(System.out);
            System.out.println();
            if (!nosubtotal) {
                if (paths.size() > 1) {
                    System.out.print("list '");
                    System.out.print(w);
                    System.out.print("' : ");
                    System.out.print(String.valueOf(r.size())/*, DShellUtils.getAttrib(null, null, r.size())*/);
                    System.out.print(" listed ressources.");
                }
            }
        }
        if (!nototal) {
            System.out.print("Total : ");
            System.out.print(String.valueOf(totalCount)/*, DShellUtils.getAttrib(null, null, totalCount)*/);
            System.out.println(" listed ressources.");
        }
    }

    public static Set<String> getFilePropNames(File path, PropertyFilter propertyFilter) {
        Set<String> prps = new LinkedHashSet<String>();
        if (propertyFilter == null || propertyFilter.matchesProperty("type")) {
            prps.add("type");
        }
        if (propertyFilter == null || propertyFilter.matchesProperty("typename")) {
            prps.add("typename");
        }
        if (propertyFilter == null || propertyFilter.matchesProperty("name")) {
            prps.add("name");
        }
        if (propertyFilter == null || propertyFilter.matchesProperty("size")) {
            prps.add("size");
        }
        if (propertyFilter == null || propertyFilter.matchesProperty("rights")) {
            prps.add("rights");
        }
        if (propertyFilter == null || propertyFilter.matchesProperty("site")) {
            prps.add("site");
        }
        if (propertyFilter == null || propertyFilter.matchesProperty("creationsite")) {
            prps.add("creationsite");
        }
        return prps;
    }

    public static Map<String, Object> getFileProps(File path, PropertyFilter propertyFilter) {
        Map<String, Object> prps = new HashMap<String, Object>();
        if (DSystem.isDoovosEnabled()) {
            DFile f = new DFile(path);
            if (propertyFilter == null || propertyFilter.matchesProperty("type")) {
                prps.put("type", f.isDirectory() ? "D" : f.isFile() ? "-" : "?");
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("typename")) {
                DResourceType rt = f.getResourceType();
                prps.put("typename", rt == null ? "-" : rt);
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("site")) {
                String rt = f.getSite();
                prps.put("site", rt == null ? "-" : rt);
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("creationsite")) {
                String rt = f.getSite();
                prps.put("creationsite", rt == null ? "-" : rt);
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("name")) {
                prps.put("name", f.getName());
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("size")) {
                prps.put("size", f.isDirectory() ? "-" : f.length());
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("rights")) {
                prps.put("rights", (f.canRead() ? "R" : "-") + (f.canRead() ? "W" : "-") + (f.isHidden() ? "H" : "-"));
            }
        } else {
            File f = path;
            if (propertyFilter == null || propertyFilter.matchesProperty("type")) {
                prps.put("type", f.isDirectory() ? "D" : f.isFile() ? "-" : "?");
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("name")) {
                prps.put("name", f.getName());
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("size")) {
                prps.put("size", f.isDirectory() ? "-" : f.length());
            }
            if (propertyFilter == null || propertyFilter.matchesProperty("rights")) {
                prps.put("rights", (f.canRead() ? "R" : "-") + (f.canRead() ? "W" : "-") + (f.isHidden() ? "H" : "-"));
            }
        }
        return prps;
    }

//    public void exec0(Command command, ShellProgram program, DProcessLocal process) throws Exception {
//
//        DPath w = process.getWorkingDir();
//        DPropertyFilter propertyFilter = null;
//        String orderby = null;
//        final int EXPECT_FOLDER = 0;
//        final int EXPECT_SELECT = 1;
//        final int EXPECT_SELECT_PROPS = 2;
//        final int EXPECT_ORDERBY = 3;
//        final int EXPECT_ORDERBY_PROPS = 4;
//        final int EXPECT_END = 5;
//        int expect = EXPECT_FOLDER;
//        for (int i = 0; i < command.getCommandArgsCount(); i++) {
//            switch (expect) {
//                case EXPECT_FOLDER: {
//                    if ("select".equals(command.getCommandArg(i))) {
//                        expect = EXPECT_SELECT_PROPS;
//                    } else if ("orderby".equals(command.getCommandArg(i))) {
//                        w = new DPath(".");
//                        expect = EXPECT_ORDERBY_PROPS;
//                    } else {
//                        w = command.getPathArg(i, process);
//                        expect = EXPECT_SELECT;
//                    }
//                    break;
//                }
//                case EXPECT_SELECT: {
//                    if ("select".equals(command.getCommandArg(i))) {
//                        expect = EXPECT_SELECT_PROPS;
//                    } else if ("orderby".equals(command.getCommandArg(i))) {
//                        expect = EXPECT_ORDERBY_PROPS;
//                    } else {
//                        throw new CmdSyntaxeError("Expected select keyword");
//                    }
//                    break;
//                }
//                case EXPECT_SELECT_PROPS: {
//                    if ("orderby".equals(command.getCommandArg(i))) {
//                        expect = EXPECT_ORDERBY_PROPS;
//                    } else {
//                        propertyFilter = new DPropertyFilter(command.getStringArg(i, process));
//                        expect = EXPECT_ORDERBY;
//                    }
//                    break;
//                }
//                case EXPECT_ORDERBY: {
//                    if ("orderby".equals(command.getCommandArg(i))) {
//                        expect = EXPECT_ORDERBY_PROPS;
//                    } else {
//                        throw new CmdSyntaxeError("Expected orderby keyword");
//                    }
//                    break;
//                }
//                case EXPECT_ORDERBY_PROPS: {
//                    orderby = command.getStringArg(i, process);
//                    expect = EXPECT_END;
//                    break;
//                }
//                case EXPECT_END: {
//                    break;
//                }
//            }
//        }
//
//        switch (expect) {
//            case EXPECT_FOLDER: {
//                break;
//            }
//            case EXPECT_SELECT: {
//                break;
//            }
//            case EXPECT_SELECT_PROPS: {
//                throw new CmdSyntaxeError("Expected select props as regexp");
//            }
//            case EXPECT_ORDERBY: {
//                break;
//            }
//            case EXPECT_ORDERBY_PROPS: {
//                throw new CmdSyntaxeError("Expected orderby props as regexp");
//            }
//            case EXPECT_END: {
//                break;
//            }
//        }
//
//        ArrayList<DResource> r = new ArrayList<DResource>(listResources(w, null));
//        if (orderby != null) {
//            DPropertyComparator rac = new DPropertyComparator(orderby);
//            Collections.sort(r, rac);
//        }
//
//        LinkedHashSet<String> props = new LinkedHashSet<String>();
//        for (DResource dResource : r) {
//            props.addAll(dResource.getPropertyNames(propertyFilter));
//        }
//        ArrayList<String> propsList = new ArrayList<String>(props);
//        if (propertyFilter != null) {
//            propertyFilter.reorderProperies(propsList);
//        }
//        ConsoleTable consoleTable=new ConsoleTable();
//        for (int i = 0; i < propsList.memorySize(); i++) {
//            consoleTable.addColumn(new ConsoleTable.StyledShunck(propsList.get(i),program.getHeaderAttrib()));
//        }
//        for (DResource dResource : r) {
//            Map<String, Object> prps = dResource.getProperties(propertyFilter);
//            Object[] vals = new Object[propsList.memorySize()];
//            for (int j = 0; j < vals.length; j++) {
//                Attributes style= program.getAttrib(dResource, propsList.get(j), vals);
//                Object value = prps.get(propsList.get(j));
//                consoleTable.addCell(new ConsoleTable.StyledShunck(ShellUtils.stringify(value),style));
//            }
//        }
//        consoleTable.write(process.getStdout());
//        process.getStdout().writeln("");
//        process.getStdout().write("list : ");
//        process.getStdout().write(String.valueOf(r.memorySize()), program.getAttrib(null, null, r.memorySize()));
//        process.getStdout().writeln(" listed ressources.");
//
//    }
//
    public String getName() {
        return "ls";
    }

    public String getSyntax() {
        return "list [<OPTIONS>] [<RESOURCE>]... \n"
                + "   <RESOURCE>... : any resource path list\n"
                + "   <OPTIONS>  : \n"
                + "     -select <COLUMNS_FILTER> : columns to select regular expression. By default all\n"
                + "                      columns are slelected witch is equivalent to '.*'\n"
                + "{    -where  <EXPRESSION> : NOT IMPLEMENTED YET}\n"
                + "     -orderby <ORDER_COLUMNS>  : columns to order by separated by | and suffixed with + \n"
                + "                      for ascending order or - for descending order\n"
                + "     -recursive   : recursive search\n"
                + "     -noheader    : do not show header\n"
                + "     -nototal     : do not show total\n"
                + "     -nosubtotal  : do not show subtoTal\n"
                + "\n"
                + "Examples:\n"
                + "   list\n"
                + "      lists all resources in the current working directory\n"
                + "   list -select name|memorySize -orderby folder-|name+ ./myfolder \n"
                + "      lists all resources in the directory ./myfolder and shows columns \n"
                + "      name and memorySize. order is performed first according on type (folders first) \n"
                + "      than according to name."
                + "";
    }

    public String getDesc() {
        return "List Resource Content";
    }

    public static Collection<File> listResources(File w) {
        File[] strings = w.listFiles();
        ArrayList<File> arr = new ArrayList<File>();
        if (strings != null) {
            arr.addAll(Arrays.asList(strings));
        }
        return arr;
    }

    


}
