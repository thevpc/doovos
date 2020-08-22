package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_BIPUSHDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_BIPUSH", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable"});

        {
            fv = cw.visitField(ACC_PRIVATE, "value", "Lorg/doovos/kernel/api/memory/KInteger;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "([J)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "BIPUSH", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitTypeInsn(NEW, "org/doovos/kernel/api/memory/KInteger");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitInsn(I2B);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/api/memory/KInteger", "<init>", "(I)V");
            mv.visitFieldInsn(PUTFIELD, "KJVM_BIPUSH", "value", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(5, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "runStatic", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;Lorg/doovos/kernel/api/jvm/reflect/KInstruction;)I", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitTypeInsn(NEW, "org/doovos/kernel/api/memory/KInteger");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/reflect/KInstruction", "getOperands", "()[J");
            mv.visitInsn(ICONST_0);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitInsn(I2B);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/api/memory/KInteger", "<init>", "(I)V");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitIntInsn(BIPUSH, -2);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(4, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_BIPUSH", "value", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_BIPUSH", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_BIPUSH", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_BIPUSH", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitInsn(AALOAD);
            mv.visitFieldInsn(PUTFIELD, "KJVM_BIPUSH", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "equals", "(Ljava/lang/Object;)Z", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            Label l0 = new Label();
            mv.visitJumpInsn(IF_ACMPNE, l0);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            Label l1 = new Label();
            mv.visitJumpInsn(IFNULL, l1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            Label l2 = new Label();
            mv.visitJumpInsn(IF_ACMPEQ, l2);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "equals", "(Ljava/lang/Object;)Z");
            Label l3 = new Label();
            mv.visitJumpInsn(IFNE, l3);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l3);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitTypeInsn(CHECKCAST, "KJVM_BIPUSH");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_BIPUSH", "value", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_BIPUSH", "value", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/memory/KInteger", "equals", "(Ljava/lang/Object;)Z");
            Label l4 = new Label();
            mv.visitJumpInsn(IFNE, l4);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"KJVM_BIPUSH"}, 0, null);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(2, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "hashCode", "()I", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "hashCode", "()I");
            mv.visitVarInsn(ISTORE, 1);
            mv.visitIntInsn(BIPUSH, 31);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IMUL);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_BIPUSH", "value", "Lorg/doovos/kernel/api/memory/KInteger;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/memory/KInteger", "hashCode", "()I");
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
