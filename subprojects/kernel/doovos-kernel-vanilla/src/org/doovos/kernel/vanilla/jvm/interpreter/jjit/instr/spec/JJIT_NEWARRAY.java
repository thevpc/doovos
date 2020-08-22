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
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;

public class JJIT_NEWARRAY extends JJITInstructionDef {

    private int type;
    public static JJIT_NEWARRAY[] JJIT_NEWARRAYS = new JJIT_NEWARRAY[12];

    static {
        JJIT_NEWARRAYS[4] = new JJIT_NEWARRAY(4);
        JJIT_NEWARRAYS[5] = new JJIT_NEWARRAY(5);
        JJIT_NEWARRAYS[6] = new JJIT_NEWARRAY(6);
        JJIT_NEWARRAYS[7] = new JJIT_NEWARRAY(7);
        JJIT_NEWARRAYS[8] = new JJIT_NEWARRAY(8);
        JJIT_NEWARRAYS[9] = new JJIT_NEWARRAY(9);
        JJIT_NEWARRAYS[10] = new JJIT_NEWARRAY(10);
        JJIT_NEWARRAYS[11] = new JJIT_NEWARRAY(11);
    }

    public JJIT_NEWARRAY(int type) {
        super(KOperator.NEWARRAY);
        this.type = type;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(JJITChangeOp.POP_INTEGER, JJITChangeOp.PUSH_REF);
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        JJITName memseg = r.declareMemSeg();
        MethodStruct methodName = Calls.MemoryManager_allocBooleanArray;
        switch (type) {
            case 4: {
                methodName = Calls.MemoryManager_allocBooleanArray;
                break;
            }
            case 5: {
                methodName = Calls.MemoryManager_allocCharArray;
                break;
            }
            case 6: {
                methodName = Calls.MemoryManager_allocFloatArray;
                break;
            }
            case 7: {
                methodName = Calls.MemoryManager_allocDoubleArray;
                break;
            }
            case 8: {
                methodName = Calls.MemoryManager_allocByteArray;
                break;
            }
            case 9: {
                methodName = Calls.MemoryManager_allocShortArray;
                break;
            }
            case 10: {
                methodName = Calls.MemoryManager_allocIntArray;
                break;
            }
            case 11: {
                methodName = Calls.MemoryManager_allocLongArray;
                break;
            }
        }
        r.push(memseg.call(methodName, r.popInt()));
    }

    @Override
    public JJITInstruction createSingleInstruction(final Object[] constantDefs, final IntHashMap labels) {
        switch (type) {
            case 4: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocByteArray(frame.popInt()));
                        return next;
                    }
                };
            }
            case 5: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocCharArray(frame.popInt()));
                        return next;
                    }
                };
            }
            case 6: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocFloatArray(frame.popInt()));
                        return next;
                    }
                };
            }
            case 7: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocDoubleArray(frame.popInt()));
                        return next;
                    }
                };
            }
            case 8: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocByteArray(frame.popInt()));
                        return next;
                    }
                };
            }
            case 9: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocShortArray(frame.popInt()));
                        return next;
                    }
                };
            }
            case 10: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocIntArray(frame.popInt()));
                        return next;
                    }
                };
            }
            case 11: {
                return new JJITInstructionSingle() {

                    private JJITInstruction next;

                    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                        next = instructions[index + 1];
                    }

                    public JJITInstruction run(KFrame frame) throws Exception {
                        frame.push(frame.getMemorySegment().allocLongArray(frame.popInt()));
                        return next;
                    }
                };
            }
        }
        throw new IllegalArgumentException("Unsupported type "+type);
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

        JJIT_NEWARRAY that = (JJIT_NEWARRAY) o;

        if (type != that.type) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + type;
        return result;
    }
}
