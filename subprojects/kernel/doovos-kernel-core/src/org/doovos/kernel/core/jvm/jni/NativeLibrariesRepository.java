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
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
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
package org.doovos.kernel.core.jvm.jni;

import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.jni.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.filesystem.KPathFilter;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.FileCache;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.rmi.RemoteException;
import java.util.*;
import org.doovos.kernel.api.jvm.jni.KJNIMethodInfo;

public class NativeLibrariesRepository {

    private Map<String, KJNINativeMethodImpl> nativeMethods = new HashMap<String, KJNINativeMethodImpl>();
    private Map<String, Object> libraries = new HashMap<String, Object>();
    private URLClassLoader librariesClassLoader;
    private static final Map<String, NativeParam> paramsFactory;
    private static Map<String, Set<String>> forcedToNativeMethods = new HashMap<String, Set<String>>();
    static {
        paramsFactory = new HashMap<String, NativeParam>();
        register(NativeParamPrimitiveBoolean.INSTANCE);
        register(NativeParamPrimitiveBooleanArray.INSTANCE);
        register(NativeParamPrimitiveByte.INSTANCE);
        register(NativeParamPrimitiveByteArray.INSTANCE);
        register(NativeParamPrimitiveByteArray2.INSTANCE);
        register(NativeParamPrimitiveShort.INSTANCE);
        register(NativeParamPrimitiveShortArray.INSTANCE);
        register(NativeParamPrimitiveChar.INSTANCE);
        register(NativeParamPrimitiveCharArray.INSTANCE);
        register(NativeParamPrimitiveInt.INSTANCE);
        register(NativeParamPrimitiveIntArray.INSTANCE);
        register(NativeParamPrimitiveLong.INSTANCE);
        register(NativeParamPrimitiveLongArray.INSTANCE);
        register(NativeParamPrimitiveFloat.INSTANCE);
        register(NativeParamPrimitiveFloatArray.INSTANCE);
        register(NativeParamPrimitiveDouble.INSTANCE);
        register(NativeParamPrimitiveDoubleArray.INSTANCE);
        register(NativeParamKBoolean.INSTANCE);
        register(NativeParamKByte.INSTANCE);
        register(NativeParamKShort.INSTANCE);
        register(NativeParamKChar.INSTANCE);
        register(NativeParamKInteger.INSTANCE);
        register(NativeParamKLong.INSTANCE);
        register(NativeParamKFloat.INSTANCE);
        register(NativeParamKDouble.INSTANCE);
        register(NativeParamKReference.INSTANCE);
        paramsFactory.put(String.class.getName(), NativeParamString.INSTANCE);
        paramsFactory.put(String[].class.getName(), NativeParamStringArray.INSTANCE);
    }

    private static void register(NativeParam p){
        paramsFactory.put(p.getGuestType(), p);
    }

    //    private final static class NativeMethodKey implements Comparable<NativeMethodKey> {
//
//        private String className;
//        private String signature;
//
//        private NativeMethodKey(String className, String signature) {
//            this.className = className;
//            this.signature = signature;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) {
//                return true;
//            }
//            if (o == null || getClass() != o.getClass()) {
//                return false;
//            }
//
//            NativeMethodKey that = (NativeMethodKey) o;
//
//            if (className != null ? !className.equals(that.className) : that.className != null) {
//                return false;
//            }
//            if (signature != null ? !signature.equals(that.signature) : that.signature != null) {

    //                return false;
//            }
//
//            return true;
//        }
//
//        @Override
//        public int hashCode() {
//            int result = className != null ? className.hashCode() : 0;
//            result = 31 * result + (signature != null ? signature.hashCode() : 0);
//            return result;
//        }
//
//        public int compareTo(NativeMethodKey o) {
//            return toString().compareTo(o.toString());
//        }
//
//        @Override
//        public String toString() {
//            return "NativeMethodKey{" +
//                    "className='" + className + '\'' +
//                    ", signature='" + signature + '\'' +
//                    '}';
//        }
//    }
    public NativeLibrariesRepository() {
    }

