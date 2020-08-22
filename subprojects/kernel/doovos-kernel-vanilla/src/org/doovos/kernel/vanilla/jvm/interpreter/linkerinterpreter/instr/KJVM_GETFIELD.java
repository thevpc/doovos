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
//import org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter.instr.opt.KJVM_GETFIELD0;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter.KInstructionLnk;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KClassDef;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.jvm.reflect.KField;
//import org.doovos.kernel.api.process.KProcess;
//
//import java.rmi.RemoteException;
//
//public final class KJVM_GETFIELD extends KInstructionLnk implements Cloneable {
//    private int classNameIndex;
//    private int attributeIndex;
//    private String classNameString;
//    private String attributeString;
//    protected KClass classByName;
//    protected KField fieldByName;
//    
//
//    public KJVM_GETFIELD(long[] operands) {
//        super(KOperator.GETFIELD, operands);
//        this.classNameIndex = (int) operands[0];
//        this.attributeIndex = (int) operands[1];
//    }
//
//    @Override
//    public KInstructionLnk run(KFrame frame) throws RemoteException {
//        if (classByName == null) {
//            KProcess p = frame.getProcess();
//            classByName = p.getClassRepository().getClassByName(classNameString);
//            fieldByName = classByName.getField(attributeString,true);
//            if (frame.pushClassInitializerFrame(classByName)) {
////                KJVM_GETFIELD base2=(KJVM_GETFIELD) base;
////                base2.classByName=classByName;
////                base2.fieldByName=fieldByName;
////                frame.getMethod().setStatus(KMethod.STATUS_DIRTY);
//                return (KInstructionLnk) frame.getThread().getFrame().getCurrentInstruction();
//            }
//        }
//
//        KRegister value = fieldByName.getInstanceValue(frame.popReference());
//        frame.push(value);
//        frame.setInstruction(ordinal + 1);
//        return next;
//    }
//
//    public void relink(int index, KInstructionLnk[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[index + 1];
//        KClassDef classDefinition = method.getParentClass().getDefinition();
//        classNameString = (String) classDefinition.getConstant(classNameIndex);
//        attributeString = (String) classDefinition.getConstant(attributeIndex);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_GETFIELD that = (KJVM_GETFIELD) o;
//
//        if (attributeIndex != that.attributeIndex) return false;
//        if (classNameIndex != that.classNameIndex) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + classNameIndex;
//        result = 31 * result + attributeIndex;
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(operator.toString());
//        sb.append(" ");
//        sb.append(classNameString);
//        sb.append(" ");
//        sb.append(attributeString);
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
//        return classByName==null;
//    }
//
//    @Override
//    public KInstruction clone() {
//        if(classByName!=null){
//            return new KJVM_GETFIELD0(classNameIndex, attributeIndex,fieldByName,classByName);
//        }
//        return super.clone();
//    }
//}
