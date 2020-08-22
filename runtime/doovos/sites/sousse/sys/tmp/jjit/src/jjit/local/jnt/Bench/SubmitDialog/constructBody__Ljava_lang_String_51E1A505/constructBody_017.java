package jjit.local.jnt.Bench.SubmitDialog.constructBody__Ljava_lang_String_51E1A505;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * constructBody()Ljava/lang/String;
 * [count=3] [32] POP [33] ALOAD(2) [34] IFNULL(56)
 */
public final class constructBody_017 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[32] POP
        frame.pop();
         // *********[33] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[34] IFNULL(56)
        return ((((KReference)frame.getLocal(2)).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[32] POP
         // *********[33] ALOAD(2)
         // *********[34] IFNULL(56)
        c_next = instructions[(index + 1)];
        c_label = instructions[25];
      }
}
