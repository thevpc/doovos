/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.vanilla.jvm.interpreter.jjit;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControl;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol.JJITFlowControlNode;

/**
 *
 * @author vpc
 */
public class JJITTransformerContext {
    private JJITGuestToHostStaticFilter g2h;
    private JJITFlowControl flowControl;
    private JJITFlowControlNode node;

    public JJITTransformerContext(JJITGuestToHostStaticFilter g2h, JJITFlowControl flowControl) {
        this.g2h = g2h;
        this.flowControl = flowControl;
    }

    public JJITFlowControl getFlowControl() {
        return flowControl;
    }

    public JJITGuestToHostStaticFilter getG2h() {
        return g2h;
    }

    public JJITFlowControlNode getNode() {
        return node;
    }

    public void setNode(JJITFlowControlNode node) {
        this.node = node;
    }
    
    
}
