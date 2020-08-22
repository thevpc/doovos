package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM_INVOKEINTERFACEDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_INVOKEINTERFACE", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable"});

        {
            fv = cw.visitField(ACC_PRIVATE, "classNameIndex", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "methodNameIndex", "I", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "classNameString", "Ljava/lang/String;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "methodNameString", "Ljava/lang/String;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "interfaceName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;", null, null);
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "interfaceMethod", "Lorg/doovos/kernel/api/jvm/reflect/KMethod;", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "([J)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETSTATIC, "org/doovos/kernel/api/jvm/bytecode/KOperator", "INVOKEINTERFACE", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", "<init>", "(Lorg/doovos/kernel/api/jvm/bytecode/KOperator;[J)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitFieldInsn(PUTFIELD, "KJVM_INVOKEINTERFACE", "classNameIndex", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(LALOAD);
            mv.visitInsn(L2I);
            mv.visitFieldInsn(PUTFIELD, "KJVM_INVOKEINTERFACE", "methodNameIndex", "I");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getThread", "()Lorg/doovos/kernel/api/process/KThreadLocal;");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KThreadLocal", "getProcess", "()Lorg/doovos/kernel/api/process/KProcess;");
            mv.visitVarInsn(ASTORE, 3);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KProcess", "getClassRepository", "()Lorg/doovos/kernel/api/jvm/reflect/KClassRepository;");
            mv.visitVarInsn(ASTORE, 4);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "interfaceName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNONNULL, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "classNameString", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/reflect/KClassRepository", "getClassByName", "(Ljava/lang/String;)Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitFieldInsn(PUTFIELD, "KJVM_INVOKEINTERFACE", "interfaceName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "interfaceName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "methodNameString", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KClass", "getVirtualMethodBySignature", "(Ljava/lang/String;)Lorg/doovos/kernel/api/jvm/reflect/KMethod;");
            mv.visitFieldInsn(PUTFIELD, "KJVM_INVOKEINTERFACE", "interfaceMethod", "Lorg/doovos/kernel/api/jvm/reflect/KMethod;");
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 3, new Object[]{"org/doovos/kernel/api/process/KThreadLocal", "org/doovos/kernel/api/process/KProcess", "org/doovos/kernel/api/jvm/reflect/KClassRepository"}, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "interfaceMethod", "Lorg/doovos/kernel/api/jvm/reflect/KMethod;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KMethod", "getDefinition", "()Lorg/doovos/kernel/api/jvm/bytecode/KMethodDef;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/bytecode/KMethodDef", "getParametersCount", "()I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitTypeInsn(ANEWARRAY, "org/doovos/kernel/api/memory/KRegister");
            mv.visitVarInsn(ASTORE, 5);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitInsn(ARRAYLENGTH);
            mv.visitInsn(ICONST_1);
            mv.visitInsn(ISUB);
            mv.visitVarInsn(ISTORE, 6);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitFrame(Opcodes.F_APPEND, 2, new Object[]{"[Lorg/doovos/kernel/api/memory/KRegister;", Opcodes.INTEGER}, 0, null);
            mv.visitVarInsn(ILOAD, 6);
            Label l2 = new Label();
            mv.visitJumpInsn(IFLE, l2);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitVarInsn(ILOAD, 6);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "pop", "()Lorg/doovos/kernel/api/memory/KRegister;");
            mv.visitInsn(AASTORE);
            mv.visitIincInsn(6, -1);
            mv.visitJumpInsn(GOTO, l1);
            mv.visitLabel(l2);
            mv.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitInsn(ICONST_0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popReference", "()Lorg/doovos/kernel/api/memory/KReference;");
            mv.visitInsn(AASTORE);
            mv.visitMethodInsn(INVOKESTATIC, "org/doovos/kernel/api/Doovos", "getMemoryManager", "()Lorg/doovos/kernel/api/memory/KMemoryManager;");
            mv.visitVarInsn(ALOAD, 5);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(AALOAD);
            mv.visitTypeInsn(CHECKCAST, "org/doovos/kernel/api/memory/KReference");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KMemoryManager", "getPointer", "(Lorg/doovos/kernel/api/memory/KReference;)Lorg/doovos/kernel/api/memory/KPointerInfo;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/memory/KPointerInfo", "getKClass", "()Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ASTORE, 6);
            mv.visitVarInsn(ALOAD, 6);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "methodNameString", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KClass", "getVirtualMethodBySignature", "(Ljava/lang/String;)Lorg/doovos/kernel/api/jvm/reflect/KMethod;");
            mv.visitVarInsn(ASTORE, 7);
            mv.visitVarInsn(ALOAD, 4);
            mv.visitVarInsn(ALOAD, 7);
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KMethod", "getClassName", "()Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/reflect/KClassRepository", "getClassByName", "(Ljava/lang/String;)Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ASTORE, 8);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 8);
            mv.visitVarInsn(ALOAD, 7);
            mv.visitVarInsn(ALOAD, 5);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KThreadLocal", "pushFrame", "(Lorg/doovos/kernel/api/jvm/reflect/KClass;Lorg/doovos/kernel/api/jvm/reflect/KMethod;[Lorg/doovos/kernel/api/memory/KRegister;)Lorg/doovos/kernel/api/jvm/interpreter/KFrame;");
            mv.visitInsn(POP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KThreadLocal", "getFrame", "()Lorg/doovos/kernel/api/jvm/interpreter/KFrame;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getCurrentInstruction", "()Lorg/doovos/kernel/api/jvm/reflect/KInstruction;");
            mv.visitTypeInsn(CHECKCAST, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(4, 9);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "KJVM_INVOKEINTERFACE", "ordinal", "I");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KMethod", "getParentClass", "()Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KClass", "getDefinition", "()Lorg/doovos/kernel/api/jvm/bytecode/KClassDef;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "classNameIndex", "I");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/bytecode/KClassDef", "getConstant", "(I)Ljava/lang/Object;");
            mv.visitTypeInsn(CHECKCAST, "java/lang/String");
            mv.visitFieldInsn(PUTFIELD, "KJVM_INVOKEINTERFACE", "classNameString", "Ljava/lang/String;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 3);
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KMethod", "getParentClass", "()Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KClass", "getDefinition", "()Lorg/doovos/kernel/api/jvm/bytecode/KClassDef;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "methodNameIndex", "I");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/bytecode/KClassDef", "getConstant", "(I)Ljava/lang/Object;");
            mv.visitTypeInsn(CHECKCAST, "java/lang/String");
            mv.visitFieldInsn(PUTFIELD, "KJVM_INVOKEINTERFACE", "methodNameString", "Ljava/lang/String;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(3, 4);
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
            mv.visitTypeInsn(CHECKCAST, "KJVM_INVOKEINTERFACE");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "classNameIndex", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "classNameIndex", "I");
            Label l4 = new Label();
            mv.visitJumpInsn(IF_ICMPEQ, l4);
            mv.visitInsn(ICONST_0);
            mv.visitInsn(IRETURN);
            mv.visitLabel(l4);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"KJVM_INVOKEINTERFACE"}, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "methodNameIndex", "I");
            mv.visitVarInsn(ALOAD, 2);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "methodNameIndex", "I");
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
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "classNameIndex", "I");
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitIntInsn(BIPUSH, 31);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IMUL);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "methodNameIndex", "I");
            mv.visitInsn(IADD);
            mv.visitVarInsn(ISTORE, 1);
            mv.visitVarInsn(ILOAD, 1);
            mv.visitInsn(IRETURN);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "toString", "()Ljava/lang/String;", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "operator", "Lorg/doovos/kernel/api/jvm/bytecode/KOperator;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/bytecode/KOperator", "toString", "()Ljava/lang/String;");
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "(Ljava/lang/String;)V");
            mv.visitVarInsn(ASTORE, 1);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn(" ");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitInsn(POP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "classNameString", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitInsn(POP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn(" ");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitInsn(POP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_INVOKEINTERFACE", "methodNameString", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
            mv.visitInsn(POP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 2);
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
        cw.visitEnd();

        return cw.toByteArray();
    }
}
