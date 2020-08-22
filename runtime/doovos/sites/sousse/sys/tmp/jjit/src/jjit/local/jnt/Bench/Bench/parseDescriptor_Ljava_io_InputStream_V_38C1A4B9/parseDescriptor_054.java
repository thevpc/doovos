package jjit.local.jnt.Bench.Bench.parseDescriptor_Ljava_io_InputStream_V_38C1A4B9;
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
 * parseDescriptor(Ljava/io/InputStream;)V
 * [count=2] [130] BIPUSH(-3) [131] IF_ICMPEQ(26)
 */
public final class parseDescriptor_054 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // *********[130] BIPUSH(-3)
         // **REMOVED Substitution** s0 = IM3;
         // *********[131] IF_ICMPEQ(26)
         // **REMOVED Substitution** index = -3;
         // **REMOVED Substitution** jump = frame.popInt() == -3;
        return ((frame.popInt() == -3)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[130] BIPUSH(-3)
         // *********[131] IF_ICMPEQ(26)
        c_next = instructions[(index + 1)];
        c_label = instructions[10];
      }
}
