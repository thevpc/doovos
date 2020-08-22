package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
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
 * format(DI)Ljava/lang/String;
 * [count=3] [44] POP [45] ILOAD(2) [46] IFLE(56)
 */
public final class format_017 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[44] POP
        frame.pop();
         // *********[45] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[46] IFLE(56)
         // **REMOVED Substitution** index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** jump = frame.getLocal(2).intValue() <= 0;
        return ((frame.getLocal(2).intValue() <= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[44] POP
         // *********[45] ILOAD(2)
         // *********[46] IFLE(56)
        c_next = instructions[(index + 1)];
        c_label = instructions[20];
      }
}
