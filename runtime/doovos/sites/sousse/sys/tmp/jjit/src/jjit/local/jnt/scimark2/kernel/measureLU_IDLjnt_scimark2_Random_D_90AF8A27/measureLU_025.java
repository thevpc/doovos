package jjit.local.jnt.scimark2.kernel.measureLU_IDLjnt_scimark2_Random_D_90AF8A27;
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
 * measureLU(IDLjnt/scimark2/Random;)D
 * [count=6] [65] ILOAD(0) [66] I2D [67] DDIV [68] LDC(33->"1.0E-12") [69] DCMPL [70] IFLE(73)
 */
public final class measureLU_025 extends JJITAbstractInstruction implements Cloneable{
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
         // *********[65] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[66] I2D
         // **REMOVED Substitution** s0 = new KDouble(frame.getLocal(0).intValue());
         // *********[67] DDIV
        m_d = frame.getLocal(0).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((frame.popDouble() / m_d));
         // *********[68] LDC(33->"1.0E-12")
         // **REMOVED Substitution** s1 = D1_0EM12;
         // *********[69] DCMPL
         // **REMOVED Substitution** m_d3 = 1.0E-12D;
        m_d2 = (frame.popDouble() / m_d);
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d2))?(KInteger.M1):(((m_d2 == 1.0E-12D)?(KInteger.ZERO):(((m_d2 > 1.0E-12D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[70] IFLE(73)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d2))?(-1):(((m_d2 == 1.0E-12D)?(0):(((m_d2 > 1.0E-12D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d2))?(-1):(((m_d2 == 1.0E-12D)?(0):(((m_d2 > 1.0E-12D)?(1):(-1)))))) <= 0;
        return ((((Double.isNaN(m_d2))?(-1):(((m_d2 == 1.0E-12D)?(0):(((m_d2 > 1.0E-12D)?(1):(-1)))))) <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[65] ILOAD(0)
         // *********[66] I2D
         // *********[67] DDIV
         // *********[68] LDC(33->"1.0E-12")
         // *********[69] DCMPL
         // *********[70] IFLE(73)
        c_next = instructions[(index + 1)];
        c_label = instructions[26];
      }
}
