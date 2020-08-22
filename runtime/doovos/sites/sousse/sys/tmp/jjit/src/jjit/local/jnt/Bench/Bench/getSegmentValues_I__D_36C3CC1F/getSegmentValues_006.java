package jjit.local.jnt.Bench.Bench.getSegmentValues_I__D_36C3CC1F;
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
 * jnt.Bench.Bench
 * getSegmentValues(I)[D
 * [count=6] [14] CHECKCAST [15] GETFIELD(jnt.Bench.Entry,values,[D) [16] ILOAD(1) [17] DALOAD [18] DASTORE [19] IINC(3,1)
 */
public final class getSegmentValues_006 extends JJITAbstractInstruction implements Cloneable{
      private KField c_values = null;
      private KClassRepository c_repo;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        int index = 0;
        double m_d;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_3 3 ; r=1/w=1 : Cached
        int local_3 = frame.getLocal(3).intValue();
         // *********[14] CHECKCAST
         // *********[15] GETFIELD(jnt.Bench.Entry,values,[D)
        if(c_values == null){
          c_values = c_repo.getClassByName("jnt.Bench.Entry").getField("values",true);
        }
         // **REMOVED Substitution** s0 = c_values.getInstanceValue(frame.popRef());
         // *********[16] ILOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[17] DALOAD
        index = frame.getLocal(1).intValue();
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)c_values.getInstanceValue(frame.popRef())),index));
         // *********[18] DASTORE
        m_d = c_memman.getDoubleArray(((KReference)c_values.getInstanceValue(frame.popRef())),index);
        index = frame.popInt();
        c_memman.setDoubleArray(frame.popRef(),index,m_d);
         // *********[19] IINC(3,1)
         // **REMOVED Substitution** local_3 = (local_3 + 1);
        frame.setLocal(3,new KInteger((local_3 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] CHECKCAST
         // *********[15] GETFIELD(jnt.Bench.Entry,values,[D)
        c_repo = process.getClassRepository();
         // *********[16] ILOAD(1)
         // *********[17] DALOAD
        c_memman = process.getMemoryManager();
         // *********[18] DASTORE
         // *********[19] IINC(3,1)
        c_next = instructions[(index + 1)];
      }
}
