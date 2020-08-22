package jjit.local.jnt.scimark2.Random._init__IDD_V_5ECA6923;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.jvm.reflect.KMethod;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Random
 * <init>(IDD)V
 * [count=39] [2] ALOAD(0) [3] ICONST_0(Integer{0}) [4] PUTFIELD(jnt.scimark2.Random,seed) [5] ALOAD(0) [6] ICONST_4(Integer{4}) [7] PUTFIELD(jnt.scimark2.Random,i) [8] ALOAD(0) [9] BIPUSH(16) [10] PUTFIELD(jnt.scimark2.Random,j) [11] ALOAD(0) [12] BIPUSH(32) [13] PUTFIELD(jnt.scimark2.Random,mdig) [14] ALOAD(0) [15] ICONST_1(Integer{1}) [16] PUTFIELD(jnt.scimark2.Random,one) [17] ALOAD(0) [18] LDC(9->"2147483647") [19] PUTFIELD(jnt.scimark2.Random,m1) [20] ALOAD(0) [21] LDC(11->"65536") [22] PUTFIELD(jnt.scimark2.Random,m2) [23] ALOAD(0) [24] LDC(13->"4.656612875245797E-10") [25] PUTFIELD(jnt.scimark2.Random,dm1) [26] ALOAD(0) [27] ICONST_0(Integer{0}) [28] PUTFIELD(jnt.scimark2.Random,haveRange) [29] ALOAD(0) [30] DCONST_0(Double{0.0}) [31] PUTFIELD(jnt.scimark2.Random,left) [32] ALOAD(0) [33] DCONST_1(Double{1.0}) [34] PUTFIELD(jnt.scimark2.Random,right) [35] ALOAD(0) [36] DCONST_1(Double{1.0}) [37] PUTFIELD(jnt.scimark2.Random,width) [38] ALOAD(0) [39] ILOAD(1) [40] INVOKESPECIAL(jnt.scimark2.Random,initialize(I)V)
 */
