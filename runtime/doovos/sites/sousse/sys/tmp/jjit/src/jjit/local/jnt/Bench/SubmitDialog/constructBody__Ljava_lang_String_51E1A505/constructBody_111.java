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
 * [count=4] [236] ALOAD(0) [237] ALOAD(0) [238] GETFIELD(jnt.Bench.SubmitDialog,vm,Ljava/awt/TextComponent;) [239] INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
 */
public final class constructBody_111 extends JJITAbstractInstruction implements Cloneable{
      private KField c_vm = null;
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
         // *********[236] ALOAD(0)
        frame.push(this_ref);
         // *********[237] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[238] GETFIELD(jnt.Bench.SubmitDialog,vm,Ljava/awt/TextComponent;)
         // **REMOVED Substitution** s0_ref = c_vm.getInstanceRef(this_ref);
         // *********[239] INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = c_vm.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(111);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getText()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getText()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[236] ALOAD(0)
         // *********[237] ALOAD(0)
         // *********[238] GETFIELD(jnt.Bench.SubmitDialog,vm,Ljava/awt/TextComponent;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_vm = c_CSubmitDialog.getField("vm",true);
         // *********[239] INVOKEVIRTUAL(java.awt.TextComponent,getText()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
