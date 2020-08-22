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
 * [count=5] [40] LLOAD(6) [41] LDC(12->"2") [42] LMUL [43] LSTORE(6) [44] GOTO(16)
 */
public final class measureFFT_017 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** long m_l;
         // local_6 6 ; r=1/w=1 : Cached
        KRegister local_6 = frame.getLocal(6);
         // *********[40] LLOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[41] LDC(12->"2")
         // **REMOVED Substitution** s1 = L2;
         // *********[42] LMUL
         // **REMOVED Substitution** m_l = 2L;
         // **REMOVED Substitution** s0 = new KLong((local_6.longValue() * 2L));
         // *********[43] LSTORE(6)
         // **REMOVED Substitution** local_6 = new KLong((local_6.longValue() * 2L));
         // *********[44] GOTO(16)
        frame.setLocal(6,new KLong((local_6.longValue() * 2L)));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[40] LLOAD(6)
         // *********[41] LDC(12->"2")
         // *********[42] LMUL
         // *********[43] LSTORE(6)
         // *********[44] GOTO(16)
        c_label = instructions[6];
      }
}
