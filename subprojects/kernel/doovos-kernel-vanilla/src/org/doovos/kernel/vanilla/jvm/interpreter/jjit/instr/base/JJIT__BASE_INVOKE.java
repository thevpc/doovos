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
 * with this program; if not, writeSource to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.api.util.JavaByteCodeUtils;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeModel;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChanges;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITChangeOp;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITClassSource;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceInit;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.JJITMethodSourceRun;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITConstant;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpressionImpl;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITExpression;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITName;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITNewArr;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.expr.JJITType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Calls;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Fields;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.helpers.Types;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITBloc;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITIf;

public abstract class JJIT__BASE_INVOKE extends JJITInstructionDef {

    protected String className;
    protected String methodName;
    protected int classNameIndex;
    protected int methodNameIndex;
    protected Object[] constants;

    public JJIT__BASE_INVOKE(KOperator op, Object[] constants, int classNameIndex, int methodNameIndex) {
        super(op);
        this.classNameIndex = classNameIndex;
        this.methodNameIndex = methodNameIndex;
        className = (String) constants[classNameIndex];
        methodName = (String) constants[methodNameIndex];
    }

    @Override
    public JJITChanges getChanges(JJITChangeModel model) {
        String[] paramsTypes = JavaByteCodeUtils.getMethodTypeCodes(methodName);
        String rt = JavaByteCodeUtils.getReturnType(methodName);
        KRegisterType rtt = JavaByteCodeUtils.getRegisterTypeByClassCode(rt);
        //[] r = rtt == null ? null : new KRegisterType[]{rtt};
        JJITChangeOp[] p;
        if (operator == KOperator.INVOKESTATIC) {
            p = new JJITChangeOp[paramsTypes.length + (rtt == null ? 0 : 1)];
            for (int i = 0; i < paramsTypes.length; i++) {
                p[i] = JJITChangeOp.Pop(JavaByteCodeUtils.getRegisterTypeByClassCode(paramsTypes[paramsTypes.length - i - 1]));
            }
            if (rtt != null) {
                p[paramsTypes.length] = JJITChangeOp.Push(JavaByteCodeUtils.getRegisterTypeByClassCode(rt));
            }
        } else {
            p = new JJITChangeOp[paramsTypes.length + 1 + (rtt == null ? 0 : 1)];
            for (int i = 0; i < paramsTypes.length; i++) {
                p[i] = JJITChangeOp.Pop(JavaByteCodeUtils.getRegisterTypeByClassCode(paramsTypes[paramsTypes.length - i - 1]));
            }
            p[paramsTypes.length] = JJITChangeOp.POP_REF;//this
            if (rtt != null) {
                p[paramsTypes.length + 1] = JJITChangeOp.Push(JavaByteCodeUtils.getRegisterTypeByClassCode(rt));
            }
        }
        return new JJITChanges(p);
    }

    @Override
    public String[] getLoadingClasses() {
        return new String[]{className};
    }

    public void visitImpl(JJITClassSource cls, JJITFlowControlNode node, int relativeIndex) {
        final JJITMethodSourceRun r = cls.run();
        //final String classNameString = (String) cls.getConstants()[classNameIndex];
        int paramsCount = JavaByteCodeUtils.getParametersCount(methodName);
        //final JJITExpressionImpl params = r.addRunInstanceMethodParams( classNameString, methodNameString);
        int paramsCountOk = paramsCount + ((operator == KOperator.INVOKESTATIC) ? 0 : 1);
        final JJITExpression params = JJITConstant.asInt(paramsCountOk);

        JJITName regs = r.declareRegs();
        r.set(regs, paramsCountOk>0?new JJITNewArr(new JJITType(Types.KREGISTER), params):new JJITType(Types.KREGISTER).field(Fields.KRegister_EMPTY_ARRAY));
        JJITName thread = r.declareThread();
        JJITExpressionImpl meth = null;

        if (operator == KOperator.INVOKESTATIC) {
            for (int j = paramsCount - 1; (j >= 0); j--) {
                r.set(regs.arr(j), r.pop());
            }
            meth = r.declareAndInitKMethod(className, methodName);
            r.addCode(r.frame().call(Calls.KFrame_setProgramCounter, cls.getBlocIndex() + 1));
            JJITName nextFrame = r.declareNextFrame();
            r.set(nextFrame, thread.call(Calls.KThread_pushFrame, meth, regs));
            r.Return(nextFrame.call(Calls.KFrame_getCurrentInstruction).cast(Types.JJITINSTRUCTION));
        } else if (operator == KOperator.INVOKEVIRTUAL || operator == KOperator.INVOKEINTERFACE) {
            for (int j = paramsCount; (j > 0); j--) {
                r.set(regs.arr(j), r.pop());
            }
            JJITName ref = r.declareRef();
            r.set(ref, r.popRef());
            r.set(regs.arr(0), ref);
            JJITName memman = r.declareMemMan();
            meth = memman.call(Calls.MemoryManager_getKClass, ref).call(Calls.KClass_getVirtualMethodBySignature, methodName);
            r.addCode(r.frame().call(Calls.KFrame_setProgramCounter, cls.getBlocIndex() + 1));
            JJITName nextFrame = r.declareNextFrame();
            r.set(nextFrame, thread.call(Calls.KThread_pushFrame, meth, regs));
            r.Return(nextFrame.call(Calls.KFrame_getCurrentInstruction).cast(Types.JJITINSTRUCTION));
        } else {
            JJITMethodSourceInit init = cls.init();
            JJITName next = cls.declareFieldNext();
            init.set(next, init.instructions().arr(init.index().add(1)));
            meth = r.declareAndInitKMethodIgnore(className, methodName);
            JJITName ignore=new JJITName(((JJITName)meth).getValue()+"_ignorable","boolean");
            for (int j = paramsCount; (j > 0); j--) {
                r.set(regs.arr(j), r.pop());
            }
            JJITName ref = r.declareRef();
            r.set(ref, r.popRef());
            r.set(regs.arr(0), ref);
            JJITName varInstr = r.declareNextInstr();
            JJITIf If = r.If(ignore);
            JJITBloc WhenIgnorableBloc = If.Then();
            JJITBloc WhenNonIgnorableBloc = If.Else();

            WhenNonIgnorableBloc.addCode(r.frame().call(Calls.KFrame_setProgramCounter, cls.getBlocIndex() + 1));
            JJITName nextFrame = r.declareNextFrame();
            WhenNonIgnorableBloc.set(nextFrame, thread.call(Calls.KThread_pushFrame, meth, regs));
            WhenNonIgnorableBloc.set(varInstr, nextFrame.call(Calls.KFrame_getCurrentInstruction).cast(Types.JJITINSTRUCTION));
            WhenIgnorableBloc.set(varInstr, next);
            r.Return(varInstr);
        }
        //return cls;
        //r.declareAndReturnNext();
    }

