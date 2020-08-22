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
import org.doovos.kernel.api.jvm.KGarbageCollector;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Collection;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.process.KProcess;


/**
 * Main interface for Memory handling
 *
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 11 oct. 2004
 * Time: 13:01:04
 */
public interface KMemorySegment extends KResource {
    
    // prepare cache
    public void prepare() throws RemoteException;


    public int getId() throws RemoteException;

    public void addDependency(String path) throws RemoteException;

    public void removeDependency(String path) throws RemoteException;

    KReference allocInt() throws RemoteException;

    KReference allocLong() throws RemoteException;

    KReference allocByte() throws RemoteException;

    KReference allocChar() throws RemoteException;

    KReference allocBoolean() throws RemoteException;

    KReference allocDouble() throws RemoteException;

    KReference allocShort() throws RemoteException;

    KReference allocFloat() throws RemoteException;

//    KReference allocRef(KClass classRef) throws RemoteException;

    /**
     * create an array of type classRef.
     *
     * @param classRef type of the array item
     * @param size     size of the array
     * @return reference to the array
     * @throws RemoteException if error
     */
    KReference allocRefArray(KClass classRef, int size) throws RemoteException;

    KReference allocMultiArray(KClass classRef, int[] size) throws RemoteException;


    KReference allocArray(KClass classRef, int size) throws RemoteException;


    public static final class Options implements Serializable {
        public static int DEFAULT = 0;
        public static int READ_ONLY = 1;
        public static int GROWABLE = 2;
        public static int SHRINLABLE = 4;
        private int flags = DEFAULT;

        public Options(int flags) {
            this.flags = flags;
        }

        public Options() {
        }

        public int getFlags() {
            return flags;
        }

        public boolean isReadOnly() {
            return (flags & READ_ONLY) == READ_ONLY;
        }

        public boolean isGrowable() {
            return (flags & GROWABLE) == GROWABLE;
        }

        public boolean isShrinkable() {
            return (flags & SHRINLABLE) == SHRINLABLE;
        }

        public Options setReadOnly(boolean value) {
            if (value) {
                flags &= READ_ONLY;
            } else {
                flags &= ~READ_ONLY;
            }
            return this;
        }

        public Options setGrowable(boolean value) {
            if (value) {
                flags &= GROWABLE;
            } else {
                flags &= ~GROWABLE;
            }
            return this;
        }

        public Options setShrinkable(boolean value) {
            if (value) {
                flags &= SHRINLABLE;
            } else {
                flags &= ~SHRINLABLE;
            }
            return this;
        }
    }

    public KPointerInfo getPointer(long pointer) throws RemoteException;

    public void free(long pointer) throws RemoteException;

    public int getOptions() throws RemoteException;

    public boolean isGrowable() throws RemoteException;

    public boolean isShrinkable() throws RemoteException;

    public boolean isReadOnly() throws RemoteException;

    public void resize(long newSize) throws RemoteException;

    public long maxMemorySize() throws RemoteException;

    public long freeMemorySize() throws RemoteException;

//////////////////////////////////////////////////////
// INT
//////////////////////////////////////////////////////

    public KReference allocIntArray(int size) throws RemoteException;

    public int getInt(long pointer) throws RemoteException;

    public int[] getIntArray(long pointer) throws RemoteException;

    public void setInt(long pointer, int value) throws RemoteException;

    public void setIntArray(long pointer, int[] value) throws RemoteException;

    int getIntArray(long pointer, int index) throws RemoteException;

    void setIntArray(long pointer, int index, int value) throws RemoteException;

//////////////////////////////////////////////////////
// SHORT
//////////////////////////////////////////////////////

    public KReference allocShortArray(int size) throws RemoteException;

    public short getShort(long pointer) throws RemoteException;

    public short[] getShortArray(long pointer) throws RemoteException;

    public void setShort(long pointer, short value) throws RemoteException;

    public void setShortArray(long pointer, short[] value) throws RemoteException;

    public short getShortArray(long pointer, int index) throws RemoteException;

    public void setShortArray(long pointer, int index, short value) throws RemoteException;

//////////////////////////////////////////////////////
// LONG
//////////////////////////////////////////////////////

    public KReference allocLongArray(int size) throws RemoteException;

    public long getLong(long pointer) throws RemoteException;

    public long[] getLongArray(long pointer) throws RemoteException;

    public void setLong(long pointer, long value) throws RemoteException;
    
//    public void setLongField(long pointer, int fieldpointer,long value) throws RemoteException;

    public void setLongArray(long pointer, long[] value) throws RemoteException;

    long getLongArray(long pointer, int index) throws RemoteException;

    void setLongArray(long pointer, int index, long value) throws RemoteException;

//////////////////////////////////////////////////////
// BYTE
//////////////////////////////////////////////////////

    public KReference allocByteArray(int size) throws RemoteException;

    public byte getByte(long pointer) throws RemoteException;

    public byte[] getByteArray(long pointer) throws RemoteException;

    public byte getByteArray(long pointer, int index) throws RemoteException;

    public void setByte(long pointer, byte value) throws RemoteException;

    public void setByteArray(long pointer, byte[] value) throws RemoteException;

    public void setByteArray(long pointer, int refOffest, byte[] value, int valpointer, int len) throws RemoteException;

