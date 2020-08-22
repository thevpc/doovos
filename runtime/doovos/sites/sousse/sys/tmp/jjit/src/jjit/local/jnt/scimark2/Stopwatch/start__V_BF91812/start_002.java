package jjit.local.jnt.scimark2.Stopwatch.start__V_BF91812;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Stopwatch
 * start()V
 * [count=8] [3] ALOAD(0) [4] ICONST_1(Integer{1}) [5] PUTFIELD(jnt.scimark2.Stopwatch,running) [6] ALOAD(0) [7] DCONST_0(Double{0.0}) [8] PUTFIELD(jnt.scimark2.Stopwatch,total) [9] ALOAD(0) [10] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
 */
public final class start_002 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IONE = KInteger.ONE;
      private KField c_running = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private static final KDouble DZERO = KDouble.ZERO;
      private KField c_total = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
         // **REMOVED Unused Var** KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[5] PUTFIELD(jnt.scimark2.Stopwatch,running)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_running.setInstanceValue(this_ref,IONE);
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[7] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[8] PUTFIELD(jnt.scimark2.Stopwatch,total)
         // **REMOVED Substitution** reg = DZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_total.setInstanceValue(this_ref,DZERO);
         // *********[9] ALOAD(0)
        frame.push(this_ref);
         // *********[10] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
         // **REMOVED Substitution** regs = KRegister.EMPTY_ARRAY;
        if(m_mth == null){
          m_mth = c_CStopwatch.getMethodBySignature("seconds()D");
        }
        frame.setProgramCounter(2);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,KRegister.EMPTY_ARRAY);
        return ((JJITInstruction)thread.pushFrame(m_mth,KRegister.EMPTY_ARRAY).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] ICONST_1(Integer{1})
         // *********[5] PUTFIELD(jnt.scimark2.Stopwatch,running)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        c_running = c_CStopwatch.getField("running",true);
         // *********[6] ALOAD(0)
         // *********[7] DCONST_0(Double{0.0})
         // *********[8] PUTFIELD(jnt.scimark2.Stopwatch,total)
        c_total = c_CStopwatch.getField("total",true);
         // *********[9] ALOAD(0)
         // *********[10] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
      }
}
