package jjit.local.jnt.scimark2.MonteCarlo.integrate_I_D_98DBB769;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.MonteCarlo
 * integrate(I)D
 * [count=6] [4] ASTORE(1) [5] ICONST_0(Integer{0}) [6] ISTORE(2) [7] ICONST_0(Integer{0}) [8] ISTORE(3) [9] GOTO(28)
 */
public final class integrate_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=0/w=1 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[4] ASTORE(1)
        frame.setLocal(1,frame.pop());
         // *********[5] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[6] ISTORE(2)
        frame.setLocal(2,KInteger.ZERO);
         // *********[7] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[8] ISTORE(3)
        frame.setLocal(3,KInteger.ZERO);
         // *********[9] GOTO(28)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ASTORE(1)
         // *********[5] ICONST_0(Integer{0})
         // *********[6] ISTORE(2)
         // *********[7] ICONST_0(Integer{0})
         // *********[8] ISTORE(3)
         // *********[9] GOTO(28)
        c_label = instructions[9];
      }
}
