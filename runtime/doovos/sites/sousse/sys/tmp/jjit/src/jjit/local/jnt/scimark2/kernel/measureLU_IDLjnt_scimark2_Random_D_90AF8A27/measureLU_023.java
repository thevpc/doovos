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
 * [count=4] [60] ALOAD(9) [61] ALOAD(4) [62] ALOAD(10) [63] INVOKESTATIC(jnt.scimark2.kernel,matvec([[D[D)[D)
 */
public final class measureLU_023 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=0 : NotCached
         // *********[60] ALOAD(9)
        frame.push(frame.getLocal(9));
         // *********[61] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[62] ALOAD(10)
         // **REMOVED Substitution** s1 = frame.getLocal(10);
         // *********[63] INVOKESTATIC(jnt.scimark2.kernel,matvec([[D[D)[D)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(10);
        regs[0] = frame.getLocal(4);
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("matvec([[D[D)[D");
        }
        frame.setProgramCounter(23);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[60] ALOAD(9)
         // *********[61] ALOAD(4)
         // *********[62] ALOAD(10)
         // *********[63] INVOKESTATIC(jnt.scimark2.kernel,matvec([[D[D)[D)
        c_repo = process.getClassRepository();
        c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
      }
}
