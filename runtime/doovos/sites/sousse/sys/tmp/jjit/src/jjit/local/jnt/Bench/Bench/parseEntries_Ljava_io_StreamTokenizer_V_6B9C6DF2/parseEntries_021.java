package jjit.local.jnt.Bench.Bench.parseEntries_Ljava_io_StreamTokenizer_V_6B9C6DF2;
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
 * parseEntries(Ljava/io/StreamTokenizer;)V
 * [count=2] [72] ALOAD(1) [73] INVOKEVIRTUAL(java.io.StreamTokenizer,pushBack()V)
 */
public final class parseEntries_021 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[72] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[73] INVOKEVIRTUAL(java.io.StreamTokenizer,pushBack()V)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(21);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("pushBack()V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("pushBack()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[72] ALOAD(1)
         // *********[73] INVOKEVIRTUAL(java.io.StreamTokenizer,pushBack()V)
        c_memman = process.getMemoryManager();
      }
}
