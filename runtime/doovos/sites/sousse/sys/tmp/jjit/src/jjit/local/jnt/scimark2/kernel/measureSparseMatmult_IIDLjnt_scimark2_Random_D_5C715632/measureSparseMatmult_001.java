package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
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
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=3] [0] ILOAD(0) [1] ALOAD(4) [2] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
 */
public final class measureSparseMatmult_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[0] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] ALOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[2] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(4);
        regs[0] = frame.getLocal(0);
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("RandomVector(ILjnt/scimark2/Random;)[D");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ILOAD(0)
         // *********[1] ALOAD(4)
         // *********[2] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
        c_repo = process.getClassRepository();
        c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
      }
}
