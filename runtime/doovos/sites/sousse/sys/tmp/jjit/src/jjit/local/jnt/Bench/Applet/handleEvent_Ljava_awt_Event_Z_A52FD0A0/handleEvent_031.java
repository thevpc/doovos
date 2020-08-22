package jjit.local.jnt.Bench.Applet.handleEvent_Ljava_awt_Event_Z_A52FD0A0;
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
 * jnt.Bench.Applet
 * handleEvent(Ljava/awt/Event;)Z
 * [count=4] [77] ALOAD(1) [78] GETFIELD(java.awt.Event,id,I) [79] SIPUSH(Integer{702}) [80] IF_ICMPNE(101)
 */
public final class handleEvent_031 extends JJITAbstractInstruction implements Cloneable{
      private KField c_id = null;
      private KClassRepository c_repo;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[77] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[78] GETFIELD(java.awt.Event,id,I)
        if(c_id == null){
          c_id = c_repo.getClassByName("java.awt.Event").getField("id",true);
        }
         // **REMOVED Substitution** s0 = c_id.getInstanceValue(((KReference)frame.getLocal(1)));
         // *********[79] SIPUSH(Integer{702})
         // **REMOVED Substitution** s1 = I702;
         // *********[80] IF_ICMPNE(101)
         // **REMOVED Substitution** index = 702;
         // **REMOVED Substitution** jump = c_id.getInstanceValue(((KReference)frame.getLocal(1))).intValue() != 702;
        return ((c_id.getInstanceValue(((KReference)frame.getLocal(1))).intValue() != 702)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[77] ALOAD(1)
         // *********[78] GETFIELD(java.awt.Event,id,I)
        c_repo = process.getClassRepository();
         // *********[79] SIPUSH(Integer{702})
         // *********[80] IF_ICMPNE(101)
        c_next = instructions[(index + 1)];
        c_label = instructions[43];
      }
}
