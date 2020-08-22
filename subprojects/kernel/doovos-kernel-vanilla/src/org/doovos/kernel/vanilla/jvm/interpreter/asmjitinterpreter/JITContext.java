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

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.Map;

public class JITContext {

    private MethodVisitor methodVisitor;
    private int locals;
    private int stack;
    private Object[] constantsPool;
    private KInstructionJIT[] instructions;
    private Map<Integer,Integer> labelsMap;
//    private Hashtable<String, String> codeMap = new Hashtable<String, String>();
//    private Stack<String> codeStack = new Stack<String>();
//    private int index = 0;

    public MethodVisitor getMethodVisitor() {
        return methodVisitor;
    }

    public int getLocals() {
        return locals;
    }

//    public void s_bipush(int i) {
//        methodVisitor.visitVarInsn(Opcodes.BIPUSH, i);
//    }

//    public void m_pop() {
//        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "pop", "()Lorg/doovos/kernel/api/memory/KRegister;");
//    }

//    public void m_popFrame() {
//        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "popFrame", "()Lorg/doovos/kernel/api/jvm/interpreter/KFrame;");
//    }

//    public void m_setLocal() {
//        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "setLocal", "(ILorg/doovos/kernel/api/memory/KRegister;)V");
//    }

//    public void m_getLocal() {
//        methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "org/doovos/kernel/api/jvm/interpreter/KFrame", "getLocal", "(I)Lorg/doovos/kernel/api/memory/KRegister;");
//    }

//    public void m_getLocal(int i) {
//        s_bipush(i);
//        m_getLocal();
//    }

    public void visitMaxs(int locals, int stack) {
        addLocals(locals);
        checkStack(stack);
    }

    public void addLocals(int inc) {
        this.locals += locals;
    }

    public void checkStack(int stack) {
        this.stack = Math.max(stack, this.stack);
    }

    public int getStack() {
        return stack;
    }
//    public void setLocals(int locals) {
//        this.locals = locals;
//    }

    public JITContext(KInstructionJIT[] instructions,Map<Integer,Integer> labelsMap,Object[] constantsPool) {
        this.instructions = instructions;
        this.labelsMap = labelsMap;
        this.constantsPool = constantsPool;
    }

    public Object[] getConstantsPool() {
        return constantsPool;
    }

    public Object getConstant(int index) {
        return constantsPool[index];
    }

    public int getLabel(int originalIndex){
        return labelsMap.get(originalIndex);
    }

    public void setMethodVisitor(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public KInstructionJIT[] getInstructions() {
        return instructions;
    }
//    public boolean isPushConsumed() {
//        int stackSize = 1;
//        int instructions_length = instructions.length;
//        for (int i = index + 1; i < instructions_length; i++) {
//
//
//            int op = instructions[i].getOperator();
//            KOperator kjvmOperator = KOperatorCodes.ALL_OPERATORS[op];
//            int pops = kjvmOperator.getPopCount();
//            int pushs = kjvmOperator.getPushCount();
//            if (pops < 0 || pushs < 0) {
//                return false;
//            }
//            stackSize = stackSize + pushs - pops;
//            if (stackSize <= 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//
////    public String getLocal(int index) {
////        String item = "local_" + index;
////        codeMap.put(item, "" + index);
////        return item;
////    }
////
////    public String setLocal(int code, String value) {
////        String item = "local_" + code;
////        codeMap.put(item, value);
////        return item + "=" + value;
////    }
//
//
//    public String pushConsumed(FutureDump dumper) {
//        if (isPushConsumed()) {
//            return push(dumper);
//        }
//        return "context.push(" + code + ");";
//    }
//
//    public String push(String code) {
//        String item = "stackItem_" + codeMap.size();
//        codeMap.put(item, code);
//        codeStack.push(item);
//        return item + " = " + code + ";";
//    }
//
//    public String pop() {
//        if (codeStack.isEmpty()) {
//            return "context.pop()";
//        }
//        return codeStack.pop();
//    }
//
//    public String prepareClass(String classPath) {
//        String v = getClassVar(classPath);
//        return "if(" + v + "==null){\n"
//                + "  " + v + "=repository.getClassByName(\"" + classPath + "\");\n"
//                + "}\n";
//    }
//
//    public String getClassVar(String className) {
//        return className.replace(";", "_").replace("/", "_").replace(".", "_");
//    }
//
//    public String getMethodVar(String methodName) {
//        return methodName.replace(";", "_").replace("/", "_").replace(".", "_").replace("(", "_").replace(")", "_");
//    }
//
//    public String popInt() {
//        if (codeStack.isEmpty()) {
//            return "context.popInt()";
//        }
//        return "((KInteger)" + codeStack.pop() + ").value";
//    }
//
//    public String popFloat() {
//        if (codeStack.isEmpty()) {
//            return "context.popFloat()";
//        }
//        return "((KFloat)" + codeStack.pop() + ").value";
//    }
//
//    public String popShort() {
//        if (codeStack.isEmpty()) {
//            return "context.popShort()";
//        }
//        return "((KShort)" + codeStack.pop() + ").value";
//    }
//
//    public String popLong() {
//        if (codeStack.isEmpty()) {
//            return "context.popLong()";
//        }
//        return "((KLong)" + codeStack.pop() + ").value";
//    }
//
//    public String popDouble() {
//        if (codeStack.isEmpty()) {
//            return "context.popDouble()";
//        }
//        return "((KDouble)" + codeStack.pop() + ").value";
//    }
//
//    public String popReference() {
//        if (codeStack.isEmpty()) {
//            return "context.popReference()";
//        }
//        return "(KReference)" + codeStack.pop();
//    }
//
//    public String peek() {
//        if (codeStack.isEmpty()) {
//            return "context.peek()";
//        }
//        return codeStack.peek();
//    }
//
//    public Hashtable<String, String> getCodeMap() {
//        return codeMap;
//    }
}
