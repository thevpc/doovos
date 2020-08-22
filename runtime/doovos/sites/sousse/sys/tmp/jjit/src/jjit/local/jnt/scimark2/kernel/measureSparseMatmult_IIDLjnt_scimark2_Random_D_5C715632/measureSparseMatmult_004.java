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
 * [count=19] [34] ALOAD(11) [35] ILOAD(12) [36] IALOAD [37] ISTORE(13) [38] ALOAD(11) [39] ILOAD(12) [40] ICONST_1(Integer{1}) [41] IADD [42] ILOAD(13) [43] ILOAD(7) [44] IADD [45] IASTORE [46] ILOAD(12) [47] ILOAD(7) [48] IDIV [49] ISTORE(14) [50] ILOAD(14) [51] ICONST_1(Integer{1}) [52] IF_ICMPGE(55)
 */
public final class measureSparseMatmult_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // **REMOVED Unused Var** boolean jump;
         // local_7 7 ; r=2/w=0 : Cached
        int local_7 = frame.getLocal(7).intValue();
         // local_11 11 ; r=2/w=0 : Cached
        KRegister local_11 = frame.getLocal(11);
         // local_12 12 ; r=3/w=0 : Cached
        int local_12 = frame.getLocal(12).intValue();
         // local_13 13 ; r=1/w=1 : Cached
        int local_13;
         // local_14 14 ; r=1/w=1 : Cached
         // **REMOVED Unused Var** int local_14;
         // *********[34] ALOAD(11)
         // **REMOVED Substitution** s0 = local_11;
         // *********[35] ILOAD(12)
         // **REMOVED Substitution** s1 = new KInteger(local_12);
         // *********[36] IALOAD
         // **REMOVED Substitution** index = local_12;
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getIntArray(((KReference)local_11),local_12));
         // *********[37] ISTORE(13)
        local_13 = c_memman.getIntArray(((KReference)local_11),local_12);
         // *********[38] ALOAD(11)
         // **REMOVED Substitution** s0 = local_11;
         // *********[39] ILOAD(12)
         // **REMOVED Substitution** s1 = new KInteger(local_12);
         // *********[40] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[41] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_12 + 1));
         // *********[42] ILOAD(13)
         // **REMOVED Substitution** s2 = new KInteger(local_13);
         // *********[43] ILOAD(7)
         // **REMOVED Substitution** s3 = new KInteger(local_7);
         // *********[44] IADD
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** s2 = new KInteger((local_13 + local_7));
         // *********[45] IASTORE
         // **REMOVED Substitution** m_i = (local_13 + local_7);
         // **REMOVED Substitution** index = (local_12 + 1);
        c_memman.setIntArray(((KReference)local_11),(local_12 + 1),(local_13 + local_7));
         // *********[46] ILOAD(12)
         // **REMOVED Substitution** s0 = new KInteger(local_12);
         // *********[47] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[48] IDIV
         // **REMOVED Substitution** index = local_7;
         // **REMOVED Substitution** s0 = new KInteger((local_12 / local_7));
         // *********[49] ISTORE(14)
         // **REMOVED Substitution** local_14 = (local_12 / local_7);
         // *********[50] ILOAD(14)
         // **REMOVED Substitution** s0 = new KInteger((local_12 / local_7));
         // *********[51] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[52] IF_ICMPGE(55)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = (local_12 / local_7) >= 1;
        frame.setLocal(13,new KInteger(local_13));
        frame.setLocal(14,new KInteger((local_12 / local_7)));
        return (((local_12 / local_7) >= 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[34] ALOAD(11)
         // *********[35] ILOAD(12)
         // *********[36] IALOAD
        c_memman = process.getMemoryManager();
         // *********[37] ISTORE(13)
         // *********[38] ALOAD(11)
         // *********[39] ILOAD(12)
         // *********[40] ICONST_1(Integer{1})
         // *********[41] IADD
         // *********[42] ILOAD(13)
         // *********[43] ILOAD(7)
         // *********[44] IADD
         // *********[45] IASTORE
         // *********[46] ILOAD(12)
         // *********[47] ILOAD(7)
         // *********[48] IDIV
         // *********[49] ISTORE(14)
         // *********[50] ILOAD(14)
         // *********[51] ICONST_1(Integer{1})
         // *********[52] IF_ICMPGE(55)
        c_next = instructions[(index + 1)];
        c_label = instructions[5];
      }
}
