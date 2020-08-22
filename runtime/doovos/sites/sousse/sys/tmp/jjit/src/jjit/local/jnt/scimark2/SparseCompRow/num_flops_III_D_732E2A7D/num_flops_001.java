package jjit.local.jnt.scimark2.SparseCompRow.num_flops_III_D_732E2A7D;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.SparseCompRow
 * num_flops(III)D
 * [count=14] [0] ILOAD(1) [1] ILOAD(0) [2] IDIV [3] ILOAD(0) [4] IMUL [5] ISTORE(3) [6] ILOAD(3) [7] I2D [8] LDC(2->"2.0") [9] DMUL [10] ILOAD(2) [11] I2D [12] DMUL [13] DRETURN
 */
public final class num_flops_001 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
        KFrame callerFrame = null;
        KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_0 0 ; r=2/w=0 : Cached
        int local_0 = frame.getLocal(0).intValue();
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=1 : Cached
        int local_3;
         // *********[0] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[1] ILOAD(0)
         // **REMOVED Substitution** s1 = new KInteger(local_0);
         // *********[2] IDIV
         // **REMOVED Substitution** index = local_0;
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(1).intValue() / local_0));
         // *********[3] ILOAD(0)
         // **REMOVED Substitution** s1 = new KInteger(local_0);
         // *********[4] IMUL
         // **REMOVED Substitution** index = local_0;
         // **REMOVED Substitution** s0 = new KInteger(((frame.getLocal(1).intValue() / local_0) * local_0));
         // *********[5] ISTORE(3)
        local_3 = ((frame.getLocal(1).intValue() / local_0) * local_0);
         // *********[6] ILOAD(3)
         // **REMOVED Substitution** s0 = new KInteger(local_3);
         // *********[7] I2D
         // **REMOVED Substitution** s0 = new KDouble(local_3);
         // *********[8] LDC(2->"2.0")
         // **REMOVED Substitution** s1 = D2_0;
         // *********[9] DMUL
         // **REMOVED Substitution** m_d = 2.0D;
         // **REMOVED Substitution** s0 = new KDouble((((double)local_3) * 2.0D));
         // *********[10] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[11] I2D
         // **REMOVED Substitution** s1 = new KDouble(frame.getLocal(2).intValue());
         // *********[12] DMUL
         // **REMOVED Substitution** m_d2 = frame.getLocal(2).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble(((((double)local_3) * 2.0D) * frame.getLocal(2).doubleValue()));
         // *********[13] DRETURN
        reg = new KDouble(((((double)local_3) * 2.0D) * frame.getLocal(2).doubleValue()));
        frame.setLocal(3,new KInteger(local_3));
        callerFrame = thread.popFrame();
        callerFrame.push(reg);
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(1)
         // *********[1] ILOAD(0)
         // *********[2] IDIV
         // *********[3] ILOAD(0)
         // *********[4] IMUL
         // *********[5] ISTORE(3)
         // *********[6] ILOAD(3)
         // *********[7] I2D
         // *********[8] LDC(2->"2.0")
         // *********[9] DMUL
         // *********[10] ILOAD(2)
         // *********[11] I2D
         // *********[12] DMUL
         // *********[13] DRETURN
      }
}
