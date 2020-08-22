package jjit.local.jnt.scimark2.FFT.log2_I_I_F037A9BF;
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
 * jnt.scimark2.FFT
 * log2(I)I
 * [count=2] [25] ILOAD(0) [26] INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
 */
public final class log2_009 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_0 0 ; r=1/w=0 : NotCached
         // *********[25] ILOAD(0)
         // **REMOVED Substitution** s0 = frame.getLocal(0);
         // *********[26] INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(0);
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(9);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(I)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(I)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[25] ILOAD(0)
         // *********[26] INVOKEVIRTUAL(java.lang.StringBuffer,append(I)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
