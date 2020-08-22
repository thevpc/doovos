package jjit.local.jnt.scimark2.kernel.CopyMatrix___D__D_V_4E84EC1A;
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
 * CopyMatrix([[D[[D)V
 * [count=37] [39] ALOAD(6) [40] ILOAD(9) [41] ALOAD(7) [42] ILOAD(9) [43] DALOAD [44] DASTORE [45] ALOAD(6) [46] ILOAD(9) [47] ICONST_1(Integer{1}) [48] IADD [49] ALOAD(7) [50] ILOAD(9) [51] ICONST_1(Integer{1}) [52] IADD [53] DALOAD [54] DASTORE [55] ALOAD(6) [56] ILOAD(9) [57] ICONST_2(Integer{2}) [58] IADD [59] ALOAD(7) [60] ILOAD(9) [61] ICONST_2(Integer{2}) [62] IADD [63] DALOAD [64] DASTORE [65] ALOAD(6) [66] ILOAD(9) [67] ICONST_3(Integer{3}) [68] IADD [69] ALOAD(7) [70] ILOAD(9) [71] ICONST_3(Integer{3}) [72] IADD [73] DALOAD [74] DASTORE [75] IINC(9,4)
 */
public final class CopyMatrix_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // local_6 6 ; r=4/w=0 : Cached
        KRegister local_6 = frame.getLocal(6);
         // local_7 7 ; r=4/w=0 : Cached
        KRegister local_7 = frame.getLocal(7);
         // local_9 9 ; r=9/w=1 : Cached
        int local_9 = frame.getLocal(9).intValue();
         // *********[39] ALOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[40] ILOAD(9)
         // **REMOVED Substitution** s1 = new KInteger(local_9);
         // *********[41] ALOAD(7)
         // **REMOVED Substitution** s2 = local_7;
         // *********[42] ILOAD(9)
         // **REMOVED Substitution** s3 = new KInteger(local_9);
         // *********[43] DALOAD
         // **REMOVED Substitution** index = local_9;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_7),local_9));
         // *********[44] DASTORE
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)local_7),local_9);
         // **REMOVED Substitution** index = local_9;
        c_memman.setDoubleArray(((KReference)local_6),local_9,c_memman.getDoubleArray(((KReference)local_7),local_9));
         // *********[45] ALOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[46] ILOAD(9)
         // **REMOVED Substitution** s1 = new KInteger(local_9);
         // *********[47] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[48] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_9 + 1));
         // *********[49] ALOAD(7)
         // **REMOVED Substitution** s2 = local_7;
         // *********[50] ILOAD(9)
         // **REMOVED Substitution** s3 = new KInteger(local_9);
         // *********[51] ICONST_1(Integer{1})
         // **REMOVED Substitution** s4 = IONE;
         // *********[52] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s3 = new KInteger((local_9 + 1));
         // *********[53] DALOAD
         // **REMOVED Substitution** index = (local_9 + 1);
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_7),(local_9 + 1)));
         // *********[54] DASTORE
         // **REMOVED Substitution** m_d2 = c_memman.getDoubleArray(((KReference)local_7),(local_9 + 1));
         // **REMOVED Substitution** index = (local_9 + 1);
        c_memman.setDoubleArray(((KReference)local_6),(local_9 + 1),c_memman.getDoubleArray(((KReference)local_7),(local_9 + 1)));
         // *********[55] ALOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[56] ILOAD(9)
         // **REMOVED Substitution** s1 = new KInteger(local_9);
         // *********[57] ICONST_2(Integer{2})
         // **REMOVED Substitution** s2 = ITWO;
         // *********[58] IADD
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s1 = new KInteger((local_9 + 2));
         // *********[59] ALOAD(7)
         // **REMOVED Substitution** s2 = local_7;
         // *********[60] ILOAD(9)
         // **REMOVED Substitution** s3 = new KInteger(local_9);
         // *********[61] ICONST_2(Integer{2})
         // **REMOVED Substitution** s4 = ITWO;
         // *********[62] IADD
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s3 = new KInteger((local_9 + 2));
         // *********[63] DALOAD
         // **REMOVED Substitution** index = (local_9 + 2);
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_7),(local_9 + 2)));
         // *********[64] DASTORE
         // **REMOVED Substitution** m_d3 = c_memman.getDoubleArray(((KReference)local_7),(local_9 + 2));
         // **REMOVED Substitution** index = (local_9 + 2);
        c_memman.setDoubleArray(((KReference)local_6),(local_9 + 2),c_memman.getDoubleArray(((KReference)local_7),(local_9 + 2)));
         // *********[65] ALOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[66] ILOAD(9)
         // **REMOVED Substitution** s1 = new KInteger(local_9);
         // *********[67] ICONST_3(Integer{3})
         // **REMOVED Substitution** s2 = ITHREE;
         // *********[68] IADD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s1 = new KInteger((local_9 + 3));
         // *********[69] ALOAD(7)
         // **REMOVED Substitution** s2 = local_7;
         // *********[70] ILOAD(9)
         // **REMOVED Substitution** s3 = new KInteger(local_9);
         // *********[71] ICONST_3(Integer{3})
         // **REMOVED Substitution** s4 = ITHREE;
         // *********[72] IADD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s3 = new KInteger((local_9 + 3));
         // *********[73] DALOAD
         // **REMOVED Substitution** index = (local_9 + 3);
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_7),(local_9 + 3)));
         // *********[74] DASTORE
         // **REMOVED Substitution** m_d4 = c_memman.getDoubleArray(((KReference)local_7),(local_9 + 3));
         // **REMOVED Substitution** index = (local_9 + 3);
        c_memman.setDoubleArray(((KReference)local_6),(local_9 + 3),c_memman.getDoubleArray(((KReference)local_7),(local_9 + 3)));
         // *********[75] IINC(9,4)
         // **REMOVED Substitution** local_9 = (local_9 + 4);
        frame.setLocal(9,new KInteger((local_9 + 4)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] ALOAD(6)
         // *********[40] ILOAD(9)
         // *********[41] ALOAD(7)
         // *********[42] ILOAD(9)
         // *********[43] DALOAD
        c_memman = process.getMemoryManager();
         // *********[44] DASTORE
         // *********[45] ALOAD(6)
         // *********[46] ILOAD(9)
         // *********[47] ICONST_1(Integer{1})
         // *********[48] IADD
         // *********[49] ALOAD(7)
         // *********[50] ILOAD(9)
         // *********[51] ICONST_1(Integer{1})
         // *********[52] IADD
         // *********[53] DALOAD
         // *********[54] DASTORE
         // *********[55] ALOAD(6)
         // *********[56] ILOAD(9)
         // *********[57] ICONST_2(Integer{2})
         // *********[58] IADD
         // *********[59] ALOAD(7)
         // *********[60] ILOAD(9)
         // *********[61] ICONST_2(Integer{2})
         // *********[62] IADD
         // *********[63] DALOAD
         // *********[64] DASTORE
         // *********[65] ALOAD(6)
         // *********[66] ILOAD(9)
         // *********[67] ICONST_3(Integer{3})
         // *********[68] IADD
         // *********[69] ALOAD(7)
         // *********[70] ILOAD(9)
         // *********[71] ICONST_3(Integer{3})
         // *********[72] IADD
         // *********[73] DALOAD
         // *********[74] DASTORE
         // *********[75] IINC(9,4)
        c_next = instructions[(index + 1)];
      }
}
