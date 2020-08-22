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

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.Properties;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.adapter.DProcessAdapter;

@JNICLASS("java.lang.System")
public class SystemJNI {

    private static final Doovos system = Doovos.getSystem();
    private static KMemoryManager memoryManager=system.getMemoryManager();

    public SystemJNI() {
    }

    @JNICALL
    public static void registerNatives(JNIEnv env) throws Exception {
        //env.callStaticMethod(env.getMethod().getParentClass().getMethodBySignature("initializeSystemClass()V"));
    }

    @JNICALL
    public static void setIn0(JNIEnv env, @JNIPARAM("java.io.InputStream") KReference in) throws RemoteException {
        KClass sysClass = env.getClassRepository().getClassByName("java.lang.System");
        sysClass.getField("in", false).setStaticValue(in);
    }

    @JNICALL
    public static void setOut0(JNIEnv env, @JNIPARAM("java.io.PrintStream") KReference out) throws RemoteException {
        KClass sysClass = env.getClassRepository().getClassByName("java.lang.System");
        sysClass.getField("out", false).setStaticValue(out);

//        KRegister value = sysClass.getField("out",false).getClassValue();
    }

    @JNICALL
    public static void setErr0(JNIEnv env, @JNIPARAM("java.io.PrintStream") KReference err) throws RemoteException {
        KClass sysClass = env.getClassRepository().getClassByName("java.lang.System");
        sysClass.getField("err", false).setStaticValue(err);
    }

    @JNICALL
    public static long currentTimeMillis(JNIEnv env) {
        return system.currentTimeMillis();
    }

    @JNICALL
    public static long nanoTime(JNIEnv env) {
        return system.nanoTime();
    }

    @JNICALL
    public static void arraycopy(JNIEnv env, @JNIPARAM("java.lang.Object") KReference src, int srcPos,
            @JNIPARAM("java.lang.Object") KReference dest, int destPos,
            int length) throws RemoteException {
        memoryManager.arraycopy(src, srcPos, dest, destPos, length);
    }

    @JNICALL
    public static int identityHashCode(JNIEnv env, @JNIPARAM("java.lang.Object") KReference x) {
        return x.hashCode();
    }

