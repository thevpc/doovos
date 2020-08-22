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
 * [count=4] [50] ASTORE(4) [51] ALOAD(1) [52] ALOAD(0) [53] GETFIELD(jnt.Bench.SubmitDialog,from,Ljava/awt/TextComponent;)
 */
public final class doSend_036 extends JJITAbstractInstruction implements Cloneable{
      private KField c_from = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private JJITInstruction c_next;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_4 4 ; r=0/w=1 : NotCached
         // *********[50] ASTORE(4)
        frame.setLocal(4,frame.pop());
         // *********[51] ALOAD(1)
        frame.push(frame.getLocal(1));
         // *********[52] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[53] GETFIELD(jnt.Bench.SubmitDialog,from,Ljava/awt/TextComponent;)
        frame.push(c_from.getInstanceRef(((KReference)frame.getLocal(0))));
        return c_next;
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[50] ASTORE(4)
         // *********[51] ALOAD(1)
         // *********[52] ALOAD(0)
         // *********[53] GETFIELD(jnt.Bench.SubmitDialog,from,Ljava/awt/TextComponent;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_from = c_CSubmitDialog.getField("from",true);
        c_next = instructions[(index + 1)];
      }
}
