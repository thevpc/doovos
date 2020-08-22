package org.doovos.kernel.core.memory.slaballocator;
/*
 * BitArray.java
 *
 * Copyright (c) 2007 by Daniel Strecker
 * <daniel dot strecker R-REMOVE-THIS-R at gmx dot net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * Change History:
 * 2007-12-05 created
 * 2007-12-22 copied methods from CompleteReader.java into this file
 * 2007-12-25 added method toByteArray()
 *            renamed methods lsh(int) and rsh(int) to leftshift(int) and
 *            rightshift(int) respectively
 *            renamed storage element to storage unit, in both, comments and
 *            code
 * 2007-12-26 renamed method toByteArray() to toBytes()
 *            removed bug in method toBytes()
 *            added method toStringByBytes()
 * 2007-12-29 fixed various bugs in the last days
 * 2007-12-31 removed bug in zeroSuperfluousBits()
 *            added constructor BitArray(String)
 *            added methods set(int) and unset(int)
 */

import java.io.*;

/**
 * This class is mostly like java.util.BitSet, just a bit more intuitive. Think
 * of it as a mutable string of bits which can grow and shrink in length.
 * <br/>
 * In this class, bits are stored in so called storage units. Depending on your
 * processor type, int or long might be best to use as storage type.
 * <br/>
 * The bits in the storage units have MSb (most significant bit) first bit
 * order. This means that the bit at index 0 in this BitArray is the most
 * significant bit of the first storage unit. For int and long, this is the
 * sign-bit.
 * <br/>
 * This class is not snychronized. If you want to access instances of this class
 * asynchronously from multiple threads, you have to synchronize access in your
 * own code.
 * <p/>
 * So far, this is a beta version. As of today (Sat, 2007-12-31), it's most
 * likely that it still contains bugs.
 *
 * @author Daniel Strecker
 * @author modifications by Taha BEN SALAH (2008)
 */
public final class BitArray implements Serializable {

//	constant(s)
////////////////////////////////////////
    /**
     * Number of bits required to address a bit within one storage unit. This
     * depends on the type used for the storage units. It must be set to 5 for
     * int and to 6 for long.
     */
    public static final int ADDRESS_BITS_PER_UNIT = 5;
    /**
     * The number of bits per storage unit.
     */
    public static final int BITS_PER_UNIT = 1 << ADDRESS_BITS_PER_UNIT;
    /**
     * The number of bytes per storage unit.
     */
    public static final int BYTES_PER_UNIT = BITS_PER_UNIT >> 3;
    /**
     * The bitmask for a single storage unit which has only the highest bit set.
     * For int, this is 0x80000000 and for long this is 0x8000000000000000L.
     */
    public static final int/*storage type*/ HIGHEST_BIT_SET_ONLY = 1 << (BITS_PER_UNIT - 1);
    /**
     * Bitmask of the bits of a bit index which are equal for all bits within
     * the same storage unit, i.e. for those bits, which address the storage
     * unit, but not the bit within the storage unit. E.g. for storage type
     * <code>int</code>, this is <code>11111111111111111111111111100000</code>.
     */
    public static final int UNIT_EXTERNAL_ADDRESS_MASK =
            (0x80000000 >> (BITS_PER_UNIT - 1 - ADDRESS_BITS_PER_UNIT));
    /**
     * Bitmask of the bits within a bit index which do not affect the index of
     * the addressed storage unit, ie which only address bits within the storage
     * unit. For storage type <code>int</code>, this is
     * </code>00000000000000000000000000011111</code>.
     */
    public static final int UNIT_INTERNAL_ADDRESS_MASK = ~UNIT_EXTERNAL_ADDRESS_MASK;
//	field(s)
////////////////////////////////////////
    /**
     * This array holds the bits of this BitArray. For reasons of memory
     * efficiency and algorithm performance, they are kept in storage units
     * instead of boolean values.
     */
    int/*storage type*/[] a;
    /**
     * The number of bits in this BitArray. This length can be less than the
     * length (in bits) of the array holding the data.
     */
    int length;

//    public static void main(String[] args) {
//        BitArray b = new BitArray("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000");
//        System.out.println(b.indexOfZeroSuite(14,123));
//        System.out.println(b.length + " : " + b);
//    }
//	constructor(s)
////////////////////////////////////////

    /**
     * Constructs a new, empty BitArray of length zero.
     */
    public BitArray() {
        this(0);
    }

    /**
     * Constructs a new, empty BitArray of the specified length.
     */
    public BitArray(int length) {
//        validateLength(length);

        this.length = length;

        a = new int/*storage type*/[getRequiredUnitCount(length)];
    }

    /**
     * Constructs a new BitArray, which will contain the bits of the specified
     * array as data.
     */
    public BitArray(byte[] b) {
        this(b, 0, b.length << 3);
    }

    /**
     * Constructs a new BitArray based on the data found in the specified array
     * at bit indexes <code>bitOffset</code> through <code>bitOffest + bitLength
     * - 1</code>.
     */
    public BitArray(byte[] b, int bitOffset, int bitLength) {
        validateOffset(bitOffset);
        validateLength(bitLength);

        if (bitOffset + bitLength > b.length * 8) {
            throw new IllegalArgumentException(
                    "bitOffset + bitLength may not be greater than b.length * 8.");
        }

        this.length = bitLength;
        int[] a0 = new int/*storage type*/[getRequiredUnitCount(length)];
        int a_length = a0.length;
        for (int i = 0; i < a_length; i++, bitOffset += BITS_PER_UNIT) {
            a0[i] = getStorageUnit(b, bitOffset);
        }
        this.a = a0;
        zeroSuperfluousBits();
    }

    /**
     * Constructs a copy of the specified BitArray. The copy will have its own
     * internal array for storing its data, so changing the copy does not change
     * the original and vice versa. Be aware that the unused capacity of the
     * copy can be less than that of the original.
     */
    public BitArray(BitArray original) {
        length = original.length;
        a = new int/*storage type*/[getRequiredUnitCount(length)];

        System.arraycopy(
                original.a, 0,
                a, 0,
                original.getUsedStorageUnitCount());
    }

