package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;

import org.objectweb.asm.*;

public class KJVM_AASTOREDump extends KInstructionJITImpl{

    public KJVM_AASTOREDump() {
        super(KOperatorCodes.AASTORE,false,false);
    }


    public void produceRunMethod(JITContext context) throws Exception
    {
 MethodVisitor  mv=context.getMethodVisitor();
   
            //mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
          //  mv.visitCode();
            int i0=context.getLocals();
            mv.visitVarInsn(ALOAD, i0+1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popReference", "()Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitVarInsn(ASTORE, i0+2);
            mv.visitVarInsn(ALOAD, i0+1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
            mv.visitVarInsn(ISTORE, i0+3);
            mv.visitVarInsn(ALOAD, i0+1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popReference", "()Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitVarInsn(ASTORE, i0+4);
            mv.visitMethodInsn(INVOKESTATIC, "org/doovos/kernel/api/Doovos", "getMemoryManager", "()Lorg/doovos/kernel/api/memory/KMemoryManager;");
            mv.visitVarInsn(ALOAD, i0+4);
            mv.visitVarInsn(ILOAD, i0+3);
            mv.visitVarInsn(ALOAD, i0+2);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemoryManager", "setReferenceArray", "(Lorg/doovos/kernel/api/memory/KReference;ILorg/doovos/kernel/api/memory/KReference;)V");
            mv.visitVarInsn(ALOAD, i0+0);
            mv.visitFieldInsn(GETFIELD, "KJVM_AASTORE", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
           // mv.visitInsn(ARETURN);
         //   mv.visitMaxs(4, 5);
            //mv.visitEnd();
            context.visitMaxs(4,5);
        }
      //byte cw.visitEnd();

     //   return cw.toByteArray();
}

