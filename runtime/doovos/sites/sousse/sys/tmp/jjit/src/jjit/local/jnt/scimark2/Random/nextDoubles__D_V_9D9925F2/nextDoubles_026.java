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
 * [count=15] [150] ALOAD(0) [151] GETFIELD(jnt.scimark2.Random,m,[I) [152] ALOAD(0) [153] GETFIELD(jnt.scimark2.Random,i,I) [154] IALOAD [155] ALOAD(0) [156] GETFIELD(jnt.scimark2.Random,m,[I) [157] ALOAD(0) [158] GETFIELD(jnt.scimark2.Random,j,I) [159] IALOAD [160] ISUB [161] ISTORE(6) [162] ALOAD(0) [163] GETFIELD(jnt.scimark2.Random,i,I) [164] IFNE(169)
 */
public final class nextDoubles_026 extends JJITAbstractInstruction implements Cloneable{
      private KField c_m = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_i = null;
      private KMemoryManager c_memman;
      private KField c_j = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=5/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_6 6 ; r=0/w=1 : NotCached
         // *********[150] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[151] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s0_ref = c_m.getInstanceRef(this_ref);
         // *********[152] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[153] GETFIELD(jnt.scimark2.Random,i,I)
         // **REMOVED Substitution** s1 = new KInteger(c_i.getInstanceInt(this_ref));
         // *********[154] IALOAD
         // **REMOVED Substitution** index = c_i.getInstanceInt(this_ref);
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)));
         // *********[155] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[156] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s1_ref = c_m.getInstanceRef(this_ref);
         // *********[157] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[158] GETFIELD(jnt.scimark2.Random,j,I)
         // **REMOVED Substitution** s2 = new KInteger(c_j.getInstanceInt(this_ref));
         // *********[159] IALOAD
         // **REMOVED Substitution** index = c_j.getInstanceInt(this_ref);
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref)));
         // *********[160] ISUB
         // **REMOVED Substitution** index = c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref));
         // **REMOVED Substitution** s0 = new KInteger((c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)) - c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref))));
         // *********[161] ISTORE(6)
        frame.setLocal(6,new KInteger((c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)) - c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref)))));
         // *********[162] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[163] GETFIELD(jnt.scimark2.Random,i,I)
         // **REMOVED Substitution** s0 = new KInteger(c_i.getInstanceInt(this_ref));
         // *********[164] IFNE(169)
         // **REMOVED Substitution** index = c_i.getInstanceInt(this_ref);
         // **REMOVED Substitution** jump = c_i.getInstanceInt(this_ref) != 0;
        return ((c_i.getInstanceInt(this_ref) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[150] ALOAD(0)
         // *********[151] GETFIELD(jnt.scimark2.Random,m,[I)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_m = c_CRandom.getField("m",true);
         // *********[152] ALOAD(0)
         // *********[153] GETFIELD(jnt.scimark2.Random,i,I)
        c_i = c_CRandom.getField("i",true);
         // *********[154] IALOAD
        c_memman = process.getMemoryManager();
         // *********[155] ALOAD(0)
         // *********[156] GETFIELD(jnt.scimark2.Random,m,[I)
         // *********[157] ALOAD(0)
         // *********[158] GETFIELD(jnt.scimark2.Random,j,I)
        c_j = c_CRandom.getField("j",true);
         // *********[159] IALOAD
         // *********[160] ISUB
         // *********[161] ISTORE(6)
         // *********[162] ALOAD(0)
         // *********[163] GETFIELD(jnt.scimark2.Random,i,I)
         // *********[164] IFNE(169)
        c_next = instructions[(index + 1)];
        c_label = instructions[27];
      }
}
