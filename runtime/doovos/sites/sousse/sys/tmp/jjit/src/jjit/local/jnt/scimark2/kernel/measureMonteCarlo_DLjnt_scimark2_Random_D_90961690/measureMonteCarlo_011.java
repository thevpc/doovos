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
 * [count=5] [21] ILOAD(4) [22] ICONST_2(Integer{2}) [23] IMUL [24] ISTORE(4) [25] GOTO(7)
 */
public final class measureMonteCarlo_011 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // local_4 4 ; r=1/w=1 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // *********[21] ILOAD(4)
         // **REMOVED Substitution** s0 = new KInteger(local_4);
         // *********[22] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[23] IMUL
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_4 * 2));
         // *********[24] ISTORE(4)
         // **REMOVED Substitution** local_4 = (local_4 * 2);
         // *********[25] GOTO(7)
        frame.setLocal(4,new KInteger((local_4 * 2)));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] ILOAD(4)
         // *********[22] ICONST_2(Integer{2})
         // *********[23] IMUL
         // *********[24] ISTORE(4)
         // *********[25] GOTO(7)
        c_label = instructions[4];
      }
}
