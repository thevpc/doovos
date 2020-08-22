package jjit.local.jnt.scimark2.kernel.RandomVector_ILjnt_scimark2_Random__D_4892868B;
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
 * RandomVector(ILjnt/scimark2/Random;)[D
 * [count=3] [12] ILOAD(3) [13] ILOAD(0) [14] IF_ICMPLT(6)
 */
public final class RandomVector_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[12] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[13] ILOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[14] IF_ICMPLT(6)
         // **REMOVED Substitution** index = frame.getLocal(0).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() < frame.getLocal(0).intValue();
        return ((frame.getLocal(3).intValue() < frame.getLocal(0).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[12] ILOAD(3)
         // *********[13] ILOAD(0)
         // *********[14] IF_ICMPLT(6)
        c_next = instructions[(index + 1)];
        c_label = instructions[1];
      }
}
