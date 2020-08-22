package jjit.local.jnt.scimark2.Random.initialize_I_V_EB929367;
import java.lang.Math;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemorySegment;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.scimark2.Random
 * initialize(I)V
 * [count=16] [0] ALOAD(0) [1] ILOAD(1) [2] PUTFIELD(jnt.scimark2.Random,seed) [3] ALOAD(0) [4] BIPUSH(17) [5] NEWARRAY [6] PUTFIELD(jnt.scimark2.Random,m) [7] ILOAD(1) [8] INVOKE_HOST(java.lang.Math.abs(I)I) [9] LDC(9->"2147483647") [10] INVOKE_HOST(java.lang.Math.min(II)I) [11] ISTORE(2) [12] ILOAD(2) [13] ICONST_2(Integer{2}) [14] IREM [15] IFNE(17)
 */
public final class initialize_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_seed = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_m = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KRegister reg;
        KMemorySegment memseg = frame.getMemorySegment();
         // **REMOVED Unused Var** KRegister[] regs = null;
         // **REMOVED Unused Var** int m_v;
         // **REMOVED Unused Var** int m_v2;
         // **REMOVED Unused Var** int m_v3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=2/w=0 : Cached
        int local_1 = frame.getLocal(1).intValue();
         // local_2 2 ; r=1/w=1 : Cached
        int local_2;
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[1] ILOAD(1)
         // **REMOVED Substitution** s1 = new KInteger(local_1);
         // *********[2] PUTFIELD(jnt.scimark2.Random,seed)
         // **REMOVED Substitution** reg = new KInteger(local_1);
         // **REMOVED Substitution** ref = this_ref;
        c_seed.setInstanceInt(this_ref,local_1);
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] BIPUSH(17)
         // **REMOVED Substitution** s1 = I17;
         // *********[5] NEWARRAY
         // **REMOVED Substitution** s1_ref = memseg.allocIntArray(17);
         // *********[6] PUTFIELD(jnt.scimark2.Random,m)
         // **REMOVED Substitution** reg = memseg.allocIntArray(17);
         // **REMOVED Substitution** ref = this_ref;
        c_m.setInstanceValue(this_ref,memseg.allocIntArray(17));
         // *********[7] ILOAD(1)
         // **REMOVED Substitution** s0 = new KInteger(local_1);
         // *********[8] INVOKE_HOST(java.lang.Math.abs(I)I)
         // **REMOVED Substitution** m_v = local_1;
         // **REMOVED Substitution** s0 = new KInteger(Math.abs(local_1));
         // *********[9] LDC(9->"2147483647")
         // **REMOVED Substitution** s1 = I2147483647;
         // *********[10] INVOKE_HOST(java.lang.Math.min(II)I)
         // **REMOVED Substitution** m_v3 = 2147483647;
         // **REMOVED Substitution** m_v2 = Math.abs(local_1);
         // **REMOVED Substitution** s0 = new KInteger(Math.min(Math.abs(local_1),2147483647));
         // *********[11] ISTORE(2)
        local_2 = Math.min(Math.abs(local_1),2147483647);
         // *********[12] ILOAD(2)
         // **REMOVED Substitution** s0 = new KInteger(local_2);
         // *********[13] ICONST_2(Integer{2})
         // **REMOVED Substitution** s1 = ITWO;
         // *********[14] IREM
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s0 = new KInteger((local_2 % 2));
         // *********[15] IFNE(17)
         // **REMOVED Substitution** index = (local_2 % 2);
         // **REMOVED Substitution** jump = (local_2 % 2) != 0;
        frame.setLocal(2,new KInteger(local_2));
        return (((local_2 % 2) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] ILOAD(1)
         // *********[2] PUTFIELD(jnt.scimark2.Random,seed)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_seed = c_CRandom.getField("seed",true);
         // *********[3] ALOAD(0)
         // *********[4] BIPUSH(17)
         // *********[5] NEWARRAY
         // *********[6] PUTFIELD(jnt.scimark2.Random,m)
        c_m = c_CRandom.getField("m",true);
         // *********[7] ILOAD(1)
         // *********[8] INVOKE_HOST(java.lang.Math.abs(I)I)
         // *********[9] LDC(9->"2147483647")
         // *********[10] INVOKE_HOST(java.lang.Math.min(II)I)
         // *********[11] ISTORE(2)
         // *********[12] ILOAD(2)
         // *********[13] ICONST_2(Integer{2})
         // *********[14] IREM
         // *********[15] IFNE(17)
        c_next = instructions[(index + 1)];
        c_label = instructions[2];
      }
}
