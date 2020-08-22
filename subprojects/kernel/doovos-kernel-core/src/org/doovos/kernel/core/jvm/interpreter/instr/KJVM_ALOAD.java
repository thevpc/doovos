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
import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;
import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionLoad;
import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionRef;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class KJVM_ALOAD extends KInstructionIdx implements Cloneable, KInstructionRef, KInstructionLoad {
    private int index;
    public static final KJVM_ALOAD ALOAD_0 = new KJVM_ALOAD(KOperatorCodes.ALOAD_0, 0);
    public static final KJVM_ALOAD ALOAD_1 = new KJVM_ALOAD(KOperatorCodes.ALOAD_1, 1);
    public static final KJVM_ALOAD ALOAD_2 = new KJVM_ALOAD(KOperatorCodes.ALOAD_2, 2);
    public static final KJVM_ALOAD ALOAD_3 = new KJVM_ALOAD(KOperatorCodes.ALOAD_3, 3);
    public KJVM_ALOAD(int op, int index) {
        super(op);
        this.index = index;

    }

    public KJVM_ALOAD(long[] operands) {
        super(KOperatorCodes.ALOAD, operands);
        this.index = (int) operands[0];
    }

    public int run(KFrame frame) throws RemoteException {
        frame.push(frame.getLocal(index));
        return KProcess.NEXT_STATEMENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_ALOAD that = (KJVM_ALOAD) o;

        if (index != that.index) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + index;
        return result;
    }

    public int getLoadIndex() {
        return index;
    }

}