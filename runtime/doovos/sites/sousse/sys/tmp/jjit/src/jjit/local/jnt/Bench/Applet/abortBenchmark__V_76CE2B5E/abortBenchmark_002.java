package jjit.local.jnt.Bench.Applet.abortBenchmark__V_76CE2B5E;
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
 * abortBenchmark()V
 * [count=3] [3] ALOAD(0) [4] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;) [5] ALOAD(0)
 */
public final class abortBenchmark_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_status = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
        frame.push(c_status.getInstanceRef(this_ref));
         // *********[5] ALOAD(0)
        frame.push(this_ref);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] GETFIELD(jnt.Bench.Applet,status,Ljava/awt/Label;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_status = c_CApplet.getField("status",true);
         // *********[5] ALOAD(0)
        c_next = instructions[(index + 1)];
      }
}
