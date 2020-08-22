//package org.doovos.kernel.vanilla.jvm.interpreter.switchinterpreter.instr;
//
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//
//import java.util.Arrays;
//
//public class KInstructionSwitch implements KInstruction {
//    private static long[] NO_OPERANDS = new long[0];
//    public KOperator operator;
//    public long[] operands;
//
//    protected KInstructionSwitch(KOperator operator) {
//        this(operator, NO_OPERANDS);
//    }
//
//    public KInstructionSwitch(KOperator operator, long[] operands) {
//        this.operator = operator;
//        this.operands = operands;
////        if(!getClass().getName().endsWith("_"+operator.name())){
////            //throw new IllegalArgumentException("????????????");
////            System.out.println(getClass().getName()+" --> "+operator.name());
////        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(operator.toString());
//        for (long operand : operands) {
//            sb.append(" ");
//            sb.append(operand);
//        }
//        return sb.toString();
//    }
//
//    @Override
//    public KInstruction clone() {
//        try {
//            KInstructionSwitch kInstruction = (KInstructionSwitch) super.clone();
//            int len = kInstruction.operands.length;
//            if (len > 0) {
//                long[] v = new long[len];
//                System.arraycopy(kInstruction.operands, 0, v, 0, v.length);
//                kInstruction.operands = v;
//            }
//            return kInstruction;
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public int getOperator() {
//        return operator.ordinal();
//    }
//
//    public long[] getOperands() {
//        return operands;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        KInstructionSwitch that = (KInstructionSwitch) o;
//
//        if (!Arrays.equals(operands, that.operands)) return false;
//        if (operator != that.operator) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = operator.name().hashCode();
//        result = 31 * result + Arrays.hashCode(operands);
//        return result;
//    }
//
//
//}
