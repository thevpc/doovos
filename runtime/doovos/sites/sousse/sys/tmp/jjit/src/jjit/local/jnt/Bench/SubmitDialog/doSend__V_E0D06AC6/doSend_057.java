package jjit.local.jnt.Bench.SubmitDialog.doSend__V_E0D06AC6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * doSend()V
 * [count=3] [77] ISTORE(4) [78] ILOAD(4) [79] IFLE(93)
 */
public final class doSend_057 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_4 4 ; r=1/w=1 : Cached
        int local_4;
         // *********[77] ISTORE(4)
        local_4 = frame.popInt();
         // *********[78] ILOAD(4)
         // **REMOVED Substitution** s0 = new KInteger(local_4);
         // *********[79] IFLE(93)
         // **REMOVED Substitution** index = local_4;
         // **REMOVED Substitution** jump = local_4 <= 0;
        frame.setLocal(4,new KInteger(local_4));
        return ((local_4 <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[77] ISTORE(4)
         // *********[78] ILOAD(4)
         // *********[79] IFLE(93)
        c_next = instructions[(index + 1)];
        c_label = instructions[66];
      }
}
