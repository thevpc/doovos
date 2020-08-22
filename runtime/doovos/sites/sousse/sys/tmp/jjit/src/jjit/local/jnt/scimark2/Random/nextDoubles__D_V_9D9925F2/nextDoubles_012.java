package jjit.local.jnt.scimark2.Random.nextDoubles__D_V_9D9925F2;
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
 * nextDoubles([D)V
 * [count=3] [78] ILOAD(4) [79] ILOAD(2) [80] IF_ICMPLT(13)
 */
public final class nextDoubles_012 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[78] ILOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[79] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[80] IF_ICMPLT(13)
         // **REMOVED Substitution** index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(4).intValue() < frame.getLocal(2).intValue();
        return ((frame.getLocal(4).intValue() < frame.getLocal(2).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[78] ILOAD(4)
         // *********[79] ILOAD(2)
         // *********[80] IF_ICMPLT(13)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
