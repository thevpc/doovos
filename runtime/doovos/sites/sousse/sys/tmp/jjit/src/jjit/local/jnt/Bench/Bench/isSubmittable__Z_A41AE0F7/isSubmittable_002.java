package jjit.local.jnt.Bench.Bench.isSubmittable__Z_A41AE0F7;
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
 * isSubmittable()Z
 * [count=3] [3] ALOAD(0) [4] GETFIELD(jnt.Bench.Bench,suburl,Ljava/lang/String;) [5] IFNULL(8)
 */
public final class isSubmittable_002 extends JJITAbstractInstruction implements Cloneable{
      private KField c_suburl = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[3] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[4] GETFIELD(jnt.Bench.Bench,suburl,Ljava/lang/String;)
         // **REMOVED Substitution** s0_ref = c_suburl.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[5] IFNULL(8)
        return ((c_suburl.getInstanceRef(((KReference)frame.getLocal(0))).isNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ALOAD(0)
         // *********[4] GETFIELD(jnt.Bench.Bench,suburl,Ljava/lang/String;)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_suburl = c_CBench.getField("suburl",true);
         // *********[5] IFNULL(8)
        c_next = instructions[(index + 1)];
        c_label = instructions[3];
      }
}