    @Override
    public String toString() {
        return getOperator() + "(" + className + "," + methodName + ")";
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT__BASE_INVOKE other = (JJIT__BASE_INVOKE) obj;
        if (this.classNameIndex != other.classNameIndex) {
            return false;
        }
        if (this.methodNameIndex != other.methodNameIndex) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.classNameIndex;
        hash = 97 * hash + this.methodNameIndex;
        return hash;
    }
}
//            KClass kClass = ;
//            if (kClass.isArray()) {
//                kClass = repository.getClassByName("java.lang.Object");
//            }
//            KMethod implMethod = kClass.getVirtualMethodBySignature(methodNameString);
////            KClass implClass = repository.getClassByName(implMethod.getClassName());
//            t.pushFrame(implMethod, args);
//
//            t.pushClassInitializerFrame(classByName);
//
//        a.addRunLine("t.pushFrame(methodByName, args);");
//        return new JITJavaSourceImpl(
//                new String[]{"java.util.NoSuchElementException"},
//                null, new String[]{
//                        KJVM__Constants.DEFINE_THREAD,
//                        KJVM__Constants.DEFINE_PROCESS,
//                        KJVM__Constants.DEFINE_MEMMANAGER
//                },
//                "    {\n"
//                        +
////                        "        KReference classNameReg = (KReference) context.getConstant("+classNameIndex+");\n" +
////                        "        String className = memoryManager.getStringChars(classNameReg);\n" +
////                        "\n" +
////                        "        KReference methodNameReg = (KReference) context.getConstant("+methodNameIndex+");\n" +
////                        "        String methodName = memoryManager.getStringChars(methodNameReg);\n" +
////                        "\n" +
//                        "        KClassDef dpc = currentProcess.getClassByNameName(\"" + classNameString + "\",0).getDefinition();\n" +
////                        "        KClassDef dpc = currentProcess.getClassRepository().getClassDefByName(className.replace('/', '.'));\n" +
//                        "        //TODO normalement on doit recuperer la methode depuis l'instance de l'objet!!\n" +
//                        "        KMethodDef method = dpc.getVirtualMethodBySignature(\"" + methodNameString + "\");\n" +
//                        "        if (method == null) {\n" +
//                        "         throw new NoSuchElementException(\"method " + methodNameString + " in " + classNameString + "\");\n" +
//                        "        }\n" +
//                        "        KRegister[] args = new KRegister[method.getParametersCount() + 1];\n" +
//                        "        for (int j = args.length - 1; j > 0; j--) {\n" +
//                        "            args[j] = context.pop();\n" +
//                        "        }\n" +
//                        "        KReference ref = context.popReference();\n" +
//                        "        args[0] = ref;//this reference\n" +
//                        "        context.setInstruction(getOrdinal()+1);\n" +
//                        "        KFrame newContext = currentThread.pushFrame(currentProcess.getClassRepository().getClassDefByName(method.getClassName()), method, args);\n" +
//                        "        //**LOG**//log(i.operator, context, className + \".\" + methodName + \"[\" + Arrays.asList(args) + \"]\");\n" +
//                        "        context.initializeClass(dpc);\n" +
//                        "        context.setInstruction(getOrdinal()+1);\n"
//                        + "\n    }"
//                , null, "context.getThread().getContext().getInstruction()", null
//        );
//        return a;

