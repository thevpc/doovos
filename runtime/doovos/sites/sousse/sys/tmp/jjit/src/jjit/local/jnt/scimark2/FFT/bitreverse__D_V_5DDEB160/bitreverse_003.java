package jjit.local.jnt.scimark2.FFT.bitreverse__D_V_5DDEB160;
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
 * bitreverse([D)V
 * [count=37] [29] ALOAD(0) [30] ILOAD(5) [31] DALOAD [32] DSTORE(8) [33] ALOAD(0) [34] ILOAD(5) [35] ICONST_1(Integer{1}) [36] IADD [37] DALOAD [38] DSTORE(10) [39] ALOAD(0) [40] ILOAD(5) [41] ALOAD(0) [42] ILOAD(6) [43] DALOAD [44] DASTORE [45] ALOAD(0) [46] ILOAD(5) [47] ICONST_1(Integer{1}) [48] IADD [49] ALOAD(0) [50] ILOAD(6) [51] ICONST_1(Integer{1}) [52] IADD [53] DALOAD [54] DASTORE [55] ALOAD(0) [56] ILOAD(6) [57] DLOAD(8) [58] DASTORE [59] ALOAD(0) [60] ILOAD(6) [61] ICONST_1(Integer{1}) [62] IADD [63] DLOAD(10) [64] DASTORE [65] GOTO(74)
 */
public final class bitreverse_003 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
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
         // local_0 0 ; r=8/w=0 : Cached
        KRegister local_0 = frame.getLocal(0);
         // local_5 5 ; r=4/w=0 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_6 6 ; r=4/w=0 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // local_8 8 ; r=1/w=1 : Cached
        KRegister local_8;
         // local_10 10 ; r=1/w=1 : Cached
        KRegister local_10;
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[30] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[31] DALOAD
         // **REMOVED Substitution** index = local_5;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_5));
         // *********[32] DSTORE(8)
        local_8 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_5));
         // *********[33] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[34] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[35] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[36] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_5 + 1));
         // *********[37] DALOAD
         // **REMOVED Substitution** index = (local_5 + 1);
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_5 + 1)));
         // *********[38] DSTORE(10)
        local_10 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_5 + 1)));
         // *********[39] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[40] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[41] ALOAD(0)
         // **REMOVED Substitution** s2 = local_0;
         // *********[42] ILOAD(6)
         // **REMOVED Substitution** s3 = new KInteger(local_6);
         // *********[43] DALOAD
         // **REMOVED Substitution** index = local_6;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),local_6));
         // *********[44] DASTORE
         // **REMOVED Substitution** m_d = c_memman.getDoubleArray(((KReference)local_0),local_6);
         // **REMOVED Substitution** index = local_5;
        c_memman.setDoubleArray(((KReference)local_0),local_5,c_memman.getDoubleArray(((KReference)local_0),local_6));
         // *********[45] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[46] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[47] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[48] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_5 + 1));
         // *********[49] ALOAD(0)
         // **REMOVED Substitution** s2 = local_0;
         // *********[50] ILOAD(6)
         // **REMOVED Substitution** s3 = new KInteger(local_6);
         // *********[51] ICONST_1(Integer{1})
         // **REMOVED Substitution** s4 = IONE;
         // *********[52] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s3 = new KInteger((local_6 + 1));
         // *********[53] DALOAD
         // **REMOVED Substitution** index = (local_6 + 1);
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_0),(local_6 + 1)));
         // *********[54] DASTORE
         // **REMOVED Substitution** m_d2 = c_memman.getDoubleArray(((KReference)local_0),(local_6 + 1));
         // **REMOVED Substitution** index = (local_5 + 1);
        c_memman.setDoubleArray(((KReference)local_0),(local_5 + 1),c_memman.getDoubleArray(((KReference)local_0),(local_6 + 1)));
         // *********[55] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[56] ILOAD(6)
         // **REMOVED Substitution** s1 = new KInteger(local_6);
         // *********[57] DLOAD(8)
         // **REMOVED Substitution** s2 = local_8;
         // *********[58] DASTORE
         // **REMOVED Substitution** m_d3 = local_8.doubleValue();
         // **REMOVED Substitution** index = local_6;
        c_memman.setDoubleArray(((KReference)local_0),local_6,local_8.doubleValue());
         // *********[59] ALOAD(0)
         // **REMOVED Substitution** s0 = local_0;
         // *********[60] ILOAD(6)
         // **REMOVED Substitution** s1 = new KInteger(local_6);
         // *********[61] ICONST_1(Integer{1})
         // **REMOVED Substitution** s2 = IONE;
         // *********[62] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s1 = new KInteger((local_6 + 1));
         // *********[63] DLOAD(10)
         // **REMOVED Substitution** s2 = local_10;
         // *********[64] DASTORE
         // **REMOVED Substitution** m_d4 = local_10.doubleValue();
         // **REMOVED Substitution** index = (local_6 + 1);
        c_memman.setDoubleArray(((KReference)local_0),(local_6 + 1),local_10.doubleValue());
         // *********[65] GOTO(74)
        frame.setLocal(8,local_8);
        frame.setLocal(10,local_10);
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[29] ALOAD(0)
         // *********[30] ILOAD(5)
         // *********[31] DALOAD
        c_memman = process.getMemoryManager();
         // *********[32] DSTORE(8)
         // *********[33] ALOAD(0)
         // *********[34] ILOAD(5)
         // *********[35] ICONST_1(Integer{1})
         // *********[36] IADD
         // *********[37] DALOAD
         // *********[38] DSTORE(10)
         // *********[39] ALOAD(0)
         // *********[40] ILOAD(5)
         // *********[41] ALOAD(0)
         // *********[42] ILOAD(6)
         // *********[43] DALOAD
         // *********[44] DASTORE
         // *********[45] ALOAD(0)
         // *********[46] ILOAD(5)
         // *********[47] ICONST_1(Integer{1})
         // *********[48] IADD
         // *********[49] ALOAD(0)
         // *********[50] ILOAD(6)
         // *********[51] ICONST_1(Integer{1})
         // *********[52] IADD
         // *********[53] DALOAD
         // *********[54] DASTORE
         // *********[55] ALOAD(0)
         // *********[56] ILOAD(6)
         // *********[57] DLOAD(8)
         // *********[58] DASTORE
         // *********[59] ALOAD(0)
         // *********[60] ILOAD(6)
         // *********[61] ICONST_1(Integer{1})
         // *********[62] IADD
         // *********[63] DLOAD(10)
         // *********[64] DASTORE
         // *********[65] GOTO(74)
        c_label = instructions[4];
      }
}
