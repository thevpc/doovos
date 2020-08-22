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
 * [count=2] [73] ILOAD(0) [74] INVOKESTATIC(jnt.scimark2.LU,num_flops(I)D)
 */
public final class measureLU_027 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CLU = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[73] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[74] INVOKESTATIC(jnt.scimark2.LU,num_flops(I)D)
        regs = new KRegister[1];
        regs[0] = frame.getLocal(0);
        if(c_CLU == null){
          c_CLU = c_repo.getClassByName("jnt.scimark2.LU");
        }
        if(m_mth == null){
          m_mth = c_CLU.getMethodBySignature("num_flops(I)D");
        }
        frame.setProgramCounter(27);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[73] ILOAD(0)
         // *********[74] INVOKESTATIC(jnt.scimark2.LU,num_flops(I)D)
        c_repo = process.getClassRepository();
      }
}
