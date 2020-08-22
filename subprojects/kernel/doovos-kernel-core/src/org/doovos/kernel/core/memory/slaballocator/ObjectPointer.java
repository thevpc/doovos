/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;


import java.io.Serializable;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KPointerInfo;

/**
 *
 * @author vpc
 */
public class ObjectPointer implements Serializable, KPointerInfo {

    KReference reference;
    int objectCount;
    Slab slab;
    int objectOffset;
    KClass classRef;
    String stringValue;

    ObjectPointer() {
    }

    public boolean contains(long offset) {
        return offset >= reference.pointer && offset < (reference.pointer + objectCount);
    }

    @Override
    public String toString() {
        if (classRef.isArray()) {
            String s = classRef.getName();
            s = s + objectCount;
            return "{@" + reference.segment + "." + reference.pointer + " : " + s + /*" ; " + slab.getObject(this) + */"}";
        } else {
            return "{@" + reference.segment + "." + reference.pointer + " : " + classRef.getName() + /*" ; " + slab.getObject(this) + */"}";
        }
        //return "ObjectPointer(pointer=" + offset + "; arrayCount=" + objectCount + "; index=" + objectOffset + "; type =" + slab.cache.type + "; class " + classRef + "; size=" + slab.byteSize + "; value=" + slab.getObject(this) + ")";
    }

    /*
    return new KPointerInfoImpl(
    objectPointer.offset,
    objectPointer.slab.byteSize,
    objectPointer.objectOffset,
    objectPointer.classRef,
    objectPointer.slab.cache.type,
    objectPointer.backward
    );

     */
    public int getSize() {
        return slab.getByteSize();
    }

    public KClass getKClass() {
        return classRef;
    }

    public KReference getReference() {
        return reference;
    }

}

