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
package org.doovos.shell;

import org.doovos.api.DProcess;
import org.doovos.api.DSystem;
import org.doovos.shell.cmds.*;
import org.doovos.shell.interpreter.ShellInterpreter;
import org.doovos.shell.interpreter.QuitShellException;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

public class DShell {

    public static final int NEXT_STATEMENT = -2;
    public static final String NO_WAIT = "@nowait";
    public static final String NEW_TERM = "@newterm";
    public static final String STDOUT = "@out";
    public static final String STDIN = "@in";
    public static final String STDERR = "@err";
    public static final String ENV_PATH = "PATH";
    public static final String ENV_EXEC_PACKAGES = "EXEC_PKG";
    public static final String ENV_EXEC_EXTENSIONS = "EXEC_EXT";

    static {
        if (DSystem.isDoovosEnabled()) {
            DProcess pp = DProcess.getProcess();
            String title = pp.getMetadata("title");
            if (title == null) {
                pp.setMetadata("title", "DShell");
                pp.setMetadata("version", "0.2");
                pp.setMetadata("author", "Taha BEN SALAH");
                pp.setMetadata("date", "2010-12-08");
                pp.setMetadata("history.1", "2009-04-12 : created");
                pp.setMetadata("history.2", "2010-12-08 : update");
            }
        }
    }
    public String[] args;
    public boolean exitAfterProcessingLines = false;
    public String input = null;
    public String lastError = null;
    public boolean fallBackToMain = false;
    public boolean verbose = false;
    public String oldCommandLine = null;
    public int commandLineIndex = -1;
//    public String promptAttribute = "192, 192, 255";
//    public String commentAttribute = "196, 240, 196";
//    public String commandsAttribute = "192, 192, 255";
//    public String errorAttribute = "255, 128, 128";
//    public String stackAttribute = "255, 128, 128";
//    public String nameAttribute = "224, 224, 160";
//    public String headerAttribute = "224, 224, 160";
//    public String propertiesAttribute = "255, 255, 0";
    public Object shellInterpreter = null;
    public Map<String, String> aliases = new HashMap<String, String>();
    public Map internalCommands = new HashMap();
    private Properties startupEnvs;
    private String startupScript;
    private String shutdownScript;

    public static void main(String[] args) {
        DShell shell = new DShell();
        shell.run(args);
    }

    public DShell() {
    }

