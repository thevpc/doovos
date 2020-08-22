package jjit.local.jnt.Bench.SubmitDialog.addField_Ljava_lang_StringILjava_lang_String_Ljava_awt_TextComponent_DF5FE369;
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
 * addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;
 * [count=4] [18] POP [19] ILOAD(2) [20] ICONST_1(Integer{1}) [21] IF_ICMPNE(28)
 */
public final class addField_012 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[18] POP
        frame.pop();
         // *********[19] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[20] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[21] IF_ICMPNE(28)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = frame.getLocal(2).intValue() != 1;
        return ((frame.getLocal(2).intValue() != 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] POP
         // *********[19] ILOAD(2)
         // *********[20] ICONST_1(Integer{1})
         // *********[21] IF_ICMPNE(28)
        c_next = instructions[(index + 1)];
        c_label = instructions[16];
      }
}
