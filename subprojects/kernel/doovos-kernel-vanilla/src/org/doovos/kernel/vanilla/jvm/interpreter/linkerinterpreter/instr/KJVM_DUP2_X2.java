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
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter.KInstructionLnk;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//
//import java.rmi.RemoteException;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 22 févr. 2009
// * Time: 14:21:52
// * To change this template use File | Settings | File Templates.
// */
//public final class KJVM_DUP2_X2 extends KInstructionLnk implements Cloneable {
//    public static final KJVM_DUP2_X2 INSTANCE = new KJVM_DUP2_X2();
//    
//
//    private KJVM_DUP2_X2() {
//        super(KOperator.DUP2_X2);
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KRegister value1 = frame.pop();
//        KRegister value2 = frame.pop();
//        boolean t1 = value1.isType2();
//        boolean t2 = value2.isType2();
//        if (t1 & t2) {
//            frame.push(value1);
//            frame.push(value2);
//            frame.push(value1);
//        } else if (!t1 && !t2) {
//            KRegister value3 = frame.pop();
//            if (!value3.isType2()) {
//                KRegister value4 = frame.pop();
//                frame.push(value2);
//                frame.push(value1);
//                frame.push(value4);
//                frame.push(value3);
//                frame.push(value2);
//                frame.push(value1);
//            } else {
//                frame.push(value2);
//                frame.push(value1);
//                frame.push(value3);
//                frame.push(value2);
//                frame.push(value1);
//            }
//        } else if (t1) {
//            KRegister value3 = frame.pop();
//            frame.push(value1);
//            frame.push(value3);
//            frame.push(value2);
//            frame.push(value1);
//        } else {
//            throw new IllegalArgumentException(getClass() + " : Unexpected");
//        }
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public KInstructionLnk run(KFrame frame) throws RemoteException {
////        KRegister value1 = context.pop();
////        KRegister value2 = context.pop();
////        if (value1.isType2()) {
////            context.push(value1);
////            context.push(value2);
////            context.push(value1);
////        } else {
////            KRegister value3 = context.pop();
////            context.push(value2);
////            context.push(value1);
////            context.push(value3);
////            context.push(value2);
////            context.push(value1);
////        }
//        KRegister value1 = frame.pop();
//        KRegister value2 = frame.pop();
//        boolean t1 = value1.isType2();
//        boolean t2 = value2.isType2();
//        if (t1 & t2) {
//            frame.push(value1);
//            frame.push(value2);
//            frame.push(value1);
//        } else if (!t1 && !t2) {
//            KRegister value3 = frame.pop();
//            if (!value3.isType2()) {
//                KRegister value4 = frame.pop();
//                frame.push(value2);
//                frame.push(value1);
//                frame.push(value4);
//                frame.push(value3);
//                frame.push(value2);
//                frame.push(value1);
//            } else {
//                frame.push(value2);
//                frame.push(value1);
//                frame.push(value3);
//                frame.push(value2);
//                frame.push(value1);
//            }
//        } else if (t1) {
//            KRegister value3 = frame.pop();
//            frame.push(value1);
//            frame.push(value3);
//            frame.push(value2);
//            frame.push(value1);
//        } else {
//            throw new IllegalArgumentException(getClass() + " : Unexpected");
//        }
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
//                "    {\n" +
//                        "        KRegister value1 = context.pop();\n" +
//                        "        KRegister value2 = context.pop();\n" +
//                        "        if(value1.isType2()){\n" +
//                        "            context.push(value1);\n" +
//                        "            context.push(value2);\n" +
//                        "            context.push(value1);\n" +
//                        "        }else{\n" +
//                        "            KRegister value3 = context.pop();\n" +
//                        "            context.push(value2);\n" +
//                        "            context.push(value1);\n" +
//                        "            context.push(value3);\n" +
//                        "            context.push(value2);\n" +
//                        "            context.push(value1);\n" +
//                        "        }\n" +
//                        "        }\n" +
//                        "    }"
//                , null, null, null
//        );
//    }
//}
