package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.SingleClassByteArrayClassLoader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by IntelliJ IDEA.
 * User: maiga
 * Date: May 13, 2010
 * Time: 12:10:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class KJVM_FNED_Bis implements Opcodes {


    public ClassWriter cw;

    public KJVM_FNED_Bis(ClassWriter writer) {


        cw = writer;
        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL, "KJVM_FNEG", null, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk", new String[]{"java/lang/Cloneable"});


        MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;", null, new String[]{"java/rmi/RemoteException"});


        {

            mw.visitVarInsn(ALOAD, 1);
            mw.visitTypeInsn(NEW, "org/doovos/kernel/api/memory/KFloat");
            mw.visitInsn(DUP);
            mw.visitVarInsn(ALOAD, 1);


            mw.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popFloat", "()F");

            mw.visitInsn(FNEG);
            mw.visitMethodInsn(INVOKESPECIAL, "org/doovos/kernel/api/memory/KFloat", "<init>", "(F)V");
            mw.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "push", "(Lorg/doovos/kernel/api/memory/KRegister;)V");
            mw.visitVarInsn(ALOAD, 1);
            mw.visitVarInsn(ALOAD, 0);
            mw.visitFieldInsn(GETFIELD, "KJVM_FNEG", "ordinal", "I");
            mw.visitInsn(ICONST_1);
            mw.visitInsn(IADD);
            mw.visitMethodInsn(INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setInstruction", "(I)V");
            mw.visitVarInsn(ALOAD, 0);
            mw.visitFieldInsn(GETFIELD, "KJVM_FNEG", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");


            mw.visitInsn(ARETURN);
            mw.visitMaxs(4, 2);
            mw.visitEnd();


        }
        mw = cw.visitMethod(ACC_PUBLIC, "runDirect", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/api/jvm/reflect/KInstruction;", null, new String[]{"java/rmi/RemoteException"});


        {


            mw.visitInsn(ACONST_NULL);
            mw.visitInsn(ARETURN);
            mw.visitMaxs(1, 2);
            mw.visitEnd();
        }


        mw = cw.visitMethod(ACC_PUBLIC, "relink", "(I[Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;Lorg/doovos/kernel/api/jvm/reflect/KMethod;)V", null, new String[]{});

        {

            mw.visitVarInsn(ALOAD, 0);
            mw.visitVarInsn(ILOAD, 1);
            mw.visitFieldInsn(PUTFIELD, "KJVM_FNEG", "ordinal", "I");

            mw.visitVarInsn(ALOAD, 0);
            mw.visitVarInsn(ALOAD, 2);
            mw.visitVarInsn(ILOAD, 1);
            mw.visitInsn(Opcodes.ICONST_1);

            mw.visitInsn(IADD);
            mw.visitInsn(AALOAD);
            mw.visitFieldInsn(PUTFIELD, "KJVM_FNEG", "next", "Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;");
            mw.visitInsn(RETURN);
            mw.visitMaxs(4, 4);
            mw.visitEnd();


        }


    }


    public byte[] getCode() {

        return cw.toByteArray();


    }


}
