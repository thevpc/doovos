package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
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
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=4] [104] ILOAD(0) [105] ILOAD(1) [106] ILOAD(14) [107] INVOKESTATIC(jnt.scimark2.SparseCompRow,num_flops(III)D)
 */
public final class measureSparseMatmult_022 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CSparseCompRow = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_14 14 ; r=1/w=0 : NotCached
         // *********[104] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[105] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[106] ILOAD(14)
         // **REMOVED Substitution** s2 = frame.getLocal(14);
         // *********[107] INVOKESTATIC(jnt.scimark2.SparseCompRow,num_flops(III)D)
        regs = new KRegister[3];
        regs[2] = frame.getLocal(14);
        regs[1] = frame.getLocal(1);
        regs[0] = frame.getLocal(0);
        if(c_CSparseCompRow == null){
          c_CSparseCompRow = c_repo.getClassByName("jnt.scimark2.SparseCompRow");
        }
        if(m_mth == null){
          m_mth = c_CSparseCompRow.getMethodBySignature("num_flops(III)D");
        }
        frame.setProgramCounter(22);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[104] ILOAD(0)
         // *********[105] ILOAD(1)
         // *********[106] ILOAD(14)
         // *********[107] INVOKESTATIC(jnt.scimark2.SparseCompRow,num_flops(III)D)
        c_repo = process.getClassRepository();
      }
}
