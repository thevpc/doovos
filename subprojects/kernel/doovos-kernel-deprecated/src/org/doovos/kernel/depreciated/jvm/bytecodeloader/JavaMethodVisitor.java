///**
// * ====================================================================
// *             Doovos (Distributed Object Oriented Operating System)
// *
// * Doovos is a new Open Source Distributed Object Oriented Operating System
// * Design and implementation based on the Java Platform.
// * Actually, it is a try for designing a distributed operation system in
// * top of existing centralized/network OS.
// * Designed OS will follow the object oriented architecture for redefining
// * all OS resources (memory,process,file system,device,...etc.) in a highly
// * distributed context.
// * Doovos is also a distributed Java virtual machine that implements JVM
// * specification on top the distributed resources context.
// *
// * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
// * Doovos Kernel code is executed on host JVM
// *
// * Copyright (C) 2008-2010 Taha BEN SALAH
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc.,
// * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// * ====================================================================
// */
//package org.doovos.kernel.depreciated.jvm.bytecodeloader;
//
//import org.doovos.kernel.api.jvm.bytecode.*;
//import org.objectweb.asm.*;
//
//import java.lang.reflect.Modifier;
//import java.util.*;
//
///**
// * @author vpc
// */
//class JavaMethodVisitor implements MethodVisitor {
//
//    private JavaClassVisitor classVisitor;
//    private KMethodDef method;
//    private int parametersCount;
//    Hashtable<Integer, OnHoldLabelInfo> onHoldLabelInstructions = new Hashtable<Integer, OnHoldLabelInfo>();
//    Hashtable<String, Integer> labelToIndex = new Hashtable<String, Integer>();
//    List<JavaMethodTryCatchBloc> tryCatchBlocs = new ArrayList<JavaMethodTryCatchBloc>();
//    List<KInstructionDef> code = new ArrayList<KInstructionDef>();
//    List<KParameterDef> params = new ArrayList<KParameterDef>();
//    List<KVariableDef> vars = new ArrayList<KVariableDef>();
//
//    JavaMethodVisitor(KMethodDef method, JavaClassVisitor classVisitor, int parametersCount, KParameterDef[] initParams) {
//        this.method = method;
//        this.classVisitor = classVisitor;
//        this.parametersCount = parametersCount;
//        this.params.addAll(Arrays.asList(initParams));
//    }
//
//    public void visitEnd() {
//        for (Map.Entry<Integer, OnHoldLabelInfo> integerLabelEntry : onHoldLabelInstructions.entrySet()) {
//            //
//            OnHoldLabelInfo onHoldLabelInfo = integerLabelEntry.getValue();
//            int max = onHoldLabelInfo.operandIndex.length;
//            for (int i = 0; i < max; i++) {
//                onHoldLabelInfo.operator.operands[onHoldLabelInfo.operandIndex[i]] = labelToIndex.get(onHoldLabelInfo.label[i]);
//            }
//            code.set(onHoldLabelInfo.instructionIndex, onHoldLabelInfo.operator);
//        }
//        method.setCode(code.toArray(new KInstructionDef[code.size()]));
//
//        Collections.sort(vars);
//        Collections.sort(params);
//
//        method.setVariables(vars.toArray(new KVariableDef[vars.size()]));
//        method.setParameters(params.toArray(new KParameterDef[params.size()]));
//
//        KTryCatchDef[] defs = new KTryCatchDef[tryCatchBlocs.size()];
//        int i = 0;
//        for (JavaMethodTryCatchBloc b : tryCatchBlocs) {
//            defs[i++] = new KTryCatchDef(
//                    labelToIndex.get(b.fromLabel),
//                    labelToIndex.get(b.toLabel),
//                    labelToIndex.get(b.targetLabel),
//                    b.type);
//
//        }
//        method.setTryCatchBlocs(defs);
//        method.compile();
//    }
//
//    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
//        return null;
//    }
//
//    public void visitAttribute(Attribute attr) {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public AnnotationVisitor visitAnnotationDefault() {
//        //System.out.println(new Throwable().getStackTrace()[0]);
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
//        //System.out.println(new Throwable().getStackTrace()[0] + " : " + parameter + " : " + desc + " : " + visible);
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public void visitCode() {
//        //System.out.println(new Throwable().getStackTrace()[0]);
//    }
//
//    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
//        //System.out.println(new Throwable().getStackTrace()[0]);
//    }
//
//    public void visitInsn(int opcode) {
//        code.add(new KInstructionDef(KOperatorCodes.ALL_OPERATORS[opcode]));
//        //System.out.println(new Throwable().getStackTrace()[0] + " : " + opcodeName(opcode));
//    }
//
//    public void visitIntInsn(int opcode, int operand) {
//        code.add(new KInstructionDef(KOperatorCodes.ALL_OPERATORS[opcode], operand));
//    }
//
//    public void visitVarInsn(int opcode, int var) {
//        code.add(new KInstructionDef(KOperatorCodes.ALL_OPERATORS[opcode], var));
//    }
//
//    public void visitTypeInsn(int opcode, String type) {
//        int index = classVisitor.registerConstant(JavaByteCodeUtils.mapType(type));
//        code.add(new KInstructionDef(KOperatorCodes.ALL_OPERATORS[opcode], index));
//    }
//
//    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
//        int classIndex = classVisitor.registerConstant(JavaByteCodeUtils.mapType(owner));
//        int nameIndex = classVisitor.registerConstant(name);
//        code.add(new KInstructionDef(KOperatorCodes.ALL_OPERATORS[opcode], classIndex, nameIndex));
//    }
//
//    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
//        int t = classVisitor.registerConstant(JavaByteCodeUtils.mapType(owner));
//        //int s = classVisitor.registerConstant(JavaByteCodeUtils.mapSignature(name, desc));
//        int s = classVisitor.registerConstant(name+desc);
//        code.add(new KInstructionDef(KOperatorCodes.ALL_OPERATORS[opcode], t, s));
//    }
//
//    public void visitJumpInsn(int opcode, Label label) {
//        int codeSize = code.size();
//        onHoldLabelInstructions.put(codeSize,
//                new OnHoldLabelInfo(
//                        new String[]{label.toString()}, codeSize,
//                        new KInstructionDef(KOperatorCodes.ALL_OPERATORS[opcode], -1),
//                        new int[]{0}));
//        code.add(null);
//        //System.out.println(new Throwable().getStackTrace()[0] + " : " + opcodeName(opcode) + " ; label=" + label);
//    }
//
//    public void visitLabel(Label label) {
//        labelToIndex.put(label.toString(), code.size());
//        //labels.add(label);
//        //System.out.println(new Throwable().getStackTrace()[0]+" ; label="+label);
//    }
//
//    public void visitLdcInsn(Object cst) {
//        if (cst instanceof Type) {
//            String tt = ((Type) cst).getDescriptor();
//            tt=JavaByteCodeUtils.mapType2(tt);
//            code.add(new KInstructionDef(KOperator.LDC_W, classVisitor.registerConstant(tt)));
//        } else {
//            code.add(new KInstructionDef(KOperator.LDC, classVisitor.registerConstant(cst)));
//        }
//    }
//
//    public void visitIincInsn(int var, int increment) {
//        code.add(new KInstructionDef(KOperator.IINC, var, increment));
//    }
//
//    public void visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels) {
//        long[] values = new long[3 + labels.length];
//        values[0] = min;
//        values[1] = max;
//        String[] labelNames = new String[max - min + 2];
//        int[] labelIndices = new int[max - min + 2];
//        labelNames[0] = dflt.toString();
//        labelIndices[0] = 2;
//        int labels_length = labels.length;
//        for (int i = 0; i < labels_length; i++) {
//            labelNames[i + 1] = labels[i].toString();
//            labelIndices[i + 1] = i + 3;
//        }
//        int codeSize = code.size();
//        onHoldLabelInstructions.put(codeSize,
//                new OnHoldLabelInfo(
//                        labelNames,
//                        codeSize,
//                        new KInstructionDef(KOperator.TABLESWITCH, values),
//                        labelIndices));
//        code.add(null);
//        //System.out.println(new Throwable().getStackTrace()[0]);
//    }
//
//    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
//        int count = keys.length;
//        long[] values = new long[2 + count + labels.length];
//        values[0] = count;
//        for (int i = 0; i < count; i++) {
//            values[i + 1] = keys[i];
//        }
//        String[] labelNames = new String[labels.length + 1];
//        int[] labelIndices = new int[labels.length + 1];
//        labelNames[0] = dflt.toString();
//        labelIndices[0] = count + 1;
//        int labels_length = labels.length;
//        for (int i = 0; i < labels_length; i++) {
//            labelNames[i + 1] = labels[i].toString();
//            labelIndices[i + 1] = count + 2 + i;
//        }
//        int codeSize = code.size();
//        onHoldLabelInstructions.put(codeSize, new OnHoldLabelInfo(
//                labelNames,
//                codeSize,
//                new KInstructionDef(KOperator.LOOKUPSWITCH, values),
//                labelIndices));
//        code.add(null);
//    }
//
//    public void visitMultiANewArrayInsn(String desc, int dims) {
//        code.add(new KInstructionDef(KOperator.MULTIANEWARRAY, classVisitor.registerConstant(desc), dims));
////            System.out.println(new Throwable().getStackTrace()[0]);
//    }
//
//    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
//        tryCatchBlocs.add(new JavaMethodTryCatchBloc(start.toString(), end.toString(), handler.toString(), type));
////            throw new IllegalArgumentException(getClass().getName()+" : Unsupported yet visitTryCatchBlock(Label start, Label end, Label handler, String type)");
//        //System.out.println(new Throwable().getStackTrace()[0]);
//    }
//
//    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
//
//        KMethodDef m = method;
//        if (Modifier.isStatic(m.getModifiers())) {
//            if (params.size() < parametersCount && index < parametersCount) {
//                params.add(new KParameterDef(name, /*JavaByteCodeUtils.mapType*/(desc), 0, index));
//            } else {
//                vars.add(
//                        new KVariableDef(name, /*JavaByteCodeUtils.mapType*/(desc), 0, index));
//            }
//        } else {
//            if (!name.equals("this") && index < (parametersCount + 1)) {
//                if (params.size() < parametersCount) {
//                    params.add(
//                            new KParameterDef(name, /*JavaByteCodeUtils.mapType*/(desc), 0, index));
//                } else {
//                    vars.add(
//                            new KVariableDef(name, /*JavaByteCodeUtils.mapType*/(desc), 0, index));
//                }
//            }
//        }
//        //System.out.println(new Throwable().getStackTrace()[0] + " : name=" + name + ", desc=" + desc + ", signature=" + signature + ", index=" + index);
//    }
//
//    public void visitLineNumber(int line, Label start) {
//        //System.out.println(new Throwable().getStackTrace()[0]);
//    }
//
//    public void visitMaxs(int maxStack, int maxLocals) {
//        KMethodDef m = method;
//        m.setMaxLocals(maxLocals);
//        m.setMaxStack(maxStack);
//        //System.out.println(new Throwable().getStackTrace()[0] + " : maxStack=" + maxStack + ", maxLocals=" + maxLocals);
//    }
//}
