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
package org.doovos.kernel.api.jvm.bytecode;


import java.io.Serializable;
import java.util.*;

public final class KClassDef implements Serializable {

    public static final long NO_VERSION = -1;
    private String classFileRootPath;
    private String classFilePath;
    private int modifiers;
    private String name;
    private String code;
    private String path;
    private String id;
    private long version=KClassDef.NO_VERSION;
    private Properties metaDataInfos = new Properties();
    private KFieldDef[] fields;
    private KMethodDef[] methods;
    private Object[] constantsPool;
    private String superClassName;
    private String[] superInterfaceNames;
    private KClassDef[] superInterfaces;
    private long classId;
    private int instanceSize = 0;
    private int classSize = 0;
    private KClassDef superClass = null;
    private HashMap<String, KFieldDef> fieldsByName = new HashMap<String, KFieldDef>();
//    private byte[] instancePattern;
//    private byte[] classPattern;

    public KClassDef() {
    }

    public KClassDef(String name, String code, String path,long version, int modifiers, String superClassName, String[] superInterfaceNames, Properties metaDataInfos, KFieldDef[] fields, KMethodDef[] methods, Object[] constantsPool) {
        this.name = name;
        this.code = code;
        this.path = path;
        setMethods(methods);
        setFields(fields);
        this.constantsPool = constantsPool;
        this.metaDataInfos = metaDataInfos;
        this.version = version;
        this.modifiers = modifiers;
        this.superClassName = superClassName;
        this.superInterfaceNames = superInterfaceNames;
        compile();
    }