    /**
     * Constructs a BitArray based on a String containing only 1s and 0s.
     */
    public BitArray(String s) {
        length = s.length();
        a = new int/*storage type*/[getRequiredUnitCount(length)];

        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case '1':
                    set(i, 1);
                case '0':
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Character " + i + " of String s is neither '0' nor '1': "
                            + s.charAt(i));
            }
        }
    }

//	factory method(s)
////////////////////////////////////////
    /**
     * Creates a new BitArray based on data in the specified file at bit indexes
     * <code>bitOffset</code> through <code>bitOffset + length - 1</code>.
     */
    public static BitArray create(
            String filename,
            long bitOffset,
            int bitLength) throws IOException {
        if (bitOffset < 0) {
            throw new IllegalArgumentException("bitOffset may not be < 0: " + bitOffset);
        }

        if (bitLength < 0) {
            throw new IllegalArgumentException("bitLength may not be < 0: " + bitLength);
        }

        long bitEnd = bitOffset + bitLength; //index of bit behind the last bit to extract
        long yteOffset = bitOffset / 8; //index of first byte to extract   //yte means byte. less confusion with bit.
        long yteEnd = bitEnd / 8;
        if (bitEnd % 8 != 0) {
            yteEnd++; //index of byte behind the last byte to extract
        }
        int yteLength = (int) (yteEnd - yteOffset);

        byte[] buffer = read(filename, yteOffset, yteLength);

        return new BitArray(buffer, (int) (bitOffset % 8), bitLength);
    }

