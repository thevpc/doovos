package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.shared;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KReference;
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
public class JJIT_ALOAD_ARRAYLENGTH extends JJITAbstractInstruction implements Cloneable {
    private KMemoryManager c_memman;
    private JJITInstruction c_next;
    private int local;

    public JJIT_ALOAD_ARRAYLENGTH(int local) {
        this.local = local;
    }

    public JJITInstruction run(KFrame frame) throws Exception {
       frame.push(new KInteger(c_memman.getArraySize(((KReference)frame.getLocal(local)))));
        return c_next;
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
        c_memman = process.getMemoryManager();
        c_next = instructions[(index + 1)];
    }

}
