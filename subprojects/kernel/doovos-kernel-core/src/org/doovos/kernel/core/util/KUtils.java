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
package org.doovos.kernel.core.util;

import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.filesystem.KPathFilter;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.process.KLocalThread;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.doovos.kernel.api.filesystem.KFilePath;

import org.doovos.kernel.api.memory.adapter.StringArrayAdapter;

public final class KUtils {

    public final static SimpleDateFormat LOG_DATE = new SimpleDateFormat("yyyyMMdd-HHmmss.SSS");
    public static final byte FF = (byte) 0xFF;
    public static final byte[] NULL_BYTES = new byte[]{
        FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF
    };
//    public static final KObject NULL_OBJECT = new KObjectImpl(
//            KObjectType.t_ref,
//            NULL_BYTES, 1);

//    private static interface KObjectFactory {
//
//        KObject createObject(Object javaObject);
//    }

    public static interface KRegisterFactory {

        KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException;
    }
//    private static final Map<Class, KObjectFactory> objectFactories;
    private static final Map<Class, KRegisterFactory> registerFactories;

    static {
//        objectFactories = new HashMap<Class, KObjectFactory>();
//        objectFactories.put(Integer.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                int v = (Integer) javaObject;
//                byte[] b = new byte[4];
//                KMemoryUtilities.int2byteArray(v, b, 0);
//                return new KObjectImpl(KObjectType.t_int, b, 1);
//            }
//        });
//        objectFactories.put(Long.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                long v = (Long) javaObject;
//                byte[] b = new byte[8];
//                KMemoryUtilities.long2byteArray(v, b, 0);
//                return new KObjectImpl(KObjectType.t_long, b, 1);
//            }
//        });
//        objectFactories.put(Double.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                double v = (Double) javaObject;
//                byte[] b = new byte[8];
//                KMemoryUtilities.double2byteArray(v, b, 0);
//                return new KObjectImpl(KObjectType.t_double, b, 1);
//            }
//        });
//        objectFactories.put(Float.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                float v = (Float) javaObject;
//                byte[] b = new byte[4];
//                KMemoryUtilities.float2byteArray(v, b, 0);
//                return new KObjectImpl(KObjectType.t_float, b, 1);
//            }
//        });
//        objectFactories.put(Byte.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                byte v = (Byte) javaObject;
//                byte[] b = new byte[1];
//                KMemoryUtilities.byte2byteArray(v, b, 0);
//                return new KObjectImpl(KObjectType.t_byte, b, 1);
//            }
//        });
//        objectFactories.put(Character.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                char v = (Character) javaObject;
//                byte[] b = new byte[2];
//                KMemoryUtilities.char2byteArray(v, b, 0);
//                return new KObjectImpl(KObjectType.t_char, b, 1);
//            }
//        });
//        objectFactories.put(Boolean.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                boolean v = (Boolean) javaObject;
//                byte[] b = new byte[1];
//                KMemoryUtilities.boolean2byteArray(v, b, 0);
//                return new KObjectImpl(KObjectType.t_boolean, b, 1);
//            }
//        });
//        objectFactories.put(KReference.class, new KObjectFactory() {
//
//            public KObject createObject(Object javaObject) {
//                KReference value = (KReference) javaObject;
//                byte[] b = new byte[16];
//                KMemoryUtilities.ref2byteArray(value, b, 0);
//                return new KObjectImpl(KObjectType.t_ref, b, 1);
//            }
//        });
        registerFactories = new HashMap<Class, KRegisterFactory>();
        KRegisterFactory reg = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return (KRegister) javaObject;
            }
        };
        KRegisterFactory INT = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return new KInteger((Integer) javaObject);
            }
        };
        KRegisterFactory LONG = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return new KLong((Long) javaObject);
            }
        };
        KRegisterFactory SHORT = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return new KShort((Short) javaObject);
            }
        };
        KRegisterFactory DOUBLE = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return new KDouble((Double) javaObject);
            }
        };
        KRegisterFactory FLOAT = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return new KFloat((Float) javaObject);
            }
        };
        KRegisterFactory CHARACTER = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return new KChar((Character) javaObject);
            }
        };
        KRegisterFactory BOOLEAN = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return KBoolean.valueOf((Boolean) javaObject);
            }
        };
        KRegisterFactory BYTE = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return KByte.valueOf((Byte) javaObject);
            }
        };
        KRegisterFactory VOID = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return null;
            }
        };
        KRegisterFactory STRING = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                return memorySegment.allocString(((String) javaObject));
            }
        };
        KRegisterFactory BYTE_ARR_ARR = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                byte[][] v = (byte[][]) javaObject;
                KClass byteClass = memorySegment.getProcess().getClassRepository().getClassByName("byte");
                KClass byteArr1Class = memorySegment.getProcess().getClassRepository().getArrayClass(byteClass, 1);
                KClass byteArr2Class = memorySegment.getProcess().getClassRepository().getArrayClass(byteClass, 2);
                KReference arr = memorySegment.allocArray(byteArr2Class, v.length);
                for (int i = 0; i < v.length; i++) {
                    byte[] bs = v[i];
                    KReference arr2 = memorySegment.allocArray(byteArr1Class, bs.length);
                    memorySegment.setByteArray(arr2.pointer, 0, bs, 0, bs.length);
                    memorySegment.setReferenceArray(arr.pointer, i, arr2);
                }
                return arr;
            }
        };

        KRegisterFactory STRING_ARR = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                String[] v = (String[]) javaObject;
                if (javaObject == null) {
                    return KReference.NULL;
                }
                StringArrayAdapter a = new StringArrayAdapter(memorySegment.getProcess(), v);
                return a.getReference();
            }
        };

        KRegisterFactory INT_ARR = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                int[] v = (int[]) javaObject;
                if (javaObject == null) {
                    return KReference.NULL;
                }
                KReference kReference = memorySegment.allocIntArray(v.length);
                memorySegment.setIntArray(kReference.pointer, v);
                return kReference;
            }
        };

        KRegisterFactory LONG_ARR = new KRegisterFactory() {

            public KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
                long[] v = (long[]) javaObject;
                if (javaObject == null) {
                    return KReference.NULL;
                }
                KReference kReference = memorySegment.allocLongArray(v.length);
                memorySegment.setLongArray(kReference.pointer, v);
                return kReference;
            }
        };

        registerFactories.put(KRegister.class, reg);
        registerFactories.put(KBoolean.class, reg);
        registerFactories.put(KByte.class, reg);
        registerFactories.put(KChar.class, reg);
        registerFactories.put(KDouble.class, reg);
        registerFactories.put(KFloat.class, reg);
        registerFactories.put(KInteger.class, reg);
        registerFactories.put(KLong.class, reg);
        registerFactories.put(KReference.class, reg);
        registerFactories.put(KShort.class, reg);
        registerFactories.put(Integer.class, INT);
        registerFactories.put(Integer.TYPE, INT);
        registerFactories.put(Long.class, LONG);
        registerFactories.put(Long.TYPE, LONG);
        registerFactories.put(Short.class, SHORT);
        registerFactories.put(Short.TYPE, SHORT);
        registerFactories.put(Double.class, DOUBLE);
        registerFactories.put(Double.TYPE, DOUBLE);
        registerFactories.put(Float.class, FLOAT);
        registerFactories.put(Float.TYPE, FLOAT);
        registerFactories.put(Character.class, CHARACTER);
        registerFactories.put(Character.TYPE, CHARACTER);
        registerFactories.put(Byte.class, BYTE);
        registerFactories.put(Byte.TYPE, BYTE);
        registerFactories.put(Boolean.class, BOOLEAN);
        registerFactories.put(Boolean.TYPE, BOOLEAN);
        registerFactories.put(String.class, STRING);
        registerFactories.put(byte[][].class, BYTE_ARR_ARR);
        registerFactories.put(Void.TYPE, VOID);
        registerFactories.put(String[].class, STRING_ARR);
        registerFactories.put(int[].class, INT_ARR);
        registerFactories.put(long[].class, LONG_ARR);
    }

    private KUtils() {
    }

    /**
     * convert the given javaObject to the most appropriate KRegister.
     * <p/>
     * <p>When javaObject is null, KReference.NULL will be returned.
     * <p>When javaObject is a String, a String will be allocated and the relative reference will be returned.
     * <p>When javaObject is a java primitive type (i.e int,Integer), the corresponding KRegister will be returned (i.e. KInteger)
     * <p>When javaObject is a KRegister, the instance it self will be returned
     *
     * @param javaObject the java object to convert
     * @param memorySegment
     * @return a valid KRegister
     * @throws RemoteException    if allocation of string fails
     * @throws ClassCastException javaObject has a non supported type and is not already a KRegister
     */
    public static KRegister toRegister(Object javaObject, KMemorySegment memorySegment) throws RemoteException {
        if (javaObject == null) {
            return KReference.NULL;
        }
        try {
            return registerFactories.get(javaObject.getClass()).toRegister(javaObject, memorySegment);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Unsupported type " + javaObject.getClass(), e);
        }
    }

    public static KRegisterFactory toRegisterFactory(Class clazz) {
        KRegisterFactory f = registerFactories.get(clazz);
        if (f == null) {
            throw new IllegalArgumentException("RegisterFactory not found for " + clazz);
        }
        return f;
    }

