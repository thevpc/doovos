package jjit.local.jnt.Bench.HTTPPost.post_Ljava_lang_StringLjava_lang_String_V_FD00FDAB;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.HTTPPost
 * post(Ljava/lang/String;Ljava/lang/String;)V
 * [count=4] [81] ISTORE(10) [82] ILOAD(10) [83] BIPUSH(100) [84] IF_ICMPEQ(90)
 */
public final class post_043 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_10 10 ; r=1/w=1 : Cached
        int local_10;
         // *********[81] ISTORE(10)
        local_10 = frame.popInt();
         // *********[82] ILOAD(10)
         // **REMOVED Substitution** s0 = new KInteger(local_10);
         // *********[83] BIPUSH(100)
         // **REMOVED Substitution** s1 = I100;
         // *********[84] IF_ICMPEQ(90)
         // **REMOVED Substitution** index = 100;
         // **REMOVED Substitution** jump = local_10 == 100;
        frame.setLocal(10,new KInteger(local_10));
        return ((local_10 == 100)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[81] ISTORE(10)
         // *********[82] ILOAD(10)
         // *********[83] BIPUSH(100)
         // *********[84] IF_ICMPEQ(90)
        c_next = instructions[(index + 1)];
        c_label = instructions[47];
      }
}
