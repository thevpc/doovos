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
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.memory.KReference;
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
//public final class KJVM_IF_ACMPNE extends KJVM__IF {
//    public KJVM_IF_ACMPNE(long[] operands) {
//        super(KOperator.IF_ACMPNE, operands);
//    }
//
//    public static int runStatic(KFrame frame, KInstruction ii) throws RemoteException {
//        long[] operands = ii.getOperands();
//        int label= (int) operands[0];
//        KReference value2 = frame.popReference();
//        KReference value1 = frame.popReference();
//        if ((value1.pointer != value2.pointer) || (value1.segment != value2.segment)) {
//            return label;
//        }
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KReference value2 = frame.popReference();
//        KReference value1 = frame.popReference();
//        if ((value1.pointer != value2.pointer) || (value1.segment != value2.segment)) {
//            return label;
//        }
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public KInstructionLnk run(KFrame frame) throws RemoteException {
//        KReference value2 = frame.popReference();
//        KReference value1 = frame.popReference();
//        if ((value1.pointer != value2.pointer) || (value1.segment != value2.segment)) {
//            frame.setInstruction(label);
//            return nextLabel;
//        }
//        frame.setInstruction(ordinalinc);
//        return next;
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                new String[]{"private KInstruction nextLabel"}, new String[]{
//                        "boolean jump"
//                },
//                "    {\n"
//                        + "        KReference value2 = " + jitContext.popReference() + ";\n" +
//                        "        KReference value1 = " + jitContext.popReference() + ";\n" +
//                        "        jump=(value1.pointer != value2.pointer) || (value1.segment != value2.segment);\n"
//                        + "\n}"
//                , "jump? " + label + ":KProcess.NEXT_STATEMENT", "jump?nextLabel:next",
//                new String[]{
//                        "this.nextLabel=code[" + label + "]"
//                }
//        );
//    }
//
//}
