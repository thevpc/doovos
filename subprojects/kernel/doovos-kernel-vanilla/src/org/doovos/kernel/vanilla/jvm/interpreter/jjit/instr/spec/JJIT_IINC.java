package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec;

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
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMathOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;

public final class JJIT_IINC extends JJITInstructionDef {

    private int local;
    private int val;

    public JJIT_IINC(int local, int val) {
        super(KOperator.IINC);
        this.val=val;
        this.local = local;
    }

    public int getLocal() {
        return local;
    }

    public int getVal() {
        return val;
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
//        final JJITExpressionImpl oldvalue = r.getLocal(index).cast(TypeStruct.KINTEGER).field("value",TypeStruct.INT);
        final JJITExpression oldvalue = r.getLocalPrimitive(local, KObjectType.t_int);
        r.setLocal(local, new JJITNew(Types.KINTEGER,  new JJITMath(JJITMathOp.ADD, oldvalue, JJITConstant.asInt(val))));
    }
    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return JJITChanges.NOTHING;
    }

    @Override
    public String getShareName() {
        return operator.toString()+ JJITUtils.stringifyForName(local)+"_"+JJITUtils.stringifyForName(val);
    }

    @Override
    public boolean isSharable(){
        return true;
    }

    

    @Override
    public JJITInstruction createSingleInstruction(final Object[] constantDefs, final IntHashMap labels) {
        return new Single(this, local,val) ;
    }

    private static class Single extends JJITInstructionSingleNext implements Cloneable {

        private int index;
        private int val;

        private Single(JJIT_IINC d, int index, int val) {
            super(d);
            this.index=index;
            this.val=val;
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            frame.setLocal(index, new KInteger((frame.getLocal(index)).intValue() + val));
            return next;
        }
    }


    @Override
    public int getReadLocal() {
        return local;
    }

    @Override
    public int getWriteLocal() {
        return local;
    }

    @Override
    public String toString() {
        return getOperator() + "(" + local + "," + val+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        JJIT_IINC kjvm_iinc = (JJIT_IINC) o;

        if (local != kjvm_iinc.local) {
            return false;
        }
        if (val != kjvm_iinc.val) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + local;
        result = 31 * result + val;
        return result;
    }
}
