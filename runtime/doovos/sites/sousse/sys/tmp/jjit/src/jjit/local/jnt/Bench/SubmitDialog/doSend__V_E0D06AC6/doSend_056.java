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
 * [count=4] [73] ALOAD(3) [74] BIPUSH(47) [75] BIPUSH(7) [76] INVOKEVIRTUAL(java.lang.String,indexOf(II)I)
 */
public final class doSend_056 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I47 = new KInteger(47);
      private static final KInteger I7 = new KInteger(7);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_3 3 ; r=1/w=0 : NotCached
         // *********[73] ALOAD(3)
         // **REMOVED Substitution** s0 = frame.getLocal(3);
         // *********[74] BIPUSH(47)
         // **REMOVED Substitution** s1 = I47;
         // *********[75] BIPUSH(7)
         // **REMOVED Substitution** s2 = I7;
         // *********[76] INVOKEVIRTUAL(java.lang.String,indexOf(II)I)
        regs = new KRegister[3];
        regs[2] = I7;
        regs[1] = I47;
        ref = ((KReference)frame.getLocal(3));
        regs[0] = ref;
        frame.setProgramCounter(56);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("indexOf(II)I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("indexOf(II)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[73] ALOAD(3)
         // *********[74] BIPUSH(47)
         // *********[75] BIPUSH(7)
         // *********[76] INVOKEVIRTUAL(java.lang.String,indexOf(II)I)
        c_memman = process.getMemoryManager();
      }
}
