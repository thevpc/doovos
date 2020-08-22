/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.special;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;

import java.io.Serializable;

/**
 * @author vpc
 */
public class JJIT_INITIALIZE_CLASS implements JJITInstruction, Cloneable, Serializable {

    private String className;

    private transient int nextpc;
    private transient boolean loaded = false;
    private transient JJITInstruction next;

    public JJIT_INITIALIZE_CLASS(String className) {
        this.className = className;
    }

    public JJITInstruction clone() {
        try {
            return (JJIT_INITIALIZE_CLASS) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("Clone unsupported", e);
        }
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) {
        nextpc = index + 1;
        next = instructions[nextpc];
        loaded = false;
    }

    public JJITInstruction run(KFrame frame) throws Exception {
        if (!loaded) {
            loaded = true;
            final KClass cc = frame.getClassRepository().getClassByName(className);
            KLocalThread t = frame.getThread();
            if (t.pushClassInitializerFrame(cc)) {
                frame.setProgramCounter(nextpc);
                return (JJITInstruction) t.getFrame().getCurrentInstruction();
            }
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
        final JJIT_INITIALIZE_CLASS other = (JJIT_INITIALIZE_CLASS) obj;
        if ((this.className == null) ? (other.className != null) : !this.className.equals(other.className)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.className != null ? this.className.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "<Initialize>{" + className + '}';
    }

}
