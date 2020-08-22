package jjit.local.jnt.Bench.Bench.doExecution__V_C25B2F44;
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
 * doExecution()V
 * [count=4] [42] POP2Type2 [43] ALOAD(0) [44] GETFIELD(jnt.Bench.Bench,current,[D) [45] IFNONNULL(80)
 */
public final class doExecution_019 extends JJITAbstractInstruction implements Cloneable{
      private KField c_current = null;
      private KClassRepository c_repo;
      private KClass c_CBench = null;
      private JJITInstruction c_label;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[42] POP2Type2
        frame.pop();
         // *********[43] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[44] GETFIELD(jnt.Bench.Bench,current,[D)
         // **REMOVED Substitution** s0_ref = c_current.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[45] IFNONNULL(80)
        return ((c_current.getInstanceRef(((KReference)frame.getLocal(0))).isNotNull())?(c_label):(c_next));
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[42] POP2Type2
         // *********[43] ALOAD(0)
         // *********[44] GETFIELD(jnt.Bench.Bench,current,[D)
        c_repo = process.getClassRepository();
        c_CBench = c_repo.getClassByName("jnt.Bench.Bench");
        c_current = c_CBench.getField("current",true);
         // *********[45] IFNONNULL(80)
        c_next = instructions[(index + 1)];
        c_label = instructions[27];
      }
}
