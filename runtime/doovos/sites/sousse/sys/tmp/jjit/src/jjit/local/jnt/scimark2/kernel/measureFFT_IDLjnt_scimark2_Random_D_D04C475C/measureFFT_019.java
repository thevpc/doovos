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
 * [count=6] [47] ILOAD(0) [48] I2D [49] DDIV [50] LDC(14->"1.0E-10") [51] DCMPL [52] IFLE(55)
 */
public final class measureFFT_019 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        double m_d;
        double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[47] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[48] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(0).intValue());
         // *********[49] DDIV
        m_d = frame.getLocal(0).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((frame.popDouble() / m_d));
         // *********[50] LDC(14->"1.0E-10")
         // **REMOVED Substitution** s1 = D1_0EM10;
         // *********[51] DCMPL
         // **REMOVED Substitution** m_d3 = 1.0E-10D;
        m_d2 = (frame.popDouble() / m_d);
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d2))?(KInteger.M1):(((m_d2 == 1.0E-10D)?(KInteger.ZERO):(((m_d2 > 1.0E-10D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[52] IFLE(55)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d2))?(-1):(((m_d2 == 1.0E-10D)?(0):(((m_d2 > 1.0E-10D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d2))?(-1):(((m_d2 == 1.0E-10D)?(0):(((m_d2 > 1.0E-10D)?(1):(-1)))))) <= 0;
        return ((((Double.isNaN(m_d2))?(-1):(((m_d2 == 1.0E-10D)?(0):(((m_d2 > 1.0E-10D)?(1):(-1)))))) <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[47] ILOAD(0)
         // *********[48] I2D
         // *********[49] DDIV
         // *********[50] LDC(14->"1.0E-10")
         // *********[51] DCMPL
         // *********[52] IFLE(55)
        c_next = instructions[(index + 1)];
        c_label = instructions[20];
      }
}
