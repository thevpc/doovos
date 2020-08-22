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
package org.doovos.shell.interpreter;

import org.doovos.shell.DShell;
import org.doovos.shell.parser.CmdInfo;
import org.doovos.shell.parser.DShellParser;
import org.doovos.shell.parser.ParseException;
import org.doovos.shell.parser.Token;
import org.doovos.shell.parser.nodes.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public final class ShellInterpreter {

    private List<ShellSmt> stmts = new ArrayList<ShellSmt>();
    private Map labels = new HashMap();
    private int labelIndex = 0;
    private int shellCounter = 0;
    private DShell shell;

    public ShellInterpreter(DShell shell) {
        this.shell = shell;
    }
    
    public ShellInterpreter(DShell shell, InputStream inputStream) throws ParseException {
        this.shell = shell;
        compile(inputStream);
    }

    public ShellInterpreter(DShell shell, String code) throws ParseException {
        this.shell = shell;
        compile(code);
    }

    public void execute(String line, DShell shell) throws ParseException, Exception {
        compile(line);
        execute(shell);
    }

    public void execute(DShell shell) throws Exception {
        boolean haveNext = true;
        while (haveNext) {
            haveNext = next(shell);
        }
    }

    /**
     * @param process
     * @return false if no more commands to interpretate
     */
    public boolean next(DShell shell) throws Exception {
        ShellSmt shellSmt = (ShellSmt) stmts.get(shellCounter);
        int next = 0;
        try {
            next = shellSmt.run(shell, this);
        } catch (EndOfShellException e) {
            return false;
        }
        if (next == DShell.NEXT_STATEMENT) {
            shellCounter++;
        } else {
            shellCounter = next;
        }
        return true;
    }

    public void compile(String code) throws ParseException {
        stmts.clear();
        labels.clear();
        labelIndex = 0;
        shellCounter = 0;
        DShellParser parser = new DShellParser();
        Node node = parser.parse(code);
        processNode(node);
        stmts.add(new LabelShellSmt("<shellEnd>"));
        stmts.add(new EndShellSmt());
        for (int i = 0; i < stmts.size(); i++) {
            ShellSmt shellSmt = (ShellSmt) stmts.get(i);
            if (shellSmt instanceof LabelShellSmt) {
                labels.put(((LabelShellSmt) shellSmt).name, i);
            }
        }
    }

    private void compile(InputStream str) throws ParseException {
        try {
            stmts.clear();
            labels.clear();
            labelIndex = 0;
            DShellParser parser = new DShellParser();
            Node node = parser.parse(str);
            processNode(node);
            stmts.add(new LabelShellSmt("<shellEnd>"));
            stmts.add(new EndShellSmt());
            for (int i = 0; i < stmts.size(); i++) {
                ShellSmt shellSmt = (ShellSmt) stmts.get(i);
                if (shellSmt instanceof LabelShellSmt) {
                    labels.put(((LabelShellSmt) shellSmt).name, i);
                }
            }
        } finally {
            try {
                str.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }

    private void processNode(Node node) throws ParseException {
        if (node == null) {
            //do nothing
        } else if (node instanceof BinoOp) {
            BinoOp op = (BinoOp) node;
            String opstr = op.getOpString();
            if (";".equals(opstr)) {
                processNode(op.getLeft());
                processNode(op.getRight());
            } else if ("&&".equals(opstr)) {
                processNode(op.getLeft());
                String shellLabel = nextLabel();
                stmts.add(new TestShellSmt("@returnCode", 0, TestShellSmt.DIFF, shellLabel));
                processNode(op.getRight());
                stmts.add(new LabelShellSmt(shellLabel));
            } else if ("||".equals(opstr)) {
                processNode(op.getLeft());
                String shellLabel = nextLabel();
                stmts.add(new TestShellSmt("@returnCode", 0, TestShellSmt.EQ, shellLabel));
                processNode(op.getRight());
                stmts.add(new LabelShellSmt(shellLabel));
            } else {
                throw new IllegalArgumentException("Unsupported op " + opstr);
            }
        } else if (node instanceof CommandNode) {
            CommandNode cmd = (CommandNode) node;
            CommandNode cmd2 = new CommandNode();
            if (cmd.items.size() > 0) {
                CommandItemNode item = (CommandItemNode) cmd.items.get(0);
                Node inode = item.getNode();
                if (inode instanceof CommandNode) {
                    processNode(inode);
                    Token token = new Token();
                    token.image = "${returnString}";
                    cmd2.items.add(new CommandItemNode(new ItemNode(token)));
                } else if (inode instanceof ItemNode) {
                    ItemNode itemNode = (ItemNode) inode;
                    final String a = shell.getAlias(itemNode.getImage());
                    if (a == null) {
                        cmd2.items.add(new CommandItemNode(inode));
                    } else {
                        DShellParser parser = new DShellParser();
                        Node node0 = parser.parse(a);
                        if (node0 instanceof CommandNode) {
                            CommandNode cnode0 = (CommandNode) node0;
                            if (cmd.items.size() > 1 && cnode0.redirectItems.size() > 0) {
                                throw new IllegalArgumentException("Invalid alias " + itemNode.getImage() + " : redirection not supported in alias when alias is used with arguments");
                            }
                            if (cmd.items.size() > 1 && cnode0.usingItems.size() > 0) {
                                throw new IllegalArgumentException("Invalid alias " + itemNode.getImage() + " : using not supported in alias when alias is used with arguments");
                            }
                            if (cmd.items.size() > 1 && cnode0.nowait) {
                                throw new IllegalArgumentException("Invalid alias " + itemNode.getImage() + " : nowait not supported in alias when alias is used with arguments");
                            }
                            cmd2.items.addAll(0, cnode0.items);
                            cmd2.redirectItems.addAll(0, cnode0.redirectItems);
                            cmd2.usingItems.addAll(0, cnode0.usingItems);
                            cmd2.nowait = cmd.nowait;

                        } else {
                            throw new IllegalArgumentException("Invalid alias " + itemNode.getImage() + " : structures not supported in alias");
                        }
                    }
                } else {
                    cmd2.items.add(new CommandItemNode(inode));
                }
            }
            for (int i = 1; i < cmd.items.size(); i++) {
                CommandItemNode item = (CommandItemNode) cmd.items.get(i);
                Node inode = item.getNode();
                if (inode instanceof CommandNode) {
                    processNode(inode);
                    Token token = new Token();
                    token.image = "${returnString}";
                    cmd2.items.add(new CommandItemNode(new ItemNode(token)));
                } else {
                    cmd2.items.add(new CommandItemNode(inode));
                }
            }
            for (Iterator it = cmd.usingItems.iterator(); it.hasNext();) {
                CommandUsingItemNode item = (CommandUsingItemNode) it.next();
                cmd2.usingItems.add(item);
            }
            cmd2.nowait = cmd.nowait;
            for (int i = 0; i < cmd.redirectItems.size(); i++) {
                CommandRedirectItemNode item = (CommandRedirectItemNode) cmd.redirectItems.get(i);
                cmd2.redirectItems.add(item);
            }
            stmts.add(new RunCmdShellSmt(cmd2));
        } else if (node instanceof IfNode) {
            IfNode ifn = (IfNode) node;
            processNode(ifn.conditionNode);
            String shellLabel = nextLabel();
            stmts.add(new TestShellSmt("@returnCode", 0, TestShellSmt.DIFF, shellLabel));
            processNode(ifn.thenNode);
            stmts.add(new LabelShellSmt(shellLabel));
            if (ifn.elseNode != null) {
                processNode(ifn.elseNode);
            }
        } else if (node instanceof WhileNode) {
            WhileNode ifn = (WhileNode) node;
            String conditionLabel = nextLabel();
            String breakLabel = nextLabel();
            stmts.add(new LabelShellSmt(conditionLabel));
            processNode(ifn.conditionNode);
            stmts.add(new TestShellSmt("@returnCode", 0, TestShellSmt.DIFF, breakLabel));
            processNode(ifn.whileNode);
            stmts.add(new LabelShellSmt(breakLabel));
        } else {
            throw new IllegalArgumentException("Unsupported node " + node);
        }
    }

    public Integer getLabel(String name){
        return (Integer) labels.get(name);
    }

    private String nextLabel() {
        labelIndex++;
        return "<shellLabel" + labelIndex + ">";
    }

    public static CmdInfo validate2(CommandNode commandNode, DShell shell) throws ParseException {
        CmdInfo info = new CmdInfo();
        for (int index = commandNode.items.size() - 1; index >= 0; index--) {
            CommandItemNode item = (CommandItemNode) commandNode.items.get(index);
            String itemString = ((ItemNode) item.getNode()).getImage();
            itemString = shell.evalAsString(itemString);
            if (index == 0) {
                Set processedAliases = new HashSet();
                String alias = shell.aliases.get(itemString);
                while (alias != null) {
                    if (processedAliases.contains(alias)) {
                        break;
                    }
                    processedAliases.add(alias);
                    ShellInterpreter sh = new ShellInterpreter(shell,alias);
                    if (sh.stmts.size() != 3) {
                        throw new IllegalArgumentException("sh.stmts.size()!=1");
                    }
                    ShellSmt shellSmt = sh.stmts.get(0);
                    if (shellSmt instanceof RunCmdShellSmt) {
                        RunCmdShellSmt s = (RunCmdShellSmt) shellSmt;
                        for (int index2 = s.commandNode.items.size() - 1; index2 >= 0; index2--) {
                            CommandItemNode item2 = (CommandItemNode) s.commandNode.items.get(index2);
                            String itemString2 = ((ItemNode) item2.getNode()).getImage();
                            itemString2 = shell.evalAsString(itemString2);
                            if (index > 0) {
                                info.items.add(0, itemString2);
                            } else {
                                itemString = itemString2;
                                alias = (String) shell.aliases.get(itemString);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("shellSmt not instanceof RunCmdShellSmt");
                    }
                }
            }
            info.items.add(0, itemString);
        }
        for (int index = 0; index < commandNode.usingItems.size(); index++) {
            CommandUsingItemNode itemNode = (CommandUsingItemNode) commandNode.usingItems.get(index);
            info.usingKeys.add(shell.evalAsString(itemNode.getName().getImage()));
            info.usingValues.add(shell.evalAsString(itemNode.getValue().getImage()));
        }
        for (int index = 0; index < commandNode.redirectItems.size(); index++) {
            CommandRedirectItemNode itemNode = (CommandRedirectItemNode) commandNode.redirectItems.get(index);
            String red = itemNode.getRedirect().getImage();
            if ("&>".equals(red) || "&1>".equals(red)) {
                info.out = itemNode.getValue().getImage();
                info.outAppend = false;
            } else if ("&>>".equals(red) || "&1>>".equals(red)) {
                info.out = itemNode.getValue().getImage();
                info.outAppend = true;
            } else if ("&<".equals(red) || "&0<".equals(red)) {
                info.in = itemNode.getValue().getImage();
            } else if ("&2>".equals(red)) {
                info.err = itemNode.getValue().getImage();
                info.errAppend = false;
            } else if ("&2>>".equals(red)) {
                info.err = itemNode.getValue().getImage();
                info.errAppend = true;
            }
        }
        info.nowait = commandNode.nowait;
        return info;
    }

    public List<ShellSmt> getStmts() {
        return stmts;
    }

    public String getDump() {
        StringBuilder sb = new StringBuilder();
        for (ShellSmt stmt : stmts) {
            sb.append(stmt).append("\n");
        }
        return sb.toString();
    }
    //    public static DShellResourceCmd getResourceCommand(Class<? extends KResource> clazz, String name) {
//        Hashtable<String, DShellResourceCmd> cmds = DShellUtils.getResourcesCommands().get(clazz);
//        DShellResourceCmd shellCmd = (cmds == null) ? null : cmds.get(name);
//        if (shellCmd != null) {
//            return shellCmd;
//        } else {
//            Class<?> superclass = clazz.getSuperclass();
//            if (superclass != null) {
//                if (KResourceRemote.class.isAssignableFrom(superclass)) {
//                    shellCmd = getResourceCommand((Class<? extends KResource>) superclass, name);
//                    if (shellCmd != null) {
//                        return shellCmd;
//                    }
//                }
//            }
//            Class[] interfaces = clazz.getInterfaces();
//            for (int i = 0; i < interfaces.length; i++) {
//                Class anInterface = interfaces[i];
//                if (KResourceRemote.class.isAssignableFrom(anInterface)) {
//                    shellCmd = getResourceCommand((Class<? extends KResource>) anInterface, name);
//                    if (shellCmd != null) {
//                        return shellCmd;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public static DShellResourceCmd getResourceCommand(KResource r, String name) throws RemoteException {
//        return getResourceCommand(r.getClass(), name);
//    }
}
