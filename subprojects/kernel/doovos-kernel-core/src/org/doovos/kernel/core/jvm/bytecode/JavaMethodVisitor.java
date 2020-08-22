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
package org.doovos.kernel.core.jvm.bytecode;

import org.doovos.kernel.api.jvm.bytecode.*;
import org.doovos.kernel.api.util.JavaByteCodeUtils;
import org.objectweb.asm.*;

import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author vpc
 */
class JavaMethodVisitor implements MethodVisitor {

    private JavaClassVisitor classVisitor;
    private KMethodDef method;
    private int parametersCount;
    Map<Integer, OnHoldLabelInfo> onHoldLabelInstructions = new HashMap<Integer, OnHoldLabelInfo>();
    Map<String, Integer> labelToIndex = new HashMap<String, Integer>();
    List<JavaMethodTryCatchBloc> tryCatchBlocs = new ArrayList<JavaMethodTryCatchBloc>();
    List<KInstructionDef> code = new ArrayList<KInstructionDef>();
    List<KParameterDef> params = new ArrayList<KParameterDef>();
    List<KVariableDef> vars = new ArrayList<KVariableDef>();
//    boolean _visitLocalVariable = false;
    Map<Integer, String> guessedVarTypes = new HashMap<Integer, String>();

    JavaMethodVisitor(KMethodDef method, JavaClassVisitor classVisitor, int parametersCount, KParameterDef[] initParams) {
        this.method = method;
        this.classVisitor = classVisitor;
        this.parametersCount = parametersCount;
        this.params.addAll(Arrays.asList(initParams));
    }

    public void visitEnd() {
        for (Map.Entry<Integer, OnHoldLabelInfo> integerLabelEntry : onHoldLabelInstructions.entrySet()) {
            //
            OnHoldLabelInfo onHoldLabelInfo = integerLabelEntry.getValue();
            int max = onHoldLabelInfo.operandIndex.length;
            for (int i = 0; i < max; i++) {
                onHoldLabelInfo.operator.operands[onHoldLabelInfo.operandIndex[i]] = labelToIndex.get(onHoldLabelInfo.label[i]);
            }
            code.set(onHoldLabelInfo.instructionIndex, onHoldLabelInfo.operator);
        }
        KInstructionDef[] codeArray = code.toArray(new KInstructionDef[code.size()]);
        method.setCode(codeArray);

        for (Map.Entry<Integer, String> e : guessedVarTypes.entrySet()) {
            Integer index = e.getKey();
            //ignore this!
            if (index == 0 && !Modifier.isStatic(method.getModifiers())) {
                //do nothing
            } else {
                boolean found = false;
                for (KVariableDef v : vars) {
                    if (v.getIndex() == index) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    vars.add(new KVariableDef("var_" + index, e.getValue(), 0, index));
                }
            }
        }

        Collections.sort(vars);
        Collections.sort(params);

        method.setVariables(vars.toArray(new KVariableDef[vars.size()]));
        method.setParameters(params.toArray(new KParameterDef[params.size()]));

        KTryCatchDef[] defs = new KTryCatchDef[tryCatchBlocs.size()];
        int i = 0;
        for (JavaMethodTryCatchBloc b : tryCatchBlocs) {
            defs[i++] = new KTryCatchDef(
                    labelToIndex.get(b.fromLabel),
                    labelToIndex.get(b.toLabel),
                    labelToIndex.get(b.targetLabel),
                    b.type);

        }
        method.setTryCatchBlocs(defs);
        method.compile();
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }

    public void visitAttribute(Attribute attr) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public AnnotationVisitor visitAnnotationDefault() {
        //System.out.println(new Throwable().getStackTrace()[0]);
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        //System.out.println(new Throwable().getStackTrace()[0] + " : " + parameter + " : " + desc + " : " + visible);
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void visitCode() {
        //System.out.println(new Throwable().getStackTrace()[0]);
    }

    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
//        System.out.println(new Throwable().getStackTrace()[0]);
    }

    public void visitInsn(int opcode) {
        code.add(new KInstructionDef(opcode));
        //System.out.println(new Throwable().getStackTrace()[0] + " : " + opcodeName(opcode));
    }

    public void visitIntInsn(int opcode, int operand) {
        code.add(new KInstructionDef(opcode, operand));
    }

