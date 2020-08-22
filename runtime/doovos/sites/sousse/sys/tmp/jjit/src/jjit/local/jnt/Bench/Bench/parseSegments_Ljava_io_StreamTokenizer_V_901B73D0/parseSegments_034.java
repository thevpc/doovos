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
 * [count=4] [106] DUP [107] ISTORE(3) [108] BIPUSH(41) [109] IF_ICMPNE(9)
 */
public final class parseSegments_034 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[106] DUP
         // **REMOVED Substitution** s0 = frame.peek();
         // *********[107] ISTORE(3)
        frame.setLocal(3,frame.peek());
         // *********[108] BIPUSH(41)
         // **REMOVED Substitution** s0 = I41;
         // *********[109] IF_ICMPNE(9)
         // **REMOVED Substitution** index = 41;
         // **REMOVED Substitution** jump = frame.popInt() != 41;
        return ((frame.popInt() != 41)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[106] DUP
         // *********[107] ISTORE(3)
         // *********[108] BIPUSH(41)
         // *********[109] IF_ICMPNE(9)
        c_next = instructions[(index + 1)];
        c_label = instructions[5];
      }
}
