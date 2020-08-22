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
package org.doovos.kernel.core.jvm.bytecode;

import java.io.File;
import java.io.FileInputStream;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KInvalidByteCodeImageException;
import org.objectweb.asm.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.doovos.kernel.api.jvm.bytecode.JavaByteCodeLoader;

public class ASMJavaByteCodeLoader implements JavaByteCodeLoader {

    public KClassDef loadClass(File file) throws IOException {
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
            return loadClass(stream);
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new KInvalidByteCodeImageException(e);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    public KClassDef loadClass(KFile file) throws IOException {
        KInputStream stream = null;
        try {
            try {
                stream = file.openInputStream();
                return loadClass(stream.getInputStream());
            } finally {
                if (stream != null) {
                    stream.free();
                }
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new KInvalidByteCodeImageException(e);
        } finally {
            if (stream != null) {
                stream.free();
            }
        }
    }

    public KClassDef loadClass(InputStream inputStream) throws IOException {
        JavaClassVisitor v = new JavaClassVisitor();
        ClassReader r;
        r = new ClassReader(inputStream);
        r.accept(v, 0);
        return v.clazz;
    }

    public KClassDef loadClass(String className, File classPathItem) throws IOException {
        if (classPathItem.isDirectory()) {
            return loadClassFromFolder(className, classPathItem);
        } else if (classPathItem.isFile()) {
            String lowerName = classPathItem.getName().toLowerCase();
            if (lowerName.endsWith(".class")) {
                return loadClass(classPathItem);
            } else if (lowerName.endsWith(".zip") || lowerName.endsWith(".jar")) {
                return loadClassFromJar(className, classPathItem);
            }
        }
        throw new IllegalArgumentException("Unsupported ClassPathItem " + classPathItem);
    }

    public KClassDef loadClassFromJar(String className, File jarFile) throws IOException {
        ZipFile zip = new ZipFile(jarFile);
        String namePath = className.replace('.', '/');
        String filePath = namePath + ".class";
        ZipEntry zipEntry = zip.getEntry(filePath);
        if (zipEntry != null) {
            return loadClass(zip.getInputStream(zipEntry));
        }
        throw new IllegalArgumentException("Class not found " + className + " from jar file " + jarFile);
    }

    public KClassDef loadClassFromFolder(String className, File folder) throws IOException {
        return loadClass(new File(folder, className.replace('.', '/')+".class"));
    }
}
