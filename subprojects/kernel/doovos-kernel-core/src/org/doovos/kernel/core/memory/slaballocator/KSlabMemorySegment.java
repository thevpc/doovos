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
package org.doovos.kernel.core.memory.slaballocator;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.io.stream.KOutputStream;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.memory.KAbstractMemorySegment;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.core.util.LongKeyHashMap;

/**
 * Memory segment implementation as Slab allocator.
 * Actually it's a very specific
 * <p/>
 * unit is byte (8 bits)
 */
public class KSlabMemorySegment extends KAbstractMemorySegment {

    private static final KMemoryManager MEMORY_MANAGER = Doovos.getSystem().getMemoryManager();
    //    private final static long LONG_MASK = 0xffffffffL;
    //    private final static long LONG_H_MASK = 0xffff0000L;
    //    private final static long LONG_L_MASK = 0x0000ffffL;
    final LongKeyHashMap<ObjectPointer> objPointers = new LongKeyHashMap<ObjectPointer>(1000);
    final int defaultSlabObjectsCount = 128;
    long size;
    SlabAllocator slabAllocator;
    PageAllocator pageAllocator;
    final Map<String, ObjectPointer> cachedStrings = new HashMap<String, ObjectPointer>(1000);

    public KSlabMemorySegment() throws RemoteException {
        super();
    }

    @Override
    public void init(KProcess process, KSegmentDef options) throws RemoteException {
        super.init(process, options);
        this.size = options.size < 0 ? (512 * 1024 * 1024) : options.size; // 512Mo if not specified
        pageAllocator = new PageAllocator(this);
        slabAllocator = new SlabAllocator(this);
    }

    public static boolean acceptOptions(KMemorySegment.Options options) {
        return !options.isGrowable() && !options.isReadOnly() && !options.isShrinkable();
    }

    public KPointerInfo getPointer(long offset) throws RemoteException {
        ObjectPointer var = objPointers.get(offset);
        if (var == null) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
        return var;
    }

    public final ObjectPointer getPrivatePointer(long offset) {
        ObjectPointer var = objPointers.get(offset);
        if (var == null) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
        return var;
    }

