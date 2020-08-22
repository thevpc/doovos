/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.debug;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;

/**
 *
 * @author vpc
 */
public class JJITInstructionBloc{

    private int index;
    private JJITInstructionDef[] instructions;

    public JJITInstructionBloc(int index,JJITInstructionDef... instructions) {
        this.instructions = instructions;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public JJITInstructionDef[] getInstructions() {
        return instructions;
    }
}
