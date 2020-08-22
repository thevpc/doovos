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
 * [count=2] [333] ALOAD(0) [334] LDC(89->"descriptor")
 */
public final class init_103 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R89 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[333] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[334] LDC(89->"descriptor")
        frame.push(R89);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[333] ALOAD(0)
         // *********[334] LDC(89->"descriptor")
        R89 = ((KReference)constants[89]);
        c_next = instructions[(index + 1)];
      }
}
