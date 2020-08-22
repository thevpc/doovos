package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_XALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;

/**
 * ====================================================================
 * Doovos (Distributed Object Oriented Operating System)
 * <p/>
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 * <p/>
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 * <p/>
 * Copyright (C) 2008-2010 Taha BEN SALAH
 * <p/>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
public final class JJIT_BALOAD extends JJIT__BASE_XALOAD {

    public static final JJIT_BALOAD INSTANCE = new JJIT_BALOAD();

    private JJIT_BALOAD() {
        super(KOperator.BALOAD, Types.KINTEGER, Calls.MemoryManager_getByteArray);
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(
                JJITChangeOp.POP_INTEGER,
                JJITChangeOp.POP_REF,
                JJITChangeOp.PUSH_INTEGER
        );
    }

    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);
    }

    private static class Single extends JJITInstructionSingleNext implements Cloneable {
        private transient KMemoryManager memoryManager;
        @Override
        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
            super.init(index, instructions, constants, process);
            memoryManager= process.getMemoryManager();
        }

        private Single(JJIT_BALOAD d) {
            super(d);
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            int index = frame.popInt();
            frame.push(new KInteger(memoryManager.getByteArray(frame.popRef(), index)));
            return next;
        }

    }
}
