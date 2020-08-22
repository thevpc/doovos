package jjit.local.jnt.Bench.Formatter.pad_CI_Ljava_lang_String_58D199A6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Formatter
 * pad(CI)Ljava/lang/String;
 * [count=2] [0] ILOAD(1) [1] IFGT(4)
 */
public final class pad_001 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] ILOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[1] IFGT(4)
         // **REMOVED Substitution** index = frame.getLocal(1).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(1).intValue() > 0;
        return ((frame.getLocal(1).intValue() > 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(1)
         // *********[1] IFGT(4)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
