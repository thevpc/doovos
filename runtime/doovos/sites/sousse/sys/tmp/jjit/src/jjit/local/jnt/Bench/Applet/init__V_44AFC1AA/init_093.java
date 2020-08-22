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
 * [count=8] [289] ALOAD(5) [290] ICONST_0(Integer{0}) [291] PUTFIELD(java.awt.GridBagConstraints,gridwidth) [292] ALOAD(4) [293] ALOAD(0) [294] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;) [295] ALOAD(5) [296] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
 */
public final class init_093 extends JJITAbstractInstruction implements Cloneable{
      private KField c_gridwidth = null;
      private KClassRepository c_repo;
      private KField c_submitButton = null;
      private KClass c_CApplet = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=2/w=0 : Cached
        KRegister local_5 = frame.getLocal(5);
         // *********[289] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[290] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[291] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        if(c_gridwidth == null){
          c_gridwidth = c_repo.getClassByName("java.awt.GridBagConstraints").getField("gridwidth",true);
        }
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_gridwidth.setInstanceInt(((KReference)local_5),0);
         // *********[292] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[293] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[294] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
         // **REMOVED Substitution** s1_ref = c_submitButton.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[295] ALOAD(5)
         // **REMOVED Substitution** s2 = local_5;
         // *********[296] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        regs = new KRegister[3];
        regs[2] = local_5;
        regs[1] = c_submitButton.getInstanceRef(((KReference)frame.getLocal(0)));
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(93);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[289] ALOAD(5)
         // *********[290] ICONST_0(Integer{0})
         // *********[291] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        c_repo = process.getClassRepository();
         // *********[292] ALOAD(4)
         // *********[293] ALOAD(0)
         // *********[294] GETFIELD(jnt.Bench.Applet,submitButton,Ljava/awt/Button;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_submitButton = c_CApplet.getField("submitButton",true);
         // *********[295] ALOAD(5)
         // *********[296] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        c_memman = process.getMemoryManager();
      }
}
