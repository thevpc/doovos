/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;

import java.rmi.RemoteException;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.memory.KInvalidReferenceException;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.process.KProcess;

/**
 *
 * @author vpc
 */
public class KSlabMemorySegment32 extends KSlabMemorySegment {

    public KSlabMemorySegment32() throws RemoteException {
    }
    
    @Override
    public void init(KProcess process, KSegmentDef options) throws RemoteException {
        super.init(process, options);
        this.size = options.size < 0 ? (512 * 1024 * 1024) : options.size; // 512Mo if not specified
        pageAllocator = new PageAllocator(this);
        slabAllocator = new SlabAllocator32(this);
    }
    
    public void setFieldLong(long offset, int fieldOffset, long value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        ((SlabObj32) (p.slab)).setFieldLong(p, fieldOffset, value);
    }

    public long getFieldLong(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj32) (p.slab)).getFieldLong(p, fieldOffset);
    }

    public void setFieldInt(long pointer, int fieldOffset, int value) throws RemoteException {
        ObjectPointer p = objPointers.get(pointer);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabObj32) (p.slab)).setFieldInt(p, fieldOffset, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, pointer));
        }
    }

    public int getFieldInt(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj32) (p.slab)).getFieldInt(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldByte(long pointer, int fieldOffset, byte value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj32) (p.slab)).setFieldByte(p, fieldOffset, value);
    }

    public byte getFieldByte(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj32) (p.slab)).getFieldByte(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldBoolean(long pointer, int fieldOffset, boolean value) throws RemoteException {
        ObjectPointer p = objPointers.get(pointer);
        //ObjectPointer p = getPrivatePointer(pointer);
        try {
            ((SlabObj32) (p.slab)).setFieldBoolean(p, fieldOffset, value);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, pointer));
        }
    }

    public boolean getFieldBoolean(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj32) (p.slab)).getFieldBoolean(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldShort(long pointer, int fieldOffset, short value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj32) (p.slab)).setFieldShort(p, fieldOffset, value);
    }

    public short getFieldShort(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj32) (p.slab)).getFieldShort(p, fieldOffset);
    }

    public void setFieldChar(long pointer, int fieldOffset, char value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj32) (p.slab)).setFieldChar(p, fieldOffset, value);
    }

    public char getFieldChar(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj32) (p.slab)).getFieldChar(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldFloat(long pointer, int fieldOffset, float value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj32) (p.slab)).setFieldFloat(p, fieldOffset, value);
    }

    public float getFieldFloat(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj32) (p.slab)).getFieldFloat(p, fieldOffset);
    }

    public void setFieldDouble(long pointer, int fieldOffset, double value) throws RemoteException {
        ObjectPointer p = getPrivatePointer(pointer);
        ((SlabObj32) (p.slab)).setFieldDouble(p, fieldOffset, value);
    }

    public double getFieldDouble(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = getPrivatePointer(offset);
        return ((SlabObj32) (p.slab)).getFieldDouble(p, fieldOffset);
    }

    public KReference getFieldReference(long offset, int fieldOffset) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            return ((SlabObj32) (p.slab)).getFieldReference(p, fieldOffset);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }

    public void setFieldReference(long offset, int fieldOffset, KReference ref) throws RemoteException {
        ObjectPointer p = objPointers.get(offset);
//        ObjectPointer p = getPrivatePointer(offset);
        try {
            ((SlabObj32) (p.slab)).setFieldReference(p, fieldOffset, ref);
        } catch (NullPointerException e) {
            throw new KInvalidReferenceException(new KReference(this, id, offset));
        }
    }
    
}
