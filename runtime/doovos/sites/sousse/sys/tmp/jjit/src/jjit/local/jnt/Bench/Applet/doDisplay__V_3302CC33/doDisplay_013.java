package jjit.local.jnt.Bench.Applet.doDisplay__V_3302CC33;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * doDisplay()V
 * [count=4] [20] ASTORE(1) [21] ICONST_0(Integer{0}) [22] ISTORE(2) [23] GOTO(31)
 */
public final class doDisplay_013 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_1 1 ; r=0/w=1 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[20] ASTORE(1)
        frame.setLocal(1,frame.pop());
         // *********[21] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[22] ISTORE(2)
        frame.setLocal(2,KInteger.ZERO);
         // *********[23] GOTO(31)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[20] ASTORE(1)
         // *********[21] ICONST_0(Integer{0})
         // *********[22] ISTORE(2)
         // *********[23] GOTO(31)
        c_label = instructions[15];
      }
}
