package jjit.local.jnt.scimark2.kernel.measureFFT_IDLjnt_scimark2_Random_D_D04C475C;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * measureFFT(IDLjnt/scimark2/Random;)D
 * [count=5] [26] ILOAD(9) [27] I2L [28] LLOAD(6) [29] LCMP [30] IFLT(21)
 */
public final class measureFFT_012 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        long m_l;
        long m_l2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_6 6 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // *********[26] ILOAD(9)
         // **REMOVED Substitution** s0 = frame.getLocal(9);
         // *********[27] I2L
         // **REMOVED Substitution** s0 = new KLong(frame.getLocal(9).intValue());
         // *********[28] LLOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[29] LCMP
        m_l2 = frame.getLocal(6).longValue();
        m_l = frame.getLocal(9).longValue();
         // **REMOVED Substitution** s0 = ((m_l == m_l2)?(KInteger.ZERO):(((m_l > m_l2)?(KInteger.ONE):(KInteger.M1))));
         // *********[30] IFLT(21)
         // **REMOVED Substitution** index = ((m_l == m_l2)?(0):(((m_l > m_l2)?(1):(-1))));
         // **REMOVED Substitution** jump = ((m_l == m_l2)?(0):(((m_l > m_l2)?(1):(-1)))) < 0;
        return ((((m_l == m_l2)?(0):(((m_l > m_l2)?(1):(-1)))) < 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] ILOAD(9)
         // *********[27] I2L
         // *********[28] LLOAD(6)
         // *********[29] LCMP
         // *********[30] IFLT(21)
        c_next = instructions[(index + 1)];
        c_label = instructions[8];
      }
}
