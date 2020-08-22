package jjit.local.jnt.Bench.Bench.doExecution__V_C25B2F44;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * doExecution()V
 * [count=3] [55] ICONST_0(Integer{0}) [56] ISTORE(4) [57] GOTO(68)
 */
public final class doExecution_021 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[55] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[56] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[57] GOTO(68)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[55] ICONST_0(Integer{0})
         // *********[56] ISTORE(4)
         // *********[57] GOTO(68)
        c_label = instructions[23];
      }
}
