///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug;
//
//import java.io.File;
//import java.io.PrintStream;
//import java.lang.reflect.Modifier;
//import java.util.ArrayList;
//import java.util.Arrays;
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.core.util.IntHashMap;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITUtils;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControl;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITStackChange;
//import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
//
///**
// *
// * @author vpc
// */
//public class JJITDisassemblerOld {
//
//    public static void disassemble(KMethod method, JJITInstructionBloc[] instr, IntHashMap labels, JJITFlowControl flowControl,int flowControlOffset, File src) {
//        try {
//            JJITDebug debug=new JJITDebug();
//            debug.setMethodHashId(false);
//            debug.setOptCacheClasses(false);
//            debug.setOptLocal(false);
//            debug.setOptStack(false);
//            debug.setOptSubstitute(false);
//            final Object[] constPool = method.getDefinition().getParentClass().getConstantsPool();
//            ArrayList<JJITInstructionDef> all = new ArrayList<JJITInstructionDef>();
//            for (int j = 0; j < instr.length; j++) {
//                final JJITInstructionBloc b = instr[j];
//                all.add(new JJITInstructionDef(KOperator.NOP) {
//
//                    @Override
//                    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node) {
////                        cls.run().getBloc().lineComment("** START BLOC "+b.getIndex());
//                    }
//
//                    @Override
//                    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
//                        throw new UnsupportedOperationException("Not supported yet.");
//                    }
//
//                    @Override
//                    public JJITStackChange getStackChanges(JJITFlowControlNode node, int index) {
//                        throw new UnsupportedOperationException("Not supported yet.");
//                    }
//
//
//                    @Override
//                    public String toString() {
//                        return "<START_BLOCK>("+b.getIndex()+")";
//                    }
//
//
//                });
//                all.addAll(Arrays.asList(b.getInstructions()));
//                all.add(new JJITInstructionDef(KOperator.NOP) {
//
//                    @Override
//                    public JJITInstruction createSingleInstruction(Object[] constantDefs, IntHashMap labels) {
//                        throw new UnsupportedOperationException("Not supported yet.");
//                    }
//
//
//                    @Override
//                    public JJITStackChange getStackChanges(JJITFlowControlNode node, int index) {
//                        throw new UnsupportedOperationException("Not supported yet.");
//                    }
//
//                    @Override
//                    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node) {
////                        cls.run().getBloc().lineComment("** END BLOC "+b.getIndex());
//                    }
//                    @Override
//                    public String toString() {
//                        return "<END_BLOCK>("+b.getIndex()+")";
//                    }
//                });
//            }
//            final String clsName = "Disassemble";
//            final String clsPkg = JJITUtils.getPackageName(method, debug);
//            JJITClassSource a = new JJITClassSource(method.getDefinition(),clsPkg, clsName, all.toArray(new JJITInstructionDef[all.size()]), labels, constPool, 0,flowControl,flowControlOffset, debug);
//            a.build();
//            final File file = new File(src,clsPkg.replace('.', '/') + "/" + clsName + ".java");
//            file.getParentFile().mkdirs();
//            PrintStream out = new PrintStream(file);
//            a.write(out);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
