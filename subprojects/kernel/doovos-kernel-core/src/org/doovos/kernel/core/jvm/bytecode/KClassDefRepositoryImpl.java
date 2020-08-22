package org.doovos.kernel.core.jvm.bytecode;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.filesystem.KFolder;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.jvm.bytecode.*;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.core.jvm.reflect.KClassLoaderFolder;
import org.doovos.kernel.core.jvm.reflect.KClassLoaderZipJar;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.doovos.kernel.api.factory.KMemoryFactory;

public class KClassDefRepositoryImpl implements KClassDefRepository {

    private static JavaByteCodeLoader bytecodeLoader = new ASMJavaByteCodeLoader();
    //    private static SecureRandom random = new SecureRandom();
    private Map<String, ClassPathItem> items = new HashMap<String, ClassPathItem>();
    private Map<String, KClassDef> nativeClasses = new HashMap<String, KClassDef>();
    private KMemoryFactory memoryFactory;

    private final static class ClassPathItem {

        private ClassPathItem(String path) {
            this.path = path;
        }
        private String path;
        private long lastModified;
        private KClassLoader classLoader;
        private Map<String, KClassDef> classes = new HashMap<String, KClassDef>();

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ClassPathItem item = (ClassPathItem) o;

            if (classLoader != null ? !classLoader.equals(item.classLoader) : item.classLoader != null) {
                return false;
            }
            if (path != null ? !path.equals(item.path) : item.path != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = path != null ? path.hashCode() : 0;
            result = 31 * result + (classLoader != null ? classLoader.hashCode() : 0);
            return result;
        }
    }

    public KClassDefRepositoryImpl(KMemoryFactory memoryFactory) {
        this.memoryFactory = memoryFactory;
        registerNativeClasses();
    }

    private void register(String path) {
        ClassPathItem pathItem = items.get(path);
        if (pathItem == null) {
            pathItem = new ClassPathItem(path);
            boolean ok = false;
            try {
                KResource r = Doovos.getSystem().getFileSystemManager().find(path);
                if (r != null) {
                    if (r instanceof KFile) {
                        KFile file = (KFile) r;
                        pathItem.lastModified = file.lastModified();
                        pathItem.classLoader = new KClassLoaderZipJar(path, file, bytecodeLoader);
                        ok = true;
                    } else if (r instanceof KFolder) {
                        KFolder folder = (KFolder) r;
                        pathItem.lastModified = folder.lastModified();
                        pathItem.classLoader = new KClassLoaderFolder(path, folder, bytecodeLoader);
                        ok = true;
                    }
                }
            } catch (IOException ee) {
                //ignore
            }
            if (ok) {
                items.put(path, pathItem);
            }
        } else {
            //should reload??
            try {
                KResource r = Doovos.getSystem().getFileSystemManager().find(path);
                if (r != null) {
                    if (r instanceof KFile) {
                        KFile file = (KFile) r;
                        long lastModified = file.lastModified();
                        if (lastModified > pathItem.lastModified) {
                            pathItem.lastModified = file.lastModified();
                            pathItem.classLoader = new KClassLoaderZipJar(path, file, bytecodeLoader);
                        }
                    }
                }
            } catch (IOException ee) {
                //ignore
            }
        }
    }

    public synchronized void register(String[] bootstrapClassLoaders) throws KClassNotFoundException {
        for (String bootstrapClassLoader : bootstrapClassLoaders) {
            register(bootstrapClassLoader);
        }
    }

    public KClassDef getClass(String[] bootstrapClassLoaders, String name) throws KClassNotFoundException {
        KClassDef classDef = nativeClasses.get(name);
        if (classDef != null) {
            return classDef;
        }
        for (String bootstrapClassLoader : bootstrapClassLoaders) {
            ClassPathItem pathItem = items.get(bootstrapClassLoader);
            if (pathItem != null) {
                classDef = pathItem.classes.get(name);
                if (classDef != null) {
                    return classDef;
                }
                try {
                    classDef = pathItem.classLoader.loadClass(name);
                    pathItem.classes.put(name, classDef);
                    initClassDef(bootstrapClassLoaders, classDef);
                    return classDef;
                } catch (KClassNotFoundException e) {
                    //
                } catch (KInvalidByteCodeImageException e) {
                    //
                }
            }
        }
        throw new KClassNotFoundException(name);
    }

    private void initClassDef(String[] bootstrapClassLoaders, KClassDef classDef) {
        String superClassName = classDef.getSuperClassName();
        String[] superInterfaceNames = classDef.getSuperInterfaceNames();
        KClassDef superClassDef = superClassName == null ? null : getClass(bootstrapClassLoaders, superClassName);
        KClassDef[] superInterfaces;
        if (superInterfaceNames == null || superInterfaceNames.length==0) {
            superInterfaces = EmptyArray.EMPTY_ARRAY_KCLASSDEF;
        } else {
            superInterfaces = new KClassDef[superInterfaceNames.length];
            for (int i = 0; i < superInterfaceNames.length; i++) {
                String superInterfaceName = superInterfaceNames[i];
                superInterfaces[i] = getClass(bootstrapClassLoaders, superInterfaceName);
            }
        }
//        classDef.setClassId(random.nextLong());
        classDef.setSuperClass(superClassDef);
        classDef.setSuperInterfaces(superInterfaces);
        memoryFactory.prepareClassDef(classDef);
    }

    private void registerNativeClasses() {
        for (KObjectType type : KObjectType.PRIMITIVE_TYPES) {
            KClassDef def = new KClassDef(type.getName(), type.getCode(), type.getCode(), KClassDef.NO_VERSION, Modifier.PUBLIC, null, EmptyArray.STRINGS, new Properties(), EmptyArray.EMPTY_ARRAY_KFIELDDEF, EmptyArray.EMPTY_ARRAY_KMETHODDEF, EmptyArray.EMPTY_ARRAY_OBJECT);
            nativeClasses.put(type.getName(), def);
            initClassDef(null, def);
        }
    }
}
