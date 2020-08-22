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
 * [count=5] [55] ASTORE(10) [56] ALOAD(5) [57] ALOAD(6) [58] ALOAD(10) [59] INVOKESTATIC(jnt.scimark2.LU,solve([[D[I[D)V)
 */
public final class measureLU_022 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CLU = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=1 : Cached
        KRegister local_10;
         // *********[55] ASTORE(10)
        local_10 = frame.pop();
         // *********[56] ALOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[57] ALOAD(6)
         // **REMOVED Substitution** s1 = frame.getLocal(6);
         // *********[58] ALOAD(10)
         // **REMOVED Substitution** s2 = local_10;
         // *********[59] INVOKESTATIC(jnt.scimark2.LU,solve([[D[I[D)V)
        regs = new KRegister[3];
        regs[2] = local_10;
        regs[1] = frame.getLocal(6);
        regs[0] = frame.getLocal(5);
        if(c_CLU == null){
          c_CLU = c_repo.getClassByName("jnt.scimark2.LU");
        }
        if(m_mth == null){
          m_mth = c_CLU.getMethodBySignature("solve([[D[I[D)V");
        }
        frame.setProgramCounter(22);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        frame.setLocal(10,local_10);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[55] ASTORE(10)
         // *********[56] ALOAD(5)
         // *********[57] ALOAD(6)
         // *********[58] ALOAD(10)
         // *********[59] INVOKESTATIC(jnt.scimark2.LU,solve([[D[I[D)V)
        c_repo = process.getClassRepository();
      }
}
