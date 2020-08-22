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

import org.doovos.kernel.core.jvm.interpreter.instr.opt.KJVM_ANEWARRAY0;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class KJVM_ANEWARRAY extends KInstructionIdx implements Cloneable {
    private int typeId;

    private KClass classByName;

    public KJVM_ANEWARRAY(long[] operands) {
        super(KOperatorCodes.ANEWARRAY, operands);
        this.typeId = (int) operands[0];
    }

    public int run(KFrame frame) throws RemoteException {
        if (classByName == null) {
            String classNameString = frame.getConstantString(typeId);
            classByName = frame.getClassRepository().getClassByName(classNameString);
            if (frame.getThread().pushClassInitializerFrame(classByName)) {
                return KProcess.THIS_STATEMENT;
            }
        }
        int size = frame.popInt();
        frame.push(frame.getMemorySegment().allocRefArray(classByName, size));
        return KProcess.NEXT_STATEMENT;
    }

      @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_ANEWARRAY that = (KJVM_ANEWARRAY) o;

        if (typeId != that.typeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + typeId;
        return result;
    }

    @Override
    public boolean isLabel() throws RemoteException {
        return true;
    }

    @Override
    public boolean isJump() throws RemoteException {
        return true;
    }

    @Override
    public KInstruction clone() {
        if (classByName != null) {
            return new KJVM_ANEWARRAY0(typeId, classByName);
        }
        return super.clone();
    }
}