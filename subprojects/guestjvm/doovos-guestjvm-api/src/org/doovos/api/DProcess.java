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
 * Doovos API is a standard library running on Doovos guest JVM (distributed
 * jvm) to access Doovos mechanisms that are not handled by the Java Platform
 * standard libraries.
 * Il gives access to system processes, system threads, etc...

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
package org.doovos.api;

import java.util.Map;
import java.util.Properties;

public class DProcess extends DResource {

    static {
        DSystem.loadLibrary("org.doovos.api.DProcessJNI");
    }
    private static DProcess process;
    private ThreadGroup threadGroup;
    private String cwd;
    private String commandLine;
    private String[] command;
    private String[] arguments;
    private Properties envs;
    private Properties metadata;
    private int pid;
    private int ppid;
    private String user;
    /**
     * will be populated in process.initialize
     */
    private String[] rawEnvs;
    private String[] rawMetadata;

    private native static DProcess getProcess0();

    public native static int[] getRootProcesses();
    public native static int[] getOwnProcesses();
    public native static int[] getAllProcesses();

    public native static DProcess getProcess(int pid);

    public native int[] getChildren();

    public native String[] getMemorySegments0();

    public native String getClassRepository0();

    public DMemorySegment[] getMemorySegments() {
        String[] x = getMemorySegments0();
        DMemorySegment[] all = new DMemorySegment[x.length];
        for (int i = 0; i < all.length; i++) {
            all[i] = new DMemorySegment(x[i]);
        }
        return all;
    }

    public DClassRepository getClassRepository() {
        return new DClassRepository(getClassRepository0());
    }

    public static DProcess getProcess() {
        if (process == null) {
            if (DSystem.isDoovosEnabled()) {
                process = getProcess0();
            } else {
                process = new DProcess("/runtime/processes/"+(int)((Math.random()*1000)));
            }
            //System.init();
        }
        return process;
    }

    private DProcess(String path) {
        super(path);
    }

//    public native void gc();
//
//    public native long maxMemorySize();
//
//    public native long freeMemorySize();

    public native String openFile();

    public ThreadGroup getThreadGroup() {
        return threadGroup;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String[] getCommand() {
        return command;
    }

    private Properties getEnvs0() {
        if (envs == null) {
            envs = new Properties();
            for (int i = 0; i < rawEnvs.length; i += 2) {
                envs.setProperty(rawEnvs[i], rawEnvs[i + 1]);
            }
        }
        return envs;
    }

    public Properties getEnvs() {
        return (Properties) getEnvs0().clone();
    }

    public String getEnv(String name) {
        return getEnvs0().getProperty(name);
    }

    public void setEnv(String name, String value) {
        Map<String, String> jvmEnvMap = null;
//        try {
//            //find jvm cache
//            Class _ProcessEnvironment_class = Class.forName("java.lang.ProcessEnvironment");
//            Field field = _ProcessEnvironment_class.getDeclaredField("theEnvironment");
//            field.setAccessible(true);
//            Object obj = field.get(null);//static field
//            jvmEnvMap = (Map<String, String>) obj;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        if (value == null || value.length() == 0) {
            getEnvs0().remove(name);
            if (jvmEnvMap != null) {
                jvmEnvMap.remove(name);
            }
        } else {
            getEnvs0().setProperty(name, value);
            if (jvmEnvMap != null) {
                jvmEnvMap.put(name, value);
            }
        }
        //setEnv0(name, value);
    }

    //public native void setEnv0(String name, String value);
    public String getCommandLine() {
        return commandLine;
    }

    public Properties getMetadata() {
        if (metadata == null) {
            metadata = new Properties();
            for (int i = 0; i < rawMetadata.length; i += 2) {
                metadata.setProperty(rawMetadata[i], rawMetadata[i + 1]);
            }
        }
        return metadata;
    }

    public int getPID() {
        return pid;
    }

    public int getParentPID() {
        return ppid;
    }

    public String getCwd() {
        return cwd;
    }

    public void setCwd(String cwd) {
        this.cwd = cwd;
        System.setProperty("user.dir", cwd);
        //setCwd0(cwd);
    }

    //public native void setCwd0(String cwd);
    public void setMetadata(String name, String value) {

        if (value == null) {
            getMetadata().remove(name);
        } else {
            getMetadata().setProperty(name, value);
        }
    }

    public String getMetadata(String name) {
        return getMetadata().getProperty(name);
    }

    public String getUser() {
        return user;
    }
}
