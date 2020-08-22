package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
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
 * jnt.scimark2.FFT
 * transform_internal([DI)V
 * [count=62] [56] ICONST_2(Integer{2}) [57] ILOAD(18) [58] IMUL [59] ISTORE(19) [60] ICONST_2(Integer{2}) [61] ILOAD(18) [62] ILOAD(5) [63] IADD [64] IMUL [65] ISTORE(20) [66] ALOAD(0) [67] ILOAD(20) [68] DALOAD [69] DSTORE(21) [70] ALOAD(0) [71] ILOAD(20) [72] ICONST_1(Integer{1}) [73] IADD [74] DALOAD [75] DSTORE(23) [76] ALOAD(0) [77] ILOAD(20) [78] ALOAD(0) [79] ILOAD(19) [80] DALOAD [81] DLOAD(21) [82] DSUB [83] DASTORE [84] ALOAD(0) [85] ILOAD(20) [86] ICONST_1(Integer{1}) [87] IADD [88] ALOAD(0) [89] ILOAD(19) [90] ICONST_1(Integer{1}) [91] IADD [92] DALOAD [93] DLOAD(23) [94] DSUB [95] DASTORE [96] ALOAD(0) [97] ILOAD(19) [98] DUP2Type1 [99] DALOAD [100] DLOAD(21) [101] DADD [102] DASTORE [103] ALOAD(0) [104] ILOAD(19) [105] ICONST_1(Integer{1}) [106] IADD [107] DUP2Type1 [108] DALOAD [109] DLOAD(23) [110] DADD [111] DASTORE [112] ILOAD(18) [113] ICONST_2(Integer{2}) [114] ILOAD(5) [115] IMUL [116] IADD [117] ISTORE(18)
 */
public final class transform_internal_009 extends JJITAbstractInstruction implements Cloneable{
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
        KRegister reg;
         // **REMOVED Unused Var** KRegister reg2;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** double m_d7;
         // **REMOVED Unused Var** double m_d8;
         // local_0 0 ; r=8/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_19 19 ; r=4/w=1 : Cached
         // **REMOVED Unused Var** int local_19;
         // local_18 18 ; r=3/w=1 : Cached
        int local_18 = frame.getLocal(18).intValue();
         // local_21 21 ; r=2/w=1 : Cached
        KRegister local_21;
         // local_20 20 ; r=4/w=1 : Cached
        int local_20;
         // local_5 5 ; r=2/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_23 23 ; r=2/w=1 : Cached
        KRegister local_23;
         // *********[56] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[57] ILOAD(18)
         // **REMOVED Substitution** s1 = new KInteger(local_18);
         // *********[58] IMUL
         // **REMOVED Substitution** index = local_18;
         // **REMOVED Substitution** s0 = new KInteger((2 * local_18));
         // *********[59] ISTORE(19)
         // **REMOVED Substitution** local_19 = (2 * local_18);
         // *********[60] ICONST_2(Integer{2})
         // **REMOVED Substitution** s0 = ITWO;
         // *********[61] ILOAD(18)
         // **REMOVED Substitution** s1 = new KInteger(local_18);
         // *********[62] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[63] IADD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s1 = new KInteger((local_18 + local_5));
         // *********[64] IMUL
         // **REMOVED Substitution** index = (local_18 + local_5);
         // **REMOVED Substitution** s0 = new KInteger((2 * (local_18 + local_5)));
         // *********[65] ISTORE(20)
        local_20 = (2 * (local_18 + local_5));
         // *********[66] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[67] ILOAD(20)
         // **REMOVED Substitution** s1 = new KInteger(local_20);
         // *********[68] DALOAD
         // **REMOVED Substitution** index = local_20;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_20));
         // *********[69] DSTORE(21)
        local_21 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_20));
         // *********[70] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[71] ILOAD(20)
         // **REMOVED Substitution** s1 = new KInteger(local_20);
         // *********[72] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[73] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_20 + 1));
         // *********[74] DALOAD
         // **REMOVED Substitution** index = (local_20 + 1);
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_20 + 1)));
         // *********[75] DSTORE(23)
        local_23 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_20 + 1)));
         // *********[76] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[77] ILOAD(20)
         // **REMOVED Substitution** s1 = new KInteger(local_20);
         // *********[78] ALOAD(0)
         // **REMOVED Substitution** s2 = local_0;
         // *********[79] ILOAD(19)
         // **REMOVED Substitution** s3 = new KInteger(local_19);
         // *********[80] DALOAD
         // **REMOVED Substitution** index = local_19;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_19));
         // *********[81] DLOAD(21)
         // **REMOVED Substitution** s3 = local_21;
         // *********[82] DSUB
         // **REMOVED Substitution** m_d = local_21.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),local_19) - local_21.doubleValue()));
         // *********[83] DASTORE
         // **REMOVED Substitution** m_d2 = (c_memman.getDoubleArray(((KReference)local_0),local_19) - local_21.doubleValue());
         // **REMOVED Substitution** index = local_20;
        c_memman.setDoubleArray(((KReference)local_0),local_20,(c_memman.getDoubleArray(((KReference)local_0),(2 * local_18)) - local_21.doubleValue()));
         // *********[84] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[85] ILOAD(20)
         // **REMOVED Substitution** s1 = new KInteger(local_20);
         // *********[86] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[87] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_20 + 1));
         // *********[88] ALOAD(0)
         // **REMOVED Substitution** s2 = local_0;
         // *********[89] ILOAD(19)
         // **REMOVED Substitution** s3 = new KInteger(local_19);
         // *********[90] ICONST_1(Integer{1})
         // **REMOVED Substitution** s4 = IONE;
         // *********[91] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s3 = new KInteger((local_19 + 1));
         // *********[92] DALOAD
         // **REMOVED Substitution** index = (local_19 + 1);
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_19 + 1)));
         // *********[93] DLOAD(23)
         // **REMOVED Substitution** s3 = local_23;
         // *********[94] DSUB
         // **REMOVED Substitution** m_d3 = local_23.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),(local_19 + 1)) - local_23.doubleValue()));
         // *********[95] DASTORE
         // **REMOVED Substitution** m_d4 = (c_memman.getDoubleArray(((KReference)local_0),(local_19 + 1)) - local_23.doubleValue());
         // **REMOVED Substitution** index = (local_20 + 1);
        c_memman.setDoubleArray(((KReference)local_0),(local_20 + 1),(c_memman.getDoubleArray(((KReference)local_0),((2 * local_18) + 1)) - local_23.doubleValue()));
         // *********[96] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[97] ILOAD(19)
         // **REMOVED Substitution** s1 = new KInteger(local_19);
         // *********[98] DUP2Type1
         // **REMOVED Substitution** reg = new KInteger(local_19);
         // **REMOVED Substitution** reg2 = local_0;
         // **REMOVED Substitution** s1 = new KInteger(local_19);
         // **REMOVED Substitution** s2 = local_0;
         // **REMOVED Substitution** s3 = new KInteger(local_19);
         // *********[99] DALOAD
         // **REMOVED Substitution** index = local_19;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_19));
         // *********[100] DLOAD(21)
         // **REMOVED Substitution** s3 = local_21;
         // *********[101] DADD
         // **REMOVED Substitution** m_d5 = local_21.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),local_19) + local_21.doubleValue()));
         // *********[102] DASTORE
         // **REMOVED Substitution** m_d6 = (c_memman.getDoubleArray(((KReference)local_0),local_19) + local_21.doubleValue());
         // **REMOVED Substitution** index = local_19;
        c_memman.setDoubleArray(((KReference)local_0),(2 * local_18),(c_memman.getDoubleArray(((KReference)local_0),(2 * local_18)) + local_21.doubleValue()));
         // *********[103] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[104] ILOAD(19)
         // **REMOVED Substitution** s1 = new KInteger(local_19);
         // *********[105] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[106] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_19 + 1));
         // *********[107] DUP2Type1
        reg = new KInteger(((2 * local_18) + 1));
         // **REMOVED Substitution** reg2 = local_0;
         // **REMOVED Substitution** s1 = reg;
         // **REMOVED Substitution** s2 = local_0;
         // **REMOVED Substitution** s3 = reg;
         // *********[108] DALOAD
         // **REMOVED Substitution** index = reg.intValue();
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),reg.intValue()));
         // *********[109] DLOAD(23)
         // **REMOVED Substitution** s3 = local_23;
         // *********[110] DADD
         // **REMOVED Substitution** m_d7 = local_23.doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_0),reg.intValue()) + local_23.doubleValue()));
         // *********[111] DASTORE
         // **REMOVED Substitution** m_d8 = (c_memman.getDoubleArray(((KReference)local_0),reg.intValue()) + local_23.doubleValue());
         // **REMOVED Substitution** index = reg.intValue();
        c_memman.setDoubleArray(((KReference)local_0),reg.intValue(),(c_memman.getDoubleArray(((KReference)local_0),reg.intValue()) + local_23.doubleValue()));
         // *********[112] ILOAD(18)
         // **REMOVED Substitution** s0 = new KInteger(local_18);
         // *********[113] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[114] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger(local_5);
         // *********[115] IMUL
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s1 = new KInteger((2 * local_5));
         // *********[116] IADD
         // **REMOVED Substitution** index = (2 * local_5);
         // **REMOVED Substitution** s0 = new KInteger((local_18 + (2 * local_5)));
         // *********[117] ISTORE(18)
         // **REMOVED Substitution** local_18 = (local_18 + (2 * local_5));
        frame.setLocal(19,new KInteger((2 * local_18)));
        frame.setLocal(18,new KInteger((local_18 + (2 * local_5))));
        frame.setLocal(21,local_21);
        frame.setLocal(20,new KInteger(local_20));
        frame.setLocal(23,local_23);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[56] ICONST_2(Integer{2})
         // *********[57] ILOAD(18)
         // *********[58] IMUL
         // *********[59] ISTORE(19)
         // *********[60] ICONST_2(Integer{2})
         // *********[61] ILOAD(18)
         // *********[62] ILOAD(5)
         // *********[63] IADD
         // *********[64] IMUL
         // *********[65] ISTORE(20)
         // *********[66] ALOAD(0)
         // *********[67] ILOAD(20)
         // *********[68] DALOAD
        c_memman = process.getMemoryManager();
         // *********[69] DSTORE(21)
         // *********[70] ALOAD(0)
         // *********[71] ILOAD(20)
         // *********[72] ICONST_1(Integer{1})
         // *********[73] IADD
         // *********[74] DALOAD
         // *********[75] DSTORE(23)
         // *********[76] ALOAD(0)
         // *********[77] ILOAD(20)
         // *********[78] ALOAD(0)
         // *********[79] ILOAD(19)
         // *********[80] DALOAD
         // *********[81] DLOAD(21)
         // *********[82] DSUB
         // *********[83] DASTORE
         // *********[84] ALOAD(0)
         // *********[85] ILOAD(20)
         // *********[86] ICONST_1(Integer{1})
         // *********[87] IADD
         // *********[88] ALOAD(0)
         // *********[89] ILOAD(19)
         // *********[90] ICONST_1(Integer{1})
         // *********[91] IADD
         // *********[92] DALOAD
         // *********[93] DLOAD(23)
         // *********[94] DSUB
         // *********[95] DASTORE
         // *********[96] ALOAD(0)
         // *********[97] ILOAD(19)
         // *********[98] DUP2Type1
         // *********[99] DALOAD
         // *********[100] DLOAD(21)
         // *********[101] DADD
         // *********[102] DASTORE
         // *********[103] ALOAD(0)
         // *********[104] ILOAD(19)
         // *********[105] ICONST_1(Integer{1})
         // *********[106] IADD
         // *********[107] DUP2Type1
         // *********[108] DALOAD
         // *********[109] DLOAD(23)
         // *********[110] DADD
         // *********[111] DASTORE
         // *********[112] ILOAD(18)
         // *********[113] ICONST_2(Integer{2})
         // *********[114] ILOAD(5)
         // *********[115] IMUL
         // *********[116] IADD
         // *********[117] ISTORE(18)
        c_next = instructions[(index + 1)];
      }
}