//	method(s)
////////////////////////////////////////
    /**
     * Returns true if, and only if
     * <ul>
     * <li>the specified BitArray is not null and
     * <li>the specified BitArray has the same length as this BitArray and
     * <li>the specified BitArray's data bits are equal to the data bits of
     * this BitArray.</li>
     * </ul>
     */
    public boolean equals(BitArray other) {
        if (other == this) {
            return true;
        }

        if (other == null) {
            return false;
        }

        if (other.length != length) {
            return false;
        }

        int utLength = getUsedStorageUnitCount();
        int/*storage type*/[] oa = other.a;
        for (int i = 0; i < utLength; i++) {
            if (oa[i] != a[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * WARNING: This method should only be used when writing performance
     * optimized code.<br/>
     * This method returns the internal storage array of this BitArray. This
     * method is provided for enabling very performance optimized accessing of
     * the internal array. This method is a tradeoff between enabling performant
     * programming and data integrity, because this method can be utilized to
     * set bits in the unused capacity within the returned array, which can
     * cause undetected data corruption. Thus, only use this method when writing
     * performance optimized code.
     */
    public int/*storage type*/[] getStorageArray() {
        return a;
    }

    /**
     * WARNING: This method should only be used when writing performance
     * optimized code.<br/>
     * Sets the internal storage array to the specified array. The length of
     * this BitArray (in bits) will afterwards be array.length * BITS_PER_UNIT.
     * Because this method is a tradeoff between data integrity and enabling of
     * very performant programming, this method should only be used when writing
     * performance optimized code.
     */
    public void setStorageArray(int/*storage type*/[] array) {
        this.a = array;
        length = array.length * BITS_PER_UNIT;
    }

    /**
     * Sets all bits in this BitArray to zero.
     */
    public void setZero() {
        int Count = getUsedStorageUnitCount();

        for (int i = 0; i < Count; i++) {
            a[i] = 0;
        }
    }

    /**
     * Converts the data of this BitArray to an array of bytes and returns the
     * array of bytes. If the number of bits in this bit array is not a multiple
     * of 8, i.e. if it doesn't line up to full bytes, then the exceeding bits
     * in the last byte of the returned byte array are zero.
     */
    public byte[] toBytes() {
        //yte means byte. less confusion with bit.
        final int yteLength = (length + 7) >> 3;
        byte[] b = new byte[yteLength];

        final int utLength = getUsedStorageUnitCount();

        int yteIdx = 0; //yte means byte. less confusion with bit.
        int/*storage type*/ ut;
        for (int i = 0; i < utLength; i++) {
            ut = a[i];

            for (int j = BYTES_PER_UNIT - 1; j >= 0; j--, yteIdx++) {
                if (yteIdx == yteLength) {
                    return b;
                }

                //b[yteIdx] = (byte)(ut >> (8 * j));
                b[yteIdx] = (byte) (ut >> (j << 3)); //cool, eh? :)
            }
        }

        return b; //reached only if last storage unit's last byte is used
    }

    /**
     * Converts every full or started byte found within this BitArray to a
     * character and returns a String of these characters.
     */
    public String toStringByBytes() {
        //yte means byte. less confusion with bit.
        final int yteLength = (length + 7) >> 3;
        char[] c = new char[yteLength];

        final int utLength = getUsedStorageUnitCount();

        int yteIdx = 0; //yte means byte. less confusion with bit.
        int/*storage type*/ ut;
        int b;
        for (int i = 0; i < utLength; i++) {
            ut = a[i];

            for (int j = BYTES_PER_UNIT - 1; j >= 0; j--, yteIdx++) {
                if (yteIdx == yteLength) {
                    return new String(c);
                }

                b = ((int) (ut >> (j << 3))) & 0xff;

                c[yteIdx] = b < 32 ? '.' : (char) b;
            }
        }

        return new String(c);
    }

    /**
     * Returns the storage unit at the specified bit index of the specified byte
     * array. The <code>bitIdx</code> may be up to <code>b.length*8 - 1</code>.
     * For the cases <code>bitIdx > b.length*8 - 32</code> those bits in the
     * returned value, which exceed the length of the byte array, are set to
     * zero.
     */
    private static int getStorageUnit(byte[] b, int bitIdx) {
        if (bitIdx < 0) {
            throw new IllegalArgumentException("bitIdx < 0: " + bitIdx);
        }

        int bBitLength = b.length << 3;

        if (bitIdx >= bBitLength) {
            throw new IllegalArgumentException(
                    "bitIdx > b.length*8 - 1: " + bitIdx);
        }

        int yteIdx = bitIdx >> 3;   //byte index //yte means byte. less confusion with bit.
        bitIdx = bitIdx & 0x07; //bit index

        if (yteIdx + BYTES_PER_UNIT < b.length) {  //if we don't risk running into the end
            return ((b[yteIdx++] & 0xff) << 24 << bitIdx)
                    | ((b[yteIdx++] & 0xff) << 16 << bitIdx)
                    | ((b[yteIdx++] & 0xff) << 8 << bitIdx)
                    | ((b[yteIdx++] & 0xff)/*<<0*/ << bitIdx)
                    | ((b[yteIdx] & 0xff) << bitIdx >> 8) //if bitIdx = 0: (x & 0xff) >> 8 = 0
                    ;
        }

        int bLength = b.length;
        int result;
        result = ((b[yteIdx++] & 0xff) << 24 << bitIdx);
        if (yteIdx == bLength) {
            return result;
        }
        result |= ((b[yteIdx++] & 0xff) << 16 << bitIdx);
        if (yteIdx == bLength) {
            return result;
        }
        result |= ((b[yteIdx++] & 0xff) << 8 << bitIdx);
        if (yteIdx == bLength) {
            return result;
        }
        result |= ((b[yteIdx++] & 0xff)/*<<0*/ << bitIdx);
        if (yteIdx == bLength) {
            return result;
        }
        result |= ((b[yteIdx] & 0xff) << bitIdx >> 8);

        return result;
    }

    /**
     * XORs another BitArray to this BitArray, starting in this BitArray at
     * index startBitIdx and at index 0 in the other BitArray. After the
     * operation, this BitArray contains the result. The length of this BitArray
     * will not be changed during this operation.
     */
    /**
     * Writes the data of the specified BitArray to this bit array. The bit
     * values at index 0 through other.length-1 in the other bit array are
     * written to the bits at index startBitIdx through startBitIdx+other.length-1 in this
     * bit array.
     */
    public void xor(int startBitIdx, BitArray other) {
//        validateBitIndex(startBitIdx);

        if (startBitIdx + other.length > length) {
            throw new IllegalArgumentException(
                    "bitIdx + other.length may not be greater than length: "
                    + (startBitIdx + other.length));
        }

        int/*storage type*/[] oa = other.a;
        int bitIdx = startBitIdx;

        //xor all storage units except the last one
        int lastOtherUt = other.getLastUsedUnitIdx();
        //TODO: optimize performance of the following loop with code directly accessing the internal array
        int/*storage type*/ ut;
        for (int i = 0; i < lastOtherUt; i++, bitIdx += BITS_PER_UNIT) {
            ut = getFractStorageUnit(bitIdx);
            ut = ut ^ oa[i];
            setFractStorageUnit(bitIdx, ut);
        }

        //xor the remaining bits
        int/*storage type*/ rest = oa[lastOtherUt];

        int utIdx = bitIdx >> ADDRESS_BITS_PER_UNIT;//getUnitExternalIdx(bitIdx);
        int inIdx = bitIdx & UNIT_INTERNAL_ADDRESS_MASK;//getUnitInternalIdx(bitIdx);

        a[utIdx] = a[utIdx] ^ (rest >>> inIdx);

        int lastUtIdx = (startBitIdx + other.length - 1) >> ADDRESS_BITS_PER_UNIT;//getUnitExternalIdx(startBitIdx + other.length - 1);
        if (lastUtIdx > utIdx) //if remaining bits span over two units
        {
            a[lastUtIdx] = (rest << (BITS_PER_UNIT - inIdx)) ^ a[lastUtIdx];
        }
    }

    /**
     * XORs another BitArray to this BitArray. After the operation, this
     * BitArray contains the result. The length of this BitArray will not be
     * changed during this operation.
     */
    public void xor(BitArray other) {
        int utLength = getUsedStorageUnitCount();
        int otherUtLength = other.getUsedStorageUnitCount();

        if (otherUtLength < utLength) {
            utLength = otherUtLength;
        }

        //should be pretty fast...
        for (int i = 0; i < utLength; i++) {
            a[i] ^= other.a[i];
        }

        zeroSuperfluousBits();
    }

    /**
     * Changes this BitArray to its binary complement. The complement of a
     * BitArray A is the BitArray with all bits set which are not set in A and
     * all bits not set which are set in A, i.e. this method replaces all 0's by
     * 1's and vice versa.
     */
    public void not() {
        int utLength = getUsedStorageUnitCount();

        for (int i = 0; i < utLength; i++) {
            a[i] = ~a[i];
        }

        zeroSuperfluousBits();
    }

    /**
     * Returns the number of units in the internal storage array, which are
     * actually used to save bit data. This can be less than the capacity of the
     * internal storage array.
     */
    public int getUsedStorageUnitCount() {
        return getLastUsedUnitIdx() + 1;
    }

    /**
     * Returns the index of the last used storage unit in this BitArray.
     */
    public int getLastUsedUnitIdx() {
        return getUnitExternalIdx(length - 1);
    }

    /**
     * This method sets any unused bits in the last used storage unit to zero.
     * This is required after the execution of some algorithms. Because the
     * length of this BitArray doesn't need to be aligned to (i.e. be a multiple
     * of) the length of the storage type, there can be superfluous
     * bits in the last used storage unit. For optimized performance, some
     * algorithms expect these bits to be zero, but out of the same reason,
     * other algorithms may change these bits to ones. So after every execution
     * of one of the first kinds of algorithm, this method needs to be invoked.
     */
    private void zeroSuperfluousBits() {
        if (length > 0) {
            a[getUnitExternalIdx(length - 1)] &= HIGHEST_BIT_SET_ONLY >> getUnitInternalIdx(length - 1);
        }
    }

    /**
     * Leftshifts the bits in this BitArray by the specified shift.
     */
    public void leftshift(int shift) {
        if (shift == 0) //if nothing to do
        {
            return;
        }

        if (shift < 0) {
            throw new IllegalArgumentException(
                    "shift may not be less than zero: " + shift);
        }

        int utShift = getUnitExternalIdx(shift);
        int biShift = getUnitInternalIdx(shift);
        int invBiShift = BITS_PER_UNIT - biShift;

        int/*storage type*/ ut1, ut2; //storage units one and two
        int lastUt = getUnitExternalIdx(length - 1) - utShift;
        ut2 = a[utShift];
        for (int i = 0; i < lastUt; i++) {
            ut1 = ut2;
            ut2 = a[i + utShift + 1];
            a[i] = (ut1 << biShift) | (ut2 >>> invBiShift);
        }
        //the last storage unit's data that is actually used is now in ut2
        a[lastUt] = ut2 << biShift;

        //zero the rest
        int utLength = getUsedStorageUnitCount();
        for (int i = lastUt + 1; i > utLength; i++) {
            a[i] = 0;
        }
    }

    /**
     * Rightshifts the bits in the specified byte array by the specified shift.
     */
    public void rightshift(int shift) {
        if (shift == 0) //if nothing to do
        {
            return;
        }

        if (shift < 0) {
            throw new IllegalArgumentException(
                    "shift may not be less than zero: " + shift);
        }

        int utShift = getUnitExternalIdx(shift);
        int biShift = getUnitInternalIdx(shift);
        int invBiShift = BITS_PER_UNIT - biShift;

        int/*storage type*/ ut1, ut2;
        int lastUt = utShift;
        ut2 = a[getUnitExternalIdx(length - 1) - utShift];
        for (int i = getUnitExternalIdx(length - 1); i > lastUt; i--) {
            ut1 = ut2;
            ut2 = a[i - utShift - 1];
            a[i] = (ut2 << invBiShift) | (ut1 >>> biShift);
        }
        //the last storage unit's data that is actually used is now in ut2
        a[lastUt] = ut2 >>> biShift;

        //zero the rest
        for (int i = 0; i < lastUt; i++) {
            a[i] = 0;
        }
    }

    /**
     * Converts this BitArray to a human readable String of '0's and '1's.
     */
    public String toString() {
        char[] c = new char[length];

        //convert those bits which are in storage units up to the 2nd last used one
        int lastUt = getUnitExternalIdx(length - 1); //idx of the last unit to be processed

        int cIdx = 0;
        for (int utIdx = 0; utIdx < lastUt; utIdx++) {
            int/*storage type*/ v = a[utIdx];

            for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                c[cIdx++] = ((v & HIGHEST_BIT_SET_ONLY) == 0) ? '0' : '1';
                v <<= 1; //next bit
            }
        }

        //convert bits which are in the last storage unit
        int biEnd = getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
        int/*storage type*/ v = a[lastUt];
        for (int biIdx = 0; biIdx < biEnd; biIdx++) {
            c[cIdx++] = ((v & HIGHEST_BIT_SET_ONLY) == 0) ? '0' : '1';
            v <<= 1; //next bit
        }

        if (cIdx != length) {
            throw new UnsupportedOperationException("you programming looser!!!");
        }

        return new String(c);
    }

//    public static void main(String[] args) {
//        BitArray b=new BitArray(8);
//    }
    /**
     * @return
     * @author Taha BEN SALAH
     */
    public int getOneBitsCount() {
        //convert those bits which are in storage units up to the 2nd last used one
        int lastUt = (length - 1 >> ADDRESS_BITS_PER_UNIT);//getUnitExternalIdx(length - 1); //idx of the last unit to be processed
        int count = 0;
        for (int utIdx = 0; utIdx < lastUt; utIdx++) {
            int/*storage type*/ v = a[utIdx];

            for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                if (!((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    count++;
                }
                v <<= 1; //next bit
            }
        }

        //convert bits which are in the last storage unit
        int biEnd = (length - 1 & UNIT_INTERNAL_ADDRESS_MASK) + 1;//getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
        int/*storage type*/ v = a[lastUt];
        for (int biIdx = 0; biIdx < biEnd; biIdx++) {
            if (!((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                count++;
            }
            v <<= 1; //next bit
        }

        return count;
    }

    /**
     * @return
     * @author Taha BEN SALAH
     */
    public int getZeroBitsCount() {
        //convert those bits which are in storage units up to the 2nd last used one
        int lastUt = ((length - 1) >> ADDRESS_BITS_PER_UNIT);//getUnitExternalIdx(length - 1); //idx of the last unit to be processed
        int count = 0;
        int[] a0 = a;
        for (int utIdx = 0; utIdx < lastUt; utIdx++) {
            int/*storage type*/ v = a0[utIdx];

            for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    count++;
                }
                v <<= 1; //next bit
            }
        }

        //convert bits which are in the last storage unit
        int biEnd = (length - 1 & UNIT_INTERNAL_ADDRESS_MASK) + 1;//getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
        int/*storage type*/ v = a0[lastUt];
        for (int biIdx = 0; biIdx < biEnd; biIdx++) {
            if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                count++;
            }
            v <<= 1; //next bit
        }

        return count;
    }

    /**
     * @return
     * @author Taha BEN SALAH
     */
    public int indexOfOne() {
        //convert those bits which are in storage units up to the 2nd last used one
        int lastUt = getUnitExternalIdx(length - 1); //idx of the last unit to be processed
        int ii = 0;
        for (int utIdx = 0; utIdx < lastUt; utIdx++) {
            int/*storage type*/ v = a[utIdx];

            for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                if (!((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    return ii;
                }
                v <<= 1; //next bit
                ii++;
            }
        }

        //convert bits which are in the last storage unit
        int biEnd = getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
        int/*storage type*/ v = a[lastUt];
        for (int biIdx = 0; biIdx < biEnd; biIdx++) {
            if (!((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                return ii;
            }
            ii++;
            v <<= 1; //next bit
        }

        return -1;
    }

    /**
     * @return
     * @author Taha BEN SALAH
     */
    public int indexOfZero() {
        //convert those bits which are in storage units up to the 2nd last used one
        int lastUt = getUnitExternalIdx(length - 1); //idx of the last unit to be processed
        int ii = 0;
        for (int utIdx = 0; utIdx < lastUt; utIdx++) {
            int/*storage type*/ v = a[utIdx];

            for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    return ii;
                }
                v <<= 1; //next bit
                ii++;
            }
        }

        //convert bits which are in the last storage unit
        int biEnd = getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
        int/*storage type*/ v = a[lastUt];
        for (int biIdx = 0; biIdx < biEnd; biIdx++) {
            if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                return ii;
            }
            ii++;
            v <<= 1; //next bit
        }

        return -1;
    }

    /**
     * @param suite
     * @return
     * @author Taha BEN SALAH
     */
    public int indexOfOneSuite(int suite) {
        //convert those bits which are in storage units up to the 2nd last used one
        int lastUt = getUnitExternalIdx(length - 1); //idx of the last unit to be processed
        int ii = 0;
        int count = 0;
        for (int utIdx = 0; utIdx < lastUt; utIdx++) {
            int/*storage type*/ v = a[utIdx];

            for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                if (!((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    count++;
                    if (count == suite) {
                        return ii - count + 1;
                    }
                } else {
                    count = 0;
                }
                v <<= 1; //next bit
                ii++;
            }
        }

        //convert bits which are in the last storage unit
        int biEnd = getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
        int/*storage type*/ v = a[lastUt];
        for (int biIdx = 0; biIdx < biEnd; biIdx++) {
            if (!((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                count++;
                if (count == suite) {
                    return ii - count + 1;
                }
            } else {
                count = 0;
            }
            ii++;
            v <<= 1; //next bit
        }

        return -1;
    }

    /**
     * @param suite
     * @return
     * @author Taha BEN SALAH
     */
    public int indexOfZeroSuite(int suite) {
        //convert those bits which are in storage units up to the 2nd last used one
        int lastUt = ((length - 1) >> ADDRESS_BITS_PER_UNIT);//getUnitExternalIdx(length - 1); //idx of the last unit to be processed
        int ii = 0;
        int count = 0;
        int[] a0 = a;
        for (int utIdx = 0; utIdx < lastUt; utIdx++) {
            int/*storage type*/ v = a0[utIdx];

            for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    count++;
                    if (count == suite) {
                        return ii - count + 1;
                    }
                } else {
                    count = 0;
                }
                v <<= 1; //next bit
                ii++;
            }
        }

        //convert bits which are in the last storage unit
        int biEnd = ((length - 1) & UNIT_INTERNAL_ADDRESS_MASK) + 1;//getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
        int/*storage type*/ v = a0[lastUt];
        for (int biIdx = 0; biIdx < biEnd; biIdx++) {
            if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                count++;
                if (count == suite) {
                    return ii - count + 1;
                }
            } else {
                count = 0;
            }
            ii++;
            v <<= 1; //next bit
        }

        return -1;
    }

    /**
     * @param suite
     * @return
     * @author Taha BEN SALAH
     */
    public int indexOfZeroSuite(int suite, int fromIndex) {
        //convert those bits which are in storage units up to the 2nd last used one
        int fromIndexUt = ((fromIndex) >> ADDRESS_BITS_PER_UNIT);
        int fromIndexMod = fromIndex % (1 << ADDRESS_BITS_PER_UNIT);
        int lastUt = ((length - 1) >> ADDRESS_BITS_PER_UNIT);//getUnitExternalIdx(length - 1); //idx of the last unit to be processed
        int ii = 0;
        int count = 0;
        int[] a0 = a;
        if (fromIndexUt == lastUt) {
            //convert bits which are in the last storage unit
            int biEnd = ((length - 1) & UNIT_INTERNAL_ADDRESS_MASK) + 1;//getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
            int/*storage type*/ v = a0[lastUt];
            v <<= fromIndexMod;
            ii+=fromIndex;
            for (int biIdx = fromIndexMod; biIdx < biEnd; biIdx++) {
                if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    count++;
                    if (count == suite) {
                        return ii - count + 1;
                    }
                } else {
                    count = 0;
                }
                ii++;
                v <<= 1; //next bit
            }
        } else if(fromIndexUt < lastUt){
            int v0 = a0[fromIndexUt];
            ii+=fromIndex;
            v0 <<= fromIndexMod;
            for (int biIdx = fromIndexMod; biIdx < BITS_PER_UNIT; biIdx++) {
                if (((v0 & HIGHEST_BIT_SET_ONLY) == 0)) {
                    count++;
                    if (count == suite) {
                        return ii - count + 1;
                    }
                } else {
                    count = 0;
                }
                v0 <<= 1; //next bit
                ii++;
            }
            for (int utIdx = fromIndexUt + 1; utIdx < lastUt; utIdx++) {
                int/*storage type*/ v = a0[utIdx];
                for (int biIdx = 0; biIdx < BITS_PER_UNIT; biIdx++) {
                    if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                        count++;
                        if (count == suite) {
                            return ii - count + 1;
                        }
                    } else {
                        count = 0;
                    }
                    v <<= 1; //next bit
                    ii++;
                }
            }

            //convert bits which are in the last storage unit
            int biEnd = ((length - 1) & UNIT_INTERNAL_ADDRESS_MASK) + 1;//getUnitInternalIdx(length - 1) + 1;  //- 1) + 1: otherwise we loose a last fully packed s. u.
            int/*storage type*/ v = a0[lastUt];
            for (int biIdx = 0; biIdx < biEnd; biIdx++) {
                if (((v & HIGHEST_BIT_SET_ONLY) == 0)) {
                    count++;
                    if (count == suite) {
                        return ii - count + 1;
                    }
                } else {
                    count = 0;
                }
                ii++;
                v <<= 1; //next bit
            }
        }
        return -1;
    }

    /**
     * Returns the bit at the specified bitIdx. The value of this bit is
     * returned in the least significant bit of the return value. All other
     * bits of the return value are zero.
     */
    public int get(int bitIdx) {
//        validateBitIndex(bitIdx);

        int utIdx = bitIdx >> ADDRESS_BITS_PER_UNIT;//getUnitExternalIdx(bitIdx);
        int inIdx = bitIdx & UNIT_INTERNAL_ADDRESS_MASK;//getUnitInternalIdx(bitIdx);
        return /*(int)*/ (a[utIdx] << inIdx >>> (BITS_PER_UNIT - 1));
    }

    /**
     * Converts the <code>BITS_PER_UNIT</code> many bits found at the specified
     * bit index to the type of the storage unit and returns the result. This
     * method is called getFractStorageUnit(...), because the returned value can
     * be composed of two fractions of two successive storage units.
     */
    public int/*storage type*/ getFractStorageUnit(int bitIdx) {
//        validateBitIndex(bitIdx);

        if (bitIdx + BITS_PER_UNIT > length) {
            throw new IllegalArgumentException(
                    "length < bitIdx + BITS_PER_ELEMENT = "
                    + bitIdx + BITS_PER_UNIT);
        }

        int utIdx = bitIdx >> ADDRESS_BITS_PER_UNIT;//getUnitExternalIdx(bitIdx);
        int inIdx = bitIdx & UNIT_INTERNAL_ADDRESS_MASK;//getUnitInternalIdx(bitIdx);

        if (inIdx == 0) {
            return a[utIdx];
        } else {
            return (a[utIdx] << inIdx)
                    | (a[utIdx + 1] >>> (BITS_PER_UNIT - inIdx));
        }
    }

    /**
     * Changes the bits found at the specified bit index to the value of the
     * bits in the specified storage type value. If the assignment spans over
     * multiple storage units, the first storage unit gets assigned the most
     * significant bits of the specified value and the second storage unit gets
     * assigned the less significant bits of the specified value.
     */
    public void setFractStorageUnit(int bitIdx, int/*storage type*/ value) {
//        validateBitIndex(bitIdx);

        if (bitIdx + BITS_PER_UNIT > length) {
            throw new IndexOutOfBoundsException(
                    "length < bitIdx + BITS_PER_ELEMENT = "
                    + bitIdx + BITS_PER_UNIT);
        }

        int utIdx = getUnitExternalIdx(bitIdx);
        int inIdx = getUnitInternalIdx(bitIdx);

        if (inIdx == 0) {
            a[utIdx] = value;
        } else {
            //bitmask of bits which remain unchanged in the 1st storage unit:
            int/*storage type*/ bitmask = HIGHEST_BIT_SET_ONLY >> inIdx << 1;
            a[utIdx] = (a[utIdx] & bitmask) | (value >>> inIdx);
            ; //this is valid java code???
            utIdx++; //2nd storage unit
            //bitmask of bits which remain unchanged in the 2nd storage unit:
            bitmask = ~bitmask;
            a[utIdx] = (value << (BITS_PER_UNIT - inIdx)) | (a[utIdx] & bitmask);
        }
    }

    /**
     * Sets the bit at the specified bitIdx to the least significant bit in the
     * specified value. The other bits of the value are ignored.
     */
    public void set(int bitIdx, int value) {
//        validateBitIndex(bitIdx);

        int utIdx = bitIdx >> ADDRESS_BITS_PER_UNIT;//getUnitExternalIdx(bitIdx);
        int inIdx = bitIdx & UNIT_INTERNAL_ADDRESS_MASK;//getUnitInternalIdx(bitIdx);
        int[] a0 = a;
        a0[utIdx] =
                a0[utIdx] & (~(HIGHEST_BIT_SET_ONLY >>> inIdx)) | //keep all bits
                //except the one to be set
                ((value & 1) << (BITS_PER_UNIT - 1) >>> inIdx);
    }

    public void setRange(int bitIdx0, int bitIdx1, int value) {
//        validateBitIndex(bitIdx);
        int[] a0 = a;
        for (int i = bitIdx0; i < bitIdx1; i++) {
            int utIdx = i >> ADDRESS_BITS_PER_UNIT;//getUnitExternalIdx(bitIdx);
            int inIdx = i & UNIT_INTERNAL_ADDRESS_MASK;//getUnitInternalIdx(bitIdx);
            a0[utIdx] =
                    a0[utIdx] & (~(HIGHEST_BIT_SET_ONLY >>> inIdx)) | //keep all bits
                    //except the one to be set
                    ((value & 1) << (BITS_PER_UNIT - 1) >>> inIdx);
        }
    }

    /**
     * Sets the bit at the specified bitIdx to 1.
     */
    public void set(int bitIdx) {
        set(bitIdx, 1);
    }

    /**
     * Sets the bit at the specified bitIdx to 0.
     */
    public void unset(int bitIdx) {
        set(bitIdx, 0);
    }

    /**
     * Writes the data of the specified BitArray to this bit array. The bit
     * values at index 0 through other.length-1 in the other bit array are
     * written to the bits at index startBitIdx through startBitIdx+other.length-1 in this
     * bit array.
     */
    public void set(int startBitIdx, BitArray other) {
//        validateBitIndex(startBitIdx);

        if (startBitIdx + other.length > length) {
            throw new IllegalArgumentException(
                    "bitIdx + other.length may not be greater than length: "
                    + (startBitIdx + other.length));
        }

        int/*storage type*/[] oa = other.a;
        int bitIdx = startBitIdx;

        //copy all storage units except the last one
        int lastOtherUt = other.getLastUsedUnitIdx();
        //TODO: optimize performance of the following loop with code directly accessing the internal array
        for (int i = 0; i < lastOtherUt; i++, bitIdx += BITS_PER_UNIT) {
            setFractStorageUnit(bitIdx, oa[i]);
        }

        //copy the remaining bits
        int/*storage type*/ rest = oa[lastOtherUt];

        int utIdx = getUnitExternalIdx(bitIdx);
        int inIdx = getUnitInternalIdx(bitIdx);

        int/*storage type*/ bitmask = HIGHEST_BIT_SET_ONLY >> inIdx << 1;
        a[utIdx] =
                (a[utIdx] & bitmask)
                | (rest >>> inIdx);
        ;

        bitmask = ~bitmask;
        int lastUtIdx = getUnitExternalIdx(startBitIdx + other.length - 1);
        if (lastUtIdx > utIdx) { //if remaining bits span over two units
            a[lastUtIdx] =
                    (rest << (BITS_PER_UNIT - inIdx))
                    | (a[lastUtIdx] & bitmask);
        }
    }

    /**
     * Returns the part of this BitArray which is found at index range
     * startBitIdx through startBitIdx + bitLength - 1.
     */
    public BitArray getSubArray(int startBitIdx, int bitLength) {
//        validateBitIndex(startBitIdx);

//        validateLength(bitLength);

        if (startBitIdx + bitLength > length) {
            throw new IllegalArgumentException(
                    "length < startBitIdx + bitLength = " + startBitIdx + bitLength);
        }

        BitArray result = new BitArray(bitLength);
        int/*storage type*/[] ra = result.a;

        int bitIdx = startBitIdx;  //throughout this method: index of next src bit

        //copy all units except the last one
        int lastResultUtIdx = result.getLastUsedUnitIdx();
        //TODO: optimize performance of the following loop with code directly accessing the internal array
        for (int i = 0; i < lastResultUtIdx; i++, bitIdx += BITS_PER_UNIT) {
            ra[i] = getFractStorageUnit(bitIdx);
        }

        //copy the remaining bits
        int utIdx = getUnitExternalIdx(bitIdx);
        int inIdx = getUnitInternalIdx(bitIdx);
        ra[lastResultUtIdx] = a[utIdx] << inIdx;

        int lastUtIdx = getUnitExternalIdx(startBitIdx + bitLength - 1);
        if (lastUtIdx > utIdx) //if remaining bits span into the next unit
        {
            ra[lastResultUtIdx] |= a[lastUtIdx] >>> (BITS_PER_UNIT - inIdx);
        }

        return result;
    }

    /**
     * Returns the storage unit at the specified storage unit index.
     */
    public int/*storage type*/ getStorageUnit(int utIdx) {
        validateStorageUnitIndex(utIdx);

        return a[utIdx];
    }

    /**
     * Changes the storage unit's value at the specified storage unit index. If
     * setting the last possible storage unit, it is possible that some bits
     * exceed the length of this BitArray. In this case, these bits are ignored
     * and not set in this BitArray's internal storage array.
     */
    public void setStorageUnit(int utIdx, int/*storage type*/ value) {
        validateStorageUnitIndex(utIdx);

        int lastUtIdx = getUnitExternalIdx(length - 1);
        if (utIdx < lastUtIdx) //if full storage unit is used
        {
            a[utIdx] = value;
        } else //if some bits of the storage unit might be unused
        {
            a[utIdx] = value & (HIGHEST_BIT_SET_ONLY >> getUnitInternalIdx(length - 1));
        }
    }

    /**
     * Returns the number of bits stored in this BitArray.
     */
    public int length() {
        return length;
    }

    /**
     * Changes the length of this BitArray to the specified length. If the new
     * length is less than the current length, the data is truncated. If the new
     * length is greater than the current length, the length is extended and the
     * new bits have initial values of zero.
     */
    public void setLength(int length) {
        validateLength(length);

        if (length < this.length) {
            this.length = length;
            zeroSuperfluousBits();
            return;
        }

        if (length > this.length) {
            boolean reusingSpace = !ensureCapacity(length);

            //zero extended bits of current last storage unit
            zeroSuperfluousBits();

            //if storage space was reused, zero all reused storage units
            if (reusingSpace) {
                int curLastUtIdx = getUnitExternalIdx(this.length - 1);
                int newUtLength = getRequiredUnitCount(length);

                for (int i = curLastUtIdx + 1; i < newUtLength; i++) {
                    a[i] = 0;
                }
            }

            this.length = length;
//            return;
        }

        //else: length == this.length
    }

    /**
     * Ensures that there is enough storage space reserved in this BitArray to
     * hold at least the specified number of bits. The returned value is true if
     * and only if additional storage space needed to be allocated to ensure the
     * requested capacity.
     */
    public boolean ensureCapacity(int bitLength) {
        int requUtLength = getRequiredUnitCount(bitLength);

        if (a.length >= requUtLength) {
            return false;
        }

        int/*storage type*/[] nA = new int/*storage type*/[requUtLength];
        System.arraycopy(a, 0, nA, 0, getRequiredUnitCount(length));
        a = nA;

        return true;
    }

    /**
     * Throws an exception if the specified bitIdx is not within the valid
     * range of 0 to (length - 1).
     */
    private void validateBitIndex(int bitIdx) {
        if (bitIdx < 0) {
            throw new IndexOutOfBoundsException(
                    "bitIdx < 0: " + bitIdx);
        }

        if (bitIdx >= length) {
            throw new IndexOutOfBoundsException(
                    "bitIdx >= length (" + length + "): " + bitIdx);
        }
    }

    /**
     * Throws an exception if the specified storage unit index is not within the
     * valid range of 0 to (length - 1).
     */
    private void validateStorageUnitIndex(int utIdx) {
        if (utIdx < 0) {
            throw new IndexOutOfBoundsException(
                    "utIdx < 0: " + utIdx);
        }

        int lastUtIdx = getUnitExternalIdx(length - 1);
        if (utIdx > lastUtIdx) {
            throw new IndexOutOfBoundsException(
                    "utIdx > index of last unit (" + lastUtIdx + "): " + utIdx);
        }
    }

    /**
     * Throws an exception if the specified length is not a valid possible
     * length of a BitArray, i.e. if the length is not >= 0, i.e. if length < 0.
     */
    private static void validateLength(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length may not be less than 0: " + length);
        }
    }

    /**
     * Throws an exception if the specified offset is not a valid possible
     * offset in an array, i.e. if the offset is not >= 0, i.e. if offset < 0.
     */
    private static void validateOffset(int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("offset may not be less than 0: " + offset);
        }
    }

    /**
     * Returns the number of storage units required to hold the specified number
     * of bits.
     */
    private static int getRequiredUnitCount(int bitLength) {
        //bitLength can be seen as the index of the bit behind the last bit for
        //which we need to provide storage
        //return getUnitExternalIdx(bitLength - 1) + 1; //bitLength - 1: idx of last bit
        return ((bitLength - 1) >> ADDRESS_BITS_PER_UNIT) + 1; //bitLength - 1: idx of last bit
    }

    /**
     * Returns the storage unit index (aka unit external index) of a bit at the
     * specified bitIdx in any BitArray.
     */
    protected static int getUnitExternalIdx(int bitIdx) {
        return bitIdx >> ADDRESS_BITS_PER_UNIT;
    }

    /**
     * For the bit at the specified bitIdx in any BitArray, this method returns
     * the index of this bit within its storage unit, aka unit internal index.
     */
    protected static int getUnitInternalIdx(int bitIdx) {
        return bitIdx & UNIT_INTERNAL_ADDRESS_MASK;
    }

    /**
     * Converts an int to a binary string, most significant byte and bit first.
     * All 32 bits of the int are converted to exactly one character each.
     */
    public static String toBinaryString(int value) {
        char[] c = new char[32];

        int mask = 0x80000000;
        for (int i = 0; i < 32; i++) {
            c[i] = ((value & mask) == 0) ? '0' : '1';
            mask >>>= 1;
        }

        return new String(c);
    }

    /**
     * Converts a long to a binary string, most significant byte and bit first.
     * All 64 bits of the long are converted to exactly one character each.
     */
    public static String toBinaryString(long value) {
        char[] c = new char[64];

        long mask = 0x8000000000000000L;
        for (int i = 0; i < 64; i++) {
            c[i] = ((value & mask) == 0L) ? '0' : '1';
            mask >>>= 1;
        }

        return new String(c);
    }

    /**
     * Test method.
     */
