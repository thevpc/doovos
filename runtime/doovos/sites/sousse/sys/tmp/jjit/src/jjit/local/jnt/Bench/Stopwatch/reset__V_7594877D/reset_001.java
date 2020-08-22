package jjit.local.jnt.Bench.Stopwatch.reset__V_7594877D;
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
 * jnt.Bench.Stopwatch
 * reset()V
 * [count=10] [0] ALOAD(0) [1] ICONST_0(Integer{0}) [2] PUTFIELD(jnt.Bench.Stopwatch,running) [3] ALOAD(0) [4] LCONST_0(Long{0}) [5] PUTFIELD(jnt.Bench.Stopwatch,last_time) [6] ALOAD(0) [7] LCONST_0(Long{0}) [8] PUTFIELD(jnt.Bench.Stopwatch,total) [9] RETURN
 */
public final class reset_001 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IZERO = KInteger.ZERO;
      private KField c_running = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private static final KLong LZERO = KLong.ZERO;
      private KField c_last_time = null;
      private KField c_total = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[1] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[2] PUTFIELD(jnt.Bench.Stopwatch,running)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_running.setInstanceValue(this_ref,IZERO);
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] LCONST_0(Long{0})
         // **REMOVED Substitution** s1 = LZERO;
         // *********[5] PUTFIELD(jnt.Bench.Stopwatch,last_time)
         // **REMOVED Substitution** reg = LZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_last_time.setInstanceValue(this_ref,LZERO);
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[7] LCONST_0(Long{0})
         // **REMOVED Substitution** s1 = LZERO;
         // *********[8] PUTFIELD(jnt.Bench.Stopwatch,total)
         // **REMOVED Substitution** reg = LZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_total.setInstanceValue(this_ref,LZERO);
         // *********[9] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ICONST_0(Integer{0})
         // *********[2] PUTFIELD(jnt.Bench.Stopwatch,running)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        c_running = c_CStopwatch.getField("running",true);
         // *********[3] ALOAD(0)
         // *********[4] LCONST_0(Long{0})
         // *********[5] PUTFIELD(jnt.Bench.Stopwatch,last_time)
        c_last_time = c_CStopwatch.getField("last_time",true);
         // *********[6] ALOAD(0)
         // *********[7] LCONST_0(Long{0})
         // *********[8] PUTFIELD(jnt.Bench.Stopwatch,total)
        c_total = c_CStopwatch.getField("total",true);
         // *********[9] RETURN
      }
}
