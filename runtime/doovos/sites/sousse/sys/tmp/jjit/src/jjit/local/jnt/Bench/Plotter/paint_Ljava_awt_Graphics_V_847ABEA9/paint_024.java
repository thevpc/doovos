package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=4] [78] DLOAD(9) [79] DLOAD(11) [80] DCMPL [81] IFNE(83)
 */
public final class paint_024 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        double m_d;
        double m_d2;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_9 9 ; r=1/w=0 : NotCached
         // local_11 11 ; r=1/w=0 : NotCached
         // *********[78] DLOAD(9)
         // **REMOVED Substitution** s0 = frame.getLocal(9);
         // *********[79] DLOAD(11)
         // **REMOVED Substitution** s1 = frame.getLocal(11);
         // *********[80] DCMPL
        m_d2 = frame.getLocal(11).doubleValue();
        m_d = frame.getLocal(9).doubleValue();
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(KInteger.M1):(((m_d == m_d2)?(KInteger.ZERO):(((m_d > m_d2)?(KInteger.ONE):(KInteger.M1))))));
         // *********[81] IFNE(83)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) != 0;
        return ((((Double.isNaN(m_d) || Double.isNaN(m_d2))?(-1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[78] DLOAD(9)
         // *********[79] DLOAD(11)
         // *********[80] DCMPL
         // *********[81] IFNE(83)
        c_next = instructions[(index + 1)];
        c_label = instructions[25];
      }
}
