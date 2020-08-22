/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import org.doovos.kernel.api.memory.KObjectType;

/**
 *
 * @author vpc
 */
class CacheShort extends Cache {

    CacheShort(SlabAllocator sa) {
        super(KObjectType.t_short, sa);
    }

    protected Slab createSlab(int size,long offset,Cache cache) {
        return new SlabShort(size, offset,cache);
    }
}
