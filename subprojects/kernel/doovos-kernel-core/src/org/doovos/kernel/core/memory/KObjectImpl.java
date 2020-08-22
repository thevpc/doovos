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

import org.doovos.kernel.api.memory.KMemoryUtilities;
import org.doovos.kernel.api.memory.KReference;

import java.util.Arrays;
import org.doovos.kernel.api.memory.KObject;
import org.doovos.kernel.api.memory.KObjectType;

public class KObjectImpl implements KObject, Cloneable {
    private KObjectType type;
    private int arraySize;
    private byte[] content;

    public KObjectImpl(KObjectType type, byte[] content, int arraySize) {
        this.type = type;
        this.content = content;
        this.arraySize = arraySize;
    }

    public KObjectType getType() {
        return type;
    }

    public byte[] getContent() {
        return content;
    }

    public boolean booleanValue() {
        return KMemoryUtilities.byteArray2boolean(content, 0);
    }

    public byte byteValue() {
        return KMemoryUtilities.byteArray2byte(content, 0);
    }

    public int intValue() {
        return KMemoryUtilities.byteArray2int(content, 0);
    }

    public double doubleValue() {
        return KMemoryUtilities.byteArray2double(content, 0);
    }

    public float floatValue() {
        return KMemoryUtilities.byteArray2float(content, 0);
    }

    public long longValue() {
        return KMemoryUtilities.byteArray2long(content, 0);
    }

    public char charValue() {
        return KMemoryUtilities.byteArray2char(content, 0);
    }

    public char[] charArrayValue() {
        return KMemoryUtilities.byteArray2charArray(content, 0, content.length);
    }

    public KReference refValue() {
        return KMemoryUtilities.byteArray2ref(content, 0);
    }

    public int getArraySize() {
        return arraySize;
    }

    public Object getObject() {
        switch (type) {
            case t_boolean: {
                return booleanValue();
            }
            case t_byte: {
                return byteValue();
            }
            case t_char: {
                return charValue();
            }
            case t_double: {
                return doubleValue();
            }
            case t_float: {
                return floatValue();
            }
            case t_int: {
                return intValue();
            }
            case t_long: {
                return longValue();
            }
//            case t_string:
            case t_ref: {
                return refValue();
            }
            case t_obj: {
                return content;
            }
//            case t_class: {
//                return content;
//            }
        }
        return content;
    }

    public String toString() {
        Object s = getObject();
        if (s instanceof String) {
            s = "\"" + s + "\"";
        }
        if (s instanceof byte[]) {
            s = "hash#" + Arrays.hashCode((byte[]) s);
        }
        return type + ":" + String.valueOf(s);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        KObjectImpl o = (KObjectImpl) super.clone();
        byte[] content2 = new byte[content.length];
        System.arraycopy(content, 0, content2, 0, content2.length);
        o.content = content2;
        return o;
    }

    public KObject copy() {
        try {
            return (KObject) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
