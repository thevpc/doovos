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
 * [count=2] [8] LDC(41->"") [9] ASTORE(1)
 */
public final class doSend_007 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R41 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // local_1 1 ; r=0/w=1 : NotCached
         // *********[8] LDC(41->"")
         // **REMOVED Substitution** s0_ref = R41;
         // *********[9] ASTORE(1)
        frame.setLocal(1,R41);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] LDC(41->"")
        R41 = ((KReference)constants[41]);
         // *********[9] ASTORE(1)
        c_next = instructions[(index + 1)];
      }
}
