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
 * [count=4] [59] ILOAD(2) [60] ALOAD(0) [61] GETFIELD(jnt.Bench.Applet,segment,I) [62] IF_ICMPEQ(103)
 */
public final class handleEvent_024 extends JJITAbstractInstruction implements Cloneable{
      private KField c_segment = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[59] ILOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[60] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[61] GETFIELD(jnt.Bench.Applet,segment,I)
         // **REMOVED Substitution** s1 = new KInteger(c_segment.getInstanceInt(((KReference)frame.getLocal(0))));
         // *********[62] IF_ICMPEQ(103)
         // **REMOVED Substitution** index = c_segment.getInstanceInt(((KReference)frame.getLocal(0)));
         // **REMOVED Substitution** jump = frame.getLocal(2).intValue() == c_segment.getInstanceInt(((KReference)frame.getLocal(0)));
        return ((frame.getLocal(2).intValue() == c_segment.getInstanceInt(((KReference)frame.getLocal(0))))?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[59] ILOAD(2)
         // *********[60] ALOAD(0)
         // *********[61] GETFIELD(jnt.Bench.Applet,segment,I)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_segment = c_CApplet.getField("segment",true);
         // *********[62] IF_ICMPEQ(103)
        c_next = instructions[(index + 1)];
        c_label = instructions[44];
      }
}
