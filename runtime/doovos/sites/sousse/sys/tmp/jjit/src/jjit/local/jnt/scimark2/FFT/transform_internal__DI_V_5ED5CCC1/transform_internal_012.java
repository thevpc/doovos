package jjit.local.jnt.scimark2.FFT.transform_internal__DI_V_5ED5CCC1;
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
 * [count=27] [124] DLOAD(6) [125] DLOAD(12) [126] DLOAD(8) [127] DMUL [128] DSUB [129] DLOAD(16) [130] DLOAD(6) [131] DMUL [132] DSUB [133] DSTORE(20) [134] DLOAD(8) [135] DLOAD(12) [136] DLOAD(6) [137] DMUL [138] DADD [139] DLOAD(16) [140] DLOAD(8) [141] DMUL [142] DSUB [143] DSTORE(22) [144] DLOAD(20) [145] DSTORE(6) [146] DLOAD(22) [147] DSTORE(8) [148] ICONST_0(Integer{0}) [149] ISTORE(20) [150] GOTO(233)
 */
public final class transform_internal_012 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IZERO = KInteger.ZERO;
      private JJITInstruction c_label;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** double m_d7;
         // **REMOVED Unused Var** double m_d8;
         // local_16 16 ; r=2/w=0 : Cached
        KRegister local_16 = frame.getLocal(16);
         // local_20 20 ; r=1/w=2 : Cached
         // **REMOVED Unused Var** KRegister local_20;
         // local_6 6 ; r=3/w=1 : Cached
        KRegister local_6 = frame.getLocal(6);
         // local_22 22 ; r=1/w=1 : Cached
        KRegister local_22;
         // local_8 8 ; r=3/w=1 : Cached
        KRegister local_8 = frame.getLocal(8);
         // local_12 12 ; r=2/w=0 : Cached
        KRegister local_12 = frame.getLocal(12);
         // *********[124] DLOAD(6)
         // **REMOVED Substitution** s0 = local_6;
         // *********[125] DLOAD(12)
         // **REMOVED Substitution** s1 = local_12;
         // *********[126] DLOAD(8)
         // **REMOVED Substitution** s2 = local_8;
         // *********[127] DMUL
         // **REMOVED Substitution** m_d = local_8.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_12.doubleValue() * local_8.doubleValue()));
         // *********[128] DSUB
         // **REMOVED Substitution** m_d2 = (local_12.doubleValue() * local_8.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble((local_6.doubleValue() - (local_12.doubleValue() * local_8.doubleValue())));
         // *********[129] DLOAD(16)
         // **REMOVED Substitution** s1 = local_16;
         // *********[130] DLOAD(6)
         // **REMOVED Substitution** s2 = local_6;
         // *********[131] DMUL
         // **REMOVED Substitution** m_d3 = local_6.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_16.doubleValue() * local_6.doubleValue()));
         // *********[132] DSUB
         // **REMOVED Substitution** m_d4 = (local_16.doubleValue() * local_6.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(((local_6.doubleValue() - (local_12.doubleValue() * local_8.doubleValue())) - (local_16.doubleValue() * local_6.doubleValue())));
         // *********[133] DSTORE(20)
         // **REMOVED Substitution** local_20 = new KDouble(((local_6.doubleValue() - (local_12.doubleValue() * local_8.doubleValue())) - (local_16.doubleValue() * local_6.doubleValue())));
         // *********[134] DLOAD(8)
         // **REMOVED Substitution** s0 = local_8;
         // *********[135] DLOAD(12)
         // **REMOVED Substitution** s1 = local_12;
         // *********[136] DLOAD(6)
         // **REMOVED Substitution** s2 = local_6;
         // *********[137] DMUL
         // **REMOVED Substitution** m_d5 = local_6.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_12.doubleValue() * local_6.doubleValue()));
         // *********[138] DADD
         // **REMOVED Substitution** m_d6 = (local_12.doubleValue() * local_6.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble((local_8.doubleValue() + (local_12.doubleValue() * local_6.doubleValue())));
         // *********[139] DLOAD(16)
         // **REMOVED Substitution** s1 = local_16;
         // *********[140] DLOAD(8)
         // **REMOVED Substitution** s2 = local_8;
         // *********[141] DMUL
         // **REMOVED Substitution** m_d7 = local_8.doubleValue();
         // **REMOVED Substitution** s1 = new KDouble((local_16.doubleValue() * local_8.doubleValue()));
         // *********[142] DSUB
         // **REMOVED Substitution** m_d8 = (local_16.doubleValue() * local_8.doubleValue());
         // **REMOVED Substitution** s0 = new KDouble(((local_8.doubleValue() + (local_12.doubleValue() * local_6.doubleValue())) - (local_16.doubleValue() * local_8.doubleValue())));
         // *********[143] DSTORE(22)
        local_22 = new KDouble(((local_8.doubleValue() + (local_12.doubleValue() * local_6.doubleValue())) - (local_16.doubleValue() * local_8.doubleValue())));
         // *********[144] DLOAD(20)
         // **REMOVED Substitution** s0 = new KDouble(((local_6.doubleValue() - (local_12.doubleValue() * local_8.doubleValue())) - (local_16.doubleValue() * local_6.doubleValue())));
         // *********[145] DSTORE(6)
         // **REMOVED Substitution** local_6 = new KDouble(((local_6.doubleValue() - (local_12.doubleValue() * local_8.doubleValue())) - (local_16.doubleValue() * local_6.doubleValue())));
         // *********[146] DLOAD(22)
         // **REMOVED Substitution** s0 = local_22;
         // *********[147] DSTORE(8)
         // **REMOVED Substitution** local_8 = local_22;
         // *********[148] ICONST_0(Integer{0})
         // **REMOVED Substitution** s0 = IZERO;
         // *********[149] ISTORE(20)
         // **REMOVED Substitution** local_20 = IZERO;
         // *********[150] GOTO(233)
        frame.setLocal(20,IZERO);
        frame.setLocal(6,new KDouble(((local_6.doubleValue() - (local_12.doubleValue() * local_8.doubleValue())) - (local_16.doubleValue() * local_6.doubleValue()))));
        frame.setLocal(22,local_22);
        frame.setLocal(8,local_22);
        return c_label;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[124] DLOAD(6)
         // *********[125] DLOAD(12)
         // *********[126] DLOAD(8)
         // *********[127] DMUL
         // *********[128] DSUB
         // *********[129] DLOAD(16)
         // *********[130] DLOAD(6)
         // *********[131] DMUL
         // *********[132] DSUB
         // *********[133] DSTORE(20)
         // *********[134] DLOAD(8)
         // *********[135] DLOAD(12)
         // *********[136] DLOAD(6)
         // *********[137] DMUL
         // *********[138] DADD
         // *********[139] DLOAD(16)
         // *********[140] DLOAD(8)
         // *********[141] DMUL
         // *********[142] DSUB
         // *********[143] DSTORE(22)
         // *********[144] DLOAD(20)
         // *********[145] DSTORE(6)
         // *********[146] DLOAD(22)
         // *********[147] DSTORE(8)
         // *********[148] ICONST_0(Integer{0})
         // *********[149] ISTORE(20)
         // *********[150] GOTO(233)
        c_label = instructions[13];
      }
}
