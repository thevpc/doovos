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
 * [count=2] [92] ALOAD(4) [93] INVOKEVIRTUAL(java.net.Socket,close()V)
 */
public final class post_049 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
        KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_4 4 ; r=1/w=0 : NotCached
         // *********[92] ALOAD(4)
         // **REMOVED Substitution** s0 = frame.getLocal(4);
         // *********[93] INVOKEVIRTUAL(java.net.Socket,close()V)
        regs = new KRegister[1];
        ref = ((KReference)frame.getLocal(4));
        regs[0] = ref;
        frame.setProgramCounter(49);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("close()V"),regs);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(ref).getVirtualMethodBySignature("close()V"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[92] ALOAD(4)
         // *********[93] INVOKEVIRTUAL(java.net.Socket,close()V)
        c_memman = process.getMemoryManager();
      }
}
