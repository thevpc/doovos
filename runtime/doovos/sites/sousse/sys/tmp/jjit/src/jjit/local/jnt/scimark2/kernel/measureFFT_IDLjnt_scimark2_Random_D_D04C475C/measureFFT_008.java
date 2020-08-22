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
 * [count=3] [18] ICONST_0(Integer{0}) [19] ISTORE(9) [20] GOTO(26)
 */
public final class measureFFT_008 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_9 9 ; r=0/w=1 : NotCached
         // *********[18] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[19] ISTORE(9)
        frame.setLocal(9,KInteger.ZERO);
         // *********[20] GOTO(26)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] ICONST_0(Integer{0})
         // *********[19] ISTORE(9)
         // *********[20] GOTO(26)
        c_label = instructions[11];
      }
}