//	public static void main(String[] args) {
//        BitArray a = new BitArray(11);
//        a.set(7);
//        a.set(6);
//        a.set(2);
//        a.set(10);
//        System.out.println(a.indexOfOneSuite(1));
//        System.out.println(a.getOneBitsCount());
//        System.out.println("a = " + a);
//
////        System.out.println("ADDRESS_BITS_PER_UNIT     : " + ADDRESS_BITS_PER_UNIT);
////		System.out.println("BITS_PER_UNIT             : " + BITS_PER_UNIT);
////		System.out.println("HIGHEST_BIT_SET_ONLY      : " + toBinaryString(HIGHEST_BIT_SET_ONLY));
////		System.out.println("UNIT_EXTERNAL_ADDRESS_MASK: " + toBinaryString(UNIT_EXTERNAL_ADDRESS_MASK));
////		System.out.println("UNIT_INTERNAL_ADDRESS_MASK: " + toBinaryString(UNIT_INTERNAL_ADDRESS_MASK));
////		System.out.println();
////
////		byte[] data = "Hallo!".getBytes();
////		BitArray a = new BitArray(data);
////		byte[] recr = a.toBytes();
////		BitArray b = new BitArray(recr);
////
////		System.out.println(a);
////		System.out.println(b);
//	}
//	methods borrowed from CompleteReader.java
////////////////////////////////////////
    /**
     * Reads a range of bytes from the specified file, starting at the specified
     * fileOffset and reading until length bytes are read or end of stream is
     * reached. The read bytes are stored in the specified buffer, starting at
     * index bufferOffset. The returned value is the number of bytes actually
     * read.
     */
    public static int read(
            String filename,
            long fileOffset,
            byte[] buffer,
            int bufferOffset,
            int length) throws IOException {
        //sanity checks NOT requiring i/o
        if (fileOffset < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "fileOffset < 0 is not allowed");
        }

        if (bufferOffset < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "bufferOffset < 0 is not allowed");
        }

        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "length < 0 is not allowed");
        }

        if (bufferOffset + length > buffer.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "bufferOffset + length exceeds the buffer length:"
                    + (bufferOffset + length) + " > " + buffer.length);
        }

        //sanity checks requiring i/o
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalArgumentException(
                    "file \"" + filename + "\" doesn't exist");
        }

        if (file.isDirectory()) {
            throw new IllegalArgumentException(
                    "file \"" + filename + "\" is a directory");
        }

        if (!file.canRead()) {
            throw new IllegalArgumentException(
                    "can't read file \"" + filename + "\"");
        }

        long fileLen = file.length();
        long fileRangeEnd = fileOffset + length;
        if (fileRangeEnd > fileLen) {
            throw new IllegalArgumentException(
                    "fileOffset + length exceeds file length: "
                    + fileRangeEnd + " > " + fileLen);
        }

        //open input stream, seek to pos, and delegate reading
        FileInputStream fis = new FileInputStream(file);

        fis.skip(fileOffset);

        int read = read(fis, buffer, bufferOffset, length);

        try {
            fis.close();
        } catch (IOException e) { /* disregard */ }

        return read;
    }

    /**
     * Convenience method for read(String, int, byte[], int, int), which does
     * the creation of the byte array for holding the read data. If less then
     * length bytes are read, then the length of the returned byte array is
     * shrinked to fit the number of read bytes.
     */
    public static byte[] read(
            String filename,
            long fileOffset,
            int length) throws IOException {
        byte[] buffer = new byte[length];

        int read = read(filename, fileOffset, buffer, 0, length);

        if (read == length) {
            return buffer;
        }

        byte[] buffer2 = new byte[read];
        System.arraycopy(buffer, 0, buffer2, 0, read);

        return buffer2;
    }

    /**
     * A read method similar to InputStream.read(byte[], int, int). The
     * difference is that this method doesn't return if the available() method
     * of the underlying stream returns zero.
     */
    public static int read(
            InputStream is,
            byte[] buffer,
            int offset,
            int length) throws IOException {
        if (offset < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "offset < 0 is not allowed");
        }

        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "length < 0 is not allowed");
        }

        if (offset + length > buffer.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "offset + length > buffer.length is not allowed");
        }

        int read = 0;
        int tmp;

        while (length > 0) {
            if (is.available() == 0) { //in case read(byte[] ...) would NOT block
                tmp = is.read();

                if (tmp == -1) {
                    return read;
                }

                buffer[offset] = (byte) tmp;
                offset++;
                read++;
            } else { //in case there is data available, the underlying
                //read(byte[] ...) method is more efficient
                tmp = is.read(buffer, offset, length);

                if (tmp == -1) {
                    return read;
                }

                offset += tmp;
                length -= tmp;
                read += tmp;
            }
        }

        return read;
    }
}
