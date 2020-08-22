package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
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
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=2] [70] BIPUSH(40) [71] IF_ICMPEQ(11)
 */
public final class parseEntries_020 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // *********[70] BIPUSH(40)
         // **REMOVED Substitution** s0 = I40;
         // *********[71] IF_ICMPEQ(11)
         // **REMOVED Substitution** index = 40;
         // **REMOVED Substitution** jump = frame.popInt() == 40;
        return ((frame.popInt() == 40)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[70] BIPUSH(40)
         // *********[71] IF_ICMPEQ(11)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
