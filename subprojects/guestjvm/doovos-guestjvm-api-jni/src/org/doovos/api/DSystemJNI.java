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

 * Doovos API JNI is the native implementation (in Doovos sens so in java)
 * of Doovos API.
 * JNI code is executed on host JVM (in doovos kernel mode)
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
package org.doovos.api;

import java.util.Properties;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.adapter.DSiteAdapter;
import org.doovos.kernel.api.memory.adapter.DSiteArrayAdapter;
import org.doovos.kernel.api.memory.adapter.StringArrayAdapter;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import java.security.Principal;
import org.doovos.kernel.api.memory.adapter.DProcessAdapter;
import org.doovos.kernel.api.site.KParentProcessContext;
import org.doovos.kernel.api.site.KSiteEntry;

@JNICLASS("org.doovos.api.DSystem")
public class DSystemJNI {
    private static final KMemoryManager memoryManager = Doovos.getSystem().getMemoryManager();

    public DSystemJNI() {
    }

    
    @JNICALL
    public static void shutdown(JNIEnv env) throws RemoteException {
        Doovos.getSystem().shutdown(true);
    }

    @JNICALL(returnType = "java.lang.String[]")
    public static KReference which(JNIEnv env,
            String spath,
            String sworkingdir,
            String spathEnv,
            String execExtensions,
            String execPackages,
            boolean top1) throws RemoteException, Exception {
        KProcess p = env.getProcess();
        DProcessAdapter a=new DProcessAdapter(p, p.getGuestReference());
        if (spathEnv == null) {
            spathEnv=a.getEnv(env, DoovosConstants.ENV_PATH);
        }
        if (execExtensions == null) {
            execExtensions=a.getEnv(env, DoovosConstants.ENV_EXEC_EXTENSIONS);
        }
        if (execPackages == null) {
            execPackages=a.getEnv(env, DoovosConstants.ENV_EXEC_PACKAGES);
        }
        if (sworkingdir == null) {
            sworkingdir = env.getProcess().getCwd();
        }
        String[] dPaths = Doovos.getSystem().which(spath, sworkingdir, spathEnv, execExtensions, execPackages, top1);
        StringArrayAdapter s = new StringArrayAdapter(p, dPaths.length);
        for (int i = 0; i < dPaths.length; i++) {
            s.setItemRef(i, dPaths[i]);
        }
        return s.getReference();
    }

//    @JNICALL
//    public static int shell(JNIEnv env, @JNIPARAM("java.lang.String[]") KReference argsRef, @JNIPARAM("java.util.Properties") KReference envsRef, String login, char[] password, String workingDir) throws RemoteException, Exception {
//        KProcess process = env.getProcess();
//        String[] args = null;
//        if (!argsRef.isNull()) {
//            args = new StringArrayAdapter(process, argsRef).toJavaArray();
//        }
//        DProcessAdapter pa=new DProcessAdapter(process, process.getGuestReference());
//        final Properties envs = pa.getEnvs().toProperties(env);
//        KParentProcessContext ppc=new KParentProcessContext(process.getId(), envs, pa.getCwd().getValue(),pa.getLogin().getValue());
//        KProcess child = Doovos.getSystem().shell(ppc,args, envs, login == null ? null : Doovos.getSystem().getFactory().createCredentials(login, password), workingDir);
//        return child.getId();
//    }

    @JNICALL
    public static int exec(JNIEnv env, String path, @JNIPARAM("java.lang.String[]") KReference argsRef, @JNIPARAM("java.util.Properties") KReference envsRef, String login, char[] password, String workingDir) throws Exception,RemoteException {
        KProcess process = env.getProcess();
        String[] args = null;
        if (argsRef.isNotNull()) {
            args = new StringArrayAdapter(process, argsRef).toJavaArray();
        }
        DProcessAdapter pa=new DProcessAdapter(process, process.getGuestReference());
        final Properties envs = pa.getEnvs().toProperties(env);
        KParentProcessContext ppc=new KParentProcessContext(process.getId(), envs, pa.getCwd().getValue(),pa.getUser().getValue());
        KProcess child = Doovos.getSystem().exec(ppc,path, args, envs, login == null ? null : Doovos.getSystem().getFactory().createCredentials(login, password), workingDir);
        return child.getId();
    }

    @JNICALL
    public static void loadLibrary(JNIEnv env, @JNIPARAM("java.lang.String") KReference string) throws RemoteException {
        env.getProcess().loadNativeLibraryClass(memoryManager.getString(string));
    }

    @JNICALL(returnType = "org.doovos.api.DSite")
    public static KReference getLocalSite0(JNIEnv env) throws RemoteException {
        KSiteEntry site = Doovos.getSystem().getSiteManager().getLocalSite();
        DSiteAdapter a = new DSiteAdapter(env.getProcess(),
                site.getUUID(),
                site.getName(),
                site.getUrl(),
                site.isLocal(),
                site.isAlive());
        return a.getReference();
    }

    @JNICALL(returnType = "org.doovos.api.DSite[]")
    public static KReference getSites0(JNIEnv env) throws RemoteException {
        KProcess process = env.getProcess();
        KSiteEntry[] sites = Doovos.getSystem().getSiteManager().getSites();
        DSiteArrayAdapter sa = new DSiteArrayAdapter(process, sites.length);
        for (int i = 0; i < sites.length; i++) {
            KSiteEntry site = sites[i];
            sa.setSite(i,
                    new DSiteAdapter(env.getProcess(),
                    site.getUUID(),
                    site.getName(),
                    site.getUrl(),
                    site.isLocal(),
                    site.isAlive()));
        }
        return sa.getReference();
    }

    @JNICALL
    public static boolean login(JNIEnv env, String login, char[] password) {
        try {
            Principal principal =
                    Doovos.getSystem().getSecurityManager().login(Doovos.getSystem().getFactory().createCredentials(login, password));
            if (principal != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
