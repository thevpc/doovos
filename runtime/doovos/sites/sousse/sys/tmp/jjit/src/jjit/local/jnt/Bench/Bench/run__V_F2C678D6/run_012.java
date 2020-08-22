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
 * [count=6] [21] ASTORE(4) [22] LDC(121->"Benchmark Aborted") [23] ASTORE(2) [24] ALOAD(4) [25] ASTORE(3) [26] GOTO(34)
 */
public final class run_012 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R121 = null;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // local_2 2 ; r=0/w=1 : NotCached
         // local_3 3 ; r=0/w=1 : NotCached
         // local_4 4 ; r=1/w=1 : Cached
        KRegister local_4;
         // *********[21] ASTORE(4)
        local_4 = frame.pop();
         // *********[22] LDC(121->"Benchmark Aborted")
         // **REMOVED Substitution** s0_ref = R121;
         // *********[23] ASTORE(2)
        frame.setLocal(2,R121);
         // *********[24] ALOAD(4)
         // **REMOVED Substitution** s0 = local_4;
         // *********[25] ASTORE(3)
        frame.setLocal(3,local_4);
         // *********[26] GOTO(34)
        frame.setLocal(4,local_4);
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[21] ASTORE(4)
         // *********[22] LDC(121->"Benchmark Aborted")
        R121 = ((KReference)constants[121]);
         // *********[23] ASTORE(2)
         // *********[24] ALOAD(4)
         // *********[25] ASTORE(3)
         // *********[26] GOTO(34)
        c_label = instructions[18];
      }
}
