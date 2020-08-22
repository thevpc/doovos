/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.core.jvm.interpreter;

import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.process.KProcessCache;
import org.doovos.kernel.api.process.KLocalThread;

import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import java.util.Arrays;

import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.core.memory.KClassIntrospector;
import org.doovos.kernel.core.util.KUtils;

public final class KFrameImpl implements KFrame {

    protected int stackIndex = -1;
    //    private Stack<KRegister> stack;
    protected KRegister[] stack;
    private KRegister[] locals;
    private int currentStatement;
    private KLocalThread thread;
    private KClassRepository classRepository;
    private KMethod method;
    private KClass clazz;
    private KRegister[] parameters;
    private KRegister[] constantsPool;
    //    private boolean nativeContext;
    private KProcessCache cache;
    private KProcess process;
    private KInstruction[] instructions;
    //private KRegister[] regConstantsPool;
    private KMemorySegment memorySegment;
    private KMemoryManager memoryManager;
    private Object[] constantPoolDef;
    private int index;

    public final static class DebugInfo {

        private KClassIntrospector[] stack;
        private KClassIntrospector[] locals;
        private KClassIntrospector[] parameters;
        private KClassIntrospector[] constantsPool;
    }

    public DebugInfo getDebugInfo() {
        DebugInfo d=new DebugInfo();
        try {
            d.stack = KClassIntrospector.torArray(stack);
            d.locals = KClassIntrospector.torArray(locals);
            d.parameters = KClassIntrospector.torArray(parameters);
            d.constantsPool = KClassIntrospector.torArray(constantsPool);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException("Why?");
        }
        return d;
    }

    public KFrameImpl() throws RemoteException {
    }

    public void setThread(KLocalThread thread) throws RemoteException {
        this.thread = thread;
        this.process = thread.getProcess();
        this.cache = thread.getCache();
        this.classRepository = process.getClassRepository();
        this.memorySegment = process.getMemorySegment();
        this.memoryManager = process.getMemoryManager();

    }

    public void init(int index, KMethod method, KRegister[] parameters) throws RemoteException {
        this.index = index;
        this.parameters = parameters;
        KMethodDef methodDefinition = method.getDefinition();
//        int max=parameters.length+method.getVariableCount();
//        int max = methodDefinition.getVariableCount() * 2;
        KRegister[] _locals = new KRegister[methodDefinition.getMaxLocals()/*max*/];
        int locIndex = 0;
        for (KRegister parameter : parameters) {
            _locals[locIndex] = parameter;
            locIndex++;
//            max++;
            if (parameter.isType2()) {
                locIndex++;
//                max++;
            }
        }
        this.locals = _locals;
        this.method = method;


        this.clazz = method.getParentClass();
        this.constantsPool = clazz.getConstantsPool();
        this.constantPoolDef = clazz.getDefinition().getConstantsPool();
        instructions = method.getCode();
        int maxStack = methodDefinition.getMaxStack();
        stack = new KRegister[maxStack * 2];
        stackIndex=-1;
        currentStatement=0;
    }

    public final void push(KRegister memName) throws RemoteException {
//        stack.push(memName);
        stack[++stackIndex] = memName;
    }

    public final KRegister peek(int count) throws RemoteException {
        return stack[stackIndex - count];
    }

    public final KRegister pop() throws RemoteException {
        return stack[stackIndex--];
    }

    public final KReference popRef() throws RemoteException {
        return (KReference) stack[stackIndex--];
    }

    public final int popInt() throws RemoteException {
        return stack[stackIndex--].intValue();
    }

    public final byte popByte() throws RemoteException {
        return stack[stackIndex--].byteValue();
    }

    public final double popDouble() throws RemoteException {
        return ((KDouble) (stack[stackIndex--])).value;
    }

    public final float popFloat() throws RemoteException {
        return ((KFloat) (stack[stackIndex--])).value;
    }

    public final short popShort() throws RemoteException {
        KRegister r = stack[stackIndex--];
        return ((KShort) r).value;
    }

    public final long popLong() throws RemoteException {
        return ((KLong) (stack[stackIndex--])).value;
    }

    public final char popChar() throws RemoteException {
        KRegister r = stack[stackIndex--];
        return ((KChar) r).value;
    }

    public final KRegister peek() throws RemoteException {
//        return stack.peek();
        return stack[stackIndex];
    }

    public final int getStackSize() throws RemoteException {
        return stackIndex + 1;
    }

