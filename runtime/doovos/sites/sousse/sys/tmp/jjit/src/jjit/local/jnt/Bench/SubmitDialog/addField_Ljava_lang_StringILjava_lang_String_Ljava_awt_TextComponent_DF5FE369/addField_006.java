package jjit.local.jnt.Bench.SubmitDialog.addField_Ljava_lang_StringILjava_lang_String_Ljava_awt_TextComponent_DF5FE369;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * addField(Ljava/lang/String;ILjava/lang/String;)Ljava/awt/TextComponent;
 * [count=6] [8] PUTFIELD(java.awt.GridBagConstraints,gridwidth) [9] ALOAD(0) [10] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;) [11] ALOAD(4) [12] ALOAD(0) [13] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
 */
public final class addField_006 extends JJITAbstractInstruction implements Cloneable{
      private KField c_gridwidth = null;
      private KClassRepository c_repo;
      private KField c_layout = null;
      private KClass c_CSubmitDialog = null;
      private KField c_constraints = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[8] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        if(c_gridwidth == null){
          c_gridwidth = c_repo.getClassByName("java.awt.GridBagConstraints").getField("gridwidth",true);
        }
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_gridwidth.setInstanceInt(frame.popRef(),reg.intValue());
         // *********[9] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[10] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
        frame.push(c_layout.getInstanceRef(this_ref));
         // *********[11] ALOAD(4)
        frame.push(frame.getLocal(4));
         // *********[12] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[13] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
        frame.push(c_constraints.getInstanceRef(this_ref));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] PUTFIELD(java.awt.GridBagConstraints,gridwidth)
        c_repo = process.getClassRepository();
         // *********[9] ALOAD(0)
         // *********[10] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_layout = c_CSubmitDialog.getField("layout",true);
         // *********[11] ALOAD(4)
         // *********[12] ALOAD(0)
         // *********[13] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
        c_constraints = c_CSubmitDialog.getField("constraints",true);
        c_next = instructions[(index + 1)];
      }
}
