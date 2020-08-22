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
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITTransformerContext;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_DUP2_X2Type1;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_DUP2_X2Type2;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_DUP2_X2Type3;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_DUP2_X2Type4;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;

public final class JJIT_DUP2_X2 extends JJITInstructionDef {

    public static final JJIT_DUP2_X2 INSTANCE = new JJIT_DUP2_X2();

    private JJIT_DUP2_X2() {
        super(KOperator.DUP2_X2);
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        KRegisterType t1 = model.peek(0);
        KRegisterType t2 = model.peek(1);
        if (t1.isType2() && t2.isType2()) {
            return new JJITChanges(JJITChangeOp.Pop(t1), JJITChangeOp.Pop(t2), JJITChangeOp.Push(t1), JJITChangeOp.Push(t2), JJITChangeOp.Push(t1));
        } else if(t1.isType2()){
            KRegisterType t3 = model.peek(2);
            return new JJITChanges(JJITChangeOp.Pop(t1), JJITChangeOp.Pop(t2), JJITChangeOp.Pop(t3), JJITChangeOp.Push(t1), JJITChangeOp.Push(t3), JJITChangeOp.Push(t2), JJITChangeOp.Push(t1));
        } else {
            KRegisterType t3 = model.peek(2);
            if(t3.isType2()){
                return new JJITChanges(JJITChangeOp.Pop(t1), JJITChangeOp.Pop(t2), JJITChangeOp.Pop(t3), JJITChangeOp.Push(t2), JJITChangeOp.Push(t1), JJITChangeOp.Push(t3), JJITChangeOp.Push(t2), JJITChangeOp.Push(t1));
            }else{
                KRegisterType t4 = model.peek(3);
                return new JJITChanges(JJITChangeOp.Pop(t1), JJITChangeOp.Pop(t2), JJITChangeOp.Pop(t3), JJITChangeOp.Pop(t4), JJITChangeOp.Push(t2), JJITChangeOp.Push(t1), JJITChangeOp.Push(t4), JJITChangeOp.Push(t3), JJITChangeOp.Push(t2), JJITChangeOp.Push(t1));
            }
        }
    }

    @Override
    public JJITInstructionDef transform(JJITTransformerContext context) {
        JJITChanges stackChanges = context.getNode().getChanges();
        KRegisterType t1 = stackChanges.get(0).getRegisterType();
        KRegisterType t2 = stackChanges.get(1).getRegisterType();
        JJITFlowControlNode node = context.getNode();
        boolean v1Type2 = t1.isType2();
        boolean v2Type2 = t2.isType2();
        if (v1Type2 && v2Type2) {
            return JJIT_DUP2_X2Type4.INSTANCE;
        } else if(v1Type2){
            return JJIT_DUP2_X2Type2.INSTANCE;
        }else{
            KRegisterType t3 = stackChanges.get(2).getRegisterType();
            boolean v3Type2 = t3.isType2();
            if(v3Type2){
                return JJIT_DUP2_X2Type3.INSTANCE;
            }else{
                return JJIT_DUP2_X2Type1.INSTANCE;
            }
        }
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        throw new IllegalArgumentException("Unsupported");
//        final JJITMethodSourceRun r = cls.run();
//        final JJITBloc b = r.getBloc();
//        final JJITName r1 = r.declareLocalVar("KRegister", "r", null);
//        final JJITName r2 = r.declareLocalVar("KRegister", "r", null);
//        final JJITName r3 = r.declareLocalVar("KRegister", "r", null);
//        final JJITName r4 = r.declareLocalVar("KRegister", "r", null);
//        r.pop(r1);
//        r.pop(r2);
//        final JJITIf If = b.If(r1.call("isType2").neg());
//        JJITBloc ok = If.Then();
//        JJITBloc ko = If.Else();
//        ok.set(r2, r.pop()).set(r3, r.pop()).addCode(r.getPush(r2)).addCode(r.getPush(r1)).addCode(r.getPush(r3)).addCode(r.getPush(r2)).addCode(r.getPush(r1));
//        ko.set(r2, r.pop()).addCode(r.getPush(r1)).addCode(r.getPush(r2)).addCode(r.getPush(r1));
    }

    @Override
    public JJITInstruction createSingleInstruction(final Object[] constantDefs, final IntHashMap labels) {
        return new JJITInstructionSingle() {

            JJITInstruction next;

            public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                next = instructions[index + 1];
            }

            public JJITInstruction run(KFrame frame) throws Exception {
                KRegister value1 = frame.pop();
                KRegister value2 = frame.pop();
                boolean t1 = value1.isType2();
                boolean t2 = value2.isType2();
                if (t1 & t2) {
                    frame.push(value1);
                    frame.push(value2);
                    frame.push(value1);
                } else if (!t1 && !t2) {
                    KRegister value3 = frame.pop();
                    if (!value3.isType2()) {
                        KRegister value4 = frame.pop();
                        frame.push(value2);
                        frame.push(value1);
                        frame.push(value4);
                        frame.push(value3);
                        frame.push(value2);
                        frame.push(value1);
                    } else {
                        frame.push(value2);
                        frame.push(value1);
                        frame.push(value3);
                        frame.push(value2);
                        frame.push(value1);
                    }
                } else if (t1) {
                    KRegister value3 = frame.pop();
                    frame.push(value1);
                    frame.push(value3);
                    frame.push(value2);
                    frame.push(value1);
                } else {
                    throw new IllegalArgumentException(getClass() + " : Unexpected");
                }
                return next;
            }
        };
    }
}
