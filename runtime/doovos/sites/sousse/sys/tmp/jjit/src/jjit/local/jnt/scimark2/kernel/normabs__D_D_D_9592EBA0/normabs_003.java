package jjit.local.jnt.scimark2.kernel.normabs__D_D_D_9592EBA0;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * normabs([D[D)D
 * [count=3] [20] ILOAD(5) [21] ILOAD(2) [22] IF_ICMPLT(8)
 */
public final class normabs_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[20] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[21] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[22] IF_ICMPLT(8)
         // **REMOVED Substitution** index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(5).intValue() < frame.getLocal(2).intValue();
        return ((frame.getLocal(5).intValue() < frame.getLocal(2).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[20] ILOAD(5)
         // *********[21] ILOAD(2)
         // *********[22] IF_ICMPLT(8)
        c_next = instructions[(index + 1)];
        c_label = instructions[1];
      }
}