public final class _init__004 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger IZERO = KInteger.ZERO;
      private KField c_seed = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_i = null;
      private KField c_j = null;
      private KField c_mdig = null;
      private KField c_one = null;
      private KField c_m1 = null;
      private KField c_m2 = null;
      private static final KDouble D4_656612875245797EM10 = new KDouble(4.656612875245797E-10D);
      private KField c_dm1 = null;
      private KField c_haveRange = null;
      private static final KDouble DZERO = KDouble.ZERO;
      private KField c_left = null;
      private static final KDouble DONE = KDouble.ONE;
      private KField c_right = null;
      private KField c_width = null;
      private JJITInstruction c_next;
      private KMethod m_mth = null;
      private boolean m_mth_ignorable = false;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        JJITInstruction nextInstr;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=13/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[2] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[3] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[4] PUTFIELD(jnt.scimark2.Random,seed)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_seed.setInstanceInt(this_ref,0);
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] ICONST_4(Integer{4})
         // **REMOVED Substitution** s1 = IFOUR;
         // *********[7] PUTFIELD(jnt.scimark2.Random,i)
         // **REMOVED Substitution** reg = IFOUR;
         // **REMOVED Substitution** ref = this_ref;
        c_i.setInstanceInt(this_ref,4);
         // *********[8] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[9] BIPUSH(16)
         // **REMOVED Substitution** s1 = I16;
         // *********[10] PUTFIELD(jnt.scimark2.Random,j)
         // **REMOVED Substitution** reg = I16;
         // **REMOVED Substitution** ref = this_ref;
        c_j.setInstanceInt(this_ref,16);
         // *********[11] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[12] BIPUSH(32)
         // **REMOVED Substitution** s1 = I32;
         // *********[13] PUTFIELD(jnt.scimark2.Random,mdig)
         // **REMOVED Substitution** reg = I32;
         // **REMOVED Substitution** ref = this_ref;
        c_mdig.setInstanceInt(this_ref,32);
         // *********[14] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[15] ICONST_1(Integer{1})
         // **REMOVED Substitution** s1 = IONE;
         // *********[16] PUTFIELD(jnt.scimark2.Random,one)
         // **REMOVED Substitution** reg = IONE;
         // **REMOVED Substitution** ref = this_ref;
        c_one.setInstanceInt(this_ref,1);
         // *********[17] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[18] LDC(9->"2147483647")
         // **REMOVED Substitution** s1 = I2147483647;
         // *********[19] PUTFIELD(jnt.scimark2.Random,m1)
         // **REMOVED Substitution** reg = I2147483647;
         // **REMOVED Substitution** ref = this_ref;
        c_m1.setInstanceInt(this_ref,2147483647);
         // *********[20] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[21] LDC(11->"65536")
         // **REMOVED Substitution** s1 = I65536;
         // *********[22] PUTFIELD(jnt.scimark2.Random,m2)
         // **REMOVED Substitution** reg = I65536;
         // **REMOVED Substitution** ref = this_ref;
        c_m2.setInstanceInt(this_ref,65536);
         // *********[23] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[24] LDC(13->"4.656612875245797E-10")
         // **REMOVED Substitution** s1 = D4_656612875245797EM10;
         // *********[25] PUTFIELD(jnt.scimark2.Random,dm1)
         // **REMOVED Substitution** reg = D4_656612875245797EM10;
         // **REMOVED Substitution** ref = this_ref;
        c_dm1.setInstanceValue(this_ref,D4_656612875245797EM10);
         // *********[26] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[27] ICONST_0(Integer{0})
         // **REMOVED Substitution** s1 = IZERO;
         // *********[28] PUTFIELD(jnt.scimark2.Random,haveRange)
         // **REMOVED Substitution** reg = IZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_haveRange.setInstanceValue(this_ref,IZERO);
         // *********[29] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[30] DCONST_0(Double{0.0})
         // **REMOVED Substitution** s1 = DZERO;
         // *********[31] PUTFIELD(jnt.scimark2.Random,left)
         // **REMOVED Substitution** reg = DZERO;
         // **REMOVED Substitution** ref = this_ref;
        c_left.setInstanceValue(this_ref,DZERO);
         // *********[32] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[33] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s1 = DONE;
         // *********[34] PUTFIELD(jnt.scimark2.Random,right)
         // **REMOVED Substitution** reg = DONE;
         // **REMOVED Substitution** ref = this_ref;
        c_right.setInstanceValue(this_ref,DONE);
         // *********[35] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[36] DCONST_1(Double{1.0})
         // **REMOVED Substitution** s1 = DONE;
         // *********[37] PUTFIELD(jnt.scimark2.Random,width)
         // **REMOVED Substitution** reg = DONE;
         // **REMOVED Substitution** ref = this_ref;
        c_width.setInstanceValue(this_ref,DONE);
         // *********[38] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[39] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[40] INVOKESPECIAL(jnt.scimark2.Random,initialize(I)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(1);
         // **REMOVED Substitution** ref = this_ref;
        regs[0] = this_ref;
        if(m_mth_ignorable){
          nextInstr = c_next;
        }else{
          frame.setProgramCounter(4);
           // **REMOVED Substitution** nextFrame = thread.pushFrame(m_mth,regs);
          nextInstr = ((JJITInstruction)thread.pushFrame(m_mth,regs).getCurrentInstruction());
        }
        return nextInstr;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[2] ALOAD(0)
         // *********[3] ICONST_0(Integer{0})
         // *********[4] PUTFIELD(jnt.scimark2.Random,seed)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_seed = c_CRandom.getField("seed",true);
         // *********[5] ALOAD(0)
         // *********[6] ICONST_4(Integer{4})
         // *********[7] PUTFIELD(jnt.scimark2.Random,i)
        c_i = c_CRandom.getField("i",true);
         // *********[8] ALOAD(0)
         // *********[9] BIPUSH(16)
         // *********[10] PUTFIELD(jnt.scimark2.Random,j)
        c_j = c_CRandom.getField("j",true);
         // *********[11] ALOAD(0)
         // *********[12] BIPUSH(32)
         // *********[13] PUTFIELD(jnt.scimark2.Random,mdig)
        c_mdig = c_CRandom.getField("mdig",true);
         // *********[14] ALOAD(0)
         // *********[15] ICONST_1(Integer{1})
         // *********[16] PUTFIELD(jnt.scimark2.Random,one)
        c_one = c_CRandom.getField("one",true);
         // *********[17] ALOAD(0)
         // *********[18] LDC(9->"2147483647")
         // *********[19] PUTFIELD(jnt.scimark2.Random,m1)
        c_m1 = c_CRandom.getField("m1",true);
         // *********[20] ALOAD(0)
         // *********[21] LDC(11->"65536")
         // *********[22] PUTFIELD(jnt.scimark2.Random,m2)
        c_m2 = c_CRandom.getField("m2",true);
         // *********[23] ALOAD(0)
         // *********[24] LDC(13->"4.656612875245797E-10")
         // *********[25] PUTFIELD(jnt.scimark2.Random,dm1)
        c_dm1 = c_CRandom.getField("dm1",true);
         // *********[26] ALOAD(0)
         // *********[27] ICONST_0(Integer{0})
         // *********[28] PUTFIELD(jnt.scimark2.Random,haveRange)
        c_haveRange = c_CRandom.getField("haveRange",true);
         // *********[29] ALOAD(0)
         // *********[30] DCONST_0(Double{0.0})
         // *********[31] PUTFIELD(jnt.scimark2.Random,left)
        c_left = c_CRandom.getField("left",true);
         // *********[32] ALOAD(0)
         // *********[33] DCONST_1(Double{1.0})
         // *********[34] PUTFIELD(jnt.scimark2.Random,right)
        c_right = c_CRandom.getField("right",true);
         // *********[35] ALOAD(0)
         // *********[36] DCONST_1(Double{1.0})
         // *********[37] PUTFIELD(jnt.scimark2.Random,width)
        c_width = c_CRandom.getField("width",true);
         // *********[38] ALOAD(0)
         // *********[39] ILOAD(1)
         // *********[40] INVOKESPECIAL(jnt.scimark2.Random,initialize(I)V)
        c_next = instructions[(index + 1)];
        m_mth = c_CRandom.getMethodBySignature("initialize(I)V");
        m_mth_ignorable = m_mth.isIgnorable();
      }
}
