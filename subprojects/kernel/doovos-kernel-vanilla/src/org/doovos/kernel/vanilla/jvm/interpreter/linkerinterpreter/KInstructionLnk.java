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
//package org.doovos.kernel.vanilla.jvm.interpreter.linkerinterpreter;
//
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//
//import java.rmi.RemoteException;
//import java.util.Arrays;
//import java.util.Hashtable;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//
//public abstract class KInstructionLnk implements KInstruction {
//    private static long[] NO_OPERANDS = new long[0];
//    public KOperator operator;
//    public long[] operands;
//    public int ordinal;
//    protected KInstructionLnk next;
//
//    protected KInstructionLnk(KOperator operator) {
//        this(operator, NO_OPERANDS);
//    }
//
//    public KInstructionLnk(KOperator operator, long[] operands) {
//        this.operator = operator;
//        this.operands = operands;
////        if(!getClass().getName().endsWith("_"+operator.name())){
////            //throw new IllegalArgumentException("????????????");
////            System.out.println(getClass().getName()+" --> "+operator.name());
////        }
//    }
//
//    public abstract KInstructionLnk run(KFrame frame) throws RemoteException;
//
//    public void relink(int index, KInstructionLnk[] code, KMethod method){
//        this.ordinal = index;
//        this.next = code[index + 1];
//    }
//    
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder(operator.toString());
//        for (long operand : operands) {
//            sb.append(" ");
//            sb.append(operand);
//        }
//        return sb.toString();
//    }
//
//    @Override
//    public KInstruction clone() {
//        try {
//            KInstructionLnk kInstruction = (KInstructionLnk) super.clone();
//            int len = kInstruction.operands.length;
//            if (len > 0) {
//                long[] v = new long[len];
//                System.arraycopy(kInstruction.operands, 0, v, 0, v.length);
//                kInstruction.operands = v;
//            }
//            return kInstruction;
//        } catch (CloneNotSupportedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public KOperator getOperator() {
//        return operator;
//    }
//
//    public long[] getOperands() {
//        return operands;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        KInstructionLnk that = (KInstructionLnk) o;
//
//        if (!Arrays.equals(operands, that.operands)) return false;
//        if (operator != that.operator) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = operator.name().hashCode();
//        result = 31 * result + Arrays.hashCode(operands);
//        return result;
//    }
//
//    public void restoreLabels(int index, KInstructionLnk[] code, KMethod method, Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public void storeLabels(Hashtable<Integer, Integer> labelsMap) throws RemoteException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public boolean isJump() throws RemoteException {
//        return false;
//    }
//
//    public boolean isLabel() throws RemoteException {
//        return false;
//    }
//
//}