    public void visitVarInsn(int opcode, int var) {
        switch (opcode) {
            case KOperatorCodes.ISTORE:
            case KOperatorCodes.ISTORE_0:
            case KOperatorCodes.ISTORE_1:
            case KOperatorCodes.ISTORE_2:
            case KOperatorCodes.ISTORE_3:
            case KOperatorCodes.ILOAD:
            case KOperatorCodes.ILOAD_0:
            case KOperatorCodes.ILOAD_1:
            case KOperatorCodes.ILOAD_2:
            case KOperatorCodes.ILOAD_3: {
                guessedVarTypes.put(var, "I");
                break;
            }
            case KOperatorCodes.LSTORE:
            case KOperatorCodes.LSTORE_0:
            case KOperatorCodes.LSTORE_1:
            case KOperatorCodes.LSTORE_2:
            case KOperatorCodes.LSTORE_3:
            case KOperatorCodes.LLOAD:
            case KOperatorCodes.LLOAD_0:
            case KOperatorCodes.LLOAD_1:
            case KOperatorCodes.LLOAD_2:
            case KOperatorCodes.LLOAD_3: {
                guessedVarTypes.put(var, "J");
                break;
            }
            case KOperatorCodes.DSTORE:
            case KOperatorCodes.DSTORE_0:
            case KOperatorCodes.DSTORE_1:
            case KOperatorCodes.DSTORE_2:
            case KOperatorCodes.DSTORE_3:
            case KOperatorCodes.DLOAD:
            case KOperatorCodes.DLOAD_0:
            case KOperatorCodes.DLOAD_1:
            case KOperatorCodes.DLOAD_2:
            case KOperatorCodes.DLOAD_3: {
                guessedVarTypes.put(var, "D");
                break;
            }
            case KOperatorCodes.FSTORE:
            case KOperatorCodes.FSTORE_0:
            case KOperatorCodes.FSTORE_1:
            case KOperatorCodes.FSTORE_2:
            case KOperatorCodes.FSTORE_3:
            case KOperatorCodes.FLOAD:
            case KOperatorCodes.FLOAD_0:
            case KOperatorCodes.FLOAD_1:
            case KOperatorCodes.FLOAD_2:
            case KOperatorCodes.FLOAD_3: {
                guessedVarTypes.put(var, "F");
                break;
            }
            case KOperatorCodes.ASTORE:
            case KOperatorCodes.ASTORE_0:
            case KOperatorCodes.ASTORE_1:
            case KOperatorCodes.ASTORE_2:
            case KOperatorCodes.ASTORE_3:
            case KOperatorCodes.ALOAD:
            case KOperatorCodes.ALOAD_0:
            case KOperatorCodes.ALOAD_1:
            case KOperatorCodes.ALOAD_2:
            case KOperatorCodes.ALOAD_3: {
                guessedVarTypes.put(var, "Ljava.lang.Object;");
                break;
            }
            case KOperatorCodes.RET:{
                //no guess applicable
                break;
            }
            default: {
                throw new IllegalArgumentException("Unsupported opcode " + opcode);
            }
        }
        code.add(new KInstructionDef(opcode, var));
    }

