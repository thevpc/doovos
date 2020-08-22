package jjit.local.jnt.scimark2.kernel.matvec___D_D_D_V_E007F59D;
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
 * matvec([[D[D[D)V
 * [count=3] [39] ILOAD(5) [40] ILOAD(3) [41] IF_ICMPLT(11)
 */
public final class matvec_006 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[39] ILOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[40] ILOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[41] IF_ICMPLT(11)
         // **REMOVED Substitution** index = frame.getLocal(3).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(5).intValue() < frame.getLocal(3).intValue();
        return ((frame.getLocal(5).intValue() < frame.getLocal(3).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] ILOAD(5)
         // *********[40] ILOAD(3)
         // *********[41] IF_ICMPLT(11)
        c_next = instructions[(index + 1)];
        c_label = instructions[1];
      }
}
