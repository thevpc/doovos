package jjit.local.jnt.Bench.Stopwatch.start__V_30D8E32B;
import java.lang.System;
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
 * start()V
 * [count=10] [0] ALOAD(0) [1] LCONST_0(Long{0}) [2] PUTFIELD(jnt.Bench.Stopwatch,total) [3] ALOAD(0) [4] INVOKE_HOST(java.lang.System.currentTimeMillis()J) [5] PUTFIELD(jnt.Bench.Stopwatch,last_time) [6] ALOAD(0) [7] ICONST_1(Integer{1}) [8] PUTFIELD(jnt.Bench.Stopwatch,running) [9] RETURN
 */
public final class start_001 extends JJITAbstractInstruction implements Cloneable{
      private static final KLong LZERO = KLong.ZERO;
      private KField c_total = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private KField c_last_time = null;
      private static final KInteger IONE = KInteger.ONE;
      private KField c_running = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** KFrame callerFrame = null;
        KLocalThread thread = frame.getThread();
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[1] LCONST_0(Long{0})
         // **REMOVED Substitution** s1 = LZERO;
         // *********[2] PUTFIELD(jnt.Bench.Stopwatch,total)
         // **REMOVED Substitution** reg = LZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_total.setInstanceValue(this_ref,LZERO);
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // **REMOVED Substitution** s1 = new KLong(System.currentTimeMillis());
         // *********[5] PUTFIELD(jnt.Bench.Stopwatch,last_time)
         // **REMOVED Substitution** reg = new KLong(System.currentTimeMillis());
         // **REMOVED Substitution** ref = this_ref;
        c_last_time.setInstanceValue(this_ref,new KLong(System.currentTimeMillis()));
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[7] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[8] PUTFIELD(jnt.Bench.Stopwatch,running)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_running.setInstanceValue(this_ref,IONE);
         // *********[9] RETURN
         // **REMOVED Substitution** callerFrame = thread.popFrame();
        return ((JJITInstruction)thread.popFrame().getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] LCONST_0(Long{0})
         // *********[2] PUTFIELD(jnt.Bench.Stopwatch,total)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        c_total = c_CStopwatch.getField("total",true);
         // *********[3] ALOAD(0)
         // *********[4] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // *********[5] PUTFIELD(jnt.Bench.Stopwatch,last_time)
        c_last_time = c_CStopwatch.getField("last_time",true);
         // *********[6] ALOAD(0)
         // *********[7] ICONST_1(Integer{1})
         // *********[8] PUTFIELD(jnt.Bench.Stopwatch,running)
        c_running = c_CStopwatch.getField("running",true);
         // *********[9] RETURN
      }
}
