package jjit.local.jnt.scimark2.FFT.log2_I_I_F037A9BF;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * log2(I)I
 * [count=3] [10] ILOAD(2) [11] ILOAD(0) [12] IF_ICMPLT(5)
 */
public final class log2_003 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[10] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[11] ILOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[12] IF_ICMPLT(5)
         // **REMOVED Substitution** index = frame.getLocal(0).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(2).intValue() < frame.getLocal(0).intValue();
        return ((frame.getLocal(2).intValue() < frame.getLocal(0).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[10] ILOAD(2)
         // *********[11] ILOAD(0)
         // *********[12] IF_ICMPLT(5)
        c_next = instructions[(index + 1)];
        c_label = instructions[1];
      }
}
