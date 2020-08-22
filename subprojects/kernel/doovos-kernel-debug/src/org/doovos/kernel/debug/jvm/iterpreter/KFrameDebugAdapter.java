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
//package org.doovos.kernel.debug.jvm.iterpreter;
//
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.reflect.KClassRepository;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.memory.KMemorySegment;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KProcessCache;
//import org.doovos.kernel.api.process.KLocalThread;
//
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//
//public class KFrameDebugAdapter implements KFrame {
//    private KFrame base;
//
//    public KFrameDebugAdapter(KFrame base) {
//        this.base = base;
//    }
//
//    public KFrame popFrame() throws RemoteException {
//        return base.popFrame();
//    }
//
//    public boolean pushClassInitializerFrame(KClass dpc) throws RemoteException {
//        boolean b = base.pushClassInitializerFrame(dpc);
//        check();
//        return b;
//    }
//
//    public void push(KRegister value) throws RemoteException {
//        if (value == null) {
//            throw new IllegalArgumentException();
//        }
//        base.push(value);
//        check();
//    }
//
//    public KRegister pop() throws RemoteException {
//        KRegister register = base.pop();
//        check();
//        return register;
//    }
//
//    public KReference popRef() throws RemoteException {
//        KReference kReference = base.popRef();
//        check();
//        return kReference;
//    }
//
//    public int popInt() throws RemoteException {
//        int v = base.popInt();
//        check();
//        return v;
//    }
//
//    public double popDouble() throws RemoteException {
//        double v = base.popDouble();
//        check();
//        return v;
//    }
//
//    public float popFloat() throws RemoteException {
//        float v = base.popFloat();
//        check();
//        return v;
//    }
//
//    public short popShort() throws RemoteException {
//        short v = base.popShort();
//        check();
//        return v;
//    }
//
//    public long popLong() throws RemoteException {
//        long v = base.popLong();
//        check();
//        return v;
//    }
//
//    public char popChar() throws RemoteException {
//        char v = base.popChar();
//        check();
//        return v;
//    }
//
//    public KRegister peek() throws RemoteException {
//        KRegister register = base.peek();
//        check();
//        return register;
//    }
//
//    public void clearStack() throws RemoteException {
//        base.clearStack();
//        check();
//    }
//
//    public KRegister getLocal(int index) throws RemoteException {
//        KRegister register = base.getLocal(index);
//        check();
//        return register;
//    }
//
//    public void setLocal(int index, KRegister value) throws RemoteException {
//        base.setLocal(index, value);
//        check();
//    }
//
//    public int getProgramCounter() throws RemoteException {
//        int currentInstructionIndex = base.getProgramCounter();
//        check();
//        return currentInstructionIndex;
//    }
//
//    public void setProgramCounter(int currentStatement) throws RemoteException {
//        base.setProgramCounter(currentStatement);
//        check();
//    }
//
//    public KInstruction[] getInstructions() throws RemoteException {
//        KInstruction[] instructions = base.getInstructions();
//        check();
//        return instructions;
//    }
//
//    public KInstruction getCurrentInstruction() throws RemoteException {
//        KInstruction kInstruction = base.getCurrentInstruction();
//        check();
//        return kInstruction;
//    }
//
//    public KLocalThread getThread() throws RemoteException {
//        KLocalThread threadLocal = base.getThread();
//        check();
//        return threadLocal;
//    }
//
//    public KProcess getProcess() throws RemoteException {
//        KProcess process = base.getProcess();
//        check();
//        return process;
//    }
//
//    public KRegister getConstant(int index) throws RemoteException {
//        KRegister register = base.getConstant(index);
//        check();
//        return register;
//    }
//
//    public KClass getKClass() throws RemoteException {
//        KClass classDef = base.getKClass();
//        check();
//        return classDef;
//    }
//
//    public KMethod getMethod() throws RemoteException {
//        KMethod kMethodDef = base.getMethod();
//        check();
//        return kMethodDef;
//    }
//
//    public String getConstantString(int index) throws RemoteException {
//        String s = base.getConstantString(index);
//        check();
//        return s;
//    }
//
//    public KRegister[] getParameters() throws RemoteException {
//        KRegister[] kRegisters = base.getParameters();
//        check();
//        return kRegisters;
//    }
//
////    public boolean isNativeContext() throws RemoteException {
////        boolean b = base.isNativeContext();
////        check();
////        return b;
////    }
////
//
//    public KProcessCache getCache() throws RemoteException {
//        KProcessCache processCache = base.getCache();
//        check();
//        return processCache;
//    }
//
//    public int getStackSize() throws RemoteException {
//        int stackSize = base.getStackSize();
//        check();
//        return stackSize;
//    }
//
//    public KRegister peek(int index) throws RemoteException {
//        KRegister register = base.peek(index);
//        check();
//        return register;
//    }
//
//    private void check() throws RemoteException {
//        for (int i = 0; i < base.getStackSize(); i++) {
//
//            KRegister register = base.peek(i);
//            if (register == null) {
//                throw new IllegalStateException();
//            }
//        }
//    }
//
//    public int getDepth() throws RemoteException {
//        return base.getDepth();
//    }
//
//    @Override
//    public String toString() {
//        return "DEBUG:" + base.toString();
//    }
//
//    public int throwThrowable(KReference ref) throws RemoteException {
//        int i = base.throwThrowable(ref);
//        check();
//        return i;
//    }
//
//    public KReference newInstance(String className, String[] paramTypes, KRegister... params) throws RemoteException {
//        KReference kReference = base.newInstance(className, paramTypes, params);
//        check();
//        return kReference;
//    }
//
//    public int throwClassNotFoundException(String message) throws RemoteException {
//        int i = base.throwClassNotFoundException(message);
//        check();
//        return i;
//    }
//
//    public int throwNullPointerException(String message) throws RemoteException {
//        int i = base.throwNullPointerException(message);
//        check();
//        return i;
//    }
//
//    public int throwRuntimeException(String message) throws RemoteException {
//        int i = base.throwRuntimeException(message);
//        check();
//        return i;
//    }
//
//    public KRegister invokeObjectMethod(KMethod method, KRegister ref, KRegister... parameters) throws RemoteException, Exception {
//        KRegister register = base.invokeObjectMethod(method, ref, parameters);
//        check();
//        return register;
//    }
//
//    public KRegister invokeStaticMethod(KMethod method, KRegister... parameters) throws RemoteException, Exception {
//        KRegister register = base.invokeStaticMethod(method, parameters);
//        check();
//        return register;
//    }
//
//    public void invokeClassInitializer(KClass clazz) throws RemoteException, Exception {
//        base.invokeClassInitializer(clazz);
//        check();
//    }
//
//    public KInstruction getInstruction(int index) throws RemoteException {
//        KInstruction kInstruction = base.getInstruction(index);
//        check();
//        return kInstruction;
//    }
//
//    public KMemorySegment getMemorySegment() throws RemoteException {
//        KMemorySegment segment = base.getMemorySegment();
//        check();
//        return segment;
//    }
//
//    public KClassRepository getClassRepository() {
//        return base.getClassRepository();
//    }
//
//    public Object getConstantPoolDef(int index) {
//        return base.getConstantPoolDef(index);
//    }
//
//
//}
