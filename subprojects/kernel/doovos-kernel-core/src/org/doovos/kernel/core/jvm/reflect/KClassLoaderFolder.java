package org.doovos.kernel.core.jvm.reflect;

import org.doovos.kernel.api.Doovos;
import org.doovos.kernel.api.filesystem.KFileSystemManager;
import org.doovos.kernel.api.filesystem.KResource;
import org.doovos.kernel.api.jvm.bytecode.JavaByteCodeLoader;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KInvalidByteCodeImageException;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.filesystem.KFolder;
import org.doovos.kernel.api.io.stream.KInputStream;

import java.io.IOException;
import java.rmi.RemoteException;

public class KClassLoaderFolder implements KClassLoader {
    private static final KFileSystemManager FILE_SYSTEM_MANAGER = Doovos.getSystem().getFileSystemManager();
    private KFolder folder;
    private String path;
    private JavaByteCodeLoader bytecodeLoader;

    public KClassLoaderFolder(String path, KFolder folder, JavaByteCodeLoader bytecodeLoader) {
        this.path = path;
        this.folder = folder;
        this.bytecodeLoader = bytecodeLoader;
    }

    public KClassDef loadClass(String name) throws KInvalidByteCodeImageException, KClassNotFoundException {
        String namePath = name.replace('.', '/');
        String filePath = path + "/" + namePath + ".class";
        KResource r = null;
        try {
            r = FILE_SYSTEM_MANAGER.find(filePath);
            if (r != null && r instanceof KFile) {
                KClassDef cbc = loadClass((KFile) r);
                cbc.setClassFileRootPath(path);
                cbc.setClassFilePath(filePath);
                if (cbc.getName().equals(name)) {
                    return cbc;
                }
            }
        } catch (RemoteException e) {
            //
        } catch (IOException e) {
            //
        }
        throw new KClassNotFoundException(name);
    }

    public KClassDef loadClass(KFile file) throws IOException {
        KInputStream stream = null;
        try {
            try {
                stream = file.openInputStream();
                return bytecodeLoader.loadClass(stream.getInputStream());
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
}
