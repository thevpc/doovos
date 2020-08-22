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
package org.doovos.kernel.api.jvm.reflect;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KObjectType;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import java.util.*;
import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;

import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;

public final class KClass implements Serializable {
//    public static final DClassRef STRING = createPrimitive(DObjectType.t_string);

    private String name;
    private String encodedName;
    private String encodedPath;
    private final boolean primitive;
    private KObjectType type;
    private int array;
    private int byteSize;
    private KClassDef classDef;
    private KClass superClass;
    private KClass[] interfaces;
    private KClass referenceTo;
    private KMethod classInitializerMethod;
    private KReference guestReference;
    private boolean initialized = false;
    private KRegister[] constantsPool;
    public KReference staticReference;
    public KMemorySegment staticReferenceSegment;
    private KClassRepository repository;
    private Map<String, KField> directFields;
    private Map<String, KField> allFields;
    private Map<String, KMethod> methodsBySignature;
    private Map<String, KMethod> virtualMethodsBySignature;

//    public static DClassRef createRefArray(DClassRef classRef) {
//        return new DClassRef(DObjectType.t_ref, DObjectType.t_ref.getByteSize(), 1, classRef, null);
//    }
    public KClass(KClassDef stringClassDef) throws RemoteException {
        this(stringClassDef.getName(), stringClassDef.getCode(), stringClassDef.getCode(), KObjectType.t_obj, stringClassDef.getInstanceSize(), 0, stringClassDef);
    }

    public KClass(KClassDef stringClassDef, KObjectType type) throws RemoteException {
        this(stringClassDef.getName(), stringClassDef.getCode(), stringClassDef.getCode(), type, stringClassDef.getInstanceSize(), 0, stringClassDef);
    }

    public KClass(String name, String encodedName, String encodedPath, KObjectType type, int byteSize, int array, KClassDef classDef) throws RemoteException {
//        if(classDef!=null && classDef.getName().equals("java.lang.Object")){
//            System.out.println("$$ java.lang.Object "+array);
//        }
        this.type = type;
        primitive = type.isPrimitive();
        this.array = array;
        this.byteSize = byteSize;
//        if (this.byteSize == 0) {
//            throw new IllegalArgumentException("byteSize=0");
//        }
//        if ((referenceTo != null) != (type == KObjectType.t_ref)) {
//            throw new IllegalArgumentException("referenceTo could not be specified if not a reference");
//        }
//        if (!isPrimitive() && !isRef() && classDef == null) {
//            throw new IllegalArgumentException();
//        }
        this.classDef = classDef;
        if (array == 0 && classDef != null) {
            directFields = new HashMap<String, KField>();
            allFields = new HashMap<String, KField>();
            for (KFieldDef kFieldDef : classDef.getFields()) {
                KField field = KField.newInstance(kFieldDef, this);
                directFields.put(kFieldDef.getName(), field);
                allFields.put(kFieldDef.getName(), field);
            }
        } else {
            directFields = Collections.EMPTY_MAP;
            allFields = Collections.EMPTY_MAP;
        }
        this.name = name;
        this.encodedName = encodedName;
        this.encodedPath = encodedPath;
//        if (type == KObjectType.t_ref || array > 0) {
//            name = getEncodedName();
//        } else {
//            name = classDef.getName();
//        }
        KMethodDef[] methodDefs = classDef.getMethods();
        methodsBySignature = new HashMap<String, KMethod>(methodDefs.length);
        virtualMethodsBySignature = new HashMap<String, KMethod>(methodDefs.length);
        for (KMethodDef methodDefinition : methodDefs) {
            KMethod m = new KMethod(methodDefinition, this);
            String signature = methodDefinition.getSignature();
            methodsBySignature.put(signature, m);
            virtualMethodsBySignature.put(signature, m);
        }
        classInitializerMethod = findMethodBySignature(KMethodDef.SIG_CLINIT);
    }

    public static char[] getArrayClassName(String encodedName, int array) throws RemoteException {
        char[] ens = encodedName.toCharArray();
        char[] enchars = new char[encodedName.length() + array];
        int i = array - 1;
        while (i >= 0) {
            enchars[i] = '[';
            i--;
        }
        System.arraycopy(ens, 0, enchars, array, ens.length);
        return enchars;
    }

