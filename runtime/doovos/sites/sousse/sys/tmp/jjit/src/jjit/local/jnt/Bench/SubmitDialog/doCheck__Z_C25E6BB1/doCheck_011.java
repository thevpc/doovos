package jjit.local.jnt.Bench.SubmitDialog.doCheck__Z_C25E6BB1;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.jvm.reflect.KClass;
import org.doovos.kernel.api.jvm.reflect.KClassRepository;
import org.doovos.kernel.api.jvm.reflect.KField;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * doCheck()Z
 * [count=4] [10] ALOAD(0) [11] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;) [12] LDC(114->"Your Email address is required") [13] INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
 */
public final class doCheck_011 extends JJITAbstractInstruction implements Cloneable{
      private KField c_status = null;
      private KClassRepository c_repo;
      private KClass c_CSubmitDialog = null;
      private static KReference R114 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[10] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[11] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;)
         // **REMOVED Substitution** s0_ref = c_status.getInstanceRef(((KReference)frame.getLocal(0)));
         // *********[12] LDC(114->"Your Email address is required")
         // **REMOVED Substitution** s1_ref = R114;
         // *********[13] INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R114;
        ref = c_status.getInstanceRef(((KReference)frame.getLocal(0)));
        regs[0] = ref;
        frame.setProgramCounter(11);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setText(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("setText(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[10] ALOAD(0)
         // *********[11] GETFIELD(jnt.Bench.SubmitDialog,status,Ljava/awt/Label;)
        c_repo = process.getClassRepository();
        c_CSubmitDialog = c_repo.getClassByName("jnt.Bench.SubmitDialog");
        c_status = c_CSubmitDialog.getField("status",true);
         // *********[12] LDC(114->"Your Email address is required")
        R114 = ((KReference)constants[114]);
         // *********[13] INVOKEVIRTUAL(java.awt.Label,setText(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
