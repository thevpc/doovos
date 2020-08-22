package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;

import org.objectweb.asm.*;

public class KJVM_ICONSTDump extends KInstructionJITImpl {

    private int index;
    private String constName;

    public KJVM_ICONSTDump(int operateur, int index, String constName) {


        super(operateur, false, false);
        this.index = index;
        this.constName = constName;
    }

    public static KJVM_ICONSTDump newICONST_0() {

        return new KJVM_ICONSTDump(KOperatorCodes.ICONST_0, 0, "ZERO");


    }

    public static KJVM_ICONSTDump newICONST_1() {
        return new KJVM_ICONSTDump(KOperatorCodes.ICONST_1, 1, "ONE");
    }

    public static KJVM_ICONSTDump newICONST_2() {
        return new KJVM_ICONSTDump(KOperatorCodes.ICONST_2, 2, "TWO");
    }

    public static KJVM_ICONSTDump newICONST_3() {
        return new KJVM_ICONSTDump(KOperatorCodes.ICONST_3, 3, "THREE");
    }

    public static KJVM_ICONSTDump newICONST_4() {
        return new KJVM_ICONSTDump(KOperatorCodes.ICONST_4, 3, "FOUR");
    }

    public static KJVM_ICONSTDump newICONST_5() {
        return new KJVM_ICONSTDump(KOperatorCodes.ICONST_4, 3, "FIVE");
    }

    public static KJVM_ICONSTDump newICONST_M1() {
        return new KJVM_ICONSTDump(KOperatorCodes.ICONST_4, 3, "M1");
    }

    public void produceRunMethod(JITContext context) throws Exception {
        MethodVisitor mv = context.getMethodVisitor();
        mv.visitVarInsn(ALOAD,1);
        mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/memory/KInteger", constName, "Lorg/doovos/kernel/api/memory/KInteger;");
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
        context.visitMaxs(0, 2);
    }
}
