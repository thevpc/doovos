package org.doovos.kernel.core.jvm.reflect;

import org.doovos.kernel.api.filesystem.KFile;
import org.doovos.kernel.api.io.stream.KInputStream;
import org.doovos.kernel.api.jvm.bytecode.JavaByteCodeLoader;
import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KInvalidByteCodeImageException;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;
import org.doovos.kernel.core.util.FileCache;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class KClassLoaderZipJar implements KClassLoader {
    private KFile file;
    private String path;
    private JavaByteCodeLoader bytecodeLoader;
    private FileCache cache;
    private ZipFile zip;

    public KClassLoaderZipJar(String path, KFile file, JavaByteCodeLoader bytecodeLoader) throws IOException {
        this.path = path;
        this.file = file;
        this.bytecodeLoader = bytecodeLoader;
        cache = new FileCache(file);
    }

    public KClassDef loadClass(String name) throws KInvalidByteCodeImageException, KClassNotFoundException {
        try {
            ZipFile zip = getZip();
            String namePath = name.replace('.', '/');
            String filePath = namePath + ".class";
            ZipEntry zipEntry = zip.getEntry(filePath);
            if (zipEntry != null) {
                KClassDef cbc = bytecodeLoader.loadClass(zip.getInputStream(zipEntry));
//                if (!cbc.getName().equals(name)) {
//                    throw new IllegalArgumentException("Expected class name " + name + " but found " + cbc.getName());
//                }
                cbc.setClassFileRootPath(path);
                cbc.setClassFilePath(path + "/" + filePath);
                return cbc;
            }
        } catch (RemoteException e) {
            //
        } catch (IOException e) {
            //
        }
        throw new KClassNotFoundException(name);
    }


    public ZipFile getZip() throws IOException {
        if (zip == null) {
            zip = new ZipFile(cache.getLocalFile());
        }
        return zip;
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