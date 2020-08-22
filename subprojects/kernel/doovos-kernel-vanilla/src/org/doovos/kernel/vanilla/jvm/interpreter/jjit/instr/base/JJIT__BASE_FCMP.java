package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITOp3;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.FieldStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

import static org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp.POP_FLOAT;
import static org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp.PUSH_INTEGER;

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

public abstract class JJIT__BASE_FCMP extends JJITInstructionDef /*KJVM__IF*/ {
    private FieldStruct val;
    protected JJIT__BASE_FCMP(KOperator op,FieldStruct val) {
        super(op);
        this.val=val;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        //return new JJITStackChange(new KRegisterType[]{KRegisterType.FLOAT, KRegisterType.FLOAT}, new KRegisterType[]{KRegisterType.INTEGER});
        return new JJITChanges(
                POP_FLOAT,
                POP_FLOAT,
                PUSH_INTEGER
        );
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        JJITName a=r.declareLocalVar(Types.FLOAT, "f", null);
        JJITName b=r.declareLocalVar(Types.FLOAT, "f", null);
        final JJITType FloatClazz = new JJITType(new TypeStruct(Float.class));
        final JJITType KIntegerClazz = new JJITType(Types.KINTEGER);
        
        r.popFloat(b);
        r.popFloat(a);
        JJITOp3 o=new JJITOp3(
                FloatClazz.call(Calls.Float_isNaN, a).or(FloatClazz.call(Calls.Float_isNaN, b)),
                KIntegerClazz.field(val),
                new JJITOp3(a.eq(b),
                    KIntegerClazz.field(Fields.KInteger_ZERO),
                new JJITOp3(a.gt(b),
                    KIntegerClazz.field(Fields.KInteger_ONE),
                    KIntegerClazz.field(Fields.KInteger_M1)
                )));
        r.push(o);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT__BASE_FCMP other = (JJIT__BASE_FCMP) obj;
        if ((this.val == null) ? (other.val != null) : !this.val.equals(other.val)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.val != null ? this.val.hashCode() : 0);
        return hash;
    }

  
}
