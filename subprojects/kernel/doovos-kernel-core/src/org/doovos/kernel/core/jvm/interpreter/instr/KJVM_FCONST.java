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


import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KFloat;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;

public final class KJVM_FCONST extends KInstructionIdx implements Cloneable {
    //    public static final KJVM_FCONST FCONST_M1=new KJVM_FCONST(KJVMOperator.FCONST_M1,KInteger.M1);
    public static final KJVM_FCONST FCONST_0 = new KJVM_FCONST(KOperatorCodes.FCONST_0, KFloat.ZERO);
    public static final KJVM_FCONST FCONST_1 = new KJVM_FCONST(KOperatorCodes.FCONST_1, KFloat.ONE);
    public static final KJVM_FCONST FCONST_2 = new KJVM_FCONST(KOperatorCodes.FCONST_2, KFloat.TWO);
//    public static final KJVM_FCONST FCONST_3 =new KJVM_FCONST(KJVMOperator.FCONST_3 ,KInteger.THREE);
    //    public static final KJVM_FCONST FCONST_4 =new KJVM_FCONST(KJVMOperator.FCONST_4 ,KInteger.FOUR);
    //    public static final KJVM_FCONST FCONST_5 =new KJVM_FCONST(KJVMOperator.FCONST_5 ,KInteger.FIVE);
    private KFloat value;


    private KJVM_FCONST(int operator, KFloat value) {
        super(operator);
        this.value = value;
    }

    public int run(KFrame frame) throws RemoteException {
        frame.push(value);
        return KProcess.NEXT_STATEMENT;
    }

 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_FCONST that = (KJVM_FCONST) o;

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