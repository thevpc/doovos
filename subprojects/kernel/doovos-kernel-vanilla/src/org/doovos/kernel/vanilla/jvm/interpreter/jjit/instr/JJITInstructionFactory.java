/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_AALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_AASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ACONST_NULL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ANEWARRAY;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ARETURN;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ARRAYLENGTH;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ATHROW;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_BALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_BASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_BIPUSH;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_CALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_CASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_CHECKCAST;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_D2F;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_D2I;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_D2L;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DADD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DCMPG;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DCMPL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DCONST;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DDIV;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DLOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DMUL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DNEG;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DREM;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DRETURN;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DSTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DSUB;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DUP;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DUP2;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DUP2_X1;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DUP2_X2;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DUP_X1;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_DUP_X2;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_F2D;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_F2I;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_F2L;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FADD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FCMPG;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FCMPL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FCONST;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FDIV;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FLOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FMUL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FNEG;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FREM;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FRETURN;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FSTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_FSUB;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_GETFIELD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_GETSTATIC;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_GOTO;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_GOTO_W;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_I2B;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_I2C;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_I2D;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_I2F;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_I2L;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_I2S;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IADD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IAND;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ICONST;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IDIV;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFEQ;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFGE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFGT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFLE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFLT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFNE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFNONNULL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IFNULL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ACMPEQ;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ACMPNE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ICMPEQ;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ICMPGE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ICMPGT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ICMPLE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ICMPLT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IF_ICMPNE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IINC;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ILOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IMUL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_INEG;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_INSTANCEOF;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_INVOKEINTERFACE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_INVOKESPECIAL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_INVOKESTATIC;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_INVOKEVIRTUAL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IOR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IREM;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IRETURN;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ISHL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ISHR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ISTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_ISUB;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IUSHR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_IXOR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_JSR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_JSR_W;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_L2D;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_L2F;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_L2I;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LADD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LAND;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LCMP;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LCONST;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LDC;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LDC2_W;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LDC_W;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LDIV;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LLOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LMUL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LNEG;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LOOKUPSWITCH;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LOR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LREM;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LRETURN;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LSHL;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LSHR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LSTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LSUB;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LUSHR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_LXOR;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_MONITORENTER;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_MONITOREXIT;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_MULTIANEWARRAY;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_NEW;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_NEWARRAY;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_NOP;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_POP;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_POP2;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_PUTFIELD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_PUTSTATIC;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_RET;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_RETURN;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_SALOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_SASTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_SIPUSH;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_SWAP;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.JJIT_TABLESWITCH;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special.JJIT_JNI_CALL;

/**
 *
 * @author vpc
 */
public class JJITInstructionFactory {

//    public static final JJIT_JNI_CALL[] NATIVE_METHOD_CODE = new JJIT_JNI_CALL[]{JJIT_JNI_CALL.INSTANCE};
//    public static final int XTRA_JNI = 1000;

