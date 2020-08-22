package jjit.local.jnt.Bench.Bench.getEntries___Ljava_lang_String_D1553752;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.Bench
 * getEntries()[Ljava/lang/String;
 * [count=2] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
 */
public final class getEntries_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_entries = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        frame.push(c_entries.getInstanceRef(((KReference)frame.getLocal(0))));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_entries = c_CBench.getField("entries",true);
        c_next = instructions[(index + 1)];
      }
}
