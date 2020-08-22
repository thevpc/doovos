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
package org.doovos.kernel.core.jvm.reflect;

import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.core.util.KUtils;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.doovos.kernel.api.jvm.reflect.KLocalClassRepository;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

public class KClassRepositoryImpl extends KPrefixedPathRuntimeResourceImpl implements KLocalClassRepository {
    private Map<String, ClassSpecWrapper> stringMapping = new HashMap<String, ClassSpecWrapper>();
//    private LongKeyHashMap<ClassSpecWrapper> longMapping = new LongKeyHashMap<ClassSpecWrapper>();
    private long offset = 0;
    private KClassLoader classLoader;
    private KMemorySegment classMemorySegment;
    private KClassMap classMap = new KClassMap();
    private KClass classClass;
    private final Map<String, KClass> primitiveClassRefsByName = new HashMap<String, KClass>();


    public KClassRepositoryImpl() throws RemoteException {
        super(KResourceType.CLASS_REPOSITORY, true,DoovosConstants.CLASS_REPOSITORY_PATH, null, null);
    }

    public void init(KClassLoader classLoader, KMemorySegment classMemorySegment, Properties newEnvArray) throws RemoteException {
        this.classMemorySegment = classMemorySegment;
        this.classLoader = classLoader;

        for (KObjectType type : KObjectType.PRIMITIVE_TYPES) {
            createPrimitive(type);
        }

        for (KObjectType type : KObjectType.PRIMITIVE_TYPES) {
            KClass clazz = primitiveClassRefsByName.get(type.getName());

            // could not call defineClass because ??
            //defineKClass(clazz);

            classMap.registerClass(clazz);
//            if (!clazz.isPrimitive()) {
//                clazz.setStaticReference(classMemorySegment.allocClass(clazz));
//            }
        }

        String stringClassName = "java.lang.String";
        KClassDef stringClassDef = getClassDef(stringClassName);
        KClass stringClass = new KClass(stringClassDef);
        classMap.registerClass(stringClass);

        String classClassName = "java.lang.Class";
        KClassDef classClassDef = getClassDef(classClassName);
        classClass = new KClass(classClassDef);
        classMap.registerClass(classClass);

        classMemorySegment.prepare();
        for (KObjectType type : KObjectType.PRIMITIVE_TYPES) {
            KClass clazz = primitiveClassRefsByName.get(type.getName());

            clazz.setGuestReference(classMemorySegment.allocObject(classClass));
            classMap.registerRegisterReference(clazz);
            KClassDef clsDef = clazz.getDefinition();
            Object[] constantsPoolDef = clsDef.getConstantsPool();
            KRegister[] constantsPool = new KRegister[constantsPoolDef.length];
            for (int i = 0; i < constantsPool.length; i++) {
                Object o = constantsPoolDef[i];
                constantsPool[i] = KUtils.toRegister(o, classMemorySegment);
            }
            clazz.setConstantsPool(constantsPool);
        }
        defineClass(stringClass);
        defineClass(classClass);
    }

    public KClass getClassByGuestReference(KReference reference) throws RemoteException {
        KClass kClass = classMap.forReference(reference);
        if (kClass != null) {
            return kClass;
        }
        throw new KClassNotFoundException(reference.toString(), 0);
    }


    private KClass createPrimitive(KObjectType type) throws RemoteException {
        KClass kClass = new KClass(classLoader.loadClass(type.getName()),type);
        primitiveClassRefsByName.put(type.getName(), kClass);
        return kClass;
    }

//    private KClass createPrimitiveArray(KObjectType type) {
//        return new KClass(this,type, KObjectType.t_ref.getByteSize(), 1, null, null);
//    }

    public KClassDef getClassDef(String name) throws RemoteException {
        ClassSpecWrapper w = getClassWrapper(name);
        if (w != null) {
            return w.value;
        }
        throw new KClassNotFoundException(name);
    }

