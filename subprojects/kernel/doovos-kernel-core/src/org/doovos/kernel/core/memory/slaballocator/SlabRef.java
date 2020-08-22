/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryUtilities;

/**
 *
 * @author vpc
 */
class SlabRef extends Slab {

    KReference[] values;

    SlabRef(int length,long offset,Cache cache) {
        super(length, KObjectType.t_ref.getByteSize(), offset,cache);
        values = new KReference[length];
        for (int i = 0; i < values.length; i++) {
            values[i] = KReference.NULL;
        }
    }

//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return KUtils.createObject(getValue(p, index));
//    }

    public KReference getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public KReference getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

    public void setValue(ObjectPointer p, int index, KReference value) {
        values[p.objectOffset + index] = value;
    }

    public void setValue(ObjectPointer p, KReference value) {
        values[p.objectOffset] = value;
    }

    public void setArray(ObjectPointer p, KReference[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public Object buffer() {
        return values;
    }

    public KReference[] getArray(ObjectPointer p) {
        KReference[] ret = new KReference[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        values[p.objectOffset + index] = mem.byteArray2ref(object.getContent(), 0);
//    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc * 16];
        int so = p.objectOffset;
        KReference[] values0 = values;
        for (int i = 0; i < oc; i++) {
            KReference r = values0[so + i];
            KMemoryUtilities.ref2byteArray(r, b, 16 * i);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        KReference[] values0 = values;
        int oc = p.objectCount;
        for (int i = 0; i < oc; i += 16) {
            values0[so + i / 16] = mem.byteArray2ref(newValues, i);
        }
    }
    //decoration.setLength();
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
