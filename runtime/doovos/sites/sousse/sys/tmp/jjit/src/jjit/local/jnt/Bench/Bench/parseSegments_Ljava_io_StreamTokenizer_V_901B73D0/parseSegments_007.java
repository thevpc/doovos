package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=3] [22] ILOAD(3) [23] BIPUSH(34) [24] IF_ICMPNE(29)
 */
public final class parseSegments_007 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[22] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[23] BIPUSH(34)
         // **REMOVED Substitution** s1 = I34;
         // *********[24] IF_ICMPNE(29)
         // **REMOVED Substitution** index = 34;
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() != 34;
        return ((frame.getLocal(3).intValue() != 34)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] ILOAD(3)
         // *********[23] BIPUSH(34)
         // *********[24] IF_ICMPNE(29)
        c_next = instructions[(index + 1)];
        c_label = instructions[8];
      }
}
