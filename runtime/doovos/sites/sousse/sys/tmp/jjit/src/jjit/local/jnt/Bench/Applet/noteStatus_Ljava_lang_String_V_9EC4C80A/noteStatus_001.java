package jjit.local.jnt.Bench.Applet.noteStatus_Ljava_lang_String_V_9EC4C80A;
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
 * noteStatus(Ljava/lang/String;)V
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;) [2] ALOAD(1)
 */
public final class noteStatus_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_status = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
        frame.push(c_status.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[2] ALOAD(1)
        frame.push(frame.getLocal(1));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_status = c_CApplet.getField("status",true);
         // *********[2] ALOAD(1)
        c_next = instructions[(index + 1)];
      }
}
