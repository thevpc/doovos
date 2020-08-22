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
//import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionIf;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//
//import java.rmi.RemoteException;
//import java.util.Arrays;
//import java.util.Hashtable;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 22 févr. 2009
// * Time: 14:21:52
// * To change this template use File | Settings | File Templates.
// */
//public final class KJVM_TABLESWITCH extends KInstructionSwitch implements Cloneable, KInstructionIf {
//    public int min;
//    public int max;
//    public int[] labels;
//    public KInstruction[] next;
//
//    public KJVM_TABLESWITCH(long[] operands) {
//        super(KOperator.TABLESWITCH, operands);
//        min = (int) operands[0];
//        max = (int) operands[1];
//        labels = new int[max - min + 2];
//        for (int i = 0; i < labels.length; i++) {
//            labels[i] = (int) operands[i + 2];
//        }
//    }
//
//    public static int runStatic(KFrame frame, KInstructionSwitch ii) throws RemoteException {
//        long[] operands = ii.getOperands();
//        int min;
//        int max;
//        int[] labels;
//        min = (int) operands[0];
//        max = (int) operands[1];
//        labels = new int[max - min + 2];
//        for (int i = 0; i < labels.length; i++) {
//            labels[i] = (int) operands[i + 2];
//        }
//        int v = frame.popInt();
//        return (v >= min && v <= max) ? labels[v - min + 1] : labels[0];
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        int v = frame.popInt();
//        return (v >= min && v <= max) ? labels[v - min + 1] : labels[0];
//    }
//
//    @Override
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        int v = frame.popInt();
//        if ((v >= min && v <= max)) {
//            frame.setInstruction(labels[v - min + 1]);
//            return next[v - min + 1];
//        } else {
//            frame.setInstruction(labels[0]);
//            return next[0];
//        }
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        next = new KInstruction[labels.length];
//        for (int i = 0; i < labels.length; i++) {
//            next[i] = code[labels[i]];
//        }
//    }
//
//    public void setLabel(int label, int index) {
//        operands[2 + index] = label;
//        this.labels[index] = label;
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                null,
//                new String[]{"int jumpValue;"},
//                "jumpValue = context.popInt();"
//                ,
//                "(v>=" + min + " && v<=" + max + ")? labels[v-" + (min - 1) + "] : labels[0]"
//                , "(v>=" + min + " && v<=" + max + ")? next[v-" + (min - 1) + "]:next[0]",
//                new String[]{
//                        //TODO ??????????????????????
//                        //"this.next=code["+label+"]"
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
//        KJVM_TABLESWITCH that = (KJVM_TABLESWITCH) o;
//
//        if (max != that.max) return false;
//        if (min != that.min) return false;
//        if (!Arrays.equals(labels, that.labels)) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + min;
//        result = 31 * result + max;
//        result = 31 * result + (labels != null ? Arrays.hashCode(labels) : 0);
//        return result;
//    }
//
//    @Override
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//
//    @Override
//    public final void restoreLabels(int index, KInstruction[] code, KMethod method, Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        for (int i = 0; i < labels.length; i++) {
//            int label = labels[i];
//            setLabel(labelsMap.get(label), i);
//        }
//    }
//
//    @Override
//    public final void storeLabels(Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        for (int label : labels) {
//            labelsMap.put(label, -1);
//        }
//    }
//
//    @Override
//    public KInstruction clone() {
//        KJVM_TABLESWITCH i = (KJVM_TABLESWITCH) super.clone();
//        int _max = labels.length;
//        i.labels = new int[_max];
//        System.arraycopy(labels, 0, i.labels, 0, _max);
//        if (next != null) {
//            i.next = new KInstruction[_max];
//            System.arraycopy(next, 0, i.next, 0, _max);
//        }
//        return i;
//    }
//}