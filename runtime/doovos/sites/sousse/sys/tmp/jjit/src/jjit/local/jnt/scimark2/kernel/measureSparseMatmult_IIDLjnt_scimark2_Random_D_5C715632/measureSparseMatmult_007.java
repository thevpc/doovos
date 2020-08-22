package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=9] [58] ALOAD(10) [59] ILOAD(13) [60] ILOAD(15) [61] IADD [62] ILOAD(15) [63] ILOAD(14) [64] IMUL [65] IASTORE [66] IINC(15,1)
 */
public final class measureSparseMatmult_007 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // local_10 10 ; r=1/w=0 : NotCached
         // local_13 13 ; r=1/w=0 : NotCached
         // local_14 14 ; r=1/w=0 : NotCached
         // local_15 15 ; r=3/w=1 : Cached
        int local_15 = frame.getLocal(15).intValue();
         // *********[58] ALOAD(10)
         // **REMOVED Substitution** s0 = frame.getLocal(10);
         // *********[59] ILOAD(13)
         // **REMOVED Substitution** s1 = frame.getLocal(13);
         // *********[60] ILOAD(15)
         // **REMOVED Substitution** s2 = new KInteger(local_15);
         // *********[61] IADD
         // **REMOVED Substitution** index = local_15;
         // **REMOVED Substitution** s1 = new KInteger((frame.getLocal(13).intValue() + local_15));
         // *********[62] ILOAD(15)
         // **REMOVED Substitution** s2 = new KInteger(local_15);
         // *********[63] ILOAD(14)
         // **REMOVED Substitution** s3 = frame.getLocal(14);
         // *********[64] IMUL
         // **REMOVED Substitution** index = frame.getLocal(14).intValue();
         // **REMOVED Substitution** s2 = new KInteger((local_15 * frame.getLocal(14).intValue()));
         // *********[65] IASTORE
         // **REMOVED Substitution** m_i = (local_15 * frame.getLocal(14).intValue());
         // **REMOVED Substitution** index = (frame.getLocal(13).intValue() + local_15);
        c_memman.setIntArray(((KReference)frame.getLocal(10)),(frame.getLocal(13).intValue() + local_15),(local_15 * frame.getLocal(14).intValue()));
         // *********[66] IINC(15,1)
         // **REMOVED Substitution** local_15 = (local_15 + 1);
        frame.setLocal(15,new KInteger((local_15 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[58] ALOAD(10)
         // *********[59] ILOAD(13)
         // *********[60] ILOAD(15)
         // *********[61] IADD
         // *********[62] ILOAD(15)
         // *********[63] ILOAD(14)
         // *********[64] IMUL
         // *********[65] IASTORE
        c_memman = process.getMemoryManager();
         // *********[66] IINC(15,1)
        c_next = instructions[(index + 1)];
      }
}
