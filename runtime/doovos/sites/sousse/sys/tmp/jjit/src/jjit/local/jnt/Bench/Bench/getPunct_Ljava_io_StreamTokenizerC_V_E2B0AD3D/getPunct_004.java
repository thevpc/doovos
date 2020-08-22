package jjit.local.jnt.Bench.Bench.getPunct_Ljava_io_StreamTokenizerC_V_E2B0AD3D;
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
 * getPunct(Ljava/io/StreamTokenizer;C)V
 * [count=2] [2] ILOAD(2) [3] IF_ICMPEQ(16)
 */
public final class getPunct_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[2] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[3] IF_ICMPEQ(16)
        index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** jump = frame.popInt() == index;
        return ((frame.popInt() == index)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ILOAD(2)
         // *********[3] IF_ICMPEQ(16)
        c_next = instructions[(index + 1)];
        c_label = instructions[11];
      }
}
