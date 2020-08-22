package jjit.local.jnt.scimark2.LU.getPivot___I_D971649A;
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
 * getPivot()[I
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.scimark2.LU,pivot_,[I) [2] INVOKESTATIC(jnt.scimark2.LU,new_copy([I)[I)
 */
public final class getPivot_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_pivot_ = null;
      private KClassRepository c_repo;
      private KClass c_CLU = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.scimark2.LU,pivot_,[I)
         // **REMOVED Substitution** s0_ref = c_pivot_.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] INVOKESTATIC(jnt.scimark2.LU,new_copy([I)[I)
        regs = new KRegister[1];
        regs[0] = c_pivot_.getInstanceRef(((KReference)frame.getLocal(0)));
        if(m_mth == null){
          m_mth = c_CLU.getMethodBySignature("new_copy([I)[I");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.scimark2.LU,pivot_,[I)
        c_repo = process.getClassRepository();
        c_CLU = c_repo.getClassByName("jnt.scimark2.LU");
        c_pivot_ = c_CLU.getField("pivot_",true);
         // *********[2] INVOKESTATIC(jnt.scimark2.LU,new_copy([I)[I)
      }
}