    public void setRepository(KClassRepository repository) throws RemoteException {
        this.repository = repository;
        String scn = classDef.getSuperClassName();
        if (scn != null) {
            superClass = repository.getClassByName(scn);
        }
        String[] ins = classDef.getSuperInterfaceNames();
        interfaces = new KClass[ins.length];
        for (int i = 0; i < ins.length; i++) {
            interfaces[i] = repository.getClassByName(ins[i]);
        }
        KMethodDef[] methodDefs = classDef.getMethods();
        methodsBySignature = new HashMap<String, KMethod>(methodDefs.length);
        virtualMethodsBySignature = new HashMap<String, KMethod>(methodDefs.length);
        for (KMethodDef methodDefinition : methodDefs) {
            KMethod m = new KMethod(methodDefinition, this);
            String signature = methodDefinition.getSignature();
            methodsBySignature.put(signature, m);
            virtualMethodsBySignature.put(signature, m);
        }
        classInitializerMethod = findMethodBySignature(KMethodDef.SIG_CLINIT);
    }

    public KObjectType getType() {
        return type;
    }

    public int getArrayDepth() {
        return array;
    }

    public KClass getReferenceTo() {
        return referenceTo;
    }

    public int getByteSize() {
        return byteSize;
    }

    public String getName() {
        return name;
    }

    public String getPathName() {
        return encodedPath;
//        StringBuilder sb = new StringBuilder();
//        if (type == KObjectType.t_ref) {
//            sb.append("&");
//            sb.append(referenceTo.getEncodedName());
//        } else {
//            for (int i = 0; i < array; i++) {
//                sb.append("[");
//            }
//            if (type.isPrimitive()) {
//                return getEncodedName();
//            } else {
//                sb.append(classDef.getName().replace('.', '/'));//.append(";");
//            }
//        }
//        return sb.toString();
    }

    public String getEncodedName() {
        return encodedName;
//        StringBuilder sb = new StringBuilder();
//        if (type == KObjectType.t_ref) {
//            sb.append("&");
//            sb.append(referenceTo.getEncodedName());
//        } else {
//            for (int i = 0; i < array; i++) {
//                sb.append("[");
//            }
//            if (type.isPrimitive()) {
//                sb.append(type.getCode());
//            } else {
//                sb.append("L").append(classDef.getName().replace('.', '/')).append(";");
//            }
//        }
//        if (sb.indexOf(".") >= 0) {
//            System.out.print("");
//        }
//        return sb.toString();
    }

//    public static String getEncodedName(KObjectType type, int array, KClass referenceTo, KClassDef classDef) {
//        StringBuilder sb = new StringBuilder();
//        if (type == KObjectType.t_ref) {
//            sb.append("&");
//            sb.append(referenceTo.getEncodedName());
//        } else {
//            for (int i = 0; i < array; i++) {
//                sb.append("[");
//            }
//            if (type.isPrimitive()) {
//                sb.append(type.getCode());
//            } else {
//                sb.append("L").append(classDef.getName().replace('.', '/')).append(";");
//            }
//        }
//        return sb.toString();
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (type == KObjectType.t_ref) {
            sb.append("&");
            sb.append(referenceTo.toString());
            sb.append("{").append(byteSize).append("}");
        } else {
            if (primitive) {
                sb.append(type.getName());
            } else {
                sb.append(classDef.getName());
            }
            sb.append("{").append(byteSize).append("}");
            for (int i = 0; i < array; i++) {
                sb.append("[]");
            }
        }
        return sb.toString();
    }
