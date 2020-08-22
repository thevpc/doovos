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
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_FCMP;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;

public final class JJIT_FCMPL extends JJIT__BASE_FCMP {

    public static final JJIT_FCMPL INSTANCE = new JJIT_FCMPL();

    private JJIT_FCMPL() {
        super(KOperator.FCMPL, Fields.KInteger_M1);
    }

    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new JJITInstructionSingle() {

            JJITInstruction next;

            public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                next = instructions[index + 1];
            }

            public JJITInstruction run(KFrame frame) throws Exception {
                float b = frame.popFloat();
                float a = frame.popFloat();
                if (Float.isNaN(a) || Float.isNaN(b)) {
                    frame.push(KInteger.M1);
                } else {
                    if (a == b) {
                        frame.push(KInteger.ZERO);
                    } else if (a > b) {
                        frame.push(KInteger.ONE);
                    } else {
                        frame.push(KInteger.M1);
                    }
                }
                return next;
            }
        };
    }
}
