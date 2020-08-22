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
 * [count=3] [67] ILOAD(15) [68] ILOAD(7) [69] IF_ICMPLT(58)
 */
public final class measureSparseMatmult_008 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_7 7 ; r=1/w=0 : NotCached
         // local_15 15 ; r=1/w=0 : NotCached
         // *********[67] ILOAD(15)
         // **REMOVED Substitution** s0 = frame.getLocal(15);
         // *********[68] ILOAD(7)
         // **REMOVED Substitution** s1 = frame.getLocal(7);
         // *********[69] IF_ICMPLT(58)
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(15).intValue() < frame.getLocal(7).intValue();
        return ((frame.getLocal(15).intValue() < frame.getLocal(7).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[67] ILOAD(15)
         // *********[68] ILOAD(7)
         // *********[69] IF_ICMPLT(58)
        c_next = instructions[(index + 1)];
        c_label = instructions[6];
      }
}
