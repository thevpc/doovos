/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;

import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KReference;

/**
 *
 * @author vpc
 */
class ObjectPointerPool extends Pool<ObjectPointer> {

    public ObjectPointerPool() {
        super(100, 10000, ObjectPointer.class);
    }

    public ObjectPointer createInstance() {
        return new ObjectPointer();
    }

    @Override
    public void resetInstance(ObjectPointer objectPointer) {
        objectPointer.reference=null;
        objectPointer.objectCount=0;
        objectPointer.slab=null;
        objectPointer.objectOffset=0;
        objectPointer.classRef=null;
        objectPointer.stringValue=null;
    }
}
