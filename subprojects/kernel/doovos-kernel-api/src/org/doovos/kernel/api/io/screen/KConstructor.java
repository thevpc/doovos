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
package org.doovos.kernel.api.io.screen;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/**
 * @author vpc (taha.bensalah@gmail.com)
 * @lastmodified 01-dec.-2005
 * Time: 15:33:02
 */
public class KConstructor<T> implements Serializable {
    private Class<? extends T> type;
    private LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

    public KConstructor(Class<? extends T> type) {
        this.type = type;
    }

    public KConstructor<T> set(String param, Object value) {
        params.put(param, value);
        return this;
    }

    public boolean contains(String param) {
        return params.containsKey(param);
    }

    public Object get(String param, boolean required) {
        if (params.containsKey(param)) {
            return params.get(param);
        } else {
            if (required) {
                throw new NoSuchElementException(param);
            } else {
                return null;
            }
        }
    }

    public Object get(String param) {
        if (params.containsKey(param)) {
            return params.get(param);
        } else {
            throw new NoSuchElementException(param);
        }
    }

    public Class<? extends T> getType() {
        return type;
    }

    public T newInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return type.getConstructor(new Class[]{KConstructor.class}).newInstance(new Object[]{this});
    }

    public void setType(Class<? extends T> type) {
        this.type = type;
    }
}
