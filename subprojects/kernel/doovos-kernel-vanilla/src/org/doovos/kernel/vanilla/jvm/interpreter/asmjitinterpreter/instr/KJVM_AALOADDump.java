package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;

import org.objectweb.asm.*;

public class KJVM_AALOADDump extends KInstructionJITImpl {

    //private static  KJVM_AALOADDump INSTANCE=new KJVM_AALOADDump();

    public KJVM_AALOADDump() {
        super(KOperatorCodes.AALOAD, false, false);
    }




    public void produceRunMethod(JITContext context) throws Exception {
//        mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
//        mv.visitCode();

        int ii=context.getLocals();

        MethodVisitor mv=context.getMethodVisitor();
        mv.visitVarInsn(ALOAD,ii+ 1);
        mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
        mv.visitVarInsn(ISTORE, ii+2);
        mv.visitVarInsn(ALOAD, ii+1);
        mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popReference", "()Lorg/doovos/kernel/api/memory/KReference;");
        mv.visitVarInsn(ASTORE, ii+3);
        mv.visitVarInsn(ALOAD, ii+1);
        mv.visitMethodInsn(INVOKESTATIC, "org/doovos/kernel/api/Doovos", "getMemoryManager", "()Lorg/doovos/kernel/api/memory/KMemoryManager;");
        mv.visitVarInsn(ALOAD,ii+ 3);
        mv.visitVarInsn(ILOAD, ii+2);
        mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemoryManager", "getReferenceArray", "(Lorg/doovos/kernel/api/memory/KReference;I)Lorg/doovos/kernel/api/memory/KReference;");
        mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
        mv.visitVarInsn(ALOAD, ii+0);
        mv.visitFieldInsn(GETFIELD, "KJVM_AALOAD", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
//        mv.visitInsn(ARETURN);
//        mv.visitMaxs(4, 4);
        context.visitMaxs(4,4);
//        mv.visitEnd();
    }

//    public void relink(int index, KInstructionJIT[] code, KMethod method) {
//       // this.ordinal = index;
//        //this.next = code[index + 1];
//    }

}
