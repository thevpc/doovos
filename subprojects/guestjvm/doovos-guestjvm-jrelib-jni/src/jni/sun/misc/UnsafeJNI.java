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
package jni.sun.misc;

import org.doovos.kernel.api.KFactory;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.memory.KMemoryUtilities;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KMemorySegment;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Comparator;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;
import org.doovos.kernel.api.process.KThread;
import org.doovos.kernel.api.process.KLocalThread;

@JNICLASS("sun.misc.Unsafe")
public class UnsafeJNI {

    private static final Doovos SYSTEM = Doovos.getSystem();
    private static final KFactory FACTORY = SYSTEM.getFactory();

    private static class Alloc implements Comparable<Alloc> {

        long offset;
        long size;

        private Alloc(long offset, long size) {
            this.offset = offset;
            this.size = size;
        }

        public long resolveIndex(long pointer) {
            return pointer - offset;
        }

        public int compareTo(Alloc o) {
            return (int) (offset - o.offset);
        }

        public boolean contains(Alloc o) {
            return o.offset >= offset && o.size < (size - (o.offset - offset));
        }
    }
    private Alloc[] allocated = new Alloc[0];

    @JNICALL
    public void ensureClassInitialized(JNIEnv env,@THIS KReference ref, @JNIPARAM("java.lang.Class") KReference clazzRef) throws Exception {
        final KClass clz = env.getClassRepository().getClassByGuestReference(clazzRef);
        env.invokeClassInitializer(clz);
    }
    
    @JNICALL
    public static void registerNatives(JNIEnv env) {
    }

    @JNICALL
    public void park(JNIEnv env, @THIS KReference ref, boolean absolute, long time) throws RemoteException {
        KLocalThread t = env.getThread();
        if (time == 0) {
            t.addDependency(FACTORY.createParkLock(t));
        } else if (absolute) {
            t.addDependency(FACTORY.createAbsoluteTimeLock(t, time));
        } else {
            t.addDependency(FACTORY.createRelativeTimeLock(t, time));
        }
    }

    @JNICALL
    public void unpark(JNIEnv env, @THIS KReference ref,@JNIPARAM("java.lang.Object") KReference threadReference) throws RemoteException {
        KLocalThread t0 = env.getThread();
        KThread t = resolveKThread(env, threadReference);
        t.removeDependency(FACTORY.createParkLock(t0));
    }

    private static KThread resolveKThread(JNIEnv env, @THIS KReference ref) throws RemoteException {
        if (ref.isNull()) {
            return null;
        }
        for (KThread o : env.getProcess().getThreads()) {
            KReference r = o.getJVMReference();
            if (r != null && r.equals(ref)) {
                return o;
            }
        }
        throw new IllegalArgumentException("????????");
    }


    @JNICALL
    public boolean compareAndSwapObject(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.Object") KReference o, long a, @JNIPARAM("java.lang.Object") KReference b, @JNIPARAM("java.lang.Object") KReference c) throws RemoteException {
        KMemorySegment s = SYSTEM.getMemorySegment(o.segment);
        int ai = (int) a;
        KReference v = s.getFieldReference(o.pointer, ai);
        if (v.equals(b)) {
            s.setFieldReference(o.pointer, ai, c);
            return true;
        } else {
            return false;
        }
    }

    @JNICALL
    public boolean compareAndSwapLong(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.Object") KReference o, long a, long b, long c) throws RemoteException {
        KMemorySegment s = SYSTEM.getMemorySegment(o.segment);
        int ai = (int) a;
        long v = s.getFieldLong(o.pointer, ai);
        if (v == b) {
            s.setFieldLong(o.pointer, ai, c);
            return true;
        } else {
            return false;
        }
    }

    @JNICALL
    public boolean compareAndSwapInt(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.Object") KReference o, long a, int b, int c) throws RemoteException {
        KMemorySegment s = SYSTEM.getMemorySegment(o.segment);
        int ai = (int) a;
        long v = s.getFieldInt(o.pointer, ai);
        if (v == b) {
            s.setFieldInt(o.pointer, ai, c);
            return true;
        } else {
            return false;
        }
    }

    @JNICALL
    public long objectFieldOffset(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.reflect.Field") KReference f) throws RemoteException {
        SimpleClassAdapter fc = new SimpleClassAdapter(env, f);
        KReference clazzRef = fc.getReference("clazz");
        String name = fc.getString("name");
        KClass kclass = env.getClassRepository().getClassByGuestReference(clazzRef);
        return kclass.getDefinition().getField(name, false).getByteOffset();
        //return kclass.getDefinition().getField(name, false).getIndex();
    }

