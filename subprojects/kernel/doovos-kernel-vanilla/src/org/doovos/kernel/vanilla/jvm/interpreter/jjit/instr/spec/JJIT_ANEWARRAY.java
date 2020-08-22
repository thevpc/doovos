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
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class JJIT_ANEWARRAY extends JJITInstructionDef {

    private int typeId;
    private String typeName;

    public JJIT_ANEWARRAY(Object[] constants, int typeId) {
        super(KOperator.ANEWARRAY);
        this.typeId = typeId;
        this.typeName = (String) constants[typeId];
    }

    @Override
    public String[] getLoadingClasses() {
        return new String[]{typeName};
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        String classNameString = (String) cls.getConstants()[typeId];
        final JJITMethodSourceRun r = cls.run();

        r.declareProcess();
        JJITName memman = r.declareMemMan();
        JJITName index = r.declareIndex();
        r.declareRef();

        r.popInt(index);
        JJITName v = r.declareAndInitKClass(classNameString);
        r.push(memman.call(Calls.MemoryManager_allocRefArray, v, index));
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(
                JJITChangeOp.POP_INTEGER,
                JJITChangeOp.PUSH_REF
        );
    }


    @Override
    public JJITInstruction createSingleInstruction(final Object[] constantDefs, final IntHashMap labels) {
        return new JJITInstructionSingle() {

            private JJITInstruction next;
            private KClass kclass;
            private String className;

            public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                next = instructions[index + 1];
                className = (String) constantDefs[typeId];
            }

            public JJITInstruction run(KFrame frame) throws Exception {
                int size = frame.popInt();
                if (kclass == null) {
                    kclass = frame.getClassRepository().getClassByName(className);
                }
                frame.push(frame.getMemorySegment().allocRefArray(kclass, size));
                return next;
            }
        };
    }

    @Override
    public String toString() {
        return getOperator() + "(" + typeId+")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT_ANEWARRAY other = (JJIT_ANEWARRAY) obj;
        if (this.typeId != other.typeId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.typeId;
        return hash;
    }
}
