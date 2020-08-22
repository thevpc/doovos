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

import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.api.DThread;
import org.doovos.shell.DShell;
import org.doovos.shell.cmds.CmdSyntaxError;
import org.doovos.shell.cmds.DShellInternalCmd;
import org.doovos.shell.parser.CmdInfo;
import org.doovos.shell.parser.ParseException;
import org.doovos.shell.parser.nodes.CommandNode;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import org.doovos.shell.util.ProcessWatcher;
import org.doovos.shell.util.ProcessWatcherHandler;

public class RunCmdShellSmt implements ShellSmt {
    private static final String[] EMPTY_ARRAY_STRING = new String[0];

    CommandNode commandNode;

    public RunCmdShellSmt(CommandNode commandNode) {
        this.commandNode = commandNode;
    }

    public int run(DShell shell, ShellInterpreter interpreter) throws Exception {
        CmdInfo info = validate(shell);
        runCmd(shell, info);
        return DShell.NEXT_STATEMENT;
    }

    protected static void runCmd(DShell shell, CmdInfo info) throws Exception {
//        try {
        boolean verbose = shell.isVerbose();
        if (verbose) {
            System.out.println(info);
        }
        ArrayList newEnvs = new ArrayList();
        Properties oldEnvs = new Properties();
        Properties substitueEnvs = new Properties();
//            try {
        boolean _nowait = false;
        String _newterm = null;
        String _in = null;
        String _out = null;
        String _err = null;
        boolean outAppend = false;
        boolean errAppend = false;
        String cmd = (String) (info.items.size() > 0 ? info.items.get(0) : "");
        String[] cmds = (String[]) info.items.toArray(new String[info.items.size()]);
        String[] args;
        if (cmds.length > 0) {
            args = new String[cmds.length - 1];
            System.arraycopy(cmds, 1, args, 0, args.length);
        } else {
            args = EMPTY_ARRAY_STRING;
        }
        for (int i = 0; i < info.usingKeys.size(); i++) {
            String name = (String) info.usingKeys.get(i);
            String value = (String) info.usingValues.get(i);
            if (name.startsWith("@")) {
                if (name.equals(DShell.NO_WAIT)) {
                    _nowait = true;
                } else if (name.equals(DShell.NEW_TERM)) {
                    _newterm = value;
                } else if (name.equals(DShell.STDIN)) {
                    _in = value;
                } else if (name.equals(DShell.STDOUT)) {
                    _out = value;
                } else if (name.equals(DShell.STDERR)) {
                    _err = value;
                } else {
                    throw new CmdSyntaxError(null,null,null,"unknown meta-env " + name);
                }
            } else {
                substitueEnvs.put(name, value);
            }
        }
        if (info.out != null) {
            _out = info.out;
            outAppend = info.outAppend;
        }
        if (info.in != null) {
            _out = info.in;
        }
        if (info.err != null) {
            _out = info.err;
            errAppend = info.errAppend;
        }
        DShellInternalCmd shellCommand = (DShellInternalCmd) shell.internalCommands.get(cmd);
//                DShellResourceCmd resourceCommand = null;
//            KResource shellResource = null;
//            String newTermName = shellCommand == null ? null : shellCommand.getName();
        //            if (_newterm != null) {
//                KConstructor<KTerminal> constructorParams = new KConstructor<KTerminal>(KTerminal.class);
//                constructorParams.set(KTerminal.TITLE_PROPERTY, (_newterm == null || _newterm.length() == 0) ? newTermName : _newterm);
//                KTerminal t = Doovos.getLocalSite().getScreen().addTerminal(constructorParams);
//                substitueEnvs.put(DoovosConstants.ENV_SYSTEM_TERM, t.getPath());
//                substitueEnvs.put(DoovosConstants.ENV_SYSTEM_STDIN, t.getIn().getPath());
//                substitueEnvs.put(DoovosConstants.ENV_SYSTEM_STDOUT, t.getOut().getPath());
//            }
        boolean newout = false;
        boolean newin = false;
        boolean newerr = false;
        OutputStream out = null;
        InputStream in = null;
        OutputStream err = null;
//                if (_out != null) {
//                    out = DShellUtils.evalAsOutputStream(_out, process, new KFile.OutFlags().setAppend(outAppend));
//                    substitueEnvs.put(DoovosConstants.ENV_SYSTEM_STDOUT, out.getPath());
//                }
//                if (_in != null) {
//
//                    in = DShellUtils.evalAsInputStream(_in, process);
//                    substitueEnvs.put(DoovosConstants.ENV_SYSTEM_STDIN, in.getPath());
//                }
//                if (_err != null) {
//                    err = DShellUtils.evalAsOutputStream(_out, process, new KFile.OutFlags().setAppend(outAppend));
//                    substitueEnvs.put(DoovosConstants.ENV_SYSTEM_STDERR, err.getPath());
//                }
//                    ProcessInfoAdapter pia = new ProcessInfoAdapter(process, process.getInfoReference());
//                    for (Map.Entry<String, String> entry : substitueEnvs.entrySet()) {
//                        ProcessEnvAdapter old = pia.getEnv(entry.getKey());
//                        if (old != null) {
//                            oldEnvs.put(entry.getKey(), old.getValue().getValue());
//                        }
//                        old.setValue(new StringAdapter(process, entry.getValue()));
//                    }
        if (shellCommand != null) {
            shellCommand.exec(args, shell);
            //internal commands do not need whait child. did they?
            //if (!_nowait) {
            //    Doovos.currentThread().waitChild();
            //}
        } else if (cmd != null) {
            //recuperer le path complet avec une variable d'env de type PATH?
//                            DPath[] dPaths = DShellUtils.which(cmd, process, true);
//                            if (dPaths.length > 0) {
//                                List<DEnvInfo> substitueEnvsList=new ArrayList<DEnvInfo>(substitueEnvs.size());
//                                for (Map.Entry<String, String> stringStringEntry : substitueEnvs.entrySet()) {
//                                    substitueEnvsList.add(new DEnvInfo(stringStringEntry.getKey(),stringStringEntry.getValue(),true));
//                                }
//                                Doovos.exec(dPaths[0], cmds, substitueEnvsList.toArray(new DEnvInfo[substitueEnvsList.size()]));
//                            }
            String pkgEnv = null;
            try {
                if (DSystem.isDoovosEnabled()) {
                    pkgEnv = DProcess.getProcess().getEnv(DShell.ENV_EXEC_PACKAGES);
                } else {
                    pkgEnv = System.getenv(DShell.ENV_EXEC_PACKAGES);
                }
            } catch (Exception e) {
                //
            }
            String[] allPkgs = pkgEnv == null ? EMPTY_ARRAY_STRING : pkgEnv.split(":");
            String[] temp = new String[allPkgs.length + 1];
            temp[0] = "";
            System.arraycopy(allPkgs, 0, temp, 1, allPkgs.length);
            allPkgs = temp;
            String[] dPaths;
            if (DSystem.isDoovosEnabled()) {
                Properties dProcessEnvs = shell.getShellProperties();
                String path = dProcessEnvs.getProperty("PATH");
                String execExt = dProcessEnvs.getProperty("EXEC_EXT");
                String sexecPackages = dProcessEnvs.getProperty("EXEC_PKG");
                dPaths = DSystem.which(cmd, null, path, execExt, sexecPackages, true);
            } else {
                dPaths = new String[]{"org.doovos.usr." + cmd};
            }
            if (dPaths.length > 0) {
                String cmd0 = dPaths[0];
                if (cmd0.startsWith("/")) {
                    // this is a file
                    String[] cmdsOk = new String[cmds.length];
                    System.arraycopy(cmds, 1, cmdsOk, 1, cmds.length - 1);
                    cmdsOk[0] = cmd0;
                    Properties p = shell.getExportedProperties();
                    p.setProperty("CMD", cmd);
                    DSystem.shell(cmdsOk, p, null, null, null);
                    if (!_nowait) {
                        DThread.getThread().waitChild();
                    }

                } else {
                    if (DSystem.isDoovosEnabled()) {
                        Properties dProcessEnvs = shell.getExportedProperties();
                        long start = System.currentTimeMillis();
                        DSystem.exec(cmd0, args, dProcessEnvs, null, null, null);
                        if (!_nowait) {
                            DThread.getThread().waitChild();
                            long end = System.currentTimeMillis();
                            //System.out.println("time : " + (end - start));
                        }
                    } else {
                        String command = "java -classpath " + System.getProperty("java.class.path") + " " + cmd0 + " ";
                        for (String arg : args) {
                            command = command + " " + arg;
                        }
//                        System.out.println("Command=" + command);
                        long start = System.currentTimeMillis();
                        Process process = Runtime.getRuntime().exec(command);
                        class MyProcessWatcherHandler implements ProcessWatcherHandler {

                            public void started(Process process) {
                                System.out.println("started");
                            }

                            public void stdout(Process process, String line) {
                                System.out.println(line);
                            }

                            public void stderr(Process process, String line) {
                                System.err.println(line);
                            }

                            public void ended(Process process, int value) {
                            }

                            public void error(Process process, Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        MyProcessWatcherHandler watcherHandler = new MyProcessWatcherHandler();
                        ProcessWatcher w = new ProcessWatcher(process, watcherHandler);
                        w.start();
                        int i = w.waitfor();
                        //Method method = Class.forName(cmd0).getMethod("main", String[].class);
                        //method.invoke(null, new Object[]{args});
                        long end = System.currentTimeMillis();
                        //System.out.println("time : " + (end - start));
                    }
                    //this is a class
                }
            } else {
                //+ ("(DoovosEnabled=" + DSystem.isDoovosEnabled() + "," + shell.getExportedProperties() + " $$$$ " + System.getenv() + ")")
                throw new CmdSyntaxError(null,null,null,"Unknow command... : " + cmd);
            }
//                    } else if (resourceCommand != null) {
//                        resourceCommand.exec(cmds, shellResource, (KProcessRemote) process);
        } else {
            throw new CmdSyntaxError(null,null,null,"No command...");
        }
//                } finally {
//                if (out != null && newout) {
//                    try {
//                        out.free();
//                    } catch (Throwable e) {
//                        //
//                    }
//                }
//                if (in != null && newin) {
//                    try {
//                        in.free();
//                    } catch (Throwable e) {
//                        //
//                    }
//                }
//                if (err != null && newerr) {
//                    try {
//                        err.free();
//                    } catch (Throwable e) {
//                        //
//                    }
//                }
//                }

//            } finally {
//            ProcessInfoAdapter pia=new ProcessInfoAdapter(process,process.getInfoReference());
//            for (Map.Entry<String, String> e : oldEnvs.entrySet()) {
//                ProcessEnvAdapter old=pia.getEnv(e.getKey());
//                old.setValue(new StringAdapter(process,e.getValue()));
//            }
//            }

    }

    protected CmdInfo validate(DShell shell) throws ParseException {
        return ShellInterpreter.validate2(commandNode, shell);
    }

    @Override
    public String toString() {
        return commandNode.toString();
    }
}