    @JNICALL
    public long staticFieldOffset(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.reflect.Field") KReference f) throws RemoteException {
        SimpleClassAdapter fc = new SimpleClassAdapter(env, f);
        KReference clazzRef = fc.getReference("clazz");
        String name = fc.getString("name");
        KClass kclass = env.getClassRepository().getClassByGuestReference(clazzRef);
        return kclass.getDefinition().getField(name, false).getByteOffset();
        //return kclass.getDefinition().getField(name, false).getIndex();
    }

    @JNICALL
    public long allocateMemory(JNIEnv env, @THIS KReference ref, long bytes) throws RemoteException {
        int bytes1 = (int) bytes;
        if (bytes1 != bytes) {
            throw new IllegalArgumentException();
        }
        KMemorySegment segment = env.getProcess().getMemorySegment();
        KReference kReference = segment.allocByteArray(bytes1);
        private_alloc(kReference.pointer, bytes);
        segment.getGarbageCollector().incReferencesCount(kReference);
        return kReference.pointer;
    }

    @JNICALL
    public long reallocateMemory(JNIEnv env, @THIS KReference ref, long address, long bytes) throws RemoteException {
        int bytes1 = (int) bytes;
        if (bytes1 != bytes) {
            throw new IllegalArgumentException();
        }
        KMemorySegment segment = env.getProcess().getMemorySegment();
        byte[] oldValue = segment.getByteArray(address);
        segment.free(address);
        private_free(address);
        KReference kReference = segment.allocByteArray(bytes1);
        private_alloc(kReference.pointer, bytes);
        segment.getGarbageCollector().incReferencesCount(kReference);
        segment.setByteArray(kReference.pointer, 0, oldValue, 0, oldValue.length);
        return kReference.pointer;
    }

    @JNICALL
    public void freeMemory(JNIEnv env, @THIS KReference ref, long address) throws RemoteException {
        KMemorySegment segment = env.getProcess().getMemorySegment();
        segment.free(address);
        private_free(address);
    }

    @JNICALL
    public byte getByte(JNIEnv env, @THIS KReference ref, long l) throws RemoteException {
        Alloc alloc = private_findAlloc(l);
        long l1 = alloc.resolveIndex(l);
        KMemorySegment segment = env.getProcess().getMemorySegment();
        return segment.getByteArray(alloc.offset, (int) l1);
    }

    @JNICALL
    public void putByte(JNIEnv env, @THIS KReference ref, long l, byte b) throws RemoteException {
        Alloc alloc = private_findAlloc(l);
        long l1 = alloc.resolveIndex(l);
        KMemorySegment segment = env.getProcess().getMemorySegment();
        segment.setByteArray(alloc.offset, (int) l1, b);
    }

    @JNICALL
    public void putLong(JNIEnv env, @THIS KReference ref, long l, long b) throws RemoteException {
        Alloc alloc = private_findAlloc(l);
        long l1 = alloc.resolveIndex(l);
        KMemorySegment segment = env.getProcess().getMemorySegment();
        segment.setByteArray(alloc.offset, (int) l1, KMemoryUtilities.long2byteArray(b), 0, 8);
    }

    private void private_alloc(long offset, long size) {
        Alloc[] n = new Alloc[allocated.length + 1];
        System.arraycopy(allocated, 0, n, 0, allocated.length);
        n[allocated.length] = new Alloc(offset, size);
        Arrays.sort(n);
        allocated = n;
    }

    private void private_free(long offset) {
        int index = Arrays.binarySearch(allocated, new Alloc(offset, 1), new Comparator<Alloc>() {

            public int compare(Alloc o1, Alloc o2) {
                return (int) (o1.offset - o2.offset);
            }
        });

        Alloc[] n = new Alloc[allocated.length - 1];
        System.arraycopy(allocated, 0, n, 0, index);
        if (index < (allocated.length - 1)) {
            System.arraycopy(allocated, index, n, index + 1, allocated.length - index - 1);
        }
        allocated = n;
    }

    private Alloc private_findAlloc(long offset) {
        return allocated[private_findAllocIndex(offset)];
    }

    private int private_findAllocIndex(long offset) {
        return Arrays.binarySearch(allocated, new Alloc(offset, 1), new Comparator<Alloc>() {

            public int compare(Alloc o1, Alloc o2) {
                if (o1.contains(o2)) {
                    return 0;
                }
                if (o2.contains(o1)) {
                    return 0;
                }
                return (int) (o1.offset - o2.offset);
            }
        });
    }
}
