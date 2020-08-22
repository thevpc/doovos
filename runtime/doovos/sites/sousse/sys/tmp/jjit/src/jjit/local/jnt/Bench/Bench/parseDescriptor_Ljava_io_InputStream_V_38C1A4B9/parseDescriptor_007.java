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
 * [count=4] [15] ALOAD(2) [16] BIPUSH(44) [17] BIPUSH(44) [18] INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
 */
public final class parseDescriptor_007 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I44 = new KInteger(44);
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
         // *********[15] ALOAD(2)
         // **REMOVED Substitution** s0 = frame.getLocal(2);
         // *********[16] BIPUSH(44)
         // **REMOVED Substitution** s1 = I44;
         // *********[17] BIPUSH(44)
         // **REMOVED Substitution** s2 = I44;
         // *********[18] INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
        regs = new KRegister[3];
        regs[2] = I44;
        regs[1] = I44;
        ref = ((KReference)frame.getLocal(2));
        regs[0] = ref;
        frame.setProgramCounter(7);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("whitespaceChars(II)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("whitespaceChars(II)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[15] ALOAD(2)
         // *********[16] BIPUSH(44)
         // *********[17] BIPUSH(44)
         // *********[18] INVOKEVIRTUAL(java.io.StreamTokenizer,whitespaceChars(II)V)
        c_memman = process.getMemoryManager();
      }
}
