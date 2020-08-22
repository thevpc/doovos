package jjit.local.jnt.Bench.SendMail.send_Ljava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_StringLjava_lang_String_V_56E49BAB;
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
 * jnt.Bench.SendMail
 * send(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
 * [count=2] [160] ALOAD(7) [161] INVOKEVIRTUAL(java.io.PrintStream,close()V)
 */
public final class send_084 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=0 : NotCached
         // *********[160] ALOAD(7)
         // **REMOVED Substitution** s0 = frame.getLocal(7);
         // *********[161] INVOKEVIRTUAL(java.io.PrintStream,close()V)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(7));
        regs[0] = ref;
        frame.setProgramCounter(84);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("close()V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("close()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[160] ALOAD(7)
         // *********[161] INVOKEVIRTUAL(java.io.PrintStream,close()V)
        c_memman = process.getMemoryManager();
      }
}
