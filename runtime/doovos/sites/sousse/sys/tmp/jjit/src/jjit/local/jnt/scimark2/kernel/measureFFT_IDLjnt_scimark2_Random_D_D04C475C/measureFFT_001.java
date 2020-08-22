package jjit.local.jnt.scimark2.kernel.measureFFT_IDLjnt_scimark2_Random_D_D04C475C;
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
 * measureFFT(IDLjnt/scimark2/Random;)D
 * [count=5] [0] ICONST_2(Integer{2}) [1] ILOAD(0) [2] IMUL [3] ALOAD(3) [4] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
 */
public final class measureFFT_001 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[0] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[1] ILOAD(0)
         // **REMOVED Substitution** s1 = frame.getLocal(0);
         // *********[2] IMUL
         // **REMOVED Substitution** index = frame.getLocal(0).intValue();
         // **REMOVED Substitution** s0 = new KInteger((2 * frame.getLocal(0).intValue()));
         // *********[3] ALOAD(3)
         // **REMOVED Substitution** s1 = frame.getLocal(3);
         // *********[4] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(3);
        regs[0] = new KInteger((2 * frame.getLocal(0).intValue()));
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("RandomVector(ILjnt/scimark2/Random;)[D");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ICONST_2(Integer{2})
         // *********[1] ILOAD(0)
         // *********[2] IMUL
         // *********[3] ALOAD(3)
         // *********[4] INVOKESTATIC(jnt.scimark2.kernel,RandomVector(ILjnt/scimark2/Random;)[D)
        c_repo = process.getClassRepository();
        c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
      }
}