    private Slab getSlab(long offset) {
        ObjectPointer var = objPointers.get(offset);
        try {
            return var.slab;
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public int getOptions() throws RemoteException {
        return Options.DEFAULT;
    }

    public boolean isGrowable() throws RemoteException {
        return false;
    }

    public boolean isShrinkable() throws RemoteException {
        return false;
    }

    public boolean isReadOnly() throws RemoteException {
        return false;
    }

    public void resize(long newSize) throws RemoteException {
        throw new IllegalArgumentException("Not resizable");
    }

//////////////////////////////////////////////////////
// INTEGER
//////////////////////////////////////////////////////
    public KReference allocInt() throws RemoteException {
        return slabAllocator.allocNativeInt(1, INTEGER).reference;
    }

    public KReference allocIntArray(int size) throws RemoteException {
        return slabAllocator.allocNativeInt(size, INTEGER_ARRAY).reference;
    }

    public int getInt(long offset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabInteger) (p.slab)).getValue(p);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public int[] getIntArray(long offset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabInteger) (p.slab)).getArray(p);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setInt(long offset, int value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabInteger) (p.slab)).setValue(p, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setIntArray(long offset, int[] value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabInteger) (p.slab)).setArray(p, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public int getIntArray(long offset, int index) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabInteger) (p.slab)).getValue(p, index);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setIntArray(long offset, int index, int value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabInteger) (p.slab)).setValue(p, index, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

//////////////////////////////////////////////////////
// SHORT
//////////////////////////////////////////////////////
    public KReference allocShort() throws RemoteException {
        return slabAllocator.allocNativeShort(1, SHORT).reference;
    }

    public KReference allocShortArray(int size) throws RemoteException {
        return slabAllocator.allocNativeShort(size, SHORT_ARRAY).reference;
    }

    public short getShort(long offset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabShort) (p.slab)).getValue(p);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public short[] getShortArray(long offset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabShort) (p.slab)).getArray(p);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setShort(long offset, short value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabShort) (p.slab)).setValue(p, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setShortArray(long offset, short[] value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabShort) (p.slab)).setArray(p, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public short getShortArray(long offset, int index) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabShort) (p.slab)).getValue(p, index);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setShortArray(long offset, int index, short value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabShort) (p.slab)).setValue(p, index, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

//////////////////////////////////////////////////////
// LONG
    //////////////////////////////////////////////////////
//    public KReference allocRef(KClass classRef) throws RemoteException {
//        KClass ref = getProcess().getClassRepository().createReference(classRef);
//        return new KReference(
//                getSegmentId(),
//                slabAllocator.allocNative(KObjectType.t_ref, 1, ref).offset
//        );
//    }
    public KReference allocRefArray(KClass classRef, int size) throws RemoteException {
        KClass r = classRef.toArray();
        return slabAllocator.allocNativeRef(size, r).reference;
    }

    public KReference allocLong() throws RemoteException {
        return slabAllocator.allocNativeLong(1, LONG).reference;
    }

    public KReference allocLongArray(int size) throws RemoteException {
        return slabAllocator.allocNativeLong(size, LONG_ARRAY).reference;
    }

    public long getLong(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabLong) (p.slab)).getValue(p);
    }

    public long[] getLongArray(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabLong) (p.slab)).getArray(p);
    }

    public void setLong(long offset, long value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabLong) (p.slab)).setValue(p, value);
    }

    public void setFieldLong(long offset, int fieldOffset, long value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabObj) (p.slab)).setFieldLong(p, fieldOffset, value);
    }

    public long getFieldLong(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj) (p.slab)).getFieldLong(p, fieldOffset);
    }

    public void setFieldInt(long pointer, int fieldOffset, int value) throws RemoteException {
        ObjectPointer p = objPointers.get(pointer);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabObj) (p.slab)).setFieldInt(p, fieldOffset, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, pointer));
        }
    }

    public int getFieldInt(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj) (p.slab)).getFieldInt(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldByte(long pointer, int fieldOffset, byte value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj) (p.slab)).setFieldByte(p, fieldOffset, value);
    }

    public byte getFieldByte(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj) (p.slab)).getFieldByte(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldBoolean(long pointer, int fieldOffset, boolean value) throws RemoteException {
        ObjectPointer p = objPointers.get(pointer);
        //ObjectPointer p = getPrivatePointer(pointer);
        try {
            ((SlabObj) (p.slab)).setFieldBoolean(p, fieldOffset, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, pointer));
        }
    }

    public boolean getFieldBoolean(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj) (p.slab)).getFieldBoolean(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldShort(long pointer, int fieldOffset, short value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj) (p.slab)).setFieldShort(p, fieldOffset, value);
    }

    public short getFieldShort(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj) (p.slab)).getFieldShort(p, fieldOffset);
    }

    public void setFieldChar(long pointer, int fieldOffset, char value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj) (p.slab)).setFieldChar(p, fieldOffset, value);
    }

    public char getFieldChar(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj) (p.slab)).getFieldChar(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldFloat(long pointer, int fieldOffset, float value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj) (p.slab)).setFieldFloat(p, fieldOffset, value);
    }

    public float getFieldFloat(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj) (p.slab)).getFieldFloat(p, fieldOffset);
    }

    public void setFieldDouble(long pointer, int fieldOffset, double value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj) (p.slab)).setFieldDouble(p, fieldOffset, value);
    }

    public double getFieldDouble(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj) (p.slab)).getFieldDouble(p, fieldOffset);
    }

    public KReference getFieldReference(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj) (p.slab)).getFieldReference(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldReference(long offset, int fieldOffset, KReference ref) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabObj) (p.slab)).setFieldReference(p, fieldOffset, ref);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setLongArray(long offset, long[] value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabLong) (p.slab)).setArray(p, value);
    }

    public long getLongArray(long offset, int index) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabLong) (p.slab)).getValue(p, index);
    }

    public void setLongArray(long offset, int index, long value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabLong) (p.slab)).setValue(p, index, value);
    }

