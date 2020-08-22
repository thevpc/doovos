package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.shared;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITAbstractInstruction;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 24/07/11
 * Time: 23:41
 * To change this template use File | Settings | File Templates.
 */
public class JJIT_XCONST_XSTORE extends JJITAbstractInstruction implements Cloneable {
    private JJITInstruction c_next;
    private KRegister value;
    private int local;

    public JJIT_XCONST_XSTORE(int local, KRegister value) {
        this.value = value;
        this.local = local;
    }

    public JJITInstruction run(KFrame frame) throws Exception {
        frame.setLocal(local, value);
        return c_next;
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
        c_next = instructions[(index + 1)];
    }

}
