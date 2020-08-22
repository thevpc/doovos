/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Map;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.core.util.LongKeyHashMap;

/**
 *
 * @author vpc
 */
abstract class Slab implements Serializable {

    SlabAllocator sa;
    long offset;
    Cache cache;
    final int cacheSize;
    BitArray decoration;
    int maxObjects;
    int unitSize;
    Slab next;
    Slab previous;
    final KSlabMemorySegment mem;
    int firstZero = 0;
//    private final ObjectPointerPool objPointerPool;
    private final LongKeyHashMap<ObjectPointer> objPointers;
    private final long segmentId;

    protected Slab(int maxObjects, int unitSize,long offset,Cache cache) {
        this.decoration = new BitArray(maxObjects);
        this.offset = offset;
        this.cache = cache;
        this.sa = cache.sa;
        this.cacheSize = cache.size;
        this.maxObjects = maxObjects;
        this.unitSize = unitSize;
//        this.objPointerPool = sa.objPointerPool;
        this.mem = sa.mem;
        try {
            this.segmentId = mem.getId();
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
        this.objPointers = mem.objPointers;
    }

    public int getByteSize() {
        return unitSize;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < maxObjects; i++) {
            sb.append(decoration.get(i));
        }
        sb.append(")");
        return sb.toString();
    }

    public abstract Object buffer();

    void linkNext(Slab n) {
        next = n;
        if (n != null) {
            n.previous = this;
        }
    }

    boolean isFull() {
        return freeObj() == 0;
    }

    boolean isFree() {
        return decoration.getOneBitsCount() == 0;
    }

    int freeObj() {
        return decoration.getZeroBitsCount();
    }

    public ObjectPointer allocObj(int count, KClass classRef) {
        int i;
        if (count <= 0) {
            if (count < 0) {
                throw new IllegalArgumentException("allocObj count=" + count + " <0");
            }
            int count0 = 1;
            i = decoration.indexOfZeroSuite(count0, firstZero);
            //i = decoration.indexOfZeroSuite(count0);
            if (i == -1) {
                return null;
            }
            decoration.setRange(i, i + count0, 1);
            firstZero = i + count0;
        } else {
            i = decoration.indexOfZeroSuite(count, firstZero);
            //i = decoration.indexOfZeroSuite(count);
            if (i == -1) {
                return null;
            }
            decoration.setRange(i, i + count, 1);
            firstZero = i + count;
        }

//        ObjectPointer objectPointer = objPointerPool.getPooledInstance();
        ObjectPointer objectPointer = new ObjectPointer();
        KReference ref = new KReference(mem, segmentId, offset + i * cacheSize);
        objectPointer.reference = ref;
        objectPointer.objectOffset = i;
        objectPointer.objectCount = count;
        objectPointer.slab = this;
        objectPointer.classRef = classRef;
//        if (classRef == null) {
//            throw new IllegalArgumentException("ClassRef is null");
//        }
//                for (ObjectPointer pointer : objPointers.values()) {
//                    if (pointer.contains(objectPointer.offset) || pointer.contains(objectPointer.offset + objectPointer.getByteSize() - 1)) {
//                        throw new IllegalArgumentException("????????");
//                    }
//                }

        objPointers.put(ref.pointer, objectPointer);
        return objectPointer;
    }

    public void free(ObjectPointer p) {
        int l = p.objectOffset;
        int oc = p.objectCount;
        if (oc == 0) {
            decoration.set(l, 0);
        } else {
            decoration.setRange(l, l + oc, 0);
        }
        if (l < firstZero) {
            firstZero = l;
        }
        objPointers.remove(p.reference.pointer);
        if (p.stringValue != null) {
            Map<String, ObjectPointer> cachedStrings = mem.cachedStrings;
            ObjectPointer objectPointer = cachedStrings.get(p.stringValue);
            if (objectPointer.equals(p)) {
                cachedStrings.remove(p.stringValue);
            }
        }
    }

    public abstract byte[] toBytes(ObjectPointer p);

//    public abstract void setValue(ObjectPointer p, int index, KObject object);

    public abstract void reset(ObjectPointer p);
    
//    public abstract void setBytes(ObjectPointer p, byte[] newValues);

//    public void setObject(ObjectPointer p, KObject object) {
//        switch (p.classRef.getType()) {
//            case t_ref: {
//                if (object == null) {
//                    setBytes(p, KUtils.NULL_OBJECT.getContent());
//                } else {
//                    setBytes(p, object.getContent());
//                }
//                break;
//            }
//            default: {
//                setBytes(p, object.getContent());
//            }
//        }
//    }

//    public void setArrayItem(ObjectPointer p, int index, KObject object) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        p.slab.setValue(p, index, object);
//    }

//    public KObject getArrayItem(ObjectPointer p, int index) {
//        if (!p.classRef.isArray()) {
//            throw new IllegalArgumentException("Not and array");
//        }
//        return p.slab.getArrayItem(p, index);
//    }

//    public KObject getObject(ObjectPointer p) {
//        byte[] b = toBytes(p);
//        if (KUtils.isNull(p.classRef, b)) {
//            return null;
//        }
//        return KUtils.createObject(b, p.objectCount);
//    }
}
