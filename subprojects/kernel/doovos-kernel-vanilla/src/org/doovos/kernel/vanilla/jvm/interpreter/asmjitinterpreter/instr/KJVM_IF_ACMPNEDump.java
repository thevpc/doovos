package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_IF_ACMPNEDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_IF_ACMPNE", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/instr/KJVM__IF", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "([J)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "IF_ACMPNE", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/instr/KJVM__IF", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popReference", "()Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popReference", "()Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitFieldInsn(GETFIELD, "org/doovos/kernel/api/memory/KReference", "pointer", "J");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "org/doovos/kernel/api/memory/KReference", "pointer", "J");
            mv.visitInsn(LCMP);
            Label l0 = new Label();
            mv.visitJumpInsn(IFNE, l0);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitFieldInsn(GETFIELD, "org/doovos/kernel/api/memory/KReference", "segment", "J");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "org/doovos/kernel/api/memory/KReference", "segment", "J");
            mv.visitInsn(LCMP);
            Label l1 = new Label();
            mv.visitJumpInsn(IFEQ, l1);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 2, new Object[]{"org/doovos/kernel/api/memory/KReference", "org/doovos/kernel/api/memory/KReference"}, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_IF_ACMPNE", "label", "I");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_IF_ACMPNE", "nextLabel", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_IF_ACMPNE", "ordinalinc", "I");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_IF_ACMPNE", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
