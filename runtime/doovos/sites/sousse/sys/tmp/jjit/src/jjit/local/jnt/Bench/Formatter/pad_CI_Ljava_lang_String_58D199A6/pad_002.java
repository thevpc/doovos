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
 * [count=2] [2] LDC(2->"") [3] ARETURN
 */
public final class pad_002 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R2 = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // *********[2] LDC(2->"")
         // **REMOVED Substitution** s0_ref = R2;
         // *********[3] ARETURN
         // **REMOVED Substitution** reg = R2;
        callerFrame = thread.popFrame();
        callerFrame.push(R2);
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] LDC(2->"")
        R2 = ((KReference)constants[2]);
         // *********[3] ARETURN
      }
}
