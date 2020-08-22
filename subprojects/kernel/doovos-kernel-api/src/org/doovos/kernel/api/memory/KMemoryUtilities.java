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
package org.doovos.kernel.api.memory;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;

public final class KMemoryUtilities {

    private KMemoryUtilities() {
    }

//    public static void main(String[] args) {
//        long value=Long.MIN_VALUE;
////        long value=65540L;
////        long x=40L;
//        int[] array=new int[1000];
//        int offset=0;
//        long2intArray(value, array, offset);
//        System.out.println(Long.toHexString(value)+" : "+Integer.toHexString(array[offset])+" "+array[offset + 1]);
//        long y=intArray2long(array, offset);
//        System.out.println();
//        System.out.println(Long.toHexString(value)+" VS "+Long.toHexString(y));
////        System.out.println(y);
//    }
    
    public static double byteArray2double(byte[] array, int offset) {
        return Double.longBitsToDouble(
                ((array[offset]) & 0xFFL) << 56
                | ((array[offset + 1]) & 0xFFL) << 48
                | ((array[offset + 2]) & 0xFFL) << 40
                | ((array[offset + 3]) & 0xFFL) << 32
                | ((array[offset + 4]) & 0xFFL) << 24
                | ((array[offset + 5]) & 0xFFL) << 16
                | ((array[offset + 6]) & 0xFFL) << 8
                | ((array[offset + 7]) & 0xFFL));

    }

    public static void double2byteArray(double value, byte[] array, int offset) {
        long x = Double.doubleToLongBits(value);
        array[offset] = (byte) ((x >>> 56));
        array[offset + 1] = (byte) ((x >>> 48));
        array[offset + 2] = (byte) ((x >>> 40));
        array[offset + 3] = (byte) ((x >>> 32));
        array[offset + 4] = (byte) ((x >>> 24));
        array[offset + 5] = (byte) ((x >>> 16));
        array[offset + 6] = (byte) ((x >>> 8));
        array[offset + 7] = (byte) (x & 0x000000ff);
    }

    public static float byteArray2float(byte[] array, int offset) {
        return Float.intBitsToFloat(
                (array[offset] & 0xFF) << 24
                | (array[offset + 1] & 0xFF) << 16
                | (array[offset + 2] & 0xFF) << 8
                | (array[offset + 3] & 0xFF));
    }

    public static void float2byteArray(float value, byte[] array, int offset) {
        int ival = Float.floatToIntBits(value);
        array[offset] = (byte) ((ival >>> 24));
        array[offset + 1] = (byte) ((ival >>> 16));
        array[offset + 2] = (byte) ((ival >>> 8));
        array[offset + 3] = (byte) (ival & 0x000000ff);
    }

    public static void byte2byteArray(byte value, byte[] array, int offset) {
        array[offset] = value;
    }

    public static void boolean2byteArray(boolean value, byte[] array, int offset) {
        array[offset] = (byte) (value ? 1 : 0);
    }

    public static byte[] charArray2byteArray(char[] input) {
        return charArray2byteArray(input, 0, input.length);
    }

    public static byte[] charArray2byteArray(char[] input, int inputIndex, int length) {
        final int size = 2;
        byte[] output = new byte[length * size];
        charArray2byteArray(input, inputIndex, output, 0, length);
        return output;
    }

    public static void charArray2byteArray(char[] input, int inputIndex, byte[] output, int outputIndex, int length) {
        final int size = 2;
        int j = outputIndex;
        int c = length;
        for (int i = inputIndex; c > 0; i++) {
            char2byteArray(input[i], output, j);
            j += size;
            c--;
        }
    }

    public static byte[] byteArray2byteArray(byte[] input) {
        return input;
    }

    public static byte[] byteArray2byteArray(byte[] input, int inputIndex, int length) {
        final int size = 1;
        byte[] output = new byte[length * size];
        byteArray2byteArray(input, inputIndex, output, 0, length);
        return output;
    }

    public static void byteArray2byteArray(byte[] input, int inputIndex, byte[] output, int outputIndex, int length) {
        final int size = 1;
        int j = outputIndex;
        int c = length;
        for (int i = inputIndex; c > 0; i++) {
            byte2byteArray(input[i], output, j);
            j += size;
            c--;
        }
    }

    public static byte[] booleanArray2byteArray(boolean[] input) {
        return booleanArray2byteArray(input, 0, input.length);
    }

    public static byte[] booleanArray2byteArray(boolean[] input, int inputIndex, int length) {
        final int size = 1;
        byte[] output = new byte[length * size];
        booleanArray2byteArray(input, inputIndex, output, 0, length);
        return output;
    }

    public static void booleanArray2byteArray(boolean[] input, int inputIndex, byte[] output, int outputIndex, int length) {
        final int size = 1;
        int j = outputIndex;
        int c = length;
        for (int i = inputIndex; c > 0; i++) {
            boolean2byteArray(input[i], output, j);
            j += size;
            c--;
        }
    }

    public static byte[] intArray2byteArray(int[] input) {
        return intArray2byteArray(input, 0, input.length);
    }

