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
 * Doovos JAVA JNI is the native implementation (in Doovos sens so in java)
 * of the hotspot java libraries (provided by sun).
 * JNI code is executed on host JVM (in doovos kernel mode)
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
package jni.java.io;

import org.doovos.kernel.api.filesystem.KFileSystemManager;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.THIS;
import org.doovos.kernel.api.jvm.jni.JNIPARAM;
import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNICALL;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.adapter.SimpleClassAdapter;
import org.doovos.kernel.api.process.KStreamDescriptor;
import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.memory.KReference;
import org.doovos.kernel.api.io.stream.KOutputStream;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 23 avr. 2009
 * Time: 03:11:46
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("java.io.FileOutputStream")
public class FileOutputStreamJNI {

    @JNICALL
    public static void initIDs(JNIEnv env) {
        //what to do?
    }
    
    private final Doovos system = Doovos.getSystem();
    private final KMemoryManager memoryManager=system.getMemoryManager();
    private final KFileSystemManager fileSystemManager = system.getFileSystemManager();

    public FileOutputStreamJNI() {
    }

    @JNICALL
    public void close0(JNIEnv env, @THIS KReference ref) throws RemoteException {
        KOutputStream s = getOutputStream(env, ref);
        s.free();
    }


    private KOutputStream getOutputStream(JNIEnv env, KReference ref) throws RemoteException {
        SimpleClassAdapter _this = new SimpleClassAdapter(env, ref);
        int fd = _this.getObject("fd").getInt("fd");
        KStreamDescriptor kStreamDescriptor = env.getProcess().getStreamDescriptor(fd);
        return (KOutputStream) fileSystemManager.getResource(kStreamDescriptor.getPath());
//
//        SimpleClassAdapter thisInstance = new SimpleClassAdapter(env.getProcess(), ref);
//        KReference fdRef= thisInstance.getReference("fd");
//        SimpleClassAdapter fdInstance = new SimpleClassAdapter(env.getProcess(), fdRef);
//        int fd=fdInstance.getInt("fd");
//        throw new UnsupportedOperationException("how to retrive path from fd "+fd);
        //return null;
    }

    /**
     * Opens a file, with the specified name, for writing.
     *
     * @param name name of file to be opened
     */
    @JNICALL
    public void open(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.String") KReference name) throws IOException {
        KStreamDescriptor streamDescriptor = env.getProcess().openOutputStream(memoryManager.getString(name), false);
        SimpleClassAdapter _this = new SimpleClassAdapter(env, ref);
        _this.getObject("fd").setInt("fd", streamDescriptor.getDescriptor());
    }

    /**
     * Opens a file, with the specified name, for appending.
     *
     * @param name name of file to be opened
     */
    @JNICALL
    public void openAppend(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.String") KReference name) throws IOException {
        KStreamDescriptor streamDescriptor = env.getProcess().openOutputStream(memoryManager.getString(name), false);
        SimpleClassAdapter _this = new SimpleClassAdapter(env, ref);
        _this.getObject("fd").setInt("fd", streamDescriptor.getDescriptor());
    }

    /**
     * Writes the specified byte to this file output stream. Implements
     * the <code>write</code> method of <code>OutputStream</code>.
     *
     * @param b the byte to be written.
     * @throws IOException if an I/O error occurs.
     */
    @JNICALL
    public void write(JNIEnv env, @THIS KReference ref, int b) throws IOException {
        getOutputStream(env, ref).write(b);
    }

    /**
     * Writes a sub array as a sequence of bytes.
     *
     * @param b   the data to be written
     * @param off the start offset in the data
     * @param len the number of bytes that are written
     * @throws IOException If an I/O error has occurred.
     */
    @JNICALL
    public void writeBytes(JNIEnv env, @THIS KReference ref, @JNIPARAM("byte[]") KReference b, int off, int len) throws IOException {
        byte[] bytes = memoryManager.getByteArray(b);
        getOutputStream(env, ref).write(bytes, off, len);
    }


}