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
 * [count=3] [45] ASTORE(5) [46] ALOAD(0) [47] ALOAD(4)
 */
public final class init_025 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[45] ASTORE(5)
        frame.setLocal(5,frame.pop());
         // *********[46] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[47] ALOAD(4)
        frame.push(frame.getLocal(4));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[45] ASTORE(5)
         // *********[46] ALOAD(0)
         // *********[47] ALOAD(4)
        c_next = instructions[(index + 1)];
      }
}
