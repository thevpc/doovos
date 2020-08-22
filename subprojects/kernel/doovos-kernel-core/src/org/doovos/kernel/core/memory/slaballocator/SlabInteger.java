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
class SlabInteger extends Slab {

    int[] values;

    SlabInteger(int length,long offset,Cache cache) {
        super(length, KObjectType.t_int.getByteSize(), offset,cache);
        values = new int[length];
    }

//    @Override
//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return KUtils.createObject(getValue(p, index));
//    }

    public int getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public int getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

    public void setValue(ObjectPointer p, int index, int value) {
        values[p.objectOffset + index] = value;
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        values[p.objectOffset + index] = KMemoryUtilities.byteArray2int(object.getContent(), 0);
//    }

    public void setValue(ObjectPointer p, int value) {
        values[p.objectOffset] = value;
    }

    public void setArray(ObjectPointer p, int[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public Object buffer() {
        return values;
    }

    public int[] getArray(ObjectPointer p) {
        int[] ret = new int[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc * 4];
        int so = p.objectOffset;
        int[] values0 = values;
        for (int i = 0; i < oc; i++) {
            KMemoryUtilities.int2byteArray(values0[so + i], b, 4 * i);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        int oc = p.objectCount;
        int[] values0 = values;
        for (int i = 0; i < oc; i += 4) {
            values0[so + (i / 4)] = (((int) newValues[i]) << 24
                    | ((int) newValues[i + 1]) << 16
                    | ((int) newValues[i + 2]) << 8
                    | ((int) newValues[i + 3]));
        }
    }
    //decoration.setLength();
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
