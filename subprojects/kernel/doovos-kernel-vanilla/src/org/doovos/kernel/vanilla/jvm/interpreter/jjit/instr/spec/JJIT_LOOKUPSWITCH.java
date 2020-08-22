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

import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.core.util.IntHashSet;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceInit;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITNew;

import org.doovos.kernel.api.jvm.interpreter.KFrame;

import java.util.HashMap;
import java.util.Map;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

public final class JJIT_LOOKUPSWITCH extends JJITInstructionDef {

    public IntHashMap map;
    public KInstruction defaultInstr;
    public int defaultLabel;

    public JJIT_LOOKUPSWITCH(int[] operands) {
        super(KOperator.LOOKUPSWITCH);
        int count = operands[0];
        defaultLabel = operands[count + 1];
        map = new IntHashMap(count);
        for (int i = 0; i < count; i++) {
            int v = operands[i + 1];
            int l = operands[i + 2 + count];
            map.put(v, l);
        }
    }

    @Override
    public int[] getLabels() {
        int[] arr = map.valuesArray();
        IntHashSet ihs=new IntHashSet(arr.length+1);
        ihs.addAll(arr);
        ihs.add(defaultLabel);
        return ihs.toArray();
    }

    @Override
    public int[] getNexts(int currentIndex, JJITInstructionDef[] instructions) {
        return getLabels();
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, final IntHashMap labels) {
        return new JJITInstructionSingle() {

            Map<Integer, JJITInstruction> map2;
            JJITInstruction defaultNext;

            public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                defaultNext = instructions[labels.get(defaultLabel, defaultLabel)];
                map2 = new HashMap<Integer, JJITInstruction>();
                for (Map.Entry<Integer, Integer> entry : map.toMap().entrySet()) {
                    JJITInstruction r = instructions[labels.get(entry.getValue(), entry.getValue())];
                    map2.put(entry.getKey(), r);
                }
            }

            public JJITInstruction run(KFrame frame) throws Exception {
                JJITInstruction ii = map2.get(frame.popInt());
                return ii == null ? defaultNext : ii;
            }
        };
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(JJITChangeOp.POP_INTEGER);
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        cls.defineImport("org.doovos.kernel.core.util.IntKeyHashMap");
        JJITName map2 = cls.declareField(new TypeStruct("IntKeyHashMap<JJITInstruction>"), "sm", new JJITNew(new TypeStruct("IntKeyHashMap<JJITInstruction>")));
        JJITName dinstr = cls.declareField(Types.JJITINSTRUCTION, "smd", null);
        JJITMethodSourceInit init = cls.init();
        JJITName instructions = init.instructions();
        init.set(dinstr, instructions.arr(cls.getLabel(defaultLabel)));
        for (Map.Entry<Integer, Integer> entry : map.toMap().entrySet()) {
            init.addCode(map2.call(Calls.Map_Integer_JJITInstruction_put, entry.getKey(), instructions.arr(cls.getLabel(entry.getValue()))));
        }
        JJITMethodSourceRun r = cls.run();
        JJITName next = r.declareLocalVar(Types.JJITINSTRUCTION, "n", null);
        r.set(next, map2.call(Calls.Map_Integer_JJITInstruction_get, r.popInt()));
        r.If(next.eq(JJITConstant.NULL)).Then().set(next, dinstr);
        r.Return(next);
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

        JJIT_LOOKUPSWITCH that = (JJIT_LOOKUPSWITCH) o;

        if (defaultLabel != that.defaultLabel) {
            return false;
        }
        if (map != null ? !map.equals(that.map) : that.map != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (map != null ? map.hashCode() : 0);
        result = 31 * result + defaultLabel;
        return result;
    }

    @Override
    public boolean isJump() {
        return true;
    }

}
