package org.doovos.kernel.core.jvm.reflect;

import org.doovos.kernel.api.jvm.bytecode.KClassDef;
import org.doovos.kernel.api.jvm.bytecode.KClassDefRepository;
import org.doovos.kernel.api.jvm.bytecode.KInvalidByteCodeImageException;
import org.doovos.kernel.api.jvm.reflect.KClassLoader;
import org.doovos.kernel.api.jvm.reflect.KClassNotFoundException;

public class KBootstrapClassLoader implements KClassLoader {
    private String[] paths;
    private KClassDefRepository classDefRepository;

    public KBootstrapClassLoader(String[] paths, KClassDefRepository classDefRepository) {
        this.paths = paths;
        this.classDefRepository = classDefRepository;
        this.classDefRepository.register(paths);
    }

    public KClassDef loadClass(String name) throws KInvalidByteCodeImageException, KClassNotFoundException {
        return classDefRepository.getClass(paths, name);
    }
}
