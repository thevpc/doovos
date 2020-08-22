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
 * [count=2] [43] ILOAD(4) [44] IFLE(59)
 */
public final class parseEntries_011 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[43] ILOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[44] IFLE(59)
         // **REMOVED Substitution** index = frame.getLocal(4).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(4).intValue() <= 0;
        return ((frame.getLocal(4).intValue() <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[43] ILOAD(4)
         // *********[44] IFLE(59)
        c_next = instructions[(index + 1)];
        c_label = instructions[16];
      }
}
