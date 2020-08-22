package jjit.local.jnt.scimark2.Jacobi.SOR_D__DI_V_764DB604;
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
 * jnt.scimark2.Jacobi
 * SOR(D[[DI)V
 * [count=31] [49] ALOAD(14) [50] ILOAD(17) [51] DLOAD(6) [52] ALOAD(15) [53] ILOAD(17) [54] DALOAD [55] ALOAD(16) [56] ILOAD(17) [57] DALOAD [58] DADD [59] ALOAD(14) [60] ILOAD(17) [61] ICONST_1(Integer{1}) [62] ISUB [63] DALOAD [64] DADD [65] ALOAD(14) [66] ILOAD(17) [67] ICONST_1(Integer{1}) [68] IADD [69] DALOAD [70] DADD [71] DMUL [72] DLOAD(8) [73] ALOAD(14) [74] ILOAD(17) [75] DALOAD [76] DMUL [77] DADD [78] DASTORE [79] IINC(17,1)
 */
public final class SOR_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s6;
         // **REMOVED Unused Var** KRegister s5;
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
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** double m_d7;
         // local_17 17 ; r=7/w=1 : Cached
        int local_17 = frame.getLocal(17).intValue();
         // local_16 16 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=0 : NotCached
         // local_8 8 ; r=1/w=0 : NotCached
         // local_14 14 ; r=4/w=0 : Cached
        KRegister local_14 = frame.getLocal(14);
         // local_15 15 ; r=1/w=0 : NotCached
         // *********[49] ALOAD(14)
         // **REMOVED Substitution** s0 = local_14;
         // *********[50] ILOAD(17)
         // **REMOVED Substitution** s1 = new KInteger(local_17);
         // *********[51] DLOAD(6)
         // **REMOVED Substitution** s2 = frame.getLocal(6);
         // *********[52] ALOAD(15)
         // **REMOVED Substitution** s3 = frame.getLocal(15);
         // *********[53] ILOAD(17)
         // **REMOVED Substitution** s4 = new KInteger(local_17);
         // *********[54] DALOAD
         // **REMOVED Substitution** index = local_17;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17));
         // *********[55] ALOAD(16)
         // **REMOVED Substitution** s4 = frame.getLocal(16);
         // *********[56] ILOAD(17)
         // **REMOVED Substitution** s5 = new KInteger(local_17);
         // *********[57] DALOAD
         // **REMOVED Substitution** index = local_17;
         // **REMOVED Substitution** s4 = new KDouble(c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17));
         // *********[58] DADD
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17);
         // **REMOVED Substitution** s3 = new KDouble((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)));
         // *********[59] ALOAD(14)
         // **REMOVED Substitution** s4 = local_14;
         // *********[60] ILOAD(17)
         // **REMOVED Substitution** s5 = new KInteger(local_17);
         // *********[61] ICONST_1(Integer{1})
         // **REMOVED Substitution** s6 = IONE;
         // *********[62] ISUB
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s5 = new KInteger((local_17 - 1));
         // *********[63] DALOAD
         // **REMOVED Substitution** index = (local_17 - 1);
         // **REMOVED Substitution** s4 = new KDouble(c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1)));
         // *********[64] DADD
         // **REMOVED Substitution** m_d2 = c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1));
         // **REMOVED Substitution** s3 = new KDouble(((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)) + c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1))));
         // *********[65] ALOAD(14)
         // **REMOVED Substitution** s4 = local_14;
         // *********[66] ILOAD(17)
         // **REMOVED Substitution** s5 = new KInteger(local_17);
         // *********[67] ICONST_1(Integer{1})
         // **REMOVED Substitution** s6 = IONE;
         // *********[68] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s5 = new KInteger((local_17 + 1));
         // *********[69] DALOAD
         // **REMOVED Substitution** index = (local_17 + 1);
         // **REMOVED Substitution** s4 = new KDouble(c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1)));
         // *********[70] DADD
         // **REMOVED Substitution** m_d3 = c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1));
         // **REMOVED Substitution** s3 = new KDouble((((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)) + c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1))) + c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1))));
         // *********[71] DMUL
         // **REMOVED Substitution** m_d4 = (((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)) + c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1))) + c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1)));
         // **REMOVED Substitution** s2 = new KDouble((frame.getLocal(6).doubleValue() * (((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)) + c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1))) + c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1)))));
         // *********[72] DLOAD(8)
         // **REMOVED Substitution** s3 = frame.getLocal(8);
         // *********[73] ALOAD(14)
         // **REMOVED Substitution** s4 = local_14;
         // *********[74] ILOAD(17)
         // **REMOVED Substitution** s5 = new KInteger(local_17);
         // *********[75] DALOAD
         // **REMOVED Substitution** index = local_17;
         // **REMOVED Substitution** s4 = new KDouble(c_memman.getDoubleArray(((KReference)local_14),local_17));
         // *********[76] DMUL
         // **REMOVED Substitution** m_d5 = c_memman.getDoubleArray(((KReference)local_14),local_17);
         // **REMOVED Substitution** s3 = new KDouble((frame.getLocal(8).doubleValue() * c_memman.getDoubleArray(((KReference)local_14),local_17)));
         // *********[77] DADD
         // **REMOVED Substitution** m_d6 = (frame.getLocal(8).doubleValue() * c_memman.getDoubleArray(((KReference)local_14),local_17));
         // **REMOVED Substitution** s2 = new KDouble(((frame.getLocal(6).doubleValue() * (((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)) + c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1))) + c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1)))) + (frame.getLocal(8).doubleValue() * c_memman.getDoubleArray(((KReference)local_14),local_17))));
         // *********[78] DASTORE
         // **REMOVED Substitution** m_d7 = ((frame.getLocal(6).doubleValue() * (((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)) + c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1))) + c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1)))) + (frame.getLocal(8).doubleValue() * c_memman.getDoubleArray(((KReference)local_14),local_17)));
         // **REMOVED Substitution** index = local_17;
        c_memman.setDoubleArray(((KReference)local_14),local_17,((frame.getLocal(6).doubleValue() * (((c_memman.getDoubleArray(((KReference)frame.getLocal(15)),local_17) + c_memman.getDoubleArray(((KReference)frame.getLocal(16)),local_17)) + c_memman.getDoubleArray(((KReference)local_14),(local_17 - 1))) + c_memman.getDoubleArray(((KReference)local_14),(local_17 + 1)))) + (frame.getLocal(8).doubleValue() * c_memman.getDoubleArray(((KReference)local_14),local_17))));
         // *********[79] IINC(17,1)
         // **REMOVED Substitution** local_17 = (local_17 + 1);
        frame.setLocal(17,new KInteger((local_17 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[49] ALOAD(14)
         // *********[50] ILOAD(17)
         // *********[51] DLOAD(6)
         // *********[52] ALOAD(15)
         // *********[53] ILOAD(17)
         // *********[54] DALOAD
        c_memman = process.getMemoryManager();
         // *********[55] ALOAD(16)
         // *********[56] ILOAD(17)
         // *********[57] DALOAD
         // *********[58] DADD
         // *********[59] ALOAD(14)
         // *********[60] ILOAD(17)
         // *********[61] ICONST_1(Integer{1})
         // *********[62] ISUB
         // *********[63] DALOAD
         // *********[64] DADD
         // *********[65] ALOAD(14)
         // *********[66] ILOAD(17)
         // *********[67] ICONST_1(Integer{1})
         // *********[68] IADD
         // *********[69] DALOAD
         // *********[70] DADD
         // *********[71] DMUL
         // *********[72] DLOAD(8)
         // *********[73] ALOAD(14)
         // *********[74] ILOAD(17)
         // *********[75] DALOAD
         // *********[76] DMUL
         // *********[77] DADD
         // *********[78] DASTORE
         // *********[79] IINC(17,1)
        c_next = instructions[(index + 1)];
      }
}
