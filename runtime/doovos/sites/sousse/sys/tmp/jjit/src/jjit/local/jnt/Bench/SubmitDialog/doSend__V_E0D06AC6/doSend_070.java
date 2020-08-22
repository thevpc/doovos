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
 * [count=4] [97] ALOAD(0) [98] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;) [99] ICONST_1(Integer{1}) [100] LDC(135->"Submitted; Thank You!")
 */
public final class doSend_070 extends JJITAbstractInstruction implements Cloneable{
      private KField c_applet = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static final KInteger IONE = KInteger.ONE;
      private static KReference R135 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[97] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[98] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        frame.push(c_applet.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[99] ICONST_1(Integer{1})
        frame.push(IONE);
         // *********[100] LDC(135->"Submitted; Thank You!")
        frame.push(R135);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[97] ALOAD(0)
         // *********[98] GETFIELD(jnt.Bench.SubmitDialog,applet,Ljnt/Bench/Applet;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_applet = c_CSubmitDialog.getField("applet",true);
         // *********[99] ICONST_1(Integer{1})
         // *********[100] LDC(135->"Submitted; Thank You!")
        R135 = ((KReference)constants[135]);
        c_next = instructions[(index + 1)];
      }
}
