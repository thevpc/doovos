package jjit.local.jnt.scimark2.LU.solve___D_I_D_V_710E1D67;
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
 * solve([[D[I[D)V
 * [count=4] [49] DLOAD(8) [50] DCONST_0(Double{0.0}) [51] DCMPL [52] IFNE(55)
 */
public final class solve_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[49] DLOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[50] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[51] DCMPL
         // **REMOVED Substitution** m_d2 = 0.0D;
        m_d = frame.getLocal(8).doubleValue();
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d))?(KInteger.M1):(((m_d == 0.0D)?(KInteger.ZERO):(((m_d > 0.0D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[52] IFNE(55)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0;
        return ((((Double.isNaN(m_d))?(-1):(((m_d == 0.0D)?(0):(((m_d > 0.0D)?(1):(-1)))))) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[49] DLOAD(8)
         // *********[50] DCONST_0(Double{0.0})
         // *********[51] DCMPL
         // *********[52] IFNE(55)
        c_next = instructions[(index + 1)];
        c_label = instructions[8];
      }
}
