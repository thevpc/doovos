package jjit.local.jnt.scimark2.SparseCompRow.matmult__D_D_I_I_DI_V_7050E244;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.SparseCompRow
 * matmult([D[D[I[I[DI)V
 * [count=3] [47] ILOAD(8) [48] ILOAD(6) [49] IF_ICMPLT(11)
 */
public final class matmult_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_6 6 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // *********[47] ILOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[48] ILOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[49] IF_ICMPLT(11)
         // **REMOVED Substitution** index = frame.getLocal(6).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(8).intValue() < frame.getLocal(6).intValue();
        return ((frame.getLocal(8).intValue() < frame.getLocal(6).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[47] ILOAD(8)
         // *********[48] ILOAD(6)
         // *********[49] IF_ICMPLT(11)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
