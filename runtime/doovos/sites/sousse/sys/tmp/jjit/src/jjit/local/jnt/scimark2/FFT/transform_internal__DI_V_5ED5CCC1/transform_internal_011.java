package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * transform_internal([DI)V
 * [count=3] [121] ICONST_1(Integer{1}) [122] ISTORE(19) [123] GOTO(237)
 */
public final class transform_internal_011 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_19 19 ; r=0/w=1 : NotCached
         // *********[121] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[122] ISTORE(19)
        frame.setLocal(19,KInteger.ONE);
         // *********[123] GOTO(237)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[121] ICONST_1(Integer{1})
         // *********[122] ISTORE(19)
         // *********[123] GOTO(237)
        c_label = instructions[15];
      }
}
