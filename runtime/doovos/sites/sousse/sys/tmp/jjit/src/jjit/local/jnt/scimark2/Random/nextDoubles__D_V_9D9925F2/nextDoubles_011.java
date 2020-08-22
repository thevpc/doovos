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
 * [count=15] [63] ALOAD(1) [64] ILOAD(4) [65] ALOAD(0) [66] GETFIELD(jnt.scimark2.Random,left,D) [67] ALOAD(0) [68] GETFIELD(jnt.scimark2.Random,dm1,D) [69] ILOAD(5) [70] I2D [71] DMUL [72] ALOAD(0) [73] GETFIELD(jnt.scimark2.Random,width,D) [74] DMUL [75] DADD [76] DASTORE [77] IINC(4,1)
 */
public final class nextDoubles_011 extends JJITAbstractInstruction implements Cloneable{
      private KField c_left = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KField c_dm1 = null;
      private KField c_width = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s4;
         // **REMOVED Unused Var** KReference s4_ref;
         // **REMOVED Unused Var** KReference s2_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s3_ref;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** double m_d2;
         // **REMOVED Unused Var** double m_d3;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d4;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=2/w=1 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[63] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[64] ILOAD(4)
         // **REMOVED Substitution** s1 = new KInteger(local_4);
         // *********[65] ALOAD(0)
         // **REMOVED Substitution** s2_ref = this_ref;
         // *********[66] GETFIELD(jnt.scimark2.Random,left,D)
         // **REMOVED Substitution** s2 = new KDouble(c_left.getInstanceDouble(this_ref));
         // *********[67] ALOAD(0)
         // **REMOVED Substitution** s3_ref = this_ref;
         // *********[68] GETFIELD(jnt.scimark2.Random,dm1,D)
         // **REMOVED Substitution** s3 = new KDouble(c_dm1.getInstanceDouble(this_ref));
         // *********[69] ILOAD(5)
         // **REMOVED Substitution** s4 = frame.getLocal(5);
         // *********[70] I2D
         // **REMOVED Substitution** s4 = new KDouble(frame.getLocal(5).intValue());
         // *********[71] DMUL
         // **REMOVED Substitution** m_d = frame.getLocal(5).doubleValue();
         // **REMOVED Substitution** s3 = new KDouble((c_dm1.getInstanceDouble(this_ref) * frame.getLocal(5).doubleValue()));
         // *********[72] ALOAD(0)
         // **REMOVED Substitution** s4_ref = this_ref;
         // *********[73] GETFIELD(jnt.scimark2.Random,width,D)
         // **REMOVED Substitution** s4 = new KDouble(c_width.getInstanceDouble(this_ref));
         // *********[74] DMUL
         // **REMOVED Substitution** m_d2 = c_width.getInstanceDouble(this_ref);
         // **REMOVED Substitution** s3 = new KDouble(((c_dm1.getInstanceDouble(this_ref) * frame.getLocal(5).doubleValue()) * c_width.getInstanceDouble(this_ref)));
         // *********[75] DADD
         // **REMOVED Substitution** m_d3 = ((c_dm1.getInstanceDouble(this_ref) * frame.getLocal(5).doubleValue()) * c_width.getInstanceDouble(this_ref));
         // **REMOVED Substitution** s2 = new KDouble((c_left.getInstanceDouble(this_ref) + ((c_dm1.getInstanceDouble(this_ref) * frame.getLocal(5).doubleValue()) * c_width.getInstanceDouble(this_ref))));
         // *********[76] DASTORE
         // **REMOVED Substitution** m_d4 = (c_left.getInstanceDouble(this_ref) + ((c_dm1.getInstanceDouble(this_ref) * frame.getLocal(5).doubleValue()) * c_width.getInstanceDouble(this_ref)));
         // **REMOVED Substitution** index = local_4;
        c_memman.setDoubleArray(((KReference)frame.getLocal(1)),local_4,(c_left.getInstanceDouble(this_ref) + ((c_dm1.getInstanceDouble(this_ref) * frame.getLocal(5).doubleValue()) * c_width.getInstanceDouble(this_ref))));
         // *********[77] IINC(4,1)
         // **REMOVED Substitution** local_4 = (local_4 + 1);
        frame.setLocal(4,new KInteger((local_4 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[63] ALOAD(1)
         // *********[64] ILOAD(4)
         // *********[65] ALOAD(0)
         // *********[66] GETFIELD(jnt.scimark2.Random,left,D)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_left = c_CRandom.getField("left",true);
         // *********[67] ALOAD(0)
         // *********[68] GETFIELD(jnt.scimark2.Random,dm1,D)
        c_dm1 = c_CRandom.getField("dm1",true);
         // *********[69] ILOAD(5)
         // *********[70] I2D
         // *********[71] DMUL
         // *********[72] ALOAD(0)
         // *********[73] GETFIELD(jnt.scimark2.Random,width,D)
        c_width = c_CRandom.getField("width",true);
         // *********[74] DMUL
         // *********[75] DADD
         // *********[76] DASTORE
        c_memman = process.getMemoryManager();
         // *********[77] IINC(4,1)
        c_next = instructions[(index + 1)];
      }
}
