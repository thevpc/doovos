package jjit.local.jnt.Bench.SubmitDialog.doSend__V_E0D06AC6;
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
 * doSend()V
 * [count=2] [20] ALOAD(0) [21] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
 */
public final class doSend_013 extends JJITAbstractInstruction implements Cloneable{
      private KField c_applet = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[20] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[21] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        frame.push(c_applet.getInstanceRef(((KReference)frame.getLocal(0))));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[20] ALOAD(0)
         // *********[21] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_applet = c_CSubmitDialog.getField("applet",true);
        c_next = instructions[(index + 1)];
      }
}
