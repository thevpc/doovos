package jjit.local.jnt.Bench.SubmitDialog.constructBody__Ljava_lang_String_51E1A505;
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
 * jnt.Bench.SubmitDialog
 * constructBody()Ljava/lang/String;
 * [count=3] [14] ALOAD(0) [15] ALOAD(0) [16] GETFIELD(jnt.Bench.SubmitDialog,bench,Ljnt/Bench/Bench;)
 */
public final class constructBody_007 extends JJITAbstractInstruction implements Cloneable{
      private KField c_bench = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[14] ALOAD(0)
        frame.push(this_ref);
         // *********[15] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[16] GETFIELD(jnt.Bench.SubmitDialog,bench,Ljnt/Bench/Bench;)
        frame.push(c_bench.getInstanceRef(this_ref));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[14] ALOAD(0)
         // *********[15] ALOAD(0)
         // *********[16] GETFIELD(jnt.Bench.SubmitDialog,bench,Ljnt/Bench/Bench;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_bench = c_CSubmitDialog.getField("bench",true);
        c_next = instructions[(index + 1)];
      }
}
