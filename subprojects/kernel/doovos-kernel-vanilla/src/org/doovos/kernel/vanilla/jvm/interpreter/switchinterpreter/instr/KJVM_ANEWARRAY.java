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
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.process.KProcess;
//
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 22 févr. 2009
// * Time: 14:21:52
// * To change this template use File | Settings | File Templates.
// */
//public final class KJVM_ANEWARRAY extends KInstructionSwitch implements Cloneable {
//    private int typeId;
//    protected KInstruction next;
//    private String classNameString;
//    private KClass classByName;
//
//    public KJVM_ANEWARRAY(long[] operands) {
//        super(KOperator.ANEWARRAY, operands);
//        this.typeId = (int) operands[0];
//    }
//
//    public static int runStatic(KFrame frame, KInstructionDef i) throws RemoteException {
//        int typeId = (int) i.getOperands()[0];
//        String classNameString = frame.getConstantString(typeId);
//        KClass classByName = null;
//
//        int size = frame.popInt();
//        KProcess currentProcess = frame.getProcess();
////        if (classByName==null) {
//        classByName = currentProcess.getClassRepository().getClassByName(classNameString);
//        if (frame.getThread().pushClassInitializerFrame(classByName)) {
//            return KProcess.THIS_STATEMENT;
//        }
////        }
//        frame.push(frame.getMemorySegment().allocRefArray(classByName, size));
//        return KProcess.NEXT_STATEMENT;
//    }
//
//
//    public int run(KFrame frame) throws RemoteException {
//        int size = frame.popInt();
//        KProcess currentProcess = frame.getProcess();
//        if (classByName == null) {
//            classByName = currentProcess.getClassRepository().getClassByName(classNameString);
//            if (frame.getThread().pushClassInitializerFrame(classByName)) {
//                return KProcess.THIS_STATEMENT;
//            }
//        }
//        frame.push(frame.getMemorySegment().allocRefArray(classByName, size));
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    @Override
//    public KInstruction clone() {
//        if (classByName != null) {
//            return new KJVM_ANEWARRAY0(typeId, classByName);
//        }
//        return super.clone();
//    }
//}