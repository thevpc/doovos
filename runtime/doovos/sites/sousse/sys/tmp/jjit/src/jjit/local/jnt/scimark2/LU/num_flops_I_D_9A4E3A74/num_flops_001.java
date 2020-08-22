package jjit.local.jnt.scimark2.LU.num_flops_I_D_9A4E3A74;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * num_flops(I)D
 * [count=13] [0] ILOAD(0) [1] I2D [2] DSTORE(1) [3] LDC(0->"2.0") [4] DLOAD(1) [5] DMUL [6] DLOAD(1) [7] DMUL [8] DLOAD(1) [9] DMUL [10] LDC(1->"3.0") [11] DDIV [12] DRETURN
 */
public final class num_flops_001 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=3/w=1 : Cached
        KRegister local_1;
         // *********[0] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(0).intValue());
         // *********[2] DSTORE(1)
        local_1 = new KDouble(frame.getLocal(0).intValue());
         // *********[3] LDC(0->"2.0")
         // **REMOVED Substitution** s0 = D2_0;
         // *********[4] DLOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[5] DMUL
         // **REMOVED Substitution** m_d = local_1.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((2.0D * local_1.doubleValue()));
         // *********[6] DLOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[7] DMUL
         // **REMOVED Substitution** m_d2 = local_1.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble(((2.0D * local_1.doubleValue()) * local_1.doubleValue()));
         // *********[8] DLOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[9] DMUL
         // **REMOVED Substitution** m_d3 = local_1.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((((2.0D * local_1.doubleValue()) * local_1.doubleValue()) * local_1.doubleValue()));
         // *********[10] LDC(1->"3.0")
         // **REMOVED Substitution** s1 = D3_0;
         // *********[11] DDIV
         // **REMOVED Substitution** m_d4 = 3.0D;
         // **REMOVED Substitution** s0 = new KDouble(((((2.0D * local_1.doubleValue()) * local_1.doubleValue()) * local_1.doubleValue()) / 3.0D));
         // *********[12] DRETURN
         // **REMOVED Substitution** reg = new KDouble(((((2.0D * local_1.doubleValue()) * local_1.doubleValue()) * local_1.doubleValue()) / 3.0D));
        frame.setLocal(1,local_1);
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble(((((2.0D * local_1.doubleValue()) * local_1.doubleValue()) * local_1.doubleValue()) / 3.0D)));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(0)
         // *********[1] I2D
         // *********[2] DSTORE(1)
         // *********[3] LDC(0->"2.0")
         // *********[4] DLOAD(1)
         // *********[5] DMUL
         // *********[6] DLOAD(1)
         // *********[7] DMUL
         // *********[8] DLOAD(1)
         // *********[9] DMUL
         // *********[10] LDC(1->"3.0")
         // *********[11] DDIV
         // *********[12] DRETURN
      }
}
