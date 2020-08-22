
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vpc
 */
public class Toto {

    public static void main(String[] args) {
        int times = 100000;
        //int max=100000;
        System.out.println("int :"+opInts(times));
        System.out.println("enum :"+opEnum(times));
    }

    public static long opInts(int times) {
        int[] all = new int[KOperator.values().length];
        int ii = 0;
        for (KOperator o : KOperator.values()) {
            try {
                all[ii] = KOperatorCodes.class.getDeclaredField(o.name()).getInt(null);
            } catch (Exception ex) {
                System.out.println(">> unknow "+o.name());
                all[ii] = -1;
            }
            ii++;
        }
        long start = System.currentTimeMillis();
        for (int t = 0; t < times; t++) {
            for (int i = 0; i < 202; i++) {
                int v = all[i];
                switch (v) {
                    ///////////////////////
                    // A
                    ///////////////////////
                    case KOperatorCodes.AALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.AASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ACONST_NULL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ALOAD_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ALOAD_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ALOAD_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ALOAD_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ANEWARRAY:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ARETURN:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ARRAYLENGTH:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ASTORE_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ASTORE_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ASTORE_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ASTORE_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ATHROW:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // B
                    ///////////////////////
                    case KOperatorCodes.BALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.BASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.BIPUSH:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // C
                    ///////////////////////
                    case KOperatorCodes.CALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.CASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.CHECKCAST:
                        System.out.print("");
                        break;
//                case KOperatorCodes.CRETURN:
//                    System.out.print("");
//                    break;

                    ///////////////////////
                    // D
                    ///////////////////////
                    case KOperatorCodes.D2F:
                        System.out.print("");
                        break;
                    case KOperatorCodes.D2I:
                        System.out.print("");
                        break;
                    case KOperatorCodes.D2L:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DADD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DCMPG:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DCMPL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DCONST_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DCONST_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DDIV:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DLOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DLOAD_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DLOAD_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DLOAD_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DLOAD_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DMUL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DNEG:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DREM:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DRETURN:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DSTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DSTORE_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DSTORE_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DSTORE_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DSTORE_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DSUB:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DUP:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DUP2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DUP2_X1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DUP2_X2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DUP_X1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.DUP_X2:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // F
                    ///////////////////////
                    case KOperatorCodes.F2D:
                        System.out.print("");
                        break;
                    case KOperatorCodes.F2I:
                        System.out.print("");
                        break;
                    case KOperatorCodes.F2L:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FADD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FCMPG:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FCMPL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FCONST_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FCONST_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FCONST_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FDIV:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FLOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FLOAD_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FLOAD_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FLOAD_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FLOAD_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FMUL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FNEG:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FREM:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FRETURN:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FSTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FSTORE_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FSTORE_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FSTORE_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FSTORE_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.FSUB:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // G
                    ///////////////////////
                    case KOperatorCodes.GETFIELD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.GETSTATIC:
                        System.out.print("");
                        break;
                    case KOperatorCodes.GOTO:
                        System.out.print("");
                        break;
                    case KOperatorCodes.GOTO_W:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // I
                    ///////////////////////
                    case KOperatorCodes.I2B:
                        System.out.print("");
                        break;
                    case KOperatorCodes.I2C:
                        System.out.print("");
                        break;
                    case KOperatorCodes.I2D:
                        System.out.print("");
                        break;
                    case KOperatorCodes.I2F:
                        System.out.print("");
                        break;
                    case KOperatorCodes.I2L:
                        System.out.print("");
                        break;
                    case KOperatorCodes.I2S:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IADD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IAND:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ICONST_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ICONST_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ICONST_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ICONST_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ICONST_4:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ICONST_5:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ICONST_M1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IDIV:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ACMPEQ:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ACMPNE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ICMPEQ:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ICMPGE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ICMPGT:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ICMPLE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ICMPLT:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IF_ICMPNE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFEQ:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFGE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFGT:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFLE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFLT:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFNE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFNONNULL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IFNULL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IINC:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ILOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ILOAD_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ILOAD_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ILOAD_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ILOAD_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IMUL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.INEG:
                        System.out.print("");
                        break;
                    case KOperatorCodes.INSTANCEOF:
                        System.out.print("");
                        break;
                    case KOperatorCodes.INVOKEINTERFACE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.INVOKESPECIAL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.INVOKESTATIC:
                        System.out.print("");
                        break;
                    case KOperatorCodes.INVOKEVIRTUAL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IOR:
                        System.out.print("");
                        break;
//                case KOperatorCodes.IPUSH:
//                    System.out.print("");
//                    break;
                    case KOperatorCodes.IREM:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IRETURN:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISHL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISHR:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISTORE_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISTORE_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISTORE_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISTORE_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.ISUB:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IUSHR:
                        System.out.print("");
                        break;
                    case KOperatorCodes.IXOR:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // J
                    ///////////////////////
                    case KOperatorCodes.JSR:
                        System.out.print("");
                        break;
                    case KOperatorCodes.JSR_W:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // L
                    ///////////////////////
                    case KOperatorCodes.L2D:
                        System.out.print("");
                        break;
                    case KOperatorCodes.L2F:
                        System.out.print("");
                        break;
                    case KOperatorCodes.L2I:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LADD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LAND:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LCMP:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LCONST_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LCONST_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LDC:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LDC2_W:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LDC_W:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LDIV:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LLOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LLOAD_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LLOAD_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LLOAD_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LLOAD_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LMUL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LNEG:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LOOKUPSWITCH:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LOR:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LREM:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LRETURN:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSHL:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSHR:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSTORE_0:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSTORE_1:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSTORE_2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSTORE_3:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LSUB:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LUSHR:
                        System.out.print("");
                        break;
                    case KOperatorCodes.LXOR:
                        System.out.print("");
                        break;
                    case KOperatorCodes.MONITORENTER:
                        System.out.print("");
                        break;
                    case KOperatorCodes.MONITOREXIT:
                        System.out.print("");
                        break;
                    case KOperatorCodes.MULTIANEWARRAY:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // N
                    ///////////////////////
                    case KOperatorCodes.NEW:
                        System.out.print("");
                        break;
                    case KOperatorCodes.NEWARRAY:
                        System.out.print("");
                        break;
                    case KOperatorCodes.NOP:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // P
                    ///////////////////////
                    case KOperatorCodes.POP:
                        System.out.print("");
                        break;
                    case KOperatorCodes.POP2:
                        System.out.print("");
                        break;
                    case KOperatorCodes.PUTFIELD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.PUTSTATIC:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // R
                    ///////////////////////
                    case KOperatorCodes.RET:
                        System.out.print("");
                        break;
                    case KOperatorCodes.RETURN:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // S
                    ///////////////////////
                    case KOperatorCodes.SALOAD:
                        System.out.print("");
                        break;
                    case KOperatorCodes.SASTORE:
                        System.out.print("");
                        break;
                    case KOperatorCodes.SIPUSH:
                        System.out.print("");
                        break;
//                case KOperatorCodes.SRETURN:
//                    System.out.print("");
//                    break;
                    case KOperatorCodes.SWAP:
                        System.out.print("");
                        break;
                    case KOperatorCodes.TABLESWITCH:
                        System.out.print("");
                        break;

                    case KOperatorCodes.UNUSED:
                        System.out.print("");
                        break;

                    default: {
                        System.out.print("");
//                        System.out.println("do nothing for " + v);
                    }
                    ///////////////////////
                    // EXTRA
                    ///////////////////////
//                case KOperatorCodes.XTRA_JNI:
//                    System.out.print("");
//                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long opEnum(int times) {
        KOperator[] values = KOperator.values();
        int max = values.length;
        long start = System.currentTimeMillis();
        for (int t = 0; t < times; t++) {
            for (int i = 0; i < max; i++) {
                KOperator v = values[i];
                switch (v) {
                    ///////////////////////
                    // A
                    ///////////////////////
                    case AALOAD:
                        System.out.print("");
                        break;
                    case AASTORE:
                        System.out.print("");
                        break;
                    case ACONST_NULL:
                        System.out.print("");
                        break;
                    case ALOAD:
                        System.out.print("");
                        break;
                    case ALOAD_0:
                        System.out.print("");
                        break;
                    case ALOAD_1:
                        System.out.print("");
                        break;
                    case ALOAD_2:
                        System.out.print("");
                        break;
                    case ALOAD_3:
                        System.out.print("");
                        break;
                    case ANEWARRAY:
                        System.out.print("");
                        break;
                    case ARETURN:
                        System.out.print("");
                        break;
                    case ARRAYLENGTH:
                        System.out.print("");
                        break;
                    case ASTORE:
                        System.out.print("");
                        break;
                    case ASTORE_0:
                        System.out.print("");
                        break;
                    case ASTORE_1:
                        System.out.print("");
                        break;
                    case ASTORE_2:
                        System.out.print("");
                        break;
                    case ASTORE_3:
                        System.out.print("");
                        break;
                    case ATHROW:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // B
                    ///////////////////////
                    case BALOAD:
                        System.out.print("");
                        break;
                    case BASTORE:
                        System.out.print("");
                        break;
                    case BIPUSH:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // C
                    ///////////////////////
                    case CALOAD:
                        System.out.print("");
                        break;
                    case CASTORE:
                        System.out.print("");
                        break;
                    case CHECKCAST:
                        System.out.print("");
                        break;
//                case CRETURN:
//                    System.out.print("");
//                    break;

                    ///////////////////////
                    // D
                    ///////////////////////
                    case D2F:
                        System.out.print("");
                        break;
                    case D2I:
                        System.out.print("");
                        break;
                    case D2L:
                        System.out.print("");
                        break;
                    case DADD:
                        System.out.print("");
                        break;
                    case DALOAD:
                        System.out.print("");
                        break;
                    case DASTORE:
                        System.out.print("");
                        break;
                    case DCMPG:
                        System.out.print("");
                        break;
                    case DCMPL:
                        System.out.print("");
                        break;
                    case DCONST_0:
                        System.out.print("");
                        break;
                    case DCONST_1:
                        System.out.print("");
                        break;
                    case DDIV:
                        System.out.print("");
                        break;
                    case DLOAD:
                        System.out.print("");
                        break;
                    case DLOAD_0:
                        System.out.print("");
                        break;
                    case DLOAD_1:
                        System.out.print("");
                        break;
                    case DLOAD_2:
                        System.out.print("");
                        break;
                    case DLOAD_3:
                        System.out.print("");
                        break;
                    case DMUL:
                        System.out.print("");
                        break;
                    case DNEG:
                        System.out.print("");
                        break;
                    case DREM:
                        System.out.print("");
                        break;
                    case DRETURN:
                        System.out.print("");
                        break;
                    case DSTORE:
                        System.out.print("");
                        break;
                    case DSTORE_0:
                        System.out.print("");
                        break;
                    case DSTORE_1:
                        System.out.print("");
                        break;
                    case DSTORE_2:
                        System.out.print("");
                        break;
                    case DSTORE_3:
                        System.out.print("");
                        break;
                    case DSUB:
                        System.out.print("");
                        break;
                    case DUP:
                        System.out.print("");
                        break;
                    case DUP2:
                        System.out.print("");
                        break;
                    case DUP2_X1:
                        System.out.print("");
                        break;
                    case DUP2_X2:
                        System.out.print("");
                        break;
                    case DUP_X1:
                        System.out.print("");
                        break;
                    case DUP_X2:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // F
                    ///////////////////////
                    case F2D:
                        System.out.print("");
                        break;
                    case F2I:
                        System.out.print("");
                        break;
                    case F2L:
                        System.out.print("");
                        break;
                    case FADD:
                        System.out.print("");
                        break;
                    case FALOAD:
                        System.out.print("");
                        break;
                    case FASTORE:
                        System.out.print("");
                        break;
                    case FCMPG:
                        System.out.print("");
                        break;
                    case FCMPL:
                        System.out.print("");
                        break;
                    case FCONST_0:
                        System.out.print("");
                        break;
                    case FCONST_1:
                        System.out.print("");
                        break;
                    case FCONST_2:
                        System.out.print("");
                        break;
                    case FDIV:
                        System.out.print("");
                        break;
                    case FLOAD:
                        System.out.print("");
                        break;
                    case FLOAD_0:
                        System.out.print("");
                        break;
                    case FLOAD_1:
                        System.out.print("");
                        break;
                    case FLOAD_2:
                        System.out.print("");
                        break;
                    case FLOAD_3:
                        System.out.print("");
                        break;
                    case FMUL:
                        System.out.print("");
                        break;
                    case FNEG:
                        System.out.print("");
                        break;
                    case FREM:
                        System.out.print("");
                        break;
                    case FRETURN:
                        System.out.print("");
                        break;
                    case FSTORE:
                        System.out.print("");
                        break;
                    case FSTORE_0:
                        System.out.print("");
                        break;
                    case FSTORE_1:
                        System.out.print("");
                        break;
                    case FSTORE_2:
                        System.out.print("");
                        break;
                    case FSTORE_3:
                        System.out.print("");
                        break;
                    case FSUB:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // G
                    ///////////////////////
                    case GETFIELD:
                        System.out.print("");
                        break;
                    case GETSTATIC:
                        System.out.print("");
                        break;
                    case GOTO:
                        System.out.print("");
                        break;
                    case GOTO_W:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // I
                    ///////////////////////
                    case I2B:
                        System.out.print("");
                        break;
                    case I2C:
                        System.out.print("");
                        break;
                    case I2D:
                        System.out.print("");
                        break;
                    case I2F:
                        System.out.print("");
                        break;
                    case I2L:
                        System.out.print("");
                        break;
                    case I2S:
                        System.out.print("");
                        break;
                    case IADD:
                        System.out.print("");
                        break;
                    case IALOAD:
                        System.out.print("");
                        break;
                    case IAND:
                        System.out.print("");
                        break;
                    case IASTORE:
                        System.out.print("");
                        break;
                    case ICONST_0:
                        System.out.print("");
                        break;
                    case ICONST_1:
                        System.out.print("");
                        break;
                    case ICONST_2:
                        System.out.print("");
                        break;
                    case ICONST_3:
                        System.out.print("");
                        break;
                    case ICONST_4:
                        System.out.print("");
                        break;
                    case ICONST_5:
                        System.out.print("");
                        break;
                    case ICONST_M1:
                        System.out.print("");
                        break;
                    case IDIV:
                        System.out.print("");
                        break;
                    case IF_ACMPEQ:
                        System.out.print("");
                        break;
                    case IF_ACMPNE:
                        System.out.print("");
                        break;
                    case IF_ICMPEQ:
                        System.out.print("");
                        break;
                    case IF_ICMPGE:
                        System.out.print("");
                        break;
                    case IF_ICMPGT:
                        System.out.print("");
                        break;
                    case IF_ICMPLE:
                        System.out.print("");
                        break;
                    case IF_ICMPLT:
                        System.out.print("");
                        break;
                    case IF_ICMPNE:
                        System.out.print("");
                        break;
                    case IFEQ:
                        System.out.print("");
                        break;
                    case IFGE:
                        System.out.print("");
                        break;
                    case IFGT:
                        System.out.print("");
                        break;
                    case IFLE:
                        System.out.print("");
                        break;
                    case IFLT:
                        System.out.print("");
                        break;
                    case IFNE:
                        System.out.print("");
                        break;
                    case IFNONNULL:
                        System.out.print("");
                        break;
                    case IFNULL:
                        System.out.print("");
                        break;
                    case IINC:
                        System.out.print("");
                        break;
                    case ILOAD:
                        System.out.print("");
                        break;
                    case ILOAD_0:
                        System.out.print("");
                        break;
                    case ILOAD_1:
                        System.out.print("");
                        break;
                    case ILOAD_2:
                        System.out.print("");
                        break;
                    case ILOAD_3:
                        System.out.print("");
                        break;
                    case IMUL:
                        System.out.print("");
                        break;
                    case INEG:
                        System.out.print("");
                        break;
                    case INSTANCEOF:
                        System.out.print("");
                        break;
                    case INVOKEINTERFACE:
                        System.out.print("");
                        break;
                    case INVOKESPECIAL:
                        System.out.print("");
                        break;
                    case INVOKESTATIC:
                        System.out.print("");
                        break;
                    case INVOKEVIRTUAL:
                        System.out.print("");
                        break;
                    case IOR:
                        System.out.print("");
                        break;
//                case IPUSH:
//                    System.out.print("");
//                    break;
                    case IREM:
                        System.out.print("");
                        break;
                    case IRETURN:
                        System.out.print("");
                        break;
                    case ISHL:
                        System.out.print("");
                        break;
                    case ISHR:
                        System.out.print("");
                        break;
                    case ISTORE:
                        System.out.print("");
                        break;
                    case ISTORE_0:
                        System.out.print("");
                        break;
                    case ISTORE_1:
                        System.out.print("");
                        break;
                    case ISTORE_2:
                        System.out.print("");
                        break;
                    case ISTORE_3:
                        System.out.print("");
                        break;
                    case ISUB:
                        System.out.print("");
                        break;
                    case IUSHR:
                        System.out.print("");
                        break;
                    case IXOR:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // J
                    ///////////////////////
                    case JSR:
                        System.out.print("");
                        break;
                    case JSR_W:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // L
                    ///////////////////////
                    case L2D:
                        System.out.print("");
                        break;
                    case L2F:
                        System.out.print("");
                        break;
                    case L2I:
                        System.out.print("");
                        break;
                    case LADD:
                        System.out.print("");
                        break;
                    case LALOAD:
                        System.out.print("");
                        break;
                    case LAND:
                        System.out.print("");
                        break;
                    case LASTORE:
                        System.out.print("");
                        break;
                    case LCMP:
                        System.out.print("");
                        break;
                    case LCONST_0:
                        System.out.print("");
                        break;
                    case LCONST_1:
                        System.out.print("");
                        break;
                    case LDC:
                        System.out.print("");
                        break;
                    case LDC2_W:
                        System.out.print("");
                        break;
                    case LDC_W:
                        System.out.print("");
                        break;
                    case LDIV:
                        System.out.print("");
                        break;
                    case LLOAD:
                        System.out.print("");
                        break;
                    case LLOAD_0:
                        System.out.print("");
                        break;
                    case LLOAD_1:
                        System.out.print("");
                        break;
                    case LLOAD_2:
                        System.out.print("");
                        break;
                    case LLOAD_3:
                        System.out.print("");
                        break;
                    case LMUL:
                        System.out.print("");
                        break;
                    case LNEG:
                        System.out.print("");
                        break;
                    case LOOKUPSWITCH:
                        System.out.print("");
                        break;
                    case LOR:
                        System.out.print("");
                        break;
                    case LREM:
                        System.out.print("");
                        break;
                    case LRETURN:
                        System.out.print("");
                        break;
                    case LSHL:
                        System.out.print("");
                        break;
                    case LSHR:
                        System.out.print("");
                        break;
                    case LSTORE:
                        System.out.print("");
                        break;
                    case LSTORE_0:
                        System.out.print("");
                        break;
                    case LSTORE_1:
                        System.out.print("");
                        break;
                    case LSTORE_2:
                        System.out.print("");
                        break;
                    case LSTORE_3:
                        System.out.print("");
                        break;
                    case LSUB:
                        System.out.print("");
                        break;
                    case LUSHR:
                        System.out.print("");
                        break;
                    case LXOR:
                        System.out.print("");
                        break;
                    case MONITORENTER:
                        System.out.print("");
                        break;
                    case MONITOREXIT:
                        System.out.print("");
                        break;
                    case MULTIANEWARRAY:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // N
                    ///////////////////////
                    case NEW:
                        System.out.print("");
                        break;
                    case NEWARRAY:
                        System.out.print("");
                        break;
                    case NOP:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // P
                    ///////////////////////
                    case POP:
                        System.out.print("");
                        break;
                    case POP2:
                        System.out.print("");
                        break;
                    case PUTFIELD:
                        System.out.print("");
                        break;
                    case PUTSTATIC:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // R
                    ///////////////////////
                    case RET:
                        System.out.print("");
                        break;
                    case RETURN:
                        System.out.print("");
                        break;

                    ///////////////////////
                    // S
                    ///////////////////////
                    case SALOAD:
                        System.out.print("");
                        break;
                    case SASTORE:
                        System.out.print("");
                        break;
                    case SIPUSH:
                        System.out.print("");
                        break;
//                    case SRETURN:
//                        System.out.print("");
//                        break;
                    case SWAP:
                        System.out.print("");
                        break;
                    case TABLESWITCH:
                        System.out.print("");
                        break;
                    case UNUSED:
                        System.out.print("");
                        break;


                    ///////////////////////
                    // EXTRA
                    ///////////////////////
//                case XTRA_JNI:
//                    System.out.print("");
//                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
