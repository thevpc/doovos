///**
// * ====================================================================
// *             Doovos (Distributed Object Oriented Operating System)
// *
// * Doovos is a new Open Source Distributed Object Oriented Operating System
// * Design and implementation based on the Java Platform.
// * Actually, it is a try for designing a distributed operation system in
// * top of existing centralized/network OS.
// * Designed OS will follow the object oriented architecture for redefining
// * all OS resources (memory,process,file system,device,...etc.) in a highly
// * distributed context.
// * Doovos is also a distributed Java virtual machine that implements JVM
// * specification on top the distributed resources context.
// *
// * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
// * Doovos Kernel code is executed on host JVM
// *
// * Copyright (C) 2008-2010 Taha BEN SALAH
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc.,
// * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// * ====================================================================
// */
//package org.doovos.kernel.vanilla.jvm.interpreter.switchinterpreter.instr;
//
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionLoad;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//
//import java.rmi.RemoteException;
//
//public final class KJVM_DLOAD extends KInstructionSwitch implements Cloneable, KInstructionLoad {
//    private int index;
//    public static final KJVM_DLOAD DLOAD_0 = new KJVM_DLOAD(KOperator.DLOAD_0, 0);
//    public static final KJVM_DLOAD DLOAD_1 = new KJVM_DLOAD(KOperator.DLOAD_1, 1);
//    public static final KJVM_DLOAD DLOAD_2 = new KJVM_DLOAD(KOperator.DLOAD_2, 2);
//    public static final KJVM_DLOAD DLOAD_3 = new KJVM_DLOAD(KOperator.DLOAD_3, 3);
//    protected KInstruction next;
//
//    private KJVM_DLOAD(KOperator operator, int value) {
//        super(operator);
//        this.index = value;
//    }
//
//
//    public KJVM_DLOAD(long[] operands) {
//        super(KOperator.DLOAD, operands);
//        this.index = (int) operands[0];
//    }
//
//    public static int runStatic(KFrame frame, KInstructionSwitch i) throws RemoteException {
//        int index = (int) i.getOperands()[0];
//        KRegister value = frame.getLocal(index);
//        frame.push(value);
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KRegister value = frame.getLocal(index);
//        frame.push(value);
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        KRegister value = frame.getLocal(index);
//        frame.push(value);
//        frame.setInstruction(ordinal + 1);
//        return next;
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[index + 1];
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                null, null,
//                "    " + jitContext.pushConsumed("context.getLocal(" + index + ")")
//                , null, null, null
//        );
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_DLOAD that = (KJVM_DLOAD) o;
//
//        if (index != that.index) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + index;
//        return result;
//    }
//
//    public int getLoadIndex() {
//        return index;
//    }
//}
