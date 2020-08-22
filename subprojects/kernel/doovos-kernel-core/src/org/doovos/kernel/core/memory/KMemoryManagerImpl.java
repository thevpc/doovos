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
package org.doovos.kernel.core.memory;

import org.doovos.kernel.api.filesystem.UnknownResourceException;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.Doovos;

import java.rmi.RemoteException;

public class KMemoryManagerImpl implements KMemoryManager {

    public KReference allocBoolean() throws RemoteException {
        return getAllocSegment().allocBoolean();
    }

    public KReference allocBooleanArray(int size) throws RemoteException {
        return getAllocSegment().allocBooleanArray(size);
    }

    public KReference allocByte() throws RemoteException {
        return getAllocSegment().allocByte();
    }

    public KReference allocByteArray(int size) throws RemoteException {
        return getAllocSegment().allocByteArray(size);
    }

    public KReference allocChar() throws RemoteException {
        return getAllocSegment().allocChar();
    }

    public KReference allocCharArray(int size) throws RemoteException {
        return getAllocSegment().allocCharArray(size);
    }

    public KReference allocCharArray(char[] value) throws RemoteException {
        return getAllocSegment().allocCharArray(value);
    }

    public KReference allocClass(KClass classRef) throws RemoteException {
        return getAllocSegment().allocClass(classRef);
    }

    public KReference allocDouble() throws RemoteException {
        return getAllocSegment().allocDouble();
    }

    public KReference allocDoubleArray(int size) throws RemoteException {
        return getAllocSegment().allocDoubleArray(size);
    }

    public KReference allocFloat() throws RemoteException {
        return getAllocSegment().allocFloat();
    }

    public KReference allocFloatArray(int size) throws RemoteException {
        return getAllocSegment().allocFloatArray(size);
    }

    public KReference allocInt() throws RemoteException {
        return getAllocSegment().allocInt();
    }

    public KReference allocIntArray(int size) throws RemoteException {
        return getAllocSegment().allocIntArray(size);
    }

    public KReference allocLong() throws RemoteException {
        return getAllocSegment().allocLong();
    }

    public KReference allocLongArray(int size) throws RemoteException {
        return getAllocSegment().allocLongArray(size);
    }

    public KReference allocObject(KClass classRef) throws RemoteException {
        return getAllocSegment().allocObject(classRef);
    }


//    public KReference allocRef(KClass classRef) throws RemoteException {
//        return getAllocSegment().allocRef(classRef);
//    }

    public KReference allocRefArray(KClass classRef, int size) throws RemoteException {
        return getAllocSegment().allocRefArray(classRef, size);
    }

    public KReference allocShort() throws RemoteException {
        return getAllocSegment().allocShort();
    }

    public KReference allocShortArray(int size) throws RemoteException {
        return getAllocSegment().allocShortArray(size);
    }

    public KReference allocString(KReference ref, int start, int count) throws RemoteException {
        return ref.memorySegment.allocString(ref.pointer, start, count);
        //return getAllocSegment().allocString(ref.pointer, start, count);
    }

    public KPointerInfo getPointer(KReference ref) throws RemoteException {
        return ref.memorySegment.getPointer(ref.pointer);
    }

    public void arraycopy(KReference src, int srcPos, KReference dest, int destPos, int length) throws RemoteException {
        dest.memorySegment.arraycopy(src, srcPos, dest.pointer, destPos, length);
    }

    public KReference allocString(String value) throws RemoteException {
        return getAllocSegment().allocString(value);
    }

    private KMemorySegment getAllocSegment() throws RemoteException {
        return Doovos.currentProcess().getMemorySegment();
    }

    private KMemorySegment getSegment(KReference ref) throws RemoteException {
        try {
            return ref.memorySegment;// Doovos.getMemorySegment(ref.segment);
        } catch (UnknownResourceException e) {
            ref.checkReference();
            throw e;
        }
    }

    public void free(KReference ref) throws RemoteException {
        ref.memorySegment.free(ref.pointer);
    }


    public boolean getBoolean(KReference ref) throws RemoteException {
        return ref.memorySegment.getBoolean(ref.pointer);
    }

    public boolean[] getBooleanArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getBooleanArray(ref.pointer);
    }

    public boolean getBooleanArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getBooleanArray(ref.pointer, index);
    }

    public byte getByte(KReference ref) throws RemoteException {
        return ref.memorySegment.getByte(ref.pointer);
    }

    public byte[] getByteArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getByteArray(ref.pointer);
    }

    public byte getByteArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getByteArray(ref.pointer, index);
    }

    public char getChar(KReference ref) throws RemoteException {
        return ref.memorySegment.getChar(ref.pointer);
    }

    public char[] getCharArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getCharArray(ref.pointer);
    }

    public char getCharArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getCharArray(ref.pointer, index);
    }

