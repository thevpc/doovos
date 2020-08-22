package jjit.local.jnt.Bench.SubmitDialog.handleEvent_Ljava_awt_Event_Z_5C460024;
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
 * handleEvent(Ljava/awt/Event;)Z
 * [count=5] [20] ALOAD(1) [21] GETFIELD(java.awt.Event,target,Ljava/lang/Object;) [22] ALOAD(0) [23] GETFIELD(jnt.Bench.SubmitDialog,submit,Ljava/awt/Button;) [24] IF_ACMPNE(28)
 */
public final class handleEvent_009 extends JJITAbstractInstruction implements Cloneable{
      private KField c_target = null;
      private KClassRepository c_repo;
      private KField c_submit = null;
      private KClass c_CSubmitDialog = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KReference ref;
        KReference ref2;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[20] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[21] GETFIELD(java.awt.Event,target,Ljava/lang/Object;)
        if(c_target == null){
          c_target = c_repo.getClassByName("java.awt.Event").getField("target",true);
        }
         // **REMOVED Substitution** s0 = c_target.getInstanceValue(((KReference)frame.getLocal(1)));
         // *********[22] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[23] GETFIELD(jnt.Bench.SubmitDialog,submit,Ljava/awt/Button;)
         // **REMOVED Substitution** s1_ref = c_submit.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[24] IF_ACMPNE(28)
        ref = c_submit.getInstanceRef(((KReference)frame.getLocal(0)));
        ref2 = ((KReference)c_target.getInstanceValue(((KReference)frame.getLocal(1))));
         // **REMOVED Substitution** jump = ref.pointer != ref2.pointer || ref.segment != ref2.segment;
        return ((ref.pointer != ref2.pointer || ref.segment != ref2.segment)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[20] ALOAD(1)
         // *********[21] GETFIELD(java.awt.Event,target,Ljava/lang/Object;)
        c_repo = process.getClassRepository();
         // *********[22] ALOAD(0)
         // *********[23] GETFIELD(jnt.Bench.SubmitDialog,submit,Ljava/awt/Button;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_submit = c_CSubmitDialog.getField("submit",true);
         // *********[24] IF_ACMPNE(28)
        c_next = instructions[(index + 1)];
        c_label = instructions[11];
      }
}
