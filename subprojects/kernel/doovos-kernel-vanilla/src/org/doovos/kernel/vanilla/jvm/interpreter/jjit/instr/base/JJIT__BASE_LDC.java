package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base;

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
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;

public class JJIT__BASE_LDC extends JJITInstructionDef {

    protected int index;
    protected Object constValue;

    public JJIT__BASE_LDC(KOperator op, Object[] constants, int index) {
        super(op);
        this.index = index;
        this.constValue = constants[index];
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        r.push(cls.declareConst(index));
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        JJITChangeOp t = null;
        if (constValue instanceof String) {
            t = JJITChangeOp.PUSH_REF;
        } else if (constValue instanceof Double) {
            t = JJITChangeOp.PUSH_DOUBLE;
        } else if (constValue instanceof Long) {
            t = JJITChangeOp.PUSH_LONG;
        } else if (constValue instanceof Integer) {
            t = JJITChangeOp.PUSH_INTEGER;
        } else if (constValue instanceof Float) {
            t = JJITChangeOp.PUSH_FLOAT;
        } else {
            throw new IllegalArgumentException("Illegal constant " + constValue.getClass());
        }
        return new JJITChanges(t);
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);
    }

    private static class Single extends JJITInstructionSingleNext implements Cloneable {

        private KRegister constValue;
        private int constIndex;

        private Single(JJIT__BASE_LDC d) {
            super(d);
            constIndex=d.index;
        }

        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
            super.init(index, instructions, constants, process);
            constValue = constants[constIndex];
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            frame.push(constValue);
            return next;
        }

    }


    @Override
    public String toString() {
        return getOperator() + "(" + index + "->\"" + constValue + "\")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT__BASE_LDC other = (JJIT__BASE_LDC) obj;
        if (this.index != other.index) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.index;
        return hash;
    }
}
