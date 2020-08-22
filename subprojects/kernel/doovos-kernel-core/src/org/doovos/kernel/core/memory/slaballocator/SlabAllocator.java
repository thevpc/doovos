/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.core.memory.slaballocator;

import java.io.Serializable;
import java.util.TreeSet;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.memory.KOutOfMemoryException;
import org.doovos.kernel.core.util.IntKeyHashMap;

/**
 *
 * @author vpc
 */
class SlabAllocator implements Serializable {

//    final ObjectPointerPool objPointerPool = new ObjectPointerPool();
    final Cache[] nativeCaches = new Cache[KObjectType.values().length];
    final IntKeyHashMap<Cache> objectCaches = new IntKeyHashMap<Cache>();
    long freeSize;
    final KSlabMemorySegment mem;
    final private Cache nativeCacheBoolean;
    final private Cache nativeCacheByte;
    final private Cache nativeCacheChar;
    final private Cache nativeCacheShort;
    final private Cache nativeCacheInt;
    final private Cache nativeCacheLong;
    final private Cache nativeCacheFloat;
    final private Cache nativeCacheDouble;
    final private Cache nativeCacheRef;

    SlabAllocator(KSlabMemorySegment mem) {
        this.mem = mem;
        this.freeSize = mem.size;
        nativeCacheBoolean = getNativeCache(KObjectType.t_boolean);
        nativeCacheByte = getNativeCache(KObjectType.t_byte);
        nativeCacheChar = getNativeCache(KObjectType.t_char);
        nativeCacheShort = getNativeCache(KObjectType.t_short);
        nativeCacheInt = getNativeCache(KObjectType.t_int);
        nativeCacheLong = getNativeCache(KObjectType.t_long);
        nativeCacheFloat = getNativeCache(KObjectType.t_float);
        nativeCacheDouble = getNativeCache(KObjectType.t_double);
        nativeCacheRef = getNativeCache(KObjectType.t_ref);

        //nativeListDouble=getNativeSlabList(KObjectType.t_double);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("SlabAllocator (free " + freeSize + "/" + mem.size + "){\n");
        for (Cache dSlabList : nativeCaches) {
            if (dSlabList != null) {
                sb.append(KSlabMemorySegment.indent(dSlabList.toString(), "\t"));
            }
        }
        for (Cache dSlabList : objectCaches.values()) {
            sb.append(KSlabMemorySegment.indent(dSlabList.toString(), "\t"));
        }
        sb.append("\n {\n");
        for (Long aLong : new TreeSet<Long>(mem.objPointers.keySet())) {
            sb.append(" ").append(mem.objPointers.get(aLong)).append("\n");
        }
        sb.append("\n }\n");
        sb.append("}");
        return sb.toString();
    }

    public void freeObj(long offset) {
        ObjectPointer p = mem.getPrivatePointer(offset);
        long toFree = p.objectCount * p.slab.cache.size;
        p.slab.free(p);
        freeSize += toFree;
        //will not free slab
    }

//    public ObjectPointer allocNative(KObjectType type, int arraySize, KClass classRef) {
//        try {
//            ObjectPointer objectPointer = getNativeSlabList(type).alloc(arraySize, classRef);
//
//            freeSize -= objectPointer.objectCount * objectPointer.slab.cache.size;
//            return objectPointer;
//        } catch (KOutOfMemoryException m) {
//            forceFreePages();
//            ObjectPointer objectPointer = getNativeSlabList(type).alloc(arraySize, classRef);
//            freeSize -= objectPointer.objectCount * objectPointer.slab.cache.size;
//            return objectPointer;
//        }
//    }
    public ObjectPointer allocNativeBoolean(int arraySize, KClass classRef) {
        return allocNative(nativeCacheBoolean, arraySize, classRef);
    }

    public ObjectPointer allocNativeByte(int arraySize, KClass classRef) {
        return allocNative(nativeCacheByte, arraySize, classRef);
    }

