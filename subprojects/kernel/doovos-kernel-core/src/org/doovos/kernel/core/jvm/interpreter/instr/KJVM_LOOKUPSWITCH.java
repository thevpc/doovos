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
package org.doovos.kernel.core.jvm.interpreter.instr;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;
import org.doovos.kernel.core.jvm.interpreter.instr.groups.KInstructionIf;




import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.jvm.interpreter.KFrame;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public final class KJVM_LOOKUPSWITCH extends KInstructionIdx implements Cloneable, KInstructionIf {
    public Map<Integer, Integer> map;
    public int defaultLabel;



    public KJVM_LOOKUPSWITCH(long[] operands) {
        super(KOperatorCodes.LOOKUPSWITCH, operands);
        int count = (int) operands[0];
        defaultLabel = (int) operands[count + 1];
        map = new HashMap<Integer, Integer>(count);
        for (int i = 0; i < count; i++) {
            int v = (int) operands[i + 1];
            int l = (int) operands[i + 2 + count];
            map.put(v, l);
        }
    }

    public int run(KFrame frame) throws RemoteException {
        int v = frame.popInt();
        Integer jumpValueI = map.get(v);
        return jumpValueI == null ? defaultLabel : jumpValueI;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_LOOKUPSWITCH that = (KJVM_LOOKUPSWITCH) o;

        if (defaultLabel != that.defaultLabel) return false;
        if (map != null ? !map.equals(that.map) : that.map != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (map != null ? map.hashCode() : 0);
        result = 31 * result + defaultLabel;
        return result;
    }

    @Override
    public boolean isJump() throws RemoteException {
        return true;
    }

    @Override
    public KInstruction clone() {
        KJVM_LOOKUPSWITCH i = (KJVM_LOOKUPSWITCH) super.clone();
        i.map = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> ii : map.entrySet()) {
            i.map.put(ii.getKey(), ii.getValue());
        }
        return i;
    }


}