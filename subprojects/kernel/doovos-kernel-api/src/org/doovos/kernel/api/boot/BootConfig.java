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
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
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
package org.doovos.kernel.api.boot;

import org.doovos.kernel.api.Doovos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BootConfig {
    private String factoryClassName;
    private String bootClassName;
    private String[] bootClassArgs;
    private boolean rebuild = true;
    private Map<String, String> bootClassEnv;
    private Properties props = new Properties();
    private File bootFolder;

    public String getFactoryClassName() {
        rebuild();
        return factoryClassName;
    }

    public File getBootFolder() {
        rebuild();
        return bootFolder;
    }

    public String getBootClassName() {
        rebuild();
        return bootClassName;
    }

    public Map<String, String> getBootClassEnv() {
        rebuild();
        return bootClassEnv;
    }

    public String[] getBootClassArgs() {
        rebuild();
        return bootClassArgs;
    }

    private void rebuild() {
        if (rebuild) {
            rebuild = false;
            bootClassEnv = new HashMap<String, String>();
            factoryClassName = props.getProperty("factory.class.name");
            bootClassName = props.getProperty("boot.class.name");
            String args = props.getProperty("boot.class.args");
            ArrayList<String> argsList = new ArrayList<String>();
            if (args != null && args.length() > 0) {
                StreamTokenizer stok = new StreamTokenizer(new StringReader(args));
                stok.resetSyntax();
                stok.wordChars('a', 'z');
                stok.wordChars('A', 'Z');
                stok.wordChars(33, 255);
                stok.whitespaceChars(0, ' ');
                stok.quoteChar('"');
                stok.quoteChar('\'');
                try {
                    int t;
                    while ((t = stok.nextToken()) != StreamTokenizer.TT_EOF) {
                        switch (t) {
                            case StreamTokenizer.TT_WORD: {
                                argsList.add(stok.sval);
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bootClassArgs = argsList.toArray(new String[argsList.size()]);
            String envPrefix = "boot.env.";
            for (Map.Entry<Object, Object> e : props.entrySet()) {
                String k = (String) e.getKey();
                String v = (String) e.getValue();
                if (k.startsWith(envPrefix)) {
                    bootClassEnv.put(k.substring(envPrefix.length()), v);
                }
            }
            String bootFolderString = props.getProperty("boot.folder");
            if (bootFolderString == null || bootFolderString.trim().length() == 0) {
                bootFolderString = ".";
            }
            bootFolder = new File(bootFolderString);
        }
    }

    public Properties load(File file) {
        Properties a = new Properties();
        try {
            if (file.exists()) {
                System.out.println("loading boot file " + file.getCanonicalPath());
                Properties bootProperties = new Properties();
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(file);
                    bootProperties.load(fis);
                } finally {
                    if (fis != null) {
                        fis.close();
                    }
                }
                a.putAll(load(bootProperties, file.getParentFile()));
            }
        } catch (IOException e) {
            try {
                System.err.println("Unable to load boot file. Local Naive path is " + file.getCanonicalPath());
            } catch (IOException e1) {
                System.err.println("Unable to load boot file. Local Naive path is " + file.getAbsolutePath());
                //
            }
            e.printStackTrace();
        }
        return a;
    }

    public Properties load(Properties bootProperties, File currentFolder) {
        Properties a = new Properties();
        if (bootProperties != null && bootProperties.size() > 0) {
            if (bootProperties.contains("boot.config")) {
                String otherBootconfig = (String) bootProperties.remove("boot.config");
                File f = new File(otherBootconfig);
                if (!f.isAbsolute()) {
                    f = new File(currentFolder, otherBootconfig);
                }
                a.putAll(load(f));
            }
            a.putAll(bootProperties);
        }
        return a;
    }

    private static final String OS_BOOT_PROPS_FILE = "sys/cfg/boot.config";

    public void init(String[] args) {
        boolean foundConfig = false;
        boolean noConfig = false;
        String bootFolderString = null;
        ArrayList<String> args2 = new ArrayList<String>();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("-")) {
                if ("boot.no-config".equals(arg.substring(1))) {
                    noConfig = true;
                } else if ("boot.config".equals(arg.substring(1))) {
                    i++;
                    if (i >= args.length) {
                        throw new IllegalArgumentException("Expected option value for " + arg);
                    }
                    args2.add(arg);
                    args2.add(args[i]);
                    foundConfig = true;
                } else if ("boot.folder".equals(arg.substring(1))) {
                    i++;
                    if (i >= args.length) {
                        throw new IllegalArgumentException("Expected option value for " + arg);
                    }
                    args2.add(arg);
                    args2.add(args[i]);
                    bootFolderString = args[i];
                } else {
                    i++;
                    if (i >= args.length) {
                        throw new IllegalArgumentException("Expected option value for " + arg);
                    }
                    args2.add(arg);
                    args2.add(args[i]);
                }
            } else {
                throw new IllegalArgumentException("Unsupported option " + arg);
            }
        }

        if (bootFolderString == null || bootFolderString.trim().length() == 0) {
            bootFolderString = ".";
        }

        bootFolder = new File(bootFolderString);

        if (!foundConfig && !noConfig) {
            props.putAll(load(new File(bootFolder,OS_BOOT_PROPS_FILE)));
        }
        props.putAll(load(args2.toArray(new String[args2.size()]),new File(".")));
    }

    private Properties load(String[] args, File currentFolder) {
        Properties p = new Properties();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("-")) {
                i++;
                if (i >= args.length) {
                    throw new IllegalArgumentException("Expected option value for " + arg);
                }
                p.setProperty(arg.substring(1), args[i]);
            } else {
                throw new IllegalArgumentException("Unsupported option " + arg);
            }
        }
        p.putAll(load(p, currentFolder));
        return p;
    }

    public String getStringProperty(String name, String defaultValue, boolean update) {
        String property = props.getProperty(name);
        if (property == null) {
            if (update) {
                //setProperty(name, defaultValue);
            }
            return defaultValue;
        }
        return property;
    }

    public int getIntProperty(String name, int defaultValue, boolean update) {
        return Integer.valueOf(getStringProperty(name, String.valueOf(defaultValue), update));
    }

    public double getDoubleProperty(String name, double defaultValue, boolean update) {
        return Double.valueOf(getStringProperty(name, String.valueOf(defaultValue), update));
    }

    public boolean getBooleanProperty(String name, boolean defaultValue, boolean update) {
        return Boolean.valueOf(getStringProperty(name, String.valueOf(defaultValue), update));
    }

    public File getLocalTempFolder() {
        String s = getStringProperty("local.temp.folder", null, false);
        if (s != null) {
            File folder = new File(s);
            if (!folder.isAbsolute()) {
                folder = new File(getBootFolder(), s);
            }
            return folder;
        }
        try {
            return new File(getBootFolder(), "cache." + Doovos.getSystem().getName());
        } catch (Exception e) {
            return new File("cache.unknown");
        }
    }
}