//    public static KObject createObject(Object javaObject) {
//        if (javaObject == null) {
//            return NULL_OBJECT;
//        }
//        try {
//            return objectFactories.get(javaObject.getClass()).createObject(javaObject);
//        } catch (NullPointerException e) {
//            throw new IllegalArgumentException("Unsupported type " + javaObject.getClass());
//        }
////        if (javaObject instanceof Integer) {
////        } else if (javaObject instanceof Long) {
////        } else if (javaObject instanceof Double) {
////        } else if (javaObject instanceof Float) {
////        } else if (javaObject instanceof Byte) {
////        } else if (javaObject instanceof Character) {
////        } else if (javaObject instanceof Boolean) {
//////        } else if (javaObject instanceof int[]) {
//////            int[] value = (int[]) javaObject;
//////            return new DObjectImpl(DClassRef.INTEGER_ARRAY, DMemoryUtils.intArray2byteArray(value), value.length);
//////        } else if (javaObject instanceof long[]) {
//////            long[] value = (long[]) javaObject;
//////            return new DObjectImpl(DClassRef.LONG_ARRAY, DMemoryUtils.longArray2byteArray(value), value.length);
//////        } else if (javaObject instanceof double[]) {
//////            double[] value = (double[]) javaObject;
//////            return new DObjectImpl(DClassRef.DOUBLE_ARRAY, DMemoryUtils.doubleArray2byteArray(value), value.length);
//////        } else if (javaObject instanceof float[]) {
//////            float[] value = (float[]) javaObject;
//////            return new DObjectImpl(DClassRef.FLOAT_ARRAY, DMemoryUtils.floatArray2byteArray(value), value.length);
//////        } else if (javaObject instanceof boolean[]) {
//////            boolean[] value = (boolean[]) javaObject;
//////            return new DObjectImpl(DClassRef.BOOLEAN_ARRAY, DMemoryUtils.booleanArray2byteArray(value), value.length);
//////        } else if (javaObject instanceof char[]) {
//////            char[] value = (char[]) javaObject;
//////            return new DObjectImpl(DClassRef.CHAR_ARRAY, DMemoryUtils.charArray2byteArray(value), value.length);
//////        } else if (javaObject instanceof byte[]) {
//////            byte[] value = (byte[]) javaObject;
//////            return new DObjectImpl(DClassRef.BYTE_ARRAY, DMemoryUtils.byteArray2byteArray(value), value.length);
//////        } else if (javaObject instanceof DRegisterString) {
//////            DRegisterString value = (DRegisterString) javaObject;
//////            byte[] b = new byte[16];
//////            DMemoryUtils.string2byteArray(value, b, 0);
//////            return new DObjectImpl(DObjectType.t_string, b, 1);
////        } else if (javaObject instanceof KReference) {
////        } else {
////        }
//    }

