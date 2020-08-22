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
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
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
//public final class KJVM_MULTIANEWARRAY extends KInstructionSwitch implements Cloneable {
//    private int dims;
//    private int typeId;
//    protected KInstruction next;
//    private String classNameString;
//    private KClass classByName;
//
//    public KJVM_MULTIANEWARRAY(long[] operands) {
//        super(KOperator.MULTIANEWARRAY, operands);
//        this.typeId = (int) operands[0];
//        this.dims = (int) operands[1];
//    }
//
//    public static int runStatic(KFrame frame, KInstructionSwitch ii) throws RemoteException {
//        long[] operands = ii.getOperands();
//        int typeId = (int) operands[0];
//        int dims = (int) operands[1];
//        KClass classByName;
//        String classNameString = frame.getConstantString(typeId);
//        KProcess p = frame.getProcess();
//        classByName = p.getClassRepository().getClassByName(classNameString);
//        if (frame.pushClassInitializerFrame(classByName)) {
//            return KProcess.NEXT_STATEMENT;
//        }
//        int[] dimValues = new int[dims];
//        int dimValues_length = dimValues.length;
//        for (int i = 0; i < dimValues_length; i++) {
//            dimValues[dimValues.length - i - 1] = frame.popInt();
//        }
//        frame.push(frame.getMemorySegment().allocMultiArray(classByName, dimValues));
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KProcess p = frame.getProcess();
//        if (classByName == null) {
//            classByName = p.getClassRepository().getClassByName(classNameString);
//            if (frame.pushClassInitializerFrame(classByName)) {
//                return KProcess.NEXT_STATEMENT;
//            }
//        }
//        int[] dimValues = new int[dims];
//        int dimValues_length = dimValues.length;
//        for (int i = 0; i < dimValues_length; i++) {
//            dimValues[dimValues_length - i - 1] = frame.popInt();
//        }
//        frame.push(frame.getMemorySegment().allocMultiArray(classByName, dimValues));
//        return KProcess.NEXT_STATEMENT;
//    }
//
//
//    @Override
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        KProcess p = frame.getProcess();
//        if (classByName == null) {
//            classByName = p.getClassRepository().getClassByName(classNameString);
//            if (frame.pushClassInitializerFrame(classByName)) {
//                KJVM_MULTIANEWARRAY base2 = (KJVM_MULTIANEWARRAY) base;
//                base2.classByName = classByName;
//                frame.getMethod().setStatus(KMethod.STATUS_DIRTY);
//                return frame.getThread().getFrame().getCurrentInstruction();
//            }
//        }
//        int[] dimValues = new int[dims];
//        int dims0 = dims;
//        for (int i = 0; i < dims0; i++) {
//            dimValues[dims0 - i - 1] = frame.popInt();
//        }
//        frame.push(frame.getMemorySegment().allocMultiArray(classByName, dimValues));
//        frame.setInstruction(ordinal + 1);
//        return next;
//
////        KProcess currentProcess = frame.getProcess();
////        String type = frame.getConstantString(typeId);
////        KClass[] klass = new KClass[dims];
////        String s = type;
////        for (int i = 0; i < dims; i++) {
////            klass[i] = currentProcess.getClassRepository().getClassByName(s, -1);
////            s = s.substring(1);
////        }
////        KMemorySegment memorySegment = currentProcess.getMemorySegment();
////        int[] dimValues = new int[dims];
////        for (int i = 0; i < dimValues.length; i++) {
////            dimValues[dimValues.length - i - 1] = frame.popInt();
////        }
////        KReference registerReference = fillArray(memorySegment, klass, dimValues, 0);
////        frame.push(registerReference);
////        //**LOG**//log(i.operator, context, "typeId=" + typeId + ";type=" + type + " ; size=" + size + " ; ref=" + registerReference);
////        return next;
//    }
//
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[index + 1];
//        classNameString = (String) method.getParentClass().getDefinition().getConstant(typeId);
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
//        KJVM_MULTIANEWARRAY that = (KJVM_MULTIANEWARRAY) o;
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
//        return true;
//    }
//
//
//    @Override
//    public boolean isLabel() throws RemoteException {
//        return classByName == null;
//    }
//
//    @Override
//    public KInstruction clone() {
//        if (classByName != null) {
//            return new KJVM_MULTIANEWARRAY0(typeId, dims, classByName);
//        }
//        return super.clone();
//    }
//}
