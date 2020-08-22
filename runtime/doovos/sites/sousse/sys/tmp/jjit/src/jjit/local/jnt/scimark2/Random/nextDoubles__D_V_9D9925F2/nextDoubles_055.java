package jjit.local.jnt.scimark2.Random.nextDoubles__D_V_9D9925F2;
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
 * nextDoubles([D)V
 * [count=9] [359] ALOAD(0) [360] GETFIELD(jnt.scimark2.Random,m,[I) [361] ALOAD(0) [362] GETFIELD(jnt.scimark2.Random,j,I) [363] ILOAD(6) [364] IASTORE [365] ALOAD(0) [366] GETFIELD(jnt.scimark2.Random,j,I) [367] IFNE(372)
 */
public final class nextDoubles_055 extends JJITAbstractInstruction implements Cloneable{
      private KField c_m = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_j = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** int m_i;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_6 6 ; r=1/w=0 : NotCached
         // *********[359] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[360] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s0_ref = c_m.getInstanceRef(this_ref);
         // *********[361] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[362] GETFIELD(jnt.scimark2.Random,j,I)
         // **REMOVED Substitution** s1 = new KInteger(c_j.getInstanceInt(this_ref));
         // *********[363] ILOAD(6)
         // **REMOVED Substitution** s2 = frame.getLocal(6);
         // *********[364] IASTORE
         // **REMOVED Substitution** m_i = frame.getLocal(6).intValue();
         // **REMOVED Substitution** index = c_j.getInstanceInt(this_ref);
        c_memman.setIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref),frame.getLocal(6).intValue());
         // *********[365] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[366] GETFIELD(jnt.scimark2.Random,j,I)
         // **REMOVED Substitution** s0 = new KInteger(c_j.getInstanceInt(this_ref));
         // *********[367] IFNE(372)
         // **REMOVED Substitution** index = c_j.getInstanceInt(this_ref);
         // **REMOVED Substitution** jump = c_j.getInstanceInt(this_ref) != 0;
        return ((c_j.getInstanceInt(this_ref) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[359] ALOAD(0)
         // *********[360] GETFIELD(jnt.scimark2.Random,m,[I)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_m = c_CRandom.getField("m",true);
         // *********[361] ALOAD(0)
         // *********[362] GETFIELD(jnt.scimark2.Random,j,I)
        c_j = c_CRandom.getField("j",true);
         // *********[363] ILOAD(6)
         // *********[364] IASTORE
        c_memman = process.getMemoryManager();
         // *********[365] ALOAD(0)
         // *********[366] GETFIELD(jnt.scimark2.Random,j,I)
         // *********[367] IFNE(372)
        c_next = instructions[(index + 1)];
        c_label = instructions[56];
      }
}
