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
 * with this program; if not, writeSource to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KReturn;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceInit;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;

public abstract class JJIT__BASE_JSR extends JJITInstructionDef {

    private int label;
    private int returnIndex;

    protected JJIT__BASE_JSR(KOperator op, int ordinal, int label) {
        super(op);
        this.label = label;
        this.returnIndex = ordinal + 1;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
//        return new JJITStackChange(
//                new KRegisterType[]{}, new KRegisterType[]{KRegisterType.RETURN}
//        );
        return new JJITChanges(JJITChangeOp.PUSH_RETURN);
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        r.push(cls.declareConst(new KReturn(cls.getLabel(returnIndex))));
        JJITName next = cls.declareFieldNext();
        r.Return(next);
        final JJITMethodSourceInit i = cls.init();
        i.set(next, i.instructions().arr(cls.getLabel(label)));
    }

    @Override
    public int[] getNexts(int currentIndex, JJITInstructionDef[] instructions) {
//        return new int[]{label, returnIndex};
        return new int[]{label};
    }

    @Override
    public String toString() {
        return getOperator() + "(" + label + "," + returnIndex + ')';
    }

    @Override
    public int[] getLabels() {
        return new int[]{label};
    }

    @Override
    public boolean isJump() {
        return true;
    }

    public int getLabel() {
        return label;
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, final IntHashMap labels) {
        return new Single(this, labels);

    }


    private static class Single extends JJITInstructionSingle implements Cloneable {

        private KReturn kReturn;
        private JJITInstruction next;
        private int label;

        private Single(JJIT__BASE_JSR d, IntHashMap labels) {
            super(d);
            kReturn = new KReturn(labels.get(d.returnIndex, d.returnIndex));
            label = labels.get(d.label, d.label);
        }

        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
            next = instructions[label];
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            frame.push(kReturn);
            return next;
        }

    }
}