    @JNICALL(returnType = "java.util.Properties")
    public static KReference initProperties(JNIEnv env, @JNIPARAM("java.util.Properties") KReference props) throws Exception {
        KProcess process = env.getProcess();
        KMemorySegment ms = process.getMemorySegment();
        KClass hash = process.getClassRepository().getClassByName("java.util.Hashtable");
        KMethod m = hash.getMethodBySignature("put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        Properties p = new Properties();
        //put host jvm properties
        for (Map.Entry<java.lang.Object, java.lang.Object> objectObjectEntry : java.lang.System.getProperties().entrySet()) {
            java.lang.String k = (java.lang.String) objectObjectEntry.getKey();
            java.lang.String v = (java.lang.String) objectObjectEntry.getValue();
            //p.setProperty(k, v);
            p.setProperty("hostvm." + k, v);
        }
        //java.version
        //java.vendor
        //java.vendor.url
        //java.home
        //java.vm.specification.version
        //java.vm.specification.vendor
        //java.vm.specification.name
        //java.vm.version
        //java.vm.vendor
        //java.vm.name
        //java.specification.version
        //java.specification.vendor
        //java.specification.name
        //java.class.version
        //java.class.path
        //java.library.path
        //java.io.tmpdir
        //java.compiler
        //java.ext.dirs
        //os.name
        //os.arch
        //os.version
        //file.separator
        //path.separator
        //line.separator
        //user.name
        //user.home
        //user.dir

//        p.put("sun.boot.library.path","/usr/java/j2sdk1.4.2_16/jre/lib/i386");
//        p.put("java.awt.graphicsenv","sun.awt.X11GraphicsEnvironment");
//        p.put("java.endorsed.dirs","/usr/java/j2sdk1.4.2_16/jre/lib/endorsed");
//        p.put("sun.java2d.fontpath","");
//        p.put("java.class.path","/usr/java/j2sdk1.4.2_16/jre/lib/charsets.jar:/usr/java/j2sdk1.4.2_16/jre/lib/plugin.jar:/usr/java/j2sdk1.4.2_16/jre/lib/sunrsasign.jar:/usr/java/j2sdk1.4.2_16/jre/lib/jsse.jar:/usr/java/j2sdk1.4.2_16/jre/lib/rt.jar:/usr/java/j2sdk1.4.2_16/jre/lib/jce.jar:/usr/java/j2sdk1.4.2_16/jre/lib/ext/ldapsec.jar:/usr/java/j2sdk1.4.2_16/jre/lib/ext/dnsns.jar:/usr/java/j2sdk1.4.2_16/jre/lib/ext/localedata.jar:/usr/java/j2sdk1.4.2_16/jre/lib/ext/sunjce_provider.jar:/home/vpc/xprojects/test/j4/out/production/j4:/home/vpc/bin/idea-8.1.9164/lib/idea_rt.jar");
//        p.put("java.ext.dirs","/usr/java/j2sdk1.4.2_16/jre/lib/ext");
//        p.put("java.util.prefs.PreferencesFactory","java.util.prefs.FileSystemPreferencesFactory");
//        p.put("sun.boot.class.path","/usr/java/j2sdk1.4.2_16/jre/lib/rt.jar:/usr/java/j2sdk1.4.2_16/jre/lib/i18n.jar:/usr/java/j2sdk1.4.2_16/jre/lib/sunrsasign.jar:/usr/java/j2sdk1.4.2_16/jre/lib/jsse.jar:/usr/java/j2sdk1.4.2_16/jre/lib/jce.jar:/usr/java/j2sdk1.4.2_16/jre/lib/charsets.jar:/usr/java/j2sdk1.4.2_16/jre/classes");
//        p.put("sun.arch.data.model","32");
//        p.put("sun.os.patch.level","N/A");
//        p.put("file.encoding.pkg","sun.io");
//        p.put("java.awt.printerjob","sun.print.PSPrinterJob");
        //p.put("java.library.path","/usr/java/j2sdk1.4.2_16/jre/lib/i386/client:/usr/java/j2sdk1.4.2_16/jre/lib/i386:/usr/java/j2sdk1.4.2_16/jre/../lib/i386:/usr/java/jdk1.6.0_10/jre/lib/i386/server:/usr/java/jdk1.6.0_10/jre/lib/i386:/usr/java/jdk1.6.0_10/jre/../lib/i386:.:/usr/lib/mpi/gcc/openmpi/lib");
        String jreHome = DoovosConstants.SYSTEM_PATH + "/bin/jre/5/";
        DProcessAdapter a = new DProcessAdapter(process, process.getGuestReference());
        p.put("java.class.path", a.getEnv(env, DoovosConstants.ENV_PATH));
        p.put("sun.boot.class.path", a.getEnv(env, DoovosConstants.ENV_PATH));
        p.put("java.library.path", DoovosConstants.SYSTEM_PATH + "/bin/jni");
        p.put("java.endorsed.dirs", jreHome + "endorsed");
        p.put("java.ext.dirs", jreHome + "endorsed");
        p.put("sun.boot.library.path", DoovosConstants.SYSTEM_PATH + "/bin/jni");
        p.put("java.io.tmpdir", "/data/tmp");
        p.put("user.dir", env.getProcess().getCwd());
        p.put("user.home", system.getUserHome(env.getProcess().getUser()));
        p.put("java.home", jreHome);

        p.put("os.version", Doovos.VERSION.getOsVersion());
        p.put("java.vm.name", Doovos.VERSION.getOsId() + " Java VM");
        p.put("os.name", Doovos.VERSION.getOsId());

        p.put("java.vm.info", "Doovos mode");
        p.put("java.runtime.name", "Java(TM) 2 Runtime Environment, Doovos Enabled");
        p.put("java.vm.version", "1.4");
        p.put("java.vm.vendor", "Taha BEN SALAH");
        p.put("java.runtime.version", "1.4.0");
        p.put("java.version", "1.4");
        p.put("java.vendor.url", "http://doovos.dev.java.net/");
        p.put("path.separator", ":");
        p.put("user.country", "TN");
        p.put("java.vm.specification.name", "Java Virtual Machine Specification");
        //?

        p.put("os.arch", "java");
        p.put("line.separator", "\n");
        p.put("java.vm.specification.vendor", "Sun Microsystems Inc.");
        p.put("java.specification.name", "Java Platform API Specification");
        p.put("java.class.version", "48.0");
        p.put("user.timezone", "");
        p.put("file.encoding", "UTF-8");
        p.put("java.specification.version", "1.4");
        p.put("user.name", env.getProcess().getUser());
        p.put("java.vm.specification.version", "1.0");
        p.put("user.language", "fr");
        p.put("java.specification.vendor", "Sun Microsystems Inc.");
        p.put("java.vendor", "Doovos Team");
//        p.put("java.vendor", "Sun Microsystems Inc.");
        p.put("file.separator", "/");
        p.put("java.vendor.url.bug", "http://doovos.dev.java.net");
        p.put("sun.io.unicode.encoding", "UnicodeLittle");
        p.put("sun.cpu.endian", "little");
        p.put("sun.cpu.isalist", "");

        for (Map.Entry<java.lang.Object, java.lang.Object> objectObjectEntry : p.entrySet()) {
            java.lang.String k = (java.lang.String) objectObjectEntry.getKey();
            java.lang.String v = (java.lang.String) objectObjectEntry.getValue();
            env.invokeObjectMethod(m, props, ms.allocString(k), ms.allocString(v));
        }

        return props;
    }

    @JNICALL
    /*(returnType = "java.lang.String")*/
    public static String mapLibraryName(JNIEnv env, String libname) throws RemoteException {
        return libname + ".jar";
    }
}
