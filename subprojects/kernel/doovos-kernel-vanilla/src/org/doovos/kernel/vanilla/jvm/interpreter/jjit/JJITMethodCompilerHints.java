/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import java.io.Serializable;
import java.util.HashSet;

/**
 *
 * @author vpc
 */
public final class JJITMethodCompilerHints implements Serializable {

    private ProcessorType hint = ProcessorType.INTERPRETER;
    private HashSet<String> yetToLoadClasses = new HashSet<String>(3);

    public JJITMethodCompilerHints() {
    }

    public ProcessorType getHint() {
        return hint;
    }

    public void setHint(ProcessorType hint) {
        this.hint = hint;
    }

    public HashSet<String> getYetToInitializeClasses() {
        return yetToLoadClasses;
    }

    public static enum ProcessorType {

        INTERPRETER,
        COMPILER
    }
}