    public int run(String[] args) {
        try {
            startupEnvs = new Properties();
            startupEnvs.putAll(DSystem.isDoovosEnabled() ? DProcess.getProcess().getEnvs() : System.getenv());
            this.args = args;
//            int type = 0;
//            int ret = 0;
            PrintStream out = System.out;
            PrintStream err = System.err;
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                if ("-?".equals(arg)) {
                    out.println("Syntaxe : shell [<FILE>]");
                    out.println("    <FILE> : if present content will be processed as input");
                    return 0;
                } else if ("--version".equals(arg)) {
                    if (DSystem.isDoovosEnabled()) {
                        out.println(DProcess.getProcess().getMetadata("version"));
                    } else {
                        out.println("v0.1");
                    }
                } else if ("--verbose".equals(arg)) {
                    verbose = true;
                } else if ("--startup-script".equals(arg)) {
                    i++;
                    startupScript = args[i];
                } else if ("--shutdown-script".equals(arg)) {
                    i++;
                    shutdownScript = args[i];
                } else if (arg.startsWith("-")) {
                    err.println("Syntax error");
                    //return -1;
                    return -1;
                } else {
                    input = arg;
                    exitAfterProcessingLines = true;
                }
            }

            if (DSystem.isDoovosEnabled()) {
                DProcess pp = DProcess.getProcess();
                if (input == null) {
                    System.out.println(pp.getMetadata("title") + " version " + pp.getMetadata("version"));
                }
            }
            declareDefaulsCmds();
            declareDefaulsAliases();

            executeFile(startupScript, true);

            if (input != null) {
                if (!new File(input).exists()) {
                    return -1;
                }
            }

            if (input == null) {
                String line;
                ShellInterpreter sh = new ShellInterpreter(this);
                BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (true) {
                        try {
                            System.out.print(getPrompt());
                            //process.getStdout().write(getPrompt((KProcessRemote) process), DShellUtils.getPromptAttrib());
                            try {
                                line = s.readLine();
                            } catch (NoSuchElementException e) {
                                return -2;
                            }
                            sh.execute(line, this);
                        } catch (QuitShellException e) {
                            return 0;
                        } catch (Exception e) {
                            System.err.println("Shell Error in interactive mode : " + e);
                            //e.printStackTrace();
                        }
                    }
                } finally {
                    executeFile(shutdownScript, true);
                }

                //return 0;
            } else {
                int c = executeFile(input, false);
                executeFile(shutdownScript, true);
                return c;
            }
        } catch (Throwable e) {
            System.err.println("Fata Error, quitting shell : " + e);
            e.printStackTrace();
            return -1;
        }
    }

    public int executeFile(String file, boolean ignoreIfNotFound) {
        if (file == null || !new File(file).exists()) {
            return -1;
        }
        try {
            ShellInterpreter sh = new ShellInterpreter(this, new FileInputStream(file));
            sh.execute(this);
            return 0;
        } catch (QuitShellException e) {
            return 0;
        } catch (Exception e) {
            System.err.println("Shell Error in non interactive mode : " + e);
            //e.printStackTrace();
            return -1;
        }
    }

    public String getPrompt() {
        if (DSystem.isDoovosEnabled()) {
            String promptValue = getEnv("PROMPT");
            if (promptValue == null) {
                promptValue = "{%p} %u@%S:%W>";
            }
            char[] promptChars = promptValue.toCharArray();
            StringBuilder s = new StringBuilder();
            DProcess p = DProcess.getProcess();
            for (int i = 0; i < promptChars.length; i++) {
                char c = promptChars[i];
                if (c == '%' && i < (promptChars.length - 1)) {
                    i++;
                    c = promptChars[i];
                    switch (c) {
                        case 'p': {
                            s.append(p.getPID());
                            break;
                        }
                        case 'W': {
                            s.append(p.getCwd());
                            break;
                        }
                        case 'u': {
                            s.append(p.getUser());
                            break;
                        }
                        case 'S': {
                            s.append(DSystem.getLocalSite().getName());
                            break;
                        }
                        default: {
                            s.append('%').append(c);
                            break;
                        }
                    }
                } else {
                    s.append(c);
                }
            }
            return s.toString();
        } else {
            return System.getProperty("user.dir") + ">";
        }
    }

    public void declareDefaulsCmds() {
        declareCmd(new CdCmd());
        declareCmd(new RunCmd());
        declareCmd(new ShowerrCmd());
        declareCmd(new AliasCmd());
        declareCmd(new UnaliasCmd());
        declareCmd(new QuitCmd());
        declareCmd(new SetCmd());
        declareCmd(new UnsetCmd());
        declareCmd(new ExportCmd());
        declareCmd(new UnexportCmd());
        declareCmd(new EnvCmd());
        declareCmd(new SetPropCmd());

        //declareCmd(new DescCmd());
        //declareCmd(new CacheCmd());
        //declareCmd(new MigrateCmd());
        //declareCmd(new PstreeCmd());
        //declareCmd(new ClearCmd());
        //declareCmd(new PromptCmd());
        //declareCmd(new UmountCmd());
        //declareCmd(new MountCmd());
        //declareCmd(new ExecCmd());
        //declareCmd(new ChronoCmd());
        //declareCmd(new DecompileCmd());
        //declareCmd(new HelpCmd());
        //declareResourceCmd(new DFileCat());
        //declareResourceCmd(new DScreenAdd());
    }

    public void declareDefaulsAliases() {
        aliases.put("ll", "ls");
        aliases.put("dir", "ls");
        aliases.put("whatis", "man");
        aliases.put("help", "man");
        aliases.put("?", "man");
        aliases.put("cls", "clear");
        aliases.put("exit", "quit");
        aliases.put("print", "echo");
    }

    public Set<String> getAliases() {
        return aliases.keySet();
    }

    public void setAlias(String key, String value) {
        if (value == null) {
            aliases.remove(key);
        } else {
            aliases.put(key, value);
        }
    }

    public String getAlias(String name) {
        return aliases.get(name);
    }

    public void declareCmd(DShellInternalCmd shellInternalCmd) {
        internalCommands.put(shellInternalCmd.getName(), shellInternalCmd);
    }
    private Properties shellEnvs = new Properties();
    private Set<String> exportedEnvs = new HashSet<String>();
    private Set<String> removedEnvs = new HashSet<String>();

    public Properties getExportedProperties() {
        Properties processEnvs = startupEnvs;
        Properties e = new Properties();
        e.putAll(processEnvs);
        for (String k : exportedEnvs) {
            if (removedEnvs.contains(k)) {
                e.remove(k);
            } else {
                e.setProperty(k, shellEnvs.getProperty(k));
            }
        }
        return e;
    }

    public String getEnv(String name) {
        return getShellProperties().getProperty(name);
    }

    public Properties getShellProperties() {
        Properties processEnvs = startupEnvs;
        Properties e = new Properties();
        for (String p : processEnvs.stringPropertyNames()) {
            if (!removedEnvs.contains(p)) {
                e.setProperty(p, processEnvs.getProperty(p));
            }
        }
        e.putAll(shellEnvs);
        return e;
    }

    public void setEnv(String var, String value) {
        if (value != null && value.length() == 0) {
            value = null;
        }
        if (value == null) {
            exportedEnvs.add(var);
            removedEnvs.add(var);
            shellEnvs.remove(var);
        } else {
            removedEnvs.remove(var);
            shellEnvs.setProperty(var, value);
        }
    }

    public void export(String var) {
        if (shellEnvs.containsKey(var)) {
            exportedEnvs.add(var);
            DProcess.getProcess().setEnv(var, getShellProperties().getProperty(var));
        } else {
            throw new NoSuchElementException("Env var " + var + " not found");
        }
    }

    public void unexport(String var) {
        if (shellEnvs.containsKey(var)) {
            exportedEnvs.remove(var);
        } else {
            throw new NoSuchElementException("Env var " + var + " not found");
        }
    }

    public boolean isExported(String var) {
        return exportedEnvs.contains(var);
    }

    public String evalAsString(String param) {
        Properties envs = new Properties();
        if (DSystem.isDoovosEnabled()) {
            Properties processEnvs = getShellProperties();
            for (Entry<Object, Object> entry : processEnvs.entrySet()) {
                envs.put(entry.getKey(), entry.getValue());
            }
        } else {
            envs.putAll(System.getenv());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            char c = param.charAt(i);
            if (c == '$') {
                StringBuilder var = new StringBuilder();
                i++;
                if (i < param.length()) {
                    if (param.charAt(i) != '{') {
                        while (i < param.length()
                                && ((param.charAt(i) >= 'a' && param.charAt(i) <= 'z')
                                || (param.charAt(i) >= 'A' && param.charAt(i) <= 'Z')
                                || (param.charAt(i) >= 'O' && param.charAt(i) <= '9')
                                || (param.charAt(i) == '_'))) {
                            var.append(param.charAt(i++));
                        }
                        i--;
                    } else {
                        i++;//ignore '{'
                        while (i < param.length() && (param.charAt(i) != '}')) {
                            var.append(param.charAt(i++));
                        }
                    }
                } else {
                    var.append('$');
                }
                Object obj = envs.get(var.toString());
                sb.append(obj == null ? "" : String.valueOf(obj));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean isVerbose() {
        return verbose;
    }

    public String getLastError() {
        return lastError;
    }
}
