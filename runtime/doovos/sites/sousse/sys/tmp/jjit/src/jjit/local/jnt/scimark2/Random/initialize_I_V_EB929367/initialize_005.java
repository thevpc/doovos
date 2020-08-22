package jjit.local.jnt.scimark2.Random.initialize_I_V_EB929367;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Random
 * initialize(I)V
 * [count=3] [64] ILOAD(7) [65] BIPUSH(17) [66] IF_ICMPLT(32)
 */
public final class initialize_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[64] ILOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[65] BIPUSH(17)
         // **REMOVED Substitution** s1 = I17;
         // *********[66] IF_ICMPLT(32)
         // **REMOVED Substitution** index = 17;
         // **REMOVED Substitution** jump = frame.getLocal(7).intValue() < 17;
        return ((frame.getLocal(7).intValue() < 17)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[64] ILOAD(7)
         // *********[65] BIPUSH(17)
         // *********[66] IF_ICMPLT(32)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
