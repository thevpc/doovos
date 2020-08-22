package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_JSRDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_JSR", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable", "org/doovos/kernel/core/jvm/interpreter/instr/groups/KInstructionJump"});

        {
            fv = cw.visitField(ACC_PUBLIC, "label", "I", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "([J)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "JSR", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitFieldInsn(PUTFIELD, "KJVM_JSR", "label", "I");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitTypeInsn(NEW, "org/doovos/kernel/api/memory/KReturn");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/api/memory/KReturn", "<init>", "(I)V");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(5, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_JSR", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            mv.visitInsn(AALOAD);
            mv.visitFieldInsn(PUTFIELD, "KJVM_JSR", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "setLabel", "(I)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "operands", "[J");
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(I2L);
            mv.visitInsn(LASTORE);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_JSR", "label", "I");
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "toJITJavaSource", "(Lorg/doovos/kernel/vanilla/jvm/interpreter/jitsrcinterpreter/JITContext;)Lorg/doovos/kernel/vanilla/jvm/interpreter/jitsrcinterpreter/JITJavaSource;", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "org/doovos/kernel/vanilla/jvm/interpreter/jitsrcinterpreter/JITJavaSourceImpl");
            mv.visitInsn(DUP);
            mv.visitInsn(ACONST_NULL);
            mv.visitInsn(ACONST_NULL);
            mv.visitInsn(ACONST_NULL);
            mv.visitLdcInsn("context.push(new KReturn(ordinal+1))");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/String", "valueOf", "(I)Ljava/lang/String;");
            mv.visitLdcInsn("next");
            mv.visitInsn(ICONST_1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
            mv.visitInsn(DUP);
            mv.visitInsn(ICONST_0);
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");
            mv.visitLdcInsn("this.next=code[");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
            mv.visitLdcInsn("]");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/jitsrcinterpreter/JITJavaSourceImpl", "<init>", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(13, 2);
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
            mv.visitTypeInsn(CHECKCAST, "KJVM_JSR");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            Label l4 = new Label();
            mv.visitJumpInsn(IF_ICMPEQ, l4);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"KJVM_JSR"}, 0, null);
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
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
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
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Hashtable", "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
            mv.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I");
            mv.visitMethodInsn(INVOKEVIRTUAL, "KJVM_JSR", "setLabel", "(I)V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 5);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_FINAL, "storeLabels", "(Ljava/util/Hashtable;)V", "(Ljava/util/Hashtable<Ljava/lang/Integer;Ljava/lang/Integer;>;)V", new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_JSR", "label", "I");
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            mv.visitInsn(ICONST_M1);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/Hashtable", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
            mv.visitInsn(POP);
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
