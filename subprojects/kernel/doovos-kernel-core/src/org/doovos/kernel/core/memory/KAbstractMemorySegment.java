/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.core.memory;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.DoovosConstants;
import org.doovos.kernel.api.filesystem.KFileSystemManager;
import org.doovos.kernel.api.filesystem.KPropertyEvent;
import org.doovos.kernel.api.filesystem.KResourceType;
import org.doovos.kernel.api.jvm.KGarbageCollector;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KObjectType;
import org.doovos.kernel.api.memory.KPointerInfo;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
//import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import org.doovos.kernel.api.jvm.bytecode.KSegmentDef;
import org.doovos.kernel.api.memory.KLocalMemorySegment;
import org.doovos.kernel.core.filesystem.KPrefixedPathRuntimeResourceImpl;

/**
 * Memory segment implementation as Slab allocator.
 * Acyually ot's a very specific
 * <p/>
 * unit is byte (8 bits)
 */
public abstract class KAbstractMemorySegment extends KPrefixedPathRuntimeResourceImpl implements KLocalMemorySegment {

    private static final Doovos SYSTEM = Doovos.getSystem();
    private static final KFileSystemManager FILE_SYSTEM_MANAGER = SYSTEM.getFileSystemManager();
    protected long string_classid;
    protected KField string_value;
    protected KField string_offset;
    protected KField string_count;
    protected int string_value__offset;
    protected int string_offset__offset;
    protected int string_count__offset;
    private String mainProcessPath;
    private List<String> dependencies = new ArrayList<String>();
//    private KClass stringClassRef;
    private KGarbageCollector gc;
    protected int id;
    protected KClass SHORT;
    protected KClass SHORT_ARRAY;
    protected KClass INTEGER;
    protected KClass INTEGER_ARRAY;
    protected KClass LONG;
    protected KClass LONG_ARRAY;
    protected KClass FLOAT;
    protected KClass FLOAT_ARRAY;
    protected KClass DOUBLE;
    protected KClass DOUBLE_ARRAY;
    protected KClass BYTE;
    protected KClass BYTE_ARRAY;
    protected KClass BOOLEAN;
    protected KClass BOOLEAN_ARRAY;
    protected KClass CHAR;
    protected KClass CHAR_ARRAY;
//    protected KClass CLASS;
    protected KClass STRING;
    protected KClass VOID;

    public KAbstractMemorySegment() throws RemoteException {
        super(KResourceType.MEMORY_SEGMENT, true, DoovosConstants.MEMORY_SEGMENTS_PATH, null, null);
    }

    public void prepare() throws RemoteException {
        if (SHORT == null) {
            KClassRepository clsRepo = getProcess().getClassRepository();
            SHORT = clsRepo.getClassByName(KObjectType.t_short.getName());
            INTEGER = clsRepo.getClassByName(KObjectType.t_int.getName());
            LONG = clsRepo.getClassByName(KObjectType.t_long.getName());
            FLOAT = clsRepo.getClassByName(KObjectType.t_float.getName());
            DOUBLE = clsRepo.getClassByName(KObjectType.t_double.getName());
            BYTE = clsRepo.getClassByName(KObjectType.t_byte.getName());
            BOOLEAN = clsRepo.getClassByName(KObjectType.t_boolean.getName());
            CHAR = clsRepo.getClassByName(KObjectType.t_char.getName());
            VOID = clsRepo.getClassByName(KObjectType.t_void.getName());
            STRING = clsRepo.getClassByName("java.lang.String");
            string_classid=STRING.getDefinition().getClassId();
            string_value = STRING.getField("value", true);
            string_offset = STRING.getField("offset", true);
            string_count = STRING.getField("count", true);
            string_value__offset = string_value.getDefinition().getByteOffset();
            string_offset__offset = string_offset.getDefinition().getByteOffset();
            string_count__offset = string_count.getDefinition().getByteOffset();


            SHORT_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_short.getCode());
            INTEGER_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_int.getCode());
            LONG_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_long.getCode());
            FLOAT_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_float.getCode());
            DOUBLE_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_double.getCode());
            BYTE_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_byte.getCode());
            BOOLEAN_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_boolean.getCode());
            CHAR_ARRAY = clsRepo.getClassByName("[" + KObjectType.t_char.getCode());
