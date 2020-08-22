package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.shared;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.memory.KDouble;
import org.doovos.kernel.api.memory.KFloat;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KLong;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_XLOAD;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_XSTORE;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec.*;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 24/07/11
 * Time: 23:50
 * To change this template use File | Settings | File Templates.
 */
public final class SharedInstructionFactory {

    private static interface Doer {
        JJITInstruction create(JJITInstructionDef a, JJITInstructionDef b);
    }

    private static class KKey {
        KOperator op1;
        KOperator op2;

        private KKey(KOperator op1, KOperator op2) {
            this.op1 = op1;
            this.op2 = op2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KKey kKey = (KKey) o;

            if (op1 != kKey.op1) return false;
            if (op2 != kKey.op2) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = op1 != null ? op1.hashCode() : 0;
            result = 31 * result + (op2 != null ? op2.hashCode() : 0);
            return result;
        }
    }

    private static HashMap<KKey, Doer> mapping = new HashMap<KKey, Doer>();

    private static void register(KOperator[] op1, KOperator[] op2, Doer d) {
        for (KOperator a : op1) {
            for (KOperator B : op2) {
                if (mapping.put(new KKey(a, B), d) != null) {
                    throw new IllegalArgumentException("Already registered");
                }
            }
        }
    }

    static {
        register(
                new KOperator[]{KOperator.ASTORE, KOperator.ASTORE_0, KOperator.ASTORE_1, KOperator.ASTORE_2, KOperator.ASTORE_3, KOperator.ISTORE, KOperator.ISTORE_0, KOperator.ISTORE_1, KOperator.ISTORE_2, KOperator.ISTORE_3, KOperator.LSTORE, KOperator.LSTORE_0, KOperator.LSTORE_1, KOperator.LSTORE_2, KOperator.LSTORE_3, KOperator.DSTORE_0, KOperator.DSTORE_1, KOperator.DSTORE_2, KOperator.DSTORE_3},
                new KOperator[]{KOperator.ALOAD, KOperator.ALOAD_0, KOperator.ALOAD_1, KOperator.ALOAD_2, KOperator.ALOAD_3, KOperator.ILOAD, KOperator.ILOAD_0, KOperator.ILOAD_1, KOperator.ILOAD_2, KOperator.ILOAD_3, KOperator.LLOAD, KOperator.LLOAD_0, KOperator.LLOAD_1, KOperator.LLOAD_2, KOperator.LLOAD_3, KOperator.FLOAD, KOperator.FLOAD_0, KOperator.FLOAD_1, KOperator.FLOAD_2, KOperator.FLOAD_3, KOperator.DLOAD, KOperator.DLOAD_0, KOperator.DLOAD_1, KOperator.DLOAD_2, KOperator.DLOAD_3}, new Doer() {
            public JJITInstruction create(JJITInstructionDef a, JJITInstructionDef b) {
                JJIT__BASE_XSTORE a1 = (JJIT__BASE_XSTORE) a;
                JJIT__BASE_XLOAD b1 = (JJIT__BASE_XLOAD) b;
                if (a1.getLocal() == b1.getLocal()) {
                    return new JJIT_XSTORE_X_XLOAD_X(a1.getLocal());
                } else {
                    return new JJIT_XSTORE_X_XLOAD_Y(a1.getLocal(), b1.getLocal());
                }
            }
        }
        );
        register(
                new KOperator[]{KOperator.ALOAD, KOperator.ALOAD_0, KOperator.ALOAD_1, KOperator.ALOAD_2, KOperator.ALOAD_3, KOperator.ILOAD, KOperator.ILOAD_0, KOperator.ILOAD_1, KOperator.ILOAD_2, KOperator.ILOAD_3, KOperator.LLOAD, KOperator.LLOAD_0, KOperator.LLOAD_1, KOperator.LLOAD_2, KOperator.LLOAD_3, KOperator.FLOAD, KOperator.FLOAD_0, KOperator.FLOAD_1, KOperator.FLOAD_2, KOperator.FLOAD_3, KOperator.DLOAD, KOperator.DLOAD_0, KOperator.DLOAD_1, KOperator.DLOAD_2, KOperator.DLOAD_3},
                new KOperator[]{KOperator.ALOAD, KOperator.ALOAD_0, KOperator.ALOAD_1, KOperator.ALOAD_2, KOperator.ALOAD_3, KOperator.ILOAD, KOperator.ILOAD_0, KOperator.ILOAD_1, KOperator.ILOAD_2, KOperator.ILOAD_3, KOperator.LLOAD, KOperator.LLOAD_0, KOperator.LLOAD_1, KOperator.LLOAD_2, KOperator.LLOAD_3, KOperator.FLOAD, KOperator.FLOAD_0, KOperator.FLOAD_1, KOperator.FLOAD_2, KOperator.FLOAD_3, KOperator.DLOAD, KOperator.DLOAD_0, KOperator.DLOAD_1, KOperator.DLOAD_2, KOperator.DLOAD_3},
                new Doer() {
            public JJITInstruction create(JJITInstructionDef a, JJITInstructionDef b) {
                JJIT__BASE_XLOAD a1 = (JJIT__BASE_XLOAD) a;
                JJIT__BASE_XLOAD b1 = (JJIT__BASE_XLOAD) b;
                if (a1.getLocal() == b1.getLocal()) {
                    return new JJIT_XLOAD_X_XLOAD_X(a1.getLocal());
                } else {
                    return new JJIT_XLOAD_X_XLOAD_Y(a1.getLocal(), b1.getLocal());
                }
            }
        }
        );
        register(
                new KOperator[]{KOperator.ALOAD, KOperator.ALOAD_0, KOperator.ALOAD_1, KOperator.ALOAD_2, KOperator.ALOAD_3, KOperator.ILOAD, KOperator.ILOAD_0, KOperator.ILOAD_1, KOperator.ILOAD_2, KOperator.ILOAD_3, KOperator.LLOAD, KOperator.LLOAD_0, KOperator.LLOAD_1, KOperator.LLOAD_2, KOperator.LLOAD_3, KOperator.FLOAD, KOperator.FLOAD_0, KOperator.FLOAD_1, KOperator.FLOAD_2, KOperator.FLOAD_3, KOperator.DLOAD, KOperator.DLOAD_0, KOperator.DLOAD_1, KOperator.DLOAD_2, KOperator.DLOAD_3},
                new KOperator[]{KOperator.ASTORE, KOperator.ASTORE_0, KOperator.ASTORE_1, KOperator.ASTORE_2, KOperator.ASTORE_3, KOperator.ISTORE, KOperator.ISTORE_0, KOperator.ISTORE_1, KOperator.ISTORE_2, KOperator.ISTORE_3, KOperator.LSTORE, KOperator.LSTORE_0, KOperator.LSTORE_1, KOperator.LSTORE_2, KOperator.LSTORE_3, KOperator.DSTORE_0, KOperator.DSTORE_1, KOperator.DSTORE_2, KOperator.DSTORE_3},
                new Doer() {
            public JJITInstruction create(JJITInstructionDef a, JJITInstructionDef b) {
                JJIT__BASE_XLOAD a1 = (JJIT__BASE_XLOAD) a;
                JJIT__BASE_XSTORE b1 = (JJIT__BASE_XSTORE) b;
                return new JJIT_XLOAD_X_XSTORE_Y(a1.getLocal(), b1.getLocal());
            }
        }
        );
        register(
                new KOperator[]{KOperator.ALOAD, KOperator.ALOAD_0, KOperator.ALOAD_1, KOperator.ALOAD_2, KOperator.ALOAD_3},
                new KOperator[]{KOperator.ARRAYLENGTH},
                new Doer() {
            public JJITInstruction create(JJITInstructionDef a, JJITInstructionDef b) {
                JJIT__BASE_XLOAD a1 = (JJIT__BASE_XLOAD) a;
                return new JJIT_ALOAD_ARRAYLENGTH(a1.getLocal());
            }
        }
        );
        register(
                new KOperator[]{KOperator.ALOAD, KOperator.ALOAD_0, KOperator.ALOAD_1, KOperator.ALOAD_2, KOperator.ALOAD_3, KOperator.ILOAD, KOperator.ILOAD_0, KOperator.ILOAD_1, KOperator.ILOAD_2, KOperator.ILOAD_3, KOperator.LLOAD, KOperator.LLOAD_0, KOperator.LLOAD_1, KOperator.LLOAD_2, KOperator.LLOAD_3, KOperator.FLOAD, KOperator.FLOAD_0, KOperator.FLOAD_1, KOperator.FLOAD_2, KOperator.FLOAD_3, KOperator.DLOAD, KOperator.DLOAD_0, KOperator.DLOAD_1, KOperator.DLOAD_2, KOperator.DLOAD_3},
                new KOperator[]{KOperator.ARETURN, KOperator.IRETURN, KOperator.LRETURN, KOperator.DRETURN, KOperator.FRETURN},
                new Doer() {
            public JJITInstruction create(JJITInstructionDef a, JJITInstructionDef b) {
                JJIT__BASE_XLOAD a1 = (JJIT__BASE_XLOAD) a;
                return new JJIT_XLOAD_X_XRETURN(a1.getLocal());
            }
        }
        );
    }


