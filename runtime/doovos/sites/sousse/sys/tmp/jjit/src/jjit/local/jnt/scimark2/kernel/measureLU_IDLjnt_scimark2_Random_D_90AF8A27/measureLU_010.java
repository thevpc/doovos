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
 * [count=3] [21] ICONST_0(Integer{0}) [22] ISTORE(9) [23] GOTO(32)
 */
public final class measureLU_010 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_9 9 ; r=0/w=1 : NotCached
         // *********[21] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[22] ISTORE(9)
        frame.setLocal(9,KInteger.ZERO);
         // *********[23] GOTO(32)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] ICONST_0(Integer{0})
         // *********[22] ISTORE(9)
         // *********[23] GOTO(32)
        c_label = instructions[13];
      }
}