//////////////////////////////////////////////////////
// BYTE
//////////////////////////////////////////////////////
    public KReference allocByte() throws RemoteException {
        return slabAllocator.allocNativeByte(1, BYTE).reference;
    }

    public KReference allocByteArray(int size) throws RemoteException {
        return slabAllocator.allocNativeByte(size, BYTE_ARRAY).reference;
    }

    public byte getByte(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabByte) (p.slab)).getValue(p);
    }

    public byte[] getByteArray(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabByte) (p.slab)).getArray(p);
    }

    public void setByte(long offset, byte value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabByte) (p.slab)).setValue(p, value);
    }

    public void setByteArray(long offset, byte[] value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabByte) (p.slab)).setArray(p, value);
    }

    public void setByteArray(long offset, int refOffset, byte[] value, int voffset, int len) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabByte) (p.slab)).setArray(p, refOffset, value, voffset, len);
    }

    public byte getByteArray(long offset, int index) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabByte) (p.slab)).getValue(p, index);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setByteArray(long offset, int index, byte value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabByte) (p.slab)).setValue(p, index, value);
    }

    public KReference allocCharArray(char[] value) throws RemoteException {
        ObjectPointer p = slabAllocator.allocNativeChar(value.length, CHAR_ARRAY);
        ((SlabChar) (p.slab)).setArray(p, value);
        return p.reference;
    }

//////////////////////////////////////////////////////
// CHAR
//////////////////////////////////////////////////////
    public KReference allocChar() throws RemoteException {
        return slabAllocator.allocNativeChar(1, CHAR).reference;
    }

    public KReference allocCharArray(int size) throws RemoteException {
        return slabAllocator.allocNativeChar(size, CHAR_ARRAY).reference;
    }

    public char getChar(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabChar) (p.slab)).getValue(p);
    }

    public char[] getCharArray(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabChar) (p.slab)).getArray(p);
    }

    public void setChar(long offset, char value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabChar) (p.slab)).setValue(p, value);
    }

    public void setCharArray(long offset, char[] value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabChar) (p.slab)).setArray(p, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public char getCharArray(long offset, int index) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabChar) (p.slab)).getValue(p, index);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setCharArray(long offset, int index, char value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabChar) (p.slab)).setValue(p, index, value);
    }

//////////////////////////////////////////////////////
// BOOLEAN
//////////////////////////////////////////////////////
    public KReference allocBoolean() throws RemoteException {
        return slabAllocator.allocNativeBoolean(1, BOOLEAN).reference;
    }

    public KReference allocBooleanArray(int size) throws RemoteException {
        return slabAllocator.allocNativeBoolean(size, BOOLEAN_ARRAY).reference;
    }

    public boolean getBoolean(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabBoolean) (p.slab)).getValue(p);
    }

    public boolean[] getBooleanArray(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabBoolean) (p.slab)).getArray(p);
    }

    public void setBoolean(long offset, boolean value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabBoolean) (p.slab)).setValue(p, value);
    }

    public void setBooleanArray(long offset, boolean[] value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabBoolean) (p.slab)).setArray(p, value);
    }

    public boolean getBooleanArray(long offset, int index) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabBoolean) (p.slab)).getValue(p, index);
    }

    public void setBooleanArray(long offset, int index, boolean value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabBoolean) (p.slab)).setValue(p, index, value);
    }

