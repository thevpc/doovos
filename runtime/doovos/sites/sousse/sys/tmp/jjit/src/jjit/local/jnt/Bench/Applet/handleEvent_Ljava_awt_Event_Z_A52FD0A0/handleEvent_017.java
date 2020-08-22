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
 * [count=2] [45] ALOAD(0) [46] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
 */
public final class handleEvent_017 extends JJITAbstractInstruction implements Cloneable{
      private KField c_chooser = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[45] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[46] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
        frame.push(c_chooser.getInstanceRef(((KReference)frame.getLocal(0))));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[45] ALOAD(0)
         // *********[46] GETFIELD(jnt.Bench.Applet,chooser,Ljava/awt/Choice;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_chooser = c_CApplet.getField("chooser",true);
        c_next = instructions[(index + 1)];
      }
}
