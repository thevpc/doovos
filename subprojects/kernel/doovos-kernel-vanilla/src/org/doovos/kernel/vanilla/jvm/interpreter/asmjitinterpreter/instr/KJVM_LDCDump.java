package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;

import org.objectweb.asm.*;

public class KJVM_LDCDump  extends KInstructionJITImpl{

    public KJVM_LDCDump() {
        super(KOperatorCodes.LDC, false, false);
    }



    public void produceRunMethod(JITContext context) throws Exception {

       
        MethodVisitor mv= context.getMethodVisitor();
        

       int ii= context.getLocals();
           
        
        {
            
            mv.visitVarInsn(ALOAD, ii+1);
            mv.visitVarInsn(ALOAD, ii+ 1);
            mv.visitVarInsn(ALOAD ,ii+ 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_LDC", "index", "I");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getConstant", "(I)Lorg/doovos/kernel/api/memory/KRegister;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, ii+ 1);
            mv.visitVarInsn(ALOAD,ii+ 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_LDC", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, ii+0);
            mv.visitFieldInsn(GETFIELD, "KJVM_LDC", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
         //  mv.visitMaxs(3, 2);
          //  mv.visitEnd();
            context.visitMaxs(3,2);
        }
      
    }
}
