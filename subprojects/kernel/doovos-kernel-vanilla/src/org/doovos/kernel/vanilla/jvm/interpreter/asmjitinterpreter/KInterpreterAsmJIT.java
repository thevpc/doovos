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

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.interpreter.KInterpreter;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr.KJVM_RETURNDump;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.instr.KJVM_XTRA_JNI;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: maiga
 * Date: May 13, 2010
 * Time: 10:50:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class KInterpreterAsmJIT implements KInterpreter {

    private static final KInstructionCompiled[] NATIVE_METHOD_CODE = {KJVM_XTRA_JNI.INSTANCE};
    final KInstructionJITInliner methodInliner = new KInstructionJITInliner();
    private KInstructionCompiled instr;
    private KLocalThread thread;

    public void init(KLocalThread thread) throws Exception {
        this.thread = thread;
    }

    public KInterpreterAsmJIT() {
    }

    public void init(KFrame frame) throws Exception {
        instr = ((KInstructionCompiled[]) frame.getInstructions())[0];
    }

    public KInstruction getCurrent(KFrame frame) throws Exception {
        return instr;
    }

    HashSet<String> ignoredMethods = new HashSet<String>(Arrays.asList(
            "java.lang.Object.registerNatives()V"
            , "java.lang.System.initializeSystemClass()V"
    ));

    public void init(KMethod method) throws Exception {
//        KInstructionDef[] defs = method.getDefinition().getCode();
        if (ignoredMethods.contains(method.getAbsoluteSignature())) {
            method.setCode(new KInstructionCompiled[]{new KJVM_RETURNDump()});
        } else {
            if (method.isNative() /*|| process.existsNativeMethod(method.getSignature())*/) {
                method.setCode(NATIVE_METHOD_CODE);
            } else {
                KMethodInfoStruct s = methodInliner.inline(method.getDefinition());
                method.setCode(s.instrunctions);
                method.setTryCatchDef(s.tryCachBlocs);
            }
        }
    }

    public void run(KFrame frame) throws Exception {
        instr = instr.run(frame);
    }
//    public KInstructionCompiled compile(KInstructionBloc bloc) throws RemoteException {
//        ClassWriter writer=new ClassWriter(0);
//        writer.visit();
//        MethodVisitor mw= cw.visitMethod(ACC_PUBLIC,"run","(Lorg/doovos/kernel/api/jvm/interpreter/KFrame;)Lorg/doovos/kernel/vanilla/jvm/interpreter/linkerinterpreter/KInstructionLnk;",null,new String[]{"java/rmi/RemoteException"});
//        for (KInstruction instruction : bloc.getInstructions()) {
//            instruction.write(mw);
//        }
//        writer.toByteArray();
//        Class<KInstructionCompiled> cls= classLoader.findClass("fff");
//        return cls.newInstance();
//
//    }

    public void close() {
        //
    }
    
}
