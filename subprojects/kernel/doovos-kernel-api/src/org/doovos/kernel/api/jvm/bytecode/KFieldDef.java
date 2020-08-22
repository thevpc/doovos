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

import org.doovos.kernel.api.memory.KObjectType;

import java.io.Serializable;
import java.lang.reflect.Modifier;

public class KFieldDef implements Serializable {
    private String name;
    private int modifiers;
    private String typeName;
    private KClassDef parentClass;
    private int byteOffset;
    /**
     * absolute index in class
     */
    private int absoluteIndex;
    private String className;

    /**
     * index in class according to its type (static of not)
     */
    private int index;

    @Override
    public String toString() {
        return "KFieldDef{" + Modifier.toString(modifiers)+ " " + typeName+" "+ className+"."+ name + ", byteOffset=" + byteOffset + ", absoluteIndex=" + absoluteIndex + ", index=" + index + '}';
    }
    
    public KFieldDef(String className,int modifiers, String typeName, String name) {
        this.modifiers = modifiers;
        this.typeName = typeName;
        this.name = name;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public int getModifiers() {
        return modifiers;
    }

    public String getTypeName() {
        return typeName;
    }

    public KObjectType getObjectType() {
        KObjectType attribType = KObjectType.resolveByName(getTypeName());
        if (attribType != null) {
            return attribType;
        }
        return KObjectType.t_ref;
    }

    public KClassDef getParentClass() {
        return parentClass;
    }

    void setParentClass(KClassDef parentClass) {
        this.parentClass = parentClass;
    }

    public int getByteOffset() {
        return byteOffset;
    }

    public void setByteOffset(int byteOffset) {
        this.byteOffset = byteOffset;
    }

    public int getAbsoluteIndex() {
        return absoluteIndex;
    }

    public void setAbsoluteIndex(int absoluteIndex) {
        this.absoluteIndex = absoluteIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KFieldDef other = (KFieldDef) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.modifiers != other.modifiers) {
            return false;
        }
        if ((this.typeName == null) ? (other.typeName != null) : !this.typeName.equals(other.typeName)) {
            return false;
        }
//        if (this.parentClass != other.parentClass && (this.parentClass == null || !this.parentClass.equals(other.parentClass))) {
//            return false;
//        }
        if (this.byteOffset != other.byteOffset) {
            return false;
        }
        if (this.absoluteIndex != other.absoluteIndex) {
            return false;
        }
        if ((this.className == null) ? (other.className != null) : !this.className.equals(other.className)) {
            return false;
        }
        if (this.index != other.index) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 89 * hash + this.modifiers;
        hash = 89 * hash + (this.typeName != null ? this.typeName.hashCode() : 0);
//        hash = 89 * hash + (this.parentClass != null ? this.parentClass.hashCode() : 0);
        hash = 89 * hash + this.byteOffset;
        hash = 89 * hash + this.absoluteIndex;
        hash = 89 * hash + (this.className != null ? this.className.hashCode() : 0);
        hash = 89 * hash + this.index;
        return hash;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        KFieldDef kFieldDef = (KFieldDef) o;
//
//        if (absoluteIndex != kFieldDef.absoluteIndex) return false;
//        if (byteOffset != kFieldDef.byteOffset) return false;
//        if (index != kFieldDef.index) return false;
//        if (modifiers != kFieldDef.modifiers) return false;
//        if (name != null ? !name.equals(kFieldDef.name) : kFieldDef.name != null) return false;
////        if (parentClass != null ? !parentClass.equals(kFieldDef.parentClass) : kFieldDef.parentClass != null)
////            return false;
//        if (typeName != null ? !typeName.equals(kFieldDef.typeName) : kFieldDef.typeName != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + modifiers;
//        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
//        result = 31 * result + byteOffset;
//        result = 31 * result + absoluteIndex;
//        result = 31 * result + index;
//        return result;
//    }


    public String getClassName() {
        return className;
    }
}
