package jjit.local.jnt.scimark2.kernel.measureLU_IDLjnt_scimark2_Random_D_90AF8A27;
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
 * measureLU(IDLjnt/scimark2/Random;)D
 * [count=3] [32] ILOAD(9) [33] ILOAD(8) [34] IF_ICMPLT(24)
 */
public final class measureLU_014 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // *********[32] ILOAD(9)
         // **REMOVED Substitution** s0 = frame.getLocal(9);
         // *********[33] ILOAD(8)
         // **REMOVED Substitution** s1 = frame.getLocal(8);
         // *********[34] IF_ICMPLT(24)
         // **REMOVED Substitution** index = frame.getLocal(8).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(9).intValue() < frame.getLocal(8).intValue();
        return ((frame.getLocal(9).intValue() < frame.getLocal(8).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[32] ILOAD(9)
         // *********[33] ILOAD(8)
         // *********[34] IF_ICMPLT(24)
        c_next = instructions[(index + 1)];
        c_label = instructions[10];
      }
}
