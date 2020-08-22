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
 * [count=15] [11] DCONST_0(Double{0.0}) [12] DSTORE(9) [13] ALOAD(2) [14] ILOAD(8) [15] IALOAD [16] ISTORE(11) [17] ALOAD(2) [18] ILOAD(8) [19] ICONST_1(Integer{1}) [20] IADD [21] IALOAD [22] ISTORE(12) [23] ILOAD(11) [24] ISTORE(13) [25] GOTO(39)
 */
public final class matmult_003 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble DZERO = KDouble.ZERO;
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
         // local_2 2 ; r=2/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // local_8 8 ; r=2/w=0 : Cached
        int local_8 = frame.getLocal(8).intValue();
         // local_9 9 ; r=0/w=1 : NotCached
         // local_11 11 ; r=1/w=1 : Cached
        int local_11;
         // local_12 12 ; r=0/w=1 : NotCached
         // local_13 13 ; r=0/w=1 : NotCached
         // *********[11] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s0 = DZERO;
         // *********[12] DSTORE(9)
        frame.setLocal(9,DZERO);
         // *********[13] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[14] ILOAD(8)
         // **REMOVED Substitution** s1 = new KInteger(local_8);
         // *********[15] IALOAD
         // **REMOVED Substitution** index = local_8;
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getIntArray(((KReference)local_2),local_8));
         // *********[16] ISTORE(11)
        local_11 = c_memman.getIntArray(((KReference)local_2),local_8);
         // *********[17] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[18] ILOAD(8)
         // **REMOVED Substitution** s1 = new KInteger(local_8);
         // *********[19] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[20] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_8 + 1));
         // *********[21] IALOAD
         // **REMOVED Substitution** index = (local_8 + 1);
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getIntArray(((KReference)local_2),(local_8 + 1)));
         // *********[22] ISTORE(12)
        frame.setLocal(12,new KInteger(c_memman.getIntArray(((KReference)local_2),(local_8 + 1))));
         // *********[23] ILOAD(11)
         // **REMOVED Substitution** s0 = new KInteger(local_11);
         // *********[24] ISTORE(13)
        frame.setLocal(13,new KInteger(local_11));
         // *********[25] GOTO(39)
        frame.setLocal(11,new KInteger(local_11));
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] DCONST_0(Double{0.0})
         // *********[12] DSTORE(9)
         // *********[13] ALOAD(2)
         // *********[14] ILOAD(8)
         // *********[15] IALOAD
        c_memman = process.getMemoryManager();
         // *********[16] ISTORE(11)
         // *********[17] ALOAD(2)
         // *********[18] ILOAD(8)
         // *********[19] ICONST_1(Integer{1})
         // *********[20] IADD
         // *********[21] IALOAD
         // *********[22] ISTORE(12)
         // *********[23] ILOAD(11)
         // *********[24] ISTORE(13)
         // *********[25] GOTO(39)
        c_label = instructions[4];
      }
}
