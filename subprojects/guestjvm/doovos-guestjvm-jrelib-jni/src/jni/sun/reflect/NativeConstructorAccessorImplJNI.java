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
 * Doovos JAVA JNI is the native implementation (in Doovos sens so in java)
 * of the hotspot java libraries (provided by sun).
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
package jni.sun.reflect;

import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.memory.adapter.RefArrayAdapter;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 26 avr. 2009
 * Time: 20:56:36
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("sun.reflect.NativeConstructorAccessorImpl")
public class NativeConstructorAccessorImplJNI {
    private static final KReference[] EMPTY_ARRAY_KREFERENCE = new KReference[0];

    //newInstance0(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)
    //Constructor constructor, Object aobj[]
    @JNICALL(returnType = "java.lang.Object")
    public static /*Object*/ KReference newInstance0(JNIEnv env, @JNIPARAM("java.lang.reflect.Constructor") KReference constructor, @JNIPARAM("java.lang.Object[]") KReference aobj) throws RemoteException {
        SimpleClassAdapter constr = new SimpleClassAdapter(env, constructor);
        SimpleClassAdapter clazz = constr.getObject("clazz");
        RefArrayAdapter parameterTypes = constr.getRefArray("parameterTypes");
        String[] types = parameterTypes.toStringArray();
        KReference[] params = null;
        if (aobj.isNull()) {
            params = EMPTY_ARRAY_KREFERENCE;
        } else {
            RefArrayAdapter aobjArr = new RefArrayAdapter(env.getProcess(), aobj);
            params = aobjArr.toArray();
        }
        return env.newInstance(env.getClassRepository().getClassByGuestReference(clazz.getReference()).getName(), types, params);
    }
}
