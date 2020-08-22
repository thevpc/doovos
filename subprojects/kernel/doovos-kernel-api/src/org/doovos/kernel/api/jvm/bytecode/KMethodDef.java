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
package org.doovos.kernel.api.jvm.bytecode;


import org.doovos.kernel.api.util.EmptyArray;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class KMethodDef implements Serializable {

    public static final String SIG_CLINIT = "<clinit>()V";
    public static final String CONSTRUCTOR = "<init>";
//    private static final String[] EMPTY_ARRAY_STRING = new String[0];
    private String name;
    private String type;
    private KParameterDef[] parameters;
    private KTryCatchDef[] tryCatchBlocs;
    private KVariableDef[] variables;
    private KInstructionDef[] code;
    private int modifiers;
    private KClassDef parentClass;
    private int maxLocals;
    private int maxStack = 1;
    private String className;
    private String signature;
    private String absoluteSignature;
    private boolean procedure;
    private boolean ignorable;

    public KMethodDef() {
    }

    public KMethodDef(String name, String className, String type, int methodModifiers, KParameterDef[] parameters, KVariableDef[] variables, KInstructionDef[] code, KTryCatchDef[] tryCatchBlocs, int maxLocals, int maxStack) {
        this.name = name;
        this.className = className;
        this.type = type;
        this.parameters = parameters;
        this.tryCatchBlocs = tryCatchBlocs;
        this.variables = variables;
        this.code = code;
        this.maxLocals = maxLocals;
        setMaxStack(maxStack);
        setModifiers(methodModifiers);
        compile();
    }

    public void compile() {
//        StringBuilder signatureBuffer = new StringBuilder(name);
//        signatureBuffer.append("(");
//        for (KParameterDef parameter : parameters) {
//            signatureBuffer.append(parameter.getType());
//        }
//        signatureBuffer.append(")");
//        signatureBuffer.append(type);
        absoluteSignature = className + "." + signature;
//        signature = signatureBuffer.toString();
        procedure = "void".equals(type);
//        if(signature.equals(SIG_CLINIT)){
//            System.out.println("?");
//        }
//        if (Modifier.isNative(modifiers)) {
//            //this.code = new KInstruction[]{KJVMInstructions.createInstruction(KJVMOperator.XTRA_JNI, null)};
//        }
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isProcedure() {
        return procedure;
    }

    public void setCode(KInstructionDef[] code) {
        this.code = code;
    }



    public String getName() {
        return name;
    }

    public String getReturnType() {
        return type;
    }

    public boolean isNative() {
        return (Modifier.NATIVE & modifiers) != 0;
    }

    public boolean isAbstract() {
        return (Modifier.ABSTRACT & modifiers) != 0;
    }

    public int getModifiers() {
        return modifiers;
    }

    public List<KParameterDef> getParameters() {
        return Arrays.asList(parameters);
    }

    public int getParametersCount() {
        return parameters.length;
    }

    public KParameterDef getParameter(int index) {
        return parameters[index];
    }

    public int getVariableCount() {
        return variables.length;
    }

    public KVariableDef getVariableByIndex(int index) {
        for (KVariableDef v : variables) {
            if(v.getIndex()==index){
                return v;
            }
        }
        return null;//variables[index];
    }

    public KInstructionDef[] getCode() {
        return code;
    }

    public KClassDef getParentClass() {
        return parentClass;
    }

    void setParentClass(KClassDef parentClass) {
        this.parentClass = parentClass;
    }

    public KTryCatchDef[] getTryCatchBlocs() {
        return tryCatchBlocs;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return className + "." + signature;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public int getMaxStack() {
        return maxStack;
    }

    private int hashCache = 0;

    public String[] getExceptionTypes() {
        //TODO fix me
        return EmptyArray.STRINGS;
    }

    public boolean isConstructor() {
        return name.equals(CONSTRUCTOR);
    }

    public boolean isClassInitializer() {
        return signature.equals(SIG_CLINIT);
    }

    public boolean isUserMethod() {
        //return !isClassInitializer() && !isConstructor();
        return !signature.equals(SIG_CLINIT) && !name.equals(CONSTRUCTOR);
    }

    public String getClassName() {
        return className;
    }

    /**
     * method is identified by its name and parameters and no return type
     *
     * @return unique identifier if a method
     */
    public String getAbsoluteSignature() {
        return absoluteSignature;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack == 0 ? 1 : maxStack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModifiers(int modifiers) {
        this.modifiers = modifiers;
    }

    public void setParameters(KParameterDef[] parameters) {
        this.parameters = parameters;
    }

    public void setVariables(KVariableDef[] variables) {
        this.variables = variables;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KMethodDef other = (KMethodDef) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        if (!Arrays.deepEquals(this.parameters, other.parameters)) {
            return false;
        }
        if (!Arrays.deepEquals(this.tryCatchBlocs, other.tryCatchBlocs)) {
            return false;
        }
        if (!Arrays.deepEquals(this.variables, other.variables)) {
            return false;
        }
        if (!Arrays.deepEquals(this.code, other.code)) {
            return false;
        }
        if (this.modifiers != other.modifiers) {
            return false;
        }
        if (this.maxLocals != other.maxLocals) {
            return false;
        }
        if (this.maxStack != other.maxStack) {
            return false;
        }
        if ((this.className == null) ? (other.className != null) : !this.className.equals(other.className)) {
            return false;
        }
        if ((this.signature == null) ? (other.signature != null) : !this.signature.equals(other.signature)) {
            return false;
        }
        if ((this.absoluteSignature == null) ? (other.absoluteSignature != null) : !this.absoluteSignature.equals(other.absoluteSignature)) {
            return false;
        }
        if (this.procedure != other.procedure) {
            return false;
        }
        if (this.hashCache != other.hashCache) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 59 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 59 * hash + Arrays.deepHashCode(this.parameters);
        hash = 59 * hash + Arrays.deepHashCode(this.tryCatchBlocs);
        hash = 59 * hash + Arrays.deepHashCode(this.variables);
        hash = 59 * hash + Arrays.deepHashCode(this.code);
        hash = 59 * hash + this.modifiers;
        hash = 59 * hash + this.maxLocals;
        hash = 59 * hash + this.maxStack;
        hash = 59 * hash + (this.className != null ? this.className.hashCode() : 0);
        hash = 59 * hash + (this.signature != null ? this.signature.hashCode() : 0);
        hash = 59 * hash + (this.absoluteSignature != null ? this.absoluteSignature.hashCode() : 0);
        hash = 59 * hash + (this.procedure ? 1 : 0);
        hash = 59 * hash + this.hashCache;
        return hash;
    }

    public void setTryCatchBlocs(KTryCatchDef[] tryCatchBlocs) {
        this.tryCatchBlocs = tryCatchBlocs;
    }

//    public void setMaxStack(int maxStack) {
//        this.maxStack = maxStack;
//    }
}
