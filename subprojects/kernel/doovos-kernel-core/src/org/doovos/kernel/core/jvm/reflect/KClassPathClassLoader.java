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
package org.doovos.kernel.core.jvm.reflect;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.filesystem.KFileSystemManager;
import org.doovos.kernel.api.filesystem.KFolder;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.jvm.bytecode.JavaByteCodeLoader;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KInvalidByteCodeImageException;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
import org.doovos.kernel.core.jvm.bytecode.ASMJavaByteCodeLoader;

import java.io.IOException;

public class KClassPathClassLoader implements KClassLoader {
    private static final KFileSystemManager FILE_SYSTEM_MANAGER = Doovos.getSystem().getFileSystemManager();
    private String[] bootstrapClassPaths;
    private KClassLoader[] bootstrapClassLoaders;
    private static JavaByteCodeLoader bytecodeLoader = new ASMJavaByteCodeLoader();

    public KClassPathClassLoader(String[] bootstrapClassPaths) {
        this.bootstrapClassPaths = bootstrapClassPaths;
        bootstrapClassLoaders = new KClassLoader[bootstrapClassPaths.length];
    }

    public KClassDef loadClass(String name) throws KInvalidByteCodeImageException, KClassNotFoundException {
        for (int i = 0; i < bootstrapClassLoaders.length; i++) {
            if (bootstrapClassLoaders[i] == null) {
                try {

                    KResource r = FILE_SYSTEM_MANAGER.find(bootstrapClassPaths[i]);
                    if (r != null) {
                        if (r instanceof KFile) {
                            bootstrapClassLoaders[i] = new KClassLoaderZipJar(bootstrapClassPaths[i], (KFile) r, bytecodeLoader);
                        } else if (r instanceof KFolder) {
                            bootstrapClassLoaders[i] = new KClassLoaderFolder(bootstrapClassPaths[i], (KFolder) r, bytecodeLoader);
                        }
                    }
                } catch (IOException ee) {
                    //ignore
                }
            }
            if (bootstrapClassLoaders[i] != null) {
                try {
                    return bootstrapClassLoaders[i].loadClass(name);
                } catch (KClassNotFoundException ee) {
                    //ignore
                } catch (KInvalidByteCodeImageException ee) {
                    //ignore
                }
            }
        }
        throw new KClassNotFoundException(name);
    }
}
