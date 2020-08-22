/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstructionDef;

/**
 *
 * @author vpc
 */
public class BlocItem extends Bloc{
    private JJITFlowControlNode node;

    public BlocItem(JJITFlowControlNode node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "BlocItem{" + node + '}';
    }

    public JJITFlowControlNode getNode() {
        return node;
    }
    public JJITInstructionDef getInstruction() {
        return node.getInstruction();
    }
    
}
