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
 * [count=4] [4] ASTORE(2) [5] ALOAD(2) [6] BIPUSH(35) [7] INVOKEVIRTUAL(java.io.StreamTokenizer,commentChar(I)V)
 */
public final class parseDescriptor_004 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I35 = new KInteger(35);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=1 : Cached
        KRegister local_2;
         // *********[4] ASTORE(2)
        local_2 = frame.pop();
         // *********[5] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[6] BIPUSH(35)
         // **REMOVED Substitution** s1 = I35;
         // *********[7] INVOKEVIRTUAL(java.io.StreamTokenizer,commentChar(I)V)
        regs = new KRegister[2];
        regs[1] = I35;
         // **REMOVED Substitution** ref = ((KReference)local_2);
        regs[0] = ((KReference)local_2);
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_2)).getVirtualMethodBySignature("commentChar(I)V"),regs);
        frame.setLocal(2,local_2);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_2)).getVirtualMethodBySignature("commentChar(I)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ASTORE(2)
         // *********[5] ALOAD(2)
         // *********[6] BIPUSH(35)
         // *********[7] INVOKEVIRTUAL(java.io.StreamTokenizer,commentChar(I)V)
        c_memman = process.getMemoryManager();
      }
}
