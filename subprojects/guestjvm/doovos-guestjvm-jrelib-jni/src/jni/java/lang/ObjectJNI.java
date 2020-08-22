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
package jni.java.lang;

import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;

import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KBoolean;

@JNICLASS("java.lang.Object")
public class ObjectJNI {

    @JNICALL
    public static void registerNatives(JNIEnv env) throws Exception {
        KProcess process = env.getProcess();
        process.loadNativeLibraryClass("jni.java.lang.SystemJNI");
        process.loadNativeLibraryClass("jni.java.lang.ThreadJNI");
        process.loadNativeLibraryClass("jni.java.lang.ClassJNI");
        process.loadNativeLibraryClass("jni.java.lang.ClassLoaderJNI");
        process.loadNativeLibraryClass("jni.java.security.AccessControllerJNI");
        process.loadNativeLibraryClass("jni.java.io.ObjectStreamClassJNI");
        process.loadNativeLibraryClass("jni.java.io.FileInputStreamJNI");
        process.loadNativeLibraryClass("jni.java.io.FileDescriptorJNI");
        process.loadNativeLibraryClass("jni.java.io.FileOutputStreamJNI");
        process.loadNativeLibraryClass("jni.sun.misc.UnsafeJNI");
        process.loadNativeLibraryClass("jni.java.lang.StringJNI");
        process.loadNativeLibraryClass("jni.sun.reflect.ReflectionJNI");
        process.loadNativeLibraryClass("jni.sun.reflect.AtomicLongJNI");
        process.loadNativeLibraryClass("jni.java.util.concurrent.atomic.AtomicLongJNI");
        process.loadNativeLibraryClass("jni.java.lang.ThrowableJNI");
        process.loadNativeLibraryClass("jni.sun.reflect.NativeConstructorAccessorImplJNI");
        process.loadNativeLibraryClass("jni.sun.reflect.NativeMethodAccessorImplJNI");
        process.loadNativeLibraryClass("jni.sun.misc.VMJNI");
        process.loadNativeLibraryClass("jni.java.io.FileSystemJNI");
        process.loadNativeLibraryClass("jni.java.io.UnixFileSystemJNI");
        process.loadNativeLibraryClass("jni.java.lang.ClassLoader_NativeLibraryJNI");
        process.loadNativeLibraryClass("jni.sun.misc.SignalJNI");
        process.loadNativeLibraryClass("jni.sun.misc.NativeSignalHandlerJNI");
        process.loadNativeLibraryClass("jni.java.lang.FloatJNI");
        process.loadNativeLibraryClass("jni.java.lang.DoubleJNI");
        process.loadNativeLibraryClass("jni.java.lang.StrictMathJNI");
        process.loadNativeLibraryClass("jni.java.lang.reflect.ArrayJNI");
        process.loadNativeLibraryClass("jni.java.lang.ProcessEnvironmentJNI");
        process.loadNativeLibraryClass("org.doovos.api.DResourceJNI");

        //for optimization
        process.loadNativeLibraryClass("jniperf.java.lang.AbstractStringBuilderJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.lang.StringBuilderJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.lang.StringBufferJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.lang.CharacterJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.lang.DoubleJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.lang.MathJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.lang.StringJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.lang.IntegerJNIPerf");
        process.loadNativeLibraryClass("jniperf.java.io.UnixFileSystemJNIPerf");

        env.getClassRepository().getClassByName("org.doovos.api.DSystem").getField("doovosEnabled", false).setStaticValue(KBoolean.TRUE);

        KClass systemClass = process.getClassRepository().getClassByName("java.lang.System");
        KMethod initializeSystemClass_method = systemClass.getMethodBySignature("initializeSystemClass()V");
        env.invokeStaticMethod(initializeSystemClass_method, KRegister.EMPTY_ARRAY);

    }
    private final KMemoryManager memoryManager;

    public ObjectJNI() {
        memoryManager = Doovos.getSystem().getMemoryManager();
    }

    @JNICALL
    public java.lang.String toString(JNIEnv env, @THIS KReference ref) throws RemoteException {
        //return Doovos.getSystem().getMemoryManager().getClass(ref).getEncodedName();
        return memoryManager.getKClass(ref).getEncodedName();
    }

    @JNICALL(returnType = "java.lang.Object")
    public KReference clone(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KMemoryManager mem = memoryManager;
        KMemorySegment mem0 = env.getMemorySegment();
//        KProcess process = env.getProcess();
//        KMemorySegment seg = process.getMemorySegment();
//        KClassRepository clsrepo = process.getClassRepository();
        KClass kClass = mem.getKClass(ref);
        if (kClass.isArray()) {
            int len = mem.getArraySize(ref);
            KReference clonedArray = mem0.allocArray(kClass.getArrayComponent(), len);
            mem.arraycopy(ref, 0, clonedArray, 0, len);
            return clonedArray;
        }
        KReference newInstance = mem0.allocObject(kClass);
        KClassDef d = kClass.getDefinition();
//        KObject object = Doovos.getSystem().getMemoryManager().getObject(ref);
//        KObject object2=object.copy();

        while (d != null) {
            int max = d.getFieldsCount();
            for (int i = 0; i < max; i++) {
                KFieldDef field = d.getField(i);
                KField field1 = kClass.getField(field.getName(), false);
                if (!Modifier.isStatic(field.getModifiers())) {
                    KRegister r = field1.getInstanceValue(ref);
                    field1.setInstanceValue(newInstance, r);
                }
            }
            d = d.getSuperClass();
            if (d != null) {
                kClass = env.getClassRepository().getClassByName(d.getName());
            }
        }
        return newInstance;
    }

    @JNICALL
    public int hashCode(JNIEnv env, @THIS KReference ref) throws RemoteException {
        return ref.hashCode();
    }

    @JNICALL
    public final void notify(JNIEnv env, @THIS KReference ref) {
    }

    @JNICALL
    public final void notifyAll(JNIEnv env, @THIS KReference ref) {
    }

    @JNICALL
    public final void wait(JNIEnv env, @THIS KReference ref, long timeout) {
    }

    @JNICALL
    public void finalize(JNIEnv env, @THIS KReference ref) {
    }

    @JNICALL(returnType = "java.lang.Class")
    public KReference getClass(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KClass kClass = memoryManager.getKClass(ref);
        //KClass kClass = Doovos.getSystem().getMemoryManager().getClass(ref);
        return kClass.getGuestReference();
    }
}
