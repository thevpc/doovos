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
 * [count=3] [11] ALOAD(0) [12] ACONST_NULL [13] PUTFIELD(jnt.Bench.Applet,thread)
 */
public final class abortBenchmark_009 extends JJITAbstractInstruction implements Cloneable{
      private KField c_thread = null;
      private KClassRepository c_repo;
      private KClass c_CApplet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[12] ACONST_NULL
         // **REMOVED Substitution** s1_ref = KReference.NULL;
         // *********[13] PUTFIELD(jnt.Bench.Applet,thread)
         // **REMOVED Substitution** reg = KReference.NULL;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        c_thread.setInstanceValue(((KReference)frame.getLocal(0)),KReference.NULL);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] ALOAD(0)
         // *********[12] ACONST_NULL
         // *********[13] PUTFIELD(jnt.Bench.Applet,thread)
        c_repo = process.getClassRepository();
        c_CApplet = c_repo.getClassByName("jnt.Bench.Applet");
        c_thread = c_CApplet.getField("thread",true);
        c_next = instructions[(index + 1)];
      }
}
