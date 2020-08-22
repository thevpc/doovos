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

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Doovos specific system utilities
 */
public class DSystem {

    private static DSite localSite;
    private static DSite[] cachedSites;
    private static boolean doovosEnabled;

    /**
     *
     * @return local site
     */
    public static DSite getLocalSite() {
        if (localSite == null) {
            localSite = getLocalSite0();
        }
        return localSite;
    }

    /**
     *
     * @return all sites (either accessible or cached)
     */
    public static DSite[] getSites() {
        if (cachedSites == null) {
            cachedSites = getSites0();
        }
        return cachedSites;
    }

    public native static void migrateCurrentThread(String siteName);

    /**
     * check for login password
     * @param login login
     * @param password password
     * @return true if a valid login or password
     */
    public native static boolean login(String login, char[] password) throws SecurityException;

    /**
     * launches a new application
     * @param program app path
     * @param args arguments
     * @param env env variables
     * @param login user to start as
     * @param password password (needed to exec a "run as" action)
     * @param workingDir process working dir
     * @return created process id
     */
    public static native int exec(String program, String[] args, Properties env, String login, char[] password, String workingDir);

    /**
     * create new instance of shell class and invoke method run() on it in the current process
     * @param args arguments to pass to the shell.run() method
     */
    public static void inline(String... args) {
        String shell = System.getenv("SHELL");
        if (shell == null) {
            throw new IllegalArgumentException("interpretShell required $SHELL variable");
        }
        try {
            Class<?> shellClass = Class.forName(shell);
            Object oshell = shellClass.newInstance();
            Method shellRunMethod = shellClass.getMethod("run", String[].class);
            shellRunMethod.invoke(oshell, new Object[]{args});
        } catch (Exception e) {
            throw new IllegalArgumentException("shell not found " + shell);
        }
    }

    /**
     * launches a new instance of the shell
     * @param args arguments
     * @param env env variables
     * @param login user to start as
     * @param password password (needed to exec a "run as" action)
     * @param workingDir process working dir
     * @return return created process id
     */
    public static int shell(String[] args, Properties env, String login, char[] password, String workingDir) {
        String shell = System.getenv("SHELL");
        if (shell == null) {
            throw new IllegalArgumentException("interpretShell required $SHELL variable");
        }
        return exec(shell, args, env, login, password, workingDir);
    }

    /**
     * Loads a class into host jvm as JNI implementation
     * JNI implementation class must be @JNICLASS annotated
     * JNI method implementations must be @JNICALL annotated
     * static JNI method implementations must start with "JNIEnv env" param
     * instance JNI method implementations must :
     *       be named with exactly the same name as the reference native method or must specify name in JNICALL annotation
     *       start with "JNIEnv env,@THIS KReference instance" params
     *       contain the exact parameter types sequence as the reference native method
     *       primitive types and String types are resolved automatically
     *       all other non primitive types must be passed as KReference with @JNIPARAM annotation
     * @param doovosJNIClassName class to load in host jvm as JNI implementation
     */
    public native static void loadLibrary(String doovosJNIClassName);

    /**
     * shutdown doovos site instance. Doovos OS will shut down if all sites are down
     */
    public native static void shutdown();

    /**
     * search executable application and return all applicable path
     * @param path application name or partial path
     * @param workingDir working directory to consider
     * @param pathEnv PATH environment value
     * @param execExtensionEnv EXEC_PATH environment value
     * @param execPackagesEnv PKG_PATH environment value
     * @param retrieveOnlyFirst if true, only first will be returned
     * @return
     */
    public native static String[] which(String path, String workingDir, String pathEnv, String execExtensionEnv, String execPackagesEnv, boolean retrieveOnlyFirst);

    /**
     * true if running on Doovos guest jvm
     * @return true if "Doovos".equals(System.getProperty("os.name"))
     */
    public static boolean isDoovosEnabled() {
        return doovosEnabled;
    }

    private native static DSite getLocalSite0();

    private native static DSite[] getSites0();
}
