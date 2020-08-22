/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControl;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.stats.JJITMethodCompilerStat;

/**
 *
 * @author vpc
 */
public final class JJITMethodCompilerCache {

    private JJITInstructionDef[] instructionDefs;
    private JJITFlowControl flowControl;
    private JJITMethodCompilerStat stat;

    public JJITMethodCompilerCache() {
    }

    public JJITInstructionDef[] getInstructionDefs() {
        return instructionDefs;
    }

    public void setInstructionDefs(JJITInstructionDef[] instructionDefs) {
        this.instructionDefs = instructionDefs;
    }

    public JJITFlowControl getFlowControl() {
        return flowControl;
    }

    public void setFlowControl(JJITFlowControl flowControl) {
        this.flowControl = flowControl;
    }

    public JJITMethodCompilerStat getStat() {
        return stat;
    }

    public void setStat(JJITMethodCompilerStat stat) {
        this.stat = stat;
    }
}
