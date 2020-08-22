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
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KProcessCache;
//import org.doovos.kernel.api.process.KLocalThread;
//
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.debug.Debug;
//
//public class KDebugFrame extends KFrameDebugAdapter {
//    private KFrameFilter filter;
////    private KFrameListener clinitContextDebugListener = new KFrameListener() {
////        public void framePoped(KFrame frame) {
////            try {
////                if (filter.accept(frame) && Debug.isDebug(frame.getProcess(), "init")) {
////                    Debug.log(frame.getThread()).info("E*******END INITIALIZE CLASS " + frame.getKClass().getName());
////                }
////                KFrameImpl.clinitContextListener.framePoped(frame);
////            } catch (RemoteException e) {
////                e.printStackTrace();
////            }
////        }
////    };
//
//    public KDebugFrame(KFrameFilter filter, KFrame frame) throws RemoteException {
//        super(frame);
//        this.filter = filter;
//    }
//
//
//    @Override
//    public KFrame popFrame() throws RemoteException {
//        return super.popFrame();
//    }
//
//    @Override
//    public boolean pushClassInitializerFrame(KClass dpc) throws RemoteException {
//        if (!dpc.isInitialized() /*!dpc.isArray()*/) {
//            KMethod initMethod = dpc.findClassInitializerMethod();
//            dpc.setInitialized(true);
//            boolean init = false;
//            if (initMethod != null) {
//                if (filter.accept(this) && Debug.isDebug(this.getProcess(), "init")) {
//                    Debug.log(getThread()).info("C*******INITIALIZE CLASS " + dpc.getName()
//                            //+ " (" + System.identityHashCode(dpc) + "/" + System.identityHashCode(dpc.getDefinition()) + ") "
//                    );
//                }
//            } else {
//
//                if (filter.accept(this) && Debug.isDebug(this.getProcess(), "noinit")) {
//                    Debug.log(getThread()).info("C*******NON INITIALIZABLE CLASS (NO  NEED) " + dpc.getName());
//                }
//            }
//                super.pushClassInitializerFrame(dpc);
//            check();
//            return init;
//
//        }
//        check();
//        return false;
//    }
//
//    @Override
//    public void push(KRegister value) throws RemoteException {
//        if (value == null) {
//            throw new IllegalArgumentException();
//        }
//        super.push(value);
//        check();
//    }
//
//    @Override
//    public KRegister peek() throws RemoteException {
//        KRegister register = super.peek();
//        check();
//        return register;
//    }
//
//    @Override
//    public void clearStack() throws RemoteException {
//        super.clearStack();
//        check();
//    }
//
//    @Override
//    public KRegister getLocal(int index) throws RemoteException {
//        KRegister register = super.getLocal(index);
//        check();
//        return register;
//    }
//
//    @Override
//    public KRegister pop() throws RemoteException {
////        return stack.pop();
//        KRegister value = super.pop();
//        check();
//        return value;
//    }
//
//    @Override
//    public KReference popRef() throws RemoteException {
//        KReference value = super.popRef();
//        check();
//        return value;
//    }
//
//    @Override
//    public int popInt() throws RemoteException {
//        int value = super.popInt();
//        check();
//        return value;
//    }
//
//    @Override
//    public double popDouble() throws RemoteException {
//        double value = super.popDouble();
//        check();
//        return value;
//    }
//
//    @Override
//    public float popFloat() throws RemoteException {
//        float value = super.popFloat();
//        check();
//        return value;
//    }
//
//    @Override
//    public short popShort() throws RemoteException {
//        short value = super.popShort();
//        check();
//        return value;
//    }
//
//    @Override
//    public long popLong() throws RemoteException {
//        long value = super.popLong();
//        check();
//        return value;
//    }
//
//    @Override
//    public char popChar() throws RemoteException {
//        char value = super.popChar();
//        check();
//        return value;
//    }
//
//    @Override
//    public void setLocal(int index, KRegister value) throws RemoteException {
//        super.setLocal(index, value);
//        check();
//    }
//
//    @Override
//    public int getProgramCounter() throws RemoteException {
//        int currentInstructionIndex = super.getProgramCounter();
//        check();
//        return currentInstructionIndex;
//    }
//
//    @Override
//    public void setProgramCounter(int currentStatement) throws RemoteException {
//        super.setProgramCounter(currentStatement);
//        check();
//    }
//
//    @Override
//    public KInstruction[] getInstructions() throws RemoteException {
//        KInstruction[] instructions = super.getInstructions();
//        check();
//        return instructions;
//    }
//
//    @Override
//    public KInstruction getCurrentInstruction() throws RemoteException {
//        KInstruction kInstruction = super.getCurrentInstruction();
//        check();
//        return kInstruction;
//    }
//
//    @Override
//    public KLocalThread getThread() throws RemoteException {
//        KLocalThread threadLocal = super.getThread();
//        check();
//        return threadLocal;
//    }
//
//    @Override
//    public KProcess getProcess() throws RemoteException {
//        KProcess process = super.getProcess();
//        check();
//        return process;
//    }
//
//    @Override
//    public KRegister getConstant(int index) throws RemoteException {
//        KRegister register = super.getConstant(index);
//        check();
//        return register;
//    }
//
//    @Override
//    public KClass getKClass() throws RemoteException {
//        KClass classDef = super.getKClass();
//        check();
//        return classDef;
//    }
//
//    @Override
//    public KMethod getMethod() throws RemoteException {
//        KMethod kMethodDef = super.getMethod();
//        check();
//        return kMethodDef;
//    }
//
//    @Override
//    public String getConstantString(int index) throws RemoteException {
//        String s = super.getConstantString(index);
//        check();
//        return s;
//    }
//
//    @Override
//    public KRegister[] getParameters() throws RemoteException {
//        KRegister[] kRegisters = super.getParameters();
//        check();
//        return kRegisters;
//    }
//
////    public boolean isNativeContext() throws RemoteException {
////        boolean b = super.isNativeContext();
////        check();
////        return b;
////    }
//
//    @Override
//    public KProcessCache getCache() throws RemoteException {
//        KProcessCache processCache = super.getCache();
//        check();
//        return processCache;
//    }
//
//
//    @Override
//    public int getStackSize() throws RemoteException {
//        int stackSize = super.getStackSize();
//        check();
//        return stackSize;
//    }
//
//    @Override
//    public KRegister peek(int index) throws RemoteException {
//        KRegister register = super.peek(index);
//        check();
//        return register;
//    }
//
//    @Override
//    public int throwThrowable(KReference ref) throws RemoteException {
//        int i = super.throwThrowable(ref);
//        check();
//        return i;
//    }
//
//    @Override
//    public KReference newInstance(String className, String[] paramTypes, KRegister... params) throws RemoteException {
//        KReference kReference = super.newInstance(className, paramTypes, params);
//        check();
//        return kReference;
//    }
//
//    @Override
//    public int throwClassNotFoundException(String message) throws RemoteException {
//        int i = super.throwClassNotFoundException(message);
//        check();
//        return i;
//    }
//
//    @Override
//    public int throwNullPointerException(String message) throws RemoteException {
//        int i = super.throwNullPointerException(message);
//        check();
//        return i;
//    }
//
//    @Override
//    public int throwRuntimeException(String message) throws RemoteException {
//        int i = super.throwRuntimeException(message);
//        check();
//        return i;
//    }
//
//
//    private void check() throws RemoteException {
////        if (stackIndex < -1) {
////            throw new IllegalStateException();
////        }
//        for (int i = 0; i < super.getStackSize(); i++) {
//
//            KRegister register = super.peek(i);
//            if (register == null) {
//                throw new IllegalStateException();
//            }
//        }
//    }
//
//    @Override
//    public int getDepth() throws RemoteException {
//        return super.getDepth();
//    }
//
//    @Override
//    public String toString() {
//        return "DEBUG:" + super.toString();
//    }
//
//    @Override
//    public KRegister invokeObjectMethod(KMethod method, KRegister ref, KRegister... parameters) throws RemoteException, Exception {
//        KRegister register = super.invokeObjectMethod(method, ref, parameters);
//        check();
//        return register;
//    }
//
//    @Override
//    public KRegister invokeStaticMethod(KMethod method, KRegister... parameters) throws RemoteException, Exception {
//        KRegister register = super.invokeStaticMethod(method, parameters);
//        check();
//        return register;
//    }
//
//    @Override
//    public void invokeClassInitializer(KClass clazz) throws RemoteException, Exception {
//        if (clazz.isInitializable()) {
//            if (filter.accept(this) && Debug.isDebug(this.getProcess(), "init")) {
//                Debug.log(getThread()).info("C2******INITIALIZE CLASS " + clazz.getName()
//                        //+ " (" + System.identityHashCode(clazz) + "/" + System.identityHashCode(clazz.getDefinition()) + ") "
//                );
//            }
//        }
//        super.invokeClassInitializer(clazz);
//        check();
//    }
//
//}