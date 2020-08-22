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

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;

import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 25 janv. 2009
 * Time: 16:48:00
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("org.doovos.api.DResource")
public class DResourceJNI {
    @JNICALL
    public String getName(JNIEnv env, @THIS KReference ref) throws RemoteException{
        KResource r = finResource(env, ref);
        if(r!=null){
            return r.getName();
        }
        return null;
    }

    @JNICALL
    public long getCreationTime(JNIEnv env, @THIS KReference ref) throws RemoteException{
        KResource r = finResource(env, ref);
        if(r!=null){
            return r.getCreationTime().getTime();
        }
        return 0;

    }

    @JNICALL
    public String getCreationSiteId(JNIEnv env, @THIS KReference ref) throws RemoteException{
        KResource r = finResource(env, ref);
        if(r!=null){
            return r.getCreationSiteId();
        }
        return null;

    }

    @JNICALL
    public String getCurrentSiteId(JNIEnv env, @THIS KReference ref) throws RemoteException{
        KResource r = finResource(env, ref);
        if(r!=null){
            return r.getCurrentSiteId();
        }
        return null;

    }

    /**
     * migrate resource the current resource to new localtion (Site named siteId)
     *
     * @param siteId
     * @
     */
    @JNICALL
    public void migrateTo(JNIEnv env, @THIS KReference ref,String siteId) throws RemoteException{
        KResource r = finResource(env, ref);
        r.migrateTo(siteId);
    }

    /**
     * true when migration is not allowed or has no meaning
     *
     * @return
     * @
     */
    @JNICALL
    public boolean isSticky(JNIEnv env, @THIS KReference ref) throws RemoteException{
        KResource r = finResource(env, ref);
        if(r!=null){
            return r.isSticky();
        }
        return false;
    }

    @JNICALL
    public boolean exists(JNIEnv env, @THIS KReference ref) throws RemoteException{
        KResource r = finResource(env, ref);
        return(r!=null);
    }

    private KResource finResource(JNIEnv env, @THIS KReference ref) throws RemoteException{
        SimpleClassAdapter a = new SimpleClassAdapter(env, ref);
        String s = a.getString("path");
        return Doovos.getSystem().getResourceLenient(s);
    }

//    @JNICALL
//    public static String openFileOutputStream(JNIEnv env, @JNIPARAM("java.lang.String") KReference filePath, boolean create, boolean append) throws IOException {
//        String stringChars = Doovos.getSystem().getMemoryManager().getString(filePath);
//        //TODO handle relative paths
//        KOutputStream outputStream = Doovos.getSystem().openOutputStream(env.getProcess(), stringChars, new KFile.OutFlags().setAppend(append).setCreate(create));
//        return outputStream.getPath();
//    }
//
//    @JNICALL
//    public static String openFileInputStream(JNIEnv env, @JNIPARAM("java.lang.String") KReference filePath) throws RemoteException, FileNotFoundException, IOException {
//        String stringChars = Doovos.getSystem().getMemoryManager().getString(filePath);
//        //TODO handle relative paths
//        KInputStream inputStream = Doovos.getSystem().openInputStream(stringChars);
//        return inputStream.getPath();
//
//    }
//
//    @JNICALL
//    public static boolean exists(JNIEnv env, @JNIPARAM("java.lang.String") KReference path) throws RemoteException {
//        String stringChars = Doovos.getSystem().getMemoryManager().getString(path);
//        //TODO handle relative paths
//        return Doovos.getSystem().getFileSystemManager().exists(stringChars);
//    }
}
