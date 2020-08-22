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
 * [count=4] [63] ASTORE(7) [64] ALOAD(7) [65] BIPUSH(32) [66] INVOKEVIRTUAL(java.lang.String,indexOf(I)I)
 */
public final class post_037 extends JJITAbstractInstruction implements Cloneable{
      private static final KInteger I32 = new KInteger(32);
      private KMemoryManager c_memman;
      public JJITInstruction run(KFrame frame) throws Exception {
         // **REMOVED Unused Var** KRegister s0;
         // **REMOVED Unused Var** KRegister s1;
        KRegister[] regs = null;
        KLocalThread thread = frame.getThread();
         // **REMOVED Unused Var** KReference ref;
         // **REMOVED Unused Var** KFrame nextFrame = null;
         // local_7 7 ; r=1/w=1 : Cached
        KRegister local_7;
         // *********[63] ASTORE(7)
        local_7 = frame.pop();
         // *********[64] ALOAD(7)
         // **REMOVED Substitution** s0 = local_7;
         // *********[65] BIPUSH(32)
         // **REMOVED Substitution** s1 = I32;
         // *********[66] INVOKEVIRTUAL(java.lang.String,indexOf(I)I)
        regs = new KRegister[2];
        regs[1] = I32;
         // **REMOVED Substitution** ref = ((KReference)local_7);
        regs[0] = ((KReference)local_7);
        frame.setProgramCounter(37);
         // **REMOVED Substitution** nextFrame = thread.pushFrame(c_memman.getKClass(((KReference)local_7)).getVirtualMethodBySignature("indexOf(I)I"),regs);
        frame.setLocal(7,local_7);
        return ((JJITInstruction)thread.pushFrame(c_memman.getKClass(((KReference)local_7)).getVirtualMethodBySignature("indexOf(I)I"),regs).getCurrentInstruction());
      }
      public void init(int index,JJITInstruction[] instructions,KRegister[] constants,KProcess process) throws Exception {
         // *********[63] ASTORE(7)
         // *********[64] ALOAD(7)
         // *********[65] BIPUSH(32)
         // *********[66] INVOKEVIRTUAL(java.lang.String,indexOf(I)I)
        c_memman = process.getMemoryManager();
      }
}
