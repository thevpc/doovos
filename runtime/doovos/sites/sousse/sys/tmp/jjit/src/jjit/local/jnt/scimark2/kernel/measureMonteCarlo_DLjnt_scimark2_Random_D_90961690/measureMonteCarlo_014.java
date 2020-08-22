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
 * [count=4] [30] DDIV [31] LDC(16->"1.0E-6") [32] DMUL [33] DRETURN
 */
public final class measureMonteCarlo_014 extends JJITAbstractInstruction implements Cloneable{
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        double m_d;
         // **REMOVED Unused Var** double m_d2;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // *********[30] DDIV
        m_d = frame.popDouble();
         // **REMOVED Substitution** s0 = new KDouble((frame.popDouble() / m_d));
         // *********[31] LDC(16->"1.0E-6")
         // **REMOVED Substitution** s1 = D1_0EM6;
         // *********[32] DMUL
         // **REMOVED Substitution** m_d2 = 1.0E-6D;
         // **REMOVED Substitution** s0 = new KDouble(((frame.popDouble() / m_d) * 1.0E-6D));
         // *********[33] DRETURN
         // **REMOVED Substitution** reg = new KDouble(((frame.popDouble() / m_d) * 1.0E-6D));
        callerFrame = thread.popFrame();
        callerFrame.push(new KDouble(((frame.popDouble() / m_d) * 1.0E-6D)));
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[30] DDIV
         // *********[31] LDC(16->"1.0E-6")
         // *********[32] DMUL
         // *********[33] DRETURN
      }
}
