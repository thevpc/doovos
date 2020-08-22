package jjit.local.jnt.scimark2.Stopwatch.resume__V_644782CE;
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
 * jnt.scimark2.Stopwatch
 * resume()V
 * [count=4] [5] PUTFIELD(jnt.scimark2.Stopwatch,last_time) [6] ALOAD(0) [7] ICONST_1(Integer{1}) [8] PUTFIELD(jnt.scimark2.Stopwatch,running)
 */
public final class resume_003 extends JJITAbstractInstruction implements Cloneable{
      private KField c_last_time = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private static final KInteger IONE = KInteger.ONE;
      private KField c_running = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[5] PUTFIELD(jnt.scimark2.Stopwatch,last_time)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_last_time.setInstanceValue(frame.popRef(),reg);
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[7] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[8] PUTFIELD(jnt.scimark2.Stopwatch,running)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = ((KReference)frame.getLocal(0));
        c_running.setInstanceValue(((KReference)frame.getLocal(0)),IONE);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[5] PUTFIELD(jnt.scimark2.Stopwatch,last_time)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        c_last_time = c_CStopwatch.getField("last_time",true);
         // *********[6] ALOAD(0)
         // *********[7] ICONST_1(Integer{1})
         // *********[8] PUTFIELD(jnt.scimark2.Stopwatch,running)
        c_running = c_CStopwatch.getField("running",true);
        c_next = instructions[(index + 1)];
      }
}
