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
// * Doovos API is a standard library running on Doovos guest JVM (distributed
// * jvm) to access Doovos mechanisms that are not handled by the Java Platform
// * standard libraries.
// * Il gives access to system processes, system threads, etc...
//
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
//package org.doovos.api;
//
///**
// * Environment variable structure
// */
//public class DProcessEnv {
//    String key;
//    String value;
//    boolean exported;
//
//    public DProcessEnv(String key, String value, boolean exported) {
//        this.key = key;
//        this.value = value;
//        this.exported = exported;
//    }
//
//    /**
//     * env key
//     * @return key
//     */
//    public String getKey() {
//        return key;
//    }
//
//    /**
//     * env value
//     * @return env value
//     */
//    public String getValue() {
//        return value;
//    }
//
//    /**
//     * true is env is exported
//     * @return true is env is exported
//     */
//    public boolean isExported() {
//        return exported;
//    }
//
//    @Override
//    public String toString() {
//        return "DProcessEnv{" +
//                "key='" + key + '\'' +
//                ", value='" + value + '\'' +
//                ", exported=" + exported +
//                '}';
//    }
//}
