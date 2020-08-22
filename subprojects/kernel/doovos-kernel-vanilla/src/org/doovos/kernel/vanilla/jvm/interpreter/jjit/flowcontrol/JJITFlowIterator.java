package org.doovos.kernel.vanilla.jvm.interpreter.jjit.flowcontrol;

import org.doovos.kernel.vanilla.jvm.interpreter.jjit.src.instr.JJITInstr;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 21/07/11
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public class JJITFlowIterator {
    private JJITFlowIterator parent;
    private JJITInstr[] array;
    private int start;
    private int end;

    public JJITFlowIterator getParent() {
        return parent;
    }

    public JJITInstr[] getArray() {
        return array;
    }

    public int getStart() {
        return start;
    }

    public JJITFlowIterator(JJITFlowIterator parent, JJITInstr[] array, int start, int end) {
        this.parent = parent;
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int getEnd() {
        return end;
    }
}
