package jjit.local.jnt.scimark2.kernel.RandomMatrix_IILjnt_scimark2_Random___D_FCF0B237;
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
 * RandomMatrix(IILjnt/scimark2/Random;)[[D
 * [count=3] [22] ILOAD(4) [23] ILOAD(1) [24] IF_ICMPLT(7)
 */
public final class RandomMatrix_010 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[22] ILOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[23] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[24] IF_ICMPLT(7)
         // **REMOVED Substitution** index = frame.getLocal(1).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(4).intValue() < frame.getLocal(1).intValue();
        return ((frame.getLocal(4).intValue() < frame.getLocal(1).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] ILOAD(4)
         // *********[23] ILOAD(1)
         // *********[24] IF_ICMPLT(7)
        c_next = instructions[(index + 1)];
        c_label = instructions[4];
      }
}
