package jjit.local.jnt.scimark2.Jacobi.SOR_D__DI_V_764DB604;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Jacobi
 * SOR(D[[DI)V
 * [count=3] [84] ILOAD(13) [85] ILOAD(10) [86] IF_ICMPLT(30)
 */
public final class SOR_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_10 10 ; r=1/w=0 : NotCached
         // local_13 13 ; r=1/w=0 : NotCached
         // *********[84] ILOAD(13)
         // **REMOVED Substitution** s0 = frame.getLocal(13);
         // *********[85] ILOAD(10)
         // **REMOVED Substitution** s1 = frame.getLocal(10);
         // *********[86] IF_ICMPLT(30)
         // **REMOVED Substitution** index = frame.getLocal(10).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(13).intValue() < frame.getLocal(10).intValue();
        return ((frame.getLocal(13).intValue() < frame.getLocal(10).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[84] ILOAD(13)
         // *********[85] ILOAD(10)
         // *********[86] IF_ICMPLT(30)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
