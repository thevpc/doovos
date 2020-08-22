/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import java.io.Serializable;
import java.rmi.RemoteException;

import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KInvalidReferenceException;
import org.doovos.kernel.api.memory.KOutOfMemoryException;
import org.doovos.kernel.core.util.LongKeyHashMap;

/**
 *
 * @author vpc
 */
class PageAllocator implements Serializable {

    private LongKeyHashMap<PagePointer> pagePointers = new LongKeyHashMap<PagePointer>();
//    private MemoryIntervallPool memoryIntervallPool = new MemoryIntervallPool();
//    private PagePointerPool pagePointerPool = new PagePointerPool();
    long freeSize;
    private MemoryIntervall used;
    private MemoryIntervall free;
    private KSlabMemorySegment mem;

    PageAllocator(KSlabMemorySegment mem) {
        free = new MemoryIntervall();
        free.from = -1;
        free.to = -1;
        //MemoryIntervall n = memoryIntervallPool.getPooledInstance();
        MemoryIntervall n = new MemoryIntervall();
        n.from = 0;
        n.to = mem.size;
        free.linkNext(n);
        used = new MemoryIntervall();
        used.from = -1;
        used.to = -1;
        this.freeSize = mem.size;
    }

    @Override
    public String toString() {
        StringBuilder freeIntervallsSb = new StringBuilder();
        MemoryIntervall m = free.next;
        while (m != null) {
            freeIntervallsSb.append(m.from).append("->").append(m.to).append(";");
            m = m.next;
        }

        StringBuilder usedIntervallsSb = new StringBuilder();
        m = used.next;
        while (m != null) {
            usedIntervallsSb.append(m.from).append("->").append(m.to).append(";");
            m = m.next;
        }
        return "PageAllocator(free " + freeSize + "/" + mem.size + "){\n"
                + KSlabMemorySegment.indent("{free=" + freeIntervallsSb + "}")
                + KSlabMemorySegment.indent("{used=" + usedIntervallsSb + "}")
                + "}";
    }

    long allocPages(int size) {
        if (size > freeSize) {
            throw new KOutOfMemoryException("unable to allocate page [page size " + size + "> free " + freeSize + "] ");
        }
        MemoryIntervall mi = free.next;
        PagePointer pointer = null;
        MemoryIntervall toAdd = null;
        while (mi != null) {
            long memSize = mi.to - mi.from;
            if (memSize > size) {
//                pointer = pagePointerPool.getPooledInstance();
                pointer = new PagePointer();
                pointer.offset = mi.from;
                pointer.psize = size;
//                toAdd = memoryIntervallPool.getPooledInstance();
                toAdd = new MemoryIntervall();
                toAdd.from = mi.from;
                toAdd.to = mi.from + size;
                mi.from = mi.from + size;
                break;
            } else if (memSize == size) {
//                pointer = pagePointerPool.getPooledInstance();
                pointer = new PagePointer();
                pointer.offset = mi.from;
                pointer.psize = size;
                mi.previous.linkNext(mi.next);
                toAdd = mi;
                break;
            }
            mi = mi.next;
        }
        if (pointer == null) {
            throw new KOutOfMemoryException("Out of memory althoug freeSize is " + freeSize);
        }

        //add to used linked list
        MemoryIntervall i = used.next;
        MemoryIntervall last = used.next;
        boolean added = false;
        while (i != null) {
            if (i.from > pointer.offset) {
                MemoryIntervall p = i.previous;
                p.linkNext(toAdd);
                toAdd.linkNext(i);
                added = true;
                break;
            }
            last = i;
            i = i.next;
        }
        if (!added) {
            toAdd.linkNext(null);
            if (last != null) {
                last.linkNext(toAdd);
            } else {
                used.linkNext(toAdd);
            }
        }
        freeSize -= pointer.psize;

        //merge
        MemoryIntervall p;
        p = toAdd.next;
        if (p != null && p.from == toAdd.to) {
            p.from = toAdd.from;
            toAdd.previous.linkNext(p);
//            memoryIntervallPool.freePooledInstance(toAdd);
            toAdd = p;
        }
        p = toAdd.previous;
        if (p != null && p.to == toAdd.from) {
            p.to = toAdd.to;
            p.linkNext(toAdd.next);
//            memoryIntervallPool.freePooledInstance(toAdd);
        }
        pagePointers.put(pointer.offset, pointer);
        return pointer.offset;
    }

