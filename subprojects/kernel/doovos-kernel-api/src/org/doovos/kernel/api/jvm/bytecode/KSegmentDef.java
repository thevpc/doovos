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

import org.doovos.kernel.api.util.EmptyArray;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 23 août 2008
 * Time: 20:52:02
 * To change this template use File | Settings | File Templates.
 */
public class KSegmentDef implements Serializable {

    public static final int DEFAULT = 0;
    public static final int READ_ONLY = 1;
    public static final int GROWABLE = 2;
    public static final int SHRINLABLE = 4;
    public String id;
    public long size;
    public int options;
    public KConstantDef constants;
//    private static final Object[] EMPTY_ARRAY_OBJECT = new Object[0];

    public KSegmentDef(String id, long size, int options, KConstantDef initialization) {
        this.id = id;
        this.size = size;
        this.options = options;
        this.constants = initialization == null ? new KConstantDef(EmptyArray.EMPTY_ARRAY_OBJECT) : initialization;
    }

    public int getFlags() {
        return options;
    }

    public boolean isReadOnly() {
        return (options & READ_ONLY) == READ_ONLY;
    }

    public boolean isGrowable() {
        return (options & GROWABLE) == GROWABLE;
    }

    public boolean isShrinkable() {
        return (options & SHRINLABLE) == SHRINLABLE;
    }

//    public Options setReadOnly(boolean value) {
//        if (value) {
//            options &= READ_ONLY;
//        } else {
//            options &= ~READ_ONLY;
//        }
//        return this;
//    }
//
//    public Options setGrowable(boolean value) {
//        if (value) {
//            options &= GROWABLE;
//        } else {
//            options &= ~GROWABLE;
//        }
//        return this;
//    }
//
//    public Options setShrinkable(boolean value) {
//        if (value) {
//            options &= SHRINLABLE;
//        } else {
//            options &= ~SHRINLABLE;
//        }
//        return this;
//    }

    public String toString() {
        return "Segment(id=" + id + ", size=" + size + ",options=" + options + "init=" + ((constants == null || constants.size == 0) ? "N/A" : (constants.size + " vars")) + ")";
    }
}
