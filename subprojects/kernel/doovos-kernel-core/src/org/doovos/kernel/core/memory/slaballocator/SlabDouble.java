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
class SlabDouble extends Slab {

    double[] values;

    SlabDouble(int length,long offset,Cache cache) {
        super(length, KObjectType.t_double.getByteSize(), offset,cache);
        values = new double[length];
    }

    public Object buffer() {
        return values;
    }

    public double getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public void setValue(ObjectPointer p, double value) {
        values[p.objectOffset] = value;
    }

    public void setArray(ObjectPointer p, double[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public double[] getArray(ObjectPointer p) {
        double[] ret = new double[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public double getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

//    @Override
//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return KUtils.createObject(getValue(p, index));
//    }

    public void setValue(ObjectPointer p, int index, double value) {
        values[p.objectOffset + index] = value;
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        int so = p.objectOffset;
//        values[so + index] = KMemoryUtilities.byteArray2float(object.getContent(), 0);
//    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc * 8];
        int so = p.objectOffset;
        double[] values0 = values;
        for (int i = 0; i < oc; i++) {
            KMemoryUtilities.double2byteArray(values0[so + i], b, 4 * i);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        int oc = p.objectCount;
        double[] values0 = values;
        for (int i = 0; i < oc; i += 8) {
            values0[so + (i / 8)] = KMemoryUtilities.byteArray2double(newValues, i);
        }
    }
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }
    
}
