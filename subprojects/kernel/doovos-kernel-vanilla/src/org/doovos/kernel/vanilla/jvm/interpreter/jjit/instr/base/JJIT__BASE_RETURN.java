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
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.util.EmptyArray;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;

public abstract class JJIT__BASE_RETURN extends JJITInstructionDef  {
    private KRegisterType rtype;

    protected JJIT__BASE_RETURN(KOperator op, KRegisterType rtype) {
        super(op);
        this.rtype = rtype;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(JJITChangeOp.Pop(rtype));
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        JJITName callerFrame = r.declareCaller();
        JJITName reg = r.declareReg();
        JJITName thread = r.declareThread();
        r.popReg(reg);
        r.Flush();
        r.set(callerFrame, thread.call(Calls.KThread_popFrame));
        r.addCode(callerFrame.call(Calls.KFrame_push, reg));
        r.Return(callerFrame.call(Calls.KFrame_getCurrentInstruction).cast(Types.JJITINSTRUCTION));
    }

    @Override
    public int[] getNexts(int currentIndex, JJITInstructionDef[] instructions) {
        return EmptyArray.INTS;
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);

    }

    @Override
    public String getShareName() {
        return operator.toString();
    }

    @Override
    public boolean isSharable(){
        return true;
    }

    private static class Single extends JJITInstructionSingle implements Cloneable {

        private Single(JJIT__BASE_RETURN d) {
            super(d);
        }

        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            KRegister value = frame.pop();
            KFrame callerFrame = frame.getThread().popFrame();
            callerFrame.push(value);
            return (JJITInstruction) callerFrame.getCurrentInstruction();
        }

    }
}
