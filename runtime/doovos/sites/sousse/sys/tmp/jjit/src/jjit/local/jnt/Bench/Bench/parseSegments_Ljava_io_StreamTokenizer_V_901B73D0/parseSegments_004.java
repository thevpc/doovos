package jjit.local.jnt.Bench.Bench.parseSegments_Ljava_io_StreamTokenizer_V_901B73D0;
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
 * parseSegments(Ljava/io/StreamTokenizer;)V
 * [count=5] [3] ASTORE(2) [4] ALOAD(0) [5] ALOAD(1) [6] BIPUSH(40) [7] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
 */
public final class parseSegments_004 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I40 = new KInteger(40);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_1 1 ; r=1/w=0 : NotCached
         // local_2 2 ; r=0/w=1 : NotCached
         // *********[3] ASTORE(2)
        frame.setLocal(2,frame.pop());
         // *********[4] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[5] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[6] BIPUSH(40)
         // **REMOVED Substitution** s2 = I40;
         // *********[7] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
        regs = new KRegister[3];
        regs[2] = I40;
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getPunct(Ljava/io/StreamTokenizer;C)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getPunct(Ljava/io/StreamTokenizer;C)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[3] ASTORE(2)
         // *********[4] ALOAD(0)
         // *********[5] ALOAD(1)
         // *********[6] BIPUSH(40)
         // *********[7] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
        c_memman = process.getMemoryManager();
      }
}
