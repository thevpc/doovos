package jjit.local.jnt.Bench.Bench._init__Ljnt_Bench_AppletLjava_net_URL_V_716E43B8;
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
 * <init>(Ljnt/Bench/Applet;Ljava/net/URL;)V
 * [count=3] [0] ALOAD(0) [1] ALOAD(1) [2] ALOAD(2)
 */
public final class _init__001 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[1] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[2] ALOAD(2)
        frame.push(frame.getLocal(2));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ALOAD(1)
         // *********[2] ALOAD(2)
        c_next = instructions[(index + 1)];
      }
}
