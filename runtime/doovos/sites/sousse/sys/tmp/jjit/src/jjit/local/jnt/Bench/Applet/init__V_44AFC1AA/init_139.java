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
 * [count=3] [409] ALOAD(0) [410] GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;) [411] INVOKEVIRTUAL(java.awt.Component,disable()V)
 */
public final class init_139 extends JJITAbstractInstruction implements Cloneable{
      private KField c_executeButton = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[409] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[410] GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
         // **REMOVED Substitution** s0_ref = c_executeButton.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[411] INVOKEVIRTUAL(java.awt.Component,disable()V)
        regs = new KRegister[1];
        ref = c_executeButton.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(139);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("disable()V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("disable()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[409] ALOAD(0)
         // *********[410] GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_executeButton = c_CApplet.getField("executeButton",true);
         // *********[411] INVOKEVIRTUAL(java.awt.Component,disable()V)
        c_memman = process.getMemoryManager();
      }
}