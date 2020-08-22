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
 * [count=5] [18] ICONST_0(Integer{0}) [19] ISTORE(4) [20] ICONST_1(Integer{1}) [21] ISTORE(5) [22] GOTO(245)
 */
public final class transform_internal_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_4 4 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[18] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[19] ISTORE(4)
        frame.setLocal(4,KInteger.ZERO);
         // *********[20] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[21] ISTORE(5)
        frame.setLocal(5,KInteger.ONE);
         // *********[22] GOTO(245)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] ICONST_0(Integer{0})
         // *********[19] ISTORE(4)
         // *********[20] ICONST_1(Integer{1})
         // *********[21] ISTORE(5)
         // *********[22] GOTO(245)
        c_label = instructions[17];
      }
}
