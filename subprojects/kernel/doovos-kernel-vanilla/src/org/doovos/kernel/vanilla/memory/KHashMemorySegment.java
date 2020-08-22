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
//package org.doovos.kernel.vanilla.memory;
//
//import org.doovos.kernel.api.Doovos;
//import org.doovos.kernel.api.jvm.reflect.KClass;
//import org.doovos.kernel.api.memory.*;
//import org.doovos.kernel.api.process.KProcess;
//import org.doovos.kernel.api.io.stream.KOutputStream;
//
//import java.io.Serializable;
//import java.rmi.RemoteException;
//import java.util.*;
//import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
//
//import org.doovos.kernel.core.memory.KAbstractMemorySegment;
//import org.doovos.kernel.core.util.KUtils;
//import org.doovos.kernel.core.util.LongKeyHashMap;
//
///**
// * Memory segment implementation as Slab allocator.
// * Acyually ot's a very specific
// * <p/>
// * unit is byte (8 bits)
// */
//public class KHashMemorySegment extends KAbstractMemorySegment {
//
//    private static final KMemoryManager MEMORY_MANAGER = Doovos.getSystem().getMemoryManager();
//    //    private final static long LONG_MASK = 0xffffffffL;
//    //    private final static long LONG_H_MASK = 0xffff0000L;
//    //    private final static long LONG_L_MASK = 0x0000ffffL;
//    private int globalOffset = 0;
//    private long size;
//    private Map<String, ObjectPointer> cachedStrings = new HashMap<String, ObjectPointer>();
//    private LongKeyHashMap<ObjectPointer> objPointers = new LongKeyHashMap<ObjectPointer>();
//    private ObjectPointerPool objPointerPool = new ObjectPointerPool();
//    private long freeSize;
//
//    public KHashMemorySegment() throws RemoteException {
//        super();
//    }
//
//    public void init(KProcess process, KSegmentDef options) throws RemoteException {
//        super.init(process, options);
//        this.size = options.size < 0 ? (512 * 1024 * 1024) : options.size; // 512Mo if not specified
//        this.freeSize = size;
//    }
//
//    private class ObjectPointerPool extends Pool<ObjectPointer> {
//
//        public ObjectPointer createInstance() {
//            return new ObjectPointer();
//        }
//    }
//
//    public static boolean acceptOptions(Options options) {
//        return !options.isGrowable() && !options.isReadOnly() && !options.isShrinkable();
//    }
//
//    public int getOptions() throws RemoteException {
//        return Options.DEFAULT;
//    }
//
//    public boolean isGrowable() throws RemoteException {
//        return false;
//    }
//
//    public boolean isShrinkable() throws RemoteException {
//        return false;
//    }
//
//    public boolean isReadOnly() throws RemoteException {
//        return false;
//    }
//
//    public void resize(long newSize) throws RemoteException {
//        throw new IllegalArgumentException("Not resizable");
//    }
//
////////////////////////////////////////////////////////
//// INTEGER
////////////////////////////////////////////////////////
//    public long getSegmentId() throws RemoteException {
//        return id;
//    }
//
//    public KReference allocInt() throws RemoteException {
//        return allocPointer(1, INTEGER, 0).reference;
//    }
//
//    public KReference allocIntArray(int size) throws RemoteException {
//        return allocPointer(size, INTEGER_ARRAY, new int[size]).reference;
//    }
//
//    public int getInt(long offset) throws RemoteException {
//        return (Integer) getPrivatePointer(offset).value;
//    }
//
//    public int[] getIntArray(long offset) throws RemoteException {
//        return (int[]) getPrivatePointer(offset).value;
//    }
//
//    public void setInt(long offset, int value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setIntArray(long offset, int[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public int getIntArray(long offset, int index) throws RemoteException {
//        return ((int[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setIntArray(long offset, int index, int value) throws RemoteException {
//        ((int[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// SHORT
////////////////////////////////////////////////////////
//    public KReference allocShort() throws RemoteException {
//        return allocPointer(1, SHORT, 0).reference;
//    }
//
//    public KReference allocShortArray(int size) throws RemoteException {
//        return allocPointer(size, SHORT_ARRAY, new short[size]).reference;
//    }
//
//    public short getShort(long offset) throws RemoteException {
//        return (Short) getPrivatePointer(offset).value;
//    }
//
//    public short[] getShortArray(long offset) throws RemoteException {
//        return (short[]) getPrivatePointer(offset).value;
//    }
//
//    public void setShort(long offset, short value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setShortArray(long offset, short[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public short getShortArray(long offset, int index) throws RemoteException {
//        return ((short[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setShortArray(long offset, int index, short value) throws RemoteException {
//        ((short[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// REF
////////////////////////////////////////////////////////
////    public KReference allocRef(KClass classRef) throws RemoteException {
////        KClass ref = getProcess().getClassRepository().createReference(classRef);
////        return new KReference(
////                getSegmentId(),
////                allocPointer(1, ref, null).offset
////        );
////    }
//    public KReference allocRefArray(KClass classRef, int size) throws RemoteException {
//        KClass ref = classRef.toArray();
//        KReference[] value = new KReference[size];
//        int max = value.length;
//        for (int i = 0; i < max; i++) {
//            value[i] = KReference.NULL;
//        }
//        return allocPointer(size, ref, value).reference;
//    }
//
//    public KReference getReference(long offset) throws RemoteException {
//        return (KReference) getPrivatePointer(offset).value;
//    }
//
//    public void setReference(long offset, KReference value) throws RemoteException {
//        ObjectPointer p = getPrivatePointer(offset);
//        KClass classRefToPut;
//        if (value.segment == getSegmentId()) {
//            classRefToPut = getPrivatePointer(value.pointer).classRef;
//        } else {
//            classRefToPut = MEMORY_MANAGER.getKClass(value);
//        }
//        if (classRefToPut.equals(p.classRef.getReferenceTo())) {
//            p.value = value;
//        } else {
//            throw new KMemoryException("Class Cast Exception : Expected " + p.classRef + " but got " + classRefToPut);
//        }
//    }
//
//    public void setReferenceArray(long offset, int index, KReference value) throws RemoteException {
//        ((KReference[]) getPrivatePointer(offset).value)[index] = value;
//    }
//
//    public void setReferenceArray(long offset, KReference[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public KReference getReferenceArray(long offset, int arrayIndex) throws RemoteException {
//        return ((KReference[]) getPrivatePointer(offset).value)[arrayIndex];
//    }
//
//    public KReference[] getReferenceArray(long offset) throws RemoteException {
//        return (KReference[]) getPrivatePointer(offset).value;
//    }
//
////////////////////////////////////////////////////////
//// LONG
////////////////////////////////////////////////////////
//    public KReference allocLong() throws RemoteException {
//        return allocPointer(1, LONG, 0).reference;
//    }
//
//    public KReference allocLongArray(int size) throws RemoteException {
//        return allocPointer(size, LONG_ARRAY, new long[size]).reference;
//    }
//
//    public long getLong(long offset) throws RemoteException {
//        return (Short) getPrivatePointer(offset).value;
//    }
//
//    public long[] getLongArray(long offset) throws RemoteException {
//        return (long[]) getPrivatePointer(offset).value;
//    }
//
//    public void setLong(long offset, long value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setLongArray(long offset, long[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public long getLongArray(long offset, int index) throws RemoteException {
//        return ((long[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setLongArray(long offset, int index, long value) throws RemoteException {
//        ((long[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// BYTE
////////////////////////////////////////////////////////
//    public KReference allocByte() throws RemoteException {
//        return allocPointer(1, BYTE, 0).reference;
//    }
//
//    public KReference allocByteArray(int size) throws RemoteException {
//        return allocPointer(size, BYTE_ARRAY, new byte[size]).reference;
//    }
//
//    public byte getByte(long offset) throws RemoteException {
//        return (Byte) getPrivatePointer(offset).value;
//    }
//
//    public byte[] getByteArray(long offset) throws RemoteException {
//        return (byte[]) getPrivatePointer(offset).value;
//    }
//
//    public void setByte(long offset, byte value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setByteArray(long offset, byte[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setByteArray(long offset, int refOffest, byte[] value, int valOffset, int len) throws RemoteException {
//        byte[] dest = (byte[]) getPrivatePointer(offset).value;
//        System.arraycopy(value, valOffset, dest, refOffest, len);
//    }
//
//    public byte getByteArray(long offset, int index) throws RemoteException {
//        return ((byte[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setByteArray(long offset, int index, byte value) throws RemoteException {
//        ((byte[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// CHAR
////////////////////////////////////////////////////////
//    public KReference allocChar() throws RemoteException {
//        return allocPointer(1, CHAR, 0).reference;
//    }
//
//    public KReference allocCharArray(int size) throws RemoteException {
//        return allocPointer(size, CHAR_ARRAY, new char[size]).reference;
//    }
//
//    public KReference allocCharArray(char[] chars) throws RemoteException {
//        return allocPointer(chars.length, CHAR_ARRAY, chars).reference;
//    }
//
//    public char getChar(long offset) throws RemoteException {
//        return (Character) getPrivatePointer(offset).value;
//    }
//
//    public char[] getCharArray(long offset) throws RemoteException {
//        return (char[]) getPrivatePointer(offset).value;
//    }
//
//    public void setChar(long offset, char value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setCharArray(long offset, char[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public char getCharArray(long offset, int index) throws RemoteException {
//        return ((char[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setCharArray(long offset, int index, char value) throws RemoteException {
//        ((char[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// BOOLEAN
////////////////////////////////////////////////////////
//    public KReference allocBoolean() throws RemoteException {
//        return allocPointer(1, BOOLEAN, 0).reference;
//    }
//
//    public KReference allocBooleanArray(int size) throws RemoteException {
//        return  allocPointer(size, BOOLEAN_ARRAY, new boolean[size]).reference;
//    }
//
//    public boolean getBoolean(long offset) throws RemoteException {
//        return (Boolean) getPrivatePointer(offset).value;
//    }
//
//    public boolean[] getBooleanArray(long offset) throws RemoteException {
//        return (boolean[]) getPrivatePointer(offset).value;
//    }
//
//    public void setBoolean(long offset, boolean value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setBooleanArray(long offset, boolean[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public boolean getBooleanArray(long offset, int index) throws RemoteException {
//        return ((boolean[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setBooleanArray(long offset, int index, boolean value) throws RemoteException {
//        ((boolean[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// DOUBLE
////////////////////////////////////////////////////////
//    public KReference allocDouble() throws RemoteException {
//        return allocPointer(1, DOUBLE, 0).reference;
//    }
//
//    public KReference allocDoubleArray(int size) throws RemoteException {
//        return allocPointer(size, DOUBLE_ARRAY, new double[size]).reference;
//    }
//
//    public double getDouble(long offset) throws RemoteException {
//        return (Double) getPrivatePointer(offset).value;
//    }
//
//    public double[] getDoubleArray(long offset) throws RemoteException {
//        return (double[]) getPrivatePointer(offset).value;
//    }
//
//    public void setDouble(long offset, double value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setDoubleArray(long offset, double[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public double getDoubleArray(long offset, int index) throws RemoteException {
//        return ((double[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setDoubleArray(long offset, int index, double value) throws RemoteException {
//        ((double[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// FLOAT
////////////////////////////////////////////////////////
//    public KReference allocFloat() throws RemoteException {
//        return  allocPointer(1, FLOAT, 0).reference;
//    }
//
//    public KReference allocFloatArray(int size) throws RemoteException {
//        return  allocPointer(size, FLOAT_ARRAY, new float[size]).reference;
//    }
//
//    public float getFloat(long offset) throws RemoteException {
//        return (Float) getPrivatePointer(offset).value;
//    }
//
//    public float[] getFloatArray(long offset) throws RemoteException {
//        return (float[]) getPrivatePointer(offset).value;
//    }
//
//    public void setFloat(long offset, float value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public void setFloatArray(long offset, float[] value) throws RemoteException {
//        getPrivatePointer(offset).value = value;
//    }
//
//    public float getFloatArray(long offset, int index) throws RemoteException {
//        return ((float[]) getPrivatePointer(offset).value)[index];
//    }
//
//    public void setFloatArray(long offset, int index, float value) throws RemoteException {
//        ((float[]) (getPrivatePointer(offset).value))[index] = value;
//    }
//
////////////////////////////////////////////////////////
//// OBJECT
//    //////////////////////////////////////////////////////
//    public KReference allocObject(KClass classRef) throws RemoteException {
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
//            }
//            case t_obj: {
//                return  allocPointer(1, classRef, KUtils.createObject(classRef.getDefinition().createInstanceBytes(), 1)).reference;
//            }
//        }
//        throw new IllegalArgumentException("Unsupported allocObject(" + classRef + ")");
//    }
//
//    public KReference allocClass(KClass classRef) throws RemoteException {
//        switch (classRef.getType()) {
//            case t_obj: {
//                KReference kReference =  allocPointer(1, classRef, KUtils.createObject(classRef.getDefinition().createClassBytes(), 1)).reference;
//                getGarbageCollector().incReferencesCount(kReference);
//                return kReference;
//            }
//        }
//        throw new IllegalArgumentException("Unsupported allocObject(" + classRef + ")");
//    }
//
////    public DRegisterReference allocObjectArray(DClassRef classRef, int size) throws RemoteException {
////        switch (classRef.getType()) {
////            case t_boolean:
////                return allocBooleanArray(size);
////            case t_byte:
////                return allocByteArray(size);
////            case t_char:
////                return allocCharArray(size);
////            case t_double:
////                return allocDoubleArray(size);
////            case t_float:
////                return allocFloatArray(size);
////            case t_int:
////                return allocIntArray(size);
////            case t_long:
////                return allocLongArray(size);
////            case t_ref: {
////                DClassRef r = DClassRef.createRefArray(classRef);
////                return new DRegisterReference(
////                        getSegmentId(),
////                        slabAllocator.allocObj(classRef.getByteSize(), size, r).offset
////                );
////            }
////            case t_string:
////            case t_obj: {
////                DClassRef r = DClassRef.createRefArray(classRef);
////                return
////                        new DRegisterReference(
////                                getSegmentId(),
////                                slabAllocator.allocObj(classRef.getByteSize(), size, r).offset
////                        );
////            }
////        }
////        throw new IllegalArgumentException("Unsupported allocObjectArray(" + classRef + ")");
////    }
//    public KObject getObject(long offset) throws RemoteException {
//        ObjectPointer p = getPrivatePointer(offset);
//        Object v = p.value;
//        if (v instanceof KObject) {
//            return (KObject) v;
//        }
//        if (v instanceof KReference) {
//            KReference r = (KReference) v;
//            if (r.isNull()) {
//                return null;
//            }
//        }
//        return KUtils.createObject(v);
//    }
//
//    public int getFieldInt(long offset, int fieldOffset) throws RemoteException {
//        return KMemoryUtilities.byteArray2int(getObject(offset).getContent(), fieldOffset);
//    }
//
//    public long getFieldLong(long offset, int fieldOffset) throws RemoteException {
//        return KMemoryUtilities.byteArray2long(getObject(offset).getContent(), fieldOffset);
//    }
//
//    public void setFieldInt(long offset, int fieldOffset, int value) throws RemoteException {
//        KObject o = getObject(offset);
//        byte[] d = o.getContent();
//        KMemoryUtilities.int2byteArray(value, d, fieldOffset);
//        setObject(offset, o);
//    }
//
//    public void setFieldLong(long offset, int fieldOffset, long value) throws RemoteException {
//        KObject o = getObject(offset);
//        byte[] d = o.getContent();
//        KMemoryUtilities.long2byteArray(value, d, fieldOffset);
//        setObject(offset, o);
//    }
//
//    public boolean getFieldBoolean(long pointer, int fieldOffset) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public byte getFieldByte(long pointer, int fieldOffset) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public char getFieldChar(long pointer, int fieldOffset) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public double getFieldDouble(long pointer, int fieldOffset) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public float getFieldFloat(long pointer, int fieldOffset) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public short getFieldShort(long pointer, int fieldOffset) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void setFieldBoolean(long pointer, int fieldOffset, boolean value) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void setFieldByte(long pointer, int fieldOffset, byte value) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void setFieldChar(long pointer, int fieldOffset, char value) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void setFieldDouble(long pointer, int fieldOffset, double value) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void setFieldFloat(long pointer, int fieldOffset, float value) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void setFieldShort(long pointer, int fieldOffset, short value) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public KReference getFieldObject(long offset, int fieldOffset) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void setFieldObject(long offset, int fieldOffset, KReference ref) throws RemoteException {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
////    public KObject getKClassInfo(long offset) throws RemoteException {
////        ObjectPointer p = getPrivatePointer(offset);
////        Object v = p.value;
////        if (v instanceof KObject) {
////            return (KObject) v;
////        }
////        if (v instanceof KReference) {
////            KReference r = (KReference) v;
////            if (r.isNull()) {
////                return null;
////            }
////        }
////        return KUtils.createObject(v);
////    }
////
////    public void setObject(long offset, KObject value) throws RemoteException {
////        //some check?
////        ObjectPointer p = getPrivatePointer(offset);
////        p.value = value;
////    }
//
////    public void setClassInfo(long offset, KObject value) throws RemoteException {
////        //some check?
////        ObjectPointer p = getPrivatePointer(offset);
////        p.value = value;
////    }
//
//    public KClass getKClass(long offset) throws RemoteException {
//        return getPrivatePointer(offset).classRef;
//    }
//
////    public void setObjectArrayItem(long offset, int arrayIndex, DObject value) throws RemoteException {
////        //some check?
////        ObjectPointer p = slabAllocator.getPointer(offset);
////        DClassRef foundClass = null;
////        switch (value.getType()) {
////            case t_ref: {
////                DRegisterReference valueRef = value.refValue();
////                ObjectPointer p0 = slabAllocator.getPointer(valueRef.pointer);
////                foundClass = slabAllocator.getPointer(p0.offset).classRef;
////                break;
////            }
////            default: {
////                ObjectPointer p0 = slabAllocator.getPointer(offset);
////                foundClass = slabAllocator.getPointer(p0.offset).classRef;
////                break;
////            }
////        }
////        DClassRef requiredClass = p.classRef.getReferenceTo();
////        if (!requiredClass.isAssignableFrom(foundClass)) {
////            throw new ClassCastException("foundClass : " + foundClass + " ; requiredClass=" + requiredClass);
////        }
////        p.slab.setArrayItem(p, arrayIndex, value);
////
////    }
////    public KObject getArrayItem(long offset, int arrayIndex) throws RemoteException {
////        //some check?
////        ObjectPointer p = slabAllocator.getObjectPointer2(offset);
////        return p.slab.getArrayItem(p, arrayIndex);
////    }
//    public int getArraySize(long offset) throws RemoteException {
//        ObjectPointer p = getPrivatePointer(offset);
//        return p.objectCount;
//    }
//
////////////////////////////////////////////////////////
//// STRING
////////////////////////////////////////////////////////
//    public KReference allocString(String value) throws RemoteException {
//        ObjectPointer pointer = cachedStrings.get(value);
//        KReference stringReference;
//        if (pointer != null) {
//            stringReference = pointer.reference;
//            return stringReference;
//        } else {
//            KObject objValue = KUtils.createObject(STRING.getDefinition().createInstanceBytes(), 1);
//            pointer = allocPointer(1, STRING, objValue);
//            stringReference = pointer.reference;
//            KReference charsReference = allocCharArray(value.toCharArray());
////            KObject dObject = objValue;//getObject(pointer.offset);
////            KGarbageCollector gc0 = getGC();
//            string_value.setInstanceValue(stringReference, charsReference);
//            string_offset.setInstanceValue(stringReference, KInteger.ZERO);
//            string_count.setInstanceValue(stringReference, new KInteger(value.length()));
//            //setObject(pointer.offset,dObject);
//            cachedStrings.put(value, pointer);
//            pointer.stringReference = value;
//            return stringReference;
//        }
//    }
//
//    public KReference getStringIntern(long offset) throws RemoteException {
//        String s = getString(offset);
//        ObjectPointer objectPointer = cachedStrings.get(s);
//        if (objectPointer == null) {
//            ObjectPointer pointer = (ObjectPointer) getPointer(offset);
//            //TODO REMOVE ME, should always be non null
//            cachedStrings.put(s, pointer);
//            return pointer.reference;
//        }
//        return objectPointer.reference;
//    }
//
//    public String getString(long offset) throws RemoteException {
//        ObjectPointer objectPointer = getPrivatePointer(offset);
//        KReference strRef = objectPointer.reference;
//        KReference charsRef = (KReference) string_value.getInstanceValue(strRef);
//        char[] chars = MEMORY_MANAGER.getCharArray(charsRef);
//        return new String(chars);
//    }
//
////    private void debugDump() {
////        try {
////            PrintStream out = new PrintStream(new File("/home/vpc/Desktop/mem-" + getName() + ".txt"));
////            out.print(getDebugString());
////            out.close();
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        }
////    }
//    public int getStringLength(long offset) throws RemoteException {
//        ObjectPointer objectPointer = getPrivatePointer(offset);
//        KReference strRef = objectPointer.reference;
//        KInteger count = (KInteger) string_count.getInstanceValue(strRef);
//        return count.value;
//    }
//
//    public KReference allocString(long oldOffset, int start, int count) throws RemoteException {
//        KReference oldRef = getPrivatePointer(oldOffset).reference;
//        KReference oldValueRef = (KReference) string_value.getInstanceValue(oldRef);
//        KInteger oldValueOffset = (KInteger) string_offset.getInstanceValue(oldRef);
////        DRegisterInteger oldValueCount=(DRegisterInteger) clazz.getInstanceFieldValueAsRegister("count", oldRef);
//        char[] oldValue = MEMORY_MANAGER.getCharArray(oldValueRef);
//        String oldValueString = new String(oldValue);
//        String newValueString = oldValueString.substring(start, start + count);
//        ObjectPointer pointer = cachedStrings.get(newValueString);
//        KReference stringReference;
//        if (pointer != null) {
//            stringReference = pointer.reference;
//            return stringReference;
//        } else {
//            pointer = allocPointer(1, STRING, STRING.getDefinition().createInstanceBytes());
//            stringReference = pointer.reference;
////            KGarbageCollector gc0 = getGC();
//            string_value.setInstanceValue(stringReference, oldValueRef);
//            string_offset.setInstanceValue(stringReference, new KInteger(start + oldValueOffset.value));
//            string_count.setInstanceValue(stringReference, new KInteger(count));
//            return stringReference;
//        }
//    }
//
////////////////////////////////////////////////////////
//// GENERAL
////////////////////////////////////////////////////////
//    public long freeMemorySize() throws RemoteException {
//        return freeSize;
//    }
//
//    public void free(long offset) throws RemoteException {
//        getGC().forceFree(getPrivatePointer(offset).reference);
//        ObjectPointer objectPointer = objPointers.remove(offset);
//        freeSize += objectPointer.objectCount * objectPointer.getByteSize();
//
//        if (objectPointer.stringReference != null) {
//            ObjectPointer objectPointer2 = cachedStrings.get(objectPointer.stringReference);
//            if (objectPointer.equals(objectPointer2)) {
//                cachedStrings.remove(objectPointer.stringReference);
//            }
//        }
//    }
//
//    private static class ObjectPointer implements KPointerInfo {
//
//        private KReference reference;
//        private long offset;
//        private int objectCount;
//        private KClass classRef;
//        private Object value;
//        private String stringReference;
//
//        private ObjectPointer() {
//        }
//
////        public KPointerInfo toPointerInfo() {
////            return new KPointerInfoImpl(
////                    this.offset,
////                    this.getByteSize(),
////                    -1,
////                    this.classRef,
////                    this.classRef.getType(),
////                    this.backward
////            );
////        }
//        public int getSize() {
//            return classRef.getByteSize();
//        }
//
//        public KClass getKClass() {
//            return classRef;
//        }
//
//        public boolean contains(long offset) {
//            return offset >= this.offset && offset < (this.offset + objectCount);
//        }
//
//        public int getByteSize() {
//            return classRef.getByteSize();
//        }
//
//        public String toString() {
//            return "ObjectPointer(pointer=" + offset + "; arrayCount=" + objectCount + "; type =" + classRef.getType() + "; class " + classRef + "; size=" + getByteSize() + "; value=" + value + ")";
//        }
//
//        public KReference getReference() {
//            return reference;
//        }
//    }
//
//    public long maxMemorySize() throws RemoteException {
//        return size;
//    }
//
//    private static abstract class Pool<T> implements Serializable {
//
//        private int maxPoolSize = 10;
//        private LinkedList<T> pool = new LinkedList<T>();
//
//        public T getPooledInstance() {
//            T i;
//            if (pool.size() > 0) {
//                i = pool.removeFirst();
//            } else {
//                i = createInstance();
//            }
//            return i;
//        }
//
//        public abstract T createInstance();
//
//        void freePooledInstance(T instance) {
//            if (pool.size() < maxPoolSize) {
//                pool.addFirst(instance);
//            }
//        }
//    }
//
//    public void dump(KOutputStream out) throws RemoteException {
//        out.write("Memory{");
//        out.write("\ttotalSize=");
//        out.write(size);
//        out.write("\n");
//        out.write("\tmap{\n");
//        //out.write(indent(getMemoryString().trim(), "\t\t"));
//        out.write("\t}\n");
//        out.write("\n {\n");
//        for (Long aLong : new TreeSet<Long>(objPointers.keySet())) {
//            out.write(" " + objPointers.get(aLong) + "\n");
//        }
//        out.write("\n }\n");
//
//        out.write("}");
//    }
//
//    public String getDebugString() {
//        StringBuilder sb = new StringBuilder("Memory{");
//        sb.append("\ttotalSize=").append(size).append("\n");
//        sb.append("\tmap{\n");
//        sb.append(indent(getMemoryString().trim(), "\t\t"));
//        sb.append("\t}\n");
//        sb.append("\n {\n");
//        for (Long aLong : new TreeSet<Long>(objPointers.keySet())) {
//            sb.append(" ").append(objPointers.get(aLong)).append("\n");
//        }
//        sb.append("\n }\n");
//        sb.append("}");
//        return sb.toString();
//    }
//
//    public String getMemoryString() {
//        return getMemoryString(16, " ", 1);
//    }
//
//    public String getMemoryString(int lineLength, String separator, int group) {
//        StringBuilder sb = new StringBuilder();
//        int line = 0;
//        boolean first = true;
//        int groupCounter = 0;
//        for (long i = 0; i < size; i++) {
//            ObjectPointer objectPointer = objPointers.get(i);
//            if (objectPointer == null) {
//                if (first) {
//                    first = false;
//                } else {
//                    groupCounter++;
//                    if (groupCounter == group) {
//                        groupCounter = 0;
//                        sb.append(separator);
//                    }
//                }
//                sb.append("00");
//                line++;
//                if (line == lineLength) {
//                    sb.append("\n");
//                }
//            } else {
//                //TODO incorrect
//                //was  slab.toBytes(objectPointer)
//                byte[] bytes = objectPointer.value.toString().getBytes();
//                for (byte aByte : bytes) {
//                    if (first) {
//                        first = false;
//                    } else {
//                        groupCounter++;
//                        if (groupCounter == group) {
//                            groupCounter = 0;
//                            sb.append(separator);
//                        }
//                    }
//                    String str = Integer.toHexString(aByte);
//                    if (str.length() < 2) {
//                        sb.append("0");
//                    }
//                    sb.append(str);
//                    line++;
//                    if (line == lineLength) {
//                        sb.append("\n");
//                    }
//                }
//                i += bytes.length - 1;
//            }
//        }
//        return sb.toString();
//    }
//
//    public static String indent(String s) {
//        return indent(s, "\t");
//    }
//
//    public static String indent(String s, String prefix) {
//        String[] t = s.split("\n");
//        StringBuilder sb = new StringBuilder();
//        for (String s1 : t) {
//            sb.append(prefix);
//            sb.append(s1);
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//
//    @Override
//    protected void freeImpl() throws RemoteException {
//        super.freeImpl();
//    }
//
//    private ObjectPointer allocPointer(int count, KClass classRef, Object value) {
//        ObjectPointer objectPointer = objPointerPool.getPooledInstance();
//        objectPointer.offset = globalOffset++;
//        objectPointer.reference = new KReference(this,id, objectPointer.offset);
//        objectPointer.objectCount = count;
//        objectPointer.classRef = classRef;
//        objectPointer.value = value;
//        objPointers.put(objectPointer.offset, objectPointer);
//        freeSize -= classRef.getByteSize() * count;
//        return objectPointer;
//    }
//
//    public ObjectPointer getPrivatePointer(long offset) {
//        ObjectPointer var = objPointers.get(offset);
//        if (var == null) {
//            throw new KInvalidReferenceException(new KReference(this,id,offset));
//        }
//        return var;
//    }
//
//    public KPointerInfo getPointer(long offset) {
//        ObjectPointer var = objPointers.get(offset);
//        if (var == null) {
//            throw new KInvalidReferenceException(new KReference(this,id,offset));
//        }
//        return var;
//    }
//
//    public Collection<? extends KPointerInfo> getPointers() throws RemoteException {
//        return Collections.unmodifiableCollection(objPointers.values());
//    }
//}
