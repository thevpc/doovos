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
//import org.doovos.kernel.api.memory.KInteger;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//
//import java.rmi.RemoteException;
//
//public final class KJVM_LCMP extends KInstructionSwitch implements Cloneable {
//    public static final KJVM_LCMP INSTANCE = new KJVM_LCMP();
//    protected KInstruction next;
//
//    private KJVM_LCMP() {
//        super(KOperator.LCMP);
//    }
//
//    public int run(KFrame context) throws RemoteException {
//        long b = context.popLong();
//        long a = context.popLong();
//        if (a == b) {
//            context.push(KInteger.ZERO);
//        } else if (a > b) {
//            context.push(KInteger.ONE);
//        } else {
//            context.push(KInteger.M1);
//        }
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        long b = frame.popLong();
//        long a = frame.popLong();
//        if (a == b) {
//            frame.push(KInteger.ZERO);
//        } else if (a > b) {
//            frame.push(KInteger.ONE);
//        } else {
//            frame.push(KInteger.M1);
//        }
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
//                "    {\n"
//                        + "       long b = " + jitContext.popLong() + ";\n" +
//                        "       long a = " + jitContext.popLong() + ";\n" +
//                        "       if(a==b){\n" +
//                        "          " + jitContext.pushConsumed("KInteger.ZERO") + "\n" +
//                        "       }else if(a>b){\n" +
//                        "          " + jitContext.pushConsumed("KInteger.ONE") + "\n" +
//                        "       }else{\n" +
//                        "          " + jitContext.pushConsumed("KInteger.M1") + "\n" +
//                        "       }\n" +
//                        "    }"
//                , null, null, null
//        );
//    }
//}
