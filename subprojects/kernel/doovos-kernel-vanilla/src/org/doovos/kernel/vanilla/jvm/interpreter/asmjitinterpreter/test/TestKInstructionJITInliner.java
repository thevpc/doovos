/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.test;

import java.io.File;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.core.jvm.bytecode.ASMJavaByteCodeLoader;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KInstructionJITInliner;
import org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter.KMethodInfoStruct;

/**
 *
 * @author vpc
 */
public class TestKInstructionJITInliner {
    public static void main(String[] args) {
        try {
            ASMJavaByteCodeLoader x=new ASMJavaByteCodeLoader();
            KClassDef y=x.loadClass(new File("/home/vpc/Temp/jnt/scimark2/Random.class"));
            KInstructionJITInliner i=new KInstructionJITInliner();
            KMethodDef md = y.getMethods()[4];
            KMethodInfoStruct r = i.inline(md);
            System.out.println(r);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
