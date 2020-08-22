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
 * [count=3] [57] ALOAD(4) [58] LDC(17->"
.
") [59] INVOKEVIRTUAL(java.lang.String,indexOf(Ljava/lang/String;)I)
 */
public final class send_039 extends JJITAbstractInstruction implements Cloneable{
      private static KReference R17 = null;
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KReference s1_ref;
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[57] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[58] LDC(17->"
         // .
         // ")
         // **REMOVED Substitution** s1_ref = R17;
         // *********[59] INVOKEVIRTUAL(java.lang.String,indexOf(Ljava/lang/String;)I)
        regs = new KRegister[2];
        regs[1] = R17;
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(39);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("indexOf(Ljava/lang/String;)I"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("indexOf(Ljava/lang/String;)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[57] ALOAD(4)
         // *********[58] LDC(17->"
         // .
         // ")
        R17 = ((KReference)constants[17]);
         // *********[59] INVOKEVIRTUAL(java.lang.String,indexOf(Ljava/lang/String;)I)
        c_memman = process.getMemoryManager();
      }
}
