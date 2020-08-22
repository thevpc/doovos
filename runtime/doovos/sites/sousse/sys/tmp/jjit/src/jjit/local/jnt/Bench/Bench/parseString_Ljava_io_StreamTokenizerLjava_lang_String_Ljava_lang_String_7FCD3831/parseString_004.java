package jjit.local.jnt.Bench.Bench.parseString_Ljava_io_StreamTokenizerLjava_lang_String_Ljava_lang_String_7FCD3831;
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
 * parseString(Ljava/io/StreamTokenizer;Ljava/lang/String;)Ljava/lang/String;
 * [count=2] [2] BIPUSH(34) [3] IF_ICMPEQ(13)
 */
public final class parseString_004 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // *********[2] BIPUSH(34)
         // **REMOVED Substitution** s0 = I34;
         // *********[3] IF_ICMPEQ(13)
         // **REMOVED Substitution** index = 34;
         // **REMOVED Substitution** jump = frame.popInt() == 34;
        return ((frame.popInt() == 34)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] BIPUSH(34)
         // *********[3] IF_ICMPEQ(13)
        c_next = instructions[(index + 1)];
        c_label = instructions[6];
      }
}
