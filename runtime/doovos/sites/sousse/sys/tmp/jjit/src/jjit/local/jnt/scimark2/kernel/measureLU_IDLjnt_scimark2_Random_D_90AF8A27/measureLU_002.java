package jjit.local.jnt.scimark2.kernel.measureLU_IDLjnt_scimark2_Random_D_90AF8A27;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * measureLU(IDLjnt/scimark2/Random;)D
 * [count=3] [4] ASTORE(4) [5] ILOAD(0) [6] ILOAD(0)
 */
public final class measureLU_002 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_0 0 ; r=2/w=0 : Cached
        int local_0 = frame.getLocal(0).intValue();
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[4] ASTORE(4)
        frame.setLocal(4,frame.pop());
         // *********[5] ILOAD(0)
        frame.push(new KInteger(local_0));
         // *********[6] ILOAD(0)
        frame.push(new KInteger(local_0));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ASTORE(4)
         // *********[5] ILOAD(0)
         // *********[6] ILOAD(0)
        c_next = instructions[(index + 1)];
      }
}
