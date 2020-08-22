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
//import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
//import org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter.KInstructionLnk;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.jni.JNIException;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
//import org.doovos.kernel.core.util.KUtils;
//
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 22 févr. 2009
// * Time: 14:21:52
// * To change this template use File | Settings | File Templates.
// */
//public final class KJVM_XTRA_JNI extends KInstructionLnk implements Cloneable {
//    public static final KJVM_XTRA_JNI INSTANCE = new KJVM_XTRA_JNI();
//
//    private KJVM_XTRA_JNI() {
//        super(KOperator.XTRA_JNI);
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        KRegister[] dRegisters = frame.getParameters();
//        KRegister dRegister = null;
//        try {
//            dRegister = frame.getProcess().invokeNativeMethod(frame.getMethod().getAbsoluteSignature(), frame, dRegisters);
//        } catch (JNIException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ",frame);
//            e.printStackTrace();
//            throw e;
//        } catch (KEndOfThreadException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ",frame);
//            e.printStackTrace();
//            throw e;
//        } catch (UnsupportedOperationException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ",frame);
//            e.printStackTrace();
//            throw e;
//        } catch (KClassNotFoundException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ",frame);
//            e.printStackTrace();
//            return frame.throwClassNotFoundException(e.getMessage());
//        } catch (NullPointerException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ",frame);
//            e.printStackTrace();
//            return frame.throwNullPointerException(e.getMessage());
//        } catch (RuntimeException e) {
//            KUtils.logStackTrace(e.toString(), "[run Error] ",frame);
//            e.printStackTrace();
//            return frame.throwRuntimeException(e.getMessage());
//        }
//        if (dRegister != null) {
//            frame = frame.popFrame();
//            frame.push(dRegister);
//        } else {
//            frame = frame.popFrame();
//        }
//        return frame.getCurrentInstructionIndex();
//    }
//
//    @Override
//    public KInstructionLnk run(KFrame frame) throws RemoteException {
//
//        KRegister[] dRegisters = frame.getParameters();
//        KRegister dRegister = null;
//        try {
//            dRegister = frame.getProcess().invokeNativeMethod(frame.getMethod().getAbsoluteSignature(), frame, dRegisters);
//        } catch (JNIException e) {
//            e.printStackTrace();
//            throw e;
//        } catch (KEndOfThreadException e) {
//            e.printStackTrace();
//            throw e;
//        } catch (UnsupportedOperationException e) {
//            e.printStackTrace();
//            throw e;
//        } catch (KClassNotFoundException e) {
//            e.printStackTrace();
//            int i = frame.throwClassNotFoundException(e.getMessage());
//            return frame.getThread().getFrame().getInstruction(i);
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//            int i = frame.throwNullPointerException(e.getMessage());
//            return frame.getThread().getFrame().getInstruction(i);
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            int i = frame.throwRuntimeException(e.getMessage());
//            return frame.getThread().getFrame().getInstruction(i);
//        }
//        if (dRegister != null) {
//            frame = frame.popFrame();
//            frame.push(dRegister);
//        } else {
//            frame = frame.popFrame();
//        }
//
//        return frame.getCurrentInstruction();
//    }
//
//    public void relink(int index, KInstructionLnk[] code, KMethod method){
//        this.ordinal = index;
//    }
//
//
//    @Override
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//
//}