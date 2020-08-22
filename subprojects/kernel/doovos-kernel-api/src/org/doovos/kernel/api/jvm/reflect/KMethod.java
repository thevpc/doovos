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
import java.util.Arrays;
import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;

import java.lang.reflect.Modifier;

/**
 * @author vpc
 */
public final class KMethod implements Serializable {

    public static final int STATUS_DIRTY = 0;
    public static final int STATUS_INITIALZING = 1;
    public static final int STATUS_READY = 2;
    public static final int STATUS_FOR_OPTIMIZATION = 3;
    private int status = STATUS_DIRTY;
    protected KMethodDef definition;
    protected KClass clazz;
    protected int modifiers;
    protected KTryCatchDef[] tryCatchBlocs;
    private KInstruction[] code;
    private Object methodCompilerHints;
    private Object methodCompilerCache;
    private int setFlags;
    private int flags;
    private boolean ignorable;
    public static final int FLAG_IGNORABLE=0; 
    public KMethod(KMethodDef definition, KClass clazz) {
        this.definition = definition;
        this.modifiers = definition.getModifiers();
        this.clazz = clazz;
        this.tryCatchBlocs = definition.getTryCatchBlocs();
    }

    public boolean isSet(int flag) {
        return ((setFlags >> flag) & 1) != 0;
    }
    
    public boolean getFlag(int flag) {
        return ((flag >> flag) & 1) != 0;
    }

    public void set(int flag, boolean value) {
        setFlags |= (2 << flag);
        if (value) {
            flags |= (2 << flag);
        } else {
            flags &= ~(2 << flag);
        }
    }

    public void unset(int flag) {
        setFlags &= ~(2 << flag);
        flags &= ~(2 << flag);
    }

    public KClass getParentClass() {
        return clazz;
    }

    public KMethodDef getDefinition() {
        return definition;
    }

//    public void compile() {
//        if (Modifier.isNative(definition.getModifiers())) {
//            //TODO fix me
//            //this.code = new KInstruction[]{KJVMInstructions.createInstruction(KJVMOperator.XTRA_JNI, null)};
//        }
//    }
    public void setCode(KInstruction[] code) {
        this.code = code;
    }

    public KInstruction[] getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getModifiers() {
        return modifiers;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public boolean isNative() {
        return (Modifier.NATIVE & modifiers) != 0;
    }

    public String getClassName() {
        return definition.getClassName();
    }

    public boolean isProcedure() {
        return definition.isProcedure();
    }

    public String getName() {
        return definition.getName();
    }

    public String getAbsoluteSignature() {
        return definition.getAbsoluteSignature();
    }

    public int getParametersCount() {
        return definition.getParametersCount();
    }

    public void setTryCatchDef(KTryCatchDef[] tryCatchBlocs) {
        this.tryCatchBlocs = tryCatchBlocs;
    }

    public KTryCatchDef[] getTryCatchBlocs() {
        return tryCatchBlocs;
    }

    public String getSignature() {
        return definition.getSignature();
    }

    @Override
    public String toString() {
        return definition.toString() + "{" + enumStr(status) + '}';
    }

    private static String enumStr(int x) {
        switch (x) {
            case STATUS_DIRTY: {
                return "DIRTY";
            }
            case STATUS_FOR_OPTIMIZATION: {
                return "FOR_OPTIMIZATION";
            }
            case STATUS_INITIALZING: {
                return "INITIALZING";
            }
            case STATUS_READY: {
                return "READY";
            }
        }
        return "?";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KMethod other = (KMethod) obj;
        if (this.definition != other.definition && (this.definition == null || !this.definition.equals(other.definition))) {
            return false;
        }
        if (!Arrays.deepEquals(this.tryCatchBlocs, other.tryCatchBlocs)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        final int h1 = this.definition != null ? this.definition.hashCode() : 0;
        final int h2 = Arrays.deepHashCode(this.tryCatchBlocs);

        hash = 13 * hash + h1;
        hash = 13 * hash + h2;
        return hash;
//        int hash = 7;
//        hash = 13 * hash + (this.definition != null ? this.definition.hashCode() : 0);
//        hash = 13 * hash + Arrays.deepHashCode(this.tryCatchBlocs);
//        return hash;
    }

    public Object getMethodCompilerHints() {
        return methodCompilerHints;
    }

    public void setMethodCompilerHints(Object methodCompilerHints) {
        this.methodCompilerHints = methodCompilerHints;
    }

    public Object getMethodCompilerCache() {
        return methodCompilerCache;
    }

    public void setMethodCompilerCache(Object methodCompilerCache) {
        this.methodCompilerCache = methodCompilerCache;
    }

    public boolean isIgnorable() {
        return ignorable;
    }

    public void setIgnorable(boolean ignorable) {
        this.ignorable = ignorable;
    }
    
    
}
