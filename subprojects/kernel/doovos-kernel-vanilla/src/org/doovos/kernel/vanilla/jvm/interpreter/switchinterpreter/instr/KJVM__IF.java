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
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionIf;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceProvider;
//
//import java.rmi.RemoteException;
//import java.util.Hashtable;
//
///**
// * Created by IntelliJ IDEA.
// * User: vpc
// * Date: 12 avr. 2009
// * Time: 00:56:42
// * To change this template use File | Settings | File Templates.
// */
//public abstract class KJVM__IF extends KInstructionSwitch implements Cloneable{
//    public int label;
//    public int ordinalinc;
//    public KInstruction next;
//    public KInstruction nextLabel;
//
//    public KJVM__IF(KOperator operator, long[] operands) {
//        super(operator, operands);
//        label = (int) operands[0];
//    }
//
//    public final void setLabel(int label) {
//        operands[0] = label;
//        this.label = label;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final KJVM__IF other = (KJVM__IF) obj;
//        if (this.label != other.label) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public final int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + label;
//        return result;
//    }
//
//
//}