    public final KRegister getLocal(int index) throws RemoteException {
        return locals[index];
    }

    public final void setLocal(int index, KRegister value) throws RemoteException {
        locals[index] = value;
    }

    public final int getProgramCounter() throws RemoteException {
        return currentStatement;
    }

    public final void setProgramCounter(int currentStatement) throws RemoteException {
//        if (currentStatement >= instructions.length) {
////            System.out.println(getClass() + " :????");
//        }
//        if (currentStatement < 0) {
//            System.out.println(getClass() + " :????");
//        }
        this.currentStatement = currentStatement;
    }

    public final void incProgramCounter() throws RemoteException {
        currentStatement++;
    }

    public final KInstruction[] getInstructions() throws RemoteException {
        return instructions;
    }

    public final KInstruction getCurrentInstruction() throws RemoteException {
        return instructions[currentStatement];
    }

    public final KLocalThread getThread() throws RemoteException {
        return thread;
    }

    public final KProcess getProcess() throws RemoteException {
        return process;
    }

    public final KRegister getConstant(int index) throws RemoteException {
        return constantsPool[index];
    }

    public final String getConstantString(int index) throws RemoteException {
        return (String) constantPoolDef[index];
//        KReference classNameReg = null;
//        classNameReg = (KReference) clazz.getConstants()[index];
//        return Doovos.getSystem().getMemoryManager().getString(classNameReg);
    }

    public final KClass getKClass() throws RemoteException {
        return clazz;
    }

    public final KMethod getMethod() throws RemoteException {
        return method;
    }

    public final KRegister[] getParameters() throws RemoteException {
        return parameters;
    }

//    public boolean isNativeContext() throws RemoteException {
//        return nativeContext;
//    }
    public final KProcessCache getCache() throws RemoteException {
        return cache;
    }

