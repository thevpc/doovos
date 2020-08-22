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
package org.doovos.kernel.vanilla.jvm.interpreter.asmjitinterpreter;

/**
 * Created by IntelliJ IDEA.
 * User: maiga
 * Date: May 13, 2010
 * Time: 1:44:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingleClassByteArrayClassLoader extends ClassLoader {

    private String name;
    private byte[] bytecde;
    private Class loadedClass;

    public SingleClassByteArrayClassLoader(String name, byte[] bytecde) {
        this.name = name;
        this.bytecde = bytecde;
    }

    public SingleClassByteArrayClassLoader(ClassLoader parent, String name, byte[] bytecde) {
        super(parent);
        this.name = name;
        this.bytecde = bytecde;
    }

    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        if (this.name.equals(name)) {
            if (loadedClass == null) {
                loadedClass = defineClass(name, bytecde, 0, bytecde.length);
            }
            return loadedClass;
        } else {
            return super.findClass(name);
        }
    }
}
