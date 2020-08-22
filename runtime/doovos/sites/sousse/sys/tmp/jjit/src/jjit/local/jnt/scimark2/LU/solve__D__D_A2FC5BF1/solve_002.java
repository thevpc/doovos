package jjit.local.jnt.scimark2.LU.solve__D__D_A2FC5BF1;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * solve([D)[D
 * [count=7] [2] ASTORE(2) [3] ALOAD(0) [4] GETFIELD(jnt.scimark2.LU,LU_,[[D) [5] ALOAD(0) [6] GETFIELD(jnt.scimark2.LU,pivot_,[I) [7] ALOAD(2) [8] INVOKESTATIC(jnt.scimark2.LU,solve([[D[I[D)V)
 */
public final class solve_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_LU_ = null;
      private KClassRepository c_repo;
      private KClass c_CLU = null;
      private KField c_pivot_ = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_2 2 ; r=1/w=1 : Cached
        KRegister local_2;
         // *********[2] ASTORE(2)
        local_2 = frame.pop();
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] GETFIELD(jnt.scimark2.LU,LU_,[[D)
         // **REMOVED Substitution** s0_ref = c_LU_.getInstanceRef(this_ref);
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[6] GETFIELD(jnt.scimark2.LU,pivot_,[I)
         // **REMOVED Substitution** s1_ref = c_pivot_.getInstanceRef(this_ref);
         // *********[7] ALOAD(2)
         // **REMOVED Substitution** s2 = local_2;
         // *********[8] INVOKESTATIC(jnt.scimark2.LU,solve([[D[I[D)V)
        regs = new KRegister[3];
        regs[2] = local_2;
        regs[1] = c_pivot_.getInstanceRef(this_ref);
        regs[0] = c_LU_.getInstanceRef(this_ref);
        if(m_mth == null){
          m_mth = c_CLU.getMethodBySignature("solve([[D[I[D)V");
        }
        frame.setProgramCounter(2);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        frame.setLocal(2,local_2);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ASTORE(2)
         // *********[3] ALOAD(0)
         // *********[4] GETFIELD(jnt.scimark2.LU,LU_,[[D)
        c_repo = process.getClassRepository();
        c_CLU = c_repo.getClassByName("jnt.scimark2.LU");
        c_LU_ = c_CLU.getField("LU_",true);
         // *********[5] ALOAD(0)
         // *********[6] GETFIELD(jnt.scimark2.LU,pivot_,[I)
        c_pivot_ = c_CLU.getField("pivot_",true);
         // *********[7] ALOAD(2)
         // *********[8] INVOKESTATIC(jnt.scimark2.LU,solve([[D[I[D)V)
      }
}
