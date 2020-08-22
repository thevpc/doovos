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
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.util.JavaByteCodeUtils;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_INVOKE;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class JJIT_INVOKEVIRTUAL extends JJIT__BASE_INVOKE {

    public JJIT_INVOKEVIRTUAL(Object[] constants, int classNameIndex, int methodNameIndex) {
        super(KOperator.INVOKEVIRTUAL, constants, classNameIndex, methodNameIndex);
    }

    private static class Single extends JJITInstructionSingle implements Cloneable {
        private String methodNameString;
        private int paramsCount;
        private int nextpc;
        private KMemoryManager memman;

        private Single(JJIT__BASE_INVOKE d, String methodNameString) {
            super(d);
            this.methodNameString = methodNameString;
            paramsCount = JavaByteCodeUtils.getParametersCount(methodNameString) + 1;
        }

        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
            nextpc = index + 1;
            memman= process.getMemoryManager();
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            KLocalThread t = frame.getThread();
            KRegister[] args = new KRegister[paramsCount];
            for (int j = args.length - 1; j > 0; j--) {
                args[j] = frame.pop();
            }
            KReference ref = frame.popRef();
            args[0] = ref;
            KClass kClass = memman.getKClass(ref);
            KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
            frame.setProgramCounter(nextpc);
            KFrame nextFrame = t.pushFrame(implMethod, args);
            return (JJITInstruction) nextFrame.getCurrentInstruction();
        }
    }

    @Override
    public JJITInstruction createSingleInstruction(final Object[] constantDefs, final IntHashMap labels) {
        return new Single(this, (String) constantDefs[methodNameIndex]);
    }

}


