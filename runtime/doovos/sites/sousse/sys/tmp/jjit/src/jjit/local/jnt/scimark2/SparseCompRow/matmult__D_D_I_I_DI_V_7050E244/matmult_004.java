package jjit.local.jnt.scimark2.SparseCompRow.matmult__D_D_I_I_DI_V_7050E244;
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
 * jnt.scimark2.SparseCompRow
 * matmult([D[D[I[I[DI)V
 * [count=13] [26] DLOAD(9) [27] ALOAD(4) [28] ALOAD(3) [29] ILOAD(13) [30] IALOAD [31] DALOAD [32] ALOAD(1) [33] ILOAD(13) [34] DALOAD [35] DMUL [36] DADD [37] DSTORE(9) [38] IINC(13,1)
 */
public final class matmult_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // local_9 9 ; r=1/w=1 : Cached
        KRegister local_9 = frame.getLocal(9);
         // local_13 13 ; r=3/w=1 : Cached
        int local_13 = frame.getLocal(13).intValue();
         // *********[26] DLOAD(9)
         // **REMOVED Substitution** s0 = local_9;
         // *********[27] ALOAD(4)
         // **REMOVED Substitution** s1 = frame.getLocal(4);
         // *********[28] ALOAD(3)
         // **REMOVED Substitution** s2 = frame.getLocal(3);
         // *********[29] ILOAD(13)
         // **REMOVED Substitution** s3 = new KInteger(local_13);
         // *********[30] IALOAD
         // **REMOVED Substitution** index = local_13;
         // **REMOVED Substitution** s2 = new KInteger(c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13));
         // *********[31] DALOAD
         // **REMOVED Substitution** index = c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13);
         // **REMOVED Substitution** s1 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(4)),c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13)));
         // *********[32] ALOAD(1)
         // **REMOVED Substitution** s2 = frame.getLocal(1);
         // *********[33] ILOAD(13)
         // **REMOVED Substitution** s3 = new KInteger(local_13);
         // *********[34] DALOAD
         // **REMOVED Substitution** index = local_13;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_13));
         // *********[35] DMUL
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_13);
         // **REMOVED Substitution** s1 = new KDouble((c_memman.getDoubleArray(((KReference)frame.getLocal(4)),c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13)) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_13)));
         // *********[36] DADD
         // **REMOVED Substitution** m_d2 = (c_memman.getDoubleArray(((KReference)frame.getLocal(4)),c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13)) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_13));
         // **REMOVED Substitution** s0 = new KDouble((local_9.doubleValue() + (c_memman.getDoubleArray(((KReference)frame.getLocal(4)),c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13)) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_13))));
         // *********[37] DSTORE(9)
         // **REMOVED Substitution** local_9 = new KDouble((local_9.doubleValue() + (c_memman.getDoubleArray(((KReference)frame.getLocal(4)),c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13)) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_13))));
         // *********[38] IINC(13,1)
         // **REMOVED Substitution** local_13 = (local_13 + 1);
        frame.setLocal(9,new KDouble((local_9.doubleValue() + (c_memman.getDoubleArray(((KReference)frame.getLocal(4)),c_memman.getIntArray(((KReference)frame.getLocal(3)),local_13)) * c_memman.getDoubleArray(((KReference)frame.getLocal(1)),local_13)))));
        frame.setLocal(13,new KInteger((local_13 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[26] DLOAD(9)
         // *********[27] ALOAD(4)
         // *********[28] ALOAD(3)
         // *********[29] ILOAD(13)
         // *********[30] IALOAD
        c_memman = process.getMemoryManager();
         // *********[31] DALOAD
         // *********[32] ALOAD(1)
         // *********[33] ILOAD(13)
         // *********[34] DALOAD
         // *********[35] DMUL
         // *********[36] DADD
         // *********[37] DSTORE(9)
         // *********[38] IINC(13,1)
        c_next = instructions[(index + 1)];
      }
}
