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

import java.io.Serializable;
import org.doovos.kernel.api.jvm.bytecode.KFieldDef;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.memory.KObjectType;

import java.rmi.RemoteException;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KDouble;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 11 mai 2009
 * Time: 03:36:18
 * To change this template use File | Settings | File Templates.
 */
public abstract class KField implements Serializable {

    protected KFieldDef definition;
    protected KClass clazz;
    protected transient KMemorySegment staticSegment;
    protected transient long staticPointer;
    protected transient KMemoryManager memoryManager;

    protected KField(KFieldDef definition, KClass clazz) throws RemoteException {
        this.definition = definition;
        this.clazz = clazz;
    }

    public void defined() throws RemoteException {
        Doovos system = Doovos.getSystem();
        staticSegment = system.getMemorySegment(clazz.staticReference.segment);
        staticPointer = clazz.staticReference.pointer;
        memoryManager = system.getMemoryManager();
    }

    public abstract void setStaticValue(KRegister value) throws RemoteException;

    public abstract KRegister getStaticValue() throws RemoteException;

    public abstract void setInstanceValue(KReference ref, KRegister value) throws RemoteException;
    
    public void setInstanceInt(KReference ref, int value) throws RemoteException{
        setInstanceValue(ref, new KInteger(value));
    }

    public abstract KRegister getInstanceValue(KReference ref) throws RemoteException;

    public int getInstanceInt(KReference ref) throws RemoteException {
        return ((KInteger) getInstanceValue(ref)).intValue();
    }
    
    public double getInstanceDouble(KReference ref) throws RemoteException {
        return ((KDouble) getInstanceValue(ref)).doubleValue();
    }

    public KReference getInstanceRef(KReference ref) throws RemoteException {
        return (KReference) getInstanceValue(ref);
    }

    public KFieldDef getDefinition() {
        return definition;
    }

    public KClass getClazz() {
        return clazz;
    }

    public String getName() {
        return definition.getName();
    }

    public static KField newInstance(KFieldDef fieldDef, KClass field) throws RemoteException {
        KObjectType objectType = KObjectType.resolveByName(fieldDef.getTypeName());
        if (objectType == null || !objectType.isPrimitive()) {
            return new KFieldReference(fieldDef, field);
        } else {
            switch (objectType) {
                case t_boolean: {
                    return new KFieldBoolean(fieldDef, field);
                }
                case t_int: {
                    return new KFieldInt(fieldDef, field);
                }
                case t_byte: {
                    return new KFieldByte(fieldDef, field);
                }
                case t_char: {
                    return new KFieldChar(fieldDef, field);
                }
                case t_double: {
                    return new KFieldDouble(fieldDef, field);
                }
                case t_float: {
                    return new KFieldFloat(fieldDef, field);
                }
                case t_long: {
                    return new KFieldLong(fieldDef, field);
                }
                case t_short: {
                    return new KFieldShort(fieldDef, field);
                }
                default: {
                    throw new IllegalArgumentException("KFieldImpl : " + fieldDef.getTypeName() + " : ?????");
                }
            }
        }
    }
}
