package jjit.local.jnt.Bench.Plotter.paint_Ljava_awt_Graphics_V_847ABEA9;
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
 * jnt.Bench.Plotter
 * paint(Ljava/awt/Graphics;)V
 * [count=40] [83] DLOAD(11) [84] DLOAD(9) [85] DSUB [86] INVOKE_HOST(java.lang.Math.log(D)D) [87] LDC(44->"10.0") [88] INVOKE_HOST(java.lang.Math.log(D)D) [89] DDIV [90] INVOKE_HOST(java.lang.Math.floor(D)D) [91] DSTORE(14) [92] LDC(44->"10.0") [93] DLOAD(14) [94] INVOKE_HOST(java.lang.Math.pow(DD)D) [95] DSTORE(16) [96] DLOAD(11) [97] DLOAD(16) [98] DDIV [99] INVOKE_HOST(java.lang.Math.ceil(D)D) [100] DLOAD(16) [101] DMUL [102] DSTORE(11) [103] DLOAD(9) [104] DLOAD(16) [105] DDIV [106] INVOKE_HOST(java.lang.Math.floor(D)D) [107] DLOAD(16) [108] DMUL [109] DSTORE(9) [110] DLOAD(14) [111] D2I [112] ISTORE(18) [113] DLOAD(11) [114] DLOAD(9) [115] DSUB [116] DLOAD(16) [117] DDIV [118] D2I [119] ISTORE(19) [120] ILOAD(19) [121] ICONST_1(Integer{1}) [122] IF_ICMPNE(129)
 */
