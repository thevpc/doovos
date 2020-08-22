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
class CacheObject32 extends Cache {

    CacheObject32(int size, SlabAllocator sa) {
        super(KObjectType.t_ref, size, sa);
    }

    protected Slab createSlab(int size, long offset, Cache cache) {
        return new SlabObj32(this.size, size, offset, cache);
    }
}
