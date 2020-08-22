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
 * [count=3] [8] ALOAD(2) [9] BIPUSH(34) [10] INVOKEVIRTUAL(java.io.StreamTokenizer,quoteChar(I)V)
 */
public final class parseDescriptor_005 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I34 = new KInteger(34);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[8] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[9] BIPUSH(34)
         // **REMOVED Substitution** s1 = I34;
         // *********[10] INVOKEVIRTUAL(java.io.StreamTokenizer,quoteChar(I)V)
        regs = new KRegister[2];
        regs[1] = I34;
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(5);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("quoteChar(I)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("quoteChar(I)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[8] ALOAD(2)
         // *********[9] BIPUSH(34)
         // *********[10] INVOKEVIRTUAL(java.io.StreamTokenizer,quoteChar(I)V)
        c_memman = process.getMemoryManager();
      }
}