    private ClassSpecWrapper getClassWrapper(String name) throws RemoteException {
//        name=name.replace('/','.');
        ClassSpecWrapper all = stringMapping.get(name);
        if (all != null) {
            return all;
        }
        KClassDef x = classLoader.loadClass(name);
        return defineClassDef(x);
    }

//    public KClassDef getClassDef(long offset) throws RemoteException {
//        ClassSpecWrapper wrapper = longMapping.get(offset);
//        return wrapper.value;
//    }

//    public static KResource findClassResource(String name, String bootstrapClassPath, long version) throws KInvalidByteCodeImageException, KClassNotFoundException {
//        try {
//            String[] paths;
//            //String name0=name.replace('/','.');
//            String name0 = name;
//            String namePath = name.replace('.', '/');
//            paths = bootstrapClassPath.split(":");
//            for (String path : paths) {
//                if (path != null) {
//                    KResource r = null;
////                    Doovos.getResourceLenient(new DPath(path + "/" + namePath + ".dasm"));
////                    if (r != null && r instanceof KFile) {
////                        KClassDef cbc;
////                        try {
////                            cbc = KASMUtils.compileAssemblerClass((KFile) r);
////                        } catch (KDefinitionParseException e) {
////                            throw new KInvalidByteCodeImageException(e);
////                        }
////                        if (!cbc.getName().equals(name0)) {
////                            throw new KInvalidByteCodeImageException("Expected class name " + name0 + " but found " + cbc.getName());
////                        }
////                        return r;
////                    }
//                    KResource ff = Doovos.getResourceLenient(path);
//                    if (ff != null && ff instanceof KFile) {
//                        KFile kff = (KFile) ff;
//                        if (kff.isDirectory()) {
//                            r = Doovos.getResourceLenient((path + "/" + namePath + ".class"));
//                            if (r != null && r instanceof KFile) {
//                                KClassDef cbc = JavaByteCodeLoader.loadClass((KFile) r);
//                                if (!cbc.getName().equals(name)) {
//                                    throw new IllegalArgumentException("Expected class name " + name + " but found " + cbc.getName());
//                                }
//                                return r;
//                            }
//                        } else if (kff.isFile()) {
//                            FileCache fc=new FileCache(kff);
//                            ZipInputStream zis=new ZipInputStream(kff.openInputStream().getInputStream());
//                            zis.
//                        }
//                    }
//
////                    r = Doovos.getResourceLenient(new DPath(path + "/" + namePath));
////                    if (r != null && r instanceof KFile) {
////                        KClassDef cbc = KASMUtils.loadClass((KFile) r);
////                        return r;
////                    }
//
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        throw new KClassNotFoundException(name, version);
//    }


    private static class ClassSpecWrapper {
        private ClassSpecWrapper() {
        }

        long version;
//        long offset;
        long subOffset;
        String sid;
        String name;
        KClassDef value;
    }

    private ClassSpecWrapper defineClassDef(KClassDef dclass) throws RemoteException {
        //TODO FIX ME check if exists
        ClassSpecWrapper w = new ClassSpecWrapper();
//        w.offset = offset++;
        w.name = dclass.getName();
        w.sid = dclass.getId();
        w.value = dclass;
        w.version = dclass.getVersion();
//        dclass.setClassId(w.offset);
//        ClassSpecWrapper wrappers = stringMapping.get(w.name);
//        if (wrappers != null) {
//            throw new RuntimeException("Already defined "+)
//            ClassSpecWrapper[] wrappers2 = new ClassSpecWrapper[wrappers.length + 1];
//            System.arraycopy(wrappers, 0, wrappers2, 0, wrappers.length);
//            wrappers2[wrappers.length] = w;
//            stringMapping.put(w.name, wrappers2);
//        } else {
//            stringMapping.put(w.name, new ClassSpecWrapper[]{w});
//        }
        stringMapping.put(w.name, w);
//        longMapping.put(w.offset, w);
        //classDefs.put(dclass.getName(), dclass);
        return w;
    }


    public KClass getClassByName(String name) throws RemoteException {
        KClass kClass = classMap.forName(name);
        if (kClass != null) {
            return kClass;
        }
        char[] all = name.toCharArray();
        int array = 0;
        while (all[array] == '[') {
            array++;
        }
        if (array > 0) {
            int length = all.length;
            if (all[length - 1] == ';') {
                int count = length - 1;
                for (int i = array + 1; i < count; i++) {
                    if (all[i] == '/') {
                        all[i] = '.';
                    }
                }
                return getClassArrayByName(new String(all, array + 1, count - array - 1), array);
            } else {
                int typeLength = length - array;
                String name2 = new String(all, array, typeLength);
                name2 = KObjectType.resolveByCode(name2).getName();
                return getClassArrayByName(name2, array);
            }
        } else {
            KClassDef classDef = getClassDef(name);
            KClass dcr = new KClass(classDef);
            defineClass(dcr);
            //load super class first
//            String superClassName = classDef.getSuperClassName();
//            if (superClassName != null) {
//                getClassByName(superClassName, KClassDef.NO_VERSION);
//            }
            return dcr;
        }
    }

//    public KClass getClassByName(String name) throws RemoteException {
//        return getClassByName(name, KClassDef.NO_VERSION);
//    }

