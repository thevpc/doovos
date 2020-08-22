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

import java.util.Properties;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.adapter.RefArrayAdapter;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.process.KThread;
import org.doovos.kernel.api.process.KLocalThread;

import java.rmi.RemoteException;
import java.util.List;
import org.doovos.kernel.api.memory.adapter.DProcessAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 19 avr. 2009
 * Time: 19:24:24
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("java.lang.Thread")
public class ThreadJNI {
    private static final Doovos system = Doovos.getSystem();

    @JNICALL
    public static void registerNatives(JNIEnv env) throws RemoteException {
    }

    @JNICALL(returnType = "java.lang.Thread")
    public static /*Thread*/ KReference currentThread(JNIEnv env) throws RemoteException {
        KLocalThread threadLocal = env.getThread();
        KReference kReference = threadLocal.getJVMReference();
        if (kReference == null) {
            KReference g = resolveThreadGroup(env);
            SimpleClassAdapter t = SimpleClassAdapter.newInstance(env, "java.lang.Thread");
            t.setReference("group", g);
            t.setInt("tid", 0);
            t.setInt("priority", 5);
            kReference = t.getReference();
            env.getThread().setJVMReference(kReference);
        }
        return kReference;
    }

    @JNICALL
    public static void yield(JNIEnv env) {
        //TODO FIXE ME
    }

    @JNICALL
    public static void sleep(JNIEnv env, long millis) throws RemoteException {
        KLocalThread threadLocal = env.getThread();
        threadLocal.sleep(millis);
    }


    @JNICALL
    public void start0(JNIEnv env, @THIS KReference ref) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        threadLocal.start();
    }

    @JNICALL
    public boolean isInterrupted(JNIEnv env, @THIS KReference ref, boolean ClearInterrupted) throws Exception {
        //TODO fix me
        return false;
    }

    @JNICALL
    public final boolean isAlive(JNIEnv env, @THIS KReference ref) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        return threadLocal.isAlive();
    }

    @JNICALL
    public final void setPriority0(JNIEnv env, @THIS KReference ref, int newPriority) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        threadLocal.setPriority(newPriority);
    }

    @JNICALL
    public final void stop0(JNIEnv env, @THIS KReference ref) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        throw new UnsupportedOperationException();
    }

    @JNICALL
    public final void suspend0(JNIEnv env, @THIS KReference ref) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        throw new UnsupportedOperationException();
    }

    @JNICALL
    public final void resume0(JNIEnv env, @THIS KReference ref) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        throw new UnsupportedOperationException();
    }

    @JNICALL
    public final void interrupt0(JNIEnv env, @THIS KReference ref) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        throw new UnsupportedOperationException();
    }

    @JNICALL
    public int countStackFrames(JNIEnv env, @THIS KReference ref) throws Exception {
        KThread threadLocal = resolveKThread(env, ref);
        return threadLocal.getFramesCount();
    }

    @JNICALL
    public static boolean holdsLock(JNIEnv env, @JNIPARAM("java.lang.Object") KReference obj) {
        //TODO fixe me
        return false;
    }

    @JNICALL(returnType = "java.lang.Thread[]")
    public static /*Thread[]*/ KReference getThreads(JNIEnv env) throws RemoteException {
        List<KThread> kThreadList = env.getProcess().getThreads();
        RefArrayAdapter a = RefArrayAdapter.newInstance(env.getProcess(), "java.lang.Thread", kThreadList.size());
        for (int i = 0; i < kThreadList.size(); i++) {
            KThread kThread = kThreadList.get(i);
            a.setArrayReference(i, kThread.getJVMReference());
        }
        return a.getReference();
    }


    private static KThread resolveKThread(JNIEnv env, @THIS KReference ref) throws Exception {
        if (ref.isNull()) {
            return null;
        }
        for (KThread o : env.getProcess().getThreads()) {
            KReference r = o.getJVMReference();
            if (r != null && r.equals(ref)) {
                return o;
            }
        }
        final KProcess process = env.getProcess();
        final Properties envs = new DProcessAdapter(process,process.getGuestReference()).getEnvs().toProperties(env);
        KThread kThread = system.allocThread(process, envs, "java.lang.Thread", "run()V", new KRegister[]{ref});
        kThread.setJVMReference(ref);
        //kThread.setPriority(new SimpleClassAdapter(env,ref).getInt("priority"));
        //Thread not found
        //will be created!
        for (KThread o : process.getThreads()) {
            KReference r = o.getJVMReference();
            if (r != null && r.equals(ref)) {
                return o;
            }
        }
        throw new IllegalArgumentException("????????");
        //return kThread;
    }

    private static KReference resolveThreadGroup(JNIEnv env) throws RemoteException {
        SimpleClassAdapter p = new SimpleClassAdapter(env.getProcess(), env.getProcess().getGuestReference());
        return p.getReference("threadGroup");
    }
}
