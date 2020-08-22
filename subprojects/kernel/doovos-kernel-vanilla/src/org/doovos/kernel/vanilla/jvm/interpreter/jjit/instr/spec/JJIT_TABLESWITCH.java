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
import java.util.Arrays;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceInit;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;

import org.doovos.kernel.api.jvm.interpreter.KFrame;

import java.util.HashSet;
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITNewArr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITOp3;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;

public final class JJIT_TABLESWITCH extends JJITInstructionDef {

    public int min;
    public int max;
    public int[] labelsTable;

    public JJIT_TABLESWITCH(int[] operands) {
        super(KOperator.TABLESWITCH);
        min = operands[0];
        max = operands[1];
        labelsTable = new int[max - min + 2];
        System.arraycopy(operands, 2, labelsTable, 0, labelsTable.length);
    }

    @Override
    public int[] getLabels() {
        HashSet<Integer> a = new HashSet<Integer>();
        for (int i : labelsTable) {
            a.add(i);
        }
        int[] all = new int[a.size()];
        int i = 0;
        for (Integer ii : a) {
            all[i] = ii;
            i++;
        }
        return all;
    }

    @Override
    public int[] getNexts(int currentIndex, JJITInstructionDef[] instructions) {
        return getLabels();
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, final IntHashMap labels) {
        return new JJITInstructionSingle() {

            JJITInstruction[] next;

            public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                next = new JJITInstruction[labelsTable.length];
                for (int i = 0; i < labelsTable.length; i++) {
                    int a = labelsTable[i];
                    next[i] = instructions[labels.get( a, a)];
                }
            }

            public JJITInstruction run(KFrame frame) throws Exception {
                int v = frame.popInt();
                return (v >= min && v <= max) ? next[v - min + 1] : next[0];
            }
        };
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(JJITChangeOp.POP_INTEGER);
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        JJITName map2 = cls.declareField(Types.JJITINSTRUCTION_ARR, "sm", new JJITNewArr(new JJITType(Types.JJITINSTRUCTION),JJITConstant.asInt(labelsTable.length)));
        JJITMethodSourceInit init = cls.init();
        JJITName instructions = init.instructions();
        for (int i = 0; i < labelsTable.length; i++) {
            init.set(map2.arr(JJITConstant.asInt(i)), instructions.arr(cls.getLabel(labelsTable[i])));
        }
        JJITMethodSourceRun r = cls.run();
        JJITName index = r.declareIndex();
        r.popInt(index);
        JJITConstant MIN = JJITConstant.asInt(min);
        JJITConstant MIN1 = JJITConstant.asInt(min-1);
        JJITConstant MAX = JJITConstant.asInt(max);
        r.Return(new JJITOp3(index.ge(MIN).and(index.le(MAX)),map2.arr(index.sub(MIN1)),map2.arr(JJITConstant.I0)));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT_TABLESWITCH other = (JJIT_TABLESWITCH) obj;
        if (this.min != other.min) {
            return false;
        }
        if (this.max != other.max) {
            return false;
        }
        if (!Arrays.equals(this.labelsTable, other.labelsTable)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.min;
        hash = 47 * hash + this.max;
        hash = 47 * hash + Arrays.hashCode(this.labelsTable);
        return hash;
    }


    

    @Override
    public boolean isJump()  {
        return true;
    }

}
