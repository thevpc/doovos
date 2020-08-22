package jjit.local.jnt.Bench.SubmitDialog.doCheck__Z_C25E6BB1;
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
 * doCheck()Z
 * [count=3] [0] ALOAD(0) [1] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;) [2] LDC(111->"Checking")
 */
public final class doCheck_001 extends JJITAbstractInstruction implements Cloneable{
      private KField c_status = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static KReference R111 = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[0] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[1] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;)
        frame.push(c_status.getInstanceRef(((KReference)frame.getLocal(0))));
         // *********[2] LDC(111->"Checking")
        frame.push(R111);
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[0] ALOAD(0)
         // *********[1] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_status = c_CSubmitDialog.getField("status",true);
         // *********[2] LDC(111->"Checking")
        R111 = ((KReference)constants[111]);
        c_next = instructions[(index + 1)];
      }
}
