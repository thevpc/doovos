package jjit.local.jnt.Bench.SubmitDialog.getSysProp_Ljava_lang_String_Ljava_lang_String_D5737AC6;
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
 * getSysProp(Ljava/lang/String;)Ljava/lang/String;
 * [count=3] [3] ASTORE(2) [4] LDC(85->"N/A") [5] ARETURN
 */
public final class getSysProp_005 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R85 = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KFrame callerFrame = null;
         // **REMOVED Unused Var** KRegister reg;
        KLocalThread thread = frame.getThread();
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[3] ASTORE(2)
        frame.setLocal(2,frame.pop());
         // *********[4] LDC(85->"N/A")
         // **REMOVED Substitution** s0_ref = R85;
         // *********[5] ARETURN
         // **REMOVED Substitution** reg = R85;
        callerFrame = thread.popFrame();
        callerFrame.push(R85);
        return ((JJITInstruction)callerFrame.getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ASTORE(2)
         // *********[4] LDC(85->"N/A")
        R85 = ((KReference)constants[85]);
         // *********[5] ARETURN
      }
}
