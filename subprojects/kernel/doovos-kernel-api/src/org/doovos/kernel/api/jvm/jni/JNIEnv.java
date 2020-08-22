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
package org.doovos.kernel.api.jvm.jni;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.process.KProcessCache;
import org.doovos.kernel.api.process.KLocalThread;

import java.rmi.RemoteException;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KMemoryManager;

public interface JNIEnv {
    /**
     * @param method
     * @param parameters : first parameter is the reference of the object if calling instance class
     * @throws java.rmi.RemoteException
     * @throws Exception
     */
    public KRegister invokeObjectMethod(KMethod method, KRegister ref, KRegister... parameters) throws RemoteException, Exception;

    public KRegister invokeStaticMethod(KMethod method, KRegister... parameters) throws RemoteException, Exception;

    public KRegister invokeObjectMethod(String className, String methodSignature, KRegister ref, KRegister... parameters) throws RemoteException, Exception ;
    
    public KRegister invokeStaticMethod(String className, String methodSignature, KRegister... parameters) throws RemoteException, Exception;
    
    public void invokeClassInitializer(KClass clazz) throws RemoteException, Exception;

    /**
     * push the name a mem in the stack
     *
     * @param value
     */
    public void push(KRegister value) throws RemoteException;

    /**
     * pop the name of the memValue in the stack
     *
     * @return
     */
    public KRegister pop() throws RemoteException;

    public KReference popRef() throws RemoteException;

    public int popInt() throws RemoteException;
    
    public byte popByte() throws RemoteException;

    public short popShort() throws RemoteException;

    public char popChar() throws RemoteException;

    public float popFloat() throws RemoteException;

    public double popDouble() throws RemoteException;

    public long popLong() throws RemoteException;

    /**
     * peek the name of the memValue in the stack
     *
     * @return KRegister
     * @throws java.rmi.RemoteException if RemoteException
     */
    public KRegister peek() throws RemoteException;

    public KRegister peek(int index) throws RemoteException;

    public int getStackSize() throws RemoteException;

    /**
     * needed in try catch handling
     *
     * @return
     * @throws RemoteException
     */
    public void clearStack() throws RemoteException;

    public KMemorySegment getMemorySegment() throws RemoteException;
    public KMemoryManager getMemoryManager() throws RemoteException;

    public KRegister getLocal(int index) throws RemoteException;

    public void setLocal(int index, KRegister value) throws RemoteException;

    public int getProgramCounter() throws RemoteException;

    public void setProgramCounter(int currentStatement) throws RemoteException;
    
    public void incProgramCounter() throws RemoteException;

    public KInstruction[] getInstructions() throws RemoteException;

    KInstruction getCurrentInstruction() throws RemoteException;

    KInstruction getInstruction(int index) throws RemoteException;

    public Object getConstantPoolDef(int index) ;
    
    public KClassRepository getClassRepository() ;

    KLocalThread getThread() throws RemoteException;

    KProcess getProcess() throws RemoteException;

    public KRegister getConstant(int index) throws RemoteException;

    public KClass getKClass() throws RemoteException;

    public KMethod getMethod() throws RemoteException;

    public String getConstantString(int index) throws RemoteException;

    public KRegister[] getParameters() throws RemoteException;

//    public boolean isNativeContext() throws RemoteException;

    public KProcessCache getCache() throws RemoteException;

    @Deprecated
    public boolean pushClassInitializerFrame(KClass dpc) throws RemoteException;

    @Deprecated
    public KFrame popFrame() throws RemoteException;

    public int getDepth() throws RemoteException;

    public KReference newInstance(String className, String[] paramTypes, KRegister... params) throws RemoteException;

    public int throwThrowable(KReference ref) throws RemoteException;

    public int throwClassNotFoundException(String className) throws RemoteException;

    public int throwAbstractMethodError(String methodName) throws RemoteException;

    public int throwNullPointerException(String className) throws RemoteException;

    public int throwRuntimeException(String message) throws RemoteException;
}
