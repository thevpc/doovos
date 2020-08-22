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
package org.doovos.kernel.api.memory.adapter;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.process.KProcess;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KMemoryManager;

public class MapAdapter extends AbstractMemoryAdapter {

    public static MapAdapter createHashtable(KProcess process, JNIEnv env) throws RemoteException, Exception {
        return new MapAdapter(process, env, "java.util.Hashtable");
    }

    public static MapAdapter createProperties(KProcess process, JNIEnv env) throws RemoteException, Exception {
        return new MapAdapter(process, env, "java.util.Properties");
    }
    private KMethod putMethod;
    private KMethod getMethod;
    private KMethod sizeMethod;
//    private KMethod entrySetMethod;
//    private KMethod Set_toArrayMethod;
//    private KMethod MapEntry_getKey;
//    private KMethod MapEntry_getValue;

    private MapAdapter(KProcess process, JNIEnv env, String className) throws RemoteException, Exception {
        super();
        setProcess(process);
        setKClass(process.getClassRepository().getClassByName(className));
        env.invokeClassInitializer(getKClass());
        setReference(process.getMemorySegment().allocObject(getKClass()));
    }

    public MapAdapter(KProcess process, KReference reference) throws RemoteException {
        super(process, Doovos.getSystem().getMemoryManager().getPointer(reference).getKClass(), reference);
    }

    public void put(JNIEnv env, KReference key, KReference value) throws Exception {
        if (putMethod == null) {
            putMethod = getKClass().getMethodBySignature("put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");

        }
        env.invokeObjectMethod(putMethod, getReference(), key, value);
    }

    public void put(JNIEnv env, String key, String value) throws Exception {
        final KMemorySegment m = env.getMemorySegment();
        put(env, m.allocString(key), m.allocString(value));
    }

    public KReference get(JNIEnv env, KReference key) throws Exception {
        if (getMethod == null) {
            getMethod = getKClass().getMethodBySignature("get(Ljava/lang/Object;)Ljava/lang/Object;");

        }
        return (KReference) env.invokeObjectMethod(getMethod, getReference(), key);
    }

    public String get(JNIEnv env, String key) throws Exception {
        final KMemorySegment m = env.getMemorySegment();
        final KReference sp = m.allocString(key);
        final KReference rp = get(env, sp);
        if (rp.isNull()) {
            return null;
        }
        return m.getString(rp.pointer);
    }

    public int size(JNIEnv env, KReference key) throws Exception {
        if (sizeMethod == null) {
            sizeMethod = getKClass().getMethodBySignature("size()I");

        }
        return ((KInteger) env.invokeObjectMethod(sizeMethod, getReference(), key)).value;
    }

    public Map<KReference, KReference> toMap(JNIEnv env) throws Exception {
        //Set<Map.Entry<K, V>> entrySet();
        final KProcess process = env.getProcess();
        final KMemoryManager m = process.getMemoryManager();

        Map<KReference, KReference> map = new HashMap<KReference, KReference>();
        //Object[] o = map.entrySet().toArray();
        final KClassRepository cr = env.getClassRepository();
        KMethod entrySetMethod = getKClass().getVirtualMethodBySignature("entrySet()Ljava/util/Set;");
        KReference entrySetRef = ((KReference) env.invokeObjectMethod(entrySetMethod, getReference()));
        KClass entrySetClass = m.getKClass(entrySetRef);

        KMethod Set_toArrayMethod = entrySetClass.getVirtualMethodBySignature("toArray()[Ljava/lang/Object;");
        KReference arrObjRef = ((KReference) env.invokeObjectMethod(Set_toArrayMethod, entrySetRef));
        int arrSize = m.getArraySize(arrObjRef);
        KMethod MapEntry_getKey = null;
        KMethod MapEntry_getValue = null;
        for (int i = 0; i < arrSize; i++) {
            KReference me = m.getReferenceArray(arrObjRef, i);
            if (MapEntry_getKey == null) {
                final KClass kcalss = m.getKClass(me);
                MapEntry_getKey = kcalss.getVirtualMethodBySignature("getKey()Ljava/lang/Object;");
                MapEntry_getValue = kcalss.getVirtualMethodBySignature("getValue()Ljava/lang/Object;");
            }
            final KReference kref = (KReference) env.invokeObjectMethod(MapEntry_getKey, me);
            final KReference vref = (KReference) env.invokeObjectMethod(MapEntry_getValue, me);
            map.put(kref, vref);
        }
        return map;
    }

    public Properties toProperties(JNIEnv env) throws Exception {
        Properties props = new Properties();
        final KMemoryManager m = getProcess().getMemoryManager();
        for (Entry<KReference, KReference> entry : toMap(env).entrySet()) {
            String k = m.getString(entry.getKey());
            String v = m.getString(entry.getValue());
            props.setProperty(k, v);
        }
        return props;
    }
}
