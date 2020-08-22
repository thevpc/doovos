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
package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter;

import java.rmi.RemoteException;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 *
 * @author vpc
 */
public abstract class KInstructionJITImpl implements KInstructionJIT, Opcodes{



    boolean jump;
    boolean label;
    int operator;
    long[] operands;
 //   ClassWriter cw;
    private static final long[] EMPTY_ARRAY_LONG = new long[0];




    public KInstructionJITImpl(int operator,boolean jump,boolean label) {
        this(operator, EMPTY_ARRAY_LONG,jump,label);
    }

    public KInstructionJITImpl(int operator,long[] operands,boolean jump,boolean label) {
        this.jump=jump;
        this.label=label;
        this.operator=operator;
        this.operands=operands;

    }

    @Override
    public KInstructionJIT clone() {
        try {
            return (KInstructionJIT) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new IllegalArgumentException(ex);
        }
    }


    public boolean isJump() throws RemoteException {
        return jump;
    }

    public boolean isLabel() throws RemoteException {
        return label;
    }

    public int[] getLabels() throws RemoteException {
        return NO_LABELS;
    }

    public void visit(MethodVisitor mv) throws RemoteException {
        //
    }

    public abstract void produceRunMethod(JITContext context) throws Exception;
    
    public long[] getOperands() {
        return operands;
    }

    public int getOperator() {
        return operator;
    }


}
