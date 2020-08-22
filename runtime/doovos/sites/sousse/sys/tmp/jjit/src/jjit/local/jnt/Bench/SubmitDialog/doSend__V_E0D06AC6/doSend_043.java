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
 * [count=2] [61] ALOAD(3) [62] IFNULL(97)
 */
public final class doSend_043 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[61] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[62] IFNULL(97)
        return ((((KReference)frame.getLocal(3)).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[61] ALOAD(3)
         // *********[62] IFNULL(97)
        c_next = instructions[(index + 1)];
        c_label = instructions[69];
      }
}