    public static byte[] intArray2byteArray(int[] input, int inputIndex, int length) {
        final int size = 4;
        byte[] output = new byte[length * size];
        intArray2byteArray(input, inputIndex, output, 0, length);
        return output;
    }

    public static void intArray2byteArray(int[] input, int inputIndex, byte[] output, int outputIndex, int length) {
        final int size = 4;
        int j = outputIndex;
        int c = length;
        for (int i = inputIndex; c > 0; i++) {
            int2byteArray(input[i], output, j);
            j += size;
            c--;
        }
    }

    public static byte[] floatArray2byteArray(float[] input) {
        return floatArray2byteArray(input, 0, input.length);
    }

    public static byte[] floatArray2byteArray(float[] input, int inputIndex, int length) {
        final int size = 4;
        byte[] output = new byte[length * size];
        floatArray2byteArray(input, inputIndex, output, 0, length);
        return output;
    }

    public static void floatArray2byteArray(float[] input, int inputIndex, byte[] output, int outputIndex, int length) {
        final int size = 4;
        int j = outputIndex;
        int c = length;
        for (int i = inputIndex; c > 0; i++) {
            float2byteArray(input[i], output, j);
            j += size;
            c--;
        }
    }

    public static byte[] doubleArray2byteArray(double[] input) {
        return doubleArray2byteArray(input, 0, input.length);
    }

    public static byte[] doubleArray2byteArray(double[] input, int inputIndex, int length) {
        final int size = 8;
        byte[] output = new byte[length * size];
        doubleArray2byteArray(input, inputIndex, output, 0, length);
        return output;
    }

    public static void doubleArray2byteArray(double[] input, int inputIndex, byte[] output, int outputIndex, int length) {
        final int size = 8;
        int j = outputIndex;
        int c = length;
        for (int i = inputIndex; c > 0; i++) {
            double2byteArray(input[i], output, j);
            j += size;
            c--;
        }
    }

    public static byte[] longArray2byteArray(long[] input) {
        return longArray2byteArray(input, 0, input.length);
    }

    public static byte[] longArray2byteArray(long[] input, int inputIndex, int length) {
        final int size = 8;
        byte[] output = new byte[length * size];
        longArray2byteArray(input, inputIndex, output, 0, length);
        return output;
    }

    public static void longArray2byteArray(long[] input, int inputIndex, byte[] output, int outputIndex, int length) {
        final int size = 8;
        int j = outputIndex;
        int c = length;
        for (int i = inputIndex; c > 0; i++) {
            long2byteArray(input[i], output, j);
            j += size;
            c--;
        }
    }

    public static char byteArray2char(byte[] array, int offset) {
        return (char) (((array[offset] & 0xFF00) << 8)
                | (array[offset + 1] & 0xFF));
    }

    public static char[] byteArray2charArray(byte[] array, int offset, int length) {
        char[] ret = new char[length / 2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = byteArray2char(array, offset + 2 * i);
        }
        return ret;
    }

    public static boolean byteArray2boolean(byte[] array, int offset) {
        return !(array[offset] == 0);
    }

    public static byte byteArray2byte(byte[] array, int offset) {
        return (array[offset]);
    }

    public static void char2byteArray(char value, byte[] array, int offset) {
        array[offset] = (byte) ((value & 0xFF) >>> 8);
        array[offset + 1] = (byte) (value & 0xFF);
    }

    public static long byteArray2long(byte[] array, int offset) {
        return ((array[offset]) & 0xFFL) << 56
                | ((array[offset + 1]) & 0xFFL) << 48
                | ((array[offset + 2]) & 0xFFL) << 40
                | ((array[offset + 3]) & 0xFFL) << 32
                | ((array[offset + 4]) & 0xFFL) << 24
                | ((array[offset + 5]) & 0xFFL) << 16
                | ((array[offset + 6]) & 0xFFL) << 8
                | ((array[offset + 7]) & 0xFFL);
    }

    public static byte[] long2byteArray(long value) {
        byte[] a = new byte[8];
        long2byteArray(value, a, 0);
        return a;
    }

    public static void long2byteArray(long value, byte[] array, int offset) {
        array[offset] = (byte) ((value >>> 56));
        array[offset + 1] = (byte) ((value >>> 48));
        array[offset + 2] = (byte) ((value >>> 40));
        array[offset + 3] = (byte) ((value >>> 32));
        array[offset + 4] = (byte) ((value >>> 24));
        array[offset + 5] = (byte) ((value >>> 16));
        array[offset + 6] = (byte) ((value >>> 8));
        array[offset + 7] = (byte) (value & 0x000000ff);
    }

    public static int byteArray2int(byte[] array, int offset) {
        return (((int) array[offset]) & 0xFF) << 24
                | (((int) array[offset + 1]) & 0xFF) << 16
                | (((int) array[offset + 2]) & 0xFF) << 8
                | (((int) array[offset + 3]) & 0xFF);
    }

    public static short byteArray2short(byte[] array, int offset) {
        return (short) ((((int) array[offset]) & (0xFF)) << 8
                | (((int) array[offset + 3]) & 0xFF));
    }

