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
 * [count=2] [9] ALOAD(1) [10] INVOKEVIRTUAL(java.lang.String,trim()Ljava/lang/String;)
 */
public final class send_010 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // *********[9] ALOAD(1)
         // **REMOVED Substitution** s0 = frame.getLocal(1);
         // *********[10] INVOKEVIRTUAL(java.lang.String,trim()Ljava/lang/String;)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(1));
        regs[0] = ref;
        frame.setProgramCounter(10);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("trim()Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("trim()Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[9] ALOAD(1)
         // *********[10] INVOKEVIRTUAL(java.lang.String,trim()Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}