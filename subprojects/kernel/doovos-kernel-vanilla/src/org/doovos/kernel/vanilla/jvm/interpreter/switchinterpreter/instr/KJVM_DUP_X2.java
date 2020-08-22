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
//import org.doovos.kernel.api.memory.KDouble;
//import org.doovos.kernel.api.memory.KLong;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
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
//public final class KJVM_DUP_X2 extends KInstructionSwitch implements Cloneable {
//    public static final KJVM_DUP_X2 INSTANCE = new KJVM_DUP_X2();
//    protected KInstruction next;
//
//    private KJVM_DUP_X2() {
//        super(KOperator.DUP_X2);
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KRegister value1 = frame.pop();
//        KRegister value2 = frame.pop();
//        if (value2.isType2()) {
//            frame.push(value1);
//            frame.push(value2);
//            frame.push(value1);
//        } else {
//            KRegister value3 = frame.pop();
//            frame.push(value1);
//            frame.push(value3);
//            frame.push(value2);
//            frame.push(value1);
//        }
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        KRegister value1 = frame.pop();
//        KRegister value2 = frame.pop();
//        if (value2 instanceof KDouble || value2 instanceof KLong) {
//            frame.push(value1);
//            frame.push(value2);
//            frame.push(value1);
//        } else {
//            KRegister value3 = frame.pop();
//            frame.push(value1);
//            frame.push(value3);
//            frame.push(value2);
//            frame.push(value1);
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
//                "    {\n" +
//                        "        KRegister value1 = context.pop();\n" +
//                        "        KRegister value2 = context.pop();\n" +
//                        "        if(value2 instanceof KDouble || value2 instanceof KLong){\n" +
//                        "            context.push(value1);\n" +
//                        "            context.push(value2);\n" +
//                        "            context.push(value1);\n" +
//                        "        }else{\n" +
//                        "            KRegister value3 = context.pop();\n" +
//                        "            context.push(value1);\n" +
//                        "            context.push(value3);\n" +
//                        "            context.push(value2);\n" +
//                        "            context.push(value1);\n" +
//                        "        }\n" +
//                        "    }"
//                , null, null, null
//        );
//    }
//}
