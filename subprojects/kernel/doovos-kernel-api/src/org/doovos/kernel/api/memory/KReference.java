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
package org.doovos.kernel.api.memory;

import org.doovos.kernel.api.Doovos;

public final class KReference implements KRegister {

    //public static final KReference NULL = new KReference(null,0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL);
    public static final KReference NULL = new KReference(null,0L, 0L);

    public KReference(KMemorySegment memorySegment, long segment, long pointer) {
        this.segment = segment;
        this.pointer = pointer;
        this.memorySegment = memorySegment;
   }

    public Object toJavaNative() {
        return this;
    }
    public final long segment;
    public final long pointer;
    public final KMemorySegment memorySegment;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KReference that = (KReference) o;

        if (pointer != that.pointer) {
            return false;
        }
        if (segment != that.segment) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (int) (segment ^ (segment >>> 32));
        result = 31 * result + (int) (pointer ^ (pointer >>> 32));
        return result;
    }

    @Override
    public String toString() {
        if (isNull()) {
            return "{NULL}";
        } else {
            String s = null;
            try {
                s = Doovos.getSystem().getMemoryManager().getPointer(this).toString();
            } catch (Throwable e) {
                s = "InvalidPointer";
                //
            }
            if (s != null) {
                s = "(" + s + ")";
            }else{
                s="";
            }
            return "{" + segment + "," + pointer + s + "}";
        }
    }

//    public String toString2() {
//        if (isNull()) {
//            return "NULL";
//        } else {
//            return "{" + segment + "," + pointer + "}";
//        }
//    }

    public boolean isNull() {
        return segment == 0 /*&& pointer == -1*/;
//        return segment == -1 /*&& pointer == -1*/;
    }
    
    public boolean isNotNull() {
        return segment != 0 /*&& pointer == -1*/;
//        return segment == -1 /*&& pointer == -1*/;
    }

    public void checkReference() {
//        if (segment == -1 /*&& pointer == -1*/) {
        if (segment == 0 /*&& pointer == -1*/) {
            throw new NullPointerException();
        }
    }

    public KRegisterType getType() {
        return KRegisterType.REF;
    }

    public boolean isType2() {
        return false;
    }

    public double doubleValue() {
        throw new ClassCastException(getClass().getName());
    }

    public float floatValue() {
        throw new ClassCastException(getClass().getName());
    }

    public int intValue() {
        throw new ClassCastException(getClass().getName());
    }

    public long longValue() {
        throw new ClassCastException(getClass().getName());
    }

    public byte byteValue() {
        throw new ClassCastException(getClass().getName());
    }

    public char charValue() {
        throw new ClassCastException(getClass().getName());
    }

    public short shortValue() {
        throw new ClassCastException(getClass().getName());
    }

    public boolean booleanValue() {
        throw new ClassCastException(getClass().getName());
    }
}
