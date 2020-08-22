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
//package org.doovos.kernel.vanilla.jvm.interpreter.switchinterpreter.instr;
//
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.api.memory.KReturn;
//import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionJump;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//
//import java.rmi.RemoteException;
//import java.util.Hashtable;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 22 févr. 2009
// * Time: 14:21:52
// * To change this template use File | Settings | File Templates.
// */
//public final class KJVM_JSR extends KInstructionSwitch implements Cloneable, KInstructionJump {
//    public int label;
//    public int ordinal;
//    protected KInstruction next;
//
//    public KJVM_JSR(int ordinal, long[] operands) {
//        super(KOperator.JSR, operands);
//        this.ordinal = ordinal;
//        this.label = (int) operands[0];
//    }
//
//    public static int runStatic(KFrame frame, KInstruction i) throws RemoteException {
//        int label = (int) i.getOperands()[0];
//        frame.push(new KReturn(i.getOrdinal() + 1));
//        return label;
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        frame.push(new KReturn(ordinal + 1));
//        return label;
//    }
//
//    @Override
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        frame.push(new KReturn(ordinal + 1));
//        frame.setInstruction(label);
//        return next;
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[label];
//    }
//
//    public void setLabel(int label) {
//        operands[0] = label;
//        this.label = label;
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                null, null,
//                "context.push(new KReturn(ordinal+1))"
//                , String.valueOf(label), "next", new String[]{
//                        "this.next=code[" + label + "]"
//                }
//        );
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_JSR kjvm_goto = (KJVM_JSR) o;
//
//        if (label != kjvm_goto.label) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + label;
//        return result;
//    }
//
//    @Override
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//
//    public final void restoreLabels(int index, KInstruction[] code, KMethod method, Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        setLabel(labelsMap.get(label));
//    }
//
//    @Override
//    public final void storeLabels(Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        labelsMap.put(label, -1);
//    }
//}
