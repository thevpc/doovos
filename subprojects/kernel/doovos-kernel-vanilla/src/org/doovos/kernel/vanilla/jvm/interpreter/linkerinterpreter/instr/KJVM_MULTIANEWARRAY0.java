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
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.memory.KMemorySegment;
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
//public final class KJVM_MULTIANEWARRAY0 extends KInstructionLnk implements Cloneable {
//    private int dims;
//    private int typeId;
//    
//    private KClass classByName;
//
//    public KJVM_MULTIANEWARRAY0(int typeId,int dims, KClass classByName) {
//        super(KOperator.MULTIANEWARRAY, new long[]{typeId,dims});
//        this.typeId = typeId;
//        this.dims = dims;
//        this.classByName = classByName;
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        int dims0=dims;
//        int[] dimValues = new int[dims];
//        for (int i = 0; i < dims0; i++) {
//            dimValues[dims0 - i - 1] = frame.popInt();
//        }
//        KMemorySegment seg = frame.getMemorySegment();
//        frame.push(seg.allocMultiArray(classByName, dimValues));
//        return KProcess.NEXT_STATEMENT;
//    }
//
//
//    public KInstructionLnk run(KFrame frame) throws RemoteException {
//        int[] dimValues = new int[dims];
//        for (int i = 0; i < dimValues.length; i++) {
//            dimValues[dimValues.length - i - 1] = frame.popInt();
//        }
//        KMemorySegment seg = frame.getMemorySegment();
//        frame.push(seg.allocMultiArray(classByName, dimValues));
//        frame.setInstruction(ordinal+1);
//        return next;
//    }
//
//
//    public void relink(int index, KInstructionLnk[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[index + 1];
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        throw new IllegalArgumentException("Unsupported " + getClass().getName());
////        return new JITJavaSourceImpl(
////                null,
////                null, new String[]{
////                        KJVM__Constants.DEFINE_PROCESS,
////                        KJVM__Constants.DEFINE_MEMSEGMENT
////                },
////                new SrcAppender(4)
////                        .line("{")
////                        .indent()
////                        .line("int size = context.popInt();")
////                        .line("KReference registerReference = null;")
////                        .line("registerReference = memorySegment.allocRefArray(currentProcess.getClassByNameName(\"" + classNameString + "\", -1), size);")
////                        .line(jitContext.pushConsumed("registerReference"))
////                        .outdent()
////                        .line("}")
////                , null, null, null
////        );
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_MULTIANEWARRAY0 that = (KJVM_MULTIANEWARRAY0) o;
//
//        if (dims != that.dims) return false;
//        if (typeId != that.typeId) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + dims;
//        result = 31 * result + typeId;
//        return result;
//    }
//
//    @Override
//    public boolean isJump() throws RemoteException {
//        return false;
//    }
//
//
//    @Override
//    public boolean isLabel() throws RemoteException {
//        return false;
//    }
//}
