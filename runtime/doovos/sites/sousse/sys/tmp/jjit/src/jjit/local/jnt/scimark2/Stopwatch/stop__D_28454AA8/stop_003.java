package jjit.local.jnt.scimark2.Stopwatch.stop__D_28454AA8;
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
 * stop()D
 * [count=8] [7] ALOAD(0) [8] GETFIELD(jnt.scimark2.Stopwatch,last_time,D) [9] DSUB [10] DADD [11] PUTFIELD(jnt.scimark2.Stopwatch,total) [12] ALOAD(0) [13] ICONST_0(Integer{0}) [14] PUTFIELD(jnt.scimark2.Stopwatch,running)
 */
public final class stop_003 extends JJITAbstractInstruction implements Cloneable{
      private KField c_last_time = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private KField c_total = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private KField c_running = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** double m_d;
        double m_d2;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[7] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[8] GETFIELD(jnt.scimark2.Stopwatch,last_time,D)
         // **REMOVED Substitution** s0 = new KDouble(c_last_time.getInstanceDouble(this_ref));
         // *********[9] DSUB
         // **REMOVED Substitution** m_d = c_last_time.getInstanceDouble(this_ref);
         // **REMOVED Substitution** s0 = new KDouble((frame.popDouble() - c_last_time.getInstanceDouble(this_ref)));
         // *********[10] DADD
        m_d2 = (frame.popDouble() - c_last_time.getInstanceDouble(this_ref));
         // **REMOVED Substitution** s0 = new KDouble((frame.popDouble() + m_d2));
         // *********[11] PUTFIELD(jnt.scimark2.Stopwatch,total)
        reg = new KDouble((frame.popDouble() + m_d2));
         // **REMOVED Substitution** ref = frame.popRef();
        c_total.setInstanceValue(frame.popRef(),reg);
         // *********[12] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[13] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[14] PUTFIELD(jnt.scimark2.Stopwatch,running)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_running.setInstanceValue(this_ref,IZERO);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[7] ALOAD(0)
         // *********[8] GETFIELD(jnt.scimark2.Stopwatch,last_time,D)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        c_last_time = c_CStopwatch.getField("last_time",true);
         // *********[9] DSUB
         // *********[10] DADD
         // *********[11] PUTFIELD(jnt.scimark2.Stopwatch,total)
        c_total = c_CStopwatch.getField("total",true);
         // *********[12] ALOAD(0)
         // *********[13] ICONST_0(Integer{0})
         // *********[14] PUTFIELD(jnt.scimark2.Stopwatch,running)
        c_running = c_CStopwatch.getField("running",true);
        c_next = instructions[(index + 1)];
      }
}
