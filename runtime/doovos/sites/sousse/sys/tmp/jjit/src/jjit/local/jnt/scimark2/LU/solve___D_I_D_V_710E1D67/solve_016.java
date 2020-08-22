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
 * [count=2] [104] ILOAD(7) [105] IFGE(68)
 */
public final class solve_016 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[104] ILOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[105] IFGE(68)
         // **REMOVED Substitution** index = frame.getLocal(7).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(7).intValue() >= 0;
        return ((frame.getLocal(7).intValue() >= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[104] ILOAD(7)
         // *********[105] IFGE(68)
        c_next = instructions[(index + 1)];
        c_label = instructions[11];
      }
}