//    public static DObject createCharArray(char[] content) {
//        return new DObjectImpl(DClassRef.CHAR_ARRAY, DMemoryUtils.charArray2byteArray(content),content.length);
//    }
//    public static KObject createReference(KReference ref) {
//        byte[] refBytes = new byte[16];
//        DMemoryUtils.ref2byteArray(ref, refBytes, 0);
//        return new KObjectImpl(KObjectType.t_ref, refBytes, 1);
//    }
    /**
     * TODO FIXME classRef not used!!
     *
     * @param content
     * @param arraySize
     * @return
     */
//    public static KObject createObject(byte[] content, int arraySize) {
//        return new KObjectImpl(KObjectType.t_obj, content, arraySize);
//    }

    public static boolean isNull(KClass classReference, byte[] content) {
        if (classReference.getType() == KObjectType.t_ref) {
            if (content.length == 0) {
                return false;
            }
            for (byte b : content) {
                if (b != 0xFF) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isNullBytes(byte[] content) {
        for (byte b : content) {
            if (b != 0xFF) {
                return false;
            }
        }
        return true;
    }

    public static String shellToRegexpPattern(String dosLikePattern) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < dosLikePattern.length(); i++) {
            char c = dosLikePattern.charAt(i);
            switch (c) {
                case '*': {
                    sb.append(".*");
                    break;
                }
                case '?': {
                    sb.append(".");
                    break;
                }
                case '.': {
                    sb.append("\\.");
                    break;
                }
                case ')': {
                    sb.append("\\)");
                    break;
                }
                case '(': {
                    sb.append("\\(");
                    break;
                }
                case '\\': {
                    sb.append("\\");
                    i++;
                    c = dosLikePattern.charAt(i);
                    sb.append(c);
                    break;
                }
                default: {
                    sb.append(c);
                    break;
                }
            }
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        Hashtable<String, KEnvInfo> env=new Hashtable<String, KEnvInfo>();
//        env.put("z", new KEnvInfo("z", "$ms$m", true));
//        env.put("k", new KEnvInfo("k", "$z", true));
//        env.put("m", new KEnvInfo("m", "M", true));
//        System.out.println(expandEnv("toto${z}/$m/d", env));
//    }
    public static String expandEnv(String value, Properties env) {
        return expandEnv0(value, env, new ExpandEnvCounter());
    }

    private static class ExpandEnvCounter {

        int count = 0;
    }

    private static String expandEnv0(String value, Properties env, ExpandEnvCounter h) {
        h.count++;
        if (h.count > 1000) {
            throw new IllegalArgumentException("Too many recursion");
        }
        StringBuilder sb = new StringBuilder();
        char[] valueChars = value.toCharArray();
        for (int i = 0; i < valueChars.length; i++) {
            char c = valueChars[i];
            switch (c) {
                case '\\': {
                    i++;
                    c = valueChars[i];
                    sb.append(c);
                    break;
                }
                case '$': {
                    i++;
                    c = valueChars[i];
                    StringBuilder v = new StringBuilder();
                    if (c == '{') {
                        i++;
                        for (; i < valueChars.length; i++) {
                            c = valueChars[i];
                            if (c == '}') {
                                break;
                            } else {
                                v.append(c);
                            }
                        }
                    } else {
                        v.append(c);
                        i++;
                        for (; i < valueChars.length; i++) {
                            c = valueChars[i];
                            if (Character.isLetterOrDigit(c) || c == '_') {
                                v.append(c);
                                break;
                            } else {
                                i--;
                                break;
                            }
                        }
                    }
                    String ev = env.getProperty(v.toString());
                    if (ev != null) {
                        sb.append(expandEnv0(ev, env, h));
                    } else {
                        System.out.println("not found \"" + v + "\"");
                    }
                    break;
                }
                default: {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static String[] findPaths(String parent, String pathPattern) throws RemoteException {
        String s = KFilePath.canonicalize(parent, pathPattern);
        final String n = new KFilePath(s).getName();
        String p = s.substring(0, s.length() - n.length() - 1);
        if (n.contains("*")) {
            final Pattern pa = Pattern.compile(KUtils.shellToRegexpPattern(n));
            Collection<KResource> resources = Doovos.getSystem().getFileSystemManager().list(p, new KPathFilter() {

                public boolean accept(String path) {
                    Matcher m = pa.matcher(new KFilePath(path).getName());
                    return m.matches();
                }
            });
            String[] ret = new String[resources.size()];
            int i = 0;
            for (KResource r : resources) {
                ret[i] = r.getPath();
                i++;
            }
            return ret;
        }
        return new String[]{s};
    }

    public static RuntimeException toRuntimeException(Throwable e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        return new RuntimeException(e.getMessage(), e);
    }

    public static void logStackTrace(String title, String prefix, KFrame frame) throws RemoteException {
        System.err.println(prefix + title);
        KLocalThread threadLocal = frame.getThread();
        int count = threadLocal.getFramesCount();
        for (int i = 0; i < count; i++) {
            KFrame f = threadLocal.getFrame(i);
            System.err.println(prefix + f.getMethod().getDefinition().getAbsoluteSignature());
        }
    }
//    public static String getPathExtension(String path) {
//        int x = path.lastIndexOf("/");
//        if (x < 0) {
//            x = 0;
//        }
//        int y = path.indexOf(".", x + 1);
//        if (y < 0) {
//            return "";
//        } else {
//            return path.substring(y + 1);
//        }
//    }
    
    
 public static <T> T resolveInstance(String name, Properties envs, Class<T> defaultImpl) throws RemoteException {
        String value = resolveProperty(name, envs);
        T ii = null;
        if (value != null) {
            try {
                ii = (T) Class.forName(value).newInstance();
            } catch (Exception ex) {
                try {
                    ii = (T) Class.forName(value).getConstructor(Properties.class).newInstance(envs);
                } catch (Exception ex2) {
                    throw new IllegalArgumentException("Unable to create " + name + " : '" + value + "' caused by Invalid '" + name + "' env : " + ex, ex);
                }
            }
        }
        if (ii == null) {
            try {
                //            System.out.println("Default Interpreter : SWITCH");
                ii = defaultImpl.newInstance();
            } catch (Exception ex) {
                throw new IllegalArgumentException("Unable to create " + name + " : '" + value + "' caused default instance '" + defaultImpl.getSimpleName() + "' " + ex, ex);
            }
        }
        return ii;
    }

    public static String resolveProperty(String name, Properties envs) throws RemoteException {
        String v = envs.getProperty(name);
        if (v == null) {
            v = System.getProperty(name);
        }
        return v;
    }    
}
