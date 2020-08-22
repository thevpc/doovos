package jjit.local.jnt.scimark2.Random.nextDoubles__D_V_9D9925F2;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Random
 * nextDoubles([D)V
 * [count=2] [233] ILOAD(6) [234] IFGE(239)
 */
public final class nextDoubles_037 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[233] ILOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[234] IFGE(239)
         // **REMOVED Substitution** index = frame.getLocal(6).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(6).intValue() >= 0;
        return ((frame.getLocal(6).intValue() >= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[233] ILOAD(6)
         // *********[234] IFGE(239)
        c_next = instructions[(index + 1)];
        c_label = instructions[38];
      }
}
