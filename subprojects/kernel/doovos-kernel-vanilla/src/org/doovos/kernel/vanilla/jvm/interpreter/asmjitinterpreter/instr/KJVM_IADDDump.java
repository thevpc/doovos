package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;

import org.objectweb.asm.*;

public class KJVM_IADDDump extends KInstructionJITImpl {

    public KJVM_IADDDump() {
        super(KOperatorCodes.IADD, false, false);
    }



    public void produceRunMethod(JITContext context) throws Exception {

        
   
        MethodVisitor mv =context.getMethodVisitor();
   int ii= context.getLocals();

  
        {
//            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD,ii+ 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
            mv.visitVarInsn(ISTORE,ii+ 2);
            mv.visitVarInsn(ALOAD, ii+1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
            mv.visitVarInsn(ISTORE, ii+3);
            mv.visitTypeInsn(NEW, "org/doovos/kernel/api/memory/KInteger");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ILOAD,ii+ 3);
            mv.visitVarInsn(ILOAD, ii+2);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/api/memory/KInteger", "<init>", "(I)V");
            mv.visitVarInsn(ASTORE, ii+4);
            mv.visitVarInsn(ALOAD, ii+1);
            mv.visitVarInsn(ALOAD, ii+4);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, ii+1);
            mv.visitVarInsn(ALOAD, ii+0);
            mv.visitFieldInsn(GETFIELD, "KJVM_IADD", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD,ii+ 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_IADD", "next", "Lorg/doovos/kernel/vanilla.jvm/interpreter/amsjitinterpreter/interpreteur/KInstructionJIT;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 5);
            //context.addLocals(4);
           // context.checkStack(5);

            //mv.visitEnd();
        }
        


   
        //return cw.toByteArray();
    }
}