    public static void int2byteArray(int value, byte[] array, int offset) {
        array[offset] = (byte) ((value >>> 24));
        array[offset + 1] = (byte) ((value >>> 16));
        array[offset + 2] = (byte) ((value >>> 8));
        array[offset + 3] = (byte) (value & 0x000000ff);
    }

    public static void short2byteArray(int value, byte[] array, int offset) {
        array[offset] = (byte) ((value >>> 8));
        array[offset + 1] = (byte) (value & 0x000000ff);
    }

    public static KReference byteArray2ref(byte[] array, int offset) {
        try {
            long segment = ((array[offset]) & 255L) << 56 | ((array[offset + 1]) & 255L) << 48 | ((array[offset + 2]) & 255L) << 40 | ((array[offset + 3]) & 255L) << 32 | ((array[offset + 4]) & 255L) << 24 | ((array[offset + 5]) & 255L) << 16 | ((array[offset + 6]) & 255L) << 8 | ((array[offset + 7]) & 255L);
            if (segment < 0) {
                return KReference.NULL;
            }
            long pointer = ((array[offset + 8]) & 255L) << 56 | ((array[offset + 9]) & 255L) << 48 | ((array[offset + 10]) & 255L) << 40 | ((array[offset + 11]) & 255L) << 32 | ((array[offset + 12]) & 255L) << 24 | ((array[offset + 13]) & 255L) << 16 | ((array[offset + 14]) & 255L) << 8 | ((array[offset + 15]) & 255L);
            //        return new KReference(
            //                byteArray2long(array, offset),
            //                byteArray2long(array, offset + 8)
            //        );
            //Doovos.syslog("byteArray2Ref "+ref);
            return new KReference(Doovos.getSystem().getMemorySegment(segment), segment, pointer);
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }

    }

//    public static void byteArray2ref(byte[] array, int offset, KReference r) {
//        r.segment = byteArray2long(array, offset);
//        r.pointer = byteArray2long(array, offset + 8);
//    }
    public static void ref2byteArray(KReference value, byte[] array, int offset) {
        long2byteArray(value.segment, array, offset);
        long2byteArray(value.pointer, array, offset + 8);
    }
    
    public static void ref2intArray(KReference value, int[] array, int offset) {
        long2intArray(value.segment, array, offset);
        long2intArray(value.pointer, array, offset + 2);
    }

//    public static void byteArray2String(byte[] array, int offset, DRegisterString r) {
//        r.pointer = byteArray2long(array,offset);
//        r.offset = byteArray2int(array,offset+8);
//        r.count = byteArray2int(array,offset+12);
//    }
//    public static void string2byteArray(DRegisterString value, byte[] array, int offset) {
//        long2byteArray(value.pointer,array,offset);
//        int2byteArray(value.offset,array,offset+8);
//        int2byteArray(value.count,array,offset+12);
//    }
//    public static void main(String[] args) {
//        for (long ll : new long[]{0L, Long.MAX_VALUE, Long.MIN_VALUE, Long.MIN_VALUE + Long.MAX_VALUE / 2L, Long.MAX_VALUE / 2L}) {
//            System.out.println(Long.toHexString(ll).toUpperCase());
//            int[] ii = long2intArray(ll);
//            System.out.println("\t ints  : " + Integer.toHexString(ii[0]).toUpperCase() + " : " + Long.toHexString(((ii[1]) & 0x0000FFFFL)).toUpperCase());
//            System.out.println("\t longs : " + Long.toHexString(((ii[0]) & 0xFFFFFFFFL) << 32).toUpperCase() + " : " + Long.toHexString(ii[1] & 0xFFFFFFFFL).toUpperCase());
//            long ll2 = intArray2long(ii, 0);
//            if (ll2 != ll) {
//                System.out.println("\t PROBLEM " + Long.toHexString(ll).toUpperCase() + " != " + Long.toHexString(ll2).toUpperCase());
//            } else {
//                System.out.println("\t OK " + Long.toHexString(ll).toUpperCase());
//            }
//        }
//    }
//

    public static int[] long2intArray(long value) {
        int[] a = new int[2];
        long2intArray(value, a, 0);
        return a;
    }

    public static void long2intArray(long value, int[] array, int offset) {
        array[offset] = (int) ((value >> 32));
        array[offset + 1] = (int) (value);
//        System.out.println(Long.toHexString(value)+" : "+Integer.toHexString(array[offset])+" "+array[offset + 1]);
    }

    public static void double2intArray(double value, int[] array, int offset) {
        long x = Double.doubleToLongBits(value);
        array[offset] = (int) ((x >> 32));
        array[offset + 1] = (int) (x);
    }

    public static double intArray2double(int[] array, int offset) {
        return Double.longBitsToDouble(((array[offset]) & 0xFFFFFFFFL) << 32
                | ((array[offset + 1]) & 0xFFFFFFFFL));
    }
    
    public static long intArray2long(int[] array, int offset) {
        return ((array[offset]) & 0xFFFFFFFFL) << 32
                | ((array[offset + 1]) & 0xFFFFFFFFL);
    }
}
