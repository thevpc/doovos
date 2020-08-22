package jjit.local.jnt.scimark2.kernel.RandomMatrix_IILjnt_scimark2_Random___D_FCF0B237;
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
 * RandomMatrix(IILjnt/scimark2/Random;)[[D
 * [count=3] [7] ICONST_0(Integer{0}) [8] ISTORE(5) [9] GOTO(18)
 */
public final class RandomMatrix_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[7] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[8] ISTORE(5)
        frame.setLocal(5,KInteger.ZERO);
         // *********[9] GOTO(18)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ICONST_0(Integer{0})
         // *********[8] ISTORE(5)
         // *********[9] GOTO(18)
        c_label = instructions[7];
      }
}
