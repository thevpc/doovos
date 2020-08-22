/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import org.doovos.kernel.api.memory.KMemoryUtilities;
import org.doovos.kernel.api.memory.KInvalidMemorySizeException;
import org.doovos.kernel.api.memory.KObjectType;

/**
 * @author vpc
 */
class SlabFloat extends Slab {

    float[] values;

    SlabFloat(int length, long offset, Cache cache) {
        super(length, KObjectType.t_float.getByteSize(), offset, cache);
        values = new float[length];
    }

//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return KUtils.createObject(getValue(p, index));
//    }

    public float getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public float getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

    public void setValue(ObjectPointer p, int index, float value) {
        values[p.objectOffset + index] = value;
    }

    public void setValue(ObjectPointer p, float value) {
        values[p.objectOffset] = value;
    }

    public void setArray(ObjectPointer p, float[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public Object buffer() {
        return values;
    }

    public float[] getArray(ObjectPointer p) {
        float[] ret = new float[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc * 4];
        int so = p.objectOffset;
        float[] values0 = values;
        for (int i = 0; i < oc; i++) {
            KMemoryUtilities.float2byteArray(values0[so + i], b, 4 * i);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        int oc = p.objectCount;
        float[] values0 = values;
        for (int i = 0; i < oc; i += 4) {
            values0[so + (i / 4)] = KMemoryUtilities.byteArray2float(newValues, i);
        }
    }
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        int so = p.objectOffset;
//        values[so + index] = KMemoryUtilities.byteArray2float(object.getContent(), 0);
//    }
}
