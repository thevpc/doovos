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
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;) [2] IFNULL(14)
 */
public final class abortBenchmark_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_thread = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;)
         // **REMOVED Substitution** s0_ref = c_thread.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] IFNULL(14)
        return ((c_thread.getInstanceRef(((KReference)frame.getLocal(0))).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Applet,thread,Ljava/lang/Thread;)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_thread = c_CApplet.getField("thread",true);
         // *********[2] IFNULL(14)
        c_next = instructions[(index + 1)];
        c_label = instructions[9];
      }
}
