/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;

import java.io.Serializable;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.memory.KOutOfMemoryException;

/**
 *
 * @author vpc
 */
abstract class Cache implements Serializable {

    KObjectType type;
    SlabAllocator sa;
    Slab first;
    final int size;
    private final PageAllocator pageAllocator;


    //
    protected Cache(KObjectType type,SlabAllocator sa) {
        this(type, type.getByteSize(),sa);
    }

    protected Cache(KObjectType type, int size,SlabAllocator sa) {
        this.sa = sa;
        this.type = type;
        this.size = size;
        pageAllocator = sa.mem.pageAllocator;
    }

    ObjectPointer alloc(int size, KClass classRef) {
        ObjectPointer p;
        Slab s = first;
        while (s != null) {
            p = s.allocObj(size, classRef);
            if (p != null) {
                return p;
            }
            s = s.next;
        }
        int slabObjectsCount = getPreferredObjectCount(size, this.size);
        if (slabObjectsCount == 0) {
            throw new KOutOfMemoryException("unable to allocate page [page size " + size + "> free " + sa.freeSize + "] ");
        }
        long offset;
        try {
            offset = pageAllocator.allocPages(slabObjectsCount * this.size);
        } catch (KOutOfMemoryException e) {
            getPreferredObjectCount(size, this.size);
//            System.out.println(getClass().getName());
            throw e;
        }
        Slab nextSlab = createSlab(slabObjectsCount,offset,this);
        //nextSlab.offset = offset;
        //nextSlab.cache = this;
        if (first == null) {
            first = nextSlab;
        } else {
            nextSlab.linkNext(first);
            first = nextSlab;
        }
        p = nextSlab.allocObj(size, classRef);
        if (p == null) {
            throw new KOutOfMemoryException("Unable to allocate type " + type);
        }
        return p;
    }

    void forceFreePages() {
        Slab s = first;
        PageAllocator pageAllocator0 = sa.mem.pageAllocator;
        while (s != null) {
            if (s.isFree()) {
                pageAllocator0.freePage(s.offset);
                if (s.previous == null) {
                    first = s.next;
                    s.next.previous = null;
                } else {
                    s.previous.linkNext(s.next);
                }
                //push back DSlab to pool?
            }
            s = s.next;
        }
    }

    private int getPreferredObjectCount(int size, int itemSize) {
        int max = (int) (sa.mem.pageAllocator.freeSize / this.size);
        //int min = size;
        int best = sa.mem.defaultSlabObjectsCount;
        if (best > max) {
            best = max;
        }
        if (size < best) {
            size = best;
        }
        long freeMem = sa.mem.slabAllocator.freeSize;
        while (true) {
            if (size == 0) {
                return 0;
            }
            if (size * itemSize < freeMem) {
                break;
            }
            size = size / 2;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Slabs(").append(type).append("){\n");
        Slab s = first;
        while (s != null) {
            sb.append(KSlabMemorySegment.indent(s.toString(), "\t"));
            s = s.next;
        }
        sb.append("}");
        return sb.toString();
    }

    protected abstract Slab createSlab(int size,long offset,Cache cache);
}

