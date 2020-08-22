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
 * [count=10] [67] ALOAD(5) [68] ICONST_2(Integer{2}) [69] PUTFIELD(java.awt.GridBagConstraints,fill) [70] ALOAD(5) [71] ICONST_0(Integer{0}) [72] PUTFIELD(java.awt.GridBagConstraints,gridwidth) [73] ALOAD(4) [74] ALOAD(6) [75] ALOAD(5) [76] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
 */
public final class init_035 extends JJITAbstractInstruction implements Cloneable{
      private KField c_fill = null;
      private KClassRepository c_repo;
      private KField c_gridwidth = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=3/w=0 : Cached
        KRegister local_5 = frame.getLocal(5);
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[67] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[68] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[69] PUTFIELD(java.awt.GridBagConstraints,fill)
        if(c_fill == null){
          c_fill = c_repo.getClassByName("java.awt.GridBagConstraints").getField("fill",true);
        }
         // **REMOVED Substitution** reg = ITWO;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_fill.setInstanceInt(((KReference)local_5),2);
         // *********[70] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[71] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[72] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        if(c_gridwidth == null){
          c_gridwidth = c_repo.getClassByName("java.awt.GridBagConstraints").getField("gridwidth",true);
        }
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_gridwidth.setInstanceInt(((KReference)local_5),0);
         // *********[73] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[74] ALOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[75] ALOAD(5)
         // **REMOVED Substitution** s2 = local_5;
         // *********[76] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        regs = new KRegister[3];
        regs[2] = local_5;
        regs[1] = frame.getLocal(6);
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(35);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[67] ALOAD(5)
         // *********[68] ICONST_2(Integer{2})
         // *********[69] PUTFIELD(java.awt.GridBagConstraints,fill)
        c_repo = process.getClassRepository();
         // *********[70] ALOAD(5)
         // *********[71] ICONST_0(Integer{0})
         // *********[72] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        c_repo = process.getClassRepository();
         // *********[73] ALOAD(4)
         // *********[74] ALOAD(6)
         // *********[75] ALOAD(5)
         // *********[76] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        c_memman = process.getMemoryManager();
      }
}
