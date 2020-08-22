package jjit.local.jnt.scimark2.Stopwatch.stop__D_28454AA8;
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
 * stop()D
 * [count=4] [3] ALOAD(0) [4] DUP [5] GETFIELD(jnt.scimark2.Stopwatch,total,D) [6] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
 */
public final class stop_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_total = null;
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
        KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[3] ALOAD(0)
        s0 = frame.getLocal(0);
         // *********[4] DUP
        frame.push(s0);
         // **REMOVED Substitution** s1 = s0;
         // *********[5] GETFIELD(jnt.scimark2.Stopwatch,total,D)
        frame.push(new KDouble(c_total.getInstanceDouble(((KReference)s0))));
         // *********[6] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
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
         // *********[4] DUP
         // *********[5] GETFIELD(jnt.scimark2.Stopwatch,total,D)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
        c_total = c_CStopwatch.getField("total",true);
         // *********[6] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
      }
}
