package jjit.local.jnt.Bench.Formatter.format_DI_Ljava_lang_String_59D5BD5C;
import java.lang.Math;
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
 * [count=4] [0] ILOAD(2) [1] INVOKE_HOST(java.lang.Math.abs(I)I) [2] BIPUSH(15) [3] IF_ICMPLE(7)
 */
public final class format_001 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** int m_v;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[0] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[1] INVOKE_HOST(java.lang.Math.abs(I)I)
         // **REMOVED Substitution** m_v = frame.getLocal(2).intValue();
         // **REMOVED Substitution** s0 = new KInteger(Math.abs(frame.getLocal(2).intValue()));
         // *********[2] BIPUSH(15)
         // **REMOVED Substitution** s1 = I15;
         // *********[3] IF_ICMPLE(7)
         // **REMOVED Substitution** index = 15;
         // **REMOVED Substitution** jump = Math.abs(frame.getLocal(2).intValue()) <= 15;
        return ((Math.abs(frame.getLocal(2).intValue()) <= 15)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(2)
         // *********[1] INVOKE_HOST(java.lang.Math.abs(I)I)
         // *********[2] BIPUSH(15)
         // *********[3] IF_ICMPLE(7)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
