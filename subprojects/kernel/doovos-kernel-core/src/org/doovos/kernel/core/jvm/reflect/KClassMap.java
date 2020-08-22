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

import java.util.HashMap;
import java.util.Map;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KReference;


/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 avr. 2009
 * Time: 23:17:55
 * To change this template use File | Settings | File Templates.
 */
public class KClassMap {
//    private Hashtable<String, KClass> classesByEncodedName = new Hashtable<String, KClass>();
    private Map<String, KClass> classesByName = new HashMap<String, KClass>();
    private Map<KReference, KClass> classesByJVMReference = new HashMap<KReference, KClass>();

    private static class KClassId<T> {
        long version;
        T key;

        private KClassId(T key, long version) {
            this.key = key;
            this.version = version;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KClassId kClassId = (KClassId) o;

            if (version != kClassId.version) return false;
            if (key != null ? !key.equals(kClassId.key) : kClassId.key != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = (int) (version ^ (version >>> 32));
            result = 31 * result + (key != null ? key.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "KClassId{" +
                    "version=" + version +
                    ", key=" + key +
                    '}';
        }
    }

    public void registerClass(KClass clazz) {
//        KClassDef d = clazz.getDefinition();
        //long version = /*d == null ? 0 : */d.getVersion();
//        classesByEncodedName.put(new KClassId<String>(clazz.getEncodedName(), version), clazz);
        classesByName.put(clazz.getName(), clazz);
//        classesByEncodedName.put(clazz.getEncodedName(), clazz);

//        if (version != KClassDef.NO_VERSION) {
//            //update default version
////            classesByEncodedName.put(new KClassId<String>(clazz.getEncodedName(), KClassDef.NO_VERSION), clazz);
//            classesByName.put(new KClassId<String>(clazz.getName(), KClassDef.NO_VERSION), clazz);
//        }

//        if (clazz.isPrimitive() && !clazz.isArray()) {
//            classesByPathName.put(new KClassId<String>(clazz.getPathName(), version), clazz);
//            //update default version
//            if (version != KClassDef.NO_VERSION) {
//                classesByPathName.put(new KClassId<String>(clazz.getPathName(), KClassDef.NO_VERSION), clazz);
//            }
//        }
    }

    public void registerRegisterReference(KClass clazz) {
//        KClassDef d = clazz.getDefinition();
//        long version = /*d == null ? 0 : */d.getVersion();
        classesByJVMReference.put(clazz.getGuestReference(), clazz);
//        if (version != KClassDef.NO_VERSION) {
//            classesByJVMReference.put(new KClassId<KReference>(clazz.getGuestReference(), KClassDef.NO_VERSION), clazz);
//        }
    }

    public KClass forName(String name) {
        return classesByName.get(name);
    }

    public KClass forReference(KReference ref) {
        return classesByJVMReference.get(ref);
    }

}
