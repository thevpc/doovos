package jjit.local.jnt.Bench.SubmitDialog.addField_Ljava_lang_StringILjava_lang_String_Ljava_awt_TextComponent_DF5FE369;
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
 * addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;
 * [count=10] [34] ALOAD(0) [35] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [36] ICONST_0(Integer{0}) [37] PUTFIELD(java.awt.GridBagConstraints,gridwidth) [38] ALOAD(0) [39] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;) [40] ALOAD(5) [41] ALOAD(0) [42] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [43] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
 */
public final class addField_021 extends JJITAbstractInstruction implements Cloneable{
      private KField c_constraints = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
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
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[34] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[35] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s0_ref = c_constraints.getInstanceRef(this_ref);
         // *********[36] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[37] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        if(c_gridwidth == null){
          c_gridwidth = c_repo.getClassByName("java.awt.GridBagConstraints").getField("gridwidth",true);
        }
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = c_constraints.getInstanceRef(this_ref);
        c_gridwidth.setInstanceInt(c_constraints.getInstanceRef(this_ref),0);
         // *********[38] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[39] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
         // **REMOVED Substitution** s0_ref = c_layout.getInstanceRef(this_ref);
         // *********[40] ALOAD(5)
         // **REMOVED Substitution** s1 = frame.getLocal(5);
         // *********[41] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[42] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // **REMOVED Substitution** s2_ref = c_constraints.getInstanceRef(this_ref);
         // *********[43] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        regs = new KRegister[3];
        regs[2] = c_constraints.getInstanceRef(this_ref);
        regs[1] = frame.getLocal(5);
        ref = c_layout.getInstanceRef(this_ref);
        regs[0] = ref;
        frame.setProgramCounter(21);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[34] ALOAD(0)
         // *********[35] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_constraints = c_CSubmitDialog.getField("constraints",true);
         // *********[36] ICONST_0(Integer{0})
         // *********[37] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        c_repo = process.getClassRepository();
         // *********[38] ALOAD(0)
         // *********[39] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
        c_layout = c_CSubmitDialog.getField("layout",true);
         // *********[40] ALOAD(5)
         // *********[41] ALOAD(0)
         // *********[42] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
         // *********[43] INVOKEVIRTUAL(java.awt.GridBagLayout,setConstraints(Ljava/awt/Component;Ljava/awt/GridBagConstraints;)V)
        c_memman = process.getMemoryManager();
      }
}
