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

public class KTryCatchDef implements Serializable{
    private int from;
    private int to;
    private int target;
    private String type;

    public KTryCatchDef(int from, int to, int target, String type) {
        this.from = from;
        this.to = to;
        this.target = target;
        this.type = type;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public void setType(String type) {
        this.type = type;
    }

    

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getTarget() {
        return target;
    }

    public String getType() {
        return type;
    }

    public boolean accept(int pos) {
        return pos >= from && pos < to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KTryCatchDef that = (KTryCatchDef) o;

        if (from != that.from) return false;
        if (target != that.target) return false;
        if (to != that.to) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = from;
        result = 31 * result + to;
        result = 31 * result + target;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}