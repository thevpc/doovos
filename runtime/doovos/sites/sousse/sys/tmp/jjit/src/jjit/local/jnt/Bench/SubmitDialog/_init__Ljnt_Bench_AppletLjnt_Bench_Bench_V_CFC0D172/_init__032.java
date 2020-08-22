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
 * [count=22] [61] ALOAD(0) [62] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [63] DCONST_1(Double{1.0}) [64] PUTFIELD(java.awt.GridBagConstraints,weightx) [65] ALOAD(0) [66] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [67] DCONST_0(Double{0.0}) [68] PUTFIELD(java.awt.GridBagConstraints,weighty) [69] ALOAD(0) [70] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [71] ICONST_2(Integer{2}) [72] PUTFIELD(java.awt.GridBagConstraints,fill) [73] ALOAD(0) [74] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [75] ICONST_0(Integer{0}) [76] PUTFIELD(java.awt.GridBagConstraints,gridwidth) [77] ALOAD(0) [78] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;) [79] ALOAD(4) [80] ALOAD(0) [81] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [82] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
 */
public final class _init__032 extends JJITAbstractInstruction implements Cloneable{
      private KField c_constraints = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static final KDouble DONE = KDouble.ONE;
      private KField c_weightx = null;
      private static final KDouble DZERO = KDouble.ZERO;
      private KField c_weighty = null;
      private KField c_fill = null;
      private KField c_gridwidth = null;
      private KField c_layout = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=6/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[61] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[62] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s0_ref = c_constraints.getInstanceRef(this_ref);
         // *********[63] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s1 = DONE;
         // *********[64] PUTFIELD(java.awt.GridBagConstraints,weightx)
        if(c_weightx == null){
          c_weightx = c_repo.getClassByName("java.awt.GridBagConstraints").getField("weightx",true);
        }
         // **REMOVED Substitution** reg = DONE;
         // **REMOVED Substitution** ref = c_constraints.getInstanceRef(this_ref);
        c_weightx.setInstanceValue(c_constraints.getInstanceRef(this_ref),DONE);
         // *********[65] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[66] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s0_ref = c_constraints.getInstanceRef(this_ref);
         // *********[67] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[68] PUTFIELD(java.awt.GridBagConstraints,weighty)
        if(c_weighty == null){
          c_weighty = c_repo.getClassByName("java.awt.GridBagConstraints").getField("weighty",true);
        }
         // **REMOVED Substitution** reg = DZERO;
         // **REMOVED Substitution** ref = c_constraints.getInstanceRef(this_ref);
        c_weighty.setInstanceValue(c_constraints.getInstanceRef(this_ref),DZERO);
         // *********[69] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[70] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s0_ref = c_constraints.getInstanceRef(this_ref);
         // *********[71] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[72] PUTFIELD(java.awt.GridBagConstraints,fill)
        if(c_fill == null){
          c_fill = c_repo.getClassByName("java.awt.GridBagConstraints").getField("fill",true);
        }
         // **REMOVED Substitution** reg = ITWO;
         // **REMOVED Substitution** ref = c_constraints.getInstanceRef(this_ref);
        c_fill.setInstanceInt(c_constraints.getInstanceRef(this_ref),2);
         // *********[73] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[74] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s0_ref = c_constraints.getInstanceRef(this_ref);
         // *********[75] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[76] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        if(c_gridwidth == null){
          c_gridwidth = c_repo.getClassByName("java.awt.GridBagConstraints").getField("gridwidth",true);
        }
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = c_constraints.getInstanceRef(this_ref);
        c_gridwidth.setInstanceInt(c_constraints.getInstanceRef(this_ref),0);
         // *********[77] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[78] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
         // **REMOVED Substitution** s0_ref = c_layout.getInstanceRef(this_ref);
         // *********[79] ALOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[80] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[81] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s2_ref = c_constraints.getInstanceRef(this_ref);
         // *********[82] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        regs = new KRegister[3];
        regs[2] = c_constraints.getInstanceRef(this_ref);
        regs[1] = frame.getLocal(4);
        ref = c_layout.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(32);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[61] ALOAD(0)
         // *********[62] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_constraints = c_CSubmitDialog.getField("constraints",true);
         // *********[63] DCONST_1(Double{1.0})
         // *********[64] PUTFIELD(java.awt.GridBagConstraints,weightx)
        c_repo = process.getClassRepository();
         // *********[65] ALOAD(0)
         // *********[66] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // *********[67] DCONST_0(Double{0.0})
         // *********[68] PUTFIELD(java.awt.GridBagConstraints,weighty)
        c_repo = process.getClassRepository();
         // *********[69] ALOAD(0)
         // *********[70] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // *********[71] ICONST_2(Integer{2})
         // *********[72] PUTFIELD(java.awt.GridBagConstraints,fill)
        c_repo = process.getClassRepository();
         // *********[73] ALOAD(0)
         // *********[74] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // *********[75] ICONST_0(Integer{0})
         // *********[76] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        c_repo = process.getClassRepository();
         // *********[77] ALOAD(0)
         // *********[78] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
        c_layout = c_CSubmitDialog.getField("layout",true);
         // *********[79] ALOAD(4)
         // *********[80] ALOAD(0)
         // *********[81] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // *********[82] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        c_memman = process.getMemoryManager();
      }
}