//            CLASS = clsRepo.getClassByName("java.lang.Class");
        }
    }

    public void init(KProcess process, KSegmentDef options) throws RemoteException {
        this.mainProcessPath = process.getPath();
        gc = process.getGarbageCollector();
    }

    @Override
    public void attach() throws RemoteException {
        super.attach();
        id = Integer.parseInt(getName());
        if (this.mainProcessPath != null) {
            addDependency(this.mainProcessPath);
        }
    }

    public final int getId() throws RemoteException {
        return id;
    }

    public void addDependency(String path) throws RemoteException {
        if (path != null && !dependencies.contains(path)) {
            FILE_SYSTEM_MANAGER.getResource(path).addPropertyEventListener(getPath(), DoovosConstants.PROPERTY_NAME_PRE_FREE);
            dependencies.add(path);
        }
    }

    public void removeDependency(String path) throws RemoteException {
        if (path != null) {
            FILE_SYSTEM_MANAGER.getResource(path).removePropertyEventListener(getPath(), DoovosConstants.PROPERTY_NAME_PRE_FREE);
            dependencies.remove(path);
        }
    }

    public KReference allocMultiArray(KClass classRef, int[] size) throws RemoteException {
        KReference arrRef = allocArray(classRef, size[0]);
        if (1 < size.length) {
            fillArr(classRef.getArrayComponent(), arrRef, size, 1);
        }
        return arrRef;
    }

    private void fillArr(KClass clz, KReference arr, int[] dims, int dimIndex) throws RemoteException {
        int len = dims[dimIndex - 1];
        KReference[] all = new KReference[len];
        for (int i = 0; i < len; i++) {
            KReference subArray = allocArray(clz, dims[dimIndex]);
            if (dimIndex + 1 < dims.length) {
                fillArr(clz.getArrayComponent(), subArray, dims, dimIndex + 1);
            }
            all[i] = subArray;
        }
        setReferenceArray(arr.pointer, all);
    }

    public KReference allocArray(KClass classRef, int size) throws RemoteException {
        if (!classRef.isPrimitive() || classRef.getArrayDepth() > 1) {
            return allocRefArray(classRef, size);
        } else {
            switch (classRef.getType()) {
                case t_byte: {
                    return allocByteArray(size);
                }
                case t_boolean: {
                    return allocBooleanArray(size);
                }
                case t_char: {
                    return allocCharArray(size);
                }
                case t_double: {
                    return allocDoubleArray(size);
                }
                case t_float: {
                    return allocFloatArray(size);
                }
                case t_int: {
                    return allocIntArray(size);
                }
                case t_long: {
                    return allocLongArray(size);
                }
                case t_short: {
                    return allocShortArray(size);
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public void onPropertyEvent(KPropertyEvent event) throws RemoteException {
        switch (event.getType()) {
            case PROCESS: {
                switch (event.getEventId()) {
                    case DoovosConstants.PROPERTY_ID_FREE: {
                        //no need to removeDependency, resource is already freed
                        //removeDependency(event.getSource());
                        dependencies.remove(event.getSource());
                        if (dependencies.isEmpty()) {
                            free();
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public KProcess getProcess() throws RemoteException {
        return (KProcess) FILE_SYSTEM_MANAGER.getResource(mainProcessPath);
    }

    public String getMainProcessPath() {
        return mainProcessPath;
    }

    public KGarbageCollector getGarbageCollector() throws RemoteException {
        return gc;
    }

    public void gc() throws RemoteException {
        gc.gc(this);
    }

    public KGarbageCollector getGC() {
        return gc;
    }

//    public void arraycopy_old(KReference src, int srcPos, long dest, int destPos, int length) throws RemoteException {
//        KMemorySegment mm = Doovos.getMemorySegment(src.segment);
//        long srcPointer = src.pointer;
//        KPointerInfo strPtr = mm.getPointer(srcPointer);
//        switch (strPtr.getKClass().getType()) {
//            case t_boolean: {
//                boolean[] srcArr = mm.getBooleanArray(srcPointer);
//                arraycopy0(src, srcPos, dest, destPos, length);
//                boolean[] destArr = mm.getBooleanArray(dest);
//                for(int i=0;i<length;i++){
//                    if(srcArr[i+srcPos]!=destArr[i+destPos]){
//                        throw new IllegalStateException();
//                    }
//                }
//                break;
//            }
//            case t_byte: {
//                byte[] srcArr = mm.getByteArray(srcPointer);
//                arraycopy0(src, srcPos, dest, destPos, length);
//                byte[] destArr = mm.getByteArray(dest);
//                for(int i=0;i<length;i++){
//                    if(srcArr[i+srcPos]!=destArr[i+destPos]){
//                        throw new IllegalStateException();
//                    }
//                }
//                break;
//            }
//            case t_char: {
//                char[] srcArr = mm.getCharArray(srcPointer);
//                char[] destArr0 = getCharArray(dest);
//                arraycopy0(src, srcPos, dest, destPos, length);
//                char[] destArr = mm.getCharArray(dest);
//                for(int i=0;i<length;i++){
//                    if(srcArr[i+srcPos]!=destArr[i+destPos]){
//                        arraycopy0(src, srcPos, dest, destPos, length);
//                        destArr = mm.getCharArray(dest);
//                        throw new IllegalStateException();
//                    }
//                }
//                break;
//            }
//            case t_ref:
//            case t_obj:
//            {
//                KReference[] srcArr = mm.getReferenceArray(srcPointer);
//                arraycopy0(src, srcPos, dest, destPos, length);
//                KReference[] destArr = mm.getReferenceArray(dest);
//                for(int i=0;i<length;i++){
//                    if(srcArr[i+srcPos]!=destArr[i+destPos]){
//                        throw new IllegalStateException();
//                    }
//                }
//                break;
//            }
//            default:{
//                throw new UnsupportedOperationException(strPtr.getKClass().getType()+"");
//            }
//        }
//
//    }
    public void arraycopy(KReference src, int srcPos, long dest, int destPos, int length) throws RemoteException {
        if (src.segment == id) {
            arraycopyself(src.pointer, srcPos, dest, destPos, length);
        } else {
            int srcMax = srcPos + length;
            int j = destPos;
            KMemorySegment mm = SYSTEM.getMemorySegment(src.segment);
            long srcPointer = src.pointer;
            KPointerInfo pointerInfo = mm.getPointer(srcPointer);
            KClass kClass = pointerInfo.getKClass();
            if (kClass.isArray()) {
                switch (kClass.getType()) {
                    case t_boolean: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setBooleanArray(dest, j, mm.getBooleanArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_char: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setCharArray(dest, j, mm.getCharArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_ref: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setReferenceArray(dest, j, mm.getReferenceArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_obj: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setReferenceArray(dest, j, mm.getReferenceArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_byte: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setByteArray(dest, j, mm.getByteArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_double: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setDoubleArray(dest, j, mm.getDoubleArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_float: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setFloatArray(dest, j, mm.getFloatArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_int: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setIntArray(dest, j, mm.getIntArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_long: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setLongArray(dest, j, mm.getLongArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                    case t_short: {
                        for (int i = srcPos; i < srcMax; i++) {
                            setShortArray(dest, j, mm.getShortArray(srcPointer, i));
                            j++;
                        }
                        return;
                    }
                }
            }
            throw new IllegalArgumentException("Not an array");
        }
    }

    public void arraycopyself(long src, int srcPos, long dest, int destPos, int length) throws RemoteException {
//        KPointerInfo srcPointer = Doovos.getSystem().getMemoryManager().getPointer(src);
//        KPointerInfo destPointer = Doovos.getSystem().getMemoryManager().getPointer(dest);
        int srcMax = srcPos + length;
        int j = destPos;
        KPointerInfo pointerInfo = getPointer(src);
        KClass kClass = pointerInfo.getKClass();
        if (kClass.isArray()) {
            switch (kClass.getType()) {
                case t_boolean: {
                    if (src == dest) {
                        boolean[] buffer = new boolean[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getBooleanArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setBooleanArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setBooleanArray(dest, j, getBooleanArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_char: {
                    if (src == dest) {
                        char[] buffer = new char[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getCharArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setCharArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setCharArray(dest, j, getCharArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_obj:
                case t_ref: {
                    if (src == dest) {
                        KReference[] buffer = new KReference[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getReferenceArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setReferenceArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setReferenceArray(dest, j, getReferenceArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_byte: {
                    if (src == dest) {
                        byte[] buffer = new byte[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getByteArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setByteArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setByteArray(dest, j, getByteArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_double: {
                    if (src == dest) {
                        double[] buffer = new double[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getDoubleArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setDoubleArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setDoubleArray(dest, j, getDoubleArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_float: {
                    if (src == dest) {
                        float[] buffer = new float[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getFloatArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setFloatArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setFloatArray(dest, j, getFloatArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_int: {
                    if (src == dest) {
                        int[] buffer = new int[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getIntArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setIntArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setIntArray(dest, j, getIntArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_long: {
                    if (src == dest) {
                        long[] buffer = new long[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getLongArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setLongArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setLongArray(dest, j, getLongArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
                case t_short: {
                    if (src == dest) {
                        short[] buffer = new short[length];
                        for (int i = 0; i < length; i++) {
                            buffer[i] = getShortArray(src, srcPos + i);
                        }
                        for (int i = 0; i < length; i++) {
                            setShortArray(dest, j, buffer[i]);
                            j++;
                        }
                    } else {
                        for (int i = srcPos; i < srcMax; i++) {
                            setShortArray(dest, j, getShortArray(src, i));
                            j++;
                        }
                    }
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Not an array");
    }
}
