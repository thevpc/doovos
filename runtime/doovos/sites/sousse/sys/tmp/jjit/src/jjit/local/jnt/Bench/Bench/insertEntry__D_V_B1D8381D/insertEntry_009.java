package jjit.local.jnt.Bench.Bench.insertEntry__D_V_B1D8381D;
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
 * insertEntry([D)V
 * [count=6] [31] CHECKCAST [32] GETFIELD(jnt.Bench.Entry,values,[D) [33] ILOAD(2) [34] DALOAD [35] DCMPG [36] IFGE(38)
 */
public final class insertEntry_009 extends JJITAbstractInstruction implements Cloneable{
      private KField c_values = null;
      private KClassRepository c_repo;
      private KMemoryManager c_memman;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        int index = 0;
        double m_d;
        double m_d2;
         // **REMOVED Unused Var** boolean jump;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[31] CHECKCAST
         // *********[32] GETFIELD(jnt.Bench.Entry,values,[D)
        if(c_values == null){
          c_values = c_repo.getClassByName("jnt.Bench.Entry").getField("values",true);
        }
         // **REMOVED Substitution** s0 = c_values.getInstanceValue(frame.popRef());
         // *********[33] ILOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[34] DALOAD
        index = frame.getLocal(2).intValue();
         // **REMOVED Substitution** s0 = new KDouble(c_memman.getDoubleArray(((KReference)c_values.getInstanceValue(frame.popRef())),index));
         // *********[35] DCMPG
        m_d2 = c_memman.getDoubleArray(((KReference)c_values.getInstanceValue(frame.popRef())),index);
        m_d = frame.popDouble();
         // **REMOVED Substitution** s0 = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(KInteger.ONE):(((m_d == m_d2)?(KInteger.ZERO):(((m_d > m_d2)?(KInteger.ONE):(KInteger.M1))))));
         // *********[36] IFGE(38)
         // **REMOVED Substitution** index = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1))))));
         // **REMOVED Substitution** jump = ((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) >= 0;
        return ((((Double.isNaN(m_d) || Double.isNaN(m_d2))?(1):(((m_d == m_d2)?(0):(((m_d > m_d2)?(1):(-1)))))) >= 0)?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[31] CHECKCAST
         // *********[32] GETFIELD(jnt.Bench.Entry,values,[D)
        c_repo = process.getClassRepository();
         // *********[33] ILOAD(2)
         // *********[34] DALOAD
        c_memman = process.getMemoryManager();
         // *********[35] DCMPG
         // *********[36] IFGE(38)
        c_next = instructions[(index + 1)];
        c_label = instructions[10];
      }
}
