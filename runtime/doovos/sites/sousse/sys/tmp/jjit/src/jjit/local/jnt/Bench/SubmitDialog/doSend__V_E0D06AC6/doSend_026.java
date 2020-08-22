package jjit.local.jnt.Bench.SubmitDialog.doSend__V_E0D06AC6;
import org.doovos.kernel.api.jvm.interpreter.*;
import org.doovos.kernel.api.jvm.interpreter.KFrame;
import org.doovos.kernel.api.memory.*;
import org.doovos.kernel.api.memory.KMemoryManager;
import org.doovos.kernel.api.memory.KRegister;
import org.doovos.kernel.api.process.KLocalThread;
import org.doovos.kernel.api.process.KProcess;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.*;
import org.doovos.kernel.vanilla.jvm.interpreter.jjit.instr.JJITInstruction;
/**
 * jnt.Bench.SubmitDialog
 * doSend()V
 * [count=3] [34] ICONST_1(Integer{1}) [35] IADD [36] INVOKEVIRTUAL(java.lang.String,substring(I)Ljava/lang/String;)
 */
public final class doSend_026 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[34] ICONST_1(Integer{1})
         // **REMOVED Substitution** s0 = IONE;
         // *********[35] IADD
         // **REMOVED Substitution** index = 1;
         // **REMOVED Substitution** s0 = new KInteger((frame.popInt() + 1));
         // *********[36] INVOKEVIRTUAL(java.lang.String,substring(I)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = new KInteger((frame.popInt() + 1));
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(26);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("substring(I)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("substring(I)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[34] ICONST_1(Integer{1})
         // *********[35] IADD
         // *********[36] INVOKEVIRTUAL(java.lang.String,substring(I)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
