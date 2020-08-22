/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;

/**
 *
 * @author vpc
 */
public class SlabAllocator32 extends SlabAllocator{

    public SlabAllocator32(KSlabMemorySegment mem) {
        super(mem);
    }
    
    @Override
    Cache getObjSlabList(int size) {
        Cache slabList = objectCaches.get(size);
        if (slabList == null) {
            slabList = new CacheObject32(size, this);
            objectCaches.put(size, slabList);
        }
        return slabList;
    }
}