//    public KObject getClassInfo(KReference ref) throws RemoteException {
//        return ref.memorySegment.getKClassInfo(ref.pointer);
//    }

    public KClass getKClass(KReference ref) throws RemoteException {
        return ref.memorySegment.getKClass(ref.pointer);
    }

    public double getDouble(KReference ref) throws RemoteException {
        return ref.memorySegment.getDouble(ref.pointer);
    }

    public double[] getDoubleArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getDoubleArray(ref.pointer);
    }

    public double getDoubleArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getDoubleArray(ref.pointer, index);
    }

    public float getFloat(KReference ref) throws RemoteException {
        return ref.memorySegment.getFloat(ref.pointer);
    }

    public float[] getFloatArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getFloatArray(ref.pointer);
    }

    public float getFloatArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getFloatArray(ref.pointer, index);
    }

    public int getInt(KReference ref) throws RemoteException {
        return ref.memorySegment.getInt(ref.pointer);
    }

    public int[] getIntArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getIntArray(ref.pointer);
    }

    public int getIntArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getIntArray(ref.pointer, index);
    }

    public long getLong(KReference ref) throws RemoteException {
        return ref.memorySegment.getLong(ref.pointer);
    }

    public long[] getLongArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getLongArray(ref.pointer);
    }

    public long getLongArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getLongArray(ref.pointer, index);
    }

//    public KObject getObject(KReference ref) throws RemoteException {
//        return ref.memorySegment.getObject(ref.pointer);
//    }

    public KReference getReference(KReference ref) throws RemoteException {
        return ref.memorySegment.getReference(ref.pointer);
    }

    public KReference getReferenceArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getReferenceArray(ref.pointer, index);
    }

    public short getShort(KReference ref) throws RemoteException {
        return ref.memorySegment.getShort(ref.pointer);
    }

    public short[] getShortArray(KReference ref) throws RemoteException {
        return ref.memorySegment.getShortArray(ref.pointer);
    }

    public short getShortArray(KReference ref, int index) throws RemoteException {
        return ref.memorySegment.getShortArray(ref.pointer, index);
    }

    public String getString(KReference ref) throws RemoteException {
        return ref.memorySegment.getString(ref.pointer);
    }

    public void setBoolean(KReference ref, boolean value) throws RemoteException {
        ref.memorySegment.setBoolean(ref.pointer, value);
    }

    public void setBooleanArray(KReference ref, int index, boolean value) throws RemoteException {
        ref.memorySegment.setBooleanArray(ref.pointer, index, value);
    }

    public void setBooleanArray(KReference ref, boolean[] value) throws RemoteException {
        ref.memorySegment.setBooleanArray(ref.pointer, value);
    }

    public void setByte(KReference ref, byte value) throws RemoteException {
        ref.memorySegment.setByte(ref.pointer, value);
    }

    public void setByteArray(KReference ref, int index, byte value) throws RemoteException {
        ref.memorySegment.setByteArray(ref.pointer, index, value);
    }

    public void setByteArray(KReference ref, byte[] value) throws RemoteException {
        ref.memorySegment.setByteArray(ref.pointer, value);
    }

    public void setByteArray(KReference ref, int refOffest, byte[] value, int valOffset, int len) throws RemoteException {
        ref.memorySegment.setByteArray(ref.pointer, refOffest, value, valOffset, len);
    }

    public void setChar(KReference ref, char value) throws RemoteException {
        ref.memorySegment.setChar(ref.pointer, value);
    }

    public void setCharArray(KReference ref, int index, char value) throws RemoteException {
        ref.memorySegment.setCharArray(ref.pointer, index, value);
    }

    public void setCharArray(KReference ref, char[] value) throws RemoteException {
        ref.memorySegment.setCharArray(ref.pointer, value);
    }

//    public void setClassInfo(KReference ref, KObject value) throws RemoteException {
//        ref.memorySegment.setClassInfo(ref.pointer, value);
//    }

    public void setDouble(KReference ref, double value) throws RemoteException {
        ref.memorySegment.setDouble(ref.pointer, value);
    }

    public void setDoubleArray(KReference ref, int index, double value) throws RemoteException {
        ref.memorySegment.setDoubleArray(ref.pointer, index, value);
    }

    public void setDoubleArray(KReference ref, double[] value) throws RemoteException {
        ref.memorySegment.setDoubleArray(ref.pointer, value);
    }

    public void setFloat(KReference ref, float value) throws RemoteException {
        ref.memorySegment.setFloat(ref.pointer, value);
    }

    public void setFloatArray(KReference ref, int index, float value) throws RemoteException {
        ref.memorySegment.setFloatArray(ref.pointer, index, value);
    }

    public void setInt(KReference ref, int value) throws RemoteException {
        ref.memorySegment.setInt(ref.pointer, value);
    }

    public void setFloatArray(KReference ref, float[] value) throws RemoteException {
        ref.memorySegment.setFloatArray(ref.pointer, value);
    }

    public void setIntArray(KReference ref, int index, int value) throws RemoteException {
        ref.memorySegment.setIntArray(ref.pointer, index, value);
    }

    public void setIntArray(KReference ref, int[] value) throws RemoteException {
        ref.memorySegment.setIntArray(ref.pointer, value);
    }

    public void setLong(KReference ref, long value) throws RemoteException {
        ref.memorySegment.setLong(ref.pointer, value);
    }

    public void setLongArray(KReference ref, int index, long value) throws RemoteException {
        ref.memorySegment.setLongArray(ref.pointer, index, value);
    }

    public void setLongArray(KReference ref, long[] value) throws RemoteException {
        ref.memorySegment.setLongArray(ref.pointer, value);
    }

