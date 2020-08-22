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

public final class KBoolean implements KRegister {
    public static final KBoolean TRUE = new KBoolean(true);
    public static final KBoolean FALSE = new KBoolean(false);

    public final boolean value;
    public final int intVal;

    public static KBoolean valueOf(boolean b) {
        return b ? TRUE : FALSE;
    }

    private KBoolean(boolean value) {
        this.value = value;
        this.intVal = value?1:0;
    }

    public Object toJavaNative() {
        return value;
    }

    public KRegisterType getType() {
        return KRegisterType.BOOLEAN;
    }


    @Override
    public String toString() {
        return "Boolean{" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KBoolean kBoolean = (KBoolean) o;

        if (value != kBoolean.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return intVal;
    }

    public boolean isType2() {
        return false;
    }

    public int intValue() {
        return intVal;
    }

    public long longValue() {
        return intVal;
    }


    public byte byteValue() {
        return (byte) (intVal);
    }

    public boolean booleanValue() {
        return value;
    }

    public char charValue() {
        throw new ClassCastException(getClass().getName());
    }

    public short shortValue() {
        throw new ClassCastException(getClass().getName());
    }

    public double doubleValue() {
        throw new ClassCastException(getClass().getName());
    }

    public float floatValue() {
        throw new ClassCastException(getClass().getName());
    }
}