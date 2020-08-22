//package org.doovos.kernel.depreciated.resource.memory;
//
//import org.doovos.kernel.core.resource.memory.KAbstractMemorySegment;
//import org.doovos.kernel.vm.bytecode.KConstantDef;
//import org.doovos.kernel.resource.device.cpu.register.KReference;
//import org.doovos.kernel.resource.memory.*;
//import org.doovos.kernel.resource.process.KProcess;
//import org.doovos.util.KUtils;
//
//import java.rmi.RemoteException;
//
//
///**
// * Memory segment implementation as Slab allocator.
// * Acyually ot's a very specific
// * <p/>
// * unit is byte (8 bits)
// */
//public class KConstMemorySegment extends KAbstractMemorySegment {
//    private KConstantDef values;
//
//    public KConstMemorySegment(KProcess mainProcess) throws RemoteException {
//        super(mainProcess);
//    }
//
//    public void init(long size, Options options, KConstantDef consts) throws RemoteException {
//        this.values = consts;
//    }
//
//    public static boolean acceptOptions(KMemorySegment.Options options) {
//        return !options.isGrowable() && options.isReadOnly() && !options.isShrinkable();
//    }
//
//    public void resize(long newSize) throws RemoteException {
//        throw new IllegalArgumentException("Not resizable");
//    }
//
//    public int getOptions() throws RemoteException {
//        return Options.READ_ONLY;
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
//        return true;
//    }
//    //////////////////////////////////////////////////////
//// INTEGER
//
//    //////////////////////////////////////////////////////
//
//    public KReference allocIntArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Allocation is not allowed");
//    }
//
//    public int getInt(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Integer) values.initialization[ioffset];
//    }
//
//    public int[] getIntArray(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (int[]) values.initialization[ioffset];
//    }
//
//    public int getIntArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((int[]) values.initialization[ioffset])[index];
//    }
//
//    public void setInt(long offset, int value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setIntArray(long offset, int[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
////////////////////////////////////////////////////////
//// LONG
//
//    //////////////////////////////////////////////////////
//
//    public KReference allocLongArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public long getLong(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Long) values.initialization[ioffset];
//    }
//
//    public long[] getLongArray(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (long[]) values.initialization[ioffset];
//    }
//
//    public void setLong(long offset, long value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setLongArray(long offset, long[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public long getLongArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((long[]) values.initialization[ioffset])[index];
//    }
//
////////////////////////////////////////////////////////
//// BYTE
////////////////////////////////////////////////////////
//
//    public KReference allocByteArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public byte getByte(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Byte) values.initialization[ioffset];
//    }
//
//    public byte[] getByteArray(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (byte[]) values.initialization[ioffset];
//    }
//
//    public void setByte(long offset, byte value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setByteArray(long offset, byte[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public byte getByteArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((byte[]) values.initialization[ioffset])[index];
//    }
//
////////////////////////////////////////////////////////
//// CHAR
////////////////////////////////////////////////////////
//
//    public KReference allocCharArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public char getChar(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Character) values.initialization[ioffset];
//    }
//
//    public char[] getCharArray(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (char[]) values.initialization[ioffset];
//    }
//
//    public void setChar(long offset, char value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setCharArray(long offset, char[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public char getCharArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((char[]) values.initialization[ioffset])[index];
//    }
//
////////////////////////////////////////////////////////
//// BOOLEAN
////////////////////////////////////////////////////////
//
//    public KReference allocBooleanArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public boolean getBoolean(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Boolean) values.initialization[ioffset];
//    }
//
//    public boolean[] getBooleanArray(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (boolean[]) values.initialization[ioffset];
//    }
//
//    public void setBoolean(long offset, boolean value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setBooleanArray(long offset, boolean[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public boolean getBooleanArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((boolean[]) values.initialization[ioffset])[index];
//    }
//
////////////////////////////////////////////////////////
//// DOUBLE
////////////////////////////////////////////////////////
//
//    public KReference allocDoubleArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public double getDouble(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Double) values.initialization[ioffset];
//    }
//
//    public double[] getDoubleArray(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (double[]) values.initialization[ioffset];
//    }
//
//    public void setDouble(long offset, double value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setDoubleArray(long offset, double[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public double getDoubleArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((double[]) values.initialization[ioffset])[index];
//    }
//
////////////////////////////////////////////////////////
//// SHORT
////////////////////////////////////////////////////////
//
//    public KReference allocShortArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public short getShort(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Short) values.initialization[ioffset];
//    }
//
//    public short[] getShortArray(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (short[]) values.initialization[ioffset];
//    }
//
//    public void setShort(long offset, short value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setShortArray(long offset, short[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setShortArray(long offset, int index,short value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public short getShortArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((short[]) values.initialization[ioffset])[index];
//    }
//
////////////////////////////////////////////////////////
//// FLOAT
////////////////////////////////////////////////////////
//
//    public KReference allocFloatArray(int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public float getFloat(long offset) throws RemoteException {
//        int ioffset = (int) offset;
//        return (Float) values.initialization[ioffset];
//    }
//
//    public float[] getFloatArray(long offset) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setFloat(long offset, float value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setFloatArray(long offset, float[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public float getFloatArray(long offset, int index) throws RemoteException {
//        int ioffset = (int) offset;
//        return ((float[]) values.initialization[ioffset])[index];
//    }
//
////////////////////////////////////////////////////////
//// GENERAL
////////////////////////////////////////////////////////
//
//    public long freeMemorySize() throws RemoteException {
//        return 0;
//    }
//
//    public void free(long offset) {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public long memorySize() throws RemoteException {
//        return values.size;
//    }
//
//    /////////////////
//    // ILLEGAL
//    //
//
//    public void setIntArray(long offset, int index, int value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setLongArray(long offset, int index, long value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setByteArray(long offset, int index, byte value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setCharArray(long offset, int index, char value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setBooleanArray(long offset, int index, boolean value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setDoubleArray(long offset, int index, double value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setFloatArray(long offset, int index, float value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocObject(KClass classRef) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
////    public DRegisterReference allocObjectArray(DClassRef classRef, int size) throws RemoteException {
////        throw new IllegalArgumentException("Modification is not allowed");
////    }
//
//    public KObject getObject(long offset) throws RemoteException {
//        return KUtils.createObject(values.initialization[(int) offset]);
//    }
//
//    public void setObject(long offset, KObject value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public long getSegmentId() throws RemoteException {
//        return Long.parseLong(getName());
//    }
//
//    public KReference allocInt() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocLong() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocByte() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocChar() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocBoolean() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocDouble() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocShort() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocFloat() throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
////    public void setObjectArrayItem(long offset, int arrayIndex, DObject value) throws RemoteException {
////        throw new IllegalArgumentException("Modification is not allowed");
////    }
//
////    public DObject getArrayItem(long offset, int arrayIndex) throws RemoteException {
////        throw new IllegalArgumentException("Modification is not allowed");
////    }
//
//    public int getArraySize(long offset) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocRef(KClass classRef) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocRefArray(KClass classRef, int size) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KPointerInfo getPointer(long offset) throws RemoteException {
//        KObject o = getObject(offset);
//        KObjectType type = o.getType();
//        KClass cr=null;
//        if(type.isPrimitive()){
//            cr= KClass.forPrimitive(type.getCode());
//        }
//        KPointerInfoImpl nfo=new KPointerInfoImpl(
//                offset,
//                o.getContent().length,
//                0,
//                cr,
//                type
//        );
//        return nfo;
//    }
//
//    public KClass getClass(long offset) throws RemoteException {
//        KObject dObject = getObject(offset);
//        KObjectType type = dObject.getType();
//        if(type.isPrimitive()){
//            return KClass.forPrimitive(type.getCode());
//        }
//        throw new IllegalArgumentException("Unknown ref "+dObject);
//    }
//
//    public void setReference(long offset, KReference value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setReferenceArray(long offset, KReference[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocCharArray(char[] value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public void setReferenceArray(long offset, int index, KReference value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public String getStringChars(long offset) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public int getStringLength(long offset) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocString(String value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocString(long oldOffset, int start, int count) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference allocClass(KClass classRef) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KObject getClassInfo(long offset) throws RemoteException {
//        throw new IllegalArgumentException("getClass is not allowed");
//    }
//
//    public void setClassInfo(long offset, KObject value) throws RemoteException {
//        throw new IllegalArgumentException("Modification is not allowed");
//    }
//
//    public KReference getReference(long offset) throws RemoteException {
//        throw new IllegalArgumentException("getReference is not allowed");
//    }
//
//    public KReference getReferenceArray(long offset, int index) throws RemoteException {
//        throw new IllegalArgumentException("getReferenceArray is not allowed");
//    }
//}