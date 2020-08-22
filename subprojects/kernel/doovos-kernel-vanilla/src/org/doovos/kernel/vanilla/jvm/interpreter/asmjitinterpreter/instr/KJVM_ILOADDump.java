package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;


public class KJVM_ILOADDump extends KInstructionJITImpl {

    private int index;

    public KJVM_ILOADDump(int index) {
        super(KOperatorCodes.ILOAD, false, false);
        this.index = index;
    }

    public void produceRunMethod(JITContext context) throws Exception {
        MethodVisitor mv = context.getMethodVisitor();
        mv.visitVarInsn(ALOAD,1);
        mv.visitVarInsn(ALOAD,1);
        mv.visitVarInsn(Opcodes.BIPUSH, index);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getLocal", "(I)Lorg/doovos/kernel/api/memory/KRegister;");
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
        context.visitMaxs(3, 2);
    }
}
