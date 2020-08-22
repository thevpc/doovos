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

import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KBoolean;
import org.doovos.kernel.api.memory.KByte;
import org.doovos.kernel.api.memory.KChar;
import org.doovos.kernel.api.memory.KDouble;
import org.doovos.kernel.api.memory.KFloat;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KLong;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KShort;
import org.doovos.kernel.api.memory.adapter.RefArrayAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 26 avr. 2009
 * Time: 20:56:36
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("sun.reflect.NativeMethodAccessorImpl")
public class NativeMethodAccessorImplJNI {
    private static final KMemoryManager memoryManager = Doovos.getSystem().getMemoryManager();

    //newInstance0(Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)
    //Constructor constructor, Object aobj[]
    @JNICALL(returnType = "java.lang.Object")
    public static /*Object*/ KReference invoke0(JNIEnv env, @JNIPARAM("java.lang.reflect.Method") KReference method, @JNIPARAM("java.lang.Object") KReference instance, @JNIPARAM("java.lang.Object[]") KReference aobj) throws RemoteException, Exception {
        SimpleClassAdapter methodInst = new SimpleClassAdapter(env, method);
        KReference clazz = methodInst.getReference("clazz");
        KReference returnType = methodInst.getReference("returnType");
        KReference[] parameterTypes = methodInst.getRefArray("parameterTypes").toArray();
        KMemoryManager m = memoryManager;
        String clazzName = m.getString((KReference) env.invokeObjectMethod("java.lang.Class", "getName()Ljava/lang/String;", clazz));

        StringBuilder s = new StringBuilder();
        s.append(m.getString((KReference) env.invokeObjectMethod("java.lang.reflect.Method", "getName()Ljava/lang/String;", method)));
        s.append("(");
        for (KReference paramType : parameterTypes) {
            String t = m.getString((KReference) env.invokeObjectMethod("java.lang.Class", "getName()Ljava/lang/String;", paramType));
            s.append(KClass.javaGetNameToJavaClassFormat(t));
        }
        s.append(")");
        s.append(KClass.javaGetNameToJavaClassFormat(m.getString((KReference) env.invokeObjectMethod("java.lang.Class", "getName()Ljava/lang/String;", returnType))));
        KRegister rr = env.invokeObjectMethod(clazzName, s.toString(), instance, new RefArrayAdapter(env.getProcess(), aobj).toArray());
        if (rr instanceof KReference) {
            return (KReference) rr;
        } else {
            //should handle autoboxing
            if(rr instanceof KInteger){
                return env.newInstance("java.lang.Integer", new String[]{"int"},rr);
            }else if(rr instanceof KLong){
                return env.newInstance("java.lang.Long", new String[]{"long"},rr);
            }else if(rr instanceof KShort){
                return env.newInstance("java.lang.Short", new String[]{"short"},rr);
            }else if(rr instanceof KBoolean){
                return env.newInstance("java.lang.Boolean", new String[]{"boolean"},rr);
            }else if(rr instanceof KDouble){
                return env.newInstance("java.lang.Double", new String[]{"double"},rr);
            }else if(rr instanceof KByte){
                return env.newInstance("java.lang.Byte", new String[]{"byte"},rr);
            }else if(rr instanceof KChar){
                return env.newInstance("java.lang.Char", new String[]{"char"},rr);
            }else if(rr instanceof KFloat){
                return env.newInstance("java.lang.Float", new String[]{"float"},rr);
            }
            return (KReference) rr;

        }
    }
}
