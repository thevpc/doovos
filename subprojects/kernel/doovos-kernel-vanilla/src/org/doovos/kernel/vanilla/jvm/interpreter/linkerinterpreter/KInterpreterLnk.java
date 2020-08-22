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
//package org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter;
//
//import org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter.instr.*;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.process.KLocalThread;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
//import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//
//public final class KInterpreterLnk implements KInterpreter {
//    private static final KJVM_XTRA_JNI[] NATIVE_METHOD_CODE = new KJVM_XTRA_JNI[]{KJVM_XTRA_JNI.INSTANCE};
//
//    KInstructionLnk instr;
//
//    public KInterpreterLnk() {
//    }
//
//    public void init(KLocalThread thread) throws Exception {
//        //do nothing
//    }
//
//    public void init(KFrame frame) throws Exception {
//        instr = (KInstructionLnk) frame.getCurrentInstruction();
//    }
//
//    public KInstruction getCurrent(KFrame frame) throws Exception {
//        return instr;
//    }
//
//    public void run(KFrame frame) throws Exception {
////        System.out.println("????? : "+instr);
////        KInstruction old = instr;
//        instr = instr.run(frame);
//
////        if(frame.getThread().getFrame().getInstruction().getOrdinal()!=instr.getOrdinal()){
////            throw new IllegalStateException();
////        }
//    }
//
//    public void replace(KFrame frame,int index,KInstructionLnk newValue) throws RemoteException {
//        frame.getMethod().getCode()[index]=newValue;
//    }
//    
//    public void init(KMethod method) throws RemoteException {
//        KInstructionDef[] defs = method.getDefinition().getCode();
//        if (method.isNative() /*|| process.existsNativeMethod(method.getSignature())*/) {
//            method.setCode(NATIVE_METHOD_CODE);
//        } else {
//            KInstructionLnk[] instructions = new KInstructionLnk[defs.length];
//            for (int i = 0; i < instructions.length; i++) {
//                instructions[i] = createInstruction(i, defs[i]);
//                instructions[i].relink(i, instructions, method);
//            }
//            method.setCode(instructions);
//        }
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
//    private static void log(KOperator op, KFrame frame, String msg) {
//        if (op == null) {
//            try {
//                System.out.println(">>[" + frame.getProcess().getId() + "][" + frame.getKClass().getName() + "." + frame.getMethod().getName() + "][**native**] " + msg);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                System.out.println(">>[" + frame.getProcess().getId() + "][" + frame.getKClass().getName() + "." + frame.getMethod().getName() + "][" + op + "] " + msg);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    private KInstructionLnk createInstruction(int index,KInstructionDef def) {
//        KOperator operator = def.operator;
//        long[] operands = def.operands;
//        switch (operator) {
//            ///////////////////////
//            // A
//            ///////////////////////
//            case AALOAD:
//                return new KJVM_AALOAD();
//            case AASTORE:
//                return new KJVM_AASTORE();
//            case ACONST_NULL:
//                return new KJVM_ACONST_NULL();
//            case ALOAD:
//                return new KJVM_ALOAD(operands);
//            case ALOAD_0:
//                return new KJVM_ALOAD(KOperator.ALOAD_0, 0);
//            case ALOAD_1:
//                return new KJVM_ALOAD(KOperator.ALOAD_1, 1);
//            case ALOAD_2:
//                return new KJVM_ALOAD(KOperator.ALOAD_2, 2);
//            case ALOAD_3:
//                return new KJVM_ALOAD(KOperator.ALOAD_3, 3);
//            case ANEWARRAY:
//                return new KJVM_ANEWARRAY(operands);
//            case ARETURN:
//                return KJVM_ARETURN.INSTANCE;
//            case ARRAYLENGTH:
//                return KJVM_ARRAYLENGTH.INSTANCE;
//            case ASTORE:
//                return new KJVM_ASTORE(operands);
//            case ASTORE_0:
//                return KJVM_ASTORE.DLOAD_0;
//            case ASTORE_1:
//                return KJVM_ASTORE.DLOAD_1;
//            case ASTORE_2:
//                return KJVM_ASTORE.DLOAD_2;
//            case ASTORE_3:
//                return KJVM_ASTORE.DLOAD_3;
//            case ATHROW:
//                return KJVM_ATHROW.INSTANCE;
//
//            ///////////////////////
//            // B
//            ///////////////////////
//            case BALOAD:
//                return KJVM_BALOAD.INSTANCE;
//            case BASTORE:
//                return KJVM_BASTORE.INSTANCE;
//            case BIPUSH:
//                return new KJVM_BIPUSH(operands);
//
//            ///////////////////////
//            // C
//            ///////////////////////
//            case CALOAD:
//                return KJVM_CALOAD.INSTANCE;
//            case CASTORE:
//                return KJVM_CASTORE.INSTANCE;
//            case CHECKCAST:
//                return KJVM_CHECKCAST.INSTANCE;
//            case CRETURN:
//                return KJVM_CRETURN.INSTANCE;
//
//            ///////////////////////
//            // D
//            ///////////////////////
//            case D2F:
//                return KJVM_D2F.INSTANCE;
//            case D2I:
//                return KJVM_D2I.INSTANCE;
//            case D2L:
//                return KJVM_D2L.INSTANCE;
//            case DADD:
//                return KJVM_DADD.INSTANCE;
//            case DALOAD:
//                return KJVM_DALOAD.INSTANCE;
//            case DASTORE:
//                return KJVM_DASTORE.INSTANCE;
//            case DCMPG:
//                return KJVM_DCMPG.INSTANCE;
//            case DCMPL:
//                return KJVM_DCMPL.INSTANCE;
//            case DCONST_0:
//                return KJVM_DCONST.DCONST_0;
//            case DCONST_1:
//                return KJVM_DCONST.DCONST_1;
//            case DDIV:
//                return KJVM_DDIV.INSTANCE;
//            case DLOAD:
//                return new KJVM_DLOAD(operands);
//            case DLOAD_0:
//                return KJVM_DLOAD.DLOAD_0;
//            case DLOAD_1:
//                return KJVM_DLOAD.DLOAD_1;
//            case DLOAD_2:
//                return KJVM_DLOAD.DLOAD_2;
//            case DLOAD_3:
//                return KJVM_DLOAD.DLOAD_3;
//            case DMUL:
//                return KJVM_DMUL.INSTANCE;
//            case DNEG:
//                return KJVM_DNEG.INSTANCE;
//            case DREM:
//                return KJVM_DREM.INSTANCE;
//            case DRETURN:
//                return KJVM_DRETURN.INSTANCE;
//            case DSTORE:
//                return new KJVM_DSTORE(operands);
//            case DSTORE_0:
//                return KJVM_DSTORE.DSTORE_0;
//            case DSTORE_1:
//                return KJVM_DSTORE.DSTORE_1;
//            case DSTORE_2:
//                return KJVM_DSTORE.DSTORE_2;
//            case DSTORE_3:
//                return KJVM_DSTORE.DSTORE_3;
//            case DSUB:
//                return KJVM_DSUB.INSTANCE;
//            case DUP:
//                return KJVM_DUP.INSTANCE;
//            case DUP2:
//                return KJVM_DUP2.INSTANCE;
//            case DUP2_X1:
//                return KJVM_DUP2_X1.INSTANCE;
//            case DUP2_X2:
//                return KJVM_DUP2_X2.INSTANCE;
//            case DUP_X1:
//                return KJVM_DUP_X1.INSTANCE;
//            case DUP_X2:
//                return KJVM_DUP_X2.INSTANCE;
//
//            ///////////////////////
//            // F
//            ///////////////////////
//            case F2D:
//                return KJVM_F2D.INSTANCE;
//            case F2I:
//                return KJVM_F2I.INSTANCE;
//            case F2L:
//                return KJVM_F2L.INSTANCE;
//            case FADD:
//                return KJVM_FADD.INSTANCE;
//            case FALOAD:
//                return KJVM_FALOAD.INSTANCE;
//            case FASTORE:
//                return KJVM_FASTORE.INSTANCE;
//            case FCMPG:
//                return KJVM_FCMPG.INSTANCE;
//            case FCMPL:
//                return KJVM_FCMPL.INSTANCE;
//            case FCONST_0:
//                return KJVM_FCONST.FCONST_0;
//            case FCONST_1:
//                return KJVM_FCONST.FCONST_1;
//            case FCONST_2:
//                return KJVM_FCONST.FCONST_2;
//            case FDIV:
//                return KJVM_FDIV.INSTANCE;
//            case FLOAD:
//                return new KJVM_FLOAD(operands);
//            case FLOAD_0:
//                return KJVM_FLOAD.FLOAD_0;
//            case FLOAD_1:
//                return KJVM_FLOAD.FLOAD_1;
//            case FLOAD_2:
//                return KJVM_FLOAD.FLOAD_2;
//            case FLOAD_3:
//                return KJVM_FLOAD.FLOAD_3;
//            case FMUL:
//                return KJVM_FMUL.INSTANCE;
//            case FNEG:
//                return KJVM_FNEG.INSTANCE;
//            case FREM:
//                return KJVM_FREM.INSTANCE;
//            case FRETURN:
//                return KJVM_FRETURN.INSTANCE;
//            case FSTORE:
//                return new KJVM_FSTORE(operands);
//            case FSTORE_0:
//                return KJVM_FSTORE.FSTORE_0;
//            case FSTORE_1:
//                return KJVM_FSTORE.FSTORE_1;
//            case FSTORE_2:
//                return KJVM_FSTORE.FSTORE_2;
//            case FSTORE_3:
//                return KJVM_FSTORE.FSTORE_3;
//            case FSUB:
//                return KJVM_FSUB.INSTANCE;
//
//            ///////////////////////
//            // G
//            ///////////////////////
//            case GETFIELD:
//                return new KJVM_GETFIELD(operands);
//            case GETSTATIC:
//                return new KJVM_GETSTATIC(operands);
//            case GOTO:
//                return new KJVM_GOTO(operands);
//            case GOTO_W:
//                return new KJVM_GOTO_W(operands);
//
//            ///////////////////////
//            // I
//            ///////////////////////
//            case I2B:
//                return KJVM_I2B.INSTANCE;
//            case I2C:
//                return KJVM_I2C.INSTANCE;
//            case I2D:
//                return KJVM_I2D.INSTANCE;
//            case I2F:
//                return KJVM_I2F.INSTANCE;
//            case I2L:
//                return KJVM_I2L.INSTANCE;
//            case I2S:
//                return KJVM_I2S.INSTANCE;
//            case IADD:
//                return KJVM_IADD.INSTANCE;
//            case IALOAD:
//                return KJVM_IALOAD.INSTANCE;
//            case IAND:
//                return KJVM_IAND.INSTANCE;
//            case IASTORE:
//                return KJVM_IASTORE.INSTANCE;
//            case ICONST_0:
//                return KJVM_ICONST.ICONST_0;
//            case ICONST_1:
//                return KJVM_ICONST.ICONST_1;
//            case ICONST_2:
//                return KJVM_ICONST.ICONST_2;
//            case ICONST_3:
//                return KJVM_ICONST.ICONST_3;
//            case ICONST_4:
//                return KJVM_ICONST.ICONST_4;
//            case ICONST_5:
//                return KJVM_ICONST.ICONST_5;
//            case ICONST_M1:
//                return KJVM_ICONST.ICONST_M1;
//            case IDIV:
//                return KJVM_IDIV.INSTANCE;
//            case IF_ACMPEQ:
//                return new KJVM_IF_ACMPEQ(operands);
//            case IF_ACMPNE:
//                return new KJVM_IF_ACMPNE(operands);
//            case IF_ICMPEQ:
//                return new KJVM_IF_ICMPEQ(operands);
//            case IF_ICMPGE:
//                return new KJVM_IF_ICMPGE(operands);
//            case IF_ICMPGT:
//                return new KJVM_IF_ICMPGT(operands);
//            case IF_ICMPLE:
//                return new KJVM_IF_ICMPLE(operands);
//            case IF_ICMPLT:
//                return new KJVM_IF_ICMPLT(operands);
//            case IF_ICMPNE:
//                return new KJVM_IF_ICMPNE(operands);
//            case IFEQ:
//                return new KJVM_IFEQ(operands);
//            case IFGE:
//                return new KJVM_IFGE(operands);
//            case IFGT:
//                return new KJVM_IFGT(operands);
//            case IFLE:
//                return new KJVM_IFLE(operands);
//            case IFLT:
//                return new KJVM_IFLT(operands);
//            case IFNE:
//                return new KJVM_IFNE(operands);
//            case IFNONNULL:
//                return new KJVM_IFNONNULL(operands);
//            case IFNULL:
//                return new KJVM_IFNULL(operands);
//            case IINC:
//                return new KJVM_IINC(operands);
//            case ILOAD:
//                return new KJVM_ILOAD(operands);
//            case ILOAD_0:
//                return KJVM_ILOAD.ILOAD_0;
//            case ILOAD_1:
//                return KJVM_ILOAD.ILOAD_1;
//            case ILOAD_2:
//                return KJVM_ILOAD.ILOAD_2;
//            case ILOAD_3:
//                return KJVM_ILOAD.ILOAD_3;
//            case IMUL:
//                return KJVM_IMUL.INSTANCE;
//            case INEG:
//                return KJVM_INEG.INSTANCE;
//            case INSTANCEOF:
//                return new KJVM_INSTANCEOF(operands);
//            case INVOKEINTERFACE:
//                return new KJVM_INVOKEINTERFACE(operands);
//            case INVOKESPECIAL:
//                return new KJVM_INVOKESPECIAL(operands);
//            case INVOKESTATIC:
//                return new KJVM_INVOKESTATIC(operands);
//            case INVOKEVIRTUAL:
//                return new KJVM_INVOKEVIRTUAL(operands);
//            case IOR:
//                return KJVM_IOR.INSTANCE;
//            case IPUSH:
//                return new KJVM_IPUSH(operands);
//            case IREM:
//                return KJVM_IREM.INSTANCE;
//            case IRETURN:
//                return KJVM_IRETURN.INSTANCE;
//            case ISHL:
//                return KJVM_ISHL.INSTANCE;
//            case ISHR:
//                return KJVM_ISHR.INSTANCE;
//            case ISTORE:
//                return new KJVM_ISTORE(operands);
//            case ISTORE_0:
//                return KJVM_ISTORE.ISTORE_0;
//            case ISTORE_1:
//                return KJVM_ISTORE.ISTORE_1;
//            case ISTORE_2:
//                return KJVM_ISTORE.ISTORE_2;
//            case ISTORE_3:
//                return KJVM_ISTORE.ISTORE_3;
//            case ISUB:
//                return KJVM_ISUB.INSTANCE;
//            case IUSHR:
//                return KJVM_IUSHR.INSTANCE;
//            case IXOR:
//                return KJVM_IXOR.INSTANCE;
//
//            ///////////////////////
//            // J
//            ///////////////////////
//            case JSR:
//                return new KJVM_JSR(index,operands);
//            case JSR_W:
//                return new KJVM_JSR_W(index,operands);
//
//            ///////////////////////
//            // L
//            ///////////////////////
//            case L2D:
//                return KJVM_L2D.INSTANCE;
//            case L2F:
//                return KJVM_L2F.INSTANCE;
//            case L2I:
//                return KJVM_L2I.INSTANCE;
//            case LADD:
//                return KJVM_LADD.INSTANCE;
//            case LALOAD:
//                return KJVM_LALOAD.INSTANCE;
//            case LAND:
//                return KJVM_LAND.INSTANCE;
//            case LASTORE:
//                return KJVM_LASTORE.INSTANCE;
//            case LCMP:
//                return KJVM_LCMP.INSTANCE;
//            case LCONST_0:
//                return KJVM_LCONST.LCONST_0;
//            case LCONST_1:
//                return KJVM_LCONST.LCONST_1;
//            case LDC:
//                return new KJVM_LDC(operands);
//            case LDC2_W:
//                return new KJVM_LDC2_W(operands);
//            case LDC_W:
//                return new KJVM_LDC_W(operands);
//            case LDIV:
//                return KJVM_LDIV.INSTANCE;
//            case LLOAD:
//                return new KJVM_LLOAD(operands);
//            case LLOAD_0:
//                return KJVM_LLOAD.LLOAD_0;
//            case LLOAD_1:
//                return KJVM_LLOAD.LLOAD_1;
//            case LLOAD_2:
//                return KJVM_LLOAD.LLOAD_2;
//            case LLOAD_3:
//                return KJVM_LLOAD.LLOAD_3;
//            case LMUL:
//                return KJVM_LMUL.INSTANCE;
//            case LNEG:
//                return KJVM_LNEG.INSTANCE;
//            case LOOKUPSWITCH:
//                return new KJVM_LOOKUPSWITCH(operands);
//            case LOR:
//                return KJVM_LOR.INSTANCE;
//            case LREM:
//                return KJVM_LREM.INSTANCE;
//            case LRETURN:
//                return KJVM_LRETURN.INSTANCE;
//            case LSHL:
//                return KJVM_LSHL.INSTANCE;
//            case LSHR:
//                return KJVM_LSHR.INSTANCE;
//            case LSTORE:
//                return new KJVM_LSTORE(operands);
//            case LSTORE_0:
//                return KJVM_LSTORE.LSTORE_0;
//            case LSTORE_1:
//                return KJVM_LSTORE.LSTORE_1;
//            case LSTORE_2:
//                return KJVM_LSTORE.LSTORE_2;
//            case LSTORE_3:
//                return KJVM_LSTORE.LSTORE_3;
//            case LSUB:
//                return KJVM_LSUB.INSTANCE;
//            case LUSHR:
//                return KJVM_LUSHR.INSTANCE;
//            case LXOR:
//                return KJVM_LXOR.INSTANCE;
//            case MONITORENTER:
//                return KJVM_MONITORENTER.INSTANCE;
//            case MONITOREXIT:
//                return KJVM_MONITOREXIT.INSTANCE;
//            case MULTIANEWARRAY:
//                return new KJVM_MULTIANEWARRAY(operands);
//            case NOP:
//                return KJVM_NOP.INSTANCE;
//
//            ///////////////////////
//            // N
//            ///////////////////////
//            case NEW:
//                return new KJVM_NEW(operands);
//            case NEWARRAY:
//                return KJVM_NEWARRAY.createInstance(operands);
//
//            ///////////////////////
//            // P
//            ///////////////////////
//            case POP:
//                return KJVM_POP.INSTANCE;
//            case POP2:
//                return KJVM_POP2.INSTANCE;
//            case PUTFIELD:
//                return new KJVM_PUTFIELD(operands);
//            case PUTSTATIC:
//                return new KJVM_PUTSTATIC(operands);
//
//            ///////////////////////
//            // R
//            ///////////////////////
//            case RET:
//                return new KJVM_RET(operands);
//            case RETURN:
//                return KJVM_RETURN.INSTANCE;
//
//            ///////////////////////
//            // S
//            ///////////////////////
//            case SALOAD:
//                return KJVM_SALOAD.INSTANCE;
//            case SASTORE:
//                return KJVM_SASTORE.INSTANCE;
//            case SIPUSH:
//                return new KJVM_SIPUSH(operands);
//            case SRETURN:
//                return KJVM_SRETURN.INSTANCE;
//            case SWAP:
//                return KJVM_SWAP.INSTANCE;
//            case TABLESWITCH:
//                return new KJVM_TABLESWITCH(operands);
//
//
//            ///////////////////////
//            // EXTRA
//            ///////////////////////
//
//            case WIDE:
//                return new KJVM_WIDE();
//
//            ///////////////////////
//            // EXTRA
//            ///////////////////////
//
//            case XTRA_JNI:
//                return KJVM_XTRA_JNI.INSTANCE;
//        }
//        throw new IllegalArgumentException("Unknown operator implementation " + operator);
//        //return new KJVMInstructionDefaultImpl(operator, operands);
//    }
//
//}
