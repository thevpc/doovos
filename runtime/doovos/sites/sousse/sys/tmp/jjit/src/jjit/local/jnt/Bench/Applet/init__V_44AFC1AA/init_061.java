package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Applet
 * init()V
 * [count=3] [158] POP [159] ALOAD(0) [160] LDC(63->"PLOTTER_BGCOLOR")
 */
public final class init_061 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R63 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[158] POP
        frame.pop();
         // *********[159] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[160] LDC(63->"PLOTTER_BGCOLOR")
        frame.push(R63);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[158] POP
         // *********[159] ALOAD(0)
         // *********[160] LDC(63->"PLOTTER_BGCOLOR")
        R63 = ((KReference)constants[63]);
        c_next = instructions[(index + 1)];
      }
}
