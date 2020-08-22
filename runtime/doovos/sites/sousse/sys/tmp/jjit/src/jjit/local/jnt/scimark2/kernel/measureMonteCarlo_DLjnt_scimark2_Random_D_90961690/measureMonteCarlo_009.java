package jjit.local.jnt.scimark2.kernel.measureMonteCarlo_DLjnt_scimark2_Random_D_90961690;
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
 * measureMonteCarlo(DLjnt/scimark2/Random;)D
 * [count=3] [17] DLOAD(0) [18] DCMPL [19] IFLT(21)
 */
public final class measureMonteCarlo_009 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        double m_d;
        double m_d2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[17] DLOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[18] DCMPL
        m_d2 = frame.getLocal(0).doubleValue();
        m_d = frame.popDouble();
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(KInteger.M1):(((m_d == m_d2)?(KInteger.ZERO):(((m_d > m_d2)?(KInteger.ONE):(KInteger.M1))))));
         // *********[19] IFLT(21)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) < 0;
        return ((((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) < 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[17] DLOAD(0)
         // *********[18] DCMPL
         // *********[19] IFLT(21)
        c_next = instructions[(index + 1)];
        c_label = instructions[10];
      }
}
