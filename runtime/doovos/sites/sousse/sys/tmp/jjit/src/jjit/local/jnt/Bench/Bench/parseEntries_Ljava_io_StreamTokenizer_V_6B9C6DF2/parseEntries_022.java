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
 * [count=4] [74] ALOAD(0) [75] ALOAD(1) [76] BIPUSH(41) [77] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
 */
public final class parseEntries_022 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I41 = new KInteger(41);
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
         // *********[74] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[75] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[76] BIPUSH(41)
         // **REMOVED Substitution** s2 = I41;
         // *********[77] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
        regs = new KRegister[3];
        regs[2] = I41;
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(22);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getPunct(Ljava/io/StreamTokenizer;C)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("getPunct(Ljava/io/StreamTokenizer;C)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[74] ALOAD(0)
         // *********[75] ALOAD(1)
         // *********[76] BIPUSH(41)
         // *********[77] INVOKEVIRTUAL(jnt.Bench.Bench,getPunct(Ljava/io/StreamTokenizer;C)V)
        c_memman = process.getMemoryManager();
      }
}
