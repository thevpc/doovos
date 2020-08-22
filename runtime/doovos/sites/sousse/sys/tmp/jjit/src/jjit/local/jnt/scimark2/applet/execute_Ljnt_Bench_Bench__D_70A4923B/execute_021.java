package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=2] [54] DASTORE [55] INVOKESTATIC(java.lang.Thread,yield()V)
 */
public final class execute_021 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private KClassRepository c_repo;
      private KClass c_CThread = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
        int index = 0;
        double m_d;
         // **REMOVED Unused Var** KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[54] DASTORE
        m_d = frame.popDouble();
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[55] INVOKESTATIC(java.lang.Thread,yield()V)
         // **REMOVED Substitution** regs = KRegister.EMPTY_ARRAY;
        if(c_CThread == null){
          c_CThread = c_repo.getClassByName("java.lang.Thread");
        }
        if(m_mth == null){
          m_mth = c_CThread.getMethodBySignature("yield()V");
        }
        frame.setProgramCounter(21);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,KRegister.EMPTY_ARRAY);
        return ((JJITInstruction)thread.pushFrame(m_mth,KRegister.EMPTY_ARRAY).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[54] DASTORE
        c_memman = process.getMemoryManager();
         // *********[55] INVOKESTATIC(java.lang.Thread,yield()V)
        c_repo = process.getClassRepository();
      }
}
