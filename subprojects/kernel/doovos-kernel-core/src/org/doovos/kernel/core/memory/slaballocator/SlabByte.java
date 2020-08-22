/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import org.doovos.kernel.api.memory.KInvalidMemorySizeException;
import org.doovos.kernel.api.memory.KObjectType;

/**
 *
 * @author vpc
 */
class SlabByte extends Slab {

    byte[] values;

    SlabByte(int length,long offset,Cache cache) {
        super(length, KObjectType.t_byte.getByteSize(), offset,cache);
        values = new byte[length];
    }

    public Object buffer() {
        return values;
    }

    public byte getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public void setValue(ObjectPointer p, byte value) {
        values[p.objectOffset] = value;
    }

    public byte getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

    public void setValue(ObjectPointer p, int index, byte value) {
        values[p.objectOffset + index] = value;
    }

    public void setArray(ObjectPointer p, byte[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public void setArray(ObjectPointer p, int refOffset, byte[] value, int voffset, int len) {
        if ((len + voffset) > p.objectCount || voffset < 0) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, voffset, values, p.objectOffset + refOffset, len);
    }

    public byte[] getArray(ObjectPointer p) {
        byte[] ret = new byte[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public byte[] toBytes(ObjectPointer p) {
        byte[] b = new byte[p.objectCount];
        System.arraycopy(values, p.objectOffset, b, 0, p.objectCount);
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        System.arraycopy(newValues, 0, values, p.objectOffset, p.objectCount);
    }
    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        int so = p.objectOffset;
//        values[so + index] = object.getContent()[0];
//    }
}