    public static JJITInstruction create(JJITInstructionDef a, JJITInstructionDef b) {
        Doer d = mapping.get(new KKey(a.getOperator(), b.getOperator()));
        if(d!=null){
            return d.create(a,b);
        }
        switch (a.getOperator()) {
            case ICONST_M1:
            case ICONST_0:
            case ICONST_1:
            case ICONST_2:
            case ICONST_3:
            case ICONST_4:
            case ICONST_5: {
                switch (b.getOperator()) {
                    case IRETURN: {
                        KInteger v = ((JJIT_ICONST) a).getValue();
                        return new JJIT_XCONST_XRETURN(v);
                    }
                    case ISTORE:
                    case ISTORE_0:
                    case ISTORE_1:
                    case ISTORE_2:
                    case ISTORE_3: {
                        KInteger v = ((JJIT_ICONST) a).getValue();
                        return new JJIT_XCONST_XSTORE(((JJIT__BASE_XSTORE) b).getLocal(), v);
                    }
                }
                break;
            }
            case LCONST_0:
            case LCONST_1: {
                switch (b.getOperator()) {
                    case LRETURN: {
                        KLong v = ((JJIT_LCONST) a).getValue();
                        return new JJIT_XCONST_XRETURN(v);
                    }
                    case LSTORE:
                    case LSTORE_0:
                    case LSTORE_1:
                    case LSTORE_2:
                    case LSTORE_3: {
                        KLong v = ((JJIT_LCONST) a).getValue();
                        return new JJIT_XCONST_XSTORE(((JJIT__BASE_XSTORE) b).getLocal(), v);
                    }
                }
                break;
            }
            case DCONST_0:
            case DCONST_1: {
                switch (b.getOperator()) {
                    case DRETURN: {
                        KDouble v = ((JJIT_DCONST) a).getValue();
                        return new JJIT_XCONST_XRETURN(v);
                    }
                    case DSTORE:
                    case DSTORE_0:
                    case DSTORE_1:
                    case DSTORE_2:
                    case DSTORE_3: {
                        KDouble v = ((JJIT_DCONST) a).getValue();
                        return new JJIT_XCONST_XSTORE(((JJIT__BASE_XSTORE) b).getLocal(), v);
                    }
                }
                break;
            }
            case FCONST_0:
            case FCONST_1:
            case FCONST_2: {
                switch (b.getOperator()) {
                    case FRETURN: {
                        KFloat v = ((JJIT_FCONST) a).getValue();
                        return new JJIT_XCONST_XRETURN(v);
                    }
                    case FSTORE:
                    case FSTORE_0:
                    case FSTORE_1:
                    case FSTORE_2:
                    case FSTORE_3: {
                        KFloat v = ((JJIT_FCONST) a).getValue();
                        return new JJIT_XCONST_XSTORE(((JJIT__BASE_XSTORE) b).getLocal(), v);
                    }
                }
                break;
            }
            case SIPUSH: {
                switch (b.getOperator()) {
                    case ISTORE:
                    case ISTORE_0:
                    case ISTORE_1:
                    case ISTORE_2:
                    case ISTORE_3: {
                        return new JJIT_XCONST_XSTORE(((JJIT__BASE_XSTORE) b).getLocal(), ((JJIT_SIPUSH) a).getValue());
                    }
                }

            }
            case DASTORE:{
                 switch (b.getOperator()) {
                    case IINC: {
                        JJIT_IINC a1 = (JJIT_IINC) b;
                        return new JJIT_DASTORE_IINC(a1.getLocal(),a1.getVal());
                    }
                }
            }
            case AASTORE:{
                 switch (b.getOperator()) {
                    case IINC: {
                        JJIT_IINC a1 = (JJIT_IINC) b;
                        return new JJIT_AASTORE_IINC(a1.getLocal(),a1.getVal());
                    }
                }
            }
            case DLOAD:
            case DLOAD_0:
            case DLOAD_1:
            case DLOAD_2:
            case DLOAD_3:
            {
                 switch (b.getOperator()) {
                    case D2L: {
                        JJIT_DLOAD a1 = (JJIT_DLOAD) a;
                        return new JJIT_DLOAD_D2L(a1.getLocal());
                    }
                }
            }
        }
        return null;
    }
}
