package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITArr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITNewArr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;

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

public final class JJIT_MULTIANEWARRAY extends JJITInstructionDef {
    private int dims;
    private int typeId;
    private String typeName;

    public JJIT_MULTIANEWARRAY(Object[] constants,int typeId,int dims) {
        super(KOperator.MULTIANEWARRAY);
        this.typeId = typeId;
        this.dims = dims;
        this.typeName = (String)constants[typeId];
                //final JJITName v = r.declareAndInitKField(className, fieldName);
    }

    @Override
    public String[] getLoadingClasses() {
        return new String[]{typeName};
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        JJITChangeOp[] ops=new JJITChangeOp[dims+1];
        for (int i = 0; i < dims; i++) {
            ops[i]= JJITChangeOp.POP_INTEGER;
        }
        ops[dims]= JJITChangeOp.PUSH_REF;
        return new JJITChanges(ops);
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        JJITMethodSourceRun r = cls.run();
        JJITName memseg = r.declareMemSeg();
        JJITName kclass = r.declareAndInitKClass(typeName);
        JJITName ia = r.declareLocalVar(Types.INT_ARR, "ia", null);
        r.set(ia, new JJITNewArr(new JJITType(Types.INT), JJITConstant.asInt(dims)));
        for (int i = 0; i < dims; i++) {
            ia.arr(JJITConstant.asInt(dims - 1 - i), r.popInt());
        }
        r.push(memseg.call(Calls.MemorySegment_allocMultiArray,kclass, ia));
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

        JJIT_MULTIANEWARRAY that = (JJIT_MULTIANEWARRAY) o;

        if (dims != that.dims) {
            return false;
        }
        if (typeId != that.typeId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + dims;
        result = 31 * result + typeId;
        return result;
    }

    @Override
    public boolean isJump() {
        return true;
    }

    private static class Single extends JJITInstructionSingleNext implements Cloneable{
        private transient KClass kclass;
        private int dims;
        private String typeName;

        private Single(JJIT_MULTIANEWARRAY d) {
            super(d);
            dims=d.dims;
            typeName=d.typeName;
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            if (kclass == null) {
                kclass = frame.getClassRepository().getClassByName(typeName);
            }
            int[] dimValues = new int[dims];
            int dimValues_length = dims;
            for (int i = 0; i < dimValues_length; i++) {
                dimValues[dimValues_length - i - 1] = frame.popInt();
            }
            frame.push(frame.getMemorySegment().allocMultiArray(kclass, dimValues));
            return next;
        }
    }
}
