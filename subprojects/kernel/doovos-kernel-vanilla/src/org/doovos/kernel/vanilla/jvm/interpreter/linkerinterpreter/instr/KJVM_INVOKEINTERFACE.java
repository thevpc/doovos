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
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KLocalThread;
//
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.Doovos;
//import org.doovos.kernel.api.jvm.reflect.KClassRepository;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 22 févr. 2009
// * Time: 14:21:52
// * To change this template use File | Settings | File Templates.
// */
//public final class KJVM_INVOKEINTERFACE extends KInstructionLnk implements Cloneable {
//    private int classNameIndex;
//    private int methodNameIndex;
//    private String classNameString;
//    private String methodNameString;
//    private KClass interfaceName;
//    private KMethod interfaceMethod;
//
//    public KJVM_INVOKEINTERFACE(long[] operands) {
//        super(KOperator.INVOKEINTERFACE, operands);
//        this.classNameIndex = (int) operands[0];
//        this.methodNameIndex = (int) operands[1];
//    }
//
// 
//    @Override
//    public KInstructionLnk run(KFrame frame) throws RemoteException {
//        KLocalThread t = frame.getThread();
//        KProcess p = t.getProcess();
//        KClassRepository repository = p.getClassRepository();
//        if(interfaceName==null){
//            interfaceName = repository.getClassByName(classNameString);
//            interfaceMethod = interfaceName.getVirtualMethodBySignature(methodNameString);
//        }
//        KRegister[] args = new KRegister[interfaceMethod.getDefinition().getParametersCount() + 1];
//        for (int j = args.length - 1; j > 0; j--) {
//            args[j] = frame.pop();
//        }
//        args[0] = frame.popReference();
//        KClass kClass = Doovos.getSystem().getMemoryManager().getPointer(((KReference) args[0])).getKClass();
//        KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
//        KClass implClass = repository.getClassByName(implMethod.getClassName());
//        t.pushFrame(implMethod, args);
//        frame.setInstruction(ordinal + 1);
//        return (KInstructionLnk) t.getFrame().getCurrentInstruction();
//    }
//
//    @Override
//    public void relink(int index, KInstructionLnk[] code, KMethod method) {
//        this.ordinal = index;
//        classNameString = (String) method.getParentClass().getDefinition().getConstant(classNameIndex);
//        methodNameString = (String) method.getParentClass().getDefinition().getConstant(methodNameIndex);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_INVOKEINTERFACE that = (KJVM_INVOKEINTERFACE) o;
//
//        if (classNameIndex != that.classNameIndex) return false;
//        if (methodNameIndex != that.methodNameIndex) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + classNameIndex;
//        result = 31 * result + methodNameIndex;
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(operator.toString());
//        sb.append(" ");
//        sb.append(classNameString);
//        sb.append(" ");
//        sb.append(methodNameString);
//        return sb.toString();
//    }
//
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//
//}
