package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special;

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
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;

public final class JJIT_POP2Type1 extends JJITInstructionDef {

    public static final JJIT_POP2Type1 INSTANCE = new JJIT_POP2Type1();

    private JJIT_POP2Type1() {
        super(KOperator.POP2);
    }


    public JJITChanges getChanges(JJITChangeModel model) {
        KRegisterType t1 = model.peek(0);
        if (!t1.isType2()) {
            KRegisterType t2 = model.peek(1);
            return new JJITChanges(JJITChangeOp.Pop(t1), JJITChangeOp.Pop(t2));
        } else {
            return new JJITChanges(JJITChangeOp.Pop(t1));
        }
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        r.popIgnored();
        r.popIgnored();
    }

    @Override
    public String toString() {
        return "POP2Type1";
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);
    }

    private static class Single extends JJITInstructionSingleNext implements Cloneable{

        private Single(JJITInstructionDef d) {
            super(d);
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            frame.pop();
            frame.pop();
            return next;
        }

    }

}
