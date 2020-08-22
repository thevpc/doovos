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
 * [count=3] [4] ASTORE(2) [5] ALOAD(2) [6] INVOKEVIRTUAL(java.net.URL,getPort()I)
 */
public final class post_004 extends JJITAbstractInstruction implements Cloneable{
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_2 2 ; r=1/w=1 : Cached
        KRegister local_2;
         // *********[4] ASTORE(2)
        local_2 = frame.pop();
         // *********[5] ALOAD(2)
         // **REMOVED Substitution** s0 = local_2;
         // *********[6] INVOKEVIRTUAL(java.net.URL,getPort()I)
        regs = new KRegister[1];
         // **REMOVED Substitution** ref = ((KReference)local_2);
        regs[0] = ((KReference)local_2);
        frame.setProgramCounter(4);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_2)).getVirtualMethodBySignature("getPort()I"),regs);
        frame.setLocal(2,local_2);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_2)).getVirtualMethodBySignature("getPort()I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[4] ASTORE(2)
         // *********[5] ALOAD(2)
         // *********[6] INVOKEVIRTUAL(java.net.URL,getPort()I)
        c_memman = process.getMemoryManager();
      }
}
