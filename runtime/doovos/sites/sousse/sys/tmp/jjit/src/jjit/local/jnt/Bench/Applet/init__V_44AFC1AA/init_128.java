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
 * [count=7] [374] ASTORE(9) [375] ALOAD(0) [376] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;) [377] ALOAD(9) [378] ICONST_0(Integer{0}) [379] AALOAD [380] INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
 */
public final class init_128 extends JJITAbstractInstruction implements Cloneable{
      private KField c_chooser = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
        KReference ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=1 : Cached
        KRegister local_9;
         // *********[374] ASTORE(9)
        local_9 = frame.pop();
         // *********[375] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[376] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
         // **REMOVED Substitution** s0_ref = c_chooser.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[377] ALOAD(9)
         // **REMOVED Substitution** s1 = local_9;
         // *********[378] ICONST_0(Integer{0})
         // **REMOVED Substitution** s2 = IZERO;
         // *********[379] AALOAD
         // **REMOVED Substitution** index = 0;
         // **REMOVED Substitution** ref = ((KReference)local_9);
         // **REMOVED Substitution** s1_ref = c_memman.getReferenceArray(((KReference)local_9),0);
         // *********[380] INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = c_memman.getReferenceArray(((KReference)local_9),0);
        ref = c_chooser.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(128);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("addItem(Ljava/lang/String;)V"),regs);
        frame.setLocal(9,local_9);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("addItem(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[374] ASTORE(9)
         // *********[375] ALOAD(0)
         // *********[376] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_chooser = c_CApplet.getField("chooser",true);
         // *********[377] ALOAD(9)
         // *********[378] ICONST_0(Integer{0})
         // *********[379] AALOAD
        c_memman = process.getMemoryManager();
         // *********[380] INVOKEVIRTUAL(java.awt.Choice,addItem(Ljava/lang/String;)V)
      }
}
