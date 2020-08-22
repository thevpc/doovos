package jjit.local.jnt.Bench.SubmitDialog.doCancel__V_AB263DC3;
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
 * doCancel()V
 * [count=4] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;) [2] ICONST_0(Integer{0}) [3] LDC(143->"Submission Cancelled")
 */
public final class doCancel_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_applet = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static final KInteger IZERO = KInteger.ZERO;
      private static KReference R143 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        frame.push(c_applet.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[2] ICONST_0(Integer{0})
        frame.push(IZERO);
         // *********[3] LDC(143->"Submission Cancelled")
        frame.push(R143);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_applet = c_CSubmitDialog.getField("applet",true);
         // *********[2] ICONST_0(Integer{0})
         // *********[3] LDC(143->"Submission Cancelled")
        R143 = ((KReference)constants[143]);
        c_next = instructions[(index + 1)];
      }
}
