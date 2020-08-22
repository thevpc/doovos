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

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;

import java.rmi.RemoteException;

public final class KJVM_ICONST extends KInstructionIdx implements Cloneable {
    public static final KJVM_ICONST ICONST_M1 = new KJVM_ICONST(KOperatorCodes.ICONST_M1, KInteger.M1);
    public static final KJVM_ICONST ICONST_0 = new KJVM_ICONST(KOperatorCodes.ICONST_0, KInteger.ZERO);
    public static final KJVM_ICONST ICONST_1 = new KJVM_ICONST(KOperatorCodes.ICONST_1, KInteger.ONE);
    public static final KJVM_ICONST ICONST_2 = new KJVM_ICONST(KOperatorCodes.ICONST_2, KInteger.TWO);
    public static final KJVM_ICONST ICONST_3 = new KJVM_ICONST(KOperatorCodes.ICONST_3, KInteger.THREE);
    public static final KJVM_ICONST ICONST_4 = new KJVM_ICONST(KOperatorCodes.ICONST_4, KInteger.FOUR);
    public static final KJVM_ICONST ICONST_5 = new KJVM_ICONST(KOperatorCodes.ICONST_5, KInteger.FIVE);
    private KInteger value;


    public KJVM_ICONST(int operator, KInteger value) {
        super(operator);
        this.value = value;
    }

    public int run(KFrame frame) throws RemoteException {
        frame.push(value);
        //**LOG**//log(i.operator, context, "value=" + value);
        return KProcess.NEXT_STATEMENT;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_ICONST that = (KJVM_ICONST) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}