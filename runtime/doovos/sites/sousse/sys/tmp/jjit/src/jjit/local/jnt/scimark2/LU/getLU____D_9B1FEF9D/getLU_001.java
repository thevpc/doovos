package jjit.local.jnt.scimark2.LU.getLU____D_9B1FEF9D;
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
 * getLU()[[D
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.scimark2.LU,LU_,[[D) [2] INVOKESTATIC(jnt.scimark2.LU,new_copy([[D)[[D)
 */
public final class getLU_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_LU_ = null;
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
         // *********[1] GETFIELD(jnt.scimark2.LU,LU_,[[D)
         // **REMOVED Substitution** s0_ref = c_LU_.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[2] INVOKESTATIC(jnt.scimark2.LU,new_copy([[D)[[D)
        regs = new KRegister[1];
        regs[0] = c_LU_.getInstanceRef(((KReference)frame.getLocal(0)));
        if(m_mth == null){
          m_mth = c_CLU.getMethodBySignature("new_copy([[D)[[D");
        }
        frame.setProgramCounter(1);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.scimark2.LU,LU_,[[D)
        c_repo = process.getClassRepository();
        c_CLU = c_repo.getClassByName("jnt.scimark2.LU");
        c_LU_ = c_CLU.getField("LU_",true);
         // *********[2] INVOKESTATIC(jnt.scimark2.LU,new_copy([[D)[[D)
      }
}
