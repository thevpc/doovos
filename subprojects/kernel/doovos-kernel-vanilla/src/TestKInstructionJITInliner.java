/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.core.jvm.bytecode.ASMJavaByteCodeLoader;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJIT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITProcessStat;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats.JJITSharedBlocKey;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITDebug;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITLog;

import java.io.File;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITMethodCompilerCache;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITMethodCompilerHints;

/**
 * @author vpc
 */
public class TestKInstructionJITInliner {

    public static void main(String[] args) {
        try {
//            System.setProperty("user.dir", "/home/vpc/xprojects/apps/doovos/runtime/doovos/sites/sousse");
            System.out.println(new File(".").getCanonicalPath());
            String rt = "/home/vpc/xprojects/apps/doovos/runtime/doovos/sites/sousse/sys/bin/jre/6/rt.jar";
            String sm = "/home/vpc/xprojects/apps/doovos/runtime/doovos/sites/sousse/bin/scimark2lib.zip";
            String lp = "/home/vpc/xprojects/apps/doovos/runtime/doovos/sites/sousse/bin/linpack.jar";

            String classPathItem = sm;
            String className = null;
            String methodName = null;
            int classIndex = -1;

//            String classPathItem = sm;
//            String className = "jnt.scimark2.MonteCarlo";
//            String methodName = "integrate(I)D";
//            int classIndex = -1;

//            String classPathItem = sm;
//            String className = "jnt.Bench.Bench";
//            String methodName = "insertEntry([D)V";
//            int classIndex = -1;

//            String classPathItem = rtjar;
//            String className = "java.util.Hashtable";
//            String methodName = "put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;";
//            int classIndex = 19;

//            String classPathItem = rtjar;
//            String className = "java.lang.System";
//            String methodName = "nullInputStream()Ljava/io/InputStream;";
//            int classIndex = -1;

//            String classPathItem = rtjar;
//            String className = "com.sun.corba.se.impl.io.ObjectStreamClass";
//            String methodName = "access$202(Lcom/sun/corba/se/impl/io/ObjectStreamClass;J)J";
//            int classIndex = -1;

//            String classPathItem = rtjar;
//            String className = "com.sun.corba.se.impl.encoding.CDROutputStream_1_2";
//            String methodName = "write_wchar_array([CII)V";
//            int classIndex = -1;

//            String classPathItem = rtjar;
//            String className = "com.sun.awt.SecurityWarning";
//            String methodName = "setPosition(Ljava/awt/Window;Ljava/awt/geom/Point2D;FF)V";
//            int classIndex = 19;

//            String classPathItem = rtjar;
//            String className = "com.sun.activation.registries.MailcapTokenizer";
//            String methodName = "nameForToken(I)Ljava/lang/String;";
//            int classIndex = 9;

//            String classPathItem = rtjar;
//            String className = "com.sun.beans.ObjectHandler";
//            String methodName = "parseIntAsChar(Ljava/lang/String;)C";
//            int classIndex = 0;

//            String classPathItem = rtjar;
//            String className = "com.sun.accessibility.internal.resources.accessibility";
//            String methodName = null;
//            int classIndex = 5;

//            String classPathItem = rtjar;
//            String className = "com.sun.corba.se.impl.interceptors.InterceptorInvoker";
//            String methodName = "invokeClientInterceptorStartingPoint(Lcom/sun/corba/se/impl/interceptors/ClientRequestInfoImpl;)V";
//            int classIndex = 8;

//            String classPathItem = rtjar;
//            String className = "com.sun.awt.SecurityWarning";
//            String methodName = "getSize(Ljava/awt/Window;)Ljava/awt/Dimension;";
//            int classIndex = 0;

//            String classPathItem = rtjar;
//            String className = "com.sun.corba.se.impl.activation.ServerTableEntry";
//            String methodName = "isActive()Z";
//            int classIndex = 1;

//            String classPathItem = rtjar;
//            String className = "com.sun.corba.se.impl.activation.CommandHandler";
//            String methodName = "getCommandName()Ljava/lang/String;";
//            int classIndex = 1;

//            String classPathItem = rtjar;
//            String className = "com.sun.activation.registries.MailcapTokenizer";
//            String methodName = null;
//            int classIndex = 1;

//            String classPathItem = rtjar;
//            String className = "java.util.Hashtable";
//            String methodName = "<init>(IF)V";
//            int classIndex = 0;
//
//            String classPathItem = rtjar;
//            String className = "java.util.Properties";
//            String methodName = "<init>()V";

//            String classPathItem = rtjar;
//            String className = "java.lang.Object";
//            String methodName = "<clinit>()V";

//            String classPathItem = "/home/vpc/Temp";
//            String className = "jnt.scimark2.commandline";
//            String methodName = "main([Ljava/lang/String;)V";


//            String classPathItem = "/home/vpc/Temp";
//            String className = "jnt.scimark2.Random";
//            String methodName = "nextDouble()D";
//            int classIndex = -1;

//            String classPathItem = "/home/vpc/xprojects/apps/doovos/subprojects/guestjvm/doovos-guestjvm-test/build/classes";
//            String className = "Taha";
//            String methodName = "main([Ljava/lang/String;)V";

//            String classPathItem = "/home/vpc/xprojects/apps/doovos/subprojects/guestjvm/doovos-guestjvm-test/build/classes";
//            String className = "Taha2";
//            String methodName = "main([Ljava/lang/String;)V";
//            int classIndex = 0;

            JJITDebug debug = new JJITDebug();
            System.out.println(debug);
            debug.setOptCacheClasses(false);
            debug.setDisassemble(true);
            debug.setClassIndex(classIndex);
//
            debug.setNoComments(false);
            debug.setOptFields(true);
            debug.setPrimitiveLocals(true);
//
            debug.setOptStack(true);
            debug.setOptLocal(true);
            debug.setOptSubstitute(true);
            debug.setOptSimplify(true);
            debug.setLog(true);
            JJITProcessStat stat = new JJITProcessStat();
            run(classPathItem, className, methodName, debug, stat);
            System.out.println("ALL STATS :: ");
            System.out.println("-------------");
            System.out.println("\tEXTRA RATIO : "+stat.getExtraRatio());
            System.out.println("\tBLOC SIZE : "+stat.getBlocSizeRatio());

            System.out.println("\tPRIVATE BLOCS");
            printSortedKeyMap(stat.getPrivateCount());
            System.out.println("\tSHARED BLOCS");
            printSortedKeyMap(stat.getSharedCount());
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    private static void printSortedKeyMap(IntHashMap m) {
        Map<Integer, Integer> mm = m.toMap();
        for (Integer k : new TreeSet<Integer>(mm.keySet())) {
            System.out.println("\t\t" + k + " : " + mm.get(k));
        }
    }

    public static List<String> lookupClassNames(String classPathItem) throws Throwable {
        File f = new File(classPathItem);
        List<String> all = new ArrayList<String>();
        if (f.isFile()) {
            ZipFile zip = new ZipFile(f);
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry e = entries.nextElement();
                String name = e.getName();
                if (name.endsWith(".class")) {
                    name = name.substring(0, name.length() - 6);
                    all.add(name.replace('/', '.'));
                }
            }
            zip.close();
            return all;
        } else {
            throw new IllegalArgumentException("Not supported");
        }
    }

    public static void run(String classPathItem, String className, String methodName, JJITDebug debug, JJITProcessStat stat) throws Throwable {
        try {
            ArrayList<String> classNames = new ArrayList<String>();
            if (className == null) {
                classNames.addAll(lookupClassNames(classPathItem));
            } else {
                classNames.add(className);
            }
            ASMJavaByteCodeLoader x = new ASMJavaByteCodeLoader();
            int counter = 1;
            int max = classNames.size();
            for (String nn : classNames) {
                KClassDef y = x.loadClass(nn, new File(classPathItem));
                compileClass(y, debug, counter, max, methodName, stat);
                counter++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static void compileClass(KClassDef y, JJITDebug debug, int counter, int max, String methodName, JJITProcessStat stat) {
        JJITLog.log("[" + counter + "/" + max + "] Compile Class " + y.getName());
        ArrayList<KMethodDef> methods = new ArrayList<KMethodDef>();
        if (methodName != null) {
            for (KMethodDef m : y.getMethods()) {
                if (m.getSignature().equals(methodName)) {
                    methods.add(m);
                    break;
                }
            }
            if (methods.isEmpty()) {
                throw new IllegalArgumentException("Method not found " + methodName);
            }
        } else {
            methods.addAll(Arrays.asList(y.getMethods()));
        }
        int mIndex = 1;
        int mMax = methods.size();
        for (KMethodDef method : methods) {
            compileMethod(method, debug, mIndex, mMax, stat);
            mIndex++;
        }
    }

    private static void compileMethod(KMethodDef method, JJITDebug debug, int mIndex, int mMax, JJITProcessStat stat) {
        JJITLog.log("[" + mIndex + "/" + mMax + "] Compile Method " + method.getSignature() + " {" + method.getClassName() + "}");
        JJITMethodCompilerHints hints = new JJITMethodCompilerHints();
        JJITMethodCompilerCache cache = new JJITMethodCompilerCache();
        JJIT.CompileInfo ci = new JJIT.CompileInfo(method, null, cache, hints, debug, stat, null);
        JJIT.compileMethod(ci);
    }
}
