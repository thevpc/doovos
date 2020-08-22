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
 * [count=3] [81] ILOAD(3) [82] BIPUSH(41) [83] IF_ICMPEQ(95)
 */
public final class parseSegments_027 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[81] ILOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[82] BIPUSH(41)
         // **REMOVED Substitution** s1 = I41;
         // *********[83] IF_ICMPEQ(95)
         // **REMOVED Substitution** index = 41;
         // **REMOVED Substitution** jump = frame.getLocal(3).intValue() == 41;
        return ((frame.getLocal(3).intValue() == 41)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[81] ILOAD(3)
         // *********[82] BIPUSH(41)
         // *********[83] IF_ICMPEQ(95)
        c_next = instructions[(index + 1)];
        c_label = instructions[30];
      }
}
