package jjit.local.jnt.Bench.Stopwatch.stop__D_8C73A202;
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
 * stop()D
 * [count=12] [3] ALOAD(0) [4] DUP [5] GETFIELD(jnt.Bench.Stopwatch,total,J) [6] INVOKE_HOST(java.lang.System.currentTimeMillis()J) [7] ALOAD(0) [8] GETFIELD(jnt.Bench.Stopwatch,last_time,J) [9] LSUB [10] LADD [11] PUTFIELD(jnt.Bench.Stopwatch,total) [12] ALOAD(0) [13] ICONST_0(Integer{0}) [14] PUTFIELD(jnt.Bench.Stopwatch,running)
 */
public final class stop_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_total = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private KField c_last_time = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private KField c_running = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s3_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** long m_l;
         // **REMOVED Unused Var** long m_l2;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] DUP
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[5] GETFIELD(jnt.Bench.Stopwatch,total,J)
         // **REMOVED Substitution** s1 = c_total.getInstanceValue(this_ref);
         // *********[6] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // **REMOVED Substitution** s2 = new KLong(System.currentTimeMillis());
         // *********[7] ALOAD(0)
         // **REMOVED Substitution** s3_ref = this_ref;
         // *********[8] GETFIELD(jnt.Bench.Stopwatch,last_time,J)
         // **REMOVED Substitution** s3 = c_last_time.getInstanceValue(this_ref);
         // *********[9] LSUB
         // **REMOVED Substitution** m_l = c_last_time.getInstanceValue(this_ref).longValue();
         // **REMOVED Substitution** s2 = new KLong((System.currentTimeMillis() - c_last_time.getInstanceValue(this_ref).longValue()));
         // *********[10] LADD
         // **REMOVED Substitution** m_l2 = (System.currentTimeMillis() - c_last_time.getInstanceValue(this_ref).longValue());
         // **REMOVED Substitution** s1 = new KLong((c_total.getInstanceValue(this_ref).longValue() + (System.currentTimeMillis() - c_last_time.getInstanceValue(this_ref).longValue())));
         // *********[11] PUTFIELD(jnt.Bench.Stopwatch,total)
         // **REMOVED Substitution** reg = new KLong((c_total.getInstanceValue(this_ref).longValue() + (System.currentTimeMillis() - c_last_time.getInstanceValue(this_ref).longValue())));
         // **REMOVED Substitution** ref = this_ref;
        c_total.setInstanceValue(this_ref,new KLong((c_total.getInstanceValue(this_ref).longValue() + (System.currentTimeMillis() - c_last_time.getInstanceValue(this_ref).longValue()))));
         // *********[12] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[13] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[14] PUTFIELD(jnt.Bench.Stopwatch,running)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_running.setInstanceValue(this_ref,IZERO);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] DUP
         // *********[5] GETFIELD(jnt.Bench.Stopwatch,total,J)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        c_total = c_CStopwatch.getField("total",true);
         // *********[6] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // *********[7] ALOAD(0)
         // *********[8] GETFIELD(jnt.Bench.Stopwatch,last_time,J)
        c_last_time = c_CStopwatch.getField("last_time",true);
         // *********[9] LSUB
         // *********[10] LADD
         // *********[11] PUTFIELD(jnt.Bench.Stopwatch,total)
         // *********[12] ALOAD(0)
         // *********[13] ICONST_0(Integer{0})
         // *********[14] PUTFIELD(jnt.Bench.Stopwatch,running)
        c_running = c_CStopwatch.getField("running",true);
        c_next = instructions[(index + 1)];
      }
}