public final class paint_026 extends JJITAbstractInstruction implements Cloneable{
      private JJITInstruction c_next;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** double m_v;
         // **REMOVED Unused Var** double m_v2;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_v3;
         // **REMOVED Unused Var** double m_v4;
         // **REMOVED Unused Var** double m_v5;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_v6;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** double m_d7;
         // **REMOVED Unused Var** double m_v7;
         // **REMOVED Unused Var** double m_d8;
         // **REMOVED Unused Var** double m_d9;
         // **REMOVED Unused Var** double m_d10;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // local_16 16 ; r=5/w=1 : Cached
        KRegister local_16;
         // local_19 19 ; r=1/w=1 : Cached
        int local_19;
         // local_18 18 ; r=0/w=1 : NotCached
         // local_9 9 ; r=3/w=1 : Cached
        KRegister local_9 = frame.getLocal(9);
         // local_11 11 ; r=3/w=1 : Cached
        KRegister local_11 = frame.getLocal(11);
         // local_14 14 ; r=2/w=1 : Cached
        KRegister local_14;
         // *********[83] DLOAD(11)
         // **REMOVED Substitution** s0 = local_11;
         // *********[84] DLOAD(9)
         // **REMOVED Substitution** s1 = local_9;
         // *********[85] DSUB
         // **REMOVED Substitution** m_d = local_9.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((local_11.doubleValue() - local_9.doubleValue()));
         // *********[86] INVOKE_HOST(java.lang.Math.log(D)D)
         // **REMOVED Substitution** m_v = (local_11.doubleValue() - local_9.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(Math.log((local_11.doubleValue() - local_9.doubleValue())));
         // *********[87] LDC(44->"10.0")
         // **REMOVED Substitution** s1 = D10_0;
         // *********[88] INVOKE_HOST(java.lang.Math.log(D)D)
         // **REMOVED Substitution** m_v2 = 10.0D;
         // **REMOVED Substitution** s1 = new KDouble(Math.log(10.0D));
         // *********[89] DDIV
         // **REMOVED Substitution** m_d2 = Math.log(10.0D);
         // **REMOVED Substitution** s0 = new KDouble((Math.log((local_11.doubleValue() - local_9.doubleValue())) / Math.log(10.0D)));
         // *********[90] INVOKE_HOST(java.lang.Math.floor(D)D)
         // **REMOVED Substitution** m_v3 = (Math.log((local_11.doubleValue() - local_9.doubleValue())) / Math.log(10.0D));
         // **REMOVED Substitution** s0 = new KDouble(Math.floor((Math.log((local_11.doubleValue() - local_9.doubleValue())) / Math.log(10.0D))));
         // *********[91] DSTORE(14)
        local_14 = new KDouble(Math.floor((Math.log((local_11.doubleValue() - local_9.doubleValue())) / Math.log(10.0D))));
         // *********[92] LDC(44->"10.0")
         // **REMOVED Substitution** s0 = D10_0;
         // *********[93] DLOAD(14)
         // **REMOVED Substitution** s1 = local_14;
         // *********[94] INVOKE_HOST(java.lang.Math.pow(DD)D)
         // **REMOVED Substitution** m_v5 = local_14.doubleValue();
         // **REMOVED Substitution** m_v4 = 10.0D;
         // **REMOVED Substitution** s0 = new KDouble(Math.pow(10.0D,local_14.doubleValue()));
         // *********[95] DSTORE(16)
        local_16 = new KDouble(Math.pow(10.0D,local_14.doubleValue()));
         // *********[96] DLOAD(11)
         // **REMOVED Substitution** s0 = local_11;
         // *********[97] DLOAD(16)
         // **REMOVED Substitution** s1 = local_16;
         // *********[98] DDIV
         // **REMOVED Substitution** m_d5 = local_16.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((local_11.doubleValue() / local_16.doubleValue()));
         // *********[99] INVOKE_HOST(java.lang.Math.ceil(D)D)
         // **REMOVED Substitution** m_v6 = (local_11.doubleValue() / local_16.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(Math.ceil((local_11.doubleValue() / local_16.doubleValue())));
         // *********[100] DLOAD(16)
         // **REMOVED Substitution** s1 = local_16;
         // *********[101] DMUL
         // **REMOVED Substitution** m_d6 = local_16.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((Math.ceil((local_11.doubleValue() / local_16.doubleValue())) * local_16.doubleValue()));
         // *********[102] DSTORE(11)
        local_11 = new KDouble((Math.ceil((local_11.doubleValue() / local_16.doubleValue())) * local_16.doubleValue()));
         // *********[103] DLOAD(9)
         // **REMOVED Substitution** s0 = local_9;
         // *********[104] DLOAD(16)
         // **REMOVED Substitution** s1 = local_16;
         // *********[105] DDIV
         // **REMOVED Substitution** m_d7 = local_16.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((local_9.doubleValue() / local_16.doubleValue()));
         // *********[106] INVOKE_HOST(java.lang.Math.floor(D)D)
         // **REMOVED Substitution** m_v7 = (local_9.doubleValue() / local_16.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(Math.floor((local_9.doubleValue() / local_16.doubleValue())));
         // *********[107] DLOAD(16)
         // **REMOVED Substitution** s1 = local_16;
         // *********[108] DMUL
         // **REMOVED Substitution** m_d8 = local_16.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((Math.floor((local_9.doubleValue() / local_16.doubleValue())) * local_16.doubleValue()));
         // *********[109] DSTORE(9)
        local_9 = new KDouble((Math.floor((local_9.doubleValue() / local_16.doubleValue())) * local_16.doubleValue()));
         // *********[110] DLOAD(14)
         // **REMOVED Substitution** s0 = local_14;
         // *********[111] D2I
         // **REMOVED Substitution** s0 = new KInteger(((int)local_14.doubleValue()));
         // *********[112] ISTORE(18)
        frame.setLocal(18,new KInteger(((int)local_14.doubleValue())));
         // *********[113] DLOAD(11)
         // **REMOVED Substitution** s0 = local_11;
         // *********[114] DLOAD(9)
         // **REMOVED Substitution** s1 = local_9;
         // *********[115] DSUB
         // **REMOVED Substitution** m_d9 = local_9.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble((local_11.doubleValue() - local_9.doubleValue()));
         // *********[116] DLOAD(16)
         // **REMOVED Substitution** s1 = local_16;
         // *********[117] DDIV
         // **REMOVED Substitution** m_d10 = local_16.doubleValue();
         // **REMOVED Substitution** s0 = new KDouble(((local_11.doubleValue() - local_9.doubleValue()) / local_16.doubleValue()));
         // *********[118] D2I
         // **REMOVED Substitution** s0 = new KInteger(((int)((local_11.doubleValue() - local_9.doubleValue()) / local_16.doubleValue())));
         // *********[119] ISTORE(19)
        local_19 = ((int)((local_11.doubleValue() - local_9.doubleValue()) / local_16.doubleValue()));
         // *********[120] ILOAD(19)
         // **REMOVED Substitution** s0 = new KInteger(local_19);
         // *********[121] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[122] IF_ICMPNE(129)
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** jump = local_19 != 1;
        frame.setLocal(16,local_16);
        frame.setLocal(19,new KInteger(local_19));
        frame.setLocal(9,local_9);
        frame.setLocal(11,local_11);
        frame.setLocal(14,local_14);
        return ((local_19 != 1)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[83] DLOAD(11)
         // *********[84] DLOAD(9)
         // *********[85] DSUB
         // *********[86] INVOKE_HOST(java.lang.Math.log(D)D)
         // *********[87] LDC(44->"10.0")
         // *********[88] INVOKE_HOST(java.lang.Math.log(D)D)
         // *********[89] DDIV
         // *********[90] INVOKE_HOST(java.lang.Math.floor(D)D)
         // *********[91] DSTORE(14)
         // *********[92] LDC(44->"10.0")
         // *********[93] DLOAD(14)
         // *********[94] INVOKE_HOST(java.lang.Math.pow(DD)D)
         // *********[95] DSTORE(16)
         // *********[96] DLOAD(11)
         // *********[97] DLOAD(16)
         // *********[98] DDIV
         // *********[99] INVOKE_HOST(java.lang.Math.ceil(D)D)
         // *********[100] DLOAD(16)
         // *********[101] DMUL
         // *********[102] DSTORE(11)
         // *********[103] DLOAD(9)
         // *********[104] DLOAD(16)
         // *********[105] DDIV
         // *********[106] INVOKE_HOST(java.lang.Math.floor(D)D)
         // *********[107] DLOAD(16)
         // *********[108] DMUL
         // *********[109] DSTORE(9)
         // *********[110] DLOAD(14)
         // *********[111] D2I
         // *********[112] ISTORE(18)
         // *********[113] DLOAD(11)
         // *********[114] DLOAD(9)
         // *********[115] DSUB
         // *********[116] DLOAD(16)
         // *********[117] DDIV
         // *********[118] D2I
         // *********[119] ISTORE(19)
         // *********[120] ILOAD(19)
         // *********[121] ICONST_1(Integer{1})
         // *********[122] IF_ICMPNE(129)
        c_next = instructions[(index + 1)];
        c_label = instructions[27];
      }
}
