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
package org.doovos.kernel.api.io;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.io.stream.KOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class KProperties {
    private String path;
    private Properties impl = new Properties();

    public KProperties(String path) throws IOException {
        this.path = path;
        load(path);
    }

    public String getPath() {
        return path;
    }

    public String getProperty(String propertyName, String defaultValue) {
        return impl.getProperty(propertyName, defaultValue);
    }

    public String getProperty(String propertyName) {
        return impl.getProperty(propertyName);
    }

    public void setProperty(String propertyName, String value) {
        impl.setProperty(propertyName, value);

    }

    public Set<String> keySet() {
        HashMap<String, String> h = new HashMap<String, String>();
        for (Map.Entry<Object, Object> e : impl.entrySet()) {
            h.put((String) e.getKey(), (String) e.getValue());
        }
        return h.keySet();
    }


    public void load(String path) throws IOException {
        KInputStream ds = null;
        InputStream js = null;
        try {
            ds = Doovos.getSystem().openInputStream(path);
            js = ds.getInputStream();
            impl.load(js);
        } finally {
            try {
                if (js != null) {
                    js.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ds != null) {
                try {
                    ds.free();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void store(String path, String comments) throws IOException {
        KOutputStream ds = null;
        OutputStream js = null;
        try {
            ds = Doovos.getSystem().openOutputStream(Doovos.currentProcess(), path, new KFile.OutFlags().setAppend(true).setCreate(true));
            js = ds.getOutputStream();
            impl.store(js, comments);
        } finally {
            try {
                if (js != null) {
                    js.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (ds != null) {
                try {
                    ds.free();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
