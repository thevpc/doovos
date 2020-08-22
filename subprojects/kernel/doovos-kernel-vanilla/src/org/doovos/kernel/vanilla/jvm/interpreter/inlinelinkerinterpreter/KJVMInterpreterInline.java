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
//package org.doovos.kernel.vanilla.jvm.interpreter.inlinelinkerinterpreter;
//
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
//import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.KJVMInterpreter;
//import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.process.KLocalThread;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Hashtable;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//
//public class KJVMInterpreterInline implements KInterpreter {
//    private KInstruction instr;
//    private KLocalThread thread;
//
//    public void init(KLocalThread thread) throws Exception {
//        this.thread=thread;
//    }
//
//    public static class KInstructionBloc extends KInstructionIdx {
//        private KInstruction[] instructions;
//
//        public KInstructionBloc(KOperator operator) {
//            super(operator);
//        }
//
//        public KInstructionBloc(KInstruction... instructions) {
//            super(KOperator.X_USER_DEFINED);
//            this.instructions = instructions;
//        }
//
//        public final int run(KFrame frame) throws RemoteException {
//            int afterStatement = 0;
//            for (KInstruction other : instructions) {
//                int beforeStatement = frame.getCurrentInstructionIndex();
//                afterStatement = other.run(frame);
//                switch (afterStatement) {
//                    case KProcess.NEXT_STATEMENT: {
//                        afterStatement = beforeStatement + 1;
//                        break;
//                    }
//                    case KProcess.THIS_STATEMENT: {
//                        afterStatement = beforeStatement;
//                        break;
//                    }
//                    default: {
//                        if (afterStatement < 0) {
//                            throw new IllegalArgumentException("Bad statement address " + afterStatement);
//                        }
//                    }
//                }
//                frame.setInstruction(afterStatement);
//            }
//            return afterStatement;
//        }
//
//        public void relink(int index, KInstruction[] code, KMethod method) {
//            ordinal = index;
//            //do nothing
//        }
//
//        @Override
//        public final KInstruction runDirect(KFrame frame) throws RemoteException {
//            KInstruction instruction = instructions[0];
//            int max = instructions.length;
////            for (KInstruction other : instructions) {
////                i = i.runDirect(context);
////            }
//            for (int i = 0; i < max; i++) {
//                instruction = instruction.runDirect(frame);
//            }
//            return instruction;
//        }
//
//        public KInstruction[] getInstructions() {
//            return instructions;
//        }
//
//        @Override
//        public String toString() {
//            return "{" +(instructions == null ? null : Arrays.asList(instructions)) +'}';
//        }
//    }
//
//    public KJVMInterpreterInline() {
//    }
//
//    public void init(KFrame frame) throws Exception {
//        instr = frame.getCurrentInstruction();
//    }
//
//    public KInstruction getCurrent(KFrame frame) throws Exception {
//        return instr;
//    }
//
//    public void run(KFrame frame) throws Exception {
////        if(context.getMethod().toString().equals("org.doovos.api.DProcess.getProcess()Lorg/doovos/api/DProcess;")){
////            System.out.println("???ROMBATAKAYA : "+instr);
////        }
////        System.out.println("????? : "+frame.getMethod().getAbsoluteSignature()+" : "+ instr.getClass().getSimpleName()+" : "+instr);
//        instr = instr.runDirect(frame);
////        if(frame.getThread().getFrame().getInstruction().getOrdinal()!=instr.getOrdinal()){
////            throw new IllegalStateException();
////        }
//        //frame.getThread().getFrame().setInstruction(instr.getOrdinal());
//    }
//
//    public void initMethod(KMethod method) throws Exception {
//        //TODO fix me
//        KInstructionInline[] instructions = (KInstructionInline[]) method.getCode();
//        int len = instructions.length;
//        for (int i = 0; i < len; i++) {
//            instructions[i].relink(i, instructions, method);
//        }
//        //method.relink();
////        if(method.toString().equals("java.lang.Math.sin(D)D")){
////            System.out.println("*$*");
////        }
//        if(method.isNative()){
//            //do nothing
////        }else if(thread.getProcess().existsNativeMethod(method.getAbsoluteSignature())){
//////            System.out.println("Native form loaded for "+method.toString());
////            method.setCode(new KInstruction[]{KJVMInstructions.createInstruction(KJVMOperator.XTRA_JNI, null)});
//        }else{
////            if(!method.isConstructor() && !method.isClassInitializer()){
////                System.out.println("interpreted form of "+method.toString()+" : "+System.identityHashCode(method));
////            }
//            method.setCode(inlineInstructions(method));
//        }
//    }
//
//    public KInstruction[] inlineInstructions(KMethod method) throws Exception {
//        KInstruction[] instructions = method.getDefinition().getCode();
//        ArrayList<KInstruction> all = new ArrayList<KInstruction>();
//        ArrayList<KInstruction> c = new ArrayList<KInstruction>();
//        Hashtable<Integer, Integer> labelsMap = new Hashtable<Integer, Integer>();
//        KTryCatchDef[] blocs0 = method.getDefinition().getTryCatchBlocs();
//        for (KTryCatchDef bloc : blocs0) {
//            labelsMap.put(bloc.getFrom(), -1);
//            labelsMap.put(bloc.getTo(), -1);
//            labelsMap.put(bloc.getTarget(), -1);
//        }
//        for (KInstruction instruction : instructions) {
//            instruction.storeLabels(labelsMap);
//        }
//        for (KInstruction instruction : instructions) {
//            int oldOrdinal = instruction.getOrdinal();
//            KInstruction instruction0 = instruction;
//            instruction = instruction0.clone();
//            ((KInstructionIdx) instruction).base=(KInstructionIdx) instruction0;
//            if (labelsMap.containsKey(oldOrdinal) || instruction.isLabel()) {
//                if (c.size() == 0) {
//                    c.add(instruction);
//                } else {
//                    all.add(new KInstructionBloc(c.toArray(new KInstruction[c.size()])));
//                    c.clear();
//                    c.add(instruction);
//                }
//                labelsMap.put(oldOrdinal, all.size());
//            }else{
//                c.add(instruction);
//            }
//            if (instruction.isJump()) {
//                if (c.size() == 1) {
//                    all.add(c.get(0));
//                } else {
//                    all.add(new KInstructionBloc(c.toArray(new KInstruction[c.size()])));
//                }
//                c.clear();
//            }
//        }
//        if (c.size() == 1) {
//            all.add(c.get(0));
//        } else if (c.size() > 0) {
//            all.add(new KInstructionBloc(c.toArray(new KInstruction[c.size()])));
//        }
//        c.clear();
//        KInstruction[] instructions1 = all.toArray(new KInstruction[all.size()]);
//        for (int j = 0; j < instructions1.length; j++) {
//            KInstruction ibloc = instructions1[j];
//            if (ibloc instanceof KInstructionBloc) {
//                KInstructionBloc iblocOk = (KInstructionBloc) ibloc;
//                for (int i = 0; i < iblocOk.instructions.length; i++) {
//                    KInstruction instruction = iblocOk.instructions[i];
//                    instruction.restoreLabels(j, instructions1, method, labelsMap);
//                    if (i == (iblocOk.instructions.length - 1)) {
//                        instruction.relink(j, instructions1, method);
//                    } else {
//                        instruction.relink(i, iblocOk.instructions, method);
//                    }
//                }
//                ibloc.relink(j, instructions1, method);
//            } else {
//                ibloc.restoreLabels(j, instructions1, method, labelsMap);
//                ibloc.relink(j, instructions1, method);
//            }
//        }
//        KTryCatchDef[] blocs = new KTryCatchDef[blocs0.length];
//        for (int i = 0; i < blocs0.length; i++) {
//            KTryCatchDef kTryCatchDef = blocs0[i];
//            blocs[i]=new KTryCatchDef(
//                    labelsMap.get(kTryCatchDef.getFrom()),
//                    labelsMap.get(kTryCatchDef.getTo()),
//                    labelsMap.get(kTryCatchDef.getTarget()),
//                    kTryCatchDef.getType()
//            );
//        }
//        method.setTryCatchDef(blocs);
//        return instructions1;
//    }
//
////    private static void runNative(KFrame context) throws Exception {
////        log(null, context, context.getClassDef().getName() + "." + context.getMethod().getName() + "(" + Arrays.asList(context.getParameters()) + ")");
////        KRegister[] dRegisters = context.getParameters();
//////        KRegister[] orderedRegisters=new KRegister[dRegisters.length];
//////        for (int i = 0; i < orderedRegisters.length; i++) {
//////            orderedRegisters[i]=dRegisters[orderedRegisters.length-i-1];
//////
//////        }
////        KRegister[] orderedRegisters = dRegisters;
////        KRegister dRegister = context.getProcess().invokeNativeMethod(context.getClassDef().getName().replace('.', '/'), context.getMethod().getName(), context, orderedRegisters);
////        if (dRegister != null) {
////            context = context.popContext();
////            context.push(dRegister);
////        } else {
////            context = context.popContext();
////        }
////    }
//
////    private static void log(KJVMOperator op, KFrame frame, String msg) {
////        if (op == null) {
////            try {
////                System.out.println(">>[" + frame.getProcess().getPID() + "][" + frame.getKClass().getName() + "." + frame.getMethod().getName() + "][**native**] " + msg);
////            } catch (RemoteException e) {
////                e.printStackTrace();
////            }
////        } else {
////            try {
////                System.out.println(">>[" + frame.getProcess().getPID() + "][" + frame.getKClass().getName() + "." + frame.getMethod().getName() + "][" + op + "] " + msg);
////            } catch (RemoteException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//
//}
