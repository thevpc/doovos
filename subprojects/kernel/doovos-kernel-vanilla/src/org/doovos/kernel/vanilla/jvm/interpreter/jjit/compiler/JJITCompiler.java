/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.compiler;

import java.io.IOException;

/**
 * @author vpc
 */
public interface JJITCompiler {

    public ClassLoader getClassLoader() ;
    
    public Class compile(String classPckg, String className, JJITWriter jsrc) throws IOException;

    public Class loadCached(String classPckg, String className) throws IOException;
}
