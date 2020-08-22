package jjit.local.jnt.scimark2.kernel.measureLU_IDLjnt_scimark2_Random_D_90AF8A27;
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
 * jnt.scimark2.kernel
 * measureLU(IDLjnt/scimark2/Random;)D
 * [count=4] [0] ILOAD(0) [1] ILOAD(0) [2] ALOAD(3) [3] INVOKESTATIC(jnt.scimark2.kernel,RandomMatrix(IILjnt/scimark2/Random;)[[D)
 */
public final class measureLU_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=2/w=0 : Cached
        int local_0 = frame.getLocal(0).intValue();
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[0] ILOAD(0)
         // **REMOVED Substitution** s0 = new KInteger(local_0);
         // *********[1] ILOAD(0)
         // **REMOVED Substitution** s1 = new KInteger(local_0);
         // *********[2] ALOAD(3)
         // **REMOVED Substitution** s2 = frame.getLocal(3);
         // *********[3] INVOKESTATIC(jnt.scimark2.kernel,RandomMatrix(IILjnt/scimark2/Random;)[[D)
        regs = new KRegister[3];
        regs[2] = frame.getLocal(3);
        regs[1] = new KInteger(local_0);
        regs[0] = new KInteger(local_0);
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("RandomMatrix(IILjnt/scimark2/Random;)[[D");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(0)
         // *********[1] ILOAD(0)
         // *********[2] ALOAD(3)
         // *********[3] INVOKESTATIC(jnt.scimark2.kernel,RandomMatrix(IILjnt/scimark2/Random;)[[D)
        c_repo = process.getClassRepository();
        c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
      }
}
