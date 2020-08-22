package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec;

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
import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.util.JavaByteCodeUtils;
import org.doovos.kernel.core.util.IntHashMap;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;

public final class JJIT_PUTFIELD extends JJITInstructionDef {

    private int classNameIndex;
    private int fieldNameIndex;
    private int typeNameIndex;
    private String className;
    private String fieldName;
    private String typeName;

    public JJIT_PUTFIELD(Object[] constants,int cls, int fld,int typeIndex) {
        super(KOperator.PUTFIELD);
        this.classNameIndex = cls;
        this.fieldNameIndex = fld;
        this.typeNameIndex = typeIndex;
        className = (String)constants[classNameIndex];
        fieldName = (String)constants[fieldNameIndex];
        typeName = (String)constants[typeNameIndex];
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        return new JJITChanges(
                JJITChangeOp.Pop(JavaByteCodeUtils.getRegisterTypeByClassCode(typeName)),
                JJITChangeOp.POP_REF
        );
    }

    @Override
    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        r.setInstanceValue(className, fieldName, typeName);
//        final JJITName v = cl.declareAndInitKField(className, fieldName);
//        JJITName ref = r.declareRef();
//        JJITName reg = r.declareReg();
//        r.popReg(reg);
//        r.popRef(ref);
//        r.addCode(v.call("setInstanceValue", ref, reg));
    }

    @Override
    public JJITInstruction createSingleInstruction(final Object[] constantDefs, final IntHashMap labels) {
        return new Single(this);
    }



    private static class Single extends JJITInstructionSingleNext implements Cloneable{

        private transient KField kfield;
        private String className;
        private String fieldName;

        private Single(JJIT_PUTFIELD d) {
            super(d);
            this.className=d.className;
            this.fieldName=d.fieldName;
        }

        public JJITInstruction run(KFrame frame) throws Exception {
            if (kfield == null) {
                final KClass kclass = frame.getClassRepository().getClassByName(className);
                kfield = kclass.getField(fieldName, true);
            }
            final KRegister value = frame.pop();
            kfield.setInstanceValue(frame.popRef(),value);
            return next;
        }

    }


    @Override
    public String[] getLoadingClasses() {
        return new String[]{className};
    }

    @Override
    public String toString() {
        return getOperator() + "(" + className + "," + fieldName+")";
    }

    @Override
    public boolean isJump() {
        return false;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT_PUTFIELD other = (JJIT_PUTFIELD) obj;
        if (this.classNameIndex != other.classNameIndex) {
            return false;
        }
        if (this.fieldNameIndex != other.fieldNameIndex) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.classNameIndex;
        hash = 23 * hash + this.fieldNameIndex;
        return hash;
    }
}
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                new String[]{"private boolean jump;"},
//                new String[]{
//                    KJVM__Constants.DEFINE_PROCESS,},
//                "    {\n"
//                + //                        "        String className = context.getConstantString("+classNameIndex+");\n" +
//                //                        "        String attributeName = context.getConstantString("+attributeIndex+");\n" +
//                "        String className =\"" + classNameString + "\";\n"
//                + "        String attributeName =\"" + attributeString + "\";\n"
//                + "        KClassDef classByName = currentProcess.getClassRepository().getClassDefByName(className);\n"
//                + "        jump = context.initializeClass(classByName);\n"
//                + "        if (!jump) {\n"
//                + "            context.push(classByName.getStaticFieldValue(attributeName));\n"
//                + "        }"
//                + "\n    }\n", "jump? KProcess.THIS_STATEMENT : KProcess.NEXT_STATEMENT", "jump? context.getThread().getContext().getInstruction() : next",
//                null);
//    }

