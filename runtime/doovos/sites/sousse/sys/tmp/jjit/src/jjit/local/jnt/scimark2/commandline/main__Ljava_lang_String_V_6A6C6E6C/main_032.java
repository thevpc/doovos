package jjit.local.jnt.scimark2.commandline.main__Ljava_lang_String_V_6A6C6E6C;
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
 * jnt.scimark2.commandline
 * main([Ljava/lang/String;)V
 * [count=25] [102] DASTORE [103] ALOAD(8) [104] ICONST_0(Integer{0}) [105] ALOAD(8) [106] ICONST_1(Integer{1}) [107] DALOAD [108] ALOAD(8) [109] ICONST_2(Integer{2}) [110] DALOAD [111] DADD [112] ALOAD(8) [113] ICONST_3(Integer{3}) [114] DALOAD [115] DADD [116] ALOAD(8) [117] ICONST_4(Integer{4}) [118] DALOAD [119] DADD [120] ALOAD(8) [121] ICONST_5(Integer{5}) [122] DALOAD [123] DADD [124] LDC(29->"5.0") [125] DDIV [126] DASTORE
 */
public final class main_032 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
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
         // local_8 8 ; r=6/w=0 : Cached
        KRegister local_8 = frame.getLocal(8);
         // *********[102] DASTORE
        m_d = frame.popDouble();
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[103] ALOAD(8)
         // **REMOVED Substitution** s0 = local_8;
         // *********[104] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[105] ALOAD(8)
         // **REMOVED Substitution** s2 = local_8;
         // *********[106] ICONST_1(Integer{1})
         // **REMOVED Substitution** s3 = IONE;
         // *********[107] DALOAD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s2 = new KDouble(c_memman.getDoubleArray(((KReference)local_8),1));
         // *********[108] ALOAD(8)
         // **REMOVED Substitution** s3 = local_8;
         // *********[109] ICONST_2(Integer{2})
         // **REMOVED Substitution** s4 = ITWO;
         // *********[110] DALOAD
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_8),2));
         // *********[111] DADD
         // **REMOVED Substitution** m_d2 = c_memman.getDoubleArray(((KReference)local_8),2);
         // **REMOVED Substitution** s2 = new KDouble((c_memman.getDoubleArray(((KReference)local_8),1) + c_memman.getDoubleArray(((KReference)local_8),2)));
         // *********[112] ALOAD(8)
         // **REMOVED Substitution** s3 = local_8;
         // *********[113] ICONST_3(Integer{3})
         // **REMOVED Substitution** s4 = ITHREE;
         // *********[114] DALOAD
         // **REMOVED Substitution** index = 3;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_8),3));
         // *********[115] DADD
         // **REMOVED Substitution** m_d3 = c_memman.getDoubleArray(((KReference)local_8),3);
         // **REMOVED Substitution** s2 = new KDouble(((c_memman.getDoubleArray(((KReference)local_8),1) + c_memman.getDoubleArray(((KReference)local_8),2)) + c_memman.getDoubleArray(((KReference)local_8),3)));
         // *********[116] ALOAD(8)
         // **REMOVED Substitution** s3 = local_8;
         // *********[117] ICONST_4(Integer{4})
         // **REMOVED Substitution** s4 = IFOUR;
         // *********[118] DALOAD
         // **REMOVED Substitution** index = 4;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_8),4));
         // *********[119] DADD
         // **REMOVED Substitution** m_d4 = c_memman.getDoubleArray(((KReference)local_8),4);
         // **REMOVED Substitution** s2 = new KDouble((((c_memman.getDoubleArray(((KReference)local_8),1) + c_memman.getDoubleArray(((KReference)local_8),2)) + c_memman.getDoubleArray(((KReference)local_8),3)) + c_memman.getDoubleArray(((KReference)local_8),4)));
         // *********[120] ALOAD(8)
         // **REMOVED Substitution** s3 = local_8;
         // *********[121] ICONST_5(Integer{5})
         // **REMOVED Substitution** s4 = IFIVE;
         // *********[122] DALOAD
         // **REMOVED Substitution** index = 5;
         // **REMOVED Substitution** s3 = new KDouble(c_memman.getDoubleArray(((KReference)local_8),5));
         // *********[123] DADD
         // **REMOVED Substitution** m_d5 = c_memman.getDoubleArray(((KReference)local_8),5);
         // **REMOVED Substitution** s2 = new KDouble(((((c_memman.getDoubleArray(((KReference)local_8),1) + c_memman.getDoubleArray(((KReference)local_8),2)) + c_memman.getDoubleArray(((KReference)local_8),3)) + c_memman.getDoubleArray(((KReference)local_8),4)) + c_memman.getDoubleArray(((KReference)local_8),5)));
         // *********[124] LDC(29->"5.0")
         // **REMOVED Substitution** s3 = D5_0;
         // *********[125] DDIV
         // **REMOVED Substitution** m_d6 = 5.0D;
         // **REMOVED Substitution** s2 = new KDouble((((((c_memman.getDoubleArray(((KReference)local_8),1) + c_memman.getDoubleArray(((KReference)local_8),2)) + c_memman.getDoubleArray(((KReference)local_8),3)) + c_memman.getDoubleArray(((KReference)local_8),4)) + c_memman.getDoubleArray(((KReference)local_8),5)) / 5.0D));
         // *********[126] DASTORE
         // **REMOVED Substitution** m_d7 = (((((c_memman.getDoubleArray(((KReference)local_8),1) + c_memman.getDoubleArray(((KReference)local_8),2)) + c_memman.getDoubleArray(((KReference)local_8),3)) + c_memman.getDoubleArray(((KReference)local_8),4)) + c_memman.getDoubleArray(((KReference)local_8),5)) / 5.0D);
         // **REMOVED Substitution** index = 0;
        c_memman.setDoubleArray(((KReference)local_8),0,(((((c_memman.getDoubleArray(((KReference)local_8),1) + c_memman.getDoubleArray(((KReference)local_8),2)) + c_memman.getDoubleArray(((KReference)local_8),3)) + c_memman.getDoubleArray(((KReference)local_8),4)) + c_memman.getDoubleArray(((KReference)local_8),5)) / 5.0D));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[102] DASTORE
        c_memman = process.getMemoryManager();
         // *********[103] ALOAD(8)
         // *********[104] ICONST_0(Integer{0})
         // *********[105] ALOAD(8)
         // *********[106] ICONST_1(Integer{1})
         // *********[107] DALOAD
         // *********[108] ALOAD(8)
         // *********[109] ICONST_2(Integer{2})
         // *********[110] DALOAD
         // *********[111] DADD
         // *********[112] ALOAD(8)
         // *********[113] ICONST_3(Integer{3})
         // *********[114] DALOAD
         // *********[115] DADD
         // *********[116] ALOAD(8)
         // *********[117] ICONST_4(Integer{4})
         // *********[118] DALOAD
         // *********[119] DADD
         // *********[120] ALOAD(8)
         // *********[121] ICONST_5(Integer{5})
         // *********[122] DALOAD
         // *********[123] DADD
         // *********[124] LDC(29->"5.0")
         // *********[125] DDIV
         // *********[126] DASTORE
        c_next = instructions[(index + 1)];
      }
}