    public void visitTypeInsn(int opcode, String type) {
        int index = classVisitor.registerConstant(JavaByteCodeUtils.mapType(type));
        code.add(new KInstructionDef(opcode, index));
    }

    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        int classIndex = classVisitor.registerConstant(JavaByteCodeUtils.mapType(owner));
        int nameIndex = classVisitor.registerConstant(name);
        int typeIndex = classVisitor.registerConstant(desc);
        code.add(new KInstructionDef(opcode, classIndex, nameIndex, typeIndex));
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        int t = classVisitor.registerConstant(JavaByteCodeUtils.mapType(owner));
        //int s = classVisitor.registerConstant(JavaByteCodeUtils.mapSignature(name, desc));
        int s = classVisitor.registerConstant(name + desc);
        code.add(new KInstructionDef(opcode, t, s));
    }

    public void visitJumpInsn(int opcode, Label label) {
        int codeSize = code.size();
        onHoldLabelInstructions.put(codeSize,
                new OnHoldLabelInfo(
                new String[]{label.toString()}, codeSize,
                new KInstructionDef(opcode, -1),
                new int[]{0}));
        code.add(null);
        //System.out.println(new Throwable().getStackTrace()[0] + " : " + opcodeName(opcode) + " ; label=" + label);
    }

    public void visitLabel(Label label) {
        labelToIndex.put(label.toString(), code.size());
        //labels.add(label);
        //System.out.println(new Throwable().getStackTrace()[0]+" ; label="+label);
    }

    public void visitLdcInsn(Object cst) {
        if (cst instanceof Type) {
            String tt = ((Type) cst).getDescriptor();
            tt = JavaByteCodeUtils.mapType2(tt);
            code.add(new KInstructionDef(KOperatorCodes.LDC_W, classVisitor.registerConstant(tt)));
        } else {
            code.add(new KInstructionDef(KOperatorCodes.LDC, classVisitor.registerConstant(cst)));
        }
    }

    public void visitIincInsn(int var, int increment) {
        code.add(new KInstructionDef(KOperatorCodes.IINC, var, increment));
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels) {
        long[] values = new long[3 + labels.length];
        values[0] = min;
        values[1] = max;
        String[] labelNames = new String[max - min + 2];
        int[] labelIndices = new int[max - min + 2];
        labelNames[0] = dflt.toString();
        labelIndices[0] = 2;
        int labels_length = labels.length;
        for (int i = 0; i < labels_length; i++) {
            labelNames[i + 1] = labels[i].toString();
            labelIndices[i + 1] = i + 3;
        }
        int codeSize = code.size();
        onHoldLabelInstructions.put(codeSize,
                new OnHoldLabelInfo(
                labelNames,
                codeSize,
                new KInstructionDef(KOperatorCodes.TABLESWITCH, values),
                labelIndices));
        code.add(null);
        //System.out.println(new Throwable().getStackTrace()[0]);
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        int count = keys.length;
        long[] values = new long[2 + count + labels.length];
        values[0] = count;
        for (int i = 0; i < count; i++) {
            values[i + 1] = keys[i];
        }
        String[] labelNames = new String[labels.length + 1];
        int[] labelIndices = new int[labels.length + 1];
        labelNames[0] = dflt.toString();
        labelIndices[0] = count + 1;
        int labels_length = labels.length;
        for (int i = 0; i < labels_length; i++) {
            labelNames[i + 1] = labels[i].toString();
            labelIndices[i + 1] = count + 2 + i;
        }
        int codeSize = code.size();
        onHoldLabelInstructions.put(codeSize, new OnHoldLabelInfo(
                labelNames,
                codeSize,
                new KInstructionDef(KOperatorCodes.LOOKUPSWITCH, values),
                labelIndices));
        code.add(null);
    }

    public void visitMultiANewArrayInsn(String desc, int dims) {
        code.add(new KInstructionDef(KOperatorCodes.MULTIANEWARRAY, classVisitor.registerConstant(desc), dims));
//            System.out.println(new Throwable().getStackTrace()[0]);
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        tryCatchBlocs.add(new JavaMethodTryCatchBloc(start.toString(), end.toString(), handler.toString(), type));
//            throw new IllegalArgumentException(getClass().getName()+" : Unsupported yet visitTryCatchBlock(Label start, Label end, Label handler, String type)");
        //System.out.println(new Throwable().getStackTrace()[0]);
    }

    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
//        _visitLocalVariable = true;
        KMethodDef m = method;
        if (Modifier.isStatic(m.getModifiers())) {
            if (params.size() < parametersCount && index >= parametersCount) {
                params.add(new KParameterDef(name, /*JavaByteCodeUtils.mapType*/ (desc), 0, index));
            } else {
                vars.add(
                        new KVariableDef(name, /*JavaByteCodeUtils.mapType*/ (desc), 0, index));
            }
        } else {
            if (!name.equals("this") && index > parametersCount) {
                if (params.size() < parametersCount) {
                    params.add(
                            new KParameterDef(name, /*JavaByteCodeUtils.mapType*/ (desc), 0, index));
                } else {
                    vars.add(
                            new KVariableDef(name, /*JavaByteCodeUtils.mapType*/ (desc), 0, index));
                }
            }
        }
        //System.out.println(new Throwable().getStackTrace()[0] + " : name=" + name + ", desc=" + desc + ", signature=" + signature + ", index=" + index);
    }

    public void visitLineNumber(int line, Label start) {
        //System.out.println(new Throwable().getStackTrace()[0]);
    }

    public void visitMaxs(int maxStack, int maxLocals) {
        KMethodDef m = method;
        m.setMaxLocals(maxLocals);
        m.setMaxStack(maxStack);
        //System.out.println(new Throwable().getStackTrace()[0] + " : maxStack=" + maxStack + ", maxLocals=" + maxLocals);
    }
}
