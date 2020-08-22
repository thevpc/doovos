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
import org.doovos.kernel.api.jvm.jni.KJNIMethodInfo;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.util.JavaByteCodeUtils;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITTransformerContext;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_INVOKE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_INVOKE_HOST;

public final class JJIT_INVOKESTATIC extends JJIT__BASE_INVOKE {

    public JJIT_INVOKESTATIC(Object[] constants, int classNameIndex, int methodNameIndex) {
        super(KOperator.INVOKESTATIC, constants, classNameIndex, methodNameIndex);
    }

    @Override
    public JJITInstructionDef transform(JJITTransformerContext context) {
        String cn = getClassName();
        String mn = getMethodName();
        //|| (cn.equals("java.lang.System") && mn.substring(0,mn.indexOf('(')).equals("arraycopy"))
        KJNIMethodInfo impl = context.getG2h().getImpl(cn, mn);
        if (impl!=null) {
            return new JJIT_INVOKE_HOST(KOperator.INVOKESTATIC, impl);
        }
        return this;
    }

    private static class Single extends JJITInstructionSingle implements Cloneable {
        private String methodNameString;
        private String classNameString;
        private int paramsCount;
        private transient KClass kclass;
        private int nextpc;

        private Single(JJIT__BASE_INVOKE d, String classNameString,String methodNameString) {
            super(d);
            this.methodNameString = methodNameString;
            this.classNameString = classNameString;
            paramsCount = JavaByteCodeUtils.getParametersCount(methodNameString);
        }

        public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
            nextpc = index + 1;
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            KLocalThread t = frame.getThread();
                KRegister[] args = new KRegister[paramsCount];
                for (int j = args.length - 1; j >= 0; j--) {
                    args[j] = frame.pop();
                }
                if (kclass == null) {
                    kclass = frame.getClassRepository().getClassByName(classNameString);
                }
                KMethod implMethod = kclass.getVirtualMethodBySignature(methodNameString);
                frame.setProgramCounter(nextpc);
                KFrame nextFrame = t.pushFrame(implMethod, args);
                return (JJITInstruction)nextFrame.getCurrentInstruction();
        }
    }

    @Override
    public JJITInstruction createSingleInstruction(final Object[] constantDefs, final IntHashMap labels) {
        return new Single(this, (String) constantDefs[classNameIndex],(String) constantDefs[methodNameIndex]);
    }

}
