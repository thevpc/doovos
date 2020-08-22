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
package org.doovos.kernel.core.jvm.interpreter.instr.opt;

import org.doovos.kernel.api.jvm.bytecode.KOperatorCodes;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.core.jvm.interpreter.KInstructionIdx;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 22 févr. 2009
 * Time: 14:21:52
 * To change this template use File | Settings | File Templates.
 */
public final class KJVM_GETSTATIC0 extends KInstructionIdx implements Cloneable {
    private int classNameIndex;
    private int attributeIndex;

    protected KClass classByName;
    protected KField fieldByName;

    public KJVM_GETSTATIC0(int classNameIndex, int attributeIndex, KField fieldByName, KClass classByName) {
        super(KOperatorCodes.GETSTATIC, new long[]{classNameIndex, attributeIndex});
        this.classNameIndex = classNameIndex;
        this.attributeIndex = attributeIndex;
        this.fieldByName = fieldByName;
        this.classByName = classByName;
    }

    public int run(KFrame frame) throws RemoteException {
        KProcess p = frame.getProcess();
        frame.push(fieldByName.getStaticValue());
        return KProcess.NEXT_STATEMENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        KJVM_GETSTATIC0 that = (KJVM_GETSTATIC0) o;

        if (attributeIndex != that.attributeIndex) return false;
        if (classNameIndex != that.classNameIndex) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + classNameIndex;
        result = 31 * result + attributeIndex;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(KOperatorCodes.ALL_NAMES[operator]);
        sb.append(" ");
        sb.append(classByName.getName());
        sb.append(" ");
        sb.append(fieldByName.getName());
        return sb.toString();
    }

    public boolean isJump() throws RemoteException {
        return false;
    }

    @Override
    public boolean isLabel() throws RemoteException {
        return false;
    }

}