    public KClass getClassArrayByName(String name, int array) throws RemoteException {
        KClass dcr;
        dcr = classMap.forName(name);
        if (dcr == null) {
            KClassDef classDef = getClassDef(name);
            dcr = new KClass(classDef);
            defineClass(dcr);
//            //load super class first
//            String superClassName = classDef.getSuperClassName();
//            if (superClassName != null) {
//                getClassByName(superClassName, KClassDef.NO_VERSION);
//            }
        }

        if (array > 0) {
            return getClassArrayByClass(dcr, array);
        } else {
            return dcr;
        }
    }

    /**
     *
     * @param dcr
     * @param array  array depth positive (>0)
     * @return
     * @throws RemoteException
     */
    private KClass getClassArrayByClass(KClass dcr, int array) throws RemoteException {
        String en = dcr.getEncodedName();
        char[] ens = en.toCharArray();
        char[] enchars = new char[en.length() + array];
        int i = array - 1;
        while (i >= 0) {
            enchars[i] = '[';
            i--;
        }
        System.arraycopy(ens, 0, enchars, array, ens.length);
        String encodedString = new String(enchars);
        KClass dcr2 = classMap.forName(encodedString);
        if (dcr2 == null) {
            for (int j = array; j < enchars.length; j++) {
                if (enchars[j] == '.') {
                    enchars[j] = '/';
                }
            }
            String encodedPath = new String(enchars);
            dcr2 = new KClass(encodedString, encodedString, encodedPath, dcr.getType(), dcr.getByteSize(), array, dcr.getDefinition());
            defineClass(dcr2);
            dcr2.setInitialized(true);
//                dcr2.link(this);
        }
        return dcr2;
    }

    private void defineClass(KClass clazz) throws RemoteException {
        classMap.registerClass(clazz);
        clazz.setRepository(this);
        if (!clazz.isPrimitive()) {
//            Doovos.getLog().debug("defineClass " + clazz.getName());
            clazz.setStaticReference(classMemorySegment.allocClass(clazz));
        }
        clazz.setGuestReference(classMemorySegment.allocObject(classClass));
        classMap.registerRegisterReference(clazz);
        KClassDef clsDef = clazz.getDefinition();
        KRegister[] constantsPool = new KRegister[clsDef.getConstantsPoolSize()];
        for (int i = 0; i < constantsPool.length; i++) {
            Object o = clsDef.getConstant(i);
            constantsPool[i] = KUtils.toRegister(o, classMemorySegment);
        }
        clazz.setConstantsPool(constantsPool);
        clazz.defined();
    }

//    public KClassDef getClassDefByName(String className) throws RemoteException {
//        return getClassDefByName(className, KClassDef.NO_VERSION);
//    }

//    public KClassDef getClassDefByName(String className, long version) throws RemoteException {
//        KClass cr = getClassByName(className, version);
//        return cr.getDefinition();
//    }

//    public DClassByteCode defineClass(DClassByteCode classBytcode) throws RemoteException {
//        getClassRepository().defineClass(classBytcode);
//        processClasses.put(classBytcode.getName(),classBytcode);
//        classBytcode.link(this);
//        processClasseRefs.put(classBytcode.getName(),classBytcode.getClassRef());
//        return classBytcode;
//    }

//    public KClass createReference(KClass classRef) throws RemoteException {
//        KClass kClass = new KClass(this,KObjectType.t_ref, KObjectType.t_ref.getByteSize(), 0, classRef, classRef.getDefinition());
//        defineKClass(kClass);
//        return kClass;
//    }

//    public KClass createObject(KClassDef cls) throws RemoteException {
//        KClass kClass = new KClass(this, KObjectType.t_obj, cls.getInstanceSize(), 0, null, cls);
//        defineKClass(kClass);
//        return kClass;
//    }

    public KClass getArrayClass(KClass clazz, int depth) throws RemoteException {
        if (clazz.isPrimitive()) {
            return getClassArrayByName(clazz.getType().getName(), depth);
        } else {
            return getClassArrayByName(clazz.getDefinition().getName(), depth);
        }
    }
//    public KClass getArrayClassRef(KClass ref, int arrayDepth) throws RemoteException {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < arrayDepth; i++) {
//            sb.append("[");
//        }
//        sb.append(ref.getEncodedName());
//        return getClassArrayByName(ref.getDefinition().getName(), ref.getArrayDepth() + arrayDepth, KClassDef.NO_VERSION);
//    }
}
