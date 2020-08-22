package jjit.local.jnt.Bench.Bench.run__V_F2C678D6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * run()V
 * [count=2] [42] ALOAD(3) [43] IFNULL(46)
 */
public final class run_023 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[42] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[43] IFNULL(46)
        return ((((KReference)frame.getLocal(3)).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[42] ALOAD(3)
         // *********[43] IFNULL(46)
        c_next = instructions[(index + 1)];
        c_label = instructions[24];
      }
}
