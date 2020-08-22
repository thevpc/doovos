package jjit.local.jnt.scimark2.kernel.measureSparseMatmult_IIDLjnt_scimark2_Random_D_5C715632;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.kernel
 * measureSparseMatmult(IIDLjnt/scimark2/Random;)D
 * [count=16] [18] ASTORE(9) [19] ILOAD(8) [20] NEWARRAY [21] ASTORE(10) [22] ILOAD(0) [23] ICONST_1(Integer{1}) [24] IADD [25] NEWARRAY [26] ASTORE(11) [27] ALOAD(11) [28] ICONST_0(Integer{0}) [29] ICONST_0(Integer{0}) [30] IASTORE [31] ICONST_0(Integer{0}) [32] ISTORE(12) [33] GOTO(71)
 */
public final class measureSparseMatmult_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
        KMemorySegment memseg = frame.getMemorySegment();
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // local_0 0 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_9 9 ; r=0/w=1 : NotCached
         // local_10 10 ; r=0/w=1 : NotCached
         // local_11 11 ; r=1/w=1 : Cached
        KRegister local_11;
         // local_12 12 ; r=0/w=1 : NotCached
         // *********[18] ASTORE(9)
        frame.setLocal(9,frame.pop());
         // *********[19] ILOAD(8)
         // **REMOVED Substitution** s0 = frame.getLocal(8);
         // *********[20] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocIntArray(frame.getLocal(8).intValue());
         // *********[21] ASTORE(10)
        frame.setLocal(10,memseg.allocIntArray(frame.getLocal(8).intValue()));
         // *********[22] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[23] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[24] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((frame.getLocal(0).intValue() + 1));
         // *********[25] NEWARRAY
         // **REMOVED Substitution** s0_ref = memseg.allocIntArray((frame.getLocal(0).intValue() + 1));
         // *********[26] ASTORE(11)
        local_11 = memseg.allocIntArray((frame.getLocal(0).intValue() + 1));
         // *********[27] ALOAD(11)
         // **REMOVED Substitution** s0 = local_11;
         // *********[28] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[29] ICONST_0(Integer{0})
         // **REMOVED Substitution** s2 = IZERO;
         // *********[30] IASTORE
         // **REMOVED Substitution** m_i = 0;
         // **REMOVED Substitution** index = 0;
        c_memman.setIntArray(((KReference)local_11),0,0);
         // *********[31] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[32] ISTORE(12)
        frame.setLocal(12,KInteger.ZERO);
         // *********[33] GOTO(71)
        frame.setLocal(11,local_11);
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] ASTORE(9)
         // *********[19] ILOAD(8)
         // *********[20] NEWARRAY
         // *********[21] ASTORE(10)
         // *********[22] ILOAD(0)
         // *********[23] ICONST_1(Integer{1})
         // *********[24] IADD
         // *********[25] NEWARRAY
         // *********[26] ASTORE(11)
         // *********[27] ALOAD(11)
         // *********[28] ICONST_0(Integer{0})
         // *********[29] ICONST_0(Integer{0})
         // *********[30] IASTORE
        c_memman = process.getMemoryManager();
         // *********[31] ICONST_0(Integer{0})
         // *********[32] ISTORE(12)
         // *********[33] GOTO(71)
        c_label = instructions[9];
      }
}
