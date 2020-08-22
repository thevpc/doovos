package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;

import org.objectweb.asm.*;

public class KJVM_ISTOREDump extends KInstructionJITImpl {

    int index;

    private KJVM_ISTOREDump(int operator, int index) {
        super(operator, false, false);
        this.index = index;
    }

    public static KJVM_ISTOREDump newISTORE(int index) {
        return new KJVM_ISTOREDump(KOperatorCodes.ISTORE, index);
    }

    public static KJVM_ISTOREDump newISTORE_0() {
        return new KJVM_ISTOREDump(KOperatorCodes.ISTORE_0, 0);
    }

    public static KJVM_ISTOREDump newISTORE_1() {
        return new KJVM_ISTOREDump(KOperatorCodes.ISTORE_1, 1);
    }

    public static KJVM_ISTOREDump newISTORE_2() {
        return new KJVM_ISTOREDump(KOperatorCodes.ISTORE_2, 2);
    }

    public static KJVM_ISTOREDump newISTORE_3() {
        return new KJVM_ISTOREDump(KOperatorCodes.ISTORE_3, 3);
    }

    public void produceRunMethod(JITContext context) throws Exception {
        MethodVisitor mv = context.getMethodVisitor();
        mv.visitVarInsn(ALOAD,1);
        mv.visitVarInsn(Opcodes.BIPUSH, index);
        mv.visitVarInsn(ALOAD,1);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "pop", "()Lorg/doovos/kernel/api/memory/KRegister;");
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setLocal", "(ILorg/doovos/kernel/api/memory/KRegister;)V");
        context.visitMaxs(3, 2);
    }
}
