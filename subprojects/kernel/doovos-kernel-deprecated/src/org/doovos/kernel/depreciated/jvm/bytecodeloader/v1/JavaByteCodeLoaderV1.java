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
//package org.doovos.kernel.depreciated.jvm.bytecodeloader.v1;
//
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.memory.KObjectType;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KClassDef;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.Field;
//import java.lang.reflect.Modifier;
//import java.util.ArrayList;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.Map;
//import org.doovos.kernel.api.jvm.bytecode.JavaByteCodeLoader;
//
//public class JavaByteCodeLoaderV1 implements JavaByteCodeLoader{
//    //    private static final String STRING_JAVA_CLASS_NAME="java/lang/String";
//    //    private static final String OBJECT_JAVA_CLASS_NAME="java/lang/Object";
//    private static final String STRING_JAVA_CLASS_NAME = "java*lang*String";
//    private static final String OBJECT_JAVA_CLASS_NAME = "java*lang*Object";
//
//    private static final String STRING_JAVA_CLASS_NAME_ENCODED = "L" + STRING_JAVA_CLASS_NAME + ";";
//    private static final String OBJECT_JAVA_CLASS_NAME_ENCODED = "L" + OBJECT_JAVA_CLASS_NAME + ";";
//
////    public static void main(String[] args) {
////        FileInputStream fis = null;
////        String prefix = "/home/vpc/xprojects/apps/doovos/deploy/doovos/site1/sys/bin/classes/";
////        try {
////            try {
////                fis = new FileInputStream(prefix + "java/lang/Object.class");
//////                KClassDef def = loadClass(fis);
//////                KASMUtils.writeClassCode(def,System.out);
////
////
////                ///
////
////                ClassReader cr = new ClassReader(fis);
////                cr.accept(new ASMifierClassVisitor(new PrintWriter(System.out)),
////                        new Attribute[0],
////                        0);
////
////            } finally {
////                fis.close();
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//    public KClassDef loadClass(InputStream inputStream) throws IOException {
//        JavaClassVisitor v = new JavaClassVisitor(new DClassByteCodeInfo());
//        ClassReader r;
//        r = new ClassReader(inputStream);
//        r.accept(v, 0);
//        return v.clazz.toClassDef();
//    }
//
//    private static class JavaFieldVisitor implements FieldVisitor {
//        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
//            return null;  //To change body of implemented methods use File | Settings | File Templates.
//        }
//
//        public void visitAttribute(Attribute attr) {
//            //To change body of implemented methods use File | Settings | File Templates.
//        }
//
//        public void visitEnd() {
//            //To change body of implemented methods use File | Settings | File Templates.
//        }
//    }
//
//    private static class OnHoldLabelInfo {
//        String[] label;
//        int instructionIndex;
//        KOperator operator;
//        long[] operands;
//        int[] operandIndex;
//
//        private OnHoldLabelInfo(String[] label, int instructionIndex, KOperator operator, long[] operands, int[] operandIndex) {
//            this.label = label;
//            this.instructionIndex = instructionIndex;
//            this.operator = operator;
//            this.operands = operands;
//            this.operandIndex = operandIndex;
//        }
//    }
//
//    private static class JavaMethodVisitor implements MethodVisitor {
//        private JavaClassVisitor classVisitor;
//        private int parametersCount;
//        Hashtable<Integer, OnHoldLabelInfo> onHoldLabelInstructions = new Hashtable<Integer, OnHoldLabelInfo>();
//        Hashtable<String, Integer> labelToIndex = new Hashtable<String, Integer>();
//
//        public void visitEnd() {
//            for (Map.Entry<Integer, OnHoldLabelInfo> integerLabelEntry : onHoldLabelInstructions.entrySet()) {
//                //
//                OnHoldLabelInfo onHoldLabelInfo = integerLabelEntry.getValue();
//                int max = onHoldLabelInfo.operandIndex.length;
//                for (int i = 0; i < max; i++) {
//                    onHoldLabelInfo.operands[onHoldLabelInfo.operandIndex[i]] = labelToIndex.get(onHoldLabelInfo.label[i]);
//                }
//                getCurrentMethod().getCode().set(onHoldLabelInfo.instructionIndex,
//                        KJVMInstructions.createInstruction(onHoldLabelInfo.operator, onHoldLabelInfo.operands)
//                );
//            }
//            for (DTryCatchByteCodeInfo dTryCatchByteCodeInfo : getCurrentMethod().getTryCatchBlocs()) {
//                dTryCatchByteCodeInfo.setFrom(labelToIndex.get(dTryCatchByteCodeInfo.getFromLabel()));
//                dTryCatchByteCodeInfo.setTo(labelToIndex.get(dTryCatchByteCodeInfo.getToLabel()));
//                dTryCatchByteCodeInfo.setTarget(labelToIndex.get(dTryCatchByteCodeInfo.getTargetLabel()));
//            }
//        }
//
//        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
//            return null;
//        }
//
//        public void visitAttribute(Attribute attr) {
//            //To change body of implemented methods use File | Settings | File Templates.
//        }
//
//
//        private JavaMethodVisitor(JavaClassVisitor classVisitor, int parametersCount) {
//            this.classVisitor = classVisitor;
//            this.parametersCount = parametersCount;
//        }
//
//        public AnnotationVisitor visitAnnotationDefault() {
//            //System.out.println(new Throwable().getStackTrace()[0]);
//            return null;  //To change body of implemented methods use File | Settings | File Templates.
//        }
//
//        public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
//            //System.out.println(new Throwable().getStackTrace()[0] + " : " + parameter + " : " + desc + " : " + visible);
//            return null;  //To change body of implemented methods use File | Settings | File Templates.
//        }
//
//        public void visitCode() {
//            //System.out.println(new Throwable().getStackTrace()[0]);
//        }
//
//        public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
//            //System.out.println(new Throwable().getStackTrace()[0]);
//        }
//
//        public void visitInsn(int opcode) {
//            getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                    KOperator.valueOf(JavaOpCodes.ALL_NAMES[opcode]),
//                    new long[0]
//            ));
//            //System.out.println(new Throwable().getStackTrace()[0] + " : " + opcodeName(opcode));
//        }
//
//
//        public void visitIntInsn(int opcode, int operand) {
//            getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                    KOperator.valueOf(JavaOpCodes.ALL_NAMES[opcode]),
//                    new long[]{operand}
//            ));
//        }
//
//        DMethodByteCodeInfo getCurrentMethod() {
//            List<DMethodByteCodeInfo> methods = classVisitor.clazz.getMethods();
//            return methods.get(methods.size() - 1);
//        }
//
//        public void visitVarInsn(int opcode, int var) {
//            getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                    KOperator.valueOf(JavaOpCodes.ALL_NAMES[opcode]),
//                    new long[]{var}
//            ));
//        }
//
//        public void visitTypeInsn(int opcode, String type) {
//            int index = getConstantAsTypeName(type);
//            getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                    KOperator.valueOf(JavaOpCodes.ALL_NAMES[opcode]),
//                    new long[]{index}
//            ));
//        }
//
//        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
//            int classIndex = getConstantAsTypeName(owner);
//            int nameIndex = getConstantAsString(name);
//            //int typeIndex = getConstantAsTypeName(desc);// attribute type why needed???
//            getCurrentMethod().getCode().add(
//                    KJVMInstructions.createInstruction(
//                            KOperator.valueOf(JavaOpCodes.ALL_NAMES[opcode]),
//                            new long[]{
//                                    classIndex
//                                    , nameIndex
//                            }
//                    ));
//            //System.out.println(new Throwable().getStackTrace()[0] + " : " + opcodeName(opcode) + " ; owner=" + owner + " ; name=" + name + " ; desc=" + desc);
//        }
//
//        private int getConstantAsTypeName(String name) {
////            name = mapType0(name);
//            List<Object> constantsPool = classVisitor.clazz.getConstantsPool();
//            int index = constantsPool.indexOf(name);
//            if (index >= 0) {
//                return index;
//            }
////            classVisitor.clazz.addConstant(mapType0(name));
//            classVisitor.clazz.addConstant(name);
//            return constantsPool.size() - 1;
//        }
//
//        private int getConstantAsString(String name) {
//            List<Object> constantsPool = classVisitor.clazz.getConstantsPool();
//            int index = constantsPool.indexOf(name);
//            if (index >= 0) {
//                return index;
//            }
//            classVisitor.clazz.addConstant(name);
//            return constantsPool.size() - 1;
//        }
//
//        private int getConstantAsObject(Object value) {
//            List<Object> constantsPool = classVisitor.clazz.getConstantsPool();
//            int index = constantsPool.indexOf(value);
//            if (index >= 0) {
//                return index;
//            }
//            classVisitor.clazz.addConstant(value);
//            return constantsPool.size() - 1;
//        }
//
//
//        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
//            int t = getConstantAsObject(mapType(owner));
//            int s = getConstantAsObject(mapSignature(name, desc));
//            getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                    KOperator.valueOf(JavaOpCodes.ALL_NAMES[opcode]),
//                    new long[]{t, s}
//            ));
//        }
//
//        public void visitJumpInsn(int opcode, Label label) {
//            List<KInstruction> c = getCurrentMethod().getCode();
//            onHoldLabelInstructions.put(c.size(), new OnHoldLabelInfo(
//                    new String[]{label.toString()},
//                    c.size(),
//                    KOperator.valueOf(JavaOpCodes.ALL_NAMES[opcode]),
//                    new long[]{-1},
//                    new int[]{0}
//            ));
//            c.add(null);
//            //System.out.println(new Throwable().getStackTrace()[0] + " : " + opcodeName(opcode) + " ; label=" + label);
//        }
//
//        public void visitLabel(Label label) {
//            labelToIndex.put(label.toString(), getCurrentMethod().getCode().size());
//            //labels.add(label);
//            //System.out.println(new Throwable().getStackTrace()[0]+" ; label="+label);
//        }
//
//        public void visitLdcInsn(Object cst) {
//            if (cst instanceof Type) {
//                getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                        KOperator.LDC_W,
//                        new long[]{getConstantAsObject(((Type) cst).getDescriptor())}
//                ));
//            } else {
//                getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                        KOperator.LDC,
//                        new long[]{getConstantAsObject(cst)}
//                ));
//            }
//        }
//
//        public void visitIincInsn(int var, int increment) {
//            getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                    KOperator.IINC,
//                    new long[]{var, increment}
//            ));
//        }
//
//        public void visitTableSwitchInsn(int min, int max, Label dflt, Label[] labels) {
//            long[] values = new long[3 + labels.length];
//            values[0] = min;
//            values[1] = max;
//            String[] labelNames = new String[max - min + 2];
//            int[] labelIndices = new int[max - min + 2];
//            labelNames[0] = dflt.toString();
//            labelIndices[0] = 2;
//            int labels_length = labels.length;
//            for (int i = 0; i < labels_length; i++) {
//                labelNames[i + 1] = labels[i].toString();
//                labelIndices[i + 1] = i + 3;
//            }
//            List<KInstruction> c = getCurrentMethod().getCode();
//            onHoldLabelInstructions.put(c.size(), new OnHoldLabelInfo(
//                    labelNames,
//                    c.size(),
//                    KOperator.TABLESWITCH,
//                    values,
//                    labelIndices
//            ));
//            c.add(null);
//            //System.out.println(new Throwable().getStackTrace()[0]);
//        }
//
//        public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
//            int count = keys.length;
//            long[] values = new long[2 + count + labels.length];
//            values[0] = count;
//            for (int i = 0; i < count; i++) {
//                values[i + 1] = keys[i];
//            }
//            String[] labelNames = new String[labels.length + 1];
//            int[] labelIndices = new int[labels.length + 1];
//            labelNames[0] = dflt.toString();
//            labelIndices[0] = count + 1;
//            int labels_length = labels.length;
//            for (int i = 0; i < labels_length; i++) {
//                labelNames[i + 1] = labels[i].toString();
//                labelIndices[i + 1] = count + 2 + i;
//            }
//            List<KInstruction> c = getCurrentMethod().getCode();
//            onHoldLabelInstructions.put(c.size(), new OnHoldLabelInfo(
//                    labelNames,
//                    c.size(),
//                    KOperator.LOOKUPSWITCH,
//                    values,
//                    labelIndices
//            ));
//            c.add(null);
//        }
//
//        public void visitMultiANewArrayInsn(String desc, int dims) {
//            getCurrentMethod().getCode().add(KJVMInstructions.createInstruction(
//                    KOperator.MULTIANEWARRAY,
//                    new long[]{
//                            getConstantAsTypeName(desc),
//                            dims
//                    }
//            ));
////            System.out.println(new Throwable().getStackTrace()[0]);
//        }
//
//        public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
//            getCurrentMethod().getTryCatchBlocs().add(
//                    new DTryCatchByteCodeInfo(start.toString(), end.toString(), handler.toString(), type)
//            );
////            throw new IllegalArgumentException(getClass().getName()+" : Unsupported yet visitTryCatchBlock(Label start, Label end, Label handler, String type)");
//            //System.out.println(new Throwable().getStackTrace()[0]);
//        }
//
//        public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
//
//            DMethodByteCodeInfo m = getCurrentMethod();
//            if (Modifier.isStatic(m.getModifiers())) {
//                if (m.getParameters().size() < parametersCount && index < parametersCount) {
//                    getCurrentMethod().getParameters().add(new DParameterByteCodeInfo(index, 0, mapType(desc), name)
//                    );
//                } else {
//                    m.getVariables().add(
//                            new DVariableByteCodeInfo(name, mapType(desc), 0, index)
//                    );
//                }
//            } else {
//                if (!name.equals("this") && index < (parametersCount + 1)) {
//                    if (m.getParameters().size() < parametersCount) {
//                        getCurrentMethod().getParameters().add(
//                                new DParameterByteCodeInfo(index, 0, mapType(desc), name)
//                        );
//                    } else {
//                        m.getVariables().add(
//                                new DVariableByteCodeInfo(name, mapType(desc), 0, index)
//                        );
//                    }
//                }
//            }
//            //System.out.println(new Throwable().getStackTrace()[0] + " : name=" + name + ", desc=" + desc + ", signature=" + signature + ", index=" + index);
//        }
//
//        public void visitLineNumber(int line, Label start) {
//            //System.out.println(new Throwable().getStackTrace()[0]);
//        }
//
//        public void visitMaxs(int maxStack, int maxLocals) {
//            DMethodByteCodeInfo m = getCurrentMethod();
//            m.setMaxLocals(maxLocals);
//            m.setMaxstack(maxStack);
//            //System.out.println(new Throwable().getStackTrace()[0] + " : maxStack=" + maxStack + ", maxLocals=" + maxLocals);
//        }
//
//    }
//
//    private static class JavaClassVisitor implements ClassVisitor {
//        DClassByteCodeInfo clazz;
//
//        private JavaClassVisitor(DClassByteCodeInfo clazz) {
//            this.clazz = clazz;
//        }
//
//        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
//            clazz.setName(name.replace('/', '.'));
//            clazz.setSuperClassName(superName == null ? null : superName.replace('/', '.'));
//            ArrayList<String> ifs = new ArrayList<String>();
//            for (String inf : interfaces) {
//                ifs.add(inf.replace('/', '.'));
//            }
//            clazz.setModifiers(access);
//            clazz.setSuperInterfaceNames(ifs);
//            //System.out.println("visit (version=" + version + ", access=" + Modifier.toString(access) + ", name=" + name + ", signature=" + signature + ", superName=" + superName + ", interfaces=" + Arrays.asList(interfaces) + ")");
//            //To change body of implemented methods use File | Settings | File Templates.
//        }
//
//        public void visitSource(String source, String debug) {
//            //System.out.println("visitSource(source=" + source + ",debug=" + debug + ")");
//        }
//
//        public void visitOuterClass(String owner, String name, String desc) {
//            //System.out.println("visitOuterClass(owner=" + owner + ", name=" + name + ", desc=" + desc + ")");
//        }
//
//        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
//            //System.out.println("visitAnnotation(desc=" + desc + ", visible=" + visible + ")");
//            return null;
//        }
//
//        public void visitAttribute(Attribute attr) {
//            //System.out.println("visitAttribute(attr=" + attr + ")");
//        }
//
//        public void visitInnerClass(String name, String outerName, String innerName, int access) {
//            //System.out.println("visitInnerClass");
//        }
//
//        public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
//            clazz.getFields().add(
//                    new DFieldByteCodeInfo(
//                            access,
//                            desc,
//                            name
//                    )
//            );
//            //System.out.println("visitField");
//            return new JavaFieldVisitor();
//        }
//
//        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//            DMethodByteCodeInfo m = new DMethodByteCodeInfo();
//            m.setName(name);
//            m.setModifiers(access);
//            int indexOfEndPar = desc.indexOf(')');
//            m.setType(mapType(desc.substring(indexOfEndPar + 1)));
//            String[] types = mapMethodTypes(desc.substring(1, indexOfEndPar));
////            if(Modifier.isNative(access) || Modifier.isInterface(clazz.getModifiers())){
//            int max = 0;
//            int types_length = types.length;
//            for (int i = 0; i < types_length; i++) {
//                String type = types[i];
//                String s = mapType(type);
//                KObjectType kObjectType = KObjectType.resolveByCode(s);
//                if (kObjectType != null && kObjectType.isType2()) {
//                    max += 2;
//                } else {
//                    max++;
//                }
//                m.getParameters().add(new DParameterByteCodeInfo(i, 0, s, "param_" + i));
//            }
//            if (Modifier.isNative(access)) {
//                if (Modifier.isStatic(access)) {
//                    m.setMaxLocals(max);
//                } else {
//                    m.setMaxLocals(max + 1);
//                }
//            }
////            }
////            for (int i = 0; i < types.length; i++) {
////                String type = types[i];
////                m.getParameters().add(new DParameterByteCodeInfo(
////                        0, type, "arg"+i
////                ));
////            }
//            clazz.getMethods().add(m);
//            //System.out.println("visitMethod(access=" + access + ", name=" + name + ", desc=" + desc + ", signature=" + signature + ", exceptions=" + (exceptions == null ? null : Arrays.asList(exceptions)) + ")");
//            return new JavaMethodVisitor(this, types.length);
//        }
//
//        public void visitEnd() {
//            //System.out.println("visitEnd");
//        }
//    }
//
//    private static String mapType0(String type) {
//        if (OBJECT_JAVA_CLASS_NAME.equals(type)) {
//            return "O";
//        } else if (STRING_JAVA_CLASS_NAME.equals(type)) {
//            return "G";
//        } else {
//            return type;
//        }
//    }
//
//    private static String mapType(String type) {
//        switch (type.charAt(0)) {
//            case '[': {
//                return '[' + mapType(type.substring(1));
//            }
//            case 'L': {
//                if (OBJECT_JAVA_CLASS_NAME_ENCODED.equals(type)) {
//                    return "O";
//                } else if (STRING_JAVA_CLASS_NAME_ENCODED.equals(type)) {
//                    return "G";
//                } else {
//                    return type;
//                }
//            }
//            default: {
//                return type;
//            }
//        }
//    }
//
//    private static String mapSignature(String name, String desc) {
//        StringBuilder sb = new StringBuilder(name);
//        if (desc.equals("()")) {
//            sb.append(desc);
//        } else {
//            int i = 0;
//            StringBuilder sb2 = new StringBuilder();
//            int desc_length = desc.length();
//            while (i < desc_length) {
//                switch (desc.charAt(i)) {
//                    case 'L': {
//                        WHILE2:
//                        while (i < desc_length) {
//                            switch (desc.charAt(i)) {
//                                case ';': {
//                                    sb2.append(";");
//                                    String x = sb2.toString();
//                                    x = x.replace(STRING_JAVA_CLASS_NAME_ENCODED, "G");
//                                    x = x.replace(OBJECT_JAVA_CLASS_NAME_ENCODED, "O");
//                                    sb.append(x);
//                                    sb2.delete(0, sb2.length());
//                                    break WHILE2;
//                                }
//                                default: {
//                                    sb2.append(desc.charAt(i));
//                                    break;
//                                }
//                            }
//                            i++;
//                        }
//                        break;
//                    }
//                    default: {
//                        sb.append(desc.charAt(i));
//                    }
//                }
//                i++;
//            }
//        }
//        return sb.toString();
//    }
//
//    private static String[] mapMethodTypes(String desc) {
//        ArrayList<String> all = new ArrayList<String>();
//        int i = 0;
//        StringBuilder sb2 = new StringBuilder();
//        int desc_length = desc.length();
//        while (i < desc_length) {
//            switch (desc.charAt(i)) {
//                case 'L': {
//                    WHILE2:
//                    while (i < desc_length) {
//                        switch (desc.charAt(i)) {
//                            case ';': {
//                                sb2.append(";");
//                                String x = sb2.toString();
//                                x = x.replace(STRING_JAVA_CLASS_NAME_ENCODED, "G");
//                                x = x.replace(OBJECT_JAVA_CLASS_NAME_ENCODED, "O");
//                                all.add(x);
//                                sb2.delete(0, sb2.length());
//                                break WHILE2;
//                            }
//                            default: {
//                                sb2.append(desc.charAt(i));
//                                break;
//                            }
//                        }
//                        i++;
//                    }
//                    break;
//                }
//                case '[': {
//                    sb2.append('[');
//                    break;
//                }
//                default: {
//                    sb2.append(desc.charAt(i));
//                    all.add(sb2.toString());
//                    sb2.delete(0, sb2.length());
//                }
//            }
//            i++;
//        }
//        return all.toArray(new String[all.size()]);
//    }
//
//    private static String opcodeName(int opcode) {
//        for (Field field : JavaOpCodes.class.getFields()) {
//            try {
//                if (field.getInt(null) == opcode) {
//                    return opcode + "_" + field.getName();
//                }
//            } catch (Throwable e) {
//                e.printStackTrace();
//            }
//        }
//        return (String.valueOf(opcode));
//    }
//}