    public void addLibraryClass(String library, KProcess process) throws ClassNotFoundException, IllegalAccessException, InstantiationException, RemoteException {
//        System.out.println("[" + process.getName() + "]>> addLibrary " + library);
        if (libraries.containsKey(library)) {
            throw new KJNIException("JNI Library already loaded : " + library);
        }
        if (librariesClassLoader == null) {
            Collection<KResource> resources = Doovos.getSystem().getFileSystemManager().list("/data/sys/bin/jni", new KPathFilter() {

                public boolean accept(String path) {
                    return path.endsWith(".jar");
                }
            });
            ArrayList<URL> jniUrls = new ArrayList<URL>();
            for (KResource resource : resources) {
                if (resource instanceof KFile) {
                    try {
                        FileCache c = new FileCache((KFile) resource);
                        jniUrls.add(c.getLocalFile().toURI().toURL());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            librariesClassLoader = new URLClassLoader(jniUrls.toArray(new URL[jniUrls.size()]), getClass().getClassLoader());
        }
        Class<?> libClass = null;
        try {
            libClass = Class.forName(library, true, librariesClassLoader);
            //libClass = librariesClassLoader.loadClass(library);// Class.forName(library, true, librariesClassLoader);
        } catch (ClassNotFoundException e) {
            throw new KJNIClassNotFoundException(e.toString());
//            try {
//                libClass = Class.forName("jni." + library, true, c);
//            } catch (ClassNotFoundException e2) {
//                try {
//                    libClass = Class.forName(library + "JNIImpl", true, c);
//                } catch (ClassNotFoundException e1) {
//            System.err.println("JNI class not found " + library);
//            throw e;
//                }
//            }
        }
        JNICLASS annotationJNICLASS = libClass.getAnnotation(JNICLASS.class);
        if (annotationJNICLASS == null) {
            System.err.println("Missing Annotation @JNICLASS in " + libClass);
            System.err.println("\tClassLoader = " + libClass.getClassLoader());
            System.err.println("\tMethods = ");
            for (Method method : libClass.getMethods()) {
                System.err.println("\t\t" + method);
            }
            throw new KJNIException("Missing Annotation @JNICLASS in " + libClass);
        }
        boolean classForceJNI = annotationJNICLASS.forceJNI();
        String classNameJNICLASS = annotationJNICLASS.value();
        if (classNameJNICLASS == null || classNameJNICLASS.length() == 0) {
            classNameJNICLASS = library;
        }

        Object oo = libClass.newInstance();
        libraries.put(library, oo);
        String classNamePath = classNameJNICLASS;// oo.getClass().getName();
        boolean added = false;
        Set<String> forced = new HashSet<String>();
        for (Method method : oo.getClass().getDeclaredMethods()) {
            JNICALL annotationJNICALL = method.getAnnotation(JNICALL.class);
            if (annotationJNICALL != null) {
                KJNINativeMethodImpl m = new KJNINativeMethodImpl(oo, method, classNamePath);
                if (nativeMethods.containsKey(m.getKey())) {
                    throw new KJNIException("JNI Method already found : " + m);
                }
                //
                method.setAccessible(true);
//                System.out.println(">>> register Native : " + m);
                nativeMethods.put(m.getKey(), m);
                if (classForceJNI || annotationJNICALL.forceJNI()) {
                    forced.add(m.getSignature());
                }
                added = true;
            }
        }
        if (forced.size() > 0) {
            forcedToNativeMethods.put(classNamePath, forced);
        }
        if (!added) {
            throw new IllegalArgumentException("No native method to load : " + library);
        }
    }

    //    private static TreeSet<String> primitivetypes = new TreeSet<String>(Arrays.asList(new String[]{"int", "long", "short", "boolean", "float", "double", "byte", "char"}));
    static String toParamCanonicalName(Class cls, Annotation[] annotations,Method method) {
        if (containsAnnotation(annotations, THIS.class) != null) {
            throw new KJNIException("static methods does not need THIS reference : "+method);
        }
        if (cls.equals(KReference.class)) {
            JNIPARAM annotationParam = containsAnnotation(annotations, JNIPARAM.class);
            if (annotationParam == null || annotationParam.value().length() == 0) {
                throw new KJNIException("Reference Parameter must be resolved to a valid class name : "+method);
            }
            return (KClass.userClassFormatToJavaClassFormat(annotationParam.value()));
        } else if (cls.isPrimitive()) {
            return KObjectType.resolveByName(cls.getCanonicalName()).getCode();
        } else {
            NativeParam param = paramsFactory.get(cls.getName());
            if(param!=null){
                return KClass.classToJavaClassFormat(cls);
            }
            throw new UnsupportedOperationException("Unsupported type " + cls+" : "+method);
        }
    }

    static String toParamTypeName(Class cls, Annotation[] annotations,Method method) {
        if (containsAnnotation(annotations, THIS.class) != null) {
            throw new KJNIException("static methods does not need THIS reference : "+method);
        }
        if (cls.equals(KReference.class)) {
            JNIPARAM annotationParam = containsAnnotation(annotations, JNIPARAM.class);
            if (annotationParam == null || annotationParam.value().length() == 0) {
                throw new KJNIException("Reference Parameter must be resolved to a valid class name : "+method);
            }
            return annotationParam.value();
        } else if (cls.isPrimitive()) {
            return KObjectType.resolveByName(cls.getCanonicalName()).getName();
        } else {
            NativeParam param = paramsFactory.get(cls.getName());
            if(param!=null){
                return cls.getName();
            }
            throw new UnsupportedOperationException("Unsupported type " + cls+" : "+method);
        }
    }

    static String toReturnTypeCanonicalName(Class cls, Annotation[] annotations,Method method) {
        if (cls.equals(KReference.class)) {
            JNICALL annotationParam = containsAnnotation(annotations, JNICALL.class);
            if (annotationParam == null || annotationParam.returnType().length() == 0) {
                throw new KJNIException("Reference Parameter must be resolved to a valid class name"+" : "+method);
            }
            return (KClass.userClassFormatToJavaClassFormat(annotationParam.returnType()));
        } else if (cls.isPrimitive()) {
            return KObjectType.resolveByName(cls.getCanonicalName()).getCode();
        } else {
            NativeParam param = paramsFactory.get(cls.getName());
            if(param!=null){
                return KClass.classToJavaClassFormat(cls);
            }
            throw new UnsupportedOperationException("Unsupported type " + cls+" : "+method);
        }
    }

    static <T> T containsAnnotation(Annotation[] all, Class<? extends T> one) {
        boolean ok = false;
        for (Annotation annotation : all) {
            if (one.isInstance(annotation)) {
                return (T) annotation;
            }
        }
        return null;
    }

    public boolean existsNativeMethod(String methodId) {
        KJNINativeMethodImpl m = nativeMethods.get(methodId);
        return m != null;
    }
    
    public KJNIMethodInfo getJNIMethodInfo(String methodFullId) throws RemoteException {
        KJNINativeMethodImpl m = nativeMethods.get(methodFullId);
        if (m == null) {
            return m.getJniDef();
        }
        return null;
    }

    public KJNIMethod getJNIMethod(String methodId) throws KJNINoSuchMethodException{

        KJNIMethod m = nativeMethods.get(methodId);
        if (m == null) {
            TreeSet<String> p=new TreeSet<String>(nativeMethods.keySet());
            Doovos.getSystem().getLog().error("JNI Method not found : " + methodId);
            Doovos.getSystem().getLog().error("registered methods are :");
            for (String s : p) {

                Doovos.getSystem().getLog().error("\t"+s);
            }
            throw new KJNINoSuchMethodException("JNI Method not found : " + methodId);
        }
        return m;
    }

    public KRegister invokeMethod(String methodId, KFrame frame, KRegister[] parameters) throws KJNINoSuchMethodException,KJNIInvocationException{
//        int dotIndex= methodId.indexOf('(');
//        if(dotIndex>0){
//            methodId = methodId.substring(0,dotIndex);
//        }
        return getJNIMethod(methodId).invoke(frame,parameters);
    }

    public Set<String> getForcedToNativeMethods(String className) {
        Set<String> found = forcedToNativeMethods.get(className);
        return found == null ? Collections.EMPTY_SET : found;
    }

    public static NativeParam getNativeParam(String parameterType){
        return paramsFactory.get(parameterType);
    }
}
