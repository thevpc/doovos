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
package org.doovos.kernel.core.jvm.interpreter.instr.opt;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class KJVM_INSTANCEOF0 extends KInstructionIdx implements Cloneable {
    private int classNameIndex;

    protected KClass classByName;

    public KJVM_INSTANCEOF0(int classNameIndex, KClass classByName) {
        super(KOperatorCodes.INSTANCEOF, new long[]{classNameIndex});
        this.classNameIndex = classNameIndex;
        this.classByName = classByName;
    }

    public int run(KFrame frame) throws RemoteException {
        KReference ref = frame.popRef();
        if (ref.isNull()) {
            frame.push(KInteger.ZERO);
        } else {
            boolean found = classByName.isAssignableFrom(Doovos.getSystem().getMemoryManager().getKClass(ref));
            frame.push(found ? KInteger.ONE : KInteger.ZERO);
        }
        return KProcess.NEXT_STATEMENT;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_INSTANCEOF0 that = (KJVM_INSTANCEOF0) o;

        if (classNameIndex != that.classNameIndex) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + classNameIndex;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(KOperatorCodes.ALL_NAMES[operator]);
        sb.append(" ");
        sb.append(classByName.getName());
        return sb.toString();
    }

    @Override
    public boolean isLabel() throws RemoteException {
        return false;
    }

    @Override
    public boolean isJump() throws RemoteException {
        return false;
    }
}