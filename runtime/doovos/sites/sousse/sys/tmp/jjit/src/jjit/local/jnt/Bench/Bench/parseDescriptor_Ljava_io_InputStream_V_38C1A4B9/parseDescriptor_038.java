package jjit.local.jnt.Bench.Bench.parseDescriptor_Ljava_io_InputStream_V_38C1A4B9;
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
 * parseDescriptor(Ljava/io/InputStream;)V
 * [count=3] [104] ALOAD(0) [105] ALOAD(2) [106] INVOKEVIRTUAL(jnt.Bench.Bench,parseSegments(Ljava/io/StreamTokenizer;)V)
 */
public final class parseDescriptor_038 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // this_ref 0 ; r=1/w=0 : NotCached
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[104] ALOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[105] ALOAD(2)
         // **REMOVED Substitution** s1 = frame.getLocal(2);
         // *********[106] INVOKEVIRTUAL(jnt.Bench.Bench,parseSegments(Ljava/io/StreamTokenizer;)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(2);
        ref = ((KReference)frame.getLocal(0));
        regs[0] = ref;
        frame.setProgramCounter(38);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseSegments(Ljava/io/StreamTokenizer;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("parseSegments(Ljava/io/StreamTokenizer;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[104] ALOAD(0)
         // *********[105] ALOAD(2)
         // *********[106] INVOKEVIRTUAL(jnt.Bench.Bench,parseSegments(Ljava/io/StreamTokenizer;)V)
        c_memman = process.getMemoryManager();
      }
}