//////////////////////////////////////////////////////
// DOUBLE
//////////////////////////////////////////////////////
    public KReference allocDouble() throws RemoteException {
        return slabAllocator.allocNativeDouble(1, DOUBLE).reference;
    }

    public KReference allocDoubleArray(int size) throws RemoteException {
        return slabAllocator.allocNativeDouble(size, DOUBLE_ARRAY).reference;
    }

    public double getDouble(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabDouble) (p.slab)).getValue(p);
    }

    public double[] getDoubleArray(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabDouble) (p.slab)).getArray(p);
    }

    public void setDouble(long offset, double value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabDouble) (p.slab)).setValue(p, value);
    }

    public void setDoubleArray(long offset, double[] value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabDouble) (p.slab)).setArray(p, value);
    }

    public double getDoubleArray(long offset, int index) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabDouble) (p.slab)).getValue(p, index);
    }

    public void setDoubleArray(long offset, int index, double value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabDouble) (p.slab)).setValue(p, index, value);
    }

//////////////////////////////////////////////////////
// FLOAT
//////////////////////////////////////////////////////
    public KReference allocFloat() throws RemoteException {
        return slabAllocator.allocNativeFloat(1, FLOAT).reference;
    }

    public KReference allocFloatArray(int size) throws RemoteException {
        return slabAllocator.allocNativeFloat(size, FLOAT_ARRAY).reference;
    }

    public float getFloat(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabFloat) (p.slab)).getValue(p);
    }

    public float[] getFloatArray(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabFloat) (p.slab)).getArray(p);
    }

    public void setFloat(long offset, float value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabFloat) (p.slab)).setValue(p, value);
    }

    public void setFloatArray(long offset, float[] value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabFloat) (p.slab)).setArray(p, value);
    }

    public float getFloatArray(long offset, int index) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabFloat) (p.slab)).getValue(p, index);
    }

    public void setFloatArray(long offset, int index, float value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabFloat) (p.slab)).setValue(p, index, value);
    }

    public KReference allocObject(KClass classRef) throws RemoteException {
        return slabAllocator.allocObj(1, classRef).reference;
//        switch (classRef.getType()) {
//            case t_boolean: {
//                return allocBoolean();
//            }
//            case t_byte: {
//                return allocByte();
//            }
//            case t_char: {
//                return allocChar();
//            }
//            case t_double: {
//                return allocDouble();
//            }
//            case t_float: {
//                return allocFloat();
//            }
//            case t_int: {
//                return allocInt();
//            }
//            case t_long: {
//                return allocLong();
//            }
////            case t_ref: {
////                return allocRef(classRef);
////            }
//            case t_short: {
//                return allocShort();
//            }
//            case t_string: {
//                return new KReference(
//                        getSegmentId(),
//                        slabAllocator.allocObj(1, classRef).offset
//                );
//            }
//            case t_obj: {
//                return new KReference(
//                        getSegmentId(),
//                        slabAllocator.allocObj(1, classRef).offset
//                );
//            }
//        }
//        throw new IllegalArgumentException("Unsupported allocObject(" + classRef + ")");
    }

    public KReference allocClass(KClass classRef) throws RemoteException {
        switch (classRef.getType()) {
            case t_obj: {
                KReference kReference = slabAllocator.allocClass(1, classRef).reference;
                getGarbageCollector().incReferencesCount(kReference);
                return kReference;
            }
        }
        throw new IllegalArgumentException("Unsupported allocObject(" + classRef + ")");
    }

//    public DRegisterReference allocObjectArray(DClassRef classRef, int size) throws RemoteException {
//        switch (classRef.getType()) {
//            case t_boolean:
//                return allocBooleanArray(size);
//            case t_byte:
//                return allocByteArray(size);
//            case t_char:
//                return allocCharArray(size);
//            case t_double:
//                return allocDoubleArray(size);
//            case t_float:
//                return allocFloatArray(size);
//            case t_int:
//                return allocIntArray(size);
//            case t_long:
//                return allocLongArray(size);
//            case t_ref: {
//                DClassRef r = DClassRef.createRefArray(classRef);
//                return new DRegisterReference(
//                        getSegmentId(),
//                        slabAllocator.allocObj(classRef.getByteSize(), size, r).offset
//                );
//            }
//            case t_string:
//            case t_obj: {
//                DClassRef r = DClassRef.createRefArray(classRef);
//                return
//                        new DRegisterReference(
//                                getSegmentId(),
//                                slabAllocator.allocObj(classRef.getByteSize(), size, r).offset
//                        );
//            }
//        }
//        throw new IllegalArgumentException("Unsupported allocObjectArray(" + classRef + ")");
//    }
    public KReference getReference(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabRef) p.slab).getValue(p);
    }

