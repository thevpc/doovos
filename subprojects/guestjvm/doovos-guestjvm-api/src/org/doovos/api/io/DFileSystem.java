package org.doovos.api.io;

import org.doovos.api.DSystem;

import java.io.File;

/**
 * Doovos FileSystem
 */
public class DFileSystem {
    static {
        DSystem.loadLibrary("org.doovos.api.io.DFileSystemJNI");
    }

    public static final int BA_PROCESS       = 0x10;
    public static final int BA_MEM_SEGMENT   = 0x20;
    public static final int BA_CLASS_REPO    = 0x30;
    public static final int BA_STREAM = 0x40;
    public static final int BA_DEVICE        = 0x50;
    public static final int BA_SITE          = 0x60;

}
