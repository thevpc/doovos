package jjit.local.jnt.Bench.Bench.getEntries___Ljava_lang_String_D1553752;
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
 * getEntries()[Ljava/lang/String;
 * [count=4] [14] CHECKCAST [15] GETFIELD(jnt.Bench.Entry,platform,Ljava/lang/String;) [16] AASTORE [17] IINC(2,1)
 */
public final class getEntries_007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_platform = null;
      private KClassRepository c_repo;
      private KMemoryManager c_memman;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        int index = 0;
        KReference m_r;
         // local_2 2 ; r=1/w=1 : Cached
        int local_2 = frame.getLocal(2).intValue();
         // *********[14] CHECKCAST
         // *********[15] GETFIELD(jnt.Bench.Entry,platform,Ljava/lang/String;)
        if(c_platform == null){
          c_platform = c_repo.getClassByName("jnt.Bench.Entry").getField("platform",true);
        }
         // **REMOVED Substitution** s0 = c_platform.getInstanceValue(frame.popRef());
         // *********[16] AASTORE
        m_r = ((KReference)c_platform.getInstanceValue(frame.popRef()));
        index = frame.popInt();
        c_memman.setReferenceArray(frame.popRef(),index,m_r);
         // *********[17] IINC(2,1)
         // **REMOVED Substitution** local_2 = (local_2 + 1);
        frame.setLocal(2,new KInteger((local_2 + 1)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] CHECKCAST
         // *********[15] GETFIELD(jnt.Bench.Entry,platform,Ljava/lang/String;)
        c_repo = process.getClassRepository();
         // *********[16] AASTORE
        c_memman = process.getMemoryManager();
         // *********[17] IINC(2,1)
        c_next = instructions[(index + 1)];
      }
}
