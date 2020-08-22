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

public final class KLong implements KRegister {

    public static final KLong ZERO = new KLong(0);
    public static final KLong ONE = new KLong(1);
    public static final KLong M1 = new KLong(-1);
    public static final KLong MAX_VALUE = new KLong(Long.MAX_VALUE);
    public static final KLong MIN_VALUE = new KLong(Long.MIN_VALUE);

    public KLong(long value) {
        this.value = value;
    }

    public Object toJavaNative() {
        return value;
    }
    public long value;

    public KRegisterType getType() {
        return KRegisterType.LONG;
    }

    @Override
    public String toString() {
        return "Long{" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KLong kLong = (KLong) o;

        if (value != kLong.value) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

    public boolean isType2() {
        return true;
    }

    public int intValue() {
        return (int) value;
    }

    public long longValue() {
        return value;
    }

    public byte byteValue() {
        return (byte) value;
    }

    public double doubleValue() {
        throw new ClassCastException(getClass().getName());
    }

    public float floatValue() {
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
