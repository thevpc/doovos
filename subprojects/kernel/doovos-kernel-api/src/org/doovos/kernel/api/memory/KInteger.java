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

public final class KInteger implements KRegister {
    public static final KInteger M1 = new KInteger(-1);
    public static final KInteger ZERO = new KInteger(0);
    public static final KInteger ONE = new KInteger(1);
    public static final KInteger TWO = new KInteger(2);
    public static final KInteger THREE = new KInteger(3);
    public static final KInteger FOUR = new KInteger(4);
    public static final KInteger FIVE = new KInteger(5);
    public static final KInteger MAX_VALUE = new KInteger(Integer.MAX_VALUE);
    public static final KInteger MIN_VALUE = new KInteger(Integer.MIN_VALUE);

    public KInteger(int value) {
        this.value = value;
    }

    public Object toJavaNative() {
        return value;
    }

    public final int value;

    @Override
    public String toString() {
        return "Integer{" + value + '}';
    }

    public KRegisterType getType() {
        return KRegisterType.INTEGER;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KInteger kInteger = (KInteger) o;

        if (value != kInteger.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public boolean isType2() {
        return false;
    }

    public int intValue() {
        return value;
    }

    public long longValue() {
        return value;
    }

    public byte byteValue() {
        return (byte) value;
    }

    public boolean booleanValue() {
        return value!=0;
    }

    public char charValue() {
        return (char) value;
    }

    public short shortValue() {
        return (short) value;
    }


    public double doubleValue() {
        return (double)value;
    }

    public float floatValue() {
        return (float)value;
    }
}
