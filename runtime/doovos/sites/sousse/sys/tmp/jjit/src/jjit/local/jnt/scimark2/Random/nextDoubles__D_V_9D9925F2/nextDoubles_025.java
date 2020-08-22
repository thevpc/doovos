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
 * [count=3] [147] ILOAD(3) [148] ISTORE(5) [149] GOTO(389)
 */
public final class nextDoubles_025 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=1/w=0 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[147] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[148] ISTORE(5)
        frame.setLocal(5,frame.getLocal(3));
         // *********[149] GOTO(389)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[147] ILOAD(3)
         // *********[148] ISTORE(5)
         // *********[149] GOTO(389)
        c_label = instructions[58];
      }
}
