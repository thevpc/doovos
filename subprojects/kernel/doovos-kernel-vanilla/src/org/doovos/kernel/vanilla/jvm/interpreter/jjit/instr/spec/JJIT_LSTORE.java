package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.spec;

import org.doovos.kernel.api.jvm.bytecode.KOperator;
import org.doovos.kernel.api.memory.KRegisterType;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.base.JJIT__BASE_XSTORE;

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
public final class JJIT_LSTORE extends JJIT__BASE_XSTORE implements Cloneable{

    public static final JJIT_LSTORE LSTORE_0 = new JJIT_LSTORE(KOperator.LSTORE_0, 0);
    public static final JJIT_LSTORE LSTORE_1 = new JJIT_LSTORE(KOperator.LSTORE_1, 1);
    public static final JJIT_LSTORE LSTORE_2 = new JJIT_LSTORE(KOperator.LSTORE_2, 2);
    public static final JJIT_LSTORE LSTORE_3 = new JJIT_LSTORE(KOperator.LSTORE_3, 3);

    private JJIT_LSTORE(KOperator op, int index) {
        super(op,KRegisterType.LONG,index);
    }

    public JJIT_LSTORE(int index) {
        super(KOperator.LSTORE,KRegisterType.LONG,index);
    }
}
