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
 * [count=4] [3] ASTORE(3) [4] ICONST_1(Integer{1}) [5] ISTORE(4) [6] GOTO(7)
 */
public final class measureMonteCarlo_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[3] ASTORE(3)
        frame.setLocal(3,frame.pop());
         // *********[4] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[5] ISTORE(4)
        frame.setLocal(4,KInteger.ONE);
         // *********[6] GOTO(7)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ASTORE(3)
         // *********[4] ICONST_1(Integer{1})
         // *********[5] ISTORE(4)
         // *********[6] GOTO(7)
        c_label = instructions[4];
      }
}
