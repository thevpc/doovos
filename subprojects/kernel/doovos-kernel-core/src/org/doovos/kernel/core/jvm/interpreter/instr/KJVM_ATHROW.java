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
import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionReturn;


import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KReference;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class KJVM_ATHROW extends KInstructionIdx implements Cloneable, KInstructionReturn {
    public static final KJVM_ATHROW INSTANCE = new KJVM_ATHROW();

    private KJVM_ATHROW() {
        super(KOperatorCodes.ATHROW);
    }

    public int run(KFrame frame) throws RemoteException {
//        KProcess p=context.getProcess();
        KReference exceptionReference = frame.popRef();
        int i = frame.throwThrowable(exceptionReference);
        return frame.getProgramCounter();
//        KReference value = context.popReference();
//        while (true) {
//            for (KTryCatchDef kTryCatchDef : context.getMethod().getTryCatchBlocs()) {
//                if(kTryCatchDef.accept(context.getCurrentInstructionIndex())){
//                    KClass exceptionType = context.getProcess().getClassRepository().getClassByPath(kTryCatchDef.getType(), 0);
//                    if(exceptionType.isAssignableFrom(value)){
//                        context.clearStack();
//                        context.push(value);
//                        context.setInstruction(kTryCatchDef.getTarget());
//                        return kTryCatchDef.getTarget();
//                    }
//                }
//            }
//            context = context.popContext();
//        }
    }

      @Override
    public boolean isJump() throws RemoteException {
        return true;
    }


}