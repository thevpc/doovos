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

/**
 *
 * @author vpc
 */
public class JJIT_ABSTRACT_CALL implements JJITInstruction, Cloneable,Serializable{
    private String methodId;
    public JJIT_ABSTRACT_CALL(String methodId) {
        this.methodId=methodId;
    }


    public JJITInstruction clone() {
        try {
            return (JJITInstruction)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) {
    }

    public JJITInstruction run(KFrame frame) throws Exception {
        frame.throwAbstractMethodError(methodId);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JJIT_ABSTRACT_CALL that = (JJIT_ABSTRACT_CALL) o;

        if (!methodId.equals(that.methodId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return methodId.hashCode();
    }

    @Override
    public String toString() {
        return "<JNI_CALL>";
    }
    
}
