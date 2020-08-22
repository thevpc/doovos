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
 * [count=3] [58] ALOAD(5) [59] ALOAD(1) [60] INVOKEVIRTUAL(java.io.PrintStream,print(Ljava/lang/String;)V)
 */
public final class post_035 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_1 1 ; r=1/w=0 : NotCached
         // local_5 5 ; r=1/w=0 : NotCached
         // *********[58] ALOAD(5)
         // **REMOVED Substitution** s0 = frame.getLocal(5);
         // *********[59] ALOAD(1)
         // **REMOVED Substitution** s1 = frame.getLocal(1);
         // *********[60] INVOKEVIRTUAL(java.io.PrintStream,print(Ljava/lang/String;)V)
        regs = new KRegister[2];
        regs[1] = frame.getLocal(1);
        ref = ((KReference)frame.getLocal(5));
        regs[0] = ref;
        frame.setProgramCounter(35);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("print(Ljava/lang/String;)V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("print(Ljava/lang/String;)V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[58] ALOAD(5)
         // *********[59] ALOAD(1)
         // *********[60] INVOKEVIRTUAL(java.io.PrintStream,print(Ljava/lang/String;)V)
        c_memman = process.getMemoryManager();
      }
}
