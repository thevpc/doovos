package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
import java.lang.Math;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.FFT
 * transform_internal([DI)V
 * [count=33] [23] DCONST_1(Double{1.0}) [24] DSTORE(6) [25] DCONST_0(Double{0.0}) [26] DSTORE(8) [27] LDC(5->"2.0") [28] ILOAD(1) [29] I2D [30] DMUL [31] LDC(33->"3.141592653589793") [32] DMUL [33] LDC(5->"2.0") [34] ILOAD(5) [35] I2D [36] DMUL [37] DDIV [38] DSTORE(10) [39] DLOAD(10) [40] INVOKE_HOST(java.lang.Math.sin(D)D) [41] DSTORE(12) [42] DLOAD(10) [43] LDC(5->"2.0") [44] DDIV [45] INVOKE_HOST(java.lang.Math.sin(D)D) [46] DSTORE(14) [47] LDC(5->"2.0") [48] DLOAD(14) [49] DMUL [50] DLOAD(14) [51] DMUL [52] DSTORE(16) [53] ICONST_0(Integer{0}) [54] ISTORE(18) [55] GOTO(118)
 */
public final class transform_internal_008 extends JJITAbstractInstruction implements Cloneable{
      private static final KDouble DONE = KDouble.ONE;
      private static final KDouble DZERO = KDouble.ZERO;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v4;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_v5;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** double m_d7;
         // local_16 16 ; r=0/w=1 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_18 18 ; r=0/w=1 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=0/w=1 : NotCached
         // local_8 8 ; r=0/w=1 : NotCached
         // local_10 10 ; r=2/w=1 : Cached
        KRegister local_10;
         // local_12 12 ; r=0/w=1 : NotCached
         // local_14 14 ; r=2/w=1 : Cached
        KRegister local_14;
         // *********[23] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s0 = DONE;
         // *********[24] DSTORE(6)
        frame.setLocal(6,DONE);
         // *********[25] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s0 = DZERO;
         // *********[26] DSTORE(8)
        frame.setLocal(8,DZERO);
         // *********[27] LDC(5->"2.0")
         // **REMOVED Substitution** s0 = D2_0;
         // *********[28] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[29] I2D
         // **REMOVED Substitution** s1 = new KDouble(frame.getLocal(1).intValue());
         // *********[30] DMUL
         // **REMOVED Substitution** m_d = frame.getLocal(1).doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((2.0D * frame.getLocal(1).doubleValue()));
         // *********[31] LDC(33->"3.141592653589793")
         // **REMOVED Substitution** s1 = D3_141592653589793;
         // *********[32] DMUL
         // **REMOVED Substitution** m_d2 = 3.141592653589793D;
         // **REMOVED Substitution** s0 = new KDouble(((2.0D * frame.getLocal(1).doubleValue()) * 3.141592653589793D));
         // *********[33] LDC(5->"2.0")
         // **REMOVED Substitution** s1 = D2_0;
         // *********[34] ILOAD(5)
         // **REMOVED Substitution** s2 = frame.getLocal(5);
         // *********[35] I2D
         // **REMOVED Substitution** s2 = new KDouble(frame.getLocal(5).intValue());
         // *********[36] DMUL
         // **REMOVED Substitution** m_d3 = frame.getLocal(5).doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((2.0D * frame.getLocal(5).doubleValue()));
         // *********[37] DDIV
         // **REMOVED Substitution** m_d4 = (2.0D * frame.getLocal(5).doubleValue());
         // **REMOVED Substitution** s0 = new KDouble((((2.0D * frame.getLocal(1).doubleValue()) * 3.141592653589793D) / (2.0D * frame.getLocal(5).doubleValue())));
         // *********[38] DSTORE(10)
        local_10 = new KDouble((((2.0D * frame.getLocal(1).doubleValue()) * 3.141592653589793D) / (2.0D * frame.getLocal(5).doubleValue())));
         // *********[39] DLOAD(10)
         // **REMOVED Substitution** s0 = local_10;
         // *********[40] INVOKE_HOST(java.lang.Math.sin(D)D)
         // **REMOVED Substitution** m_v4 = local_10.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble(Math.sin(local_10.doubleValue()));
         // *********[41] DSTORE(12)
        frame.setLocal(12,new KDouble(Math.sin(local_10.doubleValue())));
         // *********[42] DLOAD(10)
         // **REMOVED Substitution** s0 = local_10;
         // *********[43] LDC(5->"2.0")
         // **REMOVED Substitution** s1 = D2_0;
         // *********[44] DDIV
         // **REMOVED Substitution** m_d5 = 2.0D;
         // **REMOVED Substitution** s0 = new KDouble((local_10.doubleValue() / 2.0D));
         // *********[45] INVOKE_HOST(java.lang.Math.sin(D)D)
         // **REMOVED Substitution** m_v5 = (local_10.doubleValue() / 2.0D);
         // **REMOVED Substitution** s0 = new KDouble(Math.sin((local_10.doubleValue() / 2.0D)));
         // *********[46] DSTORE(14)
        local_14 = new KDouble(Math.sin((local_10.doubleValue() / 2.0D)));
         // *********[47] LDC(5->"2.0")
         // **REMOVED Substitution** s0 = D2_0;
         // *********[48] DLOAD(14)
         // **REMOVED Substitution** s1 = local_14;
         // *********[49] DMUL
         // **REMOVED Substitution** m_d6 = local_14.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((2.0D * local_14.doubleValue()));
         // *********[50] DLOAD(14)
         // **REMOVED Substitution** s1 = local_14;
         // *********[51] DMUL
         // **REMOVED Substitution** m_d7 = local_14.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble(((2.0D * local_14.doubleValue()) * local_14.doubleValue()));
         // *********[52] DSTORE(16)
        frame.setLocal(16,new KDouble(((2.0D * local_14.doubleValue()) * local_14.doubleValue())));
         // *********[53] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[54] ISTORE(18)
        frame.setLocal(18,KInteger.ZERO);
         // *********[55] GOTO(118)
        frame.setLocal(10,local_10);
        frame.setLocal(14,local_14);
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[23] DCONST_1(Double{1.0})
         // *********[24] DSTORE(6)
         // *********[25] DCONST_0(Double{0.0})
         // *********[26] DSTORE(8)
         // *********[27] LDC(5->"2.0")
         // *********[28] ILOAD(1)
         // *********[29] I2D
         // *********[30] DMUL
         // *********[31] LDC(33->"3.141592653589793")
         // *********[32] DMUL
         // *********[33] LDC(5->"2.0")
         // *********[34] ILOAD(5)
         // *********[35] I2D
         // *********[36] DMUL
         // *********[37] DDIV
         // *********[38] DSTORE(10)
         // *********[39] DLOAD(10)
         // *********[40] INVOKE_HOST(java.lang.Math.sin(D)D)
         // *********[41] DSTORE(12)
         // *********[42] DLOAD(10)
         // *********[43] LDC(5->"2.0")
         // *********[44] DDIV
         // *********[45] INVOKE_HOST(java.lang.Math.sin(D)D)
         // *********[46] DSTORE(14)
         // *********[47] LDC(5->"2.0")
         // *********[48] DLOAD(14)
         // *********[49] DMUL
         // *********[50] DLOAD(14)
         // *********[51] DMUL
         // *********[52] DSTORE(16)
         // *********[53] ICONST_0(Integer{0})
         // *********[54] ISTORE(18)
         // *********[55] GOTO(118)
        c_label = instructions[9];
      }
}
