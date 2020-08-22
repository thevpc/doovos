package jjit.local.jnt.scimark2.kernel.measureMonteCarlo_DLjnt_scimark2_Random_D_90961690;
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
 * measureMonteCarlo(DLjnt/scimark2/Random;)D
 * [count=2] [26] ILOAD(4) [27] INVOKESTATIC(jnt.scimark2.MonteCarlo,num_flops(I)D)
 */
public final class measureMonteCarlo_012 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CMonteCarlo = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[26] ILOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[27] INVOKESTATIC(jnt.scimark2.MonteCarlo,num_flops(I)D)
        regs = new KRegister[1];
        regs[0] = frame.getLocal(4);
        if(c_CMonteCarlo == null){
          c_CMonteCarlo = c_repo.getClassByName("jnt.scimark2.MonteCarlo");
        }
        if(m_mth == null){
          m_mth = c_CMonteCarlo.getMethodBySignature("num_flops(I)D");
        }
        frame.setProgramCounter(12);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] ILOAD(4)
         // *********[27] INVOKESTATIC(jnt.scimark2.MonteCarlo,num_flops(I)D)
        c_repo = process.getClassRepository();
      }
}
