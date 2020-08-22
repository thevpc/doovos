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
 * [count=3] [52] ASTORE(9) [53] ALOAD(9) [54] INVOKESTATIC(jnt.scimark2.kernel,NewVectorCopy([D)[D)
 */
public final class measureLU_021 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_Ckernel = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_9 9 ; r=1/w=1 : Cached
        KRegister local_9;
         // *********[52] ASTORE(9)
        local_9 = frame.pop();
         // *********[53] ALOAD(9)
         // **REMOVED Substitution** s0 = local_9;
         // *********[54] INVOKESTATIC(jnt.scimark2.kernel,NewVectorCopy([D)[D)
        regs = new KRegister[1];
        regs[0] = local_9;
        if(m_mth == null){
          m_mth = c_Ckernel.getMethodBySignature("NewVectorCopy([D)[D");
        }
        frame.setProgramCounter(21);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        frame.setLocal(9,local_9);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[52] ASTORE(9)
         // *********[53] ALOAD(9)
         // *********[54] INVOKESTATIC(jnt.scimark2.kernel,NewVectorCopy([D)[D)
        c_repo = process.getClassRepository();
        c_Ckernel = c_repo.getClassByName("jnt.scimark2.kernel");
      }
}
