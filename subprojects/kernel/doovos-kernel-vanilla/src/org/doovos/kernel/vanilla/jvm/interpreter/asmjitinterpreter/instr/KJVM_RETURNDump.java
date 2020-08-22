package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionCompiled;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.rmi.RemoteException;


public class KJVM_RETURNDump extends KInstructionJITImpl implements KInstructionCompiled{

    public KJVM_RETURNDump() {
        super(KOperatorCodes.RETURN, true, false);
    }

    @Override
    public void produceRunMethod(JITContext context) throws Exception {
        MethodVisitor mv = context.getMethodVisitor();
        mv.visitVarInsn(ALOAD,1);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popFrame", "()Lorg/doovos/kernel/api/jvm/interpreter/KFrame;");
        //context.m_popFrame();
    }

    public KInstructionCompiled run(KFrame frame) throws RemoteException {
        KFrame kFrame = frame.popFrame();
        return (KInstructionCompiled) kFrame.getThread().getFrame().getCurrentInstruction();
    }

    public void configure(KInstructionCompiled[] instructions, int index) throws RemoteException {
        //
    }
}
