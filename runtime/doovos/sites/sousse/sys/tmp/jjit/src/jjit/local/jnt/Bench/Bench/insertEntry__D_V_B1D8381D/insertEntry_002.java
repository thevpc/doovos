package jjit.local.jnt.Bench.Bench.insertEntry__D_V_B1D8381D;
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
 * insertEntry([D)V
 * [count=4] [3] ALOAD(0) [4] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;) [5] ALOAD(0) [6] GETFIELD(jnt.Bench.Bench,specpos,I)
 */
public final class insertEntry_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_entries = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private KField c_specpos = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[4] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        frame.push(c_entries.getInstanceRef(this_ref));
         // *********[5] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[6] GETFIELD(jnt.Bench.Bench,specpos,I)
        frame.push(new KInteger(c_specpos.getInstanceInt(this_ref)));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] GETFIELD(jnt.Bench.Bench,entries,Ljava/util/Vector;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_entries = c_CBench.getField("entries",true);
         // *********[5] ALOAD(0)
         // *********[6] GETFIELD(jnt.Bench.Bench,specpos,I)
        c_specpos = c_CBench.getField("specpos",true);
        c_next = instructions[(index + 1)];
      }
}
