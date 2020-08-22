package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITCmpOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceInit;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITOp3;

import static org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp.POP_INTEGER;

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
/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public abstract class JJIT__BASE_IF extends JJITInstructionDef /*KJVM__IF*/ {

    protected int label;
    private JJITCmpOp jop;

    public JJIT__BASE_IF(KOperator op,JJITCmpOp jop, int label) {
        super(op);
        this.label = label;
        this.jop = jop;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        //return new JJITStackChange(new KRegisterType[]{KRegisterType.INTEGER,KRegisterType.INTEGER}, null);
        return new JJITChanges(
                POP_INTEGER,
                POP_INTEGER
        );
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        JJITName next = cls.declareFieldNext();
        JJITName lab = cls.declareFieldLabel();
        JJITName index = r.declareIndex();
        JJITName jump = r.declareJump();
        r.popInt(index);
        r.set(jump, r.popInt().cmp(jop, index));
        r.Return(new JJITOp3(jump,lab,next));

        //this.next=instructions[index+1]:null
        JJITMethodSourceInit init = cls.init();
        init.set(next, init.instructions().arr(index.add(1)));
        init.set(lab, init.instructions().arr(JJITConstant.asInt(cls.getLabel(label))));
    }

    @Override
    public int[] getLabels() {
        return new int[]{label};
    }
    
    @Override
    public int[] getNexts(int currentIndex, JJITInstructionDef[] instructions) {
        return new int[]{currentIndex+1,label};
    }

    @Override
    public String toString() {
        return getOperator()+ "(" + label+")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT__BASE_IF other = (JJIT__BASE_IF) obj;
        if (this.label != other.label) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.label;
        return hash;
    }

    

//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                new String[]{"private KInstruction nextLabel"}, new String[]{
//                        "boolean jump"
//                },
//                "    {\n"
//                        + "        int value2 = " + jitContext.popInt() + ";\n" +
//                        "        int value1 = " + jitContext.popInt() + ";\n" +
//                        "        jump=(value1 >= value2);"
//                        + "\n    }"
//                , "jump? " + label + ":KProcess.NEXT_STATEMENT", "jump?nextLabel:next",
//                new String[]{
//                        "this.nextLabel=code[" + label + "]"
//                }
//        );
//    }
}
