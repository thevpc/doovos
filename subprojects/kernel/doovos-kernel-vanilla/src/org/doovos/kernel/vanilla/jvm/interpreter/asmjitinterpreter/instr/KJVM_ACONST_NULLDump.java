package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;
import java.rmi.RemoteException;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.objectweb.asm.*;

//
public class KJVM_ACONST_NULLDump extends KInstructionJITImpl {

    public KJVM_ACONST_NULLDump() {
        super(KOperatorCodes.ACONST_NULL, false, false);
    }

    public void produceRunMethod(JITContext context) throws Exception {

        MethodVisitor mv = context.getMethodVisitor();
        int ii = context.getLocals();


        {
            mv.visitVarInsn(ALOAD, ii + 1);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/memory/KReference", "NULL", "Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, ii + 1);
            mv.visitVarInsn(ALOAD, ii + 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_ACONST_NULL", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, ii + 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_ACONST_NULL", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            // mv.visitMaxs(3, 2);
            //mv.visitEnd();
            context.visitMaxs(3,2);
        }

        //  cw.visitEnd();

        //   return null;
    }

    @Override
    public boolean isJump() throws RemoteException {
        return super.isJump();
    }

    @Override
    public boolean isLabel() throws RemoteException {
        return super.isLabel();
    }

    @Override
    public void visit(MethodVisitor mv) throws RemoteException {
        super.visit(mv);
    }
}
