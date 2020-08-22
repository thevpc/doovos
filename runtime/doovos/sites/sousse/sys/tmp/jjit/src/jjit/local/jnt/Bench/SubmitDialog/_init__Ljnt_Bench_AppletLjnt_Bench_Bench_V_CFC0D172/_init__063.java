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
 * [count=12] [189] PUTFIELD(jnt.Bench.SubmitDialog,cancel) [190] ALOAD(0) [191] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [192] ICONST_0(Integer{0}) [193] PUTFIELD(java.awt.GridBagConstraints,gridwidth) [194] ALOAD(0) [195] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;) [196] ALOAD(0) [197] GETFIELD(jnt.Bench.SubmitDialog,cancel,Ljava/awt/Button;) [198] ALOAD(0) [199] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [200] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
 */
public final class _init__063 extends JJITAbstractInstruction implements Cloneable{
      private KField c_cancel = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private KField c_constraints = null;
      private KField c_gridwidth = null;
      private KField c_layout = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=4/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[189] PUTFIELD(jnt.Bench.SubmitDialog,cancel)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_cancel.setInstanceValue(frame.popRef(),reg);
         // *********[190] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[191] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s0_ref = c_constraints.getInstanceRef(this_ref);
         // *********[192] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[193] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        if(c_gridwidth == null){
          c_gridwidth = c_repo.getClassByName("java.awt.GridBagConstraints").getField("gridwidth",true);
        }
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = c_constraints.getInstanceRef(this_ref);
        c_gridwidth.setInstanceInt(c_constraints.getInstanceRef(this_ref),0);
         // *********[194] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[195] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
         // **REMOVED Substitution** s0_ref = c_layout.getInstanceRef(this_ref);
         // *********[196] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[197] GETFIELD(jnt.Bench.SubmitDialog,cancel,Ljava/awt/Button;)
         // **REMOVED Substitution** s1_ref = c_cancel.getInstanceRef(this_ref);
         // *********[198] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[199] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s2_ref = c_constraints.getInstanceRef(this_ref);
         // *********[200] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        regs = new KRegister[3];
        regs[2] = c_constraints.getInstanceRef(this_ref);
        regs[1] = c_cancel.getInstanceRef(this_ref);
        ref = c_layout.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(63);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[189] PUTFIELD(jnt.Bench.SubmitDialog,cancel)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_cancel = c_CSubmitDialog.getField("cancel",true);
         // *********[190] ALOAD(0)
         // *********[191] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
        c_constraints = c_CSubmitDialog.getField("constraints",true);
         // *********[192] ICONST_0(Integer{0})
         // *********[193] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        c_repo = process.getClassRepository();
         // *********[194] ALOAD(0)
         // *********[195] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
        c_layout = c_CSubmitDialog.getField("layout",true);
         // *********[196] ALOAD(0)
         // *********[197] GETFIELD(jnt.Bench.SubmitDialog,cancel,Ljava/awt/Button;)
         // *********[198] ALOAD(0)
         // *********[199] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // *********[200] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        c_memman = process.getMemoryManager();
      }
}
