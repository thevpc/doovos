///**
// * ====================================================================
// *             Doovos (Distributed Object Oriented Operating System)
// *
// * Doovos is a new Open Source Distributed Object Oriented Operating System
// * Design and implementation based on the Java Platform.
// * Actually, it is a try for designing a distributed operation system in
// * top of existing centralized/network OS.
// * Designed OS will follow the object oriented architecture for redefining
// * all OS resources (memory,process,file system,device,...etc.) in a highly
// * distributed context.
// * Doovos is also a distributed Java virtual machine that implements JVM
// * specification on top the distributed resources context.
// *
// * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
// * Doovos Kernel code is executed on host JVM
// *
// * Copyright (C) 2008-2010 Taha BEN SALAH
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc.,
// * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// * ====================================================================
// */
//package org.doovos.kernel.depreciated.jvm.bytecodeloader.v1;
//
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.jvm.bytecode.KClassDef;
//import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
//import org.doovos.kernel.api.jvm.bytecode.KMetaDataDef;
//import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DClassByteCodeInfo {
//
//    private int modifiers;
//    private String name;
//    private long version;
//    private List<KMetaDataDef> metaDataInfos = new ArrayList<KMetaDataDef>();
//    private List<DFieldByteCodeInfo> fields = new ArrayList<DFieldByteCodeInfo>();
//    private List<DMethodByteCodeInfo> methods = new ArrayList<DMethodByteCodeInfo>();
//    private List<Object> constantsPool = new ArrayList<Object>();
//    private String superClassName;
//    private List<String> superInterfaceNames = new ArrayList<String>();
//
//    public DClassByteCodeInfo() {
//    }
//
//    public int getModifiers() {
//        return modifiers;
//    }
//
//    public void setModifiers(int modifiers) {
//        this.modifiers = modifiers;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public long getVersion() {
//        return version;
//    }
//
//    public void setVersion(long version) {
//        this.version = version;
//    }
//
//    public List<KMetaDataDef> getMetaDataInfos() {
//        return metaDataInfos;
//    }
//
//    public void setMetaDataInfos(List<KMetaDataDef> metaDataInfos) {
//        this.metaDataInfos = metaDataInfos;
//    }
//
//    public List<DFieldByteCodeInfo> getFields() {
//        return fields;
//    }
//
//    public void setFields(List<DFieldByteCodeInfo> fields) {
//        this.fields = fields;
//    }
//
//    public List<DMethodByteCodeInfo> getMethods() {
//        return methods;
//    }
//
//    public void setMethods(List<DMethodByteCodeInfo> methods) {
//        this.methods = methods;
//    }
//
//    public List<Object> getConstantsPool() {
//        return constantsPool;
//    }
//
//    public void addConstant(Object javaObject) {
//        if (javaObject == null) {
//        } else if (javaObject instanceof KRegister) {
//        } else if (javaObject instanceof Integer) {
//        } else if (javaObject instanceof Long) {
//        } else if (javaObject instanceof Boolean) {
//        } else if (javaObject instanceof Byte) {
//        } else if (javaObject instanceof Character) {
//        } else if (javaObject instanceof Double) {
//        } else if (javaObject instanceof Float) {
//        } else if (javaObject instanceof Short) {
//        } else if (javaObject instanceof String) {
//        } else {
//            javaObject = (KRegister) javaObject;
//        }
//        constantsPool.add(javaObject);
//    }
//
//    public String getSuperClassName() {
//        return superClassName;
//    }
//
//    public void setSuperClassName(String superClassName) {
//        this.superClassName = superClassName;
//    }
//
//    public List<String> getSuperInterfaceNames() {
//        return superInterfaceNames;
//    }
//
//    public void setSuperInterfaceNames(List<String> superInterfaceNames) {
//        this.superInterfaceNames = superInterfaceNames;
//    }
//
//    public KClassDef toClassDef() {
//        KFieldDef[] a = new KFieldDef[fields.size()];
//        int i;
//        i=0;
//        for (DFieldByteCodeInfo f : fields) {
//            a[i++] = f.toFieldDef(name);
//        }
//        KMethodDef[] m = new KMethodDef[methods.size()];
//        i=0;
//        for (DMethodByteCodeInfo mm : methods) {
//            m[i++] = mm.toMethodDef(name);
//        }
//        return new KClassDef(
//                name,
//                version,
//                modifiers,
//                superClassName,
//                superInterfaceNames.toArray(new String[superInterfaceNames.size()]),
//                metaDataInfos.toArray(new KMetaDataDef[metaDataInfos.size()]),
//                a,
//                m,
//                constantsPool.toArray()
//        );
//    }
//}