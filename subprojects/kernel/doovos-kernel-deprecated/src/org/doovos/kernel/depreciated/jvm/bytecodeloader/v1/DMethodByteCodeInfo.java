///**
// * ====================================================================
// *             Doovos (Distributed Object Oriented Operating System)
// *
// * Doovos is a new Open Source Distributed Object Oriented Operating System
// * Design and implementation based on the Java Platform.
// * Actually, it is a try for designing a distributed operation system in
// * top of existing centralized/network OS.
// * Designed OS will follow the object oriented architecture for redefining
// * all OS resources (memory,process,file system,device,...etc.) in a highly
// * distributed context.
// * Doovos is also a distributed Java virtual machine that implements JVM
// * specification on top the distributed resources context.
// *
// * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
// * Doovos Kernel code is executed on host JVM
// *
// * Copyright (C) 2008-2010 Taha BEN SALAH
// *
// * This program is free software; you can redistribute it and/or modify
// * it under the terms of the GNU General Public License as published by
// * the Free Software Foundation; either version 2 of the License, or
// * (at your option) any later version.
// *
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc.,
// * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// * ====================================================================
// */
//package org.doovos.kernel.depreciated.jvm.bytecodeloader.v1;
//
//import org.doovos.kernel.api.jvm.reflect.KInstruction;
//import org.doovos.kernel.api.jvm.bytecode.KMethodDef;
//import org.doovos.kernel.api.jvm.bytecode.KParameterDef;
//import org.doovos.kernel.api.jvm.bytecode.KTryCatchDef;
//import org.doovos.kernel.api.jvm.bytecode.KVariableDef;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class DMethodByteCodeInfo {
//    private String name;
//    private String type;
//    private List<DTryCatchByteCodeInfo> tryCatchBlocs = new ArrayList<DTryCatchByteCodeInfo>();
//    private List<DParameterByteCodeInfo> parameters = new ArrayList<DParameterByteCodeInfo>();
//    private List<DVariableByteCodeInfo> variables = new ArrayList<DVariableByteCodeInfo>();
//    private List<KInstruction> code = new ArrayList<KInstruction>();
//    private int modifiers;
//    private int maxLocals;
//    private int maxstack;
//
//    public DMethodByteCodeInfo() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public List<DParameterByteCodeInfo> getParameters() {
//        return parameters;
//    }
//
//    public void setParameters(List<DParameterByteCodeInfo> parameters) {
//        this.parameters = parameters;
//    }
//
//    public List<DTryCatchByteCodeInfo> getTryCatchBlocs() {
//        return tryCatchBlocs;
//    }
//
//    public void setTryCatchBlocs(List<DTryCatchByteCodeInfo> tryCatchBlocs) {
//        this.tryCatchBlocs = tryCatchBlocs;
//    }
//
//    public List<DVariableByteCodeInfo> getVariables() {
//        return variables;
//    }
//
//    public void setVariables(List<DVariableByteCodeInfo> variables) {
//        this.variables = variables;
//    }
//
//    public List<KInstruction> getCode() {
//        return code;
//    }
//
//    public void setCode(List<KInstruction> code) {
//        this.code = code;
//    }
//
//    public int getModifiers() {
//        return modifiers;
//    }
//
//    public void setModifiers(int modifiers) {
//        this.modifiers = modifiers;
//    }
//
//    public KMethodDef toMethodDef(String className) {
//        KParameterDef[] a = new KParameterDef[parameters.size()];
//        Collections.sort(parameters);
//        Collections.sort(variables);
//        for (int i = 0; i < parameters.size(); i++) {
//            a[i] = parameters.get(i).toParameterDef();
//        }
//        KVariableDef[] v = new KVariableDef[variables.size()];
//        for (int i = 0; i < variables.size(); i++) {
//            v[i] = variables.get(i).toVariableDef();
//        }
//        KTryCatchDef[] tc = new KTryCatchDef[tryCatchBlocs.size()];
//        for (int i = 0; i < tryCatchBlocs.size(); i++) {
//            tc[i] = tryCatchBlocs.get(i).toTryCatchDef();
//        }
//        return new KMethodDef(
//                name,
//                className,
//                type,
//                modifiers,
//                a,
//                v,
//                code.toArray(new KInstruction[code.size()]),
//                tc,
//                maxLocals,
//                maxstack
//        );
//    }
//
//    public int getMaxLocals() {
//        return maxLocals;
//    }
//
//    public void setMaxLocals(int maxLocals) {
//        this.maxLocals = maxLocals;
//    }
//
//    public int getMaxstack() {
//        return maxstack;
//    }
//
//    public void setMaxstack(int maxstack) {
//        this.maxstack = maxstack;
//    }
//}