/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter;

import org.doovos.kernel.api.jvm.bytecode.KInstructionDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.mockito.asm.util.CheckClassAdapter;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author vpc
 */
public class KInstructionJITInliner {

    private static int inc = 1;
    private KInstructionJITFactory factory = new KInstructionJITFactory();

    public KMethodInfoStruct inline(KMethodDef methodDefinition) throws Exception {
        Object[] constantsPool = methodDefinition.getParentClass().getConstantsPool();
        KInstructionDef[] instructions0 = methodDefinition.getCode();
        KInstructionJIT[] instructions = new KInstructionJIT[instructions0.length];
        Map<Integer, Integer> labelsMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < instructions0.length; i++) {
            instructions[i] = factory.createInstruction(i, instructions0[i]);
            for (int j : instructions[i].getLabels()) {
                labelsMap.put(j, -1);
            }
        }
        ArrayList<ArrayList<KInstructionJIT>> blocList = new ArrayList<ArrayList<KInstructionJIT>>();
        ArrayList<KInstructionJIT> jitList = new ArrayList<KInstructionJIT>();
        KTryCatchDef[] blocs0 = methodDefinition.getTryCatchBlocs();
        for (KTryCatchDef bloc : blocs0) {
            labelsMap.put(bloc.getFrom(), -1);
            labelsMap.put(bloc.getTo(), -1);
            labelsMap.put(bloc.getTarget(), -1);
        }
        for (int i = 0; i < instructions.length; i++) {
            KInstructionJIT instruction = instructions[i];
            if (labelsMap.containsKey(i) || instruction.isLabel()) {
                if (jitList.size() > 0) {
                    blocList.add(jitList);
                    jitList = new ArrayList<KInstructionJIT>();
                }
                jitList.add(instruction);
                labelsMap.put(i, blocList.size());
            } else {
                jitList.add(instruction);
            }
            if (instruction.isJump() && jitList.size() > 0) {
                blocList.add(jitList);
                jitList = new ArrayList<KInstructionJIT>();
            }
        }
        if (jitList.size() > 0) {
            blocList.add(jitList);
        }
        jitList.clear();
        KInstructionCompiled[] compiled = new KInstructionCompiled[blocList.size()];
        for (int i = 0; i < compiled.length; i++) {
            ArrayList<KInstructionJIT> bloc = blocList.get(i);
            KInstructionJIT[] ins = bloc.toArray(new KInstructionJIT[bloc.size()]);
            KInstructionCompiled compiledInstance = compile(i,ins, labelsMap,constantsPool);
            compiled[i] = compiledInstance;
        }
        KTryCatchDef[] blocs = new KTryCatchDef[blocs0.length];
        for (int i = 0; i < blocs0.length; i++) {
            KTryCatchDef kTryCatchDef = blocs0[i];
            blocs[i] = new KTryCatchDef(
                    labelsMap.get(kTryCatchDef.getFrom()),
                    labelsMap.get(kTryCatchDef.getTo()),
                    labelsMap.get(kTryCatchDef.getTarget()),
                    kTryCatchDef.getType());
        }
//        method.setTryCatchDef(blocs);
        for (int i = 0; i < compiled.length; i++) {
            KInstructionCompiled ii = compiled[i];
            ii.configure(compiled, i);
        }
        KMethodInfoStruct ret = new KMethodInfoStruct();
        ret.instrunctions=compiled;
        ret.tryCachBlocs=blocs;
        return ret;
    }


    public KInstructionCompiled compile(int index, KInstructionJIT[] instructions, Map<Integer, Integer> labelsMap,Object[] constantsPool) throws RemoteException {
        if (instructions.length == 1) {
            KInstructionJIT ii = instructions[0];
            if (ii instanceof KInstructionCompiled) {
                return (KInstructionCompiled) ii;
            }
        }
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        MethodVisitor mv;
        final String className = "gen_class" + inc;
        inc++;


        produceConstructor(index,instructions,labelsMap,className,constantsPool,cw);
        produceRunMethod(index,instructions,labelsMap,className,constantsPool,cw);

        cw.visitEnd();


        byte[] bb = cw.toByteArray();
        PrintWriter pw = new PrintWriter(System.out);
        CheckClassAdapter.verify(new org.mockito.asm.ClassReader(cw.toByteArray()), true, pw);
        writeFile(className, className, bb);
        SingleClassByteArrayClassLoader loader = new SingleClassByteArrayClassLoader(getClass().getClassLoader(), className, bb);
        final Class<KInstructionCompiled> clz;
        try {
            clz = (Class<KInstructionCompiled>) Class.forName(className, true, loader);
            return clz.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    private void produceConstructor(int index, KInstructionJIT[] instructions, Map<Integer, Integer> labelsMap,String className,Object[] constantsPool,ClassWriter cw) {
        MethodVisitor mv;
        cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_SUPER, className, null, "org/doovos/kernel/vanilla/jvm/interpreter/asmjitinterpreter/KInstructionCompiledGen", new String[]{"java/lang/Cloneable"});
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "org/doovos/kernel/vanilla/jvm/interpreter/asmjitinterpreter/KInstructionCompiledGen", "<init>", "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();
    }
    private void produceRunMethod(int index, KInstructionJIT[] instructions, Map<Integer, Integer> labelsMap,String className,Object[] constantsPool,ClassWriter cw) {
        MethodVisitor mv;
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "run", "(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/asmjitinterpreter/KInstructionCompiled;", null, new String[]{"java/rmi/RemoteException"});
        Label labelStart = new Label();
        Label labelEnd = new Label();
        mv.visitCode();
        mv.visitLabel(labelStart);

        JITContext ctx = new JITContext(instructions, labelsMap,constantsPool);
        ctx.setMethodVisitor(mv);
        ctx.visitMaxs(2, 1);
        //  mv=ctx.getMethodVisitor();
//                    try {
//                        instructions[1].dump(ctx);
//                    } catch (Exception ex) {
//                        throw new RuntimeException(ex);
//                    }
        for (KInstructionJIT kInstructionJIT : instructions) {
            try {
                kInstructionJIT.produceRunMethod(ctx);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        mv.visitVarInsn(Opcodes.BIPUSH, index + 1);
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setProgramCounter", "(I)V");
        mv.visitVarInsn(Opcodes.ALOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getCurrentInstruction", "()Lorg/doovos/kernel/api/jvm/reflect/KInstruction;");
        mv.visitInsn(Opcodes.ARETURN);
        mv.visitLabel(labelEnd);
        mv.visitLocalVariable("next", "Lorg/doovos/kernel/api/jvm/reflect/KInstruction;", null, labelStart, labelEnd, 1);
        mv.visitMaxs(ctx.getLocals(), ctx.getStack());
        mv.visitEnd();
    }


    private void writeFile(String id, String name, byte[] bb) {
        try {
            File file = new File(name + ".class");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bb);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
