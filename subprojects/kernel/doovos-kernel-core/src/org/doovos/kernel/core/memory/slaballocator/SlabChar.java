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
class SlabChar extends Slab {

    char[] values;

    SlabChar(int length,long offset,Cache cache) {
        super(length, KObjectType.t_char.getByteSize(), offset,cache);
        values = new char[length];
    }

    public char getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public char getValue(ObjectPointer p, int index) {
            return values[p.objectOffset + index];
    }

//    @Override
//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return KUtils.createObject(getValue(p, index));
//    }

    public void setValue(ObjectPointer p, int index, char value) {
        values[p.objectOffset + index] = value;
    }

    public void setValue(ObjectPointer p, char value) {
        values[p.objectOffset] = value;
    }

    public void setArray(ObjectPointer p, char[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public Object buffer() {
        return values;
    }

    public char[] getArray(ObjectPointer p) {
        char[] ret = new char[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc * 2];
        int so = p.objectOffset;
        char[] values0 = values;
        for (int i = 0; i < oc; i++) {
            KMemoryUtilities.char2byteArray(values0[so + i], b, 2 * i);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        int oc = p.objectCount;
        char[] values0 = values;
        for (int i = 0; i < oc; i += 2) {
            values0[so + (i / 2)] = KMemoryUtilities.byteArray2char(newValues, i);
        }
    }
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        int so = p.objectOffset;
//        values[so + index] = KMemoryUtilities.byteArray2char(object.getContent(), 0);
//    }
}
