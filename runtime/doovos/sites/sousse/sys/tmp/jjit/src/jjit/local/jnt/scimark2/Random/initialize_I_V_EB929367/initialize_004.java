package jjit.local.jnt.scimark2.Random.initialize_I_V_EB929367;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Random
 * initialize(I)V
 * [count=32] [32] ILOAD(5) [33] ILOAD(3) [34] IMUL [35] ISTORE(2) [36] ILOAD(2) [37] LDC(11->"65536") [38] IDIV [39] ILOAD(5) [40] ILOAD(4) [41] IMUL [42] IADD [43] ILOAD(6) [44] ILOAD(3) [45] IMUL [46] IADD [47] LDC(29->"32768") [48] IREM [49] ISTORE(6) [50] ILOAD(2) [51] LDC(11->"65536") [52] IREM [53] ISTORE(5) [54] ALOAD(0) [55] GETFIELD(jnt.scimark2.Random,m,[I) [56] ILOAD(7) [57] ILOAD(5) [58] LDC(11->"65536") [59] ILOAD(6) [60] IMUL [61] IADD [62] IASTORE [63] IINC(7,1)
 */
public final class initialize_004 extends JJITAbstractInstruction implements Cloneable{
      private KField c_m = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=2/w=1 : Cached
         // **REMOVED Unused Var** int local_2;
         // local_3 3 ; r=2/w=0 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=3/w=1 : Cached
        int local_5 = frame.getLocal(5).intValue();
         // local_6 6 ; r=2/w=1 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // local_7 7 ; r=2/w=1 : Cached
        int local_7 = frame.getLocal(7).intValue();
         // *********[32] ILOAD(5)
         // **REMOVED Substitution** s0 = new KInteger(local_5);
         // *********[33] ILOAD(3)
         // **REMOVED Substitution** s1 = new KInteger(local_3);
         // *********[34] IMUL
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** s0 = new KInteger((local_5 * local_3));
         // *********[35] ISTORE(2)
         // **REMOVED Substitution** local_2 = (local_5 * local_3);
         // *********[36] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[37] LDC(11->"65536")
         // **REMOVED Substitution** s1 = I65536;
         // *********[38] IDIV
         // **REMOVED Substitution** index = 65536;
         // **REMOVED Substitution** s0 = new KInteger((local_2 / 65536));
         // *********[39] ILOAD(5)
         // **REMOVED Substitution** s1 = new KInteger(local_5);
         // *********[40] ILOAD(4)
         // **REMOVED Substitution** s2 = frame.getLocal(4);
         // *********[41] IMUL
         // **REMOVED Substitution** index = frame.getLocal(4).intValue();
         // **REMOVED Substitution** s1 = new KInteger((local_5 * frame.getLocal(4).intValue()));
         // *********[42] IADD
         // **REMOVED Substitution** index = (local_5 * frame.getLocal(4).intValue());
         // **REMOVED Substitution** s0 = new KInteger(((local_2 / 65536) + (local_5 * frame.getLocal(4).intValue())));
         // *********[43] ILOAD(6)
         // **REMOVED Substitution** s1 = new KInteger(local_6);
         // *********[44] ILOAD(3)
         // **REMOVED Substitution** s2 = new KInteger(local_3);
         // *********[45] IMUL
         // **REMOVED Substitution** index = local_3;
         // **REMOVED Substitution** s1 = new KInteger((local_6 * local_3));
         // *********[46] IADD
         // **REMOVED Substitution** index = (local_6 * local_3);
         // **REMOVED Substitution** s0 = new KInteger((((local_2 / 65536) + (local_5 * frame.getLocal(4).intValue())) + (local_6 * local_3)));
         // *********[47] LDC(29->"32768")
         // **REMOVED Substitution** s1 = I32768;
         // *********[48] IREM
         // **REMOVED Substitution** index = 32768;
         // **REMOVED Substitution** s0 = new KInteger(((((local_2 / 65536) + (local_5 * frame.getLocal(4).intValue())) + (local_6 * local_3)) % 32768));
         // *********[49] ISTORE(6)
        local_6 = (((((local_5 * local_3) / 65536) + (local_5 * frame.getLocal(4).intValue())) + (local_6 * local_3)) % 32768);
         // *********[50] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[51] LDC(11->"65536")
         // **REMOVED Substitution** s1 = I65536;
         // *********[52] IREM
         // **REMOVED Substitution** index = 65536;
         // **REMOVED Substitution** s0 = new KInteger((local_2 % 65536));
         // *********[53] ISTORE(5)
         // **REMOVED Substitution** local_5 = (local_2 % 65536);
         // *********[54] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[55] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s0_ref = c_m.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[56] ILOAD(7)
         // **REMOVED Substitution** s1 = new KInteger(local_7);
         // *********[57] ILOAD(5)
         // **REMOVED Substitution** s2 = new KInteger((local_2 % 65536));
         // *********[58] LDC(11->"65536")
         // **REMOVED Substitution** s3 = I65536;
         // *********[59] ILOAD(6)
         // **REMOVED Substitution** s4 = new KInteger(local_6);
         // *********[60] IMUL
         // **REMOVED Substitution** index = local_6;
         // **REMOVED Substitution** s3 = new KInteger((65536 * local_6));
         // *********[61] IADD
         // **REMOVED Substitution** index = (65536 * local_6);
         // **REMOVED Substitution** s2 = new KInteger(((local_2 % 65536) + (65536 * local_6)));
         // *********[62] IASTORE
         // **REMOVED Substitution** m_i = ((local_2 % 65536) + (65536 * local_6));
         // **REMOVED Substitution** index = local_7;
        c_memman.setIntArray(c_m.getInstanceRef(((KReference)frame.getLocal(0))),local_7,(((local_5 * local_3) % 65536) + (65536 * local_6)));
         // *********[63] IINC(7,1)
         // **REMOVED Substitution** local_7 = (local_7 + 1);
        frame.setLocal(2,new KInteger((local_5 * local_3)));
        frame.setLocal(5,new KInteger(((local_5 * local_3) % 65536)));
        frame.setLocal(6,new KInteger(local_6));
        frame.setLocal(7,new KInteger((local_7 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[32] ILOAD(5)
         // *********[33] ILOAD(3)
         // *********[34] IMUL
         // *********[35] ISTORE(2)
         // *********[36] ILOAD(2)
         // *********[37] LDC(11->"65536")
         // *********[38] IDIV
         // *********[39] ILOAD(5)
         // *********[40] ILOAD(4)
         // *********[41] IMUL
         // *********[42] IADD
         // *********[43] ILOAD(6)
         // *********[44] ILOAD(3)
         // *********[45] IMUL
         // *********[46] IADD
         // *********[47] LDC(29->"32768")
         // *********[48] IREM
         // *********[49] ISTORE(6)
         // *********[50] ILOAD(2)
         // *********[51] LDC(11->"65536")
         // *********[52] IREM
         // *********[53] ISTORE(5)
         // *********[54] ALOAD(0)
         // *********[55] GETFIELD(jnt.scimark2.Random,m,[I)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_m = c_CRandom.getField("m",true);
         // *********[56] ILOAD(7)
         // *********[57] ILOAD(5)
         // *********[58] LDC(11->"65536")
         // *********[59] ILOAD(6)
         // *********[60] IMUL
         // *********[61] IADD
         // *********[62] IASTORE
        c_memman = process.getMemoryManager();
         // *********[63] IINC(7,1)
        c_next = instructions[(index + 1)];
      }
}
