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
 * [count=5] [277] PUTFIELD(jnt.Bench.Applet,submitButton) [278] ALOAD(0) [279] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;) [280] ALOAD(2) [281] INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
 */
public final class init_090 extends JJITAbstractInstruction implements Cloneable{
      private KField c_submitButton = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[277] PUTFIELD(jnt.Bench.Applet,submitButton)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_submitButton.setInstanceValue(frame.popRef(),reg);
         // *********[278] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[279] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
         // **REMOVED Substitution** s0_ref = c_submitButton.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[280] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[281] INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(2);
        ref = c_submitButton.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(90);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setForeground(Ljava/awt/Color;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setForeground(Ljava/awt/Color;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[277] PUTFIELD(jnt.Bench.Applet,submitButton)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_submitButton = c_CApplet.getField("submitButton",true);
         // *********[278] ALOAD(0)
         // *********[279] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
         // *********[280] ALOAD(2)
         // *********[281] INVOKEVIRTUAL(java.awt.Component,setForeground(Ljava/awt/Color;)V)
        c_memman = process.getMemoryManager();
      }
}
