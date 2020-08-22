package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_BASTOREDump implements Opcodes {

    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_BASTORE", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable", "org/doovos/kernel/core/jvm/interpreter/instr/groups/KInstructionStore"});

        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "LKJVM_BASTORE;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PRIVATE, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "BASTORE", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;)V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
            mv.visitVarInsn(ISTORE, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
            mv.visitVarInsn(ISTORE, 3);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popReference", "()Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitVarInsn(ASTORE, 4);
            mv.visitMethodInsn(INVOKESTATIC, "org/doovos/kernel/api/Doovos", "getMemoryManager", "()Lorg/doovos/kernel/api/memory/KMemoryManager;");
            mv.visitVarInsn(ASTORE, 5);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemoryManager", "getPointer", "(Lorg/doovos/kernel/api/memory/KReference;)Lorg/doovos/kernel/api/memory/KPointerInfo;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KPointerInfo", "getKClass", "()Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KClass", "getType", "()Lorg/doovos/kernel/api/memory/KObjectType;");
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/memory/KObjectType", "t_boolean", "Lorg/doovos/kernel/api/memory/KObjectType;");
            Label l0 = new Label();
            mv.visitJumpInsn(IF_ACMPNE, l0);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitVarInsn(ILOAD, 2);
            Label l1 = new Label();
            mv.visitJumpInsn(IFEQ, l1);
            mv.visitInsn(ICONST_1);
            Label l2 = new Label();
            mv.visitJumpInsn(GOTO, l2);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_FULL, 6, new Object[]{"KJVM_BASTORE", "org/doovos/kernel/api/jvm/interpreter/KFrame", Opcodes.INTEGER, Opcodes.INTEGER, "org/doovos/kernel/api/memory/KReference", "org/doovos/kernel/api/memory/KMemoryManager"}, 3, new Object[]{"org/doovos/kernel/api/memory/KMemoryManager", "org/doovos/kernel/api/memory/KReference", Opcodes.INTEGER});
            mv.visitInsn(ICONST_0);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_FULL, 6, new Object[]{"KJVM_BASTORE", "org/doovos/kernel/api/jvm/interpreter/KFrame", Opcodes.INTEGER, Opcodes.INTEGER, "org/doovos/kernel/api/memory/KReference", "org/doovos/kernel/api/memory/KMemoryManager"}, 4, new Object[]{"org/doovos/kernel/api/memory/KMemoryManager", "org/doovos/kernel/api/memory/KReference", Opcodes.INTEGER, Opcodes.INTEGER});
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemoryManager", "setBooleanArray", "(Lorg/doovos/kernel/api/memory/KReference;IZ)V");
            Label l3 = new Label();
            mv.visitJumpInsn(GOTO, l3);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ILOAD, 3);
            mv.visitVarInsn(ILOAD, 2);
            mv.visitInsn(I2B);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemoryManager", "setByteArray", "(Lorg/doovos/kernel/api/memory/KReference;IB)V");
            mv.visitLabel(l3);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_BASTORE", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_BASTORE", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 6);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_BASTORE", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitInsn(AALOAD);
            mv.visitFieldInsn(PUTFIELD, "KJVM_BASTORE", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "KJVM_BASTORE");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "KJVM_BASTORE", "<init>", "()V");
            mv.visitFieldInsn(PUTSTATIC, "KJVM_BASTORE", "INSTANCE", "LKJVM_BASTORE;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(2, 0);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
