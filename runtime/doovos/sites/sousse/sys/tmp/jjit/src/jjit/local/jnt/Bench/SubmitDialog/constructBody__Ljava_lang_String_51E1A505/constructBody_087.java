package jjit.local.jnt.Bench.SubmitDialog.constructBody__Ljava_lang_String_51E1A505;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * constructBody()Ljava/lang/String;
 * [count=4] [185] ALOAD(0) [186] ALOAD(0) [187] GETFIELD(jnt.Bench.SubmitDialog,brand,Ljava/awt/TextComponent;) [188] INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
 */
public final class constructBody_087 extends JJITAbstractInstruction implements Cloneable{
      private KField c_brand = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[185] ALOAD(0)
        frame.push(this_ref);
         // *********[186] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[187] GETFIELD(jnt.Bench.SubmitDialog,brand,Ljava/awt/TextComponent;)
         // **REMOVED Substitution** s0_ref = c_brand.getInstanceRef(this_ref);
         // *********[188] INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = c_brand.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(87);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getText()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getText()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[185] ALOAD(0)
         // *********[186] ALOAD(0)
         // *********[187] GETFIELD(jnt.Bench.SubmitDialog,brand,Ljava/awt/TextComponent;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_brand = c_CSubmitDialog.getField("brand",true);
         // *********[188] INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
