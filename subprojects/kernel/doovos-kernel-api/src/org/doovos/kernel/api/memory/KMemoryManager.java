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

import org.doovos.kernel.api.jvm.reflect.KClass;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 15 janv. 2009
 * Time: 17:56:14
 * To change this template use File | Settings | File Templates.
 */
public interface KMemoryManager {
//    public void addDependency(DPath path) throws RemoteException;
//
//    public void removeDependency(DPath path) throws RemoteException;

    KReference allocInt() throws RemoteException;

    KReference allocLong() throws RemoteException;

    KReference allocByte() throws RemoteException;

    KReference allocChar() throws RemoteException;

    KReference allocBoolean() throws RemoteException;

    KReference allocDouble() throws RemoteException;

    KReference allocShort() throws RemoteException;

    KReference allocFloat() throws RemoteException;

//    KReference allocRef(KClass classRef) throws RemoteException;

    KReference allocRefArray(KClass classRef, int size) throws RemoteException;


    public void free(KReference ref) throws RemoteException;

//////////////////////////////////////////////////////
// INT
//////////////////////////////////////////////////////

    public KReference allocIntArray(int size) throws RemoteException;

    public int getInt(KReference ref) throws RemoteException;

    public int[] getIntArray(KReference ref) throws RemoteException;

    public void setInt(KReference ref, int value) throws RemoteException;

    public void setIntArray(KReference ref, int[] value) throws RemoteException;

    int getIntArray(KReference ref, int index) throws RemoteException;

    void setIntArray(KReference ref, int index, int value) throws RemoteException;

//////////////////////////////////////////////////////
// SHORT
//////////////////////////////////////////////////////

    public KReference allocShortArray(int size) throws RemoteException;

    public short getShort(KReference ref) throws RemoteException;

    public short[] getShortArray(KReference ref) throws RemoteException;

    public void setShort(KReference ref, short value) throws RemoteException;

    public void setShortArray(KReference ref, short[] value) throws RemoteException;

    public short getShortArray(KReference ref, int index) throws RemoteException;

    public void setShortArray(KReference ref, int index, short value) throws RemoteException;

//////////////////////////////////////////////////////
// LONG
//////////////////////////////////////////////////////

    public KReference allocLongArray(int size) throws RemoteException;

    public long getLong(KReference ref) throws RemoteException;

    public long[] getLongArray(KReference ref) throws RemoteException;

    public void setLong(KReference ref, long value) throws RemoteException;

    public void setLongArray(KReference ref, long[] value) throws RemoteException;

    long getLongArray(KReference ref, int index) throws RemoteException;

    void setLongArray(KReference ref, int index, long value) throws RemoteException;

//////////////////////////////////////////////////////
// BYTE
//////////////////////////////////////////////////////

    public KReference allocByteArray(int size) throws RemoteException;

    public byte getByte(KReference ref) throws RemoteException;

    public byte[] getByteArray(KReference ref) throws RemoteException;

    public byte getByteArray(KReference ref, int index) throws RemoteException;

    public void setByte(KReference ref, byte value) throws RemoteException;

    public void setByteArray(KReference ref, byte[] value) throws RemoteException;

    public void setByteArray(KReference ref, int refOffest, byte[] value, int valOffset, int len) throws RemoteException;

    void setByteArray(KReference ref, int index, byte value) throws RemoteException;

//////////////////////////////////////////////////////
// CHAR
//////////////////////////////////////////////////////

    public KReference allocCharArray(char[] value) throws RemoteException;

    public KReference allocCharArray(int size) throws RemoteException;

    public char getChar(KReference ref) throws RemoteException;

    public char[] getCharArray(KReference ref) throws RemoteException;

    public void setChar(KReference ref, char value) throws RemoteException;

    public void setCharArray(KReference ref, char[] value) throws RemoteException;

    char getCharArray(KReference ref, int index) throws RemoteException;

    void setCharArray(KReference ref, int index, char value) throws RemoteException;

//////////////////////////////////////////////////////
// BOOLEAN
//////////////////////////////////////////////////////

    public KReference allocBooleanArray(int size) throws RemoteException;

    public boolean getBoolean(KReference ref) throws RemoteException;

    public boolean[] getBooleanArray(KReference ref) throws RemoteException;

