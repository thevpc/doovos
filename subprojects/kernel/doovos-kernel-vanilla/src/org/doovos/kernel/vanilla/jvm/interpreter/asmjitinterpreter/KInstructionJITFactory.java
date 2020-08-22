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
package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter;

import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr.*;

/**
 *
 * @author maiga
 */
public class KInstructionJITFactory {

    public static final int XTRA_JNI = 1000;

    public KInstructionJIT createInstruction(int index, KInstructionDef def) {
        int operator = def.operator;
        long[] operands = def.operands;
        switch (operator) {
            ///////////////////////
            // Aex
            ///////////////////////
            case KOperatorCodes.AALOAD:
                return new KJVM_AALOADDump();
//            case KOperatorCodes.AASTORE:
//                return new KJVM_AASTORE();
//            case KOperatorCodes.ACONST_NULL:
//                return KJVM_ACONST_NULL.INSTANCE;
//            case KOperatorCodes.ALOAD:
//                return new KJVM_ALOAD(operands);
//            case KOperatorCodes.ALOAD_0:
//                return KJVM_ALOAD.ALOAD_0;
//            case KOperatorCodes.ALOAD_1:
//                return KJVM_ALOAD.ALOAD_1;
//            case KOperatorCodes.ALOAD_2:
//                return KJVM_ALOAD.ALOAD_2;
//            case KOperatorCodes.ALOAD_3:
//                return KJVM_ALOAD.ALOAD_3;
//            case KOperatorCodes.ANEWARRAY:
//                return new KJVM_ANEWARRAY(operands);
//            case KOperatorCodes.ARETURN:
//                return KJVM_ARETURN.INSTANCE;
//            case KOperatorCodes.ARRAYLENGTH:
//                return KJVM_ARRAYLENGTH.INSTANCE;
//            case KOperatorCodes.ASTORE:
//                return new KJVM_ASTORE(operands);
//            case KOperatorCodes.ASTORE_0:
//                return KJVM_ASTORE.DSTORE_0;
//            case KOperatorCodes.ASTORE_1:
//                return KJVM_ASTORE.DSTORE_1;
//            case KOperatorCodes.ASTORE_2:
//                return KJVM_ASTORE.DSTORE_2;
//            case KOperatorCodes.ASTORE_3:
//                return KJVM_ASTORE.DSTORE_3;
//            case KOperatorCodes.ATHROW:
//                return KJVM_ATHROW.INSTANCE;
//
//            ///////////////////////
//            // B
//            ///////////////////////
//            case KOperatorCodes.BALOAD:
//                return KJVM_BALOAD.INSTANCE;
//            case KOperatorCodes.BASTORE:
//                return KJVM_BASTORE.INSTANCE;
//            case KOperatorCodes.BIPUSH:
//                return new KJVM_BIPUSH(operands);
//
//            ///////////////////////
//            // C
//            ///////////////////////
//            case KOperatorCodes.CALOAD:
//                return KJVM_CALOAD.INSTANCE;
//            case KOperatorCodes.CASTORE:
//                return KJVM_CASTORE.INSTANCE;
//            case KOperatorCodes.CHECKCAST:
//                return KJVM_CHECKCAST.INSTANCE;
////            case KOperatorCodes.CRETURN:
////                return KJVM_CRETURN.INSTANCE;
//
//            ///////////////////////
//            // D
//            ///////////////////////
//            case KOperatorCodes.D2F:
//                return KJVM_D2F.INSTANCE;
//            case KOperatorCodes.D2I:
//                return KJVM_D2I.INSTANCE;
//            case KOperatorCodes.D2L:
//                return KJVM_D2L.INSTANCE;
//            case KOperatorCodes.DADD:
//                return KJVM_DADD.INSTANCE;
//            case KOperatorCodes.DALOAD:
//                return KJVM_DALOAD.INSTANCE;
//            case KOperatorCodes.DASTORE:
//                return KJVM_DASTORE.INSTANCE;
//            case KOperatorCodes.DCMPG:
//                return KJVM_DCMPG.INSTANCE;
//            case KOperatorCodes.DCMPL:
//                return KJVM_DCMPL.INSTANCE;
//            case KOperatorCodes.DCONST_0:
//                return KJVM_DCONST.DCONST_0;
//            case KOperatorCodes.DCONST_1:
//                return KJVM_DCONST.DCONST_1;
//            case KOperatorCodes.DDIV:
//                return KJVM_DDIV.INSTANCE;
//            case KOperatorCodes.DLOAD:
//                return new KJVM_DLOAD(operands);
//            case KOperatorCodes.DLOAD_0:
//                return KJVM_DLOAD.DLOAD_0;
//            case KOperatorCodes.DLOAD_1:
//                return KJVM_DLOAD.DLOAD_1;
//            case KOperatorCodes.DLOAD_2:
//                return KJVM_DLOAD.DLOAD_2;
//            case KOperatorCodes.DLOAD_3:
//                return KJVM_DLOAD.DLOAD_3;
//            case KOperatorCodes.DMUL:
//                return KJVM_DMUL.INSTANCE;
//            case KOperatorCodes.DNEG:
//                return KJVM_DNEG.INSTANCE;
//            case KOperatorCodes.DREM:
//                return KJVM_DREM.INSTANCE;
//            case KOperatorCodes.DRETURN:
//                return KJVM_DRETURN.INSTANCE;
//            case KOperatorCodes.DSTORE:
//                return new KJVM_DSTORE(operands);
//            case KOperatorCodes.DSTORE_0:
//                return KJVM_DSTORE.DSTORE_0;
//            case KOperatorCodes.DSTORE_1:
//                return KJVM_DSTORE.DSTORE_1;
//            case KOperatorCodes.DSTORE_2:
//                return KJVM_DSTORE.DSTORE_2;
//            case KOperatorCodes.DSTORE_3:
//                return KJVM_DSTORE.DSTORE_3;
//            case KOperatorCodes.DSUB:
//                return KJVM_DSUB.INSTANCE;
//            case KOperatorCodes.DUP:
//                return KJVM_DUP.INSTANCE;
//            case KOperatorCodes.DUP2:
//                return KJVM_DUP2.INSTANCE;
//            case KOperatorCodes.DUP2_X1:
//                return KJVM_DUP2_X1.INSTANCE;
//            case KOperatorCodes.DUP2_X2:
//                return KJVM_DUP2_X2.INSTANCE;
//            case KOperatorCodes.DUP_X1:
//                return KJVM_DUP_X1.INSTANCE;
//            case KOperatorCodes.DUP_X2:
//                return KJVM_DUP_X2.INSTANCE;
//
//            ///////////////////////
//            // F
//            ///////////////////////
//            case KOperatorCodes.F2D:
//                return KJVM_F2D.INSTANCE;
//            case KOperatorCodes.F2I:
//                return KJVM_F2I.INSTANCE;
//            case KOperatorCodes.F2L:
//                return KJVM_F2L.INSTANCE;
//            case KOperatorCodes.FADD:
//                return KJVM_FADD.INSTANCE;
//            case KOperatorCodes.FALOAD:
//                return KJVM_FALOAD.INSTANCE;
//            case KOperatorCodes.FASTORE:
//                return KJVM_FASTORE.INSTANCE;
//            case KOperatorCodes.FCMPG:
//                return KJVM_FCMPG.INSTANCE;
//            case KOperatorCodes.FCMPL:
//                return KJVM_FCMPL.INSTANCE;
//            case KOperatorCodes.FCONST_0:
//                return KJVM_FCONST.FCONST_0;
//            case KOperatorCodes.FCONST_1:
//                return KJVM_FCONST.FCONST_1;
//            case KOperatorCodes.FCONST_2:
//                return KJVM_FCONST.FCONST_2;
//            case KOperatorCodes.FDIV:
//                return KJVM_FDIV.INSTANCE;
//            case KOperatorCodes.FLOAD:
//                return new KJVM_FLOAD(operands);
//            case KOperatorCodes.FLOAD_0:
//                return KJVM_FLOAD.FLOAD_0;
//            case KOperatorCodes.FLOAD_1:
//                return KJVM_FLOAD.FLOAD_1;
//            case KOperatorCodes.FLOAD_2:
//                return KJVM_FLOAD.FLOAD_2;
//            case KOperatorCodes.FLOAD_3:
//                return KJVM_FLOAD.FLOAD_3;
//            case KOperatorCodes.FMUL:
//                return KJVM_FMUL.INSTANCE;
//            case KOperatorCodes.FNEG:
//                return KJVM_FNEG.INSTANCE;
//            case KOperatorCodes.FREM:
//                return KJVM_FREM.INSTANCE;
//            case KOperatorCodes.FRETURN:
//                return KJVM_FRETURN.INSTANCE;
//            case KOperatorCodes.FSTORE:
//                return new KJVM_FSTORE(operands);
//            case KOperatorCodes.FSTORE_0:
//                return KJVM_FSTORE.FSTORE_0;
//            case KOperatorCodes.FSTORE_1:
//                return KJVM_FSTORE.FSTORE_1;
//            case KOperatorCodes.FSTORE_2:
//                return KJVM_FSTORE.FSTORE_2;
//            case KOperatorCodes.FSTORE_3:
//                return KJVM_FSTORE.FSTORE_3;
//            case KOperatorCodes.FSUB:
//                return KJVM_FSUB.INSTANCE;
//
//            ///////////////////////
//            // G
//            ///////////////////////
//            case KOperatorCodes.GETFIELD:
//                return new KJVM_GETFIELD(operands);
//            case KOperatorCodes.GETSTATIC:
//                return new KJVM_GETSTATIC(operands);
//            case KOperatorCodes.GOTO:
//                return new KJVM_GOTO(operands);
//            case KOperatorCodes.GOTO_W:
//                return new KJVM_GOTO_W(operands);
//
//            ///////////////////////
//            // I
//            ///////////////////////
//            case KOperatorCodes.I2B:
//                return KJVM_I2B.INSTANCE;
//            case KOperatorCodes.I2C:
//                return KJVM_I2C.INSTANCE;
//            case KOperatorCodes.I2D:
//                return KJVM_I2D.INSTANCE;
//            case KOperatorCodes.I2F:
//                return KJVM_I2F.INSTANCE;
//            case KOperatorCodes.I2L:
//                return KJVM_I2L.INSTANCE;
//            case KOperatorCodes.I2S:
//                return KJVM_I2S.INSTANCE;
//            case KOperatorCodes.IADD:
//                return KJVM_IADD.INSTANCE;
//            case KOperatorCodes.IALOAD:
//                return KJVM_IALOAD.INSTANCE;
//            case KOperatorCodes.IAND:
//                return KJVM_IAND.INSTANCE;
//            case KOperatorCodes.IASTORE:
//                return KJVM_IASTORE.INSTANCE;
            case KOperatorCodes.ICONST_0:
                return KJVM_ICONSTDump.newICONST_0();
            case KOperatorCodes.ICONST_1:
                return KJVM_ICONSTDump.newICONST_1();

            case KOperatorCodes.ICONST_2:
                return KJVM_ICONSTDump.newICONST_2();
            case KOperatorCodes.ICONST_3:
                return KJVM_ICONSTDump.newICONST_3();
            case KOperatorCodes.ICONST_4:
                return KJVM_ICONSTDump.newICONST_4();
            case KOperatorCodes.ICONST_5:
                return KJVM_ICONSTDump.newICONST_5();
            case KOperatorCodes.ICONST_M1:
                return KJVM_ICONSTDump.newICONST_M1();
//            case KOperatorCodes.IDIV:
//                return KJVM_IDIV.INSTANCE;
//            case KOperatorCodes.IF_ACMPEQ:
//                return new KJVM_IF_ACMPEQ(operands);
//            case KOperatorCodes.IF_ACMPNE:
//                return new KJVM_IF_ACMPNE(operands);
//            case KOperatorCodes.IF_ICMPEQ:
//                return new KJVM_IF_ICMPEQ(operands);
//            case KOperatorCodes.IF_ICMPGE:
//                return new KJVM_IF_ICMPGE(operands);
//            case KOperatorCodes.IF_ICMPGT:
//                return new KJVM_IF_ICMPGT(operands);
//            case KOperatorCodes.IF_ICMPLE:
//                return new KJVM_IF_ICMPLE(operands);
//            case KOperatorCodes.IF_ICMPLT:
//                return new KJVM_IF_ICMPLT(operands);
//            case KOperatorCodes.IF_ICMPNE:
//                return new KJVM_IF_ICMPNE(operands);
//            case KOperatorCodes.IFEQ:
//                return new KJVM_IFEQ(operands);
//            case KOperatorCodes.IFGE:
//                return new KJVM_IFGE(operands);
//            case KOperatorCodes.IFGT:
//                return new KJVM_IFGT(operands);
//            case KOperatorCodes.IFLE:
//                return new KJVM_IFLE(operands);
//            case KOperatorCodes.IFLT:
//                return new KJVM_IFLT(operands);
//            case KOperatorCodes.IFNE:
//                return new KJVM_IFNE(operands);
//            case KOperatorCodes.IFNONNULL:
//                return new KJVM_IFNONNULL(operands);
//            case KOperatorCodes.IFNULL:
//                return new KJVM_IFNULL(operands);
//            case KOperatorCodes.IINC:
//                return new KJVM_IINC(operands);
            case KOperatorCodes.ILOAD:
                return new KJVM_ILOADDump((int)operands[0]);
            case KOperatorCodes.ILOAD_0:
                return new KJVM_ILOADDump(0);
            case KOperatorCodes.ILOAD_1:
                return new KJVM_ILOADDump(1);
            case KOperatorCodes.ILOAD_2:
                return new KJVM_ILOADDump(2);
            case KOperatorCodes.ILOAD_3:
                return new KJVM_ILOADDump(3);
//            case KOperatorCodes.IMUL:
//                return KJVM_IMUL.INSTANCE;
//            case KOperatorCodes.INEG:
//                return KJVM_INEG.INSTANCE;
//            case KOperatorCodes.INSTANCEOF:
//                return new KJVM_INSTANCEOF(operands);
//            case KOperatorCodes.INVOKEINTERFACE:
//                return new KJVM_INVOKEINTERFACE(operands);
//            case KOperatorCodes.INVOKESPECIAL:
//                return new KJVM_INVOKESPECIAL(operands);
            case KOperatorCodes.INVOKESTATIC:
                return new KJVM_INVOKESTATICDump(operands);
//            case KOperatorCodes.INVOKEVIRTUAL:
//                return new KJVM_INVOKEVIRTUAL(operands);
//            case KOperatorCodes.IOR:
//                return KJVM_IOR.INSTANCE;
////            case KOperatorCodes.IPUSH:
////                return new KJVM_IPUSH(operands);
//            case KOperatorCodes.IREM:
//                return KJVM_IREM.INSTANCE;
//            case KOperatorCodes.IRETURN:
//                return KJVM_IRETURN.INSTANCE;
//            case KOperatorCodes.ISHL:
//                return KJVM_ISHL.INSTANCE;
//            case KOperatorCodes.ISHR:
//                return KJVM_ISHR.INSTANCE;
            case KOperatorCodes.ISTORE:
                return  KJVM_ISTOREDump.newISTORE((int)operands[0]);
            case KOperatorCodes.ISTORE_0:
                return KJVM_ISTOREDump.newISTORE_0();
            case KOperatorCodes.ISTORE_1:
                return KJVM_ISTOREDump.newISTORE_1();
            case KOperatorCodes.ISTORE_2:
                return KJVM_ISTOREDump.newISTORE_2();
            case KOperatorCodes.ISTORE_3:
                return KJVM_ISTOREDump.newISTORE_3();
//            case KOperatorCodes.ISUB:
//                return KJVM_ISUB.INSTANCE;
//            case KOperatorCodes.IUSHR:
//                return KJVM_IUSHR.INSTANCE;
//            case KOperatorCodes.IXOR:
//                return KJVM_IXOR.INSTANCE;
//
//            ///////////////////////
//            // J
//            ///////////////////////
//            case KOperatorCodes.JSR:
//                return new KJVM_JSR(index, operands);
//            case KOperatorCodes.JSR_W:
//                return new KJVM_JSR_W(index, operands);
//
//            ///////////////////////
//            // L
//            ///////////////////////
//            case KOperatorCodes.L2D:
//                return KJVM_L2D.INSTANCE;
//            case KOperatorCodes.L2F:
//                return KJVM_L2F.INSTANCE;
//            case KOperatorCodes.L2I:
//                return KJVM_L2I.INSTANCE;
//            case KOperatorCodes.LADD:
//                return KJVM_LADD.INSTANCE;
//            case KOperatorCodes.LALOAD:
//                return KJVM_LALOAD.INSTANCE;
//            case KOperatorCodes.LAND:
//                return KJVM_LAND.INSTANCE;
//            case KOperatorCodes.LASTORE:
//                return KJVM_LASTORE.INSTANCE;
//            case KOperatorCodes.LCMP:
//                return KJVM_LCMP.INSTANCE;
//            case KOperatorCodes.LCONST_0:
//                return KJVM_LCONST.LCONST_0;
//            case KOperatorCodes.LCONST_1:
//                return KJVM_LCONST.LCONST_1;
//            case KOperatorCodes.LDC:
//                return new KJVM_LDC(operands);
//            case KOperatorCodes.LDC2_W:
//                return new KJVM_LDC2_W(operands);
//            case KOperatorCodes.LDC_W:
//                return new KJVM_LDC_W(operands);
//            case KOperatorCodes.LDIV:
//                return KJVM_LDIV.INSTANCE;
//            case KOperatorCodes.LLOAD:
//                return new KJVM_LLOAD(operands);
//            case KOperatorCodes.LLOAD_0:
//                return KJVM_LLOAD.LLOAD_0;
//            case KOperatorCodes.LLOAD_1:
//                return KJVM_LLOAD.LLOAD_1;
//            case KOperatorCodes.LLOAD_2:
//                return KJVM_LLOAD.LLOAD_2;
//            case KOperatorCodes.LLOAD_3:
//                return KJVM_LLOAD.LLOAD_3;
//            case KOperatorCodes.LMUL:
//                return KJVM_LMUL.INSTANCE;
//            case KOperatorCodes.LNEG:
//                return KJVM_LNEG.INSTANCE;
//            case KOperatorCodes.LOOKUPSWITCH:
//                return new KJVM_LOOKUPSWITCH(operands);
//            case KOperatorCodes.LOR:
//                return KJVM_LOR.INSTANCE;
//            case KOperatorCodes.LREM:
//                return KJVM_LREM.INSTANCE;
//            case KOperatorCodes.LRETURN:
//                return KJVM_LRETURN.INSTANCE;
//            case KOperatorCodes.LSHL:
//                return KJVM_LSHL.INSTANCE;
//            case KOperatorCodes.LSHR:
//                return KJVM_LSHR.INSTANCE;
//            case KOperatorCodes.LSTORE:
//                return new KJVM_LSTORE(operands);
//            case KOperatorCodes.LSTORE_0:
//                return KJVM_LSTORE.LSTORE_0;
//            case KOperatorCodes.LSTORE_1:
//                return KJVM_LSTORE.LSTORE_1;
//            case KOperatorCodes.LSTORE_2:
//                return KJVM_LSTORE.LSTORE_2;
//            case KOperatorCodes.LSTORE_3:
//                return KJVM_LSTORE.LSTORE_3;
//            case KOperatorCodes.LSUB:
//                return KJVM_LSUB.INSTANCE;
//            case KOperatorCodes.LUSHR:
//                return KJVM_LUSHR.INSTANCE;
//            case KOperatorCodes.LXOR:
//                return KJVM_LXOR.INSTANCE;
//            case KOperatorCodes.MONITORENTER:
//                return KJVM_MONITORENTER.INSTANCE;
//            case KOperatorCodes.MONITOREXIT:
//                return KJVM_MONITOREXIT.INSTANCE;
//            case KOperatorCodes.MULTIANEWARRAY:
//                return new KJVM_MULTIANEWARRAY(operands);
//            case KOperatorCodes.NOP:
//                return KJVM_NOP.INSTANCE;
//
//            ///////////////////////
//            // N
//            ///////////////////////
//            case KOperatorCodes.NEW:
//                return new KJVM_NEW(operands);
//            case KOperatorCodes.NEWARRAY:
//                return KJVM_NEWARRAY.createInstance(operands);
//
//            ///////////////////////
//            // P
//            ///////////////////////
//            case KOperatorCodes.POP:
//                return KJVM_POP.INSTANCE;
//            case KOperatorCodes.POP2:
//                return KJVM_POP2.INSTANCE;
//            case KOperatorCodes.PUTFIELD:
//                return new KJVM_PUTFIELD(operands);
//            case KOperatorCodes.PUTSTATIC:
//                return new KJVM_PUTSTATIC(operands);
//
//            ///////////////////////
//            // R
//            ///////////////////////
//            case KOperatorCodes.RET:
//                return new KJVM_RET(operands);
            case KOperatorCodes.RETURN:
                return new KJVM_RETURNDump();
//
//            ///////////////////////
//            // S
//            ///////////////////////
//            case KOperatorCodes.SALOAD:
//                return KJVM_SALOAD.INSTANCE;
//            case KOperatorCodes.SASTORE:
//                return KJVM_SASTORE.INSTANCE;
//            case KOperatorCodes.SIPUSH:
//                return new KJVM_SIPUSH(operands);
////            case KOperatorCodes.SRETURN:
////                return KJVM_SRETURN.INSTANCE;
//            case KOperatorCodes.SWAP:
//                return KJVM_SWAP.INSTANCE;
//            case KOperatorCodes.TABLESWITCH:
//                return new KJVM_TABLESWITCH(operands);
//
//
//            ///////////////////////
//            // EXTRA
//            ///////////////////////
//
//            case KOperatorCodes.WIDE:
//                return new KJVM_WIDE();

            ///////////////////////
            // EXTRA
            ///////////////////////

            case XTRA_JNI:
                return KJVM_XTRA_JNI.INSTANCE;
        }
        throw new IllegalArgumentException("Unknown operator implementation " + operator + " (" + KOperatorCodes.ALL_NAMES[operator] + ") ");
        //return new KJVMInstructionDefaultImpl(operator, operands);
    }
}
