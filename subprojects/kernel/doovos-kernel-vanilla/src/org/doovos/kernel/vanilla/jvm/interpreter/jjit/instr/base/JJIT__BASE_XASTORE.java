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
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.MethodStruct;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.structs.TypeStruct;

public abstract class JJIT__BASE_XASTORE extends JJITInstructionDef {

    private KRegisterType primtype;//"double"
    private TypeStruct castType;//"double"
    private MethodStruct setMethod;//"setDoubleArray"

    protected JJIT__BASE_XASTORE(KOperator op, KRegisterType primtype, TypeStruct castType, MethodStruct setMethod) {
        super(op);
        this.primtype = primtype;
        this.setMethod = setMethod;
        this.castType = castType;
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(
                JJITChangeOp.Pop(primtype),
                JJITChangeOp.POP_INTEGER,
                JJITChangeOp.POP_REF
        );
    }

    protected MethodStruct getSetMethod() {
        return setMethod;
    }

    protected KRegisterType getPrimtype() {
        return primtype;
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        JJITName memman = r.declareMemMan();
        JJITName index = r.declareIndex();
        JJITName val=null;
        switch(primtype){
            case INTEGER:{
                val = r.declareLocalVar(Types.INT, "i", null);
                r.popInt(val);
                break;
            }
            case DOUBLE:{
                val = r.declareLocalVar(Types.DOUBLE, "d", null);
                r.popDouble(val);
                break;
            }
            case FLOAT:{
                val = r.declareLocalVar(Types.FLOAT, "f", null);
                r.popFloat(val);
                break;
            }
            case LONG:{
                val = r.declareLocalVar(Types.LONG, "l", null);
                r.popLong(val);
                break;
            }
            case REF:{
                val = r.declareLocalVar(Types.KREFERENCE, "r", null);
                r.popRef(val);
                break;
            }
            default:{
                throw new IllegalArgumentException("Unsupported");
            }
        }
        r.popInt(index);
        r.addCode(memman.call(setMethod, r.popRef(), index, castType == null ? val : val.cast(castType)));
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT__BASE_XASTORE other = (JJIT__BASE_XASTORE) obj;
        if ((this.primtype == null) ? (other.primtype != null) : !this.primtype.equals(other.primtype)) {
            return false;
        }
        if ((this.castType == null) ? (other.castType != null) : !this.castType.equals(other.castType)) {
            return false;
        }
        if ((this.setMethod == null) ? (other.setMethod != null) : !this.setMethod.equals(other.setMethod)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.primtype != null ? this.primtype.hashCode() : 0);
        hash = 41 * hash + (this.castType != null ? this.castType.hashCode() : 0);
        hash = 41 * hash + (this.setMethod != null ? this.setMethod.hashCode() : 0);
        return hash;
    }

    @Override
    public String getShareName() {
        return operator.toString();
    }

    @Override
    public boolean isSharable(){
        return true;
    }


}
