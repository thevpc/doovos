/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr;

import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KInstruction;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;

/**
 *
 * @author vpc
 */
public interface JJITInstruction extends KInstruction{
    public void init(int index, JJITInstruction[] instructions, KRegister[] constants, KProcess process)throws Exception;
    public JJITInstruction run(KFrame frame) throws Exception;
    public JJITInstruction clone();
}
