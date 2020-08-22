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
package org.doovos.kernel.depreciated.jvm.bytecodeloader.v1;

import org.doovos.kernel.api.jvm.bytecode.KParameterDef;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 29 août 2008
 * Time: 23:29:37
 * To change this template use File | Settings | File Templates.
 */
public class DParameterByteCodeInfo implements Comparable<DParameterByteCodeInfo> {
    private int index;
    private int modifiers;
    private String name;
    private String type;

    public DParameterByteCodeInfo(int index, int modifiers, String type, String name) {
        this.index = index;
        this.type = type;
        this.name = name;
        this.modifiers = modifiers;
    }

    public DParameterByteCodeInfo() {
    }

    public int getModifiers() {
        return modifiers;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public KParameterDef toParameterDef() {
        return new KParameterDef(
                name, type, modifiers, index
        );
    }

    public int compareTo(DParameterByteCodeInfo o) {
        Integer i = index;
        return i.compareTo(o.index);
    }
}