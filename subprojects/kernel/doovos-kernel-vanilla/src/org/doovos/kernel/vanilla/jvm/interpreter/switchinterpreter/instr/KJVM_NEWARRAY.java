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
//import org.doovos.kernel.api.memory.KMemorySegment;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITContext;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSource;
//import org.doovos.kernel.vanilla.jvm.interpreter.jitsrcinterpreter.JITJavaSourceImpl;
//
//import java.rmi.RemoteException;
//
//public abstract class KJVM_NEWARRAY extends KInstructionSwitch implements Cloneable {
//    private int type;
//    protected KInstruction next;
//
//    public static int runStatic(KFrame frame, KInstructionSwitch ii) throws RemoteException {
//        long[] operands = ii.getOperands();
//        int type = (int) operands[0];
////        KProcess currentProcess = frame.getProcess();
//        KMemorySegment memorySegment = frame.getMemorySegment();
//        int size = frame.popInt();
//        KReference registerReference = null;
//        switch (type) {
//            case 4: {
//                registerReference = memorySegment.allocBooleanArray(size);
//                break;
//            }
//            case 5: {
//                registerReference = memorySegment.allocCharArray(size);
//                break;
//            }
//            case 6: {
//                registerReference = memorySegment.allocFloatArray(size);
//                break;
//            }
//            case 7: {
//                registerReference = memorySegment.allocDoubleArray(size);
//                break;
//            }
//            case 8: {
//                registerReference = memorySegment.allocByteArray(size);
//                break;
//            }
//            case 9: {
//                registerReference = memorySegment.allocShortArray(size);
//                break;
//            }
//            case 10: {
//                registerReference = memorySegment.allocIntArray(size);
//                break;
//            }
//            case 11: {
//                registerReference = memorySegment.allocLongArray(size);
//                break;
//            }
//        }
//        frame.push(registerReference);
//        return KProcess.NEXT_STATEMENT;
//    }
//
//    public static KJVM_NEWARRAY createInstance(long[] operands) {
//        int type = (int) operands[0];
//        switch (type) {
//            case 4: {
//                return new KJVM_NEWARRAY_4_BOOL(operands);
//            }
//            case 5: {
//                return new KJVM_NEWARRAY_5_CHAR(operands);
//            }
//            case 6: {
//                return new KJVM_NEWARRAY_6_FLOAT(operands);
//            }
//            case 7: {
//                return new KJVM_NEWARRAY_7_DOUBLE(operands);
//            }
//            case 8: {
//                return new KJVM_NEWARRAY_8_BYTE(operands);
//            }
//            case 9: {
//                return new KJVM_NEWARRAY_9_SHORT(operands);
//            }
//            case 10: {
//                return new KJVM_NEWARRAY_10_INT(operands);
//            }
//            case 11: {
//                return new KJVM_NEWARRAY_11_LONG(operands);
//            }
//        }
//        throw new IllegalArgumentException();
//
//    }
//
//    protected KJVM_NEWARRAY(long[] operands) {
//        super(KOperator.NEWARRAY, operands);
//        this.type = (int) operands[0];
//    }
//
//    public static final class KJVM_NEWARRAY_4_BOOL extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_4_BOOL(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocBooleanArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocBooleanArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//
//    }
//
//    public static final class KJVM_NEWARRAY_5_CHAR extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_5_CHAR(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocCharArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocCharArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//    }
//
//    public static final class KJVM_NEWARRAY_6_FLOAT extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_6_FLOAT(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocFloatArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocFloatArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//    }
//
//
//    public static final class KJVM_NEWARRAY_7_DOUBLE extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_7_DOUBLE(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocDoubleArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocDoubleArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//    }
//
//    public static final class KJVM_NEWARRAY_8_BYTE extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_8_BYTE(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocByteArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocByteArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//    }
//
//    public static final class KJVM_NEWARRAY_9_SHORT extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_9_SHORT(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocShortArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocShortArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//    }
//
//    public static final class KJVM_NEWARRAY_10_INT extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_10_INT(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocIntArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocIntArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//    }
//
//    public static final class KJVM_NEWARRAY_11_LONG extends KJVM_NEWARRAY implements Cloneable {
//        public KJVM_NEWARRAY_11_LONG(long[] operands) {
//            super(operands);
//        }
//
//        public int run(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocLongArray(frame.popInt()));
//            return KProcess.NEXT_STATEMENT;
//        }
//
//        public KInstruction runDirect(KFrame frame) throws RemoteException {
////            KProcess currentProcess = frame.getProcess();
//            KMemorySegment memorySegment = frame.getMemorySegment();
//            frame.push(memorySegment.allocLongArray(frame.popInt()));
//            frame.setInstruction(ordinal + 1);
//            return next;
//        }
//    }
//
//
//    public void relink(int index, KInstruction[] code, KMethod method) {
//        this.ordinal = index;
//        this.next = code[index + 1];
//    }
//
//
//    public JITJavaSource toJITJavaSource(JITContext jitContext) {
//        String fct = null;
//        switch (type) {
//            case 4: {
//                fct = "allocBooleanArray";
//                break;
//            }
//            case 5: {
//                fct = "allocCharArray";
//                break;
//            }
//            case 6: {
//                fct = "allocFloatArray";
//                break;
//            }
//            case 7: {
//                fct = "allocDoubleArray";
//                break;
//            }
//            case 8: {
//                fct = "allocByteArray";
//                break;
//            }
//            case 9: {
//                fct = "allocShortArray";
//                break;
//            }
//            case 10: {
//                fct = "allocIntArray";
//                break;
//            }
//            case 11: {
//                fct = "allocLongArray";
//                break;
//            }
//        }
//
//
//        return new JITJavaSourceImpl(
//                null,
//                null, new String[]{
//                        KJVM__Constants.DEFINE_PROCESS,
//                        KJVM__Constants.DEFINE_MEMSEGMENT
//                },
//                "    " + jitContext.pushConsumed("memorySegment." + fct + "(" + jitContext.popInt() + ")")
//                , null, null, null
//        );
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        KJVM_NEWARRAY that = (KJVM_NEWARRAY) o;
//
//        if (type != that.type) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = super.hashCode();
//        result = 31 * result + type;
//        return result;
//    }
//
//    @Override
//    public boolean isJump() throws RemoteException {
//        return true;
//    }
//}
