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
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;

public final class JJIT_ICONST extends JJITInstructionDef {
    public static final JJIT_ICONST ICONST_M1 = new JJIT_ICONST(KOperator.ICONST_M1, KInteger.M1);
    public static final JJIT_ICONST ICONST_0 = new JJIT_ICONST(KOperator.ICONST_0, KInteger.ZERO);
    public static final JJIT_ICONST ICONST_1 = new JJIT_ICONST(KOperator.ICONST_1, KInteger.ONE);
    public static final JJIT_ICONST ICONST_2 = new JJIT_ICONST(KOperator.ICONST_2, KInteger.TWO);
    public static final JJIT_ICONST ICONST_3 = new JJIT_ICONST(KOperator.ICONST_3, KInteger.THREE);
    public static final JJIT_ICONST ICONST_4 = new JJIT_ICONST(KOperator.ICONST_4, KInteger.FOUR);
    public static final JJIT_ICONST ICONST_5 = new JJIT_ICONST(KOperator.ICONST_5, KInteger.FIVE);
//    private int value;
    private KInteger kvalue;

    private JJIT_ICONST(KOperator operator, KInteger kvalue) {
        super(operator);
        this.kvalue = kvalue;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(JJITChangeOp.PUSH_INTEGER);
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        r.push(cls.declareConst(kvalue));
    }

    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new Single(this);
    }

    private static class Single extends JJITInstructionSingleNext implements Cloneable {

        private KInteger CONST;
        private Single(JJIT_ICONST d) {
            super(d);
            CONST=d.kvalue;
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            frame.push(CONST);
            return next;
        }
    }


    @Override
    public String toString() {
        return getOperator()+"(" + kvalue+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        JJIT_ICONST that = (JJIT_ICONST) o;

        if (kvalue != null ? !kvalue.equals(that.kvalue) : that.kvalue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (kvalue != null ? kvalue.hashCode() : 0);
        return result;
    }

    @Override
    public String getShareName() {
        return operator.toString();
    }

    @Override
    public boolean isSharable(){
        return true;
    }

    public KInteger getValue() {
        return kvalue;
    }
}
