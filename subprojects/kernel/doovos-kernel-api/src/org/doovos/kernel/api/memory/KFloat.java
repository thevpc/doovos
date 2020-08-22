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

public final class KFloat implements KRegister {
    public static final KFloat ZERO = new KFloat(0);
    public static final KFloat ONE = new KFloat(1);
    public static final KFloat TWO = new KFloat(2);
    public static final KFloat POSITIVE_INFINITY = new KFloat(Float.POSITIVE_INFINITY);
    public static final KFloat NEGATIVE_INFINITY = new KFloat(Float.NEGATIVE_INFINITY);
    public static final KFloat NAN = new KFloat(Float.NaN);
    public static final KFloat MAX_VALUE = new KFloat(Float.MAX_VALUE);
    public static final KFloat MIN_VALUE = new KFloat(Float.MIN_VALUE);

    public KFloat(float value) {
        this.value = value;
    }

    public Object toJavaNative() {
        return value;
    }

    public KRegisterType getType() {
        return KRegisterType.FLOAT;
    }

    public float value;

    @Override
    public String toString() {
        return "Float{" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KFloat kFloat = (KFloat) o;

        if (Float.compare(kFloat.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (value != +0.0f ? Float.floatToIntBits(value) : 0);
    }

    public boolean isType2() {
        return false;
    }

    public int intValue() {
        throw new ClassCastException(getClass().getName());
    }

    public long longValue() {
        throw new ClassCastException(getClass().getName());
    }

    public byte byteValue() {
        return (byte) value;
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

    public double doubleValue() {
        return value;
    }

    public float floatValue() {
        return value;
    }
}