package jjit.local.jnt.scimark2.LU._init____D_V_CD438133;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.LU
 * <init>([[D)V
 * [count=9] [19] ALOAD(0) [20] ILOAD(2) [21] NEWARRAY [22] PUTFIELD(jnt.scimark2.LU,pivot_) [23] ALOAD(0) [24] GETFIELD(jnt.scimark2.LU,LU_,[[D) [25] ALOAD(0) [26] GETFIELD(jnt.scimark2.LU,pivot_,[I) [27] INVOKESTATIC(jnt.scimark2.LU,factor([[D[I)I)
 */
public final class _init__008 extends JJITAbstractInstruction implements Cloneable{
      private KField c_pivot_ = null;
      private KClassRepository c_repo;
      private KClass c_CLU = null;
      private KField c_LU_ = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[19] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[20] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[21] NEWARRAY
         // **REMOVED Substitution** s1_ref = memseg.allocIntArray(frame.getLocal(2).intValue());
         // *********[22] PUTFIELD(jnt.scimark2.LU,pivot_)
         // **REMOVED Substitution** reg = memseg.allocIntArray(frame.getLocal(2).intValue());
         // **REMOVED Substitution** ref = this_ref;
        c_pivot_.setInstanceValue(this_ref,memseg.allocIntArray(frame.getLocal(2).intValue()));
         // *********[23] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[24] GETFIELD(jnt.scimark2.LU,LU_,[[D)
         // **REMOVED Substitution** s0_ref = c_LU_.getInstanceRef(this_ref);
         // *********[25] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[26] GETFIELD(jnt.scimark2.LU,pivot_,[I)
         // **REMOVED Substitution** s1_ref = c_pivot_.getInstanceRef(this_ref);
         // *********[27] INVOKESTATIC(jnt.scimark2.LU,factor([[D[I)I)
        regs = new KRegister[2];
        regs[1] = c_pivot_.getInstanceRef(this_ref);
        regs[0] = c_LU_.getInstanceRef(this_ref);
        if(m_mth == null){
          m_mth = c_CLU.getMethodBySignature("factor([[D[I)I");
        }
        frame.setProgramCounter(8);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[19] ALOAD(0)
         // *********[20] ILOAD(2)
         // *********[21] NEWARRAY
         // *********[22] PUTFIELD(jnt.scimark2.LU,pivot_)
        c_repo = process.getClassRepository();
        c_CLU = c_repo.getClassByName("jnt.scimark2.LU");
        c_pivot_ = c_CLU.getField("pivot_",true);
         // *********[23] ALOAD(0)
         // *********[24] GETFIELD(jnt.scimark2.LU,LU_,[[D)
        c_LU_ = c_CLU.getField("LU_",true);
         // *********[25] ALOAD(0)
         // *********[26] GETFIELD(jnt.scimark2.LU,pivot_,[I)
         // *********[27] INVOKESTATIC(jnt.scimark2.LU,factor([[D[I)I)
      }
}
