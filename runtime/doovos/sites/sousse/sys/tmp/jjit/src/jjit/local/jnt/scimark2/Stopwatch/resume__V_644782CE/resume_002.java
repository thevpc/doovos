package jjit.local.jnt.scimark2.Stopwatch.resume__V_644782CE;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Stopwatch
 * resume()V
 * [count=2] [3] ALOAD(0) [4] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
 */
public final class resume_002 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CStopwatch = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[3] ALOAD(0)
        frame.push(frame.getLocal(0));
         // *********[4] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
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
         // *********[4] INVOKESTATIC(jnt.scimark2.Stopwatch,seconds()D)
        c_repo = process.getClassRepository();
        c_CStopwatch = c_repo.getClassByName("jnt.scimark2.Stopwatch");
      }
}
