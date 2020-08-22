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
 * [count=4] [4] ASTORE(4) [5] ALOAD(0) [6] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;) [7] ICONST_1(Integer{1})
 */
public final class addField_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_constraints = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static final KInteger IONE = KInteger.ONE;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[4] ASTORE(4)
        frame.setLocal(4,frame.pop());
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[6] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
        frame.push(c_constraints.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[7] ICONST_1(Integer{1})
        frame.push(IONE);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ASTORE(4)
         // *********[5] ALOAD(0)
         // *********[6] GETFIELD(jnt.Bench.SubmitDialog,constraints,Ljava/awt/GridBagConstraints;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_constraints = c_CSubmitDialog.getField("constraints",true);
         // *********[7] ICONST_1(Integer{1})
        c_next = instructions[(index + 1)];
      }
}
