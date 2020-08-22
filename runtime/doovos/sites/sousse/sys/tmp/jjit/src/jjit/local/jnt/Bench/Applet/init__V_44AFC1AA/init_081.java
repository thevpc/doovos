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
 * [count=17] [223] ALOAD(5) [224] DCONST_1(Double{1.0}) [225] PUTFIELD(java.awt.GridBagConstraints,weightx) [226] ALOAD(5) [227] DCONST_0(Double{0.0}) [228] PUTFIELD(java.awt.GridBagConstraints,weighty) [229] ALOAD(5) [230] ICONST_2(Integer{2}) [231] PUTFIELD(java.awt.GridBagConstraints,fill) [232] ALOAD(5) [233] ICONST_1(Integer{1}) [234] PUTFIELD(java.awt.GridBagConstraints,gridwidth) [235] ALOAD(4) [236] ALOAD(0) [237] GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;) [238] ALOAD(5) [239] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
 */
public final class init_081 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble DONE = KDouble.ONE;
      private KField c_weightx = null;
      private KClassRepository c_repo;
      private static final KDouble DZERO = KDouble.ZERO;
      private KField c_weighty = null;
      private KField c_fill = null;
      private KField c_gridwidth = null;
      private KField c_executeButton = null;
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
         // local_5 5 ; r=5/w=0 : Cached
        KRegister local_5 = frame.getLocal(5);
         // *********[223] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[224] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s1 = DONE;
         // *********[225] PUTFIELD(java.awt.GridBagConstraints,weightx)
        if(c_weightx == null){
          c_weightx = c_repo.getClassByName("java.awt.GridBagConstraints").getField("weightx",true);
        }
         // **REMOVED Substitution** reg = DONE;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_weightx.setInstanceValue(((KReference)local_5),DONE);
         // *********[226] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[227] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[228] PUTFIELD(java.awt.GridBagConstraints,weighty)
        if(c_weighty == null){
          c_weighty = c_repo.getClassByName("java.awt.GridBagConstraints").getField("weighty",true);
        }
         // **REMOVED Substitution** reg = DZERO;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_weighty.setInstanceValue(((KReference)local_5),DZERO);
         // *********[229] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[230] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[231] PUTFIELD(java.awt.GridBagConstraints,fill)
        if(c_fill == null){
          c_fill = c_repo.getClassByName("java.awt.GridBagConstraints").getField("fill",true);
        }
         // **REMOVED Substitution** reg = ITWO;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_fill.setInstanceInt(((KReference)local_5),2);
         // *********[232] ALOAD(5)
         // **REMOVED Substitution** s0 = local_5;
         // *********[233] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[234] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        if(c_gridwidth == null){
          c_gridwidth = c_repo.getClassByName("java.awt.GridBagConstraints").getField("gridwidth",true);
        }
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = ((KReference)local_5);
        c_gridwidth.setInstanceInt(((KReference)local_5),1);
         // *********[235] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[236] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[237] GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
         // **REMOVED Substitution** s1_ref = c_executeButton.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[238] ALOAD(5)
         // **REMOVED Substitution** s2 = local_5;
         // *********[239] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        regs = new KRegister[3];
        regs[2] = local_5;
        regs[1] = c_executeButton.getInstanceRef(((KReference)frame.getLocal(0)));
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(81);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[223] ALOAD(5)
         // *********[224] DCONST_1(Double{1.0})
         // *********[225] PUTFIELD(java.awt.GridBagConstraints,weightx)
        c_repo = process.getClassRepository();
         // *********[226] ALOAD(5)
         // *********[227] DCONST_0(Double{0.0})
         // *********[228] PUTFIELD(java.awt.GridBagConstraints,weighty)
        c_repo = process.getClassRepository();
         // *********[229] ALOAD(5)
         // *********[230] ICONST_2(Integer{2})
         // *********[231] PUTFIELD(java.awt.GridBagConstraints,fill)
        c_repo = process.getClassRepository();
         // *********[232] ALOAD(5)
         // *********[233] ICONST_1(Integer{1})
         // *********[234] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        c_repo = process.getClassRepository();
         // *********[235] ALOAD(4)
         // *********[236] ALOAD(0)
         // *********[237] GETFIELD(jnt.Bench.Applet,executeButton,Ljava/awt/Button;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_executeButton = c_CApplet.getField("executeButton",true);
         // *********[238] ALOAD(5)
         // *********[239] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        c_memman = process.getMemoryManager();
      }
}
