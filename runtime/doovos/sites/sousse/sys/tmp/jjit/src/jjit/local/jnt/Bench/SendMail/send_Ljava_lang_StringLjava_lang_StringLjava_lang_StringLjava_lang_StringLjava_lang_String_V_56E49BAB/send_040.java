package jjit.local.jnt.Bench.SendMail.send_Ljava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_String_V_56E49BAB;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SendMail
 * send(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 * [count=4] [60] DUP [61] ISTORE(5) [62] ICONST_M1(Integer{-1}) [63] IF_ICMPNE(37)
 */
public final class send_040 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[60] DUP
         // **REMOVED Substitution** s0 = frame.peek();
         // *********[61] ISTORE(5)
        frame.setLocal(5,frame.peek());
         // *********[62] ICONST_M1(Integer{-1})
         // **REMOVED Substitution** s0 = IM1;
         // *********[63] IF_ICMPNE(37)
         // **REMOVED Substitution** index = -1;
         // **REMOVED Substitution** jump = frame.popInt() != -1;
        return ((frame.popInt() != -1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[60] DUP
         // *********[61] ISTORE(5)
         // *********[62] ICONST_M1(Integer{-1})
         // *********[63] IF_ICMPNE(37)
        c_next = instructions[(index + 1)];
        c_label = instructions[30];
      }
}
