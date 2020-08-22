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
 * [count=7] [83] ALOAD(6) [84] ALOAD(9) [85] ALOAD(11) [86] ALOAD(10) [87] ALOAD(5) [88] ILOAD(14) [89] INVOKESTATIC(jnt.scimark2.SparseCompRow,matmult([D[D[I[I[DI)V)
 */
public final class measureSparseMatmult_016 extends JJITAbstractInstruction implements Cloneable{
      private KClassRepository c_repo;
      private KClass c_CSparseCompRow = null;
      private KMethod m_mth = null;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s5;
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=0 : NotCached
         // local_10 10 ; r=1/w=0 : NotCached
         // local_11 11 ; r=1/w=0 : NotCached
         // local_14 14 ; r=1/w=0 : NotCached
         // *********[83] ALOAD(6)
         // **REMOVED Substitution** s0 = frame.getLocal(6);
         // *********[84] ALOAD(9)
         // **REMOVED Substitution** s1 = frame.getLocal(9);
         // *********[85] ALOAD(11)
         // **REMOVED Substitution** s2 = frame.getLocal(11);
         // *********[86] ALOAD(10)
         // **REMOVED Substitution** s3 = frame.getLocal(10);
         // *********[87] ALOAD(5)
         // **REMOVED Substitution** s4 = frame.getLocal(5);
         // *********[88] ILOAD(14)
         // **REMOVED Substitution** s5 = frame.getLocal(14);
         // *********[89] INVOKESTATIC(jnt.scimark2.SparseCompRow,matmult([D[D[I[I[DI)V)
        regs = new KRegister[6];
        regs[5] = frame.getLocal(14);
        regs[4] = frame.getLocal(5);
        regs[3] = frame.getLocal(10);
        regs[2] = frame.getLocal(11);
        regs[1] = frame.getLocal(9);
        regs[0] = frame.getLocal(6);
        if(c_CSparseCompRow == null){
          c_CSparseCompRow = c_repo.getClassByName("jnt.scimark2.SparseCompRow");
        }
        if(m_mth == null){
          m_mth = c_CSparseCompRow.getMethodBySignature("matmult([D[D[I[I[DI)V");
        }
        frame.setProgramCounter(16);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
        return ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[83] ALOAD(6)
         // *********[84] ALOAD(9)
         // *********[85] ALOAD(11)
         // *********[86] ALOAD(10)
         // *********[87] ALOAD(5)
         // *********[88] ILOAD(14)
         // *********[89] INVOKESTATIC(jnt.scimark2.SparseCompRow,matmult([D[D[I[I[DI)V)
        c_repo = process.getClassRepository();
      }
}
