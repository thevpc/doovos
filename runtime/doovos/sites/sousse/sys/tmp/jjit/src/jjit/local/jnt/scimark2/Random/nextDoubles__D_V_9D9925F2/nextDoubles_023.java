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
 * [count=9] [135] ALOAD(1) [136] ILOAD(4) [137] ALOAD(0) [138] GETFIELD(jnt.scimark2.Random,dm1,D) [139] ILOAD(5) [140] I2D [141] DMUL [142] DASTORE [143] IINC(4,1)
 */
public final class nextDoubles_023 extends JJITAbstractInstruction implements Cloneable{
      private KField c_dm1 = null;
      private KClassRepository c_repo;
      private KClass c_CRandom = null;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** KRegister s3;
         // **REMOVED Unused Var** double m_d;
         // **REMOVED Unused Var** int index = 0;
         // **REMOVED Unused Var** double m_d2;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=2/w=1 : Cached
        int local_4 = frame.getLocal(4).intValue();
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[135] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[136] ILOAD(4)
         // **REMOVED Substitution** s1 = new KInteger(local_4);
         // *********[137] ALOAD(0)
         // **REMOVED Substitution** s2 = frame.getLocal(0);
         // *********[138] GETFIELD(jnt.scimark2.Random,dm1,D)
         // **REMOVED Substitution** s2 = new KDouble(c_dm1.getInstanceDouble(((KReference)frame.getLocal(0))));
         // *********[139] ILOAD(5)
         // **REMOVED Substitution** s3 = frame.getLocal(5);
         // *********[140] I2D
         // **REMOVED Substitution** s3 = new KDouble(frame.getLocal(5).intValue());
         // *********[141] DMUL
         // **REMOVED Substitution** m_d = frame.getLocal(5).doubleValue();
         // **REMOVED Substitution** s2 = new KDouble((c_dm1.getInstanceDouble(((KReference)frame.getLocal(0))) * frame.getLocal(5).doubleValue()));
         // *********[142] DASTORE
         // **REMOVED Substitution** m_d2 = (c_dm1.getInstanceDouble(((KReference)frame.getLocal(0))) * frame.getLocal(5).doubleValue());
         // **REMOVED Substitution** index = local_4;
        c_memman.setDoubleArray(((KReference)frame.getLocal(1)),local_4,(c_dm1.getInstanceDouble(((KReference)frame.getLocal(0))) * frame.getLocal(5).doubleValue()));
         // *********[143] IINC(4,1)
         // **REMOVED Substitution** local_4 = (local_4 + 1);
        frame.setLocal(4,new KInteger((local_4 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[135] ALOAD(1)
         // *********[136] ILOAD(4)
         // *********[137] ALOAD(0)
         // *********[138] GETFIELD(jnt.scimark2.Random,dm1,D)
        c_repo = process.getClassRepository();
        c_CRandom = c_repo.getClassByName("jnt.scimark2.Random");
        c_dm1 = c_CRandom.getField("dm1",true);
         // *********[139] ILOAD(5)
         // *********[140] I2D
         // *********[141] DMUL
         // *********[142] DASTORE
        c_memman = process.getMemoryManager();
         // *********[143] IINC(4,1)
        c_next = instructions[(index + 1)];
      }
}