    public void setBoolean(KReference ref, boolean value) throws RemoteException;

    public void setBooleanArray(KReference ref, boolean[] value) throws RemoteException;

    boolean getBooleanArray(KReference ref, int index) throws RemoteException;

    void setBooleanArray(KReference ref, int index, boolean value) throws RemoteException;

//////////////////////////////////////////////////////
// DOUBLE
//////////////////////////////////////////////////////

    public KReference allocDoubleArray(int size) throws RemoteException;

    public double getDouble(KReference ref) throws RemoteException;

    public double[] getDoubleArray(KReference ref) throws RemoteException;

    public void setDouble(KReference ref, double value) throws RemoteException;

    public void setDoubleArray(KReference ref, double[] value) throws RemoteException;

    double getDoubleArray(KReference ref, int index) throws RemoteException;

    void setDoubleArray(KReference ref, int index, double value) throws RemoteException;


//////////////////////////////////////////////////////
// FLOAT
//////////////////////////////////////////////////////

    public KReference allocFloatArray(int size) throws RemoteException;

    public float getFloat(KReference ref) throws RemoteException;

    public float[] getFloatArray(KReference ref) throws RemoteException;

    public void setFloat(KReference ref, float value) throws RemoteException;

    public void setFloatArray(KReference ref, float[] value) throws RemoteException;

    float getFloatArray(KReference ref, int index) throws RemoteException;

    void setFloatArray(KReference ref, int index, float value) throws RemoteException;

    public KReference allocObject(KClass classRef) throws RemoteException;

//    public KObject getObject(KReference ref) throws RemoteException;

    public KClass getKClass(KReference ref) throws RemoteException;

//    public void setObject(KReference ref, KObject value) throws RemoteException;

    public KReference allocClass(KClass classRef) throws RemoteException;

//    public KObject getClassInfo(KReference ref) throws RemoteException;

//    public void setClassInfo(KReference ref, KObject value) throws RemoteException;

    public KReference getReference(KReference ref) throws RemoteException;

    public KReference getReferenceArray(KReference ref, int index) throws RemoteException;

    public void setReference(KReference ref, KReference value) throws RemoteException;

    public void setReferenceArray(KReference ref, int index, KReference value) throws RemoteException;

    public void setReferenceArray(KReference ref, KReference[] value) throws RemoteException;

//    public void setObjectArrayItem(DRegisterReference ref, int arrayIndex,DObject value) throws RemoteException;
//    public DRegisterReference allocObjectArray(DClassRef classRef, int size) throws RemoteException ;

    //    public DObject getArrayItem(DRegisterReference ref, int arrayIndex) throws RemoteException;

    public int getArraySize(KReference ref) throws RemoteException;


    public String getString(KReference ref) throws RemoteException;

    public KReference allocString(String value) throws RemoteException;

    public KReference allocString(KReference ref, int start, int count) throws RemoteException;


    public KPointerInfo getPointer(KReference ref) throws RemoteException;

    public void arraycopy(KReference src, int srcPos, KReference dest, int destPos, int length) throws RemoteException;


    public void setFieldLong(KReference ref, int fieldOffset, long value) throws RemoteException ;

    public long getFieldLong(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldInt(KReference ref, int fieldOffset, int value) throws RemoteException ;

    public int getFieldInt(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldShort(KReference ref, int fieldOffset, short value) throws RemoteException ;

    public short getFieldShort(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldByte(KReference ref, int fieldOffset, byte value) throws RemoteException ;

    public byte getFieldByte(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldChar(KReference ref, int fieldOffset, char value) throws RemoteException ;

    public char getFieldChar(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldBoolean(KReference ref, int fieldOffset, boolean value) throws RemoteException ;

    public boolean getFieldBoolean(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldFloat(KReference ref, int fieldOffset, float value) throws RemoteException ;

    public float getFieldFloat(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldDouble(KReference ref, int fieldOffset, double value) throws RemoteException ;

    public double getFieldDouble(KReference ref, int fieldOffset) throws RemoteException ;

    public void setFieldReference(KReference ref, int fieldOffset, KReference value) throws RemoteException ;

    public KReference getFieldReference(KReference ref, int fieldOffset) throws RemoteException ;
    
    public KReference getStringIntern(KReference ref) throws RemoteException;
}
