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
package org.doovos.kernel.api.filesystem;

import java.util.List;

public interface KResourceMetaData {
    public Object getProperty(String name);

    public void setProperty(String name, Object value);

    public List<String> getPropertyNames();

    /**
     * retrieve the method that matches the given name and the given parameters. Null is returned if not found
     * 2 methods of the same name (overloading) should never have the same param names or the same param types
     *
     * @param method             method name
     * @param paramNamesAndTypes a list of "name:type" strings. one of name of type could be null but never both
     * @return
     */
    public KResourceMethod getMethod(String method, String... paramNamesAndTypes);

    /**
     * @return all methods
     */
    public List<KResourceMethod> getMethods();

    /**
     * retrieve the BEST method that matches the given name and the given parameters. Null is returned if not found
     * paramNames may be null or empty.
     * The best method is defined as follow:
     * It must match exactly the method name
     * If there are no other methods that match the name, this one is returned.
     * From all over methods matching the name, the one that matches the more param names is returned (remember that param names may be not defined)
     * When ambiguity reached, the one that matches the more param types is returned (remember that param types may be not defined)
     * When ambiguity reached, the one that matches the more specific types (according to inheritance is returned)
     * When ambiguity reached, the first method (according to getMethods()) is returned
     *
     * @param method             method name (mandatory)
     * @param paramNamesAndTypes a list of "name:type" strings. one of name of type could be null but never both
     * @return Method that matches the given criteria of null if not found
     */
    public KResourceMethod findMethod(String method, String... paramNamesAndTypes);
}
