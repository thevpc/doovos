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
import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;
import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionStore;




import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;

public final class KJVM_BASTORE extends KInstructionIdx implements Cloneable, KInstructionStore {
    public static final KJVM_BASTORE INSTANCE = new KJVM_BASTORE();


    private KJVM_BASTORE() {
        super(KOperatorCodes.BASTORE);
    }

    public int run(KFrame frame) throws RemoteException {
        int value = frame.popInt();
        int index = frame.popInt();
        KReference ref = frame.popRef();
        KMemoryManager mm = Doovos.getSystem().getMemoryManager();
        if (mm.getKClass(ref).getType() == KObjectType.t_boolean) {
            Doovos.getSystem().getMemoryManager().setBooleanArray(ref, index, value != 0);
        } else {
            Doovos.getSystem().getMemoryManager().setByteArray(ref, index, (byte) value);
        }
        return KProcess.NEXT_STATEMENT;
    }

}