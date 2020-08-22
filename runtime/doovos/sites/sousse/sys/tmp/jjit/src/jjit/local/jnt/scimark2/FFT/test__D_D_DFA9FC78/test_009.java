package jjit.local.jnt.scimark2.FFT.test__D_D_DFA9FC78;
import java.lang.Math;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * test([D)D
 * [count=6] [39] DLOAD(3) [40] ILOAD(1) [41] I2D [42] DDIV [43] INVOKE_HOST(java.lang.Math.sqrt(D)D) [44] DRETURN
 */
public final class test_009 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[39] DLOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[40] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[41] I2D
         // **REMOVED Substitution** s1 = new KDouble(frame.getLocal(1).intValue());
         // *********[42] DDIV
         // **REMOVED Substitution** m_d = frame.getLocal(1).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((frame.getLocal(3).doubleValue() / frame.getLocal(1).doubleValue()));
         // *********[43] INVOKE_HOST(java.lang.Math.sqrt(D)D)
         // **REMOVED Substitution** m_v = (frame.getLocal(3).doubleValue() / frame.getLocal(1).doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(Math.sqrt((frame.getLocal(3).doubleValue() / frame.getLocal(1).doubleValue())));
         // *********[44] DRETURN
         // **REMOVED Substitution** reg = new KDouble(Math.sqrt((frame.getLocal(3).doubleValue() / frame.getLocal(1).doubleValue())));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble(Math.sqrt((frame.getLocal(3).doubleValue() / frame.getLocal(1).doubleValue()))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] DLOAD(3)
         // *********[40] ILOAD(1)
         // *********[41] I2D
         // *********[42] DDIV
         // *********[43] INVOKE_HOST(java.lang.Math.sqrt(D)D)
         // *********[44] DRETURN
      }
}
