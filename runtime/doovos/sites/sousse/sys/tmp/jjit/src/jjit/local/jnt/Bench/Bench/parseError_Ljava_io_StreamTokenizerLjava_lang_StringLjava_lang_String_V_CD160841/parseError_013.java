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
 * [count=2] [18] LDC(63->")") [19] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
 */
public final class parseError_013 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R63 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[18] LDC(63->")")
         // **REMOVED Substitution** s0_ref = R63;
         // *********[19] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = R63;
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(13);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[18] LDC(63->")")
        R63 = ((KReference)constants[63]);
         // *********[19] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
