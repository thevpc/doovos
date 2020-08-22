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
 * [count=4] [0] ALOAD(0) [1] ALOAD(0) [2] LDC(15->"BGCOLOR") [3] ALOAD(0)
 */
public final class init_001 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R15 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[0] ALOAD(0)
        frame.push(this_ref);
         // *********[1] ALOAD(0)
        frame.push(this_ref);
         // *********[2] LDC(15->"BGCOLOR")
        frame.push(R15);
         // *********[3] ALOAD(0)
        frame.push(this_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ALOAD(0)
         // *********[2] LDC(15->"BGCOLOR")
        R15 = ((KReference)constants[15]);
         // *********[3] ALOAD(0)
        c_next = instructions[(index + 1)];
      }
}
