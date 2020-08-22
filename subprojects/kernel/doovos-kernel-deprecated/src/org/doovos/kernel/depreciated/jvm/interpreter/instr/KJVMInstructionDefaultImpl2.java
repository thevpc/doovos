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
//package org.doovos.kernel.depreciated.jvm.interpreter.instr;
//
//import org.doovos.kernel.api.jvm.bytecode.KOperator;
//import org.doovos.kernel.api.memory.KRegister;
//import org.doovos.kernel.api.memory.KInteger;
//import org.doovos.kernel.api.memory.KShort;
//import org.doovos.kernel.api.memory.KChar;
//import org.doovos.kernel.api.memory.KByte;
//import org.doovos.kernel.api.memory.KFloat;
//import org.doovos.kernel.api.memory.KDouble;
//import org.doovos.kernel.api.memory.KLong;
//import org.doovos.kernel.api.memory.KReference;
//import org.doovos.kernel.api.Doovos;
//import org.doovos.kernel.api.jvm.interpreter.KFrame;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.jvm.interpreter.KEndOfThreadException;
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//
//import java.rmi.RemoteException;
//import org.doovos.kernel.api.jvm.reflect.KMethod;
//import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;
//
//public final class KJVMInstructionDefaultImpl2 extends KInstructionIdx {
//    public KJVMInstructionDefaultImpl2(KOperator operator, long[] operands) {
//        super(operator, operands);
//    }
//
//    public int run(KFrame frame) throws RemoteException {
//        try {
//            switch (this.operator) {
//                case D2F: {
//                    double value = frame.popDouble();
//                    KFloat reg = new KFloat((float) value);
//                    frame.push(reg);
//                    //**LOG**//log(i.operator, context, value + "=>" + reg.toString());
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case D2I: {
//                    double value = frame.popDouble();
//                    KInteger registerInteger = new KInteger((int) value);
//                    frame.push(registerInteger);
//                    //**LOG**//log(i.operator, context, value + "=>" + registerInteger);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case D2L: {
//                    double value = frame.popDouble();
//                    KLong registerLong = new KLong((long) value);
//                    frame.push(registerLong);
//                    //**LOG**//log(i.operator, context, value + "=>" + registerLong);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case G2L: {
//                    KReference ref = frame.popRef();
//                    String value = Doovos.getSystem().getMemoryManager().getString(ref);
//                    KLong registerLong = new KLong(Long.parseLong(value));
//                    frame.push(registerLong);
//                    //**LOG**//log(i.operator, context, "@" + ref + "=\"" + value + "\" => " + registerLong);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case G2I: {
//                    KReference ref = frame.popRef();
//                    String value = Doovos.getSystem().getMemoryManager().getString(ref);
//                    KInteger registerInteger = new KInteger(Integer.parseInt(value));
//                    frame.push(registerInteger);
//                    //**LOG**//log(i.operator, context, "@" + ref + "=\"" + value + "\" => " + registerInteger);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case I2L: {
//                    int value = frame.popInt();
//                    frame.push(new KLong(value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case I2F: {
//                    int value = frame.popInt();
//                    frame.push(new KFloat(value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case I2D: {
//                    int value = frame.popInt();
//                    frame.push(new KDouble(value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case I2B: {
//                    int value = frame.popInt();
//                    frame.push(KByte.valueOf((byte) value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case I2S: {
//                    int value = frame.popInt();
//                    frame.push(new KShort((short) value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case I2C: {
//                    int value = frame.popInt();
//                    frame.push(new KChar((char) value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case I2G: {
//                    int value = frame.popInt();
//                    KProcess process = frame.getProcess();
//                    if (frame.getThread().pushClassInitializerFrame(process.getClassRepository().getClassByName("java.lang.String"))) {
//                        return KProcess.THIS_STATEMENT;
//                    }
//                    KReference dRegisterReference = frame.getMemorySegment().allocString(String.valueOf(value));
//                    frame.push(dRegisterReference);
//                    //**LOG**//log(i.operator, context, value + " => @" + dRegisterReference + "=\"" + String.valueOf(value) + "\"");
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case G2CA: {
//                    KReference ref = frame.popRef();
//                    String value = Doovos.getSystem().getMemoryManager().getString(ref);
//                    KReference r = frame.getMemorySegment().allocCharArray(value.toCharArray());
//                    frame.push(r);
//                    //**LOG**//log(i.operator, context, "@" + ref + "=\"" + value + "\" => " + r);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case CA2G: {
//                    KReference ref = frame.popRef();
//                    char[] value = Doovos.getSystem().getMemoryManager().getCharArray(ref);
//                    String strValue = new String(value);
//                    KProcess process = frame.getProcess();
//                    if (frame.getThread().pushClassInitializerFrame(process.getClassRepository().getClassByName("java.lang.String"))) {
//                        return KProcess.THIS_STATEMENT;
//                    }
//                    KReference r = frame.getMemorySegment().allocString(strValue);
//                    frame.push(r);
//                    //**LOG**//log(i.operator, context, "@" + ref + "=\"" + strValue + "\" => " + r);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DADD: {
//                    KDouble value2 = (KDouble) frame.pop();
//                    KDouble value1 = (KDouble) frame.pop();
//                    KDouble value = new KDouble(value1.value + value2.value);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, value1 + "" + value2 + "=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DALOAD: {
//                    int index = frame.popInt();
//                    KReference ref = frame.popRef();
//                    double value = Doovos.getSystem().getMemoryManager().getDoubleArray(ref, index);
//                    KDouble registerDouble = new KDouble(value);
//                    frame.push(registerDouble);
//                    //**LOG**//log(i.operator, context, "@" + ref + "[" + index + "]=" + registerDouble);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DASTORE: {
//                    double value = frame.popDouble();
//                    int index = frame.popInt();
//                    KReference ref = frame.popRef();
//                    Doovos.getSystem().getMemoryManager().setDoubleArray(ref, index, value);
//                    //**LOG**//log(i.operator, context, "@" + ref + "[" + index + "]=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DCMP: {
//                    KDouble value2 = (KDouble) frame.pop();
//                    KDouble value1 = (KDouble) frame.pop();
//                    KDouble value = new KDouble(value1.value < value2.value ? 1 : value1.value == value2.value ? 0 : -1);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, value1 + " <? " + value2 + " = " + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DCONST: {
//                    KDouble value = new KDouble(Double.longBitsToDouble(this.operands[0]));
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, value.toString());
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DDIV: {
//                    KDouble value2 = (KDouble) frame.pop();
//                    KDouble value1 = (KDouble) frame.pop();
//                    KDouble value = new KDouble(value1.value / value2.value);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, value1 + " / " + value2 + " = " + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DMUL: {
//                    KDouble value2 = (KDouble) frame.pop();
//                    KDouble value1 = (KDouble) frame.pop();
//                    KDouble value = new KDouble(value1.value * value2.value);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, value1 + " / " + value2 + " = " + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DNEG: {
//                    KDouble value = (KDouble) frame.pop();
//                    KDouble reg = new KDouble(-value.value);
//                    frame.push(reg);
//                    //**LOG**//log(i.operator, context, "-" + value + " = " + reg);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case DREM: {
//                    KDouble value2 = (KDouble) frame.pop();
//                    KDouble value1 = (KDouble) frame.pop();
//                    KDouble value = new KDouble(value1.value % value2.value);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, value1 + " % " + value2 + " = " + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FADD: {
//                    float b = frame.popFloat();
//                    float a = frame.popFloat();
//                    KFloat value = new KFloat(a + b);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, a + "+" + b + "=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FSUB: {
//                    float b = frame.popFloat();
//                    float a = frame.popFloat();
//                    KFloat value = new KFloat(a - b);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, a + "-" + b + "=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FMUL: {
//                    float b = frame.popFloat();
//                    float a = frame.popFloat();
//                    KFloat value = new KFloat(a * b);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, a + "*" + b + "=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FDIV: {
//                    float b = frame.popFloat();
//                    float a = frame.popFloat();
//                    KFloat value = new KFloat(a * b);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, a + "/" + b + "=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case F2I: {
//                    float value = frame.popFloat();
//                    frame.push(new KInteger((int) value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case F2D: {
//                    float value = frame.popFloat();
//                    frame.push(new KDouble(value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case F2L: {
//                    float value = frame.popFloat();
//                    frame.push(new KLong((long) value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FCONST_0: {
//                    KFloat value = KFloat.ZERO;
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, "value=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FCONST_1: {
//                    KFloat value = KFloat.ONE;
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, "value=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FCONST_2: {
//                    KFloat value = KFloat.TWO;
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, "value=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FALOAD: {
//                    int index = frame.popInt();
//                    KReference ref = frame.popRef();
//                    float value = Doovos.getSystem().getMemoryManager().getFloatArray(ref, index);
//                    KFloat registerDouble = new KFloat(value);
//                    frame.push(registerDouble);
//                    //**LOG**//log(i.operator, context, "@" + ref + "[" + index + "]=" + registerDouble);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FASTORE: {
//                    float value = frame.popFloat();
//                    int index = frame.popInt();
//                    KReference ref = frame.popRef();
//                    Doovos.getSystem().getMemoryManager().setFloatArray(ref, index, value);
//                    //**LOG**//log(i.operator, context, "@" + ref + "[" + index + "]=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FCMPG: {
//                    float value2 = frame.popFloat();
//                    float value1 = frame.popFloat();
//                    KRegister val;
//                    if (value1 > value2) {
//                        val = KInteger.ONE;
//                    } else if (value1 == value2) {
//                        val = KInteger.ZERO;
//                    } else {
//                        val = KInteger.M1;
//                    }
//                    frame.push(val);
//                    //**LOG**//log(i.operator, context, value1 + ">?" + value2 + " => " + val);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FCMPL: {
//                    float value2 = frame.popFloat();
//                    float value1 = frame.popFloat();
//                    KRegister val;
//                    if (Float.isNaN(value1) || Float.isNaN(value2)) {
//                        val = KInteger.M1;
//                    } else if (value1 > value2) {
//                        val = KInteger.ONE;
//                    } else if (value1 == value2) {
//                        val = KInteger.ZERO;
//                    } else {
//                        val = KInteger.M1;
//                    }
//                    frame.push(val);
//                    //**LOG**//log(i.operator, context, value1 + ">?" + value2 + " => " + val);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FSTORE: {
//                    KRegister register = frame.pop();
//                    //**LOG**//log(i.operator, context, "local=" + this.operands[0] + " , value=" + register);
//                    frame.setLocal((int) this.operands[0], register);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FSTORE_0: {
//                    KRegister register = frame.pop();
//                    //**LOG**//log(i.operator, context, " value=" + register);
//                    frame.setLocal(0, register);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FSTORE_1: {
//                    KRegister register = frame.pop();
//                    //**LOG**//log(i.operator, context, " value=" + register);
//                    frame.setLocal(1, register);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FSTORE_2: {
//                    KRegister register = frame.pop();
//                    //**LOG**//log(i.operator, context, " value=" + register);
//                    frame.setLocal(2, register);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FSTORE_3: {
//                    KRegister register = frame.pop();
//                    //**LOG**//log(i.operator, context, " value=" + register);
//                    frame.setLocal(3, register);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case SALOAD: {
//                    int index = frame.popInt();
//                    KReference ref = frame.popRef();
//                    short value = Doovos.getSystem().getMemoryManager().getShortArray(ref, index);
//                    KShort registerDouble = new KShort(value);
//                    frame.push(registerDouble);
//                    //**LOG**//log(i.operator, context, "@" + ref + "[" + index + "]=" + registerDouble);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FNEG: {
//                    float value = frame.popFloat();
//                    //**LOG**//log(i.operator, context, "value=" + value);
//                    frame.push(new KFloat(-value));
//                    return KProcess.NEXT_STATEMENT;
//                }
//                case FREM: {
//                    float b = frame.popInt();
//                    float a = frame.popFloat();
//                    KFloat value = new KFloat(a % b);
//                    frame.push(value);
//                    //**LOG**//log(i.operator, context, a + "%" + b + "=" + value);
//                    return KProcess.NEXT_STATEMENT;
//                }
//                //            case regdefine: {
//                //                process.getContext().addLocal();
//                //                return DProcess.NEXT_STATEMENT;
//                //            }
//                //            case stdout: {
//                //                DRegister reg = process.getContext().pop();
//                //                String message = new String(process.getMemorySegment(reg.segment).getCharArray(reg.pointer));
//                //                process.getStdout().write(message);
//                //                return DProcess.NEXT_STATEMENT;
//                //            }
//            }
//            throw new IllegalArgumentException("Unsupported operation : " + this.operator);
//        } catch (KEndOfThreadException e) {
//            throw e;
//        } catch (Exception e) {
//            throw new RuntimeException("Error at line " + frame.getProgramCounter() + ", method " + frame.getMethod().getClassName() + "." + frame.getMethod().getName(), e);
//        }
//    }
//
//
//    private static void log(KOperator op, KFrame frame, String msg) {
//        if (op == null) {
//            try {
//                System.out.println(">>[" + frame.getProcess().getId() + "][" + frame.getKClass().getName() + "." + frame.getMethod().getName() + "][**native**] " + msg);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                System.out.println(">>[" + frame.getProcess().getId() + "][" + frame.getKClass().getName() + "." + frame.getMethod().getName() + "][" + op + "] " + msg);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void relink(int index, KInstruction[] code, KMethod method)  {
//        //do nothing
//    }
//}