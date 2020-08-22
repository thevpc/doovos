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
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KLocalThread;
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
//public final class KJVM_INVOKESTATIC extends KInstructionSwitch implements Cloneable {
//    private int classNameIndex;
//    private int methodNameIndex;
//    private String classNameString;
//    private String methodNameString;
//    private KClass classByName;
//    private KMethod methodByName;
//
//    public KJVM_INVOKESTATIC(long[] operands) {
//        super(KOperator.INVOKESTATIC, operands);
//        this.classNameIndex = (int) operands[0];
//        this.methodNameIndex = (int) operands[1];
//    }
//
//    public static int runStatic(KFrame frame, KInstructionSwitch ii) throws RemoteException {
//        long[] operands = ii.getOperands();
//        int classNameIndex = (int) operands[0];
//        int methodNameIndex = (int) operands[1];
//        KLocalThread t = frame.getThread();
//        KProcess p = t.getProcess();
//        String classNameString = frame.getConstantString(classNameIndex);
//        String methodNameString = frame.getConstantString(methodNameIndex);
//
//        KClass classByName = p.getClassRepository().getClassByName(classNameString);
//        KMethod methodByName = classByName.getMethodBySignature(methodNameString);
//
//        KRegister[] args = new KRegister[methodByName.getParametersCount()];
//        for (int j = args.length - 1; j >= 0; j--) {
//            args[j] = frame.pop();
//        }
//        t.pushFrame( methodByName, args);
//
//        frame.pushClassInitializerFrame(classByName);
//        return KProcess.NEXT_STATEMENT;
//    }
//
//
//    public int run(KFrame frame) throws RemoteException {
//        KLocalThread t = frame.getThread();
//        KProcess p = t.getProcess();
//        if (classByName == null) {
//            classByName = p.getClassRepository().getClassByName(classNameString);
//            methodByName = classByName.getMethodBySignature(methodNameString);
//
//            KRegister[] args = new KRegister[methodByName.getParametersCount()];
//            for (int j = args.length - 1; j >= 0; j--) {
//                args[j] = frame.pop();
//            }
//            t.pushFrame( methodByName, args);
//
//            frame.pushClassInitializerFrame(classByName);
//        } else {
//            KRegister[] args = new KRegister[methodByName.getParametersCount()];
//            for (int j = args.length - 1; j >= 0; j--) {
//                args[j] = frame.pop();
//            }
//            t.pushFrame( methodByName, args);
//
//        }
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    @Override
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        KLocalThread t = frame.getThread();
//        KProcess p = t.getProcess();
//        if (methodByName == null) {
//            classByName = p.getClassRepository().getClassByName(classNameString);
//            methodByName = classByName.getMethodBySignature(methodNameString);
//
//            KRegister[] args = new KRegister[methodByName.getParametersCount()];
//            for (int j = args.length - 1; j >= 0; j--) {
//                args[j] = frame.pop();
//            }
//            t.pushFrame( methodByName, args);
//            frame.pushClassInitializerFrame(classByName);
//            KJVM_INVOKESTATIC base2 = (KJVM_INVOKESTATIC) base;
//            base2.classByName = classByName;
//            base2.methodByName = methodByName;
//            frame.getMethod().setStatus(KMethod.STATUS_DIRTY);
//        } else {
//            KRegister[] args = new KRegister[methodByName.getParametersCount()];
//            for (int j = args.length - 1; j >= 0; j--) {
//                args[j] = frame.pop();
//            }
//            t.pushFrame( methodByName, args);
//        }
//        frame.setInstruction(ordinal + 1);
//        return frame.getThread().getFrame().getCurrentInstruction();
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        classNameString = (String) method.getParentClass().getDefinition().getConstant(classNameIndex);
//        methodNameString = (String) method.getParentClass().getDefinition().getConstant(methodNameIndex);
//    }
//
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                new String[]{"java.util.NoSuchElementException"},
//                null, new String[]{
//                        KJVM__Constants.DEFINE_THREAD,
//                        KJVM__Constants.DEFINE_PROCESS,
//                        KJVM__Constants.DEFINE_MEMMANAGER
//                },
//                "    {\n"
//                        +
////                        "        KReference classNameReg = (KReference) context.getConstant("+classNameIndex+");\n" +
////                        "        String className = memoryManager.getStringChars(classNameReg);\n" +
////                        "\n" +
////                        "        KReference methodNameReg = (KReference) context.getConstant("+methodNameIndex+");\n" +
////                        "        String methodName = memoryManager.getStringChars(methodNameReg);\n" +
////                        "\n" +
////                        "       KClassDef dpc = currentProcess.getClassRepository().getClassDefByName(className.replace('/', '.'));\n" +
//                        "       KClassDef dpc = currentProcess.getClassByNameName(\"" + classNameString + "\",0).getDefinition();\n" +
//                        "       KMethodDef method = dpc.getMethodBySignature(\"" + methodNameString + "\");\n" +
//                        "       if (method == null) {\n" +
//                        "         throw new NoSuchElementException(\"method " + methodNameString + " in " + classNameString + "\");\n" +
//                        "       }\n" +
//                        "       KRegister[] args = new KRegister[method.getParametersCount()];\n" +
//                        "       for (int j = args.length - 1; j >= 0; j--) {\n" +
//                        "         args[j] = context.pop();\n" +
//                        "       }\n" +
//                        "       KFrame newContext = currentThread.pushFrame(currentProcess.getClassRepository().getClassDefByName(method.getClassName()), method, args);\n" +
//                        "       context.initializeClass(dpc);\n" +
//                        "       context.setInstruction(getOrdinal()+1);\n"
//                        + "\n    }"
//                , null,
//                "context.getThread().getContext().getInstruction()",
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
//        KJVM_INVOKESTATIC that = (KJVM_INVOKESTATIC) o;
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
//    @Override
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//
//}