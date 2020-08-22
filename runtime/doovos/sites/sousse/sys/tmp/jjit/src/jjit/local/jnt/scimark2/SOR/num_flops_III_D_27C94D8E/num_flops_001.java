package jjit.local.jnt.scimark2.SOR.num_flops_III_D_27C94D8E;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.SOR
 * num_flops(III)D
 * [count=21] [0] ILOAD(0) [1] I2D [2] DSTORE(3) [3] ILOAD(1) [4] I2D [5] DSTORE(5) [6] ILOAD(2) [7] I2D [8] DSTORE(7) [9] DLOAD(3) [10] DCONST_1(Double{1.0}) [11] DSUB [12] DLOAD(5) [13] DCONST_1(Double{1.0}) [14] DSUB [15] DMUL [16] DLOAD(7) [17] DMUL [18] LDC(2->"6.0") [19] DMUL [20] DRETURN
 */
public final class num_flops_001 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** double m_d5;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3;
         // local_5 5 ; r=1/w=1 : Cached
        KRegister local_5;
         // local_7 7 ; r=1/w=1 : Cached
        KRegister local_7;
         // *********[0] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(0).intValue());
         // *********[2] DSTORE(3)
        local_3 = new KDouble(frame.getLocal(0).intValue());
         // *********[3] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[4] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(1).intValue());
         // *********[5] DSTORE(5)
        local_5 = new KDouble(frame.getLocal(1).intValue());
         // *********[6] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[7] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(2).intValue());
         // *********[8] DSTORE(7)
        local_7 = new KDouble(frame.getLocal(2).intValue());
         // *********[9] DLOAD(3)
         // **REMOVED Substitution** s0 = local_3;
         // *********[10] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s1 = DONE;
         // *********[11] DSUB
         // **REMOVED Substitution** m_d = 1.0D;
         // **REMOVED Substitution** s0 = new KDouble((local_3.doubleValue() - 1.0D));
         // *********[12] DLOAD(5)
         // **REMOVED Substitution** s1 = local_5;
         // *********[13] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s2 = DONE;
         // *********[14] DSUB
         // **REMOVED Substitution** m_d2 = 1.0D;
         // **REMOVED Substitution** s1 = new KDouble((local_5.doubleValue() - 1.0D));
         // *********[15] DMUL
         // **REMOVED Substitution** m_d3 = (local_5.doubleValue() - 1.0D);
         // **REMOVED Substitution** s0 = new KDouble(((local_3.doubleValue() - 1.0D) * (local_5.doubleValue() - 1.0D)));
         // *********[16] DLOAD(7)
         // **REMOVED Substitution** s1 = local_7;
         // *********[17] DMUL
         // **REMOVED Substitution** m_d4 = local_7.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((((local_3.doubleValue() - 1.0D) * (local_5.doubleValue() - 1.0D)) * local_7.doubleValue()));
         // *********[18] LDC(2->"6.0")
         // **REMOVED Substitution** s1 = D6_0;
         // *********[19] DMUL
         // **REMOVED Substitution** m_d5 = 6.0D;
         // **REMOVED Substitution** s0 = new KDouble(((((local_3.doubleValue() - 1.0D) * (local_5.doubleValue() - 1.0D)) * local_7.doubleValue()) * 6.0D));
         // *********[20] DRETURN
         // **REMOVED Substitution** reg = new KDouble(((((local_3.doubleValue() - 1.0D) * (local_5.doubleValue() - 1.0D)) * local_7.doubleValue()) * 6.0D));
        frame.setLocal(3,local_3);
        frame.setLocal(5,local_5);
        frame.setLocal(7,local_7);
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble(((((local_3.doubleValue() - 1.0D) * (local_5.doubleValue() - 1.0D)) * local_7.doubleValue()) * 6.0D)));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(0)
         // *********[1] I2D
         // *********[2] DSTORE(3)
         // *********[3] ILOAD(1)
         // *********[4] I2D
         // *********[5] DSTORE(5)
         // *********[6] ILOAD(2)
         // *********[7] I2D
         // *********[8] DSTORE(7)
         // *********[9] DLOAD(3)
         // *********[10] DCONST_1(Double{1.0})
         // *********[11] DSUB
         // *********[12] DLOAD(5)
         // *********[13] DCONST_1(Double{1.0})
         // *********[14] DSUB
         // *********[15] DMUL
         // *********[16] DLOAD(7)
         // *********[17] DMUL
         // *********[18] LDC(2->"6.0")
         // *********[19] DMUL
         // *********[20] DRETURN
      }
}
