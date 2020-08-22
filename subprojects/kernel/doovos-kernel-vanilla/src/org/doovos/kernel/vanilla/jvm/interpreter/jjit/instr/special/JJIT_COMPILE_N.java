/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;

import java.io.Serializable;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.JJITMethodCompilerHints;

/**
 * @author vpc
 */
public class JJIT_COMPILE_N implements JJITInstruction, Cloneable, Serializable {

    private int counter0;
    private int counter;
    private transient int nextpc;
    private transient JJITInstruction next;

    public JJIT_COMPILE_N(int counter) {
        this.counter = counter;
        this.counter0 = counter;
    }

    public JJITInstruction clone() {
        try {
            return (JJIT_COMPILE_N) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("Clone unsupported", e);
        }
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) {
        nextpc = index + 1;
        next = instructions[nextpc];
    }

    public JJITInstruction run(KFrame frame) throws Exception {
        JJITMethodCompilerHints hints = (JJITMethodCompilerHints) frame.getMethod().getMethodCompilerHints();
        counter--;
        if (counter == 0) {
            hints.setHint(JJITMethodCompilerHints.ProcessorType.COMPILER);
            frame.getMethod().setStatus(KMethod.STATUS_DIRTY);
        }
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JJIT_COMPILE_N other = (JJIT_COMPILE_N) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash;
        return hash;
    }

    @Override
    public String toString() {
        return "<Compile>{" + counter + "/" + counter0 + '}';
    }
}
