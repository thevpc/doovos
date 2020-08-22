package jjit.local.jnt.Bench.AppletFrame._init__Ljava_lang_String_V_B2053D6E;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.AppletFrame
 * <init>(Ljava/lang/String;)V
 * [count=2] [0] ALOAD(0) [1] LDC(0->"BenchMarker")
 */
public final class _init__001 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R0 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[1] LDC(0->"BenchMarker")
        frame.push(R0);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] LDC(0->"BenchMarker")
        R0 = ((KReference)constants[0]);
        c_next = instructions[(index + 1)];
      }
}