    void freePage(long offset) {
        PagePointer var = getPagePointer(offset);
        MemoryIntervall m = used.next;
        boolean mfound = false;
        while (m != null) {
            if (m.from <= offset && m.to > (var.psize + var.offset)) {
                mfound = true;
                break;
            }
            m = m.next;
        }
        if (!mfound) {
            try {
                throw new KInvalidReferenceException(new KReference(mem, mem.getId(), offset));
            } catch (RemoteException ex) {
                throw new KInvalidReferenceException(new KReference(mem, -1, offset));
            }
        }

        MemoryIntervall toAdd;
        int varSize = var.psize;
        //remove from used linked list
        if ((m.to - m.from) == offset) {
            m.previous.linkNext(m.next);
            toAdd = m;
        } else if (m.from == offset) {
//            toAdd = memoryIntervallPool.getPooledInstance();
            toAdd = new MemoryIntervall();
            toAdd.from = offset;
            toAdd.to = offset + varSize;
            m.from = m.from + varSize;
        } else if (m.to == (offset + varSize)) {
//            toAdd = memoryIntervallPool.getPooledInstance();
            toAdd = new MemoryIntervall();
            toAdd.from = offset;
            toAdd.to = offset + varSize;
            m.to = offset;
        } else {
//            toAdd = memoryIntervallPool.getPooledInstance();
            toAdd = new MemoryIntervall();
            toAdd.from = offset;
            toAdd.to = offset + varSize;
//            MemoryIntervall m2 = memoryIntervallPool.getPooledInstance();
            MemoryIntervall m2 = new MemoryIntervall();
            m2.from = offset + varSize;
            m2.to = m.to;
            m2.linkNext(m.next);
            m.linkNext(m2);
            m.to = offset;
        }

        //add to free linked list
        MemoryIntervall i = free.next;
        boolean added = false;
        MemoryIntervall last = null;
        while (i != null) {
            if (i.from > offset) {
                MemoryIntervall p = i.previous;
                p.linkNext(toAdd);
                toAdd.linkNext(i);
                added = true;
                break;
            }
            last = i;
            i = i.next;
        }
        if (!added) {
            toAdd.linkNext(null);
            if (last != null) {
                last.linkNext(toAdd);
            } else {
                free.linkNext(toAdd);
            }
        }
        freeSize += var.psize;

        //merge
        MemoryIntervall p;
        p = toAdd.next;
        if (p != null && p.from == toAdd.to) {
            p.from = toAdd.from;
            toAdd.previous.linkNext(p);
//            memoryIntervallPool.freePooledInstance(toAdd);
            toAdd = p;
        }
        p = toAdd.previous;
        if (p != null && p.to == toAdd.from) {
            p.to = toAdd.to;
            p.linkNext(toAdd.next);
//            memoryIntervallPool.freePooledInstance(toAdd);
        }
        pagePointers.remove(var.offset);
//        pagePointerPool.freePooledInstance(var);

    }

    public PagePointer getPagePointer(long offset) {
        PagePointer var = pagePointers.get(offset);
        if (var == null) {
            try {
                throw new KInvalidReferenceException(new KReference(mem, mem.getId(), offset));
            } catch (RemoteException ex) {
                throw new KInvalidReferenceException(new KReference(mem, -1, offset));
            }
        }
        return var;
    }

    private class MemoryIntervallPool extends Pool<MemoryIntervall> {

        public MemoryIntervallPool() {
            super(5, 20, MemoryIntervall.class);
        }

        @Override
        public void resetInstance(MemoryIntervall memoryIntervall) {
//            memoryIntervall.from=0;
            memoryIntervall.next=null;
            memoryIntervall.previous=null;
            memoryIntervall.from=0;
            memoryIntervall.to=0;
        }

        public MemoryIntervall createInstance() {
            return new MemoryIntervall();
        }
    }

    private final class MemoryIntervall implements Serializable {

        long from;//include
        long to;//exclude
        private MemoryIntervall next;
        private MemoryIntervall previous;

        private MemoryIntervall() {
        }

        private void linkNext(MemoryIntervall n) {
            next = n;
            if (n != null) {
                n.previous = this;
            }
        }
    }

    private class PagePointer implements Serializable {

        long offset;
        int psize;

        @Override
        public String toString() {
            return "DPointer(" + offset + "," + psize + ")";
        }
    }

    private class PagePointerPool extends Pool<PagePointer> {
        public PagePointerPool() {
            super(100, 1000, PagePointer.class);
        }
        public PagePointer createInstance() {
            return new PagePointer();
        }

        @Override
        public void resetInstance(PagePointer pagePointer) {
            pagePointer.offset=0;
            pagePointer.psize=0;
        }
    }
}