//    public KObject getObject(long offset) throws RemoteException {
//        ObjectPointer p = getPrivatePointer(offset);
//        return (p.slab).getObject(p);
//    }
//    public KObject getKClassInfo(long offset) throws RemoteException {
//        ObjectPointer p = getPrivatePointer(offset);
//        return (p.slab).getObject(p);
//    }
//    public void setObject(long offset, KObject value) throws RemoteException {
//        //some check?
//        ObjectPointer p = getPrivatePointer(offset);
//        p.slab.setObject(p, value);
//    }
//    public void setClassInfo(long offset, KObject value) throws RemoteException {
//        //some check?
//        ObjectPointer p = getPrivatePointer(offset);
//        p.slab.setObject(p, value);
//    }
    public void setReference(long offset, KReference value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        KClass classRefToPut;
        if (value.segment == id) {
            classRefToPut = getPrivatePointer(value.pointer).classRef;
        } else {
            classRefToPut = MEMORY_MANAGER.getKClass(value);
        }
        if (classRefToPut.equals(p.classRef.getReferenceTo())) {
            ((SlabRef) p.slab).setValue(p, value);
        } else {
            throw new KMemoryException("Class Cast Exception : Expected " + p.classRef + " but got " + classRefToPut);
        }
    }

    public void setReferenceArray(long offset, int index, KReference value) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabRef) p.slab).setValue(p, index, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setReferenceArray(long offset, KReference[] value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabRef) (p.slab)).setArray(p, value);
    }

    public KClass getKClass(long offset) throws RemoteException {
        return getPrivatePointer(offset).classRef;
    }

//    public void setObjectArrayItem(long offset, int arrayIndex, DObject value) throws RemoteException {
//        //some check?
//        ObjectPointer p = slabAllocator.getPointer(offset);
//        DClassRef foundClass = null;
//        switch (value.getType()) {
//            case t_ref: {
//                DRegisterReference valueRef = value.refValue();
//                ObjectPointer p0 = slabAllocator.getPointer(valueRef.pointer);
//                foundClass = slabAllocator.getPointer(p0.offset).classRef;
//                break;
//            }
//            default: {
//                ObjectPointer p0 = slabAllocator.getPointer(offset);
//                foundClass = slabAllocator.getPointer(p0.offset).classRef;
//                break;
//            }
//        }
//        DClassRef requiredClass = p.classRef.getReferenceTo();
//        if (!requiredClass.isAssignableFrom(foundClass)) {
//            throw new ClassCastException("foundClass : " + foundClass + " ; requiredClass=" + requiredClass);
//        }
//        p.slab.setArrayItem(p, arrayIndex, value);
//
//    }
    public KReference getReferenceArray(long offset, int arrayIndex) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabRef) p.slab).getValue(p, arrayIndex);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        } catch (ClassCastException e) {
            System.err.println(getPointer(offset).getKClass().getName());
            throw e;
        }
    }

    public KReference[] getReferenceArray(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabRef) (p.slab)).getArray(p);
    }

