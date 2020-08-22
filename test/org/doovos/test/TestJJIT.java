///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.doovos.test;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.Enumeration;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipFile;
//import org.doovos.kernel.api.jvm.bytecode.KClassDef;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug.JJITDebug;
//import org.doovos.kernel.core.jvm.bytecode.ASMJavaByteCodeLoader;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITInterpreter;
//import org.junit.*;
//
///**
// *
// * @author vpc
// */
//public class TestJJIT {
//    private static final JJITDebug _LST_;
//    private static final JJITDebug __ST_;
//    private static final JJITDebug _LS__;
//    static{
//        _LST_=new JJITDebug();
//        _LST_.setOptCacheClasses(false);
//        _LST_.setOptLocal(true);
//        _LST_.setOptStack(true);
//        _LST_.setOptSubstitute(true);
//        _LST_.setDisassemble(false);
//        _LST_.setPackageSuffix("locals_stacks_subs");
//
//        __ST_=new JJITDebug();
//        __ST_.setOptCacheClasses(false);
//        __ST_.setOptLocal(false);
//        __ST_.setOptStack(true);
//        __ST_.setOptSubstitute(true);
//        __ST_.setDisassemble(false);
//        __ST_.setPackageSuffix("stacks_subs");
//
//        _LS__=new JJITDebug();
//        _LS__.setOptCacheClasses(false);
//        _LS__.setOptLocal(true);
//        _LS__.setOptStack(true);
//        _LS__.setOptSubstitute(false);
//        _LS__.setDisassemble(false);
//        _LS__.setPackageSuffix("locals_stacks");
//    }
//    public TestJJIT() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    //
//    //@Test
//    public void hello() throws IOException {
//        dumpCls(getClass().getResource("SimpleClassForTest.class"), null,_LST_);
//    }
//
//    @Test
//    public void hello2() throws IOException {
//        File rtjar = new File("/home/vpc/xprojects/apps/doovos/runtime/doovos/sites/sousse/sys/bin/jre/6/rt.jar");
//        File scimarkjar = new File("/home/vpc/xprojects/apps/doovos/runtime/doovos/sites/sousse/bin/scimark2lib.zip");
////        dumpJar(scimarkjar,_LST_);
//        //dumpCls("jnt.scimark2.FFT","test([D)D");
//
////        dumpJar(scimarkjar,"jnt.scimark2.MonteCarlo","integrate(I)D",_LST_);
////        dumpJar(scimarkjar,"jnt.scimark2.kernel","measureFFT(IDLjnt/scimark2/Random;)D",_LST_);
//        dumpJar(scimarkjar,"jnt.scimark2.LU","factor([[D[I)I",_LST_);
//
////        dumpJar(rtjar,"java.util.Hashtable","<init>(IF)V",_LST_);
//        //dumpJar(rtjar,"sun.reflect.NativeConstructorAccessorImpl","newInstance([Ljava/lang/Object;)Ljava/lang/Object;",_LST_);
////        dumpJar(rtjar,"java.lang.String","hashCode()I",_LST_);
////        dumpJar(rtjar,"java.lang.String","hashCode()I",__ST_);
////        dumpJar(rtjar,"java.lang.String","hashCode()I",_LS__);
//        //dumpCls(jnt.scimark2.FFT.class,"transform_internal([DI)V");
////        dumpCls(jnt.scimark2.FFT.class,null);
//        //dumpCls(jnt.scimark2.commandline.class);
//    }
//
//    public void dumpJar(File jar,JJITDebug debug) throws IOException {
//        dumpJar(jar, null, null,debug);
//    }
//
//    public void dumpJar(File jar, String cls, String methodSig,JJITDebug debug) throws IOException {
//        String clsFile = cls == null ? null : (cls.replace('.', '/') + ".class");
//        ZipFile f = new ZipFile(jar);
//        final Enumeration<? extends ZipEntry> entries = f.entries();
//        while (entries.hasMoreElements()) {
//            final ZipEntry e = entries.nextElement();
//            if (clsFile == null || (clsFile.equals(e.getName()))) {
//                dumpCls(f.getInputStream(e), methodSig,debug);
//            }
//        }
//    }
//
//    public void dumpCls(String cls, String methodSig,JJITDebug debug) throws IOException {
//        String p = '/' + cls.replace('.', '/') + ".class";
//        final URL u = getClass().getResource(p);
//        dumpCls(u, methodSig,debug);
//    }
//
//    public void dumpCls(URL url, String methodSig,JJITDebug debug) throws IOException {
//        dumpCls(url.openStream(), methodSig,debug);
//    }
//
//    public void dumpCls(InputStream is, String methodSig,JJITDebug debug) throws IOException {
//        ASMJavaByteCodeLoader loader = new ASMJavaByteCodeLoader();
//        final KClassDef clsDef = loader.loadClass(is);
//        KClass cls = new KClass(clsDef);
////        if(true){
////            return;
////        }
//
////        KInterpreterIdx i = new KInterpreterIdx();
////        for (KMethod mm : cls.getMethods()) {
////            i.init(mm);
////        }
//        JJITInterpreter i = new JJITInterpreter();
//        i.setDebug(debug);
//        //put
//        final Object[] pp = cls.getDefinition().getConstantsPool();
//        cls.setConstantsPool(new KRegister[pp.length]);
////        i.setDebugNoOpt(true);
//        if (methodSig == null) {
//            for (KMethod mm : cls.getMethods()) {
//                System.out.println("INIT : " + mm);
//                i.init(mm);
//            }
//        } else {
//            final KMethod mm = cls.getMethodBySignature(methodSig);
//            System.out.println("INIT : " + mm);
//            i.init(mm);
//        }
//    }
//}
