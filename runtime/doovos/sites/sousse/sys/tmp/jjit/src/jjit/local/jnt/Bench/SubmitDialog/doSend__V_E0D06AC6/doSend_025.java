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
 * [count=4] [30] ALOAD(2) [31] ALOAD(2) [32] BIPUSH(64) [33] INVOKEVIRTUAL(java.lang.String,indexOf(I)I)
 */
public final class doSend_025 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I64 = new KInteger(64);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=2/w=0 : Cached
        KRegister local_2 = frame.getLocal(2);
         // *********[30] ALOAD(2)
        frame.push(local_2);
         // *********[31] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[32] BIPUSH(64)
         // **REMOVED Substitution** s1 = I64;
         // *********[33] INVOKEVIRTUAL(java.lang.String,indexOf(I)I)
        regs = new KRegister[2];
        regs[1] = I64;
         // **REMOVED Substitution** ref = ((KReference)local_2);
        regs[0] = ((KReference)local_2);
        frame.setProgramCounter(25);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_2)).getVirtualMethodBySignature("indexOf(I)I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_2)).getVirtualMethodBySignature("indexOf(I)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[30] ALOAD(2)
         // *********[31] ALOAD(2)
         // *********[32] BIPUSH(64)
         // *********[33] INVOKEVIRTUAL(java.lang.String,indexOf(I)I)
        c_memman = process.getMemoryManager();
      }
}