//    public KObject getArrayItem(long offset, int arrayIndex) throws RemoteException {
//        //some check?
//        ObjectPointer p = getPrivatePointer(offset);
//        return p.slab.getArrayItem(p, arrayIndex);
//    }
    public int getArraySize(long offset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return p.objectCount;
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

//////////////////////////////////////////////////////
// STRING
//////////////////////////////////////////////////////
    public KReference allocString(String value) throws RemoteException {
        ObjectPointer pointer = cachedStrings.get(value);
        KReference stringReference;
        if (pointer != null) {
            stringReference = pointer.reference;
            return stringReference;
        } else {
            pointer = slabAllocator.allocObj(1, STRING);
            pointer.stringValue = value;
            stringReference = pointer.reference;
            KReference charsReference = allocCharArray(value.toCharArray());
//            KClass clazz = getStringClassRef();
//            KObject dObject = getObject(pointer.offset);
//            KGarbageCollector gc0 = getGC();
//            if (charsReference.isNull()) {
//                throw new IllegalArgumentException();
//            }
            initString(stringReference, charsReference, 0, value.length());
//            string_value.setInstanceValue(stringReference, charsReference);
//            string_offset.setInstanceValue(stringReference, KInteger.ZERO);
//            string_count.setInstanceValue(stringReference, new KInteger(value.length()));
//            setObject(pointer.offset, dObject);
            cachedStrings.put(value, pointer);
            return stringReference;
        }
    }

    private void initString(KReference stringReference, KReference chars, int offset, int count) throws RemoteException {
        KMemorySegment s = stringReference.memorySegment;
        long pointer = stringReference.pointer;
        s.setFieldReference(pointer, string_value__offset, chars);
        s.setFieldInt(pointer, string_offset__offset, offset);
        s.setFieldInt(pointer, string_count__offset, count);
//        s.setFieldObject(stringReference.pointer, string_value.getDefinition().getByteOffset(), chars);
//        s.setFieldInt(stringReference.pointer, string_offset.getDefinition().getByteOffset(), offset);
//        s.setFieldInt(stringReference.pointer, string_count.getDefinition().getByteOffset(), count);
    }

    public KReference getStringIntern(long offset) throws RemoteException {
        ObjectPointer pointer = getPrivatePointer(offset);
        String s = pointer.stringValue;// getString(offset);
        if (s == null) {
            //some times?
            KReference strRef = pointer.reference;
            KReference charsRef = string_value.getInstanceRef(strRef);
//            if (charsRef.isNull()) {
//                //This happens when debugg calls the method before the string is initialized
//                s = "$<NON_INITIALIZED>$";
//            } else {
            char[] chars = MEMORY_MANAGER.getCharArray(charsRef);
            s = new String(chars);
//            }
            pointer.stringValue = s;
        }
        ObjectPointer pointerIntern = cachedStrings.get(s);
        if (pointerIntern == null) {
            //TODO REMOVE ME, should always be non null
            cachedStrings.put(s, pointer);
            return pointer.reference;
        }
        return pointerIntern.reference;
    }

    public String getString(long offset) throws RemoteException {
        ObjectPointer pointer = getPrivatePointer(offset);
        String s = pointer.stringValue;
        if (s == null) {
            //some times?
            KReference strRef = pointer.reference;
            KReference charsRef = string_value.getInstanceRef(strRef);
//            if (charsRef.isNull()) {
//                //This happens when debugg calls the method before the string is initialized
//                s = "$<NON_INITIALIZED>$";
//            } else {
            char[] chars = MEMORY_MANAGER.getCharArray(charsRef);
            s = new String(chars);
//            }
            pointer.stringValue = s;
        }
        return s;
//        ObjectPointer objectPointer = getPrivatePointer(offset);
//        KReference strRef = objectPointer.reference;
//        KReference charsRef = (KReference) string_value.getInstanceValue(strRef);
//        if (charsRef.isNull()) {
//            //This happens when debugg calls the method before the string is initialized
//            return "$<NON_INITIALIZED>$";
//        }
//        char[] chars = Doovos.getSystem().getMemoryManager().getCharArray(charsRef);
//        return new String(chars);
    }

//    private void debugDump() {
//        try {
//            PrintStream out = new PrintStream(new File("/home/vpc/Desktop/mem-" + getName() + ".txt"));
//            out.print(getDebugString());
//            out.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    public int getStringLength(long offset) throws RemoteException {
//        ObjectPointer objectPointer = getPrivatePointer(offset);
//        KReference strRef = objectPointer.reference;
//        KInteger count = (KInteger) string_count.getInstanceValue(strRef);
//        return count.value;
//    }
//
    public KReference allocString(long oldOffset, int start, int count) throws RemoteException {
//        KClass clazz = getStringClassRef();
        KReference oldRef = getPrivatePointer(oldOffset).reference;
        KReference oldValueRef = string_value.getInstanceRef(oldRef);
        int oldValueOffset = string_offset.getInstanceInt(oldRef);
//        DRegisterInteger oldValueCount=(DRegisterInteger) clazz.getInstanceFieldValueAsRegister("count", oldRef);
        char[] oldValue = MEMORY_MANAGER.getCharArray(oldValueRef);
        String oldValueString = new String(oldValue);
        String newValueString = oldValueString.substring(start, start + count);
        ObjectPointer pointer = cachedStrings.get(newValueString);
        KReference stringReference;
        if (pointer != null) {
            stringReference = pointer.reference;
            return stringReference;
        } else {
            pointer = slabAllocator.allocObj(1, STRING);
            pointer.stringValue = newValueString;
            stringReference = pointer.reference;
//            KGarbageCollector gc0 = getGC();
            initString(stringReference, oldValueRef, start + oldValueOffset, count);

            //string_value.setInstanceValue(stringReference, oldValueRef);
            //string_offset.setInstanceValue(stringReference, new KInteger(start + oldValueOffset.value));
            //string_count.setInstanceValue(stringReference, new KInteger(count));

            cachedStrings.put(newValueString, pointer);
            return stringReference;
        }
    }

//////////////////////////////////////////////////////
// GENERAL
//////////////////////////////////////////////////////
    public long freeMemorySize() throws RemoteException {
        return slabAllocator.freeSize;
    }

    public long freePageSize() throws RemoteException {
        return pageAllocator.freeSize;
    }

    public long freeObjSize() throws RemoteException {
        return slabAllocator.freeSize;
    }

    public void free(long offset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        getGC().forceFree(p.reference);
        slabAllocator.freeObj(offset);
    }

    public long maxMemorySize() throws RemoteException {
        return size;
    }

    public void dump(KOutputStream out) throws RemoteException {
        out.write("Memory{");
        out.write("\ttotalSize=");
        out.write(size);
        out.write("\n");
        out.write("\tmap{\n");
        //out.write(indent(getMemoryString().trim(), "\t\t"));
        out.write("\t}\n");
        out.write(indent(pageAllocator.toString(), "\t"));
        out.write(indent(slabAllocator.toString(), "\t"));
        out.write("}");
    }

    public String getDebugString() {
        StringBuilder sb = new StringBuilder("Memory{");
        sb.append("\ttotalSize=").append(size).append("\n");
        sb.append("\tmap{\n");
        sb.append(indent(getMemoryString().trim(), "\t\t"));
        sb.append("\t}\n");
        sb.append(indent(pageAllocator.toString(), "\t"));
        sb.append(indent(slabAllocator.toString(), "\t"));
        sb.append("}");
        return sb.toString();
    }

    public String getMemoryString() {
        return getMemoryString(16, " ", 1);
    }

    public String getMemoryString(int lineLength, String separator, int group) {
        StringBuilder sb = new StringBuilder();
        int line = 0;
        boolean first = true;
        int groupCounter = 0;
        long size0 = size;
        LongKeyHashMap<ObjectPointer> objPointers0 = objPointers;
        for (long i = 0; i < size0; i++) {
            ObjectPointer objectPointer = objPointers0.get(i);
            if (objectPointer == null) {
                if (first) {
                    first = false;
                } else {
                    groupCounter++;
                    if (groupCounter == group) {
                        groupCounter = 0;
                        sb.append(separator);
                    }
                }
                sb.append("00");
                line++;
                if (line == lineLength) {
                    sb.append("\n");
                }
            } else {
                byte[] bytes = objectPointer.slab.toBytes(objectPointer);
                for (byte aByte : bytes) {
                    if (first) {
                        first = false;
                    } else {
                        groupCounter++;
                        if (groupCounter == group) {
                            groupCounter = 0;
                            sb.append(separator);
                        }
                    }
                    String str = Integer.toHexString(aByte);
                    if (str.length() < 2) {
                        sb.append("0");
                    }
                    sb.append(str);
                    line++;
                    if (line == lineLength) {
                        sb.append("\n");
                    }
                }
                i += bytes.length - 1;
            }
        }
        return sb.toString();
    }

    public static String indent(String s) {
        return indent(s, "\t");
    }

    public static String indent(String s, String prefix) {
        String[] t = s.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String s1 : t) {
            sb.append(prefix);
            sb.append(s1);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    protected void freeImpl() throws RemoteException {
        super.freeImpl();
    }

    public Collection<? extends KPointerInfo> getPointers() throws RemoteException {
        return objPointers.values();
    }

    @Override
    public void arraycopyself(long src, int srcPos, long dest, int destPos, int length) throws RemoteException {
        ObjectPointer s = objPointers.get(src);
        ObjectPointer d = objPointers.get(dest);
        Slab slabsrc = null;
        Slab slabdest = null;
        try {
            slabsrc = s.slab;
            slabdest = d.slab;
        } catch (NullPointerException e) {
            s = getPrivatePointer(src);
            d = getPrivatePointer(dest);
        }
        System.arraycopy(slabsrc.buffer(), srcPos + s.objectOffset, slabdest.buffer(), destPos + d.objectOffset, length);
    }

    public KReference byteArray2ref(byte[] array, int offset) {
        try {
            long segment = ((array[offset]) & 255L) << 56 | ((array[offset + 1]) & 255L) << 48 | ((array[offset + 2]) & 255L) << 40 | ((array[offset + 3]) & 255L) << 32 | ((array[offset + 4]) & 255L) << 24 | ((array[offset + 5]) & 255L) << 16 | ((array[offset + 6]) & 255L) << 8 | ((array[offset + 7]) & 255L);
            if (segment == 0) {
                return KReference.NULL;
            }
            long pointer = ((array[offset + 8]) & 255L) << 56 | ((array[offset + 9]) & 255L) << 48 | ((array[offset + 10]) & 255L) << 40 | ((array[offset + 11]) & 255L) << 32 | ((array[offset + 12]) & 255L) << 24 | ((array[offset + 13]) & 255L) << 16 | ((array[offset + 14]) & 255L) << 8 | ((array[offset + 15]) & 255L);
            //        return new KReference(
            //                byteArray2long(array, offset),
            //                byteArray2long(array, offset + 8)
            //        );
            return new KReference(segment == id ? this : Doovos.getSystem().getMemorySegment(segment), segment, pointer);
            //Doovos.syslog("byteArray2Ref "+ref);
            //return ref;
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
    }

    public KReference intArray2ref(int[] array, int offset) {
        try {
            long segment = KMemoryUtilities.intArray2long(array, offset);
            if (segment == 0) {
                return KReference.NULL;
            }
            long pointer = KMemoryUtilities.intArray2long(array, offset + 2);
            //        return new KReference(
            //                byteArray2long(array, offset),
            //                byteArray2long(array, offset + 8)
            //        );
            if (segment == id) {
                return new KReference(this, segment, pointer);

            } else {
                return new KReference(Doovos.getSystem().getMemorySegment(segment), segment, pointer);
            }
            //Doovos.syslog("byteArray2Ref "+ref);
            //return ref;
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
    }
//    public Collection<ObjectPointer> getObjectPointers() {
//        return objPointers.values();
//    }
}