    public JJITInstructionDef createInstruction(int index, KInstructionDef def, Object[] constants) {
        int operator = def.operator;
        long[] operands = def.operands;
        switch (operator) {
            ///////////////////////
            // A
            ///////////////////////
            case KOperatorCodes.AALOAD:
                return JJIT_AALOAD.INSTANCE;
            case KOperatorCodes.AASTORE:
                return JJIT_AASTORE.INSTANCE;
            case KOperatorCodes.ACONST_NULL:
                return JJIT_ACONST_NULL.INSTANCE;
            case KOperatorCodes.ALOAD:
                return new JJIT_ALOAD((int) operands[0]);
            case KOperatorCodes.ALOAD_0:
                return JJIT_ALOAD.ALOAD_0;
            case KOperatorCodes.ALOAD_1:
                return JJIT_ALOAD.ALOAD_1;
            case KOperatorCodes.ALOAD_2:
                return JJIT_ALOAD.ALOAD_2;
            case KOperatorCodes.ALOAD_3:
                return JJIT_ALOAD.ALOAD_3;
            case KOperatorCodes.ANEWARRAY:
                return new JJIT_ANEWARRAY(constants, (int) operands[0]);
            case KOperatorCodes.ARETURN:
                return JJIT_ARETURN.INSTANCE;
            case KOperatorCodes.ARRAYLENGTH:
                return JJIT_ARRAYLENGTH.INSTANCE;
            case KOperatorCodes.ASTORE:
                return new JJIT_ASTORE((int) operands[0]);
            case KOperatorCodes.ASTORE_0:
                return JJIT_ASTORE.ASTORE_0;
            case KOperatorCodes.ASTORE_1:
                return JJIT_ASTORE.ASTORE_1;
            case KOperatorCodes.ASTORE_2:
                return JJIT_ASTORE.ASTORE_2;
            case KOperatorCodes.ASTORE_3:
                return JJIT_ASTORE.ASTORE_3;
            case KOperatorCodes.ATHROW:
                return JJIT_ATHROW.INSTANCE;
//
//            ///////////////////////
//            // B
//            ///////////////////////
            case KOperatorCodes.BALOAD:
                return JJIT_BALOAD.INSTANCE;
            case KOperatorCodes.BASTORE:
                return JJIT_BASTORE.INSTANCE;
            case KOperatorCodes.BIPUSH:
                return new JJIT_BIPUSH((byte) operands[0]);
//
//            ///////////////////////
//            // C
//            ///////////////////////
            case KOperatorCodes.CALOAD:
                return JJIT_CALOAD.INSTANCE;
            case KOperatorCodes.CASTORE:
                return JJIT_CASTORE.INSTANCE;
            case KOperatorCodes.CHECKCAST:
                return JJIT_CHECKCAST.INSTANCE;
//
//            ///////////////////////
//            // D
//            ///////////////////////
            case KOperatorCodes.D2F:
                return JJIT_D2F.INSTANCE;
            case KOperatorCodes.D2I:
                return JJIT_D2I.INSTANCE;
            case KOperatorCodes.D2L:
                return JJIT_D2L.INSTANCE;
            case KOperatorCodes.DADD:
                return JJIT_DADD.INSTANCE;
            case KOperatorCodes.DALOAD:
                return JJIT_DALOAD.INSTANCE;
            case KOperatorCodes.DASTORE:
                return JJIT_DASTORE.INSTANCE;
            case KOperatorCodes.DCMPG:
                return JJIT_DCMPG.INSTANCE;
            case KOperatorCodes.DCMPL:
                return JJIT_DCMPL.INSTANCE;
            case KOperatorCodes.DCONST_0:
                return JJIT_DCONST.DCONST_0;
            case KOperatorCodes.DCONST_1:
                return JJIT_DCONST.DCONST_1;
            case KOperatorCodes.DDIV:
                return JJIT_DDIV.INSTANCE;
            case KOperatorCodes.DLOAD:
                return new JJIT_DLOAD((int) operands[0]);
            case KOperatorCodes.DLOAD_0:
                return JJIT_DLOAD.DLOAD_0;
            case KOperatorCodes.DLOAD_1:
                return JJIT_DLOAD.DLOAD_1;
            case KOperatorCodes.DLOAD_2:
                return JJIT_DLOAD.DLOAD_2;
            case KOperatorCodes.DLOAD_3:
                return JJIT_DLOAD.DLOAD_3;
            case KOperatorCodes.DMUL:
                return JJIT_DMUL.INSTANCE;
            case KOperatorCodes.DNEG:
                return JJIT_DNEG.INSTANCE;
            case KOperatorCodes.DREM:
                return JJIT_DREM.INSTANCE;
            case KOperatorCodes.DRETURN:
                return JJIT_DRETURN.INSTANCE;
            case KOperatorCodes.DSTORE:
                return new JJIT_DSTORE((int) operands[0]);
            case KOperatorCodes.DSTORE_0:
                return JJIT_DSTORE.DSTORE_0;
            case KOperatorCodes.DSTORE_1:
                return JJIT_DSTORE.DSTORE_1;
            case KOperatorCodes.DSTORE_2:
                return JJIT_DSTORE.DSTORE_2;
            case KOperatorCodes.DSTORE_3:
                return JJIT_DSTORE.DSTORE_3;
            case KOperatorCodes.DSUB:
                return JJIT_DSUB.INSTANCE;
            case KOperatorCodes.DUP:
                return JJIT_DUP.INSTANCE;
            case KOperatorCodes.DUP2:
                return JJIT_DUP2.INSTANCE;
            case KOperatorCodes.DUP2_X1:
                return JJIT_DUP2_X1.INSTANCE;
            case KOperatorCodes.DUP2_X2:
                return JJIT_DUP2_X2.INSTANCE;
            case KOperatorCodes.DUP_X1:
                return JJIT_DUP_X1.INSTANCE;
            case KOperatorCodes.DUP_X2:
                return JJIT_DUP_X2.INSTANCE;
//
//            ///////////////////////
//            // F
//            ///////////////////////
            case KOperatorCodes.F2D:
                return JJIT_F2D.INSTANCE;
            case KOperatorCodes.F2I:
                return JJIT_F2I.INSTANCE;
            case KOperatorCodes.F2L:
                return JJIT_F2L.INSTANCE;
            case KOperatorCodes.FADD:
                return JJIT_FADD.INSTANCE;
            case KOperatorCodes.FALOAD:
                return JJIT_FALOAD.INSTANCE;
            case KOperatorCodes.FASTORE:
                return JJIT_FASTORE.INSTANCE;
            case KOperatorCodes.FCMPG:
                return JJIT_FCMPG.INSTANCE;
            case KOperatorCodes.FCMPL:
                return JJIT_FCMPL.INSTANCE;
            case KOperatorCodes.FCONST_0:
                return JJIT_FCONST.FCONST_0;
            case KOperatorCodes.FCONST_1:
                return JJIT_FCONST.FCONST_1;
            case KOperatorCodes.FCONST_2:
                return JJIT_FCONST.FCONST_2;
            case KOperatorCodes.FDIV:
                return JJIT_FDIV.INSTANCE;
            case KOperatorCodes.FLOAD:
                return new JJIT_FLOAD((int) operands[0]);
            case KOperatorCodes.FLOAD_0:
                return JJIT_FLOAD.FLOAD_0;
            case KOperatorCodes.FLOAD_1:
                return JJIT_FLOAD.FLOAD_1;
            case KOperatorCodes.FLOAD_2:
                return JJIT_FLOAD.FLOAD_2;
            case KOperatorCodes.FLOAD_3:
                return JJIT_FLOAD.FLOAD_3;
            case KOperatorCodes.FMUL:
                return JJIT_FMUL.INSTANCE;
            case KOperatorCodes.FNEG:
                return JJIT_FNEG.INSTANCE;
            case KOperatorCodes.FREM:
                return JJIT_FREM.INSTANCE;
            case KOperatorCodes.FRETURN:
                return JJIT_FRETURN.INSTANCE;
            case KOperatorCodes.FSTORE:
                return new JJIT_FSTORE((int) operands[0]);
            case KOperatorCodes.FSTORE_0:
                return JJIT_FSTORE.FSTORE_0;
            case KOperatorCodes.FSTORE_1:
                return JJIT_FSTORE.FSTORE_1;
            case KOperatorCodes.FSTORE_2:
                return JJIT_FSTORE.FSTORE_2;
            case KOperatorCodes.FSTORE_3:
                return JJIT_FSTORE.FSTORE_3;
            case KOperatorCodes.FSUB:
                return JJIT_FSUB.INSTANCE;
//
//            ///////////////////////
//            // G
//            ///////////////////////
            case KOperatorCodes.GETFIELD:
                return new JJIT_GETFIELD(constants, (int) operands[0], (int) operands[1], (int) operands[2]);
            case KOperatorCodes.GETSTATIC:
                return new JJIT_GETSTATIC(constants, (int) operands[0], (int) operands[1], (int) operands[2]);
            case KOperatorCodes.GOTO:
                return new JJIT_GOTO((int) operands[0]);
            case KOperatorCodes.GOTO_W:
                return new JJIT_GOTO_W((int) operands[0]);
//
//            ///////////////////////
//            // I
//            ///////////////////////
            case KOperatorCodes.I2B:
                return JJIT_I2B.INSTANCE;
            case KOperatorCodes.I2C:
                return JJIT_I2C.INSTANCE;
            case KOperatorCodes.I2D:
                return JJIT_I2D.INSTANCE;
            case KOperatorCodes.I2F:
                return JJIT_I2F.INSTANCE;
            case KOperatorCodes.I2L:
                return JJIT_I2L.INSTANCE;
            case KOperatorCodes.I2S:
                return JJIT_I2S.INSTANCE;
            case KOperatorCodes.IADD:
                return JJIT_IADD.INSTANCE;
            case KOperatorCodes.IALOAD:
                return JJIT_IALOAD.INSTANCE;
            case KOperatorCodes.IAND:
                return JJIT_IAND.INSTANCE;
            case KOperatorCodes.IASTORE:
                return JJIT_IASTORE.INSTANCE;
            case KOperatorCodes.ICONST_0:
                return JJIT_ICONST.ICONST_0;
            case KOperatorCodes.ICONST_1:
                return JJIT_ICONST.ICONST_1;
            case KOperatorCodes.ICONST_2:
                return JJIT_ICONST.ICONST_2;
            case KOperatorCodes.ICONST_3:
                return JJIT_ICONST.ICONST_3;
            case KOperatorCodes.ICONST_4:
                return JJIT_ICONST.ICONST_4;
            case KOperatorCodes.ICONST_5:
                return JJIT_ICONST.ICONST_5;
            case KOperatorCodes.ICONST_M1:
                return JJIT_ICONST.ICONST_M1;
            case KOperatorCodes.IDIV:
                return JJIT_IDIV.INSTANCE;
            case KOperatorCodes.IF_ACMPEQ:
                return new JJIT_IF_ACMPEQ((int) operands[0]);
            case KOperatorCodes.IF_ACMPNE:
                return new JJIT_IF_ACMPNE((int) operands[0]);
            case KOperatorCodes.IF_ICMPEQ:
                return new JJIT_IF_ICMPEQ((int) operands[0]);
            case KOperatorCodes.IF_ICMPGE:
                return new JJIT_IF_ICMPGE((int) operands[0]);
            case KOperatorCodes.IF_ICMPGT:
                return new JJIT_IF_ICMPGT((int) operands[0]);
            case KOperatorCodes.IF_ICMPLE:
                return new JJIT_IF_ICMPLE((int) operands[0]);
            case KOperatorCodes.IF_ICMPLT:
                return new JJIT_IF_ICMPLT((int) operands[0]);
            case KOperatorCodes.IF_ICMPNE:
                return new JJIT_IF_ICMPNE((int) operands[0]);
            case KOperatorCodes.IFEQ:
                return new JJIT_IFEQ((int) operands[0]);
            case KOperatorCodes.IFGE:
                return new JJIT_IFGE((int) operands[0]);
            case KOperatorCodes.IFGT:
                return new JJIT_IFGT((int) operands[0]);
            case KOperatorCodes.IFLE:
                return new JJIT_IFLE((int) operands[0]);
            case KOperatorCodes.IFLT:
                return new JJIT_IFLT((int) operands[0]);
            case KOperatorCodes.IFNE:
                return new JJIT_IFNE((int) operands[0]);
            case KOperatorCodes.IFNONNULL:
                return new JJIT_IFNONNULL((int) operands[0]);
            case KOperatorCodes.IFNULL:
                return new JJIT_IFNULL((int) operands[0]);
            case KOperatorCodes.IINC:
                return new JJIT_IINC((int) operands[0], (int) operands[1]);
            case KOperatorCodes.ILOAD:
                return new JJIT_ILOAD((int) operands[0]);
            case KOperatorCodes.ILOAD_0:
                return JJIT_ILOAD.ILOAD_0;
            case KOperatorCodes.ILOAD_1:
                return JJIT_ILOAD.ILOAD_1;
            case KOperatorCodes.ILOAD_2:
                return JJIT_ILOAD.ILOAD_2;
            case KOperatorCodes.ILOAD_3:
                return JJIT_ILOAD.ILOAD_3;
            case KOperatorCodes.IMUL:
                return JJIT_IMUL.INSTANCE;
            case KOperatorCodes.INEG:
                return JJIT_INEG.INSTANCE;
            case KOperatorCodes.INSTANCEOF:
                return new JJIT_INSTANCEOF(constants, (int) operands[0]);
            case KOperatorCodes.INVOKEINTERFACE:
                return new JJIT_INVOKEINTERFACE(constants, (int) operands[0], (int) operands[1]);
            case KOperatorCodes.INVOKESPECIAL:
                return new JJIT_INVOKESPECIAL(constants, (int) operands[0], (int) operands[1]);
            case KOperatorCodes.INVOKESTATIC:
                return new JJIT_INVOKESTATIC(constants, (int) operands[0], (int) operands[1]);
            case KOperatorCodes.INVOKEVIRTUAL:
                return new JJIT_INVOKEVIRTUAL(constants, (int) operands[0], (int) operands[1]);
            case KOperatorCodes.IOR:
                return JJIT_IOR.INSTANCE;
            case KOperatorCodes.IREM:
                return JJIT_IREM.INSTANCE;
            case KOperatorCodes.IRETURN:
                return JJIT_IRETURN.INSTANCE;
            case KOperatorCodes.ISHL:
                return JJIT_ISHL.INSTANCE;
            case KOperatorCodes.ISHR:
                return JJIT_ISHR.INSTANCE;
            case KOperatorCodes.ISTORE:
                return new JJIT_ISTORE((int) operands[0]);
            case KOperatorCodes.ISTORE_0:
                return JJIT_ISTORE.ISTORE_0;
            case KOperatorCodes.ISTORE_1:
                return JJIT_ISTORE.ISTORE_1;
            case KOperatorCodes.ISTORE_2:
                return JJIT_ISTORE.ISTORE_2;
            case KOperatorCodes.ISTORE_3:
                return JJIT_ISTORE.ISTORE_3;
            case KOperatorCodes.ISUB:
                return JJIT_ISUB.INSTANCE;
            case KOperatorCodes.IUSHR:
                return JJIT_IUSHR.INSTANCE;
            case KOperatorCodes.IXOR:
                return JJIT_IXOR.INSTANCE;
//
//            ///////////////////////
//            // J
//            ///////////////////////
            case KOperatorCodes.JSR:
                return new JJIT_JSR(index, (int) operands[0]);
            case KOperatorCodes.JSR_W:
                return new JJIT_JSR_W(index, (int) operands[0]);
//
//            ///////////////////////
//            // L
//            ///////////////////////
            case KOperatorCodes.L2D:
                return JJIT_L2D.INSTANCE;
            case KOperatorCodes.L2F:
                return JJIT_L2F.INSTANCE;
            case KOperatorCodes.L2I:
                return JJIT_L2I.INSTANCE;
            case KOperatorCodes.LADD:
                return JJIT_LADD.INSTANCE;
            case KOperatorCodes.LALOAD:
                return JJIT_LALOAD.INSTANCE;
            case KOperatorCodes.LAND:
                return JJIT_LAND.INSTANCE;
            case KOperatorCodes.LASTORE:
                return JJIT_LASTORE.INSTANCE;
            case KOperatorCodes.LCMP:
                return JJIT_LCMP.INSTANCE;
            case KOperatorCodes.LCONST_0:
                return JJIT_LCONST.LCONST_0;
            case KOperatorCodes.LCONST_1:
                return JJIT_LCONST.LCONST_1;
            case KOperatorCodes.LDC:
                return new JJIT_LDC(constants, (int) operands[0]);
            case KOperatorCodes.LDC2_W:
                return new JJIT_LDC2_W(constants, (int) operands[0]);
            case KOperatorCodes.LDC_W:
                return new JJIT_LDC_W(constants, (int) operands[0]);
            case KOperatorCodes.LDIV:
                return JJIT_LDIV.INSTANCE;
            case KOperatorCodes.LLOAD:
                return new JJIT_LLOAD((int) operands[0]);
            case KOperatorCodes.LLOAD_0:
                return JJIT_LLOAD.LLOAD_0;
            case KOperatorCodes.LLOAD_1:
                return JJIT_LLOAD.LLOAD_1;
            case KOperatorCodes.LLOAD_2:
                return JJIT_LLOAD.LLOAD_2;
            case KOperatorCodes.LLOAD_3:
                return JJIT_LLOAD.LLOAD_3;
            case KOperatorCodes.LMUL:
                return JJIT_LMUL.INSTANCE;
            case KOperatorCodes.LNEG:
                return JJIT_LNEG.INSTANCE;
            case KOperatorCodes.LOOKUPSWITCH: {
                int[] o = new int[operands.length];
                for (int i = 0; i < o.length; i++) {
                    o[i] = (int) operands[i];
                }
                return new JJIT_LOOKUPSWITCH(o);
            }
            case KOperatorCodes.LOR:
                return JJIT_LOR.INSTANCE;
            case KOperatorCodes.LREM:
                return JJIT_LREM.INSTANCE;
            case KOperatorCodes.LRETURN:
                return JJIT_LRETURN.INSTANCE;
            case KOperatorCodes.LSHL:
                return JJIT_LSHL.INSTANCE;
            case KOperatorCodes.LSHR:
                return JJIT_LSHR.INSTANCE;
            case KOperatorCodes.LSTORE:
                return new JJIT_LSTORE((int) operands[0]);
            case KOperatorCodes.LSTORE_0:
                return JJIT_LSTORE.LSTORE_0;
            case KOperatorCodes.LSTORE_1:
                return JJIT_LSTORE.LSTORE_1;
            case KOperatorCodes.LSTORE_2:
                return JJIT_LSTORE.LSTORE_2;
            case KOperatorCodes.LSTORE_3:
                return JJIT_LSTORE.LSTORE_3;
            case KOperatorCodes.LSUB:
                return JJIT_LSUB.INSTANCE;
            case KOperatorCodes.LUSHR:
                return JJIT_LUSHR.INSTANCE;
            case KOperatorCodes.LXOR:
                return JJIT_LXOR.INSTANCE;
//            ///////////////////////
//            // M
//            ///////////////////////
            case KOperatorCodes.MONITORENTER:
                return JJIT_MONITORENTER.INSTANCE;
            case KOperatorCodes.MONITOREXIT:
                return JJIT_MONITOREXIT.INSTANCE;
            case KOperatorCodes.MULTIANEWARRAY:
                return new JJIT_MULTIANEWARRAY(constants, (int) operands[0], (int) operands[1]);
            case KOperatorCodes.NOP:
                return JJIT_NOP.INSTANCE;
//
//            ///////////////////////
//            // N
//            ///////////////////////
            case KOperatorCodes.NEW:
                return new JJIT_NEW(constants, ((int) operands[0]));
            case KOperatorCodes.NEWARRAY:
                return JJIT_NEWARRAY.JJIT_NEWARRAYS[((int) operands[0])];
//
//            ///////////////////////
//            // P
//            ///////////////////////
            case KOperatorCodes.POP:
                return JJIT_POP.INSTANCE;
            case KOperatorCodes.POP2:
                return JJIT_POP2.INSTANCE;
            case KOperatorCodes.PUTFIELD:
                return new JJIT_PUTFIELD(constants, (int) operands[0], (int) operands[1], (int) operands[2]);
            case KOperatorCodes.PUTSTATIC:
                return new JJIT_PUTSTATIC(constants, (int) operands[0], (int) operands[1], (int) operands[2]);
//
//            ///////////////////////
//            // R
//            ///////////////////////
            case KOperatorCodes.RET:
                return new JJIT_RET((int) operands[0]);
            case KOperatorCodes.RETURN:
                return JJIT_RETURN.INSTANCE;
//
//            ///////////////////////
//            // S
//            ///////////////////////
            case KOperatorCodes.SALOAD:
                return JJIT_SALOAD.INSTANCE;
            case KOperatorCodes.SASTORE:
                return JJIT_SASTORE.INSTANCE;
            case KOperatorCodes.SIPUSH:
                return new JJIT_SIPUSH((short) operands[0]);
            case KOperatorCodes.SWAP:
                return JJIT_SWAP.INSTANCE;

//            ///////////////////////
//            // T
//            ///////////////////////
            case KOperatorCodes.TABLESWITCH: {
                int[] o = new int[operands.length];
                for (int i = 0; i < o.length; i++) {
                    o[i] = (int) operands[i];
                }
                return new JJIT_TABLESWITCH(o);
            }
//
//
//            ///////////////////////
//            // EXTRA
//            ///////////////////////
//
//            case KOperatorCodes.WIDE:
//                return new JJIT_WIDE();
//
//            ///////////////////////
//            // EXTRA
//            ///////////////////////
//
//            case XTRA_JNI:
//                return JJIT_XTRA_JNI.INSTANCE;
        }
        String name = "?";
        try {
            name = KOperatorCodes.ALL_NAMES[operator];
        } catch (Exception e) {
            //ignore;
        }
        throw new IllegalArgumentException("Unknown operator implementation " + operator + " : " + name);
        //return new KJVMInstructionDefaultImpl(operator, operands);
    }
}
