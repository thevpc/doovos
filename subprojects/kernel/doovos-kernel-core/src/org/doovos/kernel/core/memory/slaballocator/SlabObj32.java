/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import java.rmi.RemoteException;

import org.doovos.kernel.api.memory.KMemoryUtilities;
import org.doovos.kernel.api.jvm.KGarbageCollector;
import org.doovos.kernel.api.memory.KReference;

/**
 *
 * @author vpc
 */
final class SlabObj32 extends Slab {

    int[] values;
    int[] zeros;

    SlabObj32(int objSize, int length,long offset,Cache cache) {
        super(length, objSize, offset,cache);
        values = new int[objSize * length];
        zeros = new int[objSize];
    }

//    @Override
//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
////                    String x=new StringBuilder().append("fff").append(new Integer(4).toString()).toString();
//            throw new IllegalArgumentException("Not and array");
//        }
//        byte[] ret = new byte[byteSize];
//        System.arraycopy(values, p.objectOffset + (index * byteSize), ret, 0, ret.length);
//        return KUtils.createObject(ret, 1);
//    }

//            public byte getValue(ObjectPointer p) {
//                return values[p.objectOffset];
//            }
//            public void setValue(ObjectPointer p, byte value) {
//                values[p.objectOffset] = value;
//            }
//
//            public byte getValue(ObjectPointer p, int index) {
//                return values[p.objectOffset + index];
//            }
//            public void setValue(ObjectPointer p, int index, byte value) {
//                values[p.objectOffset + index] = value;
//            }
//    public void setArray(ObjectPointer p, byte[] value) {
//        if (value.length != p.objectCount) {
//            throw new KInvalidMemorySizeException();
//        }
//        System.arraycopy(value, 0, values, p.objectOffset, value.length);
//    }
//
//    public byte[] getArray(ObjectPointer p) {
//        byte[] ret = new byte[p.objectCount * byteSize];
//        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
//        return ret;
//    }

    public byte[] toBytes(ObjectPointer p) {
        //this method has not to be fast, used only in debug mode
        //System.arraycopy(values, p.objectOffset * byteSize, b, 0, p.objectCount * byteSize);
        byte[] b = new byte[p.objectCount * unitSize];
        int x0=p.objectOffset * unitSize;
        int len=x0+p.objectCount * unitSize;
        int j=0;
        for(int i=x0;i<len;i++){
            b[j]=(byte)values[i];
            j++;
        }
        return b;
    }

    public void reset(ObjectPointer p) {
//        System.out.println(">> "+p+" : reset");
        System.arraycopy(zeros, 0, values, p.objectOffset * unitSize, p.objectCount * unitSize);
    }
    
    public void setBytes(ObjectPointer p, byte[] newValues) {
        //initilazing an object will be a bit slower but should be faster in get/set
        //System.arraycopy(newValues, 0, values, p.objectOffset * byteSize, p.objectCount * byteSize);
        int x0=p.objectOffset * unitSize;
        int len=x0+p.objectCount * unitSize;
        int j=0;
        for(int i=x0;i<len;i++){
            values[i]=newValues[j];
            j++;
        }
    }

    public long getFieldLong(ObjectPointer p, int fieldOffset) {
//        System.out.println(">> "+p+" : getFieldLong("+fieldOffset+")="+KMemoryUtilities.intArray2long(values, p.objectOffset * unitSize + fieldOffset));
        return KMemoryUtilities.intArray2long(values, p.objectOffset * unitSize + fieldOffset);
    }

    public void setFieldLong(ObjectPointer p, int fieldOffset, long value) {
//        System.out.println(">> "+p+" : setFieldLong("+fieldOffset+")="+value+" WAS "+KMemoryUtilities.intArray2long(values, p.objectOffset * unitSize + fieldOffset));
        KMemoryUtilities.long2intArray(value, values, p.objectOffset * unitSize + fieldOffset);
    }

    public void setFieldInt(ObjectPointer p, int fieldOffset, int value) {
        //KMemoryUtilities.int2byteArray(value, values, p.objectOffset * byteSize + fieldOffset);
        values[p.objectOffset * unitSize+fieldOffset]=value;
    }

    public int getFieldInt(ObjectPointer p, int fieldOffset) {
        //return KMemoryUtilities.byteArray2int(values, p.objectOffset * byteSize + fieldOffset);
        return values[p.objectOffset * unitSize + fieldOffset];
    }

    public void setFieldByte(ObjectPointer p, int fieldOffset, byte value) {
        values[p.objectOffset * unitSize + fieldOffset]=value;
        //DMemoryUtils.byte2byteArray(value, values, p.objectOffset * byteSize + fieldOffset);
    }

