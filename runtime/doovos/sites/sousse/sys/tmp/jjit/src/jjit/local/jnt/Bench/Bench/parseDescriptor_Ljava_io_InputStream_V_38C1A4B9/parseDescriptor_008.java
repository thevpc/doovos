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
 * [count=4] [19] ALOAD(2) [20] BIPUSH(59) [21] BIPUSH(59) [22] INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
 */
public final class parseDescriptor_008 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I59 = new KInteger(59);
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
         // *********[19] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[20] BIPUSH(59)
         // **REMOVED Substitution** s1 = I59;
         // *********[21] BIPUSH(59)
         // **REMOVED Substitution** s2 = I59;
         // *********[22] INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
        regs = new KRegister[3];
        regs[2] = I59;
        regs[1] = I59;
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(8);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("whitespaceChars(II)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("whitespaceChars(II)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[19] ALOAD(2)
         // *********[20] BIPUSH(59)
         // *********[21] BIPUSH(59)
         // *********[22] INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
        c_memman = process.getMemoryManager();
      }
}
