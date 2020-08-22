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
 * [count=23] [200] ALOAD(1) [201] ILOAD(5) [202] ALOAD(0) [203] GETFIELD(jnt.scimark2.Random,dm1,D) [204] ILOAD(6) [205] I2D [206] DMUL [207] DASTORE [208] ALOAD(0) [209] GETFIELD(jnt.scimark2.Random,m,[I) [210] ALOAD(0) [211] GETFIELD(jnt.scimark2.Random,i,I) [212] IALOAD [213] ALOAD(0) [214] GETFIELD(jnt.scimark2.Random,m,[I) [215] ALOAD(0) [216] GETFIELD(jnt.scimark2.Random,j,I) [217] IALOAD [218] ISUB [219] ISTORE(6) [220] ALOAD(0) [221] GETFIELD(jnt.scimark2.Random,i,I) [222] IFNE(227)
 */
public final class nextDoubles_034 extends JJITAbstractInstruction implements Cloneable{
      private KField c_dm1 = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KMemoryManager c_memman;
      private KField c_m = null;
      private KField c_i = null;
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
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // this_ref 0 ; r=6/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // local_6 6 ; r=1/w=1 : Cached
        int local_6 = frame.getLocal(6).intValue();
         // *********[200] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[201] ILOAD(5)
         // **REMOVED Substitution** s1 = frame.getLocal(5);
         // *********[202] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[203] GETFIELD(jnt.scimark2.Random,dm1,D)
         // **REMOVED Substitution** s2 = new KDouble(c_dm1.getInstanceDouble(this_ref));
         // *********[204] ILOAD(6)
         // **REMOVED Substitution** s3 = new KInteger(local_6);
         // *********[205] I2D
         // **REMOVED Substitution** s3 = new KDouble(local_6);
         // *********[206] DMUL
         // **REMOVED Substitution** m_d = ((double)local_6);
         // **REMOVED Substitution** s2 = new KDouble((c_dm1.getInstanceDouble(this_ref) * ((double)local_6)));
         // *********[207] DASTORE
         // **REMOVED Substitution** m_d2 = (c_dm1.getInstanceDouble(this_ref) * ((double)local_6));
         // **REMOVED Substitution** index = frame.getLocal(5).intValue();
        c_memman.setDoubleArray(((KReference)frame.getLocal(1)),frame.getLocal(5).intValue(),(c_dm1.getInstanceDouble(this_ref) * ((double)local_6)));
         // *********[208] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[209] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s0_ref = c_m.getInstanceRef(this_ref);
         // *********[210] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[211] GETFIELD(jnt.scimark2.Random,i,I)
         // **REMOVED Substitution** s1 = new KInteger(c_i.getInstanceInt(this_ref));
         // *********[212] IALOAD
         // **REMOVED Substitution** index = c_i.getInstanceInt(this_ref);
         // **REMOVED Substitution** s0 = new KInteger(c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)));
         // *********[213] ALOAD(0)
         // **REMOVED Substitution** s1_ref = this_ref;
         // *********[214] GETFIELD(jnt.scimark2.Random,m,[I)
         // **REMOVED Substitution** s1_ref = c_m.getInstanceRef(this_ref);
         // *********[215] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[216] GETFIELD(jnt.scimark2.Random,j,I)
         // **REMOVED Substitution** s2 = new KInteger(c_j.getInstanceInt(this_ref));
         // *********[217] IALOAD
         // **REMOVED Substitution** index = c_j.getInstanceInt(this_ref);
         // **REMOVED Substitution** s1 = new KInteger(c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref)));
         // *********[218] ISUB
         // **REMOVED Substitution** index = c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref));
         // **REMOVED Substitution** s0 = new KInteger((c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)) - c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref))));
         // *********[219] ISTORE(6)
         // **REMOVED Substitution** local_6 = (c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)) - c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref)));
         // *********[220] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[221] GETFIELD(jnt.scimark2.Random,i,I)
         // **REMOVED Substitution** s0 = new KInteger(c_i.getInstanceInt(this_ref));
         // *********[222] IFNE(227)
         // **REMOVED Substitution** index = c_i.getInstanceInt(this_ref);
         // **REMOVED Substitution** jump = c_i.getInstanceInt(this_ref) != 0;
        frame.setLocal(6,new KInteger((c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_i.getInstanceInt(this_ref)) - c_memman.getIntArray(c_m.getInstanceRef(this_ref),c_j.getInstanceInt(this_ref)))));
        return ((c_i.getInstanceInt(this_ref) != 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[200] ALOAD(1)
         // *********[201] ILOAD(5)
         // *********[202] ALOAD(0)
         // *********[203] GETFIELD(jnt.scimark2.Random,dm1,D)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_dm1 = c_CRandom.getField("dm1",true);
         // *********[204] ILOAD(6)
         // *********[205] I2D
         // *********[206] DMUL
         // *********[207] DASTORE
        c_memman = process.getMemoryManager();
         // *********[208] ALOAD(0)
         // *********[209] GETFIELD(jnt.scimark2.Random,m,[I)
        c_m = c_CRandom.getField("m",true);
         // *********[210] ALOAD(0)
         // *********[211] GETFIELD(jnt.scimark2.Random,i,I)
        c_i = c_CRandom.getField("i",true);
         // *********[212] IALOAD
         // *********[213] ALOAD(0)
         // *********[214] GETFIELD(jnt.scimark2.Random,m,[I)
         // *********[215] ALOAD(0)
         // *********[216] GETFIELD(jnt.scimark2.Random,j,I)
        c_j = c_CRandom.getField("j",true);
         // *********[217] IALOAD
         // *********[218] ISUB
         // *********[219] ISTORE(6)
         // *********[220] ALOAD(0)
         // *********[221] GETFIELD(jnt.scimark2.Random,i,I)
         // *********[222] IFNE(227)
        c_next = instructions[(index + 1)];
        c_label = instructions[35];
      }
}
