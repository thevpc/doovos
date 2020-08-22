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
package org.doovos.kernel.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

public class KIOUtils {

    private KIOUtils() {
    }

    //    public static String getGuestPath(String hostPath){
//        char s=File.separatorChar;
//        switch (s){
    //            case '/' : return hostPath;
//        }
//        return hostPath.replace(s,'/');
//    }
    public static String getChecksum(File file) throws IOException {
        CheckedInputStream cis = null;
        try {
            //long fileSize = 0;
            // Computer CRC32 checksum
            cis = new CheckedInputStream(new FileInputStream(file), new CRC32());
            byte[] buf = new byte[1024 * 10];
            while (cis.read(buf) >= 0) {
                //do nothing
            }
            long checksum = cis.getChecksum().getValue();
            return Long.toString(checksum, 32);
        } finally {
            if (cis != null) {
                cis.close();
            }
        }
    }

    public static int DEFAULT_BUFFER_SIZE = 1024;

    public static void copy(InputStream in, File out) throws IOException {
        copy(in, out, DEFAULT_BUFFER_SIZE);
    }

    public static void copy(InputStream in, File out, int bufferSize) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(out);
            copy(in, fos, bufferSize);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void copy(File in, File out, int bufferSize) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(in);
            fos = new FileOutputStream(out);
            copy(fis, fos, bufferSize);
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void copy(InputStream in, OutputStream out, int bufferSize) throws IOException {
        byte[] buffer = new byte[bufferSize];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
