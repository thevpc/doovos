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
//import java.util.Hashtable;
//import java.util.Map;
//
//public final class KJVM_LOOKUPSWITCH extends KInstructionSwitch implements Cloneable, KInstructionIf {
//    public static class GotoLable implements Cloneable {
//        int index;
//        KInstruction instruction;
//
//        public GotoLable(int index, KInstruction instruction) {
//            this.index = index;
//            this.instruction = instruction;
//        }
//
//        @Override
//        public Object clone() {
//            try {
//                return (GotoLable) super.clone();
//            } catch (CloneNotSupportedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj == null) {
//                return false;
//            }
//            if (getClass() != obj.getClass()) {
//                return false;
//            }
//            final GotoLable other = (GotoLable) obj;
//            if (this.index != other.index) {
//                return false;
//            }
//            if (this.instruction != other.instruction && (this.instruction == null || !this.instruction.equals(other.instruction))) {
//                return false;
//            }
//            return true;
//        }
//
//        @Override
//        public int hashCode() {
//            int hash = 7;
//            hash = 89 * hash + this.index;
//            hash = 89 * hash + (this.instruction != null ? this.instruction.hashCode() : 0);
//            return hash;
//        }
//
//    }
//
//    public Hashtable<Integer, GotoLable> map;
//    public KInstruction defaultInstr;
//    public int defaultLabel;
//
//    public static int runStatic(KFrame frame, KInstructionSwitch ii) throws RemoteException {
//        long[] operands = ii.getOperands();
//        int count = (int) operands[0];
//        int defaultLabel = (int) operands[count + 1];
//        Hashtable<Integer, GotoLable> map = new Hashtable<Integer, GotoLable>(count);
//        for (int i = 0; i < count; i++) {
//            int v = (int) operands[i + 1];
//            int l = (int) operands[i + 2 + count];
//            map.put(v, new GotoLable(l, null));
//        }
//        int v = frame.popInt();
//        GotoLable jumpValueI = map.get(v);
//        return jumpValueI == null ? defaultLabel : jumpValueI.index;
//    }
//
//    public KJVM_LOOKUPSWITCH(long[] operands) {
//        super(KOperator.LOOKUPSWITCH, operands);
//        int count = (int) operands[0];
//        defaultLabel = (int) operands[count + 1];
//        map = new Hashtable<Integer, GotoLable>(count);
//        for (int i = 0; i < count; i++) {
//            int v = (int) operands[i + 1];
//            int l = (int) operands[i + 2 + count];
//            map.put(v, new GotoLable(l, null));
//        }
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        int v = frame.popInt();
//        GotoLable jumpValueI = map.get(v);
//        return jumpValueI == null ? defaultLabel : jumpValueI.index;
//    }
//
//    @Override
//    public KInstruction runDirect(KFrame frame) throws RemoteException {
//        int v = frame.popInt();
//        GotoLable jumpValueI = map.get(v);
//        frame.setInstruction(jumpValueI == null ? defaultLabel : jumpValueI.index);
//        return jumpValueI == null ? defaultInstr : jumpValueI.instruction;
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        this.defaultInstr = code[defaultLabel];
//        for (Map.Entry<Integer, GotoLable> entry : map.entrySet()) {
//            entry.getValue().instruction = code[entry.getValue().index];
//        }
//    }
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        return new JITJavaSourceImpl(
//                null,
//                null,
//                new String[]{"Integer jumpValueI;"},
//                "int v = context.popInt();\n" +
//                        "GotoLable jumpValueI=map.get(v);"
//                ,
//                "jumpValueI==null?defaultInstr:jumpValueI.instruction"
//                , "jumpValueI==null?defaultInstr:jumpValueI.instruction",
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
//        KJVM_LOOKUPSWITCH that = (KJVM_LOOKUPSWITCH) o;
//
//        if (defaultLabel != that.defaultLabel) return false;
//        if (map != null ? !map.equals(that.map) : that.map != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + (map != null ? map.hashCode() : 0);
//        result = 31 * result + defaultLabel;
//        return result;
//    }
//
//    @Override
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//
//    public final void restoreLabels(int index, KInstruction[] code, KMethod method, Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        Hashtable<Integer, GotoLable> map2 = (Hashtable<Integer, GotoLable>) map.clone();
//        int x = 0;
//        int count = (int) operands[0];
//        defaultLabel = labelsMap.get(defaultLabel);
//        operands[count + 1] = defaultLabel;//labelsMap.get(defaultLabel);
//        for (Map.Entry<Integer, GotoLable> ii : map2.entrySet()) {
//            Integer v = ii.getKey();
//            GotoLable value = ii.getValue();
//            Integer l = labelsMap.get(value.index);
//            map.put(v, new GotoLable(l, null));
//            operands[x + 1] = v;
//            operands[x + count + 2] = l;
//        }
//    }
//
//    @Override
//    public final void storeLabels(Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        labelsMap.put(defaultLabel, -1);
//        for (GotoLable i : map.values()) {
//            labelsMap.put(i.index, -1);
//        }
//    }
//
//    @Override
//    public KInstruction clone() {
//        KJVM_LOOKUPSWITCH i = (KJVM_LOOKUPSWITCH) super.clone();
//        i.map = new Hashtable<Integer, GotoLable>();
//        for (Map.Entry<Integer, GotoLable> ii : map.entrySet()) {
//            i.map.put(ii.getKey(), new GotoLable(ii.getValue().index, null));
//        }
//        return i;
//    }
//
//
//}
