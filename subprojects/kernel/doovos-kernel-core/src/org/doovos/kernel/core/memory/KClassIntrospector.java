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
package org.doovos.kernel.core.memory;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KPointerInfo;
import org.doovos.kernel.api.memory.adapter.RefArrayAdapter;

import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KField;

/**
 * Simple Guest JVM introspector
 */
public class KClassIntrospector {

    private KRegister register;
    private HostObject hostObject;

    public static KClassIntrospector[] torArray(KRegister[] r) throws RemoteException {
        KClassIntrospector[] all = new KClassIntrospector[r.length];
        for (int i = 0; i < r.length; i++) {
            KRegister x = r[i];
            all[i] = (x == null) ? null : new KClassIntrospector(x);
        }
        return all;
    }

    public static class HostObject {
    }

    public static class HostPrimitive extends HostObject {

        Object hostValue;

        @Override
        public String toString() {
            return "Primitive(" + hostValue.getClass().getSimpleName() + ":" + hostValue + ")";
        }
    }

    public static class HostReference0 extends HostObject {

        long pointer;
        long segment;
        KClass kclass;
        String className;
        KPointerInfo pointerInfo;
        Object hostValue;
    }

    public static class HostInstance extends HostReference0 {

        Field[] instanceFields;
        Field[] staticFields;

        @Override
        public String toString() {
            if (hostValue != null) {
                return String.valueOf(hostValue);
            }
            return "HostReference:" + className + "(" + segment + "," + pointer + ")";
        }
    }

    public static class HostArray extends HostReference0 {

        private KClassIntrospector[] arrayValue;

        @Override
        public String toString() {
            return "HostArr:" + className + "(" + segment + "," + pointer + "):" + arrayValue.length;
        }
    }

    public static class HostNull extends HostObject {

        public String toString() {
            return "HostNull";
        }
    }

    public static class Field {

        KFieldDef field;
        KRegister value;

        public Field(KFieldDef field, KRegister value) {
            this.field = field;
            this.value = value;
        }

        @Override
        public String toString() {
            return field.getName() + "(" + field.getTypeName() + ")";
        }
    }

    public KClassIntrospector(KRegister register) throws RemoteException {
        this.register = register;
        ArrayList<Field> ifields = new ArrayList<Field>();
        ArrayList<Field> sfields = new ArrayList<Field>();
        if (register instanceof KReference) {
            KReference reference = (KReference) register;
            if (reference.isNull()) {
                hostObject = new HostNull();
            } else {
                KPointerInfo pointerInfo = Doovos.getSystem().getMemoryManager().getPointer(reference);
                KClass kclass = pointerInfo.getKClass();
                HostReference0 hr;
                if (kclass.isArray()) {
                    hr = new HostArray();
                } else {
                    hr = new HostInstance();
                }
                hostObject = hr;
                hr.kclass = kclass;
                hr.pointerInfo = pointerInfo;
                hr.pointer = reference.pointer;
                hr.segment = reference.segment;
                hr.kclass = hr.pointerInfo.getKClass();
                hr.className = hr.kclass.getEncodedName();
                if (kclass.isArray()) {
                    ((HostArray) hr).arrayValue = torArray(new RefArrayAdapter(null, reference).toArray());
                } else {
                    HostInstance hi = (HostInstance) hr;
                    String klassName = kclass.getName();
                    if (klassName.equals("java.lang.String")) {
                        hi.hostValue = Doovos.getSystem().getMemoryManager().getString(reference);
                    }
                    KClassDef kClassDef = kclass.getDefinition();
                    if (kClassDef != null) {
                        for (KFieldDef kFieldDef : kClassDef.getAllFields()) {
                            KField field = kclass.getField(kFieldDef.getName(), true);
                            if (Modifier.isStatic(kFieldDef.getModifiers())) {
                                sfields.add(new Field(kFieldDef, field.getStaticValue()));
                            } else {
                                ifields.add(new Field(kFieldDef, field.getInstanceValue(reference)));
                            }
                        }
                        hi.instanceFields = ifields.toArray(new Field[ifields.size()]);
                        hi.staticFields = sfields.toArray(new Field[sfields.size()]);
                    }
                }
            }
        } else {
            hostObject = new HostPrimitive();
            ((HostPrimitive) hostObject).hostValue = register.toJavaNative();
        }
    }

    @Override
    public String toString() {
        return hostObject.toString();
    }

    public KRegister getRegister() {
        return register;
    }
//    private static String dump(String gprefix, KRegister[] arr) throws RemoteException {
//        if (arr == null) {
//            return "null";
//        }
//        StringBuilder sb = new StringBuilder("{\n");
//        for (KRegister kRegister : arr) {
//            sb.append(gprefix).append("  ").append(dump(kRegister)).append("\n");
//        }
//        sb.append(gprefix).append("}");
//        return sb.toString();
//    }
//
//    private static String dump(String gprefix, KRegister arr) throws RemoteException {
//        return new KClassIntrospector(arr).dump(gprefix);
//    }
//
//    public static String dump(KRegister[] arr) throws RemoteException {
//        return dump("", arr);
//    }
//
//    public static String dump(KRegister r) throws RemoteException {
//        return dump("", r);
//    }
//
//    private String dump(String prefix) throws RemoteException {
//        StringBuilder sb = new StringBuilder("{\n");
//        sb.append(prefix).append("  register=").append(register).append("\n");
//        sb.append(prefix).append("  className=").append(className).append("\n");
//        sb.append(prefix).append("  pointerInfo=").append(pointerInfo).append("\n");
//        sb.append(prefix).append("  hostValue=").append(hostValue).append("\n");
//        sb.append(prefix).append("  arrayValue=").append(dump(prefix + "  ", arrayValue)).append("\n");
//        sb.append(prefix).append("}");
//        return sb.toString();
//    }
}
