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
 * [count=3] [38] ISTORE(3) [39] ILOAD(3) [40] IFLT(71)
 */
public final class doDisplay_018 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=1 : Cached
        int local_3;
         // *********[38] ISTORE(3)
        local_3 = frame.popInt();
         // *********[39] ILOAD(3)
         // **REMOVED Substitution** s0 = new KInteger(local_3);
         // *********[40] IFLT(71)
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** jump = local_3 < 0;
        frame.setLocal(3,new KInteger(local_3));
        return ((local_3 < 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[38] ISTORE(3)
         // *********[39] ILOAD(3)
         // *********[40] IFLT(71)
        c_next = instructions[(index + 1)];
        c_label = instructions[31];
      }
}
