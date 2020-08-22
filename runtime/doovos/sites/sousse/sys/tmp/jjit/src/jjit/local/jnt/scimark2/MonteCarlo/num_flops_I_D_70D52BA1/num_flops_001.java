package jjit.local.jnt.scimark2.MonteCarlo.num_flops_I_D_70D52BA1;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.MonteCarlo
 * num_flops(I)D
 * [count=5] [0] ILOAD(0) [1] I2D [2] LDC(2->"4.0") [3] DMUL [4] DRETURN
 */
public final class num_flops_001 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[0] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(0).intValue());
         // *********[2] LDC(2->"4.0")
         // **REMOVED Substitution** s1 = D4_0;
         // *********[3] DMUL
         // **REMOVED Substitution** m_d = 4.0D;
         // **REMOVED Substitution** s0 = new KDouble((frame.getLocal(0).doubleValue() * 4.0D));
         // *********[4] DRETURN
         // **REMOVED Substitution** reg = new KDouble((frame.getLocal(0).doubleValue() * 4.0D));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble((frame.getLocal(0).doubleValue() * 4.0D)));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(0)
         // *********[1] I2D
         // *********[2] LDC(2->"4.0")
         // *********[3] DMUL
         // *********[4] DRETURN
      }
}
