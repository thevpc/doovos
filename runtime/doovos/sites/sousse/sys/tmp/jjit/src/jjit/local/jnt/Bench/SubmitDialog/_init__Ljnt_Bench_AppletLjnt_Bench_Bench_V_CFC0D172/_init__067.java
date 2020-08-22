package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
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
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=4] [223] ALOAD(0) [224] ALOAD(0) [225] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;) [226] INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
 */
public final class _init__067 extends JJITAbstractInstruction implements Cloneable{
      private KField c_status = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[223] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[224] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[225] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;)
         // **REMOVED Substitution** s1_ref = c_status.getInstanceRef(this_ref);
         // *********[226] INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
        regs = new KRegister[2];
        regs[1] = c_status.getInstanceRef(this_ref);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(67);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("add(Ljava/awt/Component;)Ljava/awt/Component;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("add(Ljava/awt/Component;)Ljava/awt/Component;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[223] ALOAD(0)
         // *********[224] ALOAD(0)
         // *********[225] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_status = c_CSubmitDialog.getField("status",true);
         // *********[226] INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
        c_memman = process.getMemoryManager();
      }
}