    public byte getFieldByte(ObjectPointer p, int fieldOffset) {
        return (byte)values[p.objectOffset * unitSize + fieldOffset];
        //return DMemoryUtils.byteArray2byte(values, p.objectOffset * byteSize + fieldOffset);
    }

    public void setFieldBoolean(ObjectPointer p, int fieldOffset, boolean value) {
        //KMemoryUtilities.boolean2byteArray(value, values, p.objectOffset * byteSize + fieldOffset);
        values[p.objectOffset * unitSize + fieldOffset]=value?1:0;
    }

    public boolean getFieldBoolean(ObjectPointer p, int fieldOffset) {
        //return KMemoryUtilities.byteArray2boolean(values, p.objectOffset * byteSize + fieldOffset);
        return values[p.objectOffset * unitSize + fieldOffset]!=0;
    }

    public void setFieldShort(ObjectPointer p, int fieldOffset, short value) {
        //KMemoryUtilities.short2byteArray(value, values, p.objectOffset * byteSize + fieldOffset);
        values[p.objectOffset * unitSize + fieldOffset]=value;
    }

    public short getFieldShort(ObjectPointer p, int fieldOffset) {
//        return KMemoryUtilities.byteArray2short(values, p.objectOffset * byteSize + fieldOffset);
        return (short)values[p.objectOffset * unitSize + fieldOffset];
    }

    public void setFieldChar(ObjectPointer p, int fieldOffset, char value) {
//        KMemoryUtilities.char2byteArray(value, values, p.objectOffset * byteSize + fieldOffset);
        values[p.objectOffset * unitSize + fieldOffset]=value;
    }

    public char getFieldChar(ObjectPointer p, int fieldOffset) {
//        return KMemoryUtilities.byteArray2char(values, p.objectOffset * byteSize + fieldOffset);
        return (char)values[p.objectOffset * unitSize + fieldOffset];
    }

    public void setFieldFloat(ObjectPointer p, int fieldOffset, float value) {
        //KMemoryUtilities.float2byteArray(value, values, p.objectOffset * byteSize + fieldOffset);
        values[p.objectOffset * unitSize + fieldOffset]=Float.floatToIntBits(value);
    }

    public float getFieldFloat(ObjectPointer p, int fieldOffset) {
        //return KMemoryUtilities.byteArray2float(values, p.objectOffset * byteSize + fieldOffset);
        return Float.intBitsToFloat(values[p.objectOffset * unitSize + fieldOffset]);
    }

    public void setFieldDouble(ObjectPointer p, int fieldOffset, double value) {
        KMemoryUtilities.double2intArray(value, values, p.objectOffset * unitSize + fieldOffset);
    }

    public double getFieldDouble(ObjectPointer p, int fieldOffset) {
        return KMemoryUtilities.intArray2double(values, p.objectOffset * unitSize + fieldOffset);
    }

    public void setFieldReference(ObjectPointer p, int fieldOffset, KReference value) throws RemoteException {
//        System.out.println(">> "+p+" : setFieldReference("+fieldOffset+")="+value +" WAS "+mem.intArray2ref(values, p.objectOffset * unitSize + fieldOffset));
        KReference reff = p.reference;
        int fullOffset = p.objectOffset * unitSize + fieldOffset;
        KReference oldRef = mem.intArray2ref(values, fullOffset);
        KGarbageCollector gc = sa.mem.getGC();
        if (!oldRef.isNull()) {
            gc.removeBackwardReference(oldRef, reff);
        }
        KMemoryUtilities.ref2intArray(value, values, fullOffset);
        if (!value.isNull()) {
            gc.addBackwardReference(value, reff);
        }
//        KReference newval = mem.intArray2ref(values, p.objectOffset * unitSize + fieldOffset);
//        if(!newval.equals(value)){
//            System.out.println("WHY");
//        }
//        System.out.println(">> "+p+" : setFieldReference("+fieldOffset+") BECOMES "+newval);
    }

    public KReference getFieldReference(ObjectPointer p, int fieldOffset) {
//        System.out.println(">> "+p+" : getFieldReference("+fieldOffset+")="+mem.intArray2ref(values, p.objectOffset * unitSize + fieldOffset));
        return mem.intArray2ref(values, p.objectOffset * unitSize + fieldOffset);
    }

//    public void setFieldBytes(ObjectPointer p, int fieldOffset, byte[] newValues) {
//        System.arraycopy(newValues, 0, values, p.objectOffset * byteSize + fieldOffset, newValues.length);
//    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        System.arraycopy(object.getContent(), 0, values, p.objectOffset + (index * byteSize), byteSize);
//    }

    public Object buffer() {
        return values;
    }

    @Override
    public void free(ObjectPointer p) {
//        System.out.println(">> "+p+" : free");
        super.free(p);
    }
    
}
