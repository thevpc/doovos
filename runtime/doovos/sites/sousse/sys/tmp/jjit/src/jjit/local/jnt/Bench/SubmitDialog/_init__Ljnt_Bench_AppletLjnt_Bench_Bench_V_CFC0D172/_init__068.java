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
 * [count=2] [227] POP [228] ALOAD(0)
 */
public final class _init__068 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[227] POP
        frame.pop();
         // *********[228] ALOAD(0)
        frame.push(frame.getLocal(0));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[227] POP
         // *********[228] ALOAD(0)
        c_next = instructions[(index + 1)];
      }
}
