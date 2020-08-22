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
 * [count=3] [0] NEW(java.awt.Label) [1] DUP [2] ALOAD(1)
 */
public final class addField_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CLabel = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
        KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] NEW(java.awt.Label)
        if(c_CLabel == null){
          c_CLabel = c_repo.getClassByName("java.awt.Label");
        }
        s0_ref = memseg.allocObject(c_CLabel);
         // *********[1] DUP
        frame.push(s0_ref);
        frame.push(s0_ref);
         // *********[2] ALOAD(1)
        frame.push(frame.getLocal(1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] NEW(java.awt.Label)
        c_repo = process.getClassRepository();
         // *********[1] DUP
         // *********[2] ALOAD(1)
        c_next = instructions[(index + 1)];
      }
}
