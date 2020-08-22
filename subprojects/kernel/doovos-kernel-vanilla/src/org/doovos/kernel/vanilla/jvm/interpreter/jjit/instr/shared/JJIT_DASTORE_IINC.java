package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.shared;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KInteger;
import org.doovos.kernel.api.memory.KMemoryManager;
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
public class JJIT_DASTORE_IINC extends JJITAbstractInstruction implements Cloneable {
    private KMemoryManager c_memman;
    private JJITInstruction c_next;
    private int local;
    private int inc;

    public JJIT_DASTORE_IINC(int local,int inc) {
        this.local = local;
        this.inc = inc;
    }

    public JJITInstruction run(KFrame frame) throws Exception {
        double m_d = frame.popDouble();
        int index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
        frame.setLocal(local,new KInteger((frame.getLocal(local).intValue() + inc)));
        return c_next;
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
        c_memman = process.getMemoryManager();
        c_next = instructions[(index + 1)];
    }

}
