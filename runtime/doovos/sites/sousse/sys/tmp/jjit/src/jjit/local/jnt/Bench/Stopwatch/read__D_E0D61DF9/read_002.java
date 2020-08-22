package jjit.local.jnt.Bench.Stopwatch.read__D_E0D61DF9;
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
 * read()D
 * [count=14] [3] INVOKE_HOST(java.lang.System.currentTimeMillis()J) [4] LSTORE(1) [5] ALOAD(0) [6] DUP [7] GETFIELD(jnt.Bench.Stopwatch,total,J) [8] LLOAD(1) [9] ALOAD(0) [10] GETFIELD(jnt.Bench.Stopwatch,last_time,J) [11] LSUB [12] LADD [13] PUTFIELD(jnt.Bench.Stopwatch,total) [14] ALOAD(0) [15] LLOAD(1) [16] PUTFIELD(jnt.Bench.Stopwatch,last_time)
 */
public final class read_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_total = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private KField c_last_time = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
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
         // local_1 1 ; r=2/w=1 : Cached
        KRegister local_1;
         // *********[3] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // **REMOVED Substitution** s0 = new KLong(System.currentTimeMillis());
         // *********[4] LSTORE(1)
        local_1 = new KLong(System.currentTimeMillis());
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] DUP
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[7] GETFIELD(jnt.Bench.Stopwatch,total,J)
         // **REMOVED Substitution** s1 = c_total.getInstanceValue(this_ref);
         // *********[8] LLOAD(1)
         // **REMOVED Substitution** s2 = local_1;
         // *********[9] ALOAD(0)
         // **REMOVED Substitution** s3_ref = this_ref;
         // *********[10] GETFIELD(jnt.Bench.Stopwatch,last_time,J)
         // **REMOVED Substitution** s3 = c_last_time.getInstanceValue(this_ref);
         // *********[11] LSUB
         // **REMOVED Substitution** m_l = c_last_time.getInstanceValue(this_ref).longValue();
         // **REMOVED Substitution** s2 = new KLong((local_1.longValue() - c_last_time.getInstanceValue(this_ref).longValue()));
         // *********[12] LADD
         // **REMOVED Substitution** m_l2 = (local_1.longValue() - c_last_time.getInstanceValue(this_ref).longValue());
         // **REMOVED Substitution** s1 = new KLong((c_total.getInstanceValue(this_ref).longValue() + (local_1.longValue() - c_last_time.getInstanceValue(this_ref).longValue())));
         // *********[13] PUTFIELD(jnt.Bench.Stopwatch,total)
         // **REMOVED Substitution** reg = new KLong((c_total.getInstanceValue(this_ref).longValue() + (local_1.longValue() - c_last_time.getInstanceValue(this_ref).longValue())));
         // **REMOVED Substitution** ref = this_ref;
        c_total.setInstanceValue(this_ref,new KLong((c_total.getInstanceValue(this_ref).longValue() + (local_1.longValue() - c_last_time.getInstanceValue(this_ref).longValue()))));
         // *********[14] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[15] LLOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[16] PUTFIELD(jnt.Bench.Stopwatch,last_time)
         // **REMOVED Substitution** reg = local_1;
         // **REMOVED Substitution** ref = this_ref;
        c_last_time.setInstanceValue(this_ref,local_1);
        frame.setLocal(1,local_1);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] INVOKE_HOST(java.lang.System.currentTimeMillis()J)
         // *********[4] LSTORE(1)
         // *********[5] ALOAD(0)
         // *********[6] DUP
         // *********[7] GETFIELD(jnt.Bench.Stopwatch,total,J)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.Bench.Stopwatch");
        c_total = c_CStopwatch.getField("total",true);
         // *********[8] LLOAD(1)
         // *********[9] ALOAD(0)
         // *********[10] GETFIELD(jnt.Bench.Stopwatch,last_time,J)
        c_last_time = c_CStopwatch.getField("last_time",true);
         // *********[11] LSUB
         // *********[12] LADD
         // *********[13] PUTFIELD(jnt.Bench.Stopwatch,total)
         // *********[14] ALOAD(0)
         // *********[15] LLOAD(1)
         // *********[16] PUTFIELD(jnt.Bench.Stopwatch,last_time)
        c_next = instructions[(index + 1)];
      }
}
