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
 * [count=5] [40] ALOAD(1) [41] GETFIELD(java.awt.Event,target,Ljava/lang/Object;) [42] ALOAD(0) [43] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;) [44] IF_ACMPNE(73)
 */
public final class handleEvent_016 extends JJITAbstractInstruction implements Cloneable{
      private KField c_target = null;
      private KClassRepository c_repo;
      private KField c_chooser = null;
      private KClass c_CApplet = null;
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
         // *********[40] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[41] GETFIELD(java.awt.Event,target,Ljava/lang/Object;)
        if(c_target == null){
          c_target = c_repo.getClassByName("java.awt.Event").getField("target",true);
        }
         // **REMOVED Substitution** s0 = c_target.getInstanceValue(((KReference)frame.getLocal(1)));
         // *********[42] ALOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[43] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
         // **REMOVED Substitution** s1_ref = c_chooser.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[44] IF_ACMPNE(73)
        ref = c_chooser.getInstanceRef(((KReference)frame.getLocal(0)));
        ref2 = ((KReference)c_target.getInstanceValue(((KReference)frame.getLocal(1))));
         // **REMOVED Substitution** jump = ref.pointer != ref2.pointer || ref.segment != ref2.segment;
        return ((ref.pointer != ref2.pointer || ref.segment != ref2.segment)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[40] ALOAD(1)
         // *********[41] GETFIELD(java.awt.Event,target,Ljava/lang/Object;)
        c_repo = process.getClassRepository();
         // *********[42] ALOAD(0)
         // *********[43] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_chooser = c_CApplet.getField("chooser",true);
         // *********[44] IF_ACMPNE(73)
        c_next = instructions[(index + 1)];
        c_label = instructions[29];
      }
}
