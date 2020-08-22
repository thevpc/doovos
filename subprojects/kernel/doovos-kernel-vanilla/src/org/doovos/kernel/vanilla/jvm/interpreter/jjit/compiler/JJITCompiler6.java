/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.compiler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.security.SecureClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author vpc
 */
public class JJITCompiler6 implements JJITCompiler {

    /**
     * Instance of JavaClassObject that will store the
     * compiled bytecode of our class
     */
    private HashMap<String, JavaClassObject> bytes=new HashMap<String, JavaClassObject>();
    private ClassLoader secureClassLoader = new SecureClassLoader() {

        @Override
        protected Class<?> findClass(String name)
                throws ClassNotFoundException {
            JavaClassObject o = bytes.get(name);
            if (o != null) {
                byte[] b = o.getBytes();
                return super.defineClass(name, b, 0, b.length);
            }
            throw new ClassNotFoundException(name);
        }
    };
    
    

    public JJITCompiler6() throws IOException {
    }

    public ClassLoader getClassLoader() {
        return secureClassLoader;
    }
    
    
    

    public Class compile(String classPckg, String className, JJITWriter jsrc) throws IOException {
        final String fullClassName = classPckg + "." + className;
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);

        jsrc.write(out);
        out.close();


        JavaFileObject file = new JavaSourceFromString(fullClassName, writer.toString());

        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(file);
        CompilationTask task = compiler.getTask(null, new ClassFileManager(compiler.getStandardFileManager(null, null, null)), diagnostics, null, null, compilationUnits);

        boolean success = task.call();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));

        }
        if (success) {
            try {
                return Class.forName(fullClassName, true, secureClassLoader);
            } catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    class JavaSourceFromString extends SimpleJavaFileObject {

        final String code;

        JavaSourceFromString(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return code;
        }
    }

    public Class loadCached(String classPckg, String className) throws IOException {
        return null;
    }

    public class ClassFileManager extends ForwardingJavaFileManager {

        /**
         * Will initialize the manager with the specified
         * standard java file manager
         *
         * @param standardManger
         */
        public ClassFileManager(StandardJavaFileManager standardManager) {
            super(standardManager);
        }

        /**
         * Will be used by us to get the class loader for our
         * compiled class. It creates an anonymous class
         * extending the SecureClassLoader which uses the
         * byte code created by the compiler and stored in
         * the JavaClassObject, and returns the Class for it
         */
        @Override
        public ClassLoader getClassLoader(Location location) {
            return secureClassLoader;
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
            JavaClassObject jclassObject = new JavaClassObject(className, kind);
            bytes.put(className, jclassObject);
            return jclassObject;
        }

        
    }

    public class JavaClassObject extends SimpleJavaFileObject {

        /**
         * Byte code created by the compiler will be stored in this
         * ByteArrayOutputStream so that we can later get the
         * byte array out of it
         * and put it in the memory as an instance of our class.
         */
        protected final ByteArrayOutputStream bos =
                new ByteArrayOutputStream();

        /**
         * Registers the compiled class object under URI
         * containing the class full name
         *
         * @param name
         *            Full name of the compiled class
         * @param kind
         *            Kind of the data. It will be CLASS in our case
         */
        public JavaClassObject(String name, Kind kind) {
            super(URI.create("string:///" + name.replace('.', '/')
                    + kind.extension), kind);
        }

        /**
         * Will be used by our file manager to get the byte code that
         * can be put into memory to instantiate our class
         *
         * @return compiled byte code
         */
        public byte[] getBytes() {
            return bos.toByteArray();
        }

        /**
         * Will provide the compiler with an output stream that leads
         * to our byte array. This way the compiler will write everything
         * into the byte array that we will instantiate later
         */
        @Override
        public OutputStream openOutputStream() throws IOException {
            return bos;
        }
    }
}
