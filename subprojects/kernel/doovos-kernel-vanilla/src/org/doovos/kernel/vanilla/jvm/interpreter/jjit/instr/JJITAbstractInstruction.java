/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import java.io.Serializable;

/**
 *
 * @author vpc
 */
public abstract class JJITAbstractInstruction implements JJITInstruction, Serializable, Cloneable {

    @Override
    public JJITInstruction clone() {
        try {
            return (JJITInstruction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException("Clone unsupported", e);
        }
    }
}
