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
 * [count=31] [116] DASTORE [117] ALOAD(2) [118] ICONST_0(Integer{0}) [119] ALOAD(2) [120] ICONST_1(Integer{1}) [121] DALOAD [122] ALOAD(2) [123] ICONST_2(Integer{2}) [124] DALOAD [125] DADD [126] ALOAD(2) [127] ICONST_3(Integer{3}) [128] DALOAD [129] DADD [130] ALOAD(2) [131] ICONST_4(Integer{4}) [132] DALOAD [133] DADD [134] ALOAD(2) [135] ICONST_5(Integer{5}) [136] DALOAD [137] DADD [138] LDC(27->"5.0") [139] DDIV [140] DASTORE [141] ALOAD(2) [142] ICONST_1(Integer{1}) [143] DALOAD [144] DCONST_0(Double{0.0}) [145] DCMPL [146] IFEQ(153)
 */
public final class execute_035 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
        int index = 0;
        double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** double m_d4;
         // **REMOVED Unused Var** double m_d5;
         // **REMOVED Unused Var** double m_d6;
         // **REMOVED Unused Var** double m_d7;
        double m_d8;
         // **REMOVED Unused Var** double m_d9;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=7/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // *********[116] DASTORE
        m_d = frame.popDouble();
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[117] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[118] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[119] ALOAD(2)
         // **REMOVED Substitution** s2 = local_2;
         // *********[120] ICONST_1(Integer{1})
         // **REMOVED Substitution** s3 = IONE;
         // *********[121] DALOAD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),1));
         // *********[122] ALOAD(2)
         // **REMOVED Substitution** s3 = local_2;
         // *********[123] ICONST_2(Integer{2})
         // **REMOVED Substitution** s4 = ITWO;
         // *********[124] DALOAD
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),2));
         // *********[125] DADD
         // **REMOVED Substitution** m_d2 = c_memman.getDoubleArray(((KReference)local_2),2);
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_2),1) + c_memman.getDoubleArray(((KReference)local_2),2)));
         // *********[126] ALOAD(2)
         // **REMOVED Substitution** s3 = local_2;
         // *********[127] ICONST_3(Integer{3})
         // **REMOVED Substitution** s4 = ITHREE;
         // *********[128] DALOAD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),3));
         // *********[129] DADD
         // **REMOVED Substitution** m_d3 = c_memman.getDoubleArray(((KReference)local_2),3);
         // **REMOVED Substitution** s2 = new KDouble(((c_memman.getDoubleArray(((KReference)local_2),1) + c_memman.getDoubleArray(((KReference)local_2),2)) + c_memman.getDoubleArray(((KReference)local_2),3)));
         // *********[130] ALOAD(2)
         // **REMOVED Substitution** s3 = local_2;
         // *********[131] ICONST_4(Integer{4})
         // **REMOVED Substitution** s4 = IFOUR;
         // *********[132] DALOAD
         // **REMOVED Substitution** index = 4;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),4));
         // *********[133] DADD
         // **REMOVED Substitution** m_d4 = c_memman.getDoubleArray(((KReference)local_2),4);
         // **REMOVED Substitution** s2 = new KDouble((((c_memman.getDoubleArray(((KReference)local_2),1) + c_memman.getDoubleArray(((KReference)local_2),2)) + c_memman.getDoubleArray(((KReference)local_2),3)) + c_memman.getDoubleArray(((KReference)local_2),4)));
         // *********[134] ALOAD(2)
         // **REMOVED Substitution** s3 = local_2;
         // *********[135] ICONST_5(Integer{5})
         // **REMOVED Substitution** s4 = IFIVE;
         // *********[136] DALOAD
         // **REMOVED Substitution** index = 5;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),5));
         // *********[137] DADD
         // **REMOVED Substitution** m_d5 = c_memman.getDoubleArray(((KReference)local_2),5);
         // **REMOVED Substitution** s2 = new KDouble(((((c_memman.getDoubleArray(((KReference)local_2),1) + c_memman.getDoubleArray(((KReference)local_2),2)) + c_memman.getDoubleArray(((KReference)local_2),3)) + c_memman.getDoubleArray(((KReference)local_2),4)) + c_memman.getDoubleArray(((KReference)local_2),5)));
         // *********[138] LDC(27->"5.0")
         // **REMOVED Substitution** s3 = D5_0;
         // *********[139] DDIV
         // **REMOVED Substitution** m_d6 = 5.0D;
         // **REMOVED Substitution** s2 = new KDouble((((((c_memman.getDoubleArray(((KReference)local_2),1) + c_memman.getDoubleArray(((KReference)local_2),2)) + c_memman.getDoubleArray(((KReference)local_2),3)) + c_memman.getDoubleArray(((KReference)local_2),4)) + c_memman.getDoubleArray(((KReference)local_2),5)) / 5.0D));
         // *********[140] DASTORE
         // **REMOVED Substitution** m_d7 = (((((c_memman.getDoubleArray(((KReference)local_2),1) + c_memman.getDoubleArray(((KReference)local_2),2)) + c_memman.getDoubleArray(((KReference)local_2),3)) + c_memman.getDoubleArray(((KReference)local_2),4)) + c_memman.getDoubleArray(((KReference)local_2),5)) / 5.0D);
         // **REMOVED Substitution** index = 0;
        c_memman.setDoubleArray(((KReference)local_2),0,(((((c_memman.getDoubleArray(((KReference)local_2),1) + c_memman.getDoubleArray(((KReference)local_2),2)) + c_memman.getDoubleArray(((KReference)local_2),3)) + c_memman.getDoubleArray(((KReference)local_2),4)) + c_memman.getDoubleArray(((KReference)local_2),5)) / 5.0D));
         // *********[141] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[142] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[143] DALOAD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)local_2),1));
         // *********[144] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[145] DCMPL
         // **REMOVED Substitution** m_d9 = 0.0D;
        m_d8 = c_memman.getDoubleArray(((KReference)local_2),1);
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d8))?(KInteger.M1):(((m_d8 == 0.0D)?(KInteger.ZERO):(((m_d8 > 0.0D)?(KInteger.ONE):(KInteger.M1))))));
         // *********[146] IFEQ(153)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d8))?(-1):(((m_d8 == 0.0D)?(0):(((m_d8 > 0.0D)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d8))?(-1):(((m_d8 == 0.0D)?(0):(((m_d8 > 0.0D)?(1):(-1)))))) == 0;
        return ((((Double.isNaN(m_d8))?(-1):(((m_d8 == 0.0D)?(0):(((m_d8 > 0.0D)?(1):(-1)))))) == 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[116] DASTORE
        c_memman = process.getMemoryManager();
         // *********[117] ALOAD(2)
         // *********[118] ICONST_0(Integer{0})
         // *********[119] ALOAD(2)
         // *********[120] ICONST_1(Integer{1})
         // *********[121] DALOAD
         // *********[122] ALOAD(2)
         // *********[123] ICONST_2(Integer{2})
         // *********[124] DALOAD
         // *********[125] DADD
         // *********[126] ALOAD(2)
         // *********[127] ICONST_3(Integer{3})
         // *********[128] DALOAD
         // *********[129] DADD
         // *********[130] ALOAD(2)
         // *********[131] ICONST_4(Integer{4})
         // *********[132] DALOAD
         // *********[133] DADD
         // *********[134] ALOAD(2)
         // *********[135] ICONST_5(Integer{5})
         // *********[136] DALOAD
         // *********[137] DADD
         // *********[138] LDC(27->"5.0")
         // *********[139] DDIV
         // *********[140] DASTORE
         // *********[141] ALOAD(2)
         // *********[142] ICONST_1(Integer{1})
         // *********[143] DALOAD
         // *********[144] DCONST_0(Double{0.0})
         // *********[145] DCMPL
         // *********[146] IFEQ(153)
        c_next = instructions[(index + 1)];
        c_label = instructions[36];
      }
}