    void setByteArray(long pointer, int index, byte value) throws RemoteException;

//////////////////////////////////////////////////////
// CHAR
//////////////////////////////////////////////////////

    public KReference allocCharArray(char[] value) throws RemoteException;

    public KReference allocCharArray(int size) throws RemoteException;

    public char getChar(long pointer) throws RemoteException;

    public char[] getCharArray(long pointer) throws RemoteException;

    public void setChar(long pointer, char value) throws RemoteException;

    public void setCharArray(long pointer, char[] value) throws RemoteException;

    char getCharArray(long pointer, int index) throws RemoteException;

    void setCharArray(long pointer, int index, char value) throws RemoteException;

//////////////////////////////////////////////////////
// BOOLEAN
//////////////////////////////////////////////////////

    public KReference allocBooleanArray(int size) throws RemoteException;

    public boolean getBoolean(long pointer) throws RemoteException;

    public boolean[] getBooleanArray(long pointer) throws RemoteException;

    public void setBoolean(long pointer, boolean value) throws RemoteException;

    public void setBooleanArray(long pointer, boolean[] value) throws RemoteException;

    boolean getBooleanArray(long pointer, int index) throws RemoteException;

    void setBooleanArray(long pointer, int index, boolean value) throws RemoteException;

//////////////////////////////////////////////////////
// DOUBLE
//////////////////////////////////////////////////////

    public KReference allocDoubleArray(int size) throws RemoteException;

    public double getDouble(long pointer) throws RemoteException;

    public double[] getDoubleArray(long pointer) throws RemoteException;

    public void setDouble(long pointer, double value) throws RemoteException;

    public void setDoubleArray(long pointer, double[] value) throws RemoteException;

    double getDoubleArray(long pointer, int index) throws RemoteException;

    void setDoubleArray(long pointer, int index, double value) throws RemoteException;


//////////////////////////////////////////////////////
// FLOAT
//////////////////////////////////////////////////////

    public KReference allocFloatArray(int size) throws RemoteException;

    public float getFloat(long pointer) throws RemoteException;

    public float[] getFloatArray(long pointer) throws RemoteException;

    public void setFloat(long pointer, float value) throws RemoteException;

    public void setFloatArray(long pointer, float[] value) throws RemoteException;

    float getFloatArray(long pointer, int index) throws RemoteException;

    void setFloatArray(long pointer, int index, float value) throws RemoteException;

    public KReference allocObject(KClass classRef) throws RemoteException;

//    public KObject getObject(long pointer) throws RemoteException;

    public KClass getKClass(long pointer) throws RemoteException;

//    public void setObject(long pointer, KObject value) throws RemoteException;

    public KReference allocClass(KClass classRef) throws RemoteException;

//    public KObject getKClassInfo(long pointer) throws RemoteException;

//    public void setClassInfo(long pointer, KObject value) throws RemoteException;

    public KReference getReference(long pointer) throws RemoteException;

    public KReference getReferenceArray(long pointer, int index) throws RemoteException;

    public KReference[] getReferenceArray(long pointer) throws RemoteException;

    public void setReference(long pointer, KReference value) throws RemoteException;

    public void setReferenceArray(long pointer, int index, KReference value) throws RemoteException;

    public void setReferenceArray(long pointer, KReference[] value) throws RemoteException;

//    public void setObjectArrayItem(long pointer, int arrayIndex,DObject value) throws RemoteException;
//    public DRegisterReference allocObjectArray(DClassRef classRef, int size) throws RemoteException ;

    //    public DObject getArrayItem(long pointer, int arrayIndex) throws RemoteException;

    public int getArraySize(long pointer) throws RemoteException;

    public KReference getStringIntern(long pointer) throws RemoteException;

    public String getString(long pointer) throws RemoteException;

    public KReference allocString(String value) throws RemoteException;

    public KReference allocString(long oldpointer, int start, int count) throws RemoteException;

    public Collection<? extends KPointerInfo> getPointers() throws RemoteException;

    public KGarbageCollector getGarbageCollector() throws RemoteException;

    public KProcess getProcess() throws RemoteException ;
    

    public void arraycopy(KReference src, int srcPos, long dest, int destPos, int length) throws RemoteException;




    public void setFieldLong(long pointer, int fieldOffset, long value) throws RemoteException ;

    public long getFieldLong(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldInt(long pointer, int fieldOffset, int value) throws RemoteException ;

    public int getFieldInt(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldShort(long pointer, int fieldOffset, short value) throws RemoteException ;

    public short getFieldShort(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldByte(long pointer, int fieldOffset, byte value) throws RemoteException ;

    public byte getFieldByte(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldChar(long pointer, int fieldOffset, char value) throws RemoteException ;

    public char getFieldChar(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldBoolean(long pointer, int fieldOffset, boolean value) throws RemoteException ;

    public boolean getFieldBoolean(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldFloat(long pointer, int fieldOffset, float value) throws RemoteException ;

    public float getFieldFloat(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldDouble(long pointer, int fieldOffset, double value) throws RemoteException ;

    public double getFieldDouble(long pointer, int fieldOffset) throws RemoteException ;

    public void setFieldReference(long pointer, int fieldOffset, KReference ref) throws RemoteException ;

    public KReference getFieldReference(long pointer, int fieldOffset) throws RemoteException ;
}