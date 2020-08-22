package jjit.local.jnt.Bench.Applet.init__V_44AFC1AA;
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
 * jnt.Bench.Applet
 * init()V
 * [count=4] [99] ALOAD(0) [100] ALOAD(0) [101] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;) [102] INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
 */
public final class init_043 extends JJITAbstractInstruction implements Cloneable{
      private KField c_chooser = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
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
         // *********[99] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[100] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[101] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
         // **REMOVED Substitution** s1_ref = c_chooser.getInstanceRef(this_ref);
         // *********[102] INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
        regs = new KRegister[2];
        regs[1] = c_chooser.getInstanceRef(this_ref);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        frame.setProgramCounter(43);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("add(Ljava/awt/Component;)Ljava/awt/Component;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(this_ref).getVirtualMethodBySignature("add(Ljava/awt/Component;)Ljava/awt/Component;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[99] ALOAD(0)
         // *********[100] ALOAD(0)
         // *********[101] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_chooser = c_CApplet.getField("chooser",true);
         // *********[102] INVOKEVIRTUAL(java.awt.Container,add(Ljava/awt/Component;)Ljava/awt/Component;)
        c_memman = process.getMemoryManager();
      }
}
