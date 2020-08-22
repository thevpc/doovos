/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import org.doovos.kernel.api.memory.KInvalidMemorySizeException;
import org.doovos.kernel.api.memory.KMemoryUtilities;
import org.doovos.kernel.api.memory.KObjectType;

/**
 *
 * @author vpc
 */
class SlabShort extends Slab {

    short[] values;

    SlabShort(int length,long offset,Cache cache) {
        super(length, KObjectType.t_short.getByteSize(), offset,cache);
        values = new short[length];
    }

    public Object buffer() {
        return values;
    }

//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return KUtils.createObject(getValue(p, index));
//    }

    public short getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public short getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

    public void setValue(ObjectPointer p, int index, short value) {
        values[p.objectOffset + index] = value;
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        values[p.objectOffset + index] = KMemoryUtilities.byteArray2short(object.getContent(), 0);
//    }

    public void setValue(ObjectPointer p, short value) {
        values[p.objectOffset] = value;
    }

    public void setArray(ObjectPointer p, short[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public short[] getArray(ObjectPointer p) {
        short[] ret = new short[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc * 2];
        int so = p.objectOffset;
        short[] values0 = values;
        for (int i = 0; i < oc; i++) {
            KMemoryUtilities.short2byteArray(values0[so + i], b, 2 * i);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        short[] values0 = values;
        int oc = p.objectCount;
        for (int i = 0; i < oc; i += 2) {
            values0[so + (i / 2)] = KMemoryUtilities.byteArray2short(newValues, i);
        }
    }
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }
    
    //decoration.setLength();
}
