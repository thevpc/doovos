package jjit.local.jnt.Bench.Bench.prepTimer_I_V_DF87A122;
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
 * jnt.Bench.Bench
 * prepTimer(I)V
 * [count=2] [22] POP [23] INVOKESTATIC(java.lang.Thread,yield()V)
 */
public final class prepTimer_015 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CThread = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[22] POP
        frame.pop();
         // *********[23] INVOKESTATIC(java.lang.Thread,yield()V)
         // **REMOVED Substitution** regs = KRegister.EMPTY_ARRAY;
        if(c_CThread == null){
          c_CThread = c_repo.getClassByName("java.lang.Thread");
        }
        if(m_mth == null){
          m_mth = c_CThread.getMethodBySignature("yield()V");
        }
        frame.setProgramCounter(15);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,KRegister.EMPTY_ARRAY);
        return ((JJITInstruction)thread.pushFrame(m_mth,KRegister.EMPTY_ARRAY).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] POP
         // *********[23] INVOKESTATIC(java.lang.Thread,yield()V)
        c_repo = process.getClassRepository();
      }
}
