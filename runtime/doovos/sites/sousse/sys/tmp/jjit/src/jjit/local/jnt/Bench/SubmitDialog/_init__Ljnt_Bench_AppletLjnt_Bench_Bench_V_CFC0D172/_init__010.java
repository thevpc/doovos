package jjit.local.jnt.Bench.SubmitDialog._init__Ljnt_Bench_AppletLjnt_Bench_Bench_V_CFC0D172;
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
 * <init>(Ljnt/Bench/Applet;Ljnt/Bench/Bench;)V
 * [count=9] [12] PUTFIELD(jnt.Bench.SubmitDialog,constraints) [13] ALOAD(0) [14] ALOAD(2) [15] PUTFIELD(jnt.Bench.SubmitDialog,bench) [16] ALOAD(0) [17] ALOAD(1) [18] PUTFIELD(jnt.Bench.SubmitDialog,applet) [19] ALOAD(0) [20] ALOAD(1)
 */
public final class _init__010 extends JJITAbstractInstruction implements Cloneable{
      private KField c_constraints = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private KField c_bench = null;
      private KField c_applet = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KReference s0_ref;
         // **REMOVED Unused Var** KReference ref;
        KRegister reg;
         // this_ref 0 ; r=3/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // local_1 1 ; r=2/w=0 : Cached
        KRegister local_1 = frame.getLocal(1);
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[12] PUTFIELD(jnt.Bench.SubmitDialog,constraints)
        reg = frame.pop();
         // **REMOVED Substitution** ref = frame.popRef();
        c_constraints.setInstanceValue(frame.popRef(),reg);
         // *********[13] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[14] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[15] PUTFIELD(jnt.Bench.SubmitDialog,bench)
         // **REMOVED Substitution** reg = frame.getLocal(2);
         // **REMOVED Substitution** ref = this_ref;
        c_bench.setInstanceValue(this_ref,frame.getLocal(2));
         // *********[16] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[17] ALOAD(1)
         // **REMOVED Substitution** s1 = local_1;
         // *********[18] PUTFIELD(jnt.Bench.SubmitDialog,applet)
         // **REMOVED Substitution** reg = local_1;
         // **REMOVED Substitution** ref = this_ref;
        c_applet.setInstanceValue(this_ref,local_1);
         // *********[19] ALOAD(0)
        frame.push(this_ref);
         // *********[20] ALOAD(1)
        frame.push(local_1);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[12] PUTFIELD(jnt.Bench.SubmitDialog,constraints)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_constraints = c_CSubmitDialog.getField("constraints",true);
         // *********[13] ALOAD(0)
         // *********[14] ALOAD(2)
         // *********[15] PUTFIELD(jnt.Bench.SubmitDialog,bench)
        c_bench = c_CSubmitDialog.getField("bench",true);
         // *********[16] ALOAD(0)
         // *********[17] ALOAD(1)
         // *********[18] PUTFIELD(jnt.Bench.SubmitDialog,applet)
        c_applet = c_CSubmitDialog.getField("applet",true);
         // *********[19] ALOAD(0)
         // *********[20] ALOAD(1)
        c_next = instructions[(index + 1)];
      }
}
