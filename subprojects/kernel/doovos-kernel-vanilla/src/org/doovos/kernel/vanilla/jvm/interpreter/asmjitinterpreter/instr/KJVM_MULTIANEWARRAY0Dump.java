package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_MULTIANEWARRAY0Dump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_MULTIANEWARRAY0", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable"});

        {
            fv = cw.visitField(ACC_PRIVATE, "dims", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "typeId", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(IILorg/doovos/kernel/api/jvm/reflect/KClass;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "MULTIANEWARRAY", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitInsn(ICONST_2);
            mv.visitIntInsn(NEWARRAY, T_LONG);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(I2L);
            mv.visitInsn(LASTORE);
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_1);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitInsn(I2L);
            mv.visitInsn(LASTORE);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY0", "typeId", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY0", "dims", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY0", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(7, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "dims", "I");
            mv.visitIntInsn(NEWARRAY, T_INT);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ISTORE, 3);
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 2, new Object[]{"[I", Opcodes.INTEGER}, 0, null);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitInsn(ARRAYLENGTH);
            Label l1 = new Label();
            mv.visitJumpInsn(IF_ICMPGE, l1);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitInsn(ARRAYLENGTH);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitInsn(ISUB);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(ISUB);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
            mv.visitInsn(IASTORE);
            mv.visitIincInsn(3, 1);
            mv.visitJumpInsn(GOTO, l0);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getMemorySegment", "()Lorg/doovos/kernel/api/memory/KMemorySegment;");
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemorySegment", "allocMultiArray", "(Lorg/doovos/kernel/api/jvm/reflect/KClass;[I)Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY0", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitInsn(AALOAD);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY0", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
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
            mv.visitTypeInsn(CHECKCAST, "KJVM_MULTIANEWARRAY0");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "dims", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "dims", "I");
            Label l4 = new Label();
            mv.visitJumpInsn(IF_ICMPEQ, l4);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"KJVM_MULTIANEWARRAY0"}, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "typeId", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "typeId", "I");
            Label l5 = new Label();
            mv.visitJumpInsn(IF_ICMPEQ, l5);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l5);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
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
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "dims", "I");
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitIntInsn(BIPUSH, 31);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IMUL);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY0", "typeId", "I");
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "isJump", "()Z", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "isLabel", "()Z", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
