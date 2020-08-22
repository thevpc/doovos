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

import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.api.process.KLocalThread;

import java.rmi.RemoteException;

public final class KInterpreterIdx implements KInterpreter {
//    private KThreadLocal thread;
//    private KProcess process;
    private KInstructionIdxFactory factory=new KInstructionIdxFactory();
    public KInterpreterIdx() {
    }

    public void init(KLocalThread thread) throws Exception {
//        this.thread = thread;
//        this.process = thread.getProcess();
    }

    public void init(KFrame frame) throws Exception {
        //do nothing
    }


    public void init(KMethod method) throws RemoteException {
        KInstructionDef[] defs = method.getDefinition().getCode();
        if (method.isNative() /*|| process.existsNativeMethod(method.getSignature())*/) {
            method.setCode(KInstructionIdxFactory.NATIVE_METHOD_CODE);
        } else {
            KInstructionIdx[] instructions = new KInstructionIdx[defs.length];
            for (int i = 0; i < instructions.length; i++) {
                instructions[i] = factory.createInstruction(i, defs[i]);
            }
            method.setCode(instructions);
        }
    }

    public KInstruction getCurrent(KFrame frame) throws Exception {
        return frame.getCurrentInstruction();
    }

    public void run(KFrame frame) throws Exception {
//        if(frame.toString().contains("java.lang.ClassLoader.loadLibrary")){
//            System.out.println("__");
//        }
//        System.out.println("????? : "+frame);
        //KFrame context = getContext();
        //loggin
//        String log = context.toString();
//        long t0 = System.currentTimeMillis();
        int afterStatement;
//        if (context.isNativeContext()) {
//            runNative(context);
//            afterStatement=context.getCurrentStatementIndex();
//        } else {
        int beforeStatement = frame.getProgramCounter();
        KInstructionIdx kInstruction = (KInstructionIdx) frame.getCurrentInstruction();
        afterStatement = kInstruction.run(frame);
        switch (afterStatement) {
            case KProcess.NEXT_STATEMENT: {
                afterStatement = beforeStatement + 1;
                break;
            }
            case KProcess.THIS_STATEMENT: {
                afterStatement = beforeStatement;
                break;
            }
            default: {
                if (afterStatement < 0) {
                    throw new IllegalArgumentException("Bad statement address " + afterStatement);
                }
            }
        }
        frame.setProgramCounter(afterStatement);
//        }

//        long t1 = System.currentTimeMillis();
//        long x = t1 - t0;
//        if (x > 1) {
//            System.out.println("["+ KUtils.LOG_DATE.format(new Date())+"]<<TOO LONG>> " + (x) + " ms \t: " + log);
//        }
//        return afterStatement;
    }

    public void close() {
        //
    }

    
}