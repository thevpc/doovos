package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_MULTIANEWARRAYDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_MULTIANEWARRAY", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable"});

        {
            fv = cw.visitField(ACC_PRIVATE, "dims", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "typeId", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "classNameString", "Ljava/lang/String;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "([J)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "MULTIANEWARRAY", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY", "typeId", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY", "dims", "I");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getProcess", "()Lorg/doovos/kernel/api/process/KProcess;");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNONNULL, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KProcess", "getClassRepository", "()Lorg/doovos/kernel/api/jvm/reflect/KClassRepository;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "classNameString", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/reflect/KClassRepository", "getClassByName", "(Ljava/lang/String;)Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "pushClassInitializerFrame", "(Lorg/doovos/kernel/api/jvm/reflect/KClass;)Z");
            mv.visitJumpInsn(IFEQ, l0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getMethod", "()Lorg/doovos/kernel/api/jvm/reflect/KMethod;");
            mv.visitInsn(ICONST_0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KMethod", "setStatus", "(I)V");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getThread", "()Lorg/doovos/kernel/api/process/KThreadLocal;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KThreadLocal", "getFrame", "()Lorg/doovos/kernel/api/jvm/interpreter/KFrame;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getCurrentInstruction", "()Lorg/doovos/kernel/api/jvm/reflect/KInstruction;");
            mv.visitTypeInsn(CHECKCAST, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk");
            mv.visitInsn(ARETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"org/doovos/kernel/api/process/KProcess"}, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "dims", "I");
            mv.visitIntInsn(NEWARRAY, T_INT);
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "dims", "I");
            mv.visitVarInsn(ISTORE, 4);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ISTORE, 5);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_APPEND, 3, new Object[]{"[I", Opcodes.INTEGER, Opcodes.INTEGER}, 0, null);
            mv.visitVarInsn(ILOAD, 5);
            mv.visitVarInsn(ILOAD, 4);
            Label l2 = new Label();
            mv.visitJumpInsn(IF_ICMPGE, l2);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitVarInsn(ILOAD, 4);
            mv.visitVarInsn(ILOAD, 5);
            mv.visitInsn(ISUB);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(ISUB);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popInt", "()I");
            mv.visitInsn(IASTORE);
            mv.visitIincInsn(5, 1);
            mv.visitJumpInsn(GOTO, l1);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getMemorySegment", "()Lorg/doovos/kernel/api/memory/KMemorySegment;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemorySegment", "allocMultiArray", "(Lorg/doovos/kernel/api/jvm/reflect/KClass;[I)Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 6);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitInsn(AALOAD);
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KMethod", "getParentClass", "()Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KClass", "getDefinition", "()Lorg/doovos/kernel/api/jvm/bytecode/KClassDef;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "typeId", "I");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/bytecode/KClassDef", "getConstant", "(I)Ljava/lang/Object;");
            mv.visitTypeInsn(CHECKCAST, "java/lang/String");
            mv.visitFieldInsn(PUTFIELD, "KJVM_MULTIANEWARRAY", "classNameString", "Ljava/lang/String;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(4, 4);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "toJITJavaSource", "(Lorg/doovos/kernel/vanilla/jvm/interpreter/jitsrcinterpreter/JITContext;)Lorg/doovos/kernel/vanilla/jvm/interpreter/jitsrcinterpreter/JITJavaSource;", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "java/lang/IllegalArgumentException");
            mv.visitInsn(DUP);
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");
            mv.visitLdcInsn("Unsupported ");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getName", "()Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V");
            mv.visitInsn(ATHROW);
            mv.visitMaxs(4, 2);
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
            mv.visitTypeInsn(CHECKCAST, "KJVM_MULTIANEWARRAY");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "dims", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "dims", "I");
            Label l4 = new Label();
            mv.visitJumpInsn(IF_ICMPEQ, l4);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"KJVM_MULTIANEWARRAY"}, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "typeId", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "typeId", "I");
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
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "dims", "I");
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitIntInsn(BIPUSH, 31);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IMUL);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "typeId", "I");
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
            mv = cw.visitMethod(ACC_PUBLIC, "isLabel", "()Z", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNONNULL, l0);
            mv.visitInsn(ICONST_1);
            Label l1 = new Label();
            mv.visitJumpInsn(GOTO, l1);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(ICONST_0);
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{Opcodes.INTEGER});
            mv.visitInsn(IRETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "clone", "()Lorg/doovos/kernel/api/jvm/reflect/KInstruction;", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNULL, l0);
            mv.visitTypeInsn(NEW, "KJVM_MULTIANEWARRAY0");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "typeId", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "dims", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_MULTIANEWARRAY", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitMethodInsn(INVOKESPECIAL, "KJVM_MULTIANEWARRAY0", "<init>", "(IILorg/doovos/kernel/api/jvm/reflect/KClass;)V");
            mv.visitInsn(ARETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "clone", "()Lorg/doovos/kernel/api/jvm/reflect/KInstruction;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(5, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC, "clone", "()Ljava/lang/Object;", null, new String[]{"java/lang/CloneNotSupportedException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKEVIRTUAL, "KJVM_MULTIANEWARRAY", "clone", "()Lorg/doovos/kernel/api/jvm/reflect/KInstruction;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
