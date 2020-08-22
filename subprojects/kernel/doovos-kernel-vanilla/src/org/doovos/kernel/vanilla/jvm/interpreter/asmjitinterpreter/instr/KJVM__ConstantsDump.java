package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr;

import java.util.*;

import org.objectweb.asm.*;

public class KJVM__ConstantsDump implements Opcodes {

    public byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, "org/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/instr/KJVM__Constants", null, "java/lang/Object", null);

        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_PROCESS", "Ljava/lang/String;", null, "/*02*/ KProcess currentProcess = context.getProcess()");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_MEMSEGMENT", "Ljava/lang/String;", null, "/*03*/ KMemorySegment memorySegment = context.getMemorySegment()");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_REPO", "Ljava/lang/String;", null, "/*03*/ KClassRepository repository = currentProcess.getRepository()");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_THREAD", "Ljava/lang/String;", null, "/*01*/ KThreadLocal currentThread = context.getThread()");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_MEMMANAGER", "Ljava/lang/String;", null, "/*00*/ KMemoryManager memoryManager=Doovos.getMemoryManager()");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_INT_INDEX", "Ljava/lang/String;", null, "/*00*/ int index");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_KREFERENCE_VALUE", "Ljava/lang/String;", null, "/*00*/ KReference value");
            fv.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "DEFINE_KREFERENCE_REF", "Ljava/lang/String;", null, "/*00*/ KReference ref");
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
