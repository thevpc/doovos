package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
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
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=3] [71] ILOAD(12) [72] ILOAD(0) [73] IF_ICMPLT(34)
 */
public final class measureSparseMatmult_010 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_12 12 ; r=1/w=0 : NotCached
         // *********[71] ILOAD(12)
         // **REMOVED Substitution** s0 = frame.getLocal(12);
         // *********[72] ILOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[73] IF_ICMPLT(34)
         // **REMOVED Substitution** index = frame.getLocal(0).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(12).intValue() < frame.getLocal(0).intValue();
        return ((frame.getLocal(12).intValue() < frame.getLocal(0).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[71] ILOAD(12)
         // *********[72] ILOAD(0)
         // *********[73] IF_ICMPLT(34)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
