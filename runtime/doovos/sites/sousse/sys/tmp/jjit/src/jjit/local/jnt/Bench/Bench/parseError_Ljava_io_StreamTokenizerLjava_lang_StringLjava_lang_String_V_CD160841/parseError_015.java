package jjit.local.jnt.Bench.Bench.parseError_Ljava_io_StreamTokenizerLjava_lang_StringLjava_lang_String_V_CD160841;
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
 * parseError(Ljava/io/StreamTokenizer;Ljava/lang/String;Ljava/lang/String;)V
 * [count=2] [22] ALOAD(1) [23] INVOKEVIRTUAL(java.io.StreamTokenizer,toString()Ljava/lang/String;)
 */
public final class parseError_015 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[22] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[23] INVOKEVIRTUAL(java.io.StreamTokenizer,toString()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(15);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("toString()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("toString()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[22] ALOAD(1)
         // *********[23] INVOKEVIRTUAL(java.io.StreamTokenizer,toString()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
