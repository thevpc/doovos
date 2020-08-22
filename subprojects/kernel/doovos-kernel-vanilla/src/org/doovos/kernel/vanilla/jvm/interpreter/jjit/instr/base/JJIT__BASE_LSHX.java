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

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMathOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITNew;

import static org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp.POP_INTEGER;
import static org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp.POP_LONG;
import static org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp.PUSH_LONG;

public abstract class JJIT__BASE_LSHX extends JJITInstructionDef {

    private JJITMathOp calcOp;

    protected JJIT__BASE_LSHX(KOperator op, JJITMathOp calcOp) {
        super(op);
        this.calcOp = calcOp;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
//        return new JJITStackChange(new KRegisterType[]{KRegisterType.LONG,KRegisterType.LONG}, new KRegisterType[]{KRegisterType.LONG});
        return new JJITChanges(
                POP_INTEGER,
                POP_LONG,
                PUSH_LONG
        );
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        final JJITName v2 = r.declareLocalVar(Types.INT, "i", null);
        r.popInt(v2);
        r.push(new JJITNew(Types.KLONG, r.popLong().calc(calcOp, v2)));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT__BASE_LSHX other = (JJIT__BASE_LSHX) obj;
        if (this.calcOp != other.calcOp) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.calcOp != null ? this.calcOp.hashCode() : 0);
        return hash;
    }

    
    @Override
    public String getShareName() {
        return operator.toString();
    }

    @Override
    public boolean isSharable(){
        return true;
    }

}
