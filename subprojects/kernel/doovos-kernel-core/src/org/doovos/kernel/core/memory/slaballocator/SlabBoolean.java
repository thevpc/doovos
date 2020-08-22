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
class SlabBoolean extends Slab {

    boolean[] values;

    SlabBoolean(int length,long offset,Cache cache) {
        super(length, KObjectType.t_boolean.getByteSize(), offset,cache);
        values = new boolean[length];
    }

    public Object buffer() {
        return values;
    }

    public boolean getValue(ObjectPointer p) {
        return values[p.objectOffset];
    }

    public void setValue(ObjectPointer p, boolean value) {
        values[p.objectOffset] = value;
    }

    public boolean getValue(ObjectPointer p, int index) {
        return values[p.objectOffset + index];
    }

    public void setValue(ObjectPointer p, int index, boolean value) {
        values[p.objectOffset + index] = value;
    }

    public void setArray(ObjectPointer p, boolean[] value) {
        if (value.length != p.objectCount) {
            throw new KInvalidMemorySizeException();
        }
        System.arraycopy(value, 0, values, p.objectOffset, value.length);
    }

    public boolean[] getArray(ObjectPointer p) {
        boolean[] ret = new boolean[p.objectCount];
        System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
        return ret;
    }

    public byte[] toBytes(ObjectPointer p) {
        int oc = p.objectCount;
        byte[] b = new byte[oc];
        int so = p.objectOffset;
        final byte one = 1;
        final byte zero = 0;
        boolean[] values0 = values;
        for (int i = 0; i < oc; i++) {
            boolean x = values0[so + i];
            b[i] = (x ? one : zero);
        }
        return b;
    }

    public void setBytes(ObjectPointer p, byte[] newValues) {
        int so = p.objectOffset;
        boolean[] values0 = values;
        int oc = p.objectCount;
        for (int i = 0; i < oc; i++) {
            values0[so + i] = (newValues[i] == 1);
        }
    }
    

//    public void setValue(ObjectPointer p, int index, KObject object) {
//        int so = p.objectOffset;
//        values[so + index] = object.getContent()[0] == 1;
//    }

    @Override
    public void reset(ObjectPointer p) {
        throw new UnsupportedOperationException("Not supported.");
    }
}
