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
package org.doovos.kernel.api.memory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 14 août 2008
 * Time: 20:37:51
 * To change this template use File | Settings | File Templates.
 */
public enum KObjectType {

    t_int(4, "I", "int", true, false),
    t_long(8, "J", "long", true, true),
    t_float(4, "F", "float", true, false),
    t_double(8, "D", "double", true, true),
    t_char(2, "C", "char", true, false),
    t_byte(1, "B", "byte", true, false),
    t_boolean(1, "Z", "boolean", true, false),
    t_void(0, "V", "void", true, false),
//    t_string(16, "G", "string", true, false),
    t_short(2, "S", "short", true, false),
    t_ref(16, null, "Reference", false, false),
    t_obj(0, null, "Object", false, false),
//    t_class(0, null, "Class", false, false)
    ;
    private int byteSize;
    private int intSize;
    private String code;
    private String fullName;
    private boolean primitive;
    private boolean type2;
    public static final KObjectType[] PRIMITIVE_TYPES = {
        t_boolean,
        t_void,
        KObjectType.t_byte,
        KObjectType.t_short,
        KObjectType.t_char,
        KObjectType.t_int,
        KObjectType.t_long,
        KObjectType.t_float,
        KObjectType.t_double
    };

    private KObjectType(int byteSize, String code, String fullName, boolean primitive, boolean type2) {
        this.byteSize = byteSize;
        intSize = byteSize/4;
        if(intSize==0){
            intSize=1;
        }
        this.code = code;
        this.fullName = fullName;
        this.primitive = primitive;
        this.type2 = type2;
    }

    public int getIntSize() {
        return intSize;
    }
    
    public int getByteSize() {
        return byteSize;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return fullName;
    }

    public boolean isPrimitive() {
        return primitive;
    }
    private static Map<String, KObjectType> codeToType;
    private static Map<String, KObjectType> nameToType;

    static {
        codeToType = new HashMap<String, KObjectType>();
        for (KObjectType type : values()) {
            if (type.code != null) {
                codeToType.put(type.code, type);
            }
        }
        nameToType = new HashMap<String, KObjectType>();
        for (KObjectType type : values()) {
            if (type.code != null) {
                nameToType.put(type.fullName, type);
            }
        }
    }

    public static KObjectType resolveByCode(String code) {
        return codeToType.get(code);
    }

    public static KObjectType resolveByName(String name) {
        return nameToType.get(name);
    }

    public boolean isType2() {
        return type2;
    }
    public boolean isType1() {
        return !type2;
    }
}