    public ObjectPointer allocNativeChar(int arraySize, KClass classRef) {
        return allocNative(nativeCacheChar, arraySize, classRef);
    }

    public ObjectPointer allocNativeShort(int arraySize, KClass classRef) {
        return allocNative(nativeCacheShort, arraySize, classRef);
    }

    public ObjectPointer allocNativeInt(int arraySize, KClass classRef) {
        return allocNative(nativeCacheInt, arraySize, classRef);
    }

    public ObjectPointer allocNativeLong(int arraySize, KClass classRef) {
        return allocNative(nativeCacheLong, arraySize, classRef);
    }

    public ObjectPointer allocNativeFloat(int arraySize, KClass classRef) {
        return allocNative(nativeCacheFloat, arraySize, classRef);
    }

    public ObjectPointer allocNativeDouble(int arraySize, KClass classRef) {
        return allocNative(nativeCacheDouble, arraySize, classRef);
    }

    public ObjectPointer allocNativeRef(int arraySize, KClass classRef) {
        return allocNative(nativeCacheRef, arraySize, classRef);
    }

    public ObjectPointer allocNative(Cache nativeSlabList, int arraySize, KClass classRef) {
        try {
            ObjectPointer objectPointer = nativeSlabList.alloc(arraySize, classRef);

            freeSize -= objectPointer.objectCount * objectPointer.slab.cacheSize;
            return objectPointer;
        } catch (KOutOfMemoryException m) {
            forceFreePages();
            ObjectPointer objectPointer = nativeSlabList.alloc(arraySize, classRef);
            freeSize -= objectPointer.objectCount * objectPointer.slab.cacheSize;
            return objectPointer;
        }
    }

    public ObjectPointer allocObj(int arraySize, KClass classRef) {
        KClassDef classDef = classRef.getDefinition();
        int realTypeSize = classDef.getInstanceSize();
        try {
            ObjectPointer objectPointer = getObjSlabList(realTypeSize).alloc(arraySize, classRef);
            //initialize memory
//            byte[] content = classDef.createInstanceBytes();
//            (objectPointer.slab).setBytes(objectPointer, content);
            (objectPointer.slab).reset(objectPointer);
            freeSize -= objectPointer.objectCount * objectPointer.slab.cacheSize;
            return objectPointer;
        } catch (KOutOfMemoryException m) {
            forceFreePages();
            ObjectPointer objectPointer = getObjSlabList(realTypeSize).alloc(arraySize, classRef);
            freeSize -= objectPointer.objectCount * objectPointer.slab.cacheSize;
            return objectPointer;
        }
    }

    public ObjectPointer allocClass(int arraySize, KClass classRef) {
        KClassDef cl = classRef.getDefinition();
        int realTypeSize = cl.getClassSize();
        try {
            ObjectPointer objectPointer = getObjSlabList(realTypeSize).alloc(arraySize, classRef);
            //initialize memory
//            byte[] content = cl.createClassBytes();
            (objectPointer.slab).reset(objectPointer);
//            objectPointer.slab.setBytes(objectPointer, content);
            freeSize -= objectPointer.objectCount * objectPointer.slab.cache.size;
            return objectPointer;
        } catch (KOutOfMemoryException m) {
            forceFreePages();
            ObjectPointer objectPointer = getObjSlabList(realTypeSize).alloc(arraySize, classRef);
            freeSize -= objectPointer.objectCount * objectPointer.slab.cache.size;
            return objectPointer;
        }
    }

    private void forceFreePages() {
        for (Cache dSlabList : objectCaches.values()) {
            dSlabList.forceFreePages();
        }
        for (Cache dSlabList : nativeCaches) {
            if (dSlabList != null) {
                dSlabList.forceFreePages();
            }
        }
    }

    Cache getObjSlabList(int size) {
        Cache slabList = objectCaches.get(size);
        if (slabList == null) {
            slabList = new CacheObject(size, this);
            objectCaches.put(size, slabList);
        }
        return slabList;
    }

