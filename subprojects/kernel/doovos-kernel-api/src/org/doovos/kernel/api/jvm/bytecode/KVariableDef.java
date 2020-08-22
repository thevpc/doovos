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
import java.lang.reflect.Modifier;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 29 août 2008
 * Time: 23:29:37
 * To change this template use File | Settings | File Templates.
 */
public class KVariableDef implements Serializable, Comparable<KVariableDef> {
    private int modifiers;
    private int index;
    private String name;
    private String type;

    public KVariableDef(String name, String type, int modifiers, int index) {
        this.name = name;
        this.type = type;
        this.modifiers = modifiers;
        this.index = index;
    }

    public int getModifiers() {
        return modifiers;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public int compareTo(KVariableDef o) {
        Integer i = index;
        return i.compareTo(o.index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KVariableDef that = (KVariableDef) o;

        if (index != that.index) return false;
        if (modifiers != that.modifiers) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = modifiers;
        result = 31 * result + index;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "var@"+index+" "+ Modifier.toString(modifiers)+" "+ type+" "+name;
    }
}