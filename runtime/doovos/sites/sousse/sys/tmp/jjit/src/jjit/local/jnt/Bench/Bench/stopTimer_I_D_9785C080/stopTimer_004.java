package jjit.local.jnt.Bench.Bench.stopTimer_I_D_9785C080;
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
 * jnt.Bench.Bench
 * stopTimer(I)D
 * [count=4] [5] DSTORE(2) [6] ALOAD(0) [7] LDC(110->"done") [8] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
 */
public final class stopTimer_004 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R110 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[5] DSTORE(2)
        frame.setLocal(2,frame.pop());
         // *********[6] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[7] LDC(110->"done")
         // **REMOVED Substitution** s1_ref = R110;
         // *********[8] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = R110;
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("noteStatus(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[5] DSTORE(2)
         // *********[6] ALOAD(0)
         // *********[7] LDC(110->"done")
        R110 = ((KReference)constants[110]);
         // *********[8] INVOKEVIRTUAL(jnt.Bench.Bench,noteStatus(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
