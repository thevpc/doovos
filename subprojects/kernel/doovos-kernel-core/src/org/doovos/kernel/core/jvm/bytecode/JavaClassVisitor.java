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
package org.doovos.kernel.core.jvm.bytecode;

import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KParameterDef;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.util.JavaByteCodeUtils;
import org.objectweb.asm.*;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vpc
 */
class JavaClassVisitor implements ClassVisitor {

    KClassDef clazz;
    List<Object> constantsPool = new ArrayList<Object>();
    List<KFieldDef> fields = new ArrayList<KFieldDef>();
    List<KMethodDef> methods = new ArrayList<KMethodDef>();

    JavaClassVisitor() {
        this.clazz = new KClassDef();
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        String dotName = name.replace('/', '.');
        clazz.setName(dotName);
        clazz.setCode("L" + dotName + ";");
        clazz.setPath(name);
        ArrayList<String> ifs = new ArrayList<String>(interfaces.length);
        for (String inf : interfaces) {
            ifs.add(inf.replace('/', '.'));
        }
        clazz.setModifiers(access);
        if (Modifier.isInterface(access)) {
            clazz.setSuperClassName(null);
        } else {
            clazz.setSuperClassName(superName == null ? null : superName.replace('/', '.'));
        }
        clazz.setSuperInterfaceNames(ifs.toArray(new String[ifs.size()]));
        //System.out.println("visit (version=" + version + ", access=" + Modifier.toString(access) + ", name=" + name + ", signature=" + signature + ", superName=" + superName + ", interfaces=" + Arrays.asList(interfaces) + ")");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void visitSource(String source, String debug) {
        //System.out.println("visitSource(source=" + source + ",debug=" + debug + ")");
    }

    public void visitOuterClass(String owner, String name, String desc) {
        //System.out.println("visitOuterClass(owner=" + owner + ", name=" + name + ", desc=" + desc + ")");
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        //System.out.println("visitAnnotation(desc=" + desc + ", visible=" + visible + ")");
        return null;
    }

    public void visitAttribute(Attribute attr) {
        //System.out.println("visitAttribute(attr=" + attr + ")");
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        //System.out.println("visitInnerClass");
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        String type = JavaByteCodeUtils.mapType2(desc);
        fields.add(
                new KFieldDef(
                clazz.getName(),
                access,
                type,
                name));
        //System.out.println("visitField");
        return new JavaFieldVisitor();
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        KMethodDef m = new KMethodDef();
        m.setName(name);
        m.setClassName(clazz.getName());
        m.setModifiers(access);
        m.setSignature(name + desc);
        int indexOfEndPar = desc.indexOf(')');
        String returnType = desc.substring(indexOfEndPar + 1);
//        if(!returnType.equals("V")){
        returnType = JavaByteCodeUtils.mapType2(returnType);
//        }
        m.setType(returnType);
        String[] types = JavaByteCodeUtils.mapMethodTypes(desc.substring(1, indexOfEndPar));
//            if(Modifier.isNative(access) || Modifier.isInterface(clazz.getModifiers())){
        int max = 0;
        int types_length = types.length;
        KParameterDef[] initParams = new KParameterDef[types_length];
        for (int i = 0; i < types_length; i++) {
            String type = types[i];
            String s = /*JavaByteCodeUtils.mapType*/ (type);
            KObjectType kObjectType = KObjectType.resolveByName(s);
            if (kObjectType != null && kObjectType.isType2()) {
                max += 2;
            } else {
                max++;
            }
            initParams[i] = (new KParameterDef("param_" + i, s, 0, i));
        }
        if (Modifier.isNative(access)) {
            if (Modifier.isStatic(access)) {
                m.setMaxLocals(max);
            } else {
                m.setMaxLocals(max + 1);
            }
        }
//            }
//            for (int i = 0; i < types.length; i++) {
//                String type = types[i];
//                m.getParameters().add(new DParameterByteCodeInfo(
//                        0, type, "arg"+i
//                ));
//            }
        methods.add(m);
        //System.out.println("visitMethod(access=" + access + ", name=" + name + ", desc=" + desc + ", signature=" + signature + ", exceptions=" + (exceptions == null ? null : Arrays.asList(exceptions)) + ")");
        return new JavaMethodVisitor(m, this, types.length, initParams);
    }

    public void visitEnd() {
        clazz.setConstantsPool(constantsPool.toArray(new Object[constantsPool.size()]));
        clazz.setFields(fields.toArray(new KFieldDef[fields.size()]));
        clazz.setMethods(methods.toArray(new KMethodDef[methods.size()]));
        clazz.compile();
        //System.out.println("visitEnd");
    }

    int registerConstant(Object value) {
        int index = constantsPool.indexOf(value);
        if (index >= 0) {
            return index;
        }
        constantsPool.add(value);
        return constantsPool.size() - 1;
    }
}
