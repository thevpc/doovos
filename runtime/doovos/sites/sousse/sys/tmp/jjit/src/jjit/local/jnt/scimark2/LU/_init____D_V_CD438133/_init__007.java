package jjit.local.jnt.scimark2.LU._init____D_V_CD438133;
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
 * <init>([[D)V
 * [count=5] [14] PUTFIELD(jnt.scimark2.LU,LU_) [15] ALOAD(0) [16] GETFIELD(jnt.scimark2.LU,LU_,[[D) [17] ALOAD(1) [18] INVOKESTATIC(jnt.scimark2.LU,insert_copy([[D[[D)V)
 */
public final class _init__007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_LU_ = null;
      private KClassRepository c_repo;
      private KClass c_CLU = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[14] PUTFIELD(jnt.scimark2.LU,LU_)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_LU_.setInstanceValue(frame.popRef(),reg);
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[16] GETFIELD(jnt.scimark2.LU,LU_,[[D)
         // **REMOVED Substitution** s0_ref = c_LU_.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[17] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[18] INVOKESTATIC(jnt.scimark2.LU,insert_copy([[D[[D)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(1);
        regs[0] = c_LU_.getInstanceRef(((KReference)frame.getLocal(0)));
        if(m_mth == null){
          m_mth = c_CLU.getMethodBySignature("insert_copy([[D[[D)V");
        }
        frame.setProgramCounter(7);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] PUTFIELD(jnt.scimark2.LU,LU_)
        c_repo = process.getClassRepository();
        c_CLU = c_repo.getClassByName("jnt.scimark2.LU");
        c_LU_ = c_CLU.getField("LU_",true);
         // *********[15] ALOAD(0)
         // *********[16] GETFIELD(jnt.scimark2.LU,LU_,[[D)
         // *********[17] ALOAD(1)
         // *********[18] INVOKESTATIC(jnt.scimark2.LU,insert_copy([[D[[D)V)
      }
}