    public void compile() {
        this.id = version + name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getPath() {
        return path;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public KFieldDef getField(int index) {
        return fields[index];
    }

    public int getFieldsCount() {
        return fields.length;
    }

    public int getMethodsCount() {
        return methods.length;
    }

    public KMethodDef getMethod(int index) {
        return methods[index];
    }

    public Object getConstant(int index) {
        return constantsPool[index];
    }

    public int getConstantsPoolSize() {
        return constantsPool.length;
    }

    public Object[] getConstantsPool() {
        return constantsPool;
    }

    

    public Properties getMetadata() {
        return metaDataInfos;
    }

    public long getVersion() {
        return version;
    }

    public int getModifiers() {
        return modifiers;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public int getSuperInterfaceCount() {
        return superInterfaceNames.length;
    }

    public String[] getSuperInterfaceNames() {
        return superInterfaceNames;
    }

    public String getSuperInterfaceName(int index) {
        return superInterfaceNames[index];
    }

    public int getByteSize() {
        return 1;
    }

    public String getId() {
        return id;
    }

    private static void long2byteArray(long value, byte[] array, int offset) {
        array[offset] = (byte) ((value >>> 56));
        array[offset + 1] = (byte) ((value >>> 48));
        array[offset + 2] = (byte) ((value >>> 40));
        array[offset + 3] = (byte) ((value >>> 32));
        array[offset + 4] = (byte) ((value >>> 24));
        array[offset + 5] = (byte) ((value >>> 16));
        array[offset + 6] = (byte) ((value >>> 8));
        array[offset + 7] = (byte) (value & 0x000000ff);
    }
//    private static final byte FF = (byte) 0xFF;
//    public static final byte[] NULL_BYTES = new byte[]{
//        FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF, FF
//    };

//    public byte[] createInstanceBytes() {
//        int len = instancePattern.length;
//        byte[] b = new byte[len];
//        System.arraycopy(instancePattern, 0, b, 0, len);
//        return b;
//    }
//
//    public byte[] createClassBytes() {
//        int len = classPattern.length;
//        byte[] b = new byte[len];
//        System.arraycopy(classPattern, 0, b, 0, len);
//        return b;
//    }
//
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KClassDef other = (KClassDef) obj;
        if (this.modifiers != other.modifiers) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.metaDataInfos == null) ? (other.metaDataInfos != null) : !this.metaDataInfos.equals(other.metaDataInfos)) {
            return false;
        }
        if (this.version != other.version) {
            return false;
        }
        if (!Arrays.deepEquals(this.fields, other.fields)) {
            return false;
        }
        if (!Arrays.deepEquals(this.methods, other.methods)) {
            return false;
        }
        if (!Arrays.deepEquals(this.constantsPool, other.constantsPool)) {
            return false;
        }
        if ((this.superClassName == null) ? (other.superClassName != null) : !this.superClassName.equals(other.superClassName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.superInterfaceNames, other.superInterfaceNames)) {
            return false;
        }
        if (!Arrays.deepEquals(this.superInterfaces, other.superInterfaces)) {
            return false;
        }
        if (this.classId != other.classId) {
            return false;
        }
        if (this.instanceSize != other.instanceSize) {
            return false;
        }
        if (this.classSize != other.classSize) {
            return false;
        }
        if (this.superClass != other.superClass && (this.superClass == null || !this.superClass.equals(other.superClass))) {
            return false;
        }
        if (this.fieldsByName != other.fieldsByName && (this.fieldsByName == null || !this.fieldsByName.equals(other.fieldsByName))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.modifiers;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (int) (this.version ^ (this.version >>> 32));
        hash = 97 * hash + (this.metaDataInfos != null ? this.metaDataInfos.hashCode() : 0);
        hash = 97 * hash + Arrays.deepHashCode(this.fields);
        hash = 97 * hash + Arrays.deepHashCode(this.methods);
        hash = 97 * hash + Arrays.deepHashCode(this.constantsPool);
        hash = 97 * hash + (this.superClassName != null ? this.superClassName.hashCode() : 0);
        hash = 97 * hash + Arrays.deepHashCode(this.superInterfaceNames);
        hash = 97 * hash + Arrays.deepHashCode(this.superInterfaces);
        hash = 97 * hash + (int) (this.classId ^ (this.classId >>> 32));
        hash = 97 * hash + this.instanceSize;
        hash = 97 * hash + this.classSize;
        hash = 97 * hash + (this.superClass != null ? this.superClass.hashCode() : 0);
        hash = 97 * hash + (this.fieldsByName != null ? this.fieldsByName.hashCode() : 0);
        return hash;
    }

//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        KClassDef that = (KClassDef) o;
//
//        if (version != that.version) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//
//        return true;
//    }
//    public int hashCode() {
//        int result;
//        result = (name != null ? name.hashCode() : 0);
//        result = 31 * result + (int) (version ^ (version >>> 32));
//        return result;
//    }
    public KFieldDef getField(String name, boolean checkSuper) {
        KFieldDef a = fieldsByName.get(name);
        if (a == null) {
            if (checkSuper && superClass != null) {
                a = superClass.findField(name, checkSuper);
                if (a == null) {
                    throw new NoSuchElementException("Field " + name + " in class " + getName());
                }
            }
        }
        return a;
    }

    public KFieldDef findField(String name, boolean checkSuper) {
        KFieldDef a = fieldsByName.get(name);
        if (a == null) {
            if (checkSuper && superClass != null) {
                a = superClass.findField(name, checkSuper);
            }
        }
        return a;
    }

    public int getClassSize() {
        return classSize;
    }

    public int getInstanceSize() {
        return instanceSize;
    }

    public KMethodDef[] getMethods() {
        return methods;
    }

    public List<KMethodDef> getConstructors() {
        ArrayList<KMethodDef> all = new ArrayList<KMethodDef>();
        for (KMethodDef method : methods) {
            if (method.isConstructor()) {
                all.add(method);
            }
        }
        return all;
    }

    public List<KMethodDef> getUserMethods() {
        ArrayList<KMethodDef> all = new ArrayList<KMethodDef>();
        for (KMethodDef method : methods) {
            if (method.isUserMethod()) {
                all.add(method);
            }
        }
        return all;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getClassId() {
        return classId;
    }

    public boolean isPrimive() {
        return superClassName == null;
    }
    private static final Set<String> PRIMITIVE_TYPE_CODES = new HashSet<String>(Arrays.asList(new String[]{"I"  , "J"   , "Z"      , "D"     , "F", "B", "C", "S"}));
    private static final Set<String> PRIMITIVE_TYPE_NAMES = new HashSet<String>(Arrays.asList(new String[]{"int", "long", "boolean", "double", "float", "byte", "char", "short"}));

    public static boolean isPrimitiveTypeCode(String typeName) {
        return PRIMITIVE_TYPE_CODES.contains(typeName);
    }

    public static boolean isPrimitiveTypeName(String typeName) {
        return PRIMITIVE_TYPE_NAMES.contains(typeName);
    }

    public KFieldDef[] getAllFields() {
        ArrayList<KFieldDef> d = new ArrayList<KFieldDef>();
        d.addAll(Arrays.asList(fields));
        if (superClass != null) {
            d.addAll(Arrays.asList(superClass.getAllFields()));
        }
        return d.toArray(new KFieldDef[d.size()]);
    }

    public KFieldDef[] getFields() {
        return fields;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public void setSuperInterfaceNames(String[] superInterfaceNames) {
        this.superInterfaceNames = superInterfaceNames;
    }

    public void setConstantsPool(Object[] constantsPool) {
        this.constantsPool = constantsPool;
    }

    public void setMethods(KMethodDef[] methods) {
        this.methods = methods;
        for (KMethodDef method : methods) {
            method.setParentClass(this);
//            String signature = method.getSignature();
        }
    }

    public void setFields(KFieldDef[] fields) {
        this.fields = fields;
        fieldsByName.clear();
        for (KFieldDef m : fields) {
            m.setParentClass(this);
            fieldsByName.put(m.getName(), m);
        }
    }

    public KClassDef getSuperClass() {
        return superClass;
    }

    public KClassDef[] getSuperInterfaces() {
        return superInterfaces;
    }

    public String getClassFileRootPath() {
        return classFileRootPath;
    }

    public void setClassFileRootPath(String classFileRootPath) {
        this.classFileRootPath = classFileRootPath;
    }

    public String getClassFilePath() {
        return classFilePath;
    }

    public void setClassFilePath(String classFilePath) {
        this.classFilePath = classFilePath;
    }

    /**
     * called by KClassDefRepository
     * @param classSize
     * @param instanceSize
     * @param superClass
     * @param superInterfaces
     */
//    public void init(int classSize, int instanceSize, byte[] classPattern, byte[] instancePattern) {
//        this.instanceSize = instanceSize;
//        this.classSize = classSize;
//        this.instancePattern = instancePattern;
//        this.classPattern = classPattern;

//        int classFieldIndex = 8;//classId
//        int instanceFieldIndex = 8;//classId
//        if (superClass != null) {
//            instanceFieldIndex = superClass.getInstanceSize();
//        }
//        int indexI = 0;
//        int indexC = 0;
//        for (KFieldDef attribute : fields) {
//            if (Modifier.isStatic(attribute.getModifiers())) {
//                attribute.setByteOffset(classFieldIndex);
//                attribute.setIndex(indexC);
//                attribute.setAbsoluteIndex(indexC + indexI);
//                indexC++;
//                classFieldIndex += attribute.getObjectType().getByteSize();
//            } else {
//                attribute.setByteOffset(instanceFieldIndex);
//                attribute.setAbsoluteIndex(indexC + indexI);
//                attribute.setIndex(indexI);
//                indexI++;
//                instanceFieldIndex += attribute.getObjectType().getByteSize();
//            }
//            fieldsByName.put(attribute.getName(), attribute);
//        }
//        
//        byte[] _instancePatternBytes = new byte[instanceSize];
//
//        long2byteArray(classId, _instancePatternBytes, 0);
//        KClassDef c = this;
//        while (c != null) {
//            for (KFieldDef f : c.fields) {
//                if (!Modifier.isStatic(f.getModifiers())) {
//                    if (!KClassDef.isPrimitiveTypeName(f.getTypeName())) {
//                        System.arraycopy(
//                                NULL_BYTES, 0, _instancePatternBytes, f.getByteOffset(), NULL_BYTES.length);
//                    }
//                }
//            }
//            c = c.superClass;
//        }
//        instancePattern=_instancePatternBytes;
//    }
    
    //    public KClassDef[] getSuperInterfaces() {
//        return superInterfaces;
//    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public void setInstanceSize(int instanceSize) {
        this.instanceSize = instanceSize;
    }

    public void setSuperClass(KClassDef superClass) {
        this.superClass = superClass;
    }

    public void setSuperInterfaces(KClassDef[] superInterfaces) {
        this.superInterfaces = superInterfaces;
    }
    
}
