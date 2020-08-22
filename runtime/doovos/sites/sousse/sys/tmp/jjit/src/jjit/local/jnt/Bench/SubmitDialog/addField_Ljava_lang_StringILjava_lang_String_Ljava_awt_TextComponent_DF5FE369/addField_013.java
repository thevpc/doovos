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
 * [count=3] [22] NEW(java.awt.TextField) [23] DUP [24] BIPUSH(40)
 */
public final class addField_013 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CTextField = null;
      private static final KInteger I40 = new KInteger(40);
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // *********[22] NEW(java.awt.TextField)
        if(c_CTextField == null){
          c_CTextField = c_repo.getClassByName("java.awt.TextField");
        }
        s0_ref = memseg.allocObject(c_CTextField);
         // *********[23] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[24] BIPUSH(40)
        frame.push(I40);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] NEW(java.awt.TextField)
        c_repo = process.getClassRepository();
         // *********[23] DUP
         // *********[24] BIPUSH(40)
        c_next = instructions[(index + 1)];
      }
}
