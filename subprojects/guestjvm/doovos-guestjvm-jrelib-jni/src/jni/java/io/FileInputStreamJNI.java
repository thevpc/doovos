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
import org.doovos.kernel.api.filesystem.UnknownResourceException;
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
import org.doovos.kernel.api.io.stream.KInputStream;

import java.io.IOException;
import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 23 avr. 2009
 * Time: 03:11:46
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS("java.io.FileInputStream")
public class FileInputStreamJNI {

    @JNICALL
    public static void initIDs(JNIEnv env) {
        //TODO DO FIXE ME
    }
    private final Doovos system = Doovos.getSystem();
    private final KFileSystemManager fileSystemManager = system.getFileSystemManager();
    private final KMemoryManager memoryManager=system.getMemoryManager();

    public FileInputStreamJNI() {
    }

    @JNICALL
    public void close0(JNIEnv env, @THIS KReference ref) throws RemoteException {
        try {
            KInputStream s = getInputStream(env, ref);
            s.free();
        } catch (UnknownResourceException e) {
            //aleady closed
        }
    }


    /**
     * Skips over and discards <code>n</code> bytes of data from the
     * input stream.
     * <p/>
     * <p>The <code>skip</code> method may, for a variety of
     * reasons, end up skipping over some smaller number of bytes,
     * possibly <code>0</code>. If <code>n</code> is negative, an
     * <code>IOException</code> is thrown, even though the <code>skip</code>
     * method of the {@link java.io.InputStream} superclass does nothing in this case.
     * The actual number of bytes skipped is returned.
     * <p/>
     * <p>This method may skip more bytes than are remaining in the backing
     * file. This produces no exception and the number of bytes skipped
     * may include some number of bytes that were beyond the EOF of the
     * backing file. Attempting to read from the stream after skipping past
     * the end will result in -1 indicating the end of the file.
     *
     * @param n the number of bytes to be skipped.
     * @return the actual number of bytes skipped.
     * @throws IOException if n is negative, or if an I/O error occurs.
     */
    @JNICALL
    public long skip(JNIEnv env, @THIS KReference ref, long n) throws IOException {
        return getInputStream(env, ref).skip(n);
    }

    /**
     * Returns the number of bytes that can be read from this file input
     * stream without blocking.
     *
     * @return the number of bytes that can be read from this file input
     *         stream without blocking.
     * @throws IOException if an I/O error occurs.
     */
    @JNICALL
    public int available(JNIEnv env, @THIS KReference ref) throws IOException {
        return getInputStream(env, ref).available();
    }


    /**
     * Opens the specified file for reading.
     *
     * @param name the name of the file
     */
    @JNICALL
    public void open(JNIEnv env, @THIS KReference ref, @JNIPARAM("java.lang.String") KReference name) throws IOException, RemoteException {
        KStreamDescriptor streamDescriptor = env.getProcess().openInputStream(memoryManager.getString(name));
        SimpleClassAdapter _this = new SimpleClassAdapter(env, ref);
        _this.getObject("fd").setInt("fd", streamDescriptor.getDescriptor());
    }

    /**
     * Reads a byte of data from this input stream. This method blocks
     * if no input is yet available.
     *
     * @return the next byte of data, or <code>-1</code> if the end of the
     *         file is reached.
     * @throws IOException if an I/O error occurs.
     */
    @JNICALL
    public int read(JNIEnv env, @THIS KReference ref) throws IOException {
        return getInputStream(env, ref).read();
    }


    /**
     * Reads a subarray as a sequence of bytes.
     *
     * @param b   the data to be written
     * @param off the start offset in the data
     * @param len the number of bytes that are written
     * @throws IOException If an I/O error has occurred.
     */
    @JNICALL
    public int readBytes(JNIEnv env, @THIS KReference ref, @JNIPARAM("byte[]") KReference b, int off, int len) throws IOException {
//        byte[] bytes = getInputStream(env, ref).read(len);
//        if (bytes.length == 0) {
//            return -1;
//        }
//        Doovos.getSystem().getMemoryManager().setByteArray(b, off, bytes, 0, bytes.length);
//        return bytes.length;
        return getInputStream(env, ref).read(b.memorySegment,b.pointer, off,len);
    }

    private KInputStream getInputStream(JNIEnv env, KReference ref) throws RemoteException {
        SimpleClassAdapter _this = new SimpleClassAdapter(env, ref);
        int fd = _this.getObject("fd").getInt("fd");
        KStreamDescriptor kStreamDescriptor = env.getProcess().getStreamDescriptor(fd);
        return (KInputStream) fileSystemManager.getResource(kStreamDescriptor.getPath());
    }
}
