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
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KRegister;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITOp3;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITType;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class JJIT_INSTANCEOF extends JJITInstructionDef {

    private int classNameIndex;
    private String className;
    protected KInstruction next;

    public JJIT_INSTANCEOF(Object[] constants,int classNameIndex) {
        super(KOperator.INSTANCEOF);
        this.classNameIndex = classNameIndex;
        this.className = (String)constants[classNameIndex];
    }

    @Override
    public String[] getLoadingClasses() {
        return new String[]{className};
    }

    @Override
    public boolean isJump() {
        return false;
    }


    @Override
    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
        return new JJITInstructionSingle() {
            JJITInstruction next;
            KClass kclass;
            public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
                next=instructions[index+1];
            }

            public JJITInstruction run(KFrame frame) throws Exception {
                KReference ref=frame.popRef();
                if(ref.isNull()){
                    frame.push(KInteger.ZERO);
                }
                if(kclass==null){
                    kclass=frame.getClassRepository().getClassByName(className);
                }
                frame.push(kclass.isAssignableFrom(ref)?KInteger.ONE:KInteger.ZERO);
                return next;
            }
        };
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(JJITChangeOp.POP_REF, JJITChangeOp.PUSH_INTEGER);
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        JJITMethodSourceRun r = cls.run();
        JJITName memman = r.declareMemMan();
        JJITName kclass = r.declareAndInitKClass(className);
        JJITName ref = r.declareRef();
        r.popRef(ref);
        JJITOp3 o3=new JJITOp3(ref.call(Calls.KReference_isNull), new JJITType(Types.KINTEGER).field(Fields.KInteger_ZERO),
                new JJITOp3(kclass.call(Calls.KClass_isAssignableFrom,memman.call(Calls.MemoryManager_getKClass, ref)), new JJITType(Types.KINTEGER).field(Fields.KInteger_ONE), new JJITType(Types.KINTEGER).field(Fields.KInteger_ZERO))
                );
        r.push(o3);
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

        JJIT_INSTANCEOF that = (JJIT_INSTANCEOF) o;

        if (classNameIndex != that.classNameIndex) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + classNameIndex;
        return result;
    }

    @Override
    public String toString() {
        return getOperator()+"("+className+")";
    }

}
