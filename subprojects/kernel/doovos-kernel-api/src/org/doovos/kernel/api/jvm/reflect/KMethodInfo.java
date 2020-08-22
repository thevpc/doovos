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
package org.doovos.kernel.api.jvm.reflect;

import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * @author vpc
 */
public final class KMethodInfo implements Serializable{

    protected int modifiers;
    protected String signature;
    protected String className;
    protected KTryCatchDef[] tryCatchBlocs;
    private KInstruction[] code;
    private Class<? extends KInstruction> codeType;

    public KMethodInfo(int modifiers, String signature, String className, KInstruction[] code, KTryCatchDef[] tryCatchBlocs, Class<? extends KInstruction> codeType) {
        this.modifiers = modifiers;
        this.signature = signature;
        this.className = className;
        this.tryCatchBlocs = tryCatchBlocs;
        this.code = code;
        this.codeType = codeType;
    }

    public int getModifiers() {
        return modifiers;
    }

    public String getSignature() {
        return signature;
    }

    public String getClassName() {
        return className;
    }

    public KTryCatchDef[] getTryCatchBlocs() {
        return tryCatchBlocs;
    }

    public KInstruction[] getCode() {
        KInstruction[] o = (KInstruction[]) Array.newInstance(codeType, code.length);
        for (int i = 0; i < o.length; i++) {
            o[i]=code[i].clone();
        }
        return code;
    }

}
