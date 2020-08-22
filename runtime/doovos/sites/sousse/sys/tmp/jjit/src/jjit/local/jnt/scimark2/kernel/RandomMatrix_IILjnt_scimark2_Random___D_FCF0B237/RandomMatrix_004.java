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
 * [count=4] [3] ASTORE(3) [4] ICONST_0(Integer{0}) [5] ISTORE(4) [6] GOTO(22)
 */
public final class RandomMatrix_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[3] ASTORE(3)
        frame.setLocal(3,frame.pop());
         // *********[4] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[5] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[6] GOTO(22)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ASTORE(3)
         // *********[4] ICONST_0(Integer{0})
         // *********[5] ISTORE(4)
         // *********[6] GOTO(22)
        c_label = instructions[9];
      }
}