//    public void setObject(KReference ref, KObject value) throws RemoteException {
//        ref.memorySegment.setObject(ref.pointer, value);
//    }


    public void setReference(KReference ref, KReference value) throws RemoteException {
        ref.memorySegment.setReference(ref.pointer, value);
    }

    public void setReferenceArray(KReference ref, int index, KReference value) throws RemoteException {
        ref.memorySegment.setReferenceArray(ref.pointer, index, value);
    }

    public void setReferenceArray(KReference ref, KReference[] value) throws RemoteException {
        ref.memorySegment.setReferenceArray(ref.pointer, value);
    }

    public void setShort(KReference ref, short value) throws RemoteException {
        ref.memorySegment.setShort(ref.pointer, value);
    }

    public void setShortArray(KReference ref, int index, short value) throws RemoteException {
        ref.memorySegment.setShortArray(ref.pointer, index, value);
    }

    public void setShortArray(KReference ref, short[] value) throws RemoteException {
        ref.memorySegment.setShortArray(ref.pointer, value);
    }


//    public void setObjectArrayItem(DRegisterReference ref, int arrayIndex, DObject value) throws RemoteException {
//        ref.memorySegment.setObjectArrayItem(ref.pointer, arrayIndex, value);
//    }
//    public DRegisterReference allocObjectArray(DClassRef classRef, int size) throws RemoteException {
//        return getAllocSegment().allocObjectArray(classRef, size);
//    }

//    public DObject getArrayItem(DRegisterReference ref, int arrayIndex) throws RemoteException {
//        return ref.memorySegment.getArrayItem(ref.pointer,arrayIndex);
//    }

    //

    public int getArraySize(KReference ref) throws RemoteException {
        return ref.memorySegment.getArraySize(ref.pointer);
    }

    public boolean getFieldBoolean(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldBoolean(ref.pointer, fieldOffset);
    }

    public byte getFieldByte(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldByte(ref.pointer, fieldOffset);
    }

    public char getFieldChar(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldChar(ref.pointer, fieldOffset);
    }

    public double getFieldDouble(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldDouble(ref.pointer, fieldOffset);
    }

    public float getFieldFloat(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldFloat(ref.pointer, fieldOffset);
    }

    public int getFieldInt(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldInt(ref.pointer, fieldOffset);
    }

    public long getFieldLong(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldLong(ref.pointer, fieldOffset);
    }

    public KReference getFieldReference(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldReference(ref.pointer, fieldOffset);
    }

    public KReference getStringIntern(KReference ref) throws RemoteException {
        return ref.memorySegment.getStringIntern(ref.pointer);
    }
    
    public short getFieldShort(KReference ref, int fieldOffset) throws RemoteException {
        return ref.memorySegment.getFieldShort(ref.pointer, fieldOffset);
    }

    public void setFieldBoolean(KReference ref, int fieldOffset, boolean value) throws RemoteException {
        ref.memorySegment.setFieldBoolean(ref.pointer, fieldOffset,value);
    }

    public void setFieldByte(KReference ref, int fieldOffset, byte value) throws RemoteException {
        ref.memorySegment.setFieldByte(ref.pointer, fieldOffset,value);
    }

    public void setFieldChar(KReference ref, int fieldOffset, char value) throws RemoteException {
        ref.memorySegment.setFieldChar(ref.pointer, fieldOffset,value);
    }

    public void setFieldDouble(KReference ref, int fieldOffset, double value) throws RemoteException {
        ref.memorySegment.setFieldDouble(ref.pointer, fieldOffset,value);
    }

    public void setFieldFloat(KReference ref, int fieldOffset, float value) throws RemoteException {
        ref.memorySegment.setFieldFloat(ref.pointer, fieldOffset,value);
    }

    public void setFieldInt(KReference ref, int fieldOffset, int value) throws RemoteException {
        ref.memorySegment.setFieldInt(ref.pointer, fieldOffset,value);
    }

    public void setFieldLong(KReference ref, int fieldOffset, long value) throws RemoteException {
        ref.memorySegment.setFieldLong(ref.pointer, fieldOffset,value);
    }

    public void setFieldReference(KReference ref, int fieldOffset, KReference value) throws RemoteException {
        ref.memorySegment.setFieldReference(ref.pointer, fieldOffset,value);
    }

    public void setFieldShort(KReference ref, int fieldOffset, short value) throws RemoteException {
        ref.memorySegment.setFieldShort(ref.pointer, fieldOffset,value);
    }



}
