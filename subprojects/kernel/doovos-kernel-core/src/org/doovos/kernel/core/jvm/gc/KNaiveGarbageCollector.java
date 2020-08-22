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
package org.doovos.kernel.core.jvm.gc;

import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KPointerInfo;
import org.doovos.kernel.api.jvm.KGarbageCollector;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 mars 2009
 * Time: 09:55:29
 * To change this template use File | Settings | File Templates.
 */
public final class KNaiveGarbageCollector implements KGarbageCollector {
    private Map<KReference, GCInfo> map = new HashMap<KReference, GCInfo>();

    private final static class GCInfo {
        KRegister pointer;
        int refsCount;
        List<KReference> backward;

        public synchronized void addBackwardReference(KReference forward) throws RemoteException {
            if (backward == null) {
                backward = new ArrayList<KReference>(3);
            }
            backward.add(forward);
        }

        public void removeBackwardReference(KReference forward) throws RemoteException {
            backward.remove(forward);
        }
    }

    public void gc(KMemorySegment segment) throws RemoteException {
        Collection<? extends KPointerInfo> pointerInfoList = segment.getPointers();
        ArrayList<KReference> toRemove = new ArrayList<KReference>();
        for (KPointerInfo kPointerInfo : pointerInfoList) {
            KReference ref = kPointerInfo.getReference();
            GCInfo i = map.get(ref);
            if (i == null) {
                toRemove.add(ref);
            } else if (i.refsCount == 0) {
                List<KReference> kReferenceList = i.backward;
                if (kReferenceList == null || kReferenceList.size() == 0) {
//                    System.out.print("[GC] : Marked " + kPointerInfo);
//                    if(kPointerInfo.getKClass().getName().equals("java.lang.String")){
//                        System.out.print(" : --> "+segment.getStringChars(kPointerInfo.getOffset()));
//                    }
                    toRemove.add(ref);
                }
            }
        }
        for (KReference rr : toRemove) {
//            System.out.println("[GC] : Free " + aLong);
            segment.free(rr.pointer);
        }
    }

    public void incReferencesCount(KReference reg) throws RemoteException {
//        System.out.println(getClass().getName()+ " : incReferencesCount "+offset);
        GCInfo objectPointer = map.get(reg);
        if (objectPointer == null) {
            objectPointer = new GCInfo();
            map.put(reg, objectPointer);
        }
        objectPointer.pointer = reg;
        objectPointer.refsCount++;
    }

    public void decReferencesCount(KReference reg) throws RemoteException {
//        System.out.println(getClass().getName()+ " : decReferencesCount "+offset);
        GCInfo objectPointer = map.get(reg);
        objectPointer.refsCount--;
    }

    public void forceFree(KReference reg) throws RemoteException {
        map.remove(reg);
    }

    public void addBackwardReference(KReference reg, KReference forward) throws RemoteException {
//        System.out.println(getClass().getName()+ " : addBackwardReference "+offset+" -> "+forward);
        GCInfo objectPointer = map.get(reg);
        if (objectPointer == null) {
            objectPointer = new GCInfo();
            map.put(reg, objectPointer);
        }
        objectPointer.addBackwardReference(forward);
    }

    public void removeBackwardReference(KReference reg, KReference forward) throws RemoteException {
//        System.out.println(getClass().getName()+ " : removeBackwardReference "+offset+" -> "+forward);
        GCInfo objectPointer = map.get(reg);
        objectPointer.removeBackwardReference(forward);
    }
}
