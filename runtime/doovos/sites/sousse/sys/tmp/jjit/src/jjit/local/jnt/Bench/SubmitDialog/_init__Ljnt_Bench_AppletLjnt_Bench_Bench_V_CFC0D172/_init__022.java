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
 * [count=3] [39] ALOAD(0) [40] ALOAD(0) [41] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
 */
public final class _init__022 extends JJITAbstractInstruction implements Cloneable{
      private KField c_layout = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
         // this_ref 0 ; r=2/w=0 : Cached
        KReference this_ref = ((KReference)frame.getLocal(0));
         // *********[39] ALOAD(0)
        frame.push(this_ref);
         // *********[40] ALOAD(0)
         // **REMOVED Substitution** s0_ref = this_ref;
         // *********[41] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
        frame.push(c_layout.getInstanceRef(this_ref));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[39] ALOAD(0)
         // *********[40] ALOAD(0)
         // *********[41] GETFIELD(jnt.Bench.SubmitDialog,layout,Ljava/awt/GridBagLayout;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_layout = c_CSubmitDialog.getField("layout",true);
        c_next = instructions[(index + 1)];
      }
}
