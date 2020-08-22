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
class CacheLong extends Cache {

    CacheLong(SlabAllocator sa) {
        super(KObjectType.t_long, sa);
    }

    protected Slab createSlab(int size,long offset,Cache cache) {
        return new SlabLong(size, offset,cache);
    }
}
