package jjit.local.jnt.scimark2.LU.solve___D_I_D_V_710E1D67;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * solve([[D[I[D)V
 * [count=3] [45] ILOAD(10) [46] ILOAD(6) [47] IF_ICMPLT(32)
 */
public final class solve_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_6 6 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=0 : NotCached
         // *********[45] ILOAD(10)
         // **REMOVED Substitution** s0 = frame.getLocal(10);
         // *********[46] ILOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[47] IF_ICMPLT(32)
         // **REMOVED Substitution** index = frame.getLocal(6).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(10).intValue() < frame.getLocal(6).intValue();
        return ((frame.getLocal(10).intValue() < frame.getLocal(6).intValue())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[45] ILOAD(10)
         // *********[46] ILOAD(6)
         // *********[47] IF_ICMPLT(32)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
