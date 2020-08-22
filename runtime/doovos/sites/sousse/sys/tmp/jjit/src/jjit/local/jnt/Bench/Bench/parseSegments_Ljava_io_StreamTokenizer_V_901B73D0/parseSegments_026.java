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
 * [count=4] [77] DUP [78] ISTORE(3) [79] BIPUSH(-3) [80] IF_ICMPEQ(38)
 */
public final class parseSegments_026 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=0/w=1 : NotCached
         // *********[77] DUP
         // **REMOVED Substitution** s0 = frame.peek();
         // *********[78] ISTORE(3)
        frame.setLocal(3,frame.peek());
         // *********[79] BIPUSH(-3)
         // **REMOVED Substitution** s0 = IM3;
         // *********[80] IF_ICMPEQ(38)
         // **REMOVED Substitution** index = -3;
         // **REMOVED Substitution** jump = frame.popInt() == -3;
        return ((frame.popInt() == -3)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[77] DUP
         // *********[78] ISTORE(3)
         // *********[79] BIPUSH(-3)
         // *********[80] IF_ICMPEQ(38)
        c_next = instructions[(index + 1)];
        c_label = instructions[11];
      }
}
