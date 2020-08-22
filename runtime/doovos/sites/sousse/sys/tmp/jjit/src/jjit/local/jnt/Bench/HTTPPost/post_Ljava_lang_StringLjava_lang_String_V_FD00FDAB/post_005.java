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
 * [count=3] [7] ISTORE(3) [8] ILOAD(3) [9] IFGE(12)
 */
public final class post_005 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_3 3 ; r=1/w=1 : Cached
        int local_3;
         // *********[7] ISTORE(3)
        local_3 = frame.popInt();
         // *********[8] ILOAD(3)
         // **REMOVED Substitution** s0 = new KInteger(local_3);
         // *********[9] IFGE(12)
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** jump = local_3 >= 0;
        frame.setLocal(3,new KInteger(local_3));
        return ((local_3 >= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ISTORE(3)
         // *********[8] ILOAD(3)
         // *********[9] IFGE(12)
        c_next = instructions[(index + 1)];
        c_label = instructions[6];
      }
}
