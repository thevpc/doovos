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
 * [count=2] [26] ASTORE(5) [27] GOTO(34)
 */
public final class addField_016 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // local_5 5 ; r=0/w=1 : NotCached
         // *********[26] ASTORE(5)
        frame.setLocal(5,frame.pop());
         // *********[27] GOTO(34)
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] ASTORE(5)
         // *********[27] GOTO(34)
        c_label = instructions[20];
      }
}
