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
 * [count=4] [55] ALOAD(2) [56] ALOAD(4) [57] ALOAD(0) [58] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,constructBody()Ljava/lang/String;)
 */
public final class doSend_039 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[55] ALOAD(2)
        frame.push(frame.getLocal(2));
         // *********[56] ALOAD(4)
        frame.push(frame.getLocal(4));
         // *********[57] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[58] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,constructBody()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(39);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("constructBody()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("constructBody()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[55] ALOAD(2)
         // *********[56] ALOAD(4)
         // *********[57] ALOAD(0)
         // *********[58] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,constructBody()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
