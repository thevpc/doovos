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
 * [count=5] [49] ALOAD(4) [50] ILOAD(5) [51] ICONST_2(Integer{2}) [52] IADD [53] INVOKEVIRTUAL(java.lang.String,substring(I)Ljava/lang/String;)
 */
public final class send_035 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
         // **REMOVED Unused Var** KRegister s2;
         // **REMOVED Unused Var** int index = 0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[49] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[50] ILOAD(5)
         // **REMOVED Substitution** s1 = frame.getLocal(5);
         // *********[51] ICONST_2(Integer{2})
         // **REMOVED Substitution** s2 = ITWO;
         // *********[52] IADD
         // **REMOVED Substitution** index = 2;
         // **REMOVED Substitution** s1 = new KInteger((frame.getLocal(5).intValue() + 2));
         // *********[53] INVOKEVIRTUAL(java.lang.String,substring(I)Ljava/lang/String;)
        regs = new KRegister[2];
        regs[1] = new KInteger((frame.getLocal(5).intValue() + 2));
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(35);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("substring(I)Ljava/lang/String;"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("substring(I)Ljava/lang/String;"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[49] ALOAD(4)
         // *********[50] ILOAD(5)
         // *********[51] ICONST_2(Integer{2})
         // *********[52] IADD
         // *********[53] INVOKEVIRTUAL(java.lang.String,substring(I)Ljava/lang/String;)
        c_memman = process.getMemoryManager();
      }
}
