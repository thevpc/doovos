package jjit.local.jnt.Bench.SubmitDialog.constructBody__Ljava_lang_String_51E1A505;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * constructBody()Ljava/lang/String;
 * [count=3] [151] ALOAD(0) [152] ALOAD(0) [153] GETFIELD(jnt.Bench.SubmitDialog,user,Ljava/awt/TextComponent;)
 */
public final class constructBody_069 extends JJITAbstractInstruction implements Cloneable{
      private KField c_user = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[151] ALOAD(0)
        frame.push(this_ref);
         // *********[152] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[153] GETFIELD(jnt.Bench.SubmitDialog,user,Ljava/awt/TextComponent;)
        frame.push(c_user.getInstanceRef(this_ref));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[151] ALOAD(0)
         // *********[152] ALOAD(0)
         // *********[153] GETFIELD(jnt.Bench.SubmitDialog,user,Ljava/awt/TextComponent;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_user = c_CSubmitDialog.getField("user",true);
        c_next = instructions[(index + 1)];
      }
}
