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
//import org.doovos.kernel.api.Doovos;
//import org.doovos.kernel.api.jvm.bytecode.KClassDef;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KLocalThread;
//import org.doovos.kernel.api.resource.classrepository.KClassRepository;
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
//public final class KJVM_INVOKEVIRTUAL extends KInstructionSwitch implements Cloneable {
//    private int classNameIndex;
//    private int methodNameIndex;
//    private String classNameString;
//    private String methodNameString;
//    private KClass classByName;
//    private KMethod methodByName;
//
//    public KJVM_INVOKEVIRTUAL(long[] operands) {
//        super(KOperator.INVOKEVIRTUAL, operands);
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
//        KClassRepository repository = p.getClassRepository();
//        KClass classByName = repository.getClassByName(classNameString);
//        KMethod methodByName = classByName.getVirtualMethodBySignature(methodNameString);
//
//        KRegister[] args = new KRegister[methodByName.getParametersCount() + 1];
//        for (int j = args.length - 1; j > 0; j--) {
//            args[j] = frame.pop();
//        }
//        args[0] = frame.popReference();
//        KClass kClass = Doovos.getSystem().getMemoryManager().getPointer(((KReference) (args[0]))).getKClass();
//        if (kClass.isArray()) {
//            kClass = repository.getClassByName("java.lang.Object");
//        }
//        KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
//        KClass implClass = repository.getClassByName(implMethod.getClassName());
//        t.pushFrame(implMethod, args);
//
//        frame.pushClassInitializerFrame(classByName);
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KLocalThread t = frame.getThread();
//        KProcess p = t.getProcess();
//        KClassRepository repository = p.getClassRepository();
//        if (classByName == null) {
//            classByName = repository.getClassByName(classNameString);
//            methodByName = classByName.getVirtualMethodBySignature(methodNameString);
//
//            KRegister[] args = new KRegister[methodByName.getParametersCount() + 1];
//            for (int j = args.length - 1; j > 0; j--) {
//                args[j] = frame.pop();
//            }
//            args[0] = frame.popReference();
//            KClass kClass = Doovos.getSystem().getMemoryManager().getPointer(((KReference) (args[0]))).getKClass();
//            if (kClass.isArray()) {
//                kClass = repository.getClassByName("java.lang.Object");
//            }
//            KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
//            KClass implClass = repository.getClassByName(implMethod.getClassName());
//            t.pushFrame(implMethod, args);
//
//            frame.pushClassInitializerFrame(classByName);
//        } else {
//            KRegister[] args = new KRegister[methodByName.getParametersCount() + 1];
//            for (int j = args.length - 1; j > 0; j--) {
//                args[j] = frame.pop();
//            }
//            args[0] = frame.popReference();
//            KClass kClass = Doovos.getSystem().getMemoryManager().getPointer(((KReference) (args[0]))).getKClass();
//            if (kClass.isArray()) {
//                kClass = repository.getClassByName("java.lang.Object");
//            }
//            KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
//            KClass implClass = repository.getClassByName(implMethod.getClassName());
//            t.pushFrame(implMethod, args);
//
//        }
//
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    @Override
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        KLocalThread t = frame.getThread();
//        KProcess p = t.getProcess();
//        KClassRepository repository = p.getClassRepository();
//        if (classByName == null) {
//            classByName = repository.getClassByName(classNameString);
//            methodByName = classByName.getVirtualMethodBySignature(methodNameString);
//
//            KRegister[] args = new KRegister[methodByName.getParametersCount() + 1];
//            for (int j = args.length - 1; j > 0; j--) {
//                args[j] = frame.pop();
//            }
//            args[0] = frame.popReference();
//            KClass kClass = Doovos.getSystem().getMemoryManager().getPointer(((KReference) (args[0]))).getKClass();
//            if (kClass.isArray()) {
//                kClass = repository.getClassByName("java.lang.Object");
//            }
//            KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
//            KClass implClass = repository.getClassByName(implMethod.getClassName());
//            t.pushFrame(implMethod, args);
//
//            frame.pushClassInitializerFrame(classByName);
//            KJVM_INVOKEVIRTUAL base2 = (KJVM_INVOKEVIRTUAL) base;
//            base2.classByName = classByName;
//            base2.methodByName = methodByName;
//            frame.getMethod().setStatus(KMethod.STATUS_DIRTY);
//        } else {
//            KRegister[] args = new KRegister[methodByName.getParametersCount() + 1];
//            for (int j = args.length - 1; j > 0; j--) {
//                args[j] = frame.pop();
//            }
//            args[0] = frame.popReference();
//            KClass kClass = Doovos.getSystem().getMemoryManager().getPointer(((KReference) (args[0]))).getKClass();
//            KClassDef kClassDef = kClass.getDefinition();
//            if (kClass.isArray()) {
//                kClass = repository.getClassByName("java.lang.Object");
//            }
//            KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
//            KClass implClass = repository.getClassByName(implMethod.getClassName());
//            t.pushFrame(implMethod, args);
//
//        }
//        frame.setInstruction(ordinal + 1);
//        return frame.getThread().getFrame().getCurrentInstruction();
//        //t.pushFrame(classByName, method, args);
//        //**LOG**//log(i.operator, context, className + "." + methodName + "[" + Arrays.asList(args) + "]");
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        KClassDef classDefinition = method.getParentClass().getDefinition();
//        classNameString = (String) classDefinition.getConstant(classNameIndex);
//        methodNameString = (String) classDefinition.getConstant(methodNameIndex);
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
////                        "        String className = context.getConstantString("+classNameIndex+");\n" +
////                        "        String methodName = context.getConstantString("+methodNameIndex+");\n" +
//                        "        KClassDef classByName = currentProcess.getClassRepository().getClassDefByName(\"" + classNameString + "\");\n" +
//                        "        KMethodDef method = classByName.getVirtualMethodBySignature(\"" + methodNameString + "\");\n" +
//                        "        if (method == null) {\n" +
//                        "         throw new NoSuchElementException(\"method " + methodNameString + " in " + classNameString + "\");\n" +
//                        "        }\n" +
//                        "        KRegister[] args = new KRegister[method.getParametersCount() + 1];\n" +
//                        "        for (int j = args.length - 1; j > 0; j--) {\n" +
//                        "            args[j] = context.pop();\n" +
//                        "        }\n" +
//                        "        args[0] = context.popReference();\n" +
//                        "\n" +
//                        "        KClass kClass = memoryManager.getPointer((KReference) args[0]).getKClass();\n" +
//                        "        KMethodDef implMethod = kClass.getDefinition().getVirtualMethodBySignature(\"" + methodNameString + "\");\n" +
//                        "        KClassDef implClass = implMethod.getParentClass();\n" +
//                        "        KFrame newcontext = currentThread.pushFrame(implClass, implMethod, args);\n" +
//                        "\n" +
//                        "        context.initializeClass(classByName);\n" +
//                        "        context.setInstruction(ordinal+1);\n"
//                        + "\n    }"
//                , null, "context.getThread().getContext().getInstruction()", null
//        );
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_INVOKEVIRTUAL that = (KJVM_INVOKEVIRTUAL) o;
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
//}
