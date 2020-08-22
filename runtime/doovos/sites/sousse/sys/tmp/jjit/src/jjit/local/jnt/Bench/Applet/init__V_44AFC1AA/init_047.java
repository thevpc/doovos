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
 * [count=15] [108] PUTFIELD(jnt.Bench.Applet,centerPanel) [109] ALOAD(5) [110] ICONST_1(Integer{1}) [111] PUTFIELD(java.awt.GridBagConstraints,fill) [112] ALOAD(5) [113] ALOAD(5) [114] DCONST_1(Double{1.0}) [115] DUP2_X1Type2 [116] PUTFIELD(java.awt.GridBagConstraints,weighty) [117] PUTFIELD(java.awt.GridBagConstraints,weightx) [118] ALOAD(4) [119] ALOAD(0) [120] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;) [121] ALOAD(5) [122] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
 */
public final class init_047 extends JJITAbstractInstruction implements Cloneable{
      private KField c_centerPanel = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private KField c_fill = null;
      private static final KDouble DONE = KDouble.ONE;
      private KField c_weighty = null;
      private KField c_weightx = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        KReference ref;
        KRegister reg;
         // **REMOVED Unused Var** KRegister m_r;
         // **REMOVED Unused Var** KRegister m_r2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=4/w=0 : Cached
        KRegister local_5 = frame.getLocal(5);
         // *********[108] PUTFIELD(jnt.Bench.Applet,centerPanel)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_centerPanel.setInstanceValue(frame.popRef(),reg);
         // *********[109] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[110] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[111] PUTFIELD(java.awt.GridBagConstraints,fill)
        if(c_fill == null){
          c_fill = c_repo.getClassByName("java.awt.GridBagConstraints").getField("fill",true);
        }
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_fill.setInstanceInt(((KReference)local_5),1);
         // *********[112] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[113] ALOAD(5)
         // **REMOVED Substitution** s1 = local_5;
         // *********[114] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s2 = DONE;
         // *********[115] DUP2_X1Type2
         // **REMOVED Substitution** m_r = DONE;
         // **REMOVED Substitution** m_r2 = local_5;
         // **REMOVED Substitution** s1 = DONE;
         // **REMOVED Substitution** s2 = local_5;
         // **REMOVED Substitution** s3 = DONE;
         // *********[116] PUTFIELD(java.awt.GridBagConstraints,weighty)
        if(c_weighty == null){
          c_weighty = c_repo.getClassByName("java.awt.GridBagConstraints").getField("weighty",true);
        }
         // **REMOVED Substitution** reg = DONE;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_weighty.setInstanceValue(((KReference)local_5),DONE);
         // *********[117] PUTFIELD(java.awt.GridBagConstraints,weightx)
        if(c_weightx == null){
          c_weightx = c_repo.getClassByName("java.awt.GridBagConstraints").getField("weightx",true);
        }
         // **REMOVED Substitution** reg = DONE;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_weightx.setInstanceValue(((KReference)local_5),DONE);
         // *********[118] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[119] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[120] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
         // **REMOVED Substitution** s1_ref = c_centerPanel.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[121] ALOAD(5)
         // **REMOVED Substitution** s2 = local_5;
         // *********[122] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        regs = new KRegister[3];
        regs[2] = local_5;
        regs[1] = c_centerPanel.getInstanceRef(((KReference)frame.getLocal(0)));
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(47);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[108] PUTFIELD(jnt.Bench.Applet,centerPanel)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_centerPanel = c_CApplet.getField("centerPanel",true);
         // *********[109] ALOAD(5)
         // *********[110] ICONST_1(Integer{1})
         // *********[111] PUTFIELD(java.awt.GridBagConstraints,fill)
        c_repo = process.getClassRepository();
         // *********[112] ALOAD(5)
         // *********[113] ALOAD(5)
         // *********[114] DCONST_1(Double{1.0})
         // *********[115] DUP2_X1Type2
         // *********[116] PUTFIELD(java.awt.GridBagConstraints,weighty)
        c_repo = process.getClassRepository();
         // *********[117] PUTFIELD(java.awt.GridBagConstraints,weightx)
        c_repo = process.getClassRepository();
         // *********[118] ALOAD(4)
         // *********[119] ALOAD(0)
         // *********[120] GETFIELD(jnt.Bench.Applet,centerPanel,Ljava/awt/Panel;)
         // *********[121] ALOAD(5)
         // *********[122] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        c_memman = process.getMemoryManager();
      }
}
