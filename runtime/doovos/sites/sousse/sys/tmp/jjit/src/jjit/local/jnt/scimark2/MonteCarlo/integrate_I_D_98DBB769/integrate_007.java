package jjit.local.jnt.scimark2.MonteCarlo.integrate_I_D_98DBB769;
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
 * integrate(I)D
 * [count=11] [15] DSTORE(6) [16] DLOAD(4) [17] DLOAD(4) [18] DMUL [19] DLOAD(6) [20] DLOAD(6) [21] DMUL [22] DADD [23] DCONST_1(Double{1.0}) [24] DCMPG [25] IFGT(27)
 */
public final class integrate_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
        double m_d4;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_4 4 ; r=2/w=0 : Cached
        KRegister local_4 = frame.getLocal(4);
         // local_6 6 ; r=2/w=1 : Cached
        KRegister local_6;
         // *********[15] DSTORE(6)
        local_6 = frame.pop();
         // *********[16] DLOAD(4)
         // **REMOVED Substitution** s0 = local_4;
         // *********[17] DLOAD(4)
         // **REMOVED Substitution** s1 = local_4;
         // *********[18] DMUL
         // **REMOVED Substitution** m_d = local_4.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((local_4.doubleValue() * local_4.doubleValue()));
         // *********[19] DLOAD(6)
         // **REMOVED Substitution** s1 = local_6;
         // *********[20] DLOAD(6)
         // **REMOVED Substitution** s2 = local_6;
         // *********[21] DMUL
         // **REMOVED Substitution** m_d2 = local_6.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_6.doubleValue() * local_6.doubleValue()));
         // *********[22] DADD
         // **REMOVED Substitution** m_d3 = (local_6.doubleValue() * local_6.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(((local_4.doubleValue() * local_4.doubleValue()) + (local_6.doubleValue() * local_6.doubleValue())));
         // *********[23] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s1 = DONE;
         // *********[24] DCMPG
         // **REMOVED Substitution** m_d5 = 1.0D;
        m_d4 = ((local_4.doubleValue() * local_4.doubleValue()) + (local_6.doubleValue() * local_6.doubleValue()));
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d4))?(KInteger.ONE):(((m_d4 == 1.0D)?(KInteger.ZERO):(((m_d4 > 1.0D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[25] IFGT(27)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d4))?(1):(((m_d4 == 1.0D)?(0):(((m_d4 > 1.0D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d4))?(1):(((m_d4 == 1.0D)?(0):(((m_d4 > 1.0D)?(1):(-1)))))) > 0;
        frame.setLocal(6,local_6);
        return ((((Double.isNaN(m_d4))?(1):(((m_d4 == 1.0D)?(0):(((m_d4 > 1.0D)?(1):(-1)))))) > 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] DSTORE(6)
         // *********[16] DLOAD(4)
         // *********[17] DLOAD(4)
         // *********[18] DMUL
         // *********[19] DLOAD(6)
         // *********[20] DLOAD(6)
         // *********[21] DMUL
         // *********[22] DADD
         // *********[23] DCONST_1(Double{1.0})
         // *********[24] DCMPG
         // *********[25] IFGT(27)
        c_next = instructions[(index + 1)];
        c_label = instructions[8];
      }
}
