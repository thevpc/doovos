package jjit.local.jnt.Bench.SubmitDialog.handleEvent_Ljava_awt_Event_Z_5C460024;
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
 * handleEvent(Ljava/awt/Event;)Z
 * [count=2] [13] ALOAD(0) [14] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,doCancel()V)
 */
public final class handleEvent_006 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // *********[13] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[14] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,doCancel()V)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("doCancel()V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("doCancel()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[13] ALOAD(0)
         // *********[14] INVOKEVIRTUAL(jnt.Bench.SubmitDialog,doCancel()V)
        c_memman = process.getMemoryManager();
      }
}
