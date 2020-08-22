package jjit.local.jnt.scimark2.FFT.log2_I_I_F037A9BF;
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
 * log2(I)I
 * [count=5] [0] ICONST_0(Integer{0}) [1] ISTORE(1) [2] ICONST_1(Integer{1}) [3] ISTORE(2) [4] GOTO(10)
 */
public final class log2_001 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=0/w=1 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[0] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[1] ISTORE(1)
        frame.setLocal(1,KInteger.ZERO);
         // *********[2] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[3] ISTORE(2)
        frame.setLocal(2,KInteger.ONE);
         // *********[4] GOTO(10)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ICONST_0(Integer{0})
         // *********[1] ISTORE(1)
         // *********[2] ICONST_1(Integer{1})
         // *********[3] ISTORE(2)
         // *********[4] GOTO(10)
        c_label = instructions[2];
      }
}
