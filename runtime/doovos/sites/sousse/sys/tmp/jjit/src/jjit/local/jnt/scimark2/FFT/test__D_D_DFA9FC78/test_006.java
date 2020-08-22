package jjit.local.jnt.scimark2.FFT.test__D_D_DFA9FC78;
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
 * test([D)D
 * [count=5] [16] DCONST_0(Double{0.0}) [17] DSTORE(3) [18] ICONST_0(Integer{0}) [19] ISTORE(5) [20] GOTO(36)
 */
public final class test_006 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble DZERO = KDouble.ZERO;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=0/w=1 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[16] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s0 = DZERO;
         // *********[17] DSTORE(3)
        frame.setLocal(3,DZERO);
         // *********[18] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[19] ISTORE(5)
        frame.setLocal(5,KInteger.ZERO);
         // *********[20] GOTO(36)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[16] DCONST_0(Double{0.0})
         // *********[17] DSTORE(3)
         // *********[18] ICONST_0(Integer{0})
         // *********[19] ISTORE(5)
         // *********[20] GOTO(36)
        c_label = instructions[7];
      }
}
