package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.shared;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
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
public class JJIT_XLOAD_X_XRETURN extends JJITAbstractInstruction implements Cloneable {
    private int local;

    public JJIT_XLOAD_X_XRETURN(int local) {
        this.local = local;
    }

    public JJITInstruction run(KFrame frame) throws Exception {
        KFrame callerFrame = frame.getThread().popFrame();
        callerFrame.push(frame.getLocal(local));
        return ((JJITInstruction) callerFrame.getCurrentInstruction());
    }

    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process) throws Exception {
    }

}
