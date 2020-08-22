/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.compiler;

import org.doovos.kernel.api.util.EmptyArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * @author vpc
 */
public class JJITCompiler5 implements JJITCompiler {
//    private static final String[] EMPTY_ARRAY_STRING = new String[0];

    private URLClassLoader javacClassLoader;
    private Method compileMethod;
    private String hostClassPath;
    private File srcFolder;
    private File binFolder;

    public JJITCompiler5(File srcFolder,File binFolder) throws IOException {
        try {
            this.binFolder = binFolder;
            this.srcFolder = srcFolder;
            binFolder.mkdirs();
            srcFolder.mkdirs();
            String baseHostClassPath = System.getProperty("java.class.path");
            String pathSeparator = System.getProperty("path.separator");
            String[] baseHostClassArr = baseHostClassPath.split(pathSeparator);
            String[] hostClassPathArr = null;
            if (baseHostClassArr.length == 1 && baseHostClassArr[0].toLowerCase().endsWith(".jar")) {
                //java -jar doovos.jar
                try {
                    hostClassPathArr = getJarClasspath(new File(baseHostClassArr[0]));
                    StringBuilder s = new StringBuilder(hostClassPathArr[0]);
                    for (int i = 1; i < hostClassPathArr.length; i++) {
                        s.append(pathSeparator);
                        s.append(hostClassPathArr[i]);
                    }
                    hostClassPath = s.toString();
                } catch (Exception e) {
                    //ignore
                }
            }
            if (hostClassPath == null) {
                hostClassPath = System.getProperty("java.class.path");
                hostClassPathArr = hostClassPath.split(pathSeparator);
            }
            URL[] hostClassPathURLArr = new URL[hostClassPathArr.length + 1];
            hostClassPathURLArr[0] = binFolder.toURI().toURL();
            for (int i = 0; i < hostClassPathArr.length; i++) {
                hostClassPathURLArr[i + 1] = new File(hostClassPathArr[i]).toURI().toURL();
            }
            //        String doovos_api_jar = "system/bin/doovos-api.jar";
            javacClassLoader = new URLClassLoader(hostClassPathURLArr, getClass().getClassLoader());
            Class<?> javacMainClass = Class.forName("com.sun.tools.javac.Main");
            compileMethod = javacMainClass.getMethod("compile", String[].class);
        } catch (NoSuchMethodException ex) {
            throw new IOException(ex);
        } catch (SecurityException ex) {
            throw new IOException(ex);
        } catch (ClassNotFoundException ex) {
            throw new IOException(ex);
        }
    }

    public final String[] getJarClasspath(File file) throws IOException {
        JarFile jf = new JarFile(file);
        Manifest m = jf.getManifest();
        String classPath = m.getMainAttributes().getValue("Class-Path");
        String[] classPathArr = classPath == null ? EmptyArray.STRINGS : classPath.split("\\ ");
        String[] classPathArr1 = new String[classPathArr.length + 1];
        classPathArr1[0] = file.getPath();
        String parent = file.getParent();
        for (int i = 0; i < classPathArr.length; i++) {
            classPathArr1[i + 1] = new File(parent, classPathArr[i]).getPath();
        }
        return classPathArr1;
    }

    public ClassLoader getClassLoader() {
        return javacClassLoader;
    }

    public Class compile(String classPckg, String className, JJITWriter jsrc) throws IOException {
        final String fullClassName = classPckg + "." + className;
        binFolder.mkdirs();
        srcFolder.mkdirs();

        File classPckgFolder = new File(srcFolder, classPckg.replace('.', '/'));
        classPckgFolder.mkdirs();
        File sourceFile = new File(classPckgFolder, className + ".java");
        FileOutputStream fos = new FileOutputStream(sourceFile);
        PrintStream ps = new PrintStream(fos);
        //PrintStream ps = new PrintStream(sourceFile);
        jsrc.write(ps);
        ps.close();

        String compilationOption = "-g";
//        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
//            log(entry.getKey()+" = "+entry.getValue());
//        }
        //log(">>(/**/"+System.getProperty("java.version")+") javac "+compilationOption+" -classpath " + hostClassPath + " -d " + binFolder.getCanonicalPath() + " " + sourceFile.getCanonicalPath());
        try {
            Integer ret = (Integer) compileMethod.invoke(null,
                    new Object[]{
                        new String[]{
                            //"-O",
                            compilationOption,
                            "-classpath", hostClassPath,
                            "-d", binFolder.getCanonicalPath(),
                            sourceFile.getCanonicalPath()
                        }
                    });
            if (ret != 0) {
                throw new RuntimeException(
                        "Compilation error " + ret + "\n"
                        + "java.version=" + System.getProperty("java.version") + "\n"
                        + "java.class.path=" + System.getProperty("java.class.path") + "\n"
                        + "path.separator=" + System.getProperty("path.separator") + "\n"
                        + "javac " + compilationOption + " -classpath " + hostClassPath + " -d " + binFolder.getCanonicalPath() + " " + sourceFile.getCanonicalPath() + "\n");
            }
        } catch (IllegalAccessException ex) {
            //impossible
        } catch (IllegalArgumentException ex) {
            //impossible
        } catch (InvocationTargetException ex) {
            final Throwable cause = ex.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause;
            }
            throw new RuntimeException(cause);
        }
        Class jitInstrClass;
        try {
            jitInstrClass = javacClassLoader.loadClass(fullClassName);
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
//        log(">>>> compiled successefully : " + fullClassName);
        return jitInstrClass;
    }

    public File getPackageFolder(String name) {
        return new File(srcFolder, name.replace('.', '/'));
    }

    public File getBinFolder() {
        return binFolder;
    }

    public File getSrcFolder() {
        return srcFolder;
    }

    public Class loadCached(String classPckg, String className) throws IOException {
        try {
            String name = new StringBuilder(classPckg).append('.').append(className).toString();
            return getClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {
            //ignore
        }
        return null;
    }
}
