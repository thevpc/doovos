package jjit.local.jnt.Bench.HTTPPost.post_Ljava_lang_StringLjava_lang_String_V_FD00FDAB;
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
 * jnt.Bench.HTTPPost
 * post(Ljava/lang/String;Ljava/lang/String;)V
 * [count=2] [36] LDC(15->"POST ") [37] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
 */
public final class post_020 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R15 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s0_ref;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // *********[36] LDC(15->"POST ")
         // **REMOVED Substitution** s0_ref = R15;
         // *********[37] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        regs = new KRegister[2];
        regs[1] = R15;
        ref = frame.popRef();
        regs[0] = ref;
        frame.setProgramCounter(20);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("append(Ljava/lang/String;)Ljava/lang/StringBuffer;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[36] LDC(15->"POST ")
        R15 = ((KReference)constants[15]);
         // *********[37] INVOKEVIRTUAL(java.lang.StringBuffer,append(Ljava/lang/String;)Ljava/lang/StringBuffer;)
        c_memman = process.getMemoryManager();
      }
}
