package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.objectweb.asm.*;

public class KJVM_ALOADDump implements Opcodes {

    public void dump(JITContext context) throws Exception {

        
        
        MethodVisitor mv=context.getMethodVisitor();
      
 int ii = context.getLocals();
      

     
        
        {
         //   mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitVarInsn(ALOAD,ii+ 1);
            mv.visitVarInsn(ALOAD,ii+ 1);
            mv.visitVarInsn(ALOAD,ii+ 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_ALOAD", "index", "I");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getLocal", "(I)Lorg/doovos/kernel/api/memory/KRegister;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, ii+1);
            mv.visitVarInsn(ALOAD,ii+ 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_ALOAD", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD,ii+ 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_ALOAD", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            //mv.visitInsn(ARETURN);
          //  mv.visitMaxs(3, 2);
           // mv.visitEnd();

            context.visitMaxs(3,2);
        }
//        {
//            mv = cw.visitMethod(ACC_PUBLIC, "equals", "(Ljava/lang/Object;)Z", null, null);
//            mv.visitCode();
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitVarInsn(ALOAD, 1);
//            Label l0 = new Label();
//            mv.visitJumpInsn(IF_ACMPNE, l0);
//            mv.visitInsn(ICONST_1);
//            mv.visitInsn(IRETURN);
//            mv.visitLabel(l0);
//            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//            mv.visitVarInsn(ALOAD, 1);
//            Label l1 = new Label();
//            mv.visitJumpInsn(IFNULL, l1);
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
//            mv.visitVarInsn(ALOAD, 1);
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
//            Label l2 = new Label();
//            mv.visitJumpInsn(IF_ACMPEQ, l2);
//            mv.visitLabel(l1);
//            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//            mv.visitInsn(ICONST_0);
//            mv.visitInsn(IRETURN);
//            mv.visitLabel(l2);
//            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitVarInsn(ALOAD, 1);
//            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "equals", "(Ljava/lang/Object;)Z");
//            Label l3 = new Label();
//            mv.visitJumpInsn(IFNE, l3);
//            mv.visitInsn(ICONST_0);
//            mv.visitInsn(IRETURN);
//            mv.visitLabel(l3);
//            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
//            mv.visitVarInsn(ALOAD, 1);
//            mv.visitTypeInsn(CHECKCAST, "KJVM_ALOAD");
//            mv.visitVarInsn(ASTORE, 2);
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitFieldInsn(GETFIELD, "KJVM_ALOAD", "index", "I");
//            mv.visitVarInsn(ALOAD, 2);
//            mv.visitFieldInsn(GETFIELD, "KJVM_ALOAD", "index", "I");
//            Label l4 = new Label();
//            mv.visitJumpInsn(IF_ICMPEQ, l4);
//            mv.visitInsn(ICONST_0);
//            mv.visitInsn(IRETURN);
//            mv.visitLabel(l4);
//            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/instr/KJVM_ALOAD"}, 0, null);
//            mv.visitInsn(ICONST_1);
//            mv.visitInsn(IRETURN);
//            mv.visitMaxs(2, 3);
//            mv.visitEnd();
//        }
//        {
//            mv = cw.visitMethod(ACC_PUBLIC, "hashCode", "()I", null, null);
//            mv.visitCode();
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "hashCode", "()I");
//            mv.visitVarInsn(ISTORE, 1);
//            mv.visitIntInsn(BIPUSH, 31);
//            mv.visitVarInsn(ILOAD, 1);
//            mv.visitInsn(IMUL);
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitFieldInsn(GETFIELD, "KJVM_ALOAD", "index", "I");
//            mv.visitInsn(IADD);
//            mv.visitVarInsn(ISTORE, 1);
//            mv.visitVarInsn(ILOAD, 1);
//            mv.visitInsn(IRETURN);
//            mv.visitMaxs(2, 2);
//            mv.visitEnd();
//        }
//        {
//            mv = cw.visitMethod(ACC_PUBLIC, "getLoadIndex", "()I", null, null);
//            mv.visitCode();
//            mv.visitVarInsn(ALOAD, 0);
//            mv.visitFieldInsn(GETFIELD, "KJVM_ALOAD", "index", "I");
//            mv.visitInsn(IRETURN);
//            mv.visitMaxs(1, 1);
//            mv.visitEnd();
//        }
       

       
    }
}
