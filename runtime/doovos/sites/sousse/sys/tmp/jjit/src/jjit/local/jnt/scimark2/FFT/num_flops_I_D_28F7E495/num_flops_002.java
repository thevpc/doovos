package jjit.local.jnt.scimark2.FFT.num_flops_I_D_28F7E495;
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
 * num_flops(I)D
 * [count=16] [5] I2D [6] DSTORE(3) [7] LDC(4->"5.0") [8] DLOAD(1) [9] DMUL [10] LDC(5->"2.0") [11] DSUB [12] DLOAD(3) [13] DMUL [14] LDC(5->"2.0") [15] DLOAD(1) [16] DCONST_1(Double{1.0}) [17] DADD [18] DMUL [19] DADD [20] DRETURN
 */
public final class num_flops_002 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_d6;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_1 1 ; r=2/w=0 : Cached
        KRegister local_1 = frame.getLocal(1);
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3;
         // *********[5] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.popInt());
         // *********[6] DSTORE(3)
        local_3 = new KDouble(frame.popInt());
         // *********[7] LDC(4->"5.0")
         // **REMOVED Substitution** s0 = D5_0;
         // *********[8] DLOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[9] DMUL
         // **REMOVED Substitution** m_d = local_1.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((5.0D * local_1.doubleValue()));
         // *********[10] LDC(5->"2.0")
         // **REMOVED Substitution** s1 = D2_0;
         // *********[11] DSUB
         // **REMOVED Substitution** m_d2 = 2.0D;
         // **REMOVED Substitution** s0 = new KDouble(((5.0D * local_1.doubleValue()) - 2.0D));
         // *********[12] DLOAD(3)
         // **REMOVED Substitution** s1 = local_3;
         // *********[13] DMUL
         // **REMOVED Substitution** m_d3 = local_3.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((((5.0D * local_1.doubleValue()) - 2.0D) * local_3.doubleValue()));
         // *********[14] LDC(5->"2.0")
         // **REMOVED Substitution** s1 = D2_0;
         // *********[15] DLOAD(1)
         // **REMOVED Substitution** s2 = local_1;
         // *********[16] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s3 = DONE;
         // *********[17] DADD
         // **REMOVED Substitution** m_d4 = 1.0D;
         // **REMOVED Substitution** s2 = new KDouble((local_1.doubleValue() + 1.0D));
         // *********[18] DMUL
         // **REMOVED Substitution** m_d5 = (local_1.doubleValue() + 1.0D);
         // **REMOVED Substitution** s1 = new KDouble((2.0D * (local_1.doubleValue() + 1.0D)));
         // *********[19] DADD
         // **REMOVED Substitution** m_d6 = (2.0D * (local_1.doubleValue() + 1.0D));
         // **REMOVED Substitution** s0 = new KDouble(((((5.0D * local_1.doubleValue()) - 2.0D) * local_3.doubleValue()) + (2.0D * (local_1.doubleValue() + 1.0D))));
         // *********[20] DRETURN
         // **REMOVED Substitution** reg = new KDouble(((((5.0D * local_1.doubleValue()) - 2.0D) * local_3.doubleValue()) + (2.0D * (local_1.doubleValue() + 1.0D))));
        frame.setLocal(3,local_3);
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble(((((5.0D * local_1.doubleValue()) - 2.0D) * local_3.doubleValue()) + (2.0D * (local_1.doubleValue() + 1.0D)))));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[5] I2D
         // *********[6] DSTORE(3)
         // *********[7] LDC(4->"5.0")
         // *********[8] DLOAD(1)
         // *********[9] DMUL
         // *********[10] LDC(5->"2.0")
         // *********[11] DSUB
         // *********[12] DLOAD(3)
         // *********[13] DMUL
         // *********[14] LDC(5->"2.0")
         // *********[15] DLOAD(1)
         // *********[16] DCONST_1(Double{1.0})
         // *********[17] DADD
         // *********[18] DMUL
         // *********[19] DADD
         // *********[20] DRETURN
      }
}
