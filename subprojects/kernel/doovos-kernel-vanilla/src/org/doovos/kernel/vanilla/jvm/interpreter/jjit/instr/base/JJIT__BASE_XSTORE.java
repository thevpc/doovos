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
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJIT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITDecField;

import java.lang.reflect.Modifier;

public abstract class JJIT__BASE_XSTORE extends JJITInstructionDef {

    private int local;
    private KRegisterType type;

    protected JJIT__BASE_XSTORE(KOperator o, KRegisterType type, int index) {
        super(o);
        this.local = index;
        this.type = type;
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        if (cls.isSharedMode()) {
            JJITDecField f = new JJITDecField(Modifier.PRIVATE, Types.INT, JJIT.getSharedVarName(relativeIndex, 1), JJITConstant.IM1);
            cls.declareField(f);
            r.frame().call(Calls.KFrame_setLocal, new JJITName(f.getName(), f.getType()), r.pop());
        } else {
            r.popToLocal(local);
        }
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(JJITChangeOp.Pop(type));
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);
    }

    private static class Single extends JJITInstructionSingleNext implements Cloneable {

        private int local;

        private Single(JJIT__BASE_XSTORE d) {
            super(d);
            local = d.local;
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            frame.setLocal(local, frame.pop());
            return next;
        }
    }

    @Override
    public int getWriteLocal() {
        return local;
    }

    @Override
    public String toString() {
        return getOperator() + "(" + local + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT__BASE_XSTORE other = (JJIT__BASE_XSTORE) obj;
        if (this.local != other.local) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.local;
        return hash;
    }

    @Override
    public String getShareName() {
        switch (operator) {
            case ASTORE:
            case ISTORE:
            case LSTORE:
            case DSTORE:
            case FSTORE: {
                return operator.toString() + JJITUtils.stringifyForName(local);
            }
        }
        return operator.toString();
    }

    public int getLocal() {
        return local;
    }

    @Override
    public boolean isSharable() {
        return true;
    }

    public void prepareShare(JJITInstruction ii, int relativeIndex){
        prepareShareVar(ii,relativeIndex,1,local);
    }
}