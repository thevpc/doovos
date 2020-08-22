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
//package org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter.instr;
//
//import org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter.KInstructionLnk;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.memory.KInteger;
//import org.doovos.kernel.api.process.KProcess;
//
//import java.rmi.RemoteException;
//
//public final class KJVM_D2I extends KInstructionLnk implements Cloneable {
//    public static final KJVM_D2I INSTANCE = new KJVM_D2I();
//    
//
//    private KJVM_D2I() {
//        super(KOperator.D2I);
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        frame.push(new KInteger((int) frame.popDouble()));
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public KInstructionLnk run(KFrame frame) throws RemoteException {
//        frame.push(new KInteger((int) frame.popDouble()));
//        frame.setInstruction(ordinal + 1);
//        return next;
//    }
//
//    public void relink(int index, KInstructionLnk[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[index + 1];
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                null, null,
//                jitContext.pushConsumed("new KInteger((int) " + jitContext.popDouble() + ")")
//                , null, null, null
//        );
//    }
//
//}
