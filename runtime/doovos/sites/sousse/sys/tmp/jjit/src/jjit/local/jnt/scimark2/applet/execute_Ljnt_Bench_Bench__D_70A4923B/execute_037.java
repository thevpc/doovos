package jjit.local.jnt.scimark2.applet.execute_Ljnt_Bench_Bench__D_70A4923B;
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
 * jnt.scimark2.applet
 * execute(Ljnt/Bench/Bench;)[D
 * [count=24] [153] ALOAD(2) [154] ICONST_0(Integer{0}) [155] ALOAD(2) [156] ICONST_1(Integer{1}) [157] ALOAD(2) [158] ICONST_2(Integer{2}) [159] ALOAD(2) [160] ICONST_3(Integer{3}) [161] ALOAD(2) [162] ICONST_4(Integer{4}) [163] ALOAD(2) [164] ICONST_5(Integer{5}) [165] DCONST_0(Double{0.0}) [166] DUP2_X2Type2 [167] DASTORE [168] DUP2_X2Type2 [169] DASTORE [170] DUP2_X2Type2 [171] DASTORE [172] DUP2_X2Type2 [173] DASTORE [174] DUP2_X2Type2 [175] DASTORE [176] DASTORE
 */
public final class execute_037 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s7;
         // **REMOVED Unused Var** KRegister s6;
         // **REMOVED Unused Var** KRegister s5;
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s9;
         // **REMOVED Unused Var** KRegister s8;
         // **REMOVED Unused Var** KRegister s10;
         // **REMOVED Unused Var** KRegister s11;
         // **REMOVED Unused Var** KRegister s12;
         // **REMOVED Unused Var** KRegister s13;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KRegister m_r;
         // **REMOVED Unused Var** KRegister m_r2;
         // **REMOVED Unused Var** KRegister m_r3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** KRegister m_r4;
         // **REMOVED Unused Var** KRegister m_r5;
         // **REMOVED Unused Var** KRegister m_r6;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** KRegister m_r7;
         // **REMOVED Unused Var** KRegister m_r8;
         // **REMOVED Unused Var** KRegister m_r9;
         // **REMOVED Unused Var** double m_d9;
         // **REMOVED Unused Var** KRegister m_r10;
         // **REMOVED Unused Var** KRegister m_r11;
         // **REMOVED Unused Var** KRegister m_r12;
         // **REMOVED Unused Var** double m_d12;
         // **REMOVED Unused Var** KRegister m_r13;
         // **REMOVED Unused Var** KRegister m_r14;
         // **REMOVED Unused Var** KRegister m_r15;
         // **REMOVED Unused Var** double m_d15;
         // **REMOVED Unused Var** double m_d16;
         // local_2 2 ; r=6/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // *********[153] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[154] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[155] ALOAD(2)
         // **REMOVED Substitution** s2 = local_2;
         // *********[156] ICONST_1(Integer{1})
         // **REMOVED Substitution** s3 = IONE;
         // *********[157] ALOAD(2)
         // **REMOVED Substitution** s4 = local_2;
         // *********[158] ICONST_2(Integer{2})
         // **REMOVED Substitution** s5 = ITWO;
         // *********[159] ALOAD(2)
         // **REMOVED Substitution** s6 = local_2;
         // *********[160] ICONST_3(Integer{3})
         // **REMOVED Substitution** s7 = ITHREE;
         // *********[161] ALOAD(2)
         // **REMOVED Substitution** s8 = local_2;
         // *********[162] ICONST_4(Integer{4})
         // **REMOVED Substitution** s9 = IFOUR;
         // *********[163] ALOAD(2)
         // **REMOVED Substitution** s10 = local_2;
         // *********[164] ICONST_5(Integer{5})
         // **REMOVED Substitution** s11 = IFIVE;
         // *********[165] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s12 = DZERO;
         // *********[166] DUP2_X2Type2
         // **REMOVED Substitution** m_r = DZERO;
         // **REMOVED Substitution** m_r2 = IFIVE;
         // **REMOVED Substitution** m_r3 = local_2;
         // **REMOVED Substitution** s10 = DZERO;
         // **REMOVED Substitution** s11 = local_2;
         // **REMOVED Substitution** s12 = IFIVE;
         // **REMOVED Substitution** s13 = DZERO;
         // *********[167] DASTORE
         // **REMOVED Substitution** m_d3 = 0.0D;
         // **REMOVED Substitution** index = 5;
        c_memman.setDoubleArray(((KReference)local_2),5,0.0D);
         // *********[168] DUP2_X2Type2
         // **REMOVED Substitution** m_r4 = DZERO;
         // **REMOVED Substitution** m_r5 = IFOUR;
         // **REMOVED Substitution** m_r6 = local_2;
         // **REMOVED Substitution** s8 = DZERO;
         // **REMOVED Substitution** s9 = local_2;
         // **REMOVED Substitution** s10 = IFOUR;
         // **REMOVED Substitution** s11 = DZERO;
         // *********[169] DASTORE
         // **REMOVED Substitution** m_d6 = 0.0D;
         // **REMOVED Substitution** index = 4;
        c_memman.setDoubleArray(((KReference)local_2),4,0.0D);
         // *********[170] DUP2_X2Type2
         // **REMOVED Substitution** m_r7 = DZERO;
         // **REMOVED Substitution** m_r8 = ITHREE;
         // **REMOVED Substitution** m_r9 = local_2;
         // **REMOVED Substitution** s6 = DZERO;
         // **REMOVED Substitution** s7 = local_2;
         // **REMOVED Substitution** s8 = ITHREE;
         // **REMOVED Substitution** s9 = DZERO;
         // *********[171] DASTORE
         // **REMOVED Substitution** m_d9 = 0.0D;
         // **REMOVED Substitution** index = 3;
        c_memman.setDoubleArray(((KReference)local_2),3,0.0D);
         // *********[172] DUP2_X2Type2
         // **REMOVED Substitution** m_r10 = DZERO;
         // **REMOVED Substitution** m_r11 = ITWO;
         // **REMOVED Substitution** m_r12 = local_2;
         // **REMOVED Substitution** s4 = DZERO;
         // **REMOVED Substitution** s5 = local_2;
         // **REMOVED Substitution** s6 = ITWO;
         // **REMOVED Substitution** s7 = DZERO;
         // *********[173] DASTORE
         // **REMOVED Substitution** m_d12 = 0.0D;
         // **REMOVED Substitution** index = 2;
        c_memman.setDoubleArray(((KReference)local_2),2,0.0D);
         // *********[174] DUP2_X2Type2
         // **REMOVED Substitution** m_r13 = DZERO;
         // **REMOVED Substitution** m_r14 = IONE;
         // **REMOVED Substitution** m_r15 = local_2;
         // **REMOVED Substitution** s2 = DZERO;
         // **REMOVED Substitution** s3 = local_2;
         // **REMOVED Substitution** s4 = IONE;
         // **REMOVED Substitution** s5 = DZERO;
         // *********[175] DASTORE
         // **REMOVED Substitution** m_d15 = 0.0D;
         // **REMOVED Substitution** index = 1;
        c_memman.setDoubleArray(((KReference)local_2),1,0.0D);
         // *********[176] DASTORE
         // **REMOVED Substitution** m_d16 = 0.0D;
         // **REMOVED Substitution** index = 0;
        c_memman.setDoubleArray(((KReference)local_2),0,0.0D);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[153] ALOAD(2)
         // *********[154] ICONST_0(Integer{0})
         // *********[155] ALOAD(2)
         // *********[156] ICONST_1(Integer{1})
         // *********[157] ALOAD(2)
         // *********[158] ICONST_2(Integer{2})
         // *********[159] ALOAD(2)
         // *********[160] ICONST_3(Integer{3})
         // *********[161] ALOAD(2)
         // *********[162] ICONST_4(Integer{4})
         // *********[163] ALOAD(2)
         // *********[164] ICONST_5(Integer{5})
         // *********[165] DCONST_0(Double{0.0})
         // *********[166] DUP2_X2Type2
         // *********[167] DASTORE
        c_memman = process.getMemoryManager();
         // *********[168] DUP2_X2Type2
         // *********[169] DASTORE
         // *********[170] DUP2_X2Type2
         // *********[171] DASTORE
         // *********[172] DUP2_X2Type2
         // *********[173] DASTORE
         // *********[174] DUP2_X2Type2
         // *********[175] DASTORE
         // *********[176] DASTORE
        c_next = instructions[(index + 1)];
      }
}
