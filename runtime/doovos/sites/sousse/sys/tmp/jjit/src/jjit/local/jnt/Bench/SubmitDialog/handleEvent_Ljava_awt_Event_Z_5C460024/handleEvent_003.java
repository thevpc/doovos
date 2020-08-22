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
 * [count=3] [1] GETFIELD(java.awt.Event,id,I) [2] SIPUSH(Integer{201}) [3] IF_ICMPEQ(13)
 */
public final class handleEvent_003 extends JJITAbstractInstruction implements Cloneable{
      private KField c_id = null;
      private KClassRepository c_repo;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // *********[1] GETFIELD(java.awt.Event,id,I)
        if(c_id == null){
          c_id = c_repo.getClassByName("java.awt.Event").getField("id",true);
        }
         // **REMOVED Substitution** s0 = c_id.getInstanceValue(frame.popRef());
         // *********[2] SIPUSH(Integer{201})
         // **REMOVED Substitution** s1 = I201;
         // *********[3] IF_ICMPEQ(13)
         // **REMOVED Substitution** index = 201;
         // **REMOVED Substitution** jump = c_id.getInstanceValue(frame.popRef()).intValue() == 201;
        return ((c_id.getInstanceValue(frame.popRef()).intValue() == 201)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[1] GETFIELD(java.awt.Event,id,I)
        c_repo = process.getClassRepository();
         // *********[2] SIPUSH(Integer{201})
         // *********[3] IF_ICMPEQ(13)
        c_next = instructions[(index + 1)];
        c_label = instructions[5];
      }
}
