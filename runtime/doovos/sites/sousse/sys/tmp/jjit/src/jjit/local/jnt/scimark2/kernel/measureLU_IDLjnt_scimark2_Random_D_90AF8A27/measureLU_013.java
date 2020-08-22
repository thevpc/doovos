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
 * [count=2] [30] POP [31] IINC(9,1)
 */
public final class measureLU_013 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_9 9 ; r=1/w=1 : Cached
        int local_9 = frame.getLocal(9).intValue();
         // *********[30] POP
        frame.pop();
         // *********[31] IINC(9,1)
         // **REMOVED Substitution** local_9 = (local_9 + 1);
        frame.setLocal(9,new KInteger((local_9 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[30] POP
         // *********[31] IINC(9,1)
        c_next = instructions[(index + 1)];
      }
}