    public final Cache getNativeCache(KObjectType type) {
        Cache slabList = nativeCaches[type.ordinal()];
        if (slabList == null) {
            switch (type) {
                case t_int: {
                    slabList = new CacheInteger(this);
                    break;
                }
                case t_short: {
                    slabList = new CacheShort(this);
                    break;
                }
                case t_double: {
                    slabList = new CacheDouble(this);
                    break;
                }
                case t_boolean: {
                    slabList = new CacheBoolean(this);
                    break;
                }
                case t_byte: {
                    slabList = new CacheByte(this);
                    break;
                }
                case t_char: {
                    slabList = new CacheChar(this);
                    break;
                }
                case t_float: {
                    slabList = new CacheFloat(this);
                    break;
                }
                case t_long: {
                    slabList = new CacheLong(this);
                    break;
                }
//                case t_string:
                case t_ref: {
                    slabList = new CacheRef(this);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unsupported");
                }
            }
            nativeCaches[type.ordinal()] = slabList;
        }
        return slabList;
    }
//        private class CacheString extends Cache {
//
//            private CacheString() {
//                super(DObjectType.t_string);
//            }
//
//            protected Slab createSlab(int size) {
//                return new SlabString(size);
//            }
//        }
//        private class SlabString extends Slab {
//            DRegisterString[] values;
//
//            private SlabString(int length) {
//                super(length, 8);
//                values = new DRegisterString[length];
//                for (int i = 0; i < values.length; i++) {
//                    values[i] = new DRegisterString(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFF, 0xFFFFFFFF);
//                }
//            }
//
//            public DObject getArrayItem(ObjectPointer p, int index) {
//                if (!p.classRef.isArray()) {
//                    throw new IllegalArgumentException("Not and array");
//                }
//                return DoovosUtils.createObject(getValue(p, index));
//            }
//
//            public DRegisterString getValue(ObjectPointer p) {
//                return values[p.objectOffset];
//            }
//
//            public DRegisterString getValue(ObjectPointer p, int index) {
//                return values[p.objectOffset + index];
//            }
//
//            public void setValue(ObjectPointer p, int index, long pointer, int offset, int count) {
//                DRegisterString svalue = values[p.objectOffset + index];
//                svalue.count = count;
//                svalue.pointer = pointer;
//                svalue.offset = offset;
//            }
//
//            public void setValue(ObjectPointer p, long pointer, int offset, int count) {
//                DRegisterString svalue = values[p.objectOffset];
//                svalue.count = count;
//                svalue.pointer = pointer;
//                svalue.offset = offset;
//            }
//
//            public void setArray(ObjectPointer p, DRegisterString[] value) {
//                if (value.length != p.objectCount) {
//                    throw new DMemoryException("Invalid memory size");
//                }
//                System.arraycopy(value, 0, values, p.objectOffset, value.length);
//            }
//
//            public DRegisterString[] getArray(ObjectPointer p) {
//                DRegisterString[] ret = new DRegisterString[p.objectCount];
//                System.arraycopy(values, p.objectOffset, ret, 0, ret.length);
//                return ret;
//            }
//
//            public void setValue(ObjectPointer p, int index, DObject object) {
//                DMemoryUtils.byteArray2String(object.getContent(), 0, values[p.objectOffset + index]);
//            }
//
//            public byte[] toBytes(ObjectPointer p) {
//                byte[] b = new byte[p.objectCount * 16];
//                int so = p.objectOffset;
//                for (int i = 0; i < p.objectCount; i++) {
//                    DRegisterString r = values[so + i];
//                    DMemoryUtils.string2byteArray(r, b, 16 * i);
//                }
//                return b;
//            }
//
//            public void setBytes(ObjectPointer p, byte[] newValues) {
//                int so = p.objectOffset;
//                for (int i = 0; i < p.objectCount; i += 16) {
//                    DMemoryUtils.byteArray2String(newValues, i, values[so + i / 16]);
//                }
//            }
//
//            //decoration.setLength();
//        }
}

