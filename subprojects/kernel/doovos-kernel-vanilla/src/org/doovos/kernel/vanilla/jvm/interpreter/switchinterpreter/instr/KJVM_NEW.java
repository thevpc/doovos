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
//import org.doovos.kernel.api.memory.KReference;
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
//public final class KJVM_NEW extends KInstructionSwitch implements Cloneable {
//    private int classNameIndex;
//    private String classNameString;
//    protected KClass classByName;
//    protected KInstruction next;
//
//    public KJVM_NEW(long[] operands) {
//        super(KOperator.NEW, operands);
//        this.classNameIndex = (int) operands[0];
//    }
//
//    public static int runStatic(KFrame frame, KInstructionSwitch ii) throws RemoteException {
//        long[] operands = ii.getOperands();
//        int classNameIndex;
//        String classNameString;
//        KClass classByName;
//        classNameIndex = (int) operands[0];
//        classNameString = frame.getConstantString(classNameIndex);
//        KProcess p = frame.getProcess();
//        classByName = p.getClassRepository().getClassByName(classNameString, 0);
//        if (frame.pushClassInitializerFrame(classByName)) {
//            return KProcess.THIS_STATEMENT;
//        }
//        KReference registerReference = frame.getMemorySegment().allocObject(classByName);
//        frame.push(registerReference);
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KProcess p = frame.getProcess();
//        if (classByName == null) {
//            classByName = p.getClassRepository().getClassByName(classNameString, 0);
//            if (frame.pushClassInitializerFrame(classByName)) {
//                return KProcess.THIS_STATEMENT;
//            }
//        }
//        KReference registerReference = frame.getMemorySegment().allocObject(classByName);
//        frame.push(registerReference);
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    @Override
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        KProcess p = frame.getProcess();
//        if (classByName == null) {
//            classByName = p.getClassRepository().getClassByName(classNameString, 0);
//            if (frame.pushClassInitializerFrame(classByName)) {
//                KJVM_NEW base2 = (KJVM_NEW) base;
//                base2.classByName = classByName;
//                frame.getMethod().setStatus(KMethod.STATUS_DIRTY);
//                return frame.getThread().getFrame().getCurrentInstruction();
//            }
//        }
//        frame.push(frame.getMemorySegment().allocObject(classByName));
//        frame.setInstruction(ordinal + 1);
//        return next;
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[index + 1];
//        this.classNameString = (String) method.getParentClass().getDefinition().getConstant(classNameIndex);
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                null,
//                new String[]{
//                        "boolean jump",
//                        KJVM__Constants.DEFINE_PROCESS,
//                        KJVM__Constants.DEFINE_MEMSEGMENT
//                },
//                "    {\n"
//                        + "       String className = context.getConstantString(" + classNameIndex + ");\n" +
//                        "       KClass classByName = currentProcess.getClassByNameName(className, 0);\n" +
//                        "       jump= (context.initializeClass(classByName.getDefinition()));\n" +
//                        "       if(!jump){\n" +
//                        "         KReference registerReference = memorySegment.allocObject(classByName);\n" +
//                        "         " + jitContext.pushConsumed("registerReference") + "\n" +
//                        "       }\n" +
//                        "    }"
//                , "jump? KProcess.THIS_STATEMENT:KProcess.NEXT_STATEMENT", "jump?context.getThread().getContext().getInstruction():next",
//                null
//        );
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_NEW kjvm_new = (KJVM_NEW) o;
//
//        if (classNameIndex != kjvm_new.classNameIndex) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + classNameIndex;
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(operator.toString());
//        sb.append(" ");
//        sb.append(classNameString);
//        return sb.toString();
//    }
//
//    @Override
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//
//    @Override
//    public boolean isLabel() throws RemoteException {
//        return classByName == null;
//    }
//
//    @Override
//    public KInstruction clone() {
//        if (classByName != null) {
//            return new KJVM_NEW0(classNameIndex, classByName);
//        }
//        return super.clone();
//    }
//}