    @Override
    public final String toString() {
        StringBuilder prefix = new StringBuilder(index + 5);
        for (int j = 0; j < index; j++) {
            prefix.append(' ');
        }
        prefix.append('[').append(index).append(']');
        String s1 = "";
        try {
            s1 = "[" + process.getName() + ":" + thread.getName() + "]";
        } catch (RemoteException e) {
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String s = s1
                + (Modifier.isNative(method.getModifiers()) ? "[NATIVE]" : "[INTERP]")
                + clazz.getDefinition().getId() + "." + method.getDefinition().getSignature() + "[" + currentStatement + "]";
        if (currentStatement < instructions.length) {
            return prefix + s + ";" + instructions[currentStatement].toString();
        } else {
            return prefix + s;
        }
    }

    public final boolean pushClassInitializerFrame(KClass dpc) throws RemoteException {
        return thread.pushClassInitializerFrame(dpc);
    }

    public final KFrame popFrame() throws RemoteException {
        return thread.popFrame();
    }

    public final void clearStack() throws RemoteException {
        stackIndex = -1;
    }

    public final KMemorySegment getMemorySegment() throws RemoteException {
        return memorySegment;
    }

    public KMemoryManager getMemoryManager() throws RemoteException {
        return memoryManager;
    }

    public final KRegister invokeObjectMethod(String className, String methodSignature, KRegister ref, KRegister... parameters) throws RemoteException, Exception {
        KMethod m = getClassRepository().getClassByName(className).getMethodBySignature(methodSignature);
        return invokeObjectMethod(m, ref, parameters);
    }

    public final KRegister invokeStaticMethod(String className, String methodSignature, KRegister... parameters) throws RemoteException, Exception {
        final KClass cls = getClassRepository().getClassByName(className);
        //invokeClassInitializer(cls);
        KMethod m = cls.getMethodBySignature(methodSignature);
        return invokeStaticMethod(m, parameters);
    }

    public final KRegister invokeObjectMethod(KMethod method, KRegister ref, KRegister... parameters) throws RemoteException, Exception {
        KRegister[] r = new KRegister[parameters.length + 1];
        System.arraycopy(parameters, 0, r, 1, parameters.length);
        r[0] = ref;
        return invokeMethod(method, r);
    }

    public final void invokeClassInitializer(KClass clazz) throws RemoteException, Exception {
        KMethod c = clazz.findClassInitializerMethod();
        if (c != null) {
            try {
                invokeStaticMethod(c);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final KRegister invokeStaticMethod(KMethod method, KRegister... parameters) throws RemoteException, Exception {
        return invokeMethod(method, parameters);
    }

    public final KRegister invokeMethod(KMethod method, KRegister... parameters) throws RemoteException, Exception {
        KLocalThread currentThread = getThread();
        int count = currentThread.getFramesCount();
//        KClass implClass = getClassRepository().getClassByName(method.getClassName());
        currentThread.pushFrame(method, parameters);
        KInterpreter interpreter = currentThread.getInterpreter();
        //TODO how to handle exception?????
        while (true) {
            interpreter.run(currentThread.getFrame());
            if (currentThread.getFramesCount() <= count) {
                break;
            }
        }
        if (method.isProcedure()) {
            return null;
        }
        return currentThread.getFrame().pop();
    }

    public final int getDepth() throws RemoteException {
        return index;
    }

    public final int throwThrowable(KReference ref) throws RemoteException {
        KClassRepository _classRepository = getClassRepository();
        for (KTryCatchDef kTryCatchDef : getMethod().getTryCatchBlocs()) {
            if (kTryCatchDef.accept(getProgramCounter())) {
                String type = kTryCatchDef.getType();
                if (type == null) {
                    //
                    clearStack();
                    push(ref);
                    setProgramCounter(kTryCatchDef.getTarget());
                    return kTryCatchDef.getTarget();
                } else {
                    KClass exceptionType = _classRepository.getClassByName(type);
                    if (exceptionType.isAssignableFrom(ref)) {
                        clearStack();
                        push(ref);
                        setProgramCounter(kTryCatchDef.getTarget());
                        return kTryCatchDef.getTarget();
                    }
                }
            }
        }
//        KFrame kFrame = null;
        try {
            return thread.rollbackFrame().throwThrowable(ref);
        } catch (KEndOfThreadException e) {
            this.getProcess().getStderr().writeln("Exception in ... " + this);
            throw e;
        }
    }

    public final KReference newInstance(String className, String[] paramTypes, KRegister... params) throws RemoteException {
        KProcess process1 = getProcess();
        KClass classByName = getClassRepository().getClassByName(className);
        try {
            invokeClassInitializer(classByName);
        } catch (Exception e) {
            throw KUtils.toRuntimeException(e);
        }
        if (getThread().getFrame() == this) {
            KReference ref = process1.getMemorySegment().allocObject(classByName);
            try {
                StringBuilder s = new StringBuilder();
                for (String paramType : paramTypes) {
                    s.append(KClass.toClassCode(paramType));
                }
                invokeObjectMethod(classByName.getMethodBySignature(KMethodDef.CONSTRUCTOR + "(" + s.toString() + ")V"), ref, params);
            } catch (Exception e) {
                throw KUtils.toRuntimeException(e);
            }
            return ref;
        } else {
            throw new IllegalStateException("thread context changed on newInstance(" + className + "," + Arrays.toString(paramTypes) + ")");
        }
    }

    public final int throwClassNotFoundException(String message) throws RemoteException {
        String exc = "java.lang.ClassNotFoundException";
        KReference msg = message == null ? KReference.NULL : getProcess().getMemorySegment().allocString(message);
        KReference ref = newInstance(exc, new String[]{"java.lang.String"}, msg);
        return throwThrowable(ref);
    }

    public final int throwAbstractMethodError(String message) throws RemoteException {
        String exc = "java.lang.AbstractMethodError";
        KReference msg = message == null ? KReference.NULL : getProcess().getMemorySegment().allocString(message);
        KReference ref = newInstance(exc, new String[]{"java.lang.String"}, msg);
        return throwThrowable(ref);
    }

    public final int throwNullPointerException(String message) throws RemoteException {
        String exc = "java.lang.NullPointerException";
        KReference msg = message == null ? KReference.NULL : getProcess().getMemorySegment().allocString(message);
        KReference ref = newInstance(exc, new String[]{"java.lang.String"}, msg);
        return throwThrowable(ref);
    }

    public final int throwRuntimeException(String message) throws RemoteException {
        String exc = "java.lang.RuntimeException";
        KReference msg = message == null ? KReference.NULL : getProcess().getMemorySegment().allocString(message);
        KReference ref = newInstance(exc, new String[]{"java.lang.String"}, msg);
        return throwThrowable(ref);
    }

    public final KInstruction getInstruction(int index) throws RemoteException {
        return instructions[index];
    }

    public Object getConstantPoolDef(int index) {
        return constantPoolDef[index];
    }

    public KClassRepository getClassRepository() {
        return classRepository;
    }
}
