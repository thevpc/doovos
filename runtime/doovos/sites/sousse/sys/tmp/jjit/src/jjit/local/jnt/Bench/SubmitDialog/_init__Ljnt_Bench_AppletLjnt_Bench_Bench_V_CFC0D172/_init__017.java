package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=3] [29] ASTORE(3) [30] ALOAD(3) [31] IFNONNULL(39)
 */
public final class _init__017 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_3 3 ; r=1/w=1 : Cached
        KRegister local_3;
         // *********[29] ASTORE(3)
        local_3 = frame.pop();
         // *********[30] ALOAD(3)
         // **REMOVED Substitution** s0 = local_3;
         // *********[31] IFNONNULL(39)
        frame.setLocal(3,local_3);
        return ((((KReference)local_3).isNotNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[29] ASTORE(3)
         // *********[30] ALOAD(3)
         // *********[31] IFNONNULL(39)
        c_next = instructions[(index + 1)];
        c_label = instructions[21];
      }
}
