/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.jvm.interpreter;

import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_AALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_AASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ACONST_NULL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ANEWARRAY;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ARETURN;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ARRAYLENGTH;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ATHROW;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_BALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_BASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_BIPUSH;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_CALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_CASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_CHECKCAST;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_D2F;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_D2I;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_D2L;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DADD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DCMPG;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DCMPL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DCONST;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DDIV;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DLOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DMUL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DNEG;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DREM;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DRETURN;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DSTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DSUB;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DUP;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DUP2;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DUP2_X1;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DUP2_X2;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DUP_X1;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_DUP_X2;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_F2D;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_F2I;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_F2L;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FADD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FCMPG;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FCMPL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FCONST;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FDIV;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FLOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FMUL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FNEG;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FREM;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FRETURN;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FSTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_FSUB;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_GETFIELD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_GETSTATIC;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_GOTO;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_GOTO_W;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_I2B;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_I2C;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_I2D;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_I2F;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_I2L;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_I2S;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IADD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IAND;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ICONST;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IDIV;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFEQ;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFGE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFGT;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFLE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFLT;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFNE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFNONNULL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IFNULL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ACMPEQ;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ACMPNE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ICMPEQ;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ICMPGE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ICMPGT;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ICMPLE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ICMPLT;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IF_ICMPNE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IINC;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ILOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IMUL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_INEG;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_INSTANCEOF;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_INVOKEINTERFACE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_INVOKESPECIAL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_INVOKESTATIC;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_INVOKEVIRTUAL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IOR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IREM;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IRETURN;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ISHL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ISHR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ISTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_ISUB;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IUSHR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_IXOR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_JSR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_JSR_W;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_L2D;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_L2F;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_L2I;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LADD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LAND;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LCMP;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LCONST;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LDC;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LDC2_W;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LDC_W;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LDIV;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LLOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LMUL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LNEG;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LOOKUPSWITCH;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LOR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LREM;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LRETURN;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LSHL;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LSHR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LSTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LSUB;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LUSHR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_LXOR;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_MONITORENTER;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_MONITOREXIT;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_MULTIANEWARRAY;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_NEW;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_NEWARRAY;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_NOP;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_POP;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_POP2;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_PUTFIELD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_PUTSTATIC;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_RET;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_RETURN;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_SALOAD;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_SASTORE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_SIPUSH;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_SWAP;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_TABLESWITCH;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_WIDE;
import org.doovos.kernel.core.jvm.interpreter.instr.KJVM_XTRA_JNI;

/**
 *
 * @author vpc
 */
public class KInstructionIdxFactory {

    static final KJVM_XTRA_JNI[] NATIVE_METHOD_CODE = new KJVM_XTRA_JNI[]{KJVM_XTRA_JNI.INSTANCE};
    public static final int XTRA_JNI = 1000;

