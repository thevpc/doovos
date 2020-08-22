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
class CacheInteger extends Cache {

        CacheInteger(SlabAllocator sa) {
            super(KObjectType.t_int,sa);
        }

        protected Slab createSlab(int size,long offset,Cache cache) {
            return new SlabInteger(size,offset,cache);
        }
    }