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
package org.doovos.kernel.core.jvm.interpreter.instr;

import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;
import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionIf;




import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.api.jvm.interpreter.KFrame;

import java.rmi.RemoteException;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class KJVM_TABLESWITCH extends KInstructionIdx implements Cloneable, KInstructionIf {
    public int min;
    public int max;
    public int[] labels;

    public KJVM_TABLESWITCH(long[] operands) {
        super(KOperatorCodes.TABLESWITCH, operands);
        min = (int) operands[0];
        max = (int) operands[1];
        labels = new int[max - min + 2];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = (int) operands[i + 2];
        }
    }

    public int run(KFrame frame) throws RemoteException {
        int v = frame.popInt();
        return (v >= min && v <= max) ? labels[v - min + 1] : labels[0];
    }

    public void setLabel(int label, int index) {
        operands[2 + index] = label;
        this.labels[index] = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_TABLESWITCH that = (KJVM_TABLESWITCH) o;

        if (max != that.max) return false;
        if (min != that.min) return false;
        if (!Arrays.equals(labels, that.labels)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + min;
        result = 31 * result + max;
        result = 31 * result + (labels != null ? Arrays.hashCode(labels) : 0);
        return result;
    }

    @Override
    public boolean isJump() throws RemoteException {
        return true;
    }

    @Override
    public KInstruction clone() {
        KJVM_TABLESWITCH i = (KJVM_TABLESWITCH) super.clone();
        int _max = labels.length;
        i.labels = new int[_max];
        System.arraycopy(labels, 0, i.labels, 0, _max);
        return i;
    }
}