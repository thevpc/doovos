package jjit.local.jnt.scimark2.Stopwatch.seconds__D_83C9E0D1;
import java.lang.System;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Stopwatch
 * seconds()D
 * [count=5] [0] INVOKE_HOST(java.lang.System.currentTimeMillis()J) [1] L2D [2] LDC(2->"0.0010") [3] DMUL [4] DRETURN
 */
public final class seconds_001 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_d;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // *********[0] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // **REMOVED Substitution** s0 = new KLong(System.currentTimeMillis());
         // *********[1] L2D
         // **REMOVED Substitution** s0 = new KDouble(((double)System.currentTimeMillis()));
         // *********[2] LDC(2->"0.0010")
         // **REMOVED Substitution** s1 = D0_0010;
         // *********[3] DMUL
         // **REMOVED Substitution** m_d = 0.0010D;
         // **REMOVED Substitution** s0 = new KDouble((((double)System.currentTimeMillis()) * 0.0010D));
         // *********[4] DRETURN
         // **REMOVED Substitution** reg = new KDouble((((double)System.currentTimeMillis()) * 0.0010D));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble((((double)System.currentTimeMillis()) * 0.0010D)));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // *********[1] L2D
         // *********[2] LDC(2->"0.0010")
         // *********[3] DMUL
         // *********[4] DRETURN
      }
}
