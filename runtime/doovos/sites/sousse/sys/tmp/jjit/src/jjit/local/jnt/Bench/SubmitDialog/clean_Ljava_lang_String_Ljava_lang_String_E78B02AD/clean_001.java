package jjit.local.jnt.Bench.SubmitDialog.clean_Ljava_lang_String_Ljava_lang_String_E78B02AD;
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
 * clean(Ljava/lang/String;)Ljava/lang/String;
 * [count=3] [0] ALOAD(1) [1] BIPUSH(59) [2] BIPUSH(44)
 */
public final class clean_001 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I59 = new KInteger(59);
      private static final KInteger I44 = new KInteger(44);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[1] BIPUSH(59)
        frame.push(I59);
         // *********[2] BIPUSH(44)
        frame.push(I44);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(1)
         // *********[1] BIPUSH(59)
         // *********[2] BIPUSH(44)
        c_next = instructions[(index + 1)];
      }
}