//    public String toString() {
//        if (array) {
//            switch (type) {
//                case t_boolean:
//                case t_byte:
//                case t_char:
//                case t_double:
//                case t_float:
//                case t_int:
//                case t_long:
//                case t_string: {
//                    return type.toString().substring(2) + "[]";
//                }
//                case t_ref: {
//                    return referenceTo.toString() + "[]";
//                }
//                case t_obj: {
//                    return "obj:" + "ClassRef("
//                            + (processClass != null ? (",classSpec=" + processClass.getName()) : "")
//                            + (processClass != null ? (",version=" + processClass.getVersion()) : "")
//                            + ",type=" + type
//                            + ",byteSize=" + byteSize
//                            + (array ? ",array" : "")
//                            + (referenceTo != null ? (",referenceTo=" + referenceTo) : "")
//                            + ")";
//                }
//                case t_class: {
//                    return "class:" + "ClassRef("
//                            + (processClass != null ? (",classSpec=" + processClass.getName()) : "")
//                            + (processClass != null ? (",version=" + processClass.getVersion()) : "")
//                            + ",type=" + type
//                            + ",byteSize=" + byteSize
//                            + (array ? ",array" : "")
//                            + (referenceTo != null ? (",referenceTo=" + referenceTo) : "")
//                            + ")";
//                }
//            }
//            return referenceTo.toString() + "[]";
//        } else {
//            switch (type) {
//                case t_boolean:
//                case t_byte:
//                case t_char:
//                case t_double:
//                case t_float:
//                case t_int:
//                case t_long:
//                case t_string: {
//                    return type.toString().substring(2);
//                }
//                case t_ref: {
//                    return "&" + referenceTo.toString();
//                }
//                case t_obj: {
//                    return "obj:" + "ClassRef("
//                            + (processClass != null ? (",classSpec=" + processClass.getName()) : "")
//                            + (processClass != null ? (",version=" + processClass.getVersion()) : "")
//                            + ",type=" + type
//                            + ",byteSize=" + byteSize
//                            + (array ? ",array" : "")
//                            + (referenceTo != null ? (",referenceTo=" + referenceTo) : "")
//                            + ")";
//                }
//            }
//        }
//        return "ClassRef("
//                + (processClass != null ? (",classSpec=" + processClass.getName()) : "")
//                + (processClass != null ? (",version=" + processClass.getVersion()) : "")
//                + ",type=" + type
//                + ",byteSize=" + byteSize
//                + (array ? ",array" : "")
//                + (referenceTo != null ? (",referenceTo=" + referenceTo) : "")
//                + ")";
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KClass dClassRef = (KClass) o;

        if (array != dClassRef.array) {
            return false;
        }
        if (byteSize != dClassRef.byteSize) {
            return false;
        }
        if (classDef != null ? !classDef.equals(dClassRef.classDef) : dClassRef.classDef != null) {
            return false;
        }
        if (referenceTo != null ? !referenceTo.equals(dClassRef.referenceTo) : dClassRef.referenceTo != null) {
            return false;
        }
        if (type != dClassRef.type) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (type != null ? type.name().hashCode() : 0);
        result = 31 * result + array;
        result = 31 * result + (referenceTo != null ? referenceTo.hashCode() : 0);
        result = 31 * result + byteSize;
        result = 31 * result + (classDef != null ? classDef.hashCode() : 0);
        return result;
    }

    public KClassDef getDefinition() {
        return classDef;
    }

    public boolean isArrayOrRef() {
        return array > 0 || type == KObjectType.t_ref;
    }

    public boolean isRef() {
        return type == KObjectType.t_ref;
    }

    public boolean isPrimitive() {
        return primitive;
    }

    public boolean isArray() {
        return array > 0;
    }

    public boolean isAssignableFrom(KReference ref) throws RemoteException {
        return isAssignableFrom(Doovos.getSystem().getMemoryManager().getKClass(ref));
    }

    public boolean isAssignableFrom(KClass other) throws RemoteException {
        if (isArray()) {
            String e = getEncodedName();
            //TODO FIX ME
            KClass other2 = other;
            if (other2.isRef()) {
                other2 = other.getReferenceTo();
            }
            boolean a = e.equals(other2.getEncodedName());
            return true;
//            if (isArray() != other.isArray() || getArrayDepth() != other.getArrayDepth()) {
//                return false;
//            }
//            if (!getReferenceTo().equals(other.getReferenceTo())) {
//                return false;
//            }
//            return true;
        }
        String defName = getDefinition().getName();
        KClassDef rtClass = other.getDefinition();
        Stack<KClassDef> stack = new Stack<KClassDef>();
        stack.push(rtClass);
        boolean found = false;
        KClassRepository repositoryLocal = repository;
        while (!stack.isEmpty()) {
            KClassDef c = stack.pop();
            if (c.getName().equals(defName)) {
                found = true;
                break;
            }
            String className1 = c.getSuperClassName();
            if (className1 != null) {
                stack.push(repositoryLocal.getClassByName(className1).getDefinition());
            }
            for (String s : c.getSuperInterfaceNames()) {
                stack.push(repositoryLocal.getClassByName(s).getDefinition());
            }
        }
        return found;
    }

    public KReference getGuestReference() {
        return guestReference;
    }

    public void setGuestReference(KReference guestReference) {
        this.guestReference = guestReference;
    }

    public boolean isInitializable() {
        return !initialized && findClassInitializerMethod() != null;
    }

    public KMethod findClassInitializerMethod() {
        return classInitializerMethod;
    }

    public boolean isInitialized() {
        return initialized;
    }

    /**
     * should be called once;
     * allocate regConstantsPool in the default process.getMemorySegment()
     *
     * @throws RemoteException
     */
    public void setConstantsPool(KRegister[] constantsPool) {
        this.constantsPool = constantsPool;
    }

    public void defined() throws RemoteException {
        for (KField field : directFields.values()) {
            field.defined();
        }
        for (KMethod kMethod : methodsBySignature.values()) {
            if (kMethod.getDefinition().getReturnType().equals("void")) {
                final KInstructionDef[] code = kMethod.getDefinition().getCode();
                switch (code.length) {
                    case 1: {
                        if (code[0].getOperator() == KOperatorCodes.RETURN) {
                            // no need to invoke
                            kMethod.setIgnorable(true);
                        }
                        break;
                    }
                    case 3: {
                        if (code[0].getOperator() == KOperatorCodes.ALOAD
                                && code[1].getOperator() == KOperatorCodes.INVOKESPECIAL
                                && code[2].getOperator() == KOperatorCodes.RETURN) {
                            long[] operands = code[1].getOperands();
                            if (getDefinition().getConstant((int) operands[1]).equals(KMethodDef.CONSTRUCTOR)) // no need to invoke
                            {
                                KMethod cons = getSuperClass().findMethodBySignature(KMethodDef.CONSTRUCTOR);
                                if (cons == null || cons.isIgnorable()) {
                                    kMethod.setIgnorable(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //    /**
//     * @param javaObject
//     * @param process
//     * @return
//     * @throws RemoteException
//     */
//    private static KRegister toRegister(Object javaObject, KProcess process) throws RemoteException {
//        if (javaObject == null) {
//            return KReference.NULL;
//        } else if (javaObject instanceof KRegister) {
//            return (KRegister) javaObject;
//        } else if (javaObject instanceof Integer) {
//            return new KInteger((Integer) javaObject);
//        } else if (javaObject instanceof Long) {
//            return new KLong((Long) javaObject);
//        } else if (javaObject instanceof Boolean) {
//            return KBoolean.valueOf((Boolean) javaObject);
//        } else if (javaObject instanceof Byte) {
//            return new KByte((Byte) javaObject);
//        } else if (javaObject instanceof Character) {
//            return new KChar((Character) javaObject);
//        } else if (javaObject instanceof Double) {
//            return new KDouble((Double) javaObject);
//        } else if (javaObject instanceof Float) {
//            return new KFloat((Float) javaObject);
//        } else if (javaObject instanceof Short) {
//            return new KShort((Short) javaObject);
//        } else if (javaObject instanceof String) {
//            KReference kReference = process.getMemorySegment().allocString(((String) javaObject));
//            process.getGarbageCollector().incReferencesCount(kReference);
//            return kReference;
//        } else {
//            return (KRegister) javaObject;
//        }
//    }
    public void setInitialized(boolean value) {
        this.initialized = value;
    }

    public KRegister[] getConstantsPool() {
        return constantsPool;
    }

    public KRegister getConstantRegister(int index) {
        return constantsPool[index];
    }

    public KReference getStaticReference() {
        return staticReference;
    }

    public void setStaticReference(KReference staticReference) throws RemoteException {
        this.staticReference = staticReference;
        this.staticReferenceSegment = Doovos.getSystem().getMemorySegment(staticReference.segment);
    }

    public KClass getArrayComponent() throws RemoteException {
        return repository.getArrayClass(this, array - 1);
    }

    public KClass toArray() throws RemoteException {
        return repository.getArrayClass(this, array + 1);
    }

    public static String toClassCode(String name0) {
        return userClassFormatToJavaClassFormat(name0);
    }

    public static String classToJavaClassFormat(Class clz) {
        if (clz.isArray()) {
            return "[" + classToJavaClassFormat(clz.getComponentType());
        } else if (clz.isPrimitive()) {
            return KObjectType.resolveByName(clz.getName()).getCode();
        } else {
            return "L" + clz.getName().replace('.', '/') + ";";
        }
    }

    public static String userClassFormatToJavaClassFormat(String name0) {
        String name = name0;
        StringBuilder ss = new StringBuilder();
        while (name.endsWith("[]")) {
            ss.append("[");
            name = name.substring(0, name.length() - 2);
        }
        KObjectType objectType = KObjectType.resolveByName(name);
        if (objectType != null && objectType.isPrimitive()) {
            ss.append(objectType.getCode());
            return ss.toString();
        } else {
            return ss.append("L").append(name.replace('.', '/')).append(";").toString();
        }
    }

    public static String javaGetNameToJavaClassFormat(String name0) {
        String name = name0;
        StringBuilder ss = new StringBuilder();
        if (name0.startsWith("[")) {
            return name0.replace('.', '/');
        }
        if (name0.endsWith(";")) {
            return name0.replace('.', '/');
        }
        KObjectType objectType = KObjectType.resolveByName(name);
        if (objectType != null && objectType.isPrimitive()) {
            ss.append(objectType.getCode());
            return ss.toString();
        } else {
            return ss.append("L").append(name.replace('.', '/')).append(";").toString();
        }
    }

    public KField getField(String name, boolean checkSuper) throws RemoteException {
        if (checkSuper) {
            KField field = allFields.get(name);
            if (field != null) {
                return field;
            }
            if (superClass != null) {
                KField field1 = superClass.findField(name, true);
                if (field1 != null) {
                    allFields.put(field1.definition.getName(), field1);
                    return field1;
                }
            }
            for (KClass ii : interfaces) {
                KField field1 = ii.findField(name, true);
                if (field1 != null) {
                    allFields.put(field1.definition.getName(), field1);
                    return field1;
                }
            }

        } else {
            KField field = directFields.get(name);
            if (field != null) {
                return field;
            }
        }


//        if (checkSuper) {
//            KField field = allFields.get(name);
//            if (field != null) {
//                return field;
//            }
//            String superClassName = classDef.getSuperClassName();
//            if (superClassName != null) {
//                KField field1 = repository.getClassByName(superClassName).findField(name, true);
//                if (field1 != null) {
//                    allFields.put(field1.definition.getName(), field1);
//                    return field1;
//                }
//            }
//
//        } else {
//            KField field = directFields.get(name);
//            if (field != null) {
//                return field;
//            }
//        }
        throw new NoSuchElementException("Field " + name + " not found in " + getName());
    }

    public KField findField(String name, boolean checkSuper) throws RemoteException {
        if (checkSuper) {
            KField field = allFields.get(name);
            if (field != null) {
                return field;
            }
            String superClassName = classDef.getSuperClassName();
            if (superClassName != null) {
                KField field1 = repository.getClassByName(superClassName).getField(name, true);
                if (field1 != null) {
                    allFields.put(field1.definition.getName(), field1);
                    return field1;
                }
            }
        } else {
            KField field = directFields.get(name);
            if (field != null) {
                return field;
            }
        }
        return null;
    }

    public KMethod[] getMethods() throws RemoteException {
        return methodsBySignature.values().toArray(new KMethod[methodsBySignature.size()]);
    }

    public KMethod getMethodBySignature(String signature) throws RemoteException {
        KMethod def = methodsBySignature.get(signature);
        if (def == null) {
            throw new NoSuchElementException("Method " + signature + " not found in " + getName());
        }
        return def;
    }

    public KMethod getMainMethod() throws RemoteException {
        KMethod m = findMethodBySignature("main([Ljava/lang/String;)V");
        if (m != null && m.getModifiers() == (Modifier.PUBLIC + Modifier.STATIC)) {
            return m;
        }
        return null;
    }

    public boolean isProgram() throws RemoteException {
        return getMainMethod() != null;
    }

    public KMethod findMethodBySignature(String signature) {
        return methodsBySignature.get(signature);
    }

    public KMethod getVirtualMethodBySignature(String signature) throws RemoteException {
        KMethod m = findVirtualMethodBySignature(signature);
        if (m == null) {
            throw new NoSuchMethodError("Method not found " + signature + " in " + getName());
        }
        return m;
    }

    public KMethod findVirtualMethodBySignature(String signature) throws RemoteException {
        KMethod m = virtualMethodsBySignature.get(signature);
        if (m != null) {
            return m;
        }

        if (superClass != null) {
            KMethod kMethodDef = superClass.findVirtualMethodBySignature(signature);
            if (kMethodDef != null) {
                virtualMethodsBySignature.put(signature, kMethodDef);
                return kMethodDef;
            }
        }
        if (interfaces.length != 0) {
            for (KClass sinterface : interfaces) {
                KMethod kMethodDef = sinterface.findVirtualMethodBySignature(signature);
                if (kMethodDef != null) {
                    virtualMethodsBySignature.put(signature, kMethodDef);
                    return kMethodDef;
                }
            }
        }
        return null;
    }

    public KClass getSuperClass() {
        return superClass;
    }
}
