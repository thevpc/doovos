/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import org.doovos.kernel.api.memory.KMemoryUtilities;
import org.doovos.kernel.api.memory.KInvalidMemorySizeException;
import org.doovos.kernel.api.memory.KObjectType;

/**
 *
 * @author vpc
 */
class SlabLong extends Slab {

    long[] values;

    SlabLong(int length,long offset,Cache cache) {
        super(length, KObjectType.t_long.getByteSize(), offset,cache);
        values = new long[length];
    }

//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return KUtils.createObject(getValue(p, index));
//    }

    public long getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public long getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        values[p.objectOffset + index] = KMemoryUtilities.byteArray2long(object.getContent(), 0);
//    }

    public void setValue(ObjectPointer p, int index, long value) {
        values[p.objectOffset + index] = value;
    }

    public void setValue(ObjectPointer p, long value) {
        values[p.objectOffset] = value;
    }

    public void setArray(ObjectPointer p, long[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public Object buffer() {
        return values;
    }

    public long[] getArray(ObjectPointer p) {
        long[] ret = new long[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc * 8];
        int so = p.objectOffset;
        long[] values0 = values;
        for (int i = 0; i < oc; i++) {
            KMemoryUtilities.long2byteArray(values0[so + i], b, 0);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        long[] values0 = values;
        int oc = p.objectCount;
        for (int i = 0; i < oc; i += 8) {
            values0[so + (i / 8)] = KMemoryUtilities.byteArray2long(newValues, i);
        }
    }
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }
    
}