    public KInstructionIdx createInstruction(int index, KInstructionDef def) {
        int operator = def.operator;
        long[] operands = def.operands;
        switch (operator) {
            ///////////////////////
            // A
            ///////////////////////
            case KOperatorCodes.AALOAD:
                return new KJVM_AALOAD();
            case KOperatorCodes.AASTORE:
                return new KJVM_AASTORE();
            case KOperatorCodes.ACONST_NULL:
                return KJVM_ACONST_NULL.INSTANCE;
            case KOperatorCodes.ALOAD:
                return new KJVM_ALOAD(operands);
            case KOperatorCodes.ALOAD_0:
                return KJVM_ALOAD.ALOAD_0;
            case KOperatorCodes.ALOAD_1:
                return KJVM_ALOAD.ALOAD_1;
            case KOperatorCodes.ALOAD_2:
                return KJVM_ALOAD.ALOAD_2;
            case KOperatorCodes.ALOAD_3:
                return KJVM_ALOAD.ALOAD_3;
            case KOperatorCodes.ANEWARRAY:
                return new KJVM_ANEWARRAY(operands);
            case KOperatorCodes.ARETURN:
                return KJVM_ARETURN.INSTANCE;
            case KOperatorCodes.ARRAYLENGTH:
                return KJVM_ARRAYLENGTH.INSTANCE;
            case KOperatorCodes.ASTORE:
                return new KJVM_ASTORE(operands);
            case KOperatorCodes.ASTORE_0:
                return KJVM_ASTORE.DSTORE_0;
            case KOperatorCodes.ASTORE_1:
                return KJVM_ASTORE.DSTORE_1;
            case KOperatorCodes.ASTORE_2:
                return KJVM_ASTORE.DSTORE_2;
            case KOperatorCodes.ASTORE_3:
                return KJVM_ASTORE.DSTORE_3;
            case KOperatorCodes.ATHROW:
                return KJVM_ATHROW.INSTANCE;

            ///////////////////////
            // B
            ///////////////////////
            case KOperatorCodes.BALOAD:
                return KJVM_BALOAD.INSTANCE;
            case KOperatorCodes.BASTORE:
                return KJVM_BASTORE.INSTANCE;
            case KOperatorCodes.BIPUSH:
                return new KJVM_BIPUSH(operands);

            ///////////////////////
            // C
            ///////////////////////
            case KOperatorCodes.CALOAD:
                return KJVM_CALOAD.INSTANCE;
            case KOperatorCodes.CASTORE:
                return KJVM_CASTORE.INSTANCE;
            case KOperatorCodes.CHECKCAST:
                return KJVM_CHECKCAST.INSTANCE;
//            case KOperatorCodes.CRETURN:
//                return KJVM_CRETURN.INSTANCE;

            ///////////////////////
            // D
            ///////////////////////
            case KOperatorCodes.D2F:
                return KJVM_D2F.INSTANCE;
            case KOperatorCodes.D2I:
                return KJVM_D2I.INSTANCE;
            case KOperatorCodes.D2L:
                return KJVM_D2L.INSTANCE;
            case KOperatorCodes.DADD:
                return KJVM_DADD.INSTANCE;
            case KOperatorCodes.DALOAD:
                return KJVM_DALOAD.INSTANCE;
            case KOperatorCodes.DASTORE:
                return KJVM_DASTORE.INSTANCE;
            case KOperatorCodes.DCMPG:
                return KJVM_DCMPG.INSTANCE;
            case KOperatorCodes.DCMPL:
                return KJVM_DCMPL.INSTANCE;
            case KOperatorCodes.DCONST_0:
                return KJVM_DCONST.DCONST_0;
            case KOperatorCodes.DCONST_1:
                return KJVM_DCONST.DCONST_1;
            case KOperatorCodes.DDIV:
                return KJVM_DDIV.INSTANCE;
            case KOperatorCodes.DLOAD:
                return new KJVM_DLOAD(operands);
            case KOperatorCodes.DLOAD_0:
                return KJVM_DLOAD.DLOAD_0;
            case KOperatorCodes.DLOAD_1:
                return KJVM_DLOAD.DLOAD_1;
            case KOperatorCodes.DLOAD_2:
                return KJVM_DLOAD.DLOAD_2;
            case KOperatorCodes.DLOAD_3:
                return KJVM_DLOAD.DLOAD_3;
            case KOperatorCodes.DMUL:
                return KJVM_DMUL.INSTANCE;
            case KOperatorCodes.DNEG:
                return KJVM_DNEG.INSTANCE;
            case KOperatorCodes.DREM:
                return KJVM_DREM.INSTANCE;
            case KOperatorCodes.DRETURN:
                return KJVM_DRETURN.INSTANCE;
            case KOperatorCodes.DSTORE:
                return new KJVM_DSTORE(operands);
            case KOperatorCodes.DSTORE_0:
                return KJVM_DSTORE.DSTORE_0;
            case KOperatorCodes.DSTORE_1:
                return KJVM_DSTORE.DSTORE_1;
            case KOperatorCodes.DSTORE_2:
                return KJVM_DSTORE.DSTORE_2;
            case KOperatorCodes.DSTORE_3:
                return KJVM_DSTORE.DSTORE_3;
            case KOperatorCodes.DSUB:
                return KJVM_DSUB.INSTANCE;
            case KOperatorCodes.DUP:
                return KJVM_DUP.INSTANCE;
            case KOperatorCodes.DUP2:
                return KJVM_DUP2.INSTANCE;
            case KOperatorCodes.DUP2_X1:
                return KJVM_DUP2_X1.INSTANCE;
            case KOperatorCodes.DUP2_X2:
                return KJVM_DUP2_X2.INSTANCE;
            case KOperatorCodes.DUP_X1:
                return KJVM_DUP_X1.INSTANCE;
            case KOperatorCodes.DUP_X2:
                return KJVM_DUP_X2.INSTANCE;

            ///////////////////////
            // F
            ///////////////////////
            case KOperatorCodes.F2D:
                return KJVM_F2D.INSTANCE;
            case KOperatorCodes.F2I:
                return KJVM_F2I.INSTANCE;
            case KOperatorCodes.F2L:
                return KJVM_F2L.INSTANCE;
            case KOperatorCodes.FADD:
                return KJVM_FADD.INSTANCE;
            case KOperatorCodes.FALOAD:
                return KJVM_FALOAD.INSTANCE;
            case KOperatorCodes.FASTORE:
                return KJVM_FASTORE.INSTANCE;
            case KOperatorCodes.FCMPG:
                return KJVM_FCMPG.INSTANCE;
            case KOperatorCodes.FCMPL:
                return KJVM_FCMPL.INSTANCE;
            case KOperatorCodes.FCONST_0:
                return KJVM_FCONST.FCONST_0;
            case KOperatorCodes.FCONST_1:
                return KJVM_FCONST.FCONST_1;
            case KOperatorCodes.FCONST_2:
                return KJVM_FCONST.FCONST_2;
            case KOperatorCodes.FDIV:
                return KJVM_FDIV.INSTANCE;
            case KOperatorCodes.FLOAD:
                return new KJVM_FLOAD(operands);
            case KOperatorCodes.FLOAD_0:
                return KJVM_FLOAD.FLOAD_0;
            case KOperatorCodes.FLOAD_1:
                return KJVM_FLOAD.FLOAD_1;
            case KOperatorCodes.FLOAD_2:
                return KJVM_FLOAD.FLOAD_2;
            case KOperatorCodes.FLOAD_3:
                return KJVM_FLOAD.FLOAD_3;
            case KOperatorCodes.FMUL:
                return KJVM_FMUL.INSTANCE;
            case KOperatorCodes.FNEG:
                return KJVM_FNEG.INSTANCE;
            case KOperatorCodes.FREM:
                return KJVM_FREM.INSTANCE;
            case KOperatorCodes.FRETURN:
                return KJVM_FRETURN.INSTANCE;
            case KOperatorCodes.FSTORE:
                return new KJVM_FSTORE(operands);
            case KOperatorCodes.FSTORE_0:
                return KJVM_FSTORE.FSTORE_0;
            case KOperatorCodes.FSTORE_1:
                return KJVM_FSTORE.FSTORE_1;
            case KOperatorCodes.FSTORE_2:
                return KJVM_FSTORE.FSTORE_2;
            case KOperatorCodes.FSTORE_3:
                return KJVM_FSTORE.FSTORE_3;
            case KOperatorCodes.FSUB:
                return KJVM_FSUB.INSTANCE;

            ///////////////////////
            // G
            ///////////////////////
            case KOperatorCodes.GETFIELD:
                return new KJVM_GETFIELD(operands);
            case KOperatorCodes.GETSTATIC:
                return new KJVM_GETSTATIC(operands);
            case KOperatorCodes.GOTO:
                return new KJVM_GOTO(operands);
            case KOperatorCodes.GOTO_W:
                return new KJVM_GOTO_W(operands);

            ///////////////////////
            // I
            ///////////////////////
            case KOperatorCodes.I2B:
                return KJVM_I2B.INSTANCE;
            case KOperatorCodes.I2C:
                return KJVM_I2C.INSTANCE;
            case KOperatorCodes.I2D:
                return KJVM_I2D.INSTANCE;
            case KOperatorCodes.I2F:
                return KJVM_I2F.INSTANCE;
            case KOperatorCodes.I2L:
                return KJVM_I2L.INSTANCE;
            case KOperatorCodes.I2S:
                return KJVM_I2S.INSTANCE;
            case KOperatorCodes.IADD:
                return KJVM_IADD.INSTANCE;
            case KOperatorCodes.IALOAD:
                return KJVM_IALOAD.INSTANCE;
            case KOperatorCodes.IAND:
                return KJVM_IAND.INSTANCE;
            case KOperatorCodes.IASTORE:
                return KJVM_IASTORE.INSTANCE;
            case KOperatorCodes.ICONST_0:
                return KJVM_ICONST.ICONST_0;
            case KOperatorCodes.ICONST_1:
                return KJVM_ICONST.ICONST_1;
            case KOperatorCodes.ICONST_2:
                return KJVM_ICONST.ICONST_2;
            case KOperatorCodes.ICONST_3:
                return KJVM_ICONST.ICONST_3;
            case KOperatorCodes.ICONST_4:
                return KJVM_ICONST.ICONST_4;
            case KOperatorCodes.ICONST_5:
                return KJVM_ICONST.ICONST_5;
            case KOperatorCodes.ICONST_M1:
                return KJVM_ICONST.ICONST_M1;
            case KOperatorCodes.IDIV:
                return KJVM_IDIV.INSTANCE;
            case KOperatorCodes.IF_ACMPEQ:
                return new KJVM_IF_ACMPEQ(operands);
            case KOperatorCodes.IF_ACMPNE:
                return new KJVM_IF_ACMPNE(operands);
            case KOperatorCodes.IF_ICMPEQ:
                return new KJVM_IF_ICMPEQ(operands);
            case KOperatorCodes.IF_ICMPGE:
                return new KJVM_IF_ICMPGE(operands);
            case KOperatorCodes.IF_ICMPGT:
                return new KJVM_IF_ICMPGT(operands);
            case KOperatorCodes.IF_ICMPLE:
                return new KJVM_IF_ICMPLE(operands);
            case KOperatorCodes.IF_ICMPLT:
                return new KJVM_IF_ICMPLT(operands);
            case KOperatorCodes.IF_ICMPNE:
                return new KJVM_IF_ICMPNE(operands);
            case KOperatorCodes.IFEQ:
                return new KJVM_IFEQ(operands);
            case KOperatorCodes.IFGE:
                return new KJVM_IFGE(operands);
            case KOperatorCodes.IFGT:
                return new KJVM_IFGT(operands);
            case KOperatorCodes.IFLE:
                return new KJVM_IFLE(operands);
            case KOperatorCodes.IFLT:
                return new KJVM_IFLT(operands);
            case KOperatorCodes.IFNE:
                return new KJVM_IFNE(operands);
            case KOperatorCodes.IFNONNULL:
                return new KJVM_IFNONNULL(operands);
            case KOperatorCodes.IFNULL:
                return new KJVM_IFNULL(operands);
            case KOperatorCodes.IINC:
                return new KJVM_IINC(operands);
            case KOperatorCodes.ILOAD:
                return new KJVM_ILOAD(operands);
            case KOperatorCodes.ILOAD_0:
                return KJVM_ILOAD.ILOAD_0;
            case KOperatorCodes.ILOAD_1:
                return KJVM_ILOAD.ILOAD_1;
            case KOperatorCodes.ILOAD_2:
                return KJVM_ILOAD.ILOAD_2;
            case KOperatorCodes.ILOAD_3:
                return KJVM_ILOAD.ILOAD_3;
            case KOperatorCodes.IMUL:
                return KJVM_IMUL.INSTANCE;
            case KOperatorCodes.INEG:
                return KJVM_INEG.INSTANCE;
            case KOperatorCodes.INSTANCEOF:
                return new KJVM_INSTANCEOF(operands);
            case KOperatorCodes.INVOKEINTERFACE:
                return new KJVM_INVOKEINTERFACE(operands);
            case KOperatorCodes.INVOKESPECIAL:
                return new KJVM_INVOKESPECIAL(operands);
            case KOperatorCodes.INVOKESTATIC:
                return new KJVM_INVOKESTATIC(operands);
            case KOperatorCodes.INVOKEVIRTUAL:
                return new KJVM_INVOKEVIRTUAL(operands);
            case KOperatorCodes.IOR:
                return KJVM_IOR.INSTANCE;
//            case KOperatorCodes.IPUSH:
//                return new KJVM_IPUSH(operands);
            case KOperatorCodes.IREM:
                return KJVM_IREM.INSTANCE;
            case KOperatorCodes.IRETURN:
                return KJVM_IRETURN.INSTANCE;
            case KOperatorCodes.ISHL:
                return KJVM_ISHL.INSTANCE;
            case KOperatorCodes.ISHR:
                return KJVM_ISHR.INSTANCE;
            case KOperatorCodes.ISTORE:
                return new KJVM_ISTORE(operands);
            case KOperatorCodes.ISTORE_0:
                return KJVM_ISTORE.ISTORE_0;
            case KOperatorCodes.ISTORE_1:
                return KJVM_ISTORE.ISTORE_1;
            case KOperatorCodes.ISTORE_2:
                return KJVM_ISTORE.ISTORE_2;
            case KOperatorCodes.ISTORE_3:
                return KJVM_ISTORE.ISTORE_3;
            case KOperatorCodes.ISUB:
                return KJVM_ISUB.INSTANCE;
            case KOperatorCodes.IUSHR:
                return KJVM_IUSHR.INSTANCE;
            case KOperatorCodes.IXOR:
                return KJVM_IXOR.INSTANCE;

            ///////////////////////
            // J
            ///////////////////////
            case KOperatorCodes.JSR:
                return new KJVM_JSR(index, operands);
            case KOperatorCodes.JSR_W:
                return new KJVM_JSR_W(index, operands);

            ///////////////////////
            // L
            ///////////////////////
            case KOperatorCodes.L2D:
                return KJVM_L2D.INSTANCE;
            case KOperatorCodes.L2F:
                return KJVM_L2F.INSTANCE;
            case KOperatorCodes.L2I:
                return KJVM_L2I.INSTANCE;
            case KOperatorCodes.LADD:
                return KJVM_LADD.INSTANCE;
            case KOperatorCodes.LALOAD:
                return KJVM_LALOAD.INSTANCE;
            case KOperatorCodes.LAND:
                return KJVM_LAND.INSTANCE;
            case KOperatorCodes.LASTORE:
                return KJVM_LASTORE.INSTANCE;
            case KOperatorCodes.LCMP:
                return KJVM_LCMP.INSTANCE;
            case KOperatorCodes.LCONST_0:
                return KJVM_LCONST.LCONST_0;
            case KOperatorCodes.LCONST_1:
                return KJVM_LCONST.LCONST_1;
            case KOperatorCodes.LDC:
                return new KJVM_LDC(operands);
            case KOperatorCodes.LDC2_W:
                return new KJVM_LDC2_W(operands);
            case KOperatorCodes.LDC_W:
                return new KJVM_LDC_W(operands);
            case KOperatorCodes.LDIV:
                return KJVM_LDIV.INSTANCE;
            case KOperatorCodes.LLOAD:
                return new KJVM_LLOAD(operands);
            case KOperatorCodes.LLOAD_0:
                return KJVM_LLOAD.LLOAD_0;
            case KOperatorCodes.LLOAD_1:
                return KJVM_LLOAD.LLOAD_1;
            case KOperatorCodes.LLOAD_2:
                return KJVM_LLOAD.LLOAD_2;
            case KOperatorCodes.LLOAD_3:
                return KJVM_LLOAD.LLOAD_3;
            case KOperatorCodes.LMUL:
                return KJVM_LMUL.INSTANCE;
            case KOperatorCodes.LNEG:
                return KJVM_LNEG.INSTANCE;
            case KOperatorCodes.LOOKUPSWITCH:
                return new KJVM_LOOKUPSWITCH(operands);
            case KOperatorCodes.LOR:
                return KJVM_LOR.INSTANCE;
            case KOperatorCodes.LREM:
                return KJVM_LREM.INSTANCE;
            case KOperatorCodes.LRETURN:
                return KJVM_LRETURN.INSTANCE;
            case KOperatorCodes.LSHL:
                return KJVM_LSHL.INSTANCE;
            case KOperatorCodes.LSHR:
                return KJVM_LSHR.INSTANCE;
            case KOperatorCodes.LSTORE:
                return new KJVM_LSTORE(operands);
            case KOperatorCodes.LSTORE_0:
                return KJVM_LSTORE.LSTORE_0;
            case KOperatorCodes.LSTORE_1:
                return KJVM_LSTORE.LSTORE_1;
            case KOperatorCodes.LSTORE_2:
                return KJVM_LSTORE.LSTORE_2;
            case KOperatorCodes.LSTORE_3:
                return KJVM_LSTORE.LSTORE_3;
            case KOperatorCodes.LSUB:
                return KJVM_LSUB.INSTANCE;
            case KOperatorCodes.LUSHR:
                return KJVM_LUSHR.INSTANCE;
            case KOperatorCodes.LXOR:
                return KJVM_LXOR.INSTANCE;
            case KOperatorCodes.MONITORENTER:
                return KJVM_MONITORENTER.INSTANCE;
            case KOperatorCodes.MONITOREXIT:
                return KJVM_MONITOREXIT.INSTANCE;
            case KOperatorCodes.MULTIANEWARRAY:
                return new KJVM_MULTIANEWARRAY(operands);
            case KOperatorCodes.NOP:
                return KJVM_NOP.INSTANCE;

            ///////////////////////
            // N
            ///////////////////////
            case KOperatorCodes.NEW:
                return new KJVM_NEW(operands);
            case KOperatorCodes.NEWARRAY:
                return KJVM_NEWARRAY.createInstance(operands);

            ///////////////////////
            // P
            ///////////////////////
            case KOperatorCodes.POP:
                return KJVM_POP.INSTANCE;
            case KOperatorCodes.POP2:
                return KJVM_POP2.INSTANCE;
            case KOperatorCodes.PUTFIELD:
                return new KJVM_PUTFIELD(operands);
            case KOperatorCodes.PUTSTATIC:
                return new KJVM_PUTSTATIC(operands);

            ///////////////////////
            // R
            ///////////////////////
            case KOperatorCodes.RET:
                return new KJVM_RET(operands);
            case KOperatorCodes.RETURN:
                return KJVM_RETURN.INSTANCE;

            ///////////////////////
            // S
            ///////////////////////
            case KOperatorCodes.SALOAD:
                return KJVM_SALOAD.INSTANCE;
            case KOperatorCodes.SASTORE:
                return KJVM_SASTORE.INSTANCE;
            case KOperatorCodes.SIPUSH:
                return new KJVM_SIPUSH(operands);
//            case KOperatorCodes.SRETURN:
//                return KJVM_SRETURN.INSTANCE;
            case KOperatorCodes.SWAP:
                return KJVM_SWAP.INSTANCE;
            case KOperatorCodes.TABLESWITCH:
                return new KJVM_TABLESWITCH(operands);


            ///////////////////////
            // EXTRA
            ///////////////////////

            case KOperatorCodes.WIDE:
                return new KJVM_WIDE();

            ///////////////////////
            // EXTRA
            ///////////////////////

            case XTRA_JNI:
                return KJVM_XTRA_JNI.INSTANCE;
        }
        throw new IllegalArgumentException("Unknown operator implementation " + operator);
        //return new KJVMInstructionDefaultImpl(operator, operands);
    }
}
