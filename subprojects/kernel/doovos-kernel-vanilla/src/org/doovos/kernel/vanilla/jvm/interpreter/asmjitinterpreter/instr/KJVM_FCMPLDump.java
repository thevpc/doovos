package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_FCMPLDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_FCMPL", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable"});

        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "LKJVM_FCMPL;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PRIVATE, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "FCMPL", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;)V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popFloat", "()F");
            mv.visitVarInsn(FSTORE, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popFloat", "()F");
            mv.visitVarInsn(FSTORE, 3);
            mv.visitVarInsn(FLOAD, 3);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Float", "isNaN", "(F)Z");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNE, l0);
            mv.visitVarInsn(FLOAD, 2);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Float", "isNaN", "(F)Z");
            Label l1 = new Label();
            mv.visitJumpInsn(IFEQ, l1);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 2, new Object[]{Opcodes.FLOAT, Opcodes.FLOAT}, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/memory/KInteger", "M1", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            Label l2 = new Label();
            mv.visitJumpInsn(GOTO, l2);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(FLOAD, 3);
            mv.visitVarInsn(FLOAD, 2);
            mv.visitInsn(FCMPL);
            Label l3 = new Label();
            mv.visitJumpInsn(IFNE, l3);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/memory/KInteger", "ZERO", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitJumpInsn(GOTO, l2);
            mv.visitLabel(l3);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(FLOAD, 3);
            mv.visitVarInsn(FLOAD, 2);
            mv.visitInsn(FCMPL);
            Label l4 = new Label();
            mv.visitJumpInsn(IFLE, l4);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/memory/KInteger", "ONE", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitJumpInsn(GOTO, l2);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/memory/KInteger", "M1", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_FCMPL", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_FCMPL", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_FCMPL", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitInsn(AALOAD);
            mv.visitFieldInsn(PUTFIELD, "KJVM_FCMPL", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "KJVM_FCMPL");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "KJVM_FCMPL", "<init>", "()V");
            mv.visitFieldInsn(PUTSTATIC, "KJVM_FCMPL", "INSTANCE", "LKJVM_FCMPL;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 0);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
