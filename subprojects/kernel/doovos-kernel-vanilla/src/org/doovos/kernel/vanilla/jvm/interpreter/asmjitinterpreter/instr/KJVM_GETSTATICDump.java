package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;
import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.JITContext;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITImpl;

import org.objectweb.asm.*;

public class KJVM_GETSTATICDump extends KInstructionJITImpl {

    public KJVM_GETSTATICDump() {

        // a voir
        super(KOperatorCodes.GETSTATIC, false, false);
    }




    public void produceRunMethod(JITContext context) throws Exception {

        
        
        MethodVisitor mv=context.getMethodVisitor();
        int ii= context.getLocals();

       

        {
           
           
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getProcess", "()Lorg/doovos/kernel/api/process/KProcess;");
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            Label l0 = new Label();
            mv.visitJumpInsn(IFNONNULL, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KProcess", "getClassRepository", "()Lorg/doovos/kernel/api/jvm/reflect/KClassRepository;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "classNameString", "Ljava/lang/String;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/reflect/KClassRepository", "getClassByName", "(Ljava/lang/String;)Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitFieldInsn(PUTFIELD, "KJVM_GETSTATIC", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "attributeString", "Ljava/lang/String;");
            mv.visitInsn(ICONST_1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KClass", "getField", "(Ljava/lang/String;Z)Lorg/doovos/kernel/api/jvm/reflect/KField;");
            mv.visitFieldInsn(PUTFIELD, "KJVM_GETSTATIC", "fieldByName", "Lorg/doovos/kernel/api/jvm/reflect/KField;");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "classByName", "Lorg/doovos/kernel/api/jvm/reflect/KClass;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "pushClassInitializerFrame", "(Lorg/doovos/kernel/api/jvm/reflect/KClass;)Z");
            mv.visitJumpInsn(IFEQ, l0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getThread", "()Lorg/doovos/kernel/api/process/KThreadLocal;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/process/KThreadLocal", "getFrame", "()Lorg/doovos/kernel/api/jvm/interpreter/KFrame;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getCurrentInstruction", "()Lorg/doovos/kernel/api/jvm/reflect/KInstruction;");
            mv.visitTypeInsn(CHECKCAST, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk");
            mv.visitInsn(ARETURN);
            mv.visitLabel(l0);
            mv.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"org/doovos/kernel/api/process/KProcess"}, 0, null);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "fieldByName", "Lorg/doovos/kernel/api/jvm/reflect/KField;");
            mv.visitMethodInsn(INVOKEVIRTUAL, "org/doovos/kernel/api/jvm/reflect/KField", "getStaticValue", "()Lorg/doovos/kernel/api/memory/KRegister;");
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "ordinal", "I");
            mv.visitInsn(ICONST_1);
            mv.visitInsn(IADD);
            mv.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "KJVM_GETSTATIC", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
           // mv.visitMaxs(4, 3);

            context.visitMaxs(4,3);
            //mv.visitEnd();
        }
       

    }
}
