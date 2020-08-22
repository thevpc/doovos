/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.compiler;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *
 * @author vpc
 */
public interface JJITWriter {
    public void write(PrintStream out) ;
    public void write(PrintWriter out) ;
}
