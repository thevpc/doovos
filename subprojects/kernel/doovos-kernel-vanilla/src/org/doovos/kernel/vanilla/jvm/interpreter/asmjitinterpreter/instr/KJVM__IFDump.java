package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM__IFDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC, "KJVM__IF", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable", "org/doovos/kernel/core/jvm/interpreter/instr/groups/KInstructionIf"});

        {
            fv = cw.visitField(ACC_PUBLIC, "label", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC, "ordinalinc", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC, "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC, "nextLabel", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitFieldInsn(PUTFIELD, "KJVM__IF", "label", "I");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitInsn(ACONST_NULL);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "setLabel", "(I)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM__IF", "operands", "[J");
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(I2L);
            mv.visitInsn(LASTORE);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM__IF", "label", "I");
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "equals", "(Ljava/lang/Object;)Z", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            Label l0 = new Label();
            mv.visitJumpInsn(IFNONNULL, l0);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            Label l1 = new Label();
            mv.visitJumpInsn(IF_ACMPEQ, l1);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitTypeInsn(CHECKCAST, "KJVM__IF");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM__IF", "label", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM__IF", "label", "I");
            Label l2 = new Label();
            mv.visitJumpInsn(IF_ICMPEQ, l2);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"KJVM__IF"}, 0, null);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(2, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "hashCode", "()I", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "hashCode", "()I");
            mv.visitVarInsn(ISTORE, 1);
            mv.visitIntInsn(BIPUSH, 31);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IMUL);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM__IF", "label", "I");
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "isJump", "()Z", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "restoreLabels", "(I[Lorg/doovos/kernel/api/jvm/reflect/KInstruction;Lorg/doovos/kernel/api/jvm/reflect/KMethod;Ljava/util/Hashtable;)V", "(I[Lorg/doovos/kernel/api/jvm/reflect/KInstruction;Lorg/doovos/kernel/api/jvm/reflect/KMethod;Ljava/util/Hashtable<Ljava/lang/Integer;Ljava/lang/Integer;>;)V", new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM__IF", "label", "I");
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Hashtable", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
            mv.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
            mv.visitMethodInsn(INVOKEVIRTUAL, "KJVM__IF", "setLabel", "(I)V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 5);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "storeLabels", "(Ljava/util/Hashtable;)V", "(Ljava/util/Hashtable<Ljava/lang/Integer;Ljava/lang/Integer;>;)V", new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM__IF", "label", "I");
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            mv.visitInsn(ICONST_M1);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Hashtable", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
            mv.visitInsn(POP);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "relink", "(I[Lorg/doovos/kernel/api/jvm/reflect/KInstruction;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM__IF", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitFieldInsn(PUTFIELD, "KJVM__IF", "ordinalinc", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitInsn(AALOAD);
            mv.visitTypeInsn(CHECKCAST, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk");
            mv.visitFieldInsn(PUTFIELD, "KJVM__IF", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM__IF", "label", "I");
            mv.visitInsn(AALOAD);
            mv.visitTypeInsn(CHECKCAST, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk");
            mv.visitFieldInsn(PUTFIELD, "KJVM__IF", "nextLabel", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
