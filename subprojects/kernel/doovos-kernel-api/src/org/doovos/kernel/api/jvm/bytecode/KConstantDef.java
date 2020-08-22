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

import java.util.Arrays;
import org.doovos.kernel.api.memory.KObjectType;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 23 août 2008
 * Time: 20:52:27
 * To change this template use File | Settings | File Templates.
 */
public class KConstantDef implements Serializable {
    public Object[] initialization;
    public long size;

    public KConstantDef(Object[] initialization) {
        this.initialization = initialization;
        size = 0;
        for (Object value : initialization) {
            if (value instanceof Integer) {
                size += KObjectType.t_int.getByteSize();
            } else if (value instanceof Long) {
                size += KObjectType.t_long.getByteSize();
            } else if (value instanceof Double) {
                size += KObjectType.t_double.getByteSize();
            } else if (value instanceof Float) {
                size += KObjectType.t_float.getByteSize();
            } else if (value instanceof Byte) {
                size += KObjectType.t_byte.getByteSize();
            } else if (value instanceof Character) {
                size += KObjectType.t_char.getByteSize();
            } else if (value instanceof Boolean) {
                size += KObjectType.t_boolean.getByteSize();
            } else if (value instanceof int[]) {
                size += KObjectType.t_int.getByteSize() * ((int[]) value).length;
            } else if (value instanceof long[]) {
                size += KObjectType.t_long.getByteSize() * ((long[]) value).length;
            } else if (value instanceof double[]) {
                size += KObjectType.t_double.getByteSize() * ((double[]) value).length;
            } else if (value instanceof float[]) {
                size += KObjectType.t_float.getByteSize() * ((float[]) value).length;
            } else if (value instanceof boolean[]) {
                size += KObjectType.t_boolean.getByteSize() * ((boolean[]) value).length;
            } else if (value instanceof char[]) {
                size += KObjectType.t_char.getByteSize() * ((char[]) value).length;
            } else if (value instanceof byte[]) {
                size += KObjectType.t_byte.getByteSize() * ((byte[]) value).length;
            } else {
                throw new IllegalArgumentException("Unsupported type " + value.getClass());
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KConstantDef other = (KConstantDef) obj;
        if (!Arrays.deepEquals(this.initialization, other.initialization)) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.deepHashCode(this.initialization);
        hash = 97 * hash + (int) (this.size ^ (this.size >>> 32));
        return hash;
    }

}
