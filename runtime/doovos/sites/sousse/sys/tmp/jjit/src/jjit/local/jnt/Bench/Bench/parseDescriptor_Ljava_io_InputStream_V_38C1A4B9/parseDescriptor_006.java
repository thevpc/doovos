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
 * [count=4] [11] ALOAD(2) [12] BIPUSH(95) [13] BIPUSH(95) [14] INVOKEVIRTUAL(java.io.StreamTokenizer,wordChars(II)V)
 */
public final class parseDescriptor_006 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I95 = new KInteger(95);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=0 : NotCached
         // *********[11] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[12] BIPUSH(95)
         // **REMOVED Substitution** s1 = I95;
         // *********[13] BIPUSH(95)
         // **REMOVED Substitution** s2 = I95;
         // *********[14] INVOKEVIRTUAL(java.io.StreamTokenizer,wordChars(II)V)
        regs = new KRegister[3];
        regs[2] = I95;
        regs[1] = I95;
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(6);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("wordChars(II)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("wordChars(II)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[11] ALOAD(2)
         // *********[12] BIPUSH(95)
         // *********[13] BIPUSH(95)
         // *********[14] INVOKEVIRTUAL(java.io.StreamTokenizer,wordChars(II)V)
        c_memman = process.getMemoryManager();
      }
}
