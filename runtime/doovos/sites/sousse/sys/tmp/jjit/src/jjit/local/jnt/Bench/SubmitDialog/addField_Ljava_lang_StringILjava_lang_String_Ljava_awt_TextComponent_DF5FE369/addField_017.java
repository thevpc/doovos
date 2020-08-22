package jjit.local.jnt.Bench.SubmitDialog.addField_Ljava_lang_StringILjava_lang_String_Ljava_awt_TextComponent_DF5FE369;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;
 * [count=4] [28] NEW(java.awt.TextArea) [29] DUP [30] ILOAD(2) [31] BIPUSH(40)
 */
public final class addField_017 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CTextArea = null;
      private static final KInteger I40 = new KInteger(40);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[28] NEW(java.awt.TextArea)
        if(c_CTextArea == null){
          c_CTextArea = c_repo.getClassByName("java.awt.TextArea");
        }
        s0_ref = memseg.allocObject(c_CTextArea);
         // *********[29] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[30] ILOAD(2)
        frame.push(frame.getLocal(2));
         // *********[31] BIPUSH(40)
        frame.push(I40);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[28] NEW(java.awt.TextArea)
        c_repo = process.getClassRepository();
         // *********[29] DUP
         // *********[30] ILOAD(2)
         // *********[31] BIPUSH(40)
        c_next = instructions[(index + 1)];
      }
}